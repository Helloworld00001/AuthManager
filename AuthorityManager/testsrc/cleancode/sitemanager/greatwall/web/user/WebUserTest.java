/*
 *  Copyright (c) 2015 Nokia. All rights reserved.
 *
 *  Revision History:
 *
 *  DATE/AUTHOR          COMMENT
 *  ---------------------------------------------------------------------
 *  2015年11月7日/grelin                            
 */
package cleancode.sitemanager.greatwall.web.user;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cleancode.sitemanager.greatwall.role.Role;
import cleancode.sitemanager.greatwall.web.operation.WebOperations;
import cleancode.sitemanager.greatwall.web.role.Admin;
import cleancode.sitemanager.greatwall.web.role.Member;
import cleancode.sitemanager.greatwall.web.role.SuperAdmin;

/**
 * @author <a HREF="mailto:yourMail@nsn.com">Your Name</a>
 *
 */
public class WebUserTest extends TestCase
{
    private WebUser user = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        user = new WebUser( "test" );
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.user.WebUser#setRole(cleancode.sitemanager.greatwall.role.Role)}.
     */
    @Test
    public void testSetRole()
    {
        Role role = new Admin();
        role.addOperation( WebOperations.VIEW );
        assertTrue( user.setRole( role ) );
        
        Role role2 = new Admin();
        role2.addOperation( WebOperations.GET );
        user.setRole( role2 );
        assertEquals( WebOperations.GET, user.getOperations().get( 0 ) );

        Role role3 = new Member();
        role3.addOperation( WebOperations.ADD );
        user.setRole( role3 );
        assertEquals( 2, user.getRoles().size() );
        assertEquals( 2, user.getOperations().size() );

    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.user.WebUser#revokeRole(cleancode.sitemanager.greatwall.role.Role)}.
     */
    @Test
    public void testRevokeRole()
    {
        Role role = new SuperAdmin();
        role.addOperation( WebOperations.VIEW );
        role.addOperation( WebOperations.DELETE );
        user.setRole( role );
        assertEquals( 1, user.getRoles().size() );

        assertTrue( user.revokeRole( role ) );
        assertEquals( 0, user.getRoles().size() );

        assertFalse( user.revokeRole( role ) );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.user.WebUser#getRoles()}.
     */
    @Test
    public void testGetRoles()
    {
        Role role = new SuperAdmin();
        role.addOperation( WebOperations.VIEW );
        role.addOperation( WebOperations.UPDATE );
        role.addOperation( WebOperations.DELETE );
        user.setRole( role );

        Role role2 = new Admin();
        role2.addOperation( WebOperations.VIEW );
        role2.addOperation( WebOperations.DELETE );
        user.setRole( role2 );

        assertEquals( 2, user.getRoles().size() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.user.WebUser#getOperations()}.
     */
    @Test
    public void testGetOperations()
    {
        Role role = new SuperAdmin();
        role.addOperation( WebOperations.VIEW );
        role.addOperation( WebOperations.UPDATE );
        role.addOperation( WebOperations.DELETE );
        user.setRole( role );

        Role role2 = new Admin();
        role2.addOperation( WebOperations.VIEW );
        role2.addOperation( WebOperations.DELETE );
        user.setRole( role2 );

        assertEquals( 3, user.getOperations().size() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.user.WebUser#canOperate(cleancode.sitemanager.greatwall.operation.Operation)}.
     */
    @Test
    public void testCanOperate()
    {
        Role role = new SuperAdmin();
        role.addOperation( WebOperations.VIEW );
        role.addOperation( WebOperations.UPDATE );
        role.addOperation( WebOperations.DELETE );
        user.setRole( role );

        Role role2 = new Admin();
        role2.addOperation( WebOperations.VIEW );
        role2.addOperation( WebOperations.DELETE );
        user.setRole( role2 );

        assertTrue( user.canOperate( WebOperations.UPDATE ) );
        user.revokeRole( role );
        assertFalse( user.canOperate( WebOperations.UPDATE ) );

    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.user.AbstractUser#getName()}.
     */
    @Test
    public void testGetName()
    {
        assertEquals( "test", user.getName() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.user.AbstractUser#setName(java.lang.String)}.
     */
    @Test
    public void testSetName()
    {
        user.setName( "hello" );
        assertEquals( "hello", user.getName() );

    }

}
