package com.alibaba.fastjson.parser;

public class SymbolTable
{
  private final int indexMask;
  private final Entry[] symbols;
  
  public SymbolTable(int paramInt)
  {
    this.indexMask = (paramInt - 1);
    this.symbols = new Entry[paramInt];
    addSymbol("$ref", 0, 4, "$ref".hashCode());
    addSymbol("@type", 0, "@type".length(), "@type".hashCode());
  }
  
  private static String subString(String paramString, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    paramString.getChars(paramInt1, paramInt1 + paramInt2, arrayOfChar, 0);
    return new String(arrayOfChar);
  }
  
  public String addSymbol(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3 & this.indexMask;
    Entry localEntry = this.symbols[i];
    if (localEntry != null)
    {
      if ((paramInt3 == localEntry.hashCode) && (paramInt2 == localEntry.chars.length) && (paramString.regionMatches(paramInt1, localEntry.value, 0, paramInt2))) {
        return localEntry.value;
      }
      return subString(paramString, paramInt1, paramInt2);
    }
    if (paramInt2 == paramString.length()) {}
    for (;;)
    {
      paramString = paramString.intern();
      this.symbols[i] = new Entry(paramString, paramInt3);
      return paramString;
      paramString = subString(paramString, paramInt1, paramInt2);
    }
  }
  
  public String addSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = this.indexMask & paramInt3;
    Entry localEntry = this.symbols[i];
    if (localEntry != null)
    {
      i = j;
      if (paramInt3 == localEntry.hashCode)
      {
        i = j;
        if (paramInt2 == localEntry.chars.length)
        {
          paramInt3 = 0;
          if (paramInt3 >= paramInt2) {
            break label152;
          }
          if (paramArrayOfChar[(paramInt1 + paramInt3)] == localEntry.chars[paramInt3]) {
            break label95;
          }
        }
      }
    }
    label152:
    for (i = j;; i = 1)
    {
      if (i != 0)
      {
        return localEntry.value;
        label95:
        paramInt3 += 1;
        break;
      }
      return new String(paramArrayOfChar, paramInt1, paramInt2);
      paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2).intern();
      localEntry = new Entry(paramArrayOfChar, paramInt3);
      this.symbols[i] = localEntry;
      return paramArrayOfChar;
    }
  }
  
  static class Entry
  {
    final char[] chars;
    final int hashCode;
    final String value;
    
    Entry(String paramString, int paramInt)
    {
      this.value = paramString;
      this.chars = paramString.toCharArray();
      this.hashCode = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.SymbolTable
 * JD-Core Version:    0.7.0.1
 */