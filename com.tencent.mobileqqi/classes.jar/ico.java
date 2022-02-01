import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.PhotoParam;

public final class ico
  implements Parcelable.Creator
{
  public PhotoParam a(Parcel paramParcel)
  {
    boolean bool2 = true;
    PhotoParam localPhotoParam = new PhotoParam();
    localPhotoParam.jdField_a_of_type_Long = paramParcel.readLong();
    localPhotoParam.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localPhotoParam.jdField_b_of_type_Long = paramParcel.readLong();
    localPhotoParam.jdField_c_of_type_Long = paramParcel.readLong();
    localPhotoParam.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localPhotoParam.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localPhotoParam.jdField_b_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_c_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_d_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localPhotoParam.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localPhotoParam.jdField_f_of_type_JavaLangString = paramParcel.readString();
    localPhotoParam.g = paramParcel.readString();
    localPhotoParam.h = paramParcel.readString();
    localPhotoParam.i = paramParcel.readString();
    localPhotoParam.jdField_e_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_a_of_type_JavaUtilMap = paramParcel.readHashMap(getClass().getClassLoader());
    localPhotoParam.j = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localPhotoParam.jdField_a_of_type_Boolean = bool1;
      localPhotoParam.jdField_f_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label270;
      }
      bool1 = true;
      label215:
      localPhotoParam.jdField_b_of_type_Boolean = bool1;
      localPhotoParam.k = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label275;
      }
      bool1 = true;
      label240:
      localPhotoParam.jdField_c_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label280;
      }
    }
    label270:
    label275:
    label280:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPhotoParam.jdField_d_of_type_Boolean = bool1;
      return localPhotoParam;
      bool1 = false;
      break;
      bool1 = false;
      break label215;
      bool1 = false;
      break label240;
    }
  }
  
  public PhotoParam[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ico
 * JD-Core Version:    0.7.0.1
 */