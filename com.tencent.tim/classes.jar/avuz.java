import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoInfo.VideoRemark;
import cooperation.qzone.model.VideoUrl;

public final class avuz
  implements Parcelable.Creator<VideoInfo>
{
  public VideoInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.videoId = paramParcel.readString();
    localVideoInfo.jdField_a_of_type_CooperationQzoneModelVideoUrl = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_a_of_type_CooperationQzoneModelPictureUrl = ((PictureUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_b_of_type_CooperationQzoneModelPictureUrl = ((PictureUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_c_of_type_CooperationQzoneModelPictureUrl = ((PictureUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_d_of_type_CooperationQzoneModelPictureUrl = ((PictureUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.actionType = paramParcel.readInt();
    localVideoInfo.actionUrl = paramParcel.readString();
    localVideoInfo.jdField_b_of_type_CooperationQzoneModelVideoUrl = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_c_of_type_CooperationQzoneModelVideoUrl = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.jdField_d_of_type_CooperationQzoneModelVideoUrl = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.e = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.videoRateList = paramParcel.readArrayList(getClass().getClassLoader());
    localVideoInfo.currentVideoRate = paramParcel.readInt();
    localVideoInfo.originVideoSize = paramParcel.readLong();
    localVideoInfo.fileType = paramParcel.readInt();
    localVideoInfo.videoType = paramParcel.readInt();
    localVideoInfo.videoTime = paramParcel.readLong();
    localVideoInfo.showVideoTime = paramParcel.readString();
    localVideoInfo.playType = paramParcel.readByte();
    localVideoInfo.videoShowType = paramParcel.readInt();
    localVideoInfo.videoStatus = paramParcel.readInt();
    localVideoInfo.lastUseTime = paramParcel.readLong();
    localVideoInfo.width = paramParcel.readInt();
    localVideoInfo.height = paramParcel.readInt();
    localVideoInfo.toast = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localVideoInfo.isFakeFeed = bool1;
      localVideoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark = ((VideoInfo.VideoRemark)paramParcel.readParcelable(getClass().getClassLoader()));
      localVideoInfo.validVideoTime = paramParcel.readLong();
      localVideoInfo.validVideoTimeDesc = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label557;
      }
      bool1 = true;
      label405:
      localVideoInfo.isCircle = bool1;
      if (paramParcel.readInt() != 1) {
        break label562;
      }
      bool1 = true;
      label421:
      localVideoInfo.isAutoPlay = bool1;
      localVideoInfo.writeFrom = paramParcel.readInt();
      localVideoInfo.desc = paramParcel.readString();
      localVideoInfo.videoSource = paramParcel.readInt();
      localVideoInfo.advDelayTime = paramParcel.readInt();
      localVideoInfo.isGetRecommAfterPlay = paramParcel.readInt();
      localVideoInfo.shootTime = paramParcel.readLong();
      localVideoInfo.videoplaycnt = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label567;
      }
      bool1 = true;
      label500:
      localVideoInfo.allowShowPasterVideoAdv = bool1;
      if (paramParcel.readInt() != 1) {
        break label572;
      }
    }
    label557:
    label562:
    label567:
    label572:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localVideoInfo.needDeleteLocal = bool1;
      localVideoInfo.aAz = paramParcel.readLong();
      localVideoInfo.lloc = paramParcel.readString();
      localVideoInfo.albumid = paramParcel.readString();
      return localVideoInfo;
      bool1 = false;
      break;
      bool1 = false;
      break label405;
      bool1 = false;
      break label421;
      bool1 = false;
      break label500;
    }
  }
  
  public VideoInfo[] a(int paramInt)
  {
    return new VideoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avuz
 * JD-Core Version:    0.7.0.1
 */