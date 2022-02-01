package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avuo;

public class DynamicPhotoData
  implements Parcelable
{
  public static final Parcelable.Creator<DynamicPhotoData> CREATOR = new avuo();
  public String cNY = "";
  public String cNZ = "";
  public String mDesc = "";
  public String mTitle = "";
  public String mUrl = "";
  
  public DynamicPhotoData(Parcel paramParcel)
  {
    this.mUrl = paramParcel.readString();
    this.mTitle = paramParcel.readString();
    this.mDesc = paramParcel.readString();
    this.cNY = paramParcel.readString();
    this.cNZ = paramParcel.readString();
  }
  
  public DynamicPhotoData(String paramString1, String paramString2, String paramString3)
  {
    this.mUrl = paramString1;
    this.mTitle = paramString2;
    this.mDesc = paramString3;
  }
  
  public DynamicPhotoData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mUrl = paramString1;
    this.mTitle = paramString2;
    this.mDesc = paramString3;
    this.cNY = paramString4;
    this.cNZ = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mUrl);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mDesc);
    paramParcel.writeString(this.cNY);
    paramParcel.writeString(this.cNZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.model.DynamicPhotoData
 * JD-Core Version:    0.7.0.1
 */