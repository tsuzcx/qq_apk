package com.tencent.mobileqq.filemanager.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import dqy;

public class ForwardFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new dqy();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  
  public ForwardFileInfo()
  {
    a("");
    b("");
    d("");
    b(-1L);
    c("");
    a(this.jdField_a_of_type_Int);
    e("");
  }
  
  private ForwardFileInfo(Parcel paramParcel)
  {
    a(paramParcel.readInt());
    b(paramParcel.readLong());
    d(paramParcel.readLong());
    a(paramParcel.readString());
    b(paramParcel.readString());
    c(paramParcel.readString());
    b(paramParcel.readInt());
    d(paramParcel.readString());
    a(paramParcel.readLong());
    c(paramParcel.readInt());
    c(paramParcel.readLong());
    e(paramParcel.readString());
  }
  
  private boolean a(ForwardFileInfo paramForwardFileInfo)
  {
    return (d().equals(paramForwardFileInfo.d())) && (d() == paramForwardFileInfo.d()) && (a() == paramForwardFileInfo.a());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long c()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public long d()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void d(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
  }
  
  public void d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof ForwardFileInfo))) {
      return false;
    }
    return a((ForwardFileInfo)paramObject);
  }
  
  public int hashCode()
  {
    return (d() + d()).hashCode();
  }
  
  public String toString()
  {
    return "type[" + this.jdField_a_of_type_Int + "], cloudTYpe[" + this.jdField_b_of_type_Int + "], sessionId[" + this.jdField_a_of_type_Long + "], uniseq[" + this.jdField_b_of_type_Long + "], uuid[" + this.jdField_b_of_type_JavaLangString + "], fileId[" + this.jdField_c_of_type_JavaLangString + "], weiYunSrcType[" + this.jdField_c_of_type_Int + "], uuidTroopFile[" + this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a());
    paramParcel.writeLong(b());
    paramParcel.writeLong(d());
    paramParcel.writeString(a());
    paramParcel.writeString(b());
    paramParcel.writeString(c());
    paramParcel.writeInt(b());
    paramParcel.writeString(d());
    paramParcel.writeLong(a());
    paramParcel.writeInt(c());
    paramParcel.writeLong(c());
    paramParcel.writeString(e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.ForwardFileInfo
 * JD-Core Version:    0.7.0.1
 */