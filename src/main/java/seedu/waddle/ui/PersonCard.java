package seedu.waddle.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.waddle.model.itinerary.Itinerary;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Itinerary itinerary;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label country;
    @FXML
    private Label startDate;
    @FXML
    private Label endDate;
    @FXML
    private Label people;


    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Itinerary itinerary, int displayedIndex) {
        super(FXML);
        this.itinerary = itinerary;
        id.setText(displayedIndex + ". ");
        name.setText(itinerary.getName().fullName);
        country.setText(itinerary.getCountry().country);
        startDate.setText(itinerary.getStartDate().date);
        endDate.setText(itinerary.getEndDate().date);
        people.setText(itinerary.getPeople().numOfPeople);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }

        // state check
        PersonCard card = (PersonCard) other;
        return id.getText().equals(card.id.getText())
                && itinerary.equals(card.itinerary);
    }
}
