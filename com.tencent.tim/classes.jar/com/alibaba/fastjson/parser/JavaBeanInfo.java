package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class JavaBeanInfo
{
  final Constructor<?> creatorConstructor;
  final Constructor<?> defaultConstructor;
  final int defaultConstructorParameterSize;
  final Method factoryMethod;
  final FieldInfo[] fields;
  final JSONType jsonType;
  boolean ordered = false;
  public final int parserFeatures;
  final FieldInfo[] sortedFields;
  final boolean supportBeanToArray;
  public final String typeName;
  
  JavaBeanInfo(Class<?> paramClass, Constructor<?> paramConstructor1, Constructor<?> paramConstructor2, Method paramMethod, FieldInfo[] paramArrayOfFieldInfo1, FieldInfo[] paramArrayOfFieldInfo2, JSONType paramJSONType)
  {
    this.defaultConstructor = paramConstructor1;
    this.creatorConstructor = paramConstructor2;
    this.factoryMethod = paramMethod;
    this.fields = paramArrayOfFieldInfo1;
    this.jsonType = paramJSONType;
    int j;
    int i;
    if (paramJSONType != null)
    {
      paramConstructor2 = paramJSONType.typeName();
      if (paramConstructor2.length() != 0) {}
      for (this.typeName = paramConstructor2;; this.typeName = paramClass.getName())
      {
        paramClass = paramJSONType.parseFeatures();
        int n = paramClass.length;
        j = 0;
        for (i = 0;; i = k | i)
        {
          k = i;
          if (j >= n) {
            break;
          }
          k = paramClass[j].mask;
          j += 1;
        }
      }
    }
    this.typeName = paramClass.getName();
    int k = 0;
    this.parserFeatures = k;
    if (paramJSONType != null)
    {
      paramClass = paramJSONType.parseFeatures();
      j = paramClass.length;
      i = 0;
      boolean bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i >= j) {
          break;
        }
        if (paramClass[i] == Feature.SupportArrayToBean) {
          bool1 = true;
        }
        i += 1;
      }
    }
    boolean bool2 = false;
    this.supportBeanToArray = bool2;
    paramClass = computeSortedFields(paramArrayOfFieldInfo1, paramArrayOfFieldInfo2);
    if (Arrays.equals(paramArrayOfFieldInfo1, paramClass)) {}
    for (;;)
    {
      this.sortedFields = paramArrayOfFieldInfo1;
      i = m;
      if (paramConstructor1 != null) {
        i = paramConstructor1.getParameterTypes().length;
      }
      this.defaultConstructorParameterSize = i;
      return;
      paramArrayOfFieldInfo1 = paramClass;
    }
  }
  
  static boolean addField(List<FieldInfo> paramList, FieldInfo paramFieldInfo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        FieldInfo localFieldInfo = (FieldInfo)paramList.get(i);
        if ((!localFieldInfo.name.equals(paramFieldInfo.name)) || ((localFieldInfo.getOnly) && (!paramFieldInfo.getOnly))) {
          i += 1;
        } else {
          return false;
        }
      }
    }
    paramList.add(paramFieldInfo);
    return true;
  }
  
  public static JavaBeanInfo build(Class<?> paramClass, int paramInt, Type paramType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, PropertyNamingStrategy paramPropertyNamingStrategy)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt & 0x400) == 0) {}
    for (;;)
    {
      try
      {
        Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[0]);
        if ((localConstructor == null) && (paramClass.isMemberClass()) && ((paramInt & 0x8) == 0))
        {
          localObject3 = paramClass.getDeclaredConstructors();
          j = localObject3.length;
          i = 0;
          if (i < j)
          {
            localObject2 = localObject3[i];
            localObject4 = ((Constructor)localObject2).getParameterTypes();
            if ((localObject4.length == 1) && (localObject4[0].equals(paramClass.getDeclaringClass())))
            {
              if (!paramBoolean1) {
                continue;
              }
              localObject5 = null;
              arrayOfField = paramClass.getDeclaredFields();
              if ((localObject2 != null) || (paramClass.isInterface()) || ((paramInt & 0x400) != 0)) {
                continue;
              }
              paramPropertyNamingStrategy = paramClass.getDeclaredConstructors();
              j = paramPropertyNamingStrategy.length;
              i = 0;
              if (i >= j) {
                continue;
              }
              paramType = paramPropertyNamingStrategy[i];
              if ((JSONCreator)paramType.getAnnotation(JSONCreator.class) == null) {
                continue;
              }
              if (0 == 0) {
                continue;
              }
              throw new JSONException("multi-json creator");
            }
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        Object localObject4;
        Field[] arrayOfField;
        Object localObject1 = null;
        continue;
        i += 1;
        continue;
        Object localObject5 = paramClass.getMethods();
        continue;
        int k;
        if (paramType != null)
        {
          TypeUtils.setAccessible(paramClass, paramType, paramInt);
          localObject2 = paramType.getParameterTypes();
          if (paramBoolean4)
          {
            paramPropertyNamingStrategy = paramType.getGenericParameterTypes();
            i = 0;
            if (i >= localObject2.length) {
              continue;
            }
            localObject4 = paramType.getParameterAnnotations()[i];
            localObject3 = null;
            k = localObject4.length;
            j = 0;
            localObject1 = localObject3;
            if (j < k)
            {
              localObject1 = localObject4[j];
              if ((localObject1 instanceof JSONField)) {
                localObject1 = (JSONField)localObject1;
              }
            }
            else
            {
              if (localObject1 != null) {
                continue;
              }
              throw new JSONException("illegal json creator");
              i += 1;
            }
          }
          else
          {
            paramPropertyNamingStrategy = (PropertyNamingStrategy)localObject2;
            continue;
          }
          j += 1;
          continue;
          localObject3 = localObject2[i];
          localObject4 = paramPropertyNamingStrategy[i];
          localObject5 = TypeUtils.getField(paramClass, ((JSONField)localObject1).name(), arrayOfField);
          if (localObject5 != null) {
            TypeUtils.setAccessible(paramClass, (Member)localObject5, paramInt);
          }
          j = ((JSONField)localObject1).ordinal();
          k = SerializerFeature.of(((JSONField)localObject1).serialzeFeatures());
          addField(localArrayList, new FieldInfo(((JSONField)localObject1).name(), paramClass, (Class)localObject3, (Type)localObject4, (Field)localObject5, j, k), paramBoolean1);
          i += 1;
          continue;
          localObject1 = new FieldInfo[localArrayList.size()];
          localArrayList.toArray((Object[])localObject1);
          localObject2 = new FieldInfo[localObject1.length];
          System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
          Arrays.sort((Object[])localObject2);
          if (paramBoolean2)
          {
            paramPropertyNamingStrategy = (JSONType)paramClass.getAnnotation(JSONType.class);
            return new JavaBeanInfo(paramClass, null, paramType, null, (FieldInfo[])localObject1, (FieldInfo[])localObject2, paramPropertyNamingStrategy);
          }
          paramPropertyNamingStrategy = null;
          continue;
        }
        int j = localObject5.length;
        int i = 0;
        if (i < j)
        {
          paramType = localObject5[i];
          if ((!Modifier.isStatic(paramType.getModifiers())) || (!paramClass.isAssignableFrom(paramType.getReturnType())))
          {
            i += 1;
            continue;
          }
          if ((JSONCreator)paramType.getAnnotation(JSONCreator.class) == null) {
            continue;
          }
          if (0 != 0) {
            throw new JSONException("multi-json creator");
          }
          if (paramType != null)
          {
            TypeUtils.setAccessible(paramClass, paramType, paramInt);
            localObject2 = paramType.getParameterTypes();
            if (paramBoolean4)
            {
              paramPropertyNamingStrategy = paramType.getGenericParameterTypes();
              paramInt = 0;
              if (paramInt >= localObject2.length) {
                continue;
              }
              localObject4 = paramType.getParameterAnnotations()[paramInt];
              localObject3 = null;
              j = localObject4.length;
              i = 0;
              localObject1 = localObject3;
              if (i < j)
              {
                localObject1 = localObject4[i];
                if ((localObject1 instanceof JSONField)) {
                  localObject1 = (JSONField)localObject1;
                }
              }
              else
              {
                if (localObject1 != null) {
                  continue;
                }
                throw new JSONException("illegal json creator");
              }
            }
            else
            {
              paramPropertyNamingStrategy = (PropertyNamingStrategy)localObject2;
              continue;
            }
            i += 1;
            continue;
            localObject3 = localObject2[paramInt];
            localObject4 = paramPropertyNamingStrategy[paramInt];
            localObject5 = TypeUtils.getField(paramClass, ((JSONField)localObject1).name(), arrayOfField);
            i = ((JSONField)localObject1).ordinal();
            j = SerializerFeature.of(((JSONField)localObject1).serialzeFeatures());
            addField(localArrayList, new FieldInfo(((JSONField)localObject1).name(), paramClass, (Class)localObject3, (Type)localObject4, (Field)localObject5, i, j), paramBoolean1);
            paramInt += 1;
            continue;
            localObject2 = new FieldInfo[localArrayList.size()];
            localArrayList.toArray((Object[])localObject2);
            localObject1 = new FieldInfo[localObject2.length];
            System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
            Arrays.sort((Object[])localObject1);
            paramPropertyNamingStrategy = (PropertyNamingStrategy)localObject1;
            if (Arrays.equals((Object[])localObject2, (Object[])localObject1)) {
              paramPropertyNamingStrategy = (PropertyNamingStrategy)localObject2;
            }
            if (paramBoolean2)
            {
              localObject1 = (JSONType)paramClass.getAnnotation(JSONType.class);
              return new JavaBeanInfo(paramClass, null, null, paramType, (FieldInfo[])localObject2, paramPropertyNamingStrategy, (JSONType)localObject1);
            }
            localObject1 = null;
            continue;
          }
          throw new JSONException("default constructor not found. " + paramClass);
          if (localObject2 != null) {
            TypeUtils.setAccessible(paramClass, (Member)localObject2, paramInt);
          }
          int m;
          Object localObject6;
          if (!paramBoolean1)
          {
            int i1 = localObject5.length;
            k = 0;
            if (k < i1)
            {
              Method localMethod = localObject5[k];
              i = 0;
              j = 0;
              localObject4 = localMethod.getName();
              if ((((String)localObject4).length() < 4) || (Modifier.isStatic(localMethod.getModifiers())))
              {
                k += 1;
                continue;
              }
              localObject1 = localMethod.getReturnType();
              if (((localObject1 != Void.TYPE) && (localObject1 != localMethod.getDeclaringClass())) || (localMethod.getParameterTypes().length != 1) || (localMethod.getDeclaringClass() == Object.class)) {
                continue;
              }
              if (paramBoolean3)
              {
                localObject1 = (JSONField)localMethod.getAnnotation(JSONField.class);
                localObject3 = localObject1;
                if (localObject1 == null)
                {
                  localObject3 = localObject1;
                  if (paramBoolean3) {
                    localObject3 = TypeUtils.getSupperMethodAnnotation(paramClass, localMethod);
                  }
                }
                if (localObject3 != null)
                {
                  if (!((JSONField)localObject3).deserialize()) {
                    continue;
                  }
                  m = ((JSONField)localObject3).ordinal();
                  n = SerializerFeature.of(((JSONField)localObject3).serialzeFeatures());
                  i = m;
                  j = n;
                  if (((JSONField)localObject3).name().length() != 0)
                  {
                    addField(localArrayList, new FieldInfo(((JSONField)localObject3).name(), localMethod, null, paramClass, paramType, m, n, (JSONField)localObject3, null, paramBoolean4), paramBoolean1);
                    TypeUtils.setAccessible(paramClass, localMethod, paramInt);
                  }
                }
              }
              else
              {
                localObject1 = null;
                continue;
              }
              if (!((String)localObject4).startsWith("set")) {
                continue;
              }
              char c = ((String)localObject4).charAt(3);
              if (Character.isUpperCase(c))
              {
                if (TypeUtils.compatibleWithJavaBean)
                {
                  localObject1 = TypeUtils.decapitalize(((String)localObject4).substring(3));
                  localObject4 = TypeUtils.getField(paramClass, (String)localObject1, arrayOfField);
                  localObject6 = localObject4;
                  if (localObject4 == null)
                  {
                    localObject6 = localObject4;
                    if (localMethod.getParameterTypes()[0] == Boolean.TYPE) {
                      localObject6 = TypeUtils.getField(paramClass, "is" + Character.toUpperCase(((String)localObject1).charAt(0)) + ((String)localObject1).substring(1), arrayOfField);
                    }
                  }
                  m = i;
                  n = j;
                  localObject7 = localObject3;
                  if (localObject6 == null) {
                    continue;
                  }
                  if (paramBoolean3)
                  {
                    localObject4 = (JSONField)((Field)localObject6).getAnnotation(JSONField.class);
                    m = i;
                    n = j;
                    localObject7 = localObject3;
                    if (localObject4 == null) {
                      continue;
                    }
                    i = ((JSONField)localObject4).ordinal();
                    j = SerializerFeature.of(((JSONField)localObject4).serialzeFeatures());
                    if (((JSONField)localObject4).name().length() == 0) {
                      continue;
                    }
                    addField(localArrayList, new FieldInfo(((JSONField)localObject4).name(), localMethod, (Field)localObject6, paramClass, paramType, i, j, (JSONField)localObject3, (JSONField)localObject4, paramBoolean4), paramBoolean1);
                  }
                }
                else
                {
                  localObject1 = Character.toLowerCase(((String)localObject4).charAt(3)) + ((String)localObject4).substring(4);
                  continue;
                }
              }
              else
              {
                if (c == '_')
                {
                  localObject1 = ((String)localObject4).substring(4);
                  continue;
                }
                if (c == 'f')
                {
                  localObject1 = ((String)localObject4).substring(3);
                  continue;
                }
                if ((((String)localObject4).length() < 5) || (!Character.isUpperCase(((String)localObject4).charAt(4)))) {
                  continue;
                }
                localObject1 = TypeUtils.decapitalize(((String)localObject4).substring(3));
                continue;
              }
              localObject4 = null;
              continue;
              m = i;
              int n = j;
              Object localObject7 = localObject3;
              if (localObject3 == null)
              {
                localObject7 = localObject4;
                n = j;
                m = i;
              }
              localObject3 = localObject1;
              if (paramPropertyNamingStrategy != null) {
                localObject3 = paramPropertyNamingStrategy.translate((String)localObject1);
              }
              addField(localArrayList, new FieldInfo((String)localObject3, localMethod, null, paramClass, paramType, m, n, localObject7, null, paramBoolean4), paramBoolean1);
              TypeUtils.setAccessible(paramClass, localMethod, paramInt);
              continue;
            }
          }
          localObject3 = new ArrayList(arrayOfField.length);
          k = arrayOfField.length;
          i = 0;
          if (i < k)
          {
            localObject1 = arrayOfField[i];
            j = ((Field)localObject1).getModifiers();
            if ((j & 0x8) != 0)
            {
              i += 1;
              continue;
            }
            if ((j & 0x10) != 0)
            {
              localObject4 = ((Field)localObject1).getType();
              if ((Map.class.isAssignableFrom((Class)localObject4)) || (Collection.class.isAssignableFrom((Class)localObject4)))
              {
                j = 1;
                if (j == 0) {
                  continue;
                }
              }
            }
            else
            {
              if ((((Field)localObject1).getModifiers() & 0x1) == 0) {
                continue;
              }
              ((List)localObject3).add(localObject1);
              continue;
            }
            j = 0;
            continue;
            continue;
          }
          localObject1 = paramClass.getSuperclass();
          if ((localObject1 != null) && (localObject1 != Object.class))
          {
            localObject4 = ((Class)localObject1).getDeclaredFields();
            k = localObject4.length;
            i = 0;
            if (i < k)
            {
              localObject5 = localObject4[i];
              m = ((Field)localObject5).getModifiers();
              if ((m & 0x8) != 0)
              {
                i += 1;
                continue;
              }
              if ((m & 0x10) != 0)
              {
                localObject6 = ((Field)localObject5).getType();
                if ((Map.class.isAssignableFrom((Class)localObject6)) || (Collection.class.isAssignableFrom((Class)localObject6)))
                {
                  j = 1;
                  if (j == 0) {
                    continue;
                  }
                }
              }
              else
              {
                if ((m & 0x1) == 0) {
                  continue;
                }
                ((List)localObject3).add(localObject5);
                continue;
              }
              j = 0;
              continue;
              continue;
            }
            localObject1 = ((Class)localObject1).getSuperclass();
            continue;
          }
          localObject5 = ((List)localObject3).iterator();
          if (((Iterator)localObject5).hasNext())
          {
            localObject6 = (Field)((Iterator)localObject5).next();
            localObject1 = ((Field)localObject6).getName();
            i = 0;
            k = localArrayList.size();
            j = 0;
            if (j < k)
            {
              if (!((FieldInfo)localArrayList.get(j)).name.equals(localObject1)) {
                continue;
              }
              i = 1;
              j += 1;
              continue;
            }
            if (i != 0) {
              continue;
            }
            i = 0;
            j = 0;
            if (paramBoolean3)
            {
              localObject3 = (JSONField)((Field)localObject6).getAnnotation(JSONField.class);
              if (localObject3 != null)
              {
                k = ((JSONField)localObject3).ordinal();
                m = SerializerFeature.of(((JSONField)localObject3).serialzeFeatures());
                i = k;
                j = m;
                if (((JSONField)localObject3).name().length() != 0)
                {
                  localObject1 = ((JSONField)localObject3).name();
                  j = m;
                  i = k;
                  localObject4 = localObject1;
                  if (paramPropertyNamingStrategy != null) {
                    localObject4 = paramPropertyNamingStrategy.translate((String)localObject1);
                  }
                  TypeUtils.setAccessible(paramClass, (Member)localObject6, paramInt);
                  addField(localArrayList, new FieldInfo((String)localObject4, null, (Field)localObject6, paramClass, paramType, i, j, null, (JSONField)localObject3, paramBoolean4), paramBoolean1);
                }
              }
            }
            else
            {
              localObject3 = null;
              continue;
            }
          }
          else
          {
            if (!paramBoolean1)
            {
              localObject3 = paramClass.getMethods();
              j = localObject3.length;
              i = 0;
              if (i < j)
              {
                localObject4 = localObject3[i];
                localObject5 = ((Method)localObject4).getName();
                if ((((String)localObject5).length() < 4) || (Modifier.isStatic(((Method)localObject4).getModifiers())))
                {
                  i += 1;
                  continue;
                }
                if ((!((String)localObject5).startsWith("get")) || (!Character.isUpperCase(((String)localObject5).charAt(3))) || (((Method)localObject4).getParameterTypes().length != 0)) {
                  continue;
                }
                paramPropertyNamingStrategy = ((Method)localObject4).getReturnType();
                if ((!Collection.class.isAssignableFrom(paramPropertyNamingStrategy)) && (!Map.class.isAssignableFrom(paramPropertyNamingStrategy))) {
                  continue;
                }
                if (paramBoolean3)
                {
                  paramPropertyNamingStrategy = (JSONField)((Method)localObject4).getAnnotation(JSONField.class);
                  if (paramPropertyNamingStrategy != null)
                  {
                    localObject1 = paramPropertyNamingStrategy.name();
                    if (((String)localObject1).length() > 0)
                    {
                      addField(localArrayList, new FieldInfo((String)localObject1, (Method)localObject4, null, paramClass, paramType, 0, 0, paramPropertyNamingStrategy, null, paramBoolean4), paramBoolean1);
                      TypeUtils.setAccessible(paramClass, (Member)localObject4, paramInt);
                    }
                  }
                }
                else
                {
                  paramPropertyNamingStrategy = null;
                  continue;
                }
                localObject1 = Character.toLowerCase(((String)localObject5).charAt(3)) + ((String)localObject5).substring(4);
                continue;
              }
            }
            paramPropertyNamingStrategy = new FieldInfo[localArrayList.size()];
            localArrayList.toArray(paramPropertyNamingStrategy);
            localObject1 = new FieldInfo[paramPropertyNamingStrategy.length];
            System.arraycopy(paramPropertyNamingStrategy, 0, localObject1, 0, paramPropertyNamingStrategy.length);
            Arrays.sort((Object[])localObject1);
            if (paramBoolean2)
            {
              paramType = (JSONType)paramClass.getAnnotation(JSONType.class);
              return new JavaBeanInfo(paramClass, (Constructor)localObject2, null, null, paramPropertyNamingStrategy, (FieldInfo[])localObject1, paramType);
            }
            paramType = null;
            continue;
          }
          continue;
          continue;
        }
        paramType = null;
        continue;
        paramType = null;
        continue;
        localObject2 = localObject1;
        continue;
      }
      Object localObject2 = null;
    }
  }
  
  private FieldInfo[] computeSortedFields(FieldInfo[] paramArrayOfFieldInfo1, FieldInfo[] paramArrayOfFieldInfo2)
  {
    if (this.jsonType == null) {}
    label128:
    label395:
    for (;;)
    {
      return paramArrayOfFieldInfo2;
      String[] arrayOfString = this.jsonType.orders();
      if ((arrayOfString != null) && (arrayOfString.length != 0))
      {
        int i = 0;
        int j;
        if (i < arrayOfString.length)
        {
          j = 0;
          label43:
          if (j < paramArrayOfFieldInfo2.length) {
            if (paramArrayOfFieldInfo2[j].name.equals(arrayOfString[i]))
            {
              j = 1;
              label70:
              if (j != 0) {
                break label185;
              }
            }
          }
        }
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label395;
          }
          if (arrayOfString.length == paramArrayOfFieldInfo1.length)
          {
            i = 0;
            label91:
            if (i >= arrayOfString.length) {
              break label381;
            }
            if (paramArrayOfFieldInfo2[i].name.equals(arrayOfString[i])) {}
          }
          label185:
          label375:
          label381:
          for (i = 0;; i = 1)
          {
            if (i != 0) {
              break label384;
            }
            paramArrayOfFieldInfo1 = new FieldInfo[paramArrayOfFieldInfo2.length];
            i = 0;
            if (i < arrayOfString.length)
            {
              j = 0;
              for (;;)
              {
                if (j < paramArrayOfFieldInfo2.length)
                {
                  if (paramArrayOfFieldInfo2[j].name.equals(arrayOfString[i])) {
                    paramArrayOfFieldInfo1[i] = paramArrayOfFieldInfo2[j];
                  }
                }
                else
                {
                  i += 1;
                  break label128;
                  j += 1;
                  break label43;
                  i += 1;
                  break;
                  i += 1;
                  break label91;
                }
                j += 1;
              }
            }
            this.ordered = true;
            return paramArrayOfFieldInfo1;
            paramArrayOfFieldInfo1 = new FieldInfo[paramArrayOfFieldInfo2.length];
            i = 0;
            if (i < arrayOfString.length)
            {
              j = 0;
              for (;;)
              {
                if (j < paramArrayOfFieldInfo2.length)
                {
                  if (paramArrayOfFieldInfo2[j].name.equals(arrayOfString[i])) {
                    paramArrayOfFieldInfo1[i] = paramArrayOfFieldInfo2[j];
                  }
                }
                else
                {
                  i += 1;
                  break;
                }
                j += 1;
              }
            }
            j = arrayOfString.length;
            i = 0;
            int k;
            if (i < paramArrayOfFieldInfo2.length)
            {
              k = 0;
              if ((k >= paramArrayOfFieldInfo1.length) || (k >= j)) {
                break label375;
              }
              if (!paramArrayOfFieldInfo1[i].equals(paramArrayOfFieldInfo2[k])) {}
            }
            for (int m = 1;; m = 0)
            {
              k = j;
              if (m == 0)
              {
                paramArrayOfFieldInfo1[j] = paramArrayOfFieldInfo2[i];
                k = j + 1;
              }
              i += 1;
              j = k;
              break;
              k += 1;
              break label296;
              this.ordered = true;
              return paramArrayOfFieldInfo2;
            }
          }
          label296:
          break;
          j = 0;
          break label70;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.JavaBeanInfo
 * JD-Core Version:    0.7.0.1
 */