import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.PhotoParam;

public final class avuv
  implements Parcelable.Creator<PhotoParam>
{
  public PhotoParam a(Parcel paramParcel)
  {
    boolean bool2 = true;
    PhotoParam localPhotoParam = new PhotoParam();
    localPhotoParam.loginUin = paramParcel.readLong();
    localPhotoParam.aAw = paramParcel.readLong();
    localPhotoParam.ownerUin = paramParcel.readLong();
    localPhotoParam.aAx = paramParcel.readLong();
    localPhotoParam.albumanswer = paramParcel.readString();
    localPhotoParam.albumid = paramParcel.readString();
    localPhotoParam.sortType = paramParcel.readInt();
    localPhotoParam.albumPriv = paramParcel.readInt();
    localPhotoParam.albumnum = paramParcel.readInt();
    localPhotoParam.uploadnum = paramParcel.readInt();
    localPhotoParam.albumType = paramParcel.readInt();
    localPhotoParam.eyK = paramParcel.readInt();
    localPhotoParam.qunid = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localPhotoParam.isLike = bool1;
      localPhotoParam.likeNum = paramParcel.readInt();
      localPhotoParam.commentNum = paramParcel.readInt();
      localPhotoParam.curKey = paramParcel.readString();
      localPhotoParam.orgKey = paramParcel.readString();
      localPhotoParam.feedId = paramParcel.readString();
      localPhotoParam.cell_id = paramParcel.readString();
      localPhotoParam.cell_subId = paramParcel.readString();
      localPhotoParam.appid = paramParcel.readInt();
      localPhotoParam.busi_param = paramParcel.readHashMap(getClass().getClassLoader());
      localPhotoParam.ugcKey = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label447;
      }
      bool1 = true;
      label251:
      localPhotoParam.doZ = bool1;
      localPhotoParam.subid = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label452;
      }
      bool1 = true;
      label276:
      localPhotoParam.dpa = bool1;
      localPhotoParam.cOe = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label457;
      }
      bool1 = true;
      label301:
      localPhotoParam.dpb = bool1;
      if (paramParcel.readInt() != 1) {
        break label462;
      }
      bool1 = true;
      label317:
      localPhotoParam.dpc = bool1;
      if (paramParcel.readInt() != 1) {
        break label467;
      }
      bool1 = true;
      label333:
      localPhotoParam.dpd = bool1;
      if (paramParcel.readInt() != 1) {
        break label472;
      }
      bool1 = true;
      label349:
      localPhotoParam.dpe = bool1;
      if (paramParcel.readInt() != 1) {
        break label477;
      }
      bool1 = true;
      label365:
      localPhotoParam.dpf = bool1;
      if (paramParcel.readInt() != 1) {
        break label482;
      }
      bool1 = true;
      label381:
      localPhotoParam.isVideoPicMix = bool1;
      localPhotoParam.eyL = paramParcel.readInt();
      localPhotoParam.sharer = paramParcel.readLong();
      localPhotoParam.cOf = paramParcel.readString();
      localPhotoParam.aAy = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label487;
      }
    }
    label447:
    label452:
    label457:
    label462:
    label467:
    label472:
    label477:
    label482:
    label487:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPhotoParam.dpg = bool1;
      return localPhotoParam;
      bool1 = false;
      break;
      bool1 = false;
      break label251;
      bool1 = false;
      break label276;
      bool1 = false;
      break label301;
      bool1 = false;
      break label317;
      bool1 = false;
      break label333;
      bool1 = false;
      break label349;
      bool1 = false;
      break label365;
      bool1 = false;
      break label381;
    }
  }
  
  public PhotoParam[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avuv
 * JD-Core Version:    0.7.0.1
 */