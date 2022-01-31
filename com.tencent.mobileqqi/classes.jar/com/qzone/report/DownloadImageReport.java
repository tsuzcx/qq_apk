package com.qzone.report;

import android.text.TextUtils;
import com.qzone.common.logging.QDLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadImageReport
{
  public static final int LOCAL_RET_CODE_CLIENT_PROTOCOL_EXP = 8;
  public static final int LOCAL_RET_CODE_CONNECT_POOL_TIMEOUT_EXP = 13;
  public static final int LOCAL_RET_CODE_CONNECT_TIMEOUT_EXP = 10;
  public static final int LOCAL_RET_CODE_DECODE_FAILED = -4;
  public static final int LOCAL_RET_CODE_EXP = 4;
  public static final int LOCAL_RET_CODE_FNF_EXP = 1;
  public static final int LOCAL_RET_CODE_ILLEGAL_FORMAT = -1;
  public static final int LOCAL_RET_CODE_ILL_EXP = 5;
  public static final int LOCAL_RET_CODE_IO_EXP = 2;
  public static final int LOCAL_RET_CODE_LENGTH_MISMATCH = -3;
  public static final int LOCAL_RET_CODE_NETWORK_FAIL = -99997;
  public static final int LOCAL_RET_CODE_NO_CACHE = -2;
  public static final int LOCAL_RET_CODE_NO_HTTP_RSP_EXP = 11;
  public static final int LOCAL_RET_CODE_OOM_ERR = 3;
  public static final int LOCAL_RET_CODE_SOCKET_EXP = 6;
  public static final int LOCAL_RET_CODE_SOCKET_TO_EXP = 7;
  public static final int LOCAL_RET_CODE_SSL_PEER_UNVERIFIED_EXP = 12;
  public static final int LOCAL_RET_CODE_TRY_FAILED = -99998;
  public static final int LOCAL_RET_CODE_TYPE_MISMATCH = -99996;
  public static final int LOCAL_RET_CODE_UNKNOW = -99999;
  public static final int LOCAL_RET_CODE_UNKNOW_HOST_EXP = 9;
  
  public static class DownloadReportObject
    extends ReportObj
  {
    private static final String QQ_QUN_FLAG = "store.qq.com/qun/";
    public int appIdType = 0;
    public String clientip;
    public String dnsIp;
    public String refer;
    public int retry;
    public String strategyInfo;
    public long t_wait;
    public String url;
    
    private void calculateAppIdType()
    {
      if ((!TextUtils.isEmpty(this.url)) && (this.url.indexOf("store.qq.com/qun/") >= 0)) {
        this.appIdType = 10;
      }
    }
    
    protected String getRefer()
    {
      if (this.appIdType == 10) {
        return "mqun";
      }
      return super.getRefer();
    }
    
    public boolean needForceReport()
    {
      return this.retry > 0;
    }
    
    public void setUrl(String paramString)
    {
      this.url = paramString;
      calculateAppIdType();
    }
    
    public JSONObject toJSON()
      throws JSONException
    {
      JSONObject localJSONObject = super.toJSON();
      try
      {
        localJSONObject.put("url", this.url);
        localJSONObject.put("dnsip", this.dnsIp);
        localJSONObject.put("retry", this.retry);
        localJSONObject.put("clientip", this.clientip);
        localJSONObject.put("t_wait", this.t_wait);
        if (this.refer != null) {
          localJSONObject.put("refer", this.refer);
        }
        if (!TextUtils.isEmpty(this.strategyInfo))
        {
          if (this.extend == null) {
            this.extend = new ExtendData();
          }
          this.extend.put(10, this.strategyInfo);
          localJSONObject.put("extend", this.extend.getExtendString());
        }
        return localJSONObject;
      }
      catch (Throwable localThrowable)
      {
        QDLog.e("BusinessReport", "to json error!", localThrowable);
      }
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.report.DownloadImageReport
 * JD-Core Version:    0.7.0.1
 */