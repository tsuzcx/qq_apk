package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import iuc;

public class LBSInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LBSInfo> CREATOR = new iuc();
  static String TAG = "LBSInfo";
  String Qw = "";
  String[] aP = null;
  double altitude = 0.0D;
  String city = "";
  String district = "";
  double latitude = 0.0D;
  double longitude = 0.0D;
  String nation = "";
  String province = "";
  String street = "";
  String town = "";
  String village = "";
  
  public LBSInfo() {}
  
  public LBSInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public LBSInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, double paramDouble1, double paramDouble2, double paramDouble3, String[] paramArrayOfString)
  {
    this.village = paramString6;
    this.town = paramString5;
    this.Qw = paramString8;
    this.street = paramString7;
    this.province = paramString2;
    this.district = paramString4;
    this.nation = paramString1;
    this.city = paramString3;
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
    this.altitude = paramDouble3;
    this.aP = paramArrayOfString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof LBSInfo))) {
        return false;
      }
      paramObject = (LBSInfo)paramObject;
    } while ((this.nation.equals(paramObject.nation)) && (this.province.equals(paramObject.province)) && (this.city.equals(paramObject.city)) && (this.district.equals(paramObject.district)) && (this.town.equals(paramObject.town)) && (this.village.equals(paramObject.village)) && (this.street.equals(paramObject.street)) && (this.Qw.equals(paramObject.Qw)) && (this.latitude == paramObject.latitude) && (this.longitude == paramObject.longitude) && (this.altitude == paramObject.altitude));
    return false;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    try
    {
      this.nation = paramParcel.readString();
      this.province = paramParcel.readString();
      this.city = paramParcel.readString();
      this.district = paramParcel.readString();
      this.town = paramParcel.readString();
      this.village = paramParcel.readString();
      this.street = paramParcel.readString();
      this.Qw = paramParcel.readString();
      this.latitude = paramParcel.readDouble();
      this.longitude = paramParcel.readDouble();
      this.altitude = paramParcel.readDouble();
      this.aP = paramParcel.createStringArray();
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(TAG, 2, "readFromParcel RuntimeException", paramParcel);
    }
  }
  
  public String[] w()
  {
    return this.aP;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeString(this.nation);
      paramParcel.writeString(this.province);
      paramParcel.writeString(this.city);
      paramParcel.writeString(this.district);
      paramParcel.writeString(this.town);
      paramParcel.writeString(this.village);
      paramParcel.writeString(this.street);
      paramParcel.writeString(this.Qw);
      paramParcel.writeDouble(this.latitude);
      paramParcel.writeDouble(this.longitude);
      paramParcel.writeDouble(this.altitude);
      paramParcel.writeArray(this.aP);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(TAG, 2, "writeToParcel RuntimeException", paramParcel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.service.LBSInfo
 * JD-Core Version:    0.7.0.1
 */