package com.tencent.turingfd.sdk.qps;

import com.tencent.token.ahr;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;

public final class switch
{
  public static final Type[] a = new Type[0];
  
  public static Type a(Type paramType)
  {
    if ((paramType instanceof Class))
    {
      Class localClass = (Class)paramType;
      paramType = localClass;
      if (localClass.isArray()) {
        paramType = new do(a(localClass.getComponentType()));
      }
      return paramType;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      return new if(paramType.getOwnerType(), paramType.getRawType(), paramType.getActualTypeArguments());
    }
    if ((paramType instanceof GenericArrayType)) {
      return new do(((GenericArrayType)paramType).getGenericComponentType());
    }
    if ((paramType instanceof WildcardType))
    {
      paramType = (WildcardType)paramType;
      return new for(paramType.getUpperBounds(), paramType.getLowerBounds());
    }
    return paramType;
  }
  
  public static Type a(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    Type localType = paramType;
    if ((paramType instanceof WildcardType)) {
      localType = ((WildcardType)paramType).getUpperBounds()[0];
    }
    ahr.a(paramClass2.isAssignableFrom(paramClass1));
    return a(localType, paramClass1, b(localType, paramClass1, paramClass2));
  }
  
  public static Type a(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    return a(paramType1, paramClass, paramType2, new HashSet());
  }
  
  private static Type a(Type paramType1, Class<?> paramClass, Type paramType2, Collection<TypeVariable> paramCollection)
  {
    int k;
    int i;
    Object localObject2;
    int j;
    label157:
    do
    {
      boolean bool = paramType2 instanceof TypeVariable;
      k = 0;
      i = 0;
      if (!bool) {
        break;
      }
      localObject2 = (TypeVariable)paramType2;
      if (paramCollection.contains(localObject2)) {
        return paramType2;
      }
      paramCollection.add(localObject2);
      paramType2 = ((TypeVariable)localObject2).getGenericDeclaration();
      if ((paramType2 instanceof Class)) {
        paramType2 = (Class)paramType2;
      } else {
        paramType2 = null;
      }
      if (paramType2 != null)
      {
        localObject1 = b(paramType1, paramClass, paramType2);
        if ((localObject1 instanceof ParameterizedType))
        {
          paramType2 = paramType2.getTypeParameters();
          j = paramType2.length;
          while (i < j)
          {
            if (localObject2.equals(paramType2[i]))
            {
              localObject1 = ((ParameterizedType)localObject1).getActualTypeArguments()[i];
              break label157;
            }
            i += 1;
          }
          throw new NoSuchElementException();
        }
      }
      localObject1 = localObject2;
      paramType2 = (Type)localObject1;
    } while (localObject1 != localObject2);
    return localObject1;
    if ((paramType2 instanceof Class))
    {
      localObject1 = (Class)paramType2;
      if (((Class)localObject1).isArray())
      {
        paramType2 = ((Class)localObject1).getComponentType();
        paramClass = a(paramType1, paramClass, paramType2, paramCollection);
        paramType1 = (Type)localObject1;
        if (paramType2 != paramClass) {
          paramType1 = new do(paramClass);
        }
        return paramType1;
      }
    }
    if ((paramType2 instanceof GenericArrayType))
    {
      paramType2 = (GenericArrayType)paramType2;
      localObject1 = paramType2.getGenericComponentType();
      paramClass = a(paramType1, paramClass, (Type)localObject1, paramCollection);
      paramType1 = paramType2;
      if (localObject1 != paramClass) {
        paramType1 = new do(paramClass);
      }
      return paramType1;
    }
    Object localObject3;
    if ((paramType2 instanceof ParameterizedType))
    {
      localObject2 = (ParameterizedType)paramType2;
      paramType2 = ((ParameterizedType)localObject2).getOwnerType();
      localObject3 = a(paramType1, paramClass, paramType2, paramCollection);
      if (localObject3 != paramType2) {
        i = 1;
      } else {
        i = 0;
      }
      paramType2 = ((ParameterizedType)localObject2).getActualTypeArguments();
      int m = paramType2.length;
      while (k < m)
      {
        Type localType = a(paramType1, paramClass, paramType2[k], paramCollection);
        j = i;
        localObject1 = paramType2;
        if (localType != paramType2[k])
        {
          j = i;
          localObject1 = paramType2;
          if (i == 0)
          {
            localObject1 = (Type[])paramType2.clone();
            j = 1;
          }
          localObject1[k] = localType;
        }
        k += 1;
        i = j;
        paramType2 = (Type)localObject1;
      }
      paramType1 = (Type)localObject2;
      if (i != 0) {
        paramType1 = new if((Type)localObject3, ((ParameterizedType)localObject2).getRawType(), paramType2);
      }
      return paramType1;
    }
    Object localObject1 = paramType2;
    if ((paramType2 instanceof WildcardType))
    {
      paramType2 = (WildcardType)paramType2;
      localObject3 = paramType2.getLowerBounds();
      localObject2 = paramType2.getUpperBounds();
      if (localObject3.length == 1)
      {
        paramType1 = a(paramType1, paramClass, localObject3[0], paramCollection);
        localObject1 = paramType2;
        if (paramType1 != localObject3[0])
        {
          if ((paramType1 instanceof WildcardType)) {
            paramType1 = ((WildcardType)paramType1).getLowerBounds();
          } else {
            paramType1 = new Type[] { paramType1 };
          }
          return new for(new Type[] { Object.class }, paramType1);
        }
      }
      else
      {
        localObject1 = paramType2;
        if (localObject2.length == 1) {
          localObject1 = localObject2[0];
        }
      }
    }
    try
    {
      paramType1 = a(paramType1, paramClass, (Type)localObject1, paramCollection);
      localObject1 = paramType2;
      if (paramType1 != localObject2[0])
      {
        if ((paramType1 instanceof WildcardType)) {
          paramType1 = ((WildcardType)paramType1).getUpperBounds();
        } else {
          paramType1 = new Type[] { paramType1 };
        }
        return new for(paramType1, a);
      }
      return localObject1;
    }
    catch (Throwable paramType1)
    {
      throw paramType1;
    }
  }
  
  public static boolean a(Type paramType1, Type paramType2)
  {
    for (;;)
    {
      if (paramType1 == paramType2) {
        return true;
      }
      if ((paramType1 instanceof Class)) {
        return paramType1.equals(paramType2);
      }
      if ((paramType1 instanceof ParameterizedType))
      {
        if (!(paramType2 instanceof ParameterizedType)) {
          return false;
        }
        paramType1 = (ParameterizedType)paramType1;
        paramType2 = (ParameterizedType)paramType2;
        Type localType1 = paramType1.getOwnerType();
        Type localType2 = paramType2.getOwnerType();
        int i;
        if ((localType1 != localType2) && ((localType1 == null) || (!localType1.equals(localType2)))) {
          i = 0;
        } else {
          i = 1;
        }
        return (i != 0) && (paramType1.getRawType().equals(paramType2.getRawType())) && (Arrays.equals(paramType1.getActualTypeArguments(), paramType2.getActualTypeArguments()));
      }
      if (!(paramType1 instanceof GenericArrayType)) {
        break;
      }
      if (!(paramType2 instanceof GenericArrayType)) {
        return false;
      }
      paramType1 = (GenericArrayType)paramType1;
      paramType2 = (GenericArrayType)paramType2;
      paramType1 = paramType1.getGenericComponentType();
      paramType2 = paramType2.getGenericComponentType();
    }
    if ((paramType1 instanceof WildcardType))
    {
      if (!(paramType2 instanceof WildcardType)) {
        return false;
      }
      paramType1 = (WildcardType)paramType1;
      paramType2 = (WildcardType)paramType2;
      return (Arrays.equals(paramType1.getUpperBounds(), paramType2.getUpperBounds())) && (Arrays.equals(paramType1.getLowerBounds(), paramType2.getLowerBounds()));
    }
    if ((paramType1 instanceof TypeVariable))
    {
      if (!(paramType2 instanceof TypeVariable)) {
        return false;
      }
      paramType1 = (TypeVariable)paramType1;
      paramType2 = (TypeVariable)paramType2;
      if ((paramType1.getGenericDeclaration() == paramType2.getGenericDeclaration()) && (paramType1.getName().equals(paramType2.getName()))) {
        return true;
      }
    }
    return false;
  }
  
  public static Class<?> b(Type paramType)
  {
    for (;;)
    {
      if ((paramType instanceof Class)) {
        return (Class)paramType;
      }
      if ((paramType instanceof ParameterizedType))
      {
        paramType = ((ParameterizedType)paramType).getRawType();
        ahr.a(paramType instanceof Class);
        return (Class)paramType;
      }
      if ((paramType instanceof GenericArrayType)) {
        return Array.newInstance(b(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
      }
      if ((paramType instanceof TypeVariable)) {
        return Object.class;
      }
      if (!(paramType instanceof WildcardType)) {
        break;
      }
      paramType = ((WildcardType)paramType).getUpperBounds()[0];
    }
    String str;
    if (paramType == null) {
      str = "null";
    } else {
      str = paramType.getClass().getName();
    }
    StringBuilder localStringBuilder = new StringBuilder("Expected a Class, ParameterizedType, or GenericArrayType, but <");
    localStringBuilder.append(paramType);
    localStringBuilder.append("> is of type ");
    localStringBuilder.append(str);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static Type b(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == paramClass1) {
      return paramType;
    }
    if (paramClass2.isInterface())
    {
      Class[] arrayOfClass = paramClass1.getInterfaces();
      int i = 0;
      int j = arrayOfClass.length;
      for (;;)
      {
        if (i >= j) {
          break label81;
        }
        if (arrayOfClass[i] == paramClass2) {
          return paramClass1.getGenericInterfaces()[i];
        }
        if (paramClass2.isAssignableFrom(arrayOfClass[i]))
        {
          paramType = paramClass1.getGenericInterfaces()[i];
          paramClass1 = arrayOfClass[i];
          break;
        }
        i += 1;
      }
    }
    label81:
    if (!paramClass1.isInterface()) {
      for (paramType = paramClass1;; paramType = paramClass1)
      {
        if (paramType == Object.class) {
          return paramClass2;
        }
        paramClass1 = paramType.getSuperclass();
        if (paramClass1 == paramClass2) {
          return paramType.getGenericSuperclass();
        }
        if (paramClass2.isAssignableFrom(paramClass1))
        {
          paramType = paramType.getGenericSuperclass();
          break;
        }
      }
    }
    return paramClass2;
  }
  
  public static String c(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return ((Class)paramType).getName();
    }
    return paramType.toString();
  }
  
  public static void d(Type paramType)
  {
    boolean bool;
    if (((paramType instanceof Class)) && (((Class)paramType).isPrimitive())) {
      bool = false;
    } else {
      bool = true;
    }
    ahr.a(bool);
  }
  
  public static final class do
    implements Serializable, GenericArrayType
  {
    public final Type a;
    
    public do(Type paramType)
    {
      this.a = switch.a(paramType);
    }
    
    public final boolean equals(Object paramObject)
    {
      return ((paramObject instanceof GenericArrayType)) && (switch.a(this, (GenericArrayType)paramObject));
    }
    
    public final Type getGenericComponentType()
    {
      return this.a;
    }
    
    public final int hashCode()
    {
      return this.a.hashCode();
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(switch.c(this.a));
      localStringBuilder.append("[]");
      return localStringBuilder.toString();
    }
  }
  
  public static final class for
    implements Serializable, WildcardType
  {
    public final Type a;
    public final Type b;
    
    public for(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      int i = paramArrayOfType2.length;
      boolean bool2 = true;
      boolean bool1;
      if (i <= 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ahr.a(bool1);
      if (paramArrayOfType1.length == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ahr.a(bool1);
      if (paramArrayOfType2.length == 1)
      {
        ahr.a(paramArrayOfType2[0]);
        switch.d(paramArrayOfType2[0]);
        if (paramArrayOfType1[0] == Object.class) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        ahr.a(bool1);
        this.b = switch.a(paramArrayOfType2[0]);
        this.a = Object.class;
        return;
      }
      ahr.a(paramArrayOfType1[0]);
      switch.d(paramArrayOfType1[0]);
      this.b = null;
      this.a = switch.a(paramArrayOfType1[0]);
    }
    
    public final boolean equals(Object paramObject)
    {
      return ((paramObject instanceof WildcardType)) && (switch.a(this, (WildcardType)paramObject));
    }
    
    public final Type[] getLowerBounds()
    {
      Type localType = this.b;
      if (localType != null) {
        return new Type[] { localType };
      }
      return switch.a;
    }
    
    public final Type[] getUpperBounds()
    {
      return new Type[] { this.a };
    }
    
    public final int hashCode()
    {
      Type localType = this.b;
      int i;
      if (localType != null) {
        i = localType.hashCode() + 31;
      } else {
        i = 1;
      }
      return i ^ this.a.hashCode() + 31;
    }
    
    public final String toString()
    {
      if (this.b != null)
      {
        localStringBuilder = new StringBuilder("? super ");
        localStringBuilder.append(switch.c(this.b));
        return localStringBuilder.toString();
      }
      if (this.a == Object.class) {
        return "?";
      }
      StringBuilder localStringBuilder = new StringBuilder("? extends ");
      localStringBuilder.append(switch.c(this.a));
      return localStringBuilder.toString();
    }
  }
  
  public static final class if
    implements Serializable, ParameterizedType
  {
    public final Type a;
    public final Type b;
    public final Type[] c;
    
    public if(Type paramType1, Type paramType2, Type... paramVarArgs)
    {
      boolean bool1 = paramType2 instanceof Class;
      int j = 0;
      if (bool1)
      {
        Class localClass = (Class)paramType2;
        bool1 = Modifier.isStatic(localClass.getModifiers());
        boolean bool2 = true;
        if ((!bool1) && (localClass.getEnclosingClass() != null)) {
          i = 0;
        } else {
          i = 1;
        }
        bool1 = bool2;
        if (paramType1 == null)
        {
          bool1 = bool2;
          if (i == 0) {
            bool1 = false;
          }
        }
        ahr.a(bool1);
      }
      if (paramType1 == null) {
        paramType1 = null;
      } else {
        paramType1 = switch.a(paramType1);
      }
      this.a = paramType1;
      this.b = switch.a(paramType2);
      paramType1 = (Type[])paramVarArgs.clone();
      this.c = paramType1;
      int k = paramType1.length;
      int i = j;
      while (i < k)
      {
        ahr.a(this.c[i]);
        switch.d(this.c[i]);
        paramType1 = this.c;
        paramType1[i] = switch.a(paramType1[i]);
        i += 1;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      return ((paramObject instanceof ParameterizedType)) && (switch.a(this, (ParameterizedType)paramObject));
    }
    
    public final Type[] getActualTypeArguments()
    {
      return (Type[])this.c.clone();
    }
    
    public final Type getOwnerType()
    {
      return this.a;
    }
    
    public final Type getRawType()
    {
      return this.b;
    }
    
    public final int hashCode()
    {
      int j = Arrays.hashCode(this.c);
      int k = this.b.hashCode();
      Type localType = this.a;
      int i;
      if (localType != null) {
        i = localType.hashCode();
      } else {
        i = 0;
      }
      return j ^ k ^ i;
    }
    
    public final String toString()
    {
      int j = this.c.length;
      if (j == 0) {
        return switch.c(this.b);
      }
      StringBuilder localStringBuilder = new StringBuilder((j + 1) * 30);
      localStringBuilder.append(switch.c(this.b));
      localStringBuilder.append("<");
      localStringBuilder.append(switch.c(this.c[0]));
      int i = 1;
      while (i < j)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(switch.c(this.c[i]));
        i += 1;
      }
      localStringBuilder.append(">");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.switch
 * JD-Core Version:    0.7.0.1
 */