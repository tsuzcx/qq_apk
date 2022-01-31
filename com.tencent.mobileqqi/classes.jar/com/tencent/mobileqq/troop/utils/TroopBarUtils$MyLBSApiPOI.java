package com.tencent.mobileqq.troop.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import hbv;
import org.json.JSONObject;

public class TroopBarUtils$MyLBSApiPOI
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new hbv();
  protected static final String a = "uid";
  protected static final String b = "catalog";
  protected static final String c = "name";
  protected static final String d = "longitude";
  protected static final String e = "addr";
  protected static final String f = "latitude";
  protected static final String g = "dist";
  public int a;
  public int b;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public TroopBarUtils$MyLBSApiPOI(MyLBSApiPOI paramMyLBSApiPOI)
  {
    if (paramMyLBSApiPOI != null)
    {
      this.h = paramMyLBSApiPOI.h;
      this.i = paramMyLBSApiPOI.i;
      this.j = paramMyLBSApiPOI.j;
      this.a = paramMyLBSApiPOI.a;
      this.k = paramMyLBSApiPOI.k;
      this.b = paramMyLBSApiPOI.b;
      this.l = paramMyLBSApiPOI.l;
    }
  }
  
  public TroopBarUtils$MyLBSApiPOI(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
  {
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
    this.a = paramInt1;
    this.k = paramString4;
    this.b = paramInt2;
    this.l = paramString5;
  }
  
  public TroopBarUtils$MyLBSApiPOI(JSONObject paramJSONObject)
  {
    this.h = TroopBarUtils.a(paramJSONObject, "uid");
    this.i = TroopBarUtils.a(paramJSONObject, "catalog");
    this.j = TroopBarUtils.a(paramJSONObject, "name");
    this.a = ((int)(TroopBarUtils.a(paramJSONObject, "longitude") * 1000000.0D));
    this.k = TroopBarUtils.a(paramJSONObject, "addr");
    this.b = ((int)(TroopBarUtils.a(paramJSONObject, "latitude") * 1000000.0D));
    this.l = TroopBarUtils.a(paramJSONObject, "dist");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof MyLBSApiPOI)) {
      return ((MyLBSApiPOI)paramObject).h.equals(this.h);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.k);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBarUtils.MyLBSApiPOI
 * JD-Core Version:    0.7.0.1
 */