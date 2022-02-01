package com.tencent.mobileqq.gamecenter.web;

import aacm;
import aaft;
import abmt;
import acfp;
import adta;
import ahtv;
import ahtz;
import ahua;
import ahuh;
import ahup;
import ahuv;
import ahuw;
import ahux;
import ahuy;
import ahuz;
import ahva;
import ahvb;
import ahvc;
import ahvd;
import ahve;
import ahvg;
import ahvg.b;
import ahvi;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlm;
import aqmu;
import aqyx;
import awot;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
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
import com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub;
import com.tencent.mobileqq.gamecenter.view.QQGameIndicator;
import com.tencent.mobileqq.gamecenter.view.QQGameIndicator.a;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.web.view.GameContentView;
import com.tencent.mobileqq.gamecenter.web.view.GameContentView.a;
import com.tencent.mobileqq.gamecenter.web.view.QQGameHeadLayout;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import eipc.EIPCResult;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tbb;
import wja;

public class QQGameFeedWebFragment
  extends PublicBaseFragment
  implements ahvg.b, QQGameIndicator.a, GameContentView.a
{
  private ImageView AA;
  private ImageView AB;
  public ImageView AC;
  public ImageView AD;
  private ImageView Az;
  public TextView TW;
  private ahtv jdField_a_of_type_Ahtv;
  private ahvi jdField_a_of_type_Ahvi;
  public NavBarQQGamePub a;
  private QQGameIndicator jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator;
  private a jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$a;
  private b jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$b;
  private GameContentView jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView;
  private QQGameHeadLayout jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout;
  public long aaY;
  public long aaZ;
  private List<String> arkAppNameList = new ArrayList();
  private QQGamePubWebView b;
  private int baD;
  @SuppressLint({"HandlerLeak"})
  private Handler cU = new ahuw(this);
  boolean cis = false;
  private View contentView;
  private ahuh currIHeaderView;
  public int dbr;
  public int dbs;
  private int dbt;
  public long enterQQGamePubTime;
  public long initUiTime;
  public long initWebViewTime;
  public LinearLayout jg;
  private RelativeLayout kI;
  private RelativeLayout kJ;
  private LinearLayout loadLayout;
  public long loadUrlEndTime;
  private GestureDetector mGestureDetector;
  List<ahuh> mHeaderRecords = new ArrayList();
  private List<QQGameMsgInfo> msgInfoList;
  private TextView navTitle;
  public long parsePageEndTime;
  public long startTime;
  public int unreadMsgNum;
  private QQGamePubViewpager viewPager;
  
  static
  {
    adta.GI(true);
    adta.cUm();
  }
  
  private int Fn()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.getVisibility() == 0) {
        i = this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.EZ();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameWebPage", 1, "gameContentHeight=" + i);
    }
    return (int)wja.a(i, getResources()) + 389;
  }
  
  private String I(List<QQGameMsgInfo> paramList)
  {
    JSONArray localJSONArray;
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        localJSONArray = new JSONArray();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)paramList.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("msgID", localQQGameMsgInfo.paMsgid);
          localJSONObject.put("appID", localQQGameMsgInfo.gameAppId);
          localJSONObject.put("msgTime", localQQGameMsgInfo.msgTime);
          if (!TextUtils.isEmpty(localQQGameMsgInfo.sortedConfigs)) {
            localJSONObject.put("sorted_configs", localQQGameMsgInfo.sortedConfigs);
          }
          if (!TextUtils.isEmpty(localQQGameMsgInfo.extJson)) {
            localJSONObject.put("extJson", localQQGameMsgInfo.extJson);
          }
          localJSONArray.put(localJSONObject);
          continue;
          return "";
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
    }
    paramList = localJSONArray.toString();
    return paramList;
  }
  
  private QQGameMsgInfo a()
  {
    int i = this.viewPager.getCurrentItem();
    if ((this.msgInfoList != null) && (this.msgInfoList.size() > 0)) {
      return (QQGameMsgInfo)this.msgInfoList.get(i);
    }
    return null;
  }
  
  private String a(String paramString, List<QQGameMsgInfo> paramList, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null) && (paramList.size() > 0))
    {
      if (paramString.indexOf("?") == -1) {}
      try
      {
        return paramString + "?gameData=" + URLEncoder.encode(I(paramList), "utf-8") + "&index=" + paramInt + "&height=" + Fn() + "&_bid=4235";
      }
      catch (Throwable paramList)
      {
        return paramString;
      }
      paramList = paramString + "&gameData=" + URLEncoder.encode(I(paramList), "utf-8") + "&index=" + paramInt + "&height=" + Fn() + "&_bid=4235";
      return paramList;
    }
    if (paramString.indexOf("?") == -1) {
      return paramString + "?height=" + Fn() + "&_bid=4235";
    }
    return paramString + "&height=" + Fn() + "&_bid=4235";
  }
  
  private void bn(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean)
    {
      this.jg.setVisibility(8);
      this.AC.setVisibility(0);
      this.unreadMsgNum = 0;
      this.dbs = 0;
      this.dbr = 0;
      return;
    }
    this.AC.setVisibility(8);
    this.jg.setVisibility(0);
    this.TW.setText(paramInt + "");
  }
  
  private void dqi()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.setUiRefresh(this);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.init();
    }
  }
  
  private void dqj()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$b = new b(null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_qgame_tool_messgae");
    localIntentFilter.addAction("action_qgame_jaspi_webloaded");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$b, localIntentFilter);
  }
  
  private void dql()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.arg1 = -1;
    localMessage.arg2 = Fn();
    this.cU.sendMessage(localMessage);
    if ((this.viewPager != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$a != null) && (this.dbt > 0))
    {
      localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.arg1 = this.viewPager.getCurrentItem();
      localMessage.arg2 = -1;
      this.cU.sendMessage(localMessage);
    }
    if ((this.msgInfoList != null) && (this.msgInfoList.size() > 3))
    {
      localMessage = Message.obtain();
      localMessage.what = 2;
      localMessage.arg1 = -1;
      localMessage.arg2 = -1;
      localMessage.obj = I(this.msgInfoList);
      this.cU.sendMessage(localMessage);
    }
  }
  
  private static void e(AppInterface paramAppInterface, String paramString)
  {
    SharedPreferences localSharedPreferences = paramAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    paramAppInterface = "msgPos_web" + paramAppInterface.getCurrentAccountUin();
    localSharedPreferences.edit().putString(paramAppInterface, paramString).commit();
  }
  
  private void ev(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$a == null) || (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$a.getCount() != 1)) {
        break label421;
      }
    }
    label421:
    for (int i = 1;; i = 0)
    {
      if (this.msgInfoList == null) {
        return;
      }
      this.dbr += paramArrayList.size();
      this.dbs += paramArrayList.size();
      int j = 0;
      if (j < paramArrayList.size())
      {
        this.msgInfoList.add(0, paramArrayList.get(j));
        localObject = ahup.a((QQGameMsgInfo)paramArrayList.get(j), getActivity());
        this.mHeaderRecords.add(0, localObject);
        if (!TextUtils.isEmpty(((QQGameMsgInfo)paramArrayList.get(j)).arkAppName)) {
          this.arkAppNameList.add(((QQGameMsgInfo)paramArrayList.get(j)).arkAppName);
        }
        if (j == paramArrayList.size() - 1)
        {
          if (i == 0)
          {
            this.kJ.setVisibility(0);
            this.cU.sendEmptyMessageDelayed(100, 3000L);
          }
          this.kJ.setTag(((QQGameMsgInfo)paramArrayList.get(j)).paMsgid);
        }
        refreshHead(-1);
        if (i != 0) {}
        for (int k = this.viewPager.getCurrentItem();; k = this.viewPager.getCurrentItem() + 1)
        {
          this.viewPager.setCurrentItem(k);
          localObject = new HashMap();
          ((Map)localObject).put(Integer.valueOf(1), ((QQGameMsgInfo)paramArrayList.get(j)).paMsgid);
          ((Map)localObject).put(Integer.valueOf(2), "");
          ((Map)localObject).put(Integer.valueOf(4), "8");
          ((Map)localObject).put(Integer.valueOf(24), "1");
          tbb.a(abmt.getAppInterface(), "769", "205030", "", "76901", "1", "160", (Map)localObject);
          j += 1;
          break;
        }
      }
      paramArrayList = I(this.msgInfoList);
      this.cU.removeMessages(2);
      Object localObject = new Message();
      ((Message)localObject).what = 2;
      ((Message)localObject).arg1 = -1;
      ((Message)localObject).arg2 = -1;
      ((Message)localObject).obj = paramArrayList;
      this.cU.sendMessage((Message)localObject);
      return;
    }
  }
  
  private void gQ(View paramView)
  {
    this.kJ = ((RelativeLayout)paramView.findViewById(2131372310));
    this.AB = ((ImageView)paramView.findViewById(2131372309));
    this.kJ.setBackgroundColor(-1);
    this.AB.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_newMsg_normal@2x.png"));
    this.kJ.setOnClickListener(new ahvb(this));
  }
  
  private void getGameMsgList()
  {
    ahvg.a().dqm();
    ahvg.a().a("task_qgame_task_all_complete", this);
    ahvg.a().a("task_get_qgame_msg", this);
    ahvg.a().cn("task_get_qgame_msg", true);
  }
  
  private static String h(AppInterface paramAppInterface)
  {
    return paramAppInterface.getApp().getSharedPreferences("game_center_sp", 0).getString("msgPos_web" + paramAppInterface.getCurrentAccountUin(), "");
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
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout = ((QQGameHeadLayout)paramView.findViewById(2131375048));
    this.b = ((QQGamePubWebView)paramView.findViewById(2131375049));
    this.kI = ((RelativeLayout)paramView.findViewById(2131370262));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.attachToRootView();
    this.b.attachHeaderView(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView = ((GameContentView)paramView.findViewById(2131370203));
    this.viewPager = ((QQGamePubViewpager)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.findViewById(2131366996));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator = ((QQGameIndicator)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewQQGameHeadLayout.findViewById(2131372828));
    this.Az = ((ImageView)paramView.findViewById(2131370479));
    this.AA = ((ImageView)paramView.findViewById(2131370484));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$a = new a(null);
    this.viewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$a);
    this.viewPager.setOffscreenPageLimit(10);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setViewPager(this.viewPager);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.refreshIndicator();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setPageListener(this);
    this.AC = ((ImageView)paramView.findViewById(2131377436));
    this.AC.setImageDrawable(ahtz.a(null, null, "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png", "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png"));
    this.AC.setOnClickListener(new ahuv(this));
    Object localObject = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/202003/upload_94d568a4fd9ea21aacf5204a5078a60c.png");
    ImageView localImageView = (ImageView)paramView.findViewById(2131368387);
    localImageView.setVisibility(0);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setImageDrawable((Drawable)localObject);
    dpH();
    this.TW = ((TextView)paramView.findViewById(2131381011));
    this.jg = ((LinearLayout)paramView.findViewById(2131370298));
    this.AD = ((ImageView)paramView.findViewById(2131369075));
    if (this.unreadMsgNum > 1)
    {
      this.jg.setVisibility(0);
      paramView = URLDrawable.URLDrawableOptions.obtain();
      localObject = new ColorDrawable(-15090945);
      paramView.mLoadingDrawable = ((Drawable)localObject);
      paramView.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/202004/upload_36fc9d2b365899db39f1b71b5da726e9.png", paramView);
      this.jg.setBackgroundDrawable((Drawable)localObject);
      paramView = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/202004/upload_5dea58e62564d53805d39c48742c5f0a.png", paramView);
      this.AD.setImageDrawable(paramView);
      this.TW.setText(this.unreadMsgNum - 1 + "");
      this.jg.setOnClickListener(new ahux(this));
      return;
    }
    bn(false, 0);
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
      ((aacm)localObject).c("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new ahuy(this));
      return;
    }
    ((aacm)localObject).c("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new ahuz(this, paramView));
  }
  
  private void jZ(long paramLong)
  {
    if (paramLong < 0L) {}
    do
    {
      return;
      paramLong = (SystemClock.elapsedRealtime() - paramLong) / 1000L;
    } while (paramLong <= 0L);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(17), paramLong + "");
    tbb.a(abmt.getAppInterface(), "769", "206471", "", "76916", "1", "160", localHashMap);
  }
  
  private void refreshHead(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$a.notifyDataSetChanged();
      dpH();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.refreshIndicator();
      if (paramInt != -1) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameFeedWebFragment.14(this, paramInt), 200L);
      }
    }
  }
  
  public void Ps(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.arg1 = paramInt;
    this.cU.sendMessage(localMessage);
  }
  
  public void a(String paramString, EIPCResult paramEIPCResult)
  {
    if ("task_get_qgame_msg".equals(paramString))
    {
      this.aaZ = (SystemClock.elapsedRealtime() - this.startTime);
      if (paramEIPCResult.code == 0)
      {
        paramString = paramEIPCResult.data;
        if (paramString != null)
        {
          this.msgInfoList = ((List)paramString.getSerializable("key_get_msg"));
          if (this.msgInfoList == null) {
            this.msgInfoList = new ArrayList();
          }
        }
      }
      j = this.msgInfoList.size();
      if (j > 0)
      {
        this.baD = 0;
        if (this.unreadMsgNum > 0)
        {
          this.dbr = 1;
          this.unreadMsgNum -= 1;
          this.dbs = this.unreadMsgNum;
        }
        label260:
        for (;;)
        {
          paramString = this.msgInfoList.iterator();
          while (paramString.hasNext())
          {
            paramEIPCResult = (QQGameMsgInfo)paramString.next();
            localahuh = ahup.a(paramEIPCResult, getActivity());
            this.mHeaderRecords.add(localahuh);
            if (!TextUtils.isEmpty(paramEIPCResult.arkAppName))
            {
              aaft.a().Ai(paramEIPCResult.arkAppName);
              this.arkAppNameList.add(paramEIPCResult.arkAppName);
            }
          }
          paramString = h(abmt.getAppInterface());
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label260;
            }
            if (((QQGameMsgInfo)this.msgInfoList.get(i)).paMsgid.equals(paramString))
            {
              this.baD = i;
              break;
            }
            i += 1;
          }
        }
        aaft.a().hE(this.arkAppNameList);
        this.mHeaderRecords.add(new MoreMsgHeaderView(getActivity()));
        refreshHead(this.baD);
        if (this.baD == 0)
        {
          paramString = new HashMap();
          paramString.put(Integer.valueOf(2), ((QQGameMsgInfo)this.msgInfoList.get(this.baD)).paMsgid);
          paramString.put(Integer.valueOf(3), this.baD + "");
          paramString.put(Integer.valueOf(4), "8");
          paramString.put(Integer.valueOf(24), "1");
          tbb.b(paramString, ((QQGameMsgInfo)this.msgInfoList.get(this.baD)).paMsgid);
          tbb.a(abmt.getAppInterface(), "769", "205017", ((QQGameMsgInfo)this.msgInfoList.get(this.baD)).gameAppId, "76901", "1", "160", paramString);
          awot.X(2, ((QQGameMsgInfo)this.msgInfoList.get(this.baD)).paMsgid, "");
        }
      }
    }
    while (!"task_qgame_task_all_complete".equals(paramString)) {
      try
      {
        int j;
        ahuh localahuh;
        ahua.a(101, (QQGameMsgInfo)this.msgInfoList.get(this.baD), this.baD);
        if (this.contentView != null)
        {
          this.jdField_a_of_type_Ahtv = new ahtv(getActivity(), (QQGameMsgInfo)this.msgInfoList.get(0));
          this.jdField_a_of_type_Ahtv.u(this.contentView);
          this.jdField_a_of_type_Ahtv.cii = true;
          this.jdField_a_of_type_Ahtv.a(abmt.getAppInterface(), null, (QQGameMsgInfo)this.msgInfoList.get(0));
        }
        if ((this.mHeaderRecords != null) && (this.baD < this.mHeaderRecords.size())) {
          this.currIHeaderView = ((ahuh)this.mHeaderRecords.get(this.baD));
        }
        return;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    int i = this.baD;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.post(new QQGameFeedWebFragment.13(this, i));
  }
  
  public View createEmptyView()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131559371, null, false);
    ((ImageView)localView.findViewById(2131366418)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public void dpH()
  {
    this.Az.setVisibility(8);
    this.AA.setVisibility(8);
  }
  
  public void dqk()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.post(new QQGameFeedWebFragment.12(this));
    }
  }
  
  public void enterAIO()
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
      localIntent.putExtra("uin", "2747277822");
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", getString(2131697440));
      localIntent.putExtra("entrance", 1);
      localIntent.putExtra("aio_msg_source", 0);
      getActivity().startActivity(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void initTitle(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub = ((NavBarQQGamePub)paramView.findViewById(2131377361));
    paramView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.findViewById(2131369967);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setRightImage(getResources().getDrawable(2130851146));
    paramView.setImageResource(2130851759);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setBackgroundColor(Color.parseColor("#64a4fe"));
    this.navTitle = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.getTitleTextView();
    this.navTitle.setText(2131697440);
    this.navTitle.setTextColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewNavBarQQGamePub.setOnItemSelectListener(new ahvc(this));
    initTitleEvent();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void initTitleEvent()
  {
    this.mGestureDetector = new GestureDetector(getActivity(), new ahvd(this));
    this.navTitle.setOnTouchListener(new ahve(this));
  }
  
  public long initWebView()
  {
    long l = SystemClock.elapsedRealtime();
    if (this.b == null) {
      this.b = new QQGamePubWebView(getActivity());
    }
    this.jdField_a_of_type_Ahvi = new ahva(this, getActivity(), getActivity(), abmt.getAppInterface(), this.b);
    this.jdField_a_of_type_Ahvi.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new aqyx(this.jdField_a_of_type_Ahvi).a(null, abmt.getAppInterface(), null);
    this.b = ((QQGamePubWebView)this.jdField_a_of_type_Ahvi.getWebView());
    this.b.setWillNotCacheDrawing(false);
    this.b.setDrawingCacheEnabled(true);
    return SystemClock.elapsedRealtime() - l;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    jZ(this.startTime);
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ahtz.cij = true;
    paramBundle = new HashMap();
    paramBundle.put(Integer.valueOf(24), "1");
    paramBundle.put(Integer.valueOf(4), "8");
    tbb.a(abmt.getAppInterface(), "769", "205838", "", "76902", "160", "1", null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.startTime = SystemClock.elapsedRealtime();
    getGameMsgList();
    long l;
    if ((getActivity().getIntent() != null) && (getActivity().getIntent().hasExtra("startTime")))
    {
      l = getActivity().getIntent().getLongExtra("startTime", 0L);
      if (l > 0L) {
        this.enterQQGamePubTime = (SystemClock.elapsedRealtime() - l);
      }
    }
    if (getActivity().getIntent() != null)
    {
      if (getActivity().getIntent().hasExtra("startTime"))
      {
        l = getActivity().getIntent().getLongExtra("startTime", 0L);
        if (l > 0L) {
          this.enterQQGamePubTime = (SystemClock.elapsedRealtime() - l);
        }
      }
      if (getActivity().getIntent().hasExtra("unreadNum")) {
        this.unreadMsgNum = getActivity().getIntent().getIntExtra("unreadNum", 0);
      }
    }
    this.contentView = paramLayoutInflater.inflate(2131559377, paramViewGroup, false);
    if (!anlm.ayn())
    {
      getActivity().mSystemBarComp = null;
      getActivity().setImmersiveStatus(0);
    }
    initHead(this.contentView);
    dqi();
    dqj();
    this.initUiTime = (SystemClock.elapsedRealtime() - this.startTime);
    this.initWebViewTime = initWebView();
    gQ(this.contentView);
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
            continue;
          }
          ((GameArkView)this.mHeaderRecords.get(i)).destory();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("GameWebPage", 2, "header destroy i=" + i);
          continue;
        }
        this.mHeaderRecords.clear();
      }
      catch (Throwable localThrowable1)
      {
        Iterator localIterator;
        String str;
        QLog.e("GameWebPage", 1, "header destroy error=" + localThrowable1.toString());
        continue;
        if (this.cU == null) {
          continue;
        }
        try
        {
          this.cU.removeCallbacksAndMessages(null);
          if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null) {
            this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.dqo();
          }
          QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "doOnDestory", null, null);
          aaft.a().D(new String[0]);
          ahvg.a().onDestory();
          return;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
          continue;
        }
        i += 1;
      }
      if (this.jdField_a_of_type_Ahvi != null) {
        this.jdField_a_of_type_Ahvi.onDestroy();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView != null) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView.onDestory();
      }
      localIterator = this.arkAppNameList.iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        aaft.a().Aj(str);
      }
    }
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$b != null) {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$b);
    }
    if (this.arkAppNameList != null) {
      aaft.a().hF(this.arkAppNameList);
    }
    super.onDestroyView();
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int i;
    if ((this.mHeaderRecords != null) && (paramInt < this.msgInfoList.size() - 1)) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.mHeaderRecords.size()) {
          if (i != paramInt) {
            ((ahuh)this.mHeaderRecords.get(i)).onPause();
          } else {
            this.currIHeaderView = ((ahuh)this.mHeaderRecords.get(i));
          }
        }
      }
      catch (Throwable localThrowable1) {}
      for (;;)
      {
        if ((this.msgInfoList != null) && (this.msgInfoList.size() > 0))
        {
          if (paramInt < this.msgInfoList.size()) {
            break;
          }
          ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameFeedWebFragment.10(this), 400L);
        }
        return;
        this.currIHeaderView.onResume();
      }
      if ((this.jdField_a_of_type_Ahtv != null) && (paramInt > 0)) {
        this.jdField_a_of_type_Ahtv.cii = false;
      }
      if (this.unreadMsgNum > 0) {
        if ((paramInt >= this.dbr) && (this.dbr <= this.dbs) && (paramInt <= this.dbs))
        {
          this.dbr += 1;
          this.unreadMsgNum = (this.dbs - this.dbr + 1);
          if (this.unreadMsgNum <= 0) {
            break label509;
          }
          bn(true, this.unreadMsgNum);
        }
      }
      for (;;)
      {
        e(abmt.getAppInterface(), ((QQGameMsgInfo)this.msgInfoList.get(paramInt)).paMsgid);
        Object localObject = new HashMap();
        tbb.b((Map)localObject, ((QQGameMsgInfo)this.msgInfoList.get(paramInt)).paMsgid);
        ((Map)localObject).put(Integer.valueOf(2), ((QQGameMsgInfo)this.msgInfoList.get(paramInt)).paMsgid);
        ((Map)localObject).put(Integer.valueOf(3), paramInt + "");
        ((Map)localObject).put(Integer.valueOf(4), "8");
        ((Map)localObject).put(Integer.valueOf(24), "1");
        tbb.a(abmt.getAppInterface(), "769", "205017", ((QQGameMsgInfo)this.msgInfoList.get(paramInt)).gameAppId, "76901", "1", "160", (Map)localObject);
        awot.X(2, ((QQGameMsgInfo)this.msgInfoList.get(paramInt)).paMsgid, "");
        try
        {
          ahua.a(101, (QQGameMsgInfo)this.msgInfoList.get(paramInt), paramInt);
          this.dbt += 1;
          this.cU.removeMessages(1);
          localObject = Message.obtain();
          ((Message)localObject).what = 1;
          ((Message)localObject).arg1 = paramInt;
          ((Message)localObject).arg2 = -1;
          ((Message)localObject).obj = "";
          this.cU.sendMessage((Message)localObject);
          return;
          label509:
          bn(false, 0);
          continue;
          bn(false, 0);
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            localThrowable2.printStackTrace();
          }
        }
      }
      i += 1;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Ahvi != null) {
      this.jdField_a_of_type_Ahvi.onPause();
    }
    if (this.currIHeaderView != null) {
      this.currIHeaderView.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Ahvi != null) {
      this.jdField_a_of_type_Ahvi.onResume();
    }
    if (this.currIHeaderView != null) {
      this.currIHeaderView.onResume();
    }
    try
    {
      int i = this.msgInfoList.size();
      if ((this.viewPager != null) && (this.msgInfoList != null) && (i > 0) && (this.viewPager.getCurrentItem() == i)) {
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
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "doOnResume", null, null);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void p(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    try
    {
      if (this.b != null)
      {
        WebViewPluginEngine localWebViewPluginEngine = this.b.getPluginEngine();
        if (localWebViewPluginEngine != null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("action", Integer.valueOf(paramInt1));
          if (paramInt2 != -1) {
            localHashMap.put("index", Integer.valueOf(paramInt2));
          }
          if (paramInt3 != -1) {
            localHashMap.put("height", Integer.valueOf(paramInt3));
          }
          if (!TextUtils.isEmpty(paramString)) {
            localHashMap.put("gameData", paramString);
          }
          localWebViewPluginEngine.handleEvent(this.b.getUrl(), 8589934621L, localHashMap);
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  class a
    extends PagerAdapter
  {
    private a() {}
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      if ((QQGameFeedWebFragment.a(QQGameFeedWebFragment.this) == null) || (QQGameFeedWebFragment.a(QQGameFeedWebFragment.this).size() == 0)) {
        return 1;
      }
      return QQGameFeedWebFragment.a(QQGameFeedWebFragment.this).size() + 1;
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      Object localObject2 = null;
      Object localObject1;
      if ((QQGameFeedWebFragment.a(QQGameFeedWebFragment.this) == null) || (QQGameFeedWebFragment.a(QQGameFeedWebFragment.this).size() == 0))
      {
        localObject1 = QQGameFeedWebFragment.this.createEmptyView();
        paramViewGroup.addView((View)localObject1);
        return localObject1;
      }
      for (;;)
      {
        synchronized (QQGameFeedWebFragment.a(QQGameFeedWebFragment.this))
        {
          if (paramInt >= QQGameFeedWebFragment.a(QQGameFeedWebFragment.this).size()) {
            break label525;
          }
          localQQGameMsgInfo = (QQGameMsgInfo)QQGameFeedWebFragment.a(QQGameFeedWebFragment.this).get(paramInt);
          ahuh localahuh = (ahuh)QQGameFeedWebFragment.this.mHeaderRecords.get(paramInt);
          if (localahuh == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GameWebPage", 2, "headerView = null");
            }
            return null;
          }
          if (((localahuh instanceof MoreMsgHeaderView)) && (paramInt != QQGameFeedWebFragment.a(QQGameFeedWebFragment.this).size())) {
            return null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("GameWebPage", 2, "headerView = " + localahuh.getClass().getSimpleName());
          }
          RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
          if (((View)localahuh).getParent() != null) {
            ((ViewGroup)((View)localahuh).getParent()).removeView((View)localahuh);
          }
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
          localLayoutParams.addRule(13, ((View)localahuh).getId());
          if (localQQGameMsgInfo == null) {
            break label520;
          }
          TextView localTextView = new TextView(QQGameFeedWebFragment.this.getActivity());
          localTextView.setTextColor(-1);
          localTextView.setTextSize(1, 10.0F);
          localTextView.setBackgroundColor(Color.parseColor("#4D000000"));
          localTextView.setText(aqmu.a(QQGameFeedWebFragment.this.getActivity(), 3, localQQGameMsgInfo.msgTime * 1000L));
          localTextView.setPadding(12, 0, 12, 0);
          localTextView.setId(2131379675);
          localObject1 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
          if (localObject1 == null)
          {
            localObject1 = new RelativeLayout.LayoutParams(-2, wja.dp2px(15.0F, QQGameFeedWebFragment.this.getResources()));
            localTextView.setGravity(17);
            ((RelativeLayout.LayoutParams)localObject1).addRule(14);
            ((RelativeLayout.LayoutParams)localObject1).addRule(10);
            localTextView.bringToFront();
            localObject2 = localObject1;
            localObject1 = localTextView;
            localRelativeLayout.addView((View)localahuh, localLayoutParams);
            if ((localObject1 != null) && (localObject2 != null)) {
              localRelativeLayout.addView((View)localObject1, localObject2);
            }
            paramViewGroup.addView(localRelativeLayout, localLayoutParams);
            if (localQQGameMsgInfo != null)
            {
              localahuh.a(localQQGameMsgInfo, QQGameFeedWebFragment.this.getActivity(), paramInt);
              return localRelativeLayout;
            }
            localahuh.a(new QQGameMsgInfo(), QQGameFeedWebFragment.this.getActivity(), paramInt);
          }
        }
        continue;
        label520:
        localObject1 = null;
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
  
  class b
    extends BroadcastReceiver
  {
    private b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext == null) {}
      do
      {
        do
        {
          do
          {
            return;
            if (!"action_qgame_tool_messgae".equals(paramContext)) {
              break;
            }
            paramContext = paramIntent.getExtras();
          } while (paramContext == null);
          paramContext = (ArrayList)paramContext.getSerializable("key_get_msg");
        } while ((paramContext == null) || (paramContext.size() <= 0));
        ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.MessageQGameReceiver.1(this, paramContext));
        return;
      } while (!"action_qgame_jaspi_webloaded".equals(paramContext));
      ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.MessageQGameReceiver.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment
 * JD-Core Version:    0.7.0.1
 */