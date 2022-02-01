package com.tencent.mobileqq.activity.qwallet;

import aaai;
import aacl;
import aagd;
import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aoop;
import aqcl;
import aqgv;
import awrp;
import axcd;
import axce;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletPicHelper;
import dov.com.qq.im.ae.SessionWrap;
import java.util.LinkedList;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
import rnq;
import zxi;
import zxj;
import zyo;
import zyp;
import zyq;
import zyr;

public class RedPacketEmojiFragment
  extends RedPacketPopFragment
{
  public static final String[] dc = { acfp.m(2131713789), acfp.m(2131713806), acfp.m(2131713796) };
  public TextView My;
  public TextView Ns;
  public TextView Nt;
  public Bundle am;
  public String bbn = "https://i.gtimg.cn/channel/imglib/201906/upload_9c25c90bf492d21e9796f96ddab01809.json";
  public String bbo;
  public String bbp;
  private String bbq;
  private String bbr = "https://i.gtimg.cn/channel/static/expression/";
  public int cfB;
  public int cfC = -1;
  private int cfD;
  public Button eS;
  public Button eT;
  public ImageView imgLottie;
  public ImageView vE;
  public ImageView vF;
  public ImageView vG;
  public View yX;
  
  private static int a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    try
    {
      i = Integer.parseInt(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId);
      int j;
      if (i >= 0)
      {
        j = i;
        if (i < 200) {}
      }
      else
      {
        j = 0;
      }
      return j;
    }
    catch (Throwable paramMessageForQQWalletMsg)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public static void a(Context paramContext, BaseChatPie paramBaseChatPie, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if ((paramBaseChatPie == null) || (paramMessageForQQWalletMsg == null)) {
      return;
    }
    Intent localIntent = new Intent();
    SessionInfo localSessionInfo = paramBaseChatPie.sessionInfo;
    localIntent.putExtra("session", localSessionInfo);
    localIntent.putExtra("uniseq", paramMessageForQQWalletMsg.uniseq);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("fromHBList", paramMessageForQQWalletMsg.fromHBList);
    localIntent.putExtra("redPacketId", paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramMessageForQQWalletMsg = null;
    if (localSessionInfo != null) {
      paramMessageForQQWalletMsg = new SessionWrap(localSessionInfo.aTl, localSessionInfo.aTn, localSessionInfo.cZ, localSessionInfo.troopUin);
    }
    localIntent.putExtra("KEY_CAMERA_BUNDLE", awrp.a(paramMessageForQQWalletMsg, paramBaseChatPie.mActivity.getClass().getName(), 10000, 100));
    PublicFragmentActivity.b.start(paramContext, localIntent, PublicTransFragmentActivity.class, RedPacketEmojiFragment.class);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if ((paramQQAppInterface == null) || (paramMessageForQQWalletMsg == null)) {}
    for (;;)
    {
      return;
      try
      {
        if ((paramMessageForQQWalletMsg.messageType == 19) && (!TextUtils.isEmpty(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId))) {
          if (isFace(a(paramMessageForQQWalletMsg)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("RedPacketEmojiFragment", 2, "preload AE_RES_BASE_PACKAGE");
            }
            axce.a().a(axcd.c, null, false);
            return;
          }
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("RedPacketEmojiFragment", 1, paramQQAppInterface, new Object[0]);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "preload AE_RES_ADDITIONAL_PACKAGE");
    }
    axce.a().a(axcd.d, null, false);
  }
  
  private void csB()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "doLoading");
    }
    int i = new Random().nextInt(3);
    this.Ns.setText(dc[(i + 0)]);
    Object localObject = getResources().getDrawable(2130844271);
    this.vF.setBackgroundDrawable((Drawable)localObject);
    ((Animatable)localObject).start();
    this.eS.setVisibility(8);
    this.imgLottie.setVisibility(8);
    if (!isFace(this.cfB))
    {
      long l = System.currentTimeMillis();
      axce.a().a(axcd.d, new zyq(this, l), false);
      return;
    }
    localObject = new LinkedList();
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.url = this.bbn;
    localDownloadParam.filePos = 1;
    ((LinkedList)localObject).add(localDownloadParam);
    PreloadManager.a().a(localDownloadParam, new zyr(this));
  }
  
  private void csC()
  {
    EmojiGifHelper.getInstance().trySendPicToAIO(hashCode());
  }
  
  private Bundle h(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10022);
    localBundle.putInt("key_ability_flag", 3);
    localBundle.putInt("emoji_capture_tag", hashCode());
    localBundle.putInt("emoji_feeds_id", this.cfB);
    localBundle.putInt("emoji_combo_id", this.cfD);
    if (this.cfC != -1) {
      localBundle.putInt("emoji_threshold", this.cfC);
    }
    localBundle.putString("emoji_face_config_path", this.bbo);
    localBundle.putString("emoji_hand_res_folder_path", this.bbp);
    return localBundle;
  }
  
  private void initConfig()
  {
    Object localObject = ((aaai)getActivity().app.getManager(245)).a("redPackPanel", "", new String[] { "panelRedPkgList" });
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
        if ((localJSONObject != null) && (localJSONObject.optInt("type") == 8))
        {
          if (QLog.isColorLevel()) {
            QLog.i("RedPacketEmojiFragment", 2, "initConfig emoji id:" + this.b.mQQWalletRedPacketMsg.body.feedId + "emoji config jo:" + localJSONObject.toString());
          }
          localObject = localJSONObject.optJSONObject("params");
          if (localObject == null) {
            break;
          }
          this.bbr = ((JSONObject)localObject).optString("prefix", "https://i.gtimg.cn/channel/static/expression/");
          this.bbn = ((JSONObject)localObject).optString("aEConfig", "https://i.gtimg.cn/channel/imglib/201906/upload_9c25c90bf492d21e9796f96ddab01809.json");
          localObject = ((JSONObject)localObject).getJSONArray("heartList");
          if (localObject == null) {
            break;
          }
          i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            localJSONObject = ((JSONArray)localObject).optJSONObject(i);
            if ((localJSONObject != null) && (localJSONObject.optInt("rId") == Integer.parseInt(this.b.mQQWalletRedPacketMsg.body.feedId)))
            {
              this.bbq = localJSONObject.optString("md5");
              JSONArray localJSONArray = localJSONObject.optJSONArray("eId");
              if (localJSONArray != null)
              {
                int j = localJSONArray.length();
                if (j > 0) {
                  this.cfD = localJSONArray.optInt(new Random().nextInt(j + 0) + 0);
                }
              }
              this.cfC = localJSONObject.optInt("aThreshold", -1);
            }
            i += 1;
          }
        }
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private static boolean isFace(int paramInt)
  {
    return paramInt >= 100;
  }
  
  private void openCamera()
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      if ((getActivity() != null) && (!getActivity().isFinishing())) {
        rnq.a().a(getActivity(), h(this.am), 1);
      }
      return;
    }
    QQToast.a(getActivity(), "请使用高于4.3.0及以上的安卓版本体验哦~", 1).show();
  }
  
  public static String qb()
  {
    return "{\"v\":\"5.3.1\",\"fr\":30,\"ip\":0,\"op\":30,\"w\":210,\"h\":210,\"nm\":\"“图层 2”轮廓 合成 1\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":1,\"ty\":4,\"nm\":\"“图层 2”轮廓\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[106,102,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[87.5,87.5,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[-65.455,80],[-80,80],[-79.868,65.454]],\"c\":false},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":1,\"ty\":\"sh\",\"ix\":2,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[-79.371,-65.455],[-80,-80],[-65.455,-80]],\"c\":false},\"ix\":2},\"nm\":\"路径 2\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":2,\"ty\":\"sh\",\"ix\":3,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[65.454,-80],[80,-80],[80,-65.455]],\"c\":false},\"ix\":2},\"nm\":\"路径 3\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":3,\"ty\":\"sh\",\"ix\":4,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[80,65.454],[80,80],[67.636,80]],\"c\":false},\"ix\":2},\"nm\":\"路径 4\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"mm\",\"mm\":1,\"nm\":\"合并路径 1\",\"mn\":\"ADBE Vector Filter - Merge\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[1,0.862999949736,0.675,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":3,\"ix\":5},\"lc\":2,\"lj\":2,\"nm\":\"描边 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[87.5,87.5],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":0,\"s\":[100,100],\"e\":[110,110]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":10,\"s\":[110,110],\"e\":[108,108]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":15,\"s\":[108,108],\"e\":[110,110]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":20,\"s\":[110,110],\"e\":[100,100]},{\"t\":30}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":6,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":2700,\"st\":0,\"bm\":0}],\"markers\":[]}";
  }
  
  private void zT(String paramString)
  {
    paramString = new StringBuilder(50);
    paramString.append("msgType=19").append("&isOffline=").append(false);
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByEmoji", paramString.toString(), 0, null, SystemClock.uptimeMillis());
    paramString = (zxj)getActivity().app.getManager(125);
    zxi localzxi = paramString.a(this.b.mQQWalletRedPacketMsg.redPacketId);
    paramString.z(this.b.mQQWalletRedPacketMsg.redPacketId, this.b.frienduin, this.b.istroop);
    aagd.e(getActivity().app, this.b);
    paramString.a(this.sessionInfo, localzxi, l, 262144, "", this.b.mQQWalletRedPacketMsg.elem.skinId, this.b.fromHBList, null);
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localzxi.isOpen + ",isPasswdRedBagFinish=" + localzxi.isFinish + ",isPasswdRedBagOverDue=" + localzxi.bul);
    }
  }
  
  protected boolean QP()
  {
    if (!super.QP()) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "initParams");
    }
    this.zc.setBackgroundDrawable(getResources().getDrawable(2130844209));
    String str = aqgv.b(getActivity().app, this.b.senderuin, true);
    str = aagd.b(getActivity(), str, 135.0F, this.Nw.getPaint());
    this.Nw.setText(str + acfp.m(2131713816));
    this.My.setText(this.b.mQQWalletRedPacketMsg.elem.title);
    anot.a(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.popup.show", 0, 0, "", "", "", "");
    this.am = getArguments().getBundle("KEY_CAMERA_BUNDLE");
    this.eS.setOnClickListener(this);
    aagd.k(this.eS, 0.3F);
    this.eT.setOnClickListener(this);
    this.eT.setOnTouchListener(aagd.a(0.7F));
    EmojiGifHelper.getInstance().bind(this.sessionInfo, hashCode());
    initConfig();
    this.cfB = a(this.b);
    csB();
    aqcl.s(this.eS, acfp.m(2131713810));
    return true;
  }
  
  public void cancelLoading()
  {
    this.Ns.setText(acfp.m(2131713782));
    this.vF.setVisibility(8);
    this.eS.setVisibility(0);
    this.imgLottie.setVisibility(0);
  }
  
  public void csA()
  {
    this.Nt.setVisibility(8);
    this.eT.setVisibility(8);
    this.yX.setVisibility(0);
    csB();
  }
  
  public void csy()
  {
    Object localObject = this.bbr + this.b.mQQWalletRedPacketMsg.body.feedId + ".png";
    Drawable localDrawable = aoop.TRANSPARENT;
    localObject = QWalletPicHelper.getNetDrawableForQWallet((String)localObject, localDrawable, localDrawable, this.bbq);
    this.vE.setBackgroundDrawable((Drawable)localObject);
    if (localObject != null)
    {
      ((URLDrawable)localObject).setURLDrawableListener(new zyp(this));
      if (((URLDrawable)localObject).getStatus() == 1) {
        cancelLoading();
      }
      while ((((URLDrawable)localObject).getStatus() == 1) || (((URLDrawable)localObject).getStatus() == 0)) {
        return;
      }
      ((URLDrawable)localObject).restartDownload();
      return;
    }
    csz();
  }
  
  public void csz()
  {
    this.Nt.setVisibility(0);
    this.eT.setVisibility(0);
    this.yX.setVisibility(8);
  }
  
  protected void initUI(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "initUI");
    }
    super.initUI(paramView);
    ((ViewStub)paramView.findViewById(2131378881)).inflate();
    this.eS = ((Button)paramView.findViewById(2131364194));
    this.vE = ((ImageView)paramView.findViewById(2131369010));
    this.vF = ((ImageView)paramView.findViewById(2131369066));
    this.My = ((TextView)paramView.findViewById(2131381098));
    this.Ns = ((TextView)paramView.findViewById(2131381118));
    this.Nt = ((TextView)paramView.findViewById(2131381094));
    this.eT = ((Button)paramView.findViewById(2131363973));
    this.yX = paramView.findViewById(2131370188);
    this.imgLottie = ((ImageView)paramView.findViewById(2131369044));
    u(this.imgLottie);
    this.vG = ((ImageView)paramView.findViewById(2131369060));
    paramView = qb();
    if (!TextUtils.isEmpty(paramView)) {
      LottieComposition.Factory.fromJsonString(paramView, new zyo(this));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      zT("sss");
      csC();
      getActivity().finish();
    }
  }
  
  public boolean onBackEvent()
  {
    anot.a(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.popup.back", 0, 0, "", "", "", "");
    EmojiGifHelper.getInstance().unbind(hashCode());
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.popup.click", 0, 0, "", "", "", "");
      openCamera();
      continue;
      csA();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    v(this.imgLottie);
    v(this.vG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment
 * JD-Core Version:    0.7.0.1
 */