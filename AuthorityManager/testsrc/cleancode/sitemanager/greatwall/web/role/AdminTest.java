/*
 *  Copyright (c) 2015 Nokia. All rights reserved.
 *
 *  Revision History:
 *
 *  DATE/AUTHOR          COMMENT
 *  ---------------------------------------------------------------------
 *  2015年11月7日/grelin                            
 */
package cleancode.sitemanager.greatwall.web.role;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cleancode.sitemanager.greatwall.web.operation.WebOperations;

/**
 * @author <a HREF="mailto:yourMail@nsn.com">Your Name</a>
 *
 */
public class AdminTest extends TestCase
{

    private Admin admin = null;
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        admin = new Admin();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void testGetRoleName()
    {
        assertEquals( "Admin", admin.getRoleName() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.role.AbstractRole#getOperations()}.
     */
    @Test
    public void testGetOperations()
    {
        admin.addOperation( WebOperations.GET );
        admin.addOperation( WebOperations.GET );
        admin.addOperation( WebOperations.POST );
        assertEquals( 2, admin.getOperations().size() );

    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.role.AbstractRole#addOperation(cleancode.sitemanager.greatwall.operation.Operation)}.
     */
    @Test
    public void testAddOperation()
    {
        assertTrue( admin.addOperation( WebOperations.GET ) );
        assertFalse( admin.addOperation( WebOperations.GET ) );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.role.AbstractRole#removeOperation(cleancode.sitemanager.greatwall.operation.Operation)}.
     */
    @Test
    public void testRemoveOperation()
    {
        admin.addOperation( WebOperations.GET );
        assertTrue( admin.removeOperation( WebOperations.GET ) );
        assertFalse( admin.removeOperation( WebOperations.POST ) );
    }

}
