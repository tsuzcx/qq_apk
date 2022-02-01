package org.apache.commons.lang3;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AnnotationUtils
{
  private static final ToStringStyle TO_STRING_STYLE = new AnnotationUtils.1();
  
  private static boolean annotationArrayMemberEquals(Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2)
  {
    if (paramArrayOfAnnotation1.length != paramArrayOfAnnotation2.length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfAnnotation1.length) {
        break label36;
      }
      if (!equals(paramArrayOfAnnotation1[i], paramArrayOfAnnotation2[i])) {
        break;
      }
      i += 1;
    }
    label36:
    return true;
  }
  
  private static boolean arrayMemberEquals(Class<?> paramClass, Object paramObject1, Object paramObject2)
  {
    if (paramClass.isAnnotation()) {
      return annotationArrayMemberEquals((Annotation[])paramObject1, (Annotation[])paramObject2);
    }
    if (paramClass.equals(Byte.TYPE)) {
      return Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
    }
    if (paramClass.equals(Short.TYPE)) {
      return Arrays.equals((short[])paramObject1, (short[])paramObject2);
    }
    if (paramClass.equals(Integer.TYPE)) {
      return Arrays.equals((int[])paramObject1, (int[])paramObject2);
    }
    if (paramClass.equals(Character.TYPE)) {
      return Arrays.equals((char[])paramObject1, (char[])paramObject2);
    }
    if (paramClass.equals(Long.TYPE)) {
      return Arrays.equals((long[])paramObject1, (long[])paramObject2);
    }
    if (paramClass.equals(Float.TYPE)) {
      return Arrays.equals((float[])paramObject1, (float[])paramObject2);
    }
    if (paramClass.equals(Double.TYPE)) {
      return Arrays.equals((double[])paramObject1, (double[])paramObject2);
    }
    if (paramClass.equals(Boolean.TYPE)) {
      return Arrays.equals((boolean[])paramObject1, (boolean[])paramObject2);
    }
    return Arrays.equals((Object[])paramObject1, (Object[])paramObject2);
  }
  
  private static int arrayMemberHash(Class<?> paramClass, Object paramObject)
  {
    if (paramClass.equals(Byte.TYPE)) {
      return Arrays.hashCode((byte[])paramObject);
    }
    if (paramClass.equals(Short.TYPE)) {
      return Arrays.hashCode((short[])paramObject);
    }
    if (paramClass.equals(Integer.TYPE)) {
      return Arrays.hashCode((int[])paramObject);
    }
    if (paramClass.equals(Character.TYPE)) {
      return Arrays.hashCode((char[])paramObject);
    }
    if (paramClass.equals(Long.TYPE)) {
      return Arrays.hashCode((long[])paramObject);
    }
    if (paramClass.equals(Float.TYPE)) {
      return Arrays.hashCode((float[])paramObject);
    }
    if (paramClass.equals(Double.TYPE)) {
      return Arrays.hashCode((double[])paramObject);
    }
    if (paramClass.equals(Boolean.TYPE)) {
      return Arrays.hashCode((boolean[])paramObject);
    }
    return Arrays.hashCode((Object[])paramObject);
  }
  
  public static boolean equals(Annotation paramAnnotation1, Annotation paramAnnotation2)
  {
    if (paramAnnotation1 == paramAnnotation2) {}
    for (;;)
    {
      return true;
      if ((paramAnnotation1 == null) || (paramAnnotation2 == null)) {
        return false;
      }
      Object localObject1 = paramAnnotation1.annotationType();
      Class localClass = paramAnnotation2.annotationType();
      Validate.notNull(localObject1, "Annotation %s with null annotationType()", new Object[] { paramAnnotation1 });
      Validate.notNull(localClass, "Annotation %s with null annotationType()", new Object[] { paramAnnotation2 });
      if (!localObject1.equals(localClass)) {
        return false;
      }
      try
      {
        localObject1 = ((Class)localObject1).getDeclaredMethods();
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localClass = localObject1[i];
          if ((localClass.getParameterTypes().length == 0) && (isValidAnnotationMemberType(localClass.getReturnType())))
          {
            Object localObject2 = localClass.invoke(paramAnnotation1, new Object[0]);
            Object localObject3 = localClass.invoke(paramAnnotation2, new Object[0]);
            boolean bool = memberEquals(localClass.getReturnType(), localObject2, localObject3);
            if (!bool) {
              return false;
            }
          }
          i += 1;
        }
        return false;
      }
      catch (IllegalAccessException paramAnnotation1)
      {
        return false;
      }
      catch (InvocationTargetException paramAnnotation1) {}
    }
  }
  
  public static int hashCode(Annotation paramAnnotation)
  {
    int i = 0;
    Method[] arrayOfMethod = paramAnnotation.annotationType().getDeclaredMethods();
    int k = arrayOfMethod.length;
    int j = 0;
    while (i < k)
    {
      Method localMethod = arrayOfMethod[i];
      try
      {
        localObject = localMethod.invoke(paramAnnotation, new Object[0]);
        if (localObject == null) {
          throw new IllegalStateException(String.format("Annotation method %s returned null", new Object[] { localMethod }));
        }
      }
      catch (RuntimeException paramAnnotation)
      {
        Object localObject;
        throw paramAnnotation;
        int m = hashMember(localMethod.getName(), localObject);
        j += m;
        i += 1;
      }
      catch (Exception paramAnnotation)
      {
        throw new RuntimeException(paramAnnotation);
      }
    }
    return j;
  }
  
  private static int hashMember(String paramString, Object paramObject)
  {
    int i = paramString.hashCode() * 127;
    if (paramObject.getClass().isArray()) {
      return i ^ arrayMemberHash(paramObject.getClass().getComponentType(), paramObject);
    }
    if ((paramObject instanceof Annotation)) {
      return i ^ hashCode((Annotation)paramObject);
    }
    return i ^ paramObject.hashCode();
  }
  
  public static boolean isValidAnnotationMemberType(Class<?> paramClass)
  {
    if (paramClass == null) {}
    Object localObject;
    do
    {
      return false;
      localObject = paramClass;
      if (paramClass.isArray()) {
        localObject = paramClass.getComponentType();
      }
    } while ((!((Class)localObject).isPrimitive()) && (!((Class)localObject).isEnum()) && (!((Class)localObject).isAnnotation()) && (!String.class.equals(localObject)) && (!Class.class.equals(localObject)));
    return true;
  }
  
  private static boolean memberEquals(Class<?> paramClass, Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return false;
    }
    if (paramClass.isArray()) {
      return arrayMemberEquals(paramClass.getComponentType(), paramObject1, paramObject2);
    }
    if (paramClass.isAnnotation()) {
      return equals((Annotation)paramObject1, (Annotation)paramObject2);
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static String toString(Annotation paramAnnotation)
  {
    int i = 0;
    ToStringBuilder localToStringBuilder = new ToStringBuilder(paramAnnotation, TO_STRING_STYLE);
    Method[] arrayOfMethod = paramAnnotation.annotationType().getDeclaredMethods();
    int j = arrayOfMethod.length;
    if (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if (localMethod.getParameterTypes().length > 0) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localToStringBuilder.append(localMethod.getName(), localMethod.invoke(paramAnnotation, new Object[0]));
        }
        catch (RuntimeException paramAnnotation)
        {
          throw paramAnnotation;
        }
        catch (Exception paramAnnotation)
        {
          throw new RuntimeException(paramAnnotation);
        }
      }
    }
    return localToStringBuilder.build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.AnnotationUtils
 * JD-Core Version:    0.7.0.1
 */