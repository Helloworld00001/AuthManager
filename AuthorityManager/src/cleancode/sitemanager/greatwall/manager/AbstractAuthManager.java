package cleancode.sitemanager.greatwall.manager;

import java.util.LinkedList;
import java.util.List;

import cleancode.sitemanager.greatwall.operation.Operation;
import cleancode.sitemanager.greatwall.user.AbstractUser;

/**
 * Abstract Authority Manager. This is the container which hold all users and their roles and operations
 * 
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
 */
public abstract class AbstractAuthManager
{
    private List<AbstractUser> usersList = new LinkedList<AbstractUser>();

    public List<AbstractUser> getUsers()
    {
        return usersList;
    }

    public AbstractUser getUser( String userName )
    {
        for( int i = usersList.size() - 1; i >= 0; i-- )
        {
            if( usersList.get( i ).getName().equals( userName ) )
            {
                return usersList.get( i );
            }
        }

        return null;
    }

    public boolean addUser( AbstractUser user )
    {
        if( !usersList.contains( user ) )
        {
            return usersList.add( user );
        }
        return false;
    }
    
    public boolean deleteUser( String userName )
    {
        for( int i = usersList.size() - 1; i >= 0; i-- )
        {
            if( usersList.get( i ).getName().equals( userName ) )
            {
                usersList.remove( i );
                return true;
            }
        }

        return false;
    }

    public boolean canUserExecuteOperation( AbstractUser user, Operation operation )
    {
        return user.canOperate( operation );
    }

    /**
     * Clear all the users and their role, operations in the framework
     */
    public void clear()
    {
        usersList.clear();
    }
}
