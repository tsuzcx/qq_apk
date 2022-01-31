package com.tencent.base.os.info;

import android.os.StatFs;
import java.io.File;

public class StorageInfo
{
  private long availableSize;
  private File rootPath;
  private long totalSize;
  
  public static StorageInfo fromFile(File paramFile)
  {
    StorageInfo localStorageInfo = new StorageInfo();
    localStorageInfo.setRootPath(paramFile);
    try
    {
      paramFile = new StatFs(paramFile.getAbsolutePath());
      long l1 = paramFile.getBlockSize();
      long l2 = paramFile.getBlockCount();
      long l3 = paramFile.getAvailableBlocks();
      localStorageInfo.setTotalSize(l2 * l1);
      localStorageInfo.setAvailableSize(l3 * l1);
      return localStorageInfo;
    }
    catch (Exception paramFile)
    {
      localStorageInfo.setAvailableSize(0L);
      localStorageInfo.setTotalSize(0L);
    }
    return localStorageInfo;
  }
  
  public long getAvailableSize()
  {
    return this.availableSize;
  }
  
  public File getRootPath()
  {
    return this.rootPath;
  }
  
  public long getTotalSize()
  {
    return this.totalSize;
  }
  
  public void setAvailableSize(long paramLong)
  {
    this.availableSize = paramLong;
  }
  
  public void setRootPath(File paramFile)
  {
    this.rootPath = paramFile;
  }
  
  public void setTotalSize(long paramLong)
  {
    this.totalSize = paramLong;
  }
  
  public String toString()
  {
    return String.format("[%s : %d / %d]", new Object[] { getRootPath().getAbsolutePath(), Long.valueOf(getAvailableSize()), Long.valueOf(getTotalSize()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.base.os.info.StorageInfo
 * JD-Core Version:    0.7.0.1
 */