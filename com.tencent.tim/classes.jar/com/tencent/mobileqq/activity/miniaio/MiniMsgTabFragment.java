package com.tencent.mobileqq.activity.miniaio;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import znm;
import znv;
import znx;
import znx.a;
import zny;
import zoa;
import zob;
import zod;

public class MiniMsgTabFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener
{
  FPSSwipListView a;
  public zny a;
  private String appID;
  private String appName;
  a jdField_b_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment$a = new zob(this);
  private ShareActionSheet jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  znv jdField_b_of_type_Znv;
  private boolean brM;
  private boolean brN;
  private boolean brO;
  private boolean brP;
  private boolean brQ = true;
  private RecentBaseData c;
  private int cdM;
  private int cdU;
  private int cdV;
  private int cdW;
  znx.a d;
  private ShareActionSheet.OnItemClickListener e = new zoa(this);
  private QQAppInterface mApp;
  private MiniAppConfig mAppConfig;
  private Animation mExitAnimation;
  private Handler mHandler;
  private boolean mIsMiniGame;
  private int mScreenHeight;
  private int mStatusBarHeight;
  private View yJ;
  private View yK;
  
  private RecentBaseData a()
  {
    return new RecentItemChatMsgData(new RecentUser("0", 0));
  }
  
  private void biq()
  {
    this.cdW = 1;
    ArrayList localArrayList1 = new ArrayList();
    boolean bool1 = getIntent().getBooleanExtra("showShareQQ", false);
    if (bool1) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    }
    boolean bool2 = getIntent().getBooleanExtra("showShareQzone", false);
    if (bool2) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    }
    boolean bool3 = getIntent().getBooleanExtra("showShareWeChatFriends", false);
    if (bool3) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    }
    boolean bool4 = getIntent().getBooleanExtra("showShareWeChatMoment", false);
    if (bool4) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    if ((bool1) || (bool2) || (bool3) || (bool4)) {
      this.cdW += 1;
    }
    for (int i = 1;; i = 0)
    {
      ArrayList localArrayList2 = new ArrayList();
      int j = getIntent().getIntExtra("key_color_note", 0);
      if (j == 0)
      {
        j = getIntent().getIntExtra("showBackHome", -1);
        if (j != -1) {
          break label924;
        }
        label201:
        if (getIntent().getBooleanExtra("showRestartMiniApp", true)) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(128));
        }
        j = getIntent().getIntExtra("topType", 0);
        bool2 = getIntent().getBooleanExtra("isSpecialMiniApp", false);
        bool3 = getIntent().getBooleanExtra("is_limited_access_app", false);
        if ((!bool2) && (!bool3)) {
          break label952;
        }
        label273:
        if ((getIntent().getBooleanExtra("setToTroop", false)) && (TroopApplicationListUtil.isAdminOrCreated())) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(158));
        }
        if (getIntent().getBooleanExtra("addToCurrentTroop", false)) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(159));
        }
        if ((getIntent().getBooleanExtra("addShortcut", false)) && (!bool3)) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(14));
        }
        if (getIntent().getBooleanExtra("showDetail", false)) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(78));
        }
        if (getIntent().getBooleanExtra("showSetting", false)) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(83));
        }
        if (getIntent().getBooleanExtra("showComplaint", false)) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
        }
        bool2 = getIntent().getBooleanExtra("showDebug", false);
        bool3 = getIntent().getBooleanExtra("debugEnable", false);
        if (bool2)
        {
          if (!bool3) {
            break label994;
          }
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(75));
        }
        label489:
        bool2 = getIntent().getBooleanExtra("showMonitor", false);
        bool3 = getIntent().getBooleanExtra("isOpenMonitorPanel", false);
        if (bool2)
        {
          if (!bool3) {
            break label1010;
          }
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(80));
        }
        label536:
        Object localObject = getArguments();
        if (localObject != null) {
          this.mAppConfig = ((MiniAppConfig)((Bundle)localObject).getParcelable("key_mini_app_config"));
        }
        this.cdU = getIntent().getIntExtra("key_mini_app_version_type", -1);
        this.mIsMiniGame = getIntent().getBooleanExtra("key_mini_app_is_game", false);
        this.brN = getIntent().getBooleanExtra("isFromShareButton", false);
        this.brM = getIntent().getBooleanExtra("isLandscape", false);
        if (("1108291530".equals(this.appID)) || (MiniAppSecurityUtil.doCheckSafeUnblockWithLogin(this.appID))) {
          i = 0;
        }
        this.brP = getIntent().getBooleanExtra("showKingcardTip", false);
        if (this.brP) {}
        this.appID = getIntent().getStringExtra("miniAppID");
        this.appName = getIntent().getStringExtra("miniAppName");
        getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_miniapp");
        localObject = new ShareActionSheetV2.Param();
        ((ShareActionSheetV2.Param)localObject).context = getActivity();
        ((ShareActionSheetV2.Param)localObject).canceledOnTouchOutside = false;
        ((ShareActionSheetV2.Param)localObject).flagNotTouchModal = true;
        ((ShareActionSheetV2.Param)localObject).dimAmount = 0.0F;
        ((ShareActionSheetV2.Param)localObject).lp = new ViewGroup.LayoutParams(-1, -2);
        this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
        if (!bool1) {
          break label1026;
        }
        this.cdW += 1;
        localObject = new Intent();
        ((Intent)localObject).putExtra("forward_type", 27);
        this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity((Intent)localObject);
        this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
      }
      for (;;)
      {
        if (i == 0) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle("");
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localArrayList1, localArrayList2);
        this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(this.e);
        this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setCancelListener(new zod(this));
        return;
        if (j == 1)
        {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(70));
          break;
        }
        if (j != 2) {
          break;
        }
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(82));
        break;
        label924:
        if (j == 1)
        {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(81));
          break label201;
        }
        if (j != 0) {
          break label201;
        }
        break label201;
        label952:
        if (j == 0)
        {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(76));
          break label273;
        }
        if (j == -11) {
          break label273;
        }
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(77));
        break label273;
        label994:
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(74));
        break label489;
        label1010:
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(79));
        break label536;
        label1026:
        this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
      }
    }
  }
  
  private void cL(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    QLog.d("MiniMsgTabFragment", 2, "shareToChatDirectly handleShareChatItemClick, uin:" + paramString + ",uinType:" + paramInt);
    localBundle.putString("key_mini_app_share_chat_uin", paramString);
    localBundle.putInt("key_mini_app_share_chat_type", paramInt);
    u(12, localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("MiniMsgTabFragment", 2, "handleShareChatItemClick");
    }
  }
  
  private void cqh()
  {
    if (!this.brQ)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniMsgTabFragment", 2, "mShouldUpdateChatData: false");
      }
      return;
    }
    List localList = this.jdField_b_of_type_Znv.c(this.cdV, this.cdM);
    if ((!this.brO) && (localList.size() == 0))
    {
      if (this.c == null) {
        this.c = a();
      }
      localList.add(this.c);
      this.yK.findViewById(2131379941).setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Zny.cS(localList);
      return;
      this.yK.findViewById(2131379941).setVisibility(0);
    }
  }
  
  private Intent getIntent()
  {
    if (getActivity() != null) {
      return getActivity().getIntent();
    }
    QLog.e("MiniMsgTabFragment", 1, "Fragment.getActivity() is null when calling getIntent()");
    return new Intent();
  }
  
  private void u(int paramInt, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismissImmediately();
    }
    if (getActivity() == null)
    {
      QLog.e("MiniMsgTabFragment", 1, "getActivity is null when calling dismissMsgFragment");
      return;
    }
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((QQAppInterface)localObject).b();
        if (localObject == null) {
          break label153;
        }
      }
      label153:
      for (int i = ((QQMessageFacade)localObject).vd();; i = 0)
      {
        localObject = getIntent();
        ((Intent)localObject).putExtra("miniAppID", this.appID);
        ((Intent)localObject).putExtra("clickID", paramInt);
        if (paramBundle != null) {
          ((Intent)localObject).putExtras(paramBundle);
        }
        ((Intent)localObject).putExtra("param_proc_badge_count", i);
        getActivity().setResult(-1, (Intent)localObject);
        getActivity().finish();
        return;
        localObject = null;
        break;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_a_of_type_Zny != null) {
      this.jdField_a_of_type_Zny.onAccountChanged(this.mApp);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      this.yJ.setVisibility(0);
      cqh();
    }
    try
    {
      if ((this.brM) && (this.jdField_a_of_type_Zny.getCount() < 1) && (this.mHandler != null)) {
        this.mHandler.postDelayed(new MiniMsgTabFragment.4(this), 100L);
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e("MiniMsgTabFragment", 1, "onActivityResult error", paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.brO)
    {
      u(-1, null);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    if ((paramView.getId() == 2131379941) && (getIntent().getBooleanExtra("key_mini_msgtab_isneed_back_conversation", false)))
    {
      localObject1 = (Intent)getIntent().getParcelableExtra("key_mini_msgtab_back_pending_intent");
      if (localObject1 != null)
      {
        ((Intent)localObject1).setClass(getActivity(), SplashActivity.class);
        znx.a().notifyGoToConversation();
        if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
          break label234;
        }
      }
    }
    label234:
    for (QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localQQAppInterface = null)
    {
      startActivity((Intent)localObject1);
      localObject1 = localObject2;
      if (localQQAppInterface != null) {
        localObject1 = localQQAppInterface.b();
      }
      if (localObject1 != null) {}
      for (i = ((QQMessageFacade)localObject1).vd();; i = 0)
      {
        localObject1 = getIntent();
        ((Intent)localObject1).putExtra("param_proc_badge_count", i);
        getActivity().setResult(-1, (Intent)localObject1);
        getActivity().finish();
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(getActivity(), SplashActivity.class);
        ((Intent)localObject1).setFlags(67108864);
        ((Intent)localObject1).putExtra("tab_index", MainFragment.bIk);
        ((Intent)localObject1).putExtra("fragment_id", 1);
        break;
      }
      if (paramView.getId() == 2131362332) {}
      for (;;)
      {
        u(i, null);
        break;
        i = -1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.cdM = getIntent().getIntExtra("key_mini_msgtab_type", 0);
    this.brO = getIntent().getBooleanExtra("key_mini_msgtab_need_action_sheet", false);
    this.cdV = getIntent().getIntExtra("key_mini_msgtab_businame", 0);
    int i = yn();
    anot.a(null, "dc00898", "", "", "0X800A0F6", "0X800A0F6", this.cdV, 1, "" + i, "", "", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (getActivity().app == null) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = null)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.mScreenHeight = getActivity().getResources().getDisplayMetrics().heightPixels;
      this.mStatusBarHeight = ImmersiveUtils.getStatusBarHeight(getActivity());
      paramBundle = getIntent();
      paramLayoutInflater = paramLayoutInflater.inflate(2131559625, paramViewGroup, false);
      if (paramLayoutInflater != null) {
        break;
      }
      getActivity().finish();
    }
    this.mApp = getActivity().app;
    this.yJ = paramLayoutInflater.findViewById(2131362332);
    this.yJ.setOnClickListener(this);
    this.yJ.setBackgroundColor(Color.parseColor("#80000000"));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)paramLayoutInflater.findViewById(2131372016));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollTouchMode(1);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollFlingMode(1);
    paramViewGroup = View.inflate(getActivity(), 2131559624, null);
    paramViewGroup.findViewById(2131365679).setOnClickListener(this);
    this.yK = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(paramViewGroup);
    biq();
    if (QLog.isColorLevel()) {
      QLog.d("MiniMsgTabFragment", 0, "mini msg tab oncreateView.mFilterMsgType " + this.cdM);
    }
    if (this.brO)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      }
      int i = this.mScreenHeight;
      int j = this.mStatusBarHeight;
      int k = this.cdW;
      int m = DisplayUtil.dip2px(getActivity(), 120.0F);
      int n = DisplayUtil.dip2px(getActivity(), 36.0F);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setMaxHeight(i - j - k * m - n);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeHeaderView(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_Zny = new zny(this.mApp, getActivity(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_b_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment$a);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Zny);
      this.jdField_b_of_type_Znv = ((znv)this.mApp.getBusinessHandler(147));
      this.d = znx.a().a();
      if ((paramBundle != null) && (!paramBundle.getBooleanExtra("showChatNewsList", true)))
      {
        this.brQ = false;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
      }
      break;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLayoutParams();
      localLayoutParams.topMargin = 0;
      paramViewGroup.findViewById(2131379941).setOnClickListener(this);
      paramViewGroup.findViewById(2131379941).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setLayoutParams(localLayoutParams);
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismissImmediately();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mExitAnimation != null)
    {
      this.yJ.clearAnimation();
      this.mExitAnimation.cancel();
      this.mExitAnimation.setAnimationListener(null);
    }
    if (this.jdField_a_of_type_Zny != null) {
      this.jdField_a_of_type_Zny.destroy();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismissImmediately();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Zny.getCount() > 0) {
      znm.report("0X8009C2B");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    cqh();
  }
  
  public void onStop()
  {
    u(-1, null);
    super.onStop();
  }
  
  public int yn()
  {
    int i = 0;
    QQAppInterface localQQAppInterface = getActivity().app;
    if (localQQAppInterface != null) {
      i = localQQAppInterface.b().vd();
    }
    return i;
  }
  
  public static abstract interface a
  {
    public abstract void b(RecentBaseData paramRecentBaseData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment
 * JD-Core Version:    0.7.0.1
 */