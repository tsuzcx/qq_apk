package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import aeay;
import aeej;
import alkw;
import android.annotation.TargetApi;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.MQLruCache;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anpc;
import aoag;
import aqdf;
import aqdf.a;
import aqfo;
import aqgz;
import aqhu;
import aqiw;
import aqiz;
import aurr;
import autl;
import awit;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.CommonAdBar;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentTopGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentTopGestureLayout.a;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData.a;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.TitleData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher.a;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.tools.utils.UriBuilder;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.SavedState;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XListView.a;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jzi;
import kbp;
import kfq;
import kgi;
import kgi.b;
import kgw;
import kjt;
import kjx;
import kkc;
import kkk;
import kny;
import kqd;
import ksm;
import ksx;
import ksz;
import ksz.b;
import ksz.c;
import ktr;
import kxm;
import kxm.b;
import kxy;
import kys;
import lbz;
import lcc;
import lcd;
import lce;
import lhu;
import lhu.a;
import lhu.b;
import mih;
import mih.b;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import mrm;
import mst;
import ndi;
import njo;
import njq;
import njr;
import njt;
import nju;
import njv;
import njw;
import njx;
import njy;
import njz;
import nka;
import nkb;
import nkc;
import nkd;
import nkf;
import nkg;
import nki;
import nkj;
import nkn;
import nko;
import nkp;
import nkq;
import nkr;
import nks;
import nkt;
import nku;
import nkv;
import nkw;
import nkx;
import nky;
import nkz;
import nla;
import nlb;
import nlc;
import nlc.a;
import nle;
import nlj;
import nlk;
import nlm;
import nmq;
import nmq.b;
import nmv;
import nmx;
import nmy;
import nmz;
import nnc.b;
import nng;
import nnl;
import nnn;
import nno;
import nns;
import nnu;
import nnw;
import npl;
import odg;
import odg.a;
import odg.c;
import odv;
import oej;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import rwt;
import svi;
import wja;
import znx;

public class FastWebActivity
  extends FragmentActivity
  implements View.OnClickListener, aqdf.a, ReadInJoyCommentTopGestureLayout.a, MiniMsgUser.IMiniMsgActionCallback, kgi.b, kny, ksz.b, odg.c
{
  public static int aZL = 33;
  private String TAG = "FastWebActivity";
  private String Vs = "";
  private String Vt = "";
  private SparseArray<View> Y = new SparseArray(1);
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.iI);
  private aqdf jdField_a_of_type_Aqdf;
  private CommonAdBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barCommonAdBar;
  private ReadInJoyCommentTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment;
  private AnchorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData;
  private ReadInJoyFastWebBottomSocialViewNew jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$b;
  private AuthorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData;
  private TitleData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData;
  private ItemShowDispatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = new ItemShowDispatcher();
  private CommonSuspensionGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout;
  private XListView.a jdField_a_of_type_ComTencentWidgetXListView$a = new nkn(this);
  private kqd jdField_a_of_type_Kqd;
  private lhu.a jdField_a_of_type_Lhu$a = new nkq(this);
  nlc.a jdField_a_of_type_Nlc$a = new nkv(this);
  private nlc jdField_a_of_type_Nlc;
  private nle jdField_a_of_type_Nle;
  private nlj jdField_a_of_type_Nlj;
  private nlk jdField_a_of_type_Nlk;
  private nmq.b jdField_a_of_type_Nmq$b;
  private nmq jdField_a_of_type_Nmq = new nmq(this);
  private nnu jdField_a_of_type_Nnu;
  private int aGM;
  private int aGN;
  private int aIV = 1000;
  private int aJU = -1;
  private int aLC = 1;
  private Handler aS = new Handler(Looper.getMainLooper());
  private Handler aT = new Handler(Looper.getMainLooper());
  private int aZA;
  private int aZB;
  private int aZC;
  private int aZD;
  private int aZE;
  private int aZF;
  private int aZG = 1;
  private int aZH;
  private int aZI;
  private int aZJ = -1;
  private int aZK;
  private int aZM;
  private int aZr;
  private int aZs;
  private int aZt;
  private int aZu;
  private int aZv;
  private int aZw;
  private int aZx;
  private int aZy;
  private int aZz;
  private boolean adb;
  private boolean adc;
  private boolean add;
  private boolean agi;
  private boolean agj;
  private String akh = System.currentTimeMillis() + "";
  protected String alw;
  private String alx = "";
  private String aly = "";
  private String alz = "";
  Set<BaseData> an = new HashSet();
  private boolean asH = true;
  private boolean asI;
  private boolean asJ;
  boolean asK = true;
  private boolean asL;
  private boolean asM;
  private boolean asN;
  private boolean asO;
  private boolean asP;
  private boolean asQ;
  private boolean asR;
  private boolean asS = true;
  public boolean asT;
  public boolean asU;
  private boolean asV;
  private boolean asW;
  private boolean asX;
  private boolean asY = true;
  private boolean asZ;
  private boolean ata;
  private boolean atb = true;
  private boolean atc = true;
  private boolean atd;
  public SparseArray<Float> ax;
  private RIJRedPacketPopupView jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView;
  private RIJRedPacketProgressView jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  private ArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private FastWebArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
  private jzi jdField_b_of_type_Jzi;
  private lhu.b jdField_b_of_type_Lhu$b = new nkp(this);
  private nng jdField_b_of_type_Nng = new nng();
  private svi jdField_b_of_type_Svi;
  public INetInfoHandler c;
  private ksm jdField_c_of_type_Ksm;
  private kxy jdField_c_of_type_Kxy = new kxy();
  private Runnable cW;
  private MessageQueue.IdleHandler d;
  private MessageQueue.IdleHandler jdField_e_of_type_AndroidOsMessageQueue$IdleHandler = new nku(this);
  private ReadInJoyCommentListView jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private HashMap<String, ArrayList<String>> eu = new HashMap();
  private RIJRedPacketPopupView f;
  private RelativeLayout fq;
  private BubblePopupWindow g;
  AbsListView.e h = new nkc(this);
  private boolean hasShareItemClick;
  private float iG = aqgz.getDispalyDpi() * 500 / 160.0F;
  private float iH = aqgz.getDispalyDpi() * 1000 / 160.0F;
  private float iI = 1.5F;
  private boolean isFinish;
  private View jE;
  private ImageView kK;
  private ImageView kL;
  lce l = new nks(this);
  private ArrayList<kjt> lG = new ArrayList();
  private long mAlgorithmID;
  public long mChannelID;
  private aeay mColorNoteController;
  private List<BaseData> mDatas;
  private View mMaskView;
  public MiniMsgUser mMiniMsgUser;
  private View mN;
  private View mO;
  private lce mObserver = new nkd(this);
  private odg mShareHelper;
  private long mStartTime;
  private int mStrategyId;
  private TextView mTitleView;
  private TextView oR;
  private TextView oS;
  private long rV;
  private TextView tn;
  private boolean wE;
  protected long xB;
  private long xC;
  long xD;
  
  public FastWebActivity()
  {
    this.jdField_c_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new nkt(this);
  }
  
  private void E(@NotNull ArticleInfo paramArticleInfo)
  {
    int j = 0;
    kxm.b localb = new kxm.b();
    paramArticleInfo = localb.a("uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin())).a("rowkey", paramArticleInfo.innerUniqueID).a("os", Integer.valueOf(1)).a("imsi", aqgz.getIMSI()).a("imei", kxm.iT());
    if (aqiw.isWifiConnected(BaseApplicationImpl.getContext()))
    {
      i = 2;
      paramArticleInfo = paramArticleInfo.a("network_type", Integer.valueOf(i));
      if (!this.add) {
        break label180;
      }
    }
    label180:
    for (int i = 1;; i = 0)
    {
      paramArticleInfo = paramArticleInfo.a("is_redpack", Integer.valueOf(i)).a("redpack_style", Integer.valueOf(this.aGN));
      i = j;
      if (!TextUtils.isEmpty(this.Vs)) {
        i = 1;
      }
      paramArticleInfo.a("is_tips", Integer.valueOf(i)).a("page_type", Integer.valueOf(1));
      kbp.bp("0X800AD2F", localb.build());
      return;
      i = 1;
      break;
    }
  }
  
  private void F(ArticleInfo paramArticleInfo)
  {
    QLog.d(this.TAG, 1, " url: " + paramArticleInfo.mArticleContentUrl);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (this.ata)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.bbh();
    }
    int i = (int)paramArticleInfo.mChannelID;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (ndi.al(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!ndi.ap(paramArticleInfo)) {
        localObject1 = ((mih.b)paramArticleInfo.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld.get(0)).businessUrl;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      nK();
      QLog.d(this.TAG, 1, " url is null!");
      return;
    }
    localObject2 = localObject1;
    if (!(paramArticleInfo instanceof AdvertisementInfo))
    {
      if (((String)localObject1).contains("?"))
      {
        localObject1 = (String)localObject1 + "&";
        localObject2 = (String)localObject1 + "from=0";
      }
    }
    else
    {
      localObject1 = localObject2;
      if (AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo))
      {
        localObject1 = localObject2;
        if (aqiw.isWifiConnected(null)) {
          if (!((String)localObject2).contains("?")) {
            break label457;
          }
        }
      }
    }
    label457:
    for (localObject1 = (String)localObject2 + "&";; localObject1 = (String)localObject2 + "?")
    {
      localObject1 = (String)localObject1 + "acttype=42";
      localObject2 = new Intent(this, ReadInJoyArticleDetailActivity.class);
      localBundle.putString("url", (String)localObject1);
      localBundle.putBoolean("hide_operation_bar", true);
      localBundle.putBoolean("from_native", true);
      localBundle.putString("from", String.valueOf(53));
      localBundle.putString("subscribename", paramArticleInfo.mSubscribeName);
      localBundle.putLong("articleid", paramArticleInfo.mArticleID);
      localBundle.putString("row_key", paramArticleInfo.innerUniqueID);
      localBundle.putInt("channelid", i);
      localBundle.putInt("strategyid", paramArticleInfo.mStrategyId);
      localBundle.putLong("algorithmid", paramArticleInfo.mAlgorithmID);
      localBundle.putInt("articalChannelId", 9);
      ((Intent)localObject2).putExtras(localBundle);
      startActivityForResult((Intent)localObject2, 10923);
      return;
      localObject1 = (String)localObject1 + "?";
      break;
    }
  }
  
  private byte[] F()
  {
    byte[] arrayOfByte2 = null;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return null;
    }
    byte[] arrayOfByte1 = arrayOfByte2;
    try
    {
      Parcel localParcel = Parcel.obtain();
      arrayOfByte1 = arrayOfByte2;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.writeToParcel(localParcel, 0);
      arrayOfByte1 = arrayOfByte2;
      localParcel.setDataPosition(0);
      arrayOfByte1 = arrayOfByte2;
      arrayOfByte2 = localParcel.marshall();
      arrayOfByte1 = arrayOfByte2;
      localParcel.recycle();
      return arrayOfByte2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d(this.TAG, 2, "init color bytes error");
    }
    return arrayOfByte1;
  }
  
  private boolean FI()
  {
    return (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.isFinish);
  }
  
  private int V(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (this.jdField_a_of_type_Nlk == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0;
    }
    int j = 0;
    while ((i < this.jdField_a_of_type_Nlk.size()) && (i <= paramInt1))
    {
      j += this.jdField_a_of_type_Nlk.get(i);
      i += 1;
    }
    return j - paramInt2;
  }
  
  private void Z(Bundle paramBundle)
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      QLog.d(this.TAG, 1, "onSaveInstanceState data != null");
      paramBundle.putBundle("bundle_key_save_instancestate", localBundle);
    }
  }
  
  private int a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      this.aZy = V(paramAbsListView.getLastVisiblePosition(), this.aZx);
    }
    for (;;)
    {
      return this.aZy;
      if (this.aZy == 0) {
        this.aZy = V(paramAbsListView.getLastVisiblePosition(), this.aZx);
      }
    }
  }
  
  private void a(RIJRedPacketPopupView paramRIJRedPacketPopupView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, CharSequence paramCharSequence, int paramInt3)
  {
    ViewGroup.LayoutParams localLayoutParams = paramRIJRedPacketPopupView.getLayoutParams();
    if ((localLayoutParams instanceof FrameLayout.LayoutParams))
    {
      ((FrameLayout.LayoutParams)localLayoutParams).leftMargin = paramInt1;
      ((FrameLayout.LayoutParams)localLayoutParams).topMargin = paramInt2;
    }
    for (;;)
    {
      paramRIJRedPacketPopupView.setLayoutParams(localLayoutParams);
      paramRIJRedPacketPopupView.setText(paramCharSequence);
      paramRIJRedPacketPopupView.nO(paramBoolean2);
      if (paramBoolean2) {
        paramRIJRedPacketPopupView.setOnCloseIconClickListener(new nkf(this, paramRIJRedPacketPopupView));
      }
      paramRIJRedPacketPopupView.nP(paramBoolean1);
      l(paramRIJRedPacketPopupView, true);
      this.aT.postDelayed(new FastWebActivity.27(this, paramRIJRedPacketPopupView), paramInt3);
      return;
      if ((localLayoutParams instanceof RelativeLayout.LayoutParams))
      {
        ((RelativeLayout.LayoutParams)localLayoutParams).leftMargin = paramInt1;
        ((RelativeLayout.LayoutParams)localLayoutParams).topMargin = paramInt2;
      }
    }
  }
  
  private void a(BaseData paramBaseData)
  {
    if (paramBaseData == null) {}
    while (this.an.contains(paramBaseData)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        if (paramBaseData.type != 6) {
          break label216;
        }
        nns.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramBaseData);
        if ((paramBaseData instanceof ProteusRecommendItemData))
        {
          JSONObject localJSONObject = ((ProteusRecommendItemData)paramBaseData).aD;
          if ((localJSONObject != null) && (localJSONObject.opt("id_recommend_category_txt") != null) && (localJSONObject.opt("kd_ug_download_url") != null))
          {
            String str = "";
            localObject = str;
            if (localJSONObject.opt("card_info") != null)
            {
              localJSONObject = localJSONObject.getJSONObject("card_info");
              localObject = str;
              if (localJSONObject.opt("rowKey") != null) {
                localObject = localJSONObject.getString("rowKey");
              }
            }
            if (aqiz.O(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0")) {
              break label200;
            }
            kfq.ma(kfq.o("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc1IiAAAAA2JjkuMTQ2LjEzMy4xMzdfMTU4MzEzMzUwODgzMV8xNzc4NDA5ODA0Ql5cs0RZDIADnQAAGwwQASYGNDE5NzYzNgk2NjY2NjY2NjZGAFACbKgM&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", (String)localObject, "2"));
          }
        }
        this.an.add(paramBaseData);
        return;
      }
      catch (Exception paramBaseData)
      {
        QLog.d(this.TAG, 1, "doExposure error! msg=" + paramBaseData);
        return;
      }
      label200:
      kfq.ma(kfq.o("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc2IiAAAAA2JTkuMTQ2LjE0NC42MV8xNTgzMTMzNDQ0Njk1XzExNTYyNzY1MTNCXlyzBFkMgAOdAAAbDBABJgY0MTk3NjI2CTY2NjY2NjY2NkYAUAFsqAw%3D&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", (String)localObject, "2"));
      continue;
      label216:
      if (paramBaseData.type == 26)
      {
        localObject = (ProteusItemData)paramBaseData;
        if (((ProteusItemData)localObject).mModuleType == 2)
        {
          nmv.e(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80099DA");
          nmv.e(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80100DB");
          nmv.e(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009A5A");
        }
        else
        {
          nmz.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, ((ProteusItemData)localObject).mTemplateBean);
        }
      }
      else
      {
        nns.d(paramBaseData);
      }
    }
  }
  
  private void a(AbsListView paramAbsListView, int paramInt, boolean paramBoolean)
  {
    this.aJU = paramInt;
    if (((!this.agj) && (!paramBoolean)) || ((this.agi) && (!paramBoolean)) || (this.wE)) {}
    Object localObject2;
    int i;
    label187:
    int j;
    label328:
    label333:
    do
    {
      do
      {
        float f1;
        do
        {
          return;
          f1 = paramAbsListView.getFlingVelocityY();
        } while (((!paramBoolean) && ((f1 < this.iG) || (f1 > this.iH))) || (this.aJU > paramInt) || (paramInt >= paramAbsListView.getCount() - 1));
        this.aJU = paramInt;
        localObject1 = (ListAdapter)paramAbsListView.getAdapter();
        if (!paramBoolean) {
          break;
        }
        localObject2 = ((ListAdapter)localObject1).getItem(paramInt);
      } while ((!(localObject2 instanceof ProteusBannerBigPicItemData)) && (!(localObject2 instanceof ProteusBannerTriplePicItemData)) && (!(localObject2 instanceof ProteusBannerVideoItemData)));
      i = ((ListAdapter)localObject1).getItemViewType(paramInt);
      localObject2 = (View)this.Y.get(i);
      ViewGroup.LayoutParams localLayoutParams;
      if (localObject2 == null)
      {
        localObject1 = ((ListAdapter)localObject1).getView(paramInt, null, paramAbsListView);
        this.Y.put(i, localObject1);
        localObject2 = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - paramAbsListView.getFirstVisiblePosition());
        if ((localObject2 == null) || (localObject1 == null)) {
          break;
        }
        i = paramAbsListView.getRemainFlingDisY();
        j = ((View)localObject2).getBottom() + paramAbsListView.getTop() - paramAbsListView.getBottom() - paramAbsListView.getPaddingBottom();
        localLayoutParams = ((View)localObject1).getLayoutParams();
        if (localLayoutParams == null) {
          break label328;
        }
      }
      for (paramInt = localLayoutParams.width;; paramInt = -1)
      {
        ((View)localObject1).measure(ViewGroup.getChildMeasureSpec(paramAbsListView.getMeasuredWidthAndState(), paramAbsListView.getPaddingLeft() + paramAbsListView.getPaddingRight(), paramInt), 0);
        paramInt = ((View)localObject1).getMeasuredHeight();
        if ((!paramBoolean) || (j >= paramInt / 2)) {
          break label333;
        }
        this.wE = true;
        return;
        paramInt += 1;
        break;
        localObject1 = ((ListAdapter)localObject1).getView(paramInt, (View)localObject2, paramAbsListView);
        break label187;
      }
    } while (((i <= j) || (i >= paramInt / 2 + j)) && ((!paramBoolean) || (j <= paramInt / 2)));
    this.agi = true;
    Object localObject1 = new FastWebActivity.24(this, (View)localObject2, paramAbsListView, i, paramInt, paramBoolean);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramAbsListView.postOnAnimation((Runnable)localObject1);
      return;
    }
    paramAbsListView.post((Runnable)localObject1);
    return;
    this.wE = true;
  }
  
  private void a(nmq.b paramb)
  {
    aZe();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramb.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_a_of_type_Nmq$b = paramb;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_Nmq$b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    this.asN = paramb.asN;
    this.jdField_a_of_type_Nlj = paramb.jdField_a_of_type_Nlj;
    initData();
  }
  
  private void aBh()
  {
    nmy.db(this.mDatas);
  }
  
  private void aBy()
  {
    if (!awit.aML()) {
      return;
    }
    awit.eDM();
    this.kK.postDelayed(new FastWebActivity.2(this), 200L);
  }
  
  private void aBz()
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.aOP();
    QLog.i(this.TAG, 1, "report timinggggggg");
    this.aS.removeCallbacksAndMessages(null);
    this.aT.removeCallbacksAndMessages(null);
  }
  
  private void aDy()
  {
    View localView = findViewById(2131374329);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void aGL()
  {
    if (this.jdField_a_of_type_Kqd != null) {
      this.jdField_a_of_type_Kqd.clear();
    }
    this.jdField_a_of_type_Kqd = new kqd();
    this.jdField_a_of_type_Kqd.a(new nkw(this));
  }
  
  private void aU(Intent paramIntent)
  {
    aZe();
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null)
    {
      QLog.e("Q.readinjoy.fast_web", 1, " refrashFromIntent data == null ");
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)paramIntent.get("fast_web_article_info"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = new ItemShowDispatcher();
    this.asH = true;
    this.asN = paramIntent.getBoolean("fast_web_from_article_recommend", false);
    initData();
  }
  
  private void aYA()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barCommonAdBar = ((CommonAdBar)findViewById(2131378558));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barCommonAdBar.bringToFront();
  }
  
  private void aYB()
  {
    this.jdField_b_of_type_Jzi = new jzi(this);
  }
  
  private void aYC()
  {
    this.fq = ((RelativeLayout)findViewById(2131377523));
    this.kL = ((ImageView)findViewById(2131371722));
    this.tn = ((TextView)findViewById(2131371723));
    Drawable localDrawable = aqhu.d(this.kL.getResources().getDrawable(2130841861), -16777216);
    this.kL.setImageDrawable(localDrawable);
  }
  
  private void aYD()
  {
    if (this.mMiniMsgUser == null) {
      this.mMiniMsgUser = new MiniMsgUser(getActivity(), getMiniMsgUserParam());
    }
  }
  
  private void aYE()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.articleId)) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID = Long.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.articleId).longValue();
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.title != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.title;
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.amn != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.amn;
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.accountName != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.accountName;
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.puin != 0L) && (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID))) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID = ("" + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.puin);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.articleUrl))
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.articleUrl;
      QLog.d(this.TAG, 1, "initArticleInfo, update url,url=" + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    }
  }
  
  private void aYF()
  {
    String str = null;
    this.jdField_c_of_type_Ksm = new ksm(this, this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = ((AnchorData)getIntent().getExtras().get("intent_key_anchor_data"));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData != null) {
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.acb;
    }
    for (Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.acd;; localObject = null)
    {
      if (!TextUtils.isEmpty(str))
      {
        QLog.d("Q.readinjoy.fast_web", 1, " mainComment : " + str + "  subComment : " + (String)localObject);
        this.jdField_c_of_type_Ksm.a(new njr(this, str, (String)localObject));
      }
      this.jdField_c_of_type_Ksm.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData, 1);
      this.jdField_c_of_type_Ksm.a(new njt(this));
      this.jdField_a_of_type_Nlc.f(this.jdField_c_of_type_Ksm);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = new ReadInJoySecondCommentListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.pB(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this, (Bundle)localObject, new nju(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.b(new njv(this));
      localObject = getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131377881, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      return;
    }
  }
  
  private void aYG()
  {
    lhu locallhu = lbz.a().a();
    if (locallhu == null)
    {
      if (!this.isFinish) {
        aYH();
      }
      QLog.d(this.TAG, 2, "fastWebModule == null");
      return;
    }
    locallhu.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, 1, this.jdField_b_of_type_Lhu$b);
  }
  
  private void aYH()
  {
    QLog.d(this.TAG, 1, "openWeb  mArticleInfo: " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    this.asM = true;
    lcc.a().b(this.mObserver);
    getMainLooper();
    Looper.myQueue().addIdleHandler(new njw(this));
    kbp.a(null, "CliOper", "", "", "0X8009C50", "0X8009C50", 0, 0, "", Long.toString(this.xB), Integer.toString(this.mStrategyId), "", false);
  }
  
  private void aYI()
  {
    if (this.d != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.d);
    }
    this.d = new njx(this);
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.d);
  }
  
  private void aYK()
  {
    aYL();
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_e_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void aYL()
  {
    getMainLooper();
    Looper.myQueue().removeIdleHandler(this.jdField_e_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void aYM()
  {
    if ((this.jdField_a_of_type_Nlk == null) || ((this.jdField_a_of_type_Nle != null) && (this.jdField_a_of_type_Nle.getCount() != this.jdField_a_of_type_Nlk.size())))
    {
      QLog.e("Q.readinjoy.fast_web", 2, "refreshMaxReadHeight itemsHeight == null ");
      return;
    }
    int k = this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition();
    int i;
    label62:
    int j;
    label83:
    Object localObject;
    int m;
    boolean bool1;
    label264:
    float f1;
    if (k > this.aZv)
    {
      i = 1;
      if (this.jdField_a_of_type_Nlk != null)
      {
        if (this.aZv <= k) {
          break label394;
        }
        j = this.aZv;
        this.aZv = j;
        j = this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
        j = this.aZv - j;
        if ((j < this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount()) && (this.aZv < this.jdField_a_of_type_Nlk.size()))
        {
          localObject = this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(j);
          j = this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeight();
          m = ((View)localObject).getTop();
          this.aZx = (this.jdField_a_of_type_Nlk.get(this.aZv) - (j - m));
          if (i == 0) {
            break label400;
          }
          this.aZw = this.aZx;
          if (this.aZw < 0) {
            this.aZw = 0;
          }
          QLog.d("Q.readinjoy.fast_web", 2, "  mMaxLastPosition  " + this.aZv + "  mMaxLastItemInvisibleHeight " + this.aZw);
        }
      }
      j = this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
      m = this.mDatas.size();
      bool1 = false;
      i = 0;
      if (j > k) {
        break label474;
      }
      if (j >= m) {
        break label466;
      }
      f1 = BaseData.a((BaseData)this.mDatas.get(j));
      if (f1 > nns.as[0]) {
        break label432;
      }
      i |= 0x1;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (j < this.mDatas.size())
      {
        bool2 = bool1;
        if (((BaseData)this.mDatas.get(j)).ato)
        {
          this.asO = true;
          if (this.aZr == 0) {
            this.aZr = a(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.aZI);
          }
          bool2 = true;
        }
      }
      j += 1;
      bool1 = bool2;
      break label264;
      i = 0;
      break label62;
      label394:
      j = k;
      break label83;
      label400:
      if (this.aZx < this.aZw) {}
      for (i = this.aZx;; i = this.aZw)
      {
        this.aZw = i;
        break;
      }
      label432:
      label590:
      if (f1 <= nns.as[1]) {
        i |= 0x2;
      } else {
        label466:
        label474:
        label730:
        if (f1 <= nns.as[2])
        {
          i |= 0x4;
          continue;
          i |= 0x8;
          continue;
          boolean bool3;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barCommonAdBar != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barCommonAdBar.a() != null))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barCommonAdBar.a();
            bool3 = ((kkk)localObject).afW;
            if (kjx.a((kkk)localObject)) {
              if (!(localObject instanceof kkc)) {
                break label754;
              }
            }
          }
          label602:
          label736:
          label754:
          for (bool2 = ((kkc)localObject).zB();; bool2 = false)
          {
            Integer localInteger;
            if ((((kkk)localObject).type == 2) && (kjx.a(a(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.aZI), this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeight(), this.aZr, bool2, bool1, bool3)))
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barCommonAdBar.setVisibility(0);
              ((kkk)localObject).aaV();
              localObject = nns.dz;
              m = localObject.length;
              j = 0;
              if (j < m)
              {
                localInteger = Integer.valueOf(localObject[j]);
                if ((1 << localInteger.intValue() & i) == 0) {
                  break label730;
                }
                k = 1;
                label632:
                if (k == 0) {
                  break label736;
                }
                kxy.mJ(nns.e(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
              }
            }
            for (;;)
            {
              j += 1;
              break label602;
              break;
              if ((((kkk)localObject).type == 1) && (kjx.a(bool1, this.asO, bool3)) && (((kkk)localObject).a != null) && (((kkk)localObject).a.bac == 1))
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barCommonAdBar.setVisibility(0);
                ((kkk)localObject).aaV();
                break label590;
              }
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barCommonAdBar.setVisibility(8);
              break label590;
              k = 0;
              break label632;
              kxy.mK(nns.e(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
            }
          }
        }
      }
    }
  }
  
  private void aYN()
  {
    this.asX = true;
    this.mColorNoteController.exitAnimation();
    QLog.d(this.TAG, 2, "mColorNoteController ：exitAnimation");
  }
  
  private void aYO()
  {
    this.asX = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.dr(0, 4);
    QLog.d(this.TAG, 2, "mFloating doClostAnimTopToBottom ");
  }
  
  private void aYP()
  {
    if (this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null)
    {
      Parcelable localParcelable = this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        lhu locallhu = ((lcd)this.app.getManager(163)).b().a();
        if (locallhu != null) {
          locallhu.b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", localParcelable);
        }
      }
    }
  }
  
  private void aYQ()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < this.mDatas.size())
    {
      BaseData localBaseData = (BaseData)this.mDatas.get(i);
      if (localBaseData.type == 6) {}
      for (;;)
      {
        i += 1;
        break;
        if (AdData.b(localBaseData))
        {
          localArrayList.add(new ItemShowDispatcher.a(i, Long.valueOf(0L), localBaseData));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(i, new njz(this, i, localBaseData));
        }
        else if (nns.f(localBaseData))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i, new nka(this, localBaseData));
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.bW(localArrayList);
  }
  
  private void aYR()
  {
    if ((this.mDatas == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mDatas.size())
      {
        BaseData localBaseData = (BaseData)this.mDatas.get(i);
        if (ef(localBaseData.type)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i, new nkb(this, localBaseData));
        }
        i += 1;
      }
    }
  }
  
  private void aYS()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher == null) || (this.mDatas == null)) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.Y == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.Y.size() <= 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.Y.iterator();
    label202:
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      int i = 0;
      for (;;)
      {
        if (i >= this.mDatas.size()) {
          break label202;
        }
        if (localInteger.intValue() == i)
        {
          BaseData localBaseData = (BaseData)this.mDatas.get(localInteger.intValue());
          if (AdData.b(localBaseData))
          {
            nns.e(this.app, (AdData)localBaseData);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.TAG, 2, "invalidADExposurePos report " + localInteger);
            break;
          }
          QLog.d(this.TAG, 1, "invalidADExposurePos report invalid key" + localInteger);
          break;
        }
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.Y.clear();
  }
  
  private void aYT()
  {
    int i = qH();
    nns.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, qG(), i, this.asN, this.mChannelID, this.aZJ);
    if (this.jdField_a_of_type_Nle != null) {
      this.jdField_a_of_type_Nle.aEe();
    }
  }
  
  private void aYV()
  {
    long l1 = nnw.L("fast_web_show_light_house_1");
    boolean bool = true;
    if (l1 < 0L) {
      return;
    }
    if (this.isFinish) {
      bool = false;
    }
    long l2 = nnw.L("fast_web_show_light_house_2");
    long l3 = nnw.L("fast_web_show_light_house_3");
    long l4 = nnw.L("fast_web_show_light_house_draw_finish");
    long l5 = nnw.L("fast_web_show_light_house_step4_2");
    long l6 = nnw.L("fast_web_show_light_house_step4_1");
    HashMap localHashMap = new HashMap();
    localHashMap.put("which", "1");
    localHashMap.put("step1", String.valueOf(l2 - l1));
    localHashMap.put("step2", String.valueOf(l3 - l2));
    localHashMap.put("step3", String.valueOf(l4 - l3));
    localHashMap.put("step4", String.valueOf(l5 - l6));
    localHashMap.put("param_uin", kxm.getAccount());
    QLog.d("Q.readinjoy.fast_web", 2, "reportSpentTime, params = " + localHashMap.toString() + "  all cost : " + (l4 - l1));
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebCost", bool, l4 - l1, 0L, localHashMap, null);
  }
  
  private void aYW()
  {
    this.aS.removeCallbacksAndMessages(null);
    QLog.i(this.TAG, 1, "resume timing:  task time has gone: " + this.aGM);
    this.cW = new FastWebActivity.23(this);
    this.aS.post(this.cW);
  }
  
  private void aYX()
  {
    this.aZz = this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
    View localView = this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0);
    int i;
    boolean bool1;
    boolean bool2;
    if (localView == null)
    {
      i = 0;
      this.aZA = i;
      this.aZB = this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition();
      bool1 = eg(this.aZz);
      bool2 = eg(this.aZB);
      if ((bool1) || (bool2)) {
        break label101;
      }
      this.aZC = this.aZz;
      this.aZD = this.aZA;
      this.asS = true;
    }
    label101:
    do
    {
      return;
      i = localView.getTop();
      break;
      if ((bool1) && (bool2))
      {
        this.aZE = this.aZz;
        this.aZF = this.aZA;
        this.asS = false;
        this.asJ = true;
        QLog.d(this.TAG, 1, "upCmtHisPos mCommentAreaLastFirstVisItemPos = " + this.aZE);
        return;
      }
    } while ((bool1) || (!bool2));
    this.asS = false;
    this.asJ = true;
    this.aZC = 0;
    this.aZD = 0;
    QLog.d(this.TAG, 1, "2area show together initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.aZE);
    aYZ();
  }
  
  private void aYu()
  {
    if ((this.ata) && (this.asY)) {
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.3(this), 500L);
    }
  }
  
  private void aYv()
  {
    if (!TextUtils.isEmpty(this.alx))
    {
      this.Vt = "";
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.clearAnimation();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setVisibility(4);
    }
    this.adb = false;
    this.Vs = "";
    this.aT.removeCallbacksAndMessages(null);
    this.f.clearAnimation();
    this.f.setVisibility(4);
    this.kK.setImageResource(2130850361);
  }
  
  private void aYw()
  {
    if ((this.ata) && (this.asY))
    {
      Intent localIntent = getIntent();
      Bundle localBundle = null;
      if (localIntent != null) {
        localBundle = localIntent.getExtras();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout = new CommonSuspensionGestureLayout(this, localBundle);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsAutoSuctionTop(this.atb);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedPopAnim(this.atc);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsStatusImmersive(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContentScrollListener(new nkr(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setViolaGestureListener(new nkx(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(this, 2131377363, 2131363692);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setMaskBackGroundDrawable(getResources().getDrawable(2130842539));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setBackgroundColor(-1);
    }
  }
  
  private void aYx()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      QLog.d(this.TAG, 2, "init color error mArticleInfo is null");
    }
    do
    {
      return;
      this.mColorNoteController = new aeay(this, true, false, true, true, 0);
      this.mColorNoteController.attachToActivity(this);
      this.mColorNoteController.setServiceInfo(new nky(this));
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
        QLog.d(this.TAG, 2, "mColorNoteController ： mOutterRowKey : " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "mTitle : " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle + "mSubscribeName : " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName + "mSubscribeName : " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName);
      }
      this.mColorNoteController.a(new nkz(this));
      this.mColorNoteController.setOnColorNoteCurdListener(new nla(this));
      this.mColorNoteController.setOnPageSwipeListener(new nlb(this));
    } while (this.asY);
    this.mColorNoteController.cVA();
  }
  
  private void aYy()
  {
    kxm.air = false;
    oej.uz(4);
  }
  
  private void aYz()
  {
    kxm.air = false;
    kxm.ais = false;
    this.xD = 0L;
  }
  
  private void aZb()
  {
    try
    {
      nmx.a(this.mDatas, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher, this.ax);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setData(this, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    catch (Exception localException)
    {
      QLog.d(this.TAG, 1, "updateConfigInfo error ! msg=" + localException);
    }
  }
  
  private void aZd()
  {
    if (this.jdField_a_of_type_Nmq.isEmpty()) {}
    nmq.b localb;
    do
    {
      return;
      this.asR = true;
      doOnPause();
      doOnStop();
      aYT();
      this.asR = false;
      localb = this.jdField_a_of_type_Nmq.a();
    } while (localb == null);
    a(localb);
    this.asR = true;
    doOnStart();
    doOnResume();
    this.asR = false;
  }
  
  private void aZe()
  {
    this.jdField_a_of_type_Nmq$b = null;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = null;
    this.asL = false;
    this.jdField_a_of_type_Nlk = null;
    this.isFinish = false;
    this.mDatas = null;
    this.asM = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = null;
    this.asP = false;
    this.asQ = false;
    this.hasShareItemClick = false;
    this.mStartTime = 0L;
    this.aZv = 0;
    this.aZw = 0;
    this.asN = false;
    this.akh = (System.currentTimeMillis() + "");
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDrawFinishedListener(null);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.b(this.h);
    lhu locallhu = lbz.a().a();
    if (locallhu != null)
    {
      locallhu.N(this.jdField_a_of_type_Lhu$a);
      locallhu.N(this.jdField_b_of_type_Lhu$b);
    }
    this.aZy = 0;
  }
  
  private void aZf()
  {
    if ((this.alx == null) || (!this.alx.equals(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))
    {
      aYv();
      if ((this.aIV != 1001) || (kys.dv(this.aZt))) {
        break label149;
      }
    }
    label149:
    for (int i = 1;; i = 0)
    {
      if (((ReadinjoyTabFrame.Dx()) || (i != 0)) && (RIJRedPacketManager.a().Dr()) && (RIJRedPacketManager.a().Dt())) {
        RIJRedPacketManager.a().a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, new nkj(this));
      }
      if ((!TextUtils.isEmpty(this.Vt)) && (RIJRedPacketManager.a().Dt())) {
        this.aT.postDelayed(new FastWebActivity.33(this), 500L);
      }
      this.alx = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
      return;
    }
  }
  
  private void aZg()
  {
    kxm.mH(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder().append("preGotoConversation mActivityStack size = ").append(this.jdField_a_of_type_Nmq.isEmpty()).append("ismain = ");
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      QLog.i(str, 2, bool);
      this.jdField_a_of_type_Nmq.a(new nko(this));
      return;
    }
  }
  
  private void aZh()
  {
    ThreadManager.getUIHandler().post(new FastWebActivity.42(this));
  }
  
  private void aZi()
  {
    Object localObject = getIntent();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((Intent)localObject).getExtras();
    } while (localObject == null);
    this.ata = ((Bundle)localObject).getBoolean("launch_from_floating_window", false);
    if (this.ata)
    {
      this.atb = ((Bundle)localObject).getBoolean("scroll_to_top", true);
      this.atc = ((Bundle)localObject).getBoolean("up_animation", true);
      this.aZJ = ((Bundle)localObject).getInt("floating_window_scene", -1);
    }
    QLog.d(this.TAG, 1, "mFloating initFloatingWindow,isFromFloatingLayer=" + this.ata + "  isSuctionTop=" + this.atb);
  }
  
  private void aZj()
  {
    int i = (int)(kxm.a(this)[0] / 16.0F * 9.0F);
    if ((i > 0) && (this.mO != null) && ((this.mO.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
      ((RelativeLayout.LayoutParams)this.mO.getLayoutParams()).topMargin = i;
    }
  }
  
  private void b(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    int i = (int)paramArticleInfo.mChannelID;
    Object localObject;
    if (paramFastWebArticleInfo.FP())
    {
      localObject = "2";
      localObject = kxm.a(this, paramArticleInfo, i, (String)localObject);
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("comment", paramFastWebArticleInfo.sN);
        if (!this.asV) {
          continue;
        }
        i = 1;
        ((JSONObject)localObject).put("click_src", i);
        if ((this.ata) && (this.aZJ != -1)) {
          ((JSONObject)localObject).put("source_extratype", this.aZJ);
        }
      }
      catch (JSONException paramFastWebArticleInfo)
      {
        paramFastWebArticleInfo.printStackTrace();
        continue;
      }
      nns.c(paramArticleInfo, "0X8008989", ((JSONObject)localObject).toString());
      aYU();
      return;
      localObject = "1";
      break;
      i = 0;
    }
  }
  
  private void b(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2)
  {
    if ((paramBoolean) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.articleId.equals(paramString)))
    {
      paramString = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList2.iterator();
      while (localIterator.hasNext())
      {
        BaseData localBaseData = (BaseData)localIterator.next();
        if (localBaseData.ato) {
          paramString.add(localBaseData);
        } else {
          localArrayList.add(localBaseData);
        }
      }
      nnn.a(this.mDatas, paramList1, paramString, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, true, this.ax, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      nnn.a(this.mDatas, paramList1, localArrayList, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, false, this.ax, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      paramString = lbz.a().a();
      if (paramString != null) {
        paramString.h(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.rowKey, this.mDatas);
      }
      aYQ();
      nnn.de(this.mDatas);
      if (this.jdField_a_of_type_Nlc != null) {
        this.jdField_a_of_type_Nlc.notifyDataSetChanged();
      }
      kjx.a(this, this.lG, this.jdField_b_of_type_Jzi, paramList2);
      kjx.a(this, this.lG, this.jdField_b_of_type_Jzi, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barCommonAdBar, paramList2);
      QLog.d(this.TAG, 1, "adback initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.aZE);
      aYZ();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.l(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 0);
    }
  }
  
  private ArticleInfo d()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return null;
    }
    ArticleInfo localArticleInfo = new ArticleInfo();
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.kn != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.kn.size() > 0)) {
      localArticleInfo.businessId = ((ArticleTopicData.a)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.kn.get(0)).vr;
    }
    localArticleInfo.innerUniqueID = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
    localArticleInfo.mRecommendSeq = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq;
    localArticleInfo.mAlgorithmID = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID;
    localArticleInfo.mChannelID = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
    localArticleInfo.mStrategyId = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
    localArticleInfo.mTitle = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
    localArticleInfo.mSubscribeName = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
    localArticleInfo.mFirstPagePicUrl = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl;
    localArticleInfo.mArticleID = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
    localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c = new SocializeFeedsInfo.c();
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.y = Long.valueOf(0L);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z = Long.valueOf(1L);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT = new ArrayList();
    return localArticleInfo;
  }
  
  private void eR(long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new FastWebActivity.36(this), paramLong);
  }
  
  private String ec(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return Uri.parse(paramString).getQueryParameter("redpackid");
    }
    return "";
  }
  
  private boolean ef(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean eg(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    int j;
    if (this.jdField_a_of_type_Nlc != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Nlc.bh().size() > 0)
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      BaseAdapter localBaseAdapter;
      if (i < this.jdField_a_of_type_Nlc.bh().size())
      {
        localBaseAdapter = (BaseAdapter)this.jdField_a_of_type_Nlc.bh().get(i);
        if (((localBaseAdapter instanceof ksm)) && (paramInt >= j) && (paramInt < localBaseAdapter.getCount() + j)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      j += localBaseAdapter.getCount();
      i += 1;
    }
  }
  
  private boolean eh(int paramInt)
  {
    if ((this.mDatas != null) && (this.mDatas.size() > 0) && (paramInt > 0) && (paramInt < this.mDatas.size())) {
      return nmy.e((BaseData)this.mDatas.get(paramInt));
    }
    return false;
  }
  
  private float getRatio()
  {
    if (this.jdField_a_of_type_Nlk == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0.0F;
    }
    if (this.aZv <= 0) {
      aYM();
    }
    int i = qG();
    int j = qH();
    if ((i >= j) || (j <= 0)) {
      return 1.0F;
    }
    return i / j;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private void init()
  {
    try
    {
      this.mN = findViewById(2131377472);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.mN.setFitsSystemWindows(true);
        this.mN.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      if (ThemeUtil.isInNightMode(kxm.getAppRuntime()))
      {
        if (this.jE == null) {
          this.jE = ((ViewStub)findViewById(2131376763)).inflate();
        }
        this.jE.setVisibility(0);
      }
      this.mTitleView = ((TextView)findViewById(2131369627));
      findViewById(2131369579).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew = ((ReadInJoyFastWebBottomSocialViewNew)findViewById(2131363692));
      this.mTitleView.setOnClickListener(this);
      this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)findViewById(2131382393));
      this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEdgeEffectEnabled(true);
      this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowTop.ah(getResources().getDrawable(2131167595));
      this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowBottom.ah(getResources().getDrawable(2131167595));
      this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollTouchMode(1);
      this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollFlingMode(1);
      this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDescendantFocusability(262144);
      aYA();
      aYB();
      this.jdField_a_of_type_Aqdf = new aqdf(this, (QQAppInterface)kxm.getAppRuntime());
      this.jdField_a_of_type_Aqdf.a(this);
      this.oR = ((TextView)findViewById(2131380622));
      if (this.oR.getPaint() != null) {
        this.oR.getPaint().setFakeBoldText(true);
      }
      this.mMaskView = findViewById(2131371166);
      this.mMaskView.setOnClickListener(this);
      aYC();
      aYD();
      findViewById(2131377294).setOnClickListener(this);
      this.oS = ((TextView)findViewById(2131366995));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$b = new b(this);
      aDy();
      initData();
      aZi();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      setResult(-10069, getIntent());
      finish();
    }
  }
  
  private void initData()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)
    {
      aYG();
      return;
    }
    HashMap localHashMap = new HashMap();
    boolean bool;
    try
    {
      aYE();
      nnw.K("fast_web_show_light_house_step4_1");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData.aZq();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData.oh(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.amm);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.pR(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.oh(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.amm);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.aZq();
      this.mDatas = lbz.a().a().C(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.rowKey);
      if (this.mDatas == null)
      {
        nnw.J("HtmlChangeUtil.parse");
        if (this.ax == null) {
          this.ax = nmx.d();
        }
        this.mDatas = nnl.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.ax);
        aBh();
        if ((this.mDatas == null) || (this.mDatas.isEmpty())) {
          throw new RuntimeException("parse data is empty!");
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e(this.TAG, 1, "has parse error, use webview open url! e=" + localException);
      localHashMap.put("param_error", localException.toString());
      bool = false;
    }
    for (;;)
    {
      localHashMap.put("param_uin", kxm.getAccount());
      localHashMap.put("param_url", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
      localHashMap.put("param_articleID", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
      localHashMap.put("param_rowkey", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "");
      localHashMap.put("param_channelID", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actNativeWebParser", bool, 100L, 0L, localHashMap, "", true);
      Object localObject1;
      Object localObject2;
      int i;
      Object localObject3;
      if (!bool)
      {
        pO(false);
        aYH();
        lcc.a().b(this.l);
        kgi.a().a(5555, this);
        kgi.a().a(6666, this);
        aYZ();
        new npl().ot("native_article");
        aGL();
        QLog.d(this.TAG, 1, "initData,isParseSuccess=" + bool);
        return;
        this.mDatas.add(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData);
        this.mDatas.add(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.da(this.mDatas);
        localObject1 = this.mDatas.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (BaseData)((Iterator)localObject1).next();
          ((BaseData)localObject2).articleInfo = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          ((BaseData)localObject2).d = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
        }
        nnw.J("HtmlChangeUtil.parse");
        i = 0;
        nnn.a(this.mDatas, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
        this.aZH = 0;
        localObject1 = this.mDatas.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (BaseData)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((localObject2 instanceof ProteusItemData)))
          {
            localObject3 = (ProteusItemData)localObject2;
            if ((((ProteusItemData)localObject3).mModuleType == 1) && ((((ProteusItemData)localObject3).bad == 1) || (((ProteusItemData)localObject3).bad == 2)) && (((BaseData)localObject2).type != 0))
            {
              this.aZH += 1;
              continue;
              if ((this.mDatas.size() >= 2) && ((this.mDatas.get(0) instanceof TitleData)) && ((this.mDatas.get(1) instanceof AuthorData)))
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = ((TitleData)this.mDatas.get(0));
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData.oh(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.amm);
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = ((AuthorData)this.mDatas.get(1));
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.pR(false);
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.oh(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.amm);
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.aBI();
              }
              for (;;)
              {
                if ((this.aIV != 1001) && (this.jdField_a_of_type_Nmq$b == null)) {
                  nnn.dj(this.mDatas);
                }
                nnn.dk(this.mDatas);
                i = 1;
                break;
                wja.a("Q.readinjoy.fast_web", "  " + this.mDatas.size() + "  :  " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, new IllegalArgumentException());
              }
            }
          }
        }
        nnw.K("fast_web_show_light_house_step4_2");
        this.jdField_a_of_type_Nlc = new nlc();
        this.jdField_a_of_type_Nlk = new nlk(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.mDatas, this.jdField_a_of_type_Nlc);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_Nlk);
        this.jdField_a_of_type_Nle = new nle(this, this.mDatas, this.jdField_a_of_type_Aqdf);
        this.jdField_a_of_type_Nle.registerDataSetObserver(new njq(this));
        this.jdField_a_of_type_Nlc.f(this.jdField_a_of_type_Nle);
        if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.FO())) {
          aYF();
        }
        if (this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFooterViewsCount() == 0) {
          this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.initFooterView();
        }
        this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$a);
        this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.h);
        this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_Nlc);
        this.jdField_a_of_type_Nlc.a(this.jdField_a_of_type_Nlc$a);
        this.mO = findViewById(2131377881);
        aZj();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.mN);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.mN, true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setFirstLevelCommentContainer(this, false);
        localObject2 = lbz.a().a();
        if (this.jdField_a_of_type_Nmq$b != null)
        {
          localObject1 = this.jdField_a_of_type_Nmq$b.d;
          label1215:
          if (localObject1 == null) {
            break label1369;
          }
          localObject1 = (AbsListView.SavedState)localObject1;
          this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onRestoreInstanceState((Parcelable)localObject1);
          tK(((AbsListView.SavedState)localObject1).position);
          label1240:
          if ((this.aIV == 1001) || (this.jdField_a_of_type_Nmq$b != null)) {
            break label1430;
          }
        }
      }
      label1369:
      while (i == 0)
      {
        localObject1 = this.mDatas.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (BaseData)((Iterator)localObject1).next();
          if ((localObject3 instanceof ProteusBannerVideoItemData)) {
            ((ProteusBannerVideoItemData)localObject3).isShowingGuide = false;
          }
        }
        if (localObject2 == null) {
          break label1437;
        }
        ((lhu)localObject2).a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Lhu$a, true);
        break label1437;
        if (localObject2 != null)
        {
          localObject1 = ((lhu)localObject2).a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
          break label1215;
          tK(0);
          break label1240;
          pO(true);
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.I(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          lcc.a().b(this.mObserver);
          if (!this.asK) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.aWo();
          this.asK = false;
          break;
        }
        localObject1 = null;
        break label1215;
      }
      label1430:
      label1437:
      bool = true;
    }
  }
  
  private void l(View paramView, boolean paramBoolean)
  {
    if ((paramView == null) || ((paramBoolean) && (paramView.getVisibility() == 0)) || ((!paramBoolean) && (paramView.getVisibility() != 0))) {
      return;
    }
    if (paramBoolean) {}
    for (AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);; localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F))
    {
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new nkg(this, paramBoolean, paramView));
      paramView.startAnimation(localAlphaAnimation);
      return;
    }
  }
  
  private void nK()
  {
    Object localObject = findViewById(2131374329);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = (TextView)findViewById(2131376746);
    if ((localObject != null) && (!TextUtils.isEmpty("")))
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText("");
    }
  }
  
  private void pN(boolean paramBoolean)
  {
    if (this.asZ) {}
    do
    {
      return;
      this.asZ = true;
      int j = this.jdField_a_of_type_Nmq.qJ();
      QLog.d(this.TAG, 2, "mColorNoteController ：finishOneByOne  size:" + j);
      int i = 0;
      while (i < j)
      {
        finish();
        i += 1;
      }
      finish();
    } while ((!this.ata) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout == null) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.bbl();
  }
  
  private void pO(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setData(this, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setVisibility(8);
  }
  
  private int qG()
  {
    return V(this.aZv, this.aZw);
  }
  
  private int qH()
  {
    int k;
    if (this.jdField_a_of_type_Nlk == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      k = -1;
      return k;
    }
    int j = 0;
    for (int i = 0;; i = k)
    {
      k = i;
      if (j >= this.mDatas.size()) {
        break;
      }
      k = i;
      if (nmy.e((BaseData)this.mDatas.get(j))) {
        k = i + this.jdField_a_of_type_Nlk.get(j);
      }
      j += 1;
    }
  }
  
  private void tK(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) && (!this.atd))
    {
      this.mTitleView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.accountName);
      return;
    }
    this.mTitleView.setText("");
  }
  
  private void tL(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (this.ata))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setVisibility(paramInt);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.bbk();
    }
  }
  
  public kjt a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Iterator localIterator = this.lG.iterator();
    while (localIterator.hasNext())
    {
      kjt localkjt = (kjt)localIterator.next();
      if ((localkjt != null) && (localkjt.b != null) && (localkjt.b.mPackageName != null) && (localkjt.b.mPackageName.equals(paramString))) {
        return localkjt;
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    ArticleInfo localArticleInfo = d();
    if (localArticleInfo == null)
    {
      QLog.d(this.TAG, 1, "generateBiuArticleInfo fail !");
      return;
    }
    Intent localIntent = new Intent(this, ReadInJoyDeliverBiuActivity.class);
    localIntent.putExtra("arg_article_info", localArticleInfo);
    localIntent.putExtra("biu_src", 4);
    localIntent.putExtra("arg_from_type", paramInt1);
    localIntent.putExtra("arg_biu_state", paramInt2);
    localIntent.putExtra("feedsType", 1);
    localIntent.putExtra("fast_biu_type", paramBoolean1);
    localIntent.putExtra("should_show_dialog", paramBoolean2);
    localIntent.putExtra("is_modified_biu", paramBoolean3);
    localIntent.putExtra("modified_feeds_id", paramLong);
    startActivityForResult(localIntent, 2002);
    overridePendingTransition(0, 0);
  }
  
  public void a(BubblePopupWindow paramBubblePopupWindow)
  {
    this.g = paramBubblePopupWindow;
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
        break label115;
      }
      if ((!aqfo.isMIUI()) && (!aqfo.isFlyme())) {
        this.mSystemBarComp.setStatusBarColor(-7829368);
      }
    }
    else
    {
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-7829368);
    this.mSystemBarComp.setStatusBarDarkMode(true);
    return;
    label115:
    if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
    {
      lU(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!aqfo.isFlyme())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public void aT(Intent paramIntent)
  {
    this.asR = true;
    doOnPause();
    doOnStop();
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      E(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    if (this.jdField_a_of_type_Nle != null) {
      this.jdField_a_of_type_Nle.onDestroy();
    }
    this.asR = false;
    nmq.b localb = new nmq.b();
    localb.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    localb.d = this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
    localb.akh = this.akh;
    localb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    localb.asN = this.asN;
    localb.jdField_a_of_type_Nlj = this.jdField_a_of_type_Nlj;
    this.jdField_a_of_type_Nmq.c(localb);
    this.akh = (kxm.getAccount() + System.currentTimeMillis());
    aU(paramIntent);
    this.asR = true;
    doOnStart();
    doOnResume();
    this.asR = false;
  }
  
  public void aYJ()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("arg_article_info", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    localIntent.putExtra("readinjoy_open_comment_from_image", true);
    PublicFragmentActivity.startForResult(this, localIntent, ReadInJoyCommentListFragment.class, 1001);
  }
  
  protected void aYU()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (localObject2 != null)
    {
      Object localObject3 = ((ArticleInfo)localObject2).mSocialFeedInfo;
      localObject1 = new ReportInfo.a();
      localReportInfo.mUin = kxm.getLongAccountUin();
      localReportInfo.mSource = ((int)((ArticleInfo)localObject2).mChannelID);
      localReportInfo.mSourceArticleId = ((ArticleInfo)localObject2).mArticleID;
      localReportInfo.mChannelId = ((int)((ArticleInfo)localObject2).mChannelID);
      localReportInfo.mAlgorithmId = ((int)((ArticleInfo)localObject2).mAlgorithmID);
      localReportInfo.mStrategyId = ((ArticleInfo)localObject2).mStrategyId;
      localReportInfo.mServerContext = ((ArticleInfo)localObject2).mServerContext;
      localReportInfo.mInnerId = ((ArticleInfo)localObject2).innerUniqueID;
      localReportInfo.mReadTimeLength = -1;
      if (localObject3 != null)
      {
        ((ReportInfo.a)localObject1).vd = ((SocializeFeedsInfo)localObject3).mFeedId;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
          ((ReportInfo.a)localObject1).vg = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
        }
        ((ReportInfo.a)localObject1).aSx = ((SocializeFeedsInfo)localObject3).mLikeCount;
        ((ReportInfo.a)localObject1).aSy = ((SocializeFeedsInfo)localObject3).mCommentCount;
        localObject2 = ((SocializeFeedsInfo)localObject3).iS;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((ReportInfo.a)localObject1).iR = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SocializeFeedsInfo.e)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((ReportInfo.a)localObject1).iR.add(Long.valueOf(((SocializeFeedsInfo.e)localObject3).uin));
            }
          }
        }
      }
      localReportInfo.mOperation = 29;
      localReportInfo.mOpSource = 12;
      localReportInfo.mFeedsReportData = ((ReportInfo.a)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    lbz.a().cb((List)localObject1);
  }
  
  public void aYY()
  {
    Object localObject = new ksz.c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).b(1);
    QLog.d(this.TAG, 1, "scrollToLastReadPos | begin");
    if (this.asS)
    {
      QLog.d(this.TAG, 1, "Scroll2CommentArea");
      if (this.aZE == 0)
      {
        kbp.a((QQAppInterface)getAppInterface(), ksz.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009C69", "0X8009C69", 0, 0, String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, "", false);
        QLog.d(this.TAG, 1, "mCommentAreaLastFirstVisItemPos == 0 return");
        return;
      }
      this.aZG = 2;
      this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.aZE, this.aZF);
      this.asS = false;
      this.asJ = true;
      ((ksz.c)localObject).e(1);
      this.jdField_c_of_type_Kxy.wakeUp();
      localObject = ((ksz.c)localObject).build();
      kbp.a((QQAppInterface)getAppInterface(), ksz.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
    }
    for (;;)
    {
      QLog.d(this.TAG, 1, "scrollToLastReadPos | done");
      return;
      QLog.d(this.TAG, 1, "Scroll2ArticleArea");
      this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.aZC, this.aZD);
      this.asS = true;
      ((ksz.c)localObject).e(2);
      localObject = ((ksz.c)localObject).build();
      kbp.a((QQAppInterface)getAppInterface(), ksz.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
      this.jdField_c_of_type_Kxy.aIc();
    }
  }
  
  public void aYZ()
  {
    if (this.jdField_a_of_type_Nle != null) {}
    for (int i = this.jdField_a_of_type_Nle.getCount();; i = 0)
    {
      this.aZE = i;
      this.aZF = 0;
      QLog.d(this.TAG, 1, "initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.aZE);
      return;
    }
  }
  
  public void aZa()
  {
    nnn.dg(this.mDatas);
    this.jdField_a_of_type_Nlc.notifyDataSetChanged();
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.aGP();
  }
  
  public void aZc()
  {
    if ((this.g != null) && (this.g.isShowing())) {
      this.g.dismiss();
    }
  }
  
  public void b(BaseData paramBaseData)
  {
    runOnUiThread(new FastWebActivity.35(this, paramBaseData));
  }
  
  public void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.mN);
    }
    if (paramBoolean)
    {
      if ((this.asY) && (this.mColorNoteController != null)) {
        this.mColorNoteController.cVA();
      }
      this.mMaskView.setVisibility(0);
      new Bundle().putBoolean("arg_comment_list_biu_btn", false);
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.setCustomAnimations(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramString1, paramString2, 1);
      localFragmentTransaction.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      this.asI = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.b());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.mO, false);
      this.jdField_c_of_type_Kxy.aIc();
      tL(8);
      return;
    }
    if ((this.asY) && (this.mColorNoteController != null)) {
      this.mColorNoteController.cVB();
    }
    this.mMaskView.setVisibility(8);
    this.jdField_c_of_type_Kxy.wakeUp();
    paramString1 = getSupportFragmentManager().beginTransaction();
    paramString1.setCustomAnimations(paramInt1, paramInt2);
    paramString1.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
    paramString1.commitAllowingStateLoss();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.aHi();
    this.asI = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.mN, true);
    this.jdField_a_of_type_Nlc.notifyDataSetChanged();
    tL(0);
  }
  
  public List<Integer>[] b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return null;
    }
    Object localObject = aurr.getArgumentsFromURL(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    if (((Map)localObject).containsKey("_wv")) {}
    for (;;)
    {
      try
      {
        int i = Integer.valueOf((String)((Map)localObject).get("_wv")).intValue();
        if (!((Map)localObject).containsKey("_wwv")) {
          break label562;
        }
        ArrayList localArrayList;
        i = 0;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        try
        {
          j = Integer.valueOf((String)((Map)localObject).get("_wwv")).intValue();
          localObject = new ArrayList();
          ((List)localObject).add(Integer.valueOf(13));
          if ((i & 0x8) == 0L) {
            ((List)localObject).add(Integer.valueOf(2));
          }
          if ((i & 0x10) == 0L) {
            ((List)localObject).add(Integer.valueOf(3));
          }
          if ((i & 0x4000) == 0L) {
            ((List)localObject).add(Integer.valueOf(9));
          }
          if ((i & 0x8000) == 0L) {
            ((List)localObject).add(Integer.valueOf(10));
          }
          ((List)localObject).add(Integer.valueOf(12));
          ((List)localObject).add(Integer.valueOf(26));
          ((List)localObject).add(Integer.valueOf(5));
          if ((i & 0x100) == 0L) {
            ((List)localObject).add(Integer.valueOf(4));
          }
          localArrayList = new ArrayList();
          if ((!TextUtils.isEmpty(localAppRuntime.getAccount())) && ((i & 0x2000) == 0L)) {
            localArrayList.add(Integer.valueOf(6));
          }
          localArrayList.add(Integer.valueOf(21));
          localArrayList.add(Integer.valueOf(7));
          if ((i & 0x20) == 0L) {
            localArrayList.add(Integer.valueOf(1));
          }
          localArrayList.add(Integer.valueOf(11));
          Collections.sort(localArrayList);
          if (((j & 0x4000) == 0L) && (aoag.pL(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl)))
          {
            j = localArrayList.indexOf(Integer.valueOf(6));
            i = j;
            if (j < 0) {
              i = localArrayList.indexOf(Integer.valueOf(1));
            }
            if (i >= 0)
            {
              if (i >= localArrayList.size() - 1) {
                break label567;
              }
              localArrayList.add(i + 1, Integer.valueOf(68));
              aoag.jI(0, 2);
            }
          }
          if ((this.mColorNoteController != null) && (this.mColorNoteController.shouldDisplayColorNote()) && (this.asY))
          {
            if (!this.mColorNoteController.isColorNoteExist()) {
              break label583;
            }
            localArrayList.add(0, Integer.valueOf(82));
            QLog.d(this.TAG, 2, "mColorNoteController ： open sheet delete colorNote");
          }
          return new List[] { localObject, localArrayList };
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          localNumberFormatException1.printStackTrace();
        }
        localNumberFormatException2 = localNumberFormatException2;
        localNumberFormatException2.printStackTrace();
      }
      continue;
      label562:
      int j = 0;
      continue;
      label567:
      localNumberFormatException2.add(Integer.valueOf(68));
      continue;
      label583:
      localNumberFormatException2.add(0, Integer.valueOf(70));
      QLog.d(this.TAG, 2, "mColorNoteController ： open sheet add colorNote");
    }
  }
  
  public void cw(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      findViewById(2131371166).setVisibility(8);
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.setCustomAnimations(2130771993, 2130772028);
      localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      this.asI = false;
      this.aLC = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.mN, true);
    }
  }
  
  public void doOnBackPressed()
  {
    if ((this.mShareHelper != null) && (this.mShareHelper.GD())) {}
    do
    {
      return;
      this.asP = true;
    } while (onBackEvent());
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    VideoReport.addToDetectionWhitelist(this);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    VideoReport.setPageId(this, "8001");
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null) {
      if (paramBundle != null)
      {
        localBundle = paramBundle.getBundle("bundle_key_save_instancestate");
        if (localBundle == null)
        {
          wja.a("Q.readinjoy.fast_web", "  " + paramBundle, new IllegalArgumentException());
          finish();
          return true;
        }
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebdoOnCreateSucc", true, 0L, 0L, null, null);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localBundle.get("fast_web_article_info"));
      this.aZs = localBundle.getInt("fast_web_from_channel_id");
      this.asV = getIntent().getBooleanExtra("from_color_note", false);
      QLog.d(this.TAG, 1, "is from colorNote : " + this.asV);
      this.asY = aeej.agw();
      Object localObject;
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
      {
        localObject = localBundle.getBundle("banner_webview_extra");
        if ((localObject != null) && (((Bundle)localObject).get("fast_web_article_info") != null))
        {
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)((Bundle)localObject).get("fast_web_article_info"));
          this.aZt = ((Bundle)localObject).getInt("fast_web_banner_from_channel_id");
          this.aIV = 1001;
          this.asN = ((Bundle)localObject).getBoolean("fast_web_from_article_recommend", false);
        }
      }
      else
      {
        this.mStrategyId = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
        this.mAlgorithmID = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID;
        this.xB = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
        this.alw = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
        this.mChannelID = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        this.akh = (kxm.getAccount() + System.currentTimeMillis());
        localObject = getSupportFragmentManager();
        if ((paramBundle == null) || (localObject == null)) {
          break label446;
        }
        paramBundle = ((FragmentManager)localObject).getFragments();
        if ((paramBundle == null) || (paramBundle.size() <= 0)) {
          break label446;
        }
        localObject = ((FragmentManager)localObject).beginTransaction();
        paramBundle = paramBundle.iterator();
      }
      while (paramBundle.hasNext())
      {
        ((FragmentTransaction)localObject).remove((Fragment)paramBundle.next());
        continue;
        setResult(-10069, getIntent());
        finish();
        return true;
      }
      ((FragmentTransaction)localObject).commit();
      label446:
      kbp.a(null, "CliOper", "", "", "0X8009C4F", "0X8009C4F", 0, 0, "", Long.toString(this.xB), Integer.toString(this.mStrategyId), "", false);
      try
      {
        setContentView(2131560363);
        init();
        if (this.jdField_a_of_type_Nle != null) {
          this.jdField_a_of_type_Nle.onCreate();
        }
        aYw();
        aYx();
        this.ax = nmx.d();
        this.Vt = ec(localBundle.getString("float_layer_article_url"));
        QLog.i(this.TAG, 1, " redpackId: " + this.Vt);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView = ((RIJRedPacketProgressView)findViewById(2131377011));
        this.f = ((RIJRedPacketPopupView)findViewById(2131377012));
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView = new RIJRedPacketPopupView(this);
        paramBundle = getWindow().getDecorView();
        if ((paramBundle instanceof ViewGroup))
        {
          ((ViewGroup)paramBundle).addView(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView);
          if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.getLayoutParams() != null)
          {
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.getLayoutParams().height = -2;
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.getLayoutParams().width = -2;
          }
        }
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setVisibility(4);
        this.f.setVisibility(4);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.setVisibility(8);
        this.kK = ((ImageView)findViewById(2131377294));
        return true;
      }
      catch (OutOfMemoryError paramBundle)
      {
        for (;;)
        {
          BaseApplicationImpl.sImageCache.evict(0);
          try
          {
            setContentView(2131560363);
            init();
          }
          catch (Throwable paramBundle)
          {
            finish();
          }
        }
      }
      break;
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      kxy.mK(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      if ((this.jdField_c_of_type_Ksm != null) && (this.jdField_c_of_type_Ksm.a() != null))
      {
        localObject = this.jdField_c_of_type_Ksm.a();
        ((ksx)localObject).W(this.jdField_c_of_type_Kxy.cq(), this.aZG);
        ((ksx)localObject).cx(0, this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition() - this.jdField_a_of_type_Nle.getCount());
      }
    }
    lcc.a().c(this.mObserver);
    lcc.a().c(this.l);
    if (this.jdField_a_of_type_Nle != null) {
      this.jdField_a_of_type_Nle.onDestroy();
    }
    if (this.jdField_a_of_type_Nlc != null) {
      this.jdField_a_of_type_Nlc.destory();
    }
    if (this.jdField_c_of_type_Ksm != null) {
      this.jdField_c_of_type_Ksm.onDestroy();
    }
    aYT();
    super.doOnDestroy();
    if (this.jdField_b_of_type_Svi != null) {
      this.jdField_b_of_type_Svi.destroy();
    }
    this.jdField_b_of_type_Svi = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.aZs();
    }
    if (this.jdField_a_of_type_Nnu != null) {
      this.jdField_a_of_type_Nnu.onDestroy();
    }
    if (this.mShareHelper != null) {
      this.mShareHelper.onDestroy();
    }
    nno.aZz();
    if (this.jdField_a_of_type_Aqdf != null)
    {
      this.jdField_a_of_type_Aqdf.a(null);
      this.jdField_a_of_type_Aqdf = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.onDestory();
    }
    mst.a().anP = false;
    Object localObject = lbz.a().a();
    if (localObject != null) {
      ((lhu)localObject).aEL();
    }
    if (this.d != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.d);
    }
    if (this.jdField_b_of_type_Jzi != null) {
      this.jdField_b_of_type_Jzi.doOnDestory();
    }
    localObject = this.lG.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((kjt)((Iterator)localObject).next()).doOnDestroy();
    }
    aYL();
    if (this.mMiniMsgUser != null)
    {
      this.mMiniMsgUser.onBackground();
      if (!this.asU) {
        znx.Fq(this.mMiniMsgUser.getParam().businessName);
      }
    }
    this.jdField_b_of_type_Nng.onDestroy();
    this.jdField_b_of_type_Nng = null;
    kgi.a().b(5555, this);
    kgi.a().b(6666, this);
    if (this.mColorNoteController != null)
    {
      this.mColorNoteController.onDestroy();
      QLog.d(this.TAG, 2, "mColorNoteController.onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      ReadInJoyUserInfoModule.np(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.hH);
    }
    if (this.jdField_a_of_type_Kqd != null) {
      this.jdField_a_of_type_Kqd.clear();
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      E(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (boolean bool = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);; bool = false)
    {
      if ((paramIntent != null) && (!bool)) {
        aT(paramIntent);
      }
      super.doOnNewIntent(paramIntent);
      if ((paramIntent != null) && (bool))
      {
        paramIntent.removeExtra("PhotoConst.SEND_FLAG");
        Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = (String)((ArrayList)localObject).get(0);
          if (this.jdField_a_of_type_Nnu == null) {
            this.jdField_a_of_type_Nnu = new nnu(this);
          }
          this.jdField_a_of_type_Nnu.setUrl(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
          this.jdField_a_of_type_Nnu.m((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
        }
      }
      return;
    }
  }
  
  public void doOnPause()
  {
    if (!this.asR) {
      super.doOnPause();
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.asM)) {
      return;
    }
    AbstractGifImage.pauseAll();
    Object localObject2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    Object localObject1;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.FP()) {
      localObject1 = "2";
    }
    for (;;)
    {
      localObject1 = kxm.a(this, (ArticleInfo)localObject2, 0, (String)localObject1);
      try
      {
        float f1 = (float)(System.currentTimeMillis() - this.mStartTime) / 1000.0F;
        float f2 = getRatio();
        ((JSONObject)localObject1).put("read_time", f1);
        ((JSONObject)localObject1).put("read_ratio", f2);
        ((JSONObject)localObject1).put("session_id", this.akh);
        ((JSONObject)localObject1).put("channel_id", "" + nns.a(this.asN, this.mChannelID));
        QLog.d("Q.readinjoy.fast_web", 2, "  time " + f1 + "  ratio : " + f2 + " session : " + this.akh);
        nns.c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898E", ((JSONObject)localObject1).toString());
        long l1 = System.currentTimeMillis() - this.rV;
        if (!this.asR) {}
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("folder_status", kxm.aMw);
          ((JSONObject)localObject1).put("algorithm_id", this.mAlgorithmID);
          ((JSONObject)localObject1).put("feeds_friends_interaction", 0);
          ((JSONObject)localObject1).put("session_id", this.akh);
          ((JSONObject)localObject1).put("os", "1");
          ((JSONObject)localObject1).put("version", "3.4.4".replace(".", ""));
          ((JSONObject)localObject1).put("rowkey", this.alw);
          localObject2 = ((JSONObject)localObject1).toString();
          if (!odv.aT(this.mChannelID)) {
            break label728;
          }
          localObject1 = "0X8009359";
          kbp.a(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, Long.toString(l1 / 1000L), Long.toString(this.xB), Integer.toString(this.mStrategyId), (String)localObject2, false);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("Q.readinjoy.fast_web", 2, localJSONException, new Object[] { "0X80066FB!" });
            continue;
            int i = 0;
          }
        }
        localObject1 = new ArrayList();
        localObject2 = new ReportInfo();
        ((ReportInfo)localObject2).mUin = kxm.getLongAccountUin();
        ((ReportInfo)localObject2).mSource = 0;
        ((ReportInfo)localObject2).mSourceArticleId = this.xB;
        ((ReportInfo)localObject2).mChannelId = ((int)this.mChannelID);
        ((ReportInfo)localObject2).mAlgorithmId = ((int)this.mAlgorithmID);
        ((ReportInfo)localObject2).mStrategyId = this.mStrategyId;
        ((ReportInfo)localObject2).mOperation = 9;
        ((ReportInfo)localObject2).mOpSource = 12;
        ((ReportInfo)localObject2).mReadTimeLength = ((int)(l1 / 1000L));
        ((ReportInfo)localObject2).mInnerId = this.alw;
        i = qH();
        ((ReportInfo)localObject2).mArticleLength = i;
        ((ReportInfo)localObject2).mReadArticleLength = ((int)(i * getRatio()));
        ((List)localObject1).add(localObject2);
        ThreadManager.getSubThreadHandler().post(new FastWebActivity.18(this, (List)localObject1));
        if (this.jdField_a_of_type_Nle != null) {
          this.jdField_a_of_type_Nle.onPause();
        }
        if (kxm.ais) {
          this.xD = System.currentTimeMillis();
        }
        if ((this.mMiniMsgUser != null) && (!this.asT)) {
          this.mMiniMsgUser.onBackground();
        }
        if (this.mColorNoteController != null)
        {
          this.mColorNoteController.onPause();
          QLog.d(this.TAG, 2, "mColorNoteController.onPause");
        }
        if ((this.aIV == 1001) && (!kys.dv(this.aZt)))
        {
          i = 1;
          if (((ReadinjoyTabFrame.Dx()) || (i != 0)) && (RIJRedPacketManager.a().Dr()) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.getVisibility() == 0)) {
            aBz();
          }
          this.aGM = 0;
          return;
          localObject1 = "1";
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("Q.readinjoy.fast_web", 2, localException, new Object[] { "doOnPause" });
          continue;
          label728:
          localObject1 = "0X80066FB";
        }
      }
    }
  }
  
  public void doOnResume()
  {
    int j = 0;
    if (!this.asR) {
      super.doOnResume();
    }
    if (!this.asR) {
      this.rV = System.currentTimeMillis();
    }
    nnw.K("fast_web_show_light_house_3");
    aCM();
    AbstractGifImage.resumeAll();
    this.mStartTime = System.currentTimeMillis();
    if (this.jdField_a_of_type_Nlc != null) {
      this.jdField_a_of_type_Nlc.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_Nle != null) {
      this.jdField_a_of_type_Nle.onResume();
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      kxy.mJ(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      lbz.a().mR(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this, this.jdField_c_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (kxm.ais)
    {
      if (kxm.air) {
        kxm.E(4, this.xD);
      }
      aYz();
    }
    aYy();
    if (this.mMiniMsgUser != null)
    {
      this.asT = false;
      this.asU = false;
      this.mMiniMsgUser.onForeground();
    }
    if (this.mColorNoteController != null)
    {
      this.mColorNoteController.onResume();
      QLog.d(this.TAG, 2, "mColorNoteController.onResume");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.aBI();
    }
    this.aGM = 0;
    this.aZK = 0;
    int i = j;
    if (this.aIV == 1001)
    {
      i = j;
      if (!kys.dv(this.aZt)) {
        i = 1;
      }
    }
    if (((ReadinjoyTabFrame.Dx()) || (i != 0)) && (RIJRedPacketManager.a().Dr()) && (RIJRedPacketManager.a().Dt())) {
      RIJRedPacketManager.a().a(1, new njo(this));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barCommonAdBar != null)
      {
        kkk localkkk = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barCommonAdBar.a();
        if (localkkk != null) {
          localkkk.aDT();
        }
      }
      return;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.setVisibility(8);
    }
  }
  
  public void doOnStart()
  {
    if (!this.asR) {
      super.doOnStart();
    }
  }
  
  public void doOnStop()
  {
    if (!this.asR) {
      super.doOnStop();
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if ((!mAppForground) || (this.asR))
    {
      kxy.mK(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      this.jdField_c_of_type_Kxy.aIc();
    }
    if ((isFinishing()) || (this.asR))
    {
      QLog.d(this.TAG, 1, "fastwebActivity doOnStop | removeCommentDataManager");
      ktr.c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_c_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      aYu();
    }
  }
  
  public void f(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool;
    if (paramInt == 2)
    {
      bool = true;
      this.agj = bool;
      if (paramInt != 0) {
        break label32;
      }
      a(paramAbsListView, this.aJU, true);
    }
    label32:
    while (this.agj)
    {
      return;
      bool = false;
      break;
    }
    this.agi = false;
    paramAbsListView.setInterpolator(null);
  }
  
  public void finish()
  {
    QLog.d(this.TAG, 2, "mFloating ：finish");
    if ((this.asW) && (!this.asX))
    {
      aYN();
      return;
    }
    if (this.jdField_a_of_type_Nmq.isEmpty())
    {
      if (this.mColorNoteController == null) {
        d(this);
      }
      if ((this.ata) && (this.asY) && (this.atc) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.Gc()) && (!this.asX))
      {
        aYO();
        return;
      }
      if ((this.mColorNoteController != null) && (!this.asX))
      {
        aYN();
        return;
      }
      if (this.aIV == 1001)
      {
        if (this.aZt != 70) {
          break label265;
        }
        KandianSubscribeManager.P(this, 2);
      }
      if (this.xC != 0L) {
        nns.a(NetConnInfoCenter.getServerTime() - this.xC, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, getApplicationContext());
      }
    }
    this.isFinish = true;
    aYS();
    aYV();
    aYP();
    lcc.a().c(this.mObserver);
    String str1;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      str1 = "";
      label214:
      if (!this.asP) {
        break label348;
      }
    }
    label265:
    label348:
    for (String str2 = "1";; str2 = "2")
    {
      kbp.a(null, "CliOper", "", str1, "0X8008995", "0X8008995", 0, 0, str2, null, null, null, false);
      aZd();
      QLog.d(this.TAG, 2, "mFloating ：finish over");
      return;
      if (this.aZt == 0)
      {
        kgw.b(this.app, this, 11, 0);
        break;
      }
      if (kys.dv(this.aZt))
      {
        KandianDailyManager.bV(this);
        break;
      }
      if (!awit.aMG()) {
        break;
      }
      kgw.M(this, 11);
      break;
      str1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID + "";
      break label214;
    }
  }
  
  public void g(boolean paramBoolean, String paramString1, String paramString2)
  {
    b(paramBoolean, paramString1, paramString2, 2130772415, 2130772414);
  }
  
  public MiniMsgUserParam getMiniMsgUserParam()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 3;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.actionCallback = this;
    localMiniMsgUserParam.entryView = this.fq;
    localMiniMsgUserParam.unreadView = ((TextView)this.fq.findViewById(2131371723));
    localMiniMsgUserParam.filterMsgType = 1;
    return localMiniMsgUserParam;
  }
  
  public void i(int paramInt, float paramFloat)
  {
    nmy.a(this.mDatas, paramFloat);
    this.jdField_a_of_type_Nlc.notifyDataSetChanged();
  }
  
  public boolean isWrapContent()
  {
    return false;
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
  
  public void m(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramBoolean, true, false, 0L);
  }
  
  public void mc(String paramString)
  {
    if (this.oS == null) {
      return;
    }
    this.oS.setText(paramString);
    this.oS.setVisibility(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 2;
    boolean bool = true;
    if (paramInt1 == 10922)
    {
      if ((paramInt2 == -10069) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
        kxm.aJ(this, ((ArticleInfo)paramIntent.getExtras().get("fast_web_article_info")).mArticleContentUrl);
      }
      return;
      break label652;
    }
    label582:
    do
    {
      Object localObject1;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      while (paramInt1 == 10923) {
                        if ((this.asM) && (this.jdField_a_of_type_Nmq$b == null))
                        {
                          finish();
                          return;
                        }
                      }
                      if ((paramInt1 != 117) || (paramIntent == null) || (paramInt2 != -1)) {
                        break;
                      }
                      localObject1 = paramIntent.getStringExtra("arg_result_json");
                      paramInt1 = paramIntent.getIntExtra("click_comment_edit_src", -1);
                      paramIntent = ktr.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
                      if (paramIntent == null)
                      {
                        paramIntent = this.TAG;
                        localObject1 = new StringBuilder().append("commentDataManage is null, src : ").append(paramInt1).append(", hasInit : ");
                        if (this.mDatas != null) {}
                        for (;;)
                        {
                          wja.a(paramIntent, bool, new NullPointerException());
                          return;
                          bool = false;
                        }
                      }
                    } while (this.jdField_c_of_type_Ksm == null);
                    if (paramInt1 == 2)
                    {
                      paramIntent.aB((String)localObject1, this.jdField_c_of_type_Ksm.nI());
                      return;
                    }
                  } while (paramInt1 != 3);
                  paramIntent.aA((String)localObject1, this.jdField_c_of_type_Ksm.nI());
                  return;
                  if ((paramInt1 != 1001) || (paramIntent == null)) {
                    break;
                  }
                  paramIntent = paramIntent.getSerializableExtra("backToImageData");
                } while (!(paramIntent instanceof List));
                paramIntent = (List)paramIntent;
              } while (paramIntent.isEmpty());
              ThreadManager.getUIHandler().post(new FastWebActivity.29(this, paramIntent));
              QLog.d(this.TAG, 2, "update comments info from commentlist activity ! size : " + paramIntent.size());
              return;
              if (paramInt1 == 2002)
              {
                if ((paramInt2 == -1) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null))
                {
                  paramIntent = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
                  paramIntent.xL += 1L;
                  ThreadManager.getUIHandler().post(new FastWebActivity.30(this));
                }
                paramIntent = getAppInterface();
                localObject1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                if (paramInt2 == -1) {}
                for (bool = true;; bool = false)
                {
                  nns.a(this, paramIntent, (ArticleInfo)localObject1, 0, -1, false, bool, this.add);
                  return;
                }
              }
              if (paramInt1 == 1)
              {
                if (RIJRedPacketManager.a().Dt())
                {
                  localObject2 = "";
                  localObject1 = localObject2;
                  if (paramIntent != null)
                  {
                    localObject1 = localObject2;
                    if (paramIntent.getExtras() != null) {
                      localObject1 = ec(paramIntent.getExtras().getString("detail_url"));
                    }
                  }
                  QLog.i(this.TAG, 1, "resultCode: " + paramInt2 + "\nafter share article content, packetId: " + (String)localObject1);
                  if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                    RIJRedPacketManager.a().a(new nki(this));
                  }
                }
                if (this.aZu == 72)
                {
                  paramInt1 = 13;
                  paramIntent = getAppInterface();
                  localObject1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                  if (paramInt2 != -1) {
                    break label582;
                  }
                }
                for (bool = true;; bool = false)
                {
                  nns.a(this, paramIntent, (ArticleInfo)localObject1, 1, paramInt1, false, bool, this.add);
                  return;
                  paramInt1 = -1;
                  break;
                }
              }
              if (paramInt1 != 9999) {
                break;
              }
            } while ((paramInt2 != -1) || (paramIntent == null));
            paramIntent = paramIntent.getParcelableExtra("key_ad_info");
          } while ((!(paramIntent instanceof AdData)) || (this.mDatas == null));
          paramIntent = ((AdData)paramIntent).alJ;
        } while (TextUtils.isEmpty(paramIntent));
        localObject1 = this.mDatas.iterator();
      } while (!((Iterator)localObject1).hasNext());
      Object localObject2 = (BaseData)((Iterator)localObject1).next();
      if ((!(localObject2 instanceof AdData)) || (!paramIntent.equals(((AdData)localObject2).alJ))) {
        break;
      }
      b((BaseData)localObject2);
      QQToast.a(this, -1, getString(2131701915), 0).show(getTitleBarHeight());
      return;
    } while ((paramInt1 != 117) || (paramIntent == null) || (paramInt2 != 1699));
    label652:
    paramInt1 = i;
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
      paramInt1 = 1;
    }
    ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_Kqd, 1, true, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_c_of_type_Ksm.nI(), paramInt1);
    QLog.d(this.TAG, 1, "back from biuAndComment");
  }
  
  public boolean onBackEvent()
  {
    boolean bool = false;
    if (this.asI)
    {
      g(false, null, null);
      aZc();
      bool = true;
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131369579) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131369579: 
        this.asP = true;
        finish();
        break;
      case 2131377294: 
        pP(true);
        break;
      case 2131369627: 
        if (!this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.isStackFromBottom()) {
          this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setStackFromBottom(true);
        }
        this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setStackFromBottom(false);
        break;
      case 2131371166: 
        g(false, null, null);
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null)
    {
      paramInt1 = 0;
      while (paramInt1 < this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount())
      {
        nlm localnlm = (nlm)this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(paramInt1).getTag();
        if (localnlm != null) {
          localnlm.k(paramString, paramBitmap);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onFromMiniAIOToAIO() {}
  
  public void onGoToConversation()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onGoToConversation..");
    }
    this.asU = true;
    ThreadManager.getUIHandler().post(new FastWebActivity.44(this));
  }
  
  public void onOpenMiniAIOCallback()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onOpenMiniAIOCallback..");
    }
    if ((this.mMiniMsgUser == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null))
    {
      QLog.e(this.TAG, 2, "onOpenMiniAIOCallback mMiniMsgUser == null || mArticleInfo == null || mFastWebInfo == null");
      return;
    }
    for (;;)
    {
      try
      {
        this.asT = true;
        Object localObject = this.mMiniMsgUser.getParam();
        ((MiniMsgUserParam)localObject).backConversationIntent = kxm.a(this, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.aZs, this.asN);
        ((MiniMsgUserParam)localObject).isNeedBackConversation = true;
        ArticleInfo localArticleInfo1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        ArticleInfo localArticleInfo2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        int i = (int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.FP())
        {
          localObject = "2";
          nns.c(localArticleInfo1, "0X800A09C", kxm.a(this, localArticleInfo2, i, (String)localObject).toString());
          localArticleInfo1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          localArticleInfo2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          i = (int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
          if (!this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.FP()) {
            break label230;
          }
          localObject = "2";
          nns.c(localArticleInfo1, "0X800A09D", kxm.a(this, localArticleInfo2, i, (String)localObject).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e(this.TAG, 2, "onOpenMiniAIOCallback Exception = " + localException);
        return;
      }
      String str = "1";
      continue;
      label230:
      str = "1";
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    Z(paramBundle);
    QLog.e(this.TAG, 2, "onSaveInstanceState(Bundle outState)");
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    Z(paramBundle);
    QLog.e(this.TAG, 2, "onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)");
    super.onSaveInstanceState(paramBundle, paramPersistableBundle);
  }
  
  public void pC(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 2: 
      nnn.dg(this.mDatas);
      this.jdField_a_of_type_Nlc.notifyDataSetChanged();
      return;
    }
    nnn.dh(this.mDatas);
    this.jdField_a_of_type_Nlc.notifyDataSetChanged();
  }
  
  public void pP(boolean paramBoolean)
  {
    kxy.mK(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    if (paramBoolean)
    {
      this.asQ = false;
      localArticleInfo1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i = (int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.FP()) {}
      for (str = "2";; str = "1")
      {
        nns.c(localArticleInfo1, "0X800898C", kxm.a(this, localArticleInfo2, i, str).toString());
        if (this.mShareHelper == null) {
          this.mShareHelper = new odg(this, this.app, new a());
        }
        this.mShareHelper.a().setActionSheetTitle("biu出去让更多好友看到");
        this.mShareHelper.a().setOnDismissListener(new njy(this));
        this.mShareHelper.a(b(), 1);
        return;
      }
    }
    this.asQ = true;
    ArticleInfo localArticleInfo1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    ArticleInfo localArticleInfo2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i = (int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.FP()) {}
    for (String str = "2";; str = "1")
    {
      nns.c(localArticleInfo1, "0X8008993", kxm.a(this, localArticleInfo2, i, str).toString());
      break;
    }
  }
  
  class a
    extends odg.a
  {
    a() {}
    
    public boolean b(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
    {
      FastWebActivity.c(FastWebActivity.this, true);
      FastWebActivity.a(FastWebActivity.this, paramInt);
      if (paramInt == 72)
      {
        FastWebActivity.a(FastWebActivity.this, paramActionSheetItem.uin);
        FastWebActivity.b(FastWebActivity.this, paramActionSheetItem.uinType);
        FastWebActivity.b(FastWebActivity.this, paramActionSheetItem.label);
      }
      Object localObject1;
      Object localObject2;
      if (paramInt == 1)
      {
        localObject1 = (ClipboardManager)FastWebActivity.this.getSystemService("clipboard");
        localObject2 = FastWebActivity.a(FastWebActivity.this).mArticleContentUrl;
        alkw.a((ClipboardManager)localObject1, (CharSequence)localObject2);
        ((ClipboardManager)localObject1).setText((CharSequence)localObject2);
        rwt.ez(2, 2131692332);
        localObject2 = FastWebActivity.this;
        if (FastWebActivity.d(FastWebActivity.this))
        {
          localObject1 = "0X8008994";
          nng.a((Context)localObject2, (String)localObject1, 9, FastWebActivity.a(FastWebActivity.this));
          nns.a(FastWebActivity.this, FastWebActivity.this.getAppInterface(), FastWebActivity.a(FastWebActivity.this), -1, 3, false);
        }
      }
      for (;;)
      {
        return super.b(paramInt, paramActionSheetItem);
        localObject1 = "0X800898D";
        break;
        if (paramInt == 5)
        {
          FastWebActivity.a(FastWebActivity.this).po(FastWebActivity.a(FastWebActivity.this).mArticleContentUrl);
          nns.a(FastWebActivity.this, FastWebActivity.this.getAppInterface(), FastWebActivity.a(FastWebActivity.this), 6, -1, false);
        }
        else if (paramInt == 4)
        {
          FastWebActivity.a(FastWebActivity.this).pp(FastWebActivity.a(FastWebActivity.this).mArticleContentUrl);
          nns.a(FastWebActivity.this, FastWebActivity.this.getAppInterface(), FastWebActivity.a(FastWebActivity.this), 7, -1, false);
        }
        else if (paramInt == 13)
        {
          FastWebActivity.this.m(17, -1, false);
          nns.a(FastWebActivity.this, FastWebActivity.this.getAppInterface(), FastWebActivity.a(FastWebActivity.this), 0, -1, false);
        }
        else
        {
          if (paramInt == 6)
          {
            if (FastWebActivity.a(FastWebActivity.this) != null) {
              FastWebActivity.a(FastWebActivity.this).setFavoriteArticle(FastWebActivity.this, FastWebActivity.a(FastWebActivity.this), FastWebActivity.a(FastWebActivity.this));
            }
            localObject2 = FastWebActivity.this;
            if (FastWebActivity.d(FastWebActivity.this)) {}
            for (localObject1 = "0X8008994";; localObject1 = "0X800898D")
            {
              nng.a((Context)localObject2, (String)localObject1, 8, FastWebActivity.a(FastWebActivity.this));
              nns.a(FastWebActivity.this, FastWebActivity.this.getAppInterface(), FastWebActivity.a(FastWebActivity.this), -1, 4, false);
              break;
            }
          }
          if (paramInt == 11)
          {
            ThreadManager.executeOnSubThread(new FastWebActivity.FastWebSheetItemClickProcessor.1(this));
            localObject2 = FastWebActivity.this;
            if (FastWebActivity.d(FastWebActivity.this)) {}
            for (localObject1 = "0X8008994";; localObject1 = "0X800898D")
            {
              nng.a((Context)localObject2, (String)localObject1, 10, FastWebActivity.a(FastWebActivity.this));
              nns.a(FastWebActivity.this, FastWebActivity.this.getAppInterface(), FastWebActivity.a(FastWebActivity.this), -1, 5, false);
              break;
            }
          }
          if (paramInt == 21)
          {
            FastWebActivity.a(FastWebActivity.this).bdE();
            localObject2 = FastWebActivity.this;
            if (FastWebActivity.d(FastWebActivity.this)) {}
            for (localObject1 = "0X8008994";; localObject1 = "0X800898D")
            {
              nng.a((Context)localObject2, (String)localObject1, 7, FastWebActivity.a(FastWebActivity.this));
              nns.a(FastWebActivity.this, FastWebActivity.this.getAppInterface(), FastWebActivity.a(FastWebActivity.this), -1, 0, false);
              break;
            }
          }
          if (paramInt == 7)
          {
            FastWebActivity.a(FastWebActivity.this).a(FastWebActivity.this);
            nns.a(FastWebActivity.this, FastWebActivity.this.getAppInterface(), FastWebActivity.a(FastWebActivity.this), -1, 1, false);
          }
          else if (paramInt == 26)
          {
            FastWebActivity.a(FastWebActivity.this).pr(FastWebActivity.a(FastWebActivity.this).mArticleContentUrl);
            nns.a(FastWebActivity.this, FastWebActivity.this.getAppInterface(), FastWebActivity.a(FastWebActivity.this), -1, 2, false);
          }
          else if (paramInt == 68)
          {
            aoag.jI(1, 2);
            aoag.bJ(FastWebActivity.a(FastWebActivity.this).mArticleContentUrl, FastWebActivity.a(FastWebActivity.this).mTitle);
          }
          else if (paramInt == 70)
          {
            if (FastWebActivity.a(FastWebActivity.this) != null) {
              if (FastWebActivity.a(FastWebActivity.this).canAddColorNote())
              {
                QLog.d(FastWebActivity.a(FastWebActivity.this), 2, "mColorNoteController ：add colorNote");
                FastWebActivity.a(FastWebActivity.this).insertColorNote();
                if (!FastWebActivity.a(FastWebActivity.this).isEmpty()) {
                  QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131691719), 5000).show();
                }
              }
              else
              {
                FastWebActivity.a(FastWebActivity.this).onCannotAdd();
              }
            }
          }
          else if (paramInt == 82)
          {
            if ((FastWebActivity.a(FastWebActivity.this) != null) && (FastWebActivity.a(FastWebActivity.this).isColorNoteExist()))
            {
              QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131691723), 5000).show();
              FastWebActivity.a(FastWebActivity.this).deleteColorNote();
              QLog.d(FastWebActivity.a(FastWebActivity.this), 2, "mColorNoteController ： delete colorNote");
            }
          }
          else
          {
            if ((FastWebActivity.b(FastWebActivity.this)) && (!TextUtils.isEmpty(FastWebActivity.b(FastWebActivity.this))))
            {
              localObject1 = new UriBuilder();
              ((UriBuilder)localObject1).setUrl(FastWebActivity.a(FastWebActivity.this).mArticleContentUrl);
              ((UriBuilder)localObject1).addParam("redpackid", FastWebActivity.b(FastWebActivity.this));
              FastWebActivity.a(FastWebActivity.this).mArticleContentUrl = ((UriBuilder)localObject1).buildUri();
            }
            lbz.a().a().a(FastWebActivity.a(FastWebActivity.this).mArticleContentUrl, FastWebActivity.a(FastWebActivity.this).innerUniqueID + "", FastWebActivity.a(FastWebActivity.this).mSubscribeID, paramInt, FastWebActivity.a(FastWebActivity.this));
          }
        }
      }
    }
  }
  
  public static class b
    implements nnc.b
  {
    private WeakReference<FastWebActivity> cv;
    
    public b(FastWebActivity paramFastWebActivity)
    {
      this.cv = new WeakReference(paramFastWebActivity);
    }
    
    public void c(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2)
    {
      FastWebActivity localFastWebActivity = (FastWebActivity)this.cv.get();
      if (localFastWebActivity == null) {
        return;
      }
      localFastWebActivity.runOnUiThread(new FastWebActivity.RecommendAndAdCallback.1(this, paramList1, paramList2, localFastWebActivity, paramBoolean, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity
 * JD-Core Version:    0.7.0.1
 */