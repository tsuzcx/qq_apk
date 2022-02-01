package cooperation.qzone.album;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avsl;
import java.util.HashMap;
import java.util.Map;

public class QzonePhotoInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QzonePhotoInfo> CREATOR = new avsl();
  public String mAlbumId = "";
  public int mBigHeight;
  public String mBigUrl = "";
  public int mBigWidth;
  public long mShootTime;
  public long mUploadTime;
  public String mlloc = "";
  public Map<Integer, String> qe = new HashMap();
  
  public QzonePhotoInfo() {}
  
  public QzonePhotoInfo(Parcel paramParcel)
  {
    this.mAlbumId = paramParcel.readString();
    this.mBigUrl = paramParcel.readString();
    this.mBigWidth = paramParcel.readInt();
    this.mBigHeight = paramParcel.readInt();
    this.mlloc = paramParcel.readString();
    this.qe = paramParcel.readHashMap(Map.class.getClassLoader());
    this.mShootTime = paramParcel.readLong();
    this.mUploadTime = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mAlbumId);
    paramParcel.writeString(this.mBigUrl);
    paramParcel.writeInt(this.mBigWidth);
    paramParcel.writeInt(this.mBigHeight);
    paramParcel.writeString(this.mlloc);
    paramParcel.writeMap(this.qe);
    paramParcel.writeLong(this.mShootTime);
    paramParcel.writeLong(this.mUploadTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.album.QzonePhotoInfo
 * JD-Core Version:    0.7.0.1
 */