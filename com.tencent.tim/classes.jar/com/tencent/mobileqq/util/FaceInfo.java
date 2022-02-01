package com.tencent.mobileqq.util;

import AvatarInfo.QQHeadInfo;
import ajrk;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import aqdl;
import com.tencent.qphone.base.util.QLog;

public class FaceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FaceInfo> CREATOR = new aqdl();
  public static int RESULT_FAIL = 1;
  public static int dYA = 3;
  public static int dYB;
  public static int dYC = dYB + 1;
  public static int dYD = dYC + 1;
  public static int dYE = dYD + 1;
  public static int dYF = dYE + 1;
  public static int dYG = dYF + 1;
  public static int dYH = dYG + 1;
  public static int dYI = dYH + 1;
  public static int dYJ = dYI + 1;
  public static int dYK = dYJ + 1;
  public static int dYy;
  public static int dYz = 2;
  public long[] aK;
  public int aRY;
  public QQHeadInfo b;
  public byte bA;
  public boolean cTH;
  public boolean cTI;
  public boolean cTJ;
  public String csn;
  public String cso;
  private String csp;
  public int dYx;
  public byte headLevel;
  public int idType;
  public String localPath;
  public int shape;
  public int sizeType;
  public long timeStamp;
  public String uin;
  
  public FaceInfo()
  {
    if (this.aK == null) {
      this.aK = new long[dYK];
    }
    int i = 0;
    while (i < dYK)
    {
      this.aK[i] = 0L;
      i += 1;
    }
  }
  
  public FaceInfo(int paramInt1, String paramString, boolean paramBoolean1, byte paramByte, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    a(paramInt1, paramString, paramBoolean1, paramByte, paramInt2, paramBoolean2, paramInt3, 0, false, 100);
  }
  
  public FaceInfo(int paramInt1, String paramString, boolean paramBoolean1, byte paramByte, int paramInt2, boolean paramBoolean2, int paramInt3, boolean paramBoolean3, int paramInt4)
  {
    a(paramInt1, paramString, paramBoolean1, paramByte, paramInt2, paramBoolean2, paramInt3, 0, paramBoolean3, paramInt4);
  }
  
  public static String a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder(16);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localStringBuilder.append(paramString);
      if (paramInt3 > 0) {
        localStringBuilder.append("_").append(paramInt3);
      }
      return localStringBuilder.toString();
      localStringBuilder.append("dis_g_");
      continue;
      localStringBuilder.append("troop_");
      continue;
      localStringBuilder.append("sub_");
      continue;
      localStringBuilder.append("stranger_").append(Integer.toString(paramInt2)).append("_");
      continue;
      localStringBuilder.append("qcall_").append(Integer.toString(paramInt2)).append("_");
    }
  }
  
  public static String a(QQHeadInfo paramQQHeadInfo, int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (paramQQHeadInfo != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramQQHeadInfo.downLoadUrl)) {
        str1 = paramQQHeadInfo.downLoadUrl + "_" + paramInt;
      }
    }
    return str1;
  }
  
  public static String e(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    if (paramInt1 == 32) {
      localStringBuilder.append(paramInt1).append("_").append(paramInt2).append("_").append(paramString);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramInt1 == 16) {
        localStringBuilder.append(paramInt1).append("_").append(paramInt2).append("_").append(paramString);
      } else {
        localStringBuilder.append(paramInt1).append("_").append(paramString);
      }
    }
  }
  
  private String getProcessName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return "TIME_BEGINE";
    case 1: 
      return "TIME_REQ_READY";
    case 2: 
      return "TIME_BEGIN_DOWNLOADINFO";
    case 3: 
      return "TIME_END_DOWNLOADINFO";
    case 4: 
      return "TIME_BEGIN_DOWNLOAD";
    case 5: 
      return "TIME_END_DOWNLOAD";
    case 6: 
      return "TIME_BEGIN_DECODE";
    case 7: 
      return "TIME_END_DECODE";
    }
    return "TIME_REQ_END";
  }
  
  public String BL()
  {
    if (TextUtils.isEmpty(this.cso)) {
      this.cso = a(this.aRY, this.uin, this.idType, this.shape);
    }
    return this.cso;
  }
  
  public String BM()
  {
    if (TextUtils.isEmpty(this.csn)) {
      this.csn = e(this.aRY, this.uin, this.idType);
    }
    return this.csn;
  }
  
  public String BN()
  {
    if (TextUtils.isEmpty(this.csp)) {
      this.csp = a(this.b, this.idType);
    }
    return this.csp;
  }
  
  public void Xq(int paramInt)
  {
    kg(paramInt, 0);
  }
  
  public void a(int paramInt1, String paramString, boolean paramBoolean1, byte paramByte, int paramInt2, boolean paramBoolean2, int paramInt3, int paramInt4, boolean paramBoolean3, int paramInt5)
  {
    this.cTH = paramBoolean3;
    this.aRY = paramInt1;
    this.uin = paramString;
    this.cTI = paramBoolean1;
    this.headLevel = paramByte;
    this.shape = paramInt2;
    this.cTJ = paramBoolean2;
    this.idType = paramInt3;
    this.cso = null;
    this.csn = null;
    this.localPath = null;
    this.timeStamp = 0L;
    this.dYx = paramInt4;
    this.sizeType = paramInt5;
    if (this.aK == null) {
      this.aK = new long[dYK];
    }
    paramInt1 = 0;
    while (paramInt1 < dYK)
    {
      this.aK[paramInt1] = 0L;
      paramInt1 += 1;
    }
  }
  
  public byte d()
  {
    switch (this.headLevel)
    {
    default: 
      return 1;
    }
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (FaceInfo)paramObject;
    return (this.aRY == paramObject.aRY) && (TextUtils.equals(this.uin, paramObject.uin)) && (this.idType == paramObject.idType) && (this.shape == paramObject.shape);
  }
  
  public int hashCode()
  {
    int j = this.aRY;
    if (TextUtils.isEmpty(this.uin)) {}
    for (int i = 0;; i = this.uin.hashCode()) {
      return i | j;
    }
  }
  
  public void kg(int paramInt1, int paramInt2)
  {
    int i = 0;
    long l2 = 0L;
    if (this.aK == null) {}
    do
    {
      do
      {
        return;
      } while ((paramInt1 < 0) || (paramInt1 >= dYK));
      this.aK[paramInt1] = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        ajrk.f(FaceInfo.class.getSimpleName(), "markTime", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(this.aK[paramInt1]), this });
      }
    } while ((paramInt1 != dYJ) || (!QLog.isColorLevel()));
    StringBuilder localStringBuilder = new StringBuilder(260);
    localStringBuilder.append("id=").append(this.uin).append(",").append("idType=").append(this.idType).append(",").append("headType=").append(this.aRY).append(",").append("shape=").append(this.shape).append(" ,Times={");
    long l1 = 0L;
    paramInt1 = i;
    if (paramInt1 < this.aK.length)
    {
      localStringBuilder.append("[").append(getProcessName(paramInt1)).append(",");
      localStringBuilder.append(this.aK[paramInt1]).append(",");
      if (this.aK[paramInt1] > 0L) {
        localStringBuilder.append(Math.abs(l1 - this.aK[paramInt1])).append("]");
      }
      for (;;)
      {
        if (this.aK[paramInt1] > 0L) {
          l1 = this.aK[paramInt1];
        }
        paramInt1 += 1;
        break;
        localStringBuilder.append("0").append("]");
      }
    }
    l1 = l2;
    if (this.aK[dYJ] > 0L)
    {
      l1 = l2;
      if (this.aK[dYB] > 0L) {
        l1 = Math.abs(this.aK[dYJ] - this.aK[dYB]);
      }
    }
    localStringBuilder.append("}, cost = ").append(l1).append(", result = ").append(paramInt2);
    QLog.i("FaceCost", 2, localStringBuilder.toString());
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    boolean bool = true;
    this.aRY = paramParcel.readInt();
    this.uin = paramParcel.readString();
    this.idType = paramParcel.readInt();
    this.shape = paramParcel.readInt();
    this.sizeType = paramParcel.readInt();
    this.headLevel = paramParcel.readByte();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.cTJ = bool;
      this.localPath = paramParcel.readString();
      this.timeStamp = paramParcel.readLong();
      this.b = ((QQHeadInfo)paramParcel.readParcelable(getClass().getClassLoader()));
      return;
      bool = false;
    }
  }
  
  public boolean s(int paramInt, long paramLong)
  {
    boolean bool = true;
    if (this.aK == null) {}
    do
    {
      do
      {
        return false;
      } while ((paramInt < 0) || (paramInt >= dYK));
      if (this.aK[paramInt] != 0L) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    ajrk.f(FaceInfo.class.getSimpleName(), "isTimeOut", new Object[] { Integer.valueOf(paramInt) });
    return false;
    if (Math.abs(System.currentTimeMillis() - this.aK[paramInt]) >= paramLong) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[").append(this.aRY).append(",").append(this.idType).append(",").append(this.uin).append(",").append(this.shape).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aRY);
    paramParcel.writeString(this.uin);
    paramParcel.writeInt(this.idType);
    paramParcel.writeInt(this.shape);
    paramParcel.writeInt(this.sizeType);
    paramParcel.writeByte(this.headLevel);
    if (this.cTJ) {}
    for (byte b1 = 1;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.localPath);
      paramParcel.writeLong(this.timeStamp);
      paramParcel.writeParcelable(this.b, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceInfo
 * JD-Core Version:    0.7.0.1
 */