package com.tencent.mobileqq.dating;

import acfp;
import afcg;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.UnsupportedEncodingException;

public class DatingFilters
  implements Parcelable
{
  public static final Parcelable.Creator<DatingFilters> CREATOR = new afcg();
  public static final String[] dS = { acfp.m(2131704678), "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
  public static final String[] eQ;
  public static String[] eR;
  public static final int[] kS = { 0, 22, 26, 35, 120 };
  public static final int[] kT = { 0, 18, 23, 27, 36 };
  public appoint_define.LocaleInfo a;
  public int age;
  public int cQd;
  public int cQe;
  public int cQf;
  public int career;
  public int datingSubject;
  public int gender;
  
  static
  {
    eQ = new String[] { acfp.m(2131704676), acfp.m(2131704682), acfp.m(2131704681), acfp.m(2131704679), acfp.m(2131704677) };
    eR = new String[] { acfp.m(2131704684), acfp.m(2131704686), acfp.m(2131704683), acfp.m(2131704680), acfp.m(2131704675), acfp.m(2131704685) };
  }
  
  private DatingFilters(Parcel paramParcel)
  {
    this.gender = paramParcel.readInt();
    this.cQd = paramParcel.readInt();
    this.cQe = paramParcel.readInt();
    this.datingSubject = paramParcel.readInt();
    this.age = paramParcel.readInt();
    this.career = paramParcel.readInt();
    this.cQf = paramParcel.readInt();
    paramParcel = paramParcel.readString();
    if ((paramParcel == null) || (paramParcel.equals("")))
    {
      this.a = null;
      return;
    }
    try
    {
      appoint_define.LocaleInfo localLocaleInfo = new appoint_define.LocaleInfo();
      localLocaleInfo.mergeFrom(paramParcel.getBytes("ISO-8859-1"));
      this.a = localLocaleInfo;
      return;
    }
    catch (Exception paramParcel)
    {
      this.a = null;
    }
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
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (DatingFilters)paramObject;
      if (this.age != paramObject.age) {
        return false;
      }
      if (this.career != paramObject.career) {
        return false;
      }
      if (this.cQe != paramObject.cQe) {
        return false;
      }
      if (this.cQd != paramObject.cQd) {
        return false;
      }
      if (this.gender != paramObject.gender) {
        return false;
      }
    } while ((this.a == paramObject.a) || ((this.a != null) && (paramObject.a != null) && (this.a.str_name.get().equals(paramObject.a.str_name.get()))));
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DatingFilters [gender=");
    localStringBuilder.append(this.gender);
    localStringBuilder.append(", datingTime=");
    localStringBuilder.append(this.cQd);
    localStringBuilder.append(", datingContent=");
    localStringBuilder.append(this.cQe);
    localStringBuilder.append(", age=");
    localStringBuilder.append(this.age);
    localStringBuilder.append(", career=");
    localStringBuilder.append(this.career);
    localStringBuilder.append(", dest=");
    if (this.a == null) {}
    for (String str = "null";; str = this.a.str_name.get())
    {
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.gender);
    paramParcel.writeInt(this.cQd);
    paramParcel.writeInt(this.cQe);
    paramParcel.writeInt(this.datingSubject);
    paramParcel.writeInt(this.age);
    paramParcel.writeInt(this.career);
    paramParcel.writeInt(this.cQf);
    try
    {
      if (this.a == null) {}
      for (String str = "";; str = new String(this.a.toByteArray(), "ISO-8859-1"))
      {
        paramParcel.writeString(str);
        return;
      }
      return;
    }
    catch (UnsupportedEncodingException paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingFilters
 * JD-Core Version:    0.7.0.1
 */