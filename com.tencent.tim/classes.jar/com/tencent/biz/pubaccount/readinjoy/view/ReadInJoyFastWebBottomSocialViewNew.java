package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kbp;
import kpn;
import ksz;
import ksz.c;
import kva;
import kva.a;
import kvx;
import kxm;
import kxy;
import kyq;
import lbz;
import lcc;
import lgv;
import lgv.a;
import luh;
import new;
import ney;
import nez;
import nfa;
import nfb;
import nmx;
import nns;
import org.json.JSONObject;
import svi;

public class ReadInJoyFastWebBottomSocialViewNew
  extends FrameLayout
{
  private kva a;
  private int aYm = -1;
  private boolean arI;
  private boolean arK;
  private KandianFavoriteBroadcastReceiver jdField_b_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  private ArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private FastWebActivity jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity;
  private svi jdField_b_of_type_Svi;
  private BubblePopupWindow jdField_c_of_type_ComTencentWidgetBubblePopupWindow;
  lgv.a jdField_c_of_type_Lgv$a = new nfa(this);
  private Container d;
  private HashMap<String, ArrayList<String>> eu = new HashMap();
  private TemplateBean mTemplateBean;
  private VafContext mVafContext;
  private View mq;
  
  public ReadInJoyFastWebBottomSocialViewNew(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public ReadInJoyFastWebBottomSocialViewNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void C(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver == null)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_c_of_type_Lgv$a);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.process.fav");
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.registerReceiver(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, (IntentFilter)localObject);
    }
    Object localObject = new ArrayList();
    ((List)localObject).add(paramArticleInfo.innerUniqueID);
    lgv.a().a((List)localObject, this.jdField_c_of_type_Lgv$a);
  }
  
  private boolean Fr()
  {
    String str = "";
    boolean bool;
    if (this.d == null)
    {
      bool = false;
      str = "" + "mContentView is null!";
    }
    for (;;)
    {
      if (!bool) {
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "isParamsValidity error!  msg=" + str);
      }
      return bool;
      bool = true;
    }
  }
  
  private void a(Activity paramActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    ksz.a(paramActivity, paramArticleInfo, null, 4, "", null, false, null, -1);
    String str = new ksz.c(paramArticleInfo, null).b(1).build();
    kbp.a(kxm.a(), ksz.a(paramArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), paramArticleInfo.innerUniqueID, str, false);
    int i = (int)paramArticleInfo.mChannelID;
    if (paramFastWebArticleInfo.FP()) {}
    for (paramFastWebArticleInfo = "2";; paramFastWebArticleInfo = "1")
    {
      nns.c(paramArticleInfo, "0X8008990", kxm.a(paramActivity, paramArticleInfo, i, paramFastWebArticleInfo).toString());
      return;
    }
  }
  
  private void a(FastWebActivity paramFastWebActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramFastWebActivity == null) || (paramArticleInfo == null) || (paramFastWebArticleInfo == null) || (a(paramFastWebActivity, paramArticleInfo, new ney(this, paramFastWebActivity, paramArticleInfo, paramFastWebArticleInfo)))) {
      return;
    }
    a(paramFastWebActivity, paramArticleInfo, paramFastWebArticleInfo);
  }
  
  private void a(FastWebActivity paramFastWebActivity, FastWebArticleInfo paramFastWebArticleInfo)
  {
    boolean bool = true;
    if ((this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow.isShowing())) {
      this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
    }
    ArticleInfo localArticleInfo1;
    FastWebActivity localFastWebActivity;
    ArticleInfo localArticleInfo2;
    int i;
    if ((paramFastWebActivity != null) && (paramFastWebArticleInfo != null))
    {
      if (kpn.ny() != 1) {
        break label109;
      }
      paramFastWebActivity.m(18, 0, bool);
      localArticleInfo1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localFastWebActivity = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity;
      localArticleInfo2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i = (int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (!paramFastWebArticleInfo.FP()) {
        break label115;
      }
    }
    label109:
    label115:
    for (paramFastWebActivity = "2";; paramFastWebActivity = "1")
    {
      nns.c(localArticleInfo1, "0X8008991", kxm.a(localFastWebActivity, localArticleInfo2, i, paramFastWebActivity, 0).toString());
      return;
      bool = false;
      break;
    }
  }
  
  private void a(ProteusItemData paramProteusItemData, FastWebActivity paramFastWebActivity, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (!Fr()) {
      return;
    }
    ViewBase localViewBase = this.d.getVirtualView();
    ViewFactory.findClickableViewListener(localViewBase, new new(this, paramProteusItemData, paramFastWebActivity));
    a(localViewBase, paramFastWebActivity, paramFastWebArticleInfo);
  }
  
  private void a(ViewBase paramViewBase, FastWebActivity paramFastWebActivity, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramViewBase == null) {}
    do
    {
      do
      {
        return;
        paramViewBase = paramViewBase.findViewBaseByName("id_biu");
      } while (paramViewBase == null);
      paramViewBase = paramViewBase.getNativeView();
    } while (paramViewBase == null);
    paramViewBase.setOnLongClickListener(new nfb(this, paramFastWebActivity, paramFastWebArticleInfo));
  }
  
  private boolean a(FastWebActivity paramFastWebActivity, ArticleInfo paramArticleInfo, kva.a parama)
  {
    if (this.a == null) {
      this.a = new kva(paramFastWebActivity, paramArticleInfo);
    }
    if ((!this.a.dw(paramArticleInfo.innerUniqueID)) && (kyq.Bj()))
    {
      if (this.mq == null) {
        this.mq = ((ViewStub)paramFastWebActivity.findViewById(2131376729)).inflate();
      }
      this.a.a(new nez(this, parama));
      this.mq.setVisibility(0);
      this.a.b(paramArticleInfo);
      this.a.aO(paramFastWebActivity.getWindow().getDecorView());
      return true;
    }
    return false;
  }
  
  private void aR(Activity paramActivity)
  {
    this.mVafContext = new luh();
    this.mVafContext.setContext(paramActivity);
    kvx.a(this.mVafContext, "native_article");
  }
  
  private void aWl() {}
  
  private void aWn() {}
  
  private void af(JSONObject paramJSONObject)
  {
    try
    {
      this.mTemplateBean.bindData(paramJSONObject);
      kvx.a(this.d.getVirtualView(), this.mTemplateBean.getViewBean());
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "refresh error!  msg=" + paramJSONObject);
    }
  }
  
  private void b(FastWebActivity paramFastWebActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramFastWebActivity != null) && (paramArticleInfo != null))
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "enter scroll");
      paramFastWebActivity.aYY();
      int i = (int)paramArticleInfo.mChannelID;
      if (paramFastWebArticleInfo.FP()) {}
      for (paramFastWebArticleInfo = "2";; paramFastWebArticleInfo = "1")
      {
        nns.c(paramArticleInfo, "0X8008990", kxm.a(paramFastWebActivity, paramArticleInfo, i, paramFastWebArticleInfo).toString());
        return;
      }
    }
    if ("scroll to history location failed cuz activity or articleinfo is null" + paramFastWebActivity == null) {}
    for (paramFastWebActivity = "activity is null";; paramFastWebActivity = "")
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, paramFastWebActivity);
      return;
    }
  }
  
  private void c(FastWebActivity paramFastWebActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramFastWebArticleInfo == null)
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 2, "like click event failed");
      return;
    }
    if (paramFastWebArticleInfo.isLiked)
    {
      paramFastWebArticleInfo.isLiked = false;
      paramFastWebArticleInfo.likeCnt -= 1;
      nns.d(paramArticleInfo, "0X8009765", "1");
    }
    for (;;)
    {
      aWl();
      tu(paramFastWebArticleInfo.likeCnt);
      lcc.a().aJD();
      lbz.a().a(kxm.getLongAccountUin(), paramFastWebArticleInfo.isLiked, paramFastWebArticleInfo);
      return;
      paramFastWebArticleInfo.isLiked = true;
      paramFastWebArticleInfo.likeCnt += 1;
      nns.d(paramArticleInfo, "0X8009764", "1");
    }
  }
  
  private void d(FastWebActivity paramFastWebActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    boolean bool = true;
    if ((this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow.isShowing())) {
      this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
    }
    kxy.mK(paramArticleInfo.innerUniqueID);
    int i;
    if ((paramFastWebActivity != null) && (paramArticleInfo != null))
    {
      if (kpn.nx() != 1) {
        break label94;
      }
      paramFastWebActivity.m(18, 0, bool);
      i = (int)paramArticleInfo.mChannelID;
      if (!paramFastWebArticleInfo.FP()) {
        break label100;
      }
    }
    label94:
    label100:
    for (paramFastWebArticleInfo = "2";; paramFastWebArticleInfo = "1")
    {
      nns.c(paramArticleInfo, "0X8008991", kxm.a(paramFastWebActivity, paramArticleInfo, i, paramFastWebArticleInfo, 0).toString());
      return;
      bool = false;
      break;
    }
  }
  
  private void e(FastWebActivity paramFastWebActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    i = 1;
    if ((paramArticleInfo == null) || (paramFastWebActivity == null) || ((!(paramFastWebActivity instanceof Activity)) && (paramFastWebArticleInfo != null)))
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "setFavoriteArticle but articleInfo is null.");
      return;
    }
    if (!paramFastWebArticleInfo.isFavorite) {}
    for (boolean bool = true;; bool = false)
    {
      this.arK = bool;
      paramFastWebArticleInfo.pS(this.arK);
      bool = paramFastWebArticleInfo.isFavorite;
      if (bool)
      {
        lgv.a();
        lgv.h(paramFastWebActivity, false);
      }
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, new Object[] { "setFavoriteArticle, isFavorite = ", Boolean.valueOf(bool) });
      if (!this.arI) {
        break;
      }
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "waiting for favorite result now, do not request again.");
      return;
    }
    if (bool)
    {
      if (this.jdField_b_of_type_Svi != null) {
        this.jdField_b_of_type_Svi.destroy();
      }
      this.jdField_b_of_type_Svi = new svi((QQAppInterface)kxm.getAppRuntime(), paramFastWebActivity);
      this.jdField_b_of_type_Svi.K(paramArticleInfo);
      this.jdField_b_of_type_Svi.a(paramArticleInfo.mArticleContentUrl, 9, false);
    }
    for (;;)
    {
      this.arI = true;
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new ReadInJoyFastWebBottomSocialViewNew.4(this), 3000L);
      try
      {
        paramFastWebActivity = new JSONObject();
        if (!bool) {
          break;
        }
      }
      catch (Exception paramFastWebActivity)
      {
        for (;;)
        {
          continue;
          i = 0;
        }
      }
      paramFastWebActivity.put("status", i);
      paramFastWebActivity.put("rowkey", paramArticleInfo.innerUniqueID);
      kbp.a(null, "", "0X8009D0F", "0X8009D0F", 0, 0, "", paramArticleInfo.mArticleID + "", "", paramFastWebActivity.toString(), false);
      lcc.a().aJD();
      return;
      paramFastWebArticleInfo = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      lgv.a().a(paramFastWebActivity, paramFastWebArticleInfo.getAccount(), 1, paramArticleInfo.innerUniqueID, (ArrayList)this.eu.get(paramArticleInfo.innerUniqueID));
    }
  }
  
  private void initView() {}
  
  public void a(FastWebActivity paramFastWebActivity, FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo)
  {
    setData(paramFastWebActivity, paramFastWebArticleInfo, paramArticleInfo);
  }
  
  public void aWo() {}
  
  public void eN(long paramLong)
  {
    lcc.a().aJD();
  }
  
  public void onDestory()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver != null)) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.unregisterReceiver(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    aWn();
  }
  
  public void px(boolean paramBoolean) {}
  
  public void setData(FastWebActivity paramFastWebActivity, FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo)
  {
    if ((paramFastWebActivity == null) || (paramFastWebArticleInfo == null) || (paramArticleInfo == null))
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "setData error!  params is null!");
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity = paramFastWebActivity;
    ProteusItemData localProteusItemData = nmx.a(paramArticleInfo, paramFastWebArticleInfo);
    if (this.mVafContext == null) {
      aR(paramFastWebActivity);
    }
    int i;
    if (paramFastWebArticleInfo.FO()) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if ((this.aYm == -1) || (i != this.aYm))
        {
          removeAllViews();
          this.mTemplateBean = localProteusItemData.mTemplateBean;
          this.d = this.mVafContext.getViewFactory().inflate(this.mVafContext, this.mTemplateBean);
          addView(this.d);
          if (!paramFastWebArticleInfo.FO()) {
            continue;
          }
          i = 0;
          this.aYm = i;
        }
      }
      catch (Exception localException)
      {
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "setData error!  msg=" + localException);
        continue;
      }
      if (!Fr()) {
        break;
      }
      af(localProteusItemData.aD);
      a(localProteusItemData, paramFastWebActivity, paramFastWebArticleInfo);
      C(paramArticleInfo);
      setVisibility(0);
      return;
      i = 1;
      continue;
      i = 1;
    }
  }
  
  public void setFavoriteArticle(FastWebActivity paramFastWebActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    e(paramFastWebActivity, paramArticleInfo, paramFastWebArticleInfo);
  }
  
  public void tu(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew
 * JD-Core Version:    0.7.0.1
 */