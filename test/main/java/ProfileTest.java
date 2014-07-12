import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.Key;
import com.zhadan.domain.Conference;
import com.zhadan.domain.Profile;
import com.zhadan.form.ProfileForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Tests for Profile POJO.
 */
public class ProfileTest {

    private static final String EMAIL = "testuser@example.com";

    private static final String USER_ID = "123456789";

    private static final ProfileForm.TeeShirtSize TEE_SHIRT_SIZE = ProfileForm.TeeShirtSize.M;

    private static final String DISPLAY_NAME = "Test User";
    private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig()
                    .setDefaultHighRepJobPolicyUnappliedJobPercentage(100));
    private Profile profile;

    @Before
    public void setUp() throws Exception {
        helper.setUp();
        profile = new Profile(USER_ID, DISPLAY_NAME, EMAIL, TEE_SHIRT_SIZE);
    }

    @After
    public void tearDown() throws Exception {
        helper.tearDown();
    }

    @Test
    public void testGetters() throws Exception {
        assertEquals(USER_ID, profile.getUserId());
        assertEquals(DISPLAY_NAME, profile.getDisplayName());
        assertEquals(EMAIL, profile.getMainEmail());
        assertEquals(TEE_SHIRT_SIZE, profile.getTeeShirtSize());
    }

    @Test
    public void testUpdate() throws Exception {
        String newDisplayName = "Kay's Daddy";
        ProfileForm.TeeShirtSize newTeeShirtSize = ProfileForm.TeeShirtSize.M;
        profile.update(newDisplayName, newTeeShirtSize);
        assertEquals(USER_ID, profile.getUserId());
        assertEquals(newDisplayName, profile.getDisplayName());
        assertEquals(EMAIL, profile.getMainEmail());
        assertEquals(newTeeShirtSize, profile.getTeeShirtSize());
    }

    @Test
    public void testListValues() throws Exception {
        List<String> conferenceKeys = new ArrayList<>();
        assertEquals(conferenceKeys, profile.getConferenceKeysToAttend());
        Key<Conference> conferenceKey = Key.create(Conference.class, 123L);
        profile.addToConferenceKeysToAttend(conferenceKey.getString());
        conferenceKeys.add(conferenceKey.getString());
        assertEquals(conferenceKeys, profile.getConferenceKeysToAttend());
    }
}
