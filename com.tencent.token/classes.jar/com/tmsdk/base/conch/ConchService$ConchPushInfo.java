package com.tmsdk.base.conch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import btmsdkobf.cp;
import btmsdkobf.z;
import com.tmsdk.base.utils.ConvertUtil;

public class ConchService$ConchPushInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ConchService.ConchPushInfo.1();
  public z mConch;
  public ConchService.RevokeTaskInfo mRevokeInfo;
  public long mTaskId;
  public long mTaskSeqno;
  
  public ConchService$ConchPushInfo(long paramLong1, long paramLong2, z paramz)
  {
    this.mTaskId = paramLong1;
    this.mTaskSeqno = paramLong2;
    this.mConch = paramz;
  }
  
  private static z a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    return (z)cp.a(paramArrayOfByte, new z(), false);
  }
  
  private static ConchPushInfo a(Parcel paramParcel)
  {
    long l1 = paramParcel.readLong();
    long l2 = paramParcel.readLong();
    int i = paramParcel.readInt();
    Object localObject = null;
    if (i > 0)
    {
      localObject = new byte[i];
      paramParcel.readByteArray((byte[])localObject);
    }
    localObject = new ConchPushInfo(l1, l2, a((byte[])localObject));
    if (paramParcel.readByte() == 1) {
      ((ConchPushInfo)localObject).mRevokeInfo = new ConchService.RevokeTaskInfo(paramParcel.readInt(), paramParcel.readInt());
    }
    return localObject;
  }
  
  private static byte[] a(z paramz)
  {
    if (paramz == null) {
      return new byte[0];
    }
    return cp.b(paramz);
  }
  
  public static String conchPushInfo2String(ConchPushInfo paramConchPushInfo)
  {
    if (paramConchPushInfo == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    paramConchPushInfo.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramConchPushInfo = ConvertUtil.bytesToHexString(localParcel.marshall());
    localParcel.recycle();
    return paramConchPushInfo;
  }
  
  public static ConchPushInfo string2ConchPushInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = ConvertUtil.hexStringToByte(paramString);
    paramString = Parcel.obtain();
    paramString.unmarshall((byte[])localObject, 0, localObject.length);
    paramString.setDataPosition(0);
    localObject = (ConchPushInfo)CREATOR.createFromParcel(paramString);
    paramString.recycle();
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mTaskId);
    paramParcel.writeLong(this.mTaskSeqno);
    byte[] arrayOfByte = a(this.mConch);
    paramParcel.writeInt(arrayOfByte.length);
    if (arrayOfByte.length > 0) {
      paramParcel.writeByteArray(arrayOfByte);
    }
    if (this.mRevokeInfo != null)
    {
      paramParcel.writeByte((byte)1);
      paramParcel.writeInt(this.mRevokeInfo.mRevokeCmdId);
      paramParcel.writeInt(this.mRevokeInfo.mRevokeConchSeqno);
      return;
    }
    paramParcel.writeByte((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.conch.ConchService.ConchPushInfo
 * JD-Core Version:    0.7.0.1
 */