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
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public JceStruct newInit()
  {
    return new SoftUpdateInfo();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
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
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 0);
    }
    if (this.urlType != 0) {
      paramJceOutputStream.write(this.urlType, 1);
    }
    if (this.newVersion != null) {
      paramJceOutputStream.write(this.newVersion, 2);
    }
    if (this.newBuildno != 0) {
      paramJceOutputStream.write(this.newBuildno, 3);
    }
    if (this.newVersionCode != 0) {
      paramJceOutputStream.write(this.newVersionCode, 4);
    }
    if (this.newPkgSize != 0) {
      paramJceOutputStream.write(this.newPkgSize, 5);
    }
    if (this.newFeature != null) {
      paramJceOutputStream.write(this.newFeature, 6);
    }
    if (this.market != null) {
      paramJceOutputStream.write(this.market, 7);
    }
    paramJceOutputStream.write(this.isSilentDownload, 8);
    if (this.silentDownloadInfo != null) {
      paramJceOutputStream.write(this.silentDownloadInfo, 9);
    }
    paramJceOutputStream.write(this.isDiffUpdateByYYB, 10);
    if (this.diffUpdate != null) {
      paramJceOutputStream.write(this.diffUpdate, 11);
    }
    if (this.noticeInterval != 0) {
      paramJceOutputStream.write(this.noticeInterval, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.SoftUpdateInfo
 * JD-Core Version:    0.7.0.1
 */