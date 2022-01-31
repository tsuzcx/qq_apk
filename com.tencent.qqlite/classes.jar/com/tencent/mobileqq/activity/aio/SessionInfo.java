package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import btd;

public class SessionInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR = new btd();
  public int a;
  public long a;
  public ChatBackground a;
  public String a;
  public int b;
  public String b;
  public int c = 0;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public SessionInfo()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_d_of_type_Int = 10004;
  }
  
  public SessionInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_d_of_type_Int = 10004;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.SessionInfo
 * JD-Core Version:    0.7.0.1
 */