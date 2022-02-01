package com.tencent.qqmail.calendar.data;

import com.tencent.qqmail.model.verify.QMVerify;

public class CalendarShareError
{
  private int errorCode;
  private String[] errorEmails;
  private String errorMsg;
  private QMVerify shareVerify;
  
  public CalendarShareError(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.errorMsg = paramString;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String[] getErrorEmails()
  {
    return this.errorEmails;
  }
  
  public String getErrorMsg()
  {
    return this.errorMsg;
  }
  
  public QMVerify getShareVerify()
  {
    return this.shareVerify;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setErrorEmails(String[] paramArrayOfString)
  {
    this.errorEmails = paramArrayOfString;
  }
  
  public void setErrorMsg(String paramString)
  {
    this.errorMsg = paramString;
  }
  
  public void setShareVerify(QMVerify paramQMVerify)
  {
    this.shareVerify = paramQMVerify;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.CalendarShareError
 * JD-Core Version:    0.7.0.1
 */