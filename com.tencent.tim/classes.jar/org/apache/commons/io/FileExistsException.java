package org.apache.commons.io;

import java.io.File;
import java.io.IOException;

public class FileExistsException
  extends IOException
{
  private static final long serialVersionUID = 1L;
  
  public FileExistsException() {}
  
  public FileExistsException(File paramFile)
  {
    super("File " + paramFile + " exists");
  }
  
  public FileExistsException(String paramString)
  {
    super(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.FileExistsException
 * JD-Core Version:    0.7.0.1
 */