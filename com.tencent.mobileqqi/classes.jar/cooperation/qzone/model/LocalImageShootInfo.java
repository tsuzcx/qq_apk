package cooperation.qzone.model;

import android.media.ExifInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import icl;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalImageShootInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new icl();
  private static final String b;
  public long a;
  public GpsInfo4LocalImage a;
  public String a;
  public long b;
  
  static
  {
    jdField_b_of_type_JavaLangString = LocalImageShootInfo.class.getSimpleName();
  }
  
  public LocalImageShootInfo() {}
  
  public LocalImageShootInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readInt() != 0) {
      this.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage = new GpsInfo4LocalImage(paramParcel);
    }
  }
  
  private LocalImageShootInfo(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("file:///")) {
        str = paramString.replaceFirst("file://", "");
      }
    }
    paramString = new File(str);
    if ((!paramString.exists()) || (paramString.isDirectory())) {
      throw new Exception();
    }
    this.jdField_a_of_type_JavaLangString = paramString.getAbsolutePath();
    this.jdField_b_of_type_Long = paramString.lastModified();
  }
  
  public static LocalImageShootInfo a(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label21;
      }
      localObject1 = localObject3;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        label21:
        paramString = new LocalImageShootInfo(paramString);
        localObject1 = paramString;
        if (paramString == null) {
          continue;
        }
        b(paramString);
        a(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = localObject2;
        }
      }
    }
  }
  
  public static boolean a(LocalImageShootInfo paramLocalImageShootInfo)
  {
    boolean bool = true;
    if (paramLocalImageShootInfo == null) {
      bool = false;
    }
    while (paramLocalImageShootInfo.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage != null) {
      return bool;
    }
    try
    {
      ExifInterface localExifInterface = new ExifInterface(paramLocalImageShootInfo.jdField_a_of_type_JavaLangString);
      float[] arrayOfFloat = new float[2];
      if (localExifInterface.getLatLong(arrayOfFloat))
      {
        paramLocalImageShootInfo.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage = new GpsInfo4LocalImage(arrayOfFloat[0], arrayOfFloat[1]);
        return true;
      }
    }
    catch (Exception paramLocalImageShootInfo)
    {
      paramLocalImageShootInfo.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(LocalImageShootInfo paramLocalImageShootInfo)
  {
    if (paramLocalImageShootInfo == null) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = new ExifInterface(paramLocalImageShootInfo.jdField_a_of_type_JavaLangString).getAttribute("DateTime");
        localObject = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse((String)localObject);
        if (localObject != null)
        {
          paramLocalImageShootInfo.jdField_a_of_type_Long = ((Date)localObject).getTime();
          return true;
        }
      }
      catch (Exception paramLocalImageShootInfo)
      {
        paramLocalImageShootInfo.printStackTrace();
      }
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof LocalImageShootInfo));
    paramObject = (LocalImageShootInfo)paramObject;
    if ((this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) && (this.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage.equals(paramObject))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage != null)
    {
      paramParcel.writeInt(1);
      this.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage.writeToParcel(paramParcel, paramInt);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.model.LocalImageShootInfo
 * JD-Core Version:    0.7.0.1
 */