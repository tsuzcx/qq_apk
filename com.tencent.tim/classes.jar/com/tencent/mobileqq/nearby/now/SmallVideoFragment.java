package com.tencent.mobileqq.nearby.now;

import ajpj;
import ajvk;
import ajvo;
import ajvp;
import ajxs;
import ajxt;
import ajxu;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import anre;
import aqmf;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout.a;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.nearby.now.view.CustomViewPager;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.List;
import jll;
import mqq.os.MqqHandler;

public class SmallVideoFragment
  extends PublicBaseFragment
  implements ajvk, DragFrameLayout.a
{
  protected View EV;
  protected int JO;
  protected int Sn;
  protected int So;
  public CustomViewPager a;
  public StuffContainerView a;
  protected boolean aEM;
  protected DragFrameLayout b;
  protected QQStoryLoadingView b;
  private Bundle bl;
  private boolean cqu = true;
  protected RelativeLayout kZ;
  protected RelativeLayout la;
  private FragmentActivity mActivity;
  protected AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new ajvp(this);
  protected AudioManager mAudioManager;
  private long mBeginTime;
  private String mCoverUrl;
  private int mFeedType = -1;
  private boolean mIsResume;
  protected View mLoadingMask;
  protected int mViewHeight;
  public View rootView;
  
  private int GE()
  {
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout = ((DragFrameLayout)findViewById(2131366128));
    this.EV = findViewById(2131362690);
    this.la = ((RelativeLayout)findViewById(2131373545));
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)findViewById(2131381737));
    this.kZ = ((RelativeLayout)findViewById(2131366142));
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setDraggableView(this.kZ);
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setOnDraggingListener(this);
    this.Sn = 0;
    this.So = 0;
    this.JO = -1;
    this.mViewHeight = -1;
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.minWidth = this.JO;
    int i = this.JO;
    if (this.JO > this.mViewHeight) {
      i = this.JO / 2;
    }
    return i;
  }
  
  private boolean arC()
  {
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter();
    if ((localVideoPlayerPagerAdapter.getView(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem()) instanceof ShortVideoCommentsView)) {
      return ((ShortVideoCommentsView)localVideoPlayerPagerAdapter.getView(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem())).arE();
    }
    return false;
  }
  
  private void db(Bundle paramBundle)
  {
    if ("2".equals(paramBundle.getString("play_mode")))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.Mw(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.Mw(true);
  }
  
  private void dc(Bundle paramBundle) {}
  
  private void dzB()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setOnCloseListener(new ajvo(this));
  }
  
  private void dzC()
  {
    this.la.setVisibility(0);
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.startAnimation();
    if (!TextUtils.isEmpty(this.bl.getString("imageUri"))) {
      this.mCoverUrl = this.bl.getString("imageUri");
    }
    for (;;)
    {
      if (getActivity().getIntent() != null)
      {
        int i = getActivity().getIntent().getIntExtra("system_msg_type", 0);
        boolean bool = getActivity().getIntent().getBooleanExtra("scroll_to_comment", false);
        this.mFeedType = getActivity().getIntent().getIntExtra("feedType", -1);
        if ((i == 2) || (bool)) {
          ThreadManager.getUIHandler().postDelayed(new SmallVideoFragment.2(this), 1000L);
        }
      }
      return;
      if (!TextUtils.isEmpty(this.bl.getString("cover_url"))) {
        this.mCoverUrl = this.bl.getString("cover_url");
      }
    }
  }
  
  public static void g(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    localIntent.addFlags(268435456);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicTransFragmentActivity.start(paramContext, localIntent, SmallVideoFragment.class);
  }
  
  public static void launch(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("raw_url", paramString);
    paramString = Uri.parse(paramString);
    String str1 = paramString.getQueryParameter("scroll_to_comment");
    String str2 = paramString.getQueryParameter("_from");
    if ((!TextUtils.isEmpty(str1)) && (str1.equals("1"))) {
      localIntent.putExtra("scroll_to_comment", true);
    }
    if (!TextUtils.isEmpty(str2)) {
      localIntent.putExtra("_from", str2);
    }
    localIntent.addFlags(268435456);
    localIntent.putExtra("public_fragment_window_feature", 1);
    paramString = paramString.getQueryParameter("play_mode");
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("play_mode", paramString);
    }
    PublicTransFragmentActivity.start(paramContext, localIntent, SmallVideoFragment.class);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt1 - paramInt3 > jll.dp2px(getActivity(), 60.0F))
    {
      new ajxs().h("video").i("slide_quit").b().dy(getActivity().app);
      if (this.aEM) {
        dzD();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.dAh();
        return;
        getActivity().finish();
      }
    }
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.xV(250);
    paramView = new AlphaAnimation(ViewHelper.getAlpha(this.EV), 1.0F);
    paramView.setFillAfter(true);
    paramView.setDuration(200L);
    this.EV.startAnimation(paramView);
  }
  
  public void ahH()
  {
    if (this.mAudioManager == null) {
      this.mAudioManager = ((AudioManager)getActivity().getApplicationContext().getSystemService("audio"));
    }
    try
    {
      int j = this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 2);
      int i = j;
      if (j == 0) {
        i = this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1);
      }
      if (i == 0) {
        this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 3);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    float f1 = 0.0F;
    float f2 = 1.0F - (paramInt3 - paramInt5) / jll.dp2px(getActivity(), 60.0F);
    if (f2 < 0.0F) {}
    for (;;)
    {
      ViewHelper.setAlpha(this.EV, f1);
      return;
      f1 = f2;
    }
  }
  
  public void cWn()
  {
    if (this.mLoadingMask != null) {
      this.mLoadingMask.setVisibility(8);
    }
    if (this.la.getVisibility() != 8)
    {
      this.kZ.setBackgroundDrawable(new ColorDrawable(-1));
      this.la.setVisibility(8);
      this.la.setBackgroundColor(0);
      if (this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView != null)
      {
        this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.stopAnimation();
        this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      }
    }
  }
  
  public void dzD()
  {
    new ajxs().h("video").i("clk_quit").b().dy(getActivity().app);
    if (!this.aEM)
    {
      getActivity().finish();
      return;
    }
    ViewHelper.setAlpha(this.EV, 0.0F);
    this.EV.setVisibility(8);
  }
  
  public View findViewById(int paramInt)
  {
    return this.rootView.findViewById(paramInt);
  }
  
  protected int getContentLayoutId()
  {
    return 2131561465;
  }
  
  public void hideProgress()
  {
    if (this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView != null)
    {
      this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.stopAnimation();
      this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().addFlags(128);
    paramActivity.getWindow().setSoftInputMode(18);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = (VideoPlayerPagerAdapter)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter();
    if ((((VideoPlayerPagerAdapter)localObject).getView(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem()) instanceof ShortVideoCommentsView)) {
      ((ShortVideoCommentsView)((VideoPlayerPagerAdapter)localObject).getView(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem())).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == -1)
    {
      if (paramInt1 != 123) {
        break label210;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramIntent);
      paramIntent = anre.a(((Intent)localObject).getByteArrayExtra("stuctmsg_bytes"));
      if (paramIntent != null) {}
    }
    for (;;)
    {
      return;
      String str = ((Intent)localObject).getStringExtra("uin");
      paramInt2 = ((Intent)localObject).getIntExtra("uintype", -1);
      aqmf.a(getActivity().app, str, paramInt2, paramIntent, null);
      new ajxs().h("video").i("playpage_fw_suc").a().dy(getActivity().app);
      ThreadManagerV2.excute(new SmallVideoFragment.4(this, (ajpj)this.mActivity.app.getManager(106)), 16, null, false);
      while (paramInt1 > 1000)
      {
        return;
        label210:
        if (paramInt1 == 124) {
          ThreadManagerV2.excute(new SmallVideoFragment.5(this, (ajpj)this.mActivity.app.getManager(106)), 16, null, false);
        }
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = ((FragmentActivity)paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ajxu.init(getActivity(), "shortVideo");
    ajxt.RB(0);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.rootView = paramLayoutInflater.inflate(getContentLayoutId(), null);
    this.rootView.setFitsSystemWindows(true);
    this.mBeginTime = System.currentTimeMillis();
    getActivity().getIntent().putExtra("fling_action_key", 0);
    this.bl = super.getActivity().getIntent().getExtras();
    ajxs.from = this.bl.getString("_from", "");
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView = ((StuffContainerView)findViewById(2131381766));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setApp(getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCallBack(this);
    db(this.bl);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.b;
    this.mLoadingMask = findViewById(2131370806);
    int i = GE();
    dzC();
    dc(this.bl);
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.minWidth = i;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.de(this.bl);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.df(this.bl);
    dzB();
    ajxt.dzR();
    paramLayoutInflater = this.rootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    long l = System.currentTimeMillis() - this.mBeginTime;
    ajxs localajxs = new ajxs().h("video").i("playpage_time").g(l + "").b();
    if (getActivity() != null) {}
    for (QQAppInterface localQQAppInterface = getActivity().app;; localQQAppInterface = null)
    {
      localajxs.dy(localQQAppInterface);
      ThreadManagerV2.excute(new SmallVideoFragment.3(this, l, (ajpj)this.mActivity.app.getManager(106)), 16, null, false);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.onDestroy();
      if (this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout != null) {
        this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.onDestroy();
      }
      if (this.mAudioManager != null) {
        this.mAudioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
      }
      AnimatorProxy.wrap(this.EV).reset();
      AnimatorProxy.wrap(this.kZ).reset();
      return;
    }
  }
  
  public void onFinish()
  {
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter();
    if ((localVideoPlayerPagerAdapter.getView(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem()) instanceof ShortVideoCommentsView)) {
      ((ShortVideoCommentsView)localVideoPlayerPagerAdapter.getView(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem())).dAe();
    }
    super.onFinish();
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 2130772079);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.mIsResume = false;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.onPause();
    if (this.mAudioManager != null) {
      this.mAudioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
    }
  }
  
  public void onResume()
  {
    this.mIsResume = true;
    super.onResume();
    if (this.cqu) {
      this.cqu = false;
    }
    for (;;)
    {
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.getWindowToken(), 0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.onResume();
    }
  }
  
  public boolean yB()
  {
    return arC();
  }
  
  public boolean yC()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      int i = ((VideoPlayerPagerAdapter)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter()).jG.size();
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter().getCount() == 0) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem() >= i - 1)) {
        return arC();
      }
    }
    return false;
  }
  
  public boolean yD()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem() == 0) {
      return arC();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment
 * JD-Core Version:    0.7.0.1
 */