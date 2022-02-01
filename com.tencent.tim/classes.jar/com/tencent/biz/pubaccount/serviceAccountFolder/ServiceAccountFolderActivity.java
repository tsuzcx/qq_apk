package com.tencent.biz.pubaccount.serviceAccountFolder;

import acfp;
import adak;
import altq;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import arhz;
import aurf;
import avpw;
import com.tencent.biz.subscribe.account_folder.recommend_banner.TopRecommendListView;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.SwipListView.a;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import nyb;
import nyi;
import nyj;
import nyn;
import obt;
import odd;
import org.json.JSONObject;
import rzd;
import saf;
import sqn;
import wja;

public class ServiceAccountFolderActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, DragFrameLayout.c, SwipListView.a
{
  private TopRecommendListView jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView;
  private TopPanelView jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private nyj jdField_a_of_type_Nyj;
  private saf jdField_a_of_type_Saf;
  private boolean aT;
  private boolean avy;
  private ImageView dr;
  private ArrayList<String> lS = new ArrayList();
  private View mContainer;
  private List<nyi> mDataList;
  private View mEmptyView;
  private ExtraTypeInfo mExtraTypeInfo;
  private long mStartTime;
  private TextView mTitle;
  private arhz n;
  private TextView tS;
  private TextView tT;
  private TextView tU;
  private final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  
  private void L(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderActivity", 2, "enableFlingRight->enable:" + paramBoolean);
    }
  }
  
  private void aC()
  {
    this.mTitle.setText(nyn.d(this.app));
    Object localObject;
    if ((this.leftView == null) || (this.aT))
    {
      if (this.tT != null)
      {
        this.tT.setVisibility(8);
        localObject = this.tT.getLayoutParams();
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = wja.dp2px(32.0F, getResources());
          this.tT.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.tU != null) {
        this.tU.setVisibility(8);
      }
      if (this.rightViewText != null)
      {
        if (!obt.Gz()) {
          break label302;
        }
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(acfp.m(2131720630));
        this.rightViewText.setOnClickListener(this);
      }
    }
    for (;;)
    {
      aQ();
      return;
      if (this.tU != null)
      {
        localObject = this.tU.getBackground();
        if ((localObject != null) && ((localObject instanceof GradientDrawable)))
        {
          GradientDrawable localGradientDrawable = (GradientDrawable)((Drawable)localObject).mutate();
          localGradientDrawable.setColor(getResources().getColorStateList(2131167301).getDefaultColor());
          ((Drawable)localObject).setAlpha(46);
          this.tU.setBackgroundDrawable(localGradientDrawable);
        }
        if (ThemeUtil.isInNightMode(this.app))
        {
          localObject = this.tU.getLayoutParams();
          if ((localObject instanceof ViewGroup.MarginLayoutParams))
          {
            ((RelativeLayout.LayoutParams)localObject).leftMargin = wja.dp2px(40.0F, getResources());
            this.tU.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        this.tU.setTextColor(getResources().getColor(2131167301));
        this.tU.setVisibility(8);
      }
      if (this.tT == null) {
        break;
      }
      this.tT.setVisibility(8);
      break;
      label302:
      this.rightViewText.setVisibility(8);
    }
  }
  
  private void aQ()
  {
    if (this.aT) {}
    for (TextView localTextView = this.tT;; localTextView = this.tU)
    {
      if ((localTextView != null) && (this.mExtraTypeInfo != null) && (this.mExtraTypeInfo.sourceType == 9004)) {
        ThreadManager.executeOnSubThread(new ServiceAccountFolderActivity.3(this, localTextView));
      }
      return;
    }
  }
  
  private void bct()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    try
    {
      Field localField = localInputMethodManager.getClass().getDeclaredField("mLastSrvView");
      if (!localField.isAccessible()) {
        localField.setAccessible(true);
      }
      localField.set(localInputMethodManager, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      QZLog.w("ServiceAccountFolderActivity", "[onDestroy]", localThrowable);
    }
  }
  
  private void bcu()
  {
    View localView = super.findViewById(2131377361);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = super.findViewById(2131379791);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = super.findViewById(2131369579);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
  }
  
  private void bcw()
  {
    if ((this.mDataList == null) || (this.mDataList.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext())
      {
        nyi localnyi = (nyi)localIterator.next();
        if (!this.lS.contains(localnyi.mUin))
        {
          this.lS.add(localnyi.mUin);
          String str2 = "";
          String str1 = str2;
          if (localnyi.d != null)
          {
            str1 = str2;
            if (localnyi.d.mExJsonObject != null) {
              str1 = localnyi.d.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
            }
          }
          adak.a(this.app, localnyi.mUin, localnyi.mUnreadFlag, localnyi.mUnreadNum, localnyi.v.toString(), str1);
        }
      }
    }
  }
  
  private void bcx()
  {
    Manager localManager = this.app.getManager(36);
    if ((localManager instanceof altq))
    {
      ((altq)localManager).dx(104000, "104000.104001");
      QLog.d("ServiceAccountFolderActivity", 2, "uin:" + this.app.getCurrentUin() + "   exposurePublicAccountMessagePopRedDot");
    }
  }
  
  private void initListView()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setContentBackground(getResources().getDrawable(2130838901), false);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setBackgroundResource(2130838901);
    this.jdField_a_of_type_Nyj = new nyj(this.app, this, this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView);
    this.jdField_a_of_type_Nyj.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.mDataList = nyn.a().be();
    this.jdField_a_of_type_Nyj.cS(this.mDataList);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setAdapter(this.jdField_a_of_type_Nyj);
  }
  
  private void initViews()
  {
    this.mContainer = super.findViewById(2131378058);
    this.mTitle = ((TextView)super.findViewById(2131369627));
    this.tS = ((TextView)super.findViewById(2131369579));
    this.tU = ((TextView)findViewById(2131369619));
    this.tT = ((TextView)super.findViewById(2131380514));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView = ((TopRecommendListView)super.findViewById(2131378065));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView = new TopPanelView(this);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Saf = new saf(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.addHeaderView(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
    this.dr = ((ImageView)findViewById(2131369967));
    this.n = new arhz(this, super.getTitleBarHeight());
    this.n.setCanceledOnTouchOutside(true);
    this.n.setMessage(2131697481);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.b(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.mEmptyView = super.findViewById(2131378060);
    ((TextView)findViewById(2131378059)).setText("暂无" + obt.lc() + "消息");
  }
  
  protected TopGestureLayout a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    nyi localnyi;
    long l;
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode() == -1) && (paramDragFrameLayout.bI() != null) && (paramDragFrameLayout.bI().getId() == 2131381288))
    {
      paramInt = ((Integer)paramDragFrameLayout.bI().getTag()).intValue();
      localnyi = (nyi)this.jdField_a_of_type_Nyj.getItem(paramInt);
      if (localnyi != null)
      {
        l = nyn.a().a(localnyi);
        localQQAppInterface = this.app;
        if (!localnyi.Gq()) {
          break label255;
        }
      }
    }
    label255:
    for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
    {
      anot.a(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, "" + localnyi.mUnreadNum, "" + (paramInt + 1), "" + l);
      nyn.a().b(this.app, localnyi, true);
      sqn.b(localnyi.mUin, "auth_page", "ignore", 0, 0, new String[0]);
      aQ();
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderActivity", 2, "onChange->drag red dot:" + localnyi.mUin);
      }
      return;
    }
  }
  
  protected void bcv()
  {
    if (this.avy) {
      return;
    }
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null)
    {
      this.avy = true;
      localTopGestureLayout.setInterceptTouchEventListener(new nyb(this));
      return;
    }
    QLog.e("ServiceAccountFolderActivity", 2, "processTopPanelTouchEvent failed! topGestureLayout return null!");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if ((QzoneConfig.getInstance().getConfig("qqsubscribe", "JumpToNewServiceAccount", 1) <= 0) || (!obt.Gz())) {}
    for (;;)
    {
      super.doOnCreate(paramBundle);
      super.setContentView(2131559843);
      this.mExtraTypeInfo = ((ExtraTypeInfo)getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
      this.app.setHandler(getClass(), this.uiHandler);
      this.aT = ThemeUtil.isDefaultOrDIYTheme(false);
      initViews();
      aC();
      initListView();
      bcu();
      nyn.a().d(this.app, NetConnInfoCenter.getServerTime());
      if (obt.Gz()) {
        this.jdField_a_of_type_Saf.start();
      }
      paramBundle = (WebProcessManager)this.app.getManager(13);
      if (paramBundle != null) {
        paramBundle.egu();
      }
      bcx();
      return true;
      Intent localIntent = new Intent();
      Bundle localBundle = getIntent().getExtras();
      if (localBundle != null) {
        localIntent.putExtras(localBundle);
      }
      localIntent.setClass(this, ServiceAccountFolderActivityNew.class);
      startActivity(localIntent);
      finish();
    }
  }
  
  public void doOnDestroy()
  {
    nyn.a().d(this.app, NetConnInfoCenter.getServerTime());
    sqn.b(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_page", "exp", 0, 0, new String[] { "", String.valueOf(System.currentTimeMillis() - this.mStartTime) });
    if (this.uiHandler != null) {
      this.uiHandler.removeCallbacksAndMessages(null);
    }
    this.app.removeHandler(getClass());
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.removeHeaderView(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Saf != null) {
      this.jdField_a_of_type_Saf.destroy();
    }
    if (this.jdField_a_of_type_Nyj != null) {
      this.jdField_a_of_type_Nyj.onDestory();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    if (this.n != null) {
      this.n.dismiss();
    }
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchEventListener(null);
    }
    bct();
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.onPause();
    }
    nyn.a().d(this.app, NetConnInfoCenter.getServerTime());
    adak.a(this.app, "9953", 1, 1, System.currentTimeMillis() - this.mStartTime);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    bcv();
    ThreadManager.executeOnSubThread(new ServiceAccountFolderActivity.2(this, nyn.a()));
    odd.bU("SERVICE_FOLDER_COST", null);
    this.mStartTime = System.currentTimeMillis();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      this.uiHandler.removeMessages(100);
      ThreadManager.executeOnSubThread(new ServiceAccountFolderActivity.1(this));
    }
    do
    {
      return true;
      if (paramMessage.what == 101)
      {
        this.jdField_a_of_type_Nyj.cS(this.mDataList);
        if (this.jdField_a_of_type_Nyj.getCount() == 0) {}
        for (boolean bool = true;; bool = false)
        {
          qt(bool);
          aQ();
          bcw();
          return true;
        }
      }
    } while (paramMessage.what != 102);
    aQ();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
      continue;
      MiniAppLauncher.startMiniApp(this, QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4"), 2016, null, null);
      avpw.eBx();
      anot.a(this.app, "dc00898", "", "", "auth_page", "clk_find", 0, 0, "", "", "", "");
      continue;
      rzd.sW("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
    }
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    L(true);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    L(false);
  }
  
  public void qt(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setVisibility(8);
      if (ThemeUtil.isInNightMode(this.app))
      {
        this.mContainer.setBackgroundResource(2130838901);
        if (this.mEmptyView != null)
        {
          Rect localRect = new Rect();
          getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
          int i = localRect.height();
          int j = View.MeasureSpec.makeMeasureSpec(0, 0);
          int k = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.mEmptyView.measure(j, k);
          i = (i - this.mEmptyView.getMeasuredHeight()) / 2;
          j = (int)getResources().getDimension(2131299627);
          ((ViewGroup.MarginLayoutParams)this.mEmptyView.getLayoutParams()).topMargin = (i - j);
          this.mEmptyView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderActivity", 2, "showEmptyView->show:" + paramBoolean);
      }
      return;
      this.mContainer.setBackgroundColor(Color.parseColor("#f5f5f5"));
      break;
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setVisibility(0);
      if (this.mEmptyView != null) {
        this.mEmptyView.setVisibility(8);
      }
    }
  }
  
  public void showProgressBar(boolean paramBoolean)
  {
    if (this.n != null)
    {
      if ((!paramBoolean) || (this.n.isShowing())) {
        break label80;
      }
      this.n.show();
      this.uiHandler.postDelayed(new ServiceAccountFolderActivity.4(this), 5000L);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderActivity", 2, "showProgressBar->show:" + paramBoolean);
      }
      return;
      label80:
      if ((!paramBoolean) && (this.n.isShowing())) {
        this.n.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity
 * JD-Core Version:    0.7.0.1
 */