package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avvi;

public class WeishiPictureUrl
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiPictureUrl> CREATOR = new avvi();
  public PictureUrl e;
  public int key;
  
  public WeishiPictureUrl() {}
  
  public WeishiPictureUrl(int paramInt, PictureUrl paramPictureUrl)
  {
    this.key = paramInt;
    this.e = paramPictureUrl;
  }
  
  public WeishiPictureUrl(Parcel paramParcel)
  {
    this.key = paramParcel.readInt();
    this.e = ((PictureUrl)paramParcel.readParcelable(PictureUrl.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.key);
    paramParcel.writeParcelable(this.e, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.model.WeishiPictureUrl
 * JD-Core Version:    0.7.0.1
 */