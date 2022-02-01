import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.photo.ImageInfo;

public final class zrr
  implements Parcelable.Creator<ImageInfo>
{
  public ImageInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    ImageInfo localImageInfo = new ImageInfo();
    if (paramParcel.readInt() == 0)
    {
      bool1 = false;
      localImageInfo.bsB = bool1;
      if (paramParcel.readInt() != 0) {
        break label412;
      }
      bool1 = false;
      label35:
      localImageInfo.bsC = bool1;
      localImageInfo.thumbnail = paramParcel.readString();
      if (paramParcel.readInt() != 0) {
        break label417;
      }
      bool1 = false;
      label59:
      localImageInfo.bsD = bool1;
      if (paramParcel.readInt() != 0) {
        break label422;
      }
      bool1 = false;
      label74:
      localImageInfo.bsE = bool1;
      localImageInfo.filePath = paramParcel.readString();
      localImageInfo.toUin = paramParcel.readString();
      localImageInfo.progress = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {
        break label427;
      }
      bool1 = false;
      label116:
      localImageInfo.showProgress = bool1;
      localImageInfo.url = paramParcel.readString();
      localImageInfo.ceE = paramParcel.readInt();
      localImageInfo.urlAtServer = paramParcel.readString();
      localImageInfo.istroop = paramParcel.readInt();
      localImageInfo.issend = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {
        break label432;
      }
      bool1 = false;
      label176:
      localImageInfo.bsH = bool1;
      localImageInfo.filesize = paramParcel.readLong();
      if (paramParcel.readInt() != 0) {
        break label437;
      }
      bool1 = false;
      label200:
      localImageInfo.bsJ = bool1;
      if (paramParcel.readInt() != 0) {
        break label442;
      }
      bool1 = false;
      label215:
      localImageInfo.bsK = bool1;
      localImageInfo.baG = paramParcel.readString();
      localImageInfo.Ls = paramParcel.readLong();
      localImageInfo.baH = paramParcel.readString();
      localImageInfo.time = paramParcel.readLong();
      localImageInfo.selfuin = paramParcel.readString();
      localImageInfo.versionCode = paramParcel.readInt();
      localImageInfo.versionCode = paramParcel.readInt();
      localImageInfo.ceG = paramParcel.readInt();
      localImageInfo.msg = paramParcel.readString();
      localImageInfo.businessType = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label447;
      }
      bool1 = true;
      label321:
      localImageInfo.compressed = bool1;
      if (paramParcel.readInt() != 1) {
        break label452;
      }
      bool1 = true;
      label337:
      localImageInfo.bsP = bool1;
      if (paramParcel.readInt() != 1) {
        break label457;
      }
    }
    label412:
    label417:
    label422:
    label427:
    label432:
    label437:
    label442:
    label447:
    label452:
    label457:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localImageInfo.isGif = bool1;
      localImageInfo.uniseq = paramParcel.readLong();
      localImageInfo.baI = paramParcel.readString();
      localImageInfo.bigMsgUrl = paramParcel.readString();
      localImageInfo.rawMsgUrl = paramParcel.readString();
      localImageInfo.selectStatus = paramParcel.readInt();
      return localImageInfo;
      bool1 = true;
      break;
      bool1 = true;
      break label35;
      bool1 = true;
      break label59;
      bool1 = true;
      break label74;
      bool1 = true;
      break label116;
      bool1 = true;
      break label176;
      bool1 = true;
      break label200;
      bool1 = true;
      break label215;
      bool1 = false;
      break label321;
      bool1 = false;
      break label337;
    }
  }
  
  public ImageInfo[] a(int paramInt)
  {
    return new ImageInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zrr
 * JD-Core Version:    0.7.0.1
 */