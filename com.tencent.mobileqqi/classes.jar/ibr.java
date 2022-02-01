import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsData.GeoInfo;
import cooperation.qzone.LbsData.QzoneGpsInfo;

public final class ibr
  implements Parcelable.Creator
{
  public LbsData.GeoInfo a(Parcel paramParcel)
  {
    LbsData.GeoInfo localGeoInfo = new LbsData.GeoInfo();
    localGeoInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localGeoInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localGeoInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localGeoInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localGeoInfo.c = paramParcel.readString();
    localGeoInfo.d = paramParcel.readString();
    localGeoInfo.e = paramParcel.readString();
    localGeoInfo.f = paramParcel.readString();
    localGeoInfo.g = paramParcel.readString();
    localGeoInfo.h = paramParcel.readString();
    localGeoInfo.i = paramParcel.readString();
    localGeoInfo.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo = ((LbsData.QzoneGpsInfo)LbsData.QzoneGpsInfo.CREATOR.createFromParcel(paramParcel));
    return localGeoInfo;
  }
  
  public LbsData.GeoInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ibr
 * JD-Core Version:    0.7.0.1
 */