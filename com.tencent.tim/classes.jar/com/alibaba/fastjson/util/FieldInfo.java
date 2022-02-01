package com.alibaba.fastjson.util;

import com.alibaba.fastjson.annotation.JSONField;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class FieldInfo
  implements Comparable<FieldInfo>
{
  public final Class<?> declaringClass;
  public final Field field;
  public final boolean fieldAccess;
  private final JSONField fieldAnnotation;
  public final Class<?> fieldClass;
  public final boolean fieldTransient;
  public final Type fieldType;
  public final String format;
  public final boolean getOnly;
  public final boolean isEnum;
  public final Method method;
  private final JSONField methodAnnotation;
  public final String name;
  public final long nameHashCode;
  private int ordinal = 0;
  
  public FieldInfo(String paramString, Class<?> paramClass1, Class<?> paramClass2, Type paramType, Field paramField, int paramInt1, int paramInt2)
  {
    this.name = paramString;
    this.declaringClass = paramClass1;
    this.fieldClass = paramClass2;
    this.fieldType = paramType;
    this.method = null;
    this.field = paramField;
    this.ordinal = paramInt1;
    this.isEnum = paramClass2.isEnum();
    this.fieldAnnotation = null;
    this.methodAnnotation = null;
    boolean bool;
    if (paramField != null)
    {
      paramInt1 = paramField.getModifiers();
      if (((paramInt1 & 0x1) != 0) || (this.method == null))
      {
        bool = true;
        this.fieldAccess = bool;
      }
    }
    long l;
    for (this.fieldTransient = Modifier.isTransient(paramInt1);; this.fieldTransient = false)
    {
      this.getOnly = false;
      l = -2128831035L;
      paramInt1 = paramInt2;
      while (paramInt1 < paramString.length())
      {
        l = (l ^ paramString.charAt(paramInt1)) * 16777619L;
        paramInt1 += 1;
      }
      bool = false;
      break;
      this.fieldAccess = false;
    }
    this.nameHashCode = l;
    this.format = null;
  }
  
  public FieldInfo(String paramString, Method paramMethod, Field paramField, Class<?> paramClass, Type paramType, int paramInt1, int paramInt2, JSONField paramJSONField1, JSONField paramJSONField2, boolean paramBoolean)
  {
    this.name = paramString;
    this.method = paramMethod;
    this.field = paramField;
    this.ordinal = paramInt1;
    this.methodAnnotation = paramJSONField1;
    this.fieldAnnotation = paramJSONField2;
    paramJSONField2 = getAnnotation();
    paramJSONField1 = null;
    if (paramJSONField2 != null)
    {
      paramJSONField2 = paramJSONField2.format();
      paramJSONField1 = paramJSONField2;
      if (paramJSONField2.trim().length() == 0) {
        paramJSONField1 = null;
      }
    }
    this.format = paramJSONField1;
    boolean bool;
    if (paramField != null)
    {
      paramInt1 = paramField.getModifiers();
      if ((paramMethod == null) || (((paramInt1 & 0x1) != 0) && (paramMethod.getReturnType() == paramField.getType())))
      {
        bool = true;
        this.fieldAccess = bool;
        if ((paramInt1 & 0x80) == 0) {
          break label196;
        }
        bool = true;
      }
    }
    label142:
    long l;
    for (this.fieldTransient = bool;; this.fieldTransient = false)
    {
      l = -2128831035L;
      paramInt1 = 0;
      while (paramInt1 < paramString.length())
      {
        l = (l ^ paramString.charAt(paramInt1)) * 16777619L;
        paramInt1 += 1;
      }
      bool = false;
      break;
      label196:
      bool = false;
      break label142;
      this.fieldAccess = false;
    }
    this.nameHashCode = l;
    if (paramMethod != null)
    {
      paramString = paramMethod.getParameterTypes();
      if (paramString.length == 1)
      {
        paramField = paramString[0];
        if ((paramField == Class.class) || (paramField == String.class) || (paramField.isPrimitive())) {
          paramString = paramField;
        }
        for (;;)
        {
          this.getOnly = false;
          this.declaringClass = paramMethod.getDeclaringClass();
          paramMethod = paramString;
          paramString = paramField;
          if ((paramClass == null) || (paramString != Object.class) || (!(paramMethod instanceof TypeVariable))) {
            break;
          }
          paramField = getInheritGenericType(paramClass, (TypeVariable)paramMethod);
          if (paramField == null) {
            break;
          }
          this.fieldClass = TypeUtils.getClass(paramField);
          this.fieldType = paramField;
          this.isEnum = paramString.isEnum();
          return;
          if (paramBoolean) {
            paramString = paramMethod.getGenericParameterTypes()[0];
          } else {
            paramString = paramField;
          }
        }
      }
      paramField = paramMethod.getReturnType();
      if (paramField == Class.class) {
        paramString = paramField;
      }
      for (;;)
      {
        this.getOnly = true;
        break;
        if (paramBoolean) {
          paramString = paramMethod.getGenericReturnType();
        } else {
          paramString = paramField;
        }
      }
    }
    paramMethod = paramField.getType();
    if ((paramMethod.isPrimitive()) || (paramMethod == String.class) || (paramMethod.isEnum())) {
      paramString = paramMethod;
    }
    for (;;)
    {
      this.declaringClass = paramField.getDeclaringClass();
      this.getOnly = Modifier.isFinal(paramField.getModifiers());
      paramField = paramMethod;
      paramMethod = paramString;
      paramString = paramField;
      break;
      if (paramBoolean) {
        paramString = paramField.getGenericType();
      } else {
        paramString = paramMethod;
      }
    }
    if (!(paramMethod instanceof Class)) {
      if (paramType != null)
      {
        paramField = getFieldType(paramClass, paramType, paramMethod);
        if (paramField == paramMethod) {
          break label568;
        }
        if (!(paramField instanceof ParameterizedType)) {
          break label545;
        }
        paramString = TypeUtils.getClass(paramField);
        paramMethod = paramField;
      }
    }
    for (;;)
    {
      label504:
      this.fieldType = paramMethod;
      this.fieldClass = paramString;
      if ((!paramString.isArray()) && (paramString.isEnum())) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.isEnum = paramBoolean;
        return;
        paramType = paramClass;
        break;
        label545:
        if (!(paramField instanceof Class)) {
          break label568;
        }
        paramString = TypeUtils.getClass(paramField);
        paramMethod = paramField;
        break label504;
      }
      label568:
      paramMethod = paramField;
    }
  }
  
  public static Type getFieldType(Class<?> paramClass, Type paramType1, Type paramType2)
  {
    Object localObject2 = null;
    if ((paramClass == null) || (paramType1 == null)) {}
    Object localObject1;
    int i;
    do
    {
      do
      {
        do
        {
          return paramType2;
          if (!(paramType2 instanceof GenericArrayType)) {
            break;
          }
          localObject1 = ((GenericArrayType)paramType2).getGenericComponentType();
          paramClass = getFieldType(paramClass, paramType1, (Type)localObject1);
        } while (localObject1 == paramClass);
        return Array.newInstance(TypeUtils.getClass(paramClass), 0).getClass();
      } while (!TypeUtils.isGenericParamType(paramType1));
      if ((paramType2 instanceof TypeVariable))
      {
        localObject1 = (ParameterizedType)TypeUtils.getGenericParamType(paramType1);
        localObject3 = TypeUtils.getClass((Type)localObject1);
        localObject4 = (TypeVariable)paramType2;
        i = 0;
        while (i < ((Class)localObject3).getTypeParameters().length)
        {
          if (localObject3.getTypeParameters()[i].getName().equals(((TypeVariable)localObject4).getName())) {
            return localObject1.getActualTypeArguments()[i];
          }
          i += 1;
        }
      }
    } while (!(paramType2 instanceof ParameterizedType));
    Object localObject3 = (ParameterizedType)paramType2;
    Object localObject4 = ((ParameterizedType)localObject3).getActualTypeArguments();
    if ((paramType1 instanceof ParameterizedType))
    {
      localObject1 = (ParameterizedType)paramType1;
      paramType1 = paramClass.getTypeParameters();
    }
    for (;;)
    {
      int j = 0;
      i = 0;
      paramClass = (Class<?>)localObject2;
      for (;;)
      {
        if ((j >= localObject4.length) || (localObject1 == null)) {
          break label362;
        }
        TypeVariable localTypeVariable = localObject4[j];
        localObject2 = paramClass;
        int m = i;
        if ((localTypeVariable instanceof TypeVariable))
        {
          localTypeVariable = (TypeVariable)localTypeVariable;
          int k = 0;
          for (;;)
          {
            localObject2 = paramClass;
            m = i;
            if (k >= paramType1.length) {
              break;
            }
            localObject2 = paramClass;
            if (paramType1[k].getName().equals(localTypeVariable.getName()))
            {
              localObject2 = paramClass;
              if (paramClass == null) {
                localObject2 = ((ParameterizedType)localObject1).getActualTypeArguments();
              }
              localObject4[j] = localObject2[k];
              i = 1;
            }
            k += 1;
            paramClass = (Class<?>)localObject2;
          }
          if (!(paramClass.getGenericSuperclass() instanceof ParameterizedType)) {
            break label390;
          }
          localObject1 = (ParameterizedType)paramClass.getGenericSuperclass();
          paramType1 = paramClass.getSuperclass().getTypeParameters();
          break;
        }
        j += 1;
        paramClass = (Class<?>)localObject2;
        i = m;
      }
      label362:
      if (i == 0) {
        break;
      }
      return new ParameterizedTypeImpl((Type[])localObject4, ((ParameterizedType)localObject3).getOwnerType(), ((ParameterizedType)localObject3).getRawType());
      label390:
      localObject1 = null;
      paramType1 = null;
    }
  }
  
  public static Type getInheritGenericType(Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Object localObject = paramTypeVariable.getGenericDeclaration();
    Type localType1;
    label132:
    do
    {
      localType1 = paramClass.getGenericSuperclass();
      if (localType1 == null) {
        return null;
      }
      if ((localType1 instanceof ParameterizedType))
      {
        paramClass = (ParameterizedType)localType1;
        Type localType2 = paramClass.getRawType();
        int i;
        if ((localObject.equals(localType2)) || (((localObject instanceof Class)) && ((localType2 instanceof Class)) && (((Class)localObject).isAssignableFrom((Class)localType2))))
        {
          i = 1;
          if (i != 0)
          {
            localObject = ((GenericDeclaration)localObject).getTypeParameters();
            paramClass = paramClass.getActualTypeArguments();
            i = 0;
          }
        }
        else
        {
          for (;;)
          {
            if (i >= localObject.length) {
              break label132;
            }
            if (localObject[i] == paramTypeVariable)
            {
              return paramClass[i];
              i = 0;
              break;
            }
            i += 1;
          }
          return null;
        }
      }
      paramClass = TypeUtils.getClass(localType1);
    } while (localType1 != null);
    return null;
  }
  
  public int compareTo(FieldInfo paramFieldInfo)
  {
    if (this.ordinal < paramFieldInfo.ordinal) {
      return -1;
    }
    if (this.ordinal > paramFieldInfo.ordinal) {
      return 1;
    }
    return this.name.compareTo(paramFieldInfo.name);
  }
  
  public boolean equals(FieldInfo paramFieldInfo)
  {
    if (paramFieldInfo == this) {}
    while (compareTo(paramFieldInfo) == 0) {
      return true;
    }
    return false;
  }
  
  public Object get(Object paramObject)
    throws IllegalAccessException, InvocationTargetException
  {
    if (this.fieldAccess) {
      return this.field.get(paramObject);
    }
    return this.method.invoke(paramObject, new Object[0]);
  }
  
  public JSONField getAnnotation()
  {
    if (this.fieldAnnotation != null) {
      return this.fieldAnnotation;
    }
    return this.methodAnnotation;
  }
  
  public void set(Object paramObject1, Object paramObject2)
    throws IllegalAccessException, InvocationTargetException
  {
    if (this.method != null)
    {
      this.method.invoke(paramObject1, new Object[] { paramObject2 });
      return;
    }
    this.field.set(paramObject1, paramObject2);
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.util.FieldInfo
 * JD-Core Version:    0.7.0.1
 */