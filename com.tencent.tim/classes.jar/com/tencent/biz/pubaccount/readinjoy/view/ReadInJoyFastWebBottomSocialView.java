package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import awit;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kbp;
import kpn;
import ksz;
import ksz.c;
import ktr;
import kva;
import kva.a;
import kxm;
import kxy;
import kyq;
import lbz;
import lcc;
import lgv;
import lgv.a;
import nes;
import net;
import neu;
import nev;
import nns;
import org.json.JSONObject;
import svi;

public class ReadInJoyFastWebBottomSocialView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private Animation Z;
  private FastWebActivity jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity;
  private kva jdField_a_of_type_Kva;
  public int aYl = 0;
  private boolean arI;
  private boolean arJ;
  private KandianFavoriteBroadcastReceiver jdField_b_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  private ArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private FastWebArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
  private svi jdField_b_of_type_Svi;
  private BubblePopupWindow jdField_c_of_type_ComTencentWidgetBubblePopupWindow;
  lgv.a jdField_c_of_type_Lgv$a = new neu(this);
  private final Runnable cO = new ReadInJoyFastWebBottomSocialView.5(this);
  private final Runnable cP = new ReadInJoyFastWebBottomSocialView.6(this);
  private LinearLayout ef;
  private LinearLayout eg;
  private LinearLayout eh;
  private LinearLayout ei;
  private HashMap<String, ArrayList<String>> eu = new HashMap();
  private ImageView kw;
  private ImageView kx;
  private ImageView ky;
  private Context mContext;
  private View mo;
  private View mp;
  private View mq;
  private TextView sR;
  private TextView sS;
  private TextView sT;
  private TextView sU;
  private TextView sV;
  private TextView sW;
  private TextView sX;
  
  public ReadInJoyFastWebBottomSocialView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    initView();
  }
  
  public ReadInJoyFastWebBottomSocialView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    initView();
  }
  
  public ReadInJoyFastWebBottomSocialView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initView();
  }
  
  private boolean a(kva.a parama)
  {
    if (this.jdField_a_of_type_Kva == null) {
      this.jdField_a_of_type_Kva = new kva(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    if ((!this.jdField_a_of_type_Kva.dw(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) && (kyq.Bj()))
    {
      if (this.mq == null) {
        this.mq = ((ViewStub)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.findViewById(2131376729)).inflate();
      }
      this.jdField_a_of_type_Kva.a(new nev(this, parama));
      this.mq.setVisibility(0);
      this.jdField_a_of_type_Kva.b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_Kva.aO(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getWindow().getDecorView());
      return true;
    }
    return false;
  }
  
  private void aWl()
  {
    if (this.Z == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      this.Z = localScaleAnimation;
    }
    this.Z.setAnimationListener(new net(this));
    this.kx.startAnimation(this.Z);
  }
  
  private void aWm()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) {
      pA(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.FN());
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.mContext == null))
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "initFavoriteStatus but articleInfo is null.");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    lgv.a().a(localArrayList, this.jdField_c_of_type_Lgv$a);
  }
  
  private void aWn()
  {
    if (this.arJ) {}
    while ((this.sX == null) || (this.sW == null)) {
      return;
    }
    Object localObject = new int[2];
    int[] arrayOfInt = new int[2];
    this.kx.getLocationOnScreen((int[])localObject);
    getLocationOnScreen(arrayOfInt);
    int k = this.kx.getWidth();
    int m = this.kx.getHeight();
    this.kx.getLeft();
    int i = localObject[1];
    int j = arrayOfInt[1];
    m /= 9;
    int n = localObject[0];
    k = k * 13 / 20;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.sX.getLayoutParams();
    localLayoutParams.leftMargin = (n + k);
    localLayoutParams.topMargin = (i - j - m);
    this.kw.getLocationOnScreen((int[])localObject);
    k = this.kw.getWidth();
    m = this.kw.getHeight();
    i = localObject[1];
    j = arrayOfInt[1];
    m /= 9;
    n = localObject[0];
    k = k * 13 / 20;
    localObject = (RelativeLayout.LayoutParams)this.sW.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = (n + k);
    ((RelativeLayout.LayoutParams)localObject).topMargin = (i - j - m);
    switch (this.aYl)
    {
    }
    for (;;)
    {
      this.arJ = true;
      return;
      getResources().getDimension(2131299214);
      this.sW.setTextColor(Color.parseColor("#FF4222"));
      this.sW.setBackgroundResource(2130843589);
      this.sX.setBackgroundResource(2130843589);
    }
  }
  
  private void initView()
  {
    try
    {
      awit.eDN();
      Object localObject1 = Aladdin.getConfig(151);
      if (localObject1 != null)
      {
        j = ((AladdinConfig)localObject1).getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
        i = ((AladdinConfig)localObject1).getIntegerFromString("readinjoy_bottom_action_bar_style", -1);
        QLog.d("ReadInJoyFastWebBottomSocialView", 1, "initView,styleBusinessID=" + j + " actionBarStyle=" + i);
        k = 2131560367;
        if (j != 1)
        {
          j = k;
          inflate(this.mContext, j, this);
          this.sR = ((TextView)findViewById(2131380619));
          this.sS = ((TextView)findViewById(2131380617));
          this.kw = ((ImageView)findViewById(2131369711));
          this.kx = ((ImageView)findViewById(2131369801));
          this.sT = ((TextView)findViewById(2131380782));
          this.ei = ((LinearLayout)findViewById(2131363548));
          this.sV = ((TextView)findViewById(2131380582));
          this.sR.setOnClickListener(this);
          this.mo = findViewById(2131381543);
          this.mp = findViewById(2131381544);
          this.ef = ((LinearLayout)findViewById(2131365024));
          this.eg = ((LinearLayout)findViewById(2131370445));
          this.eg.setOnClickListener(this);
          this.eh = ((LinearLayout)findViewById(2131364865));
          this.ky = ((ImageView)findViewById(2131369709));
          this.sU = ((TextView)findViewById(2131380611));
          this.eh.setOnClickListener(this);
          this.ei.setOnClickListener(this);
          this.ei.setOnLongClickListener(this);
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_c_of_type_Lgv$a);
          localObject1 = new IntentFilter();
          ((IntentFilter)localObject1).addAction("com.tencent.process.fav");
          this.mContext.registerReceiver(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, (IntentFilter)localObject1);
          this.sW = ((TextView)findViewById(2131380616));
          this.sX = ((TextView)findViewById(2131380781));
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j;
        int i;
        int k;
        Object localObject2 = null;
        continue;
        if ((i != 1) && (i != 2))
        {
          j = k;
          if (i != 3) {}
        }
        else
        {
          j = 2131560368;
          this.aYl = i;
          continue;
          i = -1;
          j = -1;
        }
      }
    }
  }
  
  private void pA(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2130842491;; i = 2130842505)
    {
      this.ky.setImageResource(i);
      this.ky.setSelected(paramBoolean);
      this.sU.setText("");
      return;
    }
  }
  
  private void pv(boolean paramBoolean)
  {
    ksz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, 4, "", null, false, null, -1, paramBoolean);
    String str = new ksz.c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).b(1).build();
    kbp.a((QQAppInterface)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getAppInterface(), ksz.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, str, false);
    ArticleInfo localArticleInfo1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    Context localContext = this.mContext;
    ArticleInfo localArticleInfo2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i = (int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.FP()) {}
    for (str = "2";; str = "1")
    {
      nns.c(localArticleInfo1, "0X8008990", kxm.a(localContext, localArticleInfo2, i, str).toString());
      return;
    }
  }
  
  private void pw(boolean paramBoolean)
  {
    int j = 0;
    String str;
    int i;
    if (paramBoolean)
    {
      str = awit.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.sN, 99990000L, "9999万+", "");
      if (this.sW != null)
      {
        if (this.arJ)
        {
          if ("".equalsIgnoreCase(str)) {
            break label126;
          }
          this.sW.setText(str);
          i = 0;
          this.sW.setVisibility(i);
        }
        label71:
        i = 4;
        this.ef.setOnClickListener(this);
      }
    }
    for (;;)
    {
      this.ef.setVisibility(j);
      this.mo.setVisibility(i);
      this.mp.setVisibility(i);
      this.sR.setVisibility(j);
      return;
      this.sS.setText(str);
      break label71;
      label126:
      i = 8;
      break;
      i = 0;
      j = 8;
    }
  }
  
  private void py(boolean paramBoolean)
  {
    int i = 1;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.mContext == null) || (!(this.mContext instanceof Activity)))
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "setFavoriteArticle but articleInfo is null.");
      return;
    }
    Object localObject = (Activity)this.mContext;
    pA(paramBoolean);
    if (paramBoolean)
    {
      lgv.a();
      lgv.h(this.mContext, false);
    }
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, new Object[] { "setFavoriteArticle, isFavorite = ", Boolean.valueOf(paramBoolean) });
    if (this.arI)
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "waiting for favorite result now, do not request again.");
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Svi != null) {
        this.jdField_b_of_type_Svi.destroy();
      }
      this.jdField_b_of_type_Svi = new svi((QQAppInterface)kxm.getAppRuntime(), (Activity)localObject);
      this.jdField_b_of_type_Svi.K(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_b_of_type_Svi.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, 9, false);
      this.arI = true;
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new ReadInJoyFastWebBottomSocialView.3(this), 3000L);
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        if (!paramBoolean) {
          break label343;
        }
        ((JSONObject)localObject).put("status", i);
        ((JSONObject)localObject).put("rowkey", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        kbp.a(null, "", "0X8009D0F", "0X8009D0F", 0, 0, "", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", "", ((JSONObject)localObject).toString(), false);
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      lgv.a().a(localException, localQQAppInterface.getAccount(), 1, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (ArrayList)this.eu.get(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID));
      break;
      label343:
      i = 0;
    }
  }
  
  private void pz(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.mContext == null))
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "updateFavoriteStatus but fastWebInfo is null.");
      return;
    }
    pA(paramBoolean);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.pS(paramBoolean);
  }
  
  public void eM(long paramLong)
  {
    if ((this.sS == null) || (this.sR == null) || (this.kw == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {
      return;
    }
    Object localObject = ktr.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localObject != null)
    {
      long l = ((ktr)localObject).r(2);
      localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
      if (l > 0L) {
        paramLong = l;
      }
    }
    for (((FastWebArticleInfo)localObject).sN = paramLong;; this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.sN = paramLong)
    {
      pw(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.FO());
      return;
    }
  }
  
  public void eN(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null) || (this.sV == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.xL = paramLong;
    if (awit.s(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getAppRuntime()) == 0)
    {
      this.sV.setText(awit.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.xL, 99990000L, "9999万+", "Biu"));
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, "updateBiuCntView | biu cnt is " + paramLong);
      return;
    }
    this.sV.setText("Biu");
    QLog.d("ReadInJoyFastWebBottomSocialView", 2, "updateBiuCntView | biu cnt switch is closed ");
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null)) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        switch (paramView.getId())
        {
        }
      }
      if ((this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow.isShowing())) {
        this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
      }
      kxy.mK(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null));
    label140:
    ArticleInfo localArticleInfo1;
    Context localContext;
    ArticleInfo localArticleInfo2;
    int i;
    if (kpn.nx() == 1)
    {
      bool = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.m(18, 0, bool);
      localArticleInfo1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localContext = this.mContext;
      localArticleInfo2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i = (int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (!this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.FP()) {
        break label568;
      }
    }
    label568:
    for (Object localObject = "2";; localObject = "1")
    {
      nns.c(localArticleInfo1, "0X8008991", kxm.a(localContext, localArticleInfo2, i, (String)localObject, 0).toString());
      break;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (a(new nes(this)))) {
        break;
      }
      pv(true);
      break;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
      {
        QLog.d("ReadInJoyFastWebBottomSocialView", 1, "enter scroll");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.aYY();
        localArticleInfo1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        localContext = this.mContext;
        localArticleInfo2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        i = (int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.FP()) {}
        for (localObject = "2";; localObject = "1")
        {
          nns.c(localArticleInfo1, "0X8008990", kxm.a(localContext, localArticleInfo2, i, (String)localObject).toString());
          break;
        }
      }
      if ("scroll to history location failed cuz activity or articleinfo is null" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null) {}
      for (localObject = "activity is null";; localObject = "")
      {
        QLog.d("ReadInJoyFastWebBottomSocialView", 1, (String)localObject);
        break;
      }
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)
      {
        QLog.d("ReadInJoyFastWebBottomSocialView", 2, "like click event failed");
        break;
      }
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.isLiked)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.isLiked = false;
        localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
        ((FastWebArticleInfo)localObject).likeCnt -= 1;
        nns.d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009765", "1");
      }
      for (;;)
      {
        aWl();
        tu(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.likeCnt);
        lcc.a().aJC();
        lbz.a().a(kxm.getLongAccountUin(), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.isLiked, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
        break;
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.isLiked = true;
        localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
        ((FastWebArticleInfo)localObject).likeCnt += 1;
        nns.d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009764", "1");
      }
      bool = false;
      break label140;
    }
    if (!this.ky.isSelected()) {}
    for (;;)
    {
      py(bool);
      break;
      bool = false;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    }
    do
    {
      return false;
      if ((this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow.isShowing())) {
        this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null);
    ArticleInfo localArticleInfo1;
    Context localContext;
    ArticleInfo localArticleInfo2;
    int i;
    if (kpn.ny() == 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.m(18, 0, bool);
      localArticleInfo1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localContext = this.mContext;
      localArticleInfo2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i = (int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (!this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.FP()) {
        break label144;
      }
    }
    label144:
    for (paramView = "2";; paramView = "1")
    {
      nns.c(localArticleInfo1, "0X8008991", kxm.a(localContext, localArticleInfo2, i, paramView, 0).toString());
      return false;
      bool = false;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    aWn();
  }
  
  public void px(boolean paramBoolean)
  {
    if ((this.kx == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.isLiked = paramBoolean;
    ImageView localImageView = this.kx;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.isLiked) {}
    for (int i = 2130843693;; i = 2130843695)
    {
      localImageView.setImageResource(i);
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, "updateLikeIconView | isLiked  " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.isLiked);
      return;
    }
  }
  
  public void setData(FastWebActivity paramFastWebActivity, FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity = paramFastWebActivity;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramFastWebArticleInfo;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    eM(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.sN);
    eN(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.xL);
    tu(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.likeCnt);
    px(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.isLiked);
    aWm();
  }
  
  public void setFavoriteArticle()
  {
    if (this.ky != null) {
      if (this.ky.isSelected()) {
        break label25;
      }
    }
    label25:
    for (boolean bool = true;; bool = false)
    {
      py(bool);
      return;
    }
  }
  
  public void tu(int paramInt)
  {
    if ((this.sT == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.likeCnt = paramInt;
    String str = awit.a(paramInt, 99990000L, "9999万+", "");
    if (this.sX != null) {
      if (this.arJ)
      {
        int j = 8;
        int i = j;
        if (!"".equalsIgnoreCase(str))
        {
          i = j;
          if (this.aYl == 1)
          {
            this.sX.setText(str);
            i = 0;
          }
        }
        this.sX.setVisibility(i);
      }
    }
    for (;;)
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, "updateLikeCntView | like cnt is " + paramInt);
      return;
      this.sT.setText(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialView
 * JD-Core Version:    0.7.0.1
 */