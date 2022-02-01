package moai.fragment.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import moai.fragment.app.Fragment;
import moai.fragment.app.FragmentActivity;
import moai.fragment.app.FragmentManager.BackStackEntry;
import moai.fragment.app.FragmentTransaction;
import moai.log.MLog;
import moai.log.MLogManager;

public abstract class BaseFragmentActivity
  extends FragmentActivity
  implements LifeDetection
{
  protected static final String TAG = BaseFragmentActivity.class.getSimpleName();
  public static AtomicReference<Activity> currentActivity = new AtomicReference();
  private static final MLog logger = MLogManager.getLogger("moailog");
  private boolean mDestroyed = false;
  public int mEnterAnim = -1;
  public int mExitAnim = -1;
  public HashMap<String, Object> mLastFragmentResult;
  public int mLastRequestCode;
  public int mLastResultCode;
  
  public boolean containPage(Class<? extends BaseFragment> paramClass)
  {
    if (isCurrentPage(paramClass)) {
      return true;
    }
    moai.fragment.app.FragmentManager localFragmentManager = getSupportFragmentManager();
    paramClass = paramClass.getSimpleName();
    int i = localFragmentManager.getBackStackEntryCount() - 1;
    for (;;)
    {
      if (i < 0) {
        break label55;
      }
      if (paramClass.equals(localFragmentManager.getBackStackEntryAt(i).getName())) {
        break;
      }
      i -= 1;
    }
    label55:
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    BaseFragment localBaseFragment = getCurrentFragment();
    if (localBaseFragment != null) {
      localBaseFragment.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final void finish()
  {
    super.finish();
  }
  
  protected boolean finishWhenPressBack()
  {
    return true;
  }
  
  protected abstract int getContextViewId();
  
  public final BaseFragment getCurrentFragment()
  {
    return (BaseFragment)getSupportFragmentManager().findFragmentById(getContextViewId());
  }
  
  public final android.app.FragmentManager getFragmentManager()
  {
    throw new UnsupportedOperationException("use getSupportFragmentManager");
  }
  
  protected abstract int getHistorySize();
  
  protected void goToHomeScreen()
  {
    moveTaskToBack(false);
  }
  
  public boolean isAnimationRunning()
  {
    return false;
  }
  
  public boolean isAttachedToActivity()
  {
    return !isDestroyed();
  }
  
  public boolean isCurrentPage(Class<?> paramClass)
  {
    return paramClass.isAssignableFrom(getCurrentFragment().getClass());
  }
  
  public boolean isDestroyed()
  {
    return this.mDestroyed;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    BaseFragment localBaseFragment = getCurrentFragment();
    if (localBaseFragment != null) {
      localBaseFragment.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setFlags();
    paramBundle = new FrameLayout(this);
    paramBundle.setId(getContextViewId());
    setContentView(paramBundle);
  }
  
  public void onDestroy()
  {
    currentActivity.compareAndSet(this, null);
    super.onDestroy();
    this.mDestroyed = true;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((getCurrentFragment() != null) && (getCurrentFragment().onKeyDown(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((getCurrentFragment() != null) && (getCurrentFragment().onKeyUp(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    currentActivity.compareAndSet(this, null);
    super.onPause();
  }
  
  protected void onRestart()
  {
    super.onRestart();
  }
  
  public void onResume()
  {
    currentActivity.set(this);
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void popAllBackStatck()
  {
    throw new UnsupportedOperationException("use finish");
  }
  
  public void popBackStack()
  {
    logger.d(TAG, "popBackStack(): cnt[%d],hsize[%d],fragment[%s]", new Object[] { Integer.valueOf(getSupportFragmentManager().getBackStackEntryCount()), Integer.valueOf(getHistorySize()), "" + getCurrentFragment() });
    if (getSupportFragmentManager().getBackStackEntryCount() == 0)
    {
      Object localObject2 = getCurrentFragment();
      Object localObject1 = ((BaseFragment)localObject2).onFetchTransitionConfig();
      if (getHistorySize() <= 1)
      {
        Object localObject3 = ((BaseFragment)localObject2).onLastFragmentFinish();
        if (localObject3 != null)
        {
          if ((localObject3 instanceof Fragment))
          {
            logger.d(TAG, "popBackStack(): place,fragment:" + localObject3);
            localObject2 = getSupportFragmentManager().beginTransaction();
            ((FragmentTransaction)localObject2).setCustomAnimations(((BaseFragment.TransitionConfig)localObject1).popEnter, ((BaseFragment.TransitionConfig)localObject1).popExit, 0, 0);
            localObject1 = (Fragment)localObject3;
            localObject3 = localObject1.getClass().getSimpleName();
            ((FragmentTransaction)localObject2).replace(getContextViewId(), (Fragment)localObject1, (String)localObject3).commit();
            return;
          }
          if ((localObject3 instanceof Intent))
          {
            logger.d(TAG, "popBackStack(): place,intent:" + localObject3);
            localObject2 = (Intent)localObject3;
            setResult();
            startActivity((Intent)localObject2);
            overridePendingTransition(((BaseFragment.TransitionConfig)localObject1).popEnter, ((BaseFragment.TransitionConfig)localObject1).popExit);
            finish();
            return;
          }
          throw new IllegalArgumentException("onLastFinish return invalid " + localObject3.getClass());
        }
        if (finishWhenPressBack())
        {
          setResult();
          finish();
          overridePendingTransition(((BaseFragment.TransitionConfig)localObject1).popEnter, ((BaseFragment.TransitionConfig)localObject1).popExit);
          return;
        }
        goToHomeScreen();
        return;
      }
      setResult();
      finish();
      overridePendingTransition(((BaseFragment.TransitionConfig)localObject1).popEnter, ((BaseFragment.TransitionConfig)localObject1).popExit);
      return;
    }
    getCurrentFragment().noteFMStateNotSaved();
    getSupportFragmentManager().popBackStackImmediate();
  }
  
  public void popBackStack(int paramInt1, int paramInt2)
  {
    logger.d(TAG, "popBackStack(int,int): id[%d], flags[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    getSupportFragmentManager().popBackStack(paramInt1, paramInt2);
  }
  
  public void popBackStack(Class<? extends BaseFragment> paramClass)
  {
    int i = getSupportFragmentManager().getBackStackEntryCount();
    logger.d(TAG, "popBackStatck(Class):count[%d],clazz[%s]", new Object[] { Integer.valueOf(i), paramClass.getName() });
    if (i == 0)
    {
      popBackStack();
      return;
    }
    getCurrentFragment().noteFMStateNotSaved();
    getSupportFragmentManager().popBackStack(paramClass.getSimpleName(), 0);
  }
  
  public void popBackStackInclusive(Class<? extends BaseFragment> paramClass)
  {
    int i = getSupportFragmentManager().getBackStackEntryCount();
    logger.d(TAG, "popBackStackInclusive(Class):count[%d],clazz[%s]", new Object[] { Integer.valueOf(i), paramClass.getName() });
    if (i == 0)
    {
      popBackStack();
      return;
    }
    getCurrentFragment().noteFMStateNotSaved();
    getSupportFragmentManager().popBackStack(paramClass.getSimpleName(), 1);
  }
  
  public void removeFragment(Class<?> paramClass)
  {
    throw new UnsupportedOperationException("use popBackStack");
  }
  
  protected void setFlags() {}
  
  protected void setResult()
  {
    if (this.mLastResultCode > 0) {
      setResult(this.mLastResultCode, null);
    }
  }
  
  public void startFragment(BaseFragment paramBaseFragment)
  {
    startFragment(paramBaseFragment, new BaseFragmentActivity.1(this));
  }
  
  public void startFragment(BaseFragment paramBaseFragment, TransactInterceptor paramTransactInterceptor)
  {
    Log.v(TAG, "startFragment: " + getCurrentFragment() + ", " + paramBaseFragment);
    getCurrentFragment().noteFMStateNotSaved();
    String str = paramBaseFragment.getClass().getSimpleName();
    paramTransactInterceptor.intercept(paramBaseFragment).replace(getContextViewId(), paramBaseFragment, str).addToBackStack(str).commit();
  }
  
  public void startSingleInstanceFragment(BaseFragment paramBaseFragment)
  {
    String str = paramBaseFragment.getClass().getSimpleName();
    moai.fragment.app.FragmentManager localFragmentManager = getSupportFragmentManager();
    if ((localFragmentManager.getBackStackEntryCount() > 0) && (localFragmentManager.getBackStackEntryAt(localFragmentManager.getBackStackEntryCount() - 1).getName().equals(str)))
    {
      Log.w("cyz", "try to open more than one fragment");
      return;
    }
    startFragment(paramBaseFragment);
  }
  
  public void super_finish()
  {
    super.finish();
  }
  
  public void super_finishActivity(int paramInt)
  {
    super.finishActivity(paramInt);
  }
  
  void super_onBackPressed()
  {
    popBackStack();
  }
  
  public static abstract interface TransactInterceptor
  {
    public abstract FragmentTransaction intercept(BaseFragment paramBaseFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.base.BaseFragmentActivity
 * JD-Core Version:    0.7.0.1
 */