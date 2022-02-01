package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtIncompatible
public class FinalizableReferenceQueue
  implements Closeable
{
  private static final String FINALIZER_CLASS_NAME = "com.google.common.base.internal.Finalizer";
  private static final Logger logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
  private static final Method startFinalizer = getStartFinalizer(loadFinalizer(new FinalizerLoader[] { new SystemLoader(), new DecoupledLoader(), new DirectLoader() }));
  final PhantomReference<Object> frqRef = new PhantomReference(this, this.queue);
  final ReferenceQueue<Object> queue = new ReferenceQueue();
  final boolean threadStarted;
  
  public FinalizableReferenceQueue()
  {
    try
    {
      startFinalizer.invoke(null, new Object[] { FinalizableReference.class, this.queue, this.frqRef });
      this.threadStarted = bool;
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", localThrowable);
        bool = false;
      }
    }
  }
  
  static Method getStartFinalizer(Class<?> paramClass)
  {
    try
    {
      paramClass = paramClass.getMethod("startFinalizer", new Class[] { Class.class, ReferenceQueue.class, PhantomReference.class });
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      throw new AssertionError(paramClass);
    }
  }
  
  private static Class<?> loadFinalizer(FinalizerLoader... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = paramVarArgs[i].loadFinalizer();
      if (localClass != null) {
        return localClass;
      }
      i += 1;
    }
    throw new AssertionError();
  }
  
  void cleanUp()
  {
    if (this.threadStarted) {
      return;
    }
    for (;;)
    {
      Reference localReference = this.queue.poll();
      if (localReference == null) {
        break;
      }
      localReference.clear();
      try
      {
        ((FinalizableReference)localReference).finalizeReferent();
      }
      catch (Throwable localThrowable)
      {
        logger.log(Level.SEVERE, "Error cleaning up after reference.", localThrowable);
      }
    }
  }
  
  public void close()
  {
    this.frqRef.enqueue();
    cleanUp();
  }
  
  static class DecoupledLoader
    implements FinalizableReferenceQueue.FinalizerLoader
  {
    private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";
    
    URL getBaseUrl()
      throws IOException
    {
      String str1 = "com.google.common.base.internal.Finalizer".replace('.', '/') + ".class";
      URL localURL = getClass().getClassLoader().getResource(str1);
      if (localURL == null) {
        throw new FileNotFoundException(str1);
      }
      String str2 = localURL.toString();
      if (!str2.endsWith(str1)) {
        throw new IOException("Unsupported path style: " + str2);
      }
      return new URL(localURL, str2.substring(0, str2.length() - str1.length()));
    }
    
    @Nullable
    public Class<?> loadFinalizer()
    {
      try
      {
        Class localClass = newLoader(getBaseUrl()).loadClass("com.google.common.base.internal.Finalizer");
        return localClass;
      }
      catch (Exception localException)
      {
        FinalizableReferenceQueue.logger.log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", localException);
      }
      return null;
    }
    
    URLClassLoader newLoader(URL paramURL)
    {
      return new URLClassLoader(new URL[] { paramURL }, null);
    }
  }
  
  static class DirectLoader
    implements FinalizableReferenceQueue.FinalizerLoader
  {
    public Class<?> loadFinalizer()
    {
      try
      {
        Class localClass = Class.forName("com.google.common.base.internal.Finalizer");
        return localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new AssertionError(localClassNotFoundException);
      }
    }
  }
  
  static abstract interface FinalizerLoader
  {
    @Nullable
    public abstract Class<?> loadFinalizer();
  }
  
  static class SystemLoader
    implements FinalizableReferenceQueue.FinalizerLoader
  {
    @VisibleForTesting
    static boolean disabled;
    
    /* Error */
    @Nullable
    public Class<?> loadFinalizer()
    {
      // Byte code:
      //   0: getstatic 26	com/google/common/base/FinalizableReferenceQueue$SystemLoader:disabled	Z
      //   3: ifeq +5 -> 8
      //   6: aconst_null
      //   7: areturn
      //   8: invokestatic 32	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
      //   11: astore_1
      //   12: aload_1
      //   13: ifnull -7 -> 6
      //   16: aload_1
      //   17: ldc 34
      //   19: invokevirtual 38	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
      //   22: astore_1
      //   23: aload_1
      //   24: areturn
      //   25: astore_1
      //   26: invokestatic 42	com/google/common/base/FinalizableReferenceQueue:access$000	()Ljava/util/logging/Logger;
      //   29: ldc 44
      //   31: invokevirtual 50	java/util/logging/Logger:info	(Ljava/lang/String;)V
      //   34: aconst_null
      //   35: areturn
      //   36: astore_1
      //   37: aconst_null
      //   38: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	39	0	this	SystemLoader
      //   11	13	1	localObject	Object
      //   25	1	1	localSecurityException	java.lang.SecurityException
      //   36	1	1	localClassNotFoundException	ClassNotFoundException
      // Exception table:
      //   from	to	target	type
      //   8	12	25	java/lang/SecurityException
      //   16	23	36	java/lang/ClassNotFoundException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.FinalizableReferenceQueue
 * JD-Core Version:    0.7.0.1
 */