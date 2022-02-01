import android.app.Activity;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel.a;
import com.tencent.mobileqq.apollo.process.chanel.GeneralEventHandler.1;
import com.tencent.mobileqq.apollo.process.chanel.GeneralEventHandler.2;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class abon
  implements Handler.Callback, CmGameCmdChannel.a
{
  private static long NY;
  protected auru e = new auru(Looper.getMainLooper(), this);
  public WeakReference<Activity> mActivityRef;
  private WeakReference<QQAppInterface> mAppRef;
  private int mGameId;
  
  public abon(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.mActivityRef = new WeakReference(paramActivity);
    this.mAppRef = new WeakReference(paramQQAppInterface);
    this.mGameId = paramInt;
  }
  
  private void Cy(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollochannel_GeneralEventHandler", 2, "startNewGame reqData:" + paramString);
    }
    long l = System.currentTimeMillis();
    if (l - NY < 1000L) {
      QLog.e("apollochannel_GeneralEventHandler", 1, "[startNewGame] current - sLastLaunchGameTime < 1000");
    }
    do
    {
      return;
      NY = l;
    } while (TextUtils.isEmpty(paramString));
    ThreadManagerV2.excute(new GeneralEventHandler.2(this, paramString), 16, null, false);
  }
  
  void Cx(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollochannel_GeneralEventHandler", 2, "openCmAIO reqData:" + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      ThreadManagerV2.excute(new GeneralEventHandler.1(this, paramString), 16, null, false);
    }
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
  
  public abjp a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.mAppRef == null) {
      return null;
    }
    if (this.mGameId != paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_GeneralEventHandler", 2, new Object[] { "not the same gameId, self:", Integer.valueOf(this.mGameId), "cmd gameId:", Integer.valueOf(paramInt2), ",cmd:", paramString1 });
      }
      return new abjp();
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
      abxt.d(localQQAppInterface, paramString1, paramString2, paramInt1);
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
    if ("cs.save_recommend_ip.local".equals(paramString1))
    {
      abxt.I(localQQAppInterface, paramString2);
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
        paramInt2 = -1;
        String str = "";
        paramString1 = str;
        paramInt1 = paramInt2;
        if (localQQMessageFacade != null)
        {
          paramString1 = str;
          paramInt1 = paramInt2;
          if (localQQMessageFacade.Op())
          {
            paramString1 = str;
            paramInt1 = paramInt2;
            if (!TextUtils.isEmpty(localQQMessageFacade.oA()))
            {
              paramString1 = localQQMessageFacade.oA();
              paramInt1 = localQQMessageFacade.vc();
            }
          }
        }
        return abrj.a(paramString2, localQQAppInterface, paramInt1, paramString1);
      }
      if (!"cs.send_game_msg.local".equals(paramString1)) {
        break label403;
      }
      abxt.a(localQQAppInterface, paramString2, (Activity)this.mActivityRef.get());
    }
    for (;;)
    {
      return null;
      label403:
      if ("cs.create_xy.local".equals(paramString1))
      {
        Cy(paramString2);
      }
      else if ("cs.open_cm_aio.local".equals(paramString1))
      {
        Cx(paramString2);
      }
      else if ("cs.show_one_more_page.local".equals(paramString1))
      {
        paramString1 = (abhh)localQQAppInterface.getManager(153);
        if (paramString1 != null) {
          paramString1.a().Ch(paramString2);
        }
      }
    }
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
  
  public int zz()
  {
    return 100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abon
 * JD-Core Version:    0.7.0.1
 */