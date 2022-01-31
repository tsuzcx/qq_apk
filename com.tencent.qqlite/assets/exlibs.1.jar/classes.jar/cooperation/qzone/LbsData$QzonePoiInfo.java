package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import fll;

public class LbsData$QzonePoiInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new fll();
  public int a;
  public LbsData.QzoneGpsInfo a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public String g = "";
  
  public LbsData$QzonePoiInfo()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
  }
  
  public static QzonePoiInfo a(QzonePoiInfo paramQzonePoiInfo)
  {
    LbsData.QzoneGpsInfo localQzoneGpsInfo = null;
    if (paramQzonePoiInfo == null) {
      return null;
    }
    QzonePoiInfo localQzonePoiInfo = new QzonePoiInfo();
    localQzonePoiInfo.jdField_e_of_type_JavaLangString = paramQzonePoiInfo.jdField_e_of_type_JavaLangString;
    localQzonePoiInfo.g = paramQzonePoiInfo.g;
    localQzonePoiInfo.jdField_c_of_type_Int = paramQzonePoiInfo.jdField_c_of_type_Int;
    localQzonePoiInfo.jdField_b_of_type_Int = paramQzonePoiInfo.jdField_b_of_type_Int;
    if (paramQzonePoiInfo.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo != null) {
      localQzoneGpsInfo = paramQzonePoiInfo.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo.a();
    }
    localQzonePoiInfo.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo = localQzoneGpsInfo;
    localQzonePoiInfo.jdField_d_of_type_Int = paramQzonePoiInfo.jdField_d_of_type_Int;
    localQzonePoiInfo.jdField_f_of_type_JavaLangString = paramQzonePoiInfo.jdField_f_of_type_JavaLangString;
    localQzonePoiInfo.jdField_c_of_type_JavaLangString = paramQzonePoiInfo.jdField_c_of_type_JavaLangString;
    localQzonePoiInfo.jdField_a_of_type_JavaLangString = paramQzonePoiInfo.jdField_a_of_type_JavaLangString;
    localQzonePoiInfo.jdField_b_of_type_JavaLangString = paramQzonePoiInfo.jdField_b_of_type_JavaLangString;
    localQzonePoiInfo.jdField_f_of_type_Int = paramQzonePoiInfo.jdField_f_of_type_Int;
    localQzonePoiInfo.jdField_e_of_type_Int = paramQzonePoiInfo.jdField_e_of_type_Int;
    localQzonePoiInfo.jdField_a_of_type_Int = paramQzonePoiInfo.jdField_a_of_type_Int;
    localQzonePoiInfo.jdField_d_of_type_JavaLangString = paramQzonePoiInfo.jdField_d_of_type_JavaLangString;
    return localQzonePoiInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    return ((QzonePoiInfo)paramObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString);
  }
  
  public String toString()
  {
    if (this.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo != null) {
      return " poiId: " + this.jdField_a_of_type_JavaLangString + " poiName: " + this.jdField_b_of_type_JavaLangString + " poiType: " + this.jdField_a_of_type_Int + " poiTypeName: " + this.jdField_d_of_type_JavaLangString + " address: " + this.jdField_e_of_type_JavaLangString + " districtCode: " + this.jdField_b_of_type_Int + " distance: " + this.jdField_c_of_type_Int + " phoneNumber: " + this.jdField_f_of_type_JavaLangString + "poiOrderType: " + this.jdField_e_of_type_Int + "poiNum: " + this.jdField_f_of_type_Int + " gpsInfo: " + this.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo.toString() + " ";
    }
    return "poiId: " + this.jdField_a_of_type_JavaLangString + "poiName: " + this.jdField_b_of_type_JavaLangString + "poiType: " + this.jdField_a_of_type_Int + "poiTypeName: " + this.jdField_d_of_type_JavaLangString + "address: " + this.jdField_e_of_type_JavaLangString + "districtCode: " + this.jdField_b_of_type_Int + "distance: " + this.jdField_c_of_type_Int + "phoneNumber: " + this.jdField_f_of_type_JavaLangString + "poiOrderType: " + this.jdField_e_of_type_Int + "poiNum: " + this.jdField_f_of_type_Int + " " + "dianPingId:" + this.g;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeString(this.g);
    if (this.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo == null)
    {
      paramParcel.writeInt(0);
      return;
    }
    paramParcel.writeInt(1);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.LbsData.QzonePoiInfo
 * JD-Core Version:    0.7.0.1
 */