import android.app.Activity;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.a;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

public class abjo
  implements Handler.Callback, ApolloCmdChannel.a
{
  protected auru e = new auru(Looper.getMainLooper(), this);
  WeakReference<Activity> mActivityRef;
  private WeakReference<QQAppInterface> mAppRef;
  
  public abjo(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.mActivityRef = new WeakReference(paramActivity);
    this.mAppRef = new WeakReference(paramQQAppInterface);
  }
  
  public abjp a(long paramLong, String paramString1, String paramString2)
  {
    if (this.mAppRef == null) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.mAppRef.get();
    if (localQQAppInterface == null) {
      return null;
    }
    if ("general_cmd_ui_show_toast".equals(paramString1)) {
      return a(paramString2);
    }
    if ("cs.get_dress_path.local".equals(paramString1))
    {
      abxt.a(paramLong, localQQAppInterface, paramString1, paramString2);
      return new abjp();
    }
    if ("cs.report_data_2_compass.local".equals(paramString1))
    {
      abxt.c(localQQAppInterface, paramString2);
      return new abjp();
    }
    if ("cs.report_data_2_backstage.local".equals(paramString1))
    {
      abxt.J(localQQAppInterface, paramString2);
      return new abjp();
    }
    if ("cs.report_flow_data.local".equals(paramString1))
    {
      abxt.K(localQQAppInterface, paramString2);
      return new abjp();
    }
    if ("cs.encrypt_data.local".equals(paramString1))
    {
      abxt.b(paramLong, localQQAppInterface, paramString2);
      return new abjp();
    }
    if ("cs.decrypt_data.local".equals(paramString1))
    {
      abxt.c(paramLong, localQQAppInterface, paramString2);
      return new abjp();
    }
    if ("cs.get_server_ip_port.local".equals(paramString1))
    {
      abxt.b(paramLong, localQQAppInterface, paramString1, paramString2);
      return new abjp();
    }
    if ("cs.save_recommend_ip.local".equals(paramString1))
    {
      abxt.I(localQQAppInterface, paramString2);
      return new abjp();
    }
    if ("cs.apolloGameWebMessage.local".equals(paramString1))
    {
      abxt.CY(paramString2);
      return new abjp();
    }
    if ("cs.openFloatTransparentView.local".equals(paramString1))
    {
      if (this.mActivityRef.get() != null)
      {
        abxt.bq((Context)this.mActivityRef.get(), paramString2);
        return new abjp();
      }
    }
    else if ("cs.openWebView.local".equals(paramString1))
    {
      if (this.mActivityRef.get() != null)
      {
        abxt.br((Context)this.mActivityRef.get(), paramString2);
        return new abjp();
      }
    }
    else
    {
      if ("cs.script_get_nickname.local".equals(paramString1))
      {
        QQMessageFacade localQQMessageFacade = localQQAppInterface.b();
        int j = -1;
        String str = "";
        paramString1 = str;
        int i = j;
        if (localQQMessageFacade != null)
        {
          paramString1 = str;
          i = j;
          if (localQQMessageFacade.Op())
          {
            paramString1 = str;
            i = j;
            if (!TextUtils.isEmpty(localQQMessageFacade.oA()))
            {
              paramString1 = localQQMessageFacade.oA();
              i = localQQMessageFacade.vc();
            }
          }
        }
        return abrj.a(paramString2, localQQAppInterface, i, paramString1);
      }
      if ("cs.script_get_action_data.local".equals(paramString1))
      {
        ApolloGameUtil.d(paramLong, localQQAppInterface, paramString2);
        return null;
      }
    }
    return null;
  }
  
  public abjp a(String paramString)
  {
    abjp localabjp = new abjp();
    String str = ApolloUtil.aI(paramString, "tips");
    int i = ApolloUtil.z(paramString, "length");
    if (TextUtils.isEmpty(str)) {
      return localabjp;
    }
    paramString = this.e.obtainMessage(255);
    paramString.obj = str;
    paramString.arg1 = i;
    paramString.sendToTarget();
    return localabjp;
  }
  
  public void destroyHandler()
  {
    this.e.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 1;
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while (!(paramMessage.obj instanceof String));
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    CharSequence localCharSequence = (CharSequence)paramMessage.obj;
    if (paramMessage.arg1 == 1) {}
    for (;;)
    {
      QQToast.a(localBaseApplication, localCharSequence, i).show();
      return false;
      i = 0;
    }
  }
  
  public boolean q(Activity paramActivity)
  {
    return true;
  }
  
  public int zz()
  {
    return 100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abjo
 * JD-Core Version:    0.7.0.1
 */