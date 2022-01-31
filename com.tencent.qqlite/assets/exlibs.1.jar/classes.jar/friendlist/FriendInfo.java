package friendlist;

import QQService.VipBaseInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FriendInfo
  extends JceStruct
{
  static int cache_eIconType;
  static int cache_eNetworkType;
  static VipBaseInfo cache_oVipInfo;
  static byte[] cache_vecIMGroupID;
  static byte[] cache_vecMSFGroupID;
  static byte[] cache_vecRing;
  public byte cNetwork = 0;
  public byte cSpecialFlag = 0;
  public byte detalStatusFlag = 0;
  public int eIconType = 0;
  public int eNetworkType = 0;
  public short faceId = 0;
  public long friendUin = 0L;
  public byte groupId = 0;
  public int iTermType = 0;
  public byte isIphoneOnline = 0;
  public byte isMqqOnLine = 0;
  public byte isRemark = 0;
  public byte memberLevel = 0;
  public String nick = "";
  public VipBaseInfo oVipInfo = null;
  public String remark = "";
  public String sShowName = "";
  public byte sqqOnLineState = 0;
  public byte sqqOnLineStateV2 = 0;
  public byte sqqtype = 0;
  public byte status = 20;
  public String strTermDesc = "";
  public long uAbiFlag = 0L;
  public long uColorRing = 0L;
  public long uVipFont = 0L;
  public long ulFaceAddonId = 0L;
  public byte[] vecIMGroupID = null;
  public byte[] vecMSFGroupID = null;
  public byte[] vecRing = null;
  
  public FriendInfo() {}
  
  public FriendInfo(long paramLong1, byte paramByte1, short paramShort, String paramString1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8, byte paramByte9, String paramString2, byte paramByte10, String paramString3, byte paramByte11, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, VipBaseInfo paramVipBaseInfo, byte paramByte12, byte[] paramArrayOfByte3, long paramLong2, long paramLong3, int paramInt2, long paramLong4, int paramInt3, String paramString4, long paramLong5)
  {
    this.friendUin = paramLong1;
    this.groupId = paramByte1;
    this.faceId = paramShort;
    this.remark = paramString1;
    this.sqqtype = paramByte2;
    this.status = paramByte3;
    this.memberLevel = paramByte4;
    this.isMqqOnLine = paramByte5;
    this.sqqOnLineState = paramByte6;
    this.isIphoneOnline = paramByte7;
    this.detalStatusFlag = paramByte8;
    this.sqqOnLineStateV2 = paramByte9;
    this.sShowName = paramString2;
    this.isRemark = paramByte10;
    this.nick = paramString3;
    this.cSpecialFlag = paramByte11;
    this.vecIMGroupID = paramArrayOfByte1;
    this.vecMSFGroupID = paramArrayOfByte2;
    this.iTermType = paramInt1;
    this.oVipInfo = paramVipBaseInfo;
    this.cNetwork = paramByte12;
    this.vecRing = paramArrayOfByte3;
    this.uAbiFlag = paramLong2;
    this.ulFaceAddonId = paramLong3;
    this.eNetworkType = paramInt2;
    this.uVipFont = paramLong4;
    this.eIconType = paramInt3;
    this.strTermDesc = paramString4;
    this.uColorRing = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.friendUin = paramJceInputStream.read(this.friendUin, 0, true);
    this.groupId = paramJceInputStream.read(this.groupId, 1, true);
    this.faceId = paramJceInputStream.read(this.faceId, 2, true);
    this.remark = paramJceInputStream.readString(3, true);
    this.sqqtype = paramJceInputStream.read(this.sqqtype, 4, true);
    this.status = paramJceInputStream.read(this.status, 5, true);
    this.memberLevel = paramJceInputStream.read(this.memberLevel, 6, false);
    this.isMqqOnLine = paramJceInputStream.read(this.isMqqOnLine, 7, false);
    this.sqqOnLineState = paramJceInputStream.read(this.sqqOnLineState, 8, false);
    this.isIphoneOnline = paramJceInputStream.read(this.isIphoneOnline, 9, false);
    this.detalStatusFlag = paramJceInputStream.read(this.detalStatusFlag, 10, false);
    this.sqqOnLineStateV2 = paramJceInputStream.read(this.sqqOnLineStateV2, 11, false);
    this.sShowName = paramJceInputStream.readString(12, false);
    this.isRemark = paramJceInputStream.read(this.isRemark, 13, false);
    this.nick = paramJceInputStream.readString(14, false);
    this.cSpecialFlag = paramJceInputStream.read(this.cSpecialFlag, 15, false);
    if (cache_vecIMGroupID == null)
    {
      cache_vecIMGroupID = (byte[])new byte[1];
      ((byte[])cache_vecIMGroupID)[0] = 0;
    }
    this.vecIMGroupID = ((byte[])paramJceInputStream.read(cache_vecIMGroupID, 16, false));
    if (cache_vecMSFGroupID == null)
    {
      cache_vecMSFGroupID = (byte[])new byte[1];
      ((byte[])cache_vecMSFGroupID)[0] = 0;
    }
    this.vecMSFGroupID = ((byte[])paramJceInputStream.read(cache_vecMSFGroupID, 17, false));
    this.iTermType = paramJceInputStream.read(this.iTermType, 18, false);
    if (cache_oVipInfo == null) {
      cache_oVipInfo = new VipBaseInfo();
    }
    this.oVipInfo = ((VipBaseInfo)paramJceInputStream.read(cache_oVipInfo, 19, false));
    this.cNetwork = paramJceInputStream.read(this.cNetwork, 20, false);
    if (cache_vecRing == null)
    {
      cache_vecRing = (byte[])new byte[1];
      ((byte[])cache_vecRing)[0] = 0;
    }
    this.vecRing = ((byte[])paramJceInputStream.read(cache_vecRing, 21, false));
    this.uAbiFlag = paramJceInputStream.read(this.uAbiFlag, 22, false);
    this.ulFaceAddonId = paramJceInputStream.read(this.ulFaceAddonId, 23, false);
    this.eNetworkType = paramJceInputStream.read(this.eNetworkType, 24, false);
    this.uVipFont = paramJceInputStream.read(this.uVipFont, 25, false);
    this.eIconType = paramJceInputStream.read(this.eIconType, 26, false);
    this.strTermDesc = paramJceInputStream.readString(27, false);
    this.uColorRing = paramJceInputStream.read(this.uColorRing, 28, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.friendUin, 0);
    paramJceOutputStream.write(this.groupId, 1);
    paramJceOutputStream.write(this.faceId, 2);
    paramJceOutputStream.write(this.remark, 3);
    paramJceOutputStream.write(this.sqqtype, 4);
    paramJceOutputStream.write(this.status, 5);
    paramJceOutputStream.write(this.memberLevel, 6);
    paramJceOutputStream.write(this.isMqqOnLine, 7);
    paramJceOutputStream.write(this.sqqOnLineState, 8);
    paramJceOutputStream.write(this.isIphoneOnline, 9);
    paramJceOutputStream.write(this.detalStatusFlag, 10);
    paramJceOutputStream.write(this.sqqOnLineStateV2, 11);
    if (this.sShowName != null) {
      paramJceOutputStream.write(this.sShowName, 12);
    }
    paramJceOutputStream.write(this.isRemark, 13);
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 14);
    }
    paramJceOutputStream.write(this.cSpecialFlag, 15);
    if (this.vecIMGroupID != null) {
      paramJceOutputStream.write(this.vecIMGroupID, 16);
    }
    if (this.vecMSFGroupID != null) {
      paramJceOutputStream.write(this.vecMSFGroupID, 17);
    }
    paramJceOutputStream.write(this.iTermType, 18);
    if (this.oVipInfo != null) {
      paramJceOutputStream.write(this.oVipInfo, 19);
    }
    paramJceOutputStream.write(this.cNetwork, 20);
    if (this.vecRing != null) {
      paramJceOutputStream.write(this.vecRing, 21);
    }
    paramJceOutputStream.write(this.uAbiFlag, 22);
    paramJceOutputStream.write(this.ulFaceAddonId, 23);
    paramJceOutputStream.write(this.eNetworkType, 24);
    paramJceOutputStream.write(this.uVipFont, 25);
    paramJceOutputStream.write(this.eIconType, 26);
    if (this.strTermDesc != null) {
      paramJceOutputStream.write(this.strTermDesc, 27);
    }
    paramJceOutputStream.write(this.uColorRing, 28);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     friendlist.FriendInfo
 * JD-Core Version:    0.7.0.1
 */