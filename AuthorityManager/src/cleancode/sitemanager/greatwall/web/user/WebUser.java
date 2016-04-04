package cleancode.sitemanager.greatwall.web.user;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import java.util.stream.Collectors;

import cleancode.sitemanager.greatwall.operation.Operation;
import cleancode.sitemanager.greatwall.role.Role;
import cleancode.sitemanager.greatwall.user.AbstractUser;

/**
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
 */
public class WebUser extends AbstractUser
{
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static final WriteLock writeLock = readWriteLock.writeLock();

    private static final ReadLock readLock = readWriteLock.readLock();

    private List<Role> myRoles = new LinkedList<Role>();

    public WebUser( String name )
    {
        super( name );
    }

    public WebUser( String name, Long id )
    {
        super( name, id );
    }

    @Override
    public boolean setRole( Role role )
    {
        writeLock.lock();
        try
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
        finally
        {
            writeLock.unlock();
        }
    }

    @Override
    public List<Role> getRoles()
    {
        readLock.lock();
        try
        {
            return myRoles;
        }
        finally
        {
            readLock.unlock();
        }
    }

    @Override
    public boolean revokeRole( Role role )
    {
        writeLock.lock();
        try
        {
            if( myRoles.contains( role ) )
            {
                return myRoles.remove( role );
            }

            return false;
        }
        finally
        {
            writeLock.unlock();
        }
    }

    @Override
    public List<Operation> getOperations()
    {
        readLock.lock();
        try
        {
            return myRoles.stream().flatMap( role -> role.getOperations().stream() ).distinct().collect(
                Collectors.toList() );
        }
        finally
        {
            readLock.unlock();
        }

    }

    @Override
    public boolean canOperate( Operation operation )
    {
        return getOperations().stream().anyMatch( ele -> ele == operation );
    }

}
