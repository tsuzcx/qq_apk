package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import aozw;
import ayfa;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;

public class EditTakeVideoSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator<EditTakeVideoSource> CREATOR = new ayfa();
  @NonNull
  public final String azv;
  public final String cWQ;
  @NonNull
  public final LocalMediaInfo d;
  @NonNull
  public final String sourcePath;
  
  public EditTakeVideoSource(Parcel paramParcel)
  {
    this.sourcePath = paramParcel.readString();
    this.azv = paramParcel.readString();
    this.d = ((LocalMediaInfo)paramParcel.readParcelable(aozw.class.getClassLoader()));
    this.cWQ = paramParcel.readString();
  }
  
  public EditTakeVideoSource(String paramString1, String paramString2, LocalMediaInfo paramLocalMediaInfo)
  {
    this.sourcePath = paramString1;
    this.azv = paramString2;
    this.d = paramLocalMediaInfo;
    this.cWQ = "";
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
    return null;
  }
  
  public String toString()
  {
    return "EditTakeVideoSource: sourcePath=" + this.sourcePath + " audioSourcePath=" + this.azv + " mediaInfo=" + this.d + " audioBgmSourcePath=" + this.cWQ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.sourcePath);
    paramParcel.writeString(this.azv);
    paramParcel.writeParcelable(this.d, 0);
    paramParcel.writeString(this.cWQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource
 * JD-Core Version:    0.7.0.1
 */