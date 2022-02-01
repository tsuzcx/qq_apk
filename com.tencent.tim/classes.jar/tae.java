import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;

public final class tae
  implements Parcelable.Creator<MessageForShortVideo>
{
  public MessageForDevShortVideo a(Parcel paramParcel)
  {
    MessageForDevShortVideo localMessageForDevShortVideo = new MessageForDevShortVideo();
    localMessageForDevShortVideo.uuid = paramParcel.readString();
    localMessageForDevShortVideo.md5 = paramParcel.readString();
    localMessageForDevShortVideo.videoFileName = paramParcel.readString();
    localMessageForDevShortVideo.videoFileSize = paramParcel.readInt();
    localMessageForDevShortVideo.videoFileFormat = paramParcel.readInt();
    localMessageForDevShortVideo.videoFileTime = paramParcel.readInt();
    localMessageForDevShortVideo.thumbWidth = paramParcel.readInt();
    localMessageForDevShortVideo.thumbHeight = paramParcel.readInt();
    localMessageForDevShortVideo.videoFileStatus = paramParcel.readInt();
    localMessageForDevShortVideo.videoFileProgress = paramParcel.readInt();
    localMessageForDevShortVideo.fileType = paramParcel.readInt();
    localMessageForDevShortVideo.thumbMD5 = paramParcel.readString();
    localMessageForDevShortVideo.fileSource = paramParcel.readString();
    localMessageForDevShortVideo.lastModified = paramParcel.readLong();
    return localMessageForDevShortVideo;
  }
  
  public MessageForDevShortVideo[] a(int paramInt)
  {
    return new MessageForDevShortVideo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tae
 * JD-Core Version:    0.7.0.1
 */