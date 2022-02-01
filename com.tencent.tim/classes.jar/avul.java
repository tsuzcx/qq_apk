import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.CoverCacheData.GameCoverInfo;

public final class avul
  implements Parcelable.Creator<CoverCacheData.GameCoverInfo>
{
  public CoverCacheData.GameCoverInfo a(Parcel paramParcel)
  {
    CoverCacheData.GameCoverInfo localGameCoverInfo = new CoverCacheData.GameCoverInfo();
    if (paramParcel != null)
    {
      localGameCoverInfo.xCoordLU = paramParcel.readDouble();
      localGameCoverInfo.yCoordLU = paramParcel.readDouble();
      localGameCoverInfo.xCoordRD = paramParcel.readDouble();
      localGameCoverInfo.yCoordRD = paramParcel.readDouble();
      localGameCoverInfo.jmpUrl = paramParcel.readString();
      localGameCoverInfo.schema = paramParcel.readString();
      localGameCoverInfo.jmpType = paramParcel.readInt();
    }
    return localGameCoverInfo;
  }
  
  public CoverCacheData.GameCoverInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avul
 * JD-Core Version:    0.7.0.1
 */