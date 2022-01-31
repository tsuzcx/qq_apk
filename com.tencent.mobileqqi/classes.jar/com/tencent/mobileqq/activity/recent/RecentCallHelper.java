package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import eov;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.Constants.LogoutReason;

public class RecentCallHelper
{
  public static final String a = "Q.recent";
  public static final boolean a = true;
  public static final String b = "-";
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private LocalSearchBar jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private RedDotRadioButton jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  public boolean b = true;
  public boolean c;
  private boolean d = false;
  
  public RecentCallHelper(QQAppInterface paramQQAppInterface, View paramView1, View paramView2, RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener, ViewStub.OnInflateListener paramOnInflateListener)
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView1.findViewById(2131231425));
    IphoneTitleBarActivity.b(this.jdField_a_of_type_AndroidWidgetRadioGroup);
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    paramView1 = this.jdField_a_of_type_AndroidWidgetRadioGroup.findViewById(2131231426);
    paramView1.setContentDescription("点击切换到消息记录页面");
    paramView1.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.jdField_a_of_type_AndroidWidgetRadioGroup.findViewById(2131231427));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setContentDescription("点击切换到通话记录页面");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setFocusable(true);
    paramView1 = BaseApplication.getContext();
    this.jdField_a_of_type_Int = SharedPreUtils.b(paramView1);
    this.d = SharedPreUtils.a(paramView1, paramQQAppInterface.a(), this.jdField_a_of_type_Int);
    a(paramQQAppInterface, true, this.d);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView2.findViewById(2131231430));
    this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(paramOnInflateListener);
  }
  
  private RecentCallItem a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    return (RecentCallItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Handler paramHandler, boolean paramBoolean)
  {
    this.c = true;
    if (paramBoolean)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)paramQQAppInterface.a(1);
      if (localFriendListHandler != null) {
        localFriendListHandler.d(paramQQAppInterface.a(), (byte)0);
      }
      a(paramHandler, 60000L);
      return;
    }
    a(paramHandler, 800L);
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap(40);
    }
    for (;;)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        RecentCallItem localRecentCallItem = (RecentCallItem)paramList.get(i);
        if (localRecentCallItem != null)
        {
          String str = localRecentCallItem.a() + "-" + localRecentCallItem.a();
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localRecentCallItem);
        }
        i += 1;
      }
      break;
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRadioGroup != null) {
      return this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId();
    }
    return 2131231427;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRadioGroup != null) {
      this.jdField_a_of_type_AndroidWidgetRadioGroup.check(2131231426);
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) || (paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)) {
      return;
    }
    if (this.c)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (SharedPreUtils.a(paramContext, paramString, this.jdField_a_of_type_Int)) {
      SharedPreUtils.b(paramContext, paramString, this.jdField_a_of_type_Int);
    }
  }
  
  protected void a(Handler paramHandler, long paramLong)
  {
    if ((this.c) && (paramHandler != null))
    {
      paramHandler.removeMessages(1022);
      paramHandler.sendEmptyMessageDelayed(1022, paramLong);
    }
  }
  
  public void a(Handler paramHandler, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {}
    while (!this.c) {
      return;
    }
    a(paramHandler, 800L);
    paramHandler = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
    if (paramBoolean) {}
    for (int i = 0;; i = 2)
    {
      paramHandler.a(i);
      return;
    }
  }
  
  public void a(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramMessage = (List)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(6);
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "REFRESH_FLAG_CALL_LIST|" + this.jdField_a_of_type_Long);
      }
    }
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.i("Q.recent", 4, "REFRESH_FLAG_CALL_LIST|call adapter is null");
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(paramView);
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    paramBaseActivity = View.inflate(paramBaseActivity, 2130903097, null);
    paramBaseActivity.setOnClickListener(new eov(this));
    paramBaseActivity.findViewById(2131231163).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(paramBaseActivity);
  }
  
  public void a(BaseActivity paramBaseActivity, ViewStub paramViewStub, View paramView1, QQAppInterface paramQQAppInterface, View paramView2, View paramView3, OverScrollViewListener paramOverScrollViewListener, OnRecentUserOpsListener paramOnRecentUserOpsListener, AbsListView.OnScrollListener paramOnScrollListener)
  {
    if ((paramView1 != null) && (paramView1.getId() == 2131232936))
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)paramView1);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130837729);
      paramViewStub = paramBaseActivity.getLayoutInflater().inflate(2130903931, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(paramViewStub);
      a(paramBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar = new LocalSearchBar(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, paramView2, paramView3, paramBaseActivity, paramOnRecentUserOpsListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(paramBaseActivity).inflate(2130903325, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(paramOverScrollViewListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(paramBaseActivity, paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, paramOnRecentUserOpsListener, 4);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(paramOnScrollListener);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.c) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null))
    {
      this.c = false;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.C();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a(paramQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramQQAppInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.isChecked()))
    {
      this.d = SharedPreUtils.a(paramQQAppInterface.getApplication(), paramQQAppInterface.a(), this.jdField_a_of_type_Int);
      a(paramQQAppInterface, true, this.d);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(paramInt);
      if (paramInt == 8) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.b();
      }
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.isChecked()))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
          a(paramQQAppInterface.getApplication(), paramQQAppInterface.a());
        }
        QCallFacade localQCallFacade = null;
        if (paramQQAppInterface != null) {
          localQCallFacade = (QCallFacade)paramQQAppInterface.getManager(36);
        }
        if (localQCallFacade != null) {
          localQCallFacade.a(false);
        }
      }
      return;
      if (this.jdField_a_of_type_AndroidViewViewStub != null) {
        this.jdField_a_of_type_AndroidViewViewStub.setVisibility(paramInt);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Handler paramHandler)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "REFRESH_FLAG_CALL_LIST");
    }
    if ((paramQQAppInterface != null) && (paramContext != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null))
    {
      Object localObject = (QCallFacade)paramQQAppInterface.getManager(36);
      ArrayList localArrayList;
      int i;
      label74:
      int j;
      label77:
      QCallRecent localQCallRecent;
      RecentCallItem localRecentCallItem;
      if (localObject == null)
      {
        localObject = null;
        localArrayList = new ArrayList(30);
        if (localObject == null) {
          break label213;
        }
        i = ((List)localObject).size();
        j = 0;
        if (j >= i) {
          break label229;
        }
        localQCallRecent = (QCallRecent)((List)localObject).get(j);
        if ((localQCallRecent != null) && (!TextUtils.isEmpty(localQCallRecent.uin)))
        {
          localRecentCallItem = a(localQCallRecent.uin + "-" + localQCallRecent.type);
          if (localRecentCallItem != null) {
            break label219;
          }
          localRecentCallItem = new RecentCallItem(localQCallRecent);
        }
      }
      for (;;)
      {
        localRecentCallItem.A = localQCallRecent.missedCallCount;
        localRecentCallItem.a(paramQQAppInterface, paramContext);
        localArrayList.add(localRecentCallItem);
        j += 1;
        break label77;
        localObject = ((QCallFacade)localObject).a();
        break;
        label213:
        i = 0;
        break label74;
        label219:
        localRecentCallItem.a(localQCallRecent);
      }
      label229:
      a(localArrayList);
      if (paramHandler != null) {
        Message.obtain(paramHandler, 1021, 0, 0, localArrayList).sendToTarget();
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(paramBoolean2);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    while ((paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null)) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(true);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramString, false);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramString, paramInt);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.c))
    {
      this.c = false;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.B();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Handler paramHandler)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) || (paramHandler == null)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "refreshCallList|invalidate to refresh");
      }
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean1) {
          break;
        }
        this.b = false;
        long l;
        if (paramBoolean2) {
          l = 0L;
        }
        while (!paramHandler.hasMessages(16)) {
          if (l == 0L)
          {
            paramHandler.sendEmptyMessage(16);
            return;
            l = Math.max(2000L - Math.abs(this.jdField_a_of_type_Long - System.currentTimeMillis()), 500L);
          }
          else
          {
            paramHandler.sendEmptyMessageDelayed(16, l);
            return;
          }
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("Q.recent", 4, "refreshCallList|already has not complete refresh");
      return;
      this.b = true;
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "refreshCallList|list scrolling");
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView, QQAppInterface paramQQAppInterface, Handler paramHandler, boolean paramBoolean)
  {
    if ((this.c) || (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) || (paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    a(paramQQAppInterface, paramHandler, paramBoolean);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRadioGroup != null) {
      this.jdField_a_of_type_AndroidWidgetRadioGroup.check(2131231427);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) || (paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)) {}
    while (this.c) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.c();
    }
  }
  
  public void d() {}
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(null);
    }
  }
  
  public void f()
  {
    this.c = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.B();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentCallHelper
 * JD-Core Version:    0.7.0.1
 */