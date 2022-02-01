package com.tencent.tim.cloudfile.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class CloudFileUserInfo
  extends Entity
{
  public static final long DEFAULT_TOTAL_SPACE = 10737418240L;
  public static final long DEFAULT_UPLOAD_LIMIT_SIZE = 104857600L;
  public byte[] aioRecentFolderId;
  public String aioRecentFolderName;
  public int allItemCount;
  public byte[] defaultAddFolderId;
  public String defaultAddFolderName;
  @unique
  public byte[] rootDirKey;
  public long totalSpace = 10737418240L;
  public long uploadFileLimit;
  public long usedSpace;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.data.CloudFileUserInfo
 * JD-Core Version:    0.7.0.1
 */