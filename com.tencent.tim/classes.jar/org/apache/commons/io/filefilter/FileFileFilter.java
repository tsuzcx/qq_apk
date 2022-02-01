package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class FileFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  public static final IOFileFilter FILE = new FileFileFilter();
  private static final long serialVersionUID = 5345244090827540862L;
  
  public boolean accept(File paramFile)
  {
    return paramFile.isFile();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.filefilter.FileFileFilter
 * JD-Core Version:    0.7.0.1
 */