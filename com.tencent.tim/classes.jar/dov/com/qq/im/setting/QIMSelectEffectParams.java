package dov.com.qq.im.setting;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aycd;

public class QIMSelectEffectParams
  implements Parcelable
{
  public static final Parcelable.Creator<QIMSelectEffectParams> CREATOR = new aycd();
  public int aCj;
  public int categoryId;
  public String categoryName;
  public String itemId;
  
  public QIMSelectEffectParams(Parcel paramParcel)
  {
    this.aCj = paramParcel.readInt();
    this.categoryName = paramParcel.readString();
    this.categoryId = paramParcel.readInt();
    this.itemId = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aCj);
    paramParcel.writeString(this.categoryName);
    paramParcel.writeInt(this.categoryId);
    paramParcel.writeString(this.itemId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.setting.QIMSelectEffectParams
 * JD-Core Version:    0.7.0.1
 */