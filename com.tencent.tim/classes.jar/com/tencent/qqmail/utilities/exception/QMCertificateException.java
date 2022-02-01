package com.tencent.qqmail.utilities.exception;

import java.security.cert.CertificateException;

public class QMCertificateException
  extends CertificateException
{
  public QMCertificateException() {}
  
  public QMCertificateException(String paramString)
  {
    super(paramString);
  }
  
  public QMCertificateException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public QMCertificateException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.exception.QMCertificateException
 * JD-Core Version:    0.7.0.1
 */