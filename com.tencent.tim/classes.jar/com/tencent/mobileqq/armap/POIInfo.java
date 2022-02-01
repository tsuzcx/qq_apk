package com.tencent.mobileqq.armap;

import aduo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;

public class POIInfo
  implements Parcelable
{
  public static final Parcelable.Creator<POIInfo> CREATOR = new aduo();
  public long VD;
  public long VE;
  public String address;
  public int appid;
  public String bannerUrl;
  public String bvC;
  public String iconUrl;
  public HashMap<Long, Integer> jM = new HashMap();
  public double latitude;
  public double longitude;
  public String name;
  public int poiType;
  public ArrayList<Object> uM = new ArrayList();
  
  public POIInfo() {}
  
  public POIInfo(Parcel paramParcel)
  {
    this.VD = paramParcel.readLong();
    this.longitude = paramParcel.readDouble();
    this.latitude = paramParcel.readDouble();
    this.name = paramParcel.readString();
    this.address = paramParcel.readString();
    this.VE = paramParcel.readLong();
    this.poiType = paramParcel.readInt();
    this.iconUrl = paramParcel.readString();
    this.bannerUrl = paramParcel.readString();
    this.bvC = paramParcel.readString();
    this.appid = paramParcel.readInt();
  }
  
  public static boolean needWiden(long paramLong)
  {
    return (paramLong & 0x0) == -9223372036854775808L;
  }
  
  public static BigInteger toUnsignedLongValue(long paramLong)
  {
    if (!needWiden(paramLong)) {
      return BigInteger.valueOf(paramLong);
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.putLong(paramLong);
    return new BigInteger(1, localByteBuffer.array());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("poiId:").append(toUnsignedLongValue(this.VD)).append(", longitude: ").append(this.longitude).append(", latitude: ").append(this.latitude).append(", name: ").append(this.name).append(", address: ").append(this.address).append(", adcode: ").append(this.VE).append(", poiType: ").append(this.poiType).append(", iconUrl: ").append(this.iconUrl).append(", bannerUrl: ").append(this.bannerUrl).append(", photoUrl: ").append(this.bvC).append(", appid: ").append(this.appid).append(", taskStatus: ").append(this.jM.toString()).append(", mTasks: ").append(this.uM);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.VD);
    paramParcel.writeDouble(this.longitude);
    paramParcel.writeDouble(this.latitude);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.address);
    paramParcel.writeLong(this.VE);
    paramParcel.writeInt(this.poiType);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.bannerUrl);
    paramParcel.writeString(this.bvC);
    paramParcel.writeInt(this.appid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.POIInfo
 * JD-Core Version:    0.7.0.1
 */