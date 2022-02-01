import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.CoverCacheData.PackageInfo;

public final class avum
  implements Parcelable.Creator<CoverCacheData.PackageInfo>
{
  public CoverCacheData.PackageInfo a(Parcel paramParcel)
  {
    CoverCacheData.PackageInfo localPackageInfo = new CoverCacheData.PackageInfo();
    if (paramParcel != null)
    {
      localPackageInfo.prePic = paramParcel.readString();
      localPackageInfo.PackageUrl = paramParcel.readString();
      localPackageInfo.md5 = paramParcel.readString();
      localPackageInfo.weather = paramParcel.readInt();
      localPackageInfo.eyH = paramParcel.readInt();
      localPackageInfo.coverStyle = paramParcel.readInt();
      localPackageInfo.cNW = paramParcel.readString();
    }
    return localPackageInfo;
  }
  
  public CoverCacheData.PackageInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avum
 * JD-Core Version:    0.7.0.1
 */