package de.htwsaar.prog3.carrental.view;

import de.htwsaar.prog3.carrental.model.Car;
import de.htwsaar.prog3.carrental.util.i18n.I18nComponentsUtil;
import de.htwsaar.prog3.carrental.util.i18n.I18nStringsUtil;
import de.htwsaar.prog3.carrental.util.i18n.I18nUtil;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Entry Point of the "Edit Car" Dialog.
 *
 * @author Jens Thewes
 */
public class EditCarView {
    private static final Logger logger = LoggerFactory.getLogger(EditCarView.class);

    private static Stage modalWindow;

    @Getter
    private static Car car;

    /**
     * Start the Car Configuration View Dialog in a modal Window in order to edit a existing car.
     *
     * @param parentStage
     */
    public void start(Stage parentStage, Car car) {
        modalWindow  = new Stage();
        EditCarView.car = car;

        // Load FXML document for the car configuration view wit the needed resource bundle
        Parent scene = null;
        try {
            scene = FXMLLoader.load(getClass().getResource(I18nStringsUtil.getEditCarViewFxml()),
                    I18nUtil.getResourceBundleComponents());
        } catch (IOException e) {
            logger.error("Failed loading FXML!", e);
        }

        modalWindow.setTitle(I18nComponentsUtil.getStageTitle());
        // Apply styling described in the FXML document
        modalWindow.setScene(new Scene(scene));
        modalWindow.setMaxHeight(600);
        modalWindow.setMaxWidth(900);
        // set the Owner of the modal window and the Modality of the new Stage (Modal Window)
        modalWindow.initOwner(parentStage);
        modalWindow.initModality(Modality.WINDOW_MODAL);
        modalWindow.show();
    }

    /**
     * Closes the modal window.
     */
    public static void closeModalWindow() {
        modalWindow.close();
    }
}
