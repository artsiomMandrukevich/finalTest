package Helpers;

import java.io.InputStream;
import java.util.Properties;


/**
 * Created by student on 4/28/2016.
 */
public class Locator {
    private static final Properties locators;

    private enum LocatorType {
        id, name, css, tag, text, xpath, partText
    }

    static {
        locators = new Properties();
        InputStream stream = Locator.class.getResourceAsStream("/locators");
        try{
            locators.load(stream);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String title(String pageName){return locators.getProperty(pageName);}

    public static String get(String locatorName){
        String propertyValue = locators.getProperty(locatorName);
        return getLocator(propertyValue);
    }

    public static String getLocator(String locator){
        String[] locatorItems = locator.split("=", 2);
        LocatorType locatorType = LocatorType.valueOf(locatorItems[0]);

        switch (locatorType){
            case id:
                return locatorItems[1];

            case name:
                return locatorItems[1];

            case css:
                return locatorItems[1];

            case tag:
                return locatorItems[1];

            case xpath:
                return locatorItems[1];

            case text:
                return locatorItems[1];

            case partText:
                return locatorItems[1];

            default:
                throw new IllegalArgumentException("No such locator type: " + locatorItems[0]);
        }
    }
}
