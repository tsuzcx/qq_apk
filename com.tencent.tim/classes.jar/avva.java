import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.VideoInfo.VideoRemark;

public final class avva
  implements Parcelable.Creator<VideoInfo.VideoRemark>
{
  public VideoInfo.VideoRemark a(Parcel paramParcel)
  {
    VideoInfo.VideoRemark localVideoRemark = new VideoInfo.VideoRemark();
    localVideoRemark.iconurl = paramParcel.readString();
    localVideoRemark.icondesc = paramParcel.readString();
    localVideoRemark.remark = paramParcel.readString();
    localVideoRemark.actiontype = paramParcel.readInt();
    localVideoRemark.actionurl = paramParcel.readString();
    localVideoRemark.orgwebsite = paramParcel.readInt();
    return localVideoRemark;
  }
  
  public VideoInfo.VideoRemark[] a(int paramInt)
  {
    return new VideoInfo.VideoRemark[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avva
 * JD-Core Version:    0.7.0.1
 */