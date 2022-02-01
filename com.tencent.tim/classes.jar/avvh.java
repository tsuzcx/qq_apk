import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.WeishiOperationInfo;

public final class avvh
  implements Parcelable.Creator<WeishiOperationInfo>
{
  public WeishiOperationInfo a(Parcel paramParcel)
  {
    return new WeishiOperationInfo(paramParcel);
  }
  
  public WeishiOperationInfo[] a(int paramInt)
  {
    return new WeishiOperationInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avvh
 * JD-Core Version:    0.7.0.1
 */