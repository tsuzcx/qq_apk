import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class agpi
{
  protected agpe a;
  protected ExcitingTransferOneSlotComplete a;
  int cXp = 0;
  int cYA = 0;
  int cYz = 0;
  protected final QQAppInterface mApp;
  protected long mSessionId;
  
  public agpi(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
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
  
  public void a(ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete = paramExcitingTransferOneSlotComplete;
  }
  
  public void p(long paramLong)
  {
    this.mSessionId = paramLong;
  }
  
  public void report()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Agpe == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete == null))
    {
      QLog.e("ExtfGroupDownloaderDataReport<FileAssistant>", 1, "Id[" + this.mSessionId + "] GroupDownloaderDataReport err. param err");
      return;
    }
    HashMap localHashMap = this.jdField_a_of_type_Agpe.getReportData();
    localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete.getReportData());
    localHashMap.put("param_V6SelectType", String.valueOf(this.cXp));
    localHashMap.put("param_ipAddrType", String.valueOf(this.cYz));
    localHashMap.put("param_stackType", String.valueOf(ahbr.EL()));
    localHashMap.put("param_loginType", String.valueOf(ahbr.EM()));
    localHashMap.put("param_ishttps", String.valueOf(this.cYA));
    QLog.i("ExtfGroupDownloaderDataReport<FileAssistant>", 1, "Id[" + this.mSessionId + "] >>> GroupDownloaderDataReport:act=" + vr() + localHashMap.toString());
    anpc localanpc = anpc.a(BaseApplication.getContext());
    String str1 = this.mApp.getCurrentAccountUin();
    String str2 = vr();
    if (this.jdField_a_of_type_Agpe.ZB == 0L) {}
    for (;;)
    {
      localanpc.collectPerformance(str1, str2, bool, 0L, 0L, localHashMap, "");
      this.jdField_a_of_type_Agpe = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete = null;
      return;
      bool = false;
    }
  }
  
  protected String vr()
  {
    return "actGroupPDSlot";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpi
 * JD-Core Version:    0.7.0.1
 */