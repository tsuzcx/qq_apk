import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public abstract class agpd
{
  protected final QQAppInterface mApp;
  
  public agpd(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public void Js(boolean paramBoolean)
  {
    if (alQ()) {
      Jt(paramBoolean);
    }
    HashMap localHashMap = getReportData();
    if (localHashMap != null) {
      QLog.i("DataReport", 1, ">>> report: act=" + s(false) + localHashMap.toString());
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(this.mApp.getCurrentAccountUin(), s(false), paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void Jt(boolean paramBoolean)
  {
    HashMap localHashMap = K();
    if (localHashMap != null)
    {
      QLog.i("OldDataReport", 1, ">>> reportOld: act=" + s(true) + localHashMap.toString());
      anpc.a(BaseApplication.getContext()).collectPerformance(this.mApp.getCurrentAccountUin(), s(true), paramBoolean, 0L, 0L, localHashMap, "");
    }
  }
  
  protected abstract HashMap<String, String> K();
  
  public void a(agpe paramagpe, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete, HashMap<String, String> paramHashMap)
  {
    paramagpe = paramagpe.getReportData();
    if (paramExcitingTransferOneSlotComplete != null) {
      paramagpe.putAll(paramExcitingTransferOneSlotComplete.getReportData());
    }
    if (paramHashMap != null) {
      paramagpe.putAll(paramHashMap);
    }
    paramHashMap = anpc.a(BaseApplication.getContext());
    String str = this.mApp.getCurrentAccountUin();
    if (paramExcitingTransferOneSlotComplete.m_SubReason == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramHashMap.collectPerformance(str, "actPDSlot", bool, 0L, 0L, paramagpe, "");
      return;
    }
  }
  
  protected abstract boolean alQ();
  
  public abstract void diF();
  
  public abstract void diG();
  
  protected abstract HashMap<String, String> getReportData();
  
  protected abstract String s(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpd
 * JD-Core Version:    0.7.0.1
 */