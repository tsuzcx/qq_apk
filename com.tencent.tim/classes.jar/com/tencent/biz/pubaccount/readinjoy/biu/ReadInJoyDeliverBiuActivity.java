package com.tencent.biz.pubaccount.readinjoy.biu;

import acfd;
import acje;
import anbk;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aofk;
import aqgo;
import aqgv;
import aqnm;
import arhz;
import awit;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.k;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.k.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.k.a.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.k.a.b;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.q;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.s;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.XPanelContainer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kbp;
import kpr;
import kps;
import kpt;
import kpu;
import kpv;
import kpw;
import kpx;
import kvm;
import kxm;
import kxr;
import lbz;
import lcc;
import lce;
import mde;
import mih;
import mih.b;
import mkt;
import mqq.os.MqqHandler;
import ndi;
import nhr;
import nng;
import nqj;
import nql;
import nqm;
import ods;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDeliverBiuActivity
  extends ReadInJoyBaseDeliverActivity
{
  protected static String SEPARATOR = " //";
  private String Hl;
  private CommonCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  private FixSizeImageView jdField_a_of_type_ComTencentWidgetFixSizeImageView;
  private int aIR;
  private int aKY = -1;
  private int aKZ;
  private int aLa = 5000;
  private int aLb = 1;
  private int aLc = 2;
  private int aLd = 3;
  private int aLe;
  private int aLf;
  private int aLg;
  private String abA;
  private String abB = "1920*1080;1280*720;1812*1080;1208*720;1280*760;1184*720;1794*1080;1776*1080;1800*1080;2960*1440;2560*1440";
  private boolean agX;
  private boolean agY = true;
  private boolean agZ;
  private ArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ReadInJoyNickNameTextView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  private FixSizeImageView jdField_b_of_type_ComTencentWidgetFixSizeImageView;
  private Button bN;
  private String[] bh = new String[3];
  private acfd jdField_c_of_type_Acfd = new kps(this);
  private FixSizeImageView jdField_c_of_type_ComTencentWidgetFixSizeImageView;
  acje d;
  private KandianUrlImageView jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  lce jdField_e_of_type_Lce = new kpx(this);
  private RelativeLayout eJ;
  private RelativeLayout eK;
  private RelativeLayout eL;
  private RelativeLayout eM;
  private RelativeLayout eN;
  private RelativeLayout eO;
  private int feedstype = 1;
  private ImageView ir;
  private ImageView is;
  private ImageView it;
  private ImageView iu;
  private ImageView iv;
  private ImageView iw;
  private View jP;
  private long mArticleID;
  private int mArticleType;
  private int mFromType;
  private String mRowKey;
  private String mSource;
  private String mSummary;
  private String mTitle;
  private TextView oE;
  private TextView oF;
  private TextView oG;
  private View root;
  private long sE;
  private long sF;
  AnimatorSet z;
  
  private void aFS()
  {
    boolean bool = true;
    this.agX = getIntent().getBooleanExtra("fast_biu_type", false);
    this.agY = getIntent().getBooleanExtra("should_show_dialog", true);
    this.agZ = getIntent().getBooleanExtra("is_modified_biu", false);
    this.sF = getIntent().getLongExtra("modified_feeds_id", 0L);
    if (!this.agX) {}
    for (;;)
    {
      this.mIsVisible = bool;
      return;
      bool = false;
    }
  }
  
  private void aFT()
  {
    Object localObject = (RelativeLayout)findViewById(2131365375);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(1, 2131368820);
    localLayoutParams.addRule(9, 0);
    localLayoutParams.addRule(0, 0);
    ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
    ((RelativeLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131299168);
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.oE.setMaxLines(1);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setMaxLines(2);
  }
  
  private void aFU()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  private void aFV()
  {
    ThreadManager.post(new ReadInJoyDeliverBiuActivity.10(this), 5, null, true);
  }
  
  private String an(long paramLong)
  {
    String str = ReadInJoyUserInfoModule.at(paramLong);
    Object localObject = str;
    if (ReadInJoyUserInfoModule.getDefaultNickName().equalsIgnoreCase(str))
    {
      localObject = ReadInJoyUserInfoModule.a(paramLong, null);
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (localObject = ((ReadInJoyUserInfo)localObject).nick;; localObject = ReadInJoyUserInfoModule.getDefaultNickName())
    {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "getBiuUserName : " + (String)localObject);
      return localObject;
    }
  }
  
  private static void as(Bundle paramBundle)
  {
    if (paramBundle != null) {}
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null)) {}
    while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.longValue() != 30L) {
      return false;
    }
    return true;
  }
  
  public static boolean d(ArticleInfo paramArticleInfo)
  {
    return (ndi.ak(paramArticleInfo)) || (ndi.S(paramArticleInfo)) || (ndi.T(paramArticleInfo)) || (ndi.U(paramArticleInfo)) || (paramArticleInfo.mFeedType == 25);
  }
  
  public static boolean dj(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 5) || (paramInt == 4) || (paramInt == 6)) {
      bool = true;
    }
    return bool;
  }
  
  private boolean dk(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 3) || (paramInt == 2)) {
      bool = true;
    }
    return bool;
  }
  
  private void initEditText()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT == null))
    {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "initEditText: got null stuff");
      return;
    }
    if (this.aIR <= 0)
    {
      this.aIR = getResources().getDisplayMetrics().widthPixels;
      this.aIR = (this.aIR - this.N.getPaddingLeft() - this.N.getPaddingRight());
    }
    Object localObject2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = new ArrayList();
    if (((List)localObject2).size() > 0)
    {
      i = localStringBuilder.length();
      localStringBuilder.append(SEPARATOR);
      ((List)localObject1).add(new nql(i, SEPARATOR.length() + i, new nqm()));
    }
    int j = localStringBuilder.length();
    int i = ((List)localObject2).size() - 1;
    if (i >= 0)
    {
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)((List)localObject2).get(i);
      switch (localBiuCommentInfo.aSO)
      {
      }
      for (;;)
      {
        try
        {
          str1 = an(localBiuCommentInfo.i.longValue());
          str3 = "@" + str1;
          localStringBuilder.append(str3);
          if (localBiuCommentInfo.ahj != null) {
            continue;
          }
          str1 = "";
          localStringBuilder.append(str1);
          ((List)localObject1).add(new nql(j, str3.length() + j, new BiuNicknameSpan(localBiuCommentInfo.i.toString(), localBiuCommentInfo.x.longValue(), str3)));
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          String str1;
          String str3;
          String str4;
          String str2;
          QLog.d("ReadInJoyDeliverBiuActivity", 2, localNumberFormatException2.getMessage());
          continue;
        }
        j = localStringBuilder.length();
        i -= 1;
        break;
        if (localBiuCommentInfo.a != null)
        {
          str3 = localBiuCommentInfo.a.iZ();
          str4 = localBiuCommentInfo.a.getJumpUrl();
          if (localBiuCommentInfo.ahj == null)
          {
            str1 = "";
            localStringBuilder.append(str3).append(str1);
            ((List)localObject1).add(new nql(j, str3.length() + j, new nqj(str4, 13421772)));
          }
          else
          {
            str1 = localBiuCommentInfo.ahj;
            continue;
            try
            {
              str1 = an(localBiuCommentInfo.i.longValue());
              str3 = "@" + str1 + " ";
              localStringBuilder.append(str3);
              if (localBiuCommentInfo.ahj != null) {
                continue;
              }
              str1 = "";
              localStringBuilder.append(str1);
              ((List)localObject1).add(new nql(j, str3.length() + j, new AtFriendsSpan(localBiuCommentInfo.i.toString(), localBiuCommentInfo.x.longValue(), str3)));
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              QLog.e("ReadInJoyDeliverBiuActivity", 2, "initEditText: ", localNumberFormatException1);
            }
            continue;
            str2 = localBiuCommentInfo.ahj;
            continue;
            str2 = localBiuCommentInfo.ahj;
          }
        }
      }
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(new aofk(localStringBuilder, 7, 16));
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (nql)((Iterator)localObject1).next();
      localSpannableStringBuilder.setSpan(((nql)localObject2).A(), ((nql)localObject2).getStartPos(), ((nql)localObject2).getEndPos(), 33);
    }
    this.aeZ = true;
    this.N.setText(localSpannableStringBuilder);
  }
  
  private void initTitle()
  {
    Object localObject = "";
    if (!TextUtils.isEmpty(this.mTitle)) {
      localObject = this.mTitle;
    }
    try
    {
      SocializeFeedsInfo.r localr;
      for (;;)
      {
        localObject = anbk.nn((String)localObject);
        if ((!d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ndi.Y(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (mde.G(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          break label159;
        }
        localr = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r;
        if (kxm.a(localr)) {
          break;
        }
        localObject = new aofk((CharSequence)localObject, 7, 16);
        this.oE.setText((CharSequence)localObject);
        return;
        if (!TextUtils.isEmpty(this.mSummary)) {
          localObject = this.mSummary;
        }
      }
      localObject = new aofk(localr.b.e(), 7, 16);
      this.oE.setText((CharSequence)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoyDeliverBiuActivity", 2, localException.toString());
      return;
    }
    label159:
    aofk localaofk = new aofk(localException, 7, 16);
    this.oE.setText(localaofk);
  }
  
  private void mD(boolean paramBoolean)
  {
    if ((this.mFromType == 18) || (this.mFromType == 17))
    {
      if (this.mFromType == 18)
      {
        localObject1 = "0X8008992";
        if (paramBoolean) {
          break label40;
        }
      }
    }
    else {
      return;
    }
    Object localObject1 = "0X800898D";
    label40:
    Object localObject2 = getApplicationContext();
    if (paramBoolean) {}
    for (int i = 1;; i = 11)
    {
      nng.a((Context)localObject2, (String)localObject1, i, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.aKY);
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = kxm.getLongAccountUin();
      ((ReportInfo)localObject1).mSource = ((int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      ((ReportInfo)localObject1).mSourceArticleId = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
      ((ReportInfo)localObject1).mChannelId = ((int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      ((ReportInfo)localObject1).mAlgorithmId = ((int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject1).mStrategyId = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
      ((ReportInfo)localObject1).mServerContext = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mServerContext;
      ((ReportInfo)localObject1).mInnerId = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
      ((ReportInfo)localObject1).mOperation = 25;
      ((ReportInfo)localObject1).mOpSource = 12;
      ((ReportInfo)localObject1).mReadTimeLength = -1;
      localObject2 = new ArrayList();
      ((List)localObject2).add(localObject1);
      lbz.a().cb((List)localObject2);
      return;
    }
  }
  
  private int nA()
  {
    if ((this.jdField_c_of_type_ComTencentWidgetXPanelContainer == null) || (this.jdField_c_of_type_ComTencentWidgetXPanelContainer.cE() == null)) {
      return 0;
    }
    return this.jdField_c_of_type_ComTencentWidgetXPanelContainer.cE().getHeight();
  }
  
  public void aCW()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "onEmotionBtn!");
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", kxm.aMw);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    kbp.a(null, "", "0X8007EE8", "0X8007EE8", 0, 0, "", "", "", (String)localObject1, false);
    super.aCW();
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    mD(false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560347);
    addObserver(this.jdField_c_of_type_Acfd);
    aFS();
    initViews();
    initData();
    if (this.agX) {
      return true;
    }
    nhr.a(this, null);
    Object localObject = "";
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("folder_status", kxm.aMw);
        paramBundle.put("kandian_mode", "" + kxm.nR());
        if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (!d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          continue;
        }
        paramBundle.put("feeds_id", "" + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId);
        paramBundle = paramBundle.toString();
        localObject = paramBundle;
      }
      catch (JSONException paramBundle)
      {
        String str2;
        paramBundle.printStackTrace();
        continue;
        String str1 = String.valueOf(this.mArticleID);
        continue;
        continue;
      }
      if (this.mArticleID >= 0L) {
        continue;
      }
      str1 = "0";
      paramBundle = "0";
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
        continue;
      }
      str2 = String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId);
      paramBundle = str2;
      if (str2.equals("0")) {
        continue;
      }
      str1 = "0";
      paramBundle = str2;
      kbp.a(null, "", "0X8007EE7", "0X8007EE7", 0, 0, String.valueOf(this.mFromType), str1, paramBundle, (String)localObject, false);
      as(getIntent().getExtras());
      return true;
      paramBundle.put("feeds_id", "0");
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_c_of_type_Acfd);
    if (this.z != null) {
      this.z.cancel();
    }
    if (this.d != null) {
      super.removeObserver(this.d);
    }
    lcc.a().c(this.jdField_e_of_type_Lce);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (isInMultiWindow()) {
      finish();
    }
  }
  
  public void finish()
  {
    if (this.jdField_c_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_c_of_type_ComTencentWidgetXPanelContainer.aJS();
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130772253);
    localAnimation.setFillAfter(true);
    this.root.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(this, 2130772254);
    localAnimation.setFillAfter(true);
    this.jP.startAnimation(localAnimation);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyDeliverBiuActivity.8(this), 300L);
  }
  
  public void initData()
  {
    super.initData();
    this.Zp = "0X800865F";
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImagePlaceHolder(getResources().getDrawable(2130850238));
    Object localObject1 = getIntent();
    this.mFromType = ((Intent)localObject1).getIntExtra("arg_from_type", 0);
    this.aKY = ((Intent)localObject1).getIntExtra("arg_biu_state", -1);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)((Intent)localObject1).getParcelableExtra("arg_article_info"));
    this.aKZ = ((Intent)localObject1).getIntExtra("biu_src", 1);
    this.mRowKey = ((Intent)localObject1).getStringExtra("biu_rowkey");
    this.feedstype = ((Intent)localObject1).getIntExtra("feedsType", 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = ((CommonCommentData)((Intent)localObject1).getSerializableExtra("arg_common_comment_info"));
    if (this.agX) {
      findViewById(2131364979).setVisibility(8);
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      this.mArticleType = ((Intent)localObject1).getIntExtra("arg_type", -1);
      if (this.mArticleType == -1)
      {
        this.mArticleType = 1;
        if (((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType != 1) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.aSG != 5)) && (!kxm.j(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          break label1364;
        }
        this.mArticleType = 2;
      }
    }
    for (;;)
    {
      this.mArticleID = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
      label299:
      Object localObject2;
      long l;
      label444:
      int i;
      if ((d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ndi.Y(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
        if (!ndi.aa(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
        {
          this.mTitle = ((SocializeFeedsInfo.t)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).title;
          initTitle();
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuTitle())))
          {
            this.mTitle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuTitle();
            localObject2 = new aofk(anbk.nn(new String(aqgo.decode(this.mTitle, 0))), 7, 16);
            this.oE.setVisibility(0);
            this.oE.setText((CharSequence)localObject2);
          }
          if ((!d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ndi.Y(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
            break label1736;
          }
          l = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin;
          if (l != 0L) {
            break label1725;
          }
          this.mSource = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.mSource);
          if ((!d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ndi.Y(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
            break label2188;
          }
          i = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa;
          if ((ndi.aa(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (!dj(i))) {
            break label2056;
          }
          this.Hl = ((SocializeFeedsInfo.t)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).pic_url;
          label522:
          if ((!TextUtils.isEmpty(this.Hl)) || (c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
            break label2297;
          }
          this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
          label551:
          if (this.mArticleType == 2)
          {
            if ((!d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ndi.aa(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
              break label2373;
            }
            l = ((SocializeFeedsInfo.t)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).duration / 1000L;
            this.abA = String.format("%02d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) });
            if (l != 0L)
            {
              this.eK.setVisibility(0);
              this.oG.setText(this.abA);
            }
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null)
          {
            QLog.d("ReadInJoyDeliverBiuActivity", 2, "commonCommentData is not null mcover:" + this.Hl + "video duration: " + this.abA + "msource : " + this.mSource + "mtitle" + this.mTitle);
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuSourceName()))
            {
              this.mSource = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuSourceName();
              localObject2 = new aofk(anbk.nn(new String(aqgo.decode(this.mSource, 0))), 7, 16);
              this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
              this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText((CharSequence)localObject2);
            }
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuPicUrl()))
            {
              this.Hl = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuPicUrl();
              this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
            }
          }
        }
      }
      try
      {
        for (;;)
        {
          this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(new URL(this.Hl));
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuDuration() != -1L)
          {
            l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuDuration();
            this.abA = String.format("%02d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) });
            if (l != 0L)
            {
              this.eK.setVisibility(0);
              this.oG.setText(this.abA);
            }
          }
          QLog.d("ReadInJoyDeliverBiuActivity", 2, "mcover:" + this.Hl + "video duration: " + this.abA + "msource : " + this.mSource + "mtitle : " + this.mTitle);
          if (((!TextUtils.isEmpty(this.mRowKey)) && (this.aKZ == 17)) || (this.aKZ == 24))
          {
            String str2 = ((Intent)localObject1).getStringExtra("arg_title");
            str1 = ((Intent)localObject1).getStringExtra("arg_src");
            localObject2 = ((Intent)localObject1).getStringExtra("arg_cover");
            localObject1 = str2;
            if (TextUtils.isEmpty(str2)) {
              localObject1 = this.mTitle;
            }
            this.mTitle = ((String)localObject1);
            if (!TextUtils.isEmpty(str1)) {
              break label2395;
            }
            localObject1 = this.mSource;
            this.mSource = ((String)localObject1);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label2402;
            }
            localObject1 = this.Hl;
            this.Hl = ((String)localObject1);
            if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
            {
              this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = new ArticleInfo();
              this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
            }
            localObject2 = this.oE;
            if (this.mTitle != null) {
              break label2409;
            }
            localObject1 = "";
            ((TextView)localObject2).setText((CharSequence)localObject1);
            localObject2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
            if (this.mSource != null) {
              break label2418;
            }
            localObject1 = "";
            ((ReadInJoyNickNameTextView)localObject2).setText((CharSequence)localObject1);
            if (!TextUtils.isEmpty(this.Hl)) {
              break label2427;
            }
            this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
          }
          if (kvm.h(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
          {
            this.mTitle = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.ahP;
            this.oE.setText(this.mTitle);
            this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
            this.eK.setVisibility(8);
          }
          if (awit.v(this.app) != 0) {
            break label2463;
          }
          bool = true;
          this.afe = bool;
          if ((!this.afe) && (this.hZ != null)) {
            this.hZ.setVisibility(8);
          }
          initEditText();
          lcc.a().b(this.jdField_e_of_type_Lce);
          if (this.agX) {
            zp();
          }
          return;
          label1364:
          if ((d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null))
          {
            if (dj(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa))
            {
              this.mArticleType = 2;
              break;
            }
            this.mArticleType = 1;
            break;
          }
          if (!c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
            break;
          }
          this.mArticleType = 5;
          break;
          if ((ods.ac(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!TextUtils.isEmpty(((AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdTxt)))
          {
            this.mTitle = ((AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdTxt;
            break label299;
          }
          this.mTitle = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.ail;
          break label299;
          if (ndi.al(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
          {
            if (!ndi.ap(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
            {
              localObject2 = (mih.b)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld.get(0);
              this.mTitle = (((mih.b)localObject2).businessNamePrefix + ((mih.b)localObject2).businessName);
              break label299;
            }
            this.mTitle = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
            break label299;
          }
          if (this.mArticleType == 4)
          {
            this.mTitle = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
            break label299;
          }
          if ((kxr.d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo) == 27) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$q != null))
          {
            this.mTitle = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$q.title;
            break label299;
          }
          if ((this.mArticleType == 5) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null))
          {
            this.mTitle = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.ail;
            break label299;
          }
          this.mTitle = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
          this.mSummary = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary;
          break label299;
          label1725:
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l);
          break label444;
          label1736:
          if ((ndi.al(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ndi.ap(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.mTopicRecommendFeedsInfo.vV != 0L))
          {
            this.mSource = aqgv.b((QQAppInterface)kxm.getAppRuntime(), String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.mTopicRecommendFeedsInfo.vV), true);
            if (!TextUtils.isEmpty(this.mSource))
            {
              this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.mSource);
              break label444;
            }
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(8);
            break label444;
          }
          if (this.mArticleType == 4)
          {
            if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary)) {}
            for (;;)
            {
              this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.mSource);
              break;
              this.mSource = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary;
            }
          }
          if (this.mArticleType == 5)
          {
            l = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin;
            if (l == 0L)
            {
              this.mSource = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
              this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.mSource);
              break label444;
            }
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l);
            break label444;
          }
          if ((kxr.d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo) == 27) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$q != null))
          {
            this.mSource = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$q.source;
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.mSource);
            break label444;
          }
          this.mSource = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
          if (!TextUtils.isEmpty(this.mSource))
          {
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.mSource);
            break label444;
          }
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(8);
          break label444;
          label2056:
          if ((!ndi.Z(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (dk(i)))
          {
            this.Hl = ((SocializeFeedsInfo.s)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.get(0)).aii;
            break label522;
          }
          if (kxr.K(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
          {
            this.Hl = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.a.ahS;
            break label522;
          }
          if ((ods.ac(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!TextUtils.isEmpty(((AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdImg)))
          {
            this.Hl = ((AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdImg;
            break label522;
          }
          this.Hl = null;
          break label522;
          label2188:
          if ((ndi.al(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ndi.ap(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
          {
            this.Hl = ((mih.b)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld.get(0)).picUrl;
            break label522;
          }
          if ((kxr.d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo) == 27) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$q != null))
          {
            this.Hl = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$q.coverUrl;
            break label522;
          }
          this.Hl = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl;
          break label522;
          label2297:
          if (c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
          {
            this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
            this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(BaseApplication.getContext().getResources().getDrawable(2130850202));
            break label551;
          }
          try
          {
            localObject2 = new URL(this.Hl);
            this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage((URL)localObject2);
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
        break label551;
        label2373:
        l = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mVideoDuration;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          String str1;
          localMalformedURLException.printStackTrace();
          continue;
          label2395:
          localObject1 = str1;
          continue;
          label2402:
          localObject1 = localMalformedURLException;
          continue;
          label2409:
          localObject1 = this.mTitle;
          continue;
          label2418:
          localObject1 = this.mSource;
          continue;
          try
          {
            label2427:
            localObject1 = new URL(this.Hl);
            this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage((URL)localObject1);
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
          continue;
          label2463:
          boolean bool = false;
        }
      }
    }
  }
  
  public void initViews()
  {
    this.eL = ((RelativeLayout)findViewById(2131363551));
    this.aIO = 178;
    this.aIO = aqnm.dpToPx(this.aIO);
    this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new kpr(this);
    super.initViews();
    this.j.a(new kpt(this));
    this.aLf = aqnm.getScreenHeight();
    Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_c_of_type_ComTencentWidgetXPanelContainer.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = (this.aLf * 8 / 100);
    this.jdField_c_of_type_ComTencentWidgetXPanelContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131379769));
    this.oE = ((TextView)findViewById(2131372190));
    this.jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)findViewById(2131368820));
    this.eJ = ((RelativeLayout)findViewById(2131373292));
    this.oF = ((TextView)findViewById(2131373297));
    this.eK = ((RelativeLayout)findViewById(2131381636));
    this.oG = ((TextView)findViewById(2131381659));
    getTitleBarView().setVisibility(8);
    this.bN = ((Button)findViewById(2131365717));
    if (this.agZ) {
      this.bN.setText(getString(2131699683));
    }
    this.bN.setOnClickListener(new kpu(this));
    if (this.nS != null)
    {
      this.nS.setText("" + this.aIM);
      this.nS.setTextColor(-4473925);
    }
    this.ir = ((ImageView)findViewById(2131364677));
    this.ir.setOnClickListener(new kpv(this));
    this.jP = findViewById(2131364970);
    this.jP.setOnClickListener(new kpw(this));
    this.root = findViewById(2131377546);
    this.eM = ((RelativeLayout)findViewById(2131380004));
    this.eN = ((RelativeLayout)findViewById(2131363549));
    this.is = ((ImageView)findViewById(2131363544));
    this.is.setRotation(-30.0F);
    this.it = ((ImageView)findViewById(2131372737));
    this.iu = ((ImageView)findViewById(2131372739));
    this.iu.setRotation(30.0F);
    this.iv = ((ImageView)findViewById(2131372740));
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131367118));
    this.jdField_b_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131377888));
    this.jdField_c_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131363175));
    this.iw = ((ImageView)findViewById(2131363552));
    this.eO = ((RelativeLayout)findViewById(2131363546));
    localObject = AnimationUtils.loadAnimation(this, 2130772251);
    this.root.startAnimation((Animation)localObject);
    localObject = AnimationUtils.loadAnimation(this, 2130772252);
    this.jP.startAnimation((Animation)localObject);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyDeliverBiuActivity.6(this), 250L);
    if (getIntent().getIntExtra("arg_type", -1) == 4) {
      aFT();
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.aeY) && ((!this.afc) || (this.mResult != -1)))
    {
      pw(this.aLd);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void pw(int paramInt)
  {
    this.aIS = this.aIK;
    oM(0);
    super.a(true, paramInt, false, 0L);
  }
  
  public boolean zp()
  {
    l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = l1 - this.sE;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "onDeliver!Time now=" + l1 + ", last=" + this.sE + ", diff=" + l2);
    }
    if (l2 <= 2000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "deliver too fast(<=2000), return!");
      }
      return false;
    }
    if (!super.zp())
    {
      if (this.agX) {
        finish();
      }
      return false;
    }
    if (this.agY) {
      showLoading(2131697438);
    }
    this.agY = true;
    localObject3 = new ArrayList();
    bool = mkt.a(this.N, this.app.getCurrentAccountUin(), this.afl, true, (List)localObject3);
    QLog.d("biu_data_trace", 2, "onDeliver deliverList:\n" + ((ArrayList)localObject3).toString());
    Object localObject4;
    if ((!TextUtils.isEmpty(this.mRowKey)) && (this.aKZ == 17))
    {
      lbz.a().a(kxm.getLongAccountUin(), this.mRowKey, this.aKZ, ((SocializeFeedsInfo.BiuCommentInfo)((ArrayList)localObject3).get(0)).ahj, (ArrayList)localObject3, this.agX);
      localObject4 = "";
    }
    for (;;)
    {
      try
      {
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("folder_status", kxm.aMw);
        ((JSONObject)localObject3).put("kandian_mode", "" + kxm.nR());
        if (!this.agX) {
          continue;
        }
        localObject1 = "1";
        ((JSONObject)localObject3).put("fast_biu", localObject1);
        if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (!d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          continue;
        }
        ((JSONObject)localObject3).put("feeds_id", "" + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId);
        localObject1 = getIntent().getExtras();
        if ((localObject1 == null) || (!((Bundle)localObject1).containsKey("arg_forward"))) {
          continue;
        }
        i = 1;
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        Object localObject5;
        Iterator localIterator;
        localJSONException.printStackTrace();
        continue;
        int i = 0;
        continue;
        i = 0;
        continue;
        localObject3 = String.valueOf(this.mArticleID);
        continue;
        if (!bool) {
          continue;
        }
        i = 1;
        continue;
        i = 2;
        continue;
        continue;
        continue;
        l1 = 0L;
        continue;
        Object localObject2 = null;
        continue;
        if (i == 0) {
          continue;
        }
        i = 1;
        continue;
      }
      ((JSONObject)localObject3).put("outside", i);
      localObject1 = ((JSONObject)localObject3).toString();
      localObject4 = localObject1;
      if (this.mArticleID >= 0L) {
        continue;
      }
      localObject3 = "0";
      localObject1 = "0";
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
        continue;
      }
      localObject5 = String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId);
      localObject1 = localObject5;
      if (((String)localObject5).equals("0")) {
        continue;
      }
      localObject3 = "0";
      localObject1 = localObject5;
      if (!this.aeY) {
        continue;
      }
      i = 3;
      if (!this.agX) {
        continue;
      }
      i = 1;
      kbp.a(null, "", "0X8007EE9", "0X8007EE9", 0, 0, String.valueOf(i), (String)localObject3, (String)localObject1, (String)localObject4, false);
      return true;
      if (this.mFromType == 21)
      {
        localObject1 = new SocializeFeedsInfo.a();
        ((SocializeFeedsInfo.a)localObject1).ahT = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary;
        ((SocializeFeedsInfo.a)localObject1).vM = getIntent().getLongExtra("arg_account_id", -1L);
        ((SocializeFeedsInfo.a)localObject1).accountType = getIntent().getIntExtra("arg_account_type", -1);
        ((SocializeFeedsInfo.a)localObject1).ahS = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl;
        ((SocializeFeedsInfo.a)localObject1).accountNick = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
        lbz.a().a(this.app.getCurrentUin(), this.mFromType, ii(), (ArrayList)localObject3, (SocializeFeedsInfo.a)localObject1);
        break;
      }
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (((ArrayList)localObject3).size() <= 0)) {
        break;
      }
      localObject4 = new SocializeFeedsInfo.c();
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)
      {
        if ((this.mFromType == 23) || (this.aKZ == 24))
        {
          localObject1 = new SocializeFeedsInfo.q();
          ((SocializeFeedsInfo.q)localObject1).title = this.mTitle;
          ((SocializeFeedsInfo.q)localObject1).source = this.mSource;
          ((SocializeFeedsInfo.q)localObject1).coverUrl = this.Hl;
          ((SocializeFeedsInfo.q)localObject1).webUrl = getIntent().getStringExtra("arg_source_url");
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$q = ((SocializeFeedsInfo.q)localObject1);
        }
        if (this.aKZ == 24)
        {
          localObject1 = new SocializeFeedsInfo.k();
          localObject5 = new SocializeFeedsInfo.k.a();
          ((SocializeFeedsInfo.k.a)localObject5).a(new SocializeFeedsInfo.k.a.a(getIntent().getLongExtra("arg_now_anchor_uin", 0L)));
          ((SocializeFeedsInfo.k.a)localObject5).a(new SocializeFeedsInfo.k.a.b(getIntent().getStringExtra("arg_now_live_vid")));
          ((SocializeFeedsInfo.k)localObject1).a((SocializeFeedsInfo.k.a)localObject5);
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$k = ((SocializeFeedsInfo.k)localObject1);
        }
        l1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c != null)
        {
          ((SocializeFeedsInfo.c)localObject4).y = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.y;
          ((SocializeFeedsInfo.c)localObject4).z = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z;
          i = ((ArrayList)localObject3).size() - 1;
          if (i > 0)
          {
            localObject5 = (SocializeFeedsInfo.BiuCommentInfo)((ArrayList)localObject3).get(i);
            if ((((SocializeFeedsInfo.BiuCommentInfo)localObject5).x.longValue() == 0L) || (((SocializeFeedsInfo.BiuCommentInfo)localObject5).aSO != 0)) {
              continue;
            }
            localIterator = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.iterator();
            if (!localIterator.hasNext()) {
              continue;
            }
            localObject1 = (SocializeFeedsInfo.BiuCommentInfo)localIterator.next();
            if (!((SocializeFeedsInfo.BiuCommentInfo)localObject1).x.equals(((SocializeFeedsInfo.BiuCommentInfo)localObject5).x)) {
              continue;
            }
            if (localObject1 == null)
            {
              localObject1 = (SocializeFeedsInfo.BiuCommentInfo)((ArrayList)localObject3).get(i);
              ((SocializeFeedsInfo.c)localObject4).iT.add(localObject1);
              i -= 1;
              continue;
            }
            ((SocializeFeedsInfo.BiuCommentInfo)localObject1).ahj = ((SocializeFeedsInfo.BiuCommentInfo)localObject5).ahj;
            continue;
          }
          if (!this.agZ) {
            continue;
          }
          lbz.a().a(kxm.getLongAccountUin(), this.sF, (SocializeFeedsInfo.c)localObject4, ((SocializeFeedsInfo.BiuCommentInfo)((ArrayList)localObject3).get(0)).ahj);
          break;
        }
        i = ((ArrayList)localObject3).size() - 1;
        if (i > 0)
        {
          ((SocializeFeedsInfo.c)localObject4).iT.add(((ArrayList)localObject3).get(i));
          i -= 1;
          continue;
        }
        continue;
      }
      i = ((ArrayList)localObject3).size() - 1;
      if (i <= 0) {
        continue;
      }
      ((SocializeFeedsInfo.c)localObject4).iT.add(((ArrayList)localObject3).get(i));
      i -= 1;
      continue;
      lbz.a().a(kxm.getLongAccountUin(), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId, (SocializeFeedsInfo.c)localObject4, l1, ((SocializeFeedsInfo.BiuCommentInfo)((ArrayList)localObject3).get(0)).ahj, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq, this.aKZ, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.feedstype, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.agX);
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "mFeedId:" + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId + " masterUin" + l1 + ", mArticleID:" + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + " mRecommendSeq: " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq + " biuSrc:" + this.aKZ + " innerUniqueID" + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + " feedstype:" + this.feedstype);
      this.sE = NetConnInfoCenter.getServerTimeMillis();
      break;
      localObject1 = "0";
      continue;
      ((JSONObject)localObject3).put("feeds_id", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity
 * JD-Core Version:    0.7.0.1
 */