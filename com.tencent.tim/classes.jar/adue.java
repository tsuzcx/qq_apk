import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import mqq.app.Constants.LogoutReason;

public class adue
  implements Handler.Callback
{
  public Animator.AnimatorListener a;
  public ValueAnimator a;
  public Conversation a;
  public ARMapHongBaoListView a;
  public String aMB;
  public boolean aTW;
  public boolean aVo;
  public ValueAnimator b;
  public boolean bQM;
  public boolean bQN;
  public boolean bQO;
  public boolean bQP;
  public int cJY;
  public ViewGroup e;
  public Interpolator mInterpolator;
  public Handler mUIHandler;
  public ImageView ym;
  
  @TargetApi(11)
  private void b(View paramView1, View paramView2, View paramView3)
  {
    if (!this.bQP) {
      i(paramView2, paramView1);
    }
    if (this.cJY <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.mInterpolator);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new adui(this, paramView2, paramView1, paramView3));
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new aduj(this, paramView3);
    }
    if ((this.b != null) && (this.b.isRunning()))
    {
      this.b.cancel();
      this.b.removeAllListeners();
    }
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  private void i(View paramView1, View paramView2)
  {
    this.cJY = (((RelativeLayout.LayoutParams)paramView2.getLayoutParams()).topMargin + paramView2.getHeight());
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.addRule(3, 0);
    paramView2.topMargin = this.cJY;
    paramView1.setLayoutParams(paramView2);
    this.bQP = true;
  }
  
  @TargetApi(11)
  public void GJ(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "showTitle  direct=" + paramBoolean + "  mTitleIsVisible:" + this.bQN + "  mTitleBarOffset:" + this.cJY);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null) {}
    View localView1;
    View localView2;
    View localView3;
    do
    {
      do
      {
        return;
        localView1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aJ();
        localView2 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aL();
        localView3 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aK();
        if ((localView1 != null) && (localView2 != null) && (localView3 != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ConversationPullDownActiveBase", 2, "showTitle  exit title:" + localView1 + "  head:" + localView2 + "  container:" + localView3);
      return;
      if (paramBoolean)
      {
        if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
        {
          this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
          this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
        }
        if ((this.b != null) && (this.b.isRunning()))
        {
          this.b.removeAllListeners();
          this.b.cancel();
        }
        resetTitle();
        this.bQN = true;
        return;
      }
      if (!this.bQN) {
        break;
      }
    } while ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null) || (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()) || (((RelativeLayout.LayoutParams)localView1.getLayoutParams()).topMargin == 0));
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "showTitle catch a display exception");
    }
    resetTitle();
    return;
    this.bQN = true;
    b(localView1, localView3, localView2);
  }
  
  public void Lx(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "springBackPromptly, offset=" + paramInt);
    }
    this.mUIHandler.removeMessages(1003);
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setSelection(0);
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setSpringbackOffset(paramInt);
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.springBackTo(this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.etw);
  }
  
  public void Ly(int paramInt) {}
  
  public void Lz(int paramInt) {}
  
  public boolean afA()
  {
    return false;
  }
  
  public boolean afB()
  {
    return false;
  }
  
  public void bMe()
  {
    if (!afA()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "onBeforeAccountChanged");
    }
    cUr();
  }
  
  public void cUr() {}
  
  public void cUs()
  {
    this.mUIHandler.removeMessages(1002);
    this.mUIHandler.sendEmptyMessageDelayed(1002, 800L);
  }
  
  public void cUt()
  {
    if (this.ym == null) {
      this.ym = ((ImageView)this.e.findViewById(2131368597));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "stopGestureGuide");
    }
    this.mUIHandler.removeMessages(1001);
    this.ym.clearAnimation();
    this.ym.setVisibility(8);
  }
  
  public void cUu()
  {
    if (this.ym == null) {
      this.ym = ((ImageView)this.e.findViewById(2131368597));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "doGestureGuide  this=" + this);
    }
    AnimationSet localAnimationSet = new AnimationSet(false);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setStartOffset(1L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setAnimationListener(new aduf(this));
    int i = (int)this.e.getResources().getDimension(2131298659);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, -this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.ON(), 0, i + -this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.ON());
    localTranslateAnimation.setDuration(1500L);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new adug(this));
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setAnimationListener(new aduh(this));
    localAnimationSet.addAnimation(localAlphaAnimation);
    this.ym.startAnimation(localAnimationSet);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1001: 
      cUt();
      cUu();
      return false;
    case 1002: 
      onResume();
      return false;
    }
    int j = paramMessage.arg1;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Lx(i);
    return false;
  }
  
  public void onDestroy()
  {
    if (!afA()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ConversationPullDownActiveBase", 2, "onDestroy");
      }
      cUr();
    } while (this.mUIHandler == null);
    this.mUIHandler.removeCallbacksAndMessages(null);
  }
  
  public void onDrawerOpened()
  {
    if (!afA()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "onDrawerOpened");
    }
    GJ(true);
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (!afA()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "onLogout");
    }
    cUr();
  }
  
  public void onNetStateChanged(boolean paramBoolean)
  {
    try
    {
      if (!afA()) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConversationPullDownActiveBase", 2, "onNetStateChanged, isNetSupport=" + paramBoolean);
      }
      this.bQM = paramBoolean;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("ConversationPullDownActiveBase", 2, "onNetStateChanged error" + localThrowable.getMessage());
    }
  }
  
  public void onPause()
  {
    this.aTW = false;
    this.mUIHandler.removeMessages(1002);
  }
  
  public void onPostThemeChanged() {}
  
  public void onResume()
  {
    this.aTW = true;
  }
  
  public void onStop() {}
  
  @TargetApi(11)
  public void resetTitle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "resetTitle  mTitleIsVisible:" + this.bQN + "  mTitleBarOffset:" + this.cJY);
    }
    View localView1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aJ();
    View localView2 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aL();
    if ((localView1 == null) || (localView2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConversationPullDownActiveBase", 2, "resetTitle exit title:" + localView1 + "  head:" + localView2);
      }
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
    localLayoutParams.topMargin = 0;
    localView1.setLayoutParams(localLayoutParams);
    if (this.bQO) {
      localView2.setAlpha(1.0F);
    }
    localView2.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adue
 * JD-Core Version:    0.7.0.1
 */