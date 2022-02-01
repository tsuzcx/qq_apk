package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import aydo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;

public class EditLocalPhotoSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator<EditLocalPhotoSource> CREATOR = new aydo();
  public final LocalMediaInfo d;
  public final String sourcePath;
  
  public EditLocalPhotoSource(Parcel paramParcel)
  {
    this.sourcePath = paramParcel.readString();
    this.d = ((LocalMediaInfo)paramParcel.readParcelable(LocalMediaInfo.class.getClassLoader()));
  }
  
  public EditLocalPhotoSource(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    this.sourcePath = paramString;
    this.d = paramLocalMediaInfo;
    paramString = mR();
    if (paramString != null) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getHeight()
  {
    return this.d.mediaHeight;
  }
  
  @NonNull
  public String getSourcePath()
  {
    return this.sourcePath;
  }
  
  public int getWidth()
  {
    return this.d.mediaWidth;
  }
  
  public String mR()
  {
    if (TextUtils.isEmpty(this.sourcePath)) {
      return "sourcePath is empty";
    }
    if (!new File(this.sourcePath).exists()) {
      return "Can not find file by sourcePath = " + this.sourcePath;
    }
    if (this.d == null) {
      return "media info should not be null";
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.sourcePath);
    paramParcel.writeParcelable(this.d, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource
 * JD-Core Version:    0.7.0.1
 */