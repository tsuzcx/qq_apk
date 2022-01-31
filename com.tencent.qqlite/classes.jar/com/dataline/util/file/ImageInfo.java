package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import dw;
import java.io.File;

public class ImageInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new dw();
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  
  private ImageInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.c = paramParcel.readString();
  }
  
  public ImageInfo(String paramString)
  {
    paramString = new File(paramString);
    if ((!paramString.exists()) || (paramString.isDirectory())) {
      throw new ImageInfo.InvalidImageException(this, "image file not exist!");
    }
    this.jdField_a_of_type_JavaLangString = paramString.getAbsolutePath();
    this.jdField_b_of_type_JavaLangString = paramString.getName();
    this.jdField_a_of_type_Long = paramString.length();
    this.jdField_b_of_type_Long = paramString.lastModified();
  }
  
  public static ImageInfo a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!new File(paramString).exists()) {
      return null;
    }
    try
    {
      paramString = new ImageInfo(paramString);
      return paramString;
    }
    catch (ImageInfo.InvalidImageException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  private boolean a(ImageInfo paramImageInfo)
  {
    return (this.jdField_b_of_type_JavaLangString.equals(paramImageInfo.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == paramImageInfo.jdField_a_of_type_Long) && (this.jdField_b_of_type_Long == paramImageInfo.jdField_b_of_type_Long) && (this.jdField_a_of_type_JavaLangString.equals(paramImageInfo.jdField_a_of_type_JavaLangString));
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    if (this.d == null) {
      this.d = MediaStoreUtil.a(a());
    }
    return this.d;
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
    if ((paramObject == null) || (!(paramObject instanceof ImageInfo))) {
      return false;
    }
    return a((ImageInfo)paramObject);
  }
  
  public int hashCode()
  {
    return (this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long + this.jdField_b_of_type_Long).hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.dataline.util.file.ImageInfo
 * JD-Core Version:    0.7.0.1
 */