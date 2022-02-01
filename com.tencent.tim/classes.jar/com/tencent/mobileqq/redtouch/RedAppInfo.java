package com.tencent.mobileqq.redtouch;

import altm;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class RedAppInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RedAppInfo> CREATOR = new altm();
  private RedDisplayInfo a;
  private String buffer;
  private int dxa;
  private int dxb;
  private int dxc;
  private int dxd;
  private int dxe;
  private int dxf;
  private int dxg;
  private int dxh;
  private int dxi;
  private String icon_url;
  private int num;
  private String path;
  private int type;
  public ArrayList<String> yU;
  
  public int Ie()
  {
    return this.dxa;
  }
  
  public int If()
  {
    return this.dxb;
  }
  
  public int Ig()
  {
    return this.dxc;
  }
  
  public int Ih()
  {
    return this.dxd;
  }
  
  public int Ii()
  {
    return this.num;
  }
  
  public int Ij()
  {
    return this.dxe;
  }
  
  public int Ik()
  {
    return this.dxg;
  }
  
  public int Il()
  {
    return this.dxh;
  }
  
  public int Im()
  {
    return this.dxi;
  }
  
  public void ON(String paramString)
  {
    this.buffer = paramString;
  }
  
  public void OO(String paramString)
  {
    this.icon_url = paramString;
  }
  
  public void Ti(int paramInt)
  {
    this.dxa = paramInt;
  }
  
  public void Tj(int paramInt)
  {
    this.dxb = paramInt;
  }
  
  public void Tk(int paramInt)
  {
    this.dxc = paramInt;
  }
  
  public void Tl(int paramInt)
  {
    this.dxd = paramInt;
  }
  
  public void Tm(int paramInt)
  {
    this.dxe = paramInt;
  }
  
  public void Tn(int paramInt)
  {
    this.dxg = paramInt;
  }
  
  public void To(int paramInt)
  {
    this.dxh = paramInt;
  }
  
  public void Tp(int paramInt)
  {
    this.dxi = paramInt;
  }
  
  public RedDisplayInfo a()
  {
    return this.a;
  }
  
  public void a(RedDisplayInfo paramRedDisplayInfo)
  {
    this.a = paramRedDisplayInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void eJ(ArrayList<String> paramArrayList)
  {
    this.yU = paramArrayList;
  }
  
  public List<String> fS()
  {
    return this.yU;
  }
  
  public int getIcon_type()
  {
    return this.dxf;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setIcon_type(int paramInt)
  {
    this.dxf = paramInt;
  }
  
  public void setNum(int paramInt)
  {
    this.num = paramInt;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.dxa);
    paramParcel.writeInt(this.dxb);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.buffer);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.dxc);
    paramParcel.writeList(this.yU);
    paramParcel.writeInt(this.dxd);
    paramParcel.writeInt(this.num);
    paramParcel.writeString(this.icon_url);
    paramParcel.writeInt(this.dxe);
    paramParcel.writeInt(this.dxf);
    paramParcel.writeInt(this.dxg);
    paramParcel.writeInt(this.dxh);
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeInt(this.dxi);
  }
  
  public String yw()
  {
    return this.buffer;
  }
  
  public String yx()
  {
    return this.icon_url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedAppInfo
 * JD-Core Version:    0.7.0.1
 */