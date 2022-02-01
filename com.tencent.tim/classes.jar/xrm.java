import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar.1;
import com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar.2;
import com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class xrm
  extends xrg
  implements Animation.AnimationListener
{
  private long Jp;
  private Animation as;
  private ImageView bd;
  
  public xrm(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    super(paramBaseChatPie, paramQQAppInterface, paramContext, paramSessionInfo, paramInt1, paramInt2);
    paramBaseChatPie = (TroopManager)this.c.app.getManager(52);
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = paramBaseChatPie.c(this.c.sessionInfo.troopUin);
      if (paramBaseChatPie != null) {
        this.Jp = paramBaseChatPie.dwGroupClassExt;
      }
    }
  }
  
  public static void ceq()
  {
    ThreadManager.postImmediately(new TroopAppShortcutNavBar.3(), null, false);
  }
  
  public static String j(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        paramQQAppInterface = (QQAppInterface)localObject;
      }
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        return "troopapp_shortcut_guide_counts";
      }
    }
    return "troopapp_shortcut_guide_counts" + ((QQAppInterface)localObject).getCurrentAccountUin();
  }
  
  public long getDuration()
  {
    return 15000L;
  }
  
  public View getView()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2131561208, null);
    this.bd = ((ImageView)localView.findViewById(2131362987));
    return localView;
  }
  
  public boolean needShow()
  {
    boolean bool1 = true;
    if ((this.c == null) || (this.c.a == null)) {
      QLog.d("NavigateBarManager.TroopAppShortcutNavBar", 1, "mChatPie == null || mChatPie.mChatDrawer == null");
    }
    boolean bool2;
    do
    {
      return false;
      bool2 = ajkq.a(this.c.app).ns(this.c.sessionInfo.troopUin);
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager.TroopAppShortcutNavBar", 2, String.format("canShowTroopAppShortcut: %s", new Object[] { Boolean.valueOf(bool2) }));
      }
    } while (!bool2);
    int i = PreferenceManager.getDefaultSharedPreferences(this.mContext).getInt(j(this.mApp), 0);
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager.TroopAppShortcutNavBar", 2, String.format("needShow guide count: %s", new Object[] { Integer.valueOf(i) }));
    }
    if (i < 3) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.bd.clearAnimation();
    this.bd.startAnimation(this.as);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick()
  {
    if ((this.c != null) && (this.c.a != null))
    {
      this.c.a.cbw();
      this.c.a.yY(true);
      anot.a(null, "dc00898", "", "", "0X800AD07", "0X800AD07", 0, 0, "", this.c.sessionInfo.troopUin, Long.toString(this.Jp), "");
    }
  }
  
  public void onDestroy()
  {
    this.bd.clearAnimation();
  }
  
  public void onHide() {}
  
  public void onShow()
  {
    anot.a(null, "dc00898", "", "", "0X800AD06", "0X800AD06", 0, 0, "", this.c.sessionInfo.troopUin, Long.toString(this.Jp), "");
    this.bd.postDelayed(new TroopAppShortcutNavBar.1(this), 500L);
    ThreadManager.postImmediately(new TroopAppShortcutNavBar.2(this), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrm
 * JD-Core Version:    0.7.0.1
 */