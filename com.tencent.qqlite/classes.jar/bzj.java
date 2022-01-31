import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;

public final class bzj
  implements Parcelable.Creator
{
  public AIOImageData a(Parcel paramParcel)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.a = paramParcel.readLong();
    localAIOImageData.jdField_d_of_type_Int = paramParcel.readInt();
    localAIOImageData.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localAIOImageData.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localAIOImageData.f = paramParcel.readString();
    localAIOImageData.g = paramParcel.readString();
    localAIOImageData.b = paramParcel.readLong();
    localAIOImageData.c = paramParcel.readLong();
    localAIOImageData.jdField_d_of_type_Long = paramParcel.readLong();
    localAIOImageData.jdField_e_of_type_Long = paramParcel.readLong();
    return localAIOImageData;
  }
  
  public AIOImageData[] a(int paramInt)
  {
    return new AIOImageData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bzj
 * JD-Core Version:    0.7.0.1
 */