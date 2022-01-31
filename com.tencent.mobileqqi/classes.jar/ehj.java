import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;

public final class ehj
  implements Parcelable.Creator
{
  public AIOImageData a(Parcel paramParcel)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.a = paramParcel.readLong();
    localAIOImageData.jdField_d_of_type_Int = paramParcel.readInt();
    localAIOImageData.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localAIOImageData.e = paramParcel.readString();
    localAIOImageData.f = paramParcel.readString();
    localAIOImageData.g = paramParcel.readString();
    localAIOImageData.b = paramParcel.readLong();
    localAIOImageData.c = paramParcel.readLong();
    return localAIOImageData;
  }
  
  public AIOImageData[] a(int paramInt)
  {
    return new AIOImageData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ehj
 * JD-Core Version:    0.7.0.1
 */