package com.tencent.service.update;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SoftUpdateInfo
  extends JceStruct
{
  static DiffUpdate cache_diffUpdate = new DiffUpdate();
  static ProductVersion cache_newVersion = new ProductVersion();
  static SilentDownloadInfo cache_silentDownloadInfo = new SilentDownloadInfo();
  public DiffUpdate diffUpdate = null;
  public boolean isDiffUpdateByYYB = true;
  public boolean isSilentDownload = true;
  public String market = "";
  public int newBuildno = 0;
  public String newFeature = "";
  public int newPkgSize = 0;
  public ProductVersion newVersion = null;
  public int newVersionCode = 0;
  public int noticeInterval = 0;
  public SilentDownloadInfo silentDownloadInfo = null;
  public String url = "";
  public int urlType = 0;
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final JceStruct newInit()
  {
    return new SoftUpdateInfo();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = paramJceInputStream.readString(0, false);
    this.urlType = paramJceInputStream.read(this.urlType, 1, false);
    this.newVersion = ((ProductVersion)paramJceInputStream.read(cache_newVersion, 2, false));
    this.newBuildno = paramJceInputStream.read(this.newBuildno, 3, false);
    this.newVersionCode = paramJceInputStream.read(this.newVersionCode, 4, false);
    this.newPkgSize = paramJceInputStream.read(this.newPkgSize, 5, false);
    this.newFeature = paramJceInputStream.readString(6, false);
    this.market = paramJceInputStream.readString(7, false);
    this.isSilentDownload = paramJceInputStream.read(this.isSilentDownload, 8, false);
    this.silentDownloadInfo = ((SilentDownloadInfo)paramJceInputStream.read(cache_silentDownloadInfo, 9, false));
    this.isDiffUpdateByYYB = paramJceInputStream.read(this.isDiffUpdateByYYB, 10, false);
    this.diffUpdate = ((DiffUpdate)paramJceInputStream.read(cache_diffUpdate, 11, false));
    this.noticeInterval = paramJceInputStream.read(this.noticeInterval, 12, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    int i = this.urlType;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    localObject = this.newVersion;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    i = this.newBuildno;
    if (i != 0) {
      paramJceOutputStream.write(i, 3);
    }
    i = this.newVersionCode;
    if (i != 0) {
      paramJceOutputStream.write(i, 4);
    }
    i = this.newPkgSize;
    if (i != 0) {
      paramJceOutputStream.write(i, 5);
    }
    localObject = this.newFeature;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.market;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.isSilentDownload, 8);
    localObject = this.silentDownloadInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    paramJceOutputStream.write(this.isDiffUpdateByYYB, 10);
    localObject = this.diffUpdate;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    i = this.noticeInterval;
    if (i != 0) {
      paramJceOutputStream.write(i, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.SoftUpdateInfo
 * JD-Core Version:    0.7.0.1
 */