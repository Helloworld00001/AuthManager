package cleancode.sitemanager.greatwall.web.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import cleancode.sitemanager.greatwall.operation.Operation;
import cleancode.sitemanager.greatwall.role.Role;
import cleancode.sitemanager.greatwall.user.AbstractUser;

/**
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
 */
public class WebUser extends AbstractUser
{
    private List<Role> myRoles = new LinkedList<Role>();

    /**
     * @param name
     */
    public WebUser( String name )
    {
        super( name );
    }

    /**
     * @param myRole
     * @see cleancode.sitemanager.greatwall.user.AbstractUser#setRole(cleancode.sitemanager.greatwall.role.Role)
     */
    @Override
    public boolean setRole( Role role )
    {
        if( myRoles.contains( role ) )
        {
            myRoles.set( myRoles.indexOf( role ), role );
        }
        else
        {
            myRoles.add( role );
        }

        return true;
    }

    /**
     * @return
     * @see cleancode.sitemanager.greatwall.user.AbstractUser#getRoles()
     */
    @Override
    public List<Role> getRoles()
    {
        return myRoles;
    }

    /**
     * @param role
     * @return
     * @see cleancode.sitemanager.greatwall.user.AbstractUser#revokeRole(cleancode.sitemanager.greatwall.role.Role)
     */
    @Override
    public boolean revokeRole( Role role )
    {
        if( myRoles.contains( role ) )
        {
            return myRoles.remove( role );
        }

        return false;
    }

    /**
     * @return
     * @see cleancode.sitemanager.greatwall.user.AbstractUser#getOperations()
     */
    @Override
    public List<Operation> getOperations()
    {
        Set<Operation> operationSet = new HashSet<Operation>();
        for( Role role : myRoles )
        {
            operationSet.addAll( role.getOperations() );
        }
        return new ArrayList<Operation>( operationSet );
    }

    /**
     * @return
     * @see cleancode.sitemanager.greatwall.user.AbstractUser#canOperate()
     */
    @Override
    public boolean canOperate( Operation operation )
    {
        return getOperations().contains( operation );
    }

}
