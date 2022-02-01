package com.tencent.biz.pubaccount.readinjoy.activity;

import acfp;
import amub;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anpc;
import aqfo;
import aqgz;
import aqho;
import aqhq;
import aqiw;
import aqmj;
import awit;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.c;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.d;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.a;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.b;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview.b;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar.a;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kbp;
import kct;
import kgk;
import kig;
import kil;
import kio;
import klu;
import kxm;
import lbz;
import lcc;
import lcd;
import lce;
import lci;
import ldw;
import lic;
import meu;
import mfj;
import mfk;
import mfl;
import mfo;
import mfs;
import mfs.a;
import mgf;
import mhm;
import mqq.os.MqqHandler;
import msg;
import mye;
import mza;
import mzj;
import neq;
import nha;
import npa;
import oan;
import obt;
import odd;
import odv;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyNewFeedsActivity
  extends ReadInJoyNewBaseActivity
  implements View.OnClickListener, KandianMergeManager.c, KandianMergeManager.d, TopGestureLayout.OnGestureListener, Observer, mfs.a
{
  private static final int aJc = Color.parseColor("#dedfe0");
  public static int aJe;
  public static ConcurrentHashMap<Integer, b> aS;
  public static List<String> gh = new ArrayList(1);
  protected String Zq;
  protected AccountDetailTopGestureLayout a;
  private ReadInJoyBaseFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  private GuideData jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData;
  BaseTabbar.a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$a = new kio(this);
  public ReadInJoySkinGuideView a;
  private ReadinjoyTabbar jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar;
  public kgk a;
  protected mgf a;
  private int aIV;
  private int aIW;
  int aIY;
  private int aJd;
  private ConcurrentHashMap<Integer, ReadInJoySubChannelFragment> aT = new ConcurrentHashMap();
  private boolean afq;
  private boolean afr;
  public boolean afs;
  private boolean afu;
  private boolean afv;
  private int aih;
  private KandianMergeManager jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  private ChannelCoverInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  private Runnable cv = new ReadInJoyNewFeedsActivity.1(this);
  private MqqHandler h = new MqqHandler();
  private View jD;
  private View mDivider;
  boolean mFirstShow = true;
  private FragmentManager mFragmentManager;
  protected lce mObserver = new kig(this);
  protected FrameLayout mRootLayout;
  private long rV;
  private long rW;
  private long se;
  private long sf;
  private long startTimeMillis;
  
  static
  {
    aS = new ConcurrentHashMap();
    aS.put(Integer.valueOf(0), new b(acfp.m(2131695158), 1, 0, -1, -857808928));
  }
  
  private void aBX()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = (mfs)((AppInterface)localObject).getManager(261);
      if (localObject != null) {
        ((mfs)localObject).a(this);
      }
    }
  }
  
  private void aCa()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = (mfs)((AppInterface)localObject).getManager(261);
      ((mfs)localObject).b(this);
      ((mfs)localObject).clearData();
    }
  }
  
  private void aDo()
  {
    QLog.d("ReadInJoyNewFeedsActivity", 2, "reportKandianTabRedInfo.");
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(162));
    }
    SparseIntArray localSparseIntArray = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b();
    if (localSparseIntArray.get(0) <= 0) {
      localSparseIntArray.put(0, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.ol());
    }
    localSparseIntArray.put(3, 0);
    int i = 0;
    if (i < 4)
    {
      if (localSparseIntArray.get(i) <= 0) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          JSONObject localJSONObject = kxm.v();
          localJSONObject.put("kandian_mode", kxm.nR());
          localJSONObject.put("tab_source", i + 1);
          String str3 = "";
          String str4 = "";
          String str2 = str3;
          String str1 = str4;
          if (i == 2)
          {
            long l = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.cu();
            str2 = str3;
            str1 = str4;
            if (l != 0L)
            {
              str2 = String.valueOf(l);
              str1 = String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.oh());
            }
          }
          kbp.a(null, "CliOper", "", str2, "0X80081C6", "0X80081C6", 0, 1, null, null, str1, localJSONObject.toString(), false);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  private void aDq()
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo = new ChannelCoverInfo();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId = 0;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelType = 0;
  }
  
  private void aDs()
  {
    if (this.aih == 3) {}
    for (;;)
    {
      return;
      boolean bool;
      if (this.aih == 0) {
        bool = kxm.aih;
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "onTabRedNumsChange on" + this.aih + "and rednums is" + nl());
        return;
        if (this.aih == 1) {
          bool = kxm.aih;
        }
      }
    }
  }
  
  private void aq(Bundle paramBundle)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(162));
    }
    long l;
    if ((paramBundle != null) && (paramBundle.getInt("BID_TYPE", 0) == 2))
    {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "reportSubscribeTabRedInfo.");
      l = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.cu();
      if (l == 0L) {}
    }
    try
    {
      paramBundle = kxm.v();
      paramBundle.put("kandian_mode", kxm.nR());
      paramBundle.put("tab_source", 3);
      kbp.a(null, "CliOper", "", String.valueOf(l), "0X80081C6", "0X80081C6", 0, 1, null, null, String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.oh()), paramBundle.toString(), false);
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  private void mf(String paramString)
  {
    getWindow().getDecorView().post(new ReadInJoyNewFeedsActivity.11(this, paramString));
  }
  
  private int nl()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(162));
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b().get(3);
  }
  
  public static void pb(int paramInt)
  {
    if (paramInt == 7)
    {
      kxm.pY(2);
      return;
    }
    if (paramInt == 5)
    {
      kxm.pY(1);
      return;
    }
    if (paramInt == 1)
    {
      kxm.pY(4);
      return;
    }
    if ((paramInt == 6) || (paramInt == 9))
    {
      kxm.pY(7);
      return;
    }
    kxm.pY(5);
  }
  
  public static boolean zs()
  {
    return gh.size() > 0;
  }
  
  public ReadInJoyBaseFragment a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  }
  
  public ReadinjoyTabbar a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar;
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    if ((paramInt1 < 0) || (paramInt1 >= 4)) {
      i = 0;
    }
    for (;;)
    {
      this.aJd = this.aih;
      boolean bool = de(paramInt1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setSelection(i, this.aih, this.mFragmentManager, getIntent(), paramInt2, paramBundle);
      Object localObject2 = (mfs)this.app.getManager(261);
      if (((mfs)localObject2).pg() != 0)
      {
        paramBundle = ((mfs)localObject2).a(i + 4);
        if (paramBundle != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).b.kq.setImageDrawable(paramBundle.getDrawable());
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.aih).b.kq.setSelected(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).b.kq.setSelected(true);
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(162));
      }
      int j = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.de(i);
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.Z(this.aih, i)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.tp(i);
      }
      setTitle(((b)aS.get(Integer.valueOf(i))).Zr);
      if (i == 0)
      {
        oW(0);
        label240:
        pa(i);
        if ((i != 2) || (this.jD == null)) {
          break label878;
        }
        this.jD.setBackgroundColor(aJc);
        label269:
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNewFeedsActivity", 2, "setSelection from tab " + this.aih + " to tab " + i + ", jumpType:" + paramInt2);
        }
        if (i != 1) {}
      }
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("has_redpoint", j);
        kbp.a(null, "", "0X8007C40", "0X8007C40", 0, 0, "", "", "", kct.d(paramBundle), false);
        if (this.aih == i)
        {
          paramInt1 = 1;
          this.aih = i;
          aJe = this.aih;
          aDr();
          if ((this.aih == 2) && (kxm.AP())) {
            oZ(2130843685);
          }
          if ((this.aih == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData != null))
          {
            paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData;
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData = null;
            ThreadManager.post(new ReadInJoyNewFeedsActivity.8(this, paramBundle), 8, null, true);
          }
          paramInt2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.qD();
          if (paramInt2 == 3) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.tG(paramInt2);
          }
          if (i == 3) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.tp(3);
          }
          if (paramBoolean) {
            localObject1 = "";
          }
        }
        try
        {
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("folder_status", kxm.aMw);
          if (j <= 0) {
            break label909;
          }
          paramBundle = "2";
          ((JSONObject)localObject3).put("reddot", paramBundle);
          ((JSONObject)localObject3).put("kandian_mode", kxm.nR());
          ((JSONObject)localObject3).put("kandian_mode_new", kct.nd());
          if ((((mfs)localObject2).pg() != 1) || (TextUtils.isEmpty(((mfs)localObject2).jM()))) {
            break label916;
          }
          paramBundle = ((mfs)localObject2).jM();
          ((JSONObject)localObject3).put("skin_id", paramBundle);
          if (!bool) {
            break label923;
          }
          paramInt2 = 1;
          ((JSONObject)localObject3).put("button_state", paramInt2);
          if (a().nh() == 0)
          {
            paramBundle = mfo.b(getActivity(), 0);
            if ((paramBundle == null) || (!paramBundle.isAD)) {
              break label928;
            }
            paramInt2 = 1;
            ((JSONObject)localObject3).put("ad_page", paramInt2);
          }
          paramBundle = ((JSONObject)localObject3).toString();
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            Object localObject3;
            String str;
            long l;
            label878:
            paramBundle.printStackTrace();
            paramBundle = (Bundle)localObject1;
            continue;
            if (!this.mFirstShow)
            {
              kbp.a(this.app, "", "0X80081C5", "0X80081C5", 0, 0, String.valueOf(i + 1), "", "", paramBundle, false);
              continue;
              odd.bU(null, "recommend_tab_cost");
              continue;
              odd.bU(null, "video_tab_cost");
              continue;
              odd.bU(null, "subscribe_tab_cost");
              continue;
              odd.bU(null, "self_tab_cost");
              continue;
              nha.a(this).di(0, 0);
              continue;
              nha.a(this).di(3, 56);
            }
          }
        }
        if (paramInt1 == 0)
        {
          localObject3 = "";
          str = "";
          localObject2 = localObject3;
          localObject1 = str;
          if (i == 2)
          {
            localObject2 = localObject3;
            localObject1 = str;
            if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
            {
              l = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.cu();
              localObject2 = localObject3;
              localObject1 = str;
              if (l != 0L)
              {
                localObject2 = String.valueOf(l);
                localObject1 = String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.oh());
              }
            }
          }
          kbp.a(this.app, (String)localObject2, "0X8007DB0", "0X8007DB0", 0, 0, String.valueOf(i + 1), "", (String)localObject1, paramBundle, false);
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              nha.a(this).aWY();
              this.mFirstShow = false;
              npa.tQ(a().nh());
              return;
              i = paramInt1;
              continue;
              oW(8);
              break label240;
              if (this.jD == null) {
                break label269;
              }
              this.jD.setBackgroundColor(-1);
            }
            break;
          }
        }
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          continue;
          paramInt1 = 0;
          continue;
          label909:
          paramBundle = "1";
          continue;
          label916:
          paramBundle = "0";
          continue;
          label923:
          paramInt2 = 0;
          continue;
          label928:
          paramInt2 = 0;
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    mfl localmfl = (mfl)this.app.getManager(paramInt);
    String str;
    if (localmfl.a(paramString, paramBaseResData))
    {
      str = localmfl.U(paramString, paramBaseResData.id);
      if (!localmfl.b(paramString, paramBaseResData)) {
        break label157;
      }
      if ((261 != paramInt) || (aqmj.p(this, paramBaseResData.id) == paramBaseResData.seq)) {
        break label82;
      }
      aqhq.cn(str);
      localmfl.c(paramString, paramBaseResData);
    }
    label82:
    do
    {
      return;
      localmfl.b(paramString, paramBaseResData);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "showSkinGuide：real: " + paramBaseResData.id);
      }
    } while (!(paramBaseResData instanceof GuideData));
    paramString = (GuideData)paramBaseResData;
    this.h.post(new ReadInJoyNewFeedsActivity.5(this, paramString, str, paramInt));
    return;
    label157:
    localmfl.c(paramString, paramBaseResData);
  }
  
  public void a(ReadInJoyBaseFragment paramReadInJoyBaseFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = paramReadInJoyBaseFragment;
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    if (paramInt == mhm.aRP) {
      if (this.mIsResume)
      {
        aDs();
        if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.BD())) {
          msg.a().aN(this.app.getCurrentAccountUin(), 1);
        }
      }
    }
    while (paramInt != mhm.aRQ) {
      for (;;)
      {
        return;
        this.afv = true;
      }
    }
    aq(paramBundle);
  }
  
  public void aCM()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label135;
      }
      if ((!aqfo.isMIUI()) && (!aqfo.isFlyme()))
      {
        this.mSystemBarComp.setStatusBarColor(-7829368);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-7829368);
      }
    }
    else
    {
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-7829368);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-7829368);
    this.mSystemBarComp.setStatusBarDarkMode(true);
    return;
    label135:
    if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
    {
      lU(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
      return;
    }
    if (!aqfo.isFlyme())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public void aDh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onTabRedNumsChange.");
    }
    aDm();
    aDn();
  }
  
  protected void aDk()
  {
    pa(this.aih);
    mfs localmfs = (mfs)this.app.getManager(261);
    int i = 0;
    while (i < 4)
    {
      mfj localmfj = localmfs.a(i + 4);
      if (localmfj != null)
      {
        BaseTabbar.b localb = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).b;
        localb.kq.setImageDrawable(localmfj.getDrawable());
        if (i == this.aih)
        {
          localb.kq.setSelected(true);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.df(i, i);
        }
      }
      if (localmfs.pg() == 1) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setTabState(i, false);
      }
      i += 1;
    }
  }
  
  public void aDl()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setEnableRepeatedClick(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setCurrentActivity(this);
    mfs localmfs = (mfs)this.app.getManager(261);
    i = 0;
    while (i < 4)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i, ((b)aS.get(Integer.valueOf(i))).Zr);
      if (localmfs.pg() != 0)
      {
        mfj localmfj = localmfs.a(i + 4);
        if (localmfj != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).b.kq.setImageDrawable(localmfj.getDrawable());
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setOnTabChangeListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$a);
    i = getIntent().getIntExtra("tab_tab_index", 0);
    if (i > 0) {
      this.aih = i;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.Bw()) || (System.currentTimeMillis() - awit.s(this.app) > 600000L) || (this.aIV == 1)) {
          continue;
        }
        if (this.aIV != 9) {
          continue;
        }
      }
      catch (Exception localException)
      {
        QLog.d("ReadInJoyNewFeedsActivity", 1, "restoreHistoryKanDianTab throw Exception.");
        localException.printStackTrace();
        continue;
        i = 1;
        continue;
      }
      if ((i == 0) && (kxm.aM(cc()))) {
        this.aih = ((lcd)this.app.getManager(163)).b().op();
      }
      aJe = this.aih;
      this.mFirstShow = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setSelectedTab(this.aih, false);
      return;
      this.aih = 0;
      continue;
      i = 0;
    }
  }
  
  public void aDm()
  {
    me(false);
  }
  
  public void aDn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "setRecommendRedDotInfo.");
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId == 0)) {
      for (;;)
      {
        try
        {
          if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(162));
          }
          if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.BD()) {
            return;
          }
          if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.Bw())
          {
            i = 1;
            kxm.p().post(new ReadInJoyNewFeedsActivity.7(this, i));
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        int i = 0;
      }
    }
  }
  
  public void aDp()
  {
    Iterator localIterator = this.aT.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (ReadInJoySubChannelFragment)this.aT.get(localObject);
      if (localObject != null) {
        ((ReadInJoySubChannelFragment)localObject).onDestroy();
      }
    }
    this.aT.clear();
  }
  
  protected void aDr()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.aih).c() != null) {
      super.mc(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.aih).c().BS());
    }
  }
  
  void aQ()
  {
    if (this.leftView != null) {
      ThreadManager.post(new ReadInJoyNewFeedsActivity.15(this), 5, null, true);
    }
  }
  
  public void bY(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.bS(paramView);
    }
  }
  
  public long cb()
  {
    return this.sf;
  }
  
  public long cc()
  {
    return this.rV;
  }
  
  public void d(int paramInt, String paramString, boolean paramBoolean)
  {
    aDk();
  }
  
  public boolean de(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(paramInt).asu;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    if (paramInt1 == 9992)
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false))) {
        finish();
      }
    }
    else
    {
      if (paramInt1 != 101) {
        break label240;
      }
      switch (paramInt2)
      {
      }
    }
    Object localObject;
    label240:
    do
    {
      do
      {
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.aih).c() != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.aih).c().i(paramInt1, paramInt2, paramIntent);
          }
          super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
          return;
          if (!paramIntent.getBooleanExtra("bFailed", false)) {
            i = 1;
          }
          localObject = new QQToast(this);
          ((QQToast)localObject).setDuration(2000);
          if (i != 0)
          {
            ((QQToast)localObject).setToastIcon(QQToast.getIconRes(2));
            ((QQToast)localObject).setToastMsg(2131693408);
            ((QQToast)localObject).show(getApplicationContext().getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel(getApplicationContext(), 5.0F));
          }
          else
          {
            ((QQToast)localObject).setToastIcon(QQToast.getIconRes(1));
            ((QQToast)localObject).setToastMsg(2131693409);
            ((QQToast)localObject).show(getApplicationContext().getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel(getApplicationContext(), 5.0F));
          }
        }
      } while (paramInt1 != 9991);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "back from article detail");
      }
    } while (!kxm.AO());
    if (!TextUtils.isEmpty(obt.Yj)) {}
    for (;;)
    {
      try
      {
        for (;;)
        {
          i = new JSONObject(obt.Yj).optInt("releaseServiceMinMem", 80);
          long l = aqgz.getSystemAvaialbeMemory();
          if (l >>> 20 > i) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyNewFeedsActivity", 2, "back from article detail, release web core service");
          }
          WebProcessManager.egr();
          try
          {
            localObject = new HashMap();
            ((HashMap)localObject).put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
            ((HashMap)localObject).put("param_totalMem", String.valueOf(aqgz.getSystemTotalMemory()));
            ((HashMap)localObject).put("param_availableMem", String.valueOf(l));
            ((HashMap)localObject).put("param_cpuNum", String.valueOf(aqgz.getCpuNumber()));
            ((HashMap)localObject).put("param_cpuFreq", String.valueOf(aqgz.getCpuFrequency()));
            ((HashMap)localObject).put("param_releaseType", String.valueOf(0));
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyNewFeedsActivity", 2, "releaseWebCoreServiceReport:" + ((HashMap)localObject).toString());
            }
            anpc.a(this).collectPerformance(this.app.getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject, "");
          }
          catch (Exception localException1) {}
        }
      }
      catch (Exception localException2)
      {
        i = 80;
        continue;
      }
      i = 80;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    odd.bU("KANDIAN_NEW_FEEDS_ACTIVITY_MANAGER", null);
    odd.bU(null, "KANDIAN_NEW_FEEDS_CREATE");
    mzj.a().aO(this);
    super.doOnCreate(paramBundle);
    gh.add(String.valueOf(hashCode()));
    mfo.amn = false;
    odv.d(this.app);
    awit.x(this.app);
    awit.y(this.app);
    lci.aJN();
    lci.aJO();
    this.rV = System.currentTimeMillis();
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(162)).aIH();
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(162));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    this.afq = paramBundle.getBooleanExtra("from_search", false);
    this.afr = paramBundle.getBooleanExtra("from_javascript", false);
    this.aIV = paramBundle.getIntExtra("launch_from", 5);
    pb(this.aIV);
    if (6 == this.aIV)
    {
      kxm.pV(3);
      kxm.aHY();
    }
    for (;;)
    {
      lcc.a().aJB();
      if (Build.VERSION.SDK_INT >= 11) {
        getWindow().setFlags(16777216, 16777216);
      }
      int i = aqiw.getSystemNetwork(getApplication());
      if ((i == 4) || (i == 1)) {
        ThreadManager.post(new ReadInJoyNewFeedsActivity.2(this), 5, null, true);
      }
      ThreadManager.executeOnSubThread(new MyRunnable(this));
      initUI();
      getWindow().setBackgroundDrawable(null);
      paramBundle = (lcd)this.app.getManager(163);
      lbz.a().aJn();
      lbz.a().aJj();
      if (this.app.b() != null) {
        this.app.b().addObserver(this);
      }
      if (awit.cA(this.app)) {
        oan.a().ap(this.app);
      }
      lcc.a().b(this.mObserver);
      awit.v(this.app);
      this.aIY = kxm.aMw;
      odv.a(odv.rj(), true, 0L, this.aIY, 0);
      kxm.Q(this.app);
      aDs();
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.BD()) {
        msg.a().aN(this.app.getCurrentAccountUin(), 1);
      }
      odd.bU("KANDIAN_NEW_FEEDS_CREATE", null);
      odd.bU(null, "KANDIAN_NEW_FEEDS_CREATE_TO_RESUME");
      long l = NetConnInfoCenter.getServerTimeMillis();
      i = kxm.nR();
      int j = kxm.aMw;
      npa.a().a(this.app, l, i, j);
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.3(this, l, i, j));
      aBX();
      this.jdField_a_of_type_Mgf = new mgf(this.app, 0);
      this.jdField_a_of_type_Mgf.a(new kil(this));
      this.jdField_a_of_type_Mgf.aOZ();
      aCM();
      ThreadManager.getFileThreadHandler().postDelayed(this.cv, 20000L);
      npa.tQ(0);
      kxm.aIb();
      return true;
      if (9 == this.aIV) {
        kxm.pV(3);
      } else if (1 == this.aIV) {
        kxm.pV(8);
      } else if (2 == this.aIV) {
        kxm.pV(8);
      } else if (11 == this.aIV) {
        lcc.a().mh("onConversationJumpRestoreStack");
      }
    }
  }
  
  public void doOnDestroy()
  {
    long l = System.currentTimeMillis();
    try
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.qt();
      ((lcd)this.app.getManager(163)).b().qv(i);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, new Object[] { "saveLeaveKanDianTab time cost: ", Long.valueOf(System.currentTimeMillis() - l) });
      }
      ((klu)this.app.getManager(307)).aB(getActivity());
      nha.a(this).doOnDestory();
      lcc.a().c(this.mObserver);
      ldw.a().aKX();
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
      aCa();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.onDestroy();
      }
      gh.remove(String.valueOf(hashCode()));
      super.doOnDestroy();
      this.rW = System.currentTimeMillis();
      l = this.rW - this.rV;
      if (l > 0L) {
        kbp.a(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", kxm.iR(), false);
      }
      if (this.app.b() != null) {
        this.app.b().deleteObserver(this);
      }
      Object localObject = (lcd)this.app.getManager(163);
      if ((localObject != null) && (((lcd)localObject).b() != null))
      {
        localObject = ((lcd)localObject).b().a();
        if (localObject != null) {
          ((ReadInJoyUserInfoModule)localObject).aMy();
        }
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.aIR();
      lbz.a().aJo();
      mzj.a().aP(this);
      PreloadManager.a().bdj();
      PreloadManager.a().bdm();
      odv.a(odv.rj(), false, this.rV, this.aIY, this.aIW);
      odd.clear();
      WebProcessManager.egr();
      WebProcessManager.egw();
      msg.aRK();
      msg.a().destroy();
      aDp();
      ((mfs)this.app.getManager(261)).b(this);
      this.jdField_a_of_type_Mgf.onDestroy();
      if (this.Zq != null)
      {
        aqhq.cn(mfk.eP(this.Zq));
        this.Zq = null;
      }
      npa.a().report();
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.12(this));
      if (this.jdField_a_of_type_Kgk != null) {
        this.jdField_a_of_type_Kgk.destroy();
      }
      localObject = lbz.a().a();
      if (localObject != null) {
        ((lic)localObject).nB(false);
      }
      ThreadManager.getFileThreadHandler().removeCallbacks(this.cv);
      meu.a().aOS();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ReadInJoyNewFeedsActivity", 1, "saveLeaveKanDianTab throw Exception.");
        localException.printStackTrace();
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.afq = paramIntent.getBooleanExtra("from_search", false);
    this.afr = paramIntent.getBooleanExtra("from_javascript", false);
    this.aIV = paramIntent.getIntExtra("launch_from", 5);
    pb(this.aIV);
    if ((this.leftView != null) && (this.aIV != 5)) {
      this.leftView.setText(getString(2131691039));
    }
    a(paramIntent.getIntExtra("target_fragment", 0), 258, paramIntent.getExtras(), false);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    AbstractGifImage.pauseAll();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.tG(3);
    nha.a(this).aWY();
    lbz.aJt();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.onPause();
    }
  }
  
  public void doOnResume()
  {
    odd.bU("KANDIAN_NEW_FEEDS_CREATE_TO_RESUME", null);
    odd.bU(null, "KANDIAN_NEW_FEEDS_RESUME");
    ldw.a().b(this);
    super.doOnResume();
    if (this.afu)
    {
      a(this.aJd, 257, null, false);
      this.afu = false;
    }
    boolean bool;
    if (this.aih == 0)
    {
      oW(0);
      if ((getIntent() != null) && (getIntent().getExtras() != null) && (getIntent().hasExtra("notification_message_id")))
      {
        String str = getIntent().getExtras().getString("notification_message_id", "");
        if ((!str.isEmpty()) && (kxm.nX() == 2) && (kxm.nZ() == 2)) {
          ((KandianMergeManager)this.app.getManager(162)).ap(2, str);
        }
        getIntent().removeExtra("notification_message_id");
        if ((kxm.nZ() == 1) || (kxm.nX() != 2)) {
          mf(str);
        }
      }
      aDk();
      if (this.afs) {
        break label300;
      }
      bool = true;
      label189:
      me(bool);
      aDn();
      aDo();
      if (!this.afs)
      {
        this.afs = true;
        odd.bU("KANDIAN_FEEDS_STAGE_1_COST", null);
      }
      AbstractGifImage.resumeAll();
      if (this.afv) {
        this.h.postDelayed(new ReadInJoyNewFeedsActivity.10(this), 1000L);
      }
      switch (this.aih)
      {
      default: 
        nha.a(this).aWY();
      }
    }
    for (;;)
    {
      odd.bU("KANDIAN_NEW_FEEDS_RESUME", null);
      return;
      oW(8);
      break;
      label300:
      bool = false;
      break label189;
      nha.a(this).di(0, 0);
      continue;
      nha.a(this).di(3, 56);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.startTimeMillis = System.currentTimeMillis();
    lbz.a().aJp();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    mzj.a().z(false, "readinjoy tab doOnStop");
    this.se = System.currentTimeMillis();
    this.sf += this.se - this.startTimeMillis;
    lbz.a().aJq();
  }
  
  public void f(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onKandianMsgNotification.");
    }
    aDn();
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void flingLToR()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.BT())) {
      onBackPressed();
    }
  }
  
  public void flingRToL() {}
  
  public void g(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onSubscribeMsgNotification.");
    }
    aDn();
  }
  
  public int getCurrentTab()
  {
    return this.aih;
  }
  
  public void initHeader()
  {
    this.rightViewImg.setOnClickListener(this);
    this.ds.setOnClickListener(this);
    findViewById(2131377363).setOnClickListener(this);
  }
  
  public void initUI()
  {
    odd.bU(null, "KANDIAN_NEW_FEEDS_INIT_UI");
    this.mFragmentManager = getSupportFragmentManager();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new ReadInJoyNewFeedsTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.setOnFlingGesture(this);
    }
    setContentView(2131560171);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar = ((ReadinjoyTabbar)findViewById(2131379165));
    this.mDivider = findViewById(2131379143);
    this.jD = findViewById(2131380010);
    aDq();
    aDl();
    initHeader();
    if (ThemeUtil.isInNightMode(this.app)) {
      aDj();
    }
    ldw.a().b(this);
    if ((this.leftView != null) && (this.aIV != 5)) {
      this.leftView.setText(getString(2131691039));
    }
    QQMessageFacade localQQMessageFacade = this.app.b();
    if (localQQMessageFacade != null) {
      oP(localQQMessageFacade.bl());
    }
    this.mRootLayout = ((FrameLayout)findViewById(2131366994));
    odd.bU("KANDIAN_NEW_FEEDS_INIT_UI", null);
    this.ib.setOnClickListener(this);
    try
    {
      this.jdField_a_of_type_Kgk = new kgk(this.mRootLayout, new ReadInJoyNavigationGridview(this, new a(this)), this.ib);
      this.jdField_a_of_type_Kgk.aID = getTitleBarHeight();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("ReadInJoyNewFeedsActivity", 1, "init ReadInJoyNavigationGridView Exception or Error.");
      localThrowable.printStackTrace();
    }
  }
  
  @TargetApi(23)
  public void lU(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public void md(boolean paramBoolean)
  {
    if (this.aih == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setTabState(0, paramBoolean);
    }
  }
  
  public void me(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(162));
    }
    SparseIntArray localSparseIntArray = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b();
    int i;
    label71:
    ReadinjoyTabbar localReadinjoyTabbar;
    if (!paramBoolean)
    {
      if (localSparseIntArray.get(0) > 0) {
        localSparseIntArray.put(0, 10);
      }
      localSparseIntArray.put(0, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.ol());
      localSparseIntArray.put(3, 0);
      i = 0;
      if (i >= 4) {
        return;
      }
      localReadinjoyTabbar = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar;
      if (((b)aS.get(Integer.valueOf(i))).aJi != 1) {
        break label132;
      }
    }
    label132:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localReadinjoyTabbar.c(i, paramBoolean, localSparseIntArray.get(i));
      i += 1;
      break label71;
      localSparseIntArray.put(0, 0);
      break;
    }
  }
  
  public void oP(int paramInt)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if ((this.aIV != 5) || (this.afq)) {
      localBoolean = Boolean.valueOf(false);
    }
    if (localBoolean.booleanValue()) {
      runOnUiThread(new ReadInJoyNewFeedsActivity.16(this, paramInt));
    }
  }
  
  public void oT(int paramInt)
  {
    this.aIW |= paramInt;
  }
  
  protected void oZ(int paramInt)
  {
    super.oY(paramInt);
  }
  
  public boolean onBackEvent()
  {
    if ((this.aih == 0) && (this.jdField_a_of_type_Kgk != null) && (this.jdField_a_of_type_Kgk.isShow()))
    {
      this.jdField_a_of_type_Kgk.a(null);
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.aih) != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.aih).c();
      if ((localObject instanceof ReadInJoyVideoChannelFragment))
      {
        localObject = ((ReadInJoyVideoChannelFragment)localObject).a();
        if ((localObject != null) && (((mye)localObject).a() != null) && (((mye)localObject).a().EV()))
        {
          ((mye)localObject).a().aUp();
          return true;
        }
      }
      else if (((localObject instanceof ReadInJoyRecommendFeedsFragment)) && (((ReadInJoyRecommendFeedsFragment)localObject).onBackPressed()))
      {
        return true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.onBackEvent())) {
      return true;
    }
    if ((!awit.aMG()) && (getIntent() != null) && (getIntent().getBooleanExtra("from_lock_screen", false)))
    {
      neq.ci(this);
      return true;
    }
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
      if ((this.aih == 2) && (kxm.AP()))
      {
        kxm.a(this, this.vg);
        kbp.a(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", kxm.iS(), false);
      }
      else
      {
        kxm.aH(this);
        amub.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("clk_search"));
        continue;
        if ((this.aih == 0) && (this.jdField_a_of_type_Kgk != null))
        {
          if (this.jdField_a_of_type_Kgk.isShow()) {
            this.jdField_a_of_type_Kgk.a(null);
          } else if ((a() instanceof ReadInJoySubChannelFragment)) {
            this.jdField_a_of_type_Kgk.show(a().nh());
          } else {
            this.jdField_a_of_type_Kgk.show(0);
          }
        }
        else
        {
          try
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.aih).c().aIp();
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            QLog.d("ReadInJoyNewFeedsActivity", 1, "notifyTitleClick failed.");
          }
          continue;
          a().aIq();
          ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.14(this));
        }
      }
    }
  }
  
  public void pa(int paramInt)
  {
    if (aqfo.aCb())
    {
      oX(((b)aS.get(Integer.valueOf(paramInt))).aJb);
      mfj localmfj = ((mfs)this.app.getManager(261)).a(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setSelectColor(localmfj.getColor());
      return;
    }
    ThreadManager.post(new ReadInJoyNewFeedsActivity.13(this, paramInt), 5, null, false);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((!this.afq) && (!this.afr) && ((paramObject instanceof MessageRecord)) && (KandianMergeManager.a((MessageRecord)paramObject, this.app) == -1) && (((MessageRecord)paramObject).extInt != 5) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      aQ();
    }
  }
  
  public boolean zt()
  {
    return this.aIW != 0;
  }
  
  class MyRunnable
    implements Runnable
  {
    private WeakReference<ReadInJoyNewFeedsActivity> mWeakReference;
    
    public MyRunnable(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity)
    {
      this.mWeakReference = new WeakReference(paramReadInJoyNewFeedsActivity);
    }
    
    public void run()
    {
      if (WebProcessManager.aFS()) {}
      for (;;)
      {
        return;
        WebProcessManager localWebProcessManager;
        int i;
        if ((this.mWeakReference != null) && (this.mWeakReference.get() != null))
        {
          localWebProcessManager = (WebProcessManager)((ReadInJoyNewFeedsActivity)this.mWeakReference.get()).app.getManager(13);
          if (localWebProcessManager != null)
          {
            i = kxm.nS();
            if (!kxm.AO()) {}
          }
        }
        try
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
          localHashMap.put("param_totalMem", String.valueOf(aqgz.getSystemTotalMemory()));
          localHashMap.put("param_availableMem", String.valueOf(aqgz.getSystemAvaialbeMemory()));
          localHashMap.put("param_cpuNum", String.valueOf(aqgz.getCpuNumber()));
          localHashMap.put("param_cpuFreq", String.valueOf(aqgz.getCpuFrequency()));
          localHashMap.put("param_preloadLevel", String.valueOf(i));
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyNewFeedsActivity", 2, "preloadToolProcessReport:" + localHashMap.toString());
          }
          anpc.a(ReadInJoyNewFeedsActivity.this).collectPerformance(ReadInJoyNewFeedsActivity.this.app.getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
        }
        catch (Exception localException)
        {
          label206:
          break label206;
        }
        if (i == 1) {
          localWebProcessManager.Yc(200);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("ReadInJoyNewFeedsActivity", 2, "enter folder preload web process");
          return;
          if (i == 2) {
            localWebProcessManager.Yc(201);
          }
        }
      }
    }
  }
  
  static class a
    implements ReadInJoyNavigationGridview.b
  {
    private WeakReference<ReadInJoyNewBaseActivity> mActivity;
    
    a(ReadInJoyNewBaseActivity paramReadInJoyNewBaseActivity)
    {
      this.mActivity = new WeakReference(paramReadInJoyNewBaseActivity);
    }
    
    public void aDt()
    {
      ReadInJoyNewFeedsActivity localReadInJoyNewFeedsActivity = (ReadInJoyNewFeedsActivity)this.mActivity.get();
      if (localReadInJoyNewFeedsActivity == null) {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNewFeedsActivity", 2, "NaviMaskTouchListenerImpl. activity has destoryed");
        }
      }
      while ((ReadInJoyNewFeedsActivity.a(localReadInJoyNewFeedsActivity) != 0) || (localReadInJoyNewFeedsActivity.a == null)) {
        return;
      }
      localReadInJoyNewFeedsActivity.a.a(null);
    }
  }
  
  public static class b
  {
    public String Zr;
    public int aJb;
    public int aJi;
    public int aJj;
    public int mDividerColor;
    
    public b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.Zr = paramString;
      this.aJi = paramInt1;
      this.aJb = paramInt2;
      this.aJj = paramInt3;
      this.mDividerColor = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity
 * JD-Core Version:    0.7.0.1
 */