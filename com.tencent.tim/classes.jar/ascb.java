import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.wadl.WadlJsBridgeDownloadInfo;

public final class ascb
  implements Parcelable.Creator<WadlJsBridgeDownloadInfo>
{
  public WadlJsBridgeDownloadInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    WadlJsBridgeDownloadInfo localWadlJsBridgeDownloadInfo = new WadlJsBridgeDownloadInfo();
    localWadlJsBridgeDownloadInfo.appId = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.urlStr = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.packageName = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.pushTitle = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.sendTime = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.time = paramParcel.readInt();
    localWadlJsBridgeDownloadInfo.via = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.cDF = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.updateType = paramParcel.readInt();
    localWadlJsBridgeDownloadInfo.filePath = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.state = paramParcel.readInt();
    localWadlJsBridgeDownloadInfo.progress = paramParcel.readInt();
    localWadlJsBridgeDownloadInfo.awM = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      localWadlJsBridgeDownloadInfo.ddw = bool1;
      localWadlJsBridgeDownloadInfo.iconUrl = paramParcel.readString();
      localWadlJsBridgeDownloadInfo.ell = paramParcel.readInt();
      localWadlJsBridgeDownloadInfo.elm = paramParcel.readInt();
      localWadlJsBridgeDownloadInfo.extraData = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label203;
      }
    }
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localWadlJsBridgeDownloadInfo.isAutoInstallBySDK = bool1;
      return localWadlJsBridgeDownloadInfo;
      bool1 = false;
      break;
    }
  }
  
  public WadlJsBridgeDownloadInfo[] a(int paramInt)
  {
    return new WadlJsBridgeDownloadInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ascb
 * JD-Core Version:    0.7.0.1
 */