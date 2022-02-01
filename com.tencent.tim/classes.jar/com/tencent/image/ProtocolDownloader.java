package com.tencent.image;

import java.io.File;
import java.net.URL;

public abstract interface ProtocolDownloader
{
  public abstract Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception;
  
  public abstract JobQueue getQueue(URL paramURL);
  
  public abstract boolean gifHasDifferentState();
  
  public abstract boolean hasDiskFile(DownloadParams paramDownloadParams);
  
  public abstract File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception;
  
  public static abstract class Adapter
    implements ProtocolDownloader
  {
    public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
      throws Exception
    {
      return null;
    }
    
    public JobQueue getQueue(URL paramURL)
    {
      return null;
    }
    
    public boolean gifHasDifferentState()
    {
      return false;
    }
    
    public boolean hasDiskFile(DownloadParams paramDownloadParams)
    {
      return false;
    }
    
    public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
      throws Exception
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.ProtocolDownloader
 * JD-Core Version:    0.7.0.1
 */