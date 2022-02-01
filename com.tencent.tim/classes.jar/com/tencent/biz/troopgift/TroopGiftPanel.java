package com.tencent.biz.troopgift;

import abmt;
import acfp;
import acie;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aofe;
import apsz;
import apsz.a;
import apsz.b;
import aqdj;
import aqha;
import aqho;
import aqhu;
import aqju;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityLandscape;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.InputMethodLinearLayout.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jlk;
import jof;
import sna.b;
import snb;
import snb.a;
import snd;
import snd.a;
import sne;
import snf;
import snf.a;
import snf.b;
import snf.c;
import snf.d;
import snf.e;
import sng;
import snh;
import sni;
import snj;
import snk;
import snl;
import snm;
import snn;
import sno;
import snp;
import snq;
import snr;
import sns;
import snt;
import snu;
import snv;
import snw;
import snx;
import sny;
import snz;
import soa;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;
import tgc;
import tgc.b;
import tgg;
import tgk;
import tgl;
import tis;
import tkv;
import tkw;
import tls;
import yam;

public class TroopGiftPanel
  extends LinearLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener, TabBarView.a
{
  private static boolean aMm;
  public static int byj;
  public static int byk = 1;
  public static int byl = byk;
  public static int bym = byl + 1;
  public static int byn = byj;
  public static int byo = byl;
  protected TextView AL;
  public TextView AM;
  public TextView AN;
  protected TextView AO;
  protected TextView AP;
  private long CY;
  private a jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$a;
  public f a;
  private com.tencent.gdtad.api.GdtAd jdField_a_of_type_ComTencentGdtadApiGdtAd;
  private GdtMotiveVideoAd jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoAd;
  public snd a;
  public snf a;
  public GridListViewPager[] a;
  public String aFc = acfp.m(2131715771);
  protected String aFd = "OidbSvc.0x6c3";
  public String aFe = "0";
  protected String aFf;
  protected String aFg = "";
  private String aFh = acfp.m(2131715776);
  private String aFi = "看广告0元送";
  public String aFj;
  protected String aFk;
  protected boolean aMi;
  public boolean aMj;
  protected boolean aMk = true;
  private boolean aMl;
  public int asi;
  protected int byp = 1731;
  public int byq;
  public int byr;
  public sne c;
  public Button cG;
  protected View.OnClickListener cO = new snu(this);
  public WeakReference<BaseChatPie> dq;
  protected HorizontalListView j;
  public Context mContext;
  public int mCurrentTab;
  protected boolean mIsShow;
  protected View mLoadingView;
  public WeakReference<AppInterface> n;
  protected ImageView oy;
  protected ImageView oz;
  public View[] q;
  protected View qo;
  protected View qp;
  protected View qq;
  public View qr;
  protected View qs;
  protected View qt;
  protected View qu;
  public View qv;
  private View qw;
  private View qx;
  protected SessionInfo sessionInfo;
  
  public TroopGiftPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.asi = 1;
  }
  
  public TroopGiftPanel(Context paramContext, f paramf)
  {
    this(paramContext, paramf, true);
  }
  
  public TroopGiftPanel(Context paramContext, f paramf, boolean paramBoolean)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.aMj = paramBoolean;
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$f = paramf;
    this.aFc = acfp.m(2131715761);
    this.asi = 1;
  }
  
  public TroopGiftPanel(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this(paramContext, paramBaseChatPie, 1, 0);
  }
  
  public TroopGiftPanel(Context paramContext, BaseChatPie paramBaseChatPie, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.dq = new WeakReference(paramBaseChatPie);
    this.asi = paramInt1;
    this.byr = paramInt2;
    if ((paramInt2 == 2) || (paramInt2 == 7)) {
      this.aFc = acfp.m(2131715753);
    }
  }
  
  private boolean Nc()
  {
    return (this.c != null) && (this.jdField_a_of_type_Snf.on != null) && (this.jdField_a_of_type_Snf.bh.size() > 0) && (this.jdField_a_of_type_Snf.on.size() > 0);
  }
  
  public static GdtHandler.Params a(boolean paramBoolean, Activity paramActivity)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.processId = 1;
    localParams.activity = new WeakReference(paramActivity);
    localParams.reportForClick = paramBoolean;
    return localParams;
  }
  
  private GdtMotiveVideoPageData a(int paramInt1, com.tencent.gdtad.api.GdtAd paramGdtAd, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = null;
    if ((paramGdtAd == null) || (!paramGdtAd.isLoaded()) || (paramGdtAd.isInvalidated()) || (!(paramGdtAd instanceof GdtMotiveVideoAd)))
    {
      QLog.i("TroopGiftPanel", 1, String.format("mockMVPageData null %d", new Object[] { Integer.valueOf(paramInt1) }) + paramInt2);
      QQToast.a(getActivity(), acfp.m(2131715759), 0).show();
      return null;
    }
    Object localObject2 = (GdtMotiveVideoAd)paramGdtAd;
    com.tencent.gdtad.aditem.GdtAd localGdtAd = ((GdtMotiveVideoAd)localObject2).getAd();
    if (localGdtAd != null)
    {
      GdtMotiveVideoPageData localGdtMotiveVideoPageData = new GdtMotiveVideoPageData();
      localGdtMotiveVideoPageData.productType = localGdtAd.getProductType();
      if (paramBoolean) {
        paramInt1 = localGdtAd.getCreativeSize();
      }
      localGdtMotiveVideoPageData.vSize = paramInt1;
      localGdtMotiveVideoPageData.screenOrientation = paramInt2;
      localGdtMotiveVideoPageData.adId = localGdtAd.getAdvertiserId();
      localGdtMotiveVideoPageData.vid = localGdtAd.getTencent_video_id();
      localGdtMotiveVideoPageData.url = localGdtAd.getVideoUrl();
      tkw.e("TroopGiftPanel", "VideoUrl " + localGdtMotiveVideoPageData.url);
      if ((!TextUtils.isEmpty(localGdtMotiveVideoPageData.url)) && (localGdtMotiveVideoPageData.url.startsWith("https://"))) {
        localGdtMotiveVideoPageData.url = localGdtMotiveVideoPageData.url.replaceFirst("https://", "http://");
      }
      if (localGdtAd.getImageData() == null)
      {
        paramGdtAd = "";
        localGdtMotiveVideoPageData.previewImgUrl = paramGdtAd;
        localGdtMotiveVideoPageData.bannerImgName = localGdtAd.getAdvertiser_corporate_image_name();
        localGdtMotiveVideoPageData.bannerBaseInfoText = localGdtAd.getText();
        localGdtMotiveVideoPageData.bannerLogo = localGdtAd.getAdvertiser_corporate_logo();
        localGdtMotiveVideoPageData.exposureUrl = localGdtAd.getUrlForImpression();
        localGdtMotiveVideoPageData.appScore = Double.valueOf(localGdtAd.getAppScore()).doubleValue();
        localGdtMotiveVideoPageData.downloadNum = localGdtAd.getAppDownloadNum();
        localGdtMotiveVideoPageData.style = localGdtAd.getStyle();
        localObject2 = ((GdtMotiveVideoAd)localObject2).getGdtAdLoader();
        paramGdtAd = localObject1;
        if (localObject2 != null)
        {
          paramGdtAd = localObject1;
          if (((tgc)localObject2).a() != null)
          {
            paramGdtAd = localObject1;
            if (((tgc)localObject2).a().a != null)
            {
              localObject2 = ((tgc)localObject2).a().a.pos_ads_info.get();
              paramGdtAd = localObject1;
              if (localObject2 != null)
              {
                paramGdtAd = localObject1;
                if (((List)localObject2).size() > 0)
                {
                  localObject2 = (qq_ad_get.QQAdGetRsp.PosAdInfo)((List)localObject2).get(0);
                  paramGdtAd = localObject1;
                  if (localObject2 != null)
                  {
                    paramGdtAd = localObject1;
                    if (((qq_ad_get.QQAdGetRsp.PosAdInfo)localObject2).ads_info != null)
                    {
                      localObject2 = ((qq_ad_get.QQAdGetRsp.PosAdInfo)localObject2).ads_info.get();
                      paramGdtAd = localObject1;
                      if (localObject2 != null)
                      {
                        paramGdtAd = localObject1;
                        if (((List)localObject2).size() > 0) {
                          paramGdtAd = tkv.pbToJson((qq_ad_get.QQAdGetRsp.AdInfo)((List)localObject2).get(0));
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        if (paramGdtAd != null) {
          break label544;
        }
      }
      label544:
      for (paramGdtAd = "";; paramGdtAd = paramGdtAd.toString())
      {
        localGdtMotiveVideoPageData.adsContent = paramGdtAd;
        localGdtMotiveVideoPageData.processId = BaseApplicationImpl.sProcessId;
        localGdtMotiveVideoPageData.refId = "biz_src_hdsp_liwu";
        return localGdtMotiveVideoPageData;
        paramGdtAd = localGdtAd.getImageData().url;
        break;
      }
    }
    return null;
  }
  
  public static qq_ad_get.QQAdGet a(long paramLong, String paramString)
  {
    Object localObject = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject).deep_link_version.set(1);
    qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
    localPositionInfo.pos_id.set(paramString);
    localPositionInfo.ad_count.set(1);
    localPositionInfo.pos_ext.set((MessageMicro)localObject);
    paramString = new qq_ad_get.QQAdGet.UserInfo();
    paramString.qq.set(paramLong);
    localObject = new qq_ad_get.QQAdGet();
    ((qq_ad_get.QQAdGet)localObject).position_info.add(localPositionInfo);
    ((qq_ad_get.QQAdGet)localObject).user_info.set(paramString);
    return localObject;
  }
  
  private void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if ((paramActivity == null) || (paramGdtMotiveVideoPageData == null) || (!tls.fp(paramGdtMotiveVideoPageData.vSize))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("data", paramGdtMotiveVideoPageData);
    localBundle.putString("big_brother_ref_source_key", paramGdtMotiveVideoPageData.refId);
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    localIntent.putExtras(localBundle);
    if (paramGdtMotiveVideoPageData.screenOrientation == 0) {}
    for (paramGdtMotiveVideoPageData = PublicFragmentActivityLandscape.class;; paramGdtMotiveVideoPageData = PublicFragmentActivity.class)
    {
      PublicFragmentActivity.b.startForResult(paramActivity, localIntent, paramGdtMotiveVideoPageData, paramClass, 12008);
      return;
    }
  }
  
  private void a(sne paramsne)
  {
    if (paramsne != null)
    {
      if (paramsne.bxX == 0)
      {
        yF(0);
        if (this.asi >= 4)
        {
          acie.i("gift_store", "exp_chose", nD(), um() + "", "", "");
          return;
        }
        if (jof.a().dd(nD())) {}
        for (int i = 2;; i = 1)
        {
          anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", i, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
          return;
        }
      }
      yF(8);
      return;
    }
    yF(8);
  }
  
  private void bzB()
  {
    tt(this.aFg);
  }
  
  private void bzC()
  {
    if (this.jdField_a_of_type_Snf == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Snf.byg = 0;
      if ((this.jdField_a_of_type_Snf.ok != null) && (this.jdField_a_of_type_Snf.ok.size() == byl) && (this.mCurrentTab >= 0) && (this.mCurrentTab < byl))
      {
        snf.d locald = (snf.d)this.jdField_a_of_type_Snf.ok.get(this.mCurrentTab);
        if (locald.or != null)
        {
          int i = 0;
          if (i < locald.or.size())
          {
            sne localsne = (sne)locald.or.get(i);
            if (i == 0) {}
            for (boolean bool = true;; bool = false)
            {
              localsne.mSelected = bool;
              i += 1;
              break;
            }
          }
        }
      }
    } while ((this.mCurrentTab < 0) || (this.mCurrentTab >= this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.length) || (this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[this.mCurrentTab].getAdapter() == null));
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[this.mCurrentTab].refreshUI();
  }
  
  private void bzD()
  {
    tis localtis = new tis();
    localtis.b = a(Long.parseLong(abmt.getAppInterface().getCurrentAccountUin()), "4040385433442243");
    localtis.c = a(true, getActivity());
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoAd = new GdtMotiveVideoAd(localtis);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoAd.setListener(new WeakReference(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$a));
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoAd.load(getActivity());
  }
  
  private void bzy()
  {
    if (this.qw != null) {
      this.qw.setSelected(false);
    }
    if (this.qx != null) {
      this.qx.setSelected(false);
    }
  }
  
  private void cC(ArrayList<snf.e> paramArrayList)
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131382165);
    localViewGroup.removeAllViews();
    localViewGroup.setBackgroundColor(0);
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    int i;
    Object localObject1;
    for (;;)
    {
      return;
      i = 0;
      while (i < paramArrayList.size())
      {
        localObject1 = (snf.e)paramArrayList.get(i);
        if ((localObject1 != null) && (((snf.e)localObject1).width > 0) && (((snf.e)localObject1).height > 0) && (((snf.e)localObject1).icon.length() != 0) && (((snf.e)localObject1).jumpUrl.length() != 0)) {
          break label105;
        }
        i += 1;
      }
    }
    label105:
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject3 = getContext();
    if (i == paramArrayList.size() - 1) {}
    for (float f = 10.0F;; f = 6.0F)
    {
      localRelativeLayout.setPadding(0, 0, (int)aqho.convertDpToPixel((Context)localObject3, f), 0);
      localViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject2);
      localObject3 = new LinearLayout.LayoutParams((int)aqho.convertDpToPixel(getContext(), ((snf.e)localObject1).width), (int)aqho.convertDpToPixel(getContext(), ((snf.e)localObject1).height));
      localObject2 = new ImageView(getContext());
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      ((ImageView)localObject2).setBackgroundDrawable(URLDrawable.getDrawable(((snf.e)localObject1).icon, URLDrawable.URLDrawableOptions.obtain()));
      localObject1 = new snt(this, (snf.e)localObject1);
      localRelativeLayout.setOnClickListener((View.OnClickListener)localObject1);
      ((ImageView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
      break;
    }
  }
  
  public static void eH(int paramInt1, int paramInt2)
  {
    anot.a(null, "dc00899", "grp_lbs", "", "qq_gift", "aio_pv", 0, 0, paramInt2 + "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "reportPlusPanelEntryExp, pageIdx=" + paramInt1 + ", aioType=" + paramInt2);
    }
  }
  
  private void tt(String paramString)
  {
    paramString = gI(paramString);
    Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
    localIntent.putExtra("selfSet_leftViewText", acfp.m(2131715757));
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    this.mContext.startActivity(localIntent);
    ((Activity)this.mContext).overridePendingTransition(2130772009, 2130772082);
    if (this.byr == 2) {
      anot.a(null, "dc00899", "Grp_flower", "", "C2C", "Clk_opr", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftPanel", 2, "onJumpAction, url=" + paramString);
      }
      yG(1);
      return;
      if (this.byr == 6)
      {
        anot.a(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_opr", 0, 0, "", "", "", "");
      }
      else if (this.byr == 7)
      {
        anot.a(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_opr", 0, 0, "", "", "", "");
      }
      else
      {
        if (this.asi < 4) {
          break;
        }
        acie.i("clk_oper", "clk_oper", nD(), um() + "", "", "");
      }
    }
    if (jof.a().dd(nD())) {}
    for (int i = 2;; i = 1)
    {
      anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_opr", i, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
      break;
    }
  }
  
  private void uT(boolean paramBoolean)
  {
    if (this.qw == null) {
      return;
    }
    bzy();
    ((TextView)this.qw.findViewById(2131380735)).setText(acfp.m(2131715752));
    this.qw.setContentDescription(acfp.m(2131715756));
    ((TextView)this.qw.findViewById(2131380735)).setTextColor(Color.parseColor("#ff878b99"));
    ((TextView)this.qx.findViewById(2131380734)).setText(acfp.m(2131715767));
    this.qx.setContentDescription(acfp.m(2131715763));
    ((TextView)this.qx.findViewById(2131380734)).setTextColor(Color.parseColor("#ff878b99"));
    this.qw.findViewById(2131381919).setVisibility(8);
    this.qx.findViewById(2131381927).setVisibility(8);
    this.qw.setOnClickListener(new snr(this));
    this.qx.setOnClickListener(new sns(this));
  }
  
  public boolean MZ()
  {
    return true;
  }
  
  public boolean Na()
  {
    return true;
  }
  
  public boolean Nb()
  {
    return (this.byr != 2) && (this.byr != 7) && (this.byr != 3);
  }
  
  protected void a(View paramView1, View paramView2, View paramView3)
  {
    if (Nb())
    {
      paramView1.findViewById(2131372829).setVisibility(0);
      this.qr.setVisibility(0);
      paramView2.findViewById(2131372829).setVisibility(0);
      paramView2.findViewById(2131373796).setVisibility(0);
      paramView3.findViewById(2131372829).setVisibility(0);
      this.qt.setVisibility(0);
      paramView1 = findViewById(2131363405);
      paramView2 = paramView1.getLayoutParams();
      paramView2.height = ((int)aqho.convertDpToPixel(getContext(), 400.0F));
      paramView1.setLayoutParams(paramView2);
      paramView1 = (AppInterface)this.n.get();
      paramView2 = nD();
      paramView3 = snf.gH(paramView2);
      if ((paramView1 != null) && (!TextUtils.isEmpty(paramView3)) && (!TextUtils.isEmpty(paramView2)) && ((paramView1 instanceof QQAppInterface))) {
        ThreadManagerV2.excute(new TroopGiftPanel.6(this, paramView1, paramView2, paramView3, new Handler(Looper.getMainLooper())), 16, null, true);
      }
    }
  }
  
  public void a(d paramd)
  {
    QLog.d("TroopGiftPanel", 1, "getGiftStorage, callback=" + paramd);
    Object localObject = (AppInterface)this.n.get();
    if (localObject == null) {
      return;
    }
    localObject = (apsz)((AppInterface)localObject).getManager(113);
    String str1 = this.aFd;
    int k = this.byp;
    int m = this.asi;
    String str2 = nD();
    if (this.asi >= 4) {}
    for (int i = 2;; i = 0)
    {
      ((apsz)localObject).a(str1, k, m, str2, 2, i, new snw(this, paramd));
      return;
    }
  }
  
  public void a(e parame)
  {
    QLog.d("TroopGiftPanel", 1, "getPackGiftStorage, callback=" + parame);
    AppInterface localAppInterface = (AppInterface)this.n.get();
    if (localAppInterface == null) {
      return;
    }
    ((apsz)localAppInterface.getManager(113)).b(new snq(this, parame));
  }
  
  public void a(AppInterface paramAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    buQ();
    this.n = new WeakReference(paramAppInterface);
    this.sessionInfo = paramSessionInfo;
    this.mLoadingView = findViewById(2131370787);
    this.qp = findViewById(2131365385);
    this.j = ((HorizontalListView)findViewById(2131379133));
    this.jdField_a_of_type_Snd = new snd();
    this.j.setAdapter(this.jdField_a_of_type_Snd);
    this.qw = findViewById(2131370677);
    this.qx = findViewById(2131370678);
    uT(paramBoolean);
    uS(paramBoolean);
    this.cG = ((Button)findViewById(2131363993));
    this.qq = findViewById(2131363994);
    this.cG.setOnClickListener(this);
    this.qq.setOnClickListener(this);
    this.cG.setText(this.aFc);
    this.AL = ((TextView)findViewById(2131366283));
    this.AL.setOnClickListener(this);
    this.qo = findViewById(2131363674);
    this.qo.setOnClickListener(this);
    this.AM = ((TextView)findViewById(2131378783));
    this.AN = ((TextView)findViewById(2131368066));
    this.AM.setOnClickListener(this);
    findViewById(2131377027).setOnClickListener(this);
    findViewById(2131363405).setOnClickListener(this);
    this.j.setOnItemClickListener(new sng(this));
    bzy();
    this.jdField_a_of_type_Snd.setSelectedTab(this.mCurrentTab);
    yE(this.mCurrentTab);
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$a = new a();
    bzD();
  }
  
  protected boolean a(int paramInt, apsz.a parama)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.byq < paramInt) {
      if (parama != null)
      {
        bool1 = bool2;
        if (parama.count + parama.dVN != 0) {}
      }
      else
      {
        if (!jof.a().dd(nD())) {
          break label122;
        }
      }
    }
    label122:
    for (paramInt = 2;; paramInt = 1)
    {
      parama = this.mContext.getResources();
      aqha.a(this.mContext, 230, parama.getString(2131699967), parama.getString(2131699966), parama.getString(2131721058), parama.getString(2131699969), new sno(this, paramInt), new snp(this)).show();
      bzG();
      bool1 = false;
      return bool1;
    }
  }
  
  public void buQ()
  {
    inflate(getContext(), 2131560804, this);
  }
  
  public void bzA()
  {
    Object localObject = this.jdField_a_of_type_Snf.jdField_a_of_type_Snf$a.jumpUrl + "?_bid=3913&_wvSb=1&from=7&troopUin=%s";
    if (this.sessionInfo.troopUin != null) {}
    for (String str = this.sessionInfo.troopUin;; str = this.sessionInfo.aTl)
    {
      str = String.format((String)localObject, new Object[] { str });
      localObject = new Intent(this.mContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("selfSet_leftViewText", acfp.m(2131715768));
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("url", gI(str));
      this.mContext.startActivity((Intent)localObject);
      ((Activity)this.mContext).overridePendingTransition(2130772009, 0);
      return;
    }
  }
  
  public void bzE()
  {
    Intent localIntent;
    if (this.byr == 6)
    {
      localIntent = TroopMemberListActivity.c(BaseApplication.getContext(), this.sessionInfo.aTl, 16);
      localIntent.putExtra("param_is_pop_up_style", true);
      localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131699958));
      localIntent.setFlags(603979776);
      ((Activity)this.mContext).startActivityForResult(localIntent, 12006);
    }
    do
    {
      return;
      localIntent = TroopMemberListActivity.c(BaseApplication.getContext(), nD(), 14);
      localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131699958));
      if (this.n.get() != null) {
        localIntent.putExtra("troop_gift_from", ((AppInterface)this.n.get()).getCurrentAccountUin());
      }
    } while (this.aMj);
    ((Activity)this.mContext).startActivityForResult(localIntent, 12006);
  }
  
  public void bzF()
  {
    if ((this.qs != null) && (this.qr != null))
    {
      this.qs.setVisibility(8);
      this.qr.setVisibility(0);
    }
  }
  
  public void bzG()
  {
    if (jof.a().dd(nD())) {}
    for (int i = 2; this.byr == 2; i = 1)
    {
      anot.a(null, "dc00899", "Grp_flower", "", "C2C", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.byr == 6)
    {
      anot.a(null, "dc00899", "Grp_flower", "", "discuss_grp", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.byr == 7)
    {
      anot.a(null, "dc00899", "Grp_flower", "", "temp_c2c", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.asi >= 4)
    {
      acie.i("gift_store", "exp_tip", nD(), um() + "", "", "");
      return;
    }
    anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_payremind", i, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
  }
  
  public void bzz()
  {
    AppInterface localAppInterface = (AppInterface)this.n.get();
    String str1 = nD();
    String str2 = snf.gH(str1);
    if ((localAppInterface != null) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && ((localAppInterface instanceof QQAppInterface)))
    {
      ThreadManagerV2.excute(new TroopGiftPanel.5(this, localAppInterface, str1, str2, new Handler(Looper.getMainLooper())), 16, null, true);
      return;
    }
    QLog.e("TroopGiftPanel", 1, "NoSelectGiftReceiver! last receiver is not in troop, troopUin=" + str1 + ", memberUin=" + str2);
    snf.cO(str1, "");
    bzF();
  }
  
  public void cP(String paramString1, String paramString2)
  {
    boolean bool = true;
    QLog.i("TroopGiftPanel", 1, "onSelectGiftReceiver, uin=" + paramString1 + ", displayName=" + paramString2);
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!paramString1.equals(this.aFj)) {
        snf.cO(nD(), paramString1);
      }
      this.aFj = paramString1;
      this.aFk = paramString2;
      this.qs.setVisibility(0);
      this.qr.setVisibility(8);
      paramString2 = new aofe(this.aFk, 16).k();
      this.AO.setText(paramString2);
      this.qu.setVisibility(0);
      this.qt.setVisibility(8);
      paramString2 = new aofe(this.aFk, 16).k();
      this.AP.setText(paramString2);
      paramString2 = aqhu.aU();
      AppInterface localAppInterface = (AppInterface)this.n.get();
      if (localAppInterface != null)
      {
        paramString1 = aqdj.a(localAppInterface, 1, paramString1, 3, paramString2, paramString2);
        this.oy.setImageDrawable(paramString1);
        this.oz.setImageDrawable(paramString1);
      }
    }
    else
    {
      if (TextUtils.isEmpty(this.aFj)) {
        break label248;
      }
    }
    for (;;)
    {
      setSendGiftBtnEnabled(bool);
      return;
      this.oy.setImageDrawable(paramString2);
      this.oz.setImageDrawable(paramString2);
      break;
      label248:
      bool = false;
    }
  }
  
  protected void d(TextView paramTextView, String paramString)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftPanel", 2, "setLeftCoinDrawable param illegal");
      }
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    paramString.setDownloadListener(new snv(this, paramTextView));
    paramString.setBounds(0, 0, (int)aqho.convertDpToPixel(this.mContext, 13.0F), (int)aqho.convertDpToPixel(this.mContext, 14.0F));
    paramTextView.setCompoundDrawables(paramString, null, null, null);
    paramTextView.setCompoundDrawablePadding((int)aqho.convertDpToPixel(this.mContext, 2.0F));
    paramString.startDownload();
  }
  
  public void e(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    QLog.i("TroopGiftPanel", 1, "watch gdt mv result, 广告总时长: " + paramLong1 + " 观看时长: " + paramLong2 + " 可以送免费礼物： " + paramBoolean);
    if (paramBoolean)
    {
      this.cG.setText(this.aFh);
      aMm = true;
    }
    bzD();
  }
  
  public String gI(String paramString)
  {
    if ((paramString == null) || (this.n == null) || (this.sessionInfo == null)) {}
    AppInterface localAppInterface;
    do
    {
      do
      {
        return paramString;
      } while ((this.byr == 2) || (this.byr == 7));
      localAppInterface = (AppInterface)this.n.get();
    } while (localAppInterface == null);
    Object localObject = (TroopManager)localAppInterface.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).c(nD());
      if (localObject != null) {
        if (((TroopInfo)localObject).isTroopOwner(localAppInterface.getCurrentAccountUin())) {
          localObject = "0";
        }
      }
    }
    for (;;)
    {
      return paramString.replace("$GCODE$", nD()).replace("$CLIENTVER$", "android3.4.4").replace("$UIN$", localAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$ROLE$", (CharSequence)localObject);
      if (((TroopInfo)localObject).isAdmin())
      {
        localObject = "1";
      }
      else
      {
        localObject = "2";
        continue;
        localObject = "2";
      }
    }
  }
  
  public Activity getActivity()
  {
    return (Activity)this.mContext;
  }
  
  public boolean isShow()
  {
    return this.mIsShow;
  }
  
  public String nD()
  {
    if (this.byr == 2) {
      return null;
    }
    if (this.byr == 7) {
      return this.sessionInfo.troopUin;
    }
    return this.sessionInfo.aTl;
  }
  
  public void onClick(View paramView)
  {
    int k;
    if (jof.a().dd(nD())) {
      k = 2;
    }
    label170:
    int i;
    switch (paramView.getId())
    {
    case 2131363674: 
    default: 
    case 2131363993: 
    case 2131377027: 
    case 2131363909: 
    case 2131370233: 
    case 2131366283: 
    case 2131366284: 
    case 2131378015: 
      label1280:
      label1546:
      label2314:
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        k = 1;
        break;
        label201:
        Object localObject4;
        Object localObject3;
        label300:
        int i1;
        Object localObject1;
        int i2;
        if (byl == this.mCurrentTab) {
          if (this.asi >= 4)
          {
            acie.i("gift_store", "clk_now", nD(), um() + "", "", "");
            m = 0;
            i = m;
            if (this.c != null)
            {
              if (this.c.giftId <= 0) {
                break label849;
              }
              i = this.c.giftId;
            }
            anot.a(null, "dc00899", "grp_lbs", "", "qq_gift", "giftsend_click", 0, 0, String.valueOf(i), "", "", "");
            localObject4 = (AppInterface)this.n.get();
            if ((localObject4 == null) || (this.c == null)) {
              continue;
            }
            localObject3 = this.c;
            i = ((sne)localObject3).bxX;
            if (((sne)localObject3).bxX == 0) {
              i = un();
            }
            if ((this.mCurrentTab != bym) || (!this.c.aMh)) {
              break label873;
            }
            if (byl != this.mCurrentTab) {
              break label1064;
            }
            localObject4 = (apsz)((AppInterface)localObject4).getManager(113);
            if (!((sne)localObject3).aMf) {
              break label971;
            }
            i1 = this.asi;
            localObject1 = nD();
            i2 = ((sne)localObject3).bxY;
            if (((sne)localObject3).bxX != 0) {
              break label965;
            }
          }
        }
        label965:
        for (int m = 1;; m = 0)
        {
          ((apsz)localObject4).a("OidbSvc.0x6b6", 1718, 8, i1, (String)localObject1, 2, i, 0L, i2, m, ((sne)localObject3).bxW, 0, new snj(this, k, (sne)localObject3), ((sne)localObject3).giftId);
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$f == null) {
            break label1546;
          }
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$f.onHide();
          break;
          anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forall_send", k, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
          break label170;
          if ((this.mCurrentTab < 0) || (this.mCurrentTab >= byl)) {
            break label170;
          }
          if (this.byr == 2)
          {
            anot.a(null, "dc00899", "Grp_flower", "", "C2C", "Clk_send", 0, 0, "", "", "", "");
            break label170;
          }
          if (this.byr == 6)
          {
            anot.a(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_send", 0, 0, "", "", "", "");
            break label170;
          }
          if (this.byr == 7)
          {
            anot.a(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_send", 0, 0, "", "", "", "");
            break label170;
          }
          if (this.asi >= 4)
          {
            acie.i("gift_store", "clk_send", nD(), um() + "", "", "");
            break label170;
          }
          anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forone_send", k, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
          anot.a(null, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_addpage", k, 0, nD(), "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()), "", "");
          break label170;
          label849:
          i = m;
          if (this.c.bxW <= 0) {
            break label201;
          }
          i = this.c.bxW;
          break label201;
          label873:
          boolean bool = this.jdField_a_of_type_Snf.fm(this.mCurrentTab);
          localObject1 = this.jdField_a_of_type_Snf.bg;
          if (((sne)localObject3).giftId != 0) {}
          for (m = ((sne)localObject3).giftId;; m = ((sne)localObject3).bxW)
          {
            localObject1 = (apsz.a)((SparseArray)localObject1).get(m);
            if ((bool) || (a(i, (apsz.a)localObject1))) {
              break label300;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("TroopGiftPanel", 2, "isStorageEnough: false");
            break;
          }
        }
        label971:
        if (this.aMi)
        {
          k = 3;
          label980:
          if (!this.aMi) {
            break label1048;
          }
          localObject1 = "OidbSvc.0x7f6";
          label992:
          if (!this.aMi) {
            break label1056;
          }
        }
        label1048:
        label1056:
        for (m = 2038;; m = 1718)
        {
          ((apsz)localObject4).a((String)localObject1, m, k, this.asi, nD(), 2, i, 1, ((sne)localObject3).bxW, new snk(this, (sne)localObject3));
          break;
          k = 1;
          break label980;
          localObject1 = "OidbSvc.0x6b6";
          break label992;
        }
        label1064:
        if ((this.mCurrentTab >= 0) && (this.mCurrentTab < byl))
        {
          if (this.aMj)
          {
            localObject1 = this.aFf;
            continue;
          }
          if ((this.byr == 2) || (this.byr == 7)) {}
          for (localObject1 = ((BaseChatPie)this.dq.get()).sessionInfo.aTl;; localObject1 = this.aFj)
          {
            long l1 = 0L;
            try
            {
              long l2 = Long.valueOf((String)localObject1).longValue();
              l1 = l2;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.e("TroopGiftPanel", 1, "toUinStr to uin err");
                continue;
                if (this.byr == 2) {
                  i = 7;
                } else if (this.byr == 6) {
                  i = 8;
                }
              }
              localObject2 = a(0, this.jdField_a_of_type_ComTencentGdtadApiGdtAd, 1, true);
              a(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject2);
            }
            i = 1;
            if (!jof.a().dd(this.sessionInfo.aTl)) {
              break label1280;
            }
            i = 4;
            if ((this.jdField_a_of_type_Snf == null) || (!this.jdField_a_of_type_Snf.fm(this.mCurrentTab))) {
              break label1338;
            }
            if (System.currentTimeMillis() - this.CY < 500L) {
              break;
            }
            this.CY = System.currentTimeMillis();
            if (!aMm) {
              break label1309;
            }
            aMm = false;
            ((apsz)((AppInterface)localObject4).getManager(113)).a(this.c, i, nD(), l1, new snl(this));
            break;
          }
          continue;
          label1338:
          if ((this.c != null) && (this.c.byc == 1) && ((this.n.get() instanceof QQAppInterface)) && (!VipUtils.ce((QQAppInterface)this.n.get())))
          {
            localObject2 = new snm(this);
            localObject2 = aqha.a(this.mContext, 0, getResources().getString(2131699767), getResources().getString(2131699766), acfp.m(2131715773), acfp.m(2131715764), (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject2);
            if (localObject2 != null) {
              ((aqju)localObject2).show();
            }
            anot.a(null, "dc00899", "grp_lbs", "", "qq_gift", "svip_window_view", 0, 0, "", "", "", "");
            continue;
          }
          if (this.aMj)
          {
            this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$f.onHide();
            tv(this.aFf);
            continue;
          }
          if ((this.byr == 2) || (this.byr == 7)) {
            tv(((BaseChatPie)this.dq.get()).sessionInfo.aTl);
          }
        }
        label1309:
        while (this.dq.get() != null)
        {
          ((BaseChatPie)this.dq.get()).bzx();
          break;
          tv(this.aFj);
          continue;
          if (bym == this.mCurrentTab)
          {
            if (this.aMj)
            {
              this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$f.onHide();
              tv(this.aFf);
              break;
            }
            if ((this.byr == 2) || (this.byr == 7)) {
              tv(((BaseChatPie)this.dq.get()).sessionInfo.aTl);
            } else {
              tv(this.aFj);
            }
          }
        }
        if ((this.jdField_a_of_type_Snf != null) && (this.jdField_a_of_type_Snf.jdField_a_of_type_Snf$a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Snf.jdField_a_of_type_Snf$a.jumpUrl)))
        {
          localObject3 = this.jdField_a_of_type_Snf.jdField_a_of_type_Snf$a.jumpUrl + "?_bid=3913&_wvSb=1&from=7&troopUin=%s";
          if (this.sessionInfo.troopUin == null) {
            break label1900;
          }
        }
        label1900:
        for (Object localObject2 = this.sessionInfo.troopUin;; localObject2 = this.sessionInfo.aTl)
        {
          localObject2 = String.format((String)localObject3, new Object[] { localObject2 });
          localObject3 = new Intent(getActivity(), QQBrowserActivity.class);
          ((Intent)localObject3).putExtra("selfSet_leftViewText", acfp.m(2131715758));
          ((Intent)localObject3).putExtra("hide_more_button", true);
          ((Intent)localObject3).putExtra("hide_operation_bar", true);
          ((Intent)localObject3).putExtra("url", gI((String)localObject2));
          getActivity().startActivityForResult((Intent)localObject3, 12007);
          getActivity().overridePendingTransition(2130772009, 2130772082);
          if (this.byr != 2) {
            break label1912;
          }
          anot.a(null, "dc00899", "Grp_flower", "", "C2C", "Clk_pay", 0, 0, "", "", "", "");
          break;
        }
        label1912:
        if (this.byr == 6)
        {
          anot.a(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_pay", 0, 0, "", "", "", "");
        }
        else if (this.byr == 7)
        {
          anot.a(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_pay", 0, 0, "", "", "", "");
        }
        else if (this.asi >= 4)
        {
          acie.i("gift_store", "clk_pay", nD(), um() + "", "", "");
        }
        else
        {
          anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_pay", k, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
          continue;
          if (!TextUtils.isEmpty(this.aFg))
          {
            bzB();
            continue;
            new c(getActivity()).show();
            if (this.aMj) {
              this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$f.onHide();
            }
            for (;;)
            {
              m = 1;
              i = m;
              try
              {
                if (Build.VERSION.SDK_INT >= 23)
                {
                  i = m;
                  if (!Settings.System.canWrite(getActivity()))
                  {
                    i = 0;
                    QLog.i("TroopGiftPanel", 1, "can not write settings");
                  }
                }
                if (i != 0) {
                  Settings.System.putInt(this.mContext.getContentResolver(), "accelerometer_rotation", 0);
                }
              }
              catch (SecurityException localSecurityException)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopGiftPanel", 2, "SecurityException ");
                  }
                }
                anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_num", k, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
              }
              if (this.asi < 4) {
                break label2314;
              }
              acie.i("gift_store", "clk_chose", nD(), um() + "", "", "");
              break;
              ((BaseChatPie)this.dq.get()).bzx();
            }
            continue;
            bzE();
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "sendGiftMaskBtn onClick");
    }
    if (this.c != null) {
      if (this.c.giftId > 0) {
        i = this.c.giftId;
      }
    }
    for (;;)
    {
      anot.a(null, "dc00899", "grp_lbs", "", "qq_gift", "giftsend_click", 0, 0, String.valueOf(i), "", "", "");
      if (((this.mCurrentTab == bym) && (!this.cG.isEnabled()) && (!Nc())) || (!Nb()) || (!TextUtils.isEmpty(this.aFj)) || (this.cG.isEnabled())) {
        break;
      }
      QQToast.a(getContext(), 1, acfp.m(2131715775), 1).show();
      break;
      if (this.c.bxW > 0) {
        i = this.c.bxW;
      } else {
        i = 0;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    sne localsne1;
    int i;
    if ((paramView.getTag() instanceof snb.a))
    {
      localsne1 = ((snb.a)paramView.getTag()).b;
      if ((!localsne1.mSelected) && ((paramAdapterView.getAdapter() instanceof snb)))
      {
        this.c = localsne1;
        localsne1.mSelected = true;
        if ((this.mCurrentTab < 0) || (this.mCurrentTab >= byl)) {
          break label323;
        }
        if ((this.jdField_a_of_type_Snf.ok != null) && (this.jdField_a_of_type_Snf.ok.size() == byl))
        {
          snf.d locald = (snf.d)this.jdField_a_of_type_Snf.ok.get(this.mCurrentTab);
          if (locald.or != null)
          {
            i = 0;
            if (i < locald.or.size())
            {
              sne localsne2 = (sne)locald.or.get(i);
              if (localsne2.bxW == localsne1.bxW) {
                this.jdField_a_of_type_Snf.byg = i;
              }
              for (;;)
              {
                i += 1;
                break;
                localsne2.mSelected = false;
              }
            }
          }
        }
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[this.mCurrentTab].refreshUI();
        if (localsne1.bxX != 0) {
          break label607;
        }
        yF(0);
        if (this.asi < 4) {
          break label503;
        }
        acie.i("gift_store", "exp_chose", nD(), um() + "", "", "");
      }
      label265:
      if (localsne1.giftId <= 0) {
        break label616;
      }
      i = localsne1.giftId;
    }
    for (;;)
    {
      anot.a(null, "dc00899", "grp_lbs", "", "qq_gift", "gift_click", 0, 0, String.valueOf(i), "", "", "");
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label323:
      if (this.mCurrentTab == byl)
      {
        if ((this.jdField_a_of_type_Snf.byh >= 0) && (this.jdField_a_of_type_Snf.byh < this.jdField_a_of_type_Snf.om.size())) {
          ((sne)this.jdField_a_of_type_Snf.om.get(this.jdField_a_of_type_Snf.byh)).mSelected = false;
        }
        this.jdField_a_of_type_Snf.byh = localsne1.mIndex;
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[byl].refreshUI();
        break;
      }
      if (this.mCurrentTab != bym) {
        break;
      }
      if ((this.jdField_a_of_type_Snf.byi >= 0) && (this.jdField_a_of_type_Snf.byi < this.jdField_a_of_type_Snf.on.size())) {
        ((sne)this.jdField_a_of_type_Snf.on.get(this.jdField_a_of_type_Snf.byi)).mSelected = false;
      }
      this.jdField_a_of_type_Snf.byi = localsne1.mIndex;
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[bym].refreshUI();
      break;
      label503:
      if (jof.a().dd(nD())) {}
      for (i = 2;; i = 1)
      {
        anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", i, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
        break;
      }
      label607:
      yF(8);
      break label265;
      label616:
      if (localsne1.bxW > 0) {
        i = localsne1.bxW;
      } else {
        i = 0;
      }
    }
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    this.mCurrentTab = paramInt2;
    yE(this.mCurrentTab);
    Object localObject1;
    boolean bool;
    Object localObject2;
    if ((paramInt2 >= 0) && (paramInt2 < byl))
    {
      this.qr = this.q[paramInt2].findViewById(2131377951);
      this.qs = this.q[paramInt2].findViewById(2131376835);
      this.oy = ((ImageView)this.q[paramInt2].findViewById(2131376834));
      this.AO = ((TextView)this.q[paramInt2].findViewById(2131376836));
      localObject1 = this.q[paramInt2].findViewById(2131364429);
      this.qr.setOnClickListener(this.cO);
      ((View)localObject1).setOnClickListener(this.cO);
      bzz();
      bzy();
      this.jdField_a_of_type_Snd.setSelectedTab(paramInt2);
      uT(this.aMk);
      bzC();
      bool = jof.a().dd(nD());
      if ((this.q[paramInt2].findViewById(2131377979) instanceof TextView))
      {
        localObject2 = (TextView)this.q[paramInt2].findViewById(2131377979);
        if (!bool) {
          break label710;
        }
        localObject1 = "#878B99";
        label211:
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      }
      if ((this.q[paramInt2].findViewById(2131377951) instanceof TextView))
      {
        localObject2 = (TextView)this.q[paramInt2].findViewById(2131377951);
        if (!bool) {
          break label718;
        }
        localObject1 = "#878B99";
        label265:
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      }
      if ((this.jdField_a_of_type_Snf == null) || (!this.jdField_a_of_type_Snf.fm(this.mCurrentTab))) {
        break label740;
      }
      if (!aMm) {
        break label726;
      }
      this.cG.setText(this.aFh);
      label313:
      if ((paramInt2 < 0) || (paramInt2 >= byl) || (this.jdField_a_of_type_Snf == null) || (this.jdField_a_of_type_Snf.ok == null) || (this.jdField_a_of_type_Snf.ok.size() != byl) || (this.jdField_a_of_type_Snf.byg == -1)) {
        break label754;
      }
      if (((snf.d)this.jdField_a_of_type_Snf.ok.get(paramInt2)).or.size() <= this.jdField_a_of_type_Snf.byg) {
        break label1460;
      }
      localObject1 = (sne)((snf.d)this.jdField_a_of_type_Snf.ok.get(paramInt2)).or.get(this.jdField_a_of_type_Snf.byg);
    }
    for (;;)
    {
      label430:
      if (localObject1 != null) {
        if (((sne)localObject1).bxX == 0)
        {
          yF(0);
          if (this.asi >= 4)
          {
            acie.i("gift_store", "exp_chose", nD(), um() + "", "", "");
            label495:
            this.c = ((sne)localObject1);
            if (!jof.a().dd(nD())) {
              break label1009;
            }
            paramInt1 = 2;
            if ((paramInt2 < 0) || (paramInt2 >= byl)) {
              break label1108;
            }
            if (this.asi < 4) {
              break label1014;
            }
            acie.i("gift_store", "exp_one", nD(), um() + "", "", "");
            label574:
            if (!Nb()) {
              break label1100;
            }
            if (TextUtils.isEmpty(this.aFj)) {
              break label1095;
            }
            bool = true;
            label593:
            setSendGiftBtnEnabled(bool);
          }
        }
      }
      for (;;)
      {
        label516:
        localObject2 = "";
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Snf != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Snf.ok != null)
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_Snf.ok.size() == byl) {
              localObject1 = ((snf.d)this.jdField_a_of_type_Snf.ok.get(paramInt2)).name;
            }
          }
        }
        anot.a(null, "dc00899", "grp_lbs", "", "qq_gift", "gift_tab_click", paramInt1, 0, nD(), "", this.aFe, (String)localObject1);
        return;
        this.jdField_a_of_type_Snd.setSelectedTab(-1);
        break;
        label710:
        localObject1 = "#000000";
        break label211;
        label718:
        localObject1 = "#000000";
        break label265;
        label726:
        this.cG.setText(this.aFi);
        break label313;
        label740:
        this.cG.setText(this.aFc);
        break label313;
        label754:
        if ((paramInt2 == byl) && (this.jdField_a_of_type_Snf != null) && (this.jdField_a_of_type_Snf.byh != -1))
        {
          localObject1 = (sne)this.jdField_a_of_type_Snf.om.get(this.jdField_a_of_type_Snf.byh);
          break label430;
        }
        if ((paramInt2 != bym) || (this.jdField_a_of_type_Snf == null) || (this.jdField_a_of_type_Snf.on == null) || (this.jdField_a_of_type_Snf.on.size() <= 0) || (this.jdField_a_of_type_Snf.bh.size() <= 0) || (this.jdField_a_of_type_Snf.byi == -1)) {
          break label1460;
        }
        localObject1 = (sne)this.jdField_a_of_type_Snf.on.get(this.jdField_a_of_type_Snf.byi);
        break label430;
        if (jof.a().dd(nD())) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", paramInt1, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
          break;
        }
        yF(8);
        break label495;
        yF(8);
        break label495;
        label1009:
        paramInt1 = 1;
        break label516;
        label1014:
        anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", paramInt1, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
        break label574;
        label1095:
        bool = false;
        break label593;
        label1100:
        setSendGiftBtnEnabled(true);
      }
      label1108:
      if (paramInt2 == bym)
      {
        anot.a(null, "dc00899", "grp_lbs", "", "qq_gift", "aiobag_view", paramInt1, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
        a(new sni(this));
        if (Nb())
        {
          if ((!TextUtils.isEmpty(this.aFj)) && (Nc())) {}
          for (bool = true;; bool = false)
          {
            setSendGiftBtnEnabled(bool);
            return;
          }
        }
        setSendGiftBtnEnabled(Nc());
        return;
      }
      if (this.asi >= 4)
      {
        acie.i("gift_store", "exp_all", nD(), um() + "", "", "");
        ((apsz)((AppInterface)this.n.get()).getManager(113)).Sg(true);
        ((RedDotTextView)this.qw.findViewById(2131380735)).showRedDot(false, false);
        setSendGiftBtnEnabled(true);
        return;
      }
      localObject2 = nD();
      if (((RedDotTextView)this.qw.findViewById(2131380735)).aGD()) {}
      for (localObject1 = "1";; localObject1 = "0")
      {
        anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forall", paramInt1, 0, (String)localObject2, (String)localObject1, this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
        break;
      }
      label1460:
      localObject1 = null;
    }
  }
  
  public void reset(int paramInt)
  {
    ts("1");
    if ((this.c != null) && (this.c.bxX == 0))
    {
      yF(0);
      if (this.asi >= 4) {
        acie.i("gift_store", "exp_chose", nD(), um() + "", "", "");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Snf != null) {
        this.jdField_a_of_type_Snf.byg = 0;
      }
      this.mCurrentTab = paramInt;
      if ((this.jdField_a_of_type_Snf == null) || (this.jdField_a_of_type_Snf.om == null)) {
        this.mCurrentTab = byj;
      }
      bzy();
      if (this.jdField_a_of_type_Snd != null) {
        this.jdField_a_of_type_Snd.setSelectedTab(this.mCurrentTab);
      }
      onTabSelected(0, this.mCurrentTab);
      uT(this.aMk);
      return;
      if (jof.a().dd(nD())) {}
      for (int i = 2;; i = 1)
      {
        anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", i, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
        break;
      }
      yF(8);
    }
  }
  
  public void setGiftData(snf paramsnf, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramsnf == null) {
      return;
    }
    this.jdField_a_of_type_Snf = paramsnf;
    Object localObject;
    int i;
    if (((!this.aMl) && (paramsnf.ok != null) && (paramsnf.ok.size() > 0)) || ((paramsnf.ok != null) && (paramsnf.ok.size() != byl)))
    {
      int k = paramsnf.ok.size();
      this.aMl = true;
      localObject = (GridListViewPager[])this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.clone();
      View[] arrayOfView = (View[])this.q.clone();
      if (localObject.length == bym + 1)
      {
        byk = k;
        byl = byk;
        bym = byl + 1;
        byo = byl;
        ArrayList localArrayList = new ArrayList();
        i = 0;
        while (i < k)
        {
          snd.a locala = new snd.a();
          locala.name = ((snf.d)paramsnf.ok.get(i)).name;
          localArrayList.add(locala);
          i += 1;
        }
        bzy();
        this.jdField_a_of_type_Snd.fg(localArrayList);
        this.jdField_a_of_type_Snd.setSelectedTab(this.mCurrentTab);
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager = new GridListViewPager[k + 2];
        this.q = new View[k + 2];
        ((ViewGroup)this.qp).removeAllViews();
        i = 0;
        while (i < k)
        {
          paramsnf = new RadioViewPager(getContext());
          paramsnf.setGiftPanel(this);
          paramsnf.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          ((ViewGroup)this.qp).addView(paramsnf, new RelativeLayout.LayoutParams(-1, -1));
          this.q[i] = paramsnf;
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[i] = ((GridListViewPager)paramsnf.a());
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[i].setOnItemClickListener(this);
          i += 1;
        }
        ((ViewGroup)this.qp).addView(arrayOfView[1], new RelativeLayout.LayoutParams(-1, -1));
        ((ViewGroup)this.qp).addView(arrayOfView[2], new RelativeLayout.LayoutParams(-1, -1));
        localObject[0].setVisibility(8);
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[byl] = localObject[1];
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[bym] = localObject[2];
        arrayOfView[0].setVisibility(8);
        this.q[byl] = arrayOfView[1];
        this.q[bym] = arrayOfView[2];
        this.qr = this.q[0].findViewById(2131377951);
        this.qs = this.q[0].findViewById(2131376835);
        this.oy = ((ImageView)this.q[0].findViewById(2131376834));
        this.AO = ((TextView)this.q[0].findViewById(2131376836));
        paramsnf = this.q[0].findViewById(2131364429);
        this.qr.setOnClickListener(this.cO);
        paramsnf.setOnClickListener(this.cO);
        this.qt = this.q[bym].findViewById(2131377951);
        this.qu = this.q[bym].findViewById(2131376835);
        this.oz = ((ImageView)this.q[bym].findViewById(2131376834));
        this.AP = ((TextView)this.q[bym].findViewById(2131376836));
        this.qv = this.q[bym].findViewById(2131372829);
        paramsnf = this.q[bym].findViewById(2131364429);
        this.qt.setOnClickListener(this.cO);
        paramsnf.setOnClickListener(this.cO);
        i = 0;
        while (i < byl)
        {
          a(this.q[i], this.q[byl], this.q[bym]);
          i += 1;
        }
        onTabSelected(0, 0);
      }
    }
    cC(this.jdField_a_of_type_Snf.oo);
    this.qp.setVisibility(0);
    this.mLoadingView.setVisibility(8);
    if ((this.mIsShow) && (this.jdField_a_of_type_Snf.oo != null))
    {
      paramsnf = this.jdField_a_of_type_Snf.oo.iterator();
      while (paramsnf.hasNext()) {
        if (((snf.e)paramsnf.next()).tabID == 1) {
          anot.a(null, "dc00899", "grp_lbs", "", "qq_gift", "activityTab", 0, 0, "", "", "", "");
        }
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Snf.jdField_a_of_type_Snf$a.aEZ))
    {
      paramsnf = this.jdField_a_of_type_Snf.jdField_a_of_type_Snf$a.aEZ;
      if (this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.length > byl)
      {
        i = 0;
        while (i < byl)
        {
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[i].setGridGiftIcon(paramsnf);
          i += 1;
        }
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[byl].setGridGiftIcon(paramsnf);
      }
    }
    if ((this.jdField_a_of_type_Snf.om != null) && (this.jdField_a_of_type_Snf.om.size() >= 1) && (this.aMk))
    {
      this.jdField_a_of_type_Snf.byh = this.jdField_a_of_type_Snf.byf;
      ((sne)this.jdField_a_of_type_Snf.om.get(this.jdField_a_of_type_Snf.byh)).mSelected = true;
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[byl].setData(this.jdField_a_of_type_Snf.om);
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[byl].setVisibility(0);
      this.qw.setVisibility(0);
      ((RedDotTextView)this.qw.findViewById(2131380735)).showRedDot(false, false);
      long l2 = System.currentTimeMillis();
      long l3 = this.jdField_a_of_type_Snf.date;
      if ((this.jdField_a_of_type_Snf.MX) && (l2 >= this.jdField_a_of_type_Snf.date) && (l2 <= l3 + 2592000000L) && (!((apsz)((AppInterface)this.n.get()).getManager(113)).aBx())) {
        ((RedDotTextView)this.qw.findViewById(2131380735)).showRedDot(true, false);
      }
      if ((this.jdField_a_of_type_Snf.jdField_a_of_type_Snf$a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Snf.jdField_a_of_type_Snf$a.icon))) {
        d(this.AM, this.jdField_a_of_type_Snf.jdField_a_of_type_Snf$a.icon);
      }
      uU(paramBoolean);
      if ((this.jdField_a_of_type_Snf.ok != null) && (this.jdField_a_of_type_Snf.ok.size() > 0)) {
        this.jdField_a_of_type_Snf.byg = 0;
      }
      if (this.jdField_a_of_type_Snf.om == null) {
        this.mCurrentTab = byj;
      }
      if ((this.mCurrentTab < 0) || (this.mCurrentTab >= byl) || (this.jdField_a_of_type_Snf.byg == -1)) {
        break label1570;
      }
      if ((this.jdField_a_of_type_Snf.ok != null) && (this.mCurrentTab >= 0) && (this.mCurrentTab < this.jdField_a_of_type_Snf.ok.size()))
      {
        paramsnf = ((snf.d)this.jdField_a_of_type_Snf.ok.get(this.mCurrentTab)).or;
        if ((paramsnf != null) && (this.jdField_a_of_type_Snf.byg >= 0) && (this.jdField_a_of_type_Snf.byg < paramsnf.size())) {
          this.c = ((sne)paramsnf.get(this.jdField_a_of_type_Snf.byg));
        }
      }
    }
    for (;;)
    {
      if ((this.c == null) && (this.jdField_a_of_type_Snf.ok != null) && (this.jdField_a_of_type_Snf.ok.size() > 0) && (((snf.d)this.jdField_a_of_type_Snf.ok.get(0)).or != null) && (((snf.d)this.jdField_a_of_type_Snf.ok.get(0)).or.size() > 0)) {
        this.c = ((sne)((snf.d)this.jdField_a_of_type_Snf.ok.get(0)).or.get(0));
      }
      if ((this.jdField_a_of_type_Snf.ok == null) || (this.jdField_a_of_type_Snf.ok.size() != byl) || (this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.length <= byl)) {
        break label1666;
      }
      i = 0;
      while (i < byl)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[i].setData(((snf.d)this.jdField_a_of_type_Snf.ok.get(i)).or);
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[byl].setVisibility(8);
      this.qw.setVisibility(8);
      break;
      label1570:
      if ((this.mCurrentTab == byl) && (this.jdField_a_of_type_Snf.byh != -1)) {
        this.c = ((sne)this.jdField_a_of_type_Snf.om.get(this.jdField_a_of_type_Snf.byh));
      } else if ((this.mCurrentTab == bym) && (this.jdField_a_of_type_Snf.byi != -1)) {
        this.c = ((sne)this.jdField_a_of_type_Snf.on.get(this.jdField_a_of_type_Snf.byi));
      }
    }
    label1666:
    if ((this.c != null) && (this.c.bxX == 0))
    {
      yF(0);
      if (this.asi >= 4)
      {
        acie.i("gift_store", "exp_chose", nD(), um() + "", "", "");
        if ((this.jdField_a_of_type_Snf.on != null) && (this.jdField_a_of_type_Snf.bh.size() > 0)) {
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[bym].setData(this.jdField_a_of_type_Snf.on);
        }
        a(new snh(this, System.currentTimeMillis(), l1));
        paramBoolean = jof.a().dd(nD());
        paramsnf = findViewById(2131381943);
        localObject = findViewById(2131381944);
        if (!paramBoolean) {
          break label1985;
        }
        paramsnf.setBackgroundResource(2130844570);
        ((View)localObject).setBackgroundResource(2130844572);
      }
    }
    for (;;)
    {
      bzy();
      if (this.jdField_a_of_type_Snd != null) {
        this.jdField_a_of_type_Snd.setSelectedTab(this.mCurrentTab);
      }
      yE(this.mCurrentTab);
      bzC();
      return;
      if (jof.a().dd(nD())) {}
      for (i = 2;; i = 1)
      {
        anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", i, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
        break;
      }
      yF(8);
      break;
      label1985:
      paramsnf.setBackgroundResource(2130844569);
      ((View)localObject).setBackgroundResource(2130844571);
    }
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.mIsShow = paramBoolean;
    if (this.mIsShow)
    {
      if (this.byr == 2) {
        anot.a(null, "dc00899", "Grp_flower", "", "C2C", "half_mall_exp", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    if (this.byr == 6)
    {
      anot.a(null, "dc00899", "Grp_flower", "", "discuss_grp", "half_mall_exp", 0, 0, "", "", "", "");
      return;
    }
    if (this.byr == 7)
    {
      anot.a(null, "dc00899", "Grp_flower", "", "temp_c2c", "half_mall_exp", 0, 0, "", "", "", "");
      return;
    }
    if (this.asi >= 4)
    {
      acie.i("gift_store", "exp_one", nD(), um() + "", "", "");
      return;
    }
    if (jof.a().dd(nD())) {}
    for (int i = 2;; i = 1)
    {
      anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", i, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
      return;
    }
  }
  
  public void setMainAreaBackgroundColor(int paramInt)
  {
    View localView = findViewById(2131363405);
    if (localView != null) {
      localView.setBackgroundColor(paramInt);
    }
  }
  
  public void setSendGiftBtnEnabled(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "setSendGiftBtnEnabled, enabled=" + paramBoolean);
    }
    this.cG.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.qq.setVisibility(8);
      return;
    }
    this.qq.setVisibility(0);
  }
  
  public void showLoading()
  {
    if (this.qp != null) {
      this.qp.setVisibility(8);
    }
    if (this.mLoadingView != null) {
      this.mLoadingView.setVisibility(0);
    }
  }
  
  public void ts(String paramString)
  {
    this.AL.setText("x" + paramString);
  }
  
  public void tu(String paramString)
  {
    paramString = gI(paramString);
    if (paramString.contains("?")) {}
    for (paramString = paramString + "&troop_uin=" + nD();; paramString = paramString + "?troop_uin=" + nD())
    {
      Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
      localIntent.putExtra("selfSet_leftViewText", acfp.m(2131715747));
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("hide_operation_bar", true);
      this.mContext.startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftPanel", 2, "onActionListItemClick, url=" + paramString);
      }
      return;
    }
  }
  
  public void tv(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "handlerSendGiftToPerson, uin=" + paramString);
    }
    Object localObject = (AppInterface)this.n.get();
    if ((localObject == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    localObject = (apsz)((AppInterface)localObject).getManager(113);
    sne localsne = this.c;
    int m = localsne.bxX;
    if (localsne.bxX == 0) {
      m = un();
    }
    int i = 0;
    int i1 = 0;
    int k;
    label139:
    int i3;
    String str;
    long l;
    int i4;
    if (jof.a().dd(this.sessionInfo.aTl))
    {
      i = 6;
      k = i1;
      if (!jof.a().dd(nD())) {
        break label340;
      }
      i1 = 2;
      i3 = this.asi;
      str = nD();
      l = Long.parseLong(paramString);
      i4 = localsne.bxY;
      if (localsne.bxX != 0) {
        break label346;
      }
    }
    label340:
    label346:
    for (int i2 = 1;; i2 = 0)
    {
      ((apsz)localObject).a("OidbSvc.0x6b6", 1718, i, i3, str, 2, m, l, i4, i2, localsne.bxW, k, new snn(this, i1, localsne), localsne.giftId);
      this.c.mSelected = false;
      this.c = null;
      return;
      if (this.byr == 2)
      {
        i = 9;
        k = 1;
        break;
      }
      if (this.byr == 6)
      {
        i = 10;
        k = i1;
        break;
      }
      k = i1;
      if (this.byr != 7) {
        break;
      }
      i = 11;
      switch (this.sessionInfo.cZ)
      {
      default: 
        k = i1;
        break;
      case 1000: 
        k = 512;
        break;
      case 1004: 
        k = 513;
        break;
        i1 = 1;
        break label139;
      }
    }
  }
  
  protected void uS(boolean paramBoolean)
  {
    byj = 0;
    byk = 1;
    byl = byk;
    bym = byl + 1;
    byn = byj;
    byo = byl;
    Object localObject1 = new snd.a();
    ((snd.a)localObject1).name = getResources().getString(2131699965);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    this.jdField_a_of_type_Snd.fg((List)localObject2);
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager = new GridListViewPager[3];
    this.q = new View[3];
    localObject1 = (RadioViewPager)findViewById(2131381897);
    localObject2 = (RadioViewPager)findViewById(2131381898);
    RadioViewPager localRadioViewPager = (RadioViewPager)findViewById(2131381899);
    ((RadioViewPager)localObject1).setGiftPanel(this);
    ((RadioViewPager)localObject2).setGiftPanel(this);
    localRadioViewPager.setGiftPanel(this);
    this.qr = ((RadioViewPager)localObject1).findViewById(2131377951);
    this.qs = ((RadioViewPager)localObject1).findViewById(2131376835);
    this.oy = ((ImageView)((RadioViewPager)localObject1).findViewById(2131376834));
    this.AO = ((TextView)((RadioViewPager)localObject1).findViewById(2131376836));
    View localView1 = ((RadioViewPager)localObject1).findViewById(2131364429);
    this.qt = localRadioViewPager.findViewById(2131377951);
    this.qu = localRadioViewPager.findViewById(2131376835);
    this.oz = ((ImageView)localRadioViewPager.findViewById(2131376834));
    this.AP = ((TextView)localRadioViewPager.findViewById(2131376836));
    this.qv = localRadioViewPager.findViewById(2131372829);
    View localView2 = localRadioViewPager.findViewById(2131364429);
    localRadioViewPager.setEmptyInfo(BaseApplication.getContext().getString(2131699764), BaseApplication.getContext().getString(2131699765));
    localRadioViewPager.setIsShowJumpInfo(false, "", this.mContext);
    this.qr.setOnClickListener(this.cO);
    localView1.setOnClickListener(this.cO);
    this.qt.setOnClickListener(this.cO);
    localView2.setOnClickListener(this.cO);
    a((View)localObject1, (View)localObject2, localRadioViewPager);
    this.q[byj] = localObject1;
    this.q[byl] = localObject2;
    this.q[bym] = localRadioViewPager;
    this.aMk = paramBoolean;
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[byj] = ((GridListViewPager)((RadioViewPager)localObject1).a());
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[byj].setOnItemClickListener(this);
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[byl] = ((GridListViewPager)((RadioViewPager)localObject2).a());
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[byl].setOnItemClickListener(this);
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[bym] = ((GridListViewPager)localRadioViewPager.a());
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[bym].setOnItemClickListener(this);
  }
  
  protected void uU(boolean paramBoolean)
  {
    if ((AppInterface)this.n.get() == null) {}
    for (;;)
    {
      return;
      String str = "";
      int m = 0;
      int i1 = 0;
      Object localObject = null;
      if (this.jdField_a_of_type_Snf != null) {
        localObject = this.jdField_a_of_type_Snf.jdField_a_of_type_Sna$b;
      }
      int k;
      if (localObject != null)
      {
        str = ((sna.b)localObject).imgUrl;
        k = ((sna.b)localObject).height;
        i = ((sna.b)localObject).width;
        this.aFg = ((sna.b)localObject).jumpUrl;
        anot.a(null, "dc00899", "grp_lbs", "", "qq_gift", "panelEntryItem", 0, 0, "", "", "", "");
        localObject = str;
      }
      while ((!TextUtils.isEmpty((CharSequence)localObject)) && (k > 0) && (i > 0))
      {
        if (this.byr != 2) {
          break label259;
        }
        anot.a(null, "dc00899", "Grp_flower", "", "C2C", "exp_opr", 0, 0, "", "", "", "");
        return;
        i = i1;
        k = m;
        localObject = str;
        if (this.jdField_a_of_type_Snf != null)
        {
          i = i1;
          k = m;
          localObject = str;
          if (this.jdField_a_of_type_Snf.jdField_a_of_type_Snf$c != null)
          {
            i = i1;
            k = m;
            localObject = str;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_Snf.jdField_a_of_type_Snf$c.icon))
            {
              localObject = this.jdField_a_of_type_Snf.jdField_a_of_type_Snf$c.icon;
              k = 36;
              i = 36;
              this.aFg = this.jdField_a_of_type_Snf.jdField_a_of_type_Snf$c.jumpUrl;
            }
          }
        }
      }
    }
    label259:
    if (this.byr == 6)
    {
      anot.a(null, "dc00899", "Grp_flower", "", "discuss_grp", "exp_opr", 0, 0, "", "", "", "");
      return;
    }
    if (this.byr == 7)
    {
      anot.a(null, "dc00899", "Grp_flower", "", "temp_c2c", "exp_opr", 0, 0, "", "", "", "");
      return;
    }
    if (this.asi >= 4)
    {
      acie.i("gift_store", "exp_oper", nD(), um() + "", "", "");
      return;
    }
    if (jof.a().dd(nD())) {}
    for (int i = 2;; i = 1)
    {
      anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_opr", i, 0, nD(), "", this.aFe, "" + jlk.a((AppInterface)this.n.get(), ((AppInterface)this.n.get()).getCurrentAccountUin(), nD()));
      return;
    }
  }
  
  public int um()
  {
    switch (this.asi)
    {
    case 7: 
    default: 
      return this.asi;
    case 6: 
      return 504;
    case 4: 
      if ((this.dq.get() instanceof yam))
      {
        yam localyam = (yam)this.dq.get();
        if ((localyam.b != null) && (localyam.b.isBuLuoHotChat())) {
          return 507;
        }
        return 503;
      }
      return -1;
    case 5: 
      return 2;
    }
    return 508;
  }
  
  public int un()
  {
    int k = 0;
    CharSequence localCharSequence = this.AL.getText();
    int i = k;
    try
    {
      if (!TextUtils.isEmpty(localCharSequence)) {
        i = Integer.parseInt(localCharSequence.toString().substring(1));
      }
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      do
      {
        i = k;
      } while (!QLog.isColorLevel());
      QLog.d("TroopGiftPanel", 2, "error sendNum = " + localCharSequence);
    }
    return 0;
  }
  
  public int uo()
  {
    return 0;
  }
  
  protected void yE(int paramInt)
  {
    int i = 0;
    if (i < this.q.length)
    {
      if (i != paramInt) {
        this.q[i].setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        this.q[i].setVisibility(0);
      }
    }
    if (this.qo != null) {
      this.qo.setVisibility(0);
    }
  }
  
  public void yF(int paramInt)
  {
    this.AL.setVisibility(paramInt);
  }
  
  protected void yG(int paramInt)
  {
    if (this.sessionInfo.troopUin != null) {}
    for (String str = this.sessionInfo.troopUin;; str = this.sessionInfo.aTl)
    {
      anot.a(null, "dc00899", "grp_lbs", str, "qq_gift", "button_click", 0, 0, paramInt + "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftPanel", 2, "reportActionEntryClick, entryId=" + paramInt + ", toUin=" + str);
      }
      return;
    }
  }
  
  class a
    implements tgl
  {
    a() {}
    
    public void a(com.tencent.gdtad.api.GdtAd paramGdtAd)
    {
      QLog.i("TroopGiftPanel", 1, "onAdLoaded");
      TroopGiftPanel.a(TroopGiftPanel.this, paramGdtAd);
    }
    
    public void a(com.tencent.gdtad.api.GdtAd paramGdtAd, tgk paramtgk)
    {
      QLog.e("TroopGiftPanel", 1, "onAdFailedToLoad: " + paramtgk.getErrorMessage());
    }
    
    public void b(com.tencent.gdtad.api.GdtAd paramGdtAd)
    {
      QLog.i("TroopGiftPanel", 1, "onAdImpression");
    }
    
    public void c(com.tencent.gdtad.api.GdtAd paramGdtAd)
    {
      QLog.i("TroopGiftPanel", 1, "onAdClicked");
    }
    
    public void d(com.tencent.gdtad.api.GdtAd paramGdtAd)
    {
      QLog.i("TroopGiftPanel", 1, "onAdClosed");
    }
  }
  
  class b
    implements InputFilter
  {
    protected int mMaxLength = -1;
    
    public b(int paramInt)
    {
      this.mMaxLength = paramInt;
    }
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      System.out.println("filter() source = " + paramCharSequence + ", dest = " + paramSpanned + ", start = " + paramInt1 + ", dstart = " + paramInt3 + ", dend = " + paramInt4);
      if (paramCharSequence.length() != 1) {
        return "";
      }
      paramInt1 = paramCharSequence.charAt(0);
      if ((paramInt1 < 48) || (paramInt1 > 57)) {
        return "";
      }
      if ((paramInt3 == 0) && (paramInt1 == 48)) {
        return "";
      }
      if ((this.mMaxLength > 0) && (paramSpanned.length() >= this.mMaxLength)) {
        return "";
      }
      return null;
    }
  }
  
  public class c
    implements View.OnClickListener, InputMethodLinearLayout.a
  {
    protected TextView AQ;
    public EditText aj;
    protected TextView mCancelButton;
    protected Dialog mDialog;
    
    @TargetApi(11)
    public c(Context paramContext)
    {
      this.mDialog = new Dialog(paramContext, 2131755357);
      Window localWindow = this.mDialog.getWindow();
      localWindow.setSoftInputMode(16);
      View localView = localWindow.getDecorView();
      if (localView != null) {
        localView.setPadding(0, 0, 0, 0);
      }
      localWindow.setGravity(80);
      localWindow.setLayout(-1, -2);
      paramContext = LayoutInflater.from(paramContext).inflate(2131560803, null);
      this.mDialog.setContentView(paramContext);
      this.mDialog.setCancelable(true);
      paramContext = (InputMethodLinearLayout)this.mDialog.findViewById(2131368049);
      paramContext.setOnSizeChangedListenner(this);
      this.AQ = ((TextView)this.mDialog.findViewById(2131365224));
      this.mCancelButton = ((TextView)this.mDialog.findViewById(2131364228));
      this.aj = ((EditText)this.mDialog.findViewById(2131368055));
      if (Build.VERSION.SDK_INT >= 11) {
        this.aj.setCustomSelectionActionModeCallback(new snx(this, TroopGiftPanel.this));
      }
      this.aj.setOnEditorActionListener(new sny(this, TroopGiftPanel.this));
      this.AQ.setOnClickListener(this);
      this.mCancelButton.setOnClickListener(this);
      paramContext.setOnClickListener(new snz(this, TroopGiftPanel.this));
    }
    
    public void dismiss()
    {
      if (TroopGiftPanel.this.aMj) {
        TroopGiftPanel.this.a.bzH();
      }
      for (;;)
      {
        this.mDialog.dismiss();
        return;
        ((BaseChatPie)TroopGiftPanel.this.dq.get()).wh(false);
      }
    }
    
    public void gR()
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)TroopGiftPanel.this.getContext().getSystemService("input_method");
      View localView = this.mDialog.getWindow().peekDecorView();
      if ((localView != null) && (localView.getWindowToken() != null)) {
        localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
      }
    }
    
    public void onClick(View paramView)
    {
      int i;
      if (jof.a().dd(TroopGiftPanel.this.nD()))
      {
        i = 2;
        switch (paramView.getId())
        {
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        i = 1;
        break;
        gR();
        TroopGiftPanel.this.postDelayed(new TroopGiftPanel.GiftNumInputDialog.5(this), 100L);
        if (TroopGiftPanel.this.asi >= 4)
        {
          acie.i("gift_store", "cancel_num", TroopGiftPanel.this.nD(), TroopGiftPanel.this.um() + "", "", "");
        }
        else
        {
          anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numcancel", i, 0, TroopGiftPanel.this.nD(), "", TroopGiftPanel.this.aFe, "" + jlk.a((AppInterface)TroopGiftPanel.this.n.get(), ((AppInterface)TroopGiftPanel.this.n.get()).getCurrentAccountUin(), TroopGiftPanel.this.nD()));
          continue;
          gR();
          String str = this.aj.getEditableText().toString();
          if (!TextUtils.isEmpty(str)) {
            TroopGiftPanel.this.ts(str);
          }
          TroopGiftPanel.this.postDelayed(new TroopGiftPanel.GiftNumInputDialog.6(this), 100L);
          if (TroopGiftPanel.this.asi >= 4) {
            acie.i("gift_store", "sure_num", TroopGiftPanel.this.nD(), TroopGiftPanel.this.um() + "", "", "");
          } else {
            anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numok", i, 0, TroopGiftPanel.this.nD(), "", TroopGiftPanel.this.aFe, "" + jlk.a((AppInterface)TroopGiftPanel.this.n.get(), ((AppInterface)TroopGiftPanel.this.n.get()).getCurrentAccountUin(), TroopGiftPanel.this.nD()));
          }
        }
      }
    }
    
    public void show()
    {
      this.mDialog.setOnShowListener(new soa(this));
      this.aj.setFilters(new InputFilter[] { new TroopGiftPanel.b(TroopGiftPanel.this, 5) });
      this.mDialog.show();
    }
    
    public void uV(boolean paramBoolean)
    {
      if (!paramBoolean) {
        dismiss();
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void fj(List<apsz.a> paramList);
    
    public abstract void onError(int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract void a(List<apsz.b> paramList, snf.b paramb);
    
    public abstract void onError(int paramInt);
  }
  
  public static abstract interface f
  {
    public abstract void bzH();
    
    public abstract void onHide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel
 * JD-Core Version:    0.7.0.1
 */