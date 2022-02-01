import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.model.CoverCacheData.GameCoverInfo;
import cooperation.qzone.model.CoverCacheData.PackageInfo;

public final class avuk
  implements Parcelable.Creator<CoverCacheData>
{
  public CoverCacheData a(Parcel paramParcel)
  {
    CoverCacheData localCoverCacheData = new CoverCacheData();
    if (paramParcel != null)
    {
      localCoverCacheData.uin = paramParcel.readLong();
      localCoverCacheData.coverId = paramParcel.readString();
      localCoverCacheData.type = paramParcel.readString();
      localCoverCacheData.cNV = paramParcel.readString();
      localCoverCacheData.cy = paramParcel.readHashMap(getClass().getClassLoader());
      localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo = ((CoverCacheData.PackageInfo)paramParcel.readParcelable(getClass().getClassLoader()));
      localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo = ((CoverCacheData.GameCoverInfo)paramParcel.readParcelable(getClass().getClassLoader()));
      localCoverCacheData.EY = paramParcel.readArrayList(getClass().getClassLoader());
      localCoverCacheData.eyG = paramParcel.readInt();
      localCoverCacheData.qI = paramParcel.readHashMap(getClass().getClassLoader());
      localCoverCacheData.qJ = paramParcel.readHashMap(getClass().getClassLoader());
      localCoverCacheData.alian = paramParcel.readInt();
    }
    return localCoverCacheData;
  }
  
  public CoverCacheData[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avuk
 * JD-Core Version:    0.7.0.1
 */