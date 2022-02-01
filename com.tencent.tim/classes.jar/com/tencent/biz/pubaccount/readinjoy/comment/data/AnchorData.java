package com.tencent.biz.pubaccount.readinjoy.comment.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ktl;

public class AnchorData
  implements Parcelable
{
  public static final Parcelable.Creator<AnchorData> CREATOR = new ktl();
  public String acb;
  public String acd;
  public boolean ahJ = true;
  public boolean ahK;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.acb);
    paramParcel.writeString(this.acd);
    if (this.ahJ)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.ahK) {
        break label54;
      }
    }
    label54:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData
 * JD-Core Version:    0.7.0.1
 */