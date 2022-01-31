package com.tencent.wcdb;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class BulkCursorDescriptor$1
  implements Parcelable.Creator
{
  public BulkCursorDescriptor createFromParcel(Parcel paramParcel)
  {
    BulkCursorDescriptor localBulkCursorDescriptor = new BulkCursorDescriptor();
    localBulkCursorDescriptor.readFromParcel(paramParcel);
    return localBulkCursorDescriptor;
  }
  
  public BulkCursorDescriptor[] newArray(int paramInt)
  {
    return new BulkCursorDescriptor[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.BulkCursorDescriptor.1
 * JD-Core Version:    0.7.0.1
 */