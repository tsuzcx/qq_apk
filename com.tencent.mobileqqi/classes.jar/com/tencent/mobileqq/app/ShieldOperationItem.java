package com.tencent.mobileqq.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import fgq;

public class ShieldOperationItem
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new fgq();
  public int a;
  public long[] a;
  public int b;
  public int c = 0;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("--->>DUMP_ShieldOperationItem<<---").append(",").append("opType:").append(this.jdField_a_of_type_Int).append(",source_id:").append(this.b).append(",source_sub_id:").append(this.c).append(",uinList:");
    if (this.jdField_a_of_type_ArrayOfLong != null) {
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfLong.toString());
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("null.");
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeLongArray(this.jdField_a_of_type_ArrayOfLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ShieldOperationItem
 * JD-Core Version:    0.7.0.1
 */