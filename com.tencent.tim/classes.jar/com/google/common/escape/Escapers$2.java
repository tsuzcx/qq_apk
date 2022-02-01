package com.google.common.escape;

final class Escapers$2
  extends UnicodeEscaper
{
  Escapers$2(CharEscaper paramCharEscaper) {}
  
  protected char[] escape(int paramInt)
  {
    int j = 0;
    if (paramInt < 65536) {
      return this.val$escaper.escape((char)paramInt);
    }
    char[] arrayOfChar1 = new char[2];
    Character.toChars(paramInt, arrayOfChar1, 0);
    char[] arrayOfChar2 = this.val$escaper.escape(arrayOfChar1[0]);
    char[] arrayOfChar3 = this.val$escaper.escape(arrayOfChar1[1]);
    if ((arrayOfChar2 == null) && (arrayOfChar3 == null)) {
      return null;
    }
    if (arrayOfChar2 != null)
    {
      paramInt = arrayOfChar2.length;
      if (arrayOfChar3 == null) {
        break label128;
      }
    }
    char[] arrayOfChar4;
    label128:
    for (int i = arrayOfChar3.length;; i = 1)
    {
      arrayOfChar4 = new char[i + paramInt];
      if (arrayOfChar2 == null) {
        break label133;
      }
      i = 0;
      while (i < arrayOfChar2.length)
      {
        arrayOfChar4[i] = arrayOfChar2[i];
        i += 1;
      }
      paramInt = 1;
      break;
    }
    label133:
    arrayOfChar4[0] = arrayOfChar1[0];
    if (arrayOfChar3 != null)
    {
      i = j;
      while (i < arrayOfChar3.length)
      {
        arrayOfChar4[(paramInt + i)] = arrayOfChar3[i];
        i += 1;
      }
    }
    arrayOfChar4[paramInt] = arrayOfChar1[1];
    return arrayOfChar4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.escape.Escapers.2
 * JD-Core Version:    0.7.0.1
 */