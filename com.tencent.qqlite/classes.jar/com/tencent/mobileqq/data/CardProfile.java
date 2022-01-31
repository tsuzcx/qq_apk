package com.tencent.mobileqq.data;

import QQService.UserProfile;
import QQService.VipBaseInfo;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.richstatus.RichStatus;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="lEctID,type")
public class CardProfile
  extends Entity
{
  public static final int TYPE_FAVORITE = 3;
  public static final int TYPE_VISITOR = 1;
  public static final int TYPE_VOTER = 2;
  public byte bAage;
  public byte bConstellation = 0;
  public byte bFavorite;
  public byte bFavoritedMe;
  public byte bSex;
  public byte bSingle;
  public byte bVote;
  public int eUserIdentityType;
  public long lEctID;
  public int lTime;
  public int nFaceNum;
  private transient RichStatus rs;
  public short shIntroType;
  public VipBaseInfo stVipInfo = null;
  public String strNick;
  public int type = 1;
  public byte[] vFaceID;
  public byte[] vIntroContent;
  public byte[] vRichSign = null;
  public short wFace;
  
  public byte getBAge()
  {
    return this.bAage;
  }
  
  public byte getBConstellation()
  {
    return this.bConstellation;
  }
  
  public byte getBSex()
  {
    return this.bSex;
  }
  
  public byte getBVote()
  {
    return this.bVote;
  }
  
  public long getLEctID()
  {
    return this.lEctID;
  }
  
  public int getLTime()
  {
    return this.lTime;
  }
  
  public RichStatus getRichStatus()
  {
    if ((this.rs == null) && (this.vRichSign != null)) {
      this.rs = RichStatus.a(this.vRichSign);
    }
    return this.rs;
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
  
  public String getTableName()
  {
    return super.getTableName() + "v2";
  }
  
  public int getType()
  {
    return this.type;
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
  
  public byte getbFavorite()
  {
    return this.bFavorite;
  }
  
  public byte getbFavoritedMe()
  {
    return this.bFavoritedMe;
  }
  
  public byte getbSingle()
  {
    return this.bSingle;
  }
  
  public int geteUserIdentityType()
  {
    return this.eUserIdentityType;
  }
  
  public int getnFaceNum()
  {
    return this.nFaceNum;
  }
  
  public byte[] getvFaceID()
  {
    return this.vFaceID;
  }
  
  public void readFrom(UserProfile paramUserProfile)
  {
    this.bAage = paramUserProfile.bAge;
    this.bFavorite = paramUserProfile.bFavorited;
    this.bFavoritedMe = paramUserProfile.bFavoritedMe;
    this.bSex = paramUserProfile.bSex;
    this.bSingle = paramUserProfile.bSingle;
    this.bVote = paramUserProfile.bVote;
    this.eUserIdentityType = paramUserProfile.eUserIdentityType;
    this.lEctID = paramUserProfile.lEctID;
    this.lTime = paramUserProfile.lTime;
    this.nFaceNum = paramUserProfile.nFaceNum;
    this.shIntroType = paramUserProfile.shIntroType;
    this.strNick = paramUserProfile.strNick;
    this.vFaceID = paramUserProfile.vFaceID;
    this.vIntroContent = paramUserProfile.vIntroContent;
    this.wFace = paramUserProfile.wFace;
    this.vRichSign = paramUserProfile.vRichSign;
    this.bConstellation = paramUserProfile.bConstellation;
    this.stVipInfo = paramUserProfile.stVipInfo;
  }
  
  public void setBConstellation(byte paramByte)
  {
    this.bConstellation = paramByte;
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
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setVRichSign(byte[] paramArrayOfByte)
  {
    this.vRichSign = paramArrayOfByte;
  }
  
  public void setbAage(byte paramByte)
  {
    this.bAage = paramByte;
  }
  
  public void setbFavorite(byte paramByte)
  {
    this.bFavorite = paramByte;
  }
  
  public void setbFavoritedMe(byte paramByte)
  {
    this.bFavoritedMe = paramByte;
  }
  
  public void setbSex(byte paramByte)
  {
    this.bSex = paramByte;
  }
  
  public void setbSingle(byte paramByte)
  {
    this.bSingle = paramByte;
  }
  
  public void setbVote(byte paramByte)
  {
    this.bVote = paramByte;
  }
  
  public void seteUserIdentityType(int paramInt)
  {
    this.eUserIdentityType = paramInt;
  }
  
  public void setlEctID(long paramLong)
  {
    this.lEctID = paramLong;
  }
  
  public void setlTime(int paramInt)
  {
    this.lTime = paramInt;
  }
  
  public void setnFaceNum(int paramInt)
  {
    this.nFaceNum = paramInt;
  }
  
  public void setvFaceID(byte[] paramArrayOfByte)
  {
    this.vFaceID = paramArrayOfByte;
  }
  
  public void setvIntroContent(byte[] paramArrayOfByte)
  {
    this.vIntroContent = paramArrayOfByte;
  }
  
  public void setwFace(short paramShort)
  {
    this.wFace = paramShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.CardProfile
 * JD-Core Version:    0.7.0.1
 */