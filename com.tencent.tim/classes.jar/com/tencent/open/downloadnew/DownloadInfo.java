package com.tencent.open.downloadnew;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import aqgz;
import aroi;
import arwt;
import arwu;
import aryw;
import com.tencent.tmassistantbase.util.GlobalUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadInfo> CREATOR = new aryw();
  protected static final String TAG = DownloadInfo.class.getName();
  public String appId;
  public long awM;
  public long awN;
  public String cCL;
  public String cCM = "";
  public String cDF;
  public String cDG;
  public String cDH = "0";
  public String cDI;
  public String cDJ;
  public String channelId = "";
  public boolean ddi;
  public boolean ddw = true;
  public boolean ddx;
  public int downloadType = 0;
  public int ekZ;
  public int elk = 1;
  public int ell;
  public int elm = -1;
  public int errorCode;
  public String extraData;
  public String fileMd5 = "";
  public String filePath = "";
  public long fileSize;
  public int from = 0;
  public String iconUrl = "";
  public boolean isAutoInstall = true;
  public boolean isAutoInstallBySDK;
  public String kx = "0";
  public Intent noticeIntent;
  public String packageName;
  public String pageId = "6000";
  public volatile int progress;
  public String pushTitle;
  public String recommendId = "";
  public String sendTime = "";
  public String source = "";
  public volatile int state = 1;
  public String ticket;
  public long time;
  public String uniqueId;
  public int updateType = 0;
  public String urlStr;
  public int versionCode;
  public String via;
  
  public DownloadInfo() {}
  
  public DownloadInfo(Parcel paramParcel)
  {
    this.ticket = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.urlStr = paramParcel.readString();
    this.packageName = paramParcel.readString();
    this.pushTitle = paramParcel.readString();
    this.sendTime = paramParcel.readString();
    this.via = paramParcel.readString();
    this.time = paramParcel.readLong();
    this.updateType = paramParcel.readInt();
    this.cDF = paramParcel.readString();
    this.cDG = paramParcel.readString();
    this.cCL = paramParcel.readString();
    this.versionCode = paramParcel.readInt();
    this.downloadType = paramParcel.readInt();
    this.elk = paramParcel.readInt();
    this.filePath = paramParcel.readString();
    this.source = paramParcel.readString();
    this.state = paramParcel.readInt();
    this.progress = paramParcel.readInt();
    this.noticeIntent = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    this.ekZ = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.isAutoInstall = bool1;
      if (paramParcel.readByte() == 0) {
        break label516;
      }
      bool1 = true;
      label311:
      this.ddi = bool1;
      this.awM = paramParcel.readLong();
      this.from = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label521;
      }
      bool1 = true;
      label341:
      this.ddw = bool1;
      this.iconUrl = paramParcel.readString();
      this.ell = paramParcel.readInt();
      this.elm = paramParcel.readInt();
      this.awN = paramParcel.readLong();
      this.extraData = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label526;
      }
      bool1 = true;
      label395:
      this.isAutoInstallBySDK = bool1;
      this.fileMd5 = paramParcel.readString();
      this.fileSize = paramParcel.readLong();
      this.recommendId = paramParcel.readString();
      this.cCM = paramParcel.readString();
      this.channelId = paramParcel.readString();
      this.pageId = paramParcel.readString();
      this.kx = paramParcel.readString();
      this.cDH = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label531;
      }
    }
    label516:
    label521:
    label526:
    label531:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ddx = bool1;
      this.errorCode = paramParcel.readInt();
      this.cDI = paramParcel.readString();
      this.uniqueId = paramParcel.readString();
      this.cDJ = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label311;
      bool1 = false;
      break label341;
      bool1 = false;
      break label395;
    }
  }
  
  public DownloadInfo(String paramString1, String paramString2)
  {
    this.appId = paramString1;
    this.packageName = paramString2;
  }
  
  public DownloadInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, String paramString6, String paramString7, int paramInt1, String paramString8, String paramString9, int paramInt2, int paramInt3, String paramString10, String paramString11, long paramLong2, boolean paramBoolean1, int paramInt4, String paramString12, int paramInt5, int paramInt6, String paramString13, boolean paramBoolean2, String paramString14, long paramLong3)
  {
    this.appId = paramString1;
    this.urlStr = paramString2;
    this.packageName = paramString3;
    this.pushTitle = paramString4;
    this.sendTime = paramString5;
    this.time = paramLong1;
    this.via = paramString6;
    this.cDF = paramString7;
    this.updateType = paramInt1;
    this.cDG = paramString8;
    this.cCL = paramString9;
    this.versionCode = paramInt2;
    this.downloadType = paramInt3;
    this.filePath = paramString10;
    this.source = paramString11;
    this.awM = paramLong2;
    this.ddw = paramBoolean1;
    this.from = paramInt4;
    this.iconUrl = paramString12;
    this.ell = paramInt5;
    this.elm = paramInt6;
    this.extraData = paramString13;
    this.isAutoInstallBySDK = paramBoolean2;
    this.fileMd5 = paramString14;
    this.fileSize = paramLong3;
  }
  
  public DownloadInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Intent paramIntent, String paramString6, boolean paramBoolean)
  {
    this.appId = paramString1;
    this.urlStr = paramString2;
    this.packageName = paramString3;
    this.pushTitle = paramString4;
    if (TextUtils.isEmpty(paramString2)) {}
    for (this.sendTime = ("_" + paramString1);; this.sendTime = ("_" + GlobalUtil.calcMD5AsString(paramString2)))
    {
      this.time = System.currentTimeMillis();
      this.state = 1;
      this.via = paramString5;
      this.noticeIntent = paramIntent;
      this.awM = 0L;
      this.source = paramString6;
      this.ddw = paramBoolean;
      return;
    }
  }
  
  public static String aP(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString + "_" + paramInt;
  }
  
  private void emc()
  {
    if ((!TextUtils.isEmpty(this.ticket)) && (TextUtils.isEmpty(this.uniqueId))) {
      this.uniqueId = qJ(this.ticket);
    }
  }
  
  public static String qI(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return arwu.toMD5(paramString);
  }
  
  private static String qJ(String paramString)
  {
    try
    {
      paramString = "" + aroi.a().getUin() + aqgz.getIMEI() + System.currentTimeMillis() + paramString;
      arwt.i(TAG, ">genUniqueId ori=" + paramString);
      paramString = arwu.toMD5(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return "" + System.currentTimeMillis();
  }
  
  public boolean ce(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    JSONObject localJSONObject1;
    if (TextUtils.isEmpty(this.cDJ)) {
      localJSONObject1 = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject1.put(paramString1, paramString2);
        arwt.i(TAG, ">setExtParam " + paramString1 + "=" + paramString2);
        this.cDJ = localJSONObject1.toString();
        return true;
      }
      catch (Exception paramString1)
      {
        JSONObject localJSONObject2;
        arwt.e(TAG, ">setExtParam failed:", paramString1);
      }
      try
      {
        localJSONObject1 = new JSONObject(this.cDJ);
      }
      catch (JSONException localJSONException)
      {
        this.cDJ = "";
        localJSONObject2 = new JSONObject();
      }
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void emb()
  {
    if (TextUtils.isEmpty(this.ticket))
    {
      if (TextUtils.isEmpty(this.urlStr)) {
        break label45;
      }
      this.ticket = qI(this.urlStr);
      arwt.i(TAG, "gen ticket by urlStr");
    }
    for (;;)
    {
      emc();
      return;
      label45:
      if (!TextUtils.isEmpty(this.cDF))
      {
        this.ticket = qI(this.cDF);
        arwt.i(TAG, "gen ticket by urlPatch");
      }
      else if (!TextUtils.isEmpty(this.packageName))
      {
        this.ticket = aP(this.packageName, this.versionCode);
        arwt.i(TAG, "gen ticket by packageName & versionCode");
      }
      else
      {
        arwt.e(TAG, "bad download INFO!!!");
      }
    }
  }
  
  public void emd()
  {
    this.uniqueId = "";
    emb();
  }
  
  public int getState()
  {
    try
    {
      int i = this.state;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String qH(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.cDJ)))
    {
      arwt.i(TAG, ">getExtParam empty params:" + paramString + "|" + this.cDJ);
      return "";
    }
    try
    {
      Object localObject = new JSONObject(this.cDJ);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString(paramString);
        arwt.i(TAG, ">getExtParam " + paramString + "=" + (String)localObject);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        String str = null;
        continue;
        str = "";
      }
    }
  }
  
  public void setState(int paramInt)
  {
    try
    {
      this.state = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public JSONObject toJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", this.appId);
      localJSONObject.put("state", this.state);
      localJSONObject.put("pro", this.progress);
      localJSONObject.put("packagename", this.packageName);
      localJSONObject.put("ismyapp", this.downloadType);
      localJSONObject.put("download_from", this.from);
      localJSONObject.put("realDownloadType", this.elk);
      localJSONObject.put("via", this.via);
      localJSONObject.put("writecodestate", this.elm);
      localJSONObject.put("extraInfo", this.extraData);
      localJSONObject.put("isAutoInstallBySDK", this.isAutoInstallBySDK);
      localJSONObject.put("fileMd5", this.fileMd5);
      localJSONObject.put("fileSize", this.fileSize);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      arwt.e(TAG, "onNetworkConnect " + localJSONException.getMessage(), localJSONException);
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    return "DownloadInfo [ticket=" + this.ticket + ", uniqueId=" + this.uniqueId + ", state=" + this.state + ", urlStr=" + this.urlStr + ", urlPatch=" + this.cDF + ", packageName=" + this.packageName + ", versionCode=" + this.versionCode + ", fileSize =" + this.fileSize + ", totalDataLength =" + this.awN + ", progress=" + this.progress + ", isAutoInstallBySDK =" + this.isAutoInstallBySDK + ", isAutoInstall=" + this.isAutoInstall + ", filePath=" + this.filePath + ", appId=" + this.appId + ", push_title=" + this.pushTitle + ", sendTime=" + this.sendTime + ", time=" + this.time + ", updateType=" + this.updateType + ", myAppId=" + this.cDG + ", apkId=" + this.cCL + ", lastDownloadSize=" + this.awM + ", isApk=" + this.ddw + ", iconUrl=" + this.iconUrl + ", isShowNotification=" + this.ell + ", writeCodeState=" + this.elm + ", extraInfo =" + this.extraData + ", fileMd5 =" + this.fileMd5 + ", recommendId =" + this.recommendId + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    paramParcel.writeString(this.ticket);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.urlStr);
    paramParcel.writeString(this.packageName);
    paramParcel.writeString(this.pushTitle);
    paramParcel.writeString(this.sendTime);
    paramParcel.writeString(this.via);
    paramParcel.writeLong(this.time);
    paramParcel.writeInt(this.updateType);
    paramParcel.writeString(this.cDF);
    paramParcel.writeString(this.cDG);
    paramParcel.writeString(this.cCL);
    paramParcel.writeInt(this.versionCode);
    paramParcel.writeInt(this.downloadType);
    paramParcel.writeInt(this.elk);
    paramParcel.writeString(this.filePath);
    paramParcel.writeString(this.source);
    paramParcel.writeInt(this.state);
    paramParcel.writeInt(this.progress);
    paramParcel.writeParcelable(this.noticeIntent, paramInt);
    paramParcel.writeInt(this.ekZ);
    if (this.isAutoInstall)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.ddi) {
        break label401;
      }
      b1 = 1;
      label195:
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.awM);
      paramParcel.writeInt(this.from);
      if (!this.ddw) {
        break label406;
      }
      b1 = 1;
      label225:
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeInt(this.ell);
      paramParcel.writeInt(this.elm);
      paramParcel.writeLong(this.awN);
      paramParcel.writeString(this.extraData);
      if (!this.isAutoInstallBySDK) {
        break label411;
      }
      b1 = 1;
      label279:
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.fileMd5);
      paramParcel.writeLong(this.fileSize);
      paramParcel.writeString(this.recommendId);
      paramParcel.writeString(this.cCM);
      paramParcel.writeString(this.channelId);
      paramParcel.writeString(this.pageId);
      paramParcel.writeString(this.kx);
      paramParcel.writeString(this.cDH);
      if (!this.ddx) {
        break label416;
      }
    }
    label401:
    label406:
    label411:
    label416:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.errorCode);
      paramParcel.writeString(this.cDI);
      paramParcel.writeString(this.uniqueId);
      paramParcel.writeString(this.cDJ);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label195;
      b1 = 0;
      break label225;
      b1 = 0;
      break label279;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */