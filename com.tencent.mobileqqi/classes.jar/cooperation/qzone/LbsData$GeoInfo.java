package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import igm;

public class LbsData$GeoInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new igm();
  public int a;
  public LbsData.QzoneGpsInfo a;
  public String a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  
  public LbsData$GeoInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public GeoInfo a()
  {
    GeoInfo localGeoInfo = new GeoInfo();
    localGeoInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localGeoInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localGeoInfo.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localGeoInfo.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localGeoInfo.c = this.c;
    localGeoInfo.d = this.d;
    localGeoInfo.e = this.e;
    localGeoInfo.f = this.f;
    localGeoInfo.g = this.g;
    localGeoInfo.h = this.h;
    localGeoInfo.i = this.i;
    if (this.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo != null) {
      localGeoInfo.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo = this.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo.a();
    }
    return localGeoInfo;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.c)) || (!TextUtils.isEmpty(this.d)) || (!TextUtils.isEmpty(this.e));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.LbsData.GeoInfo
 * JD-Core Version:    0.7.0.1
 */