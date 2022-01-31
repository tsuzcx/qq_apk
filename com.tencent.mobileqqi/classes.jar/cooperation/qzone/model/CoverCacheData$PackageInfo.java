package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import icj;

public class CoverCacheData$PackageInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new icj();
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public CoverCacheData$PackageInfo()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.model.CoverCacheData.PackageInfo
 * JD-Core Version:    0.7.0.1
 */