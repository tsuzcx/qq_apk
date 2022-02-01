import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.navigate.IntimateInfoNavBar.1;
import com.tencent.mobileqq.activity.aio.navigate.IntimateInfoNavBar.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class xrf
  extends xrg
  implements Animation.AnimationListener
{
  private Animation as;
  private ImageView bd;
  
  public xrf(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    super(paramBaseChatPie, paramQQAppInterface, paramContext, paramSessionInfo, paramInt1, paramInt2);
  }
  
  public long getDuration()
  {
    return 15000L;
  }
  
  public View getView()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2131561191, null);
    this.bd = ((ImageView)localView.findViewById(2131362987));
    TextView localTextView = (TextView)localView.findViewById(2131379722);
    return localView;
  }
  
  public boolean needShow()
  {
    if ((this.c == null) || (this.c.a == null)) {
      QLog.d("NavigateBarManager.IntimateInfoNavBar", 1, "mChatPie == null || mChatPie.mChatDrawer == null");
    }
    ExtensionInfo localExtensionInfo;
    do
    {
      return false;
      localExtensionInfo = ((acff)this.mApp.getManager(51)).a(this.c.sessionInfo.aTl, false);
    } while ((localExtensionInfo == null) || (localExtensionInfo.intimate_type == 0));
    int i = this.mApp.getApp().getSharedPreferences("IntimateInfo" + this.mApp.getCurrentAccountUin(), 0).getInt("key_aio_score_guide_count", 0);
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager.IntimateInfoNavBar", 2, String.format("needShow score guide count: %s", new Object[] { Integer.valueOf(i) }));
    }
    if (i < 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
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
    if ((this.c != null) && (this.c.a != null)) {
      this.c.a.yY(true);
    }
    anot.a(null, "dc00898", "", "", "0X800A11D", "0X800A11D", 0, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    this.bd.clearAnimation();
  }
  
  public void onHide() {}
  
  public void onShow()
  {
    this.bd.postDelayed(new IntimateInfoNavBar.1(this), 500L);
    ThreadManager.postImmediately(new IntimateInfoNavBar.2(this), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrf
 * JD-Core Version:    0.7.0.1
 */