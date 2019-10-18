package tagline.model.group;

import tagline.model.contact.ContactId;

import static tagline.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * Represents a Group in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Group {

    // Identity fields
    private final GroupName groupName;

    // Data fields
    private final GroupDescription description;
    private final Set<ContactId> memberIds = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Group(GroupName groupName, GroupDescription description , Set<ContactId> memberIds) {
        requireAllNonNull(groupName, description, memberIds);
        //private final MemberModel members;
        this.groupName = groupName;
        this.description = description;
        this.memberIds.addAll(memberIds);
        //this.tags.addAll(tags);
    }

    public GroupName getGroupName() {
        return groupName;
    }

    public GroupDescription getGroupDescription() {
        return description;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<ContactId> getMemberIds() {
        return Collections.unmodifiableSet(memberIds);
    }

    /**
     * Returns true if both persons of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSameGroup(Group otherGroup) {
        if (otherGroup == this) {
            return true;
        }

        return otherGroup != null
                && otherGroup.getGroupName().equals(getGroupName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Group)) {
            return false;
        }

        Group otherGroup = (Group) other;
        return otherGroup.getGroupName().equals(getGroupName())
                && otherGroup.getMemberIds().equals(getMemberIds())
                && otherGroup.getGroupDescription().equals(getGroupDescription());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(groupName, memberIds, description);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getGroupName())
                .append(" Description: ")
                .append(getGroupDescription())
                .append(" Members: ");
                //.append(getMembers());
        getMemberIds().forEach(builder::append);
        //getMemberIds().forEach(builder::append);
        //builder.append(getName())
        //        .append(" Phone: ")
        //        .append(getPhone())
        //        .append(" Email: ")
        //        .append(getEmail())
        //        .append(" Address: ")
        //        .append(getAddress())
        //        .append(" Tags: ");
        //getTags().forEach(builder::append);
        return builder.toString();
    }
}
