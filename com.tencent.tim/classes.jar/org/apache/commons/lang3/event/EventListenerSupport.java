package org.apache.commons.lang3.event;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.Validate;

public class EventListenerSupport<L>
  implements Serializable
{
  private static final long serialVersionUID = 3593265990380473632L;
  private List<L> listeners = new CopyOnWriteArrayList();
  private transient L[] prototypeArray;
  private transient L proxy;
  
  private EventListenerSupport() {}
  
  public EventListenerSupport(Class<L> paramClass)
  {
    this(paramClass, Thread.currentThread().getContextClassLoader());
  }
  
  public EventListenerSupport(Class<L> paramClass, ClassLoader paramClassLoader)
  {
    this();
    Validate.notNull(paramClass, "Listener interface cannot be null.", new Object[0]);
    Validate.notNull(paramClassLoader, "ClassLoader cannot be null.", new Object[0]);
    Validate.isTrue(paramClass.isInterface(), "Class {0} is not an interface", new Object[] { paramClass.getName() });
    initializeTransientFields(paramClass, paramClassLoader);
  }
  
  public static <T> EventListenerSupport<T> create(Class<T> paramClass)
  {
    return new EventListenerSupport(paramClass);
  }
  
  private void createProxy(Class<L> paramClass, ClassLoader paramClassLoader)
  {
    InvocationHandler localInvocationHandler = createInvocationHandler();
    this.proxy = paramClass.cast(Proxy.newProxyInstance(paramClassLoader, new Class[] { paramClass }, localInvocationHandler));
  }
  
  private void initializeTransientFields(Class<L> paramClass, ClassLoader paramClassLoader)
  {
    this.prototypeArray = ((Object[])Array.newInstance(paramClass, 0));
    createProxy(paramClass, paramClassLoader);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream = (Object[])paramObjectInputStream.readObject();
    this.listeners = new CopyOnWriteArrayList(paramObjectInputStream);
    initializeTransientFields(paramObjectInputStream.getClass().getComponentType(), Thread.currentThread().getContextClassLoader());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    ObjectOutputStream localObjectOutputStream1 = new ObjectOutputStream(new ByteArrayOutputStream());
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      try
      {
        localObjectOutputStream1.writeObject(localObject);
        localArrayList.add(localObject);
      }
      catch (IOException localIOException)
      {
        ObjectOutputStream localObjectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
      }
    }
    paramObjectOutputStream.writeObject(localArrayList.toArray(this.prototypeArray));
  }
  
  public void addListener(L paramL)
  {
    Validate.notNull(paramL, "Listener object cannot be null.", new Object[0]);
    this.listeners.add(paramL);
  }
  
  protected InvocationHandler createInvocationHandler()
  {
    return new ProxyInvocationHandler();
  }
  
  public L fire()
  {
    return this.proxy;
  }
  
  int getListenerCount()
  {
    return this.listeners.size();
  }
  
  public L[] getListeners()
  {
    return this.listeners.toArray(this.prototypeArray);
  }
  
  public void removeListener(L paramL)
  {
    Validate.notNull(paramL, "Listener object cannot be null.", new Object[0]);
    this.listeners.remove(paramL);
  }
  
  public class ProxyInvocationHandler
    implements InvocationHandler
  {
    protected ProxyInvocationHandler() {}
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      paramObject = EventListenerSupport.this.listeners.iterator();
      while (paramObject.hasNext()) {
        paramMethod.invoke(paramObject.next(), paramArrayOfObject);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.event.EventListenerSupport
 * JD-Core Version:    0.7.0.1
 */