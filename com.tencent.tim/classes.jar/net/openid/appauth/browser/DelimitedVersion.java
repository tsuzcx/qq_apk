package net.openid.appauth.browser;

import android.support.annotation.NonNull;

public class DelimitedVersion
  implements Comparable<DelimitedVersion>
{
  private static final long BIT_MASK_32 = -1L;
  private static final int PRIME_HASH_FACTOR = 92821;
  private final long[] mNumericParts;
  
  public DelimitedVersion(long[] paramArrayOfLong)
  {
    this.mNumericParts = paramArrayOfLong;
  }
  
  private int compareLongs(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 > paramLong2) {
      return 1;
    }
    return 0;
  }
  
  public static DelimitedVersion parse(String paramString)
  {
    if (paramString == null) {
      return new DelimitedVersion(new long[0]);
    }
    Object localObject = paramString.split("[^0-9]+");
    paramString = new long[localObject.length];
    int k = localObject.length;
    int i = 0;
    int j = 0;
    if (i < k)
    {
      String str = localObject[i];
      if (str.isEmpty()) {}
      for (;;)
      {
        i += 1;
        break;
        paramString[j] = Long.parseLong(str);
        j += 1;
      }
    }
    i = j - 1;
    for (;;)
    {
      if ((i < 0) || (paramString[i] > 0L))
      {
        i += 1;
        localObject = new long[i];
        System.arraycopy(paramString, 0, localObject, 0, i);
        return new DelimitedVersion((long[])localObject);
      }
      i -= 1;
    }
  }
  
  public int compareTo(@NonNull DelimitedVersion paramDelimitedVersion)
  {
    int i = 0;
    while ((i < this.mNumericParts.length) && (i < paramDelimitedVersion.mNumericParts.length))
    {
      int j = compareLongs(this.mNumericParts[i], paramDelimitedVersion.mNumericParts[i]);
      if (j != 0) {
        return j;
      }
      i += 1;
    }
    return compareLongs(this.mNumericParts.length, paramDelimitedVersion.mNumericParts.length);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof DelimitedVersion))) {
        return false;
      }
    } while (compareTo((DelimitedVersion)paramObject) == 0);
    return false;
  }
  
  public int hashCode()
  {
    int i = 0;
    long[] arrayOfLong = this.mNumericParts;
    int k = arrayOfLong.length;
    int j = 0;
    while (i < k)
    {
      j = j * 92821 + (int)(arrayOfLong[i] & 0xFFFFFFFF);
      i += 1;
    }
    return j;
  }
  
  public String toString()
  {
    if (this.mNumericParts.length == 0) {
      return "0";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mNumericParts[0]);
    int i = 1;
    while (i < this.mNumericParts.length)
    {
      localStringBuilder.append('.');
      localStringBuilder.append(this.mNumericParts[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.browser.DelimitedVersion
 * JD-Core Version:    0.7.0.1
 */