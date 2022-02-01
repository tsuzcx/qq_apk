package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Beta
@GwtCompatible
public final class CharEscaperBuilder
{
  private final Map<Character, String> map = new HashMap();
  private int max = -1;
  
  @CanIgnoreReturnValue
  public CharEscaperBuilder addEscape(char paramChar, String paramString)
  {
    this.map.put(Character.valueOf(paramChar), Preconditions.checkNotNull(paramString));
    if (paramChar > this.max) {
      this.max = paramChar;
    }
    return this;
  }
  
  @CanIgnoreReturnValue
  public CharEscaperBuilder addEscapes(char[] paramArrayOfChar, String paramString)
  {
    Preconditions.checkNotNull(paramString);
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      addEscape(paramArrayOfChar[i], paramString);
      i += 1;
    }
    return this;
  }
  
  public char[][] toArray()
  {
    char[][] arrayOfChar = new char[this.max + 1][];
    Iterator localIterator = this.map.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      arrayOfChar[((Character)localEntry.getKey()).charValue()] = ((String)localEntry.getValue()).toCharArray();
    }
    return arrayOfChar;
  }
  
  public Escaper toEscaper()
  {
    return new CharArrayDecorator(toArray());
  }
  
  static class CharArrayDecorator
    extends CharEscaper
  {
    private final int replaceLength;
    private final char[][] replacements;
    
    CharArrayDecorator(char[][] paramArrayOfChar)
    {
      this.replacements = paramArrayOfChar;
      this.replaceLength = paramArrayOfChar.length;
    }
    
    public String escape(String paramString)
    {
      int j = paramString.length();
      int i = 0;
      for (;;)
      {
        String str = paramString;
        if (i < j)
        {
          int k = paramString.charAt(i);
          if ((k < this.replacements.length) && (this.replacements[k] != null)) {
            str = escapeSlow(paramString, i);
          }
        }
        else
        {
          return str;
        }
        i += 1;
      }
    }
    
    protected char[] escape(char paramChar)
    {
      if (paramChar < this.replaceLength) {
        return this.replacements[paramChar];
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.escape.CharEscaperBuilder
 * JD-Core Version:    0.7.0.1
 */