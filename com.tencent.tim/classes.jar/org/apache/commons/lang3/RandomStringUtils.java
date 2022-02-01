package org.apache.commons.lang3;

import java.util.Random;

public class RandomStringUtils
{
  private static final Random RANDOM = new Random();
  
  public static String random(int paramInt)
  {
    return random(paramInt, false, false);
  }
  
  public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    return random(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, null, RANDOM);
  }
  
  public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char... paramVarArgs)
  {
    return random(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramVarArgs, RANDOM);
  }
  
  public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar, Random paramRandom)
  {
    if (paramInt1 == 0) {
      return "";
    }
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Requested random string length " + paramInt1 + " is less than 0.");
    }
    if ((paramArrayOfChar != null) && (paramArrayOfChar.length == 0)) {
      throw new IllegalArgumentException("The chars array must not be empty");
    }
    int k;
    int m;
    char[] arrayOfChar;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (paramArrayOfChar != null)
      {
        k = paramArrayOfChar.length;
        m = paramInt2;
        arrayOfChar = new char[paramInt1];
        paramInt3 = k - m;
        label96:
        paramInt2 = paramInt1 - 1;
        if (paramInt1 == 0) {
          break label401;
        }
        if (paramArrayOfChar != null) {
          break label262;
        }
        int i = (char)(paramRandom.nextInt(paramInt3) + m);
        label121:
        if (((!paramBoolean1) || (!Character.isLetter(i))) && ((!paramBoolean2) || (!Character.isDigit(i))) && ((paramBoolean1) || (paramBoolean2))) {
          break label394;
        }
        if ((i < 56320) || (i > 57343)) {
          break label308;
        }
        if (paramInt2 != 0) {
          break label279;
        }
        paramInt1 = paramInt2 + 1;
      }
    }
    label262:
    label394:
    for (;;)
    {
      break label96;
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        k = 2147483647;
        m = paramInt2;
        break;
      }
      k = 123;
      m = 32;
      break;
      m = paramInt2;
      k = paramInt3;
      if (paramInt3 > paramInt2) {
        break;
      }
      throw new IllegalArgumentException("Parameter end (" + paramInt3 + ") must be greater than start (" + paramInt2 + ")");
      int j = paramArrayOfChar[(paramRandom.nextInt(paramInt3) + m)];
      break label121;
      label279:
      arrayOfChar[paramInt2] = j;
      paramInt1 = paramInt2 - 1;
      arrayOfChar[paramInt1] = ((char)(paramRandom.nextInt(128) + 55296));
      continue;
      label308:
      if ((j >= 55296) && (j <= 56191))
      {
        if (paramInt2 == 0)
        {
          paramInt1 = paramInt2 + 1;
        }
        else
        {
          arrayOfChar[paramInt2] = ((char)(paramRandom.nextInt(128) + 56320));
          paramInt1 = paramInt2 - 1;
          arrayOfChar[paramInt1] = j;
        }
      }
      else if ((j >= 56192) && (j <= 56319))
      {
        paramInt1 = paramInt2 + 1;
      }
      else
      {
        arrayOfChar[paramInt2] = j;
        paramInt1 = paramInt2;
        continue;
        paramInt1 = paramInt2 + 1;
      }
    }
    label401:
    return new String(arrayOfChar);
  }
  
  public static String random(int paramInt, String paramString)
  {
    if (paramString == null) {
      return random(paramInt, 0, 0, false, false, null, RANDOM);
    }
    return random(paramInt, paramString.toCharArray());
  }
  
  public static String random(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return random(paramInt, 0, 0, paramBoolean1, paramBoolean2);
  }
  
  public static String random(int paramInt, char... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return random(paramInt, 0, 0, false, false, null, RANDOM);
    }
    return random(paramInt, 0, paramVarArgs.length, false, false, paramVarArgs, RANDOM);
  }
  
  public static String randomAlphabetic(int paramInt)
  {
    return random(paramInt, true, false);
  }
  
  public static String randomAlphanumeric(int paramInt)
  {
    return random(paramInt, true, true);
  }
  
  public static String randomAscii(int paramInt)
  {
    return random(paramInt, 32, 127, false, false);
  }
  
  public static String randomNumeric(int paramInt)
  {
    return random(paramInt, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.RandomStringUtils
 * JD-Core Version:    0.7.0.1
 */