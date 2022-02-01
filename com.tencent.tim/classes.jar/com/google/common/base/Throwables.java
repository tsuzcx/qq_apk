package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Throwables
{
  @GwtIncompatible
  private static final String JAVA_LANG_ACCESS_CLASSNAME = "sun.misc.JavaLangAccess";
  @GwtIncompatible
  @VisibleForTesting
  static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";
  @Nullable
  @GwtIncompatible
  private static final Method getStackTraceDepthMethod;
  @Nullable
  @GwtIncompatible
  private static final Method getStackTraceElementMethod;
  @Nullable
  @GwtIncompatible
  private static final Object jla;
  
  static
  {
    Object localObject2 = null;
    jla = getJLA();
    if (jla == null)
    {
      localObject1 = null;
      getStackTraceElementMethod = (Method)localObject1;
      if (jla != null) {
        break label40;
      }
    }
    label40:
    for (Object localObject1 = localObject2;; localObject1 = getSizeMethod())
    {
      getStackTraceDepthMethod = (Method)localObject1;
      return;
      localObject1 = getGetMethod();
      break;
    }
  }
  
  @Beta
  public static List<Throwable> getCausalChain(Throwable paramThrowable)
  {
    Preconditions.checkNotNull(paramThrowable);
    ArrayList localArrayList = new ArrayList(4);
    while (paramThrowable != null)
    {
      localArrayList.add(paramThrowable);
      paramThrowable = paramThrowable.getCause();
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  @Nullable
  @GwtIncompatible
  private static Method getGetMethod()
  {
    return getJlaMethod("getStackTraceElement", new Class[] { Throwable.class, Integer.TYPE });
  }
  
  @Nullable
  @GwtIncompatible
  private static Object getJLA()
  {
    try
    {
      Object localObject = Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
      return localObject;
    }
    catch (ThreadDeath localThreadDeath)
    {
      throw localThreadDeath;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  @Nullable
  @GwtIncompatible
  private static Method getJlaMethod(String paramString, Class<?>... paramVarArgs)
    throws ThreadDeath
  {
    try
    {
      paramString = Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(paramString, paramVarArgs);
      return paramString;
    }
    catch (ThreadDeath paramString)
    {
      throw paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public static Throwable getRootCause(Throwable paramThrowable)
  {
    for (;;)
    {
      Throwable localThrowable = paramThrowable.getCause();
      if (localThrowable == null) {
        break;
      }
      paramThrowable = localThrowable;
    }
    return paramThrowable;
  }
  
  @Nullable
  @GwtIncompatible
  private static Method getSizeMethod()
  {
    return getJlaMethod("getStackTraceDepth", new Class[] { Throwable.class });
  }
  
  @GwtIncompatible
  public static String getStackTraceAsString(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  @GwtIncompatible
  private static Object invokeAccessibleNonThrowingMethod(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException(paramMethod);
    }
    catch (InvocationTargetException paramMethod)
    {
      throw propagate(paramMethod.getCause());
    }
  }
  
  @GwtIncompatible
  private static List<StackTraceElement> jlaStackTrace(Throwable paramThrowable)
  {
    Preconditions.checkNotNull(paramThrowable);
    return new Throwables.1(paramThrowable);
  }
  
  @Beta
  @GwtIncompatible
  public static List<StackTraceElement> lazyStackTrace(Throwable paramThrowable)
  {
    if (lazyStackTraceIsLazy()) {
      return jlaStackTrace(paramThrowable);
    }
    return Collections.unmodifiableList(Arrays.asList(paramThrowable.getStackTrace()));
  }
  
  @Beta
  @GwtIncompatible
  public static boolean lazyStackTraceIsLazy()
  {
    int j = 1;
    int i;
    if (getStackTraceElementMethod != null)
    {
      i = 1;
      if (getStackTraceDepthMethod == null) {
        break label25;
      }
    }
    for (;;)
    {
      return i & j;
      i = 0;
      break;
      label25:
      j = 0;
    }
  }
  
  @Deprecated
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static RuntimeException propagate(Throwable paramThrowable)
  {
    throwIfUnchecked(paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
  
  @Deprecated
  @GwtIncompatible
  public static <X extends Throwable> void propagateIfInstanceOf(@Nullable Throwable paramThrowable, Class<X> paramClass)
    throws Throwable
  {
    if (paramThrowable != null) {
      throwIfInstanceOf(paramThrowable, paramClass);
    }
  }
  
  @Deprecated
  @GwtIncompatible
  public static void propagateIfPossible(@Nullable Throwable paramThrowable)
  {
    if (paramThrowable != null) {
      throwIfUnchecked(paramThrowable);
    }
  }
  
  @GwtIncompatible
  public static <X extends Throwable> void propagateIfPossible(@Nullable Throwable paramThrowable, Class<X> paramClass)
    throws Throwable
  {
    propagateIfInstanceOf(paramThrowable, paramClass);
    propagateIfPossible(paramThrowable);
  }
  
  @GwtIncompatible
  public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@Nullable Throwable paramThrowable, Class<X1> paramClass, Class<X2> paramClass1)
    throws Throwable, Throwable
  {
    Preconditions.checkNotNull(paramClass1);
    propagateIfInstanceOf(paramThrowable, paramClass);
    propagateIfPossible(paramThrowable, paramClass1);
  }
  
  @GwtIncompatible
  public static <X extends Throwable> void throwIfInstanceOf(Throwable paramThrowable, Class<X> paramClass)
    throws Throwable
  {
    Preconditions.checkNotNull(paramThrowable);
    if (paramClass.isInstance(paramThrowable)) {
      throw ((Throwable)paramClass.cast(paramThrowable));
    }
  }
  
  public static void throwIfUnchecked(Throwable paramThrowable)
  {
    Preconditions.checkNotNull(paramThrowable);
    if ((paramThrowable instanceof RuntimeException)) {
      throw ((RuntimeException)paramThrowable);
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Throwables
 * JD-Core Version:    0.7.0.1
 */