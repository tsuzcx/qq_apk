package moai.fragment.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import moai.fragment.app.Fragment;
import moai.fragment.app.FragmentActivity;
import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentManager.OpGenerator;
import moai.log.MLog;
import moai.log.MLogManager;

public abstract class BaseFragment
  extends Fragment
  implements LifeCycle, LifeDetection
{
  private static final String ARGUMENTS_KEY_CLASSNAME = "basefragment_argument_classname";
  private static final String ARGUMENTS_KEY_SAVED = "basefragment_argument_saved";
  protected static final TransitionConfig NO_ANIMATE_TRANSITION_CONFIG = new TransitionConfig(0, 0, 0, 0);
  private static final int NO_REQUEST_CODE = -2147483648;
  public static final int RESULT_BACK = 2;
  public static final int RESULT_CANCELED = 0;
  public static final int RESULT_FIRST_USER = 1;
  public static final int RESULT_OK = -1;
  private static final String TAG = "BaseFragment";
  private static final MLog logger = MLogManager.getLogger("moailog");
  private static Handler mainHandler = new Handler(Looper.getMainLooper());
  private boolean mAnimationInfo = false;
  private final boolean mAutoSaveArguments;
  private View mBaseView;
  private boolean mOnCreateCalled = false;
  private int mSourceRequestCode = -2147483648;
  private int mTargetRequestCode = -2147483648;
  private final ConcurrentHashMap<Runnable, Runnable> mapToMainHandler = new ConcurrentHashMap();
  
  protected BaseFragment(boolean paramBoolean)
  {
    this.mAutoSaveArguments = paramBoolean;
    Log.v("BaseFragment", "#initConstructor");
    if (paramBoolean)
    {
      if (getArguments() != null) {
        throw new IllegalArgumentException("arguments alread has value:" + getArguments());
      }
      super.setArguments(new Bundle());
    }
  }
  
  private void resetOverridePendingTransition()
  {
    FragmentManager localFragmentManager = getBaseFragmentActivity().getSupportFragmentManager();
    try
    {
      localFragmentManager.getClass().getDeclaredMethod("enqueueAction", new Class[] { FragmentManager.OpGenerator.class, Boolean.TYPE }).invoke(localFragmentManager, new Object[] { new BaseFragment.2(this), Boolean.valueOf(true) });
      return;
    }
    catch (Exception localException)
    {
      logger.e("BaseFragment", "resetOverridePendingTransition", localException);
    }
  }
  
  private void restoreArguments()
  {
    Bundle localBundle = getArguments();
    long l;
    Class localClass1;
    Field[] arrayOfField;
    int j;
    int i;
    if ((localBundle != null) && (localBundle.getBoolean("basefragment_argument_saved", false)))
    {
      l = System.currentTimeMillis();
      localClass1 = getClass();
      if (localClass1 != BaseFragment.class)
      {
        arrayOfField = localClass1.getDeclaredFields();
        j = arrayOfField.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        Field localField = arrayOfField[i];
        if ((SaveArgumentField)localField.getAnnotation(SaveArgumentField.class) != null)
        {
          String str;
          try
          {
            localField.setAccessible(true);
            str = localClass1.getName() + "#" + localField.getName();
            if (!localBundle.containsKey(str)) {
              throw new IllegalArgumentException("restoreArguments field not complete, " + str);
            }
          }
          catch (Exception localException)
          {
            throw new RuntimeException(localException);
          }
          Class localClass3 = localField.getType();
          if (localClass3 == Integer.TYPE) {
            localField.set(this, Integer.valueOf(localBundle.getInt(str)));
          } else if (localClass3 == Long.TYPE) {
            localField.set(this, Long.valueOf(localBundle.getLong(str)));
          } else if (localClass3 == Boolean.TYPE) {
            localField.set(this, Boolean.valueOf(localBundle.getBoolean(str)));
          } else if (localClass3 == [I.class) {
            localField.set(this, localBundle.getIntArray(str));
          } else if (localClass3 == [J.class) {
            localField.set(this, localBundle.getLongArray(str));
          } else if (localClass3 == String.class) {
            localField.set(this, localBundle.getString(str));
          } else {
            throw new RuntimeException("Add new type");
          }
        }
      }
      else
      {
        Class localClass2 = localException.getSuperclass();
        break;
        logger.i("BaseFragment", "restoreArguments: " + (System.currentTimeMillis() - l) + ", " + this);
        return;
      }
      i += 1;
    }
  }
  
  private void saveArguments()
  {
    getArguments().putString("basefragment_argument_classname", getClass().getName());
    new BaseFragment.3(this).start();
  }
  
  public boolean canDragBack()
  {
    return super.canDragBack();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public View findViewById(int paramInt)
  {
    if (this.mBaseView != null) {
      return this.mBaseView.findViewById(paramInt);
    }
    return null;
  }
  
  public final BaseFragmentActivity getBaseFragmentActivity()
  {
    return (BaseFragmentActivity)getActivity();
  }
  
  public final View getBaseView()
  {
    return this.mBaseView;
  }
  
  public int getRequestCode()
  {
    return this.mTargetRequestCode;
  }
  
  public final View getView()
  {
    return super.getView();
  }
  
  public boolean hideKeyBoard()
  {
    return ((InputMethodManager)getActivity().getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().findViewById(16908290).getWindowToken(), 0);
  }
  
  public abstract void initDataSource();
  
  protected void initDom(View paramView, Bundle paramBundle) {}
  
  protected boolean isAnimationInto()
  {
    if (!this.mOnCreateCalled) {
      throw new IllegalStateException("onCreate cannot invoke here");
    }
    return this.mAnimationInfo;
  }
  
  public boolean isAttachedToActivity()
  {
    return (!isRemoving()) && (this.mBaseView != null);
  }
  
  protected boolean isLastFragment()
  {
    return getBaseFragmentActivity().getSupportFragmentManager().getBackStackEntryCount() == 0;
  }
  
  public void noteFMStateNotSaved()
  {
    try
    {
      FragmentManager localFragmentManager = getFragmentManager();
      localFragmentManager.getClass().getDeclaredMethod("noteStateNotSaved", new Class[0]).invoke(localFragmentManager, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      logger.w("BaseFragment", "noteFMStateNotSaved", localException);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    noteFMStateNotSaved();
  }
  
  protected void onAnimationEnd(Animation paramAnimation) {}
  
  protected void onAnimationStart(Animation paramAnimation) {}
  
  public void onBackPressed()
  {
    getBaseFragmentActivity().super_onBackPressed();
  }
  
  public void onBackground() {}
  
  public abstract void onBindEvent(boolean paramBoolean);
  
  public void onCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    super.onCreate(paramBundle);
    long l3 = System.currentTimeMillis();
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.getBoolean("basefragment_argument_saved", false))) {
      onRestoreArguments(localBundle);
    }
    for (;;)
    {
      this.mBaseView = onCreateView();
      long l2 = System.currentTimeMillis();
      Log.v("BaseFragment", "#initUI: timed:" + (l2 - l3) + ", this:" + this);
      initDataSource();
      l3 = System.currentTimeMillis();
      Log.v("BaseFragment", "#initDataSource: timed:" + (l3 - l2) + ", this:" + this);
      initDom(this.mBaseView, paramBundle);
      l2 = System.currentTimeMillis();
      Log.v("BaseFragment", "#initDom: timed:" + (l2 - l3) + ", totle:" + (l2 - l1) + ", this:" + this);
      this.mOnCreateCalled = true;
      return;
      if (!this.mAutoSaveArguments) {}
    }
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    SlideStillAnimation localSlideStillAnimation2 = onCreateStillAnimation(paramInt2);
    Object localObject = localSlideStillAnimation2;
    if (localSlideStillAnimation2 == null)
    {
      localObject = localSlideStillAnimation2;
      if (paramInt2 == 0) {}
    }
    try
    {
      localObject = AnimationUtils.loadAnimation(getActivity(), paramInt2);
      if (localObject != null)
      {
        if (paramBoolean)
        {
          this.mAnimationInfo = true;
          ((Animation)localObject).setAnimationListener(new BaseFragment.1(this));
        }
        return localObject;
      }
      if (paramBoolean)
      {
        onAnimationStart(null);
        onAnimationEnd(null);
      }
      return super.onCreateAnimation(paramInt1, paramBoolean, paramInt2);
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        SlideStillAnimation localSlideStillAnimation1 = localSlideStillAnimation2;
      }
    }
  }
  
  protected SlideStillAnimation onCreateStillAnimation(int paramInt)
  {
    return null;
  }
  
  protected abstract View onCreateView();
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.mBaseView.getParent() != null)
    {
      Log.i("wuziyi", "baseView parent not null " + this.mBaseView.getParent());
      ((ViewGroup)this.mBaseView.getParent()).removeView(this.mBaseView);
    }
    return this.mBaseView;
  }
  
  public void onDestroy()
  {
    this.mTargetRequestCode = -2147483648;
    onRelease();
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public final void onDetach()
  {
    Log.v("BaseFragment", "onDetach: " + this);
    this.mBaseView = null;
    super.onDetach();
  }
  
  public TransitionConfig onFetchTransitionConfig()
  {
    return NO_ANIMATE_TRANSITION_CONFIG;
  }
  
  public void onForeground() {}
  
  protected void onFragmentResult(int paramInt1, int paramInt2, HashMap<String, Object> paramHashMap) {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public Object onLastFragmentFinish()
  {
    return null;
  }
  
  public void onPause()
  {
    Log.d("BaseFragment", "onPause: " + this + ", " + getActivity());
    onBackground();
    super.onPause();
  }
  
  public abstract void onRelease();
  
  protected void onRestoreArguments(Bundle paramBundle) {}
  
  public void onResume()
  {
    onForeground();
    Log.d("BaseFragment", "onResume: " + this + ", " + getActivity());
    long l1 = System.currentTimeMillis();
    super.onResume();
    long l2 = System.currentTimeMillis();
    int i = refreshData();
    long l3 = System.currentTimeMillis();
    Log.v("BaseFragment", "#refreshData: timed:" + (l3 - l2) + ", this:" + this);
    render(i);
    l3 = System.currentTimeMillis();
    Log.v("BaseFragment", "#render: timed:" + (l3 - l2) + ", totle:" + (l3 - l1) + ", this:" + this);
  }
  
  public void onStart()
  {
    super.onStart();
    long l1 = System.currentTimeMillis();
    BaseFragmentActivity localBaseFragmentActivity = getBaseFragmentActivity();
    int i;
    int j;
    if (this.mSourceRequestCode != -2147483648)
    {
      i = this.mSourceRequestCode;
      j = localBaseFragmentActivity.mLastRequestCode;
      int k = localBaseFragmentActivity.mLastResultCode;
      HashMap localHashMap = localBaseFragmentActivity.mLastFragmentResult;
      this.mSourceRequestCode = -2147483648;
      localBaseFragmentActivity.mLastRequestCode = -2147483648;
      localBaseFragmentActivity.mLastResultCode = 0;
      localBaseFragmentActivity.mLastFragmentResult = null;
      if (j != i) {
        break label142;
      }
      onFragmentResult(j, k, localHashMap);
    }
    for (;;)
    {
      onBindEvent(true);
      onWindowConfiguration(true);
      long l2 = System.currentTimeMillis();
      Log.v("BaseFragment", "#onBindEvent: timed:" + (l2 - l1) + ", this:" + this);
      return;
      label142:
      logger.e("BaseFragment", "onFragmentResult requestCode: " + j + ", " + i);
    }
  }
  
  public void onStop()
  {
    onWindowConfiguration(false);
    onBindEvent(false);
    super.onStop();
  }
  
  public void onWindowConfiguration(boolean paramBoolean) {}
  
  public void overridePendingTransition(int paramInt1, int paramInt2)
  {
    Log.v("BaseFragment", "overridePendingTransition:" + paramInt1 + ", " + paramInt2);
    BaseFragmentActivity localBaseFragmentActivity = getBaseFragmentActivity();
    localBaseFragmentActivity.mEnterAnim = paramInt1;
    localBaseFragmentActivity.mExitAnim = paramInt2;
  }
  
  public void popBackStack()
  {
    BaseFragmentActivity localBaseFragmentActivity = getBaseFragmentActivity();
    if (localBaseFragmentActivity != null)
    {
      FragmentManager localFragmentManager = localBaseFragmentActivity.getSupportFragmentManager();
      for (;;)
      {
        try
        {
          Field localField = localFragmentManager.getClass().getDeclaredField("mExecutingActions");
          localField.setAccessible(true);
          boolean bool = ((Boolean)localField.get(localFragmentManager)).booleanValue();
          if (bool) {
            continue;
          }
          i = 1;
        }
        catch (Exception localException)
        {
          logger.e("BaseFragment", "popBackStack", localException);
          int i = 1;
          continue;
          logger.d("BaseFragment", "popBackStack not immediate");
          mainHandler.post(new BaseFragment.5(this, localBaseFragmentActivity));
          return;
        }
        if (i == 0) {
          continue;
        }
        localBaseFragmentActivity.popBackStack();
        return;
        i = 0;
      }
    }
    logger.e("BaseFragment", "popBackStack null:" + this);
  }
  
  public void popBackStackUntilToTheClass(String paramString)
  {
    for (;;)
    {
      if (((BaseFragmentActivity)getActivity()).getCurrentFragment().getClass().getName().equals(paramString)) {
        return;
      }
      popBackStack();
    }
  }
  
  public abstract int refreshData();
  
  public void removeCallbackOnMain(Runnable paramRunnable)
  {
    paramRunnable = (Runnable)this.mapToMainHandler.remove(paramRunnable);
    if (paramRunnable != null) {
      mainHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public abstract void render(int paramInt);
  
  public void runOnMainThread(Runnable paramRunnable)
  {
    if ((!isRemoving()) && (this.mBaseView != null))
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        paramRunnable.run();
      }
    }
    else {
      return;
    }
    runOnMainThread(paramRunnable, 0L);
  }
  
  public void runOnMainThread(Runnable paramRunnable, long paramLong)
  {
    BaseFragment.4 local4 = new BaseFragment.4(this, paramRunnable);
    this.mapToMainHandler.put(paramRunnable, local4);
    mainHandler.postDelayed(local4, paramLong);
  }
  
  public final void setArguments(Bundle paramBundle)
  {
    throw new UnsupportedOperationException("used Constructor");
  }
  
  public void setFragmentResult(int paramInt, HashMap<String, Object> paramHashMap)
  {
    BaseFragmentActivity localBaseFragmentActivity;
    Intent localIntent;
    if (this.mTargetRequestCode == -2147483648)
    {
      logger.w("BaseFragment", "non-startForResult:" + this);
      localBaseFragmentActivity = getBaseFragmentActivity();
      localIntent = new Intent();
      if (paramHashMap != null) {
        paramHashMap = paramHashMap.entrySet().iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (paramHashMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramHashMap.next();
          if ((localEntry.getValue() instanceof String))
          {
            localIntent.putExtra((String)localEntry.getKey(), (String)localEntry.getValue());
            continue;
            localBaseFragmentActivity = getBaseFragmentActivity();
            localBaseFragmentActivity.mLastResultCode = paramInt;
            localBaseFragmentActivity.mLastFragmentResult = paramHashMap;
            localBaseFragmentActivity.mLastRequestCode = this.mTargetRequestCode;
            break;
          }
          if ((localEntry.getValue() instanceof Integer)) {
            localIntent.putExtra((String)localEntry.getKey(), ((Integer)localEntry.getValue()).intValue());
          } else if ((localEntry.getValue() instanceof Long)) {
            localIntent.putExtra((String)localEntry.getKey(), (Long)localEntry.getValue());
          } else if ((localEntry.getValue() instanceof Double)) {
            localIntent.putExtra((String)localEntry.getKey(), (Double)localEntry.getValue());
          } else if ((localEntry.getValue() instanceof Float)) {
            localIntent.putExtra((String)localEntry.getKey(), (Float)localEntry.getValue());
          } else if ((localEntry.getValue() instanceof Serializable)) {
            localIntent.putExtra((String)localEntry.getKey(), (Serializable)localEntry.getValue());
          } else {
            throw new IllegalArgumentException("no valid value support : " + (String)localEntry.getKey());
          }
        }
      }
    }
    localBaseFragmentActivity.setResult(paramInt, localIntent);
  }
  
  public void showKeyBoard()
  {
    ((InputMethodManager)getActivity().getApplicationContext().getSystemService("input_method")).toggleSoftInput(0, 2);
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startFragment(BaseFragment paramBaseFragment)
  {
    BaseFragmentActivity localBaseFragmentActivity = getBaseFragmentActivity();
    if (localBaseFragmentActivity != null)
    {
      if ((!isRemoving()) && (this.mBaseView != null))
      {
        localBaseFragmentActivity.startFragment(paramBaseFragment);
        return;
      }
      logger.e("BaseFragment", "fragment not attached:" + this);
      return;
    }
    logger.e("BaseFragment", "startFragment null:" + this);
  }
  
  public void startFragmentForResult(BaseFragment paramBaseFragment, int paramInt)
  {
    paramBaseFragment.mTargetRequestCode = paramInt;
    this.mSourceRequestCode = paramInt;
    startFragment(paramBaseFragment);
  }
  
  public static final class TransitionConfig
  {
    public final int enter;
    public final int exit;
    public final int popEnter;
    public final int popExit;
    
    public TransitionConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.enter = paramInt1;
      this.exit = paramInt2;
      this.popEnter = paramInt3;
      this.popExit = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.base.BaseFragment
 * JD-Core Version:    0.7.0.1
 */