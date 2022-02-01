package com.tencent.mobileqq.data;

import advo.a;
import advo.b;
import advo.c;
import aeza;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DynamicAvatar
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<DynamicAvatar> CREATOR = new aeza();
  public String basicBigUrl = "";
  public String basicMiddleUrl = "";
  public int basicOverdueTimeStamp;
  public int basicSetTimeStamp;
  public String basicSmallUrl = "";
  public String basicStaticUrl = "";
  public int getTimeStamp;
  public String nearbyBigUrl = "";
  public String nearbyMiddleUrl = "";
  public int nearbyOverdueTimeStamp;
  public int nearbySetTimeStamp;
  public String nearbySmallUrl = "";
  public String nearbyStaticUrl = "";
  public long playTimeStamp;
  public long tinyId;
  public long uin;
  
  public DynamicAvatar() {}
  
  public DynamicAvatar(Parcel paramParcel)
  {
    this.tinyId = paramParcel.readLong();
    this.uin = paramParcel.readLong();
    this.getTimeStamp = paramParcel.readInt();
    this.basicOverdueTimeStamp = paramParcel.readInt();
    this.nearbyOverdueTimeStamp = paramParcel.readInt();
    this.basicSetTimeStamp = paramParcel.readInt();
    this.nearbySetTimeStamp = paramParcel.readInt();
    this.basicSmallUrl = paramParcel.readString();
    this.basicMiddleUrl = paramParcel.readString();
    this.basicBigUrl = paramParcel.readString();
    this.nearbySmallUrl = paramParcel.readString();
    this.nearbyMiddleUrl = paramParcel.readString();
    this.nearbyBigUrl = paramParcel.readString();
    this.playTimeStamp = paramParcel.readLong();
  }
  
  public static DynamicAvatar convertFrom(advo.a parama)
  {
    if (parama == null) {
      return null;
    }
    DynamicAvatar localDynamicAvatar = new DynamicAvatar();
    localDynamicAvatar.tinyId = parama.tinyId;
    localDynamicAvatar.uin = parama.uin;
    localDynamicAvatar.getTimeStamp = parama.timeStamp;
    if ((parama.uR == null) || (parama.uR.isEmpty()))
    {
      QLog.i("Q.dynamicAvatar", 1, "convertFrom oneUinHeadInfo's headInfos is null.");
      return localDynamicAvatar;
    }
    parama = parama.uR.iterator();
    while (parama.hasNext())
    {
      Object localObject1 = (advo.b)parama.next();
      if (localObject1 != null)
      {
        Object localObject2 = ((advo.b)localObject1).uS;
        if (((advo.b)localObject1).type == 17)
        {
          localDynamicAvatar.basicSetTimeStamp = ((advo.b)localObject1).timeStamp;
          localDynamicAvatar.basicOverdueTimeStamp = ((advo.b)localObject1).cKq;
          localDynamicAvatar.basicStaticUrl = ((advo.b)localObject1).bvI;
          if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
          {
            localObject1 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (advo.c)((Iterator)localObject1).next();
              if (localObject2 != null) {
                if ((((advo.c)localObject2).videoSize == 80) || (((advo.c)localObject2).videoSize == 100)) {
                  localDynamicAvatar.basicSmallUrl = ((advo.c)localObject2).url;
                } else if (((advo.c)localObject2).videoSize == 200) {
                  localDynamicAvatar.basicMiddleUrl = ((advo.c)localObject2).url;
                } else if (((advo.c)localObject2).videoSize == 640) {
                  localDynamicAvatar.basicBigUrl = ((advo.c)localObject2).url;
                }
              }
            }
          }
        }
        else if (((advo.b)localObject1).type == 18)
        {
          localDynamicAvatar.nearbySetTimeStamp = ((advo.b)localObject1).timeStamp;
          localDynamicAvatar.nearbyOverdueTimeStamp = ((advo.b)localObject1).cKq;
          localDynamicAvatar.nearbyStaticUrl = ((advo.b)localObject1).bvI;
          if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
          {
            localObject1 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (advo.c)((Iterator)localObject1).next();
              if (localObject2 != null) {
                if ((((advo.c)localObject2).videoSize == 80) || (((advo.c)localObject2).videoSize == 100)) {
                  localDynamicAvatar.nearbySmallUrl = ((advo.c)localObject2).url;
                } else if (((advo.c)localObject2).videoSize == 200) {
                  localDynamicAvatar.nearbyMiddleUrl = ((advo.c)localObject2).url;
                } else if (((advo.c)localObject2).videoSize == 640) {
                  localDynamicAvatar.nearbyBigUrl = ((advo.c)localObject2).url;
                }
              }
            }
          }
        }
      }
    }
    return localDynamicAvatar;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n************************************************");
    localStringBuilder.append("\ntinid: ").append(this.tinyId);
    localStringBuilder.append("\nuin: ").append(this.uin);
    localStringBuilder.append("\ngetTimeStamp: ").append(this.getTimeStamp);
    localStringBuilder.append("\nbasicOverdueTimeStamp: ").append(this.basicOverdueTimeStamp);
    localStringBuilder.append("\nnearbyOverdueTimeStamp: ").append(this.nearbyOverdueTimeStamp);
    localStringBuilder.append("\nbasicSetTimeStamp: ").append(this.basicSetTimeStamp);
    localStringBuilder.append("\nnearbySetTimeStamp: ").append(this.nearbySetTimeStamp);
    localStringBuilder.append("\nplayTimeStamp: ").append(this.playTimeStamp);
    localStringBuilder.append("\nbasicSmallUrl: ").append(this.basicSmallUrl);
    localStringBuilder.append("\nbasicMiddleUrl: ").append(this.basicMiddleUrl);
    localStringBuilder.append("\nbasicBigUrl: ").append(this.basicBigUrl);
    localStringBuilder.append("\nnearbySmallUrl: ").append(this.nearbySmallUrl);
    localStringBuilder.append("\nnearbyMiddleUrl: ").append(this.nearbyMiddleUrl);
    localStringBuilder.append("\nnearbyBigUrl: ").append(this.nearbyBigUrl);
    localStringBuilder.append("\nnearbyStaticUrl: ").append(this.nearbyStaticUrl);
    localStringBuilder.append("\n************************************************");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.tinyId);
    paramParcel.writeLong(this.uin);
    paramParcel.writeInt(this.getTimeStamp);
    paramParcel.writeInt(this.basicOverdueTimeStamp);
    paramParcel.writeInt(this.nearbyOverdueTimeStamp);
    paramParcel.writeInt(this.basicSetTimeStamp);
    paramParcel.writeInt(this.nearbySetTimeStamp);
    paramParcel.writeString(this.basicSmallUrl);
    paramParcel.writeString(this.basicMiddleUrl);
    paramParcel.writeString(this.basicBigUrl);
    paramParcel.writeString(this.nearbySmallUrl);
    paramParcel.writeString(this.nearbyMiddleUrl);
    paramParcel.writeString(this.nearbyBigUrl);
    paramParcel.writeLong(this.playTimeStamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.DynamicAvatar
 * JD-Core Version:    0.7.0.1
 */