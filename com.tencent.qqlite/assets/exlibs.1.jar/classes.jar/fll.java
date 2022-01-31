import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsData.QzoneGpsInfo;
import cooperation.qzone.LbsData.QzonePoiInfo;

public final class fll
  implements Parcelable.Creator
{
  public LbsData.QzonePoiInfo a(Parcel paramParcel)
  {
    LbsData.QzonePoiInfo localQzonePoiInfo = new LbsData.QzonePoiInfo();
    localQzonePoiInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localQzonePoiInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localQzonePoiInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localQzonePoiInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localQzonePoiInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localQzonePoiInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localQzonePoiInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localQzonePoiInfo.jdField_c_of_type_Int = paramParcel.readInt();
    localQzonePoiInfo.jdField_d_of_type_Int = paramParcel.readInt();
    localQzonePoiInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
    localQzonePoiInfo.jdField_e_of_type_Int = paramParcel.readInt();
    localQzonePoiInfo.jdField_f_of_type_Int = paramParcel.readInt();
    localQzonePoiInfo.g = paramParcel.readString();
    if (paramParcel.readInt() == 1) {
      localQzonePoiInfo.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo = ((LbsData.QzoneGpsInfo)paramParcel.readParcelable(LbsData.QzoneGpsInfo.class.getClassLoader()));
    }
    return localQzonePoiInfo;
  }
  
  public LbsData.QzonePoiInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fll
 * JD-Core Version:    0.7.0.1
 */