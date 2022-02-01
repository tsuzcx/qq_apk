package com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import aozw;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;
import rbz;

public class EditTakeVideoSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator<EditTakeVideoSource> CREATOR = new rbz();
  @NonNull
  public final String azv;
  @NonNull
  public final LocalMediaInfo d;
  @NonNull
  public final String sourcePath;
  
  public EditTakeVideoSource(Parcel paramParcel)
  {
    this.sourcePath = paramParcel.readString();
    this.azv = paramParcel.readString();
    this.d = ((LocalMediaInfo)paramParcel.readParcelable(aozw.class.getClassLoader()));
  }
  
  public EditTakeVideoSource(String paramString1, String paramString2, LocalMediaInfo paramLocalMediaInfo)
  {
    this.sourcePath = paramString1;
    this.azv = paramString2;
    this.d = paramLocalMediaInfo;
    paramString1 = mR();
    if (paramString1 != null) {
      throw new IllegalArgumentException(paramString1);
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
    if (!new File(this.azv).exists()) {
      return "Can not find file by audioSourcePath = " + this.azv;
    }
    if (this.d == null) {
      return "media info should not be null";
    }
    if (this.d.mDuration <= 0L) {
      return "media info duration should be large than 0";
    }
    return null;
  }
  
  public String toString()
  {
    return "EditTakeVideoSource: sourcePath=" + this.sourcePath + " audioSourcePath=" + this.azv + " mediaInfo=" + this.d;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.sourcePath);
    paramParcel.writeString(this.azv);
    paramParcel.writeParcelable(this.d, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditTakeVideoSource
 * JD-Core Version:    0.7.0.1
 */