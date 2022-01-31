package com.tencent.mobileqq.service.message.remote;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import gjc;

public class MessageRecordInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new gjc();
  public static final int d = 32772;
  public static final int e = 32770;
  public static final int f = 32768;
  public static final int g = 32769;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 2;
  public int a;
  public String a;
  public short a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public String d = "";
  private int k;
  private int l;
  
  public MessageRecordInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Short = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public MessageRecordInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Short = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    a(paramParcel);
  }
  
  public int a()
  {
    return this.k;
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void a(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Short = ((short)paramParcel.readInt());
    this.d = paramParcel.readString();
    if (paramParcel.readByte() == 0)
    {
      bool1 = false;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() != 0) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      this.jdField_b_of_type_Boolean = bool1;
      this.k = paramParcel.readInt();
      this.l = paramParcel.readInt();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      return;
      bool1 = true;
      break;
    }
  }
  
  public int b()
  {
    return this.l;
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_a_of_type_Short);
    paramParcel.writeString(this.d);
    if (this.jdField_a_of_type_Boolean)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.jdField_b_of_type_Boolean) {
        break label118;
      }
    }
    label118:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.k);
      paramParcel.writeInt(this.l);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.remote.MessageRecordInfo
 * JD-Core Version:    0.7.0.1
 */