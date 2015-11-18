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
public class SuperAdminTest extends TestCase
{
    private SuperAdmin superAdmin = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        superAdmin = new SuperAdmin();
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
        assertEquals( "Super Admin", superAdmin.getRoleName() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.role.AbstractRole#getOperations()}.
     */
    @Test
    public void testGetOperations()
    {
        superAdmin.addOperation( WebOperations.GET );
        superAdmin.addOperation( WebOperations.GET );
        superAdmin.addOperation( WebOperations.POST );
        assertEquals( 2, superAdmin.getOperations().size() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.role.AbstractRole#addOperation(cleancode.sitemanager.greatwall.operation.Operation)}.
     */
    @Test
    public void testAddOperation()
    {
        assertTrue( superAdmin.addOperation( WebOperations.GET ) );
        assertFalse( superAdmin.addOperation( WebOperations.GET ) );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.role.AbstractRole#removeOperation(cleancode.sitemanager.greatwall.operation.Operation)}.
     */
    @Test
    public void testRemoveOperation()
    {
        superAdmin.addOperation( WebOperations.GET );
        assertTrue( superAdmin.removeOperation( WebOperations.GET ) );
        assertFalse( superAdmin.removeOperation( WebOperations.POST ) );
    }

}
