package cooperation.wadl.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import asbt;
import awod;
import org.json.JSONObject;

public class WadlParams
  implements Parcelable
{
  public static final Parcelable.Creator<WadlParams> CREATOR = new awod();
  public long aBo;
  public long aBp;
  public long aBq;
  public String apkChannel = "";
  public String apkUrl = "";
  public String appId = "";
  public String appName = "";
  public String bLD;
  public String bLE = "";
  public String bLF = "";
  public int cII = -1;
  public String cRO;
  public String cRP;
  public int channelNum;
  public boolean dqZ;
  public boolean dra;
  public boolean drb;
  public int eCg = 39;
  public int eCh;
  public int ekZ;
  public String extraData = "";
  public int flags;
  public int from;
  public String iconUrl = "";
  public String packageName = "";
  public String resMD5;
  public String resName;
  public int resType;
  public String sourceId = "";
  public int versionCode;
  public String via = "";
  
  public WadlParams() {}
  
  public WadlParams(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      parseFromJson(paramString);
    }
  }
  
  public WadlParams(String paramString1, String paramString2)
  {
    this.appId = paramString1;
    this.packageName = paramString2;
    this.flags = this.eCg;
  }
  
  public static String aL(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    default: 
      return "";
    case 2: 
      return "doDownloadAction";
    case 3: 
      return "doPauseAction";
    case 10: 
      return "doCancelAction";
    case 4: 
      return "doResumeAction";
    case 5: 
      return "doInstallAction";
    }
    return "doUpdateAction";
  }
  
  public static String e(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramInt1 == 1) {
      return paramString1 + "_" + paramInt1 + "_" + paramInt2;
    }
    return paramString1 + "_" + paramInt1 + "_" + paramInt2 + "_" + paramString2;
  }
  
  private void parseFromJson(String paramString)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.ekZ = paramString.optInt("actionCode");
        this.appId = paramString.optString("appId");
        this.bLD = paramString.optString("apkSign");
        this.versionCode = paramString.optInt("versionCode");
        this.packageName = paramString.optString("packageName");
        this.appName = paramString.optString("appName");
        this.iconUrl = paramString.optString("iconUrl");
        if (paramString.optInt("delayDownload") > 0)
        {
          this.dra = bool;
          this.bLE = paramString.optString("fromWebUrl");
          this.apkChannel = paramString.optString("apkChannel", "10000144");
          this.via = paramString.optString("via");
          this.aBo = paramString.optLong("downloadStartTime");
          this.aBp = paramString.optLong("downloadEndTime");
          this.bLF = paramString.optString("adtag");
          this.from = paramString.optInt("from", 0);
          this.flags = paramString.optInt("flags", this.eCg);
          if (nO(64))
          {
            acT(64);
            setFlags(1);
          }
          if (nO(128)) {
            acT(128);
          }
          this.extraData = paramString.optString("extraData");
          this.appId = paramString.optString("appid", this.appId);
          this.bLE = paramString.optString("wadlSource", this.bLE);
          this.bLD = paramString.optString("myAppId", this.bLD);
          if ((paramString.has("isAutoInstall")) && (paramString.optInt("isAutoInstall") == 0)) {
            acT(1);
          }
          if ((paramString.has("showPageNotification")) && (paramString.optInt("showPageNotification") == 0)) {
            acT(2);
          }
          if ((paramString.has("showSystemNotification")) && (paramString.optInt("showSystemNotification") == 0)) {
            acT(4);
          }
          if ((paramString.has("requireWifi")) && (paramString.optBoolean("requireWifi", false))) {
            setFlags(8);
          }
          if ((paramString.has("showNetworkDiaLog")) && (paramString.optInt("showNetworkDiaLog") > 0)) {
            setFlags(16);
          }
          this.sourceId = paramString.optString("sourceId");
          this.dqZ = paramString.optBoolean("isRes");
          this.cII = paramString.optInt("resIndex");
          this.cRP = paramString.optString("resVersionCode");
          this.resName = paramString.optString("resName");
          this.resMD5 = paramString.optString("resMD5");
          if (this.dqZ)
          {
            this.apkUrl = paramString.optString("resUrl");
            this.cRO = paramString.optString("resDir");
            this.aBq = paramString.optLong("pkgSize");
            return;
          }
          this.apkUrl = paramString.optString("url");
          continue;
        }
        bool = false;
      }
      catch (Exception paramString)
      {
        asbt.e("WadlParams", "parse json exception:" + paramString.getMessage());
        return;
      }
    }
  }
  
  public String Hj()
  {
    if (this.dqZ) {
      return e(this.appId, this.resType, this.versionCode, this.resName);
    }
    return this.appId;
  }
  
  public void acT(int paramInt)
  {
    this.flags &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void g(WadlParams paramWadlParams)
  {
    this.from = paramWadlParams.from;
    this.flags = paramWadlParams.flags;
    this.aBo = paramWadlParams.aBo;
    this.aBp = paramWadlParams.aBp;
    this.bLE = paramWadlParams.bLE;
    this.extraData = paramWadlParams.extraData;
    this.sourceId = paramWadlParams.sourceId;
    this.eCh = paramWadlParams.eCh;
    this.channelNum = paramWadlParams.channelNum;
    this.resMD5 = paramWadlParams.resMD5;
  }
  
  public boolean nO(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    if (paramParcel != null)
    {
      this.ekZ = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.apkUrl = paramParcel.readString();
      this.bLD = paramParcel.readString();
      this.versionCode = paramParcel.readInt();
      this.packageName = paramParcel.readString();
      this.appName = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      if (paramParcel.readInt() <= 0) {
        break label259;
      }
      bool1 = true;
      this.dra = bool1;
      this.bLE = paramParcel.readString();
      this.apkChannel = paramParcel.readString();
      this.via = paramParcel.readString();
      this.aBo = paramParcel.readLong();
      this.aBp = paramParcel.readLong();
      this.bLF = paramParcel.readString();
      this.from = paramParcel.readInt();
      this.flags = paramParcel.readInt();
      this.extraData = paramParcel.readString();
      this.sourceId = paramParcel.readString();
      if (paramParcel.readInt() <= 0) {
        break label264;
      }
    }
    label259:
    label264:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.dqZ = bool1;
      this.cII = paramParcel.readInt();
      this.cRP = paramParcel.readString();
      this.resName = paramParcel.readString();
      this.resMD5 = paramParcel.readString();
      this.apkUrl = paramParcel.readString();
      this.resType = paramParcel.readInt();
      this.cRO = paramParcel.readString();
      this.aBq = paramParcel.readLong();
      this.eCh = paramParcel.readInt();
      this.channelNum = paramParcel.readInt();
      return;
      bool1 = false;
      break;
    }
  }
  
  public void setFlags(int paramInt)
  {
    this.flags |= paramInt;
  }
  
  public String toString()
  {
    return "WadlParams{actionCode='" + aL(this.ekZ) + '\'' + ", appId='" + this.appId + '\'' + ", isRes='" + this.dqZ + '\'' + ", resType=" + this.resType + ", versionCode=" + this.versionCode + ", apkUrl='" + this.apkUrl + '\'' + ", packageName='" + this.packageName + '\'' + ", appName='" + this.appName + '\'' + ", delayDownload=" + this.dra + ", extraData='" + this.extraData + '\'' + ", apkChannel='" + this.apkChannel + '\'' + ", via='" + this.via + '\'' + ", flags=" + this.flags + ", from=" + this.from + ", yyStartTime=" + this.aBo + ", yyEndTime=" + this.aBp + ", adtag='" + this.bLF + '\'' + ", resName='" + this.resName + '\'' + ", resIndex='" + this.cII + '\'' + ", resMD5='" + this.resMD5 + '\'' + ", resDir='" + this.cRO + '\'' + ", pkgSize=" + this.aBq + ", ignoreSpace=" + this.eCh + ", channelNum=" + this.channelNum + ", isCancelRequest=" + this.drb + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    if (paramParcel != null)
    {
      paramParcel.writeInt(this.ekZ);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.apkUrl);
      paramParcel.writeString(this.bLD);
      paramParcel.writeInt(this.versionCode);
      paramParcel.writeString(this.packageName);
      paramParcel.writeString(this.appName);
      paramParcel.writeString(this.iconUrl);
      if (!this.dra) {
        break label259;
      }
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.bLE);
      paramParcel.writeString(this.apkChannel);
      paramParcel.writeString(this.via);
      paramParcel.writeLong(this.aBo);
      paramParcel.writeLong(this.aBp);
      paramParcel.writeString(this.bLF);
      paramParcel.writeInt(this.from);
      paramParcel.writeInt(this.flags);
      paramParcel.writeString(this.extraData);
      paramParcel.writeString(this.sourceId);
      if (!this.dqZ) {
        break label264;
      }
    }
    label259:
    label264:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.cII);
      paramParcel.writeString(this.cRP);
      paramParcel.writeString(this.resName);
      paramParcel.writeString(this.resMD5);
      paramParcel.writeString(this.apkUrl);
      paramParcel.writeInt(this.resType);
      paramParcel.writeString(this.cRO);
      paramParcel.writeLong(this.aBq);
      paramParcel.writeInt(this.eCh);
      paramParcel.writeInt(this.channelNum);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlParams
 * JD-Core Version:    0.7.0.1
 */