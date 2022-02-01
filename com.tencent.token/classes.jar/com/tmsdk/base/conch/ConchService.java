package com.tmsdk.base.conch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import btmsdkobf.aa;
import btmsdkobf.cp;
import btmsdkobf.z;
import com.tmsdk.base.utils.ConvertUtil;
import java.util.ArrayList;
import java.util.List;

public abstract interface ConchService
{
  public abstract void pullConch(int paramInt);
  
  public abstract void registerConchPush(int paramInt, IConchPushListener paramIConchPushListener);
  
  public abstract void registerConchPush(List<Integer> paramList, IConchPushListener paramIConchPushListener);
  
  public abstract void registerSharkPush();
  
  public abstract void reportConchResult(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void reportConchResult(ConchPushInfo paramConchPushInfo, int paramInt1, int paramInt2);
  
  public abstract void unRegisterConchPush(int paramInt);
  
  public abstract void unRegisterConchPush(List<Integer> paramList);
  
  public abstract void unRegisterSharkPush();
  
  public static class ConchPushInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<ConchPushInfo> CREATOR = new Parcelable.Creator()
    {
      public ConchService.ConchPushInfo a(Parcel paramAnonymousParcel)
      {
        return ConchService.ConchPushInfo.b(paramAnonymousParcel);
      }
      
      public ConchService.ConchPushInfo[] b(int paramAnonymousInt)
      {
        return new ConchService.ConchPushInfo[paramAnonymousInt];
      }
    };
    public z mConch;
    public ConchService.RevokeTaskInfo mRevokeInfo;
    public long mTaskId;
    public long mTaskSeqno;
    
    public ConchPushInfo(long paramLong1, long paramLong2, z paramz)
    {
      this.mTaskId = paramLong1;
      this.mTaskSeqno = paramLong2;
      this.mConch = paramz;
    }
    
    private static z a(byte[] paramArrayOfByte)
    {
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
        return (z)cp.a(paramArrayOfByte, new z(), false);
      }
      return null;
    }
    
    private static ConchPushInfo a(Parcel paramParcel)
    {
      long l1 = paramParcel.readLong();
      long l2 = paramParcel.readLong();
      int i = paramParcel.readInt();
      if (i > 0)
      {
        localObject = new byte[i];
        paramParcel.readByteArray((byte[])localObject);
      }
      else
      {
        localObject = null;
      }
      Object localObject = new ConchPushInfo(l1, l2, a((byte[])localObject));
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
  
  public static class ConchPushResp
    implements Parcelable
  {
    public static final Parcelable.Creator<ConchPushResp> CREATOR = new Parcelable.Creator()
    {
      public ConchService.ConchPushResp c(Parcel paramAnonymousParcel)
      {
        return ConchService.ConchPushResp.d(paramAnonymousParcel);
      }
      
      public ConchService.ConchPushResp[] c(int paramAnonymousInt)
      {
        return new ConchService.ConchPushResp[paramAnonymousInt];
      }
    };
    public List<aa> mConchPushResults;
    
    private static byte[] a(aa paramaa)
    {
      if (paramaa == null) {
        return new byte[0];
      }
      return cp.b(paramaa);
    }
    
    private static aa b(byte[] paramArrayOfByte)
    {
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
        return (aa)cp.a(paramArrayOfByte, new aa(), false);
      }
      return null;
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
      Object localObject = this.mConchPushResults;
      paramInt = 0;
      if (localObject == null)
      {
        paramParcel.writeInt(0);
        return;
      }
      int i = ((List)localObject).size();
      paramParcel.writeInt(i);
      while (paramInt < i)
      {
        localObject = a((aa)this.mConchPushResults.get(paramInt));
        paramParcel.writeInt(localObject.length);
        paramParcel.writeByteArray((byte[])localObject);
        paramInt += 1;
      }
    }
  }
  
  public static abstract class IConchPushListener
  {
    public int mErrorCode = 0;
    
    public abstract void onRecvPush(ConchService.ConchPushInfo paramConchPushInfo);
  }
  
  public static class RevokeTaskInfo
  {
    public int mRevokeCmdId;
    public int mRevokeConchSeqno;
    
    public RevokeTaskInfo(int paramInt1, int paramInt2)
    {
      this.mRevokeCmdId = paramInt1;
      this.mRevokeConchSeqno = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.conch.ConchService
 * JD-Core Version:    0.7.0.1
 */