package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ecf;
import java.io.File;

public class AIOImageData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ecf();
  public static final int a = 1;
  public static final String a = "I:N";
  public static final int b = 2;
  public static final String b = "I:E";
  public static final int c = 4;
  @Deprecated
  public static final String c = "";
  public long a;
  public long b;
  public long c;
  public int d;
  public String d;
  public String e = "I:N";
  public String f = "I:N";
  public String g = "I:N";
  
  public AIOImageData()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = "I:N";
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 0;
      if (paramString.equals(this.jdField_d_of_type_JavaLangString)) {
        return 1;
      }
      if (paramString.equals(this.e)) {
        return 2;
      }
    } while (!paramString.equals(this.f));
    return 4;
  }
  
  public File a(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    case 3: 
    default: 
      localObject = null;
    }
    while ((localObject != null) && (!((String)localObject).equals("I:N")))
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        break;
      }
      return localObject;
      localObject = this.jdField_d_of_type_JavaLangString;
      continue;
      localObject = this.e;
      continue;
      localObject = this.f;
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    Object localObject2 = null;
    String str;
    switch (paramInt)
    {
    case 3: 
    default: 
      str = null;
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (!str.equals("I:N"))
        {
          localObject1 = localObject2;
          if (!str.equals(""))
          {
            if (str.startsWith("/")) {
              break;
            }
            localObject1 = "file:/" + str;
          }
        }
      }
      return localObject1;
      str = this.jdField_d_of_type_JavaLangString;
      continue;
      str = this.e;
      continue;
      str = this.f;
    }
    if (str.startsWith("//")) {
      return "file:" + str;
    }
    return "file:" + str;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 3: 
    default: 
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
        } while (!this.jdField_d_of_type_JavaLangString.equals("I:N"));
        return false;
      } while (!this.e.equals("I:N"));
      return false;
    } while (!this.f.equals("I:N"));
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageData
 * JD-Core Version:    0.7.0.1
 */