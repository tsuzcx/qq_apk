package com.tencent.android.tpush.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class StorageEntity
  implements Parcelable
{
  public static final Parcelable.Creator<StorageEntity> CREATOR = new StorageEntity.1();
  public String a = "";
  public int b = -1;
  public boolean c;
  public String d;
  public int e;
  public float f;
  public long g;
  
  public StorageEntity() {}
  
  public StorageEntity(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  private void a(Parcel paramParcel)
  {
    boolean bool = true;
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.c = bool;
      this.d = paramParcel.readString();
      this.e = paramParcel.readInt();
      this.f = paramParcel.readFloat();
      this.g = paramParcel.readLong();
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StorageEntity[key:").append(this.a).append(",type:").append(this.b).append(",strValue:").append(this.d).append(",boolValue:").append(this.c).append(",intValue").append(this.e).append(",floatValue:").append(this.f).append(",longValue:").append(this.g).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    if (this.c) {}
    for (byte b1 = 1;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeFloat(this.f);
      paramParcel.writeLong(this.g);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.data.StorageEntity
 * JD-Core Version:    0.7.0.1
 */