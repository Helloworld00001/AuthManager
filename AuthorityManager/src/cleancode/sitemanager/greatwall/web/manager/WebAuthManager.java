/*
 *  Copyright (c) 2015 Nokia. All rights reserved.
 *
 *  Revision History:
 *
 *  DATE/AUTHOR          COMMENT
 *  ---------------------------------------------------------------------
 *  2015年11月6日/grelin                            
 */
package cleancode.sitemanager.greatwall.web.manager;

import java.util.ArrayList;
import java.util.List;

import cleancode.sitemanager.greatwall.manager.AbstractAuthManager;
import cleancode.sitemanager.greatwall.operation.Operation;
import cleancode.sitemanager.greatwall.role.Role;
import cleancode.sitemanager.greatwall.user.AbstractUser;
import cleancode.sitemanager.greatwall.web.role.Admin;
import cleancode.sitemanager.greatwall.web.role.Guest;
import cleancode.sitemanager.greatwall.web.role.Member;
import cleancode.sitemanager.greatwall.web.role.SuperAdmin;
import cleancode.sitemanager.greatwall.web.user.WebUser;

/**
 * Web Authority Manager which handle Web-based system authority management
 * 
 * @author <a HREF="mailto:yourMail@nsn.com">Your Name</a>
 */
public class WebAuthManager extends AbstractAuthManager
{
    private static WebAuthManager instance = new WebAuthManager();

    private WebAuthManager()
    {

    }

    public static WebAuthManager getInstance()
    {
        return instance;
    }

    public AbstractUser createUser( String userName )
    {
        AbstractUser user = new WebUser( userName );
        addUser( user );
        return user;
    }

    public void updateUserName( AbstractUser user, String updatedName )
    {
        user.setName( updatedName );
    }

    public Role createAdmin()
    {
        return new Admin();
    }

    public Role createMember()
    {
        return new Member();
    }

    public Role createSuperAdmin()
    {
        return new SuperAdmin();
    }

    public Role createGuest()
    {
        return new Guest();
    }

    public void setRoleOnUser( AbstractUser user, Role role )
    {
        user.setRole( role );
    }

    public void revokeRoleOnUser( AbstractUser user, Role role )
    {
        user.revokeRole( role );
    }

    public void addOperation( Role role, Operation operation )
    {
        role.addOperation( operation );
    }

    public void removeOperation( Role role, Operation operation )
    {
        role.removeOperation( operation );
    }

    public List<Operation> getOperationsOfRoleInUser( AbstractUser user, Role role )
    {
        if( user.getRoles().contains( role ) )
        {
            int index = user.getRoles().indexOf( role );
            return user.getRoles().get( index ).getOperations();
        }
        return new ArrayList<Operation>();
    }
}
