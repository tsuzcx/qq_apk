import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.util.FaceInfo;

public final class aqdl
  implements Parcelable.Creator<FaceInfo>
{
  public FaceInfo a(Parcel paramParcel)
  {
    FaceInfo localFaceInfo = new FaceInfo();
    localFaceInfo.readFromParcel(paramParcel);
    return localFaceInfo;
  }
  
  public FaceInfo[] a(int paramInt)
  {
    return new FaceInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqdl
 * JD-Core Version:    0.7.0.1
 */