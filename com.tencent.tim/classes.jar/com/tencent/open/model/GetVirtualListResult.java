package com.tencent.open.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import asba;
import java.util.ArrayList;

public class GetVirtualListResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetVirtualListResult> CREATOR = new asba();
  public long awU;
  public int errorCode;
  public ArrayList<VirtualInfo> list;
  
  public GetVirtualListResult() {}
  
  public GetVirtualListResult(Parcel paramParcel)
  {
    this.errorCode = paramParcel.readInt();
    this.awU = paramParcel.readLong();
    this.list = paramParcel.createTypedArrayList(VirtualInfo.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("GetVirtualListResult={");
    localStringBuilder1.append("errorCode=").append(this.errorCode).append(",");
    localStringBuilder1.append("curVirtualId=").append(this.awU).append(",");
    StringBuilder localStringBuilder2 = localStringBuilder1.append("list=");
    if (this.list != null) {}
    for (String str = this.list.toString();; str = "null")
    {
      localStringBuilder2.append(str).append("}");
      return localStringBuilder1.toString();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.errorCode);
    paramParcel.writeLong(this.awU);
    paramParcel.writeTypedList(this.list);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.model.GetVirtualListResult
 * JD-Core Version:    0.7.0.1
 */