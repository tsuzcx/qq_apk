import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.qphone.base.util.QLog;

public class agpl
  extends agpj
  implements apeu
{
  protected apev a;
  protected String bIR;
  
  public agpl(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt, agpk paramagpk)
  {
    super(paramQQAppInterface, paramLong1, paramLong2, paramInt, paramagpk);
  }
  
  public static apeu a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString, agpk paramagpk)
  {
    if (paramagpk == null)
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader fileInfo is null");
      return null;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader strTmpFilePath is err");
      return null;
    }
    if (!paramagpk.isVaild())
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader fileInfo is err");
      return null;
    }
    paramQQAppInterface = new agpl(paramQQAppInterface, paramLong1, paramLong2, 1, paramagpk);
    paramQQAppInterface.Jh(paramString);
    return paramQQAppInterface;
  }
  
  public int EA()
  {
    return 0;
  }
  
  public int Ez()
  {
    if (a() != null) {
      return a().m_uRetryTimes;
    }
    return 0;
  }
  
  protected void Jh(String paramString)
  {
    this.bIR = paramString;
  }
  
  public void a(apev paramapev)
  {
    this.jdField_a_of_type_Apev = paramapev;
  }
  
  public boolean alZ()
  {
    return false;
  }
  
  protected void b(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    super.b(paramExcitingTransferDownloadCompletedInfo);
    if (this.jdField_a_of_type_Apev != null) {
      this.jdField_a_of_type_Apev.onDownloadSuccess(paramExcitingTransferDownloadCompletedInfo.m_strFileSavePath);
    }
  }
  
  public void bme()
  {
    if (this.mIsStop) {
      return;
    }
    QLog.i("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "Id[" + this.mSessionId + "] cancelTask");
    diN();
  }
  
  protected void c(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    super.c(paramInt, paramExcitingTransferDownloadCompletedInfo);
    if (this.jdField_a_of_type_Apev != null)
    {
      Bundle localBundle = new Bundle();
      if (paramExcitingTransferDownloadCompletedInfo != null) {
        localBundle.putInt("nSrvReturnCode", paramExcitingTransferDownloadCompletedInfo.m_nSrvReturnCode);
      }
      this.jdField_a_of_type_Apev.a(true, fX(), paramInt, "", "", localBundle);
    }
  }
  
  protected ExcitingTransferDownloadConfig d()
  {
    return agpf.a().c();
  }
  
  public void download()
  {
    this.mIsStop = false;
    alX();
  }
  
  public int getProxyType()
  {
    if (a() != null) {
      return a().m_uProxyType;
    }
    return 0;
  }
  
  public String getUrl()
  {
    return this.bIQ;
  }
  
  protected void t(long paramLong1, long paramLong2, long paramLong3)
  {
    super.t(paramLong1, paramLong2, paramLong3);
    if (this.jdField_a_of_type_Apev != null) {
      this.jdField_a_of_type_Apev.onDownloadProgress(paramLong2, this.jdField_a_of_type_Agpk.getFileSize());
    }
  }
  
  protected String vs()
  {
    return acbn.bmg;
  }
  
  protected String vt()
  {
    return this.bIR;
  }
  
  public String vz()
  {
    return this.bIQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpl
 * JD-Core Version:    0.7.0.1
 */