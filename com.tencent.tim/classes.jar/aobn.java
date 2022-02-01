import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.CloudFileDirBrowserActivity;
import eipc.EIPCResult;

public class aobn
  extends QIPCModule
{
  private static aobn a;
  
  private aobn()
  {
    super("TeamWorkModule");
  }
  
  public static aobn a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aobn();
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeamWorkModule", 2, "[onCall] action = " + paramString + ", params = " + paramBundle + ", callbackId=" + paramInt);
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (!QQAppInterface.class.isInstance(localObject)) {
      if (QLog.isColorLevel()) {
        QLog.e("TeamWorkModule", 2, "[onCall] get app failed.");
      }
    }
    do
    {
      do
      {
        String str1;
        String str2;
        do
        {
          return null;
          if (!"send_to_chat_msg".equals(paramString)) {
            break;
          }
          paramString = anre.a(paramBundle);
          paramInt = paramBundle.getInt("uin_type");
          str1 = paramBundle.getString("to_uin");
          str2 = paramBundle.getString("docs_gray_tips_info_json");
          paramBundle = paramBundle.getString("detail_url");
        } while ((localObject == null) || (paramString == null));
        paramString.mExtraData = "aioPlusPanelTencentDoc";
        aqmf.a((QQAppInterface)localObject, str1, paramInt, paramString, null, str2, paramBundle);
      } while (!(BaseActivity.sTopActivity instanceof CloudFileDirBrowserActivity));
      BaseActivity.sTopActivity.finish();
      return null;
    } while (!"action_download_export_file".equals(paramString));
    boolean bool = paramBundle.getBoolean("isSuccess");
    paramString = paramBundle.getString("docUrl");
    localObject = (aoam)((QQAppInterface)localObject).getBusinessHandler(142);
    if (bool)
    {
      ((aoam)localObject).notifyUI(2, true, new Object[] { paramBundle.getString("url"), paramBundle.getString("fileName"), paramString, paramBundle.getString("cookie") });
      return null;
    }
    ((aoam)localObject).notifyUI(1, true, new Object[] { acfp.m(2131715171), paramString });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aobn
 * JD-Core Version:    0.7.0.1
 */