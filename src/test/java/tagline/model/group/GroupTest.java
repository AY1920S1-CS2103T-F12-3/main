package tagline.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tagline.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static tagline.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static tagline.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static tagline.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static tagline.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static tagline.testutil.Assert.assertThrows;
import static tagline.testutil.TypicalPersons.ALICE;
import static tagline.testutil.TypicalGroups.BOB;

import org.junit.jupiter.api.Test;

import tagline.testutil.GroupBuilder;

public class GroupTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Group person = new GroupBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> person.getTags().remove(0));
    }

    @Test
    public void isSameGroup() {
        // same object -> returns true
        assertTrue(ALICE.isSameGroup(ALICE));

        // null -> returns false
        assertFalse(ALICE.isSameGroup(null));

        // different phone and email -> returns false
        Group editedAlice = new GroupBuilder(ALICE).withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(ALICE.isSameGroup(editedAlice));

        // different name -> returns false
        editedAlice = new GroupBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.isSameGroup(editedAlice));

        // same name, same phone, different attributes -> returns true
        editedAlice = new GroupBuilder(ALICE).withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameGroup(editedAlice));

        // same name, same email, different attributes -> returns true
        editedAlice = new GroupBuilder(ALICE).withPhone(VALID_PHONE_BOB).withAddress(VALID_ADDRESS_BOB)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameGroup(editedAlice));

        // same name, same phone, same email, different attributes -> returns true
        editedAlice = new GroupBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameGroup(editedAlice));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Group aliceCopy = new GroupBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different person -> returns false
        assertFalse(ALICE.equals(BOB));

        // different name -> returns false
        Group editedAlice = new GroupBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different phone -> returns false
        editedAlice = new GroupBuilder(ALICE).withPhone(VALID_PHONE_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different email -> returns false
        editedAlice = new GroupBuilder(ALICE).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different address -> returns false
        editedAlice = new GroupBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different tags -> returns false
        editedAlice = new GroupBuilder(ALICE).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(ALICE.equals(editedAlice));
    }
}
