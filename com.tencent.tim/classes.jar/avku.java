import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;

public class avku
  extends OnPluginInstallListener.Stub
{
  public avku(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity) {}
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {}
  
  public void onInstallError(String paramString, int paramInt)
    throws RemoteException
  {
    String str = String.valueOf(paramInt);
    paramString = acfp.m(2131711803);
    if (this.a.type == QQIndividualityBridgeActivity.exn) {
      paramString = acfp.m(2131711796);
    }
    for (;;)
    {
      avfw.jo(str, paramString);
      int i = aqiw.getSystemNetwork(this.a);
      QLog.e("QQIndividuality", 2, "install plugin fail: " + paramInt + " and netType = " + i);
      this.a.setResult(1001);
      QQIndividualityBridgeActivity.c(this.a);
      anot.a(null, "CliOper", "", "", "ep_mall", "0X8006A98", 0, 0, str, String.valueOf(i), "", "");
      return;
      if (this.a.type == QQIndividualityBridgeActivity.exo) {
        paramString = acfp.m(2131711797);
      } else if (this.a.type == QQIndividualityBridgeActivity.exp) {
        paramString = acfp.m(2131711800);
      }
    }
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    this.a.eAz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avku
 * JD-Core Version:    0.7.0.1
 */