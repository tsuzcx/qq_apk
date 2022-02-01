package com.tencent.mobileqq.app;

import aclq;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ShieldOperationItem
  implements Parcelable
{
  public static final Parcelable.Creator<ShieldOperationItem> CREATOR = new aclq();
  public long[] f;
  public int fromType;
  public int opType;
  public int source_id;
  public int source_sub_id;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("--->>DUMP_ShieldOperationItem<<---").append(",").append("opType:").append(this.opType).append(",source_id:").append(this.source_id).append(",source_sub_id:").append(this.source_sub_id).append(this.fromType).append(",uinList:");
    if (this.f != null) {
      localStringBuilder.append(this.f.toString());
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("null.");
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.opType);
    paramParcel.writeInt(this.source_id);
    paramParcel.writeInt(this.source_sub_id);
    paramParcel.writeLongArray(this.f);
    paramParcel.writeInt(this.fromType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ShieldOperationItem
 * JD-Core Version:    0.7.0.1
 */