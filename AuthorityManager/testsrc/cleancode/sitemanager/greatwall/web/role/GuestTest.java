package cleancode.sitemanager.greatwall.web.role;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cleancode.sitemanager.greatwall.web.operation.WebOperations;

/**
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
 */
public class GuestTest extends TestCase
{
    private Guest guest = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        guest = new Guest();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.role.AbstractRole#getRoleName()}.
     */
    @Test
    public void testGetRoleName()
    {
        assertEquals( "Guest", guest.getRoleName() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.role.AbstractRole#getOperations()}.
     */
    @Test
    public void testGetOperations()
    {
        guest.addOperation( WebOperations.GET );
        guest.addOperation( WebOperations.GET );
        guest.addOperation( WebOperations.POST );
        assertEquals( 2, guest.getOperations().size() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.role.AbstractRole#addOperation(cleancode.sitemanager.greatwall.operation.Operation)}.
     */
    @Test
    public void testAddOperation()
    {
        assertTrue( guest.addOperation( WebOperations.GET ) );
        assertFalse( guest.addOperation( WebOperations.GET ) );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.role.AbstractRole#removeOperation(cleancode.sitemanager.greatwall.operation.Operation)}.
     */
    @Test
    public void testRemoveOperation()
    {
        guest.addOperation( WebOperations.GET );
        assertTrue( guest.removeOperation( WebOperations.GET ) );
        assertFalse( guest.removeOperation( WebOperations.POST ) );
    }
}
