package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

public class AIOShortVideoData
  extends AIORichMediaData
  implements Parcelable
{
  public String aWo = "I:N";
  public String aWp = "I:N";
  public boolean bio;
  public boolean bjB;
  public int bqB;
  public String friendUin = "";
  public int height;
  public int isSend;
  public int mBusiType;
  public String mTemplateId;
  public String mTemplateName;
  public int redBagStat;
  public int redBagType;
  public String senderUin = "";
  public String shortVideoId = "";
  public int specialVideoType;
  private String strErr;
  public long uniseq;
  public int videoFileStatus;
  public int width;
  
  public File c(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    while ((localObject != null) && (!((String)localObject).equals("I:N")))
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        break;
      }
      return localObject;
      localObject = this.aWo;
      continue;
      localObject = this.aWp;
    }
    return null;
  }
  
  public String cH(int paramInt)
  {
    Object localObject2 = null;
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (!str.equals("I:N"))
        {
          if (str.startsWith("/")) {
            break;
          }
          localObject1 = "file:/" + str;
        }
      }
      return localObject1;
      str = this.aWo;
      continue;
      str = this.aWp;
    }
    if (str.startsWith("//")) {
      return "file:" + str;
    }
    return "file:" + str;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean gF(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        return bool;
      } while (!this.aWo.equals("I:N"));
      return false;
    } while (!this.aWp.equals("I:N"));
    return false;
  }
  
  public String pw()
  {
    return this.strErr;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    super.readFromParcel(paramParcel);
    this.aWo = paramParcel.readString();
    this.aWp = paramParcel.readString();
    this.bqB = paramParcel.readInt();
    this.mBusiType = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.uniseq = paramParcel.readLong();
    this.redBagType = paramParcel.readInt();
    this.shortVideoId = paramParcel.readString();
    this.senderUin = paramParcel.readString();
    this.redBagStat = paramParcel.readInt();
    this.friendUin = paramParcel.readString();
    this.isSend = paramParcel.readInt();
    this.specialVideoType = paramParcel.readInt();
    this.videoFileStatus = paramParcel.readInt();
    this.mTemplateId = paramParcel.readString();
    this.mTemplateName = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.aWo);
    paramParcel.writeString(this.aWp);
    paramParcel.writeInt(this.bqB);
    paramParcel.writeInt(this.mBusiType);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeLong(this.uniseq);
    paramParcel.writeInt(this.redBagType);
    paramParcel.writeString(this.shortVideoId);
    paramParcel.writeString(this.senderUin);
    paramParcel.writeInt(this.redBagStat);
    paramParcel.writeString(this.friendUin);
    paramParcel.writeInt(this.isSend);
    paramParcel.writeInt(this.specialVideoType);
    paramParcel.writeInt(this.videoFileStatus);
    paramParcel.writeString(this.mTemplateId);
    paramParcel.writeString(this.mTemplateName);
  }
  
  public void ya(String paramString)
  {
    this.strErr = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData
 * JD-Core Version:    0.7.0.1
 */