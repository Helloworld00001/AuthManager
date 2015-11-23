package cleancode.sitemanager.greatwall.web.demo;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cleancode.sitemanager.greatwall.web.manager.WebAuthManager;

/**
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
 */
public class WebAuthManagerDemoTest extends TestCase
{
    private WebAuthManagerDemo demo = null;

    private WebAuthManager webAuthManagerInstance = WebAuthManager.getInstance();

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        demo = new WebAuthManagerDemo();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
        webAuthManagerInstance.clear();
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.demo.WebAuthManagerDemo#testFunctionalitySuit1()}.
     */
    @Test
    public void testFunctionalitySuit1()
    {
        demo.functionalitySuit1();
        assertEquals( 1, webAuthManagerInstance.getUsers().size() );
    }

    @Test
    public void testFunctionalitySuit2()
    {
        demo.functionalitySuit2();
        assertEquals( 2, webAuthManagerInstance.getUsers().size() );
    }
}
