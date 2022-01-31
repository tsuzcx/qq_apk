package OnlinePushPack;

import QQService.shareData;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class MsgInfo
  extends JceStruct
  implements Cloneable
{
  static shareData cache_stShareData;
  static byte[] cache_vAppShareCookie;
  static ArrayList cache_vCPicInfo;
  static byte[] cache_vMsg;
  static byte[] cache_vMsgCookies;
  static ArrayList cache_vNickName;
  static byte[] cache_vRemarkOfSender;
  public long lFromInstId = 0L;
  public long lFromUin = 0L;
  public long lLastChangeTime = 1L;
  public long lMsgUid = 0L;
  public short shMsgSeq = 0;
  public short shMsgType = 0;
  public shareData stShareData = null;
  public String strFromMobile = "";
  public String strFromName = "";
  public String strMsg = "";
  public long uAppShareID = 0L;
  public long uMsgTime = 0L;
  public int uRealMsgTime = 0;
  public byte[] vAppShareCookie = null;
  public ArrayList vCPicInfo = null;
  public byte[] vMsg = null;
  public byte[] vMsgCookies = null;
  public ArrayList vNickName = null;
  public byte[] vRemarkOfSender = null;
  
  static
  {
    if (!MsgInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public MsgInfo() {}
  
  public MsgInfo(long paramLong1, long paramLong2, short paramShort1, short paramShort2, String paramString1, int paramInt, byte[] paramArrayOfByte1, long paramLong3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong4, long paramLong5, ArrayList paramArrayList1, shareData paramshareData, long paramLong6, byte[] paramArrayOfByte4, String paramString2, String paramString3, ArrayList paramArrayList2)
  {
    this.lFromUin = paramLong1;
    this.uMsgTime = paramLong2;
    this.shMsgType = paramShort1;
    this.shMsgSeq = paramShort2;
    this.strMsg = paramString1;
    this.uRealMsgTime = paramInt;
    this.vMsg = paramArrayOfByte1;
    this.uAppShareID = paramLong3;
    this.vMsgCookies = paramArrayOfByte2;
    this.vAppShareCookie = paramArrayOfByte3;
    this.lMsgUid = paramLong4;
    this.lLastChangeTime = paramLong5;
    this.vCPicInfo = paramArrayList1;
    this.stShareData = paramshareData;
    this.lFromInstId = paramLong6;
    this.vRemarkOfSender = paramArrayOfByte4;
    this.strFromMobile = paramString2;
    this.strFromName = paramString3;
    this.vNickName = paramArrayList2;
  }
  
  public String className()
  {
    return "OnlinePushPack.MsgInfo";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.lFromUin, "lFromUin");
    paramStringBuilder.display(this.uMsgTime, "uMsgTime");
    paramStringBuilder.display(this.shMsgType, "shMsgType");
    paramStringBuilder.display(this.shMsgSeq, "shMsgSeq");
    paramStringBuilder.display(this.strMsg, "strMsg");
    paramStringBuilder.display(this.uRealMsgTime, "uRealMsgTime");
    paramStringBuilder.display(this.vMsg, "vMsg");
    paramStringBuilder.display(this.uAppShareID, "uAppShareID");
    paramStringBuilder.display(this.vMsgCookies, "vMsgCookies");
    paramStringBuilder.display(this.vAppShareCookie, "vAppShareCookie");
    paramStringBuilder.display(this.lMsgUid, "lMsgUid");
    paramStringBuilder.display(this.lLastChangeTime, "lLastChangeTime");
    paramStringBuilder.display(this.vCPicInfo, "vCPicInfo");
    paramStringBuilder.display(this.stShareData, "stShareData");
    paramStringBuilder.display(this.lFromInstId, "lFromInstId");
    paramStringBuilder.display(this.vRemarkOfSender, "vRemarkOfSender");
    paramStringBuilder.display(this.strFromMobile, "strFromMobile");
    paramStringBuilder.display(this.strFromName, "strFromName");
    paramStringBuilder.display(this.vNickName, "vNickName");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.lFromUin, true);
    paramStringBuilder.displaySimple(this.uMsgTime, true);
    paramStringBuilder.displaySimple(this.shMsgType, true);
    paramStringBuilder.displaySimple(this.shMsgSeq, true);
    paramStringBuilder.displaySimple(this.strMsg, true);
    paramStringBuilder.displaySimple(this.uRealMsgTime, true);
    paramStringBuilder.displaySimple(this.vMsg, true);
    paramStringBuilder.displaySimple(this.uAppShareID, true);
    paramStringBuilder.displaySimple(this.vMsgCookies, true);
    paramStringBuilder.displaySimple(this.vAppShareCookie, true);
    paramStringBuilder.displaySimple(this.lMsgUid, true);
    paramStringBuilder.displaySimple(this.lLastChangeTime, true);
    paramStringBuilder.displaySimple(this.vCPicInfo, true);
    paramStringBuilder.displaySimple(this.stShareData, true);
    paramStringBuilder.displaySimple(this.lFromInstId, true);
    paramStringBuilder.displaySimple(this.vRemarkOfSender, true);
    paramStringBuilder.displaySimple(this.strFromMobile, true);
    paramStringBuilder.displaySimple(this.strFromName, true);
    paramStringBuilder.displaySimple(this.vNickName, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (MsgInfo)paramObject;
    } while ((!JceUtil.equals(this.lFromUin, paramObject.lFromUin)) || (!JceUtil.equals(this.uMsgTime, paramObject.uMsgTime)) || (!JceUtil.equals(this.shMsgType, paramObject.shMsgType)) || (!JceUtil.equals(this.shMsgSeq, paramObject.shMsgSeq)) || (!JceUtil.equals(this.strMsg, paramObject.strMsg)) || (!JceUtil.equals(this.uRealMsgTime, paramObject.uRealMsgTime)) || (!JceUtil.equals(this.vMsg, paramObject.vMsg)) || (!JceUtil.equals(this.uAppShareID, paramObject.uAppShareID)) || (!JceUtil.equals(this.vMsgCookies, paramObject.vMsgCookies)) || (!JceUtil.equals(this.vAppShareCookie, paramObject.vAppShareCookie)) || (!JceUtil.equals(this.lMsgUid, paramObject.lMsgUid)) || (!JceUtil.equals(this.lLastChangeTime, paramObject.lLastChangeTime)) || (!JceUtil.equals(this.vCPicInfo, paramObject.vCPicInfo)) || (!JceUtil.equals(this.stShareData, paramObject.stShareData)) || (!JceUtil.equals(this.lFromInstId, paramObject.lFromInstId)) || (!JceUtil.equals(this.vRemarkOfSender, paramObject.vRemarkOfSender)) || (!JceUtil.equals(this.strFromMobile, paramObject.strFromMobile)) || (!JceUtil.equals(this.strFromName, paramObject.strFromName)) || (!JceUtil.equals(this.vNickName, paramObject.vNickName)));
    return true;
  }
  
  public String fullClassName()
  {
    return "OnlinePushPack.MsgInfo";
  }
  
  public long getLFromInstId()
  {
    return this.lFromInstId;
  }
  
  public long getLFromUin()
  {
    return this.lFromUin;
  }
  
  public long getLLastChangeTime()
  {
    return this.lLastChangeTime;
  }
  
  public long getLMsgUid()
  {
    return this.lMsgUid;
  }
  
  public short getShMsgSeq()
  {
    return this.shMsgSeq;
  }
  
  public short getShMsgType()
  {
    return this.shMsgType;
  }
  
  public shareData getStShareData()
  {
    return this.stShareData;
  }
  
  public String getStrFromMobile()
  {
    return this.strFromMobile;
  }
  
  public String getStrFromName()
  {
    return this.strFromName;
  }
  
  public String getStrMsg()
  {
    return this.strMsg;
  }
  
  public long getUAppShareID()
  {
    return this.uAppShareID;
  }
  
  public long getUMsgTime()
  {
    return this.uMsgTime;
  }
  
  public int getURealMsgTime()
  {
    return this.uRealMsgTime;
  }
  
  public byte[] getVAppShareCookie()
  {
    return this.vAppShareCookie;
  }
  
  public ArrayList getVCPicInfo()
  {
    return this.vCPicInfo;
  }
  
  public byte[] getVMsg()
  {
    return this.vMsg;
  }
  
  public byte[] getVMsgCookies()
  {
    return this.vMsgCookies;
  }
  
  public ArrayList getVNickName()
  {
    return this.vNickName;
  }
  
  public byte[] getVRemarkOfSender()
  {
    return this.vRemarkOfSender;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUin = paramJceInputStream.read(this.lFromUin, 0, true);
    this.uMsgTime = paramJceInputStream.read(this.uMsgTime, 1, true);
    this.shMsgType = paramJceInputStream.read(this.shMsgType, 2, true);
    this.shMsgSeq = paramJceInputStream.read(this.shMsgSeq, 3, true);
    this.strMsg = paramJceInputStream.readString(4, true);
    this.uRealMsgTime = paramJceInputStream.read(this.uRealMsgTime, 5, false);
    if (cache_vMsg == null)
    {
      cache_vMsg = (byte[])new byte[1];
      ((byte[])cache_vMsg)[0] = 0;
    }
    this.vMsg = ((byte[])paramJceInputStream.read(cache_vMsg, 6, false));
    this.uAppShareID = paramJceInputStream.read(this.uAppShareID, 7, false);
    if (cache_vMsgCookies == null)
    {
      cache_vMsgCookies = (byte[])new byte[1];
      ((byte[])cache_vMsgCookies)[0] = 0;
    }
    this.vMsgCookies = ((byte[])paramJceInputStream.read(cache_vMsgCookies, 8, false));
    if (cache_vAppShareCookie == null)
    {
      cache_vAppShareCookie = (byte[])new byte[1];
      ((byte[])cache_vAppShareCookie)[0] = 0;
    }
    this.vAppShareCookie = ((byte[])paramJceInputStream.read(cache_vAppShareCookie, 9, false));
    this.lMsgUid = paramJceInputStream.read(this.lMsgUid, 10, false);
    this.lLastChangeTime = paramJceInputStream.read(this.lLastChangeTime, 11, false);
    if (cache_vCPicInfo == null)
    {
      cache_vCPicInfo = new ArrayList();
      CPicInfo localCPicInfo = new CPicInfo();
      cache_vCPicInfo.add(localCPicInfo);
    }
    this.vCPicInfo = ((ArrayList)paramJceInputStream.read(cache_vCPicInfo, 12, false));
    if (cache_stShareData == null) {
      cache_stShareData = new shareData();
    }
    this.stShareData = ((shareData)paramJceInputStream.read(cache_stShareData, 13, false));
    this.lFromInstId = paramJceInputStream.read(this.lFromInstId, 14, false);
    if (cache_vRemarkOfSender == null)
    {
      cache_vRemarkOfSender = (byte[])new byte[1];
      ((byte[])cache_vRemarkOfSender)[0] = 0;
    }
    this.vRemarkOfSender = ((byte[])paramJceInputStream.read(cache_vRemarkOfSender, 15, false));
    this.strFromMobile = paramJceInputStream.readString(16, false);
    this.strFromName = paramJceInputStream.readString(17, false);
    if (cache_vNickName == null)
    {
      cache_vNickName = new ArrayList();
      cache_vNickName.add("");
    }
    this.vNickName = ((ArrayList)paramJceInputStream.read(cache_vNickName, 18, false));
  }
  
  public void setLFromInstId(long paramLong)
  {
    this.lFromInstId = paramLong;
  }
  
  public void setLFromUin(long paramLong)
  {
    this.lFromUin = paramLong;
  }
  
  public void setLLastChangeTime(long paramLong)
  {
    this.lLastChangeTime = paramLong;
  }
  
  public void setLMsgUid(long paramLong)
  {
    this.lMsgUid = paramLong;
  }
  
  public void setShMsgSeq(short paramShort)
  {
    this.shMsgSeq = paramShort;
  }
  
  public void setShMsgType(short paramShort)
  {
    this.shMsgType = paramShort;
  }
  
  public void setStShareData(shareData paramshareData)
  {
    this.stShareData = paramshareData;
  }
  
  public void setStrFromMobile(String paramString)
  {
    this.strFromMobile = paramString;
  }
  
  public void setStrFromName(String paramString)
  {
    this.strFromName = paramString;
  }
  
  public void setStrMsg(String paramString)
  {
    this.strMsg = paramString;
  }
  
  public void setUAppShareID(long paramLong)
  {
    this.uAppShareID = paramLong;
  }
  
  public void setUMsgTime(long paramLong)
  {
    this.uMsgTime = paramLong;
  }
  
  public void setURealMsgTime(int paramInt)
  {
    this.uRealMsgTime = paramInt;
  }
  
  public void setVAppShareCookie(byte[] paramArrayOfByte)
  {
    this.vAppShareCookie = paramArrayOfByte;
  }
  
  public void setVCPicInfo(ArrayList paramArrayList)
  {
    this.vCPicInfo = paramArrayList;
  }
  
  public void setVMsg(byte[] paramArrayOfByte)
  {
    this.vMsg = paramArrayOfByte;
  }
  
  public void setVMsgCookies(byte[] paramArrayOfByte)
  {
    this.vMsgCookies = paramArrayOfByte;
  }
  
  public void setVNickName(ArrayList paramArrayList)
  {
    this.vNickName = paramArrayList;
  }
  
  public void setVRemarkOfSender(byte[] paramArrayOfByte)
  {
    this.vRemarkOfSender = paramArrayOfByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUin, 0);
    paramJceOutputStream.write(this.uMsgTime, 1);
    paramJceOutputStream.write(this.shMsgType, 2);
    paramJceOutputStream.write(this.shMsgSeq, 3);
    paramJceOutputStream.write(this.strMsg, 4);
    paramJceOutputStream.write(this.uRealMsgTime, 5);
    if (this.vMsg != null) {
      paramJceOutputStream.write(this.vMsg, 6);
    }
    paramJceOutputStream.write(this.uAppShareID, 7);
    if (this.vMsgCookies != null) {
      paramJceOutputStream.write(this.vMsgCookies, 8);
    }
    if (this.vAppShareCookie != null) {
      paramJceOutputStream.write(this.vAppShareCookie, 9);
    }
    paramJceOutputStream.write(this.lMsgUid, 10);
    paramJceOutputStream.write(this.lLastChangeTime, 11);
    if (this.vCPicInfo != null) {
      paramJceOutputStream.write(this.vCPicInfo, 12);
    }
    if (this.stShareData != null) {
      paramJceOutputStream.write(this.stShareData, 13);
    }
    paramJceOutputStream.write(this.lFromInstId, 14);
    if (this.vRemarkOfSender != null) {
      paramJceOutputStream.write(this.vRemarkOfSender, 15);
    }
    if (this.strFromMobile != null) {
      paramJceOutputStream.write(this.strFromMobile, 16);
    }
    if (this.strFromName != null) {
      paramJceOutputStream.write(this.strFromName, 17);
    }
    if (this.vNickName != null) {
      paramJceOutputStream.write(this.vNickName, 18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     OnlinePushPack.MsgInfo
 * JD-Core Version:    0.7.0.1
 */