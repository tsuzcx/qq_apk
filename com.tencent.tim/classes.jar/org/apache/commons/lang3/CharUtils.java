package org.apache.commons.lang3;

public class CharUtils
{
  private static final String[] CHAR_STRING_ARRAY = new String[''];
  public static final char CR = '\r';
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public static final char LF = '\n';
  
  static
  {
    int j;
    for (int i = 0; i < CHAR_STRING_ARRAY.length; j = (char)(i + 1)) {
      CHAR_STRING_ARRAY[i] = String.valueOf(i);
    }
  }
  
  public static int compare(char paramChar1, char paramChar2)
  {
    return paramChar1 - paramChar2;
  }
  
  public static boolean isAscii(char paramChar)
  {
    return paramChar < '';
  }
  
  public static boolean isAsciiAlpha(char paramChar)
  {
    return (isAsciiAlphaUpper(paramChar)) || (isAsciiAlphaLower(paramChar));
  }
  
  public static boolean isAsciiAlphaLower(char paramChar)
  {
    return (paramChar >= 'a') && (paramChar <= 'z');
  }
  
  public static boolean isAsciiAlphaUpper(char paramChar)
  {
    return (paramChar >= 'A') && (paramChar <= 'Z');
  }
  
  public static boolean isAsciiAlphanumeric(char paramChar)
  {
    return (isAsciiAlpha(paramChar)) || (isAsciiNumeric(paramChar));
  }
  
  public static boolean isAsciiControl(char paramChar)
  {
    return (paramChar < ' ') || (paramChar == '');
  }
  
  public static boolean isAsciiNumeric(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  public static boolean isAsciiPrintable(char paramChar)
  {
    return (paramChar >= ' ') && (paramChar < '');
  }
  
  public static char toChar(Character paramCharacter)
  {
    if (paramCharacter == null) {
      throw new IllegalArgumentException("The Character must not be null");
    }
    return paramCharacter.charValue();
  }
  
  public static char toChar(Character paramCharacter, char paramChar)
  {
    if (paramCharacter == null) {
      return paramChar;
    }
    return paramCharacter.charValue();
  }
  
  public static char toChar(String paramString)
  {
    if (StringUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("The String must not be empty");
    }
    return paramString.charAt(0);
  }
  
  public static char toChar(String paramString, char paramChar)
  {
    if (StringUtils.isEmpty(paramString)) {
      return paramChar;
    }
    return paramString.charAt(0);
  }
  
  @Deprecated
  public static Character toCharacterObject(char paramChar)
  {
    return Character.valueOf(paramChar);
  }
  
  public static Character toCharacterObject(String paramString)
  {
    if (StringUtils.isEmpty(paramString)) {
      return null;
    }
    return Character.valueOf(paramString.charAt(0));
  }
  
  public static int toIntValue(char paramChar)
  {
    if (!isAsciiNumeric(paramChar)) {
      throw new IllegalArgumentException("The character " + paramChar + " is not in the range '0' - '9'");
    }
    return paramChar - '0';
  }
  
  public static int toIntValue(char paramChar, int paramInt)
  {
    if (!isAsciiNumeric(paramChar)) {
      return paramInt;
    }
    return paramChar - '0';
  }
  
  public static int toIntValue(Character paramCharacter)
  {
    if (paramCharacter == null) {
      throw new IllegalArgumentException("The character must not be null");
    }
    return toIntValue(paramCharacter.charValue());
  }
  
  public static int toIntValue(Character paramCharacter, int paramInt)
  {
    if (paramCharacter == null) {
      return paramInt;
    }
    return toIntValue(paramCharacter.charValue(), paramInt);
  }
  
  public static String toString(char paramChar)
  {
    if (paramChar < '') {
      return CHAR_STRING_ARRAY[paramChar];
    }
    return new String(new char[] { paramChar });
  }
  
  public static String toString(Character paramCharacter)
  {
    if (paramCharacter == null) {
      return null;
    }
    return toString(paramCharacter.charValue());
  }
  
  public static String unicodeEscaped(char paramChar)
  {
    StringBuilder localStringBuilder = new StringBuilder(6);
    localStringBuilder.append("\\u");
    localStringBuilder.append(HEX_DIGITS[(paramChar >> '\f' & 0xF)]);
    localStringBuilder.append(HEX_DIGITS[(paramChar >> '\b' & 0xF)]);
    localStringBuilder.append(HEX_DIGITS[(paramChar >> '\004' & 0xF)]);
    localStringBuilder.append(HEX_DIGITS[(paramChar & 0xF)]);
    return localStringBuilder.toString();
  }
  
  public static String unicodeEscaped(Character paramCharacter)
  {
    if (paramCharacter == null) {
      return null;
    }
    return unicodeEscaped(paramCharacter.charValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.CharUtils
 * JD-Core Version:    0.7.0.1
 */