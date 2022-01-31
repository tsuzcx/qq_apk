package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespHYMakeFriendsCard
  extends JceStruct
{
  static RespHead cache_stHeader;
  static MakeFriendsCard cache_stMakeFriendsCard;
  static ArrayList cache_vFaceInfo;
  public byte bFavorited = 0;
  public byte bQzoneInfo = 0;
  public byte bShareLBS = 0;
  public byte bVoted = 0;
  public byte bWeiboInfo = 0;
  public byte cSqqLevel = 0;
  public int iLat = 900000000;
  public int iLon = 900000000;
  public int nSameFriendsNum = 0;
  public RespHead stHeader = null;
  public MakeFriendsCard stMakeFriendsCard = null;
  public String strAddress = "";
  public String strCompany = "";
  public String strCustomTelNumber = "";
  public String strSchool = "";
  public ArrayList vFaceInfo = null;
  
  public RespHYMakeFriendsCard() {}
  
  public RespHYMakeFriendsCard(RespHead paramRespHead, MakeFriendsCard paramMakeFriendsCard, byte paramByte1, byte paramByte2, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, ArrayList paramArrayList, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6)
  {
    this.stHeader = paramRespHead;
    this.stMakeFriendsCard = paramMakeFriendsCard;
    this.bWeiboInfo = paramByte1;
    this.bQzoneInfo = paramByte2;
    this.nSameFriendsNum = paramInt1;
    this.strCompany = paramString1;
    this.strSchool = paramString2;
    this.iLat = paramInt2;
    this.iLon = paramInt3;
    this.strAddress = paramString3;
    this.strCustomTelNumber = paramString4;
    this.vFaceInfo = paramArrayList;
    this.bVoted = paramByte3;
    this.bFavorited = paramByte4;
    this.bShareLBS = paramByte5;
    this.cSqqLevel = paramByte6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stMakeFriendsCard == null) {
      cache_stMakeFriendsCard = new MakeFriendsCard();
    }
    this.stMakeFriendsCard = ((MakeFriendsCard)paramJceInputStream.read(cache_stMakeFriendsCard, 1, true));
    this.bWeiboInfo = paramJceInputStream.read(this.bWeiboInfo, 2, true);
    this.bQzoneInfo = paramJceInputStream.read(this.bQzoneInfo, 3, true);
    this.nSameFriendsNum = paramJceInputStream.read(this.nSameFriendsNum, 4, true);
    this.strCompany = paramJceInputStream.readString(5, true);
    this.strSchool = paramJceInputStream.readString(6, true);
    this.iLat = paramJceInputStream.read(this.iLat, 7, false);
    this.iLon = paramJceInputStream.read(this.iLon, 8, false);
    this.strAddress = paramJceInputStream.readString(9, false);
    this.strCustomTelNumber = paramJceInputStream.readString(10, false);
    if (cache_vFaceInfo == null)
    {
      cache_vFaceInfo = new ArrayList();
      FaceInfo localFaceInfo = new FaceInfo();
      cache_vFaceInfo.add(localFaceInfo);
    }
    this.vFaceInfo = ((ArrayList)paramJceInputStream.read(cache_vFaceInfo, 11, false));
    this.bVoted = paramJceInputStream.read(this.bVoted, 12, false);
    this.bFavorited = paramJceInputStream.read(this.bFavorited, 13, false);
    this.bShareLBS = paramJceInputStream.read(this.bShareLBS, 14, false);
    this.cSqqLevel = paramJceInputStream.read(this.cSqqLevel, 15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stMakeFriendsCard, 1);
    paramJceOutputStream.write(this.bWeiboInfo, 2);
    paramJceOutputStream.write(this.bQzoneInfo, 3);
    paramJceOutputStream.write(this.nSameFriendsNum, 4);
    paramJceOutputStream.write(this.strCompany, 5);
    paramJceOutputStream.write(this.strSchool, 6);
    paramJceOutputStream.write(this.iLat, 7);
    paramJceOutputStream.write(this.iLon, 8);
    if (this.strAddress != null) {
      paramJceOutputStream.write(this.strAddress, 9);
    }
    if (this.strCustomTelNumber != null) {
      paramJceOutputStream.write(this.strCustomTelNumber, 10);
    }
    if (this.vFaceInfo != null) {
      paramJceOutputStream.write(this.vFaceInfo, 11);
    }
    paramJceOutputStream.write(this.bVoted, 12);
    paramJceOutputStream.write(this.bFavorited, 13);
    paramJceOutputStream.write(this.bShareLBS, 14);
    paramJceOutputStream.write(this.cSqqLevel, 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespHYMakeFriendsCard
 * JD-Core Version:    0.7.0.1
 */