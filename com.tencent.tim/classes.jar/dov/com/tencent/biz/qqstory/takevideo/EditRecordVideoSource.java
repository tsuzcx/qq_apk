package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import ayev;
import java.io.File;

public class EditRecordVideoSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator<EditRecordVideoSource> CREATOR = new ayev();
  public final boolean aGI;
  public final String azu;
  public final int bpF;
  public final int bpG;
  public final int bpH;
  public final int bpI;
  public final int bpJ;
  public final int bpK;
  public final int bpL;
  public final float mH;
  public final long recordTime;
  @NonNull
  public final String sourcePath;
  
  public EditRecordVideoSource(Parcel paramParcel)
  {
    this.sourcePath = paramParcel.readString();
    this.bpF = paramParcel.readInt();
    this.recordTime = paramParcel.readLong();
    this.bpG = paramParcel.readInt();
    this.bpH = paramParcel.readInt();
    this.bpI = paramParcel.readInt();
    this.bpJ = paramParcel.readInt();
    this.bpK = paramParcel.readInt();
    this.bpL = paramParcel.readInt();
    this.mH = paramParcel.readFloat();
    this.azu = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.aGI = bool;
      return;
    }
  }
  
  public int describeContents()
  {
    return hashCode();
  }
  
  public int getHeight()
  {
    return this.bpI;
  }
  
  @NonNull
  public String getSourcePath()
  {
    return this.sourcePath;
  }
  
  public int getWidth()
  {
    return this.bpH;
  }
  
  public String mR()
  {
    if (TextUtils.isEmpty(this.sourcePath)) {
      return "sourcePath is empty";
    }
    if (!new File(this.sourcePath).exists()) {
      return "Can not find file by sourcePath = " + this.sourcePath;
    }
    if ((this.bpF <= 0) || (this.recordTime <= 0L)) {
      return "both totalFrame and recordTime can not less than 0";
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.sourcePath);
    paramParcel.writeInt(this.bpF);
    paramParcel.writeLong(this.recordTime);
    paramParcel.writeInt(this.bpG);
    paramParcel.writeInt(this.bpH);
    paramParcel.writeInt(this.bpI);
    paramParcel.writeInt(this.bpJ);
    paramParcel.writeInt(this.bpK);
    paramParcel.writeInt(this.bpL);
    paramParcel.writeFloat(this.mH);
    paramParcel.writeString(this.azu);
    if (this.aGI) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource
 * JD-Core Version:    0.7.0.1
 */