import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.model.CoverCacheData.PackageInfo;

public final class ici
  implements Parcelable.Creator
{
  public CoverCacheData a(Parcel paramParcel)
  {
    CoverCacheData localCoverCacheData = new CoverCacheData();
    localCoverCacheData.uin = paramParcel.readLong();
    localCoverCacheData.type = paramParcel.readString();
    localCoverCacheData.local_url = paramParcel.readString();
    localCoverCacheData.urls = paramParcel.readHashMap(getClass().getClassLoader());
    localCoverCacheData.packageInfo = ((CoverCacheData.PackageInfo)paramParcel.readParcelable(getClass().getClassLoader()));
    localCoverCacheData.photoWall = paramParcel.readArrayList(getClass().getClassLoader());
    localCoverCacheData.isJigsawOpen = paramParcel.readInt();
    return localCoverCacheData;
  }
  
  public CoverCacheData[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ici
 * JD-Core Version:    0.7.0.1
 */