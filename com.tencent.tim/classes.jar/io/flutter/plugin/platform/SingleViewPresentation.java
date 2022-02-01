package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@TargetApi(17)
class SingleViewPresentation
  extends Presentation
{
  private final AccessibilityEventsDelegate accessibilityEventsDelegate;
  private FrameLayout container;
  private Object createParams;
  private final View.OnFocusChangeListener focusChangeListener;
  private AccessibilityDelegatingFrameLayout rootView;
  private boolean startFocused = false;
  private PresentationState state;
  private final PlatformViewFactory viewFactory;
  private int viewId;
  
  public SingleViewPresentation(Context paramContext, Display paramDisplay, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, PresentationState paramPresentationState, View.OnFocusChangeListener paramOnFocusChangeListener, boolean paramBoolean)
  {
    super(paramContext, paramDisplay);
    this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
    this.viewFactory = null;
    this.state = paramPresentationState;
    this.focusChangeListener = paramOnFocusChangeListener;
    getWindow().setFlags(8, 8);
    this.startFocused = paramBoolean;
  }
  
  public SingleViewPresentation(Context paramContext, Display paramDisplay, PlatformViewFactory paramPlatformViewFactory, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, int paramInt, Object paramObject, View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    super(paramContext, paramDisplay);
    this.viewFactory = paramPlatformViewFactory;
    this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
    this.viewId = paramInt;
    this.createParams = paramObject;
    this.focusChangeListener = paramOnFocusChangeListener;
    this.state = new PresentationState();
    getWindow().setFlags(8, 8);
  }
  
  public PresentationState detachState()
  {
    this.container.removeAllViews();
    this.rootView.removeAllViews();
    return this.state;
  }
  
  public PlatformView getView()
  {
    if (this.state.platformView == null) {
      return null;
    }
    return this.state.platformView;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (this.state.fakeWindowViewGroup == null) {
      PresentationState.access$002(this.state, new FakeWindowViewGroup(getContext()));
    }
    if (this.state.windowManagerHandler == null)
    {
      paramBundle = (WindowManager)getContext().getSystemService("window");
      PresentationState.access$102(this.state, new WindowManagerHandler(paramBundle, this.state.fakeWindowViewGroup));
    }
    this.container = new FrameLayout(getContext());
    paramBundle = new PresentationContext(getContext(), this.state.windowManagerHandler);
    if (this.state.platformView == null) {
      PresentationState.access$202(this.state, this.viewFactory.create(paramBundle, this.viewId, this.createParams));
    }
    paramBundle = this.state.platformView.getView();
    this.container.addView(paramBundle);
    this.rootView = new AccessibilityDelegatingFrameLayout(getContext(), this.accessibilityEventsDelegate, paramBundle);
    this.rootView.addView(this.container);
    this.rootView.addView(this.state.fakeWindowViewGroup);
    paramBundle.setOnFocusChangeListener(this.focusChangeListener);
    this.rootView.setFocusableInTouchMode(true);
    if (this.startFocused) {
      paramBundle.requestFocus();
    }
    for (;;)
    {
      setContentView(this.rootView);
      return;
      this.rootView.requestFocus();
    }
  }
  
  static class AccessibilityDelegatingFrameLayout
    extends FrameLayout
  {
    private final AccessibilityEventsDelegate accessibilityEventsDelegate;
    private final View embeddedView;
    
    public AccessibilityDelegatingFrameLayout(Context paramContext, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, View paramView)
    {
      super();
      this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
      this.embeddedView = paramView;
    }
    
    public boolean requestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return this.accessibilityEventsDelegate.requestSendAccessibilityEvent(this.embeddedView, paramView, paramAccessibilityEvent);
    }
  }
  
  static class FakeWindowViewGroup
    extends ViewGroup
  {
    private final Rect childRect = new Rect();
    private final Rect viewBounds = new Rect();
    
    public FakeWindowViewGroup(Context paramContext)
    {
      super();
    }
    
    private static int atMost(int paramInt)
    {
      return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt), -2147483648);
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)localView.getLayoutParams();
        this.viewBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
        Gravity.apply(localLayoutParams.gravity, localView.getMeasuredWidth(), localView.getMeasuredHeight(), this.viewBounds, localLayoutParams.x, localLayoutParams.y, this.childRect);
        localView.layout(this.childRect.left, this.childRect.top, this.childRect.right, this.childRect.bottom);
        i += 1;
      }
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      int i = 0;
      while (i < getChildCount())
      {
        getChildAt(i).measure(atMost(paramInt1), atMost(paramInt2));
        i += 1;
      }
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  static class PresentationContext
    extends ContextWrapper
  {
    private WindowManager windowManager;
    private final SingleViewPresentation.WindowManagerHandler windowManagerHandler;
    
    PresentationContext(Context paramContext, SingleViewPresentation.WindowManagerHandler paramWindowManagerHandler)
    {
      super();
      this.windowManagerHandler = paramWindowManagerHandler;
    }
    
    private WindowManager getWindowManager()
    {
      if (this.windowManager == null) {
        this.windowManager = this.windowManagerHandler.getWindowManager();
      }
      return this.windowManager;
    }
    
    public Object getSystemService(String paramString)
    {
      if ("window".equals(paramString)) {
        return getWindowManager();
      }
      return super.getSystemService(paramString);
    }
  }
  
  static class PresentationState
  {
    private SingleViewPresentation.FakeWindowViewGroup fakeWindowViewGroup;
    private PlatformView platformView;
    private SingleViewPresentation.WindowManagerHandler windowManagerHandler;
  }
  
  static class WindowManagerHandler
    implements InvocationHandler
  {
    private static final String TAG = "PlatformViewsController";
    private final WindowManager delegate;
    SingleViewPresentation.FakeWindowViewGroup fakeWindowRootView;
    
    WindowManagerHandler(WindowManager paramWindowManager, SingleViewPresentation.FakeWindowViewGroup paramFakeWindowViewGroup)
    {
      this.delegate = paramWindowManager;
      this.fakeWindowRootView = paramFakeWindowViewGroup;
    }
    
    private void addView(Object[] paramArrayOfObject)
    {
      if (this.fakeWindowRootView == null)
      {
        Log.w("PlatformViewsController", "Embedded view called addView while detached from presentation");
        return;
      }
      View localView = (View)paramArrayOfObject[0];
      paramArrayOfObject = (WindowManager.LayoutParams)paramArrayOfObject[1];
      this.fakeWindowRootView.addView(localView, paramArrayOfObject);
    }
    
    private void removeView(Object[] paramArrayOfObject)
    {
      if (this.fakeWindowRootView == null)
      {
        Log.w("PlatformViewsController", "Embedded view called removeView while detached from presentation");
        return;
      }
      paramArrayOfObject = (View)paramArrayOfObject[0];
      this.fakeWindowRootView.removeView(paramArrayOfObject);
    }
    
    private void removeViewImmediate(Object[] paramArrayOfObject)
    {
      if (this.fakeWindowRootView == null)
      {
        Log.w("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
        return;
      }
      paramArrayOfObject = (View)paramArrayOfObject[0];
      paramArrayOfObject.clearAnimation();
      this.fakeWindowRootView.removeView(paramArrayOfObject);
    }
    
    private void updateViewLayout(Object[] paramArrayOfObject)
    {
      if (this.fakeWindowRootView == null)
      {
        Log.w("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
        return;
      }
      View localView = (View)paramArrayOfObject[0];
      paramArrayOfObject = (WindowManager.LayoutParams)paramArrayOfObject[1];
      this.fakeWindowRootView.updateViewLayout(localView, paramArrayOfObject);
    }
    
    public WindowManager getWindowManager()
    {
      return (WindowManager)Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[] { WindowManager.class }, this);
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      paramObject = paramMethod.getName();
      int i = paramObject.hashCode();
      if (i != -1148522778) {
        if (i != 542766184) {
          if (i != 931413976) {
            if (i != 1098630473) {
              i = -1;
            }
          }
        }
      }
      for (;;)
      {
        switch (i)
        {
        }
        try
        {
          paramObject = paramMethod.invoke(this.delegate, paramArrayOfObject);
          return paramObject;
        }
        catch (InvocationTargetException paramObject)
        {
          throw paramObject.getCause();
        }
        if (!paramObject.equals("removeView")) {
          break;
        }
        i = 1;
        continue;
        if (!paramObject.equals("updateViewLayout")) {
          break;
        }
        i = 3;
        continue;
        if (!paramObject.equals("removeViewImmediate")) {
          break;
        }
        i = 2;
        continue;
        if (!paramObject.equals("addView")) {
          break;
        }
        i = 0;
      }
      updateViewLayout(paramArrayOfObject);
      return null;
      removeViewImmediate(paramArrayOfObject);
      return null;
      removeView(paramArrayOfObject);
      return null;
      addView(paramArrayOfObject);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation
 * JD-Core Version:    0.7.0.1
 */