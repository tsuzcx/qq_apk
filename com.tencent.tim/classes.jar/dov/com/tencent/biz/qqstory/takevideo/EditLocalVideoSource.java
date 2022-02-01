package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import aozw;
import ayds;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;

public class EditLocalVideoSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator<EditLocalVideoSource> CREATOR = new ayds();
  @NonNull
  public final LocalMediaInfo d;
  public final int endTime;
  @NonNull
  public final String sourcePath;
  public int startTime;
  
  public EditLocalVideoSource(Parcel paramParcel)
  {
    this.sourcePath = paramParcel.readString();
    this.d = ((LocalMediaInfo)paramParcel.readParcelable(aozw.class.getClassLoader()));
    this.startTime = paramParcel.readInt();
    this.endTime = paramParcel.readInt();
  }
  
  public EditLocalVideoSource(String paramString, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    this.sourcePath = paramString;
    this.d = paramLocalMediaInfo;
    this.startTime = paramInt1;
    this.endTime = paramInt2;
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
    if ((this.startTime < 0) || (this.endTime < 0) || (this.endTime < this.startTime)) {
      return "startTime(" + this.startTime + ") or endTime(" + this.endTime + ") is illegal";
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.sourcePath);
    paramParcel.writeParcelable(this.d, 0);
    paramParcel.writeInt(this.startTime);
    paramParcel.writeInt(this.endTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource
 * JD-Core Version:    0.7.0.1
 */