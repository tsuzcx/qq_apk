package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avux;

public class PublishEventTag
  implements Parcelable
{
  public static final Parcelable.Creator<PublishEventTag> CREATOR = new avux();
  public String cOg;
  public String desc;
  public String id;
  public String picUrl;
  public String protocol;
  public String time;
  public String title;
  public String uin;
  
  public PublishEventTag() {}
  
  public PublishEventTag(Parcel paramParcel)
  {
    this.title = paramParcel.readString();
    this.picUrl = paramParcel.readString();
    this.id = paramParcel.readString();
    this.protocol = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.cOg = paramParcel.readString();
    this.uin = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.picUrl);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.protocol);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.cOg);
    paramParcel.writeString(this.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.model.PublishEventTag
 * JD-Core Version:    0.7.0.1
 */