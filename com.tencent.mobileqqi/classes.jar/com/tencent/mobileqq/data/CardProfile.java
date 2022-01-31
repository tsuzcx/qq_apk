package com.tencent.mobileqq.data;

import QQService.UserProfile;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="lEctID,type")
public class CardProfile
  extends Entity
{
  public static final int TYPE_VISITOR = 1;
  public static final int TYPE_VOTER = 2;
  public byte bAage;
  public byte bFavorite;
  public byte bFavoritedMe;
  public byte bSex;
  public byte bSingle;
  public byte bVote;
  public int eUserIdentityType;
  public long lEctID;
  public int lTime;
  public int nFaceNum;
  public short shIntroType;
  public String strNick;
  public int type = 1;
  public byte[] vFaceID;
  public byte[] vIntroContent;
  public short wFace;
  
  public byte getBAge()
  {
    return this.bAage;
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
  
  public short getShIntroType()
  {
    return this.shIntroType;
  }
  
  public String getStrNick()
  {
    return this.strNick;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public byte[] getVIntroContent()
  {
    return this.vIntroContent;
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
  }
  
  public void setShIntroType(short paramShort)
  {
    this.shIntroType = paramShort;
  }
  
  public void setStrNick(String paramString)
  {
    this.strNick = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.CardProfile
 * JD-Core Version:    0.7.0.1
 */