package cleancode.sitemanager.greatwall.role;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import cleancode.sitemanager.greatwall.operation.Operation;

/**
 * AbstractRole which implements Role interface
 * 
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
 */
public abstract class AbstractRole implements Role
{
    private String myRoleName;

    private List<Operation> operations = new LinkedList<Operation>();

    private final ReentrantLock lock = new ReentrantLock();

    public AbstractRole( String roleName )
    {
        myRoleName = roleName;
    }

    public String getRoleName()
    {
        return myRoleName;
    }

    @Override
    public List<Operation> getOperations()
    {
        lock.lock();
        try
        {
            return operations;
        }
        finally
        {
            lock.unlock();
        }
    }

    @Override
    public boolean addOperation( Operation operation )
    {
        lock.lock();
        try
        {
            if( !operations.contains( operation ) )
            {
                return operations.add( operation );
            }
            return false;
        }
        finally
        {
            lock.unlock();
        }
    }

    @Override
    public boolean removeOperation( Operation operation )
    {
        lock.lock();
        try
        {
            if( operations.contains( operation ) )
            {
                return operations.remove( operation );
            }
            return false;
        }
        finally
        {
            lock.unlock();
        }
    }

    @Override
    public boolean equals( Object obj )
    {
        if(obj == this)
        {
           return true; 
        }
        if(obj instanceof AbstractRole)
        {
            AbstractRole abstractRole = ( AbstractRole ) obj;
            return abstractRole.getRoleName().equals( this.getRoleName() );
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return getRoleName().hashCode();
    }

    @Override
    public String toString()
    {
        return myRoleName;
    }
}
