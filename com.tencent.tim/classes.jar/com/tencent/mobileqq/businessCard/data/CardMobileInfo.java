package com.tencent.mobileqq.businessCard.data;

import adzs;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class CardMobileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardMobileInfo> CREATOR = new adzs();
  public String bwu;
  public String bwv;
  public boolean isFriend;
  public String mobile;
  public String nickName;
  
  public CardMobileInfo() {}
  
  public CardMobileInfo(Parcel paramParcel)
  {
    this.mobile = paramParcel.readString();
    this.bwu = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isFriend = bool;
      this.nickName = paramParcel.readString();
      this.bwv = paramParcel.readString();
      return;
    }
  }
  
  public static String D(List<CardMobileInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    localJSONArray1 = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CardMobileInfo localCardMobileInfo = (CardMobileInfo)paramList.next();
        JSONArray localJSONArray2 = new JSONArray();
        localJSONArray2.put(0, localCardMobileInfo.mobile);
        localJSONArray2.put(1, localCardMobileInfo.bwv);
        localJSONArray2.put(2, localCardMobileInfo.isFriend);
        localJSONArray2.put(3, localCardMobileInfo.nickName);
        localJSONArray2.put(4, localCardMobileInfo.bwu);
        localJSONArray1.put(localJSONArray2);
      }
      return localJSONArray1.toString();
    }
    catch (JSONException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public static List<CardMobileInfo> ap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        JSONArray localJSONArray = (JSONArray)paramString.get(i);
        CardMobileInfo localCardMobileInfo = new CardMobileInfo();
        localCardMobileInfo.mobile = ((String)localJSONArray.get(0));
        localCardMobileInfo.bwv = localJSONArray.getString(1);
        localCardMobileInfo.isFriend = localJSONArray.getBoolean(2);
        localCardMobileInfo.nickName = localJSONArray.getString(3);
        localCardMobileInfo.bwu = ((String)localJSONArray.get(4));
        localArrayList.add(localCardMobileInfo);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard", 2, "unPackMoblieInfos has exception");
      }
      paramString.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "CardMobileInfo{, isFriend=" + this.isFriend + "bindqq='" + this.bwu + ",nickName=" + this.nickName + ", mobile='" + this.mobile + ",format= " + this.bwv + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mobile);
    paramParcel.writeString(this.bwu);
    if (this.isFriend) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.nickName);
      paramParcel.writeString(this.bwv);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.data.CardMobileInfo
 * JD-Core Version:    0.7.0.1
 */