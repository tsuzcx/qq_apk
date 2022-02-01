package org.apache.commons.lang3;

import org.apache.commons.lang3.math.NumberUtils;

public class BooleanUtils
{
  public static Boolean and(Boolean... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("The Array must not be null");
    }
    if (paramVarArgs.length == 0) {
      throw new IllegalArgumentException("Array is empty");
    }
    try
    {
      if (and(ArrayUtils.toPrimitive(paramVarArgs))) {
        return Boolean.TRUE;
      }
      paramVarArgs = Boolean.FALSE;
      return paramVarArgs;
    }
    catch (NullPointerException paramVarArgs)
    {
      throw new IllegalArgumentException("The array must not contain any null elements");
    }
  }
  
  public static boolean and(boolean... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("The Array must not be null");
    }
    if (paramVarArgs.length == 0) {
      throw new IllegalArgumentException("Array is empty");
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (paramVarArgs[i] == 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static int compare(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == paramBoolean2) {
      return 0;
    }
    if (paramBoolean1) {
      return 1;
    }
    return -1;
  }
  
  public static boolean isFalse(Boolean paramBoolean)
  {
    return Boolean.FALSE.equals(paramBoolean);
  }
  
  public static boolean isNotFalse(Boolean paramBoolean)
  {
    return !isFalse(paramBoolean);
  }
  
  public static boolean isNotTrue(Boolean paramBoolean)
  {
    return !isTrue(paramBoolean);
  }
  
  public static boolean isTrue(Boolean paramBoolean)
  {
    return Boolean.TRUE.equals(paramBoolean);
  }
  
  public static Boolean negate(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return null;
    }
    if (paramBoolean.booleanValue()) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public static Boolean or(Boolean... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("The Array must not be null");
    }
    if (paramVarArgs.length == 0) {
      throw new IllegalArgumentException("Array is empty");
    }
    try
    {
      if (or(ArrayUtils.toPrimitive(paramVarArgs))) {
        return Boolean.TRUE;
      }
      paramVarArgs = Boolean.FALSE;
      return paramVarArgs;
    }
    catch (NullPointerException paramVarArgs)
    {
      throw new IllegalArgumentException("The array must not contain any null elements");
    }
  }
  
  public static boolean or(boolean... paramVarArgs)
  {
    boolean bool2 = false;
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("The Array must not be null");
    }
    if (paramVarArgs.length == 0) {
      throw new IllegalArgumentException("Array is empty");
    }
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramVarArgs[i] != 0) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean toBoolean(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static boolean toBoolean(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == paramInt2) {
      return true;
    }
    if (paramInt1 == paramInt3) {
      return false;
    }
    throw new IllegalArgumentException("The Integer did not match either specified value");
  }
  
  public static boolean toBoolean(Boolean paramBoolean)
  {
    return (paramBoolean != null) && (paramBoolean.booleanValue());
  }
  
  public static boolean toBoolean(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    if (paramInteger1 == null) {
      if (paramInteger2 != null) {}
    }
    while (paramInteger1.equals(paramInteger2))
    {
      return true;
      if (paramInteger3 != null) {
        break;
      }
      return false;
    }
    if (paramInteger1.equals(paramInteger3)) {
      return false;
    }
    throw new IllegalArgumentException("The Integer did not match either specified value");
  }
  
  public static boolean toBoolean(String paramString)
  {
    return toBooleanObject(paramString) == Boolean.TRUE;
  }
  
  public static boolean toBoolean(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == paramString2) {}
    do
    {
      return true;
      if (paramString1 == paramString3) {
        return false;
      }
      if (paramString1 == null) {
        break;
      }
    } while (paramString1.equals(paramString2));
    if (paramString1.equals(paramString3)) {
      return false;
    }
    throw new IllegalArgumentException("The String did not match either specified value");
  }
  
  public static boolean toBooleanDefaultIfNull(Boolean paramBoolean, boolean paramBoolean1)
  {
    if (paramBoolean == null) {
      return paramBoolean1;
    }
    return paramBoolean.booleanValue();
  }
  
  public static Boolean toBooleanObject(int paramInt)
  {
    if (paramInt == 0) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public static Boolean toBooleanObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == paramInt2) {
      return Boolean.TRUE;
    }
    if (paramInt1 == paramInt3) {
      return Boolean.FALSE;
    }
    if (paramInt1 == paramInt4) {
      return null;
    }
    throw new IllegalArgumentException("The Integer did not match any specified value");
  }
  
  public static Boolean toBooleanObject(Integer paramInteger)
  {
    if (paramInteger == null) {
      return null;
    }
    if (paramInteger.intValue() == 0) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public static Boolean toBooleanObject(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4)
  {
    Object localObject = null;
    if (paramInteger1 == null)
    {
      if (paramInteger2 == null) {
        paramInteger1 = Boolean.TRUE;
      }
      do
      {
        return paramInteger1;
        if (paramInteger3 == null) {
          return Boolean.FALSE;
        }
        paramInteger1 = localObject;
      } while (paramInteger4 == null);
    }
    do
    {
      throw new IllegalArgumentException("The Integer did not match any specified value");
      if (paramInteger1.equals(paramInteger2)) {
        return Boolean.TRUE;
      }
      if (paramInteger1.equals(paramInteger3)) {
        return Boolean.FALSE;
      }
    } while (!paramInteger1.equals(paramInteger4));
    return null;
  }
  
  public static Boolean toBooleanObject(String paramString)
  {
    if (paramString == "true") {
      return Boolean.TRUE;
    }
    if (paramString == null) {
      return null;
    }
    switch (paramString.length())
    {
    }
    int i;
    int j;
    int k;
    int m;
    int n;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
              i = paramString.charAt(0);
              if ((i == 121) || (i == 89) || (i == 116) || (i == 84)) {
                return Boolean.TRUE;
              }
            } while ((i != 110) && (i != 78) && (i != 102) && (i != 70));
            return Boolean.FALSE;
            i = paramString.charAt(0);
            j = paramString.charAt(1);
            if (((i == 111) || (i == 79)) && ((j == 110) || (j == 78))) {
              return Boolean.TRUE;
            }
          } while (((i != 110) && (i != 78)) || ((j != 111) && (j != 79)));
          return Boolean.FALSE;
          i = paramString.charAt(0);
          j = paramString.charAt(1);
          k = paramString.charAt(2);
          if (((i == 121) || (i == 89)) && ((j == 101) || (j == 69)) && ((k == 115) || (k == 83))) {
            return Boolean.TRUE;
          }
        } while (((i != 111) && (i != 79)) || ((j != 102) && (j != 70)) || ((k != 102) && (k != 70)));
        return Boolean.FALSE;
        i = paramString.charAt(0);
        j = paramString.charAt(1);
        k = paramString.charAt(2);
        m = paramString.charAt(3);
      } while (((i != 116) && (i != 84)) || ((j != 114) && (j != 82)) || ((k != 117) && (k != 85)) || ((m != 101) && (m != 69)));
      return Boolean.TRUE;
      i = paramString.charAt(0);
      j = paramString.charAt(1);
      k = paramString.charAt(2);
      m = paramString.charAt(3);
      n = paramString.charAt(4);
    } while (((i != 102) && (i != 70)) || ((j != 97) && (j != 65)) || ((k != 108) && (k != 76)) || ((m != 115) && (m != 83)) || ((n != 101) && (n != 69)));
    return Boolean.FALSE;
  }
  
  public static Boolean toBooleanObject(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = null;
    if (paramString1 == null)
    {
      if (paramString2 == null) {
        paramString1 = Boolean.TRUE;
      }
      do
      {
        return paramString1;
        if (paramString3 == null) {
          return Boolean.FALSE;
        }
        paramString1 = localObject;
      } while (paramString4 == null);
    }
    do
    {
      throw new IllegalArgumentException("The String did not match any specified value");
      if (paramString1.equals(paramString2)) {
        return Boolean.TRUE;
      }
      if (paramString1.equals(paramString3)) {
        return Boolean.FALSE;
      }
    } while (!paramString1.equals(paramString4));
    return null;
  }
  
  public static int toInteger(Boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBoolean == null) {
      return paramInt3;
    }
    if (paramBoolean.booleanValue()) {}
    for (;;)
    {
      return paramInt1;
      paramInt1 = paramInt2;
    }
  }
  
  public static int toInteger(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1;
    }
    return 0;
  }
  
  public static int toInteger(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static Integer toIntegerObject(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return null;
    }
    if (paramBoolean.booleanValue()) {
      return NumberUtils.INTEGER_ONE;
    }
    return NumberUtils.INTEGER_ZERO;
  }
  
  public static Integer toIntegerObject(Boolean paramBoolean, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    if (paramBoolean == null) {
      return paramInteger3;
    }
    if (paramBoolean.booleanValue()) {}
    for (;;)
    {
      return paramInteger1;
      paramInteger1 = paramInteger2;
    }
  }
  
  public static Integer toIntegerObject(boolean paramBoolean)
  {
    if (paramBoolean) {
      return NumberUtils.INTEGER_ONE;
    }
    return NumberUtils.INTEGER_ZERO;
  }
  
  public static Integer toIntegerObject(boolean paramBoolean, Integer paramInteger1, Integer paramInteger2)
  {
    if (paramBoolean) {
      return paramInteger1;
    }
    return paramInteger2;
  }
  
  public static String toString(Boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean == null) {
      return paramString3;
    }
    if (paramBoolean.booleanValue()) {}
    for (;;)
    {
      return paramString1;
      paramString1 = paramString2;
    }
  }
  
  public static String toString(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean) {
      return paramString1;
    }
    return paramString2;
  }
  
  public static String toStringOnOff(Boolean paramBoolean)
  {
    return toString(paramBoolean, "on", "off", null);
  }
  
  public static String toStringOnOff(boolean paramBoolean)
  {
    return toString(paramBoolean, "on", "off");
  }
  
  public static String toStringTrueFalse(Boolean paramBoolean)
  {
    return toString(paramBoolean, "true", "false", null);
  }
  
  public static String toStringTrueFalse(boolean paramBoolean)
  {
    return toString(paramBoolean, "true", "false");
  }
  
  public static String toStringYesNo(Boolean paramBoolean)
  {
    return toString(paramBoolean, "yes", "no", null);
  }
  
  public static String toStringYesNo(boolean paramBoolean)
  {
    return toString(paramBoolean, "yes", "no");
  }
  
  public static Boolean xor(Boolean... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("The Array must not be null");
    }
    if (paramVarArgs.length == 0) {
      throw new IllegalArgumentException("Array is empty");
    }
    try
    {
      if (xor(ArrayUtils.toPrimitive(paramVarArgs))) {
        return Boolean.TRUE;
      }
      paramVarArgs = Boolean.FALSE;
      return paramVarArgs;
    }
    catch (NullPointerException paramVarArgs)
    {
      throw new IllegalArgumentException("The array must not contain any null elements");
    }
  }
  
  public static boolean xor(boolean... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("The Array must not be null");
    }
    if (paramVarArgs.length == 0) {
      throw new IllegalArgumentException("Array is empty");
    }
    int j = paramVarArgs.length;
    int k = 0;
    while (i < j)
    {
      k ^= paramVarArgs[i];
      i += 1;
    }
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.BooleanUtils
 * JD-Core Version:    0.7.0.1
 */