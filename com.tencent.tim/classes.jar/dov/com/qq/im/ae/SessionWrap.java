package dov.com.qq.im.ae;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import awui;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class SessionWrap
  implements Parcelable
{
  public static final Parcelable.Creator<SessionWrap> CREATOR = new awui();
  public String aTl;
  public String aTn;
  public int cZ;
  public String troopUin;
  
  public SessionWrap(Parcel paramParcel)
  {
    this.aTl = paramParcel.readString();
    this.aTn = paramParcel.readString();
    this.cZ = paramParcel.readInt();
    this.troopUin = paramParcel.readString();
  }
  
  public SessionWrap(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.aTl = paramString1;
    this.aTn = paramString2;
    this.cZ = paramInt;
    this.troopUin = paramString3;
  }
  
  public SessionInfo c()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.cZ = this.cZ;
    localSessionInfo.aTn = this.aTn;
    localSessionInfo.aTl = this.aTl;
    localSessionInfo.troopUin = this.troopUin;
    return localSessionInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.aTl);
    paramParcel.writeString(this.aTn);
    paramParcel.writeInt(this.cZ);
    paramParcel.writeString(this.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.SessionWrap
 * JD-Core Version:    0.7.0.1
 */