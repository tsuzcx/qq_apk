package EncounterSvc;

import QQService.VipBaseInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespEncounterInfo
  extends JceStruct
{
  static int cache_eMerchantType;
  static int cache_eUserIdentityType;
  static RishState cache_richState;
  static byte[] cache_sig;
  static byte[] cache_vDateInfo;
  static byte[] cache_vFaceID;
  static byte[] cache_vIntroContent;
  static VipBaseInfo cache_vipBaseInfo;
  public byte authFlag = 0;
  public byte bIsSingle = 0;
  public byte cAge = -1;
  public byte cGroupId = 0;
  public byte cSex = -1;
  public byte cSpecialFlag = 0;
  public int common_face_timestamp = 0;
  public byte constellation = 0;
  public int eMerchantType = 0;
  public int eUserIdentityType = 0;
  public String enc_id = "";
  public int iDistance = -1;
  public int iLat = 900000000;
  public int iLon = 900000000;
  public int iRank = 0;
  public int iVoteIncrement = -1;
  public byte is_trav = 0;
  public long lEctID = 0L;
  public int lTime = 0;
  public long lTotalVisitorsNum = 0L;
  public byte marriage = 0;
  public int nFaceNum = 0;
  public int profession_id = 0;
  public RishState richState = null;
  public short shIntroType = 0;
  public byte[] sig = null;
  public String strCertification = "";
  public String strCompanyName = "";
  public String strDescription = "";
  public String strNick = "";
  public String strPYFaceUrl = "";
  public String strPYName = "";
  public String strSchoolName = "";
  public int stranger_face_timestamp = 0;
  public long tiny_id = 0L;
  public String uid = "";
  public byte[] vDateInfo = null;
  public byte[] vFaceID = null;
  public byte[] vIntroContent = null;
  public VipBaseInfo vipBaseInfo = null;
  public short wFace = 0;
  
  public RespEncounterInfo() {}
  
  public RespEncounterInfo(long paramLong1, int paramInt1, int paramInt2, String paramString1, short paramShort1, byte paramByte1, byte paramByte2, String paramString2, byte paramByte3, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7, short paramShort2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, int paramInt6, byte paramByte4, int paramInt7, int paramInt8, int paramInt9, long paramLong2, byte paramByte5, VipBaseInfo paramVipBaseInfo, RishState paramRishState, byte[] paramArrayOfByte3, String paramString8, String paramString9, byte paramByte6, byte paramByte7, int paramInt10, byte[] paramArrayOfByte4, byte paramByte8, long paramLong3, int paramInt11, int paramInt12, byte paramByte9)
  {
    this.lEctID = paramLong1;
    this.iDistance = paramInt1;
    this.lTime = paramInt2;
    this.strDescription = paramString1;
    this.wFace = paramShort1;
    this.cSex = paramByte1;
    this.cAge = paramByte2;
    this.strNick = paramString2;
    this.cGroupId = paramByte3;
    this.strPYFaceUrl = paramString3;
    this.strSchoolName = paramString4;
    this.strCompanyName = paramString5;
    this.strPYName = paramString6;
    this.nFaceNum = paramInt3;
    this.strCertification = paramString7;
    this.shIntroType = paramShort2;
    this.vIntroContent = paramArrayOfByte1;
    this.vFaceID = paramArrayOfByte2;
    this.eMerchantType = paramInt4;
    this.eUserIdentityType = paramInt5;
    this.iVoteIncrement = paramInt6;
    this.bIsSingle = paramByte4;
    this.iLat = paramInt7;
    this.iLon = paramInt8;
    this.iRank = paramInt9;
    this.lTotalVisitorsNum = paramLong2;
    this.cSpecialFlag = paramByte5;
    this.vipBaseInfo = paramVipBaseInfo;
    this.richState = paramRishState;
    this.sig = paramArrayOfByte3;
    this.enc_id = paramString8;
    this.uid = paramString9;
    this.is_trav = paramByte6;
    this.constellation = paramByte7;
    this.profession_id = paramInt10;
    this.vDateInfo = paramArrayOfByte4;
    this.marriage = paramByte8;
    this.tiny_id = paramLong3;
    this.common_face_timestamp = paramInt11;
    this.stranger_face_timestamp = paramInt12;
    this.authFlag = paramByte9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lEctID = paramJceInputStream.read(this.lEctID, 0, true);
    this.iDistance = paramJceInputStream.read(this.iDistance, 1, true);
    this.lTime = paramJceInputStream.read(this.lTime, 2, true);
    this.strDescription = paramJceInputStream.readString(3, true);
    this.wFace = paramJceInputStream.read(this.wFace, 4, true);
    this.cSex = paramJceInputStream.read(this.cSex, 5, true);
    this.cAge = paramJceInputStream.read(this.cAge, 6, true);
    this.strNick = paramJceInputStream.readString(7, true);
    this.cGroupId = paramJceInputStream.read(this.cGroupId, 8, false);
    this.strPYFaceUrl = paramJceInputStream.readString(9, false);
    this.strSchoolName = paramJceInputStream.readString(10, false);
    this.strCompanyName = paramJceInputStream.readString(11, false);
    this.strPYName = paramJceInputStream.readString(12, false);
    this.nFaceNum = paramJceInputStream.read(this.nFaceNum, 13, false);
    this.strCertification = paramJceInputStream.readString(14, false);
    this.shIntroType = paramJceInputStream.read(this.shIntroType, 15, false);
    if (cache_vIntroContent == null)
    {
      cache_vIntroContent = (byte[])new byte[1];
      ((byte[])cache_vIntroContent)[0] = 0;
    }
    this.vIntroContent = ((byte[])paramJceInputStream.read(cache_vIntroContent, 16, false));
    if (cache_vFaceID == null)
    {
      cache_vFaceID = (byte[])new byte[1];
      ((byte[])cache_vFaceID)[0] = 0;
    }
    this.vFaceID = ((byte[])paramJceInputStream.read(cache_vFaceID, 17, false));
    this.eMerchantType = paramJceInputStream.read(this.eMerchantType, 18, false);
    this.eUserIdentityType = paramJceInputStream.read(this.eUserIdentityType, 19, false);
    this.iVoteIncrement = paramJceInputStream.read(this.iVoteIncrement, 20, false);
    this.bIsSingle = paramJceInputStream.read(this.bIsSingle, 21, false);
    this.iLat = paramJceInputStream.read(this.iLat, 22, false);
    this.iLon = paramJceInputStream.read(this.iLon, 23, false);
    this.iRank = paramJceInputStream.read(this.iRank, 24, false);
    this.lTotalVisitorsNum = paramJceInputStream.read(this.lTotalVisitorsNum, 25, false);
    this.cSpecialFlag = paramJceInputStream.read(this.cSpecialFlag, 26, false);
    if (cache_vipBaseInfo == null) {
      cache_vipBaseInfo = new VipBaseInfo();
    }
    this.vipBaseInfo = ((VipBaseInfo)paramJceInputStream.read(cache_vipBaseInfo, 27, false));
    if (cache_richState == null) {
      cache_richState = new RishState();
    }
    this.richState = ((RishState)paramJceInputStream.read(cache_richState, 28, false));
    if (cache_sig == null)
    {
      cache_sig = (byte[])new byte[1];
      ((byte[])cache_sig)[0] = 0;
    }
    this.sig = ((byte[])paramJceInputStream.read(cache_sig, 29, false));
    this.enc_id = paramJceInputStream.readString(30, false);
    this.uid = paramJceInputStream.readString(31, false);
    this.is_trav = paramJceInputStream.read(this.is_trav, 32, false);
    this.constellation = paramJceInputStream.read(this.constellation, 33, false);
    this.profession_id = paramJceInputStream.read(this.profession_id, 34, false);
    if (cache_vDateInfo == null)
    {
      cache_vDateInfo = (byte[])new byte[1];
      ((byte[])cache_vDateInfo)[0] = 0;
    }
    this.vDateInfo = ((byte[])paramJceInputStream.read(cache_vDateInfo, 35, false));
    this.marriage = paramJceInputStream.read(this.marriage, 36, false);
    this.tiny_id = paramJceInputStream.read(this.tiny_id, 37, false);
    this.common_face_timestamp = paramJceInputStream.read(this.common_face_timestamp, 38, false);
    this.stranger_face_timestamp = paramJceInputStream.read(this.stranger_face_timestamp, 39, false);
    this.authFlag = paramJceInputStream.read(this.authFlag, 40, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lEctID, 0);
    paramJceOutputStream.write(this.iDistance, 1);
    paramJceOutputStream.write(this.lTime, 2);
    paramJceOutputStream.write(this.strDescription, 3);
    paramJceOutputStream.write(this.wFace, 4);
    paramJceOutputStream.write(this.cSex, 5);
    paramJceOutputStream.write(this.cAge, 6);
    paramJceOutputStream.write(this.strNick, 7);
    paramJceOutputStream.write(this.cGroupId, 8);
    if (this.strPYFaceUrl != null) {
      paramJceOutputStream.write(this.strPYFaceUrl, 9);
    }
    if (this.strSchoolName != null) {
      paramJceOutputStream.write(this.strSchoolName, 10);
    }
    if (this.strCompanyName != null) {
      paramJceOutputStream.write(this.strCompanyName, 11);
    }
    if (this.strPYName != null) {
      paramJceOutputStream.write(this.strPYName, 12);
    }
    paramJceOutputStream.write(this.nFaceNum, 13);
    if (this.strCertification != null) {
      paramJceOutputStream.write(this.strCertification, 14);
    }
    paramJceOutputStream.write(this.shIntroType, 15);
    if (this.vIntroContent != null) {
      paramJceOutputStream.write(this.vIntroContent, 16);
    }
    if (this.vFaceID != null) {
      paramJceOutputStream.write(this.vFaceID, 17);
    }
    paramJceOutputStream.write(this.eMerchantType, 18);
    paramJceOutputStream.write(this.eUserIdentityType, 19);
    paramJceOutputStream.write(this.iVoteIncrement, 20);
    paramJceOutputStream.write(this.bIsSingle, 21);
    paramJceOutputStream.write(this.iLat, 22);
    paramJceOutputStream.write(this.iLon, 23);
    paramJceOutputStream.write(this.iRank, 24);
    paramJceOutputStream.write(this.lTotalVisitorsNum, 25);
    paramJceOutputStream.write(this.cSpecialFlag, 26);
    if (this.vipBaseInfo != null) {
      paramJceOutputStream.write(this.vipBaseInfo, 27);
    }
    if (this.richState != null) {
      paramJceOutputStream.write(this.richState, 28);
    }
    if (this.sig != null) {
      paramJceOutputStream.write(this.sig, 29);
    }
    if (this.enc_id != null) {
      paramJceOutputStream.write(this.enc_id, 30);
    }
    if (this.uid != null) {
      paramJceOutputStream.write(this.uid, 31);
    }
    paramJceOutputStream.write(this.is_trav, 32);
    paramJceOutputStream.write(this.constellation, 33);
    paramJceOutputStream.write(this.profession_id, 34);
    if (this.vDateInfo != null) {
      paramJceOutputStream.write(this.vDateInfo, 35);
    }
    paramJceOutputStream.write(this.marriage, 36);
    paramJceOutputStream.write(this.tiny_id, 37);
    paramJceOutputStream.write(this.common_face_timestamp, 38);
    paramJceOutputStream.write(this.stranger_face_timestamp, 39);
    paramJceOutputStream.write(this.authFlag, 40);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     EncounterSvc.RespEncounterInfo
 * JD-Core Version:    0.7.0.1
 */