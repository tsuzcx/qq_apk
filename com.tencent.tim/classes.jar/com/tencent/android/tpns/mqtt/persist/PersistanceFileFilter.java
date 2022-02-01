package com.tencent.android.tpns.mqtt.persist;

import java.io.File;
import java.io.FileFilter;

public class PersistanceFileFilter
  implements FileFilter
{
  private final String fileExtension;
  
  public PersistanceFileFilter(String paramString)
  {
    this.fileExtension = paramString;
  }
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(this.fileExtension);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.persist.PersistanceFileFilter
 * JD-Core Version:    0.7.0.1
 */