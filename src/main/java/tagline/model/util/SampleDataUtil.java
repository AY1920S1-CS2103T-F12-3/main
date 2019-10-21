package tagline.model.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import tagline.model.contact.Address;
import tagline.model.contact.AddressBook;
import tagline.model.contact.Contact;
import tagline.model.contact.ContactId;
import tagline.model.contact.Description;
import tagline.model.contact.Email;
import tagline.model.contact.Name;
import tagline.model.contact.Phone;
import tagline.model.contact.ReadOnlyAddressBook;
import tagline.model.group.Group;
import tagline.model.group.GroupBook;
import tagline.model.group.GroupDescription;
import tagline.model.group.MemberId;
import tagline.model.group.GroupName;
import tagline.model.group.ReadOnlyGroupBook;
import tagline.model.note.Content;
import tagline.model.note.Note;
import tagline.model.note.NoteBook;
import tagline.model.note.NoteId;
import tagline.model.note.ReadOnlyNoteBook;
import tagline.model.note.TimeCreated;
import tagline.model.note.TimeLastEdited;
import tagline.model.note.Title;
import tagline.model.tag.ContactTag;
import tagline.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Contact[] getSampleContacts() {
        // @formatter:off
        return new Contact[]{
            new Contact(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"), new Description("friend"), new ContactId(1)),
            new Contact(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), new Description("friend"),
                new ContactId(2)),
            new Contact(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), new Description("friend"),
                new ContactId(3)),
            new Contact(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), new Description("friend"),
                new ContactId(4)),
            new Contact(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"), new Description("friend"), new ContactId(5)),
            new Contact(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"), new Description("friend"), new ContactId(6))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Contact sampleContact : getSampleContacts()) {
            sampleAb.addContact(sampleContact);
        }
        return sampleAb;
    }

    public static Note[] getSampleNotes() {
        return new Note[]{
            new Note(new NoteId(), new Title(""), new Content("Hello from TagLine!"),
                new TimeCreated(), new TimeLastEdited(), new HashSet<>()),
            new Note(new NoteId(), new Title("Lorem Ipsum"), new Content("Lorem ipsum dolor sit amet, "
                + "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna "
                + "aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip"
                + "ex ea commodo consequat."), new TimeCreated(), new TimeLastEdited(), new HashSet<>()),
            new Note(new NoteId(), new Title("Lorem Ipsum Dolor Sit"), new Content("Lorem ipsum dolor sit amet, "
                + "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna "
                + "aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip"
                + "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse "
                + "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, "
                + "sunt in culpa qui officia deserunt mollit anim id est laborum."), new TimeCreated(),
                new TimeLastEdited(), new HashSet<>()),
            new Note(new NoteId(), new Title("Lorem Ipsum Dolor Sit"), new Content("Lorem ipsum dolor sit amet, "
                + "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna "
                + "aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip"
                + "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse "
                + "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, "
                + "sunt in culpa qui officia deserunt mollit anim id est laborum."), new TimeCreated(),
                new TimeLastEdited(), new HashSet<>()),
            new Note(new NoteId(), new Title("Lorem Ipsum Dolor Sit"), new Content("Lorem ipsum dolor sit amet, "
                + "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna "
                + "aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip"
                + "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse "
                + "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, "
                + "sunt in culpa qui officia deserunt mollit anim id est laborum."), new TimeCreated(),
                new TimeLastEdited(), new HashSet<>())
        };
    }

    public static ReadOnlyNoteBook getSampleNoteBook() {
        NoteBook sampleNb = new NoteBook();
        for (Note sampleNote : getSampleNotes()) {
            sampleNb.addNote(sampleNote);
        }
        return sampleNb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
            .map(s -> new ContactTag(new ContactId(s)))
            .collect(Collectors.toSet());
    }

    public static Group[] getSampleGroups() {
        // @formatter:off
        return new Group[]{
            new Group(new GroupName("X1"), new GroupDescription("X1 was formed through "
                    + "the survival competition series Produce X 101, which aired on Mnet from "
                    + "May 3, 2019, until July 19, 2019."),
                    getMemberIdSet("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11")),
            new Group(new GroupName("BTS"), new GroupDescription("The group's name, BTS, "
                    + "stands for the Korean expression Bangtan Sonyeondan, literally meaning \""
                    + "Bulletproof Boy Scouts\". According to member J-Hope, the name signifies "
                    + "the group's desire \"to block out stereotypes, criticisms, and expectations "
                    + "that aim on adolescents like bullets\"."),
                    getMemberIdSet("11", "12", "13", "14", "15", "16", "17")),
            new Group(new GroupName("GFriend"), new GroupDescription("GFriend (Korean: <Korean>,"
                    + "RR: Yeoja Chingu) is a six-member South Korean girl group formed by Source Music "
                    + "in 2015.[2] The group consists of Sowon, Yerin, Eunha, Yuju, SinB, and Umji. "
                    + "They made their debut with the EP Season of Glass on January 15, 2015. GFriend "
                    + "won several 2015 female rookie awards and has garnered momentum since their debut "
                    + "despite being from a small company."),
                    getMemberIdSet("211", "212", "213", "214", "215", "216")),
            new Group(new GroupName("Wanna One"), new GroupDescription("Wanna One (Korean: 워너원) "
                    + "was a South Korean boy band formed by CJ E&M through the second season of Produce "
                    + "101.[1] The group was composed of eleven members: Kang Daniel, Park Ji-hoon, Lee "
                    + "Dae-hwi, Kim Jae-hwan, Ong Seong-wu, Park Woo-jin, Lai Kuan-lin, Yoon Ji-sung, "
                    + "Hwang Min-hyun, Bae Jin-young and Ha Sung-woon. The group debuted on August 7, "
                    + "2017, under Swing Entertainment and CJ E&M. Their contract ended on December 31, "
                    + "2018, but their final activity as a group was their last concert on January 24–27, "
                    + "2019."),
                    getMemberIdSet("2131", "2132", "2133", "2134", "2135", "2136", "2137",
                        "2138", "2139", "21310", "21311")),
            new Group(new GroupName("iKon"), new GroupDescription("The group released their debut "
                    + "studio album Welcome Back (2015), which debuted atop the South Korean Gaon Album "
                    + "Chart and produced the number-one singles \"My Type\", \"Apology\" and \"Dumb & "
                    + "Dumber\" and three top-ten singles: \"Rhythm Ta\", \"Airplane\" and \"Anthem\". "
                    + "The album was commercially a success, selling 260,000 copies in Asia, and the "
                    + "songs sold 4.8 million copies, which lead the group to win several best new "
                    + "artist awards on major Asia award shows, including Mnet Asian Music Awards, "
                    + "Japan Record Awards and QQ Music Awards. The following two years, the group "
                    + "released the singles \"#WYD\" and \"New Kids: Begin\", and they focused on their "
                    + "first Asia tour and several Japanese tours. The group's second studio album, "
                    + "Return, was released on January 25, 2018. "),
                    getMemberIdSet("62131", "52132", "42133", "32134", "22135", "12136")),
            new Group(new GroupName("exo"), new GroupDescription("Exo (Korean: 엑소; stylized in "
                    + "all caps) is a South Korean–Chinese boy band based in Seoul, with nine members: "
                    + "Xiumin, Suho, Lay, Baekhyun, Chen, Chanyeol, D.O., Kai and Sehun. The band was "
                    + "formed by SM Entertainment in 2011 and debuted in 2012. Their music incorporates "
                    + "genres like pop, hip-hop, and R&B, alongside electronic dance music genres like "
                    + "house, trap, and synth-pop. Exo releases and performs music in Korean, Mandarin, "
                    + "and Japanese. The band ranked as one of the top five most influential celebrities "
                    + "on the Forbes Korea Power Celebrity list each year from 2014 to 2018, and have "
                    + "been named \"the biggest boy band in the world\" and the \"kings of K-pop\" by "
                    + "media outlets. "),
                    getMemberIdSet("6231", "5213", "4213", "3213", "5335", "6136",
                        "7", "8", "9")),
            new Group(new GroupName("Seventeen"), new GroupDescription("Seventeen (Korean: 세븐틴), "
                    + "also stylized as SEVENTEEN or SVT, is a South Korean boy group formed by Pledis "
                    + "Entertainment in 2015. The group consists of 13 members divided into three "
                    + "sub-units, each with a different area of specialization: a 'Hip-Hop Unit', 'Vocal "
                    + "Unit', and 'Performance Unit'. Seventeen has released three studio albums and six "
                    + "extended plays.\n\n"
                    + "Seventeen has been considered a \"self-producing\" idol group, with the members being "
                    + "actively involved in the songwriting, choreographing, and other aspects of the group."),
                    getMemberIdSet("901", "902", "903", "904", "905", "906", "907", "908",
                            "909", "9010", "9011", "9012", "9013"))
        };
    }

    public static ReadOnlyGroupBook getSampleGroupBook() {
        GroupBook sampleGb = new GroupBook();
        for (Group sampleGroup : getSampleGroups()) {
            sampleGb.addGroup(sampleGroup);
        }
        return sampleGb;
    }

    /**
     * Returns a contactId set containing the list of strings given.
     */
    public static Set<MemberId> getMemberIdSet(String... strings) {
        return Arrays.stream(strings)
                .map(s -> new MemberId(s))
                .collect(Collectors.toSet());
    }
}
