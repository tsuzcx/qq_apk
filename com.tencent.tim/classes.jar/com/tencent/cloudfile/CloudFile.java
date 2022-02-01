package com.tencent.cloudfile;

import java.util.List;

public class CloudFile
  extends CloudBase
{
  public CloudAIORecentFileExt aioRecentFileExt;
  public boolean bIsClusterFile;
  public List<CloudFile> clusterFileList;
  public int downloadStatus;
  public long duration;
  public int expireTime;
  public byte[] fileSha;
  public long fileSize;
  public int fileSrcType;
  public int fileType;
  public String finalPath;
  public int height;
  public CloudOnlineFileExt onlineFileExt;
  public long takeTime;
  public String thumbUrl;
  public int width;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.cloudfile.CloudFile
 * JD-Core Version:    0.7.0.1
 */