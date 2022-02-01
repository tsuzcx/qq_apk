package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import avuz;
import avva;
import java.util.ArrayList;
import java.util.Map;

public class VideoInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoInfo> CREATOR = new avuz();
  public PictureUrl a;
  public VideoRemark a;
  public VideoUrl a;
  public long aAz;
  public int actionType;
  public String actionUrl;
  public int advDelayTime;
  public String albumid;
  public boolean allowShowPasterVideoAdv;
  public PictureUrl b;
  public VideoUrl b;
  public PictureUrl c;
  public VideoUrl c;
  public int currentVideoRate;
  public PictureUrl d;
  public VideoUrl d;
  public String desc;
  public VideoUrl e;
  public int fileType;
  public boolean hasVideoPlayed;
  public int height;
  public boolean isAutoPlay;
  public boolean isCircle;
  public boolean isFakeFeed;
  public boolean isFeedComplete;
  public boolean isFeedFirst = true;
  public boolean isFeedFirstComplete;
  public boolean isFloatFirst = true;
  public int isGetRecommAfterPlay;
  public boolean isTranscoding;
  public boolean isUploading;
  public long lastUseTime;
  public String lloc;
  public String nativeLikeUrl;
  public boolean needDeleteLocal;
  public long originVideoSize;
  public byte playType;
  public long shootTime;
  public String showVideoTime;
  public String toast;
  public long validVideoTime = -1L;
  public String validVideoTimeDesc;
  public Map<String, String> videoFloatReportParam;
  public String videoId;
  public ArrayList<VideoUrl> videoRateList;
  public int videoShowType;
  public int videoSource;
  public int videoStatus = 0;
  public long videoTime;
  public int videoType;
  public int videoplaycnt;
  public int width;
  public int writeFrom;
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isAutoPlay()
  {
    return ((this.playType & 0x1) != 0) || (this.videoShowType == 1);
  }
  
  public boolean isCircle()
  {
    return ((this.playType & 0x2) != 0) && ((this.validVideoTime <= 0L) || (this.validVideoTime >= this.videoTime));
  }
  
  public String toString()
  {
    return "VideoInfo [videoId=" + this.videoId + ", videoUrl=" + this.jdField_a_of_type_CooperationQzoneModelVideoUrl + ", bigUrl=" + this.jdField_b_of_type_CooperationQzoneModelPictureUrl + ", actionType=" + this.actionType + ", actionUrl=" + this.actionUrl + ", highBrUrl=" + this.jdField_b_of_type_CooperationQzoneModelVideoUrl + ", lowBrUrl=" + this.jdField_c_of_type_CooperationQzoneModelVideoUrl + ", fileType=" + this.fileType + ", videoType=" + this.videoType + ",videoShowType=" + this.videoShowType + ", videoTime=" + this.videoTime + ", videoStatus=" + this.videoStatus + ", originVideoUrl=" + this.jdField_d_of_type_CooperationQzoneModelVideoUrl + ", originVideoSize=" + this.originVideoSize + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    paramParcel.writeString(this.videoId);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelVideoUrl, paramInt);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelPictureUrl, paramInt);
    paramParcel.writeParcelable(this.jdField_b_of_type_CooperationQzoneModelPictureUrl, paramInt);
    paramParcel.writeParcelable(this.jdField_c_of_type_CooperationQzoneModelPictureUrl, paramInt);
    paramParcel.writeParcelable(this.jdField_d_of_type_CooperationQzoneModelPictureUrl, paramInt);
    paramParcel.writeInt(this.actionType);
    paramParcel.writeString(this.actionUrl);
    paramParcel.writeParcelable(this.jdField_b_of_type_CooperationQzoneModelVideoUrl, paramInt);
    paramParcel.writeParcelable(this.jdField_c_of_type_CooperationQzoneModelVideoUrl, paramInt);
    paramParcel.writeParcelable(this.jdField_d_of_type_CooperationQzoneModelVideoUrl, paramInt);
    paramParcel.writeParcelable(this.e, paramInt);
    paramParcel.writeList(this.videoRateList);
    paramParcel.writeInt(this.currentVideoRate);
    paramParcel.writeLong(this.originVideoSize);
    paramParcel.writeInt(this.fileType);
    paramParcel.writeInt(this.videoType);
    paramParcel.writeLong(this.videoTime);
    paramParcel.writeString(this.showVideoTime);
    paramParcel.writeByte(this.playType);
    paramParcel.writeInt(this.videoShowType);
    paramParcel.writeInt(this.videoStatus);
    paramParcel.writeLong(this.lastUseTime);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeString(this.toast);
    int i;
    if (this.isFakeFeed)
    {
      i = 1;
      paramParcel.writeInt(i);
      paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark, paramInt);
      paramParcel.writeLong(this.validVideoTime);
      paramParcel.writeString(this.validVideoTimeDesc);
      if (!this.isCircle) {
        break label402;
      }
      paramInt = 1;
      label268:
      paramParcel.writeInt(paramInt);
      if (!this.isAutoPlay) {
        break label407;
      }
      paramInt = 1;
      label282:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.writeFrom);
      paramParcel.writeString(this.desc);
      paramParcel.writeInt(this.videoSource);
      paramParcel.writeInt(this.advDelayTime);
      paramParcel.writeInt(this.isGetRecommAfterPlay);
      paramParcel.writeLong(this.shootTime);
      paramParcel.writeInt(this.videoplaycnt);
      if (!this.allowShowPasterVideoAdv) {
        break label412;
      }
      paramInt = 1;
      label352:
      paramParcel.writeInt(paramInt);
      if (!this.needDeleteLocal) {
        break label417;
      }
    }
    label402:
    label407:
    label412:
    label417:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.aAz);
      paramParcel.writeString(this.lloc);
      paramParcel.writeString(this.albumid);
      return;
      i = 0;
      break;
      paramInt = 0;
      break label268;
      paramInt = 0;
      break label282;
      paramInt = 0;
      break label352;
    }
  }
  
  public static class VideoRemark
    implements Parcelable
  {
    public static final Parcelable.Creator<VideoRemark> CREATOR = new avva();
    public int actiontype;
    public String actionurl = "";
    public String icondesc = "";
    public String iconurl = "";
    public int orgwebsite;
    public String remark = "";
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getDisplayRemark()
    {
      if (TextUtils.isEmpty(this.icondesc)) {
        return this.remark;
      }
      return this.icondesc + " -- " + this.remark;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.iconurl);
      paramParcel.writeString(this.icondesc);
      paramParcel.writeString(this.remark);
      paramParcel.writeInt(this.actiontype);
      paramParcel.writeString(this.actionurl);
      paramParcel.writeInt(this.orgwebsite);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.model.VideoInfo
 * JD-Core Version:    0.7.0.1
 */