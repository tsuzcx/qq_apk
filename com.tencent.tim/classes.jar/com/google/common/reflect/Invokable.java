package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import javax.annotation.Nullable;

@Beta
public abstract class Invokable<T, R>
  extends Element
  implements GenericDeclaration
{
  <M extends AccessibleObject,  extends Member> Invokable(M paramM)
  {
    super(paramM);
  }
  
  public static <T> Invokable<T, T> from(Constructor<T> paramConstructor)
  {
    return new ConstructorInvokable(paramConstructor);
  }
  
  public static Invokable<?, Object> from(Method paramMethod)
  {
    return new MethodInvokable(paramMethod);
  }
  
  public final Class<? super T> getDeclaringClass()
  {
    return super.getDeclaringClass();
  }
  
  public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes()
  {
    ImmutableList.Builder localBuilder = ImmutableList.builder();
    Type[] arrayOfType = getGenericExceptionTypes();
    int j = arrayOfType.length;
    int i = 0;
    while (i < j)
    {
      localBuilder.add(TypeToken.of(arrayOfType[i]));
      i += 1;
    }
    return localBuilder.build();
  }
  
  abstract Type[] getGenericExceptionTypes();
  
  abstract Type[] getGenericParameterTypes();
  
  abstract Type getGenericReturnType();
  
  public TypeToken<T> getOwnerType()
  {
    return TypeToken.of(getDeclaringClass());
  }
  
  abstract Annotation[][] getParameterAnnotations();
  
  public final ImmutableList<Parameter> getParameters()
  {
    Type[] arrayOfType = getGenericParameterTypes();
    Annotation[][] arrayOfAnnotation = getParameterAnnotations();
    ImmutableList.Builder localBuilder = ImmutableList.builder();
    int i = 0;
    while (i < arrayOfType.length)
    {
      localBuilder.add(new Parameter(this, i, TypeToken.of(arrayOfType[i]), arrayOfAnnotation[i]));
      i += 1;
    }
    return localBuilder.build();
  }
  
  public final TypeToken<? extends R> getReturnType()
  {
    return TypeToken.of(getGenericReturnType());
  }
  
  @CanIgnoreReturnValue
  public final R invoke(@Nullable T paramT, Object... paramVarArgs)
    throws InvocationTargetException, IllegalAccessException
  {
    return invokeInternal(paramT, (Object[])Preconditions.checkNotNull(paramVarArgs));
  }
  
  abstract Object invokeInternal(@Nullable Object paramObject, Object[] paramArrayOfObject)
    throws InvocationTargetException, IllegalAccessException;
  
  public abstract boolean isOverridable();
  
  public abstract boolean isVarArgs();
  
  public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> paramTypeToken)
  {
    if (!paramTypeToken.isSupertypeOf(getReturnType())) {
      throw new IllegalArgumentException("Invokable is known to return " + getReturnType() + ", not " + paramTypeToken);
    }
    return this;
  }
  
  public final <R1 extends R> Invokable<T, R1> returning(Class<R1> paramClass)
  {
    return returning(TypeToken.of(paramClass));
  }
  
  static class ConstructorInvokable<T>
    extends Invokable<T, T>
  {
    final Constructor<?> constructor;
    
    ConstructorInvokable(Constructor<?> paramConstructor)
    {
      super();
      this.constructor = paramConstructor;
    }
    
    private boolean mayNeedHiddenThis()
    {
      Class localClass = this.constructor.getDeclaringClass();
      if (localClass.getEnclosingConstructor() != null) {}
      do
      {
        Method localMethod;
        do
        {
          return true;
          localMethod = localClass.getEnclosingMethod();
          if (localMethod == null) {
            break;
          }
        } while (!Modifier.isStatic(localMethod.getModifiers()));
        return false;
      } while ((localClass.getEnclosingClass() != null) && (!Modifier.isStatic(localClass.getModifiers())));
      return false;
    }
    
    Type[] getGenericExceptionTypes()
    {
      return this.constructor.getGenericExceptionTypes();
    }
    
    Type[] getGenericParameterTypes()
    {
      Type[] arrayOfType2 = this.constructor.getGenericParameterTypes();
      Type[] arrayOfType1 = arrayOfType2;
      if (arrayOfType2.length > 0)
      {
        arrayOfType1 = arrayOfType2;
        if (mayNeedHiddenThis())
        {
          Class[] arrayOfClass = this.constructor.getParameterTypes();
          arrayOfType1 = arrayOfType2;
          if (arrayOfType2.length == arrayOfClass.length)
          {
            arrayOfType1 = arrayOfType2;
            if (arrayOfClass[0] == getDeclaringClass().getEnclosingClass()) {
              arrayOfType1 = (Type[])Arrays.copyOfRange(arrayOfType2, 1, arrayOfType2.length);
            }
          }
        }
      }
      return arrayOfType1;
    }
    
    Type getGenericReturnType()
    {
      Class localClass = getDeclaringClass();
      TypeVariable[] arrayOfTypeVariable = localClass.getTypeParameters();
      Object localObject = localClass;
      if (arrayOfTypeVariable.length > 0) {
        localObject = Types.newParameterizedType(localClass, arrayOfTypeVariable);
      }
      return localObject;
    }
    
    final Annotation[][] getParameterAnnotations()
    {
      return this.constructor.getParameterAnnotations();
    }
    
    public final TypeVariable<?>[] getTypeParameters()
    {
      TypeVariable[] arrayOfTypeVariable1 = getDeclaringClass().getTypeParameters();
      TypeVariable[] arrayOfTypeVariable2 = this.constructor.getTypeParameters();
      TypeVariable[] arrayOfTypeVariable3 = new TypeVariable[arrayOfTypeVariable1.length + arrayOfTypeVariable2.length];
      System.arraycopy(arrayOfTypeVariable1, 0, arrayOfTypeVariable3, 0, arrayOfTypeVariable1.length);
      System.arraycopy(arrayOfTypeVariable2, 0, arrayOfTypeVariable3, arrayOfTypeVariable1.length, arrayOfTypeVariable2.length);
      return arrayOfTypeVariable3;
    }
    
    final Object invokeInternal(@Nullable Object paramObject, Object[] paramArrayOfObject)
      throws InvocationTargetException, IllegalAccessException
    {
      try
      {
        paramObject = this.constructor.newInstance(paramArrayOfObject);
        return paramObject;
      }
      catch (InstantiationException paramObject)
      {
        throw new RuntimeException(this.constructor + " failed.", paramObject);
      }
    }
    
    public final boolean isOverridable()
    {
      return false;
    }
    
    public final boolean isVarArgs()
    {
      return this.constructor.isVarArgs();
    }
  }
  
  static class MethodInvokable<T>
    extends Invokable<T, Object>
  {
    final Method method;
    
    MethodInvokable(Method paramMethod)
    {
      super();
      this.method = paramMethod;
    }
    
    Type[] getGenericExceptionTypes()
    {
      return this.method.getGenericExceptionTypes();
    }
    
    Type[] getGenericParameterTypes()
    {
      return this.method.getGenericParameterTypes();
    }
    
    Type getGenericReturnType()
    {
      return this.method.getGenericReturnType();
    }
    
    final Annotation[][] getParameterAnnotations()
    {
      return this.method.getParameterAnnotations();
    }
    
    public final TypeVariable<?>[] getTypeParameters()
    {
      return this.method.getTypeParameters();
    }
    
    final Object invokeInternal(@Nullable Object paramObject, Object[] paramArrayOfObject)
      throws InvocationTargetException, IllegalAccessException
    {
      return this.method.invoke(paramObject, paramArrayOfObject);
    }
    
    public final boolean isOverridable()
    {
      return (!isFinal()) && (!isPrivate()) && (!isStatic()) && (!Modifier.isFinal(getDeclaringClass().getModifiers()));
    }
    
    public final boolean isVarArgs()
    {
      return this.method.isVarArgs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.Invokable
 * JD-Core Version:    0.7.0.1
 */