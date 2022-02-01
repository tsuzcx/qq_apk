package com.tencent.mobileqq.triton.sdk;

public class Version
  implements Comparable<Version>
{
  long timeStamp;
  String version;
  
  public Version()
  {
    this.version = "";
    this.timeStamp = -1L;
  }
  
  public Version(String paramString, long paramLong)
  {
    this.version = paramString;
    this.timeStamp = paramLong;
  }
  
  public static int compareVersion(String paramString1, String paramString2)
  {
    int i = 0;
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int m = Math.min(paramString1.length, paramString2.length);
    int j = 0;
    while (j < m)
    {
      int k = paramString1[j].length() - paramString2[j].length();
      i = k;
      if (k != 0) {
        break;
      }
      k = paramString1[j].compareTo(paramString2[j]);
      i = k;
      if (k != 0) {
        break;
      }
      j += 1;
      i = k;
    }
    if (i != 0) {
      return i;
    }
    return paramString1.length - paramString2.length;
  }
  
  public int compareTo(Version paramVersion)
  {
    try
    {
      int i = compareVersion(this.version, paramVersion.version);
      if (i == 0)
      {
        if (this.timeStamp > paramVersion.timeStamp) {
          return 1;
        }
        long l1 = this.timeStamp;
        long l2 = paramVersion.timeStamp;
        if (l1 < l2) {
          return -1;
        }
      }
      else
      {
        return i;
      }
    }
    finally {}
    return 0;
  }
  
  public long getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.timeStamp = paramLong;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public String toString()
  {
    return "Version{version='" + this.version + '\'' + ", timeStamp=" + this.timeStamp + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.Version
 * JD-Core Version:    0.7.0.1
 */