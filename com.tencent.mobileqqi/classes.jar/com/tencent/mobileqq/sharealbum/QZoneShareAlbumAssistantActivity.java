package com.tencent.mobileqq.sharealbum;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import gji;
import gjk;
import gjl;
import gjm;
import gjn;
import gjo;
import gjp;
import gjq;
import gjr;
import gjs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.MobileQQ;

public class QZoneShareAlbumAssistantActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, OnRecentUserOpsListener, DragRelativeLayout.OnDragModeChangedListener, OverScrollViewListener
{
  public static final int a = 8877;
  public static final String a = "photoactivity_key_type";
  public static final int b = 8878;
  private static final String jdField_b_of_type_JavaLangString = "ShareAlbumAssistantActivity";
  public static final int c = 7;
  public static final int d = 9;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private DragRelativeLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout;
  private QZoneShareAlbumAssistantManager.onShareAlbumResultListener jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public SlideDetectListView a;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private Comparator jdField_a_of_type_JavaUtilComparator;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  RotateAnimation jdField_b_of_type_AndroidViewAnimationRotateAnimation;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  
  private List a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareAlbumAssistantActivity", 2, "ShareAlbum get local data");
    }
    this.jdField_a_of_type_JavaUtilList = QZoneShareAlbumAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    int i;
    int j;
    label48:
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      i = 0;
      this.jdField_b_of_type_JavaUtilList.clear();
      j = 0;
      if (j >= i) {
        break label121;
      }
      localObject = (QZoneShareAlbumAssistantItemData)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localObject != null) {
        break label91;
      }
    }
    for (;;)
    {
      j += 1;
      break label48;
      i = this.jdField_a_of_type_JavaUtilList.size();
      break;
      label91:
      localObject = new QZoneShareAlbumAssistantShowItem((QZoneShareAlbumAssistantItemData)localObject, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext());
      this.jdField_b_of_type_JavaUtilList.add(localObject);
    }
    label121:
    Collections.sort(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  private void a(QZoneShareAlbumAssistantItemData paramQZoneShareAlbumAssistantItemData)
  {
    if ((paramQZoneShareAlbumAssistantItemData != null) && (this.jdField_b_of_type_JavaUtilList != null))
    {
      QZoneShareAlbumAssistantShowItem localQZoneShareAlbumAssistantShowItem = new QZoneShareAlbumAssistantShowItem(paramQZoneShareAlbumAssistantItemData, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
      this.jdField_b_of_type_JavaUtilList.remove(localQZoneShareAlbumAssistantShowItem);
      this.jdField_b_of_type_JavaUtilList.add(localQZoneShareAlbumAssistantShowItem);
      Collections.sort(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
      if (QLog.isColorLevel()) {
        QLog.d("ShareAlbumAssistantActivity", 2, "ShareAlbum handlepush:" + paramQZoneShareAlbumAssistantItemData.toString());
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      runOnUiThread(new gjm(this));
    }
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData instanceof QZoneShareAlbumAssistantShowItem))
    {
      paramRecentBaseData = (QZoneShareAlbumAssistantShowItem)paramRecentBaseData;
      if ((paramRecentBaseData.a.unreadCount > 0L) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
      {
        paramRecentBaseData.a.unreadCount = 0L;
        paramRecentBaseData.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
        QZoneShareAlbumAssistantManager.a().a(paramRecentBaseData.a);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void c(RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData instanceof QZoneShareAlbumAssistantShowItem))
    {
      paramRecentBaseData = (QZoneShareAlbumAssistantShowItem)paramRecentBaseData;
      if ((paramRecentBaseData.a != null) && (!TextUtils.isEmpty(paramRecentBaseData.a.albumID)) && (!TextUtils.isEmpty(paramRecentBaseData.a.albumName)))
      {
        QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
        localUserInfo.a = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localUserInfo.b = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
        localUserInfo.c = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
        QZoneHelper.b(this, localUserInfo, paramRecentBaseData.a.albumID, paramRecentBaseData.a.albumName, paramRecentBaseData.a.url, -1);
      }
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131234198));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2130903325, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
    View localView = getLayoutInflater().inflate(2130903134, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b(localView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setContentBackground(2130837729);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, this, 2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131234175);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234176));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  private void g()
  {
    QZoneShareAlbumAssistantManager.a().h(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = a();
    if (localObject != null)
    {
      a((List)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
        if (!this.jdField_a_of_type_Boolean) {
          break label84;
        }
      }
    }
    label84:
    for (int i = 5;; i = 0)
    {
      ((RecentAdapter)localObject).a(i);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_b_of_type_JavaUtilList);
      if (QLog.isColorLevel()) {
        QLog.d("ShareAlbumAssistantActivity", 2, "ShareAlbum set to UI");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
      return;
    }
  }
  
  private void h()
  {
    setTitle(2131562911);
    c(2131561016, new gjn(this));
  }
  
  private void i()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localUserInfo.b = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
    localUserInfo.c = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
    QZoneHelper.a(this, localUserInfo, -1);
  }
  
  private void j()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener != null))
    {
      this.jdField_b_of_type_Boolean = true;
      QZoneShareAlbumAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("ShareAlbumAssistantActivity", 2, "ShareAlbum start reflash");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(8877);
  }
  
  private void k()
  {
    this.jdField_b_of_type_AndroidViewView = findViewById(2131231462);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setFocusable(true);
    this.jdField_b_of_type_AndroidViewView.setContentDescription(getResources().getString(2131561259));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231463));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840161);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setMaxHeight((int)getResources().getDimension(2131427736));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new gjo(this));
    b(this.jdField_b_of_type_AndroidViewView);
  }
  
  private void l()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((ViewStub)findViewById(2131234199)).inflate());
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131233600));
      gjp localgjp = new gjp(this);
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(a(), 2130968628);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(localgjp);
      this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(a(), 2130968626);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(localgjp);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new gjq(this));
      findViewById(2131233599).setOnTouchListener(new gjr(this));
      findViewById(2131233994).setOnClickListener(new gjs(this));
      findViewById(2131234147).setOnClickListener(new gjk(this));
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationRotateAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, -45.0F, 1, 0.5F, 1, 0.5F);
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(400L);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
  }
  
  private void o()
  {
    if (this.jdField_b_of_type_AndroidViewAnimationRotateAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(-45.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setDuration(400L);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationRotateAnimation);
  }
  
  private void p()
  {
    this.jdField_b_of_type_AndroidViewView.setContentDescription(getResources().getString(2131561260));
    n();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(AnimationUtils.loadAnimation(a(), 2130968627));
    findViewById(2131233599).startAnimation(AnimationUtils.loadAnimation(a(), 2130968625));
  }
  
  private void q()
  {
    this.jdField_b_of_type_AndroidViewView.setContentDescription(getResources().getString(2131561259));
    o();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    findViewById(2131233599).startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
  }
  
  private void r()
  {
    i();
  }
  
  public void a(int paramInt)
  {
    Object localObject = QZoneShareAlbumAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (QZoneShareAlbumAssistantItemData)((List)localObject).get(0);
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.a = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localUserInfo.b = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
      localUserInfo.c = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
      QZoneHelper.a(this, localUserInfo, ((QZoneShareAlbumAssistantItemData)localObject).albumID, ((QZoneShareAlbumAssistantItemData)localObject).albumName, paramInt, -1);
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(d());
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    b(paramRecentBaseData);
    c(paramRecentBaseData);
  }
  
  public void a(View paramView, ContactsSearchableRecentUser paramContactsSearchableRecentUser, String paramString, boolean paramBoolean) {}
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData == null) {}
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt, DragRelativeLayout paramDragRelativeLayout)
  {
    if (paramBoolean)
    {
      View localView = paramDragRelativeLayout.a();
      if ((localView != null) && (localView.getTag() != null))
      {
        paramInt = ((Integer)localView.getTag()).intValue();
        b((RecentBaseData)this.jdField_b_of_type_JavaUtilList.get(paramInt));
      }
    }
    if ((paramBoolean) || (paramDragRelativeLayout.a() == -1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    if (!NetworkUtil.e(this))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(8877, 800L);
      return true;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(8878);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(8878, 10000L);
    j();
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener = new gji(this);
    if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener != null) {
      QZoneShareAlbumAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener);
    }
    this.jdField_a_of_type_JavaUtilComparator = new gjl(this);
    QZoneShareAlbumAssistantManager.a().j(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    g();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2130903872);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout = DragRelativeLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a(this, false);
    f();
    h();
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(null);
    QZoneShareAlbumAssistantManager.a().a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener = null;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a();
    }
  }
  
  public void e()
  {
    m();
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)
      {
        p();
        return;
      }
      q();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ShareAlbumAssistantActivity", 2, "ShareAlbum test error:" + localException.getMessage());
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("ShareAlbumAssistantActivity", 2, "ShareAlbum springBackOverScrollHeaderView");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.B();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(8878);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ShareAlbumAssistantActivity", 2, "ShareAlbum refreshTimeout");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.B();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantActivity
 * JD-Core Version:    0.7.0.1
 */