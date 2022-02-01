import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimPluginLoadRunnable.a;
import cooperation.qqpim.QQPimPluginProxyService;

public class avlj
  implements QQPimPluginLoadRunnable.a
{
  public avlj(QQPimGetTipsInfoIPC paramQQPimGetTipsInfoIPC) {}
  
  public void abL(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(avli.TAG, 2, "QQPimGetTipsInfoIPC.downloadError() " + paramInt);
    }
  }
  
  public void bm(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i(avli.TAG, 2, "QQPimGetTipsInfoIPC.downloading() " + paramFloat);
    }
  }
  
  public void eAB()
  {
    if (QLog.isColorLevel()) {
      QLog.i(avli.TAG, 2, "QQPimGetTipsInfoIPC.hasInstalled() ");
    }
    QQPimPluginProxyService.eQ(QQPimGetTipsInfoIPC.a(this.this$0));
  }
  
  public void eAC()
  {
    if (QLog.isColorLevel()) {
      QLog.i(avli.TAG, 2, "QQPimGetTipsInfoIPC.downloadBegin()");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avlj
 * JD-Core Version:    0.7.0.1
 */