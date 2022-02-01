package cooperation.qqpim;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avlq;

public class QQPimTipsInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QQPimTipsInfo> CREATOR = new avlq();
  public byte bF;
  public String cMb;
  public int ext;
  public int tipsType;
  
  public QQPimTipsInfo() {}
  
  private QQPimTipsInfo(Parcel paramParcel)
  {
    this.tipsType = paramParcel.readInt();
    this.cMb = paramParcel.readString();
    this.bF = paramParcel.readByte();
    this.ext = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.tipsType);
    paramParcel.writeString(this.cMb);
    paramParcel.writeByte(this.bF);
    paramParcel.writeInt(this.ext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqpim.QQPimTipsInfo
 * JD-Core Version:    0.7.0.1
 */