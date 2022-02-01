import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.DrawerFrame.a;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public abstract class wsr
  implements DrawerFrame.a
{
  private DrawerFrame.a jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$a = new wsu(this);
  private DrawerFrame jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
  private int bRz;
  private boolean bfP;
  private Rect bk;
  public BaseChatPie c;
  private Drawable dJ;
  public ViewGroup dl;
  public ViewGroup dm;
  private MessageQueue.IdleHandler f = new wss(this);
  private ImmersiveTitleBar2 i;
  public FragmentActivity mActivity;
  public QQAppInterface mApp;
  public Context mContext;
  public SessionInfo mSessionInfo;
  private View wx;
  
  public wsr(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie == null) {}
    this.c = paramBaseChatPie;
    this.mApp = this.c.app;
    this.mActivity = this.c.mActivity;
    this.mContext = this.c.mContext;
    this.mSessionInfo = this.c.sessionInfo;
    this.dl = this.c.mAIORootView;
    this.dm = this.c.cL;
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame = this.c.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.setDrawerEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.setDrawerCallbacks(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$a);
    cbx();
    Looper.myQueue().addIdleHandler(this.f);
  }
  
  private boolean RO()
  {
    return (this.i != null) && (this.i.getParent() != null);
  }
  
  private boolean RP()
  {
    boolean bool = true;
    if ((ThemeUtil.isNowThemeIsNight(this.mApp, true, null)) || (anlm.ayn())) {
      bool = false;
    }
    return bool;
  }
  
  private SystemBarCompact b()
  {
    if (this.mActivity != null)
    {
      Fragment localFragment = this.mActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localFragment != null) {
        return ((ChatFragment)localFragment).b;
      }
    }
    return null;
  }
  
  private void cbA()
  {
    boolean bool = RO();
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, "updateImmersiveTitleBar, isVisible: " + bool);
    }
    if (bool)
    {
      SystemBarCompact localSystemBarCompact = b();
      if (localSystemBarCompact != null)
      {
        this.dJ = localSystemBarCompact.mStatusBarDarwable;
        this.bRz = localSystemBarCompact.mStatusBarColor;
      }
      this.c.ay(0, false);
      if (this.dJ == null) {
        break label112;
      }
      this.i.setBackgroundDrawable(this.dJ);
    }
    for (;;)
    {
      if (RP()) {
        ImmersiveUtils.setStatusTextColor(true, this.mActivity.getWindow());
      }
      return;
      label112:
      this.i.setBackgroundColor(this.bRz);
    }
  }
  
  private void cbx()
  {
    NavBarAIO localNavBarAIO = this.c.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (localNavBarAIO != null) {
      localNavBarAIO.addOnLayoutChangeListener(new wst(this, localNavBarAIO));
    }
  }
  
  private void cby()
  {
    boolean bool = RO();
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, "addImmersiveTitleBar, isVisible: " + bool);
    }
    if (!bool)
    {
      if (this.i == null) {
        this.i = new ImmersiveTitleBar2(this.mContext);
      }
      this.bk = new Rect(this.dl.getPaddingLeft(), this.dl.getPaddingTop(), this.dl.getPaddingRight(), this.dl.getPaddingBottom());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      this.dl.addView(this.i, localLayoutParams);
      ((TopGestureLayout)this.dl).setPadding2(0, 0, 0, 0);
      this.dl.setFitsSystemWindows(false);
      localLayoutParams = (RelativeLayout.LayoutParams)this.dm.getLayoutParams();
      localLayoutParams.leftMargin += this.bk.left;
      localLayoutParams.rightMargin += this.bk.right;
      localLayoutParams.topMargin += this.bk.top;
      localLayoutParams.bottomMargin += this.bk.bottom;
      this.dm.setFitsSystemWindows(true);
      cbA();
    }
  }
  
  private void cbz()
  {
    boolean bool = RO();
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, "removeImmersiveTitleBar, isVisible: " + bool);
    }
    if (bool)
    {
      this.dl.removeView(this.i);
      this.dl.setFitsSystemWindows(true);
      if (this.bk != null) {
        this.dl.setPadding(this.bk.left, this.bk.top, this.bk.right, this.bk.bottom);
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.dm.getLayoutParams();
      if (this.bk != null)
      {
        localLayoutParams.leftMargin -= this.bk.left;
        localLayoutParams.rightMargin -= this.bk.right;
        localLayoutParams.topMargin -= this.bk.top;
        localLayoutParams.bottomMargin -= this.bk.bottom;
      }
      this.dm.setFitsSystemWindows(false);
      if (this.dJ == null) {
        break label230;
      }
      this.c.N(this.dJ);
    }
    for (;;)
    {
      if (RP()) {
        ImmersiveUtils.setStatusTextColor(false, this.mActivity.getWindow());
      }
      return;
      label230:
      this.c.ay(this.bRz, false);
    }
  }
  
  public void AD(int paramInt) {}
  
  public void CN(int paramInt) {}
  
  public void cbB() {}
  
  public void cbC() {}
  
  public void cbw()
  {
    if (!this.bfP) {}
    try
    {
      this.wx = onCreateView();
      if (this.wx == null) {}
      this.bfP = true;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        QLog.d("BaseChatDrawer", 1, "BaseChatDrawer createDrawerView oom", localOutOfMemoryError);
      }
    }
    if ((this.wx != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.ay(this.wx, 1);
      initData();
    }
  }
  
  public void close(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.Cn(paramBoolean);
    }
  }
  
  public void doOnDestroy() {}
  
  public void doOnPause() {}
  
  public void doOnResume() {}
  
  public void h(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected abstract void initData();
  
  public boolean isOpen()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.Wt();
    }
    return false;
  }
  
  public void m(int paramInt, float paramFloat) {}
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  protected abstract View onCreateView();
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.ehR();
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.setDrawerCallbacks(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame = null;
    }
    Looper.myQueue().removeIdleHandler(this.f);
    cbz();
    if (this.bfP) {
      doOnDestroy();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, String.format("onDestroy, mHadInflated: %s", new Object[] { Boolean.valueOf(this.bfP) }));
    }
  }
  
  public void onDrawerClosed() {}
  
  public void onDrawerOpened() {}
  
  public void onPause()
  {
    if (this.bfP) {
      doOnPause();
    }
  }
  
  public void onResume()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.Wt())) {
      cbA();
    }
    if (this.bfP) {
      doOnResume();
    }
  }
  
  public void setEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null) {}
  }
  
  public void yY(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.openDrawer(1, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wsr
 * JD-Core Version:    0.7.0.1
 */