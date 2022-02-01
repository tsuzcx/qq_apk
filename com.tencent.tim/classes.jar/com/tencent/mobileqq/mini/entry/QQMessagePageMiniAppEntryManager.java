package com.tencent.mobileqq.mini.entry;

import aamm;
import acfp;
import adah;
import aeku;
import aekv;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqnm;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.b;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class QQMessagePageMiniAppEntryManager
  implements DrawerFrame.c, MiniAppPullInterface, ARMapHongBaoListView.b, BusinessObserver
{
  public static final long APP_STORE_TIME_THRESHOLD = 86400000L;
  public static final int MODE_IDLE = 1;
  public static final int MODE_REFRESH = 2;
  public static final int MODE_SHOW_NODE = 3;
  private static final int OFFSET_NODE_OPEN = aqnm.dip2px(-50.0F);
  private static final int OFFSET_NODE_SCROLL = aqnm.dip2px(-50.0F);
  private static final int OFFSET_NODE_SCROLL_FAST = aqnm.dip2px(-100.0F);
  private static final int OVER_FLING_DISTANCE = 70;
  private static final float SPEED_2 = 1.5F;
  private static final int STORY_TRANSLATE = aqnm.dip2px(-70.0F);
  public static final String TAG = "QQMessagePageMicroAppEntryManager";
  private int OFFSET_SCROLL_OVER;
  private final int OVER_FLING_DISTANCE_DEFAULT = 30;
  RedDotAppletsObserver appletsObserver = new RedDotAppletsObserver(this);
  boolean flag = false;
  private boolean isFirstOpenMiniAppEntry;
  private QQAppInterface mApp;
  private final aamm mCareNotificationBar;
  private PullRefreshHeader mChatTopRefresh;
  private MiniAppEntryLayout mContentView;
  private Context mContext;
  private DrawerFrame mDrawer;
  private ARMapHongBaoListView mListView;
  private ViewGroup mMiniAppListLayout;
  private int mode = 1;
  private int preMode = 1;
  private ProgressBar refreshProgressBar;
  
  public QQMessagePageMiniAppEntryManager(Context paramContext, Conversation paramConversation, ListView paramListView, PullRefreshHeader paramPullRefreshHeader, DrawerFrame paramDrawerFrame)
  {
    this.mContext = paramContext;
    this.mApp = paramConversation.app;
    this.mDrawer = paramDrawerFrame;
    this.mListView = ((ARMapHongBaoListView)paramListView);
    this.mChatTopRefresh = paramPullRefreshHeader;
    this.mCareNotificationBar = paramConversation.a;
  }
  
  private void doOnScroll(float paramFloat, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.preMode != 3)) {
      this.mContentView.dotViewOnScroll(paramFloat);
    }
    QLog.d("QQMessagePageMicroAppEntryManager", 4, String.format("fight..doOnScroll.scrollY:%f,offset_node_scrll:%d,offset_scroll_over:%d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(OFFSET_NODE_SCROLL), Integer.valueOf(this.OFFSET_SCROLL_OVER) }));
    float f1;
    if ((paramFloat <= OFFSET_NODE_SCROLL) && (paramFloat > this.OFFSET_SCROLL_OVER)) {
      if (paramFloat <= OFFSET_NODE_SCROLL_FAST)
      {
        f1 = (OFFSET_NODE_SCROLL_FAST - paramFloat) / (OFFSET_NODE_SCROLL_FAST - this.OFFSET_SCROLL_OVER);
        float f2 = STORY_TRANSLATE + (OFFSET_NODE_SCROLL - OFFSET_NODE_SCROLL_FAST);
        f1 = f2 - f1 * f2 * 1.5F;
        f2 = this.mMiniAppListLayout.getTranslationY();
        this.mMiniAppListLayout.setTranslationY(f1);
        if (this.mMiniAppListLayout.getTranslationY() < STORY_TRANSLATE) {
          this.mMiniAppListLayout.setTranslationY(STORY_TRANSLATE);
        }
        if (this.mMiniAppListLayout.getTranslationY() > 0.0F) {
          this.mMiniAppListLayout.setTranslationY(0.0F);
        }
        f1 = this.mMiniAppListLayout.getTranslationY() - f2;
        setMicroAppEntryPanelAlpha(1.0F - this.mMiniAppListLayout.getTranslationY() / STORY_TRANSLATE + 0.8F);
        label226:
        if (paramFloat <= aqnm.dpToPx(-70.0F)) {
          break label342;
        }
        this.mContentView.setDotViewTranslationY((this.mContentView.getDotViewHeight() + paramFloat) / 2.0F);
      }
    }
    for (;;)
    {
      if (Math.signum(paramFloat) == 0.0F)
      {
        paramBoolean = this.mCareNotificationBar.WH();
        this.mCareNotificationBar.Ct(false);
        if (paramBoolean != this.mCareNotificationBar.WH()) {
          this.mCareNotificationBar.refresh();
        }
      }
      return;
      f1 = STORY_TRANSLATE + (OFFSET_NODE_SCROLL - paramFloat);
      break;
      if ((paramFloat <= this.OFFSET_SCROLL_OVER) && (this.OFFSET_SCROLL_OVER != 0)) {
        setMicroAppEntryCompleteVisible(true);
      }
      f1 = 0.0F;
      break label226;
      label342:
      this.mContentView.setDotViewTranslationY(f1 + this.mContentView.getDotViewTranslationY());
    }
  }
  
  public static boolean isNightMode()
  {
    return ("1103".equals(ThemeUtil.getCurrentThemeId())) || ("2920".equals(ThemeUtil.getCurrentThemeId()));
  }
  
  private boolean needIntercept()
  {
    boolean bool = true;
    if ((this.mContentView == null) || (this.mListView == null)) {
      bool = false;
    }
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    do
    {
      return bool;
      arrayOfInt1 = new int[2];
      arrayOfInt2 = new int[2];
      this.mContentView.getLocationInWindow(arrayOfInt1);
      this.mListView.getLocationInWindow(arrayOfInt2);
    } while ((arrayOfInt1[1] >= arrayOfInt2[1]) && (this.mListView.getScrollY() < 0));
    return false;
  }
  
  private boolean needShowMiniAppStoreAnimation()
  {
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    if (localAppInterface == null) {
      QLog.e("QQMessagePageMicroAppEntryManager", 1, "[mini_app_anim].needShowMiniAppStoreAnimation, app is null.");
    }
    long l;
    do
    {
      return false;
      l = localAppInterface.getPreferences().getLong("key_mini_app_store_show_animation_time", 0L);
      l = System.currentTimeMillis() - l;
      QLog.e("QQMessagePageMicroAppEntryManager", 1, "[mini_app_anim].needShowMiniAppStoreAnimation, diff time = " + l);
    } while (l <= 86400000L);
    return true;
  }
  
  private void setMicroAppEntryCompleteVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mMiniAppListLayout.getTranslationY() != 0.0F) {
        this.mMiniAppListLayout.setTranslationY(0.0F);
      }
      if (this.mMiniAppListLayout.getAlpha() != 1.0F) {
        setMicroAppEntryPanelAlpha(1.0F);
      }
    }
    do
    {
      return;
      if (this.mMiniAppListLayout.getTranslationY() != STORY_TRANSLATE) {
        this.mMiniAppListLayout.setTranslationY(STORY_TRANSLATE);
      }
    } while (this.mMiniAppListLayout.getAlpha() == 0.0F);
    setMicroAppEntryPanelAlpha(0.0F);
  }
  
  private void setMicroAppEntryPanelAlpha(float paramFloat)
  {
    if (this.mMiniAppListLayout != null) {
      this.mMiniAppListLayout.setAlpha(paramFloat);
    }
  }
  
  private void setNightMode()
  {
    try
    {
      this.mListView.setOverscrollHeader(new ColorDrawable(Color.parseColor("#000000")));
      int i = this.mContext.getResources().getColor(2131167404);
      this.mChatTopRefresh.setTextColor(i, i, i, i, i);
      TextView localTextView = (TextView)this.mChatTopRefresh.findViewById(2131377036);
      if (localTextView != null) {
        localTextView.setTextColor(i);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QQMessagePageMicroAppEntryManager", 1, "setNightMode, e" + Log.getStackTraceString(localException));
    }
  }
  
  private void setNormalMode()
  {
    try
    {
      this.mListView.setOverscrollHeader(this.mContext.getResources().getDrawable(2130852004));
      int i = this.mContext.getResources().getColor(2131167365);
      this.mChatTopRefresh.setTextColor(i, i, i, i, i);
      TextView localTextView = (TextView)this.mChatTopRefresh.findViewById(2131377036);
      if (localTextView != null) {
        localTextView.setTextColor(i);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QQMessagePageMicroAppEntryManager", 1, "setNormalMode, e" + Log.getStackTraceString(localException));
    }
  }
  
  private void setRefreshLayoutVisible(boolean paramBoolean)
  {
    View localView = this.mChatTopRefresh.findViewById(2131377032);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2)
  {
    if ((paramPopupWindow != null) && (paramView != null))
    {
      paramPopupWindow.showAtLocation(paramView, 48, paramInt1, paramInt2);
      paramPopupWindow.setFocusable(true);
      paramPopupWindow.setTouchable(true);
      paramPopupWindow.setOutsideTouchable(true);
    }
    try
    {
      paramPopupWindow.update();
      paramView.postDelayed(new QQMessagePageMiniAppEntryManager.3(this, paramPopupWindow), 5000L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QQMessagePageMicroAppEntryManager", 1, "showAsDropDown.update() exception!");
      }
    }
  }
  
  private void shutdownMiniAppPullDownEntry()
  {
    try
    {
      if (this.mChatTopRefresh.indexOfChild(this.mContentView) >= 0)
      {
        hideMiniAppEntry();
        this.mChatTopRefresh.removeView(this.mContentView);
        setRefreshLayoutVisible(true);
        this.mListView.setMaxOverScrollTopDistance(30);
        this.mListView.setQQStoryListViewListener(null);
        this.mListView.scrollTo(0, 0);
        this.mListView.mEnableStory = false;
        this.mListView.mForStory = false;
        this.mode = 1;
        if (this.mDrawer != null) {
          this.mDrawer.FW(MainFragment.bIk);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QQMessagePageMicroAppEntryManager", 1, "shutdownMiniAppPullDownEntry, " + Log.getStackTraceString(localException));
    }
  }
  
  private void updateRefreshTheme()
  {
    try
    {
      if (this.refreshProgressBar != null)
      {
        Drawable localDrawable = this.mContext.getResources().getDrawable(2130839657);
        this.refreshProgressBar.setIndeterminateDrawable(localDrawable);
      }
      if (this.mChatTopRefresh != null) {
        this.mChatTopRefresh.setArrowColor(0);
      }
      if (isNightMode())
      {
        setNightMode();
        return;
      }
      setNormalMode();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQMessagePageMicroAppEntryManager", 1, "updateRefreshTheme error.", localThrowable);
    }
  }
  
  public int getMode()
  {
    return this.mode;
  }
  
  public int getSpringbackOffset(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    float f = paramARMapHongBaoListView.getScrollY();
    if (this.mode == 1)
    {
      this.mContentView.stopSwitchIconAnimation();
      this.mCareNotificationBar.refresh();
      MiniAppEntryLayout.exposureReport();
      return 0;
    }
    if (this.mode == 3)
    {
      if (needShowMiniAppStoreAnimation()) {
        this.mContentView.startSwitchIconAnimation();
      }
      this.mCareNotificationBar.hide();
      return -this.mContentView.getHeight();
    }
    if (this.mode == 2)
    {
      this.mCareNotificationBar.hide();
      return -paramARMapHongBaoListView.getOverScrollHeight();
    }
    return (int)f;
  }
  
  public void handlePullRefresh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMessagePageMicroAppEntryManager", 1, "[MiniAppUserAppInfoListManager]. handlePullRefresh");
    }
    MiniAppUtils.checkSendUserAppListRequest();
  }
  
  public boolean hasOpenDesktop()
  {
    return this.mode != 1;
  }
  
  public void hideMiniAppEntry()
  {
    if ((this.mListView.mEnableStory) && (this.mListView.mForStory))
    {
      this.mListView.setScrollY(0);
      this.mListView.mForStory = false;
      this.mode = 1;
      setMicroAppEntryCompleteVisible(false);
      setRefreshLayoutVisible(false);
    }
  }
  
  public void initLater(DrawerFrame paramDrawerFrame)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMessagePageMicroAppEntryManager", 2, paramDrawerFrame + " initLater " + this.mListView.mEnableStory);
    }
    this.mDrawer = paramDrawerFrame;
    if (this.mDrawer != null) {
      this.mDrawer.setMiniAppTouchEventInterceptor(MainFragment.bIk, this);
    }
  }
  
  public void initUI(Activity paramActivity)
  {
    QLog.d("QQMessagePageMicroAppEntryManager", 1, "initUI");
    if (this.mChatTopRefresh != null)
    {
      this.mContentView = new MiniAppEntryLayout(paramActivity, this.mListView, 0);
      this.mMiniAppListLayout = this.mContentView.getContainerView();
      this.mApp.registObserver(this);
      this.mApp.addObserver(this.appletsObserver);
      paramActivity = (MiniAppUserAppInfoListManager)this.mApp.getManager(309);
      if (this.mChatTopRefresh.indexOfChild(this.mContentView) < 0)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(3, 2131377032);
        this.mChatTopRefresh.addView(this.mContentView, localLayoutParams);
        this.refreshProgressBar = ((ProgressBar)this.mChatTopRefresh.findViewById(2131377037));
        updateRefreshTheme();
        this.mListView.setMaxOverScrollTopDistance(70);
        this.mListView.setQQStoryListViewListener(this);
        this.mListView.mEnableStory = true;
        this.mListView.mForStory = false;
        this.mode = 1;
        if (this.mDrawer != null) {
          this.mDrawer.setMiniAppTouchEventInterceptor(MainFragment.bIk, this);
        }
        this.mListView.setScrollY(0);
        setMicroAppEntryCompleteVisible(false);
        this.mContentView.resetDotViewStatus();
        this.mContentView.addOnLayoutChangeListener(new QQMessagePageMiniAppEntryManager.1(this));
      }
      if (paramActivity != null)
      {
        paramActivity.initLocalCacheData();
        paramActivity.sendUserAppListRequest(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue(), 20L);
      }
    }
  }
  
  public boolean interceptDrawer(View paramView, MotionEvent paramMotionEvent)
  {
    if (needIntercept()) {
      return this.mContentView.interceptDrawer(paramView, paramMotionEvent);
    }
    if (this.mListView != null) {
      QLog.e("QQMessagePageMicroAppEntryManager", 2, "interceptDrawer error. listView, scrollY: " + this.mListView.getScrollY());
    }
    return false;
  }
  
  public boolean isMiniAppLauncherOpened()
  {
    return false;
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    this.mApp.unRegistObserver(this);
    this.mApp.removeObserver(this.appletsObserver);
    this.mApp = paramQQAppInterface;
    boolean bool = false;
    Object localObject = aekv.a();
    if (localObject != null) {
      bool = ((aeku)localObject).agN();
    }
    QLog.d("QQMessagePageMicroAppEntryManager", 1, "[MiniAppUserAppInfoListManager].onAccountChanged: " + bool);
    if ((!bool) && (this.mChatTopRefresh != null) && (this.mContentView != null))
    {
      shutdownMiniAppPullDownEntry();
      QLog.d("QQMessagePageMicroAppEntryManager", 1, "onAccountChanged: shutDown mini app entry");
      return;
    }
    paramQQAppInterface.registObserver(this);
    this.appletsObserver = new RedDotAppletsObserver(this);
    paramQQAppInterface.addObserver(this.appletsObserver);
    localObject = (MiniAppUserAppInfoListManager)paramQQAppInterface.getManager(309);
    ((MiniAppUserAppInfoListManager)localObject).queryMiniAppInfoFromDb();
    ((MiniAppUserAppInfoListManager)localObject).asyncQueryMiniAppPushRedDotData();
    ThreadManager.executeOnSubThread(new QQMessagePageMiniAppEntryManager.2(this, paramQQAppInterface));
  }
  
  public void onChangeRedDotSwitch(int paramInt, boolean paramBoolean)
  {
    if ((this.mContentView != null) && (aekv.aha())) {
      this.mContentView.onChangeRedDotSwitch(paramInt, paramBoolean);
    }
  }
  
  public void onFlingScrollHeader(int paramInt1, int paramInt2)
  {
    if ((this.mListView.mEnableStory) && (this.mContentView != null))
    {
      if ((paramInt1 == 2) && (this.OFFSET_SCROLL_OVER != 0)) {
        doOnScroll(paramInt2, false);
      }
      if ((this.mContentView.getHeight() != 0) && (paramInt2 <= -this.mContentView.getHeight()))
      {
        setMicroAppEntryCompleteVisible(true);
        this.mContentView.resetDotViewStatus();
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    this.mContentView.onPostThemeChanged();
    updateRefreshTheme();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMessagePageMicroAppEntryManager", 2, "[MiniAppUserAppInfoListManager], onReceive, type = " + paramInt + " , mContentView = " + this.mContentView);
    }
    if (paramInt == 100) {
      hideMiniAppEntry();
    }
    do
    {
      for (;;)
      {
        return;
        if (paramInt == 103) {
          try
          {
            if (this.mContentView != null)
            {
              updateRefreshTheme();
              this.mContentView.updateHongBaoRes();
              return;
            }
          }
          catch (Throwable paramBundle)
          {
            QLog.e("QQMessagePageMicroAppEntryManager", 1, "TYPE_HONGBAO_UPDATE_DESKTOP_RES error.", paramBundle);
            return;
          }
        }
      }
    } while (this.mContentView == null);
    this.mContentView.updateMicroAppItemData();
  }
  
  public void onResume() {}
  
  public void onStop() {}
  
  public void onTouchMoving(ARMapHongBaoListView paramARMapHongBaoListView, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    if (this.mContentView.getVisibility() != 0) {
      this.mContentView.setVisibility(0);
    }
    if (this.OFFSET_SCROLL_OVER == 0) {
      this.OFFSET_SCROLL_OVER = (-this.mContentView.getHeight());
    }
    float f = paramARMapHongBaoListView.getScrollY();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return;
        } while (this.mode != 1);
        this.flag = true;
        setMicroAppEntryCompleteVisible(false);
        this.mContentView.resetDotViewStatus();
        return;
        if ((!this.flag) && (this.mode == 1))
        {
          this.flag = true;
          setMicroAppEntryCompleteVisible(false);
          this.mContentView.resetDotViewStatus();
        }
        if ((f <= 0.0F) && (this.mode == 1))
        {
          doOnScroll(f, true);
          return;
        }
      } while (f >= 0.0F);
      QLog.d("QQMessagePageMicroAppEntryManager", 2, "fight...onTouchMoving.onMove..scrollY = " + f);
      return;
    }
    int i = paramARMapHongBaoListView.getListViewScrollY();
    if ((i > 0) && (f == 0.0F))
    {
      this.mCareNotificationBar.Ct(false);
      this.mCareNotificationBar.refresh();
      this.flag = false;
      this.preMode = this.mode;
      if (f < 0.0F) {
        break label362;
      }
      if (paramARMapHongBaoListView.mForStory) {}
      this.mode = 1;
      paramARMapHongBaoListView.mForStory = false;
    }
    for (;;)
    {
      if ((this.preMode == 1) && (this.mode == 3))
      {
        this.mContentView.recordExposureItem();
        MiniProgramLpReportDC04239.reportPageView("expo_page", "pulldown_mini_msg");
      }
      setRefreshLayoutVisible(paramARMapHongBaoListView.mForStory);
      QLog.d("QQMessagePageMicroAppEntryManager", 2, "fight...onTouchMoving.onUp..scrollY = " + f);
      return;
      if (i != 0) {
        break;
      }
      this.mCareNotificationBar.Ct(true);
      this.mCareNotificationBar.refresh();
      break;
      label362:
      if (paramARMapHongBaoListView.mForStory)
      {
        if (f <= -paramARMapHongBaoListView.getOverScrollHeight())
        {
          paramMotionEvent = (TextView)this.mChatTopRefresh.findViewById(2131377036);
          if ((paramMotionEvent.getText().toString() != null) && (paramMotionEvent.getText().toString().contains(acfp.m(2131711871)))) {}
          for (this.mode = 3;; this.mode = 2)
          {
            paramARMapHongBaoListView.mForStory = true;
            break;
            QLog.d("QQMessagePageMicroAppEntryManager", 2, "story node start refresh onTouchMoving");
          }
        }
        if (f <= -this.mContentView.getHeight())
        {
          this.mode = 3;
          paramARMapHongBaoListView.mForStory = true;
        }
        else
        {
          this.mode = 1;
          paramARMapHongBaoListView.mForStory = false;
        }
      }
      else if (f <= -this.mContentView.getHeight())
      {
        if (this.mode != 2)
        {
          this.mode = 3;
          paramARMapHongBaoListView.mForStory = true;
        }
      }
      else if (f <= OFFSET_NODE_OPEN)
      {
        if (this.mode == 2)
        {
          setMicroAppEntryCompleteVisible(false);
        }
        else
        {
          this.mode = 3;
          paramARMapHongBaoListView.mForStory = true;
        }
      }
      else
      {
        this.mode = 1;
        paramARMapHongBaoListView.mForStory = false;
      }
    }
  }
  
  public int onViewCompleteAfterRefresh(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QQMessagePageMicroAppEntryManager", 2, "onViewCompleteAfterRefresh, mode:" + this.mode);
    }
    this.mContentView.updateMicroAppItemData();
    if (this.mode == 2) {
      if (paramARMapHongBaoListView.mForStory)
      {
        this.mode = 3;
        i = -this.mContentView.getHeight();
      }
    }
    while (this.mode != 3)
    {
      return i;
      this.mode = 1;
      return 0;
    }
    return -this.mContentView.getHeight();
  }
  
  public boolean showMicroAppEntry()
  {
    if ((this.mListView.mEnableStory) && (!this.mListView.mForStory) && (this.mListView.getListViewScrollY() == 0))
    {
      this.mListView.setScrollY(-this.mContentView.getHeight());
      this.mListView.mForStory = true;
      this.mode = 3;
      setMicroAppEntryCompleteVisible(true);
      this.mContentView.resetDotViewStatus();
      setRefreshLayoutVisible(true);
      return true;
    }
    return false;
  }
  
  static class RedDotAppletsObserver
    extends adah
  {
    private final WeakReference<QQMessagePageMiniAppEntryManager> miniAppEntryManagerWeakReference;
    
    public RedDotAppletsObserver(QQMessagePageMiniAppEntryManager paramQQMessagePageMiniAppEntryManager)
    {
      this.miniAppEntryManagerWeakReference = new WeakReference(paramQQMessagePageMiniAppEntryManager);
    }
    
    public void onAppletsSettingSwitchChange(int paramInt)
    {
      updateAppletsSettingSwitchState(paramInt);
    }
    
    protected void updateAppletsSettingSwitchState(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQMessagePageMicroAppEntryManager", 2, "updateAppletsSettingSwitchState:  switchState: " + paramInt);
      }
      QQMessagePageMiniAppEntryManager localQQMessagePageMiniAppEntryManager = (QQMessagePageMiniAppEntryManager)this.miniAppEntryManagerWeakReference.get();
      if (localQQMessagePageMiniAppEntryManager != null) {
        localQQMessagePageMiniAppEntryManager.onChangeRedDotSwitch(paramInt, false);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("QQMessagePageMicroAppEntryManager", 2, "updateAppletsSettingSwitchState failed! miniAppEntryManager is null! ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager
 * JD-Core Version:    0.7.0.1
 */