package com.tencent.qqmail.utilities.qmnetwork.login;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.report.QMReportManager;

public class QMLoginError
  extends QMCGIError
{
  public static final int APP_CODE_NO_ERROR = 0;
  public static final int STANDARD_ERRNO_ACCOUNT_DOMAIN_ERROR = 10009;
  public static final int STANDARD_ERRNO_ACCOUNT_NOT_EXIST = 10007;
  public static final int STANDARD_ERRNO_ACCOUNT_REOPEN = 10010;
  public static final int STANDARD_ERRNO_ACCOUNT_SUSPEND = 10008;
  public static final int STANDARD_ERRNO_LOGINED_ACCOUNT = 10011;
  public static final int STANDARD_ERRNO_NEED_PASSWORD = 10004;
  public static final int STANDARD_ERRNO_NEED_SECOND_PASSWORD = 10005;
  public static final int STANDARD_ERRNO_NEED_VERIFY_CODE = 10006;
  public static final int STANDARD_ERRNO_PASSWORD_ERROR = 10001;
  public static final int STANDARD_ERRNO_SECOND_PASSWORD_ERROR = 10002;
  public static final int STANDARD_ERRNO_UNKNOW = 10000;
  public static final int STANDARD_ERRNO_VERIFY_CODE_ERROR = 10003;
  private static final String TAG = QMLoginError.class.getSimpleName();
  public final int detailCode;
  public final String loginErrorMsg;
  public final int loginErrorType;
  public String tips;
  
  public QMLoginError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super(paramInt1, paramInt2, paramString, "", "login", "", null);
    this.loginErrorType = paramInt2;
    this.detailCode = paramInt3;
    this.loginErrorMsg = paramString;
    this.tips = "";
    QMReportManager.reportLoginError(this, paramInt1, paramInt2, paramInt3, paramString, isSessionTimeouted(), isSessionTimeouted());
    paramInt1 = convertToStandardErrNo(paramInt2);
    if (paramString == null) {}
    for (paramString = "";; paramString = paramString.replaceAll(";", " "))
    {
      DataCollector.logException(4, paramInt1, "Event_Error", paramString, true);
      return;
    }
  }
  
  public QMLoginError(int paramInt1, int paramInt2, int paramInt3, String paramString, QMNetworkResponse paramQMNetworkResponse)
  {
    super(paramInt1, paramInt2, "登录失败", "", "login", "", paramQMNetworkResponse);
    this.loginErrorType = paramInt2;
    this.detailCode = paramInt3;
    this.loginErrorMsg = paramString;
    this.tips = "";
    QMReportManager.reportLoginError(this, paramInt1, paramInt2, paramInt3, paramString, isSessionTimeouted(), isSessionTimeouted());
    paramInt1 = convertToStandardErrNo(paramInt2);
    if (paramString == null) {}
    for (paramString = "";; paramString = paramString.replaceAll(";", " "))
    {
      DataCollector.logException(4, paramInt1, "Event_Error", paramString, true);
      return;
    }
  }
  
  public QMLoginError(int paramInt1, int paramInt2, int paramInt3, String paramString1, QMNetworkResponse paramQMNetworkResponse, String paramString2)
  {
    this(paramInt1, paramInt2, paramInt3, paramString1, paramQMNetworkResponse);
    this.tips = paramString2;
  }
  
  public static int convertToStandardErrNo(int paramInt)
  {
    switch (paramInt)
    {
    case 10000: 
    default: 
      return 10000;
    case 1: 
      return 10001;
    case 16: 
      return 16;
    case 4: 
      return 10005;
    case 9: 
      return 9;
    case 6: 
      return 10002;
    case 100: 
      return 10010;
    case 7: 
      return 10004;
    case 8: 
      return 10008;
    case 2: 
      return 10003;
    case 3: 
      return 10006;
    case 10: 
      return 10007;
    case 10001: 
      return 10009;
    }
    return 10011;
  }
  
  public boolean isNeedRetryAutologin()
  {
    return (super.isNeedRetryAutologin()) || (this.loginErrorType == -62) || (this.loginErrorType == -63) || (this.loginErrorType == -64);
  }
  
  public String toString()
  {
    return super.toString() + "{loginErrorType:" + this.loginErrorType + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.login.QMLoginError
 * JD-Core Version:    0.7.0.1
 */