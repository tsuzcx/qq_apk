package com.tencent.mobileqq.businessCard.data;

import adzt;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class CardOCRInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardOCRInfo> CREATOR = new adzt();
  public int errorCode;
  public String errorMsg;
  public String imageUrl;
  public List<String> mobilesNum = new ArrayList();
  public String name;
  public String picUrl;
  public List<String> qqNum = new ArrayList();
  public float vD;
  public float vE;
  public float vF;
  
  public CardOCRInfo() {}
  
  public CardOCRInfo(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.picUrl = paramParcel.readString();
    paramParcel.readList(this.qqNum, getClass().getClassLoader());
    paramParcel.readList(this.mobilesNum, getClass().getClassLoader());
    this.vD = paramParcel.readFloat();
    this.vE = paramParcel.readFloat();
    this.vF = paramParcel.readFloat();
  }
  
  public static CardOCRInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    CardOCRInfo localCardOCRInfo = new CardOCRInfo();
    try
    {
      paramString = new JSONArray(paramString);
      localCardOCRInfo.name = paramString.getString(0);
      localCardOCRInfo.picUrl = paramString.getString(1);
      localCardOCRInfo.qqNum = BusinessCard.unPack(paramString.getString(2));
      localCardOCRInfo.mobilesNum = BusinessCard.unPack(paramString.getString(3));
      return localCardOCRInfo;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard", 2, "unPackOCRInfo has exception");
      }
      paramString.printStackTrace();
    }
    return localCardOCRInfo;
  }
  
  public static String a(CardOCRInfo paramCardOCRInfo)
  {
    if (paramCardOCRInfo == null) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONArray.put(0, paramCardOCRInfo.name);
      localJSONArray.put(1, paramCardOCRInfo.picUrl);
      localJSONArray.put(2, BusinessCard.pack(paramCardOCRInfo.qqNum));
      localJSONArray.put(3, BusinessCard.pack(paramCardOCRInfo.mobilesNum));
      return localJSONArray.toString();
    }
    catch (JSONException paramCardOCRInfo)
    {
      for (;;)
      {
        paramCardOCRInfo.printStackTrace();
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "erroCode: " + this.errorCode + " errMsg: " + this.errorMsg + " uin:" + this.qqNum + " uincon:" + this.vE + " phone: " + this.mobilesNum + " phoneConfidence: " + this.vF + " name:" + this.name + " nameConfidence:" + this.vD + " imgUrl:" + this.imageUrl;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.picUrl);
    paramParcel.writeList(this.qqNum);
    paramParcel.writeList(this.mobilesNum);
    paramParcel.writeFloat(this.vD);
    paramParcel.writeFloat(this.vE);
    paramParcel.writeFloat(this.vF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.data.CardOCRInfo
 * JD-Core Version:    0.7.0.1
 */