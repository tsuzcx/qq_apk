package com.qzone.report;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.qzone.common.logging.QDLog;
import com.qzone.download.DownloaderFactory;
import com.qzone.download.uinterface.IDownloadConfig;
import com.qzone.utils.SDCardUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportObj
{
  public static final int APP_ID_HEAD = 6;
  public static final int APP_ID_PHOTO = 0;
  public static final int APP_ID_QQ_QUN_PHOTO = 10;
  public static final int APP_ID_SOUND = 4;
  public static final int APP_ID_UPP = 8;
  public static final int APP_ID_VIDEO = 2;
  private static final String APP_TYPE_HEAD = "qzone_head";
  private static final String APP_TYPE_PHOTO = "photo";
  private static final String APP_TYPE_QQ_QUN_PHOTO = "groupphoto";
  private static final String APP_TYPE_SOUND = "qzone_sound";
  private static final String APP_TYPE_UPP = "upp";
  private static final String APP_TYPE_VIDEO = "qzone_video";
  public static boolean IS_CONNECT_USB = false;
  public static final int OP_DOWN = 1;
  public static final int OP_UP = 0;
  public static final String REPORT_REFER_QQ_QUN = "mqun";
  private static final String REPORT_URL = "http://p.store.qq.com/";
  public long elapse = 0L;
  public long endTime;
  public StringBuilder errMsg = new StringBuilder();
  public ExtendData extend = null;
  public long fileSize = 0L;
  public int flow;
  public int networkType = 0;
  public String refer = "unknown";
  public int retCode = 0;
  public String serverIp = "";
  public long startTime;
  public String terminal = "Android";
  public String version = "0.0.1";
  
  public static String getReportUrl(int paramInt1, int paramInt2)
  {
    String str;
    switch (paramInt1)
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return "";
    case 0: 
      str = "http://p.store.qq.com/" + "photo";
    }
    for (;;)
    {
      str = str + "?";
      if (paramInt2 != 0) {
        break;
      }
      return str + "op=upload";
      str = "http://p.store.qq.com/" + "qzone_video";
      continue;
      str = "http://p.store.qq.com/" + "qzone_sound";
      continue;
      str = "http://p.store.qq.com/" + "qzone_head";
      continue;
      str = "http://p.store.qq.com/" + "upp";
      continue;
      str = "http://p.store.qq.com/" + "groupphoto";
    }
    if (paramInt2 == 1) {
      return str + "op=down";
    }
    return "";
  }
  
  private static String putAddress(int paramInt)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = localStringBuffer1.append(paramInt & 0xFF).append('.');
    paramInt >>>= 8;
    localStringBuffer2 = localStringBuffer2.append(paramInt & 0xFF).append('.');
    paramInt >>>= 8;
    localStringBuffer2.append(paramInt & 0xFF).append('.').append(paramInt >>> 8 & 0xFF);
    return localStringBuffer1.toString();
  }
  
  protected String getRefer()
  {
    return this.refer;
  }
  
  public void init(IDownloadConfig paramIDownloadConfig)
  {
    if (paramIDownloadConfig == null) {
      return;
    }
    this.terminal = paramIDownloadConfig.getTerminal();
    this.version = paramIDownloadConfig.getVersion();
    this.refer = paramIDownloadConfig.getRefer();
  }
  
  public JSONObject toJSON()
    throws JSONException
  {
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("size", this.fileSize);
        localJSONObject.put("delay", this.elapse);
        localJSONObject.put("network", this.networkType);
        localJSONObject.put("terminal", this.terminal);
        localJSONObject.put("terminalver", this.version);
        localJSONObject.put("refer", getRefer());
        localJSONObject.put("errcode", this.retCode);
        if (DownloaderFactory.getDownloadConfig() != null)
        {
          localJSONObject.put("uin", DownloaderFactory.getDownloadConfig().getCurrentUin());
          localJSONObject.put("time", this.endTime / 1000L);
          localJSONObject.put("flow", this.flow);
          localJSONObject.put("sip", this.serverIp);
          if ((this.errMsg == null) || (this.errMsg.length() <= 0)) {
            break;
          }
          localJSONObject.put("msg", this.errMsg.toString());
          if (this.extend == null) {
            this.extend = new ExtendData();
          }
          Object localObject2 = ((WifiManager)DownloaderFactory.getContext().getSystemService("wifi")).getDhcpInfo();
          Object localObject1 = "none";
          if (localObject2 != null) {
            localObject1 = putAddress(((DhcpInfo)localObject2).dns1) + "," + putAddress(((DhcpInfo)localObject2).dns2);
          }
          this.extend.put(0, Build.MODEL);
          this.extend.put(1, Build.VERSION.RELEASE);
          localObject2 = this.extend;
          if (SDCardUtil.isSDCardMounted())
          {
            i = 1;
            ((ExtendData)localObject2).put(2, String.valueOf(i));
            this.extend.put(3, SDCardUtil.getSDCardCapabilityForDisplay());
            this.extend.put(4, SDCardUtil.getSDCardRemainForDisplay());
            this.extend.put(6, (String)localObject1);
            localObject1 = this.extend;
            if (!IS_CONNECT_USB) {
              break label420;
            }
            i = j;
            ((ExtendData)localObject1).put(7, String.valueOf(i));
            localJSONObject.put("extend", this.extend.getExtendString());
            return localJSONObject;
          }
        }
        else
        {
          localJSONObject.put("uin", 0);
          continue;
        }
        i = 0;
      }
      catch (Throwable localThrowable)
      {
        QDLog.e("BusinessReport", "to json error!", localThrowable);
        return localJSONObject;
      }
      continue;
      label420:
      int i = 0;
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("networkType = ");
    switch (this.networkType)
    {
    default: 
      localStringBuilder.append("未知");
    }
    for (;;)
    {
      localStringBuilder.append(" retCode = ");
      localStringBuilder.append(this.retCode);
      localStringBuilder.append(" fileSize = ");
      localStringBuilder.append(this.fileSize);
      localStringBuilder.append(" elapse = ");
      localStringBuilder.append(this.elapse);
      localStringBuilder.append(" errMsg = ");
      localStringBuilder.append(this.errMsg.toString());
      return localStringBuilder.toString();
      localStringBuilder.append("WIFI");
      continue;
      localStringBuilder.append("3G");
      continue;
      localStringBuilder.append("2G");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.report.ReportObj
 * JD-Core Version:    0.7.0.1
 */