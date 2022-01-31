import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.TempLiteMailIndexInfo;

public final class zwx
  implements Parcelable.Creator
{
  public DingdongPluginBizObserver.TempLiteMailIndexInfo a(Parcel paramParcel)
  {
    DingdongPluginBizObserver.TempLiteMailIndexInfo localTempLiteMailIndexInfo = new DingdongPluginBizObserver.TempLiteMailIndexInfo();
    localTempLiteMailIndexInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localTempLiteMailIndexInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localTempLiteMailIndexInfo.jdField_a_of_type_Long = paramParcel.readLong();
    return localTempLiteMailIndexInfo;
  }
  
  public DingdongPluginBizObserver.TempLiteMailIndexInfo[] a(int paramInt)
  {
    return new DingdongPluginBizObserver.TempLiteMailIndexInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zwx
 * JD-Core Version:    0.7.0.1
 */