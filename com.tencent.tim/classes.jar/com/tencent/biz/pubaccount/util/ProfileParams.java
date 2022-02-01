package com.tencent.biz.pubaccount.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import obp;
import obq;

public class ProfileParams
  implements Parcelable
{
  public static final Parcelable.Creator<ProfileParams> CREATOR = new obp();
  public CurLoginUsr a;
  String aoZ;
  String apa;
  String apb;
  int bdV;
  String mUin;
  
  public CurLoginUsr a()
  {
    return this.a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getOpenId()
  {
    if (this.a != null) {
      return this.a.mOpenId;
    }
    return null;
  }
  
  public String getUin()
  {
    return this.mUin;
  }
  
  public String la()
  {
    return this.apa;
  }
  
  public int re()
  {
    return this.bdV;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mUin);
    paramParcel.writeInt(this.bdV);
    paramParcel.writeString(this.aoZ);
    paramParcel.writeString(this.apa);
    paramParcel.writeString(this.apb);
    paramParcel.writeParcelable(this.a, paramInt);
  }
  
  public static class CurLoginUsr
    implements Parcelable
  {
    public static final Parcelable.Creator<CurLoginUsr> CREATOR = new obq();
    public final String apc;
    public final String mOpenId;
    
    public CurLoginUsr(String paramString1, String paramString2)
    {
      this.mOpenId = paramString1;
      this.apc = paramString2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mOpenId);
      paramParcel.writeString(this.apc);
    }
  }
  
  public static final class a
  {
    private ProfileParams b = new ProfileParams(null);
    
    public a a(int paramInt)
    {
      this.b.bdV = paramInt;
      return this;
    }
    
    public a a(ProfileParams.CurLoginUsr paramCurLoginUsr)
    {
      this.b.a = paramCurLoginUsr;
      return this;
    }
    
    public a a(String paramString)
    {
      this.b.mUin = paramString;
      return this;
    }
    
    public ProfileParams a()
    {
      return this.b;
    }
    
    public a b(String paramString)
    {
      this.b.aoZ = paramString;
      return this;
    }
    
    public a c(String paramString)
    {
      this.b.apa = paramString;
      return this;
    }
    
    public a d(String paramString)
    {
      this.b.apb = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ProfileParams
 * JD-Core Version:    0.7.0.1
 */