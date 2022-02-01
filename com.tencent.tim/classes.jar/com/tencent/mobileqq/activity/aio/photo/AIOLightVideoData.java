package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

public class AIOLightVideoData
  extends AIORichMediaData
  implements Parcelable
{
  public String aWo = "I:N";
  public String aWp = "I:N";
  public int bqB;
  public int height;
  public int mBusiType;
  public long uniseq;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOLightVideoData
 * JD-Core Version:    0.7.0.1
 */