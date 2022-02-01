package org.apache.commons.lang3.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class FieldUtils
{
  public static Field[] getAllFields(Class<?> paramClass)
  {
    paramClass = getAllFieldsList(paramClass);
    return (Field[])paramClass.toArray(new Field[paramClass.size()]);
  }
  
  public static List<Field> getAllFieldsList(Class<?> paramClass)
  {
    boolean bool;
    ArrayList localArrayList;
    if (paramClass != null)
    {
      bool = true;
      Validate.isTrue(bool, "The class must not be null", new Object[0]);
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      if (paramClass == null) {
        break label78;
      }
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          localArrayList.add(arrayOfField[i]);
          i += 1;
          continue;
          bool = false;
          break;
        }
      }
      paramClass = paramClass.getSuperclass();
    }
    label78:
    return localArrayList;
  }
  
  public static Field getDeclaredField(Class<?> paramClass, String paramString)
  {
    return getDeclaredField(paramClass, paramString, false);
  }
  
  public static Field getDeclaredField(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramClass != null) {}
    for (;;)
    {
      Validate.isTrue(bool, "The class must not be null", new Object[0]);
      Validate.isTrue(StringUtils.isNotBlank(paramString), "The field name must not be blank/empty", new Object[0]);
      try
      {
        paramClass = paramClass.getDeclaredField(paramString);
        if (!MemberUtils.isAccessible(paramClass))
        {
          if (paramBoolean) {
            paramClass.setAccessible(true);
          }
        }
        else
        {
          return paramClass;
          bool = false;
          continue;
        }
        return null;
      }
      catch (NoSuchFieldException paramClass) {}
    }
    return null;
  }
  
  public static Field getField(Class<?> paramClass, String paramString)
  {
    paramClass = getField(paramClass, paramString, false);
    MemberUtils.setAccessibleWorkaround(paramClass);
    return paramClass;
  }
  
  public static Field getField(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    boolean bool;
    Object localObject1;
    if (paramClass != null)
    {
      bool = true;
      Validate.isTrue(bool, "The class must not be null", new Object[0]);
      Validate.isTrue(StringUtils.isNotBlank(paramString), "The field name must not be blank/empty", new Object[0]);
      localObject1 = paramClass;
      label32:
      if (localObject1 == null) {
        break label94;
      }
    }
    Object localObject4;
    label84:
    label94:
    do
    {
      try
      {
        localObject4 = ((Class)localObject1).getDeclaredField(paramString);
        Object localObject2 = localObject4;
        if (!Modifier.isPublic(((Field)localObject4).getModifiers()))
        {
          if (!paramBoolean) {
            break label84;
          }
          ((Field)localObject4).setAccessible(true);
          localObject2 = localObject4;
        }
        return localObject2;
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        localObject1 = ((Class)localObject1).getSuperclass();
      }
      bool = false;
      break;
      break label32;
      localObject1 = null;
      localObject4 = ClassUtils.getAllInterfaces(paramClass).iterator();
      localObject3 = localObject1;
    } while (!((Iterator)localObject4).hasNext());
    Object localObject3 = (Class)((Iterator)localObject4).next();
    for (;;)
    {
      try
      {
        localObject3 = ((Class)localObject3).getField(paramString);
        if (localObject1 == null)
        {
          paramBoolean = true;
          Validate.isTrue(paramBoolean, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", new Object[] { paramString, paramClass });
          localObject1 = localObject3;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        continue;
      }
      paramBoolean = false;
    }
  }
  
  public static List<Field> getFieldsListWithAnnotation(Class<?> paramClass, Class<? extends Annotation> paramClass1)
  {
    if (paramClass1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool, "The annotation class must not be null", new Object[0]);
      Object localObject = getAllFieldsList(paramClass);
      paramClass = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Field localField = (Field)((Iterator)localObject).next();
        if (localField.getAnnotation(paramClass1) != null) {
          paramClass.add(localField);
        }
      }
    }
    return paramClass;
  }
  
  public static Field[] getFieldsWithAnnotation(Class<?> paramClass, Class<? extends Annotation> paramClass1)
  {
    paramClass = getFieldsListWithAnnotation(paramClass, paramClass1);
    return (Field[])paramClass.toArray(new Field[paramClass.size()]);
  }
  
  public static Object readDeclaredField(Object paramObject, String paramString)
    throws IllegalAccessException
  {
    return readDeclaredField(paramObject, paramString, false);
  }
  
  public static Object readDeclaredField(Object paramObject, String paramString, boolean paramBoolean)
    throws IllegalAccessException
  {
    boolean bool;
    Class localClass;
    Field localField;
    if (paramObject != null)
    {
      bool = true;
      Validate.isTrue(bool, "target object must not be null", new Object[0]);
      localClass = paramObject.getClass();
      localField = getDeclaredField(localClass, paramString, paramBoolean);
      if (localField == null) {
        break label70;
      }
    }
    label70:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Validate.isTrue(paramBoolean, "Cannot locate declared field %s.%s", new Object[] { localClass, paramString });
      return readField(localField, paramObject, false);
      bool = false;
      break;
    }
  }
  
  public static Object readDeclaredStaticField(Class<?> paramClass, String paramString)
    throws IllegalAccessException
  {
    return readDeclaredStaticField(paramClass, paramString, false);
  }
  
  public static Object readDeclaredStaticField(Class<?> paramClass, String paramString, boolean paramBoolean)
    throws IllegalAccessException
  {
    Field localField = getDeclaredField(paramClass, paramString, paramBoolean);
    if (localField != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Validate.isTrue(paramBoolean, "Cannot locate declared field %s.%s", new Object[] { paramClass.getName(), paramString });
      return readStaticField(localField, false);
    }
  }
  
  public static Object readField(Object paramObject, String paramString)
    throws IllegalAccessException
  {
    return readField(paramObject, paramString, false);
  }
  
  public static Object readField(Object paramObject, String paramString, boolean paramBoolean)
    throws IllegalAccessException
  {
    boolean bool;
    Class localClass;
    Field localField;
    if (paramObject != null)
    {
      bool = true;
      Validate.isTrue(bool, "target object must not be null", new Object[0]);
      localClass = paramObject.getClass();
      localField = getField(localClass, paramString, paramBoolean);
      if (localField == null) {
        break label70;
      }
    }
    label70:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Validate.isTrue(paramBoolean, "Cannot locate field %s on %s", new Object[] { paramString, localClass });
      return readField(localField, paramObject, false);
      bool = false;
      break;
    }
  }
  
  public static Object readField(Field paramField, Object paramObject)
    throws IllegalAccessException
  {
    return readField(paramField, paramObject, false);
  }
  
  public static Object readField(Field paramField, Object paramObject, boolean paramBoolean)
    throws IllegalAccessException
  {
    boolean bool;
    if (paramField != null)
    {
      bool = true;
      Validate.isTrue(bool, "The field must not be null", new Object[0]);
      if ((!paramBoolean) || (paramField.isAccessible())) {
        break label43;
      }
      paramField.setAccessible(true);
    }
    for (;;)
    {
      return paramField.get(paramObject);
      bool = false;
      break;
      label43:
      MemberUtils.setAccessibleWorkaround(paramField);
    }
  }
  
  public static Object readStaticField(Class<?> paramClass, String paramString)
    throws IllegalAccessException
  {
    return readStaticField(paramClass, paramString, false);
  }
  
  public static Object readStaticField(Class<?> paramClass, String paramString, boolean paramBoolean)
    throws IllegalAccessException
  {
    Field localField = getField(paramClass, paramString, paramBoolean);
    if (localField != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Validate.isTrue(paramBoolean, "Cannot locate field '%s' on %s", new Object[] { paramString, paramClass });
      return readStaticField(localField, false);
    }
  }
  
  public static Object readStaticField(Field paramField)
    throws IllegalAccessException
  {
    return readStaticField(paramField, false);
  }
  
  public static Object readStaticField(Field paramField, boolean paramBoolean)
    throws IllegalAccessException
  {
    if (paramField != null) {}
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool, "The field must not be null", new Object[0]);
      Validate.isTrue(Modifier.isStatic(paramField.getModifiers()), "The field '%s' is not static", new Object[] { paramField.getName() });
      return readField(paramField, (Object)null, paramBoolean);
    }
  }
  
  public static void removeFinalModifier(Field paramField)
  {
    removeFinalModifier(paramField, true);
  }
  
  public static void removeFinalModifier(Field paramField, boolean paramBoolean)
  {
    int i = 1;
    boolean bool;
    if (paramField != null)
    {
      bool = true;
      Validate.isTrue(bool, "The field must not be null", new Object[0]);
    }
    for (;;)
    {
      try
      {
        if (Modifier.isFinal(paramField.getModifiers()))
        {
          Field localField = Field.class.getDeclaredField("modifiers");
          if ((!paramBoolean) || (localField.isAccessible())) {
            break label105;
          }
          if (i != 0) {
            localField.setAccessible(true);
          }
          try
          {
            localField.setInt(paramField, paramField.getModifiers() & 0xFFFFFFEF);
            return;
          }
          finally
          {
            if (i != 0) {
              localField.setAccessible(false);
            }
          }
        }
        return;
      }
      catch (NoSuchFieldException paramField)
      {
        return;
      }
      catch (IllegalAccessException paramField) {}
      bool = false;
      break;
      label105:
      i = 0;
    }
  }
  
  public static void writeDeclaredField(Object paramObject1, String paramString, Object paramObject2)
    throws IllegalAccessException
  {
    writeDeclaredField(paramObject1, paramString, paramObject2, false);
  }
  
  public static void writeDeclaredField(Object paramObject1, String paramString, Object paramObject2, boolean paramBoolean)
    throws IllegalAccessException
  {
    boolean bool;
    Class localClass;
    Field localField;
    if (paramObject1 != null)
    {
      bool = true;
      Validate.isTrue(bool, "target object must not be null", new Object[0]);
      localClass = paramObject1.getClass();
      localField = getDeclaredField(localClass, paramString, paramBoolean);
      if (localField == null) {
        break label77;
      }
    }
    label77:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Validate.isTrue(paramBoolean, "Cannot locate declared field %s.%s", new Object[] { localClass.getName(), paramString });
      writeField(localField, paramObject1, paramObject2, false);
      return;
      bool = false;
      break;
    }
  }
  
  public static void writeDeclaredStaticField(Class<?> paramClass, String paramString, Object paramObject)
    throws IllegalAccessException
  {
    writeDeclaredStaticField(paramClass, paramString, paramObject, false);
  }
  
  public static void writeDeclaredStaticField(Class<?> paramClass, String paramString, Object paramObject, boolean paramBoolean)
    throws IllegalAccessException
  {
    Field localField = getDeclaredField(paramClass, paramString, paramBoolean);
    if (localField != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Validate.isTrue(paramBoolean, "Cannot locate declared field %s.%s", new Object[] { paramClass.getName(), paramString });
      writeField(localField, (Object)null, paramObject, false);
      return;
    }
  }
  
  public static void writeField(Object paramObject1, String paramString, Object paramObject2)
    throws IllegalAccessException
  {
    writeField(paramObject1, paramString, paramObject2, false);
  }
  
  public static void writeField(Object paramObject1, String paramString, Object paramObject2, boolean paramBoolean)
    throws IllegalAccessException
  {
    boolean bool;
    Class localClass;
    Field localField;
    if (paramObject1 != null)
    {
      bool = true;
      Validate.isTrue(bool, "target object must not be null", new Object[0]);
      localClass = paramObject1.getClass();
      localField = getField(localClass, paramString, paramBoolean);
      if (localField == null) {
        break label77;
      }
    }
    label77:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Validate.isTrue(paramBoolean, "Cannot locate declared field %s.%s", new Object[] { localClass.getName(), paramString });
      writeField(localField, paramObject1, paramObject2, false);
      return;
      bool = false;
      break;
    }
  }
  
  public static void writeField(Field paramField, Object paramObject1, Object paramObject2)
    throws IllegalAccessException
  {
    writeField(paramField, paramObject1, paramObject2, false);
  }
  
  public static void writeField(Field paramField, Object paramObject1, Object paramObject2, boolean paramBoolean)
    throws IllegalAccessException
  {
    boolean bool;
    if (paramField != null)
    {
      bool = true;
      Validate.isTrue(bool, "The field must not be null", new Object[0]);
      if ((!paramBoolean) || (paramField.isAccessible())) {
        break label47;
      }
      paramField.setAccessible(true);
    }
    for (;;)
    {
      paramField.set(paramObject1, paramObject2);
      return;
      bool = false;
      break;
      label47:
      MemberUtils.setAccessibleWorkaround(paramField);
    }
  }
  
  public static void writeStaticField(Class<?> paramClass, String paramString, Object paramObject)
    throws IllegalAccessException
  {
    writeStaticField(paramClass, paramString, paramObject, false);
  }
  
  public static void writeStaticField(Class<?> paramClass, String paramString, Object paramObject, boolean paramBoolean)
    throws IllegalAccessException
  {
    Field localField = getField(paramClass, paramString, paramBoolean);
    if (localField != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Validate.isTrue(paramBoolean, "Cannot locate field %s on %s", new Object[] { paramString, paramClass });
      writeStaticField(localField, paramObject, false);
      return;
    }
  }
  
  public static void writeStaticField(Field paramField, Object paramObject)
    throws IllegalAccessException
  {
    writeStaticField(paramField, paramObject, false);
  }
  
  public static void writeStaticField(Field paramField, Object paramObject, boolean paramBoolean)
    throws IllegalAccessException
  {
    if (paramField != null) {}
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool, "The field must not be null", new Object[0]);
      Validate.isTrue(Modifier.isStatic(paramField.getModifiers()), "The field %s.%s is not static", new Object[] { paramField.getDeclaringClass().getName(), paramField.getName() });
      writeField(paramField, (Object)null, paramObject, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.reflect.FieldUtils
 * JD-Core Version:    0.7.0.1
 */