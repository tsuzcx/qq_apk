package com.tencent.qqmail.fragment.base;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqmail.BaseActivityImpl;
import com.tencent.qqmail.BaseActivityImpl.PageProvider;
import com.tencent.qqmail.BaseActivityImpl.PrivateAccess;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.HashMap;
import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentManager.OnBackStackChangedListener;
import moai.fragment.base.BaseFragment;
import moai.fragment.base.BaseFragment.TransitionConfig;
import moai.fragment.base.BaseFragmentActivity;
import moai.fragment.base.SlideStillAnimation;

public abstract class QMBaseFragment
  extends BaseFragment
  implements BaseActivityImpl.PageProvider
{
  private static final int NO_REQUEST_CODE = -2147483648;
  public static final int RESULT_BACK = 2;
  public static final int RESULT_CANCELED = 0;
  public static final int RESULT_FIRST_USER = 1;
  public static final int RESULT_OK = -1;
  protected static final BaseFragment.TransitionConfig SCALE_TRANSITION_CONFIG = new BaseFragment.TransitionConfig(2130772401, 2130772423, 2130772423, 2130772402);
  protected static final BaseFragment.TransitionConfig SLIDE_TRANSITION_CONFIG;
  private static final String TAG = QMBaseFragment.class.getSimpleName();
  private BaseActivityImpl mBaseActivityImpl;
  private BaseActivityImpl.PrivateAccess mPrivateAccess = new QMBaseFragment.1(this);
  private ViewHolder viewHolder = null;
  
  static
  {
    SLIDE_TRANSITION_CONFIG = new BaseFragment.TransitionConfig(2130772422, 2130772419, 2130772421, 2130772420);
  }
  
  protected QMBaseFragment(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public boolean canDragBack()
  {
    return false;
  }
  
  protected boolean checkGesturePassword()
  {
    return true;
  }
  
  protected boolean checkWelcomePopularize()
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mBaseActivityImpl.dispatchTouchEvent(paramMotionEvent);
  }
  
  public View findViewById(int paramInt)
  {
    return super.findViewById(paramInt);
  }
  
  public BaseActivityImpl getBaseActivityImpl()
  {
    return this.mBaseActivityImpl;
  }
  
  public QMTips getTips()
  {
    return this.mBaseActivityImpl.getTips();
  }
  
  public boolean hideKeyBoard()
  {
    return this.mBaseActivityImpl.hideKeyBoard();
  }
  
  public void initDom(View paramView, Bundle paramBundle)
  {
    initDom(paramView, this.viewHolder, paramBundle);
  }
  
  protected abstract void initDom(View paramView, ViewHolder paramViewHolder, Bundle paramBundle);
  
  public void initTips(QMTips paramQMTips) {}
  
  protected void initTopbar(View paramView) {}
  
  protected abstract View initUI(ViewHolder paramViewHolder);
  
  public boolean isAnimationRunning()
  {
    return false;
  }
  
  protected boolean isLastActivity()
  {
    return QMActivityManager.shareInstance().getActivitySize() <= 1;
  }
  
  public boolean isLastFragment()
  {
    return getBaseFragmentActivity().getSupportFragmentManager().getBackStackEntryCount() == 0;
  }
  
  public boolean isMultiStartAllowed()
  {
    return false;
  }
  
  public boolean isPage(Class<?> paramClass)
  {
    return paramClass.isAssignableFrom(getClass());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    noteFMStateNotSaved();
  }
  
  public void onBackground()
  {
    super.onBackground();
  }
  
  public abstract void onBindEvent(boolean paramBoolean);
  
  protected ViewHolder onCacheView()
  {
    return null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mBaseActivityImpl = new BaseActivityImpl(this, this.mPrivateAccess);
    this.mBaseActivityImpl.onCreate(paramBundle);
  }
  
  public SlideStillAnimation onCreateStillAnimation(int paramInt)
  {
    if (paramInt == 2130772423)
    {
      SlideStillAnimation localSlideStillAnimation = new SlideStillAnimation();
      localSlideStillAnimation.setDuration(getResources().getInteger(2131427330));
      return localSlideStillAnimation;
    }
    return null;
  }
  
  public View onCreateView()
  {
    this.viewHolder = onCacheView();
    View localView = initUI(this.viewHolder);
    initTopbar(localView);
    return localView;
  }
  
  public void onDestroy()
  {
    this.mBaseActivityImpl.onDestroy();
  }
  
  public void onDestroyView()
  {
    onSaveViewHolder();
    super.onDestroyView();
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected BaseFragment.TransitionConfig onFetchTransaction()
  {
    return NO_ANIMATE_TRANSITION_CONFIG;
  }
  
  public BaseFragment.TransitionConfig onFetchTransitionConfig()
  {
    return onFetchTransaction();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public Object onLastFragmentFinish()
  {
    return null;
  }
  
  public void onPause()
  {
    this.mBaseActivityImpl.registerNotification(false);
    this.mBaseActivityImpl.onPause();
  }
  
  public abstract void onRelease();
  
  public void onResume()
  {
    this.mBaseActivityImpl.registerNotification(true);
    this.mBaseActivityImpl.onResume();
  }
  
  protected void onSaveViewHolder() {}
  
  public void onStart()
  {
    this.mBaseActivityImpl.onStart();
  }
  
  public void onStop()
  {
    this.mBaseActivityImpl.onStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void onWindowConfiguration(boolean paramBoolean) {}
  
  public abstract int refreshData();
  
  public void removeBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    BaseFragmentActivity localBaseFragmentActivity = getBaseFragmentActivity();
    if (localBaseFragmentActivity != null) {
      localBaseFragmentActivity.getSupportFragmentManager().removeOnBackStackChangedListener(paramOnBackStackChangedListener);
    }
  }
  
  protected void removeCallbackInBackground(Runnable paramRunnable)
  {
    Threads.removeCallbackInBackground(paramRunnable);
  }
  
  public abstract void render(int paramInt);
  
  public void runInBackground(Runnable paramRunnable)
  {
    Threads.runInBackground(paramRunnable);
  }
  
  protected void runInBackground(Runnable paramRunnable, long paramLong)
  {
    Threads.runInBackground(paramRunnable, paramLong);
  }
  
  public final void setFragmentActivityResult(int paramInt, HashMap<String, Object> paramHashMap)
  {
    super.setFragmentResult(paramInt, paramHashMap);
  }
  
  public final void setFragmentResult(int paramInt, HashMap<String, Object> paramHashMap)
  {
    if (getRequestCode() == -2147483648)
    {
      QMLog.log(5, TAG, "non-startForResult:" + this);
      return;
    }
    BaseFragmentActivity localBaseFragmentActivity = getBaseFragmentActivity();
    localBaseFragmentActivity.mLastResultCode = paramInt;
    localBaseFragmentActivity.mLastFragmentResult = paramHashMap;
    localBaseFragmentActivity.mLastRequestCode = getRequestCode();
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.mBaseActivityImpl.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.mBaseActivityImpl.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startFragmentWithBackStackChangedListener(BaseFragment paramBaseFragment, FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    BaseFragmentActivity localBaseFragmentActivity = getBaseFragmentActivity();
    if (localBaseFragmentActivity != null)
    {
      localBaseFragmentActivity.getSupportFragmentManager().addOnBackStackChangedListener(paramOnBackStackChangedListener);
      startSingleInstanceFragment(paramBaseFragment);
    }
  }
  
  protected void startSingleInstanceFragment(BaseFragment paramBaseFragment)
  {
    BaseFragmentActivity localBaseFragmentActivity = getBaseFragmentActivity();
    if (localBaseFragmentActivity != null)
    {
      localBaseFragmentActivity.startSingleInstanceFragment(paramBaseFragment);
      return;
    }
    QMLog.log(6, TAG, "startFragment null:" + this);
  }
  
  public void toast(int paramInt1, int paramInt2)
  {
    this.mBaseActivityImpl.toast(getString(paramInt1), paramInt2);
  }
  
  public void toast(String paramString, int paramInt)
  {
    this.mBaseActivityImpl.toast(paramString, paramInt);
  }
  
  public static class ViewHolder {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.fragment.base.QMBaseFragment
 * JD-Core Version:    0.7.0.1
 */