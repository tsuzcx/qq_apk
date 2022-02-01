package cooperation.qqreader.host.filemanager;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.filemanager.data.FileInfo;

public class ReaderFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ReaderFileInfo> CREATOR = new ReaderFileInfo.1();
  public static final String KEY_BUNDLE = "key_reader_file_for_bundle";
  private String mName;
  private String mPath;
  
  protected ReaderFileInfo(Parcel paramParcel)
  {
    this.mPath = paramParcel.readString();
    this.mName = paramParcel.readString();
  }
  
  public ReaderFileInfo(FileInfo paramFileInfo)
  {
    this.mPath = paramFileInfo.getPath();
    this.mName = paramFileInfo.getName();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.mPath = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mPath);
    paramParcel.writeString(this.mName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.filemanager.ReaderFileInfo
 * JD-Core Version:    0.7.0.1
 */