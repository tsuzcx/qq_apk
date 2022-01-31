package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bip;
import com.tencent.qphone.base.util.QLog;

public class RecvMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR = new bip();
  static String jdField_a_of_type_JavaLangString = "RecvMsg";
  int jdField_a_of_type_Int;
  String b;
  String c;
  String d;
  String e;
  String f;
  
  public RecvMsg()
  {
    this.jdField_a_of_type_Int = 0;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.b = null;
  }
  
  public RecvMsg(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.b = paramString5;
  }
  
  public RecvMsg(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Parcel paramParcel)
  {
    try
    {
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.c = paramParcel.readString();
      this.d = paramParcel.readString();
      this.e = paramParcel.readString();
      this.f = paramParcel.readString();
      this.b = paramParcel.readString();
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "readFromParcel RuntimeException", paramParcel);
    }
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public void e(String paramString)
  {
    this.b = paramString;
  }
  
  public String toString()
  {
    return jdField_a_of_type_JavaLangString + ", mVipBubbleId:" + this.jdField_a_of_type_Int + ", mAccountUin:" + this.c + ", mFriendUin:" + this.d + ", mSenderUin:" + this.e + ", mSenderName:" + this.f + ", mMsg:" + this.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeString(this.c);
      paramParcel.writeString(this.d);
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.b);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "writeToParcel RuntimeException", paramParcel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.service.RecvMsg
 * JD-Core Version:    0.7.0.1
 */