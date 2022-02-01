package com.tencent.android.tpns.mqtt.persist;

import java.io.File;
import java.io.FilenameFilter;

public class PersistanceFileNameFilter
  implements FilenameFilter
{
  private final String fileExtension;
  
  public PersistanceFileNameFilter(String paramString)
  {
    this.fileExtension = paramString;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.fileExtension);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.persist.PersistanceFileNameFilter
 * JD-Core Version:    0.7.0.1
 */