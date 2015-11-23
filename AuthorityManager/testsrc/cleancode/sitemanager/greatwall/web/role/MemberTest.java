package cleancode.sitemanager.greatwall.web.role;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cleancode.sitemanager.greatwall.web.operation.WebOperations;

/**
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
 */
public class MemberTest extends TestCase
{

    private Member member = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        member = new Member();
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
        assertEquals( "Member", member.getRoleName() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.role.AbstractRole#getOperations()}.
     */
    @Test
    public void testGetOperations()
    {
        member.addOperation( WebOperations.GET );
        member.addOperation( WebOperations.GET );
        member.addOperation( WebOperations.POST );
        assertEquals( 2, member.getOperations().size() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.role.AbstractRole#addOperation(cleancode.sitemanager.greatwall.operation.Operation)}.
     */
    @Test
    public void testAddOperation()
    {
        assertTrue( member.addOperation( WebOperations.GET ) );
        assertFalse( member.addOperation( WebOperations.GET ) );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.role.AbstractRole#removeOperation(cleancode.sitemanager.greatwall.operation.Operation)}.
     */
    @Test
    public void testRemoveOperation()
    {
        member.addOperation( WebOperations.GET );
        assertTrue( member.removeOperation( WebOperations.GET ) );
        assertFalse( member.removeOperation( WebOperations.POST ) );
    }

}
