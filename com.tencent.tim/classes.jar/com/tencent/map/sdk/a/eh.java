package com.tencent.map.sdk.a;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class eh
{
  static final Type[] a = new Type[0];
  
  private static int a(Object[] paramArrayOfObject, Object paramObject)
  {
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      if (paramObject.equals(paramArrayOfObject[i])) {
        return i;
      }
      i += 1;
    }
    throw new NoSuchElementException();
  }
  
  private static Class<?> a(TypeVariable<?> paramTypeVariable)
  {
    paramTypeVariable = paramTypeVariable.getGenericDeclaration();
    if ((paramTypeVariable instanceof Class)) {
      return (Class)paramTypeVariable;
    }
    return null;
  }
  
  private static ParameterizedType a(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    return new b(paramType1, paramType2, paramVarArgs);
  }
  
  public static Type a(Type paramType)
  {
    if ((paramType instanceof Class))
    {
      paramType = (Class)paramType;
      if (paramType.isArray()) {
        paramType = new a(a(paramType.getComponentType()));
      }
      for (;;)
      {
        return (Type)paramType;
      }
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      return new b(paramType.getOwnerType(), paramType.getRawType(), paramType.getActualTypeArguments());
    }
    if ((paramType instanceof GenericArrayType)) {
      return new a(((GenericArrayType)paramType).getGenericComponentType());
    }
    if ((paramType instanceof WildcardType))
    {
      paramType = (WildcardType)paramType;
      return new c(paramType.getUpperBounds(), paramType.getLowerBounds());
    }
    return paramType;
  }
  
  public static Type a(Type paramType, Class<?> paramClass)
  {
    paramClass = b(paramType, paramClass, Collection.class);
    paramType = paramClass;
    if ((paramClass instanceof WildcardType)) {
      paramType = ((WildcardType)paramClass).getUpperBounds()[0];
    }
    if ((paramType instanceof ParameterizedType)) {
      return ((ParameterizedType)paramType).getActualTypeArguments()[0];
    }
    return Object.class;
  }
  
  private static Type a(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    Object localObject = paramClass1;
    paramClass1 = paramType;
    paramType = (Type)localObject;
    if (paramClass2 == paramType) {}
    label13:
    label89:
    do
    {
      return paramClass1;
      if (paramClass2.isInterface())
      {
        localObject = paramType.getInterfaces();
        int i = 0;
        int j = localObject.length;
        for (;;)
        {
          if (i >= j) {
            break label89;
          }
          if (localObject[i] == paramClass2) {
            return paramType.getGenericInterfaces()[i];
          }
          if (paramClass2.isAssignableFrom(localObject[i]))
          {
            paramClass1 = paramType.getGenericInterfaces()[i];
            paramType = localObject[i];
            break;
          }
          i += 1;
        }
      }
      paramClass1 = paramClass2;
    } while (paramType.isInterface());
    for (;;)
    {
      paramClass1 = paramClass2;
      if (paramType == Object.class) {
        break label13;
      }
      paramClass1 = paramType.getSuperclass();
      if (paramClass1 == paramClass2) {
        return paramType.getGenericSuperclass();
      }
      if (paramClass2.isAssignableFrom(paramClass1))
      {
        localObject = paramType.getGenericSuperclass();
        paramType = paramClass1;
        paramClass1 = (Class<?>)localObject;
        break;
      }
      paramType = paramClass1;
    }
  }
  
  public static Type a(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    Object localObject1 = paramType2;
    if ((localObject1 instanceof TypeVariable))
    {
      localObject1 = (TypeVariable)localObject1;
      paramType2 = a(paramType1, paramClass, (TypeVariable)localObject1);
      if (paramType2 != localObject1) {}
    }
    label90:
    Object localObject3;
    label131:
    label292:
    label361:
    do
    {
      do
      {
        Object localObject2;
        do
        {
          do
          {
            int i;
            do
            {
              do
              {
                do
                {
                  return paramType2;
                  localObject1 = paramType2;
                  break;
                  if ((!(localObject1 instanceof Class)) || (!((Class)localObject1).isArray())) {
                    break label90;
                  }
                  paramType2 = (Class)localObject1;
                  localObject1 = paramType2.getComponentType();
                  paramType1 = a(paramType1, paramClass, (Type)localObject1);
                } while (localObject1 == paramType1);
                return f(paramType1);
                if (!(localObject1 instanceof GenericArrayType)) {
                  break label131;
                }
                paramType2 = (GenericArrayType)localObject1;
                localObject1 = paramType2.getGenericComponentType();
                paramType1 = a(paramType1, paramClass, (Type)localObject1);
              } while (localObject1 == paramType1);
              return f(paramType1);
              if (!(localObject1 instanceof ParameterizedType)) {
                break label292;
              }
              localObject2 = (ParameterizedType)localObject1;
              paramType2 = ((ParameterizedType)localObject2).getOwnerType();
              localObject3 = a(paramType1, paramClass, paramType2);
              if (localObject3 != paramType2) {}
              for (i = 1;; i = 0)
              {
                localObject1 = ((ParameterizedType)localObject2).getActualTypeArguments();
                int m = localObject1.length;
                int k = 0;
                while (k < m)
                {
                  Type localType = a(paramType1, paramClass, localObject1[k]);
                  paramType2 = (Type)localObject1;
                  int j = i;
                  if (localType != localObject1[k])
                  {
                    paramType2 = (Type)localObject1;
                    j = i;
                    if (i == 0)
                    {
                      paramType2 = (Type[])((Type[])localObject1).clone();
                      j = 1;
                    }
                    paramType2[k] = localType;
                  }
                  k += 1;
                  localObject1 = paramType2;
                  i = j;
                }
              }
              paramType2 = (Type)localObject2;
            } while (i == 0);
            return a((Type)localObject3, ((ParameterizedType)localObject2).getRawType(), (Type[])localObject1);
            paramType2 = (Type)localObject1;
          } while (!(localObject1 instanceof WildcardType));
          localObject1 = (WildcardType)localObject1;
          localObject2 = ((WildcardType)localObject1).getLowerBounds();
          localObject3 = ((WildcardType)localObject1).getUpperBounds();
          if (localObject2.length != 1) {
            break label361;
          }
          paramType1 = a(paramType1, paramClass, localObject2[0]);
          paramType2 = (Type)localObject1;
        } while (paramType1 == localObject2[0]);
        return h(paramType1);
        paramType2 = (Type)localObject1;
      } while (localObject3.length != 1);
      paramType1 = a(paramType1, paramClass, localObject3[0]);
      paramType2 = (Type)localObject1;
    } while (paramType1 == localObject3[0]);
    return g(paramType1);
  }
  
  private static Type a(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Class localClass = a(paramTypeVariable);
    if (localClass == null) {}
    do
    {
      return paramTypeVariable;
      paramType = a(paramType, paramClass, localClass);
    } while (!(paramType instanceof ParameterizedType));
    int i = a(localClass.getTypeParameters(), paramTypeVariable);
    return ((ParameterizedType)paramType).getActualTypeArguments()[i];
  }
  
  public static boolean a(Type paramType1, Type paramType2)
  {
    Type localType1 = paramType1;
    for (paramType1 = paramType2;; paramType1 = paramType1.getGenericComponentType())
    {
      if (localType1 == paramType1) {
        return true;
      }
      if ((localType1 instanceof Class)) {
        return localType1.equals(paramType1);
      }
      if ((localType1 instanceof ParameterizedType))
      {
        if (!(paramType1 instanceof ParameterizedType)) {
          return false;
        }
        paramType2 = (ParameterizedType)localType1;
        paramType1 = (ParameterizedType)paramType1;
        localType1 = paramType2.getOwnerType();
        Type localType2 = paramType1.getOwnerType();
        if ((localType1 == localType2) || ((localType1 != null) && (localType1.equals(localType2)))) {}
        for (int i = 1; (i != 0) && (paramType2.getRawType().equals(paramType1.getRawType())) && (Arrays.equals(paramType2.getActualTypeArguments(), paramType1.getActualTypeArguments())); i = 0) {
          return true;
        }
        return false;
      }
      if (!(localType1 instanceof GenericArrayType)) {
        break;
      }
      if (!(paramType1 instanceof GenericArrayType)) {
        return false;
      }
      paramType2 = (GenericArrayType)localType1;
      paramType1 = (GenericArrayType)paramType1;
      localType1 = paramType2.getGenericComponentType();
    }
    if ((localType1 instanceof WildcardType))
    {
      if (!(paramType1 instanceof WildcardType)) {
        return false;
      }
      paramType2 = (WildcardType)localType1;
      paramType1 = (WildcardType)paramType1;
      return (Arrays.equals(paramType2.getUpperBounds(), paramType1.getUpperBounds())) && (Arrays.equals(paramType2.getLowerBounds(), paramType1.getLowerBounds()));
    }
    if ((localType1 instanceof TypeVariable))
    {
      if (!(paramType1 instanceof TypeVariable)) {
        return false;
      }
      paramType2 = (TypeVariable)localType1;
      paramType1 = (TypeVariable)paramType1;
      return (paramType2.getGenericDeclaration() == paramType1.getGenericDeclaration()) && (paramType2.getName().equals(paramType1.getName()));
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
        eg.a(paramType instanceof Class);
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
    if (paramType == null) {}
    for (String str = "null";; str = paramType.getClass().getName()) {
      throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + paramType + "> is of type " + str);
    }
  }
  
  private static Type b(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    eg.a(paramClass2.isAssignableFrom(paramClass1));
    return a(paramType, paramClass1, a(paramType, paramClass1, paramClass2));
  }
  
  public static Type[] b(Type paramType, Class<?> paramClass)
  {
    if (paramType == Properties.class) {
      return new Type[] { String.class, String.class };
    }
    paramType = b(paramType, paramClass, Map.class);
    if ((paramType instanceof ParameterizedType)) {
      return ((ParameterizedType)paramType).getActualTypeArguments();
    }
    return new Type[] { Object.class, Object.class };
  }
  
  public static String c(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return ((Class)paramType).getName();
    }
    return paramType.toString();
  }
  
  public static Type d(Type paramType)
  {
    if ((paramType instanceof GenericArrayType)) {
      return ((GenericArrayType)paramType).getGenericComponentType();
    }
    return ((Class)paramType).getComponentType();
  }
  
  private static GenericArrayType f(Type paramType)
  {
    return new a(paramType);
  }
  
  private static WildcardType g(Type paramType)
  {
    Type[] arrayOfType = a;
    return new c(new Type[] { paramType }, arrayOfType);
  }
  
  private static WildcardType h(Type paramType)
  {
    return new c(new Type[] { Object.class }, new Type[] { paramType });
  }
  
  static final class a
    implements Serializable, GenericArrayType
  {
    private final Type a;
    
    public a(Type paramType)
    {
      this.a = eh.a(paramType);
    }
    
    public final boolean equals(Object paramObject)
    {
      return ((paramObject instanceof GenericArrayType)) && (eh.a(this, (GenericArrayType)paramObject));
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
      return eh.c(this.a) + "[]";
    }
  }
  
  static final class b
    implements Serializable, ParameterizedType
  {
    private final Type a;
    private final Type b;
    private final Type[] c;
    
    public b(Type paramType1, Type paramType2, Type... paramVarArgs)
    {
      boolean bool1;
      if ((paramType2 instanceof Class))
      {
        Class localClass = (Class)paramType2;
        if ((paramType1 != null) || (localClass.getEnclosingClass() == null))
        {
          bool1 = true;
          eg.a(bool1);
          bool1 = bool2;
          if (paramType1 != null)
          {
            if (localClass.getEnclosingClass() == null) {
              break label160;
            }
            bool1 = bool2;
          }
          label63:
          eg.a(bool1);
        }
      }
      else
      {
        if (paramType1 != null) {
          break label166;
        }
      }
      label160:
      label166:
      for (paramType1 = null;; paramType1 = eh.a(paramType1))
      {
        this.a = paramType1;
        this.b = eh.a(paramType2);
        this.c = ((Type[])paramVarArgs.clone());
        while (i < this.c.length)
        {
          eg.a(this.c[i]);
          eh.e(this.c[i]);
          paramType1 = this.c;
          paramType1[i] = eh.a(paramType1[i]);
          i += 1;
        }
        bool1 = false;
        break;
        bool1 = false;
        break label63;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      return ((paramObject instanceof ParameterizedType)) && (eh.a(this, (ParameterizedType)paramObject));
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
      return Arrays.hashCode(this.c) ^ this.b.hashCode() ^ eh.a(this.a);
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder((this.c.length + 1) * 30);
      localStringBuilder.append(eh.c(this.b));
      if (this.c.length == 0) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append("<").append(eh.c(this.c[0]));
      int i = 1;
      while (i < this.c.length)
      {
        localStringBuilder.append(", ").append(eh.c(this.c[i]));
        i += 1;
      }
      return ">";
    }
  }
  
  static final class c
    implements Serializable, WildcardType
  {
    private final Type a;
    private final Type b;
    
    public c(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      if (paramArrayOfType2.length <= 1)
      {
        bool1 = true;
        eg.a(bool1);
        if (paramArrayOfType1.length != 1) {
          break label87;
        }
        bool1 = true;
        label27:
        eg.a(bool1);
        if (paramArrayOfType2.length != 1) {
          break label97;
        }
        eg.a(paramArrayOfType2[0]);
        eh.e(paramArrayOfType2[0]);
        if (paramArrayOfType1[0] != Object.class) {
          break label92;
        }
      }
      label87:
      label92:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        eg.a(bool1);
        this.b = eh.a(paramArrayOfType2[0]);
        this.a = Object.class;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label27;
      }
      label97:
      eg.a(paramArrayOfType1[0]);
      eh.e(paramArrayOfType1[0]);
      this.b = null;
      this.a = eh.a(paramArrayOfType1[0]);
    }
    
    public final boolean equals(Object paramObject)
    {
      return ((paramObject instanceof WildcardType)) && (eh.a(this, (WildcardType)paramObject));
    }
    
    public final Type[] getLowerBounds()
    {
      if (this.b != null) {
        return new Type[] { this.b };
      }
      return eh.a;
    }
    
    public final Type[] getUpperBounds()
    {
      return new Type[] { this.a };
    }
    
    public final int hashCode()
    {
      if (this.b != null) {}
      for (int i = this.b.hashCode() + 31;; i = 1) {
        return i ^ this.a.hashCode() + 31;
      }
    }
    
    public final String toString()
    {
      if (this.b != null) {
        return "? super " + eh.c(this.b);
      }
      if (this.a == Object.class) {
        return "?";
      }
      return "? extends " + eh.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.eh
 * JD-Core Version:    0.7.0.1
 */