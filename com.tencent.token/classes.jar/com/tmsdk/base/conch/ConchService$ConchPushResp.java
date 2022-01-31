package com.tmsdk.base.conch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import btmsdkobf.aa;
import btmsdkobf.cp;
import java.util.ArrayList;
import java.util.List;

public class ConchService$ConchPushResp
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ConchService.ConchPushResp.1();
  public List mConchPushResults;
  
  private static byte[] a(aa paramaa)
  {
    if (paramaa == null) {
      return new byte[0];
    }
    return cp.b(paramaa);
  }
  
  private static aa b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    return (aa)cp.a(paramArrayOfByte, new aa(), false);
  }
  
  private static ConchPushResp c(Parcel paramParcel)
  {
    ConchPushResp localConchPushResp = new ConchPushResp();
    int j = paramParcel.readInt();
    if (j > 0)
    {
      localConchPushResp.mConchPushResults = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        byte[] arrayOfByte = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(arrayOfByte);
        localConchPushResp.mConchPushResults.add(b(arrayOfByte));
        i += 1;
      }
    }
    return localConchPushResp;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.mConchPushResults == null) {
      paramParcel.writeInt(0);
    }
    for (;;)
    {
      return;
      int i = this.mConchPushResults.size();
      paramParcel.writeInt(i);
      paramInt = 0;
      while (paramInt < i)
      {
        byte[] arrayOfByte = a((aa)this.mConchPushResults.get(paramInt));
        paramParcel.writeInt(arrayOfByte.length);
        paramParcel.writeByteArray(arrayOfByte);
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.conch.ConchService.ConchPushResp
 * JD-Core Version:    0.7.0.1
 */