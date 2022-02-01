import android.content.Context;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.qphone.base.util.QLog;

final class avfz
  extends OnPluginInstallListener.Stub
{
  avfz(avfw.b paramb, avfw.d paramd, Context paramContext) {}
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {}
  
  public void onInstallError(String paramString, int paramInt)
    throws RemoteException
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallError");
    }
    if (this.jdField_a_of_type_Avfw$b != null) {
      this.jdField_a_of_type_Avfw$b.a(false, this.val$context, this.jdField_a_of_type_Avfw$d);
    }
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallFinish");
    }
    if (this.jdField_a_of_type_Avfw$b != null)
    {
      paramString = avfw.a().queryPlugin(this.jdField_a_of_type_Avfw$d.mPluginID);
      if (paramString != null)
      {
        this.jdField_a_of_type_Avfw$d.mApkFilePath = paramString.mInstalledPath;
        this.jdField_a_of_type_Avfw$d.a(paramString);
      }
      this.jdField_a_of_type_Avfw$b.a(true, this.val$context, this.jdField_a_of_type_Avfw$d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfz
 * JD-Core Version:    0.7.0.1
 */