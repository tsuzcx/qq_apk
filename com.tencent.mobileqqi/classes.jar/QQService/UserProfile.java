package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserProfile
  extends JceStruct
{
  static int cache_eUserIdentityType;
  static byte[] cache_vFaceID;
  static byte[] cache_vIntroContent;
  public byte bAge = -1;
  public byte bFavorited = -1;
  public byte bFavoritedMe = -1;
  public byte bSex = -1;
  public byte bSingle = -1;
  public byte bVote = -1;
  public int eUserIdentityType = UserIdentityType.UserIdentityType_Nomal.value();
  public long lEctID = 0L;
  public int lTime = -1;
  public int nFaceNum = 0;
  public short shIntroType = 0;
  public String strNick = "";
  public byte[] vFaceID = null;
  public byte[] vIntroContent = null;
  public short wFace = 0;
  
  public UserProfile() {}
  
  public UserProfile(long paramLong, int paramInt1, short paramShort1, byte paramByte1, byte paramByte2, String paramString, int paramInt2, int paramInt3, short paramShort2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6)
  {
    this.lEctID = paramLong;
    this.lTime = paramInt1;
    this.wFace = paramShort1;
    this.bSex = paramByte1;
    this.bAge = paramByte2;
    this.strNick = paramString;
    this.nFaceNum = paramInt2;
    this.eUserIdentityType = paramInt3;
    this.shIntroType = paramShort2;
    this.vIntroContent = paramArrayOfByte1;
    this.vFaceID = paramArrayOfByte2;
    this.bVote = paramByte3;
    this.bSingle = paramByte4;
    this.bFavorited = paramByte5;
    this.bFavoritedMe = paramByte6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lEctID = paramJceInputStream.read(this.lEctID, 0, true);
    this.lTime = paramJceInputStream.read(this.lTime, 1, true);
    this.wFace = paramJceInputStream.read(this.wFace, 2, true);
    this.bSex = paramJceInputStream.read(this.bSex, 3, true);
    this.bAge = paramJceInputStream.read(this.bAge, 4, true);
    this.strNick = paramJceInputStream.readString(5, true);
    this.nFaceNum = paramJceInputStream.read(this.nFaceNum, 6, false);
    this.eUserIdentityType = paramJceInputStream.read(this.eUserIdentityType, 7, false);
    this.shIntroType = paramJceInputStream.read(this.shIntroType, 8, false);
    if (cache_vIntroContent == null)
    {
      cache_vIntroContent = (byte[])new byte[1];
      ((byte[])cache_vIntroContent)[0] = 0;
    }
    this.vIntroContent = ((byte[])paramJceInputStream.read(cache_vIntroContent, 9, false));
    if (cache_vFaceID == null)
    {
      cache_vFaceID = (byte[])new byte[1];
      ((byte[])cache_vFaceID)[0] = 0;
    }
    this.vFaceID = ((byte[])paramJceInputStream.read(cache_vFaceID, 10, false));
    this.bVote = paramJceInputStream.read(this.bVote, 11, false);
    this.bSingle = paramJceInputStream.read(this.bSingle, 12, false);
    this.bFavorited = paramJceInputStream.read(this.bFavorited, 13, false);
    this.bFavoritedMe = paramJceInputStream.read(this.bFavoritedMe, 14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lEctID, 0);
    paramJceOutputStream.write(this.lTime, 1);
    paramJceOutputStream.write(this.wFace, 2);
    paramJceOutputStream.write(this.bSex, 3);
    paramJceOutputStream.write(this.bAge, 4);
    paramJceOutputStream.write(this.strNick, 5);
    paramJceOutputStream.write(this.nFaceNum, 6);
    paramJceOutputStream.write(this.eUserIdentityType, 7);
    paramJceOutputStream.write(this.shIntroType, 8);
    if (this.vIntroContent != null) {
      paramJceOutputStream.write(this.vIntroContent, 9);
    }
    if (this.vFaceID != null) {
      paramJceOutputStream.write(this.vFaceID, 10);
    }
    paramJceOutputStream.write(this.bVote, 11);
    paramJceOutputStream.write(this.bSingle, 12);
    paramJceOutputStream.write(this.bFavorited, 13);
    paramJceOutputStream.write(this.bFavoritedMe, 14);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.UserProfile
 * JD-Core Version:    0.7.0.1
 */