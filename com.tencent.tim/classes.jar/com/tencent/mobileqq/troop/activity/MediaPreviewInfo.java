package com.tencent.mobileqq.troop.activity;

import advm;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aoss;
import org.json.JSONObject;

public class MediaPreviewInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MediaPreviewInfo> CREATOR = new aoss();
  public String imageUrl;
  public int type = -1;
  public String videoLocalPath;
  public String videoUrl;
  
  public MediaPreviewInfo() {}
  
  public MediaPreviewInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.type = paramJSONObject.optInt("type", -1);
      this.imageUrl = paramJSONObject.optString("image");
      this.videoUrl = paramJSONObject.optString("video");
      this.videoLocalPath = advm.jZ(this.videoUrl);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "type = " + this.type + ", imageUrl = " + this.imageUrl + ", videoUrl = " + this.videoUrl + ", videoLocalPath = " + this.videoLocalPath;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.imageUrl);
    paramParcel.writeString(this.videoUrl);
    paramParcel.writeString(this.videoLocalPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewInfo
 * JD-Core Version:    0.7.0.1
 */