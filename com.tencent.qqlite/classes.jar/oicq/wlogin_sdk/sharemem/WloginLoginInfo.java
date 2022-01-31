package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class WloginLoginInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<WloginLoginInfo> CREATOR = new a();
  public static int TYPE_LOACL = 1;
  public static int TYPE_REMOTE = 2;
  private static final long serialVersionUID = 5551948389726789420L;
  public String mAccount;
  public long mAppid;
  public long mCreateTime;
  public String mFaceUrl = "";
  public int mLoginBitmap;
  public int mType;
  public long mUin;
  
  private WloginLoginInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public WloginLoginInfo(String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3, int paramInt1, int paramInt2)
  {
    this.mAccount = paramString1;
    this.mUin = paramLong1;
    this.mAppid = paramLong2;
    this.mFaceUrl = paramString2;
    this.mCreateTime = paramLong3;
    this.mType = paramInt1;
    this.mLoginBitmap = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.mAccount = paramParcel.readString();
    this.mUin = paramParcel.readLong();
    this.mAppid = paramParcel.readLong();
    this.mCreateTime = paramParcel.readLong();
    this.mType = paramParcel.readInt();
    this.mLoginBitmap = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mAccount);
    paramParcel.writeLong(this.mUin);
    paramParcel.writeLong(this.mAppid);
    paramParcel.writeLong(this.mCreateTime);
    paramParcel.writeInt(this.mType);
    paramParcel.writeInt(this.mLoginBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.sharemem.WloginLoginInfo
 * JD-Core Version:    0.7.0.1
 */