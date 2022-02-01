package com.tencent.mobileqq.service.lbs;

import anat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import aqoj;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import java.util.ArrayList;

public class BusinessBuff
  implements Parcelable
{
  public static final Parcelable.Creator<BusinessBuff> CREATOR = new anat();
  private int busiType;
  private byte[] fq;
  
  public BusinessBuff(int paramInt, byte[] paramArrayOfByte)
  {
    this.busiType = paramInt;
    this.fq = paramArrayOfByte;
  }
  
  public BusinessBuff(Parcel paramParcel)
  {
    this.busiType = paramParcel.readInt();
    paramParcel.readByteArray(this.fq);
  }
  
  public static SparseArray<a> a(ArrayList<byte[]> paramArrayList)
  {
    SparseArray localSparseArray = new SparseArray();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Object localObject1 = null;
      new ArrayList();
      int i = 0;
      if (i < paramArrayList.size())
      {
        Object localObject4 = (byte[])paramArrayList.get(i);
        int j;
        label58:
        Object localObject2;
        if (localObject4 == null)
        {
          j = 0;
          if (j > 10) {
            break label86;
          }
          localObject2 = localObject1;
        }
        for (;;)
        {
          i += 1;
          localObject1 = localObject2;
          break;
          j = localObject4.length;
          break label58;
          label86:
          int k = (int)aqoj.getLongData((byte[])localObject4, 1);
          int m = (int)aqoj.getLongData((byte[])localObject4, 5);
          localObject2 = localObject1;
          if (k > 0)
          {
            localObject2 = localObject1;
            if (k + 9 < j)
            {
              localObject2 = new byte[k];
              aqoj.copyData((byte[])localObject2, 0, (byte[])localObject4, 9, k);
              if (m > 0)
              {
                localObject1 = new byte[m];
                aqoj.copyData((byte[])localObject1, 0, (byte[])localObject4, k + 9, m);
              }
              localObject4 = new SummaryCardBusiEntry.comm();
              try
              {
                ((SummaryCardBusiEntry.comm)localObject4).mergeFrom((byte[])localObject2);
                if (((SummaryCardBusiEntry.comm)localObject4).result.get() == 0) {
                  localSparseArray.put(((SummaryCardBusiEntry.comm)localObject4).service.get(), new a((SummaryCardBusiEntry.comm)localObject4, (byte[])localObject1));
                }
                localObject2 = localObject1;
              }
              catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
              {
                localInvalidProtocolBufferMicroException.printStackTrace();
                Object localObject3 = localObject1;
              }
            }
          }
        }
      }
    }
    return localSparseArray;
  }
  
  public int DX()
  {
    return this.busiType;
  }
  
  public byte[] al()
  {
    return this.fq;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.busiType);
    paramParcel.writeByteArray(this.fq);
  }
  
  public static class a
  {
    public SummaryCardBusiEntry.comm a;
    public byte[] busiBuff;
    
    public a(SummaryCardBusiEntry.comm paramcomm, byte[] paramArrayOfByte)
    {
      this.a = paramcomm;
      this.busiBuff = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.service.lbs.BusinessBuff
 * JD-Core Version:    0.7.0.1
 */