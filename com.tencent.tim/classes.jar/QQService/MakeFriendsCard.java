package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MakeFriendsCard
  extends JceStruct
{
  static int cache_eUserIdentityType;
  static Intro cache_stIntro;
  static byte[] cache_vBackground;
  static byte[] cache_vQQFaceID;
  static ArrayList<TagInfo> cache_vTags;
  public byte bSingle;
  public int eUserIdentityType = UserIdentityType.UserIdentityType_Nomal.value();
  public int iFaceNum;
  public int iQQLevel;
  public long lFavoriteCount;
  public long lVisitCount;
  public long lVoteCount;
  public int nFaceID;
  public short shAge;
  public short shGender;
  public Intro stIntro;
  public String strCertificationInfo = "";
  public String strNick = "";
  public int uFaceTimeStamp;
  public byte[] vBackground;
  public byte[] vQQFaceID;
  public ArrayList<TagInfo> vTags;
  
  public MakeFriendsCard() {}
  
  public MakeFriendsCard(String paramString1, short paramShort1, short paramShort2, int paramInt1, String paramString2, Intro paramIntro, int paramInt2, byte[] paramArrayOfByte1, byte paramByte, long paramLong1, long paramLong2, ArrayList<TagInfo> paramArrayList, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, long paramLong3, int paramInt5)
  {
    this.strNick = paramString1;
    this.shGender = paramShort1;
    this.shAge = paramShort2;
    this.nFaceID = paramInt1;
    this.strCertificationInfo = paramString2;
    this.stIntro = paramIntro;
    this.uFaceTimeStamp = paramInt2;
    this.vQQFaceID = paramArrayOfByte1;
    this.bSingle = paramByte;
    this.lVisitCount = paramLong1;
    this.lVoteCount = paramLong2;
    this.vTags = paramArrayList;
    this.eUserIdentityType = paramInt3;
    this.vBackground = paramArrayOfByte2;
    this.iFaceNum = paramInt4;
    this.lFavoriteCount = paramLong3;
    this.iQQLevel = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strNick = paramJceInputStream.readString(0, true);
    this.shGender = paramJceInputStream.read(this.shGender, 1, true);
    this.shAge = paramJceInputStream.read(this.shAge, 2, true);
    this.nFaceID = paramJceInputStream.read(this.nFaceID, 3, true);
    this.strCertificationInfo = paramJceInputStream.readString(4, true);
    if (cache_stIntro == null) {
      cache_stIntro = new Intro();
    }
    this.stIntro = ((Intro)paramJceInputStream.read(cache_stIntro, 5, true));
    this.uFaceTimeStamp = paramJceInputStream.read(this.uFaceTimeStamp, 6, true);
    if (cache_vQQFaceID == null)
    {
      cache_vQQFaceID = (byte[])new byte[1];
      ((byte[])cache_vQQFaceID)[0] = 0;
    }
    this.vQQFaceID = ((byte[])paramJceInputStream.read(cache_vQQFaceID, 7, true));
    this.bSingle = paramJceInputStream.read(this.bSingle, 8, false);
    this.lVisitCount = paramJceInputStream.read(this.lVisitCount, 9, false);
    this.lVoteCount = paramJceInputStream.read(this.lVoteCount, 10, false);
    if (cache_vTags == null)
    {
      cache_vTags = new ArrayList();
      TagInfo localTagInfo = new TagInfo();
      cache_vTags.add(localTagInfo);
    }
    this.vTags = ((ArrayList)paramJceInputStream.read(cache_vTags, 11, false));
    this.eUserIdentityType = paramJceInputStream.read(this.eUserIdentityType, 12, false);
    if (cache_vBackground == null)
    {
      cache_vBackground = (byte[])new byte[1];
      ((byte[])cache_vBackground)[0] = 0;
    }
    this.vBackground = ((byte[])paramJceInputStream.read(cache_vBackground, 13, false));
    this.iFaceNum = paramJceInputStream.read(this.iFaceNum, 14, false);
    this.lFavoriteCount = paramJceInputStream.read(this.lFavoriteCount, 15, false);
    this.iQQLevel = paramJceInputStream.read(this.iQQLevel, 16, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strNick, 0);
    paramJceOutputStream.write(this.shGender, 1);
    paramJceOutputStream.write(this.shAge, 2);
    paramJceOutputStream.write(this.nFaceID, 3);
    paramJceOutputStream.write(this.strCertificationInfo, 4);
    paramJceOutputStream.write(this.stIntro, 5);
    paramJceOutputStream.write(this.uFaceTimeStamp, 6);
    paramJceOutputStream.write(this.vQQFaceID, 7);
    paramJceOutputStream.write(this.bSingle, 8);
    paramJceOutputStream.write(this.lVisitCount, 9);
    paramJceOutputStream.write(this.lVoteCount, 10);
    if (this.vTags != null) {
      paramJceOutputStream.write(this.vTags, 11);
    }
    paramJceOutputStream.write(this.eUserIdentityType, 12);
    if (this.vBackground != null) {
      paramJceOutputStream.write(this.vBackground, 13);
    }
    paramJceOutputStream.write(this.iFaceNum, 14);
    paramJceOutputStream.write(this.lFavoriteCount, 15);
    paramJceOutputStream.write(this.iQQLevel, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.MakeFriendsCard
 * JD-Core Version:    0.7.0.1
 */