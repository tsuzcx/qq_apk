package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@GwtIncompatible
final class FuturesGetChecked
{
  private static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new FuturesGetChecked.1()).reverse();
  
  private static GetCheckedTypeValidator bestGetCheckedTypeValidator()
  {
    return GetCheckedTypeValidatorHolder.BEST_VALIDATOR;
  }
  
  @VisibleForTesting
  static void checkExceptionClassValidity(Class<? extends Exception> paramClass)
  {
    Preconditions.checkArgument(isCheckedException(paramClass), "Futures.getChecked exception type (%s) must not be a RuntimeException", paramClass);
    Preconditions.checkArgument(hasConstructorUsableByGetChecked(paramClass), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", paramClass);
  }
  
  @VisibleForTesting
  static GetCheckedTypeValidator classValueValidator()
  {
    return FuturesGetChecked.GetCheckedTypeValidatorHolder.ClassValueValidator.INSTANCE;
  }
  
  @VisibleForTesting
  @CanIgnoreReturnValue
  static <V, X extends Exception> V getChecked(GetCheckedTypeValidator paramGetCheckedTypeValidator, Future<V> paramFuture, Class<X> paramClass)
    throws Exception
  {
    paramGetCheckedTypeValidator.validateClass(paramClass);
    try
    {
      paramGetCheckedTypeValidator = paramFuture.get();
      return paramGetCheckedTypeValidator;
    }
    catch (InterruptedException paramGetCheckedTypeValidator)
    {
      Thread.currentThread().interrupt();
      throw newWithCause(paramClass, paramGetCheckedTypeValidator);
    }
    catch (ExecutionException paramGetCheckedTypeValidator)
    {
      wrapAndThrowExceptionOrError(paramGetCheckedTypeValidator.getCause(), paramClass);
      throw new AssertionError();
    }
  }
  
  @CanIgnoreReturnValue
  static <V, X extends Exception> V getChecked(Future<V> paramFuture, Class<X> paramClass)
    throws Exception
  {
    return getChecked(bestGetCheckedTypeValidator(), paramFuture, paramClass);
  }
  
  @CanIgnoreReturnValue
  static <V, X extends Exception> V getChecked(Future<V> paramFuture, Class<X> paramClass, long paramLong, TimeUnit paramTimeUnit)
    throws Exception
  {
    bestGetCheckedTypeValidator().validateClass(paramClass);
    try
    {
      paramFuture = paramFuture.get(paramLong, paramTimeUnit);
      return paramFuture;
    }
    catch (InterruptedException paramFuture)
    {
      Thread.currentThread().interrupt();
      throw newWithCause(paramClass, paramFuture);
    }
    catch (TimeoutException paramFuture)
    {
      throw newWithCause(paramClass, paramFuture);
    }
    catch (ExecutionException paramFuture)
    {
      wrapAndThrowExceptionOrError(paramFuture.getCause(), paramClass);
      throw new AssertionError();
    }
  }
  
  private static boolean hasConstructorUsableByGetChecked(Class<? extends Exception> paramClass)
  {
    try
    {
      newWithCause(paramClass, new Exception());
      return true;
    }
    catch (Exception paramClass) {}
    return false;
  }
  
  @VisibleForTesting
  static boolean isCheckedException(Class<? extends Exception> paramClass)
  {
    return !RuntimeException.class.isAssignableFrom(paramClass);
  }
  
  @Nullable
  private static <X> X newFromConstructor(Constructor<X> paramConstructor, Throwable paramThrowable)
  {
    Class[] arrayOfClass = paramConstructor.getParameterTypes();
    Object[] arrayOfObject = new Object[arrayOfClass.length];
    int i = 0;
    if (i < arrayOfClass.length)
    {
      Class localClass = arrayOfClass[i];
      if (localClass.equals(String.class)) {
        arrayOfObject[i] = paramThrowable.toString();
      }
      for (;;)
      {
        i += 1;
        break;
        if (!localClass.equals(Throwable.class)) {
          break label68;
        }
        arrayOfObject[i] = paramThrowable;
      }
      label68:
      return null;
    }
    try
    {
      paramConstructor = paramConstructor.newInstance(arrayOfObject);
      return paramConstructor;
    }
    catch (IllegalArgumentException paramConstructor)
    {
      return null;
    }
    catch (InstantiationException paramConstructor)
    {
      return null;
    }
    catch (IllegalAccessException paramConstructor)
    {
      return null;
    }
    catch (InvocationTargetException paramConstructor) {}
    return null;
  }
  
  private static <X extends Exception> X newWithCause(Class<X> paramClass, Throwable paramThrowable)
  {
    Iterator localIterator = preferringStrings(Arrays.asList(paramClass.getConstructors())).iterator();
    while (localIterator.hasNext())
    {
      Exception localException = (Exception)newFromConstructor((Constructor)localIterator.next(), paramThrowable);
      if (localException != null)
      {
        if (localException.getCause() == null) {
          localException.initCause(paramThrowable);
        }
        return localException;
      }
    }
    throw new IllegalArgumentException("No appropriate constructor for exception of type " + paramClass + " in response to chained exception", paramThrowable);
  }
  
  private static <X extends Exception> List<Constructor<X>> preferringStrings(List<Constructor<X>> paramList)
  {
    return WITH_STRING_PARAM_FIRST.sortedCopy(paramList);
  }
  
  @VisibleForTesting
  static GetCheckedTypeValidator weakSetValidator()
  {
    return FuturesGetChecked.GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
  }
  
  private static <X extends Exception> void wrapAndThrowExceptionOrError(Throwable paramThrowable, Class<X> paramClass)
    throws Exception
  {
    if ((paramThrowable instanceof Error)) {
      throw new ExecutionError((Error)paramThrowable);
    }
    if ((paramThrowable instanceof RuntimeException)) {
      throw new UncheckedExecutionException(paramThrowable);
    }
    throw newWithCause(paramClass, paramThrowable);
  }
  
  @VisibleForTesting
  static abstract interface GetCheckedTypeValidator
  {
    public abstract void validateClass(Class<? extends Exception> paramClass);
  }
  
  @VisibleForTesting
  static class GetCheckedTypeValidatorHolder
  {
    static final FuturesGetChecked.GetCheckedTypeValidator BEST_VALIDATOR = getBestValidator();
    static final String CLASS_VALUE_VALIDATOR_NAME = GetCheckedTypeValidatorHolder.class.getName() + "$ClassValueValidator";
    
    static FuturesGetChecked.GetCheckedTypeValidator getBestValidator()
    {
      try
      {
        FuturesGetChecked.GetCheckedTypeValidator localGetCheckedTypeValidator = (FuturesGetChecked.GetCheckedTypeValidator)Class.forName(CLASS_VALUE_VALIDATOR_NAME).getEnumConstants()[0];
        return localGetCheckedTypeValidator;
      }
      catch (Throwable localThrowable) {}
      return FuturesGetChecked.weakSetValidator();
    }
    
    @IgnoreJRERequirement
    static enum ClassValueValidator
      implements FuturesGetChecked.GetCheckedTypeValidator
    {
      INSTANCE;
      
      private static final ClassValue<Boolean> isValidClass = new FuturesGetChecked.GetCheckedTypeValidatorHolder.ClassValueValidator.1();
      
      private ClassValueValidator() {}
      
      public void validateClass(Class<? extends Exception> paramClass)
      {
        isValidClass.get(paramClass);
      }
    }
    
    static enum WeakSetValidator
      implements FuturesGetChecked.GetCheckedTypeValidator
    {
      INSTANCE;
      
      private static final Set<WeakReference<Class<? extends Exception>>> validClasses = new CopyOnWriteArraySet();
      
      private WeakSetValidator() {}
      
      public void validateClass(Class<? extends Exception> paramClass)
      {
        Iterator localIterator = validClasses.iterator();
        while (localIterator.hasNext()) {
          if (paramClass.equals(((WeakReference)localIterator.next()).get())) {
            return;
          }
        }
        FuturesGetChecked.checkExceptionClassValidity(paramClass);
        if (validClasses.size() > 1000) {
          validClasses.clear();
        }
        validClasses.add(new WeakReference(paramClass));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.FuturesGetChecked
 * JD-Core Version:    0.7.0.1
 */