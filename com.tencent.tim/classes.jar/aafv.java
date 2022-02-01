import Wallet.AcsMsg;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper.ConvertParam;
import com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils.2;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.microapp.apkg.AppInfo;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.SoLoadInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class aafv
{
  public static void Ch(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 10);
    localBundle.putBoolean("req_param", paramBoolean);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static boolean Wi()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("oper_type", 9);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "ComIPCUtils", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess()) && (((EIPCResult)localObject).data != null)) {
      return ((EIPCResult)localObject).data.getBoolean("res");
    }
    return false;
  }
  
  @NonNull
  public static SoLoadInfo a(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 17);
    localBundle.putBoolean("is_sync", true);
    localBundle.putSerializable("load_param", paramLoadParam);
    localBundle.putSerializable("load_item", paramLoadItem);
    paramLoadParam = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "ComIPCUtils", localBundle);
    if ((paramLoadParam != null) && (paramLoadParam.isSuccess()) && (paramLoadParam.data != null)) {
      try
      {
        paramLoadItem = (SoLoadInfo)paramLoadParam.data.getSerializable("res");
        paramLoadParam = paramLoadItem;
        if (paramLoadItem == null) {
          paramLoadParam = SoLoadInfo.sDefault;
        }
        return paramLoadParam;
      }
      catch (Throwable paramLoadParam)
      {
        QLog.e("SoLoadWidget.IPC", 1, paramLoadParam, new Object[0]);
      }
    }
    return SoLoadInfo.sDefault;
  }
  
  public static void a(int paramInt, MiniAppConfig paramMiniAppConfig)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 5);
    localBundle.putInt("action", paramInt);
    localBundle.putSerializable("req_param", paramMiniAppConfig);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void a(EmojiGifHelper.ConvertParam paramConvertParam, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 7);
    localBundle.putSerializable("req_param", paramConvertParam);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, paramEIPCResultCallback);
  }
  
  public static void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 4);
    localBundle.putSerializable("req_param", paramStartCheckParam);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void a(LaunchParam paramLaunchParam, int paramInt, OnUpdateListener paramOnUpdateListener)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 2);
    localBundle.putSerializable("mini_launch_param", paramLaunchParam);
    localBundle.putInt("version", paramInt);
    localBundle.putParcelable("receiver", aacm.a(new ComIPCUtils.2(null, paramOnUpdateListener)));
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void a(LaunchParam paramLaunchParam, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 1);
    localBundle.putSerializable("mini_launch_param", paramLaunchParam);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, paramEIPCResultCallback);
  }
  
  public static void a(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem, anly paramanly)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 17);
    localBundle.putBoolean("is_sync", false);
    localBundle.putSerializable("load_param", paramLoadParam);
    localBundle.putSerializable("load_item", paramLoadItem);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, new aafw(paramanly));
  }
  
  public static void g(AcsMsg paramAcsMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 11);
    localBundle.putSerializable("req_param", paramAcsMsg);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void h(AcsMsg paramAcsMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 12);
    localBundle.putSerializable("req_param", paramAcsMsg);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void i(AcsMsg paramAcsMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 13);
    localBundle.putSerializable("req_param", paramAcsMsg);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static String ie(String paramString)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("oper_type", 0);
    ((Bundle)localObject).putString("uin", paramString);
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "ComIPCUtils", (Bundle)localObject);
    localObject = paramString;
    if (localEIPCResult != null)
    {
      localObject = paramString;
      if (localEIPCResult.isSuccess())
      {
        localObject = paramString;
        if (localEIPCResult.data != null) {
          localObject = localEIPCResult.data.getString("res");
        }
      }
    }
    return localObject;
  }
  
  public static void recordAppStart(AppInfo paramAppInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 3);
    localBundle.putSerializable("req_param", paramAppInfo);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void removeTask(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 8);
    localBundle.putInt("req_id", paramInt);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aafv
 * JD-Core Version:    0.7.0.1
 */