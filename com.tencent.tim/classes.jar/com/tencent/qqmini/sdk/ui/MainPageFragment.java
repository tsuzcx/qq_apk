package com.tencent.qqmini.sdk.ui;

import NS_COMM.COMM.StCommonExt;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentActivity;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentActivity.Launcher;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class MainPageFragment
  extends MiniBaseFragment
  implements View.OnClickListener
{
  private static final String LIKE_NUM_POSTFIX = "个赞";
  private static final String MINI_FILE_SUB_PATH = "/tencent/mini/files/";
  private static final String MINI_LOG_PATH = Environment.getExternalStorageDirectory().getPath() + "/tencent/mini/files/";
  public static final String TAG = "MainPageFragment";
  private boolean isLike;
  private boolean isMiniGame = false;
  private ImageView mAppIcon;
  private TextView mAppName;
  private TextView mBackTextView;
  private ImageView mBackView;
  private ChannelProxy mChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  private View mComplainCallbackContainer;
  private Button mEnterMiniAppBtn;
  private TextView mIntroduction;
  private ImageView mLikeBtn;
  private View mLikeContainer;
  private COMM.StCommonExt mLikeExtInfo;
  private TextView mLikeNum;
  private int mLikeNumber = 0;
  private View.OnLongClickListener mLongClickListener = new MainPageFragment.1(this);
  private MiniAppDialog mMiniAppDialog;
  private MiniAppInfo mMiniAppInfo;
  private MiniAppProxy mMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  private ImageView mMoreView;
  private Button mRecommendMiniAppBtn;
  private View mRelativePublicAccountContainer;
  private View mSeparator;
  private View mSetTopContainer;
  private Switch mSetTopSwitch;
  private TextView mSetTopText;
  private COMM.StCommonExt mTopExtInfo;
  
  private Drawable getIconDrawable(String paramString)
  {
    int i = DisplayUtil.dip2px(getActivity(), 70.0F);
    Drawable localDrawable = null;
    try
    {
      if (Build.VERSION.SDK_INT >= 21) {
        localDrawable = getActivity().getDrawable(R.drawable.mini_sdk_icon_loading_default);
      }
      return this.mMiniAppProxy.getDrawable(getActivity(), paramString, i, i, localDrawable);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("MainPageFragment", "getIconDrawable, exception!");
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  private void handleMoreButtonEvent()
  {
    this.mMiniAppDialog = new MiniAppDialog(getActivity());
    this.mMiniAppDialog.setContentView(LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_main_page_dialog_layout, null));
    TextView localTextView = (TextView)this.mMiniAppDialog.findViewById(R.id.miniapp_seting);
    localTextView.setText("设置");
    localTextView.setOnClickListener(this);
    localTextView = (TextView)this.mMiniAppDialog.findViewById(R.id.miniapp_more_information);
    localTextView.setText("更多资料");
    localTextView.setOnClickListener(this);
    ((TextView)this.mMiniAppDialog.findViewById(R.id.miniapp_dialog_cancel)).setOnClickListener(this);
    this.mMiniAppDialog.show();
  }
  
  private void initData()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.mMiniAppInfo = ((MiniAppInfo)localBundle.getParcelable("mini_app_info"));
      this.isMiniGame = this.mMiniAppInfo.isEngineTypeMiniGame();
    }
  }
  
  private void initUI()
  {
    if (this.mMiniAppInfo != null)
    {
      if (!TextUtils.isEmpty(this.mMiniAppInfo.iconUrl)) {
        this.mAppIcon.setImageDrawable(getIconDrawable(this.mMiniAppInfo.iconUrl));
      }
      this.mAppName.setText(this.mMiniAppInfo.name);
      this.mIntroduction.setText(this.mMiniAppInfo.desc);
      boolean bool = this.mMiniAppInfo.isAppStoreMiniApp();
      if ((bool) || (this.mMiniAppInfo.isInternalApp()))
      {
        this.mSetTopContainer.setVisibility(8);
        if (bool)
        {
          this.mRecommendMiniAppBtn.setVisibility(8);
          if (this.mSeparator != null) {
            this.mSeparator.setVisibility(8);
          }
        }
      }
    }
    if (this.isMiniGame)
    {
      this.mSetTopText.setText("置顶");
      this.mRecommendMiniAppBtn.setText("推荐小游戏");
      this.mEnterMiniAppBtn.setText("进入小游戏");
      this.mLikeNum.setText("为小游戏点赞");
    }
    for (;;)
    {
      if ((!QUAUtil.isQQApp()) && (!QUAUtil.isDemoApp()))
      {
        this.mSetTopContainer.setVisibility(8);
        this.mLikeContainer.setVisibility(8);
      }
      if (QUAUtil.isQQBrowseApp()) {
        this.mEnterMiniAppBtn.setVisibility(8);
      }
      return;
      if (WnsUtil.needShowMiniAppFullScreen()) {
        this.mSetTopText.setText("置顶");
      }
      this.mLikeNum.setText("为小程序点赞");
    }
  }
  
  public static void launch(Context paramContext, MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("mini_app_info", paramMiniAppInfo);
    localIntent.putExtra("versionType", paramInt);
    MiniFragmentActivity.Launcher.start(paramContext, localIntent, MiniFragmentActivity.class, MainPageFragment.class);
  }
  
  private void reportClick(String paramString)
  {
    SDKMiniProgramLpReportDC04239.reportUserClick(this.mMiniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.mMiniAppInfo), null, "user_click", "more_about", paramString);
  }
  
  private void sendGetUserAppInfoRequest()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.mMiniAppInfo.appId);
    update(this.mMiniAppInfo);
    this.mChannelProxy.getUserAppInfo(null, localArrayList, new MainPageFragment.4(this));
  }
  
  private void sendSetUserAppLikeRequest(boolean paramBoolean)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).setUserAppLike(paramBoolean, this.mLikeExtInfo, this.mMiniAppInfo.appId, new MainPageFragment.6(this));
  }
  
  private void setLikeNum()
  {
    if (this.isLike)
    {
      this.isLike = false;
      this.mLikeNumber -= 1;
      updateLikeNum(this.mLikeNumber);
      updateLikeState(this.isLike);
      sendSetUserAppLikeRequest(this.isLike);
      if (!this.isLike) {
        break label81;
      }
    }
    label81:
    for (String str = "like_on";; str = "like_off")
    {
      reportClick(str);
      return;
      this.isLike = true;
      this.mLikeNumber += 1;
      break;
    }
  }
  
  private void setMiniAppTop(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("MainPageFragment", "setMiniAppTop, miniAppInfo = null");
      return;
    }
    this.mChannelProxy.setUserAppTop(paramMiniAppInfo, new MainPageFragment.5(this));
  }
  
  private void setTopType(MiniAppInfo paramMiniAppInfo)
  {
    int i;
    if (paramMiniAppInfo.topType == 0)
    {
      i = 1;
      paramMiniAppInfo.topType = i;
      updateTopTypeState(paramMiniAppInfo);
      sendSetUserAppTopRequest(paramMiniAppInfo);
      if (paramMiniAppInfo.topType != 0) {
        break label46;
      }
    }
    label46:
    for (paramMiniAppInfo = "settop_off";; paramMiniAppInfo = "settop_on")
    {
      reportClick(paramMiniAppInfo);
      return;
      i = 0;
      break;
    }
  }
  
  private void startComplainAndCallback()
  {
    if (this.mMiniAppInfo == null)
    {
      QMLog.e("MainPageFragment", "startComplainAndCallback, mApkgConfig = " + this.mMiniAppInfo);
      return;
    }
    Object localObject1 = "";
    try
    {
      localObject2 = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject2;
        QMLog.e("MainPageFragment", "startComplainAndCallback, url = " + "");
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    localObject2 = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + this.mMiniAppInfo.appId + "&openid=" + getUin() + "&avatar=" + (String)localObject1 + "&nickname=游客";
    localObject1 = localObject2;
    if (!QUAUtil.isQQApp()) {
      localObject1 = (String)localObject2 + "&customInfo=-" + this.mMiniAppProxy.getPlatformId();
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("title", "投诉与反馈");
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("hide_more_button", true);
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    this.mMiniAppProxy.startBrowserActivity(getActivity(), (Intent)localObject2);
    reportClick("feedback");
    QMLog.d("MainPageFragment", "feedback, prepare to upload log ");
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).uploadUserLog(this.mMiniAppInfo.appId);
  }
  
  private void startMiniApp()
  {
    this.mMiniAppInfo.launchParam.scene = 1024;
    MiniSDK.startMiniApp(getActivity(), this.mMiniAppInfo);
  }
  
  private void startMoreInformation(String paramString)
  {
    if (this.mMiniAppInfo == null)
    {
      QMLog.e("MainPageFragment", "startMoreInformation, miniAppInfo = " + this.mMiniAppInfo);
      return;
    }
    Object localObject = "https://q.qq.com/os/store/details-more?appid=" + this.mMiniAppInfo.appId;
    MiniAppProxy localMiniAppProxy;
    if (!TextUtils.isEmpty(paramString)) {
      localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    }
    for (paramString = (String)localObject + "&token=" + paramString + "&uin=" + localMiniAppProxy.getAccount() + "&pid=" + localMiniAppProxy.getPlatformId();; paramString = (String)localObject)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("url", paramString);
      ((Intent)localObject).putExtra("title", "更多资料");
      new Bundle().putBoolean("hide_more_button", true);
      this.mMiniAppProxy.startBrowserActivity(getActivity(), (Intent)localObject);
      return;
    }
  }
  
  private void startRecommendMiniApp() {}
  
  private void update(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.mMiniAppInfo.name)) {
      this.mAppName.setText(this.mMiniAppInfo.name);
    }
    if (!TextUtils.isEmpty(this.mMiniAppInfo.desc)) {
      this.mIntroduction.setText(this.mMiniAppInfo.desc);
    }
    updateTopTypeState(paramMiniAppInfo);
  }
  
  private void updateLikeNum(int paramInt)
  {
    if (!this.isLike) {
      if (this.isMiniGame) {
        this.mLikeNum.setText("为小游戏点赞");
      }
    }
    while (paramInt <= 0)
    {
      return;
      this.mLikeNum.setText("为小程序点赞");
      return;
    }
    if (paramInt > 9999)
    {
      float f = paramInt / 10000.0F;
      this.mLikeNum.setText(String.format("%.2f", new Object[] { Float.valueOf(f) }) + "万" + "个赞");
      return;
    }
    this.mLikeNum.setText(paramInt + "个赞");
  }
  
  private void updateLikeState(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mLikeBtn.setImageResource(R.drawable.mini_sdk_like_button);
      return;
    }
    this.mLikeBtn.setImageResource(R.drawable.mini_sdk_not_like_button);
  }
  
  private void updateTopTypeState(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.topType == 0)
    {
      this.mSetTopSwitch.setChecked(false);
      return;
    }
    this.mSetTopSwitch.setChecked(true);
  }
  
  public String getUin()
  {
    return LoginManager.getInstance().getAccount();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.miniapp_enter_miniapp_btn)
    {
      startMiniApp();
      reportClick("launch");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == R.id.miniapp_like_container)
      {
        setLikeNum();
      }
      else if (i == R.id.miniapp_set_top_switch)
      {
        setTopType(this.mMiniAppInfo);
      }
      else if (i == R.id.miniapp_recommend_miniapp_btn)
      {
        startRecommendMiniApp();
        reportClick("share");
      }
      else if (i != R.id.miniapp_relative_public_account_container)
      {
        if (i == R.id.miniapp_complain_callback_container)
        {
          startComplainAndCallback();
        }
        else if (i == R.id.miniapp_title_back)
        {
          getActivity().finish();
        }
        else if (i == R.id.miniapp_title_more)
        {
          handleMoreButtonEvent();
        }
        else if (i == R.id.miniapp_seting)
        {
          if ((this.mMiniAppInfo != null) && (!TextUtils.isEmpty(this.mMiniAppInfo.appId)))
          {
            ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openPermissionSettingsActivity(getActivity(), this.mMiniAppInfo.appId, this.mMiniAppInfo.name);
            this.mMiniAppDialog.dismiss();
            reportClick("set");
          }
        }
        else
        {
          if (i == R.id.miniapp_more_information)
          {
            if (QUAUtil.isQQApp()) {
              startMoreInformation(null);
            }
            for (;;)
            {
              this.mMiniAppDialog.dismiss();
              reportClick("profile");
              break;
              ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
              if (localChannelProxy != null) {
                localChannelProxy.getSDKOpenKeyToken(null, new MainPageFragment.3(this));
              }
            }
          }
          if (i == R.id.miniapp_dialog_cancel) {
            this.mMiniAppDialog.dismiss();
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_main_page_layout, null);
    if (Build.VERSION.SDK_INT >= 23)
    {
      getActivity().getWindow().clearFlags(67108864);
      getActivity().getWindow().addFlags(-2147483648);
      getActivity().getWindow().setStatusBarColor(-1);
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    }
    if (DisplayUtil.isImmersiveSupported)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, DisplayUtil.getStatusBarHeight(getActivity()), 0, 0);
    }
    initData();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    TaskMonitorManager.g().switchPerfmPage(getClass().getSimpleName(), true);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mAppIcon = ((ImageView)paramView.findViewById(R.id.miniapp_logo));
    this.mAppIcon.setOnLongClickListener(this.mLongClickListener);
    this.mAppName = ((TextView)paramView.findViewById(R.id.miniapp_name));
    this.mIntroduction = ((TextView)paramView.findViewById(R.id.miniapp_desc));
    this.mLikeNum = ((TextView)paramView.findViewById(R.id.miniapp_like_num_text));
    this.mLikeBtn = ((ImageView)paramView.findViewById(R.id.miniapp_like_image));
    this.mSetTopContainer = paramView.findViewById(R.id.set_top_layout);
    this.mSetTopSwitch = ((Switch)paramView.findViewById(R.id.miniapp_set_top_switch));
    this.mRecommendMiniAppBtn = ((Button)paramView.findViewById(R.id.miniapp_recommend_miniapp_btn));
    this.mEnterMiniAppBtn = ((Button)paramView.findViewById(R.id.miniapp_enter_miniapp_btn));
    this.mRelativePublicAccountContainer = paramView.findViewById(R.id.miniapp_relative_public_account_container);
    this.mComplainCallbackContainer = paramView.findViewById(R.id.miniapp_complain_callback_container);
    this.mLikeContainer = paramView.findViewById(R.id.miniapp_like_container);
    this.mBackView = ((ImageView)paramView.findViewById(R.id.miniapp_title_back));
    this.mMoreView = ((ImageView)paramView.findViewById(R.id.miniapp_title_more));
    this.mSetTopText = ((TextView)paramView.findViewById(R.id.set_top_text));
    this.mSeparator = paramView.findViewById(R.id.item_separator);
    this.mSetTopSwitch.setOnClickListener(this);
    this.mRecommendMiniAppBtn.setOnClickListener(this);
    this.mEnterMiniAppBtn.setOnClickListener(this);
    this.mRelativePublicAccountContainer.setOnClickListener(this);
    this.mComplainCallbackContainer.setOnClickListener(this);
    this.mComplainCallbackContainer.setOnLongClickListener(new MainPageFragment.2(this));
    this.mBackView.setOnClickListener(this);
    this.mMoreView.setOnClickListener(this);
    this.mLikeContainer.setOnClickListener(this);
    initUI();
    sendGetUserAppInfoRequest();
  }
  
  public void sendSetUserAppTopRequest(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) && (QMLog.isColorLevel())) {
      QMLog.e("MainPageFragment", "sendSetUserAppTopRequest, miniAppInfo = " + this.mMiniAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MainPageFragment
 * JD-Core Version:    0.7.0.1
 */