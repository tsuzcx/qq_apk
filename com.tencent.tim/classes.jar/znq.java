import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.widget.immersive.ImmersiveUtils;

public class znq
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, View.OnTouchListener, IMiniMsgUnreadCallback
{
  private znt a;
  ValueAnimator ai;
  private int cdK;
  private int cdL;
  private int cdM;
  private int cdN;
  private int cdO;
  private int cdP;
  private int cdQ;
  private int cdR;
  private int cdS;
  private int cdT;
  private WindowManager.LayoutParams e;
  private View.OnClickListener eC;
  private Activity mActivity;
  private View mContentView;
  private final GestureDetector mGestureDetector;
  private boolean mIsAttached;
  private int mOffsetX;
  private int mScreenWidth;
  private int mStatusBarHeight;
  private float mTouchX;
  private float mTouchY;
  private WindowManager mWindowManager;
  
  public znq(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, View.OnClickListener paramOnClickListener)
  {
    this.mActivity = paramActivity;
    this.cdM = paramInt1;
    this.cdN = paramInt2;
    this.cdT = paramInt3;
    this.cdR = paramInt4;
    this.cdS = paramInt5;
    this.mStatusBarHeight = ImmersiveUtils.getStatusBarHeight(this.mActivity);
    paramActivity = BaseApplicationImpl.getApplication().getBaseContext();
    paramInt1 = paramActivity.getResources().getDisplayMetrics().widthPixels;
    paramInt3 = paramActivity.getResources().getDisplayMetrics().heightPixels;
    int i = paramActivity.getResources().getDimensionPixelSize(2131297713);
    int j = paramActivity.getResources().getDimensionPixelSize(2131297714);
    int m = paramActivity.getResources().getDimensionPixelSize(2131297712);
    int k = aqnm.dpToPx(56.0F);
    this.mScreenWidth = paramInt1;
    this.mOffsetX = i;
    this.cdQ = (paramInt3 - m);
    m = this.mStatusBarHeight;
    int n = aqnm.dip2px(7.0F);
    int i1 = this.mOffsetX;
    if (paramInt4 != -1)
    {
      this.cdK = paramInt4;
      this.cdL = paramInt5;
    }
    for (;;)
    {
      this.eC = paramOnClickListener;
      this.mGestureDetector = new GestureDetector(paramActivity, new znr(this));
      this.a = znu.a();
      if (this.a == null) {
        this.a = new znt();
      }
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("mini_msg_FloatViewManager", 0, "configData : " + this.a.toString());
      }
      return;
      if (paramInt2 != 0)
      {
        this.cdK = (paramInt1 - i * 4);
        this.cdL = (m + n);
      }
      else
      {
        this.cdK = (paramInt1 - k - i1);
        this.cdL = (paramInt3 - j);
      }
    }
  }
  
  private void cpV()
  {
    if (this.ai == null)
    {
      this.ai = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.ai.setDuration(200L);
      this.ai.addListener(this);
      this.ai.addUpdateListener(this);
    }
    this.ai.start();
  }
  
  public int[] L()
  {
    Object localObject;
    if (this.e == null) {
      localObject = null;
    }
    int[] arrayOfInt;
    do
    {
      return localObject;
      arrayOfInt = new int[2];
      localObject = arrayOfInt;
    } while (this.e == null);
    arrayOfInt[0] = this.e.x;
    arrayOfInt[1] = this.e.y;
    return arrayOfInt;
  }
  
  public void destroy()
  {
    if (this.mIsAttached)
    {
      this.mWindowManager.removeViewImmediate(this.mContentView);
      this.mIsAttached = false;
    }
    this.mActivity = null;
    this.mContentView = null;
  }
  
  public void hide()
  {
    if (this.mIsAttached) {
      this.mContentView.setVisibility(8);
    }
  }
  
  public void hideUnread()
  {
    if (this.mIsAttached) {
      this.mContentView.findViewById(2131371723).setVisibility(8);
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = this.cdK;
    if (this.cdO < this.mScreenWidth / 2) {
      i = this.mOffsetX;
    }
    int j = this.cdO;
    i = (int)((i - this.cdO) * f) + j;
    com.tencent.TMG.utils.QLog.d("mini_msg_FloatViewManager", 0, "onAnimationUpdate .curPx = " + i + " ,mTouchUpX = " + this.cdO);
    j = this.cdP;
    s(this.mContentView, i, j);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = 0;
    if ((this.ai != null) && (this.ai.isRunning())) {
      return false;
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = this.mGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.cdN != 0) {
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      if ((!bool) && (i != 0)) {
        cpV();
      }
      return true;
      this.mTouchX = paramMotionEvent.getX();
      this.mTouchY = paramMotionEvent.getY();
      continue;
      s(paramView, (int)(f1 - this.mTouchX), (int)(f2 - this.mTouchY));
      continue;
      s(paramView, (int)(f1 - this.mTouchX), (int)(f2 - this.mTouchY));
      this.cdO = ((int)(f1 - this.mTouchX));
      this.cdP = ((int)(f2 - this.mTouchY));
      this.mTouchY = 0.0F;
      this.mTouchX = 0.0F;
      i = 1;
    }
  }
  
  public void s(View paramView, int paramInt1, int paramInt2)
  {
    if (!this.mIsAttached) {
      return;
    }
    int i = paramInt2;
    if (paramInt2 < this.mStatusBarHeight) {
      i = this.mStatusBarHeight;
    }
    int j = i;
    if (i > this.cdQ) {
      j = this.cdQ;
    }
    paramInt2 = paramInt1;
    if (paramInt1 < this.mOffsetX) {
      paramInt2 = this.mOffsetX;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > this.cdK) {
      paramInt1 = this.cdK;
    }
    this.e.y = j;
    this.e.x = paramInt1;
    this.mWindowManager.updateViewLayout(paramView, this.e);
  }
  
  public boolean show(int paramInt)
  {
    if (!this.mActivity.hasWindowFocus()) {
      return false;
    }
    Activity localActivity = this.mActivity;
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("mini_msg_FloatViewManager", 2, "styleType = " + this.cdN + ",filterType = " + this.cdM);
    }
    if (this.mContentView == null)
    {
      this.mContentView = View.inflate(localActivity.getApplicationContext(), 2131559610, null);
      this.mContentView.setOnTouchListener(this);
      Object localObject2 = (RelativeLayout)this.mContentView.findViewById(2131371721);
      ImageView localImageView = (ImageView)this.mContentView.findViewById(2131371722);
      Object localObject1 = (TextView)this.mContentView.findViewById(2131371723);
      localObject2 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      localObject1 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      if (this.cdN != 0)
      {
        i = aqnm.dpToPx(38.0F);
        j = aqnm.dpToPx(32.0F);
        ((RelativeLayout.LayoutParams)localObject2).width = i;
        ((RelativeLayout.LayoutParams)localObject2).height = j;
        i = aqnm.dpToPx(24.0F);
        localLayoutParams.width = i;
        localLayoutParams.height = i;
        localLayoutParams.leftMargin = aqnm.dpToPx(4.0F);
        localImageView.setPadding(0, 0, 0, 0);
        localImageView.setBackgroundDrawable(null);
        localImageView.setImageResource(2130841861);
        if (this.cdT != 1) {
          localImageView.setImageResource(2130841861);
        }
      }
      if (AppSetting.enableTalkBack) {
        aqcl.R(this.mContentView, false);
      }
      this.mWindowManager = ((WindowManager)localActivity.getApplicationContext().getSystemService("window"));
      this.e = new WindowManager.LayoutParams();
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("mini_msg_FloatViewManager", 0, "is activity window focused " + localActivity.hasWindowFocus());
      }
      int i = localActivity.getResources().getDisplayMetrics().heightPixels;
      if ((this.cdR != -1) && (this.cdN != 0) && (this.cdS == -1) && (ankt.isNavigationBarExist(localActivity))) {
        this.cdL = (i - localActivity.getResources().getDimensionPixelSize(2131297714) - ankt.getNavigationBarHeight(localActivity));
      }
      i = this.cdK;
      int j = this.cdL;
      this.e.type = 1002;
      this.e.format = 1;
      this.e.flags = 40;
      this.e.gravity = 51;
      this.e.x = i;
      this.e.y = j;
      this.e.width = -2;
      this.e.height = -2;
      this.e.token = localActivity.getWindow().getDecorView().getWindowToken();
      this.mWindowManager.addView(this.mContentView, this.e);
      this.mIsAttached = true;
    }
    if (this.mIsAttached) {
      this.mContentView.setVisibility(0);
    }
    if (!this.a.brK) {
      this.mContentView.setVisibility(8);
    }
    updateUnreadCount(paramInt, false);
    return this.mIsAttached;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle) {}
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    if (this.mIsAttached)
    {
      if (this.a.brK) {
        this.mContentView.setVisibility(0);
      }
      TextView localTextView = (TextView)this.mContentView.findViewById(2131371723);
      String str = String.valueOf(paramInt);
      if (paramInt > 99) {
        str = "99+";
      }
      localTextView.setText(str);
      if ((!paramBoolean) && (paramInt > 0)) {
        localTextView.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     znq
 * JD-Core Version:    0.7.0.1
 */