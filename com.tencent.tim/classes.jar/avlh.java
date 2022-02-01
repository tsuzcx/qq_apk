import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimBridgeActivity;
import cooperation.qqpim.QQPimPluginLoadRunnable.a;

public class avlh
  implements QQPimPluginLoadRunnable.a
{
  public avlh(QQPimBridgeActivity paramQQPimBridgeActivity) {}
  
  public void abL(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(avli.TAG, 2, "QQPimBridgeActivity.downloadError()");
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    QQPimBridgeActivity.a(this.a).sendMessage(localMessage);
  }
  
  public void bm(float paramFloat) {}
  
  public void eAB()
  {
    if (QLog.isColorLevel()) {
      QLog.i(avli.TAG, 2, "QQPimBridgeActivity.hasInstalled()");
    }
    QQPimBridgeActivity.a(this.a).sendEmptyMessage(1);
  }
  
  public void eAC()
  {
    QQPimBridgeActivity.a(this.a).sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avlh
 * JD-Core Version:    0.7.0.1
 */