package EncounterSvc;

import NeighborComm.MerchantType;
import NeighborComm.UserIdentityType;
import QQService.VipBaseInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.richstatus.RichStatus;

public final class RespEncounterInfo
  extends JceStruct
{
  static int cache_eMerchantType;
  static int cache_eUserIdentityType;
  static RishState cache_richState;
  static byte[] cache_sig;
  static byte[] cache_vFaceID;
  static byte[] cache_vIntroContent;
  static VipBaseInfo cache_vipBaseInfo;
  public byte bIsSingle = 0;
  public byte cAge = -1;
  public byte cGroupId = 0;
  public byte cSex = -1;
  public byte cSpecialFlag = 0;
  public int eMerchantType = MerchantType.MerchantType_Nomal.value();
  public int eUserIdentityType = UserIdentityType.UserIdentityType_Nomal.value();
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
  public int nFaceNum = 0;
  public RishState richState = null;
  private transient RichStatus rs;
  public short shIntroType = 0;
  public byte[] sig = null;
  public String strCertification = "";
  public String strCompanyName = "";
  public String strDescription = "";
  public String strNick = "";
  public String strPYFaceUrl = "";
  public String strPYName = "";
  public String strSchoolName = "";
  public String uid = "";
  public byte[] vFaceID = null;
  public byte[] vIntroContent = null;
  public VipBaseInfo vipBaseInfo = null;
  public short wFace = 0;
  
  public RichStatus getRichStatus()
  {
    if ((this.rs == null) && (this.richState != null))
    {
      this.rs = RichStatus.a(this.richState.vState);
      this.rs.a = this.richState.uModifyTime;
    }
    return this.rs;
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
    if (cache_vIntroContent == null) {
      cache_vIntroContent = (byte[])new byte[1];
    }
    this.vIntroContent = ((byte[])paramJceInputStream.read(cache_vIntroContent, 16, false));
    if (cache_vFaceID == null) {
      cache_vFaceID = (byte[])new byte[1];
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
    if (cache_sig == null) {
      cache_sig = (byte[])new byte[1];
    }
    this.sig = ((byte[])paramJceInputStream.read(this.sig, 29, false));
    this.enc_id = paramJceInputStream.readString(30, false);
    this.uid = paramJceInputStream.readString(31, false);
    this.is_trav = paramJceInputStream.read(this.is_trav, 32, false);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     EncounterSvc.RespEncounterInfo
 * JD-Core Version:    0.7.0.1
 */