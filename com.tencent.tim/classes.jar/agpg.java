import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloaderFirstPkgRp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class agpg
{
  protected agpe a;
  protected ExcitingTransferDownloadCompletedInfo a;
  protected ExcitingTransferDownloaderFirstPkgRp a;
  int cXp = 0;
  int cYA = 0;
  int cYz = 0;
  protected final QQAppInterface mApp;
  protected long mSessionId;
  
  public agpg(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public void Js(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Agpe == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo == null))
    {
      QLog.e("ExtfGroupDownloadDataReport<FileAssistant>", 1, "Id[" + this.mSessionId + "] GroupDownloadDataReport err. param err");
      return;
    }
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Agpe != null) {
      localHashMap.putAll(this.jdField_a_of_type_Agpe.getReportData());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo != null) {
      localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.getReportData());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp != null) {
      localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.getReportData());
    }
    for (;;)
    {
      localHashMap.put("param_V6SelectType", String.valueOf(this.cXp));
      localHashMap.put("param_ipAddrType", String.valueOf(this.cYz));
      localHashMap.put("param_stackType", String.valueOf(ahbr.EL()));
      localHashMap.put("param_loginType", String.valueOf(ahbr.EM()));
      localHashMap.put("param_ishttps", String.valueOf(this.cYA));
      QLog.i("ExtfGroupDownloadDataReport<FileAssistant>", 1, "Id[" + this.mSessionId + "] >>> GroupDownloadDataReport: act=" + vr() + localHashMap.toString());
      anpc.a(BaseApplication.getContext()).collectPerformance(this.mApp.getCurrentAccountUin(), vr(), paramBoolean, 0L, 0L, localHashMap, "");
      this.jdField_a_of_type_Agpe = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = null;
      return;
      localHashMap.put("param_CSTime", String.valueOf(0));
      localHashMap.put("param_HttpFirstTime", String.valueOf(0));
      localHashMap.put("param_HttpFirstDataSize", String.valueOf(0));
    }
  }
  
  public void Ju(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.cYA = i;
      return;
    }
  }
  
  public void Oo(int paramInt)
  {
    this.cXp = paramInt;
  }
  
  public void Op(int paramInt)
  {
    this.cYz = paramInt;
  }
  
  public void a(int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_Agpe = new agpe();
    this.jdField_a_of_type_Agpe.ZA = paramInt;
    this.jdField_a_of_type_Agpe.ZB = paramLong1;
    this.jdField_a_of_type_Agpe.bIP = paramString;
    this.jdField_a_of_type_Agpe.ZD = paramLong2;
    this.jdField_a_of_type_Agpe.ZC = paramLong3;
    this.jdField_a_of_type_Agpe.cYw = 0;
    this.jdField_a_of_type_Agpe.cYx = 1;
  }
  
  public void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (paramExcitingTransferDownloadCompletedInfo.m_uFirstRecvDataTime > paramExcitingTransferDownloadCompletedInfo.m_uStartTime) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHttpFirstTime = (paramExcitingTransferDownloadCompletedInfo.m_uFirstRecvDataTime - paramExcitingTransferDownloadCompletedInfo.m_uStartTime);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize = paramExcitingTransferDownloadCompletedInfo.m_uFirstRecvDataSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = paramExcitingTransferDownloadCompletedInfo;
  }
  
  public void jD(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp = new ExcitingTransferDownloaderFirstPkgRp();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mCSStartTime = paramLong;
  }
  
  public void jE(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mCSEndTime = paramLong;
  }
  
  public void p(long paramLong)
  {
    this.mSessionId = paramLong;
  }
  
  protected String vr()
  {
    return "actGroupPDFileDownload";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpg
 * JD-Core Version:    0.7.0.1
 */