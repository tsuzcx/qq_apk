import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;

public class avda
  extends RemoteCommand
{
  private static Bundle bJ;
  boolean dmc;
  
  public avda(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.dmc = paramBoolean;
  }
  
  private boolean ah(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (acja)paramQQAppInterface.getManager(56);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.b(paramString) != null;
    }
    return false;
  }
  
  private void bo(QQAppInterface paramQQAppInterface, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(268435456);
    ocp.a(localIntent, paramQQAppInterface, BaseApplication.getContext(), paramString, -1);
  }
  
  public static void eN(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = PluginCommunicationHandler.getInstance();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.register(new avda("cacomicetinfo", true));
    }
  }
  
  private Bundle m(Bundle paramBundle)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicRemoteCommand", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    localObject = (QQAppInterface)localObject;
    String str = paramBundle.getString("cacomicetinfo");
    if ("Remotecall_getPublicAccountState".equals(str))
    {
      paramBundle = paramBundle.getString("uin");
      if (!TextUtils.isEmpty(paramBundle))
      {
        boolean bool = ah((QQAppInterface)localObject, paramBundle);
        paramBundle = new Bundle();
        paramBundle.putBoolean("state", bool);
        return paramBundle;
      }
    }
    else
    {
      if (!"Remotecall_showPublicAccountDetail".equals(str)) {
        break label123;
      }
      paramBundle = paramBundle.getString("uin");
      if (!TextUtils.isEmpty(paramBundle)) {
        bo((QQAppInterface)localObject, paramBundle);
      }
    }
    for (;;)
    {
      return null;
      label123:
      if ("Remotecall_getUserStatus".equals(str))
      {
        paramBundle = new Bundle();
        if (VipUtils.ce((QQAppInterface)localObject)) {
          paramBundle.putInt("userStatus", 3);
        }
        for (;;)
        {
          return paramBundle;
          if (VipUtils.cf((QQAppInterface)localObject)) {
            paramBundle.putInt("userStatus", 2);
          } else {
            paramBundle.putInt("userStatus", 1);
          }
        }
      }
      if ("Remotecall_initQbPlugin".equals(str)) {
        try
        {
          QWalletHelper.preloadQWallet((AppInterface)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("VipComicRemoteCommand", 2, "preloadQWallet()");
          }
          paramBundle = new Bundle();
          paramBundle.putBoolean("success", true);
          return paramBundle;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
      } else if ("Remotecall_showComicBar".equals(str))
      {
        if (((QQAppInterface)localObject).getHandler(Conversation.class) != null) {
          n(paramBundle);
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("VipComicRemoteCommand", 2, "onRemoteInvoke unknow invokeCmd");
      }
    }
  }
  
  public static Bundle n(Bundle paramBundle)
  {
    try
    {
      Bundle localBundle = bJ;
      bJ = paramBundle;
      return localBundle;
    }
    finally
    {
      paramBundle = finally;
      throw paramBundle;
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramBundle = m(paramBundle);
    if (paramOnInvokeFinishLinstener != null) {
      paramOnInvokeFinishLinstener.onInvokeFinish(paramBundle);
    }
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avda
 * JD-Core Version:    0.7.0.1
 */