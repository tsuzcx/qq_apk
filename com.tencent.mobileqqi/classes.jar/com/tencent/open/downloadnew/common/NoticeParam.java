package com.tencent.open.downloadnew.common;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import hst;

public class NoticeParam
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new hst();
  public int a;
  public long a;
  public Intent a;
  public String a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g;
  
  public NoticeParam()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public NoticeParam(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_AndroidContentIntent = ((Intent)paramParcel.readParcelable(null));
    this.g = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.f);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidContentIntent, paramInt);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.NoticeParam
 * JD-Core Version:    0.7.0.1
 */