/*
 *  Copyright (c) 2015 Nokia. All rights reserved.
 *
 *  Revision History:
 *
 *  DATE/AUTHOR          COMMENT
 *  ---------------------------------------------------------------------
 *  2015年11月7日/grelin                            
 */
package cleancode.sitemanager.greatwall.web.manager;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cleancode.sitemanager.greatwall.role.AbstractRole;
import cleancode.sitemanager.greatwall.role.Role;
import cleancode.sitemanager.greatwall.user.AbstractUser;
import cleancode.sitemanager.greatwall.web.operation.WebOperations;

/**
 * @author <a HREF="mailto:yourMail@nsn.com">Your Name</a>
 *
 */
public class WebAuthManagerTest extends TestCase
{

    private WebAuthManager instance = WebAuthManager.getInstance();

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
        instance.clear();
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.manager.WebAuthManager#createUser(java.lang.String)}.
     */
    @Test
    public void testCreateUser()
    {
        instance.createUser( "test" );
        assertEquals( 1, instance.getUsers().size() );
        assertEquals( "test", instance.getUsers().get( 0 ).getName() );

        instance.createUser( "test" );
        assertEquals( 1, instance.getUsers().size() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.manager.WebAuthManager#updateUserName(cleancode.sitemanager.greatwall.user.AbstractUser, java.lang.String)}.
     */
    @Test
    public void testUpdateUserName()
    {
        AbstractUser user = instance.createUser( "test" );
        user.setName( "hello" );
        assertEquals( "hello", user.getName() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.manager.WebAuthManager#deleteUser(java.lang.String)}.
     */
    @Test
    public void testDeleteUser()
    {
        instance.createUser( "test" );
        instance.deleteUser( "test1" );
        assertEquals( 1, instance.getUsers().size() );
        instance.deleteUser( "test" );
        assertEquals( 0, instance.getUsers().size() );

    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.manager.WebAuthManager#createAdmin()}.
     */
    @Test
    public void testCreateAdmin()
    {
        AbstractRole role = ( AbstractRole ) instance.createAdmin();
        assertEquals( "Admin", role.getRoleName() );

    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.manager.WebAuthManager#createMember()}.
     */
    @Test
    public void testCreateMember()
    {
        AbstractRole role = ( AbstractRole ) instance.createMember();
        assertEquals( "Member", role.getRoleName() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.manager.WebAuthManager#createSuperAdmin()}.
     */
    @Test
    public void testCreateSuperAdmin()
    {
        AbstractRole role = ( AbstractRole ) instance.createSuperAdmin();
        assertEquals( "Super Admin", role.getRoleName() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.manager.WebAuthManager#createGuest()}.
     */
    @Test
    public void testCreateGuest()
    {
        AbstractRole role = ( AbstractRole ) instance.createGuest();
        assertEquals( "Guest", role.getRoleName() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.manager.WebAuthManager#setRoleOnUser(cleancode.sitemanager.greatwall.user.AbstractUser, cleancode.sitemanager.greatwall.role.Role)}.
     */
    @Test
    public void testSetRoleOnUser()
    {
        Role role = instance.createGuest();
        AbstractUser user = instance.createUser( "test" );
        instance.setRoleOnUser( user, role );

        assertEquals( role, user.getRoles().get( 0 ) );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.manager.WebAuthManager#revokeRoleOnUser(cleancode.sitemanager.greatwall.user.AbstractUser, cleancode.sitemanager.greatwall.role.Role)}.
     */
    @Test
    public void testRevokeRoleOnUser()
    {
        Role role = instance.createGuest();
        AbstractUser user = instance.createUser( "test" );
        instance.setRoleOnUser( user, role );

        instance.revokeRoleOnUser( user, instance.createAdmin() );
        assertEquals( 1, user.getRoles().size() );
        instance.revokeRoleOnUser( user, instance.createGuest() );
        assertEquals( 0, user.getRoles().size() );

    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.manager.WebAuthManager#addOperation(cleancode.sitemanager.greatwall.role.Role, cleancode.sitemanager.greatwall.operation.Operation)}.
     */
    @Test
    public void testAddOperation()
    {
        Role role = instance.createGuest();
        AbstractUser user = instance.createUser( "test" );
        instance.setRoleOnUser( user, role );

        instance.addOperation( role, WebOperations.VIEW );
        assertEquals( 1, role.getOperations().size() );
        assertEquals( WebOperations.VIEW, role.getOperations().get( 0 ) );

    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.web.manager.WebAuthManager#removeOperation(cleancode.sitemanager.greatwall.role.Role, cleancode.sitemanager.greatwall.operation.Operation)}.
     */
    @Test
    public void testRemoveOperation()
    {
        Role role = instance.createGuest();
        AbstractUser user = instance.createUser( "test" );
        instance.setRoleOnUser( user, role );

        instance.addOperation( role, WebOperations.VIEW );
        assertEquals( 1, role.getOperations().size() );
        instance.removeOperation( role, WebOperations.ADD );
        assertEquals( 1, role.getOperations().size() );
        instance.removeOperation( role, WebOperations.VIEW );
        assertEquals( 0, role.getOperations().size() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.manager.AbstractAuthManager#getUsers()}.
     */
    @Test
    public void testGetUsers()
    {
        instance.createUser( "test1" );
        instance.createUser( "test2" );
        assertEquals( 2, instance.getUsers().size() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.manager.AbstractAuthManager#getUser(java.lang.String)}.
     */
    @Test
    public void testGetUser()
    {
        AbstractUser user1 = instance.createUser( "test1" );
        AbstractUser user2 = instance.createUser( "test2" );

        assertEquals( null, instance.getUser( "test" ) );
        assertEquals( user1, instance.getUser( "test1" ) );
        assertEquals( user2, instance.getUser( "test2" ) );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.manager.AbstractAuthManager#delelteUser(java.lang.String)}.
     */
    @Test
    public void testDelelteUser()
    {
        instance.createUser( "test1" );
        instance.createUser( "test2" );

        instance.deleteUser( "test" );
        assertEquals( 2, instance.getUsers().size() );
        instance.deleteUser( "test1" );
        assertEquals( 1, instance.getUsers().size() );
        instance.deleteUser( "test2" );
        assertEquals( 0, instance.getUsers().size() );
    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.manager.AbstractAuthManager#canUserExecuteOperation(cleancode.sitemanager.greatwall.user.AbstractUser, cleancode.sitemanager.greatwall.operation.Operation)}.
     */
    @Test
    public void testCanUserExecuteOperation()
    {
        AbstractUser user = instance.createUser( "test" );
        assertFalse( instance.canUserExecuteOperation( user, WebOperations.GET ) );
        Role role = instance.createAdmin();
        instance.setRoleOnUser( user, role );
        instance.addOperation( role, WebOperations.GET );

        assertTrue( instance.canUserExecuteOperation( user, WebOperations.GET ) );

    }

    /**
     * Test method for {@link cleancode.sitemanager.greatwall.manager.AbstractAuthManager#clear()}.
     */
    @Test
    public void testClear()
    {
        instance.createUser( "test" );
        assertEquals( 1, instance.getUsers().size() );
        instance.clear();
        assertEquals( 0, instance.getUsers().size() );

    }

    @Test
    public void testGetOperationsOfRoleInUser()
    {
        AbstractUser user = instance.createUser( "test" );
        Role role = instance.createAdmin();
        instance.setRoleOnUser( user, role );
        instance.addOperation( role, WebOperations.GET );
        instance.addOperation( role, WebOperations.POST );
        assertEquals( 2, instance.getOperationsOfRoleInUser( user, role ).size() );

        Role role2 = instance.createMember();
        assertEquals( 0, instance.getOperationsOfRoleInUser( user, role2 ).size() );

    }

}
