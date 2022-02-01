package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

class ReverseComparator
  extends AbstractFileComparator
  implements Serializable
{
  private static final long serialVersionUID = -4808255005272229056L;
  private final Comparator<File> delegate;
  
  public ReverseComparator(Comparator<File> paramComparator)
  {
    if (paramComparator == null) {
      throw new IllegalArgumentException("Delegate comparator is missing");
    }
    this.delegate = paramComparator;
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    return this.delegate.compare(paramFile2, paramFile1);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.delegate.toString() + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.comparator.ReverseComparator
 * JD-Core Version:    0.7.0.1
 */