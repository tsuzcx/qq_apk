package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;
import java.lang.reflect.Proxy;

public class ClassLoaderObjectInputStream
  extends ObjectInputStream
{
  private final ClassLoader classLoader;
  
  public ClassLoaderObjectInputStream(ClassLoader paramClassLoader, InputStream paramInputStream)
    throws IOException, StreamCorruptedException
  {
    super(paramInputStream);
    this.classLoader = paramClassLoader;
  }
  
  protected Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass)
    throws IOException, ClassNotFoundException
  {
    try
    {
      Class localClass = Class.forName(paramObjectStreamClass.getName(), false, this.classLoader);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return super.resolveClass(paramObjectStreamClass);
  }
  
  protected Class<?> resolveProxyClass(String[] paramArrayOfString)
    throws IOException, ClassNotFoundException
  {
    Object localObject = new Class[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localObject[i] = Class.forName(paramArrayOfString[i], false, this.classLoader);
      i += 1;
    }
    try
    {
      localObject = Proxy.getProxyClass(this.classLoader, (Class[])localObject);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return super.resolveProxyClass(paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.ClassLoaderObjectInputStream
 * JD-Core Version:    0.7.0.1
 */