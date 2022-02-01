import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJMsgBoxPopupStep.1;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class lcx
  extends lcs
{
  private Activity activity;
  
  public lcx(@NotNull lct paramlct, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(paramlct, "RIJMsgBoxPopupStep");
    this.activity = paramActivity;
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString, long paramLong)
  {
    if (paramActivity == null)
    {
      QLog.e("RIJMsgBoxPopupStep", 1, "openMsgBoxPage failed, activity = null");
      return;
    }
    kxm.aik = true;
    paramActivity.getWindow().getDecorView().postDelayed(new RIJMsgBoxPopupStep.1(this, paramActivity, paramInt, paramString), paramLong);
  }
  
  private boolean dD(int paramInt)
  {
    QLog.d("RIJMsgBoxPopupStep", 2, "checkIfShowMsgBoxWithFloatingWindow | launchFrom : " + paramInt);
    if (paramInt != 5) {
      return false;
    }
    Object localObject = ((KandianMergeManager)kxm.getAppRuntime().getManager(162)).a();
    if ((localObject == null) || (((KandianMsgBoxRedPntInfo)localObject).mMsgCnt <= 0))
    {
      QLog.d("RIJMsgBoxPopupStep", 1, "checkIfShowMsgBoxWithFloatingWindow | no msg");
      return false;
    }
    boolean bool = ((Boolean)awit.f("sp_key_kandian_msg_box_show_float_window", Boolean.valueOf(false))).booleanValue();
    QLog.d("RIJMsgBoxPopupStep", 1, "checkIfShowMsgBoxWithFloatingWindow | sp showFloatingWin " + bool);
    localObject = Aladdin.getConfig(262);
    if (localObject != null) {
      if (((AladdinConfig)localObject).getIntegerFromString("kandian_msg_box_popup_window_cfg", 0) == 1)
      {
        bool = true;
        awit.H("sp_key_kandian_msg_box_show_float_window", Boolean.valueOf(bool));
        QLog.d("RIJMsgBoxPopupStep", 1, "checkIfShowMsgBoxWithFloatingWindow | aladdin cfg showFloatingWin " + bool);
      }
    }
    for (;;)
    {
      QLog.d("RIJMsgBoxPopupStep", 1, "checkIfShowMsgBoxWithFloatingWindow | showFloatingWindow " + bool);
      if (bool)
      {
        a(this.activity, 6, "", 0L);
        if (this.activity != null)
        {
          localObject = kxm.a(this.activity);
          if (localObject != null) {
            ((ReadinjoyTabFrame)localObject).oT(32);
          }
        }
      }
      return bool;
      bool = false;
      break;
    }
  }
  
  protected void aKn()
  {
    int i = 1;
    Object localObject = this.activity.getIntent();
    kxm.aik = false;
    boolean bool;
    if (((Intent)localObject).hasExtra("notification_message_id"))
    {
      String str = ((Intent)localObject).getStringExtra("notification_message_id");
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((kxm.nX() == 2) && (kxm.nZ() == 2))
      {
        if (!str.isEmpty()) {
          ((KandianMergeManager)localQQAppInterface.getManager(162)).ap(2, str);
        }
      }
      else
      {
        ((Intent)localObject).removeExtra("notification_message_id");
        if ((kxm.nZ() != 1) && (kxm.nX() == 2)) {
          break label186;
        }
        a(this.activity, 5, str, 200L);
        bool = true;
        label117:
        localObject = new kxm.b().a("uin", localQQAppInterface.getCurrentAccountUin()).a("push_type", Integer.valueOf(9));
        if (bool) {
          i = 3;
        }
        kbp.bp("0X80081DB", ((kxm.b)localObject).a("load_mode", Integer.valueOf(i)).build());
      }
    }
    for (;;)
    {
      nn(bool);
      return;
      QLog.i("RIJMsgBoxPopupStep", 1, "readInJoy lock push, notificationMessageId is empty");
      break;
      label186:
      bool = false;
      break label117;
      bool = false;
    }
  }
  
  protected void aKo()
  {
    int i = this.activity.getIntent().getIntExtra("launch_from", 5);
    if ((((KandianMergeManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(162)).ol() > 0) && (dD(i))) {}
    for (boolean bool = true;; bool = false)
    {
      nn(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcx
 * JD-Core Version:    0.7.0.1
 */