package com.tencent.component.media.image;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ImageUrl
  implements Parcelable
{
  public static final Parcelable.Creator<ImageUrl> CREATOR = new ImageUrl.1();
  public String bigUrl;
  public boolean isHighScaleUrl;
  public boolean isNetWorkUrl;
  public boolean isSuperResolutionUrl;
  public String url;
  public String urlKey;
  public Integer urlKeyHashCode;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.urlKey);
    if (this.isSuperResolutionUrl)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.isHighScaleUrl) {
        break label85;
      }
      paramInt = 1;
      label41:
      paramParcel.writeInt(paramInt);
      if (!this.isNetWorkUrl) {
        break label90;
      }
    }
    label85:
    label90:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.urlKeyHashCode.intValue());
      paramParcel.writeString(this.bigUrl);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ImageUrl
 * JD-Core Version:    0.7.0.1
 */