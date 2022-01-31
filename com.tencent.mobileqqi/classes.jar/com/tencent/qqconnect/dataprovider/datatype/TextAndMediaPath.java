package com.tencent.qqconnect.dataprovider.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TextAndMediaPath
  implements Parcelable
{
  public static final Parcelable.Creator<TextAndMediaPath> CREATOR = new Parcelable.Creator()
  {
    public TextAndMediaPath createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TextAndMediaPath(paramAnonymousParcel, null);
    }
    
    public TextAndMediaPath[] newArray(int paramAnonymousInt)
    {
      return new TextAndMediaPath[paramAnonymousInt];
    }
  };
  private String mMediaPath;
  private String mText;
  
  private TextAndMediaPath(Parcel paramParcel)
  {
    this.mText = paramParcel.readString();
    this.mMediaPath = paramParcel.readString();
  }
  
  public TextAndMediaPath(String paramString1, String paramString2)
  {
    this.mText = paramString1;
    this.mMediaPath = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getMediaPath()
  {
    return this.mMediaPath;
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mText);
    paramParcel.writeString(this.mMediaPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.qqconnect.dataprovider.datatype.TextAndMediaPath
 * JD-Core Version:    0.7.0.1
 */