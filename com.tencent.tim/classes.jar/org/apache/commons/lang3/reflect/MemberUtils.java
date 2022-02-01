package org.apache.commons.lang3.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ClassUtils;

abstract class MemberUtils
{
  private static final int ACCESS_TEST = 7;
  private static final Class<?>[] ORDERED_PRIMITIVE_TYPES = { Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE };
  
  static int compareParameterTypes(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2, Class<?>[] paramArrayOfClass3)
  {
    float f1 = getTotalTransformationCost(paramArrayOfClass3, paramArrayOfClass1);
    float f2 = getTotalTransformationCost(paramArrayOfClass3, paramArrayOfClass2);
    if (f1 < f2) {
      return -1;
    }
    if (f2 < f1) {
      return 1;
    }
    return 0;
  }
  
  private static float getObjectTransformationCost(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2.isPrimitive())
    {
      f2 = getPrimitivePromotionCost(paramClass1, paramClass2);
      return f2;
    }
    float f2 = 0.0F;
    for (;;)
    {
      float f1 = f2;
      if (paramClass1 != null)
      {
        f1 = f2;
        if (!paramClass2.equals(paramClass1))
        {
          if ((!paramClass2.isInterface()) || (!ClassUtils.isAssignable(paramClass1, paramClass2))) {
            break label64;
          }
          f1 = f2 + 0.25F;
        }
      }
      f2 = f1;
      if (paramClass1 != null) {
        break;
      }
      return f1 + 1.5F;
      label64:
      f2 += 1.0F;
      paramClass1 = paramClass1.getSuperclass();
    }
  }
  
  private static float getPrimitivePromotionCost(Class<?> paramClass1, Class<?> paramClass2)
  {
    float f1 = 0.0F;
    Object localObject = paramClass1;
    if (!paramClass1.isPrimitive())
    {
      f1 = 0.0F + 0.1F;
      localObject = ClassUtils.wrapperToPrimitive(paramClass1);
    }
    int i = 0;
    paramClass1 = (Class<?>)localObject;
    for (float f2 = f1; (paramClass1 != paramClass2) && (i < ORDERED_PRIMITIVE_TYPES.length); f2 = f1)
    {
      localObject = paramClass1;
      f1 = f2;
      if (paramClass1 == ORDERED_PRIMITIVE_TYPES[i])
      {
        f2 += 0.1F;
        localObject = paramClass1;
        f1 = f2;
        if (i < ORDERED_PRIMITIVE_TYPES.length - 1)
        {
          localObject = ORDERED_PRIMITIVE_TYPES[(i + 1)];
          f1 = f2;
        }
      }
      i += 1;
      paramClass1 = (Class<?>)localObject;
    }
    return f2;
  }
  
  private static float getTotalTransformationCost(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    float f = 0.0F;
    int i = 0;
    while (i < paramArrayOfClass1.length)
    {
      f += getObjectTransformationCost(paramArrayOfClass1[i], paramArrayOfClass2[i]);
      i += 1;
    }
    return f;
  }
  
  static boolean isAccessible(Member paramMember)
  {
    return (paramMember != null) && (Modifier.isPublic(paramMember.getModifiers())) && (!paramMember.isSynthetic());
  }
  
  static boolean isPackageAccess(int paramInt)
  {
    return (paramInt & 0x7) == 0;
  }
  
  static boolean setAccessibleWorkaround(AccessibleObject paramAccessibleObject)
  {
    if ((paramAccessibleObject == null) || (paramAccessibleObject.isAccessible())) {
      return false;
    }
    Member localMember = (Member)paramAccessibleObject;
    if ((!paramAccessibleObject.isAccessible()) && (Modifier.isPublic(localMember.getModifiers())) && (isPackageAccess(localMember.getDeclaringClass().getModifiers()))) {
      try
      {
        paramAccessibleObject.setAccessible(true);
        return true;
      }
      catch (SecurityException paramAccessibleObject) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.reflect.MemberUtils
 * JD-Core Version:    0.7.0.1
 */