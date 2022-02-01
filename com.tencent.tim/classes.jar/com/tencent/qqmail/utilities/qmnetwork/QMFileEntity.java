package com.tencent.qqmail.utilities.qmnetwork;

import java.io.File;
import org.apache.http.entity.FileEntity;

public class QMFileEntity
  extends FileEntity
{
  private final String fileNameString;
  private final File mFile;
  
  public QMFileEntity(File paramFile, String paramString1, String paramString2)
  {
    super(paramFile, paramString1);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramString1 = paramFile.getName();
    }
    this.fileNameString = paramString1;
    this.mFile = paramFile;
  }
  
  public File getFile()
  {
    return this.mFile;
  }
  
  public String getFileNameString()
  {
    return this.fileNameString;
  }
  
  public String toString()
  {
    return "{file: " + this.mFile + ", size: " + this.mFile.length() + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMFileEntity
 * JD-Core Version:    0.7.0.1
 */