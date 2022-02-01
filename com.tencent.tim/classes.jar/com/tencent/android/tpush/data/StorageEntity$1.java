package com.tencent.android.tpush.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class StorageEntity$1
  implements Parcelable.Creator<StorageEntity>
{
  public StorageEntity a(Parcel paramParcel)
  {
    return new StorageEntity(paramParcel);
  }
  
  public StorageEntity[] a(int paramInt)
  {
    return new StorageEntity[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.data.StorageEntity.1
 * JD-Core Version:    0.7.0.1
 */