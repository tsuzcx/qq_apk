package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.Random;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="mUrl")
public class UniformDownloadBPTransEntity
  extends Entity
  implements Cloneable
{
  public String mFileName;
  public String mFilePath;
  public long mFileSize = 0L;
  public String mTempPath;
  @unique
  public String mUrl;
  
  public static Long genUniqId()
  {
    return Long.valueOf((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public static String tableName()
  {
    return "mr_UDLBPTrans";
  }
  
  public UniformDownloadBPTransEntity clone()
  {
    try
    {
      UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = (UniformDownloadBPTransEntity)super.clone();
      return localUniformDownloadBPTransEntity;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public void copyFrom(UniformDownloadBPTransEntity paramUniformDownloadBPTransEntity)
  {
    try
    {
      this.mUrl = paramUniformDownloadBPTransEntity.mUrl;
      this.mFileName = paramUniformDownloadBPTransEntity.mFileName;
      this.mFileSize = paramUniformDownloadBPTransEntity.mFileSize;
      this.mTempPath = paramUniformDownloadBPTransEntity.mTempPath;
      this.mFilePath = paramUniformDownloadBPTransEntity.mFilePath;
      return;
    }
    finally
    {
      paramUniformDownloadBPTransEntity = finally;
      throw paramUniformDownloadBPTransEntity;
    }
  }
  
  public String getTableName()
  {
    return "mr_UDLBPTrans";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloadBPTransEntity
 * JD-Core Version:    0.7.0.1
 */