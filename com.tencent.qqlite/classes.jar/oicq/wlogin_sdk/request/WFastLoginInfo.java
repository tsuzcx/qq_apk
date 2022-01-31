package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class WFastLoginInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<WFastLoginInfo> CREATOR = new e();
  private static final long serialVersionUID = 1L;
  public byte[] _outA1 = new byte[0];
  public String adUrl = "";
  public String iconUrl = "";
  public String profileUrl = "";
  
  public WFastLoginInfo()
  {
    this._outA1 = new byte[0];
  }
  
  private WFastLoginInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public WFastLoginInfo(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this._outA1 = ((byte[])paramArrayOfByte.clone());
      return;
    }
    this._outA1 = new byte[0];
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void get_clone(WFastLoginInfo paramWFastLoginInfo)
  {
    if (paramWFastLoginInfo != null) {
      if (paramWFastLoginInfo._outA1 == null) {
        break label50;
      }
    }
    label50:
    for (this._outA1 = ((byte[])paramWFastLoginInfo._outA1.clone());; this._outA1 = new byte[0])
    {
      this.iconUrl = paramWFastLoginInfo.iconUrl;
      this.adUrl = paramWFastLoginInfo.adUrl;
      this.profileUrl = paramWFastLoginInfo.profileUrl;
      return;
    }
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this._outA1 = paramParcel.createByteArray();
    this.iconUrl = paramParcel.readString();
    this.adUrl = paramParcel.readString();
    this.profileUrl = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this._outA1);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.adUrl);
    paramParcel.writeString(this.profileUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WFastLoginInfo
 * JD-Core Version:    0.7.0.1
 */