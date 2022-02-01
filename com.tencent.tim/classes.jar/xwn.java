import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.b;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller;
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller.a;
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie.4;
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie.5;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class xwn
  extends BaseChatPie
  implements MoveToBottomScroller.a
{
  protected long JF;
  public apmp a;
  protected ProxyObserver a;
  public TroopAIORobotLayout a;
  public boolean aCV;
  public String aWO;
  public String aWP;
  public boolean aaR;
  protected boolean bkc;
  protected boolean bkd;
  protected boolean bke;
  public boolean bkf;
  public boolean bkg;
  protected ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
  
  public xwn(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new xwp(this);
  }
  
  public void Ib()
  {
    this.TAG = "BaseTroopChatPie";
  }
  
  public boolean OI()
  {
    boolean bool = false;
    if ((this.aey) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public void R(MotionEvent paramMotionEvent)
  {
    wxk localwxk = (wxk)this.jdField_a_of_type_Wvm.a(23);
    if ((localwxk != null) && (localwxk.c(paramMotionEvent, this.aSN))) {
      return;
    }
    super.R(paramMotionEvent);
  }
  
  public boolean SV()
  {
    return false;
  }
  
  public boolean SW()
  {
    return this.aaR;
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 3)
    {
      long l = System.currentTimeMillis();
      this.c = ((EmoticonMainPanel)this.mActivity.getLayoutInflater().inflate(2131559281, null));
      this.c.setCallBack(this);
      EmoticonMainPanel localEmoticonMainPanel = this.c;
      if ((isFullScreenMode()) || (this.aSM)) {}
      for (boolean bool = true;; bool = false)
      {
        localEmoticonMainPanel.bYY = bool;
        if (isFullScreenMode()) {
          this.c.setHideAllSettingTabs(true);
        }
        this.c.bZc = this.aSM;
        this.c.bYZ = this.aSM;
        this.c.a(this.app, this.sessionInfo.cZ, this.mActivity, this.mActivity.getTitleBarHeight(), this.aLB, this.bED, this);
        if (QLog.isColorLevel()) {
          QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
        }
        if (this.aaR) {
          this.c.HW(this.aaR);
        }
        return this.c;
      }
    }
    return super.a(paramInt);
  }
  
  public QQRecorder.RecorderParam a()
  {
    boolean bool = super.Pc();
    return aqlv.a(this.app, bool);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    wxo localwxo = (wxo)a(53);
    wur localwur = (wur)a(52);
    if ((localwxo != null) && (localwur != null) && (localwur.bgd) && (localwxo.St())) {
      localwur.r(this.fs);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_Wki.getCount() > 0)
    {
      this.Fp = SystemClock.uptimeMillis();
      ((wkk)this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.context).fU(this.Fp);
      if (this.jdField_a_of_type_Apat != null) {
        if (this.jdField_a_of_type_Apat.valid)
        {
          this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQi = true;
          this.app.b().a().a(this.sessionInfo.aTl, this.sessionInfo.cZ, this.jdField_a_of_type_Apat.aqG, this.jdField_a_of_type_Apat.aqH, this.jdField_a_of_type_Apat.aPY, this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b);
          this.jdField_a_of_type_Apat.dYv();
          if ((this.sessionInfo.cZ == 1) && (this.app.cs(this.sessionInfo.aTl) == 3)) {
            anot.a(this.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_more_history", 0, 0, this.sessionInfo.aTl, "", "", "");
          }
        }
      }
    }
    for (;;)
    {
      return true;
      this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQi = false;
      this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQj = true;
      if (!this.bkd)
      {
        this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, 20, this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b);
        break;
      }
      this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b);
      this.bkd = false;
      break;
      this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQi = false;
      this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQj = true;
      if (!this.bkd)
      {
        this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, 20, this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b);
        break;
      }
      this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b);
      this.bkd = false;
      break;
      vY(false);
    }
  }
  
  protected void aD(Object paramObject)
  {
    paramObject = (apab.a)paramObject;
    if (paramObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "handleUpdateTroopAioAgentMessage: " + paramObject.type);
      }
      if (paramObject.type != apab.dSq) {
        break label74;
      }
      a(paramObject.dSt, paramObject.hp(), paramObject.dSu, null);
    }
    label74:
    while ((paramObject.type != apab.dSr) || (this.rE == null)) {
      return;
    }
    ((RelativeLayout.LayoutParams)this.rE.getLayoutParams()).addRule(2, paramObject.id);
  }
  
  public void aF(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.rE != null) {
      super.aF(paramBoolean1, paramBoolean2);
    }
    Object localObject;
    do
    {
      return;
      super.aF(paramBoolean1, paramBoolean2);
      localObject = (wxk)this.jdField_a_of_type_Wvm.a(23);
      if (localObject != null) {
        ((wxk)localObject).fg(this.rE);
      }
      localObject = (wur)a(52);
    } while (localObject == null);
    ((wur)localObject).a(this.fs, this.rE);
  }
  
  public void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if (((apsw)this.app.getManager(48)).a(this.sessionInfo.aTl, true).cSk) {}
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        break;
      }
    } while (!this.sessionInfo.beA);
    BaseChatpieHelper.a(this.sessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_b_of_type_ComTencentWidgetPatchedButton, false);
    return;
    if ((this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 2) && (this.app.getApplication().getResources().getConfiguration().orientation == 2)) {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
    }
    if (this.sessionInfo.beA)
    {
      if ("0".equals(paramString1))
      {
        BaseChatpieHelper.a(this.sessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_b_of_type_ComTencentWidgetPatchedButton, false);
        return;
      }
      this.sessionInfo.aTq = paramString1;
      this.bEk = 131077;
      refresh(this.bEk);
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(acfp.m(2131703155));
      this.uiHandler.postDelayed(new BaseTroopChatPie.4(this), 200L);
      return;
    }
    this.uiHandler.postDelayed(new BaseTroopChatPie.5(this, paramBoolean, paramString1, paramString2, paramInt), 300L);
  }
  
  public void bGE()
  {
    super.bGE();
    if (this.mOnGlobalLayoutListener != null)
    {
      this.mOnGlobalLayoutListener = new xwo(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }
    this.mTitleText.setTextColor(this.mActivity.getResources().getColor(2131167301));
    this.Cu.setTextColor(this.mActivity.getResources().getColor(2131167301));
    this.Cr.setTextColor(this.mActivity.getResources().getColor(2131167298));
    wxk localwxk = (wxk)this.jdField_a_of_type_Wvm.a(23);
    if (localwxk != null) {
      localwxk.cdg();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.TQ(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller.a(this);
    }
  }
  
  public void bGJ()
  {
    super.bGJ();
    this.aSc = false;
  }
  
  public void bGZ()
  {
    a(this.pp, 2130851139, 2130851146);
  }
  
  public void bHa()
  {
    String str = aqgv.a(this.app, this.sessionInfo.aTl, this.sessionInfo.troopUin, aqgv.jZ(this.sessionInfo.cZ), 3);
    this.sessionInfo.aTn = str;
  }
  
  public void bIb()
  {
    super.bIb();
    this.aLz = "";
  }
  
  public void bJf()
  {
    super.bJf();
    this.jdField_a_of_type_Wvm.a(this);
  }
  
  public void bZR() {}
  
  public void bn(Intent paramIntent)
  {
    super.bn(paramIntent);
    if (this.aaR)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378466).setVisibility(8);
    }
    int i = paramIntent.getIntExtra("input_panel_status", 0);
    if (i > 0) {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.cm(i, false);
    }
    paramIntent = paramIntent.getBundleExtra("key_invoke_troop_robot_function");
    wxk localwxk = (wxk)this.jdField_a_of_type_Wvm.a(23);
    if (localwxk != null) {
      localwxk.bz(paramIntent);
    }
  }
  
  public void bo(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("uinname");
    if (paramIntent != null) {
      this.sessionInfo.aTn = paramIntent;
    }
    for (;;)
    {
      this.mTitleText.setText(new aofe(this.sessionInfo.aTn, 32).k());
      if (AppSetting.enableTalkBack)
      {
        paramIntent = this.mTitleText.getText().toString();
        this.mTitleText.setContentDescription(paramIntent);
        a().setTitle(this.mTitleText.getText());
      }
      return;
      bHa();
    }
  }
  
  protected void cft()
  {
    Aa(0);
  }
  
  protected void cfu()
  {
    this.JF = System.currentTimeMillis();
    this.pp.setContentDescription(this.mActivity.getString(2131721370));
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "--->current AIO info<--- onresume. troopUin:" + this.sessionInfo.troopUin + ",curFriendUin:" + this.sessionInfo.aTl + ",type:" + this.sessionInfo.cZ);
    }
  }
  
  protected void cfv()
  {
    if (this.jdField_a_of_type_Apat == null) {
      this.jdField_a_of_type_Apat = new apat();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(this.jdField_a_of_type_Apat);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "Base#onShow_troopType#setTroopTips");
      }
    }
    this.jdField_a_of_type_Apat.onResume();
    this.jdField_a_of_type_Apat.a(this.app, this.mActivity, this, this.sessionInfo, this.fs, this.jdField_a_of_type_Wki, this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    if ((this.jdField_a_of_type_Apat != null) && (this.jdField_a_of_type_Yjh.wN() != 9)) {
      this.jdField_a_of_type_Apat.dYs();
    }
    cfw();
  }
  
  void cfw()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleGrayTipsMsg");
    }
    Object localObject = (apuf)this.app.getManager(81);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "troopTipsMsgMgr == null");
      }
    }
    while ((this.sessionInfo.cZ != 1) || (!((apuf)localObject).qZ(this.sessionInfo.aTl))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "troopAIO has unread troopTipMsg");
    }
    localObject = new BaseTroopChatPie.3(this, (apuf)localObject);
    ThreadManager.getSubThreadHandler().post((Runnable)localObject);
  }
  
  public void cfx()
  {
    vW(true);
  }
  
  @TargetApi(16)
  public void doOnDestroy()
  {
    if (this.aSY)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "hasDestory = true return");
      }
      return;
    }
    if (this.jdField_a_of_type_Apat != null) {
      this.jdField_a_of_type_Apat.uninit();
    }
    if (this.jdField_a_of_type_Apmp != null)
    {
      this.jdField_a_of_type_Apmp.destory();
      this.jdField_a_of_type_Apmp = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        break label137;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
    }
    for (;;)
    {
      this.mOnGlobalLayoutListener = null;
      cft();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.TQ(false);
      }
      wxk localwxk = (wxk)this.jdField_a_of_type_Wvm.a(23);
      if (localwxk != null) {
        localwxk.cdh();
      }
      super.doOnDestroy();
      return;
      label137:
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Apat != null) {
      this.jdField_a_of_type_Apat.onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    cfu();
  }
  
  public void doOnStop()
  {
    if (!this.aSY)
    {
      Object localObject = (apnu)this.app.getManager(363);
      if (localObject != null)
      {
        ((apnu)localObject).gl(this.sessionInfo.aTl, 0);
        if (this.jdField_a_of_type_Apat != null)
        {
          localObject = this.jdField_a_of_type_Apat.a();
          if (localObject != null) {
            ((apmz)localObject).ee.set(false);
          }
        }
      }
    }
    super.doOnStop();
  }
  
  public boolean fV(int paramInt)
  {
    if (this.jdField_a_of_type_Apat != null) {
      this.jdField_a_of_type_Apat.uninit();
    }
    return super.fV(paramInt);
  }
  
  public boolean isDestroy()
  {
    return this.aSY;
  }
  
  public void k(Object paramObject)
  {
    super.k(paramObject);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Apat != null) {
      this.jdField_a_of_type_Apat.uninit();
    }
    return super.onBackEvent();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
    int j = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    if ((this.jdField_a_of_type_Apat != null) && (this.jdField_a_of_type_Apat.aAN()) && (this.jdField_a_of_type_Wki != null) && (!this.jdField_a_of_type_Apat.a().ee.get()))
    {
      if ((!apmz.ma(this.jdField_a_of_type_Apat.Lf())) || (paramInt2 <= 0)) {
        break label239;
      }
      List localList = this.jdField_a_of_type_Wki.getList();
      int k = localList.size();
      int m = paramInt1 + paramInt2 - j - i;
      if (QLog.isColorLevel()) {
        QLog.i("BaseTroopChatPieOnScroll", 2, "firstVisibleItem = " + paramInt1 + ",visibleItemCount = " + paramInt2 + ",totalItemCount = " + paramInt3 + ",footerCnt = " + i + ",headerCnt = " + j + ", listSize = " + k);
      }
      if ((paramInt1 >= 0) && (paramInt1 <= m) && (m < k))
      {
        localList = localList.subList(paramInt1, m);
        this.jdField_a_of_type_Apat.mM(localList);
      }
    }
    for (;;)
    {
      super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      return;
      label239:
      this.jdField_a_of_type_Apat.Wx(0);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {
      if (this.jdField_a_of_type_Apdd$a != null)
      {
        if ((this.jdField_a_of_type_Apdd$a.actionType == apdd.a.dTx) && (this.jdField_a_of_type_Apdd$a.a != null)) {
          a(this.jdField_a_of_type_Apdd$a.a.dSt, this.jdField_a_of_type_Apdd$a.a.hp(), this.jdField_a_of_type_Apdd$a.a.dSu, null);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG + ".trooptroop_pull_msg", 2, "update,mUserActionState.actionType" + this.jdField_a_of_type_Apdd$a.actionType);
        }
        this.jdField_a_of_type_Apdd$a = null;
        this.app.b().a().deleteObservers();
      }
    }
    while (!(paramObject instanceof apab.a)) {
      return;
    }
    aD(paramObject);
  }
  
  public void vU(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.Cu.getVisibility() == 8))
    {
      this.Cu.setVisibility(0);
      this.mTitleText.setTextSize(1, 17.0F);
      this.Ct.setTextSize(1, 17.0F);
    }
    while ((paramBoolean) || (this.Cu.getVisibility() != 0) || (this.aaR)) {
      return;
    }
    this.Cu.setVisibility(8);
    this.mTitleText.setTextSize(1, 17.0F);
    this.Ct.setTextSize(1, 17.0F);
  }
  
  public void vW(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Apat != null) {
      this.jdField_a_of_type_Apat.uninit();
    }
    super.vW(paramBoolean);
  }
  
  public void wc(boolean paramBoolean)
  {
    if (this.sessionInfo.cZ != 1) {}
    while (((this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 0) && (!paramBoolean)) || (this.jdField_a_of_type_Apmp == null) || (!this.jdField_a_of_type_Apmp.aBl())) {
      return;
    }
    this.jdField_a_of_type_Apmp.eaE();
  }
  
  public void zU(int paramInt)
  {
    super.zU(paramInt);
    Object localObject = (wxk)this.jdField_a_of_type_Wvm.a(23);
    if (localObject != null) {
      ((wxk)localObject).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout, this.fs);
    }
    localObject = (wur)a(52);
    if (localObject != null) {
      ((wur)localObject).r(this.fs);
    }
  }
  
  public class a
    extends achq
  {
    public a() {}
    
    protected void U(boolean paramBoolean, String paramString)
    {
      xwn.this.refresh(65536);
    }
    
    protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
    {
      if ((paramString1 == null) || (!paramString1.equals(xwn.this.sessionInfo.aTl)) || (paramInt1 != xwn.this.sessionInfo.cZ))
      {
        if (QLog.isColorLevel()) {
          QLog.d(xwn.this.TAG, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(xwn.this.TAG, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      paramSendMessageHandler = xwn.this.app.a(true);
      if ((paramSendMessageHandler.kj(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        acfx.a(xwn.this.app, paramSendMessageHandler.a(paramString1), paramString2, true);
        if ((paramInt2 == 112) || (paramInt2 == 113))
        {
          acgh.o(xwn.this.app, paramString1, 6);
          acgh.cr(xwn.this.app);
        }
      }
      xwn.this.refresh(196608);
    }
    
    protected void a(boolean paramBoolean, String paramString, long paramLong)
    {
      a(paramBoolean, paramString, paramLong, null);
    }
    
    protected void a(boolean paramBoolean, String paramString, long paramLong, MessageHandler.d paramd)
    {
      if ((paramString == null) || (paramString.length() == 0)) {}
      while (!paramString.equals(xwn.this.sessionInfo.aTl)) {
        return;
      }
      xwn.this.aSt = true;
      xwn.this.a(262144, paramd, paramLong);
    }
    
    public void b(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(xwn.this.TAG + ".troop.revoked_troop_msg", 2, "isSuccess:" + paramBoolean1);
      }
      if (!paramBoolean1) {
        return;
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Object localObject = (MessageRecord)paramList.get(0);
        if (xwn.this.a != null)
        {
          int i = xwn.this.a.Lf();
          if (i != -1)
          {
            apnu localapnu = (apnu)xwn.this.app.getManager(363);
            long l = localapnu.aQ(xwn.this.sessionInfo.aTl);
            if (((MessageRecord)localObject).uniseq == l) {
              localapnu.gl(xwn.this.sessionInfo.aTl, i);
            }
            xwn.this.a.fG(((MessageRecord)localObject).uniseq);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder("onMsgRevokeNotice==>");
              ((StringBuilder)localObject).append("navigateType:").append(i).append("|navigaeSeq:").append(l);
              QLog.d(xwn.this.TAG + ".troop.special_msg", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
      super.b(paramBoolean1, paramList, paramBoolean2);
    }
    
    public void yh(String paramString)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
      }
      xwn.this.refresh(131072);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwn
 * JD-Core Version:    0.7.0.1
 */