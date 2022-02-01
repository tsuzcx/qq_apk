package com.tencent.component.media.image;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ImageUrl$1
  implements Parcelable.Creator<ImageUrl>
{
  public ImageUrl createFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    ImageUrl localImageUrl = new ImageUrl();
    localImageUrl.url = paramParcel.readString();
    localImageUrl.urlKey = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localImageUrl.isSuperResolutionUrl = bool1;
      if (paramParcel.readInt() != 1) {
        break label106;
      }
      bool1 = true;
      label55:
      localImageUrl.isHighScaleUrl = bool1;
      if (paramParcel.readInt() != 1) {
        break label111;
      }
    }
    label106:
    label111:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localImageUrl.isNetWorkUrl = bool1;
      localImageUrl.urlKeyHashCode = Integer.valueOf(paramParcel.readInt());
      localImageUrl.bigUrl = paramParcel.readString();
      return localImageUrl;
      bool1 = false;
      break;
      bool1 = false;
      break label55;
    }
  }
  
  public ImageUrl[] newArray(int paramInt)
  {
    return new ImageUrl[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ImageUrl.1
 * JD-Core Version:    0.7.0.1
 */