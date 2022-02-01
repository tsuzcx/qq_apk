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
import com.tencent.mobileqq.activity.aio.navigate.TroopDNANavBar.1;
import com.tencent.mobileqq.activity.aio.navigate.TroopDNANavBar.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class xrn
  extends xrg
  implements Animation.AnimationListener
{
  private Animation as;
  private ImageView bd;
  
  public xrn(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    super(paramBaseChatPie, paramQQAppInterface, paramContext, paramSessionInfo, paramInt1, paramInt2);
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
        return "troop_dna_aio_guide_counts";
      }
    }
    return "troop_dna_aio_guide_counts" + ((QQAppInterface)localObject).getCurrentAccountUin();
  }
  
  public long getDuration()
  {
    return 15000L;
  }
  
  public View getView()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2131561207, null);
    this.bd = ((ImageView)localView.findViewById(2131362987));
    return localView;
  }
  
  public boolean needShow()
  {
    boolean bool1 = true;
    boolean bool2 = ajkq.a(this.c.app).nr(this.c.sessionInfo.troopUin);
    if ((this.c == null) || (this.c.a == null))
    {
      QLog.d("NavigateBarManager.TroopDNANavBar", 1, "mChatPie == null || mChatPie.mChatDrawer == null");
      bool1 = false;
    }
    int i;
    do
    {
      return bool1;
      i = PreferenceManager.getDefaultSharedPreferences(this.mContext).getInt(j(this.mApp), 0);
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager.TroopDNANavBar", 2, String.format("needShow guide count: %s", new Object[] { Integer.valueOf(i) }));
      }
    } while ((bool2) && (i < 3));
    return false;
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
    if ((this.c != null) && (this.c.a != null)) {
      this.c.a.yY(true);
    }
    anot.a(null, "dc00898", "", "", "0X800A469", "0X800A469", 0, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    this.bd.clearAnimation();
  }
  
  public void onHide() {}
  
  public void onShow()
  {
    this.bd.postDelayed(new TroopDNANavBar.1(this), 500L);
    ThreadManager.postImmediately(new TroopDNANavBar.2(this), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrn
 * JD-Core Version:    0.7.0.1
 */