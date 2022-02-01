package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.persistence.Entity;
import mhw;

public class RecommendFollowInfoTitle
  extends Entity
  implements Parcelable
{
  public static Parcelable.Creator<RecommendFollowInfoTitle> CREATOR = new mhw();
  public boolean isAllFollowed;
  public String title;
  
  public RecommendFollowInfoTitle() {}
  
  public RecommendFollowInfoTitle(String paramString)
  {
    this.title = paramString;
    this.isAllFollowed = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "RecommendFollowInfoTitle{title='" + this.title + '\'' + ", isAllFollowed=" + this.isAllFollowed + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.title);
    if (this.isAllFollowed) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfoTitle
 * JD-Core Version:    0.7.0.1
 */