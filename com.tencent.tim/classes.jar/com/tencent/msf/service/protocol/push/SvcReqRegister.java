package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcReqRegister
  extends JceStruct
{
  static byte[] cache_bytes_0x769_reqbody;
  static ArrayList cache_vecBindUin;
  static byte[] cache_vecDevParam = (byte[])new byte[1];
  static byte[] cache_vecGuid;
  static byte[] cache_vecServerBuf;
  public byte bIsOnline = 0;
  public byte bIsSetStatus = 0;
  public byte bIsShowOnline = 0;
  public byte bKikPC = 0;
  public byte bKikWeak = 0;
  public byte bOnlinePush = 0;
  public byte bOpenPush = 1;
  public byte bRegType = 0;
  public byte bSetMute = 0;
  public byte bSlientPush = 0;
  public byte[] bytes_0x769_reqbody = null;
  public byte cConnType = 0;
  public byte cNetType = 0;
  public byte cNotifySwitch = 1;
  public int iBatteryStatus = 0;
  public long iLargeSeq = 0L;
  public long iLastWatchStartTime = 0L;
  public int iLocaleID = 2052;
  public long iOSVersion = 0L;
  public int iStatus = 11;
  public long lBid = 0L;
  public long lCpId = 0L;
  public long lUin = 0L;
  public String sBuildVer = "";
  public String sChannelNo = "";
  public String sOther = "";
  public VendorPushInfo stVendorPushInfo = null;
  public String strDevName = "";
  public String strDevType = "";
  public String strIOSIdfa = "";
  public String strOSVer = "";
  public String strVendorName = "";
  public String strVendorOSName = "";
  public long timeStamp = 0L;
  public long uExtOnlineStatus = 0L;
  public long uNewSSOIp = 0L;
  public long uOldSSOIp = 0L;
  public ArrayList vecBindUin = null;
  public byte[] vecDevParam = null;
  public byte[] vecGuid = null;
  public byte[] vecServerBuf = null;
  
  static
  {
    ((byte[])cache_vecDevParam)[0] = 0;
    cache_vecGuid = (byte[])new byte[1];
    ((byte[])cache_vecGuid)[0] = 0;
    cache_vecBindUin = new ArrayList();
    a locala = new a();
    cache_vecBindUin.add(locala);
    cache_bytes_0x769_reqbody = (byte[])new byte[1];
    ((byte[])cache_bytes_0x769_reqbody)[0] = 0;
    cache_vecServerBuf = (byte[])new byte[1];
    ((byte[])cache_vecServerBuf)[0] = 0;
  }
  
  public SvcReqRegister() {}
  
  public SvcReqRegister(long paramLong1, long paramLong2, byte paramByte1, String paramString1, int paramInt1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, long paramLong3, long paramLong4, byte paramByte7, String paramString2, byte paramByte8, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, byte paramByte9, String paramString3, String paramString4, String paramString5, byte paramByte10, long paramLong5, long paramLong6, ArrayList paramArrayList, long paramLong7, long paramLong8, String paramString6, long paramLong9, String paramString7, String paramString8, String paramString9, byte[] paramArrayOfByte3, byte paramByte11, byte[] paramArrayOfByte4, byte paramByte12, byte paramByte13, long paramLong10, int paramInt3, VendorPushInfo paramVendorPushInfo)
  {
    this.lUin = paramLong1;
    this.lBid = paramLong2;
    this.cConnType = paramByte1;
    this.sOther = paramString1;
    this.iStatus = paramInt1;
    this.bOnlinePush = paramByte2;
    this.bIsOnline = paramByte3;
    this.bIsShowOnline = paramByte4;
    this.bKikPC = paramByte5;
    this.bKikWeak = paramByte6;
    this.timeStamp = paramLong3;
    this.iOSVersion = paramLong4;
    this.cNetType = paramByte7;
    this.sBuildVer = paramString2;
    this.bRegType = paramByte8;
    this.vecDevParam = paramArrayOfByte1;
    this.vecGuid = paramArrayOfByte2;
    this.iLocaleID = paramInt2;
    this.bSlientPush = paramByte9;
    this.strDevName = paramString3;
    this.strDevType = paramString4;
    this.strOSVer = paramString5;
    this.bOpenPush = paramByte10;
    this.iLargeSeq = paramLong5;
    this.iLastWatchStartTime = paramLong6;
    this.vecBindUin = paramArrayList;
    this.uOldSSOIp = paramLong7;
    this.uNewSSOIp = paramLong8;
    this.sChannelNo = paramString6;
    this.lCpId = paramLong9;
    this.strVendorName = paramString7;
    this.strVendorOSName = paramString8;
    this.strIOSIdfa = paramString9;
    this.bytes_0x769_reqbody = paramArrayOfByte3;
    this.bIsSetStatus = paramByte11;
    this.vecServerBuf = paramArrayOfByte4;
    this.bSetMute = paramByte12;
    this.cNotifySwitch = paramByte13;
    this.uExtOnlineStatus = paramLong10;
    this.iBatteryStatus = paramInt3;
    this.stVendorPushInfo = paramVendorPushInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.lBid = paramJceInputStream.read(this.lBid, 1, true);
    this.cConnType = paramJceInputStream.read(this.cConnType, 2, true);
    this.sOther = paramJceInputStream.readString(3, true);
    this.iStatus = paramJceInputStream.read(this.iStatus, 4, false);
    this.bOnlinePush = paramJceInputStream.read(this.bOnlinePush, 5, false);
    this.bIsOnline = paramJceInputStream.read(this.bIsOnline, 6, false);
    this.bIsShowOnline = paramJceInputStream.read(this.bIsShowOnline, 7, false);
    this.bKikPC = paramJceInputStream.read(this.bKikPC, 8, false);
    this.bKikWeak = paramJceInputStream.read(this.bKikWeak, 9, false);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 10, false);
    this.iOSVersion = paramJceInputStream.read(this.iOSVersion, 11, false);
    this.cNetType = paramJceInputStream.read(this.cNetType, 12, false);
    this.sBuildVer = paramJceInputStream.readString(13, false);
    this.bRegType = paramJceInputStream.read(this.bRegType, 14, false);
    this.vecDevParam = ((byte[])paramJceInputStream.read(cache_vecDevParam, 15, false));
    this.vecGuid = ((byte[])paramJceInputStream.read(cache_vecGuid, 16, false));
    this.iLocaleID = paramJceInputStream.read(this.iLocaleID, 17, false);
    this.bSlientPush = paramJceInputStream.read(this.bSlientPush, 18, false);
    this.strDevName = paramJceInputStream.readString(19, false);
    this.strDevType = paramJceInputStream.readString(20, false);
    this.strOSVer = paramJceInputStream.readString(21, false);
    this.bOpenPush = paramJceInputStream.read(this.bOpenPush, 22, false);
    this.iLargeSeq = paramJceInputStream.read(this.iLargeSeq, 23, false);
    this.iLastWatchStartTime = paramJceInputStream.read(this.iLastWatchStartTime, 24, false);
    this.vecBindUin = ((ArrayList)paramJceInputStream.read(cache_vecBindUin, 25, false));
    this.uOldSSOIp = paramJceInputStream.read(this.uOldSSOIp, 26, false);
    this.uNewSSOIp = paramJceInputStream.read(this.uNewSSOIp, 27, false);
    this.sChannelNo = paramJceInputStream.readString(28, false);
    this.lCpId = paramJceInputStream.read(this.lCpId, 29, false);
    this.strVendorName = paramJceInputStream.readString(30, false);
    this.strVendorOSName = paramJceInputStream.readString(31, false);
    this.strIOSIdfa = paramJceInputStream.readString(32, false);
    this.bytes_0x769_reqbody = ((byte[])paramJceInputStream.read(cache_bytes_0x769_reqbody, 33, false));
    this.bIsSetStatus = paramJceInputStream.read(this.bIsSetStatus, 34, false);
    this.vecServerBuf = ((byte[])paramJceInputStream.read(cache_vecServerBuf, 35, false));
    this.bSetMute = paramJceInputStream.read(this.bSetMute, 36, false);
    this.cNotifySwitch = paramJceInputStream.read(this.cNotifySwitch, 37, false);
    this.uExtOnlineStatus = paramJceInputStream.read(this.uExtOnlineStatus, 38, false);
    this.iBatteryStatus = paramJceInputStream.read(this.iBatteryStatus, 39, false);
    this.stVendorPushInfo = ((VendorPushInfo)paramJceInputStream.read(this.stVendorPushInfo, 42, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.lBid, 1);
    paramJceOutputStream.write(this.cConnType, 2);
    paramJceOutputStream.write(this.sOther, 3);
    paramJceOutputStream.write(this.iStatus, 4);
    paramJceOutputStream.write(this.bOnlinePush, 5);
    paramJceOutputStream.write(this.bIsOnline, 6);
    paramJceOutputStream.write(this.bIsShowOnline, 7);
    paramJceOutputStream.write(this.bKikPC, 8);
    paramJceOutputStream.write(this.bKikWeak, 9);
    paramJceOutputStream.write(this.timeStamp, 10);
    paramJceOutputStream.write(this.iOSVersion, 11);
    paramJceOutputStream.write(this.cNetType, 12);
    if (this.sBuildVer != null) {
      paramJceOutputStream.write(this.sBuildVer, 13);
    }
    paramJceOutputStream.write(this.bRegType, 14);
    if (this.vecDevParam != null) {
      paramJceOutputStream.write(this.vecDevParam, 15);
    }
    if (this.vecGuid != null) {
      paramJceOutputStream.write(this.vecGuid, 16);
    }
    paramJceOutputStream.write(this.iLocaleID, 17);
    paramJceOutputStream.write(this.bSlientPush, 18);
    if (this.strDevName != null) {
      paramJceOutputStream.write(this.strDevName, 19);
    }
    if (this.strDevType != null) {
      paramJceOutputStream.write(this.strDevType, 20);
    }
    if (this.strOSVer != null) {
      paramJceOutputStream.write(this.strOSVer, 21);
    }
    paramJceOutputStream.write(this.bOpenPush, 22);
    paramJceOutputStream.write(this.iLargeSeq, 23);
    paramJceOutputStream.write(this.iLastWatchStartTime, 24);
    if (this.vecBindUin != null) {
      paramJceOutputStream.write(this.vecBindUin, 25);
    }
    paramJceOutputStream.write(this.uOldSSOIp, 26);
    paramJceOutputStream.write(this.uNewSSOIp, 27);
    if (this.sChannelNo != null) {
      paramJceOutputStream.write(this.sChannelNo, 28);
    }
    paramJceOutputStream.write(this.lCpId, 29);
    if (this.strVendorName != null) {
      paramJceOutputStream.write(this.strVendorName, 30);
    }
    if (this.strVendorOSName != null) {
      paramJceOutputStream.write(this.strVendorOSName, 31);
    }
    if (this.strIOSIdfa != null) {
      paramJceOutputStream.write(this.strIOSIdfa, 32);
    }
    if (this.bytes_0x769_reqbody != null) {
      paramJceOutputStream.write(this.bytes_0x769_reqbody, 33);
    }
    paramJceOutputStream.write(this.bIsSetStatus, 34);
    if (this.vecServerBuf != null) {
      paramJceOutputStream.write(this.vecServerBuf, 35);
    }
    paramJceOutputStream.write(this.bSetMute, 36);
    paramJceOutputStream.write(this.cNotifySwitch, 37);
    paramJceOutputStream.write(this.uExtOnlineStatus, 38);
    paramJceOutputStream.write(this.iBatteryStatus, 39);
    if (this.stVendorPushInfo != null) {
      paramJceOutputStream.write(this.stVendorPushInfo, 42);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.SvcReqRegister
 * JD-Core Version:    0.7.0.1
 */