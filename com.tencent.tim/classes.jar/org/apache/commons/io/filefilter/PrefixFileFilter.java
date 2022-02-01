package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.IOCase;

public class PrefixFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private static final long serialVersionUID = 8533897440809599867L;
  private final IOCase caseSensitivity;
  private final String[] prefixes;
  
  public PrefixFileFilter(String paramString)
  {
    this(paramString, IOCase.SENSITIVE);
  }
  
  public PrefixFileFilter(String paramString, IOCase paramIOCase)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("The prefix must not be null");
    }
    this.prefixes = new String[] { paramString };
    paramString = paramIOCase;
    if (paramIOCase == null) {
      paramString = IOCase.SENSITIVE;
    }
    this.caseSensitivity = paramString;
  }
  
  public PrefixFileFilter(List<String> paramList)
  {
    this(paramList, IOCase.SENSITIVE);
  }
  
  public PrefixFileFilter(List<String> paramList, IOCase paramIOCase)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("The list of prefixes must not be null");
    }
    this.prefixes = ((String[])paramList.toArray(new String[paramList.size()]));
    paramList = paramIOCase;
    if (paramIOCase == null) {
      paramList = IOCase.SENSITIVE;
    }
    this.caseSensitivity = paramList;
  }
  
  public PrefixFileFilter(String[] paramArrayOfString)
  {
    this(paramArrayOfString, IOCase.SENSITIVE);
  }
  
  public PrefixFileFilter(String[] paramArrayOfString, IOCase paramIOCase)
  {
    if (paramArrayOfString == null) {
      throw new IllegalArgumentException("The array of prefixes must not be null");
    }
    this.prefixes = new String[paramArrayOfString.length];
    System.arraycopy(paramArrayOfString, 0, this.prefixes, 0, paramArrayOfString.length);
    paramArrayOfString = paramIOCase;
    if (paramIOCase == null) {
      paramArrayOfString = IOCase.SENSITIVE;
    }
    this.caseSensitivity = paramArrayOfString;
  }
  
  public boolean accept(File paramFile)
  {
    boolean bool2 = false;
    paramFile = paramFile.getName();
    String[] arrayOfString = this.prefixes;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        String str = arrayOfString[i];
        if (this.caseSensitivity.checkStartsWith(paramFile, str)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    boolean bool2 = false;
    paramFile = this.prefixes;
    int j = paramFile.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        String str = paramFile[i];
        if (this.caseSensitivity.checkStartsWith(paramString, str)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(");
    if (this.prefixes != null)
    {
      int i = 0;
      while (i < this.prefixes.length)
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(this.prefixes[i]);
        i += 1;
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.filefilter.PrefixFileFilter
 * JD-Core Version:    0.7.0.1
 */