package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseBusinessAlbumInfo
  implements Parcelable, Cloneable
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  
  public BaseBusinessAlbumInfo()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public BaseBusinessAlbumInfo(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
  }
  
  public BaseBusinessAlbumInfo(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public BaseBusinessAlbumInfo a()
  {
    BaseBusinessAlbumInfo localBaseBusinessAlbumInfo = new BaseBusinessAlbumInfo(this.jdField_a_of_type_JavaLangString);
    localBaseBusinessAlbumInfo.a(this);
    return localBaseBusinessAlbumInfo;
  }
  
  public void a(BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo)
  {
    if (paramBaseBusinessAlbumInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramBaseBusinessAlbumInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Long = paramBaseBusinessAlbumInfo.jdField_a_of_type_Long;
    this.jdField_b_of_type_JavaLangString = paramBaseBusinessAlbumInfo.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramBaseBusinessAlbumInfo.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramBaseBusinessAlbumInfo.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramBaseBusinessAlbumInfo.jdField_b_of_type_Int;
    this.jdField_b_of_type_Long = paramBaseBusinessAlbumInfo.jdField_b_of_type_Long;
    this.jdField_c_of_type_Int = paramBaseBusinessAlbumInfo.jdField_c_of_type_Int;
    this.jdField_c_of_type_Long = paramBaseBusinessAlbumInfo.jdField_c_of_type_Long;
    this.d = paramBaseBusinessAlbumInfo.d;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b(BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo)
  {
    if (paramBaseBusinessAlbumInfo == null) {
      return;
    }
    this.jdField_a_of_type_Long = paramBaseBusinessAlbumInfo.jdField_a_of_type_Long;
    this.jdField_a_of_type_Int = paramBaseBusinessAlbumInfo.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramBaseBusinessAlbumInfo.jdField_b_of_type_Int;
    this.jdField_c_of_type_Int = paramBaseBusinessAlbumInfo.jdField_c_of_type_Int;
    if (!b(paramBaseBusinessAlbumInfo.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = paramBaseBusinessAlbumInfo.jdField_b_of_type_JavaLangString;
    }
    if (!b(paramBaseBusinessAlbumInfo.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = paramBaseBusinessAlbumInfo.jdField_c_of_type_JavaLangString;
    }
    this.jdField_c_of_type_Long = paramBaseBusinessAlbumInfo.jdField_c_of_type_Long;
    this.d = paramBaseBusinessAlbumInfo.d;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (BaseBusinessAlbumInfo)paramObject;
        if (this.jdField_a_of_type_JavaLangString != null) {
          break;
        }
      } while (paramObject.jdField_a_of_type_JavaLangString == null);
      return false;
    } while (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString));
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaLangString.hashCode()) {
      return i + 31;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.model.BaseBusinessAlbumInfo
 * JD-Core Version:    0.7.0.1
 */