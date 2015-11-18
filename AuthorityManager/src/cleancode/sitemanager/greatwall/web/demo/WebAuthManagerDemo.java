/*
 *  Copyright (c) 2015 Nokia. All rights reserved.
 *
 *  Revision History:
 *
 *  DATE/AUTHOR          COMMENT
 *  ---------------------------------------------------------------------
 *  2015年11月5日/grelin                            
 */
package cleancode.sitemanager.greatwall.web.demo;

import cleancode.sitemanager.greatwall.role.Role;
import cleancode.sitemanager.greatwall.user.AbstractUser;
import cleancode.sitemanager.greatwall.util.PrinterUtil;
import cleancode.sitemanager.greatwall.web.manager.WebAuthManager;
import cleancode.sitemanager.greatwall.web.operation.WebOperations;

/**
 * Demo
 * 
 * @author <a HREF="mailto:yourMail@nsn.com">Your Name</a>
 */
public class WebAuthManagerDemo
{
    private static WebAuthManager webAuthManagerInstance = WebAuthManager.getInstance();

    /**
     * Only one user, set role, revoke role, add operation, delete operation, update user
     */
    public void functionalitySuit1()
    {
        String userName = "Terry";
        AbstractUser user = webAuthManagerInstance.createUser( userName );
        PrinterUtil.printCommandString( "Create User '" + user + "'" );
        Role guestRole = webAuthManagerInstance.createGuest();
        webAuthManagerInstance.setRoleOnUser( user, guestRole );
        PrinterUtil.printCommandString( "Create Role '" + guestRole + "' and set it on '" + user + "'" );
        webAuthManagerInstance.addOperation( guestRole, WebOperations.VIEW );
        PrinterUtil.printCommandString( "Add Operation '" + WebOperations.VIEW.operate() + "' for Role '" + guestRole +
            "'" );
        PrinterUtil.printAllUsersInformation( webAuthManagerInstance.getUsers() );

        webAuthManagerInstance.addOperation( guestRole, WebOperations.ADD );
        webAuthManagerInstance.addOperation( guestRole, WebOperations.UPDATE );
        PrinterUtil.printCommandString( "Add Operation '" + WebOperations.ADD.operate() + "', '" +
            WebOperations.UPDATE.operate() + "' for Role '" + guestRole + "'" );
        PrinterUtil.printAllUsersInformation( webAuthManagerInstance.getUsers() );

        webAuthManagerInstance.removeOperation( guestRole, WebOperations.ADD );
        PrinterUtil.printCommandString( "Remove Operation '" + WebOperations.ADD.operate() + "' from Role " + guestRole );
        PrinterUtil.printAllUsersInformation( webAuthManagerInstance.getUsers() );

        Role adminRole = webAuthManagerInstance.createAdmin();
        webAuthManagerInstance.setRoleOnUser( user, adminRole );
        PrinterUtil.printCommandString( "Create Role '" + adminRole + "' and set it on '" + user + "'" );
        PrinterUtil.printAllUsersInformation( webAuthManagerInstance.getUsers() );

        webAuthManagerInstance.addOperation( adminRole, WebOperations.ADD );
        webAuthManagerInstance.addOperation( adminRole, WebOperations.UPDATE );
        webAuthManagerInstance.addOperation( adminRole, WebOperations.DELETE );
        PrinterUtil.printCommandString( "Add Operation 'Add, Update, Delete' for Role '" + adminRole + "'" );
        PrinterUtil.printAllUsersInformation( webAuthManagerInstance.getUsers() );

        webAuthManagerInstance.revokeRoleOnUser( user, guestRole );
        PrinterUtil.printCommandString( "Revoke role '" + guestRole + "' from user '" + user + "'" );
        PrinterUtil.printAllUsersInformation( webAuthManagerInstance.getUsers() );

        webAuthManagerInstance.updateUserName( user, "Paul" );
        PrinterUtil.printCommandString( "Update User '" + user + "' name to 'Paul'" );
        PrinterUtil.printAllUsersInformation( webAuthManagerInstance.getUsers() );
    }

    /**
     * More than one user, create user, set role on user, add/remove operation for role, update user name, delete user
     */
    public void functionalitySuit2()
    {
        String userName1 = "Terry";
        AbstractUser user = webAuthManagerInstance.createUser( userName1 );
        Role guestRole = webAuthManagerInstance.createGuest();
        webAuthManagerInstance.setRoleOnUser( user, guestRole );
        webAuthManagerInstance.addOperation( guestRole, WebOperations.VIEW );
        PrinterUtil.printCommandString( "Create User '" + user + "'" );
        PrinterUtil.printCommandString( "Create Role '" + guestRole + "' and set it on '" + user + "'" );
        PrinterUtil.printCommandString( "Add Operation '" + WebOperations.VIEW.operate() + "' for Role '" + guestRole +
            "'" );
        PrinterUtil.printAllUsersInformation( webAuthManagerInstance.getUsers() );

        String userName2 = "Hook";
        AbstractUser user2 = webAuthManagerInstance.createUser( userName2 );
        Role memberRole = webAuthManagerInstance.createMember();
        webAuthManagerInstance.setRoleOnUser( user2, memberRole );
        webAuthManagerInstance.addOperation( memberRole, WebOperations.VIEW );
        webAuthManagerInstance.addOperation( memberRole, WebOperations.ADD );
        webAuthManagerInstance.addOperation( memberRole, WebOperations.UPDATE );
        webAuthManagerInstance.addOperation( memberRole, WebOperations.DELETE );
        PrinterUtil.printCommandString( "Create User '" + user2 + "'" );
        PrinterUtil.printCommandString( "Create Role '" + memberRole + "' and set it on '" + user2 + "'" );
        PrinterUtil.printCommandString( "Add Operation 'View, Add, Update, Delete' for Role '" + memberRole + "'" );
        PrinterUtil.printAllUsersInformation( webAuthManagerInstance.getUsers() );

        String userName3 = "Paul";
        AbstractUser user3 = webAuthManagerInstance.createUser( userName3 );
        Role superAdminRole = webAuthManagerInstance.createSuperAdmin();
        webAuthManagerInstance.setRoleOnUser( user3, superAdminRole );
        webAuthManagerInstance.addOperation( superAdminRole, WebOperations.VIEW );
        webAuthManagerInstance.addOperation( superAdminRole, WebOperations.ADD );
        webAuthManagerInstance.addOperation( superAdminRole, WebOperations.UPDATE );
        webAuthManagerInstance.addOperation( superAdminRole, WebOperations.DELETE );
        webAuthManagerInstance.addOperation( superAdminRole, WebOperations.GET );
        webAuthManagerInstance.addOperation( superAdminRole, WebOperations.POST );
        PrinterUtil.printCommandString( "Create User '" + user3 + "'" );
        PrinterUtil.printCommandString( "Create Role '" + superAdminRole + "' and set it on '" + user3 + "'" );
        PrinterUtil.printCommandString( "Add Operation 'View, Add, Update, Delete, Get, Post' for Role '" +
            superAdminRole + "'" );
        PrinterUtil.printAllUsersInformation( webAuthManagerInstance.getUsers() );

        PrinterUtil.printUserExistInFramework( user, webAuthManagerInstance.getUser( userName1 ) != null );
        webAuthManagerInstance.deleteUser( userName1 );
        PrinterUtil.printCommandString( "Delete User '" + userName1 + "'" );
        PrinterUtil.printUserExistInFramework( user, webAuthManagerInstance.getUser( userName1 ) != null );
        PrinterUtil.printAllUsersInformation( webAuthManagerInstance.getUsers() );

        PrinterUtil.printCanUserExecuteOperation( user2, WebOperations.GET );
        webAuthManagerInstance.addOperation( memberRole, WebOperations.GET );
        PrinterUtil.printCommandString( "Add Operation '" + WebOperations.GET.operate() + "' for Role '" + memberRole +
            "' on User '" + user2 + "'" );
        PrinterUtil.printCanUserExecuteOperation( user2, WebOperations.GET );
        PrinterUtil.printAllUsersInformation( webAuthManagerInstance.getUsers() );

        PrinterUtil.printCommandString( "Revoke Role '" + superAdminRole + "' from User '" + user3 + "'" );
        webAuthManagerInstance.revokeRoleOnUser( user3, superAdminRole );
        PrinterUtil.printAllUsersInformation( webAuthManagerInstance.getUsers() );

        Role adminRole = webAuthManagerInstance.createAdmin();
        webAuthManagerInstance.setRoleOnUser( user3, adminRole );
        webAuthManagerInstance.addOperation( adminRole, WebOperations.GET );
        webAuthManagerInstance.addOperation( adminRole, WebOperations.POST );
        PrinterUtil.printCommandString( "Create Role 'Admin'" );
        PrinterUtil.printCommandString( "Set Role 'Admin' on User 'Paul'" );
        PrinterUtil.printCommandString( "Add Operation 'Get, Post' for Role 'Admin'" );
        PrinterUtil.printAllUsersInformation( webAuthManagerInstance.getUsers() );
    }

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        WebAuthManagerDemo demo = new WebAuthManagerDemo();
        System.out.println( "****************************************************" );
        System.out.println( "*******Web Authority Manager Framework Demo*********" );
        demo.functionalitySuit1();
        webAuthManagerInstance.clear();
        PrinterUtil.printCommandString( "Clear all users" );
        demo.functionalitySuit2();
    }

}
