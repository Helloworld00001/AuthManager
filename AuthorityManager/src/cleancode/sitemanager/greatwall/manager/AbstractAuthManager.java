package cleancode.sitemanager.greatwall.manager;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import java.util.stream.Collectors;

import cleancode.sitemanager.greatwall.operation.Operation;
import cleancode.sitemanager.greatwall.user.AbstractUser;

/**
 * Abstract Authority Manager. This is the container which hold all users and their roles and operations
 * 
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
 */
public abstract class AbstractAuthManager
{
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Map<Long, AbstractUser> usersContainer = new ConcurrentHashMap<Long, AbstractUser>();

    protected final WriteLock writeLock = readWriteLock.writeLock();

    protected final ReadLock readLock = readWriteLock.readLock();

    public List<AbstractUser> getUsers()
    {
        readLock.lock();
        try
        {
            return usersContainer.values().stream().collect( Collectors.toList() );
        }
        finally
        {
            readLock.unlock();
        }
    }

    public List<AbstractUser> getOptionalUsersByName( String userName )
    {
        readLock.lock();
        try
        {
            return usersContainer.values().stream().filter( user -> user != null && user.getName().equals( userName ) ).collect(
                Collectors.toList() );
        }
        finally
        {
            readLock.unlock();
        }

    }

    public Optional<AbstractUser> getOptionalUser( Long userId )
    {
        return Optional.ofNullable( usersContainer.get( userId ) );
    }

    public boolean addUser( AbstractUser user )
    {
        return usersContainer.putIfAbsent( user.getUseId(), user ) == null;
    }
    
    public boolean deleteUser( String userName )
    {
        writeLock.lock();
        try
        {
            getOptionalUsersByName( userName ).stream().forEach( user -> {
                usersContainer.remove( user.getUseId() );
            } );

            return true;
        }
        finally
        {
            writeLock.unlock();
        }
    }

    public boolean deleteUser( Long userId )
    {
        writeLock.lock();
        try
        {
            getOptionalUser( userId ).ifPresent( user -> {
                usersContainer.remove( user.getUseId() );
            } );

            return true;
        }
        finally
        {
            writeLock.unlock();
        }
    }

    public boolean canUserExecuteOperation( AbstractUser user, Operation operation )
    {
        return user.canOperate( operation );
    }

    /**
     * Clear all the users and their roles, operations in the framework
     */
    public void clear()
    {
        usersContainer.clear();
    }
}
