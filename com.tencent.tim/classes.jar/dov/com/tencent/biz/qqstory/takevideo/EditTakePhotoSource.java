package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import ayez;
import java.io.File;

public class EditTakePhotoSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator<EditTakePhotoSource> CREATOR = new ayez();
  public final double bn;
  public final int bpG;
  public final int height;
  public final double latitude;
  @NonNull
  public final String sourcePath;
  public final int width;
  
  public EditTakePhotoSource(Parcel paramParcel)
  {
    this.sourcePath = paramParcel.readString();
    this.bpG = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.bn = paramParcel.readDouble();
    this.latitude = paramParcel.readDouble();
  }
  
  public EditTakePhotoSource(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramString, paramInt1, paramInt2, paramInt3, 4.9E-324D, 4.9E-324D);
  }
  
  public EditTakePhotoSource(@NonNull String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2)
  {
    this.sourcePath = paramString;
    this.bpG = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.bn = paramDouble1;
    this.latitude = paramDouble2;
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
    return this.height;
  }
  
  @NonNull
  public String getSourcePath()
  {
    return this.sourcePath;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public String mR()
  {
    if (TextUtils.isEmpty(this.sourcePath)) {
      return "sourcePath is empty";
    }
    if (!new File(this.sourcePath).exists()) {
      return "Can not find file by sourcePath = " + this.sourcePath;
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.sourcePath);
    paramParcel.writeInt(this.bpG);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeDouble(this.bn);
    paramParcel.writeDouble(this.latitude);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource
 * JD-Core Version:    0.7.0.1
 */