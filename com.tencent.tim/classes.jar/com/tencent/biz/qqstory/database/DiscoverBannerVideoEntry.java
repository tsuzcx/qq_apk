package com.tencent.biz.qqstory.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pru;

public class DiscoverBannerVideoEntry
  extends Entity
{
  public static final String TAG = "Q.qqstory.discover.DiscoverBannerVideoEntry";
  @unique
  public String bannerId;
  @notColumn
  public List<BannerInfo> bannerInfoList;
  public byte[] bannerInfoListByte;
  public String nextCookie;
  public int totalCount;
  
  /* Error */
  public List<BannerInfo> convertBytesToList(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: new 39	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 40	java/util/ArrayList:<init>	()V
    //   18: astore_2
    //   19: aload 4
    //   21: aload_1
    //   22: iconst_0
    //   23: aload_1
    //   24: arraylength
    //   25: invokevirtual 44	android/os/Parcel:unmarshall	([BII)V
    //   28: aload 4
    //   30: iconst_0
    //   31: invokevirtual 48	android/os/Parcel:setDataPosition	(I)V
    //   34: aload 4
    //   36: aload_2
    //   37: getstatic 52	com/tencent/biz/qqstory/database/DiscoverBannerVideoEntry$BannerInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   40: invokevirtual 56	android/os/Parcel:readTypedList	(Ljava/util/List;Landroid/os/Parcelable$Creator;)V
    //   43: aload 4
    //   45: invokevirtual 59	android/os/Parcel:recycle	()V
    //   48: aload_2
    //   49: areturn
    //   50: astore_2
    //   51: aconst_null
    //   52: astore_1
    //   53: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +31 -> 87
    //   59: ldc 11
    //   61: iconst_2
    //   62: new 67	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   69: ldc 70
    //   71: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_2
    //   75: invokevirtual 78	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   78: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload 4
    //   89: invokevirtual 59	android/os/Parcel:recycle	()V
    //   92: aload_1
    //   93: areturn
    //   94: astore_1
    //   95: aload 4
    //   97: invokevirtual 59	android/os/Parcel:recycle	()V
    //   100: aload_1
    //   101: athrow
    //   102: astore_3
    //   103: aload_2
    //   104: astore_1
    //   105: aload_3
    //   106: astore_2
    //   107: goto -54 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	DiscoverBannerVideoEntry
    //   0	110	1	paramArrayOfByte	byte[]
    //   18	31	2	localArrayList	java.util.ArrayList
    //   50	54	2	localException1	Exception
    //   106	1	2	localObject	Object
    //   102	4	3	localException2	Exception
    //   9	87	4	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   11	19	50	java/lang/Exception
    //   11	19	94	finally
    //   19	43	94	finally
    //   53	87	94	finally
    //   19	43	102	java/lang/Exception
  }
  
  public byte[] convertListToBytes()
  {
    if (this.bannerInfoList == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeTypedList(this.bannerInfoList);
      byte[] arrayOfByte = localParcel.marshall();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.discover.DiscoverBannerVideoEntry", 2, "DiscoverBannerVideoEntry::convertListToBytes exception:" + localException.getMessage());
      }
      return null;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (getClass() != paramObject.getClass());
    paramObject = (DiscoverBannerVideoEntry)paramObject;
    return TextUtils.equals(this.bannerId, paramObject.bannerId);
  }
  
  public void postRead()
  {
    this.bannerInfoList = convertBytesToList(this.bannerInfoListByte);
  }
  
  public void prewrite()
  {
    this.bannerInfoListByte = convertListToBytes();
  }
  
  public static class BannerInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<BannerInfo> CREATOR = new pru();
    public String feedId;
    public String vid;
    
    public BannerInfo() {}
    
    public BannerInfo(Parcel paramParcel)
    {
      this.vid = paramParcel.readString();
      this.feedId = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.vid);
      paramParcel.writeString(this.feedId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry
 * JD-Core Version:    0.7.0.1
 */