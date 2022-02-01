import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.now.model.LocalMediaInfo;

public final class ajwl
  implements Parcelable.Creator<LocalMediaInfo>
{
  public LocalMediaInfo a(Parcel paramParcel)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo._id = paramParcel.readLong();
    localLocalMediaInfo.path = paramParcel.readString();
    localLocalMediaInfo.fileSize = paramParcel.readLong();
    localLocalMediaInfo.addedDate = paramParcel.readLong();
    localLocalMediaInfo.modifiedDate = paramParcel.readLong();
    localLocalMediaInfo.orientation = paramParcel.readInt();
    localLocalMediaInfo.rotation = paramParcel.readInt();
    localLocalMediaInfo.mDuration = paramParcel.readLong();
    localLocalMediaInfo.selectStatus = paramParcel.readInt();
    localLocalMediaInfo.thumbWidth = paramParcel.readInt();
    localLocalMediaInfo.thumbHeight = paramParcel.readInt();
    localLocalMediaInfo.index = paramParcel.readInt();
    localLocalMediaInfo.position = Integer.valueOf(paramParcel.readInt());
    localLocalMediaInfo.mMimeType = paramParcel.readString();
    localLocalMediaInfo.url = paramParcel.readString();
    localLocalMediaInfo.mediaWidth = paramParcel.readInt();
    localLocalMediaInfo.mediaHeight = paramParcel.readInt();
    localLocalMediaInfo.longitude = paramParcel.readInt();
    localLocalMediaInfo.latitude = paramParcel.readInt();
    return localLocalMediaInfo;
  }
  
  public LocalMediaInfo[] a(int paramInt)
  {
    return new LocalMediaInfo[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajwl
 * JD-Core Version:    0.7.0.1
 */