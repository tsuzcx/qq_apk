package com.tencent.qqmail.utilities.qmnetwork.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.ArrayList;

public class PushUser
  implements Parcelable
{
  public static final Parcelable.Creator<PushUser> CREATOR = new PushUser.1();
  private String autoLoginPwd;
  private Long lastTime;
  private String pUin;
  private ArrayList<String> relatives;
  private String uin;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAutoLoginPwd()
  {
    return this.autoLoginPwd;
  }
  
  public Long getLastTime()
  {
    return this.lastTime;
  }
  
  public String getPUin()
  {
    return this.pUin;
  }
  
  public ArrayList<String> getRelatives()
  {
    return this.relatives;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.uin = paramParcel.readString();
    this.relatives = new ArrayList();
    paramParcel.readStringList(this.relatives);
    this.lastTime = Long.valueOf(paramParcel.readLong());
    this.autoLoginPwd = paramParcel.readString();
    this.pUin = paramParcel.readString();
  }
  
  public void setAutoLoginPwd(String paramString)
  {
    this.autoLoginPwd = paramString;
  }
  
  public void setLastTime(Long paramLong)
  {
    this.lastTime = paramLong;
  }
  
  public void setPUinAndAutologinPwd(String paramString1, String paramString2)
  {
    ValidateHelper.notNullAndNotEmpty(paramString1);
    ValidateHelper.notNullAndNotEmpty(paramString2);
    this.pUin = paramString1;
    this.autoLoginPwd = paramString2;
  }
  
  public void setRelatives(ArrayList<String> paramArrayList)
  {
    this.relatives = paramArrayList;
  }
  
  public void setUin(String paramString)
  {
    this.uin = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uin);
    paramParcel.writeStringList(this.relatives);
    paramParcel.writeLong(this.lastTime.longValue());
    paramParcel.writeString(this.autoLoginPwd);
    paramParcel.writeString(this.pUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.PushUser
 * JD-Core Version:    0.7.0.1
 */