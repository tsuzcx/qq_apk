package cooperation.qqpim;

import acfp;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Window;
import arhz;
import aurf;
import avlg;
import avlh;
import avli;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Iterator;
import java.util.List;

public class QQPimBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public static long azC;
  private arhz W;
  QQPimPluginLoadRunnable.a jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a = new avlh(this);
  private QQPimPluginLoadRunnable jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable;
  private aurf b;
  
  public static boolean cL(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:tool".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167595);
    if (System.currentTimeMillis() - azC < 800L)
    {
      finish();
      return true;
    }
    this.b = new aurf(this);
    azC = System.currentTimeMillis();
    this.W = new arhz(this, super.getResources().getDimensionPixelSize(2131299627));
    this.W.setMessage(acfp.m(2131712028));
    this.W.setCanceledOnTouchOutside(false);
    this.W.setOnDismissListener(new avlg(this));
    if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable != null) {
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable.stop();
    }
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = new QQPimPluginLoadRunnable(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a);
    ThreadManager.postImmediately(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.W != null) && (this.W.isShowing()))
    {
      this.W.dismiss();
      this.W = null;
    }
    sTopActivity = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramMessage.what)
    {
    }
    Bundle localBundle;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while ((isFinishing()) || (this.W == null));
          this.W.setMessage(acfp.m(2131712030));
          this.W.show();
          return false;
        } while (isFinishing());
        int i = paramMessage.arg1;
        int j = super.getResources().getDimensionPixelSize(2131299627);
        paramMessage = acfp.m(2131712031);
        if (-4 == i) {
          paramMessage = acfp.m(2131712032);
        }
        for (;;)
        {
          QQToast.a(this.app.getApp(), 1, paramMessage, 0).show(j);
          finish();
          return false;
          if ((-5 == i) || (-1 == i) || (-3 == i) || (-2 == i)) {
            paramMessage = acfp.m(2131712027);
          } else if (-6 == i) {
            paramMessage = acfp.m(2131712029);
          }
        }
      } while (isFinishing());
      localBundle = getIntent().getExtras();
      if (avli.cLO.equals(localBundle.getString(avli.cLU)))
      {
        paramMessage = localObject1;
        if (!cL(getApplicationContext())) {
          paramMessage = this.W;
        }
        QQPimPluginProxyActivity.a(this, localBundle, paramMessage);
        finish();
        return false;
      }
    } while (!avli.cLP.equals(localBundle.getString(avli.cLU)));
    paramMessage = localObject2;
    if (!cL(getApplicationContext())) {
      paramMessage = this.W;
    }
    QQPimPluginProxyActivity.b(this, localBundle, paramMessage);
    finish();
    return false;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqpim.QQPimBridgeActivity
 * JD-Core Version:    0.7.0.1
 */