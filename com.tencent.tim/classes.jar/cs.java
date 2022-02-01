import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.mpfile.MpfileTaskInfo;

public final class cs
  implements Parcelable.Creator<MpfileTaskInfo>
{
  public MpfileTaskInfo a(Parcel paramParcel)
  {
    MpfileTaskInfo localMpfileTaskInfo = new MpfileTaskInfo();
    localMpfileTaskInfo.type = paramParcel.readInt();
    localMpfileTaskInfo.status = paramParcel.readInt();
    localMpfileTaskInfo.key = paramParcel.readString();
    localMpfileTaskInfo.url = paramParcel.readString();
    localMpfileTaskInfo.fileId = paramParcel.readString();
    localMpfileTaskInfo.fileName = paramParcel.readString();
    localMpfileTaskInfo.filePath = paramParcel.readString();
    localMpfileTaskInfo.fileTempPath = paramParcel.readString();
    localMpfileTaskInfo.fileMd5 = paramParcel.readString();
    localMpfileTaskInfo.fileTime = paramParcel.readString();
    localMpfileTaskInfo.ak = paramParcel.readLong();
    localMpfileTaskInfo.totalSize = paramParcel.readLong();
    localMpfileTaskInfo.currentSize = paramParcel.readLong();
    localMpfileTaskInfo.taskId = paramParcel.readLong();
    localMpfileTaskInfo.al = paramParcel.readLong();
    localMpfileTaskInfo.am = paramParcel.readLong();
    localMpfileTaskInfo.din = paramParcel.readLong();
    return localMpfileTaskInfo;
  }
  
  public MpfileTaskInfo[] a(int paramInt)
  {
    return new MpfileTaskInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cs
 * JD-Core Version:    0.7.0.1
 */