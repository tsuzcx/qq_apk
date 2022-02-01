import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.ImageTagInfo;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.VideoInfo;
import java.util.ArrayList;

public final class avuu
  implements Parcelable.Creator<PhotoInfo>
{
  public PhotoInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    PhotoInfo localPhotoInfo = new PhotoInfo();
    localPhotoInfo.albumId = paramParcel.readString();
    localPhotoInfo.albumPriv = paramParcel.readInt();
    localPhotoInfo.currentUrl = paramParcel.readString();
    localPhotoInfo.bigUrl = paramParcel.readString();
    localPhotoInfo.orgUrl = paramParcel.readString();
    localPhotoInfo.desc = paramParcel.readString();
    localPhotoInfo.praiseCount = paramParcel.readInt();
    localPhotoInfo.commentCount = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localPhotoInfo.doU = bool1;
      localPhotoInfo.unikey = paramParcel.readString();
      localPhotoInfo.curkey = paramParcel.readString();
      localPhotoInfo.lloc = paramParcel.readString();
      localPhotoInfo.sloc = paramParcel.readString();
      localPhotoInfo.busi_param = paramParcel.readHashMap(getClass().getClassLoader());
      localPhotoInfo.EZ = paramParcel.readArrayList(getClass().getClassLoader());
      localPhotoInfo.eyI = paramParcel.readInt();
      localPhotoInfo.photoType = paramParcel.readInt();
      localPhotoInfo.opsynflag = paramParcel.readInt();
      localPhotoInfo.isIndependentUgc = paramParcel.readInt();
      localPhotoInfo.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage = ((GpsInfo4LocalImage)paramParcel.readParcelable(getClass().getClassLoader()));
      if (paramParcel.readInt() != 1) {
        break label697;
      }
      bool1 = true;
      label232:
      localPhotoInfo.isSelected = bool1;
      localPhotoInfo.ctime = paramParcel.readLong();
      localPhotoInfo.date = paramParcel.readLong();
      localPhotoInfo.tagList = new ArrayList();
      paramParcel.readTypedList(localPhotoInfo.tagList, ImageTagInfo.CREATOR);
      if (paramParcel.readInt() != 1) {
        break label702;
      }
      bool1 = true;
      label290:
      localPhotoInfo.isFakeFeed = bool1;
      localPhotoInfo.showGifState = paramParcel.readInt();
      localPhotoInfo.flag = paramParcel.readInt();
      localPhotoInfo.opMask = paramParcel.readInt();
      localPhotoInfo.allow_share = paramParcel.readInt();
      localPhotoInfo.videoflag = paramParcel.readInt();
      localPhotoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo = ((VideoInfo)paramParcel.readParcelable(VideoInfo.class.getClassLoader()));
      localPhotoInfo.albumName = paramParcel.readString();
      localPhotoInfo.uploadtime = paramParcel.readInt();
      localPhotoInfo.photoOpmask = paramParcel.readInt();
      localPhotoInfo.cOb = paramParcel.readString();
      localPhotoInfo.aAu = paramParcel.readLong();
      localPhotoInfo.appid = paramParcel.readInt();
      localPhotoInfo.pssCellId = paramParcel.readString();
      localPhotoInfo.pssCellSubId = paramParcel.readString();
      localPhotoInfo.pssUgcKey = paramParcel.readString();
      localPhotoInfo.pssSubId = paramParcel.readInt();
      localPhotoInfo.pssCurLikeKey = paramParcel.readString();
      localPhotoInfo.pssOrgLikeKey = paramParcel.readString();
      localPhotoInfo.pssBusiParam = paramParcel.readHashMap(getClass().getClassLoader());
      if (paramParcel.readInt() != 1) {
        break label707;
      }
      bool1 = true;
      label492:
      localPhotoInfo.pssHasFeedPraise = bool1;
      localPhotoInfo.shareWeixinUrl = paramParcel.readString();
      localPhotoInfo.shareQqUrl = paramParcel.readString();
      localPhotoInfo.shareTitle = paramParcel.readString();
      localPhotoInfo.shareSummary = paramParcel.readString();
      localPhotoInfo.sharePhotoUrl = paramParcel.readString();
      localPhotoInfo.shareSpaceRight = paramParcel.readInt();
      localPhotoInfo.shareAlbumRight = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label712;
      }
      bool1 = true;
      label571:
      localPhotoInfo.doV = bool1;
      localPhotoInfo.Fb = ((ArrayList)paramParcel.readSerializable());
      if (paramParcel.readInt() != 1) {
        break label717;
      }
      bool1 = true;
      label599:
      localPhotoInfo.doW = bool1;
      localPhotoInfo.aAv = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label722;
      }
      bool1 = true;
      label624:
      localPhotoInfo.doX = bool1;
      localPhotoInfo.cOc = paramParcel.readString();
      localPhotoInfo.cOd = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label727;
      }
    }
    label697:
    label702:
    label707:
    label712:
    label717:
    label722:
    label727:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPhotoInfo.doY = bool1;
      localPhotoInfo.Fa = paramParcel.readArrayList(getClass().getClassLoader());
      localPhotoInfo.re = paramParcel.readFloat();
      return localPhotoInfo;
      bool1 = false;
      break;
      bool1 = false;
      break label232;
      bool1 = false;
      break label290;
      bool1 = false;
      break label492;
      bool1 = false;
      break label571;
      bool1 = false;
      break label599;
      bool1 = false;
      break label624;
    }
  }
  
  public PhotoInfo[] a(int paramInt)
  {
    return new PhotoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avuu
 * JD-Core Version:    0.7.0.1
 */