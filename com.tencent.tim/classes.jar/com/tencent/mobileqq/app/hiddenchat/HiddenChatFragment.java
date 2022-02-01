package com.tencent.mobileqq.app.hiddenchat;

import aajb;
import aajg;
import aakz;
import aala;
import aalb;
import accc;
import accd;
import acfd;
import acff;
import acfs;
import acms;
import acnd;
import acqa;
import acqb;
import acqc;
import acqd;
import acxw;
import aizp;
import ajpd;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import anot;
import anov;
import aqft;
import aqiw;
import aqnm;
import ausb;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import tog;
import wkh;
import wvo;

public class HiddenChatFragment
  extends IphoneTitleBarFragment
  implements aajb, Handler.Callback, View.OnClickListener, DragFrameLayout.c, Observer
{
  private MqqHandler E;
  private aala jdField_a_of_type_Aala;
  protected accd a;
  private acfd jdField_a_of_type_Acfd = new acqd(this);
  private acqa jdField_a_of_type_Acqa;
  MiniMsgUser jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  aajg jdField_b_of_type_Aajg;
  private acnd jdField_b_of_type_Acnd = new acqc(this);
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  private QQAppInterface mApp;
  XListView u;
  
  public HiddenChatFragment()
  {
    this.jdField_a_of_type_Accd = new acqb(this);
  }
  
  public static void b(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("FromType", paramInt1);
    localIntent.putExtra("should_restore_from_kill", false);
    PublicFragmentActivity.startForResult((Activity)paramContext, localIntent, HiddenChatFragment.class, paramInt2);
  }
  
  public static List<RecentUser> i(List<RecentUser> paramList1, List<RecentUser> paramList2)
  {
    if ((paramList2 == null) || (paramList2.isEmpty())) {
      return paramList1;
    }
    paramList2 = paramList2.iterator();
    label22:
    label51:
    label120:
    label121:
    for (;;)
    {
      RecentUser localRecentUser1;
      int i;
      if (paramList2.hasNext())
      {
        localRecentUser1 = (RecentUser)paramList2.next();
        Iterator localIterator = paramList1.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          RecentUser localRecentUser2 = (RecentUser)localIterator.next();
          if ((localRecentUser1.getType() != localRecentUser2.getType()) || (!localRecentUser2.uin.equals(localRecentUser1.uin))) {
            break label120;
          }
          i = 1;
        }
      }
      for (;;)
      {
        break label51;
        if (i != 0) {
          break label121;
        }
        paramList1.add(localRecentUser1);
        break label22;
        break;
      }
    }
  }
  
  private void jp(List<RecentBaseData> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode() != -1) || (getActivity() == null) || (getActivity().getIntent() == null)) {}
    while (this.jdField_b_of_type_Aajg == null) {
      return;
    }
    this.jdField_b_of_type_Aajg.FX(0);
    this.jdField_b_of_type_Aajg.cS(paramList);
    int m = getActivity().getIntent().getIntExtra("FromType", 0);
    int j;
    int i;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      j = 0;
      i = 0;
      if (paramList.hasNext())
      {
        int k;
        if (((RecentBaseData)paramList.next()).ng() == 1)
        {
          k = j;
          j = i + 1;
        }
        for (i = k;; i = k)
        {
          k = j;
          j = i;
          i = k;
          break;
          k = j + 1;
          j = i;
        }
      }
    }
    for (;;)
    {
      anot.a(getActivity().app, "dc00898", "", "", "0X800A34B", "0X800A34B", m, j, "" + i, "0", "", "");
      return;
      j = 0;
      i = 0;
    }
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    Object localObject;
    String str1;
    if (paramBoolean)
    {
      localObject = this.mApp.a().a();
      str1 = paramRecentBaseData.qx();
      paramString = (acff)this.mApp.getManager(51);
      if (paramInt != 5000) {
        break label91;
      }
      if (this.jdField_a_of_type_Aala != null) {
        this.jdField_a_of_type_Aala.a(paramRecentBaseData, paramBoolean);
      }
    }
    for (;;)
    {
      label60:
      anot.a(this.mApp, "dc00898", "", "", "0X800A353", "0X800A353", 0, 0, "0", "0", "", "");
      label91:
      label238:
      do
      {
        String str2;
        do
        {
          return;
          break;
          if (paramInt == 5001)
          {
            ((acfs)this.mApp.getManager(255)).aM(paramBoolean);
            break label60;
          }
          if (paramInt != 1) {
            break label531;
          }
          paramString = (TroopManager)this.mApp.getManager(52);
          str2 = paramString.jr(paramRecentBaseData.qx());
          if (TextUtils.isEmpty(str2)) {
            break label340;
          }
          localObject = (accc)this.mApp.getBusinessHandler(22);
          if (!paramBoolean) {
            break label318;
          }
          paramInt = 0;
        } while (!((accc)localObject).N(str2, paramInt));
        paramString = paramString.c(paramRecentBaseData.qx());
        if (paramString != null) {}
        switch (paramString.troopmask)
        {
        case 2: 
        case 3: 
        default: 
          paramInt = 0;
          paramString = new anov(this.mApp).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
          localObject = paramRecentBaseData.qx();
          if (!paramBoolean) {
            break;
          }
        }
        for (paramRecentBaseData = "0";; paramRecentBaseData = "1")
        {
          paramString.a(new String[] { localObject, String.valueOf(paramInt), paramRecentBaseData }).report();
          break;
          paramInt = 1;
          break label177;
          paramInt = 0;
          break label238;
          paramInt = 3;
          break label238;
        }
        if (QLog.isColorLevel()) {
          QLog.e("tag_hidden_chat", 2, "TroopManage.getTroopCodeByTroopUin return null...");
        }
        paramInt = paramRecentBaseData.ng();
        if ((str1 != null) && (str1.length() != 0) && (localObject != null)) {
          break label457;
        }
      } while (!QLog.isColorLevel());
      label177:
      label318:
      label340:
      paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
      if (str1 == null)
      {
        paramBoolean = true;
        paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
        if (localObject != null) {
          break label451;
        }
      }
      label451:
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("tag_hidden_chat", 2, paramBoolean);
        return;
        paramBoolean = false;
        break;
      }
      label457:
      paramString = ((acxw)localObject).b(str1, paramInt);
      paramRecentBaseData = paramString;
      if (paramString == null) {
        paramRecentBaseData = new RecentUser(str1, paramInt);
      }
      if (ajpd.d(this.mApp, paramRecentBaseData))
      {
        if (paramBoolean) {}
        for (paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);; paramRecentBaseData.showUpTime = 0L)
        {
          ((acxw)localObject).e(paramRecentBaseData);
          bOm();
          break;
        }
        label531:
        if ((paramInt == 0) && (paramString.isFriend(str1)))
        {
          paramRecentBaseData = this.mApp;
          if (paramBoolean) {}
          for (int i = 1;; i = 2)
          {
            anot.a(paramRecentBaseData, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i, "0", "0", "", "");
            if (aqiw.isNetworkAvailable(this.mApp.getApp().getApplicationContext())) {
              break;
            }
            QQToast.a(getActivity(), 1, 2131698346, 0).show(getActivity().getTitleBarHeight());
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("tag_hidden_chat", 2, "setChatAtTop top: " + paramBoolean + " uin: " + str1 + " userType: " + paramInt);
          }
          FriendsStatusUtil.g(this.mApp, str1, paramBoolean);
        }
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((!(paramRecentBaseData instanceof RecentUserBaseData)) && (QLog.isColorLevel())) {
      QLog.d("tag_hidden_chat", 2, "NOT THE RIGHT Recent type");
    }
    paramView = ((RecentUserBaseData)paramRecentBaseData).a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("hidden_aio_msg_source", 1);
    aalb.a(getActivity(), this.mApp, paramView, paramString, paramBoolean, 0, paramRecentBaseData, localBundle, null);
    getActivity().overridePendingTransition(2130772004, 2130772005);
    paramRecentBaseData.cuQ();
    ausb.a(this.mApp).ZA(paramRecentBaseData.qx());
    if (paramView != null)
    {
      paramRecentBaseData = (FeedsManager)this.mApp.getManager(275);
      paramRecentBaseData.setFeedInfoRead(paramView.uin);
      if (!FeedsManager.isShowStatus(paramView.uin)) {
        break label186;
      }
      paramString = (wkh)this.mApp.getManager(282);
      if (paramString != null)
      {
        long l = paramString.T(paramView.uin);
        FeedsManager.saveToken(paramView.uin, l);
        paramRecentBaseData.reportClickExpose();
        paramString.report(2, 2);
      }
    }
    label186:
    do
    {
      do
      {
        return;
        paramView = this.mApp.b().d(paramView.uin, paramView.getType());
      } while ((paramView == null) || (paramView.msgtype != -1034));
      paramView = (wkh)this.mApp.getManager(282);
    } while (paramView == null);
    paramView.report(2, 1);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    paramString = null;
    int i = -1;
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)paramRecentBaseData;
      paramString = localRecentUserBaseData.a();
      i = localRecentUserBaseData.mPosition;
    }
    if (paramString != null)
    {
      aakz.a(this.mApp, paramRecentBaseData, paramString);
      aalb.a(this.mApp, paramString, i);
      aizp.a().k(paramString.uin, this.mApp);
    }
    bOm();
    anot.a(this.mApp, "dc00898", "", "", "0X800A352", "0X800A352", 0, 0, "0", "0", "", "");
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = getResources();
    int i = paramRecentBaseData.ng();
    if ((i == 1) && (this.jdField_a_of_type_Aala == null)) {
      this.jdField_a_of_type_Aala = new aala(this.mApp, getActivity());
    }
    if (aqft.equalsWithNullCheck(paramString1, localResources.getString(2131692274)))
    {
      a(i, paramRecentBaseData, paramString2, false);
      if (!aqft.equalsWithNullCheck(paramString1, localResources.getString(aakb.fy[4]))) {
        break label242;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString2 = (RecentUserBaseData)paramRecentBaseData;
        aalb.a(this.mApp, paramString2.a(), true, true);
        bOm();
      }
      label114:
      if (aqft.equalsWithNullCheck(paramString1, localResources.getString(2131692273)))
      {
        if (aqiw.isNetSupport(BaseApplication.getContext())) {
          break label300;
        }
        QQToast.a(BaseApplication.getContext(), 2131693404, 1, 0).show(getActivity().getTitleBarHeight());
      }
    }
    label242:
    do
    {
      return;
      if (aqft.equalsWithNullCheck(paramString1, localResources.getString(2131692278)))
      {
        a(i, paramRecentBaseData, paramString2, true);
        break;
      }
      if (aqft.equalsWithNullCheck(paramString1, localResources.getString(2131694512)))
      {
        a(i, paramRecentBaseData, paramString2, false);
        break;
      }
      if (!aqft.equalsWithNullCheck(paramString1, localResources.getString(2131694514))) {
        break;
      }
      a(i, paramRecentBaseData, paramString2, true);
      break;
      if ((!aqft.equalsWithNullCheck(paramString1, localResources.getString(aakb.fy[5]))) || (!(paramRecentBaseData instanceof RecentUserBaseData))) {
        break label114;
      }
      paramString2 = ((RecentUserBaseData)paramRecentBaseData).a();
      this.mApp.a().D(paramString2.uin, paramString2.getType(), 1);
      bOm();
      break label114;
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, "onMenuItemClick mHiddenChat cancel hide");
      }
      paramString1 = paramRecentBaseData.qx();
      if (i == 1)
      {
        i = (int)NetConnInfoCenter.getServerTime();
        ((acms)getActivity().app.getBusinessHandler(20)).c(paramString1, getActivity().app.getCurrentUin(), 0, 512, i);
        return;
      }
    } while (i != 0);
    label300:
    ((FriendListHandler)getActivity().app.getBusinessHandler(1)).a(new String[] { paramString1 }, new boolean[] { false }, new int[] { i });
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode() == -1))
    {
      bOm();
      anot.a(getActivity().app, "dc00898", "", "", "0X800A354", "0X800A354", 0, 0, "", "0", "", "");
    }
  }
  
  public void bOm()
  {
    HiddenChatFragment.1 local1 = new HiddenChatFragment.1(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      if (this.E != null) {
        this.E.post(local1);
      }
    }
    while (this.E == null) {
      return;
    }
    local1.run();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.E = new MqqHandler(ThreadManagerV2.getRecentThreadLooper(), this);
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.mApp = ((QQAppInterface)getActivity().getAppRuntime());
      this.mApp.addObserver(this.jdField_a_of_type_Accd);
      this.mApp.addObserver(this.jdField_b_of_type_Acnd);
      this.mApp.addObserver(this.jdField_a_of_type_Acfd);
      this.mApp.b().addObserver(this);
      this.mApp.setHandler(HiddenChatSettingFragment.class, this.E);
    }
    if (FrameHelperActivity.ZW())
    {
      FrameHelperActivity.EO(true);
      FrameHelperActivity.cuA();
    }
    this.jdField_a_of_type_Acqa = new acqa(this.mApp);
    this.u = ((XListView)this.mContentView.findViewById(2131368520));
    this.jdField_b_of_type_Aajg = new aajg(getActivity(), getActivity().app, this.u, this, 0);
    this.jdField_b_of_type_Aajg.FX(0);
    this.u.setAdapter(this.jdField_b_of_type_Aajg);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.b(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    this.jdField_b_of_type_Aajg.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    setTitle(getString(2131698582));
    this.rightViewText.setText(2131719875);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setOnClickListener(this);
    paramLayoutInflater = getMiniMsgUserParam();
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getActivity(), paramLayoutInflater);
  }
  
  public int getContentLayoutId()
  {
    return 2131562950;
  }
  
  public MiniMsgUserParam getMiniMsgUserParam()
  {
    Object localObject = getActivity().getApplication().getResources().getDrawable(2130841861);
    int m = (int)this.rightViewText.getPaint().measureText(this.rightViewText.getText().toString());
    int i = getActivity().getApplication().getResources().getDisplayMetrics().widthPixels;
    int j = ImmersiveUtils.getStatusBarHeight(getActivity());
    int k = aqnm.dpToPx(16.0F);
    m = (aqnm.dpToPx(52.0F) - m) / 2;
    int n = aqnm.dpToPx(56.0F);
    int i1 = ((Drawable)localObject).getIntrinsicWidth();
    int i2 = aqnm.dip2px(5.0F);
    localObject = new MiniMsgUserParam();
    ((MiniMsgUserParam)localObject).businessName = 24;
    ((MiniMsgUserParam)localObject).accessType = 0;
    ((MiniMsgUserParam)localObject).entryType = 1;
    ((MiniMsgUserParam)localObject).positionX = (i - (k - m) - n - i1);
    ((MiniMsgUserParam)localObject).positionY = (i2 + j);
    ((MiniMsgUserParam)localObject).colorType = 1;
    ((MiniMsgUserParam)localObject).filterMsgType = 1;
    return localObject;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((getActivity() == null) || (!getActivity().app.isLogin())) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      bOm();
      continue;
      jp((List)paramMessage.obj);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    wvo.a(getActivity(), QQSettingChatOperationFragment.class);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText) {
      HiddenChatSettingFragment.aj(getActivity(), 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClick(View paramView, Object paramObject) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    }
    if (this.jdField_b_of_type_Aajg != null) {
      this.jdField_b_of_type_Aajg.onDestory();
    }
    if (this.u != null) {
      this.u.setAdapter(null);
    }
    this.mApp.removeObserver(this.jdField_a_of_type_Accd);
    this.mApp.removeObserver(this.jdField_b_of_type_Acnd);
    this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
    this.mApp.b().deleteObserver(this);
    this.mApp.removeHandler(HiddenChatSettingFragment.class);
    this.jdField_b_of_type_Aajg = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.destroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = null;
    }
    MiniMsgIPCClient.getInstance().clearBusiness(24);
    if (this.E != null) {
      this.E.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    bOm();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.showEntry();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (wvo.a(paramObservable.frienduin, paramObservable.istroop, this.mApp)) {}
    }
    else
    {
      return;
    }
    bOm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment
 * JD-Core Version:    0.7.0.1
 */