package com.tencent.qqmail.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.CrashGuard;
import com.tencent.qqmail.utilities.CrashGuard.Key;
import com.tencent.qqmail.utilities.animation.AdvertiseAnimUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.PtrListView;

public class QMBaseView
  extends FrameLayout
{
  private static final float MAX_SCROLL_TIMES = 1.5F;
  private static final String TAG = "QMBaseView";
  public static final int WEBVIEW_DESTROY_DELAY = 30000;
  private QMAdvertiseView advertiseView;
  private Runnable destroyAdvertiseViewRunnable;
  private boolean isKeyboardShown = false;
  private ListView listView;
  private OnCompleteInputListener onCompleteInputListener;
  private ScrollView rootScrollView;
  private LinearLayout scrollBodyView;
  private QMTopBar topBar;
  
  public QMBaseView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  private void initView()
  {
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void addContentView(View paramView)
  {
    this.scrollBodyView.addView(paramView);
  }
  
  public ItemScrollListView addItemScrollListView(boolean paramBoolean)
  {
    ItemScrollListView localItemScrollListView = new ItemScrollListView(getContext());
    localItemScrollListView.setId(2131373733);
    FrameLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.gravity = 48;
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    addView(localItemScrollListView, 0, localLayoutParams);
    this.listView = localItemScrollListView;
    if (paramBoolean) {
      localItemScrollListView.setDropdownView();
    }
    return localItemScrollListView;
  }
  
  public QMContentLoadingView addListEmptyView()
  {
    QMContentLoadingView localQMContentLoadingView = new QMContentLoadingView(getContext());
    addView(localQMContentLoadingView, 0);
    localQMContentLoadingView.initStyle();
    return localQMContentLoadingView;
  }
  
  public RelativeLayout addListViewAndBottomView(boolean paramBoolean)
  {
    FrameLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.gravity = 48;
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    RelativeLayout localRelativeLayout = (RelativeLayout)inflate(getContext(), 2131559498, null);
    ItemScrollListView localItemScrollListView = (ItemScrollListView)localRelativeLayout.findViewById(2131373733);
    addView(localRelativeLayout, 0, localLayoutParams);
    this.listView = localItemScrollListView;
    if (paramBoolean) {
      localItemScrollListView.setDropdownView();
    }
    return localRelativeLayout;
  }
  
  public void addOnCompleteInputListener(EditText paramEditText, OnCompleteInputListener paramOnCompleteInputListener)
  {
    paramEditText.setOnEditorActionListener(new QMBaseView.1(this));
    this.onCompleteInputListener = paramOnCompleteInputListener;
  }
  
  public PtrListView addPtrListView()
  {
    return addPtrListView(false);
  }
  
  public PtrListView addPtrListView(boolean paramBoolean)
  {
    PtrListView localPtrListView = new PtrListView(getContext());
    localPtrListView.setId(2131373733);
    FrameLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.gravity = 48;
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    addView(localPtrListView, 0, localLayoutParams);
    this.listView = localPtrListView;
    if (paramBoolean) {
      localPtrListView.setDropdownView();
    }
    return localPtrListView;
  }
  
  public QMTopBar addTopBar()
  {
    this.topBar = new QMTopBar(getContext());
    addView(this.topBar);
    return this.topBar;
  }
  
  public void commitEditTextOnKeyboardHidden(EditText paramEditText) {}
  
  public void destroyAdvertiseViewInFuture()
  {
    QMLog.log(4, "QMBaseView", "destroyAdvertiseViewInFuture");
    if (this.destroyAdvertiseViewRunnable == null) {
      this.destroyAdvertiseViewRunnable = new QMBaseView.2(this);
    }
    Threads.removeCallbackOnMain(this.destroyAdvertiseViewRunnable);
    Threads.runOnMainThread(this.destroyAdvertiseViewRunnable, 30000L);
  }
  
  public QMAdvertiseView getAdvertiseView()
  {
    QMLog.log(4, "QMBaseView", "getAdvertiseView");
    if (this.advertiseView == null)
    {
      Object localObject = new CrashGuard(CrashGuard.Key.PULL_DOWN_WEBVIEW, 3);
      ((CrashGuard)localObject).open();
      if (!((CrashGuard)localObject).isWork())
      {
        QMLog.log(5, "QMBaseView", "Crash shit!! Report It");
        DataCollector.logEvent("Event_Pulldown_Webview_Crashguard");
      }
      ((CrashGuard)localObject).closeDelay(5000);
      QMLog.log(4, "QMBaseView", "re-build a advertise webview");
      this.advertiseView = new QMAdvertiseView(getContext());
      localObject = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject).gravity = 48;
      this.advertiseView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.advertiseView.getParent() == null) {
      addView(this.advertiseView);
    }
    this.advertiseView.setVisibility(8);
    return this.advertiseView;
  }
  
  public ScrollView getRootScrollView()
  {
    return this.rootScrollView;
  }
  
  public LinearLayout getScrollBodyView()
  {
    return this.scrollBodyView;
  }
  
  public QMTopBar getTopBar()
  {
    if (this.topBar == null) {
      addTopBar();
    }
    return this.topBar;
  }
  
  public void initScrollView()
  {
    initScrollView(new ScrollView(getContext()));
  }
  
  public void initScrollView(ScrollView paramScrollView)
  {
    this.rootScrollView = paramScrollView;
    paramScrollView = new FrameLayout.LayoutParams(-1, -1, 48);
    paramScrollView.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    this.rootScrollView.setLayoutParams(paramScrollView);
    this.rootScrollView.setVerticalFadingEdgeEnabled(false);
    addView(this.rootScrollView);
    this.scrollBodyView = new LinearLayout(getContext());
    int i = getResources().getDimensionPixelSize(2131299398);
    this.scrollBodyView.setPadding(0, i, 0, i);
    this.scrollBodyView.setOrientation(1);
    this.scrollBodyView.setFocusable(true);
    this.scrollBodyView.setFocusableInTouchMode(true);
    this.rootScrollView.addView(this.scrollBodyView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.onCompleteInputListener != null)
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      paramInt2 = getHeight();
      if (paramInt2 <= paramInt1) {
        break label34;
      }
      this.isKeyboardShown = true;
    }
    label34:
    while ((!this.isKeyboardShown) || (paramInt2 >= paramInt1)) {
      return;
    }
    this.isKeyboardShown = false;
    this.onCompleteInputListener.onComplete();
  }
  
  public void removeAdvertiseView()
  {
    QMLog.log(4, "QMBaseView", "removeAdvertiseView");
    if ((this.advertiseView != null) && (this.advertiseView.getParent() != null))
    {
      if (!AdvertiseAnimUtil.advertiseViewForeground)
      {
        QMLog.log(4, "QMBaseView", "WebView is going to die");
        removeView(this.advertiseView);
        this.advertiseView.destroy();
        this.advertiseView = null;
      }
    }
    else {
      return;
    }
    QMLog.log(4, "QMBaseView", "WebView is foreground, Don't kill it");
  }
  
  @SuppressLint({"NewApi"})
  public void scrollToPosition(int paramInt)
  {
    Log.d("hill-title", "pos:" + paramInt);
    if (this.scrollBodyView != null) {
      ((ScrollView)this.scrollBodyView.getParent()).smoothScrollTo(paramInt, 0);
    }
    while (this.listView == null) {
      return;
    }
    int i = Build.VERSION.SDK_INT;
    Log.d("hill-scroll", "pos:" + paramInt + ", first:" + this.listView.getFirstVisiblePosition() + ", last:" + this.listView.getLastVisiblePosition());
    float f;
    if (i >= 8)
    {
      i = this.listView.getFirstVisiblePosition();
      f = this.listView.getChildCount() * 1.5F;
      if (Math.abs(i - paramInt) > f)
      {
        if (i <= paramInt) {
          break label189;
        }
        this.listView.setSelectionFromTop((int)(f + paramInt), 0);
      }
    }
    for (;;)
    {
      ((PtrListView)this.listView).smoothScrollToPositionFromTop(paramInt, 0);
      return;
      label189:
      this.listView.setSelectionFromTop((int)(paramInt - f), 0);
    }
  }
  
  public void scrollToTop()
  {
    if (this.scrollBodyView != null) {
      ((ScrollView)this.scrollBodyView.getParent()).fullScroll(33);
    }
    while (this.listView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 8)
    {
      int i = this.listView.getFirstVisiblePosition();
      int j = MailListItemView.VIEW_HEIGHT;
      float f = this.listView.getHeight() * 1.5F;
      int k = Math.round(f / MailListItemView.VIEW_HEIGHT);
      if (i * j > f) {
        this.listView.setSelectionFromTop(k, 0);
      }
      this.listView.smoothScrollToPosition(0);
      return;
    }
    QMLog.log(4, "QMBaseView", "scrollToTop not working, because API level is under 8, current is " + Build.VERSION.SDK_INT);
    this.listView.setSelectionFromTop(0, 0);
  }
  
  public static abstract interface OnCompleteInputListener
  {
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMBaseView
 * JD-Core Version:    0.7.0.1
 */