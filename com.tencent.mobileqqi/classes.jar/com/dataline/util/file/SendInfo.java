package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import eu;
import java.io.File;

public class SendInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new eu();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  private SendInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  public SendInfo(String paramString1, String paramString2, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static SendInfo a(String paramString1, String paramString2, long paramLong)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    while (!new File(paramString1).exists()) {
      return null;
    }
    return new SendInfo(paramString1, paramString2, paramLong);
  }
  
  private boolean a(SendInfo paramSendInfo)
  {
    return (this.jdField_a_of_type_JavaLangString.equals(paramSendInfo.jdField_a_of_type_JavaLangString)) && (this.b.equals(paramSendInfo.b)) && (this.jdField_a_of_type_Long == paramSendInfo.jdField_a_of_type_Long) && (this.jdField_a_of_type_Int == paramSendInfo.jdField_a_of_type_Int);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof SendInfo))) {
      return false;
    }
    return a((SendInfo)paramObject);
  }
  
  public int hashCode()
  {
    return (this.jdField_a_of_type_JavaLangString + this.b + this.jdField_a_of_type_Long).hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.util.file.SendInfo
 * JD-Core Version:    0.7.0.1
 */