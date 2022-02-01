package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.login.QMLoginError;
import com.tencent.qqmail.utilities.report.QMReportManager;
import java.util.List;
import java.util.Map;

public class QMCGIError
  extends QMNetworkError
{
  private static final String TAG = "QMCGIError";
  public final int appCode;
  public final String cgiName;
  private final boolean isNeedRetryAutologin;
  private final boolean isSessionTimeouted;
  private final boolean isWtloginSkeyTimeout;
  public final QMNetworkResponse response;
  
  public QMCGIError(int paramInt)
  {
    this(paramInt, 0, "", "", "", "", null);
  }
  
  public QMCGIError(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, QMNetworkResponse paramQMNetworkResponse)
  {
    super(3, -1, paramString1, paramString2);
    this.appCode = paramInt1;
    this.response = paramQMNetworkResponse;
    boolean bool2;
    if (paramInt1 == -2)
    {
      bool1 = true;
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramQMNetworkResponse != null)
        {
          bool2 = bool1;
          if (paramQMNetworkResponse.getResponseHeaders().containsKey("Set-Cookie")) {
            bool2 = ((List)paramQMNetworkResponse.getResponseHeaders().get("Set-Cookie")).contains("session=timeout");
          }
        }
      }
      this.isSessionTimeouted = bool2;
      if (paramInt1 != -15) {
        break label318;
      }
      bool1 = true;
      label105:
      this.isWtloginSkeyTimeout = bool1;
      if ((!bool2) && (!this.isWtloginSkeyTimeout)) {
        break label324;
      }
    }
    label318:
    label324:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.isNeedRetryAutologin = bool1;
      this.cgiName = paramString3;
      if (!(this instanceof QMLoginError))
      {
        paramQMNetworkResponse = paramString1.replaceAll(";", " ");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uin:").append(paramString4).append(";").append(paramInt1).append(";").append(paramString3).append(";").append(paramInt2).append(";").append(paramQMNetworkResponse);
        DataCollector.logException(paramString3, paramInt1, "Event_Error", localStringBuilder.toString(), true);
        QMReportManager.reportCGIError(this, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, bool2, this.isWtloginSkeyTimeout);
      }
      QMLog.log(6, "QMCGIError", "errType:3,code:" + this.code + ":" + paramString1 + "," + getClass().getSimpleName() + "," + paramString2);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label105;
    }
  }
  
  public boolean isNeedRetryAutologin()
  {
    return this.isNeedRetryAutologin;
  }
  
  public boolean isSessionTimeouted()
  {
    return this.isSessionTimeouted;
  }
  
  public boolean isWtloginSkeyTimeout()
  {
    return this.isWtloginSkeyTimeout;
  }
  
  public String toString()
  {
    return super.toString() + "{appCode:" + this.appCode + ", timeout:" + this.isSessionTimeouted + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMCGIError
 * JD-Core Version:    0.7.0.1
 */