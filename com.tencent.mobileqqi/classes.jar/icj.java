import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.FaceData;

public final class icj
  implements Parcelable.Creator
{
  public FaceData a(Parcel paramParcel)
  {
    FaceData localFaceData = new FaceData();
    localFaceData.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localFaceData.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localFaceData.jdField_a_of_type_Long = paramParcel.readLong();
    localFaceData.jdField_b_of_type_Long = paramParcel.readLong();
    localFaceData.jdField_c_of_type_Long = paramParcel.readLong();
    localFaceData.jdField_d_of_type_Long = paramParcel.readLong();
    localFaceData.jdField_e_of_type_Long = paramParcel.readLong();
    localFaceData.jdField_a_of_type_Int = paramParcel.readInt();
    localFaceData.jdField_f_of_type_Long = paramParcel.readLong();
    localFaceData.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localFaceData.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localFaceData.g = paramParcel.readLong();
    localFaceData.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localFaceData.h = paramParcel.readLong();
    localFaceData.jdField_f_of_type_JavaLangString = paramParcel.readString();
    localFaceData.jdField_a_of_type_AndroidGraphicsBitmap = null;
    return localFaceData;
  }
  
  public FaceData[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     icj
 * JD-Core Version:    0.7.0.1
 */