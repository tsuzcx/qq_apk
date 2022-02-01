package dov.com.qq.im.poi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ayaf;

public class PoiInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PoiInfo> CREATOR = new ayaf();
  public String address;
  public long id;
  public int latitude;
  public int longitude;
  public String name;
  
  public PoiInfo() {}
  
  private PoiInfo(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.latitude = paramParcel.readInt();
    this.longitude = paramParcel.readInt();
    this.name = paramParcel.readString();
    this.address = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:").append(this.id);
    localStringBuilder.append(", latitude:").append(this.latitude);
    localStringBuilder.append(", longitude:").append(this.longitude);
    localStringBuilder.append(", name:").append(this.name);
    localStringBuilder.append(", address").append(this.address);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeInt(this.latitude);
    paramParcel.writeInt(this.longitude);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.address);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.poi.PoiInfo
 * JD-Core Version:    0.7.0.1
 */