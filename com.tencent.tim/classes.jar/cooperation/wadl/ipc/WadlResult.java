package cooperation.wadl.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ascc;
import awoq;

public class WadlResult
  implements Parcelable
{
  public static final Parcelable.Creator<WadlResult> CREATOR = new awoq();
  public long DZ;
  public WadlParams a;
  public String aJb;
  public int aqA;
  public int bBa;
  public long createTime;
  public int errCode;
  public long fileSize;
  public long lastUpdateTime;
  public int progress;
  public String taskId = "";
  
  public WadlResult(Parcel paramParcel)
  {
    this.a = ((WadlParams)paramParcel.readParcelable(WadlParams.class.getClassLoader()));
    this.taskId = paramParcel.readString();
    this.bBa = paramParcel.readInt();
    this.fileSize = paramParcel.readLong();
    this.DZ = paramParcel.readLong();
    this.aJb = paramParcel.readString();
    this.createTime = paramParcel.readLong();
    this.lastUpdateTime = paramParcel.readLong();
    this.errCode = paramParcel.readInt();
    this.progress = paramParcel.readInt();
  }
  
  public WadlResult(WadlParams paramWadlParams)
  {
    if (paramWadlParams != null) {
      this.a = paramWadlParams;
    }
  }
  
  public boolean aNm()
  {
    if (this.a != null) {}
    for (String str = this.a.packageName;; str = "")
    {
      this.bBa = ascc.a(this.bBa, str, this.aJb);
      if (this.bBa != 0) {
        break;
      }
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WadlResult{wadlParams=" + this.a + ", event=" + this.aqA + ", taskId='" + this.taskId + '\'' + ", taskStatus=" + this.bBa + ", fileSize=" + this.fileSize + ", downloadFileSize=" + this.DZ + ", downloadFilePath='" + this.aJb + '\'' + ", createTime=" + this.createTime + ", lastUpdateTime=" + this.lastUpdateTime + ", errCode=" + this.errCode + ", progress=" + this.progress + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeString(this.taskId);
    paramParcel.writeInt(this.bBa);
    paramParcel.writeLong(this.fileSize);
    paramParcel.writeLong(this.DZ);
    paramParcel.writeString(this.aJb);
    paramParcel.writeLong(this.createTime);
    paramParcel.writeLong(this.lastUpdateTime);
    paramParcel.writeInt(this.errCode);
    paramParcel.writeInt(this.progress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlResult
 * JD-Core Version:    0.7.0.1
 */