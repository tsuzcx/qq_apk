package com.tencent.mobileqq.activity;

import MessageSvcPack.UinPairReadInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticTroopAssist;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.LbsTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import doj;
import dok;
import dol;
import dom;
import don;
import doo;
import dos;
import dot;
import dou;
import dov;
import dow;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TroopAssistantActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, OnRecentUserOpsListener, DragRelativeLayout.OnDragModeChangedListener, Observer
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "TroopAssistantActivity";
  public static final int b = 2;
  public static final int c = 3;
  protected static final int d = 2;
  public long a;
  public Handler a;
  protected View a;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private DragRelativeLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new doo(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new don(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dos(this);
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new dom(this);
  public QQProgressNotifier a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  public XListView a;
  boolean jdField_a_of_type_Boolean;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private View jdField_b_of_type_AndroidViewView;
  public boolean b;
  protected boolean c = true;
  private boolean d;
  private boolean e = false;
  
  public TroopAssistantActivity()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new dou(this);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) > 0)
    {
      long l;
      if (paramInt == 1)
      {
        l = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 1).shmsgseq;
        if (QLog.isColorLevel()) {
          QLog.d("sendGroupMsgReadConfirm", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l);
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(paramString).longValue(), l);
      }
      if (paramInt == 3000)
      {
        l = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 3000).shmsgseq;
        if (QLog.isColorLevel()) {
          QLog.d("sendDisMsgReadConfirm", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l);
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(Long.valueOf(paramString).longValue(), l);
      }
      if (paramInt == 0)
      {
        l = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 0).time;
        if (QLog.isColorLevel()) {
          QLog.d("sendMsgReadedReport", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l);
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new UinPairReadInfo(Long.valueOf(paramString).longValue(), l, 0L, null));
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localArrayList);
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Resources localResources = getResources();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(localResources.getString(2131561519, new Object[] { paramString2 }));
    int i = DBUtils.a().a(paramString1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    localActionSheet.b(localResources.getString(2131561533, new Object[] { StringUtil.a(BaseApplication.getContext(), i) }));
    localActionSheet.a(localResources.getString(2131560651), false);
    localActionSheet.a(localResources.getString(2131560652), false);
    localActionSheet.a(localResources.getString(2131560653), false);
    localActionSheet.a(localResources.getString(2131560654), false);
    i = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(String.valueOf(paramString1));
    switch (i)
    {
    }
    for (;;)
    {
      localActionSheet.d(2131561746);
      localActionSheet.a(new dok(this, i, paramString1, localActionSheet));
      localActionSheet.show();
      return;
      localActionSheet.e(0);
      continue;
      localActionSheet.e(1);
      continue;
      localActionSheet.e(2);
      continue;
      localActionSheet.e(3);
    }
  }
  
  private boolean c()
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      if (localView != null)
      {
        localView = localView.findViewById(2131234180);
        if ((localView != null) && (localView.getVisibility() == 0))
        {
          this.d = false;
          return this.d;
        }
      }
      i += 1;
    }
    this.d = true;
    return this.d;
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131234469));
    View localView1 = View.inflate(this, 2130904022, null);
    this.jdField_b_of_type_AndroidViewView = localView1.findViewById(2131234597);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView1);
    View localView2 = getLayoutInflater().inflate(2130903134, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(localView2);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, this, 1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    this.jdField_a_of_type_AndroidViewView = localView1.findViewById(2131234596);
    localView1 = localView1.findViewById(2131234593);
    localView1.setVisibility(8);
    localView1.setOnClickListener(new doj(this));
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { LbsTransfileProcessor.class, BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class, ForwardImageProcessor.class });
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  private void l()
  {
    setTitle(2131562181);
    ImageView localImageView = this.p;
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130838011);
    localImageView.setContentDescription(getString(2131562183));
    localImageView.setOnClickListener(new dot(this));
    g();
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.e = TroopAssistantManager.a().b();
      if (!this.e) {
        break label117;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getString(2131562755), 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getString(2131562522), 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getString(2131561945), 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(getString(2131561746));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new dow(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
      label117:
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getString(2131562972), 1);
    }
  }
  
  protected List a()
  {
    List localList = TroopAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    int i;
    ArrayList localArrayList;
    int j;
    label31:
    Object localObject;
    if (localList == null)
    {
      i = 0;
      localArrayList = new ArrayList(i);
      j = 0;
      if (j >= i) {
        break label189;
      }
      localObject = (TroopAssistantData)localList.get(j);
      if (localObject != null) {
        break label72;
      }
    }
    for (;;)
    {
      j += 1;
      break label31;
      i = localList.size();
      break;
      label72:
      localObject = new RecentTroopAssistantItem((TroopAssistantData)localObject);
      ((RecentTroopAssistantItem)localObject).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext());
      if (QLog.isDevelopLevel())
      {
        long l = System.currentTimeMillis();
        QLog.i("Q.recent.cost", 4, "[" + (l - 0L) + ", " + ((RecentTroopAssistantItem)localObject).a() + "," + localObject.getClass().getName() + "]");
        ((RecentTroopAssistantItem)localObject).a();
      }
      localArrayList.add(localObject);
    }
    label189:
    return localArrayList;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    if (paramRecentBaseData.b() > 0) {
      this.jdField_a_of_type_Boolean = true;
    }
    a(paramRecentBaseData.a(), paramRecentBaseData.a(), paramString);
  }
  
  public void a(View paramView, ContactsSearchableRecentUser paramContactsSearchableRecentUser, String paramString, boolean paramBoolean) {}
  
  public void a(View paramView, Object paramObject)
  {
    if (paramView == null) {}
    int i;
    do
    {
      return;
      i = paramView.getId();
      if (i == 2131234598)
      {
        this.jdField_b_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(4);
          i();
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
        }
        paramView = new Intent(this, TroopAssisSettingActivity.class);
        paramView.setFlags(67108864);
        startActivity(paramView);
        if (TroopAssistantManager.a().c()) {
          TroopAssistantManager.a().f(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "help_nav", "Clk_set", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2131234599);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(4);
      i();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
      h();
    }
    TroopAssistantManager.a().f(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    a(paramRecentBaseData.a());
  }
  
  void a(String paramString)
  {
    TroopAssistantManager.a().b(paramString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    h();
    a(paramString, 1);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString, 1);
    paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
    if (paramString != null) {
      paramString.sendEmptyMessage(1014);
    }
  }
  
  void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    if (paramInt == 1)
    {
      paramString1 = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramString1);
      if ((paramString1 != null) && (paramString1.troopcode != null)) {
        localIntent.putExtra("troop_uin", paramString1.troopcode);
      }
    }
    for (;;)
    {
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString2);
      startActivity(localIntent);
      return;
      if (paramInt == 0)
      {
        paramString1 = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(paramString1 + "");
        if (paramString1 != null)
        {
          localIntent.putExtra("cSpecialFlag", paramString1.cSpecialFlag);
          if (paramString1.cSpecialFlag == 1) {
            localIntent.setClass(this, ChatForEnterpriseActivity.class);
          }
        }
      }
      else if (paramInt != 3000) {}
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    paramString2 = getResources();
    if ((paramRecentBaseData.a() == 1) && (Utils.a(paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[1]), paramString1))) {
      a(paramRecentBaseData.a(), paramRecentBaseData.b());
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragRelativeLayout paramDragRelativeLayout)
  {
    if (paramBoolean) {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800419E", "0X800419E", 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a() == -1) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  protected boolean b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      StatisticTroopAssist.g(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("fightReport", 2, "-----------------------------------taa.finish----------------------------------");
      }
      StatisticTroopAssist.h(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (QLog.isColorLevel()) {
        QLog.d("fightReport", 2, "-----------------------------------taa.finish----------------------------------");
      }
      return super.b();
      c();
      if (this.d) {
        StatisticTroopAssist.e(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      } else {
        StatisticTroopAssist.f(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
    }
  }
  
  protected void d()
  {
    for (;;)
    {
      try
      {
        localObject = ((RedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a("100300");
        if (localObject == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopAssistantFeedsJsHandler", 2, "updateTroopFeedsRedDotInfo, appInfo !=null, iNewFlag=" + ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() + " type=" + ((BusinessInfoCheckUpdate.AppInfo)localObject).type.get());
        }
        if ((localObject == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0)) {
          continue;
        }
        if (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() == -1) {
          continue;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      catch (Exception localException)
      {
        Object localObject;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        continue;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        continue;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        continue;
        String str = "0";
        continue;
      }
      if (this.c)
      {
        if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
          continue;
        }
        localObject = "2";
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_dynamic", "", "helper", "exp", 0, 0, "", (String)localObject, "", "");
        if (QLog.isColorLevel()) {
          QLog.d("TroopAssistantFeedsJsHandler", 2, "updateTroopFeedsRedDotInfo, ReportController.reportClickEvent, hasRedDot=" + (String)localObject);
        }
        this.c = false;
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "updateTroopFeedsRedDotInfo, appInfo==null");
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2130904020);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout = DragRelativeLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a(this, false);
    j();
    l();
    f();
    k();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a();
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(0);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((RecentBaseData)localObject).a(), ((RecentBaseData)localObject).a());
        if (localObject != null)
        {
          TroopAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((QQMessageFacade.Message)localObject).time);
          localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
          if (localObject != null) {
            ((Handler)localObject).sendEmptyMessage(1009);
          }
        }
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    h();
    d();
  }
  
  public void e()
  {
    ((RedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b("100300");
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {}
    for (String str = "1";; str = "0")
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_dynamic", "", "helper", "Clk", 0, 0, "", str, "", "");
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "doRedDotClickReport, ReportController.reportClickEvent, hasRedDot=" + str);
      }
      return;
    }
  }
  
  public void f()
  {
    if (TroopAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface) == true) {
      TroopAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = TroopAssistantManager.a().c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(3);
        i();
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "help_nav", "exp", 0, 0, "", "", "", "");
      }
      TroopAssistantManager.a().f(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void g()
  {
    int i;
    if (this.k != null)
    {
      QQMessageFacade localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localQQMessageFacade != null)
      {
        i = localQQMessageFacade.f();
        if (i <= 0) {
          break label124;
        }
        if (i <= 99) {
          break label80;
        }
        this.k.setText(getString(2131561807) + "(" + "99+" + ")");
      }
    }
    return;
    label80:
    this.k.setText(getString(2131561807) + "(" + i + ")");
    return;
    label124:
    this.k.setText(getString(2131561807));
  }
  
  public void h()
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (isFinishing()) {}
    while (paramMessage.what != 3) {
      return true;
    }
    for (;;)
    {
      try
      {
        paramMessage = a();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("MSG_UPDATE_TROOP_LIST|size");
          if (paramMessage != null) {
            break label96;
          }
          i = 0;
          QLog.i("TroopAssistantActivity", 2, i);
        }
        runOnUiThread(new dol(this, paramMessage));
        return true;
      }
      catch (Exception paramMessage) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("TroopAssistantActivity", 2, paramMessage.toString());
      return true;
      label96:
      int i = paramMessage.size();
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b()) {
        break label41;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    label41:
    while (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = false;
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 0: 
      if (!this.e) {
        bool = true;
      }
      this.e = bool;
      TroopAssistantManager.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.e);
      return true;
    case 1: 
      paramMenuItem = new Intent(this, TroopAssisSettingActivity.class);
      paramMenuItem.setFlags(67108864);
      startActivity(paramMenuItem);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
      return true;
    }
    TroopAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, false);
    finish();
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    this.e = TroopAssistantManager.a().b();
    if (this.e) {}
    for (MenuItem localMenuItem = paramMenu.add(0, 0, 0, getString(2131562755));; localMenuItem = paramMenu.add(0, 0, 0, getString(2131562972)))
    {
      MenuItemCompat.setShowAsAction(localMenuItem, 0);
      MenuItemCompat.setShowAsAction(paramMenu.add(0, 1, 0, getString(2131562522)), 0);
      MenuItemCompat.setShowAsAction(paramMenu.add(0, 2, 0, getString(2131561945)), 0);
      return true;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new dov(this));
      }
      if ((!paramObservable.isSendFromLocal()) || (paramObservable.msgtype != -2002)) {}
    }
    while (!(paramObject instanceof RecentUser))
    {
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity
 * JD-Core Version:    0.7.0.1
 */