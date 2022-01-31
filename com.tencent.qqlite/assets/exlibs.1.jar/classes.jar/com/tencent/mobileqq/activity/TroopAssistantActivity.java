package com.tencent.mobileqq.activity;

import MessageSvcPack.UinPairReadInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import blt;
import blu;
import blv;
import blw;
import bma;
import bmb;
import bmc;
import bmd;
import bme;
import bmf;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
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
import com.tencent.mobileqq.troop.data.TroopMessageProcessor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TroopAssistantActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, Observer
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "TroopAssistantActivity";
  public static final int b = 2;
  public static final int c = 3;
  protected static final int d = 2;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new blw(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new blv(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new bma(this);
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new blt(this);
  public QQProgressNotifier a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  public XListView a;
  boolean jdField_a_of_type_Boolean;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = false;
  
  public TroopAssistantActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new bmc(this);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.app.a().a(paramString, paramInt) > 0)
    {
      long l;
      if (paramInt == 1)
      {
        l = this.app.a().a(paramString, 1).shmsgseq;
        if (QLog.isColorLevel()) {
          QLog.d("sendGroupMsgReadConfirm", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l);
        }
        ((TroopMessageProcessor)this.app.a().a("troop_processor")).a(Long.valueOf(paramString).longValue(), l);
      }
      if (paramInt == 3000)
      {
        l = this.app.a().a(paramString, 3000).shmsgseq;
        if (QLog.isColorLevel()) {
          QLog.d("sendDisMsgReadConfirm", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l);
        }
        ((DiscMessageProcessor)this.app.a().a("disc_processor")).a(Long.valueOf(paramString).longValue(), l);
      }
      if (paramInt == 0)
      {
        l = this.app.a().a(paramString, 0).time;
        if (QLog.isColorLevel()) {
          QLog.d("sendMsgReadedReport", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l);
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new UinPairReadInfo(Long.valueOf(paramString).longValue(), l, 0L, null));
        ((C2CMessageProcessor)this.app.a().a("c2c_processor")).b(localArrayList);
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Resources localResources = getResources();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null, 2131624119);
    localActionSheet.a(localResources.getString(2131363867, new Object[] { paramString2 }));
    int i = DBUtils.a().a(paramString1, this.app);
    localActionSheet.b(localResources.getString(2131363868, new Object[] { StringUtil.a(BaseApplication.getContext(), i) }));
    localActionSheet.a(localResources.getString(2131362536), false);
    localActionSheet.a(localResources.getString(2131362537), false);
    localActionSheet.a(localResources.getString(2131362538), false);
    i = this.app.b(String.valueOf(paramString1));
    switch (i)
    {
    }
    for (;;)
    {
      localActionSheet.d(2131362790);
      localActionSheet.a(new bmf(this, i, paramString1, localActionSheet));
      localActionSheet.show();
      return;
      localActionSheet.e(0);
      continue;
      localActionSheet.e(1);
      continue;
      localActionSheet.e(2);
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
        localView = localView.findViewById(2131298717);
        if ((localView != null) && (localView.getVisibility() == 0))
        {
          this.jdField_b_of_type_Boolean = false;
          return this.jdField_b_of_type_Boolean;
        }
      }
      i += 1;
    }
    this.jdField_b_of_type_Boolean = true;
    return this.jdField_b_of_type_Boolean;
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298805));
    View localView = getLayoutInflater().inflate(2130903113, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(localView);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this, 1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { LbsTransfileProcessor.class, BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class, ForwardImageProcessor.class });
    this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  private void h()
  {
    setTitle(2131363869);
    ImageView localImageView = this.p;
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130838044);
    localImageView.setContentDescription(getString(2131364166));
    localImageView.setOnClickListener(new bmb(this));
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.c = TroopAssistantManager.a().b();
      if (!this.c) {
        break label118;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getString(2131364163), 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getString(2131364164), 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getString(2131364165), 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(getString(2131362790));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new bme(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
      label118:
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getString(2131364162), 1);
    }
  }
  
  protected List a()
  {
    List localList = TroopAssistantManager.a().a(this.app);
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
      ((RecentTroopAssistantItem)localObject).a(this.app, BaseApplication.getContext());
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
    if (paramView == null) {
      return;
    }
    paramView.getId();
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
    TroopAssistantManager.a().b(paramString, this.app);
    d();
    a(paramString, 1);
    this.app.a().c(paramString, 1);
    paramString = this.app.a(Conversation.class);
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
      paramString1 = ((FriendManager)this.app.getManager(8)).a(paramString1);
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
        paramString1 = ((FriendManager)this.app.getManager(8)).c(paramString1 + "");
        if (paramString1 != null)
        {
          localIntent.putExtra("cSpecialFlag", paramString1.cSpecialFlag);
          if (paramString1.cSpecialFlag == 1)
          {
            localIntent.setClass(this, ChatActivity.class);
            localIntent.putExtra("chat_subType", 1);
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
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800419E", "0X800419E", 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  protected boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      StatisticTroopAssist.g(this, this.app.a());
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("fightReport", 2, "-----------------------------------taa.finish----------------------------------");
      }
      StatisticTroopAssist.h(this, this.app.a());
      if (QLog.isColorLevel()) {
        QLog.d("fightReport", 2, "-----------------------------------taa.finish----------------------------------");
      }
      return super.a();
      c();
      if (this.jdField_b_of_type_Boolean) {
        StatisticTroopAssist.e(this, this.app.a());
      } else {
        StatisticTroopAssist.f(this, this.app.a());
      }
    }
  }
  
  public void c()
  {
    if (TroopAssistantManager.a().a(this.app) == true) {
      TroopAssistantManager.a().a(this.app.a().createEntityManager(), this.app);
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    this.app.a().addObserver(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.app);
    }
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2130903682);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    f();
    h();
    c();
    g();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(0);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        localObject = this.app.a().a(((RecentBaseData)localObject).a(), ((RecentBaseData)localObject).a());
        if (localObject != null)
        {
          TroopAssistantManager.a().a(this.app, ((QQMessageFacade.Message)localObject).time);
          localObject = this.app.a(Conversation.class);
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
    d();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b()) {
        break label41;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label41:
    while (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
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
        runOnUiThread(new blu(this, paramMessage));
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
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new bmd(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity
 * JD-Core Version:    0.7.0.1
 */