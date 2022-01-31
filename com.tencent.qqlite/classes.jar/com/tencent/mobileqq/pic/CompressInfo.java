package com.tencent.mobileqq.pic;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.BaseApplication;
import ear;

public class CompressInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ear();
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  public int g;
  public boolean g;
  public int h;
  
  public CompressInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
  }
  
  private CompressInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    boolean[] arrayOfBoolean = new boolean[2];
    paramParcel.readBooleanArray(arrayOfBoolean);
    this.jdField_a_of_type_Boolean = arrayOfBoolean[0];
    this.jdField_b_of_type_Boolean = arrayOfBoolean[1];
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    Context localContext = BaseApplication.getContext();
    if (paramBoolean) {}
    for (int i = 2131364310;; i = 2131364312)
    {
      this.jdField_b_of_type_JavaLangString = localContext.getString(i);
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nCompressInfo");
    localStringBuilder.append("\n|-").append("localUUID:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n|-").append("isSuccess:").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("\n|-").append("isOOM:").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\n|-").append("oomMsg:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n|-").append("srcPath:").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("\n|-").append("specPath:").append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("\n|-").append("destPath:").append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\n|-").append("picType:").append(this.jdField_f_of_type_Int);
    localStringBuilder.append("\n|-").append("picQuality:").append(this.jdField_g_of_type_Int);
    localStringBuilder.append("\n|-").append("isWifi:").append(this.jdField_e_of_type_Boolean);
    localStringBuilder.append("\n|-").append("sampleCompressCnt:").append(this.h);
    localStringBuilder.append("\n|-").append("compressMsg:").append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append("\n|-").append("isResultOriginal:").append(this.jdField_f_of_type_Boolean);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBooleanArray(new boolean[] { this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean });
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.CompressInfo
 * JD-Core Version:    0.7.0.1
 */