package com.tencent.qqmail.utilities.qmnetwork;

public class QMSendMailCGIError
  extends QMCGIError
{
  public static int CGIERROR_SEND_MAIL_NEED_VERIFY = -140;
  public static int CGIERROR_SEND_MAIL_WITH_ERROR_VERIFY = -141;
  private String verifyKey;
  private String verifyMailId;
  
  public QMSendMailCGIError(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, QMNetworkResponse paramQMNetworkResponse, String paramString5, String paramString6)
  {
    super(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramQMNetworkResponse);
    this.verifyKey = paramString6;
    this.verifyMailId = paramString5;
  }
  
  public String getVerifyKey()
  {
    return this.verifyKey;
  }
  
  public String getVerifyMailId()
  {
    return this.verifyMailId;
  }
  
  public boolean isNeedVerifyCode()
  {
    return this.appCode == CGIERROR_SEND_MAIL_NEED_VERIFY;
  }
  
  public boolean isVerifyError()
  {
    return this.appCode == CGIERROR_SEND_MAIL_WITH_ERROR_VERIFY;
  }
  
  public String toString()
  {
    return super.toString() + "{appCode:" + this.appCode + ", verifyKey:" + this.verifyKey + ", verifyMailId:" + this.verifyMailId + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMSendMailCGIError
 * JD-Core Version:    0.7.0.1
 */