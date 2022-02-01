package Protocol.MConch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import wf7.df;
import wf7.fe;

public class ConchPushInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ConchPushInfo> CREATOR = new ConchPushInfo.1();
  public long bq;
  public long br;
  public c bs;
  
  public ConchPushInfo(long paramLong1, long paramLong2, c paramc)
  {
    this.bq = paramLong1;
    this.br = paramLong2;
    this.bs = paramc;
  }
  
  private static ConchPushInfo a(Parcel paramParcel)
  {
    long l1 = paramParcel.readLong();
    long l2 = paramParcel.readLong();
    int i = paramParcel.readInt();
    byte[] arrayOfByte = null;
    if (i > 0)
    {
      arrayOfByte = new byte[i];
      paramParcel.readByteArray(arrayOfByte);
    }
    return new ConchPushInfo(l1, l2, a(arrayOfByte));
  }
  
  public static ConchPushInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = fe.F(paramString);
    paramString = Parcel.obtain();
    paramString.unmarshall((byte[])localObject, 0, localObject.length);
    paramString.setDataPosition(0);
    localObject = (ConchPushInfo)CREATOR.createFromParcel(paramString);
    paramString.recycle();
    return localObject;
  }
  
  private static c a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    return (c)df.a(paramArrayOfByte, new c(), false);
  }
  
  public static String a(ConchPushInfo paramConchPushInfo)
  {
    if (paramConchPushInfo == null) {
      return "";
    }
    Parcel localParcel = Parcel.obtain();
    paramConchPushInfo.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramConchPushInfo = fe.k(localParcel.marshall());
    localParcel.recycle();
    return paramConchPushInfo;
  }
  
  private static byte[] a(c paramc)
  {
    if (paramc == null) {
      return new byte[0];
    }
    return df.a(paramc);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.bq);
    paramParcel.writeLong(this.br);
    byte[] arrayOfByte = a(this.bs);
    paramParcel.writeInt(arrayOfByte.length);
    if (arrayOfByte.length > 0) {
      paramParcel.writeByteArray(arrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Protocol.MConch.ConchPushInfo
 * JD-Core Version:    0.7.0.1
 */