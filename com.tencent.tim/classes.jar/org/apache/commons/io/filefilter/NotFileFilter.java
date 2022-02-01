package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class NotFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private static final long serialVersionUID = 6131563330944994230L;
  private final IOFileFilter filter;
  
  public NotFileFilter(IOFileFilter paramIOFileFilter)
  {
    if (paramIOFileFilter == null) {
      throw new IllegalArgumentException("The filter must not be null");
    }
    this.filter = paramIOFileFilter;
  }
  
  public boolean accept(File paramFile)
  {
    return !this.filter.accept(paramFile);
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return !this.filter.accept(paramFile, paramString);
  }
  
  public String toString()
  {
    return super.toString() + "(" + this.filter.toString() + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.filefilter.NotFileFilter
 * JD-Core Version:    0.7.0.1
 */