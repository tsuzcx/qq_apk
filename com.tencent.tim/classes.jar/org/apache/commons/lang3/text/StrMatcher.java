package org.apache.commons.lang3.text;

import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public abstract class StrMatcher
{
  private static final StrMatcher COMMA_MATCHER = new CharMatcher(',');
  private static final StrMatcher DOUBLE_QUOTE_MATCHER;
  private static final StrMatcher NONE_MATCHER = new NoMatcher();
  private static final StrMatcher QUOTE_MATCHER;
  private static final StrMatcher SINGLE_QUOTE_MATCHER;
  private static final StrMatcher SPACE_MATCHER;
  private static final StrMatcher SPLIT_MATCHER;
  private static final StrMatcher TAB_MATCHER = new CharMatcher('\t');
  private static final StrMatcher TRIM_MATCHER;
  
  static
  {
    SPACE_MATCHER = new CharMatcher(' ');
    SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
    TRIM_MATCHER = new TrimMatcher();
    SINGLE_QUOTE_MATCHER = new CharMatcher('\'');
    DOUBLE_QUOTE_MATCHER = new CharMatcher('"');
    QUOTE_MATCHER = new CharSetMatcher("'\"".toCharArray());
  }
  
  public static StrMatcher charMatcher(char paramChar)
  {
    return new CharMatcher(paramChar);
  }
  
  public static StrMatcher charSetMatcher(String paramString)
  {
    if (StringUtils.isEmpty(paramString)) {
      return NONE_MATCHER;
    }
    if (paramString.length() == 1) {
      return new CharMatcher(paramString.charAt(0));
    }
    return new CharSetMatcher(paramString.toCharArray());
  }
  
  public static StrMatcher charSetMatcher(char... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return NONE_MATCHER;
    }
    if (paramVarArgs.length == 1) {
      return new CharMatcher(paramVarArgs[0]);
    }
    return new CharSetMatcher(paramVarArgs);
  }
  
  public static StrMatcher commaMatcher()
  {
    return COMMA_MATCHER;
  }
  
  public static StrMatcher doubleQuoteMatcher()
  {
    return DOUBLE_QUOTE_MATCHER;
  }
  
  public static StrMatcher noneMatcher()
  {
    return NONE_MATCHER;
  }
  
  public static StrMatcher quoteMatcher()
  {
    return QUOTE_MATCHER;
  }
  
  public static StrMatcher singleQuoteMatcher()
  {
    return SINGLE_QUOTE_MATCHER;
  }
  
  public static StrMatcher spaceMatcher()
  {
    return SPACE_MATCHER;
  }
  
  public static StrMatcher splitMatcher()
  {
    return SPLIT_MATCHER;
  }
  
  public static StrMatcher stringMatcher(String paramString)
  {
    if (StringUtils.isEmpty(paramString)) {
      return NONE_MATCHER;
    }
    return new StringMatcher(paramString);
  }
  
  public static StrMatcher tabMatcher()
  {
    return TAB_MATCHER;
  }
  
  public static StrMatcher trimMatcher()
  {
    return TRIM_MATCHER;
  }
  
  public int isMatch(char[] paramArrayOfChar, int paramInt)
  {
    return isMatch(paramArrayOfChar, paramInt, 0, paramArrayOfChar.length);
  }
  
  public abstract int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3);
  
  static final class CharMatcher
    extends StrMatcher
  {
    private final char ch;
    
    CharMatcher(char paramChar)
    {
      this.ch = paramChar;
    }
    
    public int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.ch == paramArrayOfChar[paramInt1]) {
        return 1;
      }
      return 0;
    }
  }
  
  static final class CharSetMatcher
    extends StrMatcher
  {
    private final char[] chars;
    
    CharSetMatcher(char[] paramArrayOfChar)
    {
      this.chars = ((char[])paramArrayOfChar.clone());
      Arrays.sort(this.chars);
    }
    
    public int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    {
      if (Arrays.binarySearch(this.chars, paramArrayOfChar[paramInt1]) >= 0) {
        return 1;
      }
      return 0;
    }
  }
  
  static final class NoMatcher
    extends StrMatcher
  {
    public int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    {
      return 0;
    }
  }
  
  static final class StringMatcher
    extends StrMatcher
  {
    private final char[] chars;
    
    StringMatcher(String paramString)
    {
      this.chars = paramString.toCharArray();
    }
    
    public int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    {
      int i = this.chars.length;
      if (paramInt1 + i > paramInt3) {
        return 0;
      }
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 >= this.chars.length) {
          break label52;
        }
        if (this.chars[paramInt2] != paramArrayOfChar[paramInt1]) {
          break;
        }
        paramInt2 += 1;
        paramInt1 += 1;
      }
      label52:
      return i;
    }
  }
  
  static final class TrimMatcher
    extends StrMatcher
  {
    public int isMatch(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramArrayOfChar[paramInt1] <= ' ') {
        return 1;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.text.StrMatcher
 * JD-Core Version:    0.7.0.1
 */