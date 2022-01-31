package oicq.wlogin_sdk.devicelock;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DevlockInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<DevlockInfo> CREATOR = new c();
  public int AllowSet;
  public int AvailableMsgCount;
  public String BakCountryCode;
  public String BakMobile;
  public int BakMobileState;
  public String CountryCode;
  public int DevSetup;
  public String MbGuideInfo;
  public int MbGuideInfoType;
  public String MbGuideMsg;
  public int MbGuideType;
  public int MbItemSmsCodeStatus;
  public String Mobile;
  public String ProtectIntro;
  public int TimeLimit;
  public byte[] TransferInfo;
  public String UnionVerifyUrl;
  public String VerifyReason;
  public String WarningInfo;
  public int WarningInfoType;
  public String WarningMsg;
  public String WarningTitle;
  
  public DevlockInfo() {}
  
  private DevlockInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.DevSetup = paramParcel.readInt();
    this.AllowSet = paramParcel.readInt();
    this.ProtectIntro = paramParcel.readString();
    this.WarningTitle = paramParcel.readString();
    this.WarningMsg = paramParcel.readString();
    this.WarningInfo = paramParcel.readString();
    this.WarningInfoType = paramParcel.readInt();
    this.CountryCode = paramParcel.readString();
    this.Mobile = paramParcel.readString();
    this.MbItemSmsCodeStatus = paramParcel.readInt();
    this.AvailableMsgCount = paramParcel.readInt();
    this.TimeLimit = paramParcel.readInt();
    this.MbGuideMsg = paramParcel.readString();
    this.MbGuideInfo = paramParcel.readString();
    this.MbGuideType = paramParcel.readInt();
    this.MbGuideInfoType = paramParcel.readInt();
    this.UnionVerifyUrl = paramParcel.readString();
    this.VerifyReason = paramParcel.readString();
    this.BakMobileState = paramParcel.readInt();
    this.BakCountryCode = paramParcel.readString();
    this.BakMobile = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.TransferInfo = new byte[i];
      paramParcel.readByteArray(this.TransferInfo);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.DevSetup);
    paramParcel.writeInt(this.AllowSet);
    paramParcel.writeString(this.ProtectIntro);
    paramParcel.writeString(this.WarningTitle);
    paramParcel.writeString(this.WarningMsg);
    paramParcel.writeString(this.WarningInfo);
    paramParcel.writeInt(this.WarningInfoType);
    paramParcel.writeString(this.CountryCode);
    paramParcel.writeString(this.Mobile);
    paramParcel.writeInt(this.MbItemSmsCodeStatus);
    paramParcel.writeInt(this.AvailableMsgCount);
    paramParcel.writeInt(this.TimeLimit);
    paramParcel.writeString(this.MbGuideMsg);
    paramParcel.writeString(this.MbGuideInfo);
    paramParcel.writeInt(this.MbGuideType);
    paramParcel.writeInt(this.MbGuideInfoType);
    paramParcel.writeString(this.UnionVerifyUrl);
    paramParcel.writeString(this.VerifyReason);
    paramParcel.writeInt(this.BakMobileState);
    paramParcel.writeString(this.BakCountryCode);
    paramParcel.writeString(this.BakMobile);
    if ((this.TransferInfo != null) && (this.TransferInfo.length > 0))
    {
      paramParcel.writeInt(this.TransferInfo.length);
      paramParcel.writeByteArray(this.TransferInfo);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.DevlockInfo
 * JD-Core Version:    0.7.0.1
 */