package com.tencent.mobileqq.minigame.publicaccount;

import aacm;
import aaft;
import abmt;
import acbn;
import acfp;
import adta;
import ahuh;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlm;
import aqmu;
import aqnm;
import aqyx;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import wja;

public class MiniGamePublicAccountWebFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private static final int GAME_STORE_HEIGHT = 55;
  private static final int MORE_MSG_MARGIN = 20;
  public static final String TAG = "MiniGamePublicAccountWebFragment";
  private List<String> arkAppNameList = new ArrayList();
  private View contentView;
  private ahuh currIHeaderView;
  public long enterQQGamePubTime;
  private EIPCResultCallback getMsgCallback = new MiniGamePublicAccountWebFragment.1(this);
  public long initUiTime;
  public long initWebViewTime;
  private LinearLayout loadLayout;
  public long loadUrlEndTime;
  private GestureDetector mGestureDetector;
  List<ahuh> mHeaderRecords = new ArrayList();
  private MiniGamePublicAccountViewPagerIndicator mIndicator;
  private RelativeLayout moreMsgLayout;
  private List<QQGameMsgInfo> msgInfoList;
  private TextView navTitle;
  private HeadPageAdapter pagerAdapter;
  private LinearLayout pagerContainer;
  public long parsePageEndTime;
  public long startTime;
  public MiniGamePublicAccountNavBar titleBar;
  private QQGamePubViewpager viewPager;
  private MiniGamePublicAccountWebView webView;
  private MiniGamePublicAccountWebViewBuilder webViewBuilder;
  
  static
  {
    adta.GI(true);
    adta.cUm();
  }
  
  private void enterAIO()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(getActivity(), SplashActivity.class.getName());
      localIntent = wja.a(localIntent, new int[] { 1 });
      localIntent.putExtra("shouldreport", true);
      localIntent.putExtra("has_unread_msg", false);
      localIntent.putExtra("jump_from", 1);
      localIntent.setClass(getActivity(), ChatActivity.class);
      localIntent.putExtra("uin", acbn.blT);
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", getString(2131695943));
      localIntent.putExtra("entrance", 1);
      localIntent.putExtra("aio_msg_source", 0);
      getActivity().startActivity(localIntent);
      MiniProgramLpReportDC04239.reportAsync("minigamechengzaiye", "top_news_more", "click", null);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniGamePublicAccountWebFragment", 1, "enterAIO error", localThrowable);
    }
  }
  
  private void getGameMsgList()
  {
    QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", "action_get_mini_game_public_account_msg", null, this.getMsgCallback);
  }
  
  private int getWebHeaderHeight()
  {
    int i = 55;
    if (this.pagerContainer.getVisibility() == 0) {
      i = (int)(55 + (wja.a(this.pagerContainer.getMeasuredHeight() + this.moreMsgLayout.getMeasuredHeight(), getResources()) + 20.0F));
    }
    return i;
  }
  
  private void gotoAccountDetail()
  {
    Intent localIntent = new Intent(getActivity(), AccountDetailActivity.class);
    localIntent.putExtra("uin", acbn.blT);
    localIntent.putExtra("fromMiniGamePub", true);
    startActivity(localIntent);
  }
  
  private void handleDefaultLoading()
  {
    this.loadLayout.removeAllViews();
    TextView localTextView = new TextView(getActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = wja.dp2px(7.0F, getActivity().getResources());
    localTextView.setText(acfp.m(2131711711));
    localTextView.setTextColor(2130706432);
    ImageView localImageView = new ImageView(getActivity());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getActivity().getResources().getDrawable(2130848044);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getActivity().getResources().getDrawable(2130848044);
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_refresh_small_gray@2x.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setVisibility(0);
    localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setDuration(1000L);
    localImageView.startAnimation((Animation)localObject);
    localObject = new LinearLayout.LayoutParams(wja.dp2px(15.0F, getActivity().getResources()), wja.dp2px(15.0F, getActivity().getResources()));
    this.loadLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.loadLayout.addView(localTextView, localLayoutParams);
  }
  
  private void initHead(View paramView)
  {
    MiniGamePublicAccountHeadLayout localMiniGamePublicAccountHeadLayout = (MiniGamePublicAccountHeadLayout)paramView.findViewById(2131375048);
    this.webView = ((MiniGamePublicAccountWebView)paramView.findViewById(2131375049));
    localMiniGamePublicAccountHeadLayout.attachToRootView();
    this.webView.attachHeaderView(localMiniGamePublicAccountHeadLayout);
    this.pagerContainer = ((LinearLayout)localMiniGamePublicAccountHeadLayout.findViewById(2131370229));
    this.viewPager = ((QQGamePubViewpager)localMiniGamePublicAccountHeadLayout.findViewById(2131366996));
    this.mIndicator = ((MiniGamePublicAccountViewPagerIndicator)localMiniGamePublicAccountHeadLayout.findViewById(2131372828));
    paramView = (ImageView)localMiniGamePublicAccountHeadLayout.findViewById(2131367853);
    TextView localTextView = (TextView)localMiniGamePublicAccountHeadLayout.findViewById(2131371955);
    this.moreMsgLayout = ((RelativeLayout)localMiniGamePublicAccountHeadLayout.findViewById(2131371956));
    paramView.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    this.pagerAdapter = new HeadPageAdapter(null);
    this.viewPager.setAdapter(this.pagerAdapter);
    this.viewPager.setOffscreenPageLimit(5);
    this.mIndicator.setViewPager(this.viewPager);
    this.mIndicator.refreshIndicator();
    MiniProgramLpReportDC04239.reportAsync("minigamechengzaiye", "top_minigame", "expo", null);
  }
  
  private void initLoad(View paramView)
  {
    Object localObject = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = ((DisplayMetrics)localObject).heightPixels;
    this.loadLayout = ((LinearLayout)paramView.findViewById(2131370776));
    int j = wja.dp2px(418.0F, getActivity().getResources());
    localObject = this.loadLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = wja.dp2px(i - j, getActivity().getResources());
    this.loadLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = aacm.a();
    if (TextUtils.isEmpty(PreloadManager.a("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", false, 0).filePath))
    {
      handleDefaultLoading();
      ((aacm)localObject).c("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new MiniGamePublicAccountWebFragment.2(this));
      return;
    }
    ((aacm)localObject).c("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new MiniGamePublicAccountWebFragment.3(this, paramView));
  }
  
  private void refreshHead(int paramInt)
  {
    if (this.pagerAdapter != null)
    {
      this.pagerAdapter.notifyDataSetChanged();
      this.mIndicator.refreshIndicator();
      if (paramInt != -1) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new MiniGamePublicAccountWebFragment.8(this, paramInt), 200L);
      }
    }
  }
  
  public View createEmptyView()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131559371, null, false);
    ((ImageView)localView.findViewById(2131366418)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public void initTitle(View paramView)
  {
    this.titleBar = ((MiniGamePublicAccountNavBar)paramView.findViewById(2131377361));
    this.titleBar.setRightImage(getResources().getDrawable(2130849180));
    this.titleBar.changeBg(true);
    this.navTitle = this.titleBar.getTitleTextView();
    this.navTitle.setText(2131695943);
    this.navTitle.setTextColor(-16777216);
    this.titleBar.setOnItemSelectListener(new MiniGamePublicAccountWebFragment.5(this));
    initTitleEvent();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void initTitleEvent()
  {
    this.mGestureDetector = new GestureDetector(getActivity(), new MiniGamePublicAccountWebFragment.6(this));
    this.navTitle.setOnTouchListener(new MiniGamePublicAccountWebFragment.7(this));
  }
  
  public long initWebView()
  {
    long l = SystemClock.elapsedRealtime();
    if (this.webView == null) {
      this.webView = new MiniGamePublicAccountWebView(getActivity());
    }
    this.webViewBuilder = new MiniGamePublicAccountWebFragment.4(this, getActivity(), getActivity(), abmt.getAppInterface(), this.webView);
    this.webViewBuilder.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new aqyx(this.webViewBuilder).a(null, abmt.getAppInterface(), null);
    this.webView = ((MiniGamePublicAccountWebView)this.webViewBuilder.getWebView());
    this.webView.setWillNotCacheDrawing(false);
    this.webView.setDrawingCacheEnabled(true);
    String str = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePublicAccountWebUrl", "https://h5.qzone.qq.com/miniapp/act/gamePublic");
    this.webView.loadUrl(str);
    return SystemClock.elapsedRealtime() - l;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void notifyWebHeaderHeight(int paramInt)
  {
    try
    {
      if (this.webView != null)
      {
        WebViewPluginEngine localWebViewPluginEngine = this.webView.getPluginEngine();
        if (localWebViewPluginEngine != null)
        {
          HashMap localHashMap = new HashMap();
          if (paramInt != -1) {
            localHashMap.put("height", Integer.valueOf(paramInt));
          }
          localWebViewPluginEngine.handleEvent(this.webView.getUrl(), 8589934624L, localHashMap);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniGamePublicAccountWebFragment", 1, "notify web error", localThrowable);
    }
  }
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
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
      enterAIO();
      continue;
      String str = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePublicAccountGameStoreUrl", "mqqapi://miniapp/open?_atype=0&_mappid=1108291530&_mvid=&_path=pages%2Fgame-list%2Fgame-list%3Fmode%3Dchengzaiye&_vt=3&via=2015_5_11&_sig=1248527088");
      MiniAppLauncher.startMiniApp(getActivity(), str, 4011, null);
      MiniProgramLpReportDC04239.reportAsync("minigamechengzaiye", "top_minigame", "click", null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.startTime = SystemClock.elapsedRealtime();
    getGameMsgList();
    if ((getActivity().getIntent() != null) && (getActivity().getIntent().hasExtra("startTime")))
    {
      long l = getActivity().getIntent().getLongExtra("startTime", 0L);
      if (l > 0L) {
        this.enterQQGamePubTime = (SystemClock.elapsedRealtime() - l);
      }
    }
    this.contentView = paramLayoutInflater.inflate(2131559619, paramViewGroup, false);
    if (!anlm.ayn())
    {
      getActivity().mSystemBarComp = null;
      getActivity().setImmersiveStatus(0);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    }
    initHead(this.contentView);
    this.initUiTime = (SystemClock.elapsedRealtime() - this.startTime);
    this.initWebViewTime = initWebView();
    initTitle(this.contentView);
    initLoad(this.contentView);
    paramLayoutInflater = this.contentView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    int i;
    if (this.mHeaderRecords != null) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.mHeaderRecords.size())
        {
          if (!(this.mHeaderRecords.get(i) instanceof GameArkView)) {
            break label199;
          }
          ((GameArkView)this.mHeaderRecords.get(i)).destory();
          if (!QLog.isColorLevel()) {
            break label199;
          }
          QLog.d("MiniGamePublicAccountWebFragment", 2, "header destroy i=" + i);
          break label199;
        }
        this.mHeaderRecords.clear();
      }
      catch (Throwable localThrowable)
      {
        Iterator localIterator;
        String str;
        QLog.e("MiniGamePublicAccountWebFragment", 1, "header destroy error=" + localThrowable.toString());
        continue;
        aaft.a().D(new String[0]);
        return;
      }
      if (this.webViewBuilder != null) {
        this.webViewBuilder.onDestroy();
      }
      localIterator = this.arkAppNameList.iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        aaft.a().Aj(str);
      }
      else
      {
        label199:
        i += 1;
      }
    }
  }
  
  public void onDestroyView()
  {
    if (this.arkAppNameList != null) {
      aaft.a().hF(this.arkAppNameList);
    }
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.webViewBuilder != null) {
      this.webViewBuilder.onPause();
    }
    if (this.currIHeaderView != null) {
      this.currIHeaderView.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.webViewBuilder != null) {
      this.webViewBuilder.onResume();
    }
    if (this.currIHeaderView != null) {
      this.currIHeaderView.onResume();
    }
    try
    {
      int i = this.msgInfoList.size();
      if ((this.viewPager != null) && (i > 0) && (this.viewPager.getCurrentItem() == i)) {
        this.viewPager.setCurrentItem(i - 1);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", "action_do_on_resume", null, null);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  class HeadPageAdapter
    extends PagerAdapter
  {
    private HeadPageAdapter() {}
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      if (MiniGamePublicAccountWebFragment.this.msgInfoList == null) {
        return 0;
      }
      return MiniGamePublicAccountWebFragment.this.msgInfoList.size();
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      Object localObject = null;
      if ((MiniGamePublicAccountWebFragment.this.msgInfoList == null) || (MiniGamePublicAccountWebFragment.this.msgInfoList.size() == 0))
      {
        localObject = MiniGamePublicAccountWebFragment.this.createEmptyView();
        paramViewGroup.addView((View)localObject);
        return localObject;
      }
      for (;;)
      {
        synchronized (MiniGamePublicAccountWebFragment.this.msgInfoList)
        {
          if (paramInt >= MiniGamePublicAccountWebFragment.this.msgInfoList.size()) {
            break label525;
          }
          localQQGameMsgInfo = (QQGameMsgInfo)MiniGamePublicAccountWebFragment.this.msgInfoList.get(paramInt);
          ahuh localahuh = (ahuh)MiniGamePublicAccountWebFragment.this.mHeaderRecords.get(paramInt);
          if (localahuh == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MiniGamePublicAccountWebFragment", 2, "headerView = null");
            }
            return null;
          }
          if (((localahuh instanceof MoreMsgHeaderView)) && (paramInt != MiniGamePublicAccountWebFragment.this.msgInfoList.size())) {
            return null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MiniGamePublicAccountWebFragment", 2, "headerView = " + localahuh.getClass().getSimpleName());
          }
          RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
          if (((View)localahuh).getParent() != null) {
            ((ViewGroup)((View)localahuh).getParent()).removeView((View)localahuh);
          }
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
          localLayoutParams.addRule(13, ((View)localahuh).getId());
          localLayoutParams.topMargin = aqnm.dpToPx(40.0F);
          if (localQQGameMsgInfo == null) {
            break label519;
          }
          localTextView = new TextView(MiniGamePublicAccountWebFragment.this.getActivity());
          localTextView.setTextColor(-1);
          localTextView.setTextSize(1, 10.0F);
          localTextView.setBackgroundColor(Color.parseColor("#D0D8F2"));
          localTextView.setText(aqmu.a(MiniGamePublicAccountWebFragment.this.getActivity(), 3, localQQGameMsgInfo.msgTime * 1000L));
          localTextView.setPadding(12, 0, 12, 0);
          localTextView.setId(2131379675);
          localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
          if (localObject == null)
          {
            localObject = new RelativeLayout.LayoutParams(-2, wja.dp2px(15.0F, MiniGamePublicAccountWebFragment.this.getResources()));
            localTextView.setGravity(17);
            ((RelativeLayout.LayoutParams)localObject).addRule(14);
            ((RelativeLayout.LayoutParams)localObject).addRule(10);
            localTextView.bringToFront();
            if (localTextView != null) {
              localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
            }
            localRelativeLayout.addView((View)localahuh, localLayoutParams);
            paramViewGroup.addView(localRelativeLayout, localLayoutParams);
            if (localQQGameMsgInfo != null)
            {
              localahuh.a(localQQGameMsgInfo, MiniGamePublicAccountWebFragment.this.getActivity(), paramInt);
              return localRelativeLayout;
            }
            localahuh.a(new QQGameMsgInfo(), MiniGamePublicAccountWebFragment.this.getActivity(), paramInt);
          }
        }
        continue;
        label519:
        TextView localTextView = null;
        continue;
        label525:
        QQGameMsgInfo localQQGameMsgInfo = null;
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment
 * JD-Core Version:    0.7.0.1
 */