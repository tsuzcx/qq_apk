package com.tencent.token;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class ack
{
  public static ack a()
  {
    try
    {
      localObject1 = Class.forName("sun.misc.Unsafe");
      final Object localObject2 = ((Class)localObject1).getDeclaredField("theUnsafe");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(null);
      localObject1 = new a(((Class)localObject1).getMethod("allocateInstance", new Class[] { Class.class }), localObject2);
      return localObject1;
    }
    catch (Exception localException1)
    {
      Object localObject1;
      label50:
      final int i;
      label133:
      label171:
      break label50;
    }
    try
    {
      localObject1 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
      ((Method)localObject1).setAccessible(true);
      i = ((Integer)((Method)localObject1).invoke(null, new Object[] { Object.class })).intValue();
      localObject1 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Integer.TYPE });
      ((Method)localObject1).setAccessible(true);
      localObject1 = new c((Method)localObject1, i);
      return localObject1;
    }
    catch (Exception localException2)
    {
      break label133;
    }
    try
    {
      localObject1 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
      ((Method)localObject1).setAccessible(true);
      localObject1 = new b((Method)localObject1);
      return localObject1;
    }
    catch (Exception localException3)
    {
      break label171;
    }
    return new d();
  }
  
  public static void a(Class<?> paramClass)
  {
    int i = paramClass.getModifiers();
    if (!Modifier.isInterface(i))
    {
      if (!Modifier.isAbstract(i)) {
        return;
      }
      localStringBuilder = new StringBuilder("Abstract class can't be instantiated! Class name: ");
      localStringBuilder.append(paramClass.getName());
      throw new UnsupportedOperationException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder("Interface can't be instantiated! Interface name: ");
    localStringBuilder.append(paramClass.getName());
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public abstract <T> T b(Class<T> paramClass);
  
  public final class a
    extends ack
  {
    public a(Object paramObject) {}
    
    public final <T> T b(Class<T> paramClass)
    {
      ack.a(paramClass);
      return ack.this.invoke(localObject2, new Object[] { paramClass });
    }
  }
  
  public final class b
    extends ack
  {
    public b() {}
    
    public final <T> T b(Class<T> paramClass)
    {
      ack.a(paramClass);
      return ack.this.invoke(null, new Object[] { paramClass, Object.class });
    }
  }
  
  public final class c
    extends ack
  {
    public c(int paramInt) {}
    
    public final <T> T b(Class<T> paramClass)
    {
      ack.a(paramClass);
      return ack.this.invoke(null, new Object[] { paramClass, Integer.valueOf(i) });
    }
  }
  
  public final class d
    extends ack
  {
    public final <T> T b(Class<T> paramClass)
    {
      throw new UnsupportedOperationException("Cannot allocate ".concat(String.valueOf(paramClass)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ack
 * JD-Core Version:    0.7.0.1
 */