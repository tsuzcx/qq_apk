package com.tencent.mobileqq.utils;

public class FileSizeFormat
{
  private static final long jdField_a_of_type_Long = 1024L;
  private static char[] jdField_a_of_type_ArrayOfChar;
  private static final long jdField_b_of_type_Long = 1048576L;
  private static final char[] jdField_b_of_type_ArrayOfChar;
  private static final long c = 1073741824L;
  
  static
  {
    a = new char[32];
    b = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, 160);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    double d = l;
    int i;
    int j;
    label63:
    int k;
    label90:
    char[] arrayOfChar;
    if (l < 1048576L) {
      if (l < 1024L)
      {
        i = 66;
        j = (int)(0.005D + d);
        if (j >= 100) {
          break label299;
        }
        if (j >= 10) {
          break label294;
        }
        paramInt = 1;
        if (i == 66) {
          break label330;
        }
        j = (int)(d * 100.0D + 0.5D);
        k = paramInt + 5;
        paramInt = j;
        if (k <= a.length) {
          break label341;
        }
        arrayOfChar = new char[k];
        label105:
        j = k - 1;
        arrayOfChar[j] = 'B';
        if (i == 66) {
          break label349;
        }
        j -= 1;
        arrayOfChar[j] = i;
        j -= 1;
        arrayOfChar[j] = b[(paramInt % 10)];
        paramInt /= 10;
        j -= 1;
        arrayOfChar[j] = b[(paramInt % 10)];
        paramInt /= 10;
        j -= 1;
        arrayOfChar[j] = '.';
      }
    }
    label294:
    label299:
    label330:
    label341:
    label349:
    for (;;)
    {
      j -= 1;
      arrayOfChar[j] = b[(paramInt % 10)];
      int m = paramInt / 10;
      paramInt = m;
      if (m <= 0)
      {
        return new String(arrayOfChar, 0, k);
        d /= 1024.0D;
        i = 75;
        break;
        if (l < 1073741824L)
        {
          d /= 1048576.0D;
          i = 77;
          break;
        }
        d /= 1073741824.0D;
        i = 71;
        break;
        paramInt = 2;
        break label63;
        if (j < 1000)
        {
          paramInt = 3;
          break label63;
        }
        if (j < 10000)
        {
          paramInt = 4;
          break label63;
        }
        paramInt = 5;
        break label63;
        k = paramInt + 1;
        paramInt = j;
        break label90;
        arrayOfChar = a;
        break label105;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.FileSizeFormat
 * JD-Core Version:    0.7.0.1
 */