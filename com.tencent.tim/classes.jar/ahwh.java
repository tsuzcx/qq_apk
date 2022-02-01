import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.bigbrother.JumpConfirmFragment;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.haoliyou.JefsClass.CancelableRunnable;
import com.tencent.mobileqq.haoliyou.JefsClass.e;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class ahwh
  implements adwv
{
  public ahwh(JefsClass paramJefsClass, WeakReference paramWeakReference, JefsClass.CancelableRunnable paramCancelableRunnable, int paramInt, String paramString) {}
  
  public void c(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = (Context)this.hb.get();
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, String.format(Locale.CHINA, "onReceive: success: %b, jump: %d, err_code: %d, err_msg: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    if (this.a == null) {
      return;
    }
    if (localObject == null)
    {
      adxf.a().hE(this.val$callbackId, -3);
      QLog.i("TeleScreen|JefsClass", 1, "context is null");
      if (this.val$src == null) {}
      for (paramString = "";; paramString = this.val$src)
      {
        anot.a(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, "", "1", paramString, "");
        return;
      }
    }
    if ((paramBoolean) && (paramInt1 == 1))
    {
      JefsClass.a(this.this$0, this.a);
      return;
    }
    if ((!paramBoolean) || (paramInt1 == 0)) {}
    for (;;)
    {
      try
      {
        if (!(localObject instanceof Activity)) {
          break label491;
        }
        paramString = (Activity)localObject;
        if ((paramString == null) || (paramString.isFinishing())) {
          break label317;
        }
        QLog.i("TeleScreen|JefsClass", 1, "leave QQ jump other app , act.isFinishing() == false");
        localObject = aqha.b(paramString, 0, null, "即将离开QQ\n打开其他应用", paramString.getString(2131721058), paramString.getString(2131721897), new ahwi(this), new ahwj(this));
        if ((paramString instanceof BaseActivity))
        {
          ((BaseActivity)paramString).setJumpDialog((Dialog)localObject);
          ((aqju)localObject).show();
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("TeleScreen|JefsClass", 1, paramString, new Object[0]);
        JefsClass.a(this.this$0, this.a);
        return;
      }
      if ((paramString instanceof BasePluginActivity))
      {
        ((BasePluginActivity)paramString).setJumpDialog((Dialog)localObject);
        continue;
        label317:
        if (BaseApplicationImpl.sProcessId != 1)
        {
          if (JefsClass.a(this.this$0) == null) {
            JefsClass.a(this.this$0, new JefsClass.e(this.this$0, null));
          }
          paramString = new IntentFilter("com.tencent.mobileqq.telescreen.action_run");
          paramString.addAction("com.tencent.mobileqq.telescreen.action_remove");
          BaseApplicationImpl.context.registerReceiver(JefsClass.a(this.this$0), paramString);
        }
        paramString = new Intent();
        paramString.putExtra("big_brother_source_key", this.val$src);
        paramString.putExtra("key_id", JefsClass.a(this.this$0, this.a));
        paramString.putExtra("key_process_id", BaseApplicationImpl.processName);
        paramString.putExtra("key_callback_id", this.val$callbackId);
        paramString.putExtra("public_fragment_window_feature", 1);
        PublicFragmentActivity.b.a(paramString, PublicTransFragmentActivity.class, JumpConfirmFragment.class);
        QLog.i("TeleScreen|JefsClass", 1, "leave QQ jump other app , act == null && act.isFinishing() == true");
        return;
        adxf.a().hE(this.val$callbackId, -2);
        return;
        label491:
        paramString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahwh
 * JD-Core Version:    0.7.0.1
 */