package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class UserProfile
  extends JceStruct
  implements Cloneable
{
  static int cache_eUserIdentityType;
  static VipBaseInfo cache_stVipInfo;
  static byte[] cache_vFaceID;
  static byte[] cache_vIntroContent;
  static byte[] cache_vRichSign;
  public byte bAge = -1;
  public byte bConstellation = 0;
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
  public VipBaseInfo stVipInfo = null;
  public String strNick = "";
  public byte[] vFaceID = null;
  public byte[] vIntroContent = null;
  public byte[] vRichSign = null;
  public short wFace = 0;
  
  static
  {
    if (!UserProfile.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UserProfile() {}
  
  public UserProfile(long paramLong, int paramInt1, short paramShort1, byte paramByte1, byte paramByte2, String paramString, int paramInt2, int paramInt3, short paramShort2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte[] paramArrayOfByte3, byte paramByte7, VipBaseInfo paramVipBaseInfo)
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
    this.vRichSign = paramArrayOfByte3;
    this.bConstellation = paramByte7;
    this.stVipInfo = paramVipBaseInfo;
  }
  
  public String className()
  {
    return "QQService.UserProfile";
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
    paramStringBuilder.display(this.lEctID, "lEctID");
    paramStringBuilder.display(this.lTime, "lTime");
    paramStringBuilder.display(this.wFace, "wFace");
    paramStringBuilder.display(this.bSex, "bSex");
    paramStringBuilder.display(this.bAge, "bAge");
    paramStringBuilder.display(this.strNick, "strNick");
    paramStringBuilder.display(this.nFaceNum, "nFaceNum");
    paramStringBuilder.display(this.eUserIdentityType, "eUserIdentityType");
    paramStringBuilder.display(this.shIntroType, "shIntroType");
    paramStringBuilder.display(this.vIntroContent, "vIntroContent");
    paramStringBuilder.display(this.vFaceID, "vFaceID");
    paramStringBuilder.display(this.bVote, "bVote");
    paramStringBuilder.display(this.bSingle, "bSingle");
    paramStringBuilder.display(this.bFavorited, "bFavorited");
    paramStringBuilder.display(this.bFavoritedMe, "bFavoritedMe");
    paramStringBuilder.display(this.vRichSign, "vRichSign");
    paramStringBuilder.display(this.bConstellation, "bConstellation");
    paramStringBuilder.display(this.stVipInfo, "stVipInfo");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.lEctID, true);
    paramStringBuilder.displaySimple(this.lTime, true);
    paramStringBuilder.displaySimple(this.wFace, true);
    paramStringBuilder.displaySimple(this.bSex, true);
    paramStringBuilder.displaySimple(this.bAge, true);
    paramStringBuilder.displaySimple(this.strNick, true);
    paramStringBuilder.displaySimple(this.nFaceNum, true);
    paramStringBuilder.displaySimple(this.eUserIdentityType, true);
    paramStringBuilder.displaySimple(this.shIntroType, true);
    paramStringBuilder.displaySimple(this.vIntroContent, true);
    paramStringBuilder.displaySimple(this.vFaceID, true);
    paramStringBuilder.displaySimple(this.bVote, true);
    paramStringBuilder.displaySimple(this.bSingle, true);
    paramStringBuilder.displaySimple(this.bFavorited, true);
    paramStringBuilder.displaySimple(this.bFavoritedMe, true);
    paramStringBuilder.displaySimple(this.vRichSign, true);
    paramStringBuilder.displaySimple(this.bConstellation, true);
    paramStringBuilder.displaySimple(this.stVipInfo, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (UserProfile)paramObject;
    } while ((!JceUtil.equals(this.lEctID, paramObject.lEctID)) || (!JceUtil.equals(this.lTime, paramObject.lTime)) || (!JceUtil.equals(this.wFace, paramObject.wFace)) || (!JceUtil.equals(this.bSex, paramObject.bSex)) || (!JceUtil.equals(this.bAge, paramObject.bAge)) || (!JceUtil.equals(this.strNick, paramObject.strNick)) || (!JceUtil.equals(this.nFaceNum, paramObject.nFaceNum)) || (!JceUtil.equals(this.eUserIdentityType, paramObject.eUserIdentityType)) || (!JceUtil.equals(this.shIntroType, paramObject.shIntroType)) || (!JceUtil.equals(this.vIntroContent, paramObject.vIntroContent)) || (!JceUtil.equals(this.vFaceID, paramObject.vFaceID)) || (!JceUtil.equals(this.bVote, paramObject.bVote)) || (!JceUtil.equals(this.bSingle, paramObject.bSingle)) || (!JceUtil.equals(this.bFavorited, paramObject.bFavorited)) || (!JceUtil.equals(this.bFavoritedMe, paramObject.bFavoritedMe)) || (!JceUtil.equals(this.vRichSign, paramObject.vRichSign)) || (!JceUtil.equals(this.bConstellation, paramObject.bConstellation)) || (!JceUtil.equals(this.stVipInfo, paramObject.stVipInfo)));
    return true;
  }
  
  public String fullClassName()
  {
    return "QQService.UserProfile";
  }
  
  public byte getBAge()
  {
    return this.bAge;
  }
  
  public byte getBConstellation()
  {
    return this.bConstellation;
  }
  
  public byte getBFavorited()
  {
    return this.bFavorited;
  }
  
  public byte getBFavoritedMe()
  {
    return this.bFavoritedMe;
  }
  
  public byte getBSex()
  {
    return this.bSex;
  }
  
  public byte getBSingle()
  {
    return this.bSingle;
  }
  
  public byte getBVote()
  {
    return this.bVote;
  }
  
  public int getEUserIdentityType()
  {
    return this.eUserIdentityType;
  }
  
  public long getLEctID()
  {
    return this.lEctID;
  }
  
  public int getLTime()
  {
    return this.lTime;
  }
  
  public int getNFaceNum()
  {
    return this.nFaceNum;
  }
  
  public short getShIntroType()
  {
    return this.shIntroType;
  }
  
  public VipBaseInfo getStVipInfo()
  {
    return this.stVipInfo;
  }
  
  public String getStrNick()
  {
    return this.strNick;
  }
  
  public byte[] getVFaceID()
  {
    return this.vFaceID;
  }
  
  public byte[] getVIntroContent()
  {
    return this.vIntroContent;
  }
  
  public byte[] getVRichSign()
  {
    return this.vRichSign;
  }
  
  public short getWFace()
  {
    return this.wFace;
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
    if (cache_vRichSign == null)
    {
      cache_vRichSign = (byte[])new byte[1];
      ((byte[])cache_vRichSign)[0] = 0;
    }
    this.vRichSign = ((byte[])paramJceInputStream.read(cache_vRichSign, 15, false));
    this.bConstellation = paramJceInputStream.read(this.bConstellation, 16, false);
    if (cache_stVipInfo == null) {
      cache_stVipInfo = new VipBaseInfo();
    }
    this.stVipInfo = ((VipBaseInfo)paramJceInputStream.read(cache_stVipInfo, 17, false));
  }
  
  public void setBAge(byte paramByte)
  {
    this.bAge = paramByte;
  }
  
  public void setBConstellation(byte paramByte)
  {
    this.bConstellation = paramByte;
  }
  
  public void setBFavorited(byte paramByte)
  {
    this.bFavorited = paramByte;
  }
  
  public void setBFavoritedMe(byte paramByte)
  {
    this.bFavoritedMe = paramByte;
  }
  
  public void setBSex(byte paramByte)
  {
    this.bSex = paramByte;
  }
  
  public void setBSingle(byte paramByte)
  {
    this.bSingle = paramByte;
  }
  
  public void setBVote(byte paramByte)
  {
    this.bVote = paramByte;
  }
  
  public void setEUserIdentityType(int paramInt)
  {
    this.eUserIdentityType = paramInt;
  }
  
  public void setLEctID(long paramLong)
  {
    this.lEctID = paramLong;
  }
  
  public void setLTime(int paramInt)
  {
    this.lTime = paramInt;
  }
  
  public void setNFaceNum(int paramInt)
  {
    this.nFaceNum = paramInt;
  }
  
  public void setShIntroType(short paramShort)
  {
    this.shIntroType = paramShort;
  }
  
  public void setStVipInfo(VipBaseInfo paramVipBaseInfo)
  {
    this.stVipInfo = paramVipBaseInfo;
  }
  
  public void setStrNick(String paramString)
  {
    this.strNick = paramString;
  }
  
  public void setVFaceID(byte[] paramArrayOfByte)
  {
    this.vFaceID = paramArrayOfByte;
  }
  
  public void setVIntroContent(byte[] paramArrayOfByte)
  {
    this.vIntroContent = paramArrayOfByte;
  }
  
  public void setVRichSign(byte[] paramArrayOfByte)
  {
    this.vRichSign = paramArrayOfByte;
  }
  
  public void setWFace(short paramShort)
  {
    this.wFace = paramShort;
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
    if (this.vRichSign != null) {
      paramJceOutputStream.write(this.vRichSign, 15);
    }
    paramJceOutputStream.write(this.bConstellation, 16);
    if (this.stVipInfo != null) {
      paramJceOutputStream.write(this.stVipInfo, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.UserProfile
 * JD-Core Version:    0.7.0.1
 */