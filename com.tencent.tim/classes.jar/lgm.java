import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.net.URLDecoder;

public class lgm
  extends QIPCModule
{
  private static volatile lgm a;
  
  private lgm(String paramString)
  {
    super(paramString);
  }
  
  public static lgm a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new lgm("ReadInJoyIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  private void ax(Bundle paramBundle)
  {
    int i = paramBundle.getInt("key_native_channel_id", 0);
    int j = paramBundle.getInt("key_native_channel_change_order", 0);
    String str = paramBundle.getString("key_native_channel_name", "");
    int k = paramBundle.getInt("key_native_channel_type", 0);
    boolean bool = paramBundle.getBoolean("key_native_channel_is_push", false);
    int m = paramBundle.getInt("key_channel_source_from", -1);
    Object localObject = paramBundle.getString("key_channel_jump_scheme", "");
    QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel] native channel jump, channelID = " + i + ", changeChannelOrder = " + j + ", channelName = " + str + ", channelType = " + k + ", isPush = " + bool + ", sourceFrom = " + m + ", scheme = " + (String)localObject);
    if (j == 1) {
      lbz.a().cF(i, m);
    }
    if (BaseActivity.sTopActivity == null) {}
    for (paramBundle = BaseApplicationImpl.getContext(); paramBundle == null; paramBundle = BaseActivity.sTopActivity)
    {
      QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel], context is null.");
      return;
    }
    if (lfy.G(paramBundle, (String)localObject))
    {
      QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel], jump to recommend channel, using floating window.");
      return;
    }
    if (bool) {}
    for (localObject = "1"; lfw.l((String)localObject, i); localObject = "0")
    {
      kgw.a(paramBundle, i, str, k, 4);
      return;
    }
    localObject = kgw.b(paramBundle, 0, i);
    if (!(paramBundle instanceof BaseActivity)) {
      ((Intent)localObject).setFlags(268435456);
    }
    paramBundle.startActivity((Intent)localObject);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = true;
    if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      QLog.i("ReadInJoyIPCModule", 1, "[onCall], runtime is not QQAppInterface.");
    }
    label222:
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
            if (!"action_native_channel_jump".equals(paramString)) {
              break;
            }
          } while (paramBundle == null);
          ax(paramBundle);
          return null;
          if (!"action_viola_fragment_jump".equals(paramString)) {
            break;
          }
        } while (paramBundle == null);
        String str = paramBundle.getString("key_viola_fragment_jump_url", "");
        paramInt = paramBundle.getInt("key_native_channel_id", 0);
        if (lfw.l(Uri.parse(str).getQueryParameter("ispush"), paramInt)) {
          try
          {
            if (str.contains("v_url_base64")) {}
            for (paramString = aqhv.toBase64Decode(Uri.parse(str).getQueryParameter("v_url_base64"));; paramString = URLDecoder.decode(Uri.parse(str).getQueryParameter("v_url"), "utf-8"))
            {
              ntp.b(BaseActivity.sTopActivity, null, paramString, null);
              return null;
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              QLog.e("ReadInJoyIPCModule", 1, "call viola page error = " + paramString.getMessage());
              paramString = null;
            }
          }
        }
        paramInt = paramBundle.getInt("key_native_channel_change_order", 0);
        if (BaseActivity.sTopActivity == null)
        {
          paramString = BaseApplicationImpl.getContext();
          if (paramInt != 1) {
            break label222;
          }
        }
        for (;;)
        {
          lfw.a(paramString, str, bool);
          return null;
          paramString = BaseActivity.sTopActivity;
          break;
          bool = false;
        }
        if ("action_update_biu_and_comment_switch_action".equals(paramString))
        {
          bool = kqc.Al();
          paramString = new Bundle();
          paramString.putBoolean("action_update_biu_and_comment_switch", bool);
          callbackResult(paramInt, EIPCResult.createResult(0, paramString));
          return null;
        }
      } while (!"action_update_biu_and_comment_request_action".equals(paramString));
      paramString = (Intent)paramBundle.getParcelable("action_update_biu_and_comment_request");
    } while (paramString == null);
    paramBundle = new kqd();
    UiApiPlugin.a(paramString, paramBundle, paramString.getStringExtra("arg_callback"), new lgn(this, paramInt, paramBundle));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgm
 * JD-Core Version:    0.7.0.1
 */