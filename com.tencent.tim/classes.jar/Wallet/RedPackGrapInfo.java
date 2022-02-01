package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RedPackGrapInfo
  extends JceStruct
{
  static ArrayList<Long> cache_vecGrapUin = new ArrayList();
  public String hbIdiomLastPY = "";
  public int iConfType;
  public int iEffectsId;
  public int iEnvelopeId;
  public int iMsgType;
  public int iRedChannel;
  public int iRedType;
  public int iResourceType;
  public int iSkinId;
  public int iSongFlag;
  public int iSongId;
  public int iSoundRecordDuration;
  public int iSpecialPopId;
  public int iSubjectId;
  public long lCreateTime;
  public long lUin;
  public String sAuthKey = "";
  public String sBiilNo = "";
  public String sContent = "";
  public String sIndex = "";
  public String sName = "";
  public String sReserve = "";
  public String sTitle = "";
  public int seq;
  public ArrayList<Long> vecGrapUin;
  
  static
  {
    cache_vecGrapUin.add(Long.valueOf(0L));
  }
  
  public RedPackGrapInfo() {}
  
  public RedPackGrapInfo(long paramLong1, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4, int paramInt4, ArrayList<Long> paramArrayList, String paramString5, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong2, String paramString6, int paramInt12, int paramInt13, String paramString7, int paramInt14, String paramString8)
  {
    this.lUin = paramLong1;
    this.sTitle = paramString1;
    this.iRedType = paramInt1;
    this.sBiilNo = paramString2;
    this.sAuthKey = paramString3;
    this.iMsgType = paramInt2;
    this.iEnvelopeId = paramInt3;
    this.sName = paramString4;
    this.iRedChannel = paramInt4;
    this.vecGrapUin = paramArrayList;
    this.sContent = paramString5;
    this.iSoundRecordDuration = paramInt5;
    this.iResourceType = paramInt6;
    this.iSkinId = paramInt7;
    this.iEffectsId = paramInt8;
    this.iSpecialPopId = paramInt9;
    this.iConfType = paramInt10;
    this.iSubjectId = paramInt11;
    this.lCreateTime = paramLong2;
    this.sIndex = paramString6;
    this.iSongId = paramInt12;
    this.iSongFlag = paramInt13;
    this.sReserve = paramString7;
    this.seq = paramInt14;
    this.hbIdiomLastPY = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, false);
    this.sTitle = paramJceInputStream.readString(1, false);
    this.iRedType = paramJceInputStream.read(this.iRedType, 2, false);
    this.sBiilNo = paramJceInputStream.readString(3, false);
    this.sAuthKey = paramJceInputStream.readString(4, false);
    this.iMsgType = paramJceInputStream.read(this.iMsgType, 5, false);
    this.iEnvelopeId = paramJceInputStream.read(this.iEnvelopeId, 6, false);
    this.sName = paramJceInputStream.readString(7, false);
    this.iRedChannel = paramJceInputStream.read(this.iRedChannel, 8, false);
    this.vecGrapUin = ((ArrayList)paramJceInputStream.read(cache_vecGrapUin, 9, false));
    this.sContent = paramJceInputStream.readString(10, false);
    this.iSoundRecordDuration = paramJceInputStream.read(this.iSoundRecordDuration, 11, false);
    this.iResourceType = paramJceInputStream.read(this.iResourceType, 12, false);
    this.iSkinId = paramJceInputStream.read(this.iSkinId, 13, false);
    this.iEffectsId = paramJceInputStream.read(this.iEffectsId, 14, false);
    this.iSpecialPopId = paramJceInputStream.read(this.iSpecialPopId, 15, false);
    this.iConfType = paramJceInputStream.read(this.iConfType, 16, false);
    this.iSubjectId = paramJceInputStream.read(this.iSubjectId, 17, false);
    this.lCreateTime = paramJceInputStream.read(this.lCreateTime, 18, false);
    this.sIndex = paramJceInputStream.readString(19, false);
    this.iSongId = paramJceInputStream.read(this.iSongId, 20, false);
    this.iSongFlag = paramJceInputStream.read(this.iSongFlag, 21, false);
    this.sReserve = paramJceInputStream.readString(22, false);
    this.seq = paramJceInputStream.read(this.seq, 23, false);
    this.hbIdiomLastPY = paramJceInputStream.readString(24, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    if (this.sTitle != null) {
      paramJceOutputStream.write(this.sTitle, 1);
    }
    paramJceOutputStream.write(this.iRedType, 2);
    if (this.sBiilNo != null) {
      paramJceOutputStream.write(this.sBiilNo, 3);
    }
    if (this.sAuthKey != null) {
      paramJceOutputStream.write(this.sAuthKey, 4);
    }
    paramJceOutputStream.write(this.iMsgType, 5);
    paramJceOutputStream.write(this.iEnvelopeId, 6);
    if (this.sName != null) {
      paramJceOutputStream.write(this.sName, 7);
    }
    paramJceOutputStream.write(this.iRedChannel, 8);
    if (this.vecGrapUin != null) {
      paramJceOutputStream.write(this.vecGrapUin, 9);
    }
    if (this.sContent != null) {
      paramJceOutputStream.write(this.sContent, 10);
    }
    paramJceOutputStream.write(this.iSoundRecordDuration, 11);
    paramJceOutputStream.write(this.iResourceType, 12);
    paramJceOutputStream.write(this.iSkinId, 13);
    paramJceOutputStream.write(this.iEffectsId, 14);
    paramJceOutputStream.write(this.iSpecialPopId, 15);
    paramJceOutputStream.write(this.iConfType, 16);
    paramJceOutputStream.write(this.iSubjectId, 17);
    paramJceOutputStream.write(this.lCreateTime, 18);
    if (this.sIndex != null) {
      paramJceOutputStream.write(this.sIndex, 19);
    }
    paramJceOutputStream.write(this.iSongId, 20);
    paramJceOutputStream.write(this.iSongFlag, 21);
    if (this.sReserve != null) {
      paramJceOutputStream.write(this.sReserve, 22);
    }
    paramJceOutputStream.write(this.seq, 23);
    if (this.hbIdiomLastPY != null) {
      paramJceOutputStream.write(this.hbIdiomLastPY, 24);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Wallet.RedPackGrapInfo
 * JD-Core Version:    0.7.0.1
 */