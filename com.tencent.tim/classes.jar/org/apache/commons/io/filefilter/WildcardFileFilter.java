package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

public class WildcardFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private static final long serialVersionUID = -7426486598995782105L;
  private final IOCase caseSensitivity;
  private final String[] wildcards;
  
  public WildcardFileFilter(String paramString)
  {
    this(paramString, IOCase.SENSITIVE);
  }
  
  public WildcardFileFilter(String paramString, IOCase paramIOCase)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("The wildcard must not be null");
    }
    this.wildcards = new String[] { paramString };
    paramString = paramIOCase;
    if (paramIOCase == null) {
      paramString = IOCase.SENSITIVE;
    }
    this.caseSensitivity = paramString;
  }
  
  public WildcardFileFilter(List<String> paramList)
  {
    this(paramList, IOCase.SENSITIVE);
  }
  
  public WildcardFileFilter(List<String> paramList, IOCase paramIOCase)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("The wildcard list must not be null");
    }
    this.wildcards = ((String[])paramList.toArray(new String[paramList.size()]));
    paramList = paramIOCase;
    if (paramIOCase == null) {
      paramList = IOCase.SENSITIVE;
    }
    this.caseSensitivity = paramList;
  }
  
  public WildcardFileFilter(String[] paramArrayOfString)
  {
    this(paramArrayOfString, IOCase.SENSITIVE);
  }
  
  public WildcardFileFilter(String[] paramArrayOfString, IOCase paramIOCase)
  {
    if (paramArrayOfString == null) {
      throw new IllegalArgumentException("The wildcard array must not be null");
    }
    this.wildcards = new String[paramArrayOfString.length];
    System.arraycopy(paramArrayOfString, 0, this.wildcards, 0, paramArrayOfString.length);
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
    String[] arrayOfString = this.wildcards;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (FilenameUtils.wildcardMatch(paramFile, arrayOfString[i], this.caseSensitivity)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    boolean bool2 = false;
    paramFile = this.wildcards;
    int j = paramFile.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (FilenameUtils.wildcardMatch(paramString, paramFile[i], this.caseSensitivity)) {
          bool1 = true;
        }
      }
      else {
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
    if (this.wildcards != null)
    {
      int i = 0;
      while (i < this.wildcards.length)
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(this.wildcards[i]);
        i += 1;
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.filefilter.WildcardFileFilter
 * JD-Core Version:    0.7.0.1
 */