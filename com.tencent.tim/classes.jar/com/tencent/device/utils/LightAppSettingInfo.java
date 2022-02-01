package com.tencent.device.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashMap;
import tan;

public class LightAppSettingInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<LightAppSettingInfo> CREATOR = new tan();
  public String aIB;
  public String aIC;
  public String aID;
  public String appId;
  public String appName;
  public int bAP;
  public int bindType;
  public int deviceType;
  public long din;
  public HashMap<Integer, String> gs;
  public ArrayList<Integer> oA;
  public String openId;
  public String openKey;
  public String packageName;
  public int productId;
  public int templateType;
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int hashCode()
  {
    if (this.din != 0L) {
      return Long.valueOf(this.din).hashCode();
    }
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.templateType);
    paramParcel.writeInt(this.bAP);
    paramParcel.writeInt(this.productId);
    paramParcel.writeLong(this.din);
    paramParcel.writeList(this.oA);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.packageName);
    paramParcel.writeInt(this.deviceType);
    paramParcel.writeString(this.aIB);
    paramParcel.writeString(this.aIC);
    paramParcel.writeString(this.openId);
    paramParcel.writeString(this.openKey);
    paramParcel.writeString(this.appName);
    paramParcel.writeInt(this.bindType);
    paramParcel.writeMap(this.gs);
    paramParcel.writeString(this.aID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.utils.LightAppSettingInfo
 * JD-Core Version:    0.7.0.1
 */