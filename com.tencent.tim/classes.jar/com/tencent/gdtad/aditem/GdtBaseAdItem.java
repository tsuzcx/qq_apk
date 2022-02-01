package com.tencent.gdtad.aditem;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import org.json.JSONObject;
import tge;

public class GdtBaseAdItem
  implements Parcelable
{
  public static final Parcelable.Creator<GdtBaseAdItem> CREATOR = new tge();
  public String aJm;
  public String aJn;
  public String aJo;
  public boolean aOT;
  public boolean aOU;
  public Class clz;
  public Bundle extra;
  public String packageName;
  public String productId;
  public String traceId;
  
  private GdtBaseAdItem() {}
  
  public GdtBaseAdItem(Parcel paramParcel)
  {
    this.packageName = paramParcel.readString();
    this.aJm = paramParcel.readString();
    this.aJn = paramParcel.readString();
    this.traceId = paramParcel.readString();
    this.productId = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.aOT = bool1;
      this.clz = ((Class)paramParcel.readSerializable());
      if (paramParcel.readByte() == 0) {
        break label114;
      }
    }
    label114:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aOU = bool1;
      this.aJo = paramParcel.readString();
      this.extra = paramParcel.readBundle(getClass().getClassLoader());
      return;
      bool1 = false;
      break;
    }
  }
  
  public static GdtBaseAdItem a()
  {
    return new GdtBaseAdItem();
  }
  
  public static GdtBaseAdItem a(String paramString)
  {
    localGdtBaseAdItem = new GdtBaseAdItem();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      try
      {
        paramString = Class.forName(localJSONObject.optString("class"));
        localGdtBaseAdItem.d(localJSONObject.optString("packageName")).b(localJSONObject.optString("traceId")).f(localJSONObject.optString("invokeUrl")).e(localJSONObject.optString("appDownloadSchema")).c(localJSONObject.optString("productId")).a(paramString).g(localJSONObject.optString("urlForClick")).a("1".equals(localJSONObject.optString("autoDownload")));
        paramString = localJSONObject.optString("pkg_name");
        if (!TextUtils.isEmpty(paramString))
        {
          localGdtBaseAdItem.d(paramString);
          return localGdtBaseAdItem;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QZLog.w(paramString);
          paramString = null;
        }
      }
      return localGdtBaseAdItem;
    }
    catch (Exception paramString) {}
  }
  
  public GdtBaseAdItem a(Class paramClass)
  {
    this.clz = paramClass;
    return this;
  }
  
  public GdtBaseAdItem a(boolean paramBoolean)
  {
    this.aOT = paramBoolean;
    return this;
  }
  
  public GdtBaseAdItem b(String paramString)
  {
    this.traceId = paramString;
    return this;
  }
  
  public GdtBaseAdItem c(String paramString)
  {
    this.productId = paramString;
    return this;
  }
  
  public GdtBaseAdItem d(String paramString)
  {
    this.packageName = paramString;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public GdtBaseAdItem e(String paramString)
  {
    this.aJm = paramString;
    return this;
  }
  
  public GdtBaseAdItem f(String paramString)
  {
    this.aJn = paramString;
    return this;
  }
  
  public GdtBaseAdItem g(String paramString)
  {
    this.aJo = paramString;
    return this;
  }
  
  public String toString()
  {
    return "GdtBaseAdItem|" + this.packageName + "\n" + this.aJm + "\n" + this.aJn + "\n" + this.traceId + "\n" + this.productId;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.packageName);
    paramParcel.writeString(this.aJm);
    paramParcel.writeString(this.aJn);
    paramParcel.writeString(this.traceId);
    paramParcel.writeString(this.productId);
    if (this.aOT)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeSerializable(this.clz);
      if (!this.aOU) {
        break label102;
      }
    }
    label102:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.aJo);
      paramParcel.writeBundle(this.extra);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtBaseAdItem
 * JD-Core Version:    0.7.0.1
 */