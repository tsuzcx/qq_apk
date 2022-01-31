package com.tencent.mobileqq.troop.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import hbu;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarUtils$MyBar
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new hbu();
  protected static final String a = "sign_info";
  protected static final String b = "sign";
  protected static final String c = "continue";
  protected static final String d = "level";
  protected static final String e = "point";
  protected static final String f = "level";
  protected static final String g = "flag";
  protected static final String h = "pids";
  protected static final String i = "fans";
  protected static final String j = "name";
  protected static final String k = "today_pids";
  protected static final String l = "ifollowed";
  protected static final String m = "pic";
  protected static final String n = "bid";
  protected static final String o = "bar_class";
  protected static final String p = "intro";
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public String q;
  public String r;
  public String s;
  public String t;
  
  public TroopBarUtils$MyBar(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString1, int paramInt8, int paramInt9, String paramString2, String paramString3, int paramInt10, String paramString4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.g = paramInt7;
    this.q = paramString1;
    this.h = paramInt8;
    this.i = paramInt9;
    this.r = paramString2;
    this.s = paramString3;
    this.j = paramInt10;
    this.t = paramString4;
  }
  
  public TroopBarUtils$MyBar(long paramLong, String paramString)
  {
    this.s = String.valueOf(paramLong);
    this.q = paramString;
  }
  
  public TroopBarUtils$MyBar(MyBar paramMyBar)
  {
    this.a = paramMyBar.a;
    this.b = paramMyBar.b;
    this.c = paramMyBar.c;
    this.d = paramMyBar.d;
    this.e = paramMyBar.e;
    this.f = paramMyBar.f;
    this.g = paramMyBar.g;
    this.q = paramMyBar.q;
    this.h = paramMyBar.h;
    this.i = paramMyBar.i;
    this.r = paramMyBar.r;
    this.s = paramMyBar.s;
    this.j = paramMyBar.j;
    this.t = paramMyBar.t;
  }
  
  public TroopBarUtils$MyBar(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("sign_info");
      this.a = TroopBarUtils.a(localJSONObject, "sign");
      this.b = TroopBarUtils.a(localJSONObject, "continue");
      try
      {
        label31:
        localJSONObject = paramJSONObject.getJSONObject("level");
        this.c = TroopBarUtils.a(localJSONObject, "point");
        this.d = TroopBarUtils.a(localJSONObject, "level");
        label58:
        this.e = TroopBarUtils.a(paramJSONObject, "flag");
        this.f = TroopBarUtils.a(paramJSONObject, "pids");
        this.g = TroopBarUtils.a(paramJSONObject, "fans");
        this.q = TroopBarUtils.a(paramJSONObject, "name");
        this.h = TroopBarUtils.a(paramJSONObject, "today_pids");
        this.i = TroopBarUtils.a(paramJSONObject, "ifollowed");
        this.r = TroopBarUtils.a(paramJSONObject, "pic");
        this.s = TroopBarUtils.a(paramJSONObject, "bid");
        this.j = TroopBarUtils.a(paramJSONObject, "bar_class");
        this.t = TroopBarUtils.a(paramJSONObject, "intro");
        return;
      }
      catch (JSONException localJSONException1)
      {
        break label58;
      }
    }
    catch (JSONException localJSONException2)
    {
      break label31;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof MyBar)) {
      return ((MyBar)paramObject).s.equals(this.s);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    if (this.q == null)
    {
      str = "";
      paramParcel.writeString(str);
      paramParcel.writeInt(this.h);
      paramParcel.writeInt(this.i);
      if (this.r != null) {
        break label149;
      }
      str = "";
      label97:
      paramParcel.writeString(str);
      if (this.s != null) {
        break label157;
      }
      str = "";
      label112:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.j);
      if (this.t != null) {
        break label165;
      }
    }
    label149:
    label157:
    label165:
    for (String str = "";; str = this.t)
    {
      paramParcel.writeString(str);
      return;
      str = this.q;
      break;
      str = this.r;
      break label97;
      str = this.s;
      break label112;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBarUtils.MyBar
 * JD-Core Version:    0.7.0.1
 */