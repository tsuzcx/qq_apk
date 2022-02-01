package com.tencent.mobileqq.apollo.data;

import com.tencent.mobileqq.persistence.Entity;
import java.io.Serializable;

public class ApolloPreDownloadData
  extends Entity
  implements Serializable
{
  public static final int DOWNLOAD_STATUS_FAILED = 0;
  public static final int DOWNLOAD_STATUS_SUCCESS = 1;
  public String dir;
  public int dirType;
  public long endTime;
  public String maxVer;
  public String md5;
  public String minVer;
  public String reportId;
  public String resId;
  public int status;
  public String url;
  public int version;
  public String zipDir;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.data.ApolloPreDownloadData
 * JD-Core Version:    0.7.0.1
 */