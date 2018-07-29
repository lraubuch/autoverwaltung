package de.htwsaar.prog3.carrental.i18n;

import java.util.ResourceBundle;

/**
 * Internationalization utility class for components file.
 *
 * @author Lukas Raubuch
 */
public class I18nComponentsUtil {
    /**
     * Definition of all available Strings in components_*.properties.
     */
    private static final String STAGE_TITLE = "stage-title";

    private static ResourceBundle resourceBundle;

    /**
     * Initialization of the ResourceBundle.
     */
    static {
        resourceBundle = I18Util.getResourceBundleComponents();
    }

    /**
     * Access methods to get a internationalized String for the needed value.
     */
    public static String getStageTitleString() {
        return resourceBundle.getString(STAGE_TITLE);
    }
}
