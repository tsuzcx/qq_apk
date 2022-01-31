package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class FileStoragePushFSSvcList
  extends JceStruct
{
  static BigDataChannel cache_bigDataChannel;
  static DomainIpChannel cache_domainIpChannel;
  static FmtIPInfo cache_fmtIPInfo;
  static ArrayList cache_vC2CPicDownList;
  static ArrayList cache_vGPicDownLoadList;
  static ArrayList cache_vPicDownLoadList;
  static ArrayList cache_vQzoneProxyServiceList;
  static ArrayList cache_vUpLoadList;
  static ArrayList cache_vUrlEncodeServiceList;
  static ArrayList cache_vVipEmotionList;
  public BigDataChannel bigDataChannel = null;
  public DomainIpChannel domainIpChannel = null;
  public FmtIPInfo fmtIPInfo = null;
  public ArrayList vC2CPicDownList = null;
  public ArrayList vGPicDownLoadList = null;
  public ArrayList vPicDownLoadList = null;
  public ArrayList vQzoneProxyServiceList = null;
  public ArrayList vUpLoadList = null;
  public ArrayList vUrlEncodeServiceList = null;
  public ArrayList vVipEmotionList = null;
  
  public FileStoragePushFSSvcList() {}
  
  public FileStoragePushFSSvcList(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4, ArrayList paramArrayList5, BigDataChannel paramBigDataChannel, ArrayList paramArrayList6, ArrayList paramArrayList7, FmtIPInfo paramFmtIPInfo, DomainIpChannel paramDomainIpChannel)
  {
    this.vUpLoadList = paramArrayList1;
    this.vPicDownLoadList = paramArrayList2;
    this.vGPicDownLoadList = paramArrayList3;
    this.vQzoneProxyServiceList = paramArrayList4;
    this.vUrlEncodeServiceList = paramArrayList5;
    this.bigDataChannel = paramBigDataChannel;
    this.vVipEmotionList = paramArrayList6;
    this.vC2CPicDownList = paramArrayList7;
    this.fmtIPInfo = paramFmtIPInfo;
    this.domainIpChannel = paramDomainIpChannel;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    FileStorageServerListInfo localFileStorageServerListInfo;
    if (cache_vUpLoadList == null)
    {
      cache_vUpLoadList = new ArrayList();
      localFileStorageServerListInfo = new FileStorageServerListInfo();
      cache_vUpLoadList.add(localFileStorageServerListInfo);
    }
    this.vUpLoadList = ((ArrayList)paramJceInputStream.read(cache_vUpLoadList, 0, true));
    if (cache_vPicDownLoadList == null)
    {
      cache_vPicDownLoadList = new ArrayList();
      localFileStorageServerListInfo = new FileStorageServerListInfo();
      cache_vPicDownLoadList.add(localFileStorageServerListInfo);
    }
    this.vPicDownLoadList = ((ArrayList)paramJceInputStream.read(cache_vPicDownLoadList, 1, true));
    if (cache_vGPicDownLoadList == null)
    {
      cache_vGPicDownLoadList = new ArrayList();
      localFileStorageServerListInfo = new FileStorageServerListInfo();
      cache_vGPicDownLoadList.add(localFileStorageServerListInfo);
    }
    this.vGPicDownLoadList = ((ArrayList)paramJceInputStream.read(cache_vGPicDownLoadList, 2, false));
    if (cache_vQzoneProxyServiceList == null)
    {
      cache_vQzoneProxyServiceList = new ArrayList();
      localFileStorageServerListInfo = new FileStorageServerListInfo();
      cache_vQzoneProxyServiceList.add(localFileStorageServerListInfo);
    }
    this.vQzoneProxyServiceList = ((ArrayList)paramJceInputStream.read(cache_vQzoneProxyServiceList, 3, false));
    if (cache_vUrlEncodeServiceList == null)
    {
      cache_vUrlEncodeServiceList = new ArrayList();
      localFileStorageServerListInfo = new FileStorageServerListInfo();
      cache_vUrlEncodeServiceList.add(localFileStorageServerListInfo);
    }
    this.vUrlEncodeServiceList = ((ArrayList)paramJceInputStream.read(cache_vUrlEncodeServiceList, 4, false));
    if (cache_bigDataChannel == null) {
      cache_bigDataChannel = new BigDataChannel();
    }
    this.bigDataChannel = ((BigDataChannel)paramJceInputStream.read(cache_bigDataChannel, 5, false));
    if (cache_vVipEmotionList == null)
    {
      cache_vVipEmotionList = new ArrayList();
      localFileStorageServerListInfo = new FileStorageServerListInfo();
      cache_vVipEmotionList.add(localFileStorageServerListInfo);
    }
    this.vVipEmotionList = ((ArrayList)paramJceInputStream.read(cache_vVipEmotionList, 6, false));
    if (cache_vC2CPicDownList == null)
    {
      cache_vC2CPicDownList = new ArrayList();
      localFileStorageServerListInfo = new FileStorageServerListInfo();
      cache_vC2CPicDownList.add(localFileStorageServerListInfo);
    }
    this.vC2CPicDownList = ((ArrayList)paramJceInputStream.read(cache_vC2CPicDownList, 7, false));
    if (cache_fmtIPInfo == null) {
      cache_fmtIPInfo = new FmtIPInfo();
    }
    this.fmtIPInfo = ((FmtIPInfo)paramJceInputStream.read(cache_fmtIPInfo, 8, false));
    if (cache_domainIpChannel == null) {
      cache_domainIpChannel = new DomainIpChannel();
    }
    this.domainIpChannel = ((DomainIpChannel)paramJceInputStream.read(cache_domainIpChannel, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vUpLoadList, 0);
    paramJceOutputStream.write(this.vPicDownLoadList, 1);
    if (this.vGPicDownLoadList != null) {
      paramJceOutputStream.write(this.vGPicDownLoadList, 2);
    }
    if (this.vQzoneProxyServiceList != null) {
      paramJceOutputStream.write(this.vQzoneProxyServiceList, 3);
    }
    if (this.vUrlEncodeServiceList != null) {
      paramJceOutputStream.write(this.vUrlEncodeServiceList, 4);
    }
    if (this.bigDataChannel != null) {
      paramJceOutputStream.write(this.bigDataChannel, 5);
    }
    if (this.vVipEmotionList != null) {
      paramJceOutputStream.write(this.vVipEmotionList, 6);
    }
    if (this.vC2CPicDownList != null) {
      paramJceOutputStream.write(this.vC2CPicDownList, 7);
    }
    if (this.fmtIPInfo != null) {
      paramJceOutputStream.write(this.fmtIPInfo, 8);
    }
    if (this.domainIpChannel != null) {
      paramJceOutputStream.write(this.domainIpChannel, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ConfigPush.FileStoragePushFSSvcList
 * JD-Core Version:    0.7.0.1
 */