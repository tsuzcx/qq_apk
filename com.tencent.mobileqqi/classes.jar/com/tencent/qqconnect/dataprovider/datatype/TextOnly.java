package com.tencent.qqconnect.dataprovider.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TextOnly
  implements Parcelable
{
  public static final Parcelable.Creator<TextOnly> CREATOR = new Parcelable.Creator()
  {
    public TextOnly createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TextOnly(paramAnonymousParcel, null);
    }
    
    public TextOnly[] newArray(int paramAnonymousInt)
    {
      return new TextOnly[paramAnonymousInt];
    }
  };
  private String mText;
  
  private TextOnly(Parcel paramParcel)
  {
    this.mText = paramParcel.readString();
  }
  
  public TextOnly(String paramString)
  {
    this.mText = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.qqconnect.dataprovider.datatype.TextOnly
 * JD-Core Version:    0.7.0.1
 */