import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;

public class avdi
  extends RemoteCommand
{
  private boolean dmc;
  
  public avdi(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.dmc = paramBoolean;
  }
  
  public static void eN(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = PluginCommunicationHandler.getInstance();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.register(new avdi("qqcomicemoticonipccmd", false));
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicEmoticonUploadRemoteCmd", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
    }
    do
    {
      do
      {
        return null;
        localObject = (QQAppInterface)localObject;
      } while (!"Remotecall_uploadEmoticon".equals(paramBundle.getString("qqcomicemoticonipccmd")));
      localObject = (avdg)((QQAppInterface)localObject).getManager(147);
    } while (localObject == null);
    ((avdg)localObject).a(paramBundle, paramOnInvokeFinishLinstener);
    return null;
  }
  
  public boolean isSynchronized()
  {
    return this.dmc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avdi
 * JD-Core Version:    0.7.0.1
 */