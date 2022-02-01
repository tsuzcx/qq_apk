package com.tencent.biz.pubaccount.readinjoy.comment;

import afmf;
import ahzd;
import aiaa;
import anbk;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aooi;
import aook;
import aqgo;
import aqgv;
import aqiw;
import arhz;
import aurf;
import awit;
import com.tencent.biz.pubaccount.readinjoy.biu.AtFriendsSpan;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.c;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import kbp;
import kct;
import kqc;
import ksb;
import ksc;
import ksd;
import kse;
import ksf;
import ksg;
import ksh;
import ksi;
import ksz;
import kvm;
import kwt;
import kxm;
import kxy;
import mkt;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import ndi;
import nhr;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ykm;
import ykm.c;
import ykv;

public class ReadInJoyCommentComponentFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener, ykm.c
{
  private Editable.Factory jdField_a_of_type_AndroidTextEditable$Factory = new ksf(this);
  aook jdField_a_of_type_Aook = new kse(this);
  public BiuEditText a;
  public EmoticonMainPanel a;
  public HotPicData a;
  public PublicAccountHotPicPanel a;
  private XPanelContainer.c jdField_a_of_type_ComTencentWidgetXPanelContainer$c = new ksg(this);
  private ykv jdField_a_of_type_Ykv;
  protected int aIK = 1;
  protected int aIL = 1;
  private int aIR;
  private int aKZ = 1;
  public int aLs = kwt.aMk;
  public int aLt;
  private int aLu = -1;
  private int aLv;
  private int aLw;
  private String abU;
  private String abV = "";
  private String abW = "";
  private String abX = "";
  public boolean afa;
  private boolean afe = true;
  public boolean ahd;
  protected boolean ahe;
  public boolean ahf;
  private boolean ahg;
  private boolean ahh = true;
  private boolean ahi;
  private boolean ahj;
  private boolean ahk;
  private boolean ahl;
  private boolean ahm;
  private boolean ahn;
  private boolean aho = true;
  private aiaa jdField_b_of_type_Aiaa = new ksi(this);
  private ArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  protected Button bO;
  protected Button bP;
  private String[] bi;
  protected ViewTreeObserver.OnGlobalLayoutListener c;
  public XPanelContainer c;
  private String commentId = "";
  private afmf d = new ksh(this);
  protected LinearLayout dy;
  protected LinearLayout dz;
  public RelativeLayout eP;
  protected RelativeLayout eQ;
  protected RelativeLayout eR;
  protected RelativeLayout eS;
  protected RelativeLayout eT;
  private int feedstype = 1;
  protected ImageView hZ;
  protected ImageView iA;
  public ImageView iB;
  protected ImageView iC;
  protected ImageView iD;
  protected ImageView iE;
  protected boolean isSelected;
  public ImageView ix;
  protected ImageView iy;
  protected ImageView iz;
  protected arhz j;
  private FragmentActivity mActivity;
  protected int mCommentType;
  private boolean mIsGalleryChannel;
  public ViewGroup.LayoutParams mLayoutParams;
  public FrameLayout mRootLayout;
  protected int mSourceType;
  public int mStatusBarHeight;
  public TextView oN;
  protected TextView oO;
  public TextView oP;
  protected TextView oQ;
  private SharedPreferences sp;
  protected TextWatcher textWatcher = new ksb(this);
  public final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  
  public ReadInJoyCommentComponentFragment()
  {
    this.jdField_c_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new ksc(this);
  }
  
  private boolean At()
  {
    if (this.afa) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver overlong!");
      }
    }
    do
    {
      return false;
      if (aqiw.isNetworkAvailable(this.mActivity)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver network error!");
    return false;
    return true;
  }
  
  private boolean Au()
  {
    return awit.z(this.mActivity.app) == 1;
  }
  
  private ykm a()
  {
    if ((this.mActivity == null) || (this.mActivity.app == null)) {}
    Object localObject;
    do
    {
      Bundle localBundle;
      do
      {
        return null;
        localObject = this.mActivity.app;
        localBundle = getArguments();
      } while (((localBundle != null) && (!localBundle.getBoolean("arg_comment_zhitu_switch", true))) || (awit.r((AppRuntime)localObject) != 0));
      localObject = ykm.a((AppInterface)localObject);
    } while ((localObject == null) || (!((ykm)localObject).TQ()));
    return localObject;
  }
  
  private void aCW()
  {
    if (this.aIK == 2) {
      oM(1);
    }
    for (;;)
    {
      ykm localykm = a();
      if ((localykm != null) && (this.ahi))
      {
        localykm.ciX();
        this.ahi = false;
        this.iB.setSelected(false);
      }
      return;
      oM(2);
      kbp.a(null, "", "0X800844B", "0X800844B", 0, 0, "", "", "", f(false), false);
    }
  }
  
  private void aGc()
  {
    if (this.aLu == -1) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentComponentFragment.2(this));
  }
  
  private void aGd()
  {
    this.eP.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) {
      kbp.a(null, "", "0X800844D", "0X800844D", 0, 0, "", "", "", f(false), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
      this.jdField_a_of_type_Ykv = null;
      aGh();
      this.iC.setClickable(true);
      if (this.ahj)
      {
        this.ahj = false;
        this.iC.setImageResource(2130843668);
      }
      return;
      if (this.jdField_a_of_type_Ykv != null) {
        kbp.a(null, "", "0X8008F5A", "0X8008F5A", 0, 0, "", "", "", f(false), false);
      }
    }
  }
  
  private void aGe()
  {
    if (!this.ahe) {}
    for (boolean bool = true;; bool = false)
    {
      this.ahe = bool;
      if (!this.ahe) {
        break;
      }
      this.iy.setBackgroundResource(2130843554);
      return;
    }
    this.iy.setBackgroundResource(2130843553);
  }
  
  private void aGf()
  {
    if (this.aIK == 3) {
      oM(1);
    }
    for (;;)
    {
      ykm localykm = a();
      if ((localykm != null) && (this.ahi))
      {
        localykm.ciX();
        this.ahi = false;
        this.iB.setSelected(false);
      }
      return;
      oM(3);
      kbp.a(null, "", "0X800844C", "0X800844C", 0, 0, "", "", "", f(false), false);
    }
  }
  
  private void aGg()
  {
    if (!At()) {
      return;
    }
    if (!TextUtils.isEmpty(ii())) {}
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) {
        i += 2;
      }
      for (;;)
      {
        String str = "0X800844E";
        if (this.aLu == 1) {
          str = "0X80094A1";
        }
        kbp.a(null, "", str, str, 0, 0, String.valueOf(this.mCommentType), String.valueOf(i), "", f(true), false);
        if (this.jdField_a_of_type_Ykv == null)
        {
          this.mActivity.setResult(-1, k());
          this.mActivity.finish();
          return;
          if (this.jdField_a_of_type_Ykv != null) {
            i += 4;
          }
        }
        else
        {
          showLoading(2131697438);
          mw(this.jdField_a_of_type_Ykv.path);
          return;
        }
      }
    }
  }
  
  private void aGh()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData == null)
    {
      if (this.jdField_a_of_type_Ykv == null) {
        break label44;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      this.bO.setEnabled(bool1);
      if (this.bP != null) {
        this.bP.setEnabled(bool1);
      }
      return;
      label44:
      bool1 = bool2;
      if (TextUtils.isEmpty(ii())) {
        bool1 = false;
      }
    }
  }
  
  private void aGk()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (((!ndi.P(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (kvm.i(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.DC()))) {
      this.ahh = false;
    }
    if (!this.ahh)
    {
      this.dy.setVisibility(8);
      this.isSelected = false;
    }
  }
  
  private void aGl()
  {
    if ((kqc.Al()) && (this.aho)) {
      this.ahn = true;
    }
    if (!this.ahn)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 1, "initBiuAndCommentMix isBiuAndCommentMixType is false");
      return;
    }
    aGm();
    aGo();
    aGr();
  }
  
  private void aGm()
  {
    this.dy.setVisibility(8);
    this.bO.setVisibility(8);
    this.eS.setVisibility(0);
    if (TextUtils.isEmpty(this.abX)) {
      this.eT.setVisibility(0);
    }
    aGn();
  }
  
  private void aGn()
  {
    this.bi = kqc.iA().split("\\|");
    if (this.bi.length > 0) {
      this.aLw = new Random().nextInt(this.bi.length);
    }
    if (!TextUtils.isEmpty(this.bi[this.aLw])) {
      this.oP.setText(this.bi[this.aLw]);
    }
    String str = kqc.iB();
    if (!TextUtils.isEmpty(str)) {
      this.bP.setText(str);
    }
    if (kqc.Ao()) {
      this.dz.setVisibility(8);
    }
    do
    {
      return;
      this.dz.setVisibility(0);
      str = kqc.iC();
      if (!TextUtils.isEmpty(str)) {
        this.oQ.setText(str);
      }
      if (kqc.Am()) {
        mE(true);
      }
    } while (!kqc.An());
    if (((Boolean)awit.f("rij_sp_editor_last_check", Boolean.valueOf(false))).booleanValue())
    {
      mE(true);
      return;
    }
    mE(false);
  }
  
  private void aGo()
  {
    ksd localksd = new ksd(this);
    this.dz.setOnClickListener(localksd);
    this.bP.setOnClickListener(localksd);
    this.oP.setOnClickListener(localksd);
  }
  
  private void aGp()
  {
    aGq();
    if (!At()) {
      return;
    }
    if (kqc.An()) {
      awit.H("rij_sp_editor_last_check", Boolean.valueOf(this.ahd));
    }
    this.mActivity.setResult(1699, l());
    this.mActivity.finish();
  }
  
  private void aGq()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "reportMixCommentBiuBtnClick | mArticleInfo is null");
      return;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("feeds_type", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
      ((JSONObject)localObject2).put("feedsid", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId);
      ((JSONObject)localObject2).put("version", kct.XU);
      ((JSONObject)localObject2).put("os", "1");
      ((JSONObject)localObject2).put("entry", 1);
      ((JSONObject)localObject2).put("place", 1);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("ReadInJoyCommentComponentFragment", 2, localJSONException.getMessage());
      }
    }
    kbp.a(null, ksz.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800AB7B", "0X800AB7B", 0, 0, String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.mSourceType), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject1, false);
  }
  
  private void aGr()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "reportMixCommentBiuBtnExposure | mArticleInfo is null");
      return;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("feeds_type", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
      ((JSONObject)localObject2).put("feedsid", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId);
      ((JSONObject)localObject2).put("version", kct.XU);
      ((JSONObject)localObject2).put("os", "1");
      ((JSONObject)localObject2).put("entry", 1);
      ((JSONObject)localObject2).put("place", 1);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("ReadInJoyCommentComponentFragment", 2, localJSONException.getMessage());
      }
    }
    kbp.a(null, ksz.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800AB7A", "0X800AB7A", 0, 0, String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.mSourceType), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject1, false);
  }
  
  private void cg(View paramView)
  {
    this.eS = ((RelativeLayout)paramView.findViewById(2131363538));
    this.eT = ((RelativeLayout)paramView.findViewById(2131363541));
    this.dz = ((LinearLayout)paramView.findViewById(2131363535));
    this.oP = ((TextView)paramView.findViewById(2131363542));
    this.iE = ((ImageView)paramView.findViewById(2131363537));
    this.bP = ((Button)paramView.findViewById(2131363536));
    this.oQ = ((TextView)paramView.findViewById(2131363539));
  }
  
  private String f(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", kxm.aMw);
      if (paramBoolean) {
        if (!this.isSelected) {
          break label48;
        }
      }
      label48:
      for (String str = "0";; str = "1")
      {
        localJSONObject.put("biu_comment", str);
        return localJSONObject.toString();
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void initData()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null) {
      return;
    }
    if (localBundle.getBoolean("arg_comment_enable_anonymous", false)) {
      this.iy.setVisibility(0);
    }
    this.ahh = localBundle.getBoolean("comment_can_biu", true);
    String str1 = localBundle.getString("arg_comment_placeholder", "");
    QLog.d("ReadInJoyCommentComponentFragment", 2, "initData | comment_placeholder : " + str1);
    if (!TextUtils.isEmpty(str1)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setHint(str1);
    }
    int i = localBundle.getInt("arg_comment_max_length", -1);
    if (i > 0) {
      this.aLs = i;
    }
    label167:
    SpannableStringBuilder localSpannableStringBuilder;
    for (;;)
    {
      if (this.aLs > 1000) {
        this.aLs = 1000;
      }
      i = localBundle.getInt("arg_comment_open_at", 0);
      boolean bool;
      Object localObject1;
      if ((awit.A(this.mActivity.app) == 0) && (i == 1))
      {
        bool = true;
        this.afe = bool;
        if ((!this.afe) && (this.hZ != null)) {
          this.hZ.setVisibility(8);
        }
        if (this.aIR <= 0)
        {
          this.aIR = getResources().getDisplayMetrics().widthPixels;
          this.aIR = (this.aIR - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingLeft() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingRight());
        }
        localObject1 = localBundle.getString("arg_comment_default_comment_at", "");
        if ((!this.afe) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label972;
        }
      }
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localSpannableStringBuilder = new SpannableStringBuilder();
        i = ((JSONArray)localObject1).length() - 1;
        label295:
        if (i < 0) {
          break label944;
        }
        Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        long l1 = ((JSONObject)localObject2).optLong("uin");
        String str4 = new String(aqgo.decode(((JSONObject)localObject2).optString("nick"), 0));
        String str3 = new String(aqgo.decode(((JSONObject)localObject2).optString("comment"), 0));
        ((JSONObject)localObject2).optString("op_type");
        long l2 = ((JSONObject)localObject2).optLong("feedsId");
        if (i != ((JSONArray)localObject1).length() - 1)
        {
          localObject2 = "@" + str4 + " ";
          int k = localSpannableStringBuilder.length();
          localSpannableStringBuilder.append((CharSequence)localObject2).append(str3);
          localSpannableStringBuilder.setSpan(new AtFriendsSpan(String.valueOf(l1), l2, (CharSequence)localObject2, this.mActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaint(), this.aIR), k, ((String)localObject2).length() + k, 33);
        }
        for (;;)
        {
          i -= 1;
          break label295;
          i = awit.p(this.mActivity.app);
          if (i <= 0) {
            break;
          }
          this.aLs = i;
          break;
          bool = false;
          break label167;
          localSpannableStringBuilder.append(str3);
        }
        if (localBundle.getBoolean("arg_comment_gif_switch", true)) {
          break label1067;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        this.oN.setText(String.valueOf(this.aLs));
      }
    }
    this.iA.setVisibility(8);
    for (;;)
    {
      if (localBundle.getBoolean("arg_comment_transparent_bg", false)) {
        this.eQ.setBackgroundColor(0);
      }
      String str2 = this.mActivity.app.getCurrentAccountUin();
      this.sp = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + str2, 4);
      this.ahk = this.mActivity.getIntent().getBooleanExtra("comment_native", false);
      this.ahl = this.mActivity.getIntent().getBooleanExtra("comment_reply_second", false);
      if (this.ahl) {
        this.abU = this.mActivity.getIntent().getStringExtra("comment_reply_second_uin");
      }
      if (this.ahk)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)this.mActivity.getIntent().getParcelableExtra("comment_articleid"));
        this.abW = this.mActivity.getIntent().getStringExtra("comment_val");
        this.abX = this.mActivity.getIntent().getStringExtra("comment_author_uin");
        this.aKZ = this.mActivity.getIntent().getIntExtra("biu_src", 1);
        this.feedstype = this.mActivity.getIntent().getIntExtra("feedsType", 1);
        this.commentId = this.mActivity.getIntent().getStringExtra("comment_id");
        this.abV = this.mActivity.getIntent().getStringExtra("first_comment_uin");
        this.mIsGalleryChannel = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mIsGalleryChannel;
      }
      if (this.mActivity.getIntent().getBooleanExtra("comment_is_show_pic", false))
      {
        this.iD.setVisibility(0);
        this.iD.setOnClickListener(this);
      }
      this.mCommentType = localBundle.getInt("arg_comment_comment_type", 0);
      this.mSourceType = localBundle.getInt("arg_comment_source_type", 0);
      this.aLu = localBundle.getInt("click_comment_edit_src");
      mv(str1);
      this.ahm = localBundle.getBoolean("arg_ad_show_biu", true);
      this.aho = localBundle.getBoolean("comment_type", true);
      return;
      label944:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setText(localSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(localSpannableStringBuilder.length());
      aGh();
      break;
      label972:
      str2 = localBundle.getString("arg_comment_default_txt", "");
      if (!TextUtils.isEmpty(str2))
      {
        str2 = anbk.nn(str2);
        if ("@".equals(str2)) {
          this.ahg = true;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setText(str2);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(str2.length());
        aGh();
        break;
      }
      if (this.oN == null) {
        break;
      }
      this.oN.setText(String.valueOf(this.aLs));
      break;
      label1067:
      if (awit.q(this.mActivity.app) == 1) {
        this.iA.setVisibility(8);
      }
    }
  }
  
  private Intent k()
  {
    int i = 1;
    Intent localIntent = this.mActivity.getIntent();
    JSONObject localJSONObject1 = new JSONObject();
    label983:
    for (;;)
    {
      try
      {
        localJSONObject1.put("isAnonymous", this.ahe);
        localJSONObject1.put("comment", new String(aqgo.encode(ii().getBytes(), 0)));
        Object localObject1;
        Object localObject3;
        Object localObject4;
        b localb;
        JSONObject localJSONObject2;
        if ((this.jdField_a_of_type_Ykv != null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null))
        {
          localJSONObject1.put("biuAfterComment", 0);
          if (this.ahk)
          {
            if (!TextUtils.isEmpty(this.abU)) {
              continue;
            }
            localObject1 = "";
            localJSONObject1.put("replyUin", localObject1);
            localJSONObject1.put("isSecondReply", this.ahl);
            localJSONObject1.put("commentId", this.commentId);
            localJSONObject1.put("commentUin", this.abV);
          }
          if (this.isSelected)
          {
            localObject1 = u();
            if (localObject1 != null) {
              localJSONObject1.put("biu_info", localObject1);
            }
          }
          if ((!this.afe) || (TextUtils.isEmpty(ii()))) {
            continue;
          }
          localObject3 = new ArrayList();
          t((ArrayList)localObject3);
          if (((ArrayList)localObject3).size() <= 0) {
            continue;
          }
          localObject4 = new JSONArray();
          i = ((ArrayList)localObject3).size() - 1;
          if (i < 0) {
            continue;
          }
          localb = (b)((ArrayList)localObject3).get(i);
          localJSONObject2 = new JSONObject();
        }
        try
        {
          localJSONObject2.put("uin", Long.valueOf(localb.uin));
          localObject1 = "";
          if (TextUtils.isEmpty(localb.n)) {
            localb.J(this.mActivity.app);
          }
          if (localb.n != null) {
            localObject1 = localb.n.toString();
          }
          localJSONObject2.put("nick", new String(aqgo.encode(((String)localObject1).getBytes(), 0)));
          localObject1 = "";
          if (localb.o != null) {
            localObject1 = localb.o.toString();
          }
          localJSONObject2.put("comment", new String(aqgo.encode(((String)localObject1).getBytes(), 0)));
          localJSONObject2.put("op_type", localb.opType);
          ((JSONArray)localObject4).put(localJSONObject2);
          i -= 1;
          continue;
          if (!this.isSelected) {
            break label983;
          }
          localJSONObject1.put("biuAfterComment", i);
          continue;
          localObject1 = this.abU;
        }
        catch (Exception localException)
        {
          localJSONObject2.put("uin", 0L);
          continue;
        }
        localJSONObject1.put("commentAtLevel", localObject4);
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null)
        {
          localObject2 = new JSONArray();
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("picType", 3);
          ((JSONObject)localObject3).put("url", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalUrl);
          ((JSONObject)localObject3).put("md5", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalMD5);
          ((JSONObject)localObject3).put("width", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalWidth);
          ((JSONObject)localObject3).put("height", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalHeight);
          ((JSONObject)localObject3).put("thumbnail_url", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.url);
          ((JSONObject)localObject3).put("thumbnail_md5", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.md5);
          ((JSONObject)localObject3).put("thumbnail_width", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.width);
          ((JSONObject)localObject3).put("thumbnail_height", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.height);
          ((JSONArray)localObject2).put(localObject3);
          localJSONObject1.put("picInfoList", localObject2);
        }
        if ((this.jdField_a_of_type_Ykv != null) && (this.jdField_a_of_type_Ykv.bnd))
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(this.jdField_a_of_type_Ykv.path, (BitmapFactory.Options)localObject2);
          localObject3 = new JSONArray();
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("picType", 3);
          ((JSONObject)localObject4).put("url", this.jdField_a_of_type_Ykv.uploadUrl);
          ((JSONObject)localObject4).put("md5", this.jdField_a_of_type_Ykv.aYw);
          ((JSONObject)localObject4).put("width", ((BitmapFactory.Options)localObject2).outWidth);
          ((JSONObject)localObject4).put("height", ((BitmapFactory.Options)localObject2).outHeight);
          ((JSONObject)localObject4).put("thumbnail_url", this.jdField_a_of_type_Ykv.uploadUrl);
          ((JSONObject)localObject4).put("thumbnail_md5", this.jdField_a_of_type_Ykv.aYw);
          ((JSONObject)localObject4).put("thumbnail_width", ((BitmapFactory.Options)localObject2).outWidth);
          ((JSONObject)localObject4).put("thumbnail_height", ((BitmapFactory.Options)localObject2).outHeight);
          ((JSONArray)localObject3).put(localObject4);
          localJSONObject1.put("picInfoList", localObject3);
        }
        Object localObject2 = localJSONObject1.toString();
        ReadInJoyUserInfoModule.a(Long.parseLong(kxm.getAccount()), null);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentComponentFragment", 2, "finish resultJson=" + (String)localObject2);
        }
        localIntent.putExtra("arg_result_json", (String)localObject2);
        localIntent.putExtra("comment_articleid", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        localIntent.putExtra("comment_gallery_channel", this.mIsGalleryChannel);
        localIntent.putExtra("comment_cmd", this.aLv);
        if (TextUtils.isEmpty(this.abX))
        {
          i = 2;
          localIntent.putExtra("click_comment_edit_src", i);
          return localIntent;
        }
        i = 3;
        continue;
        i = 0;
      }
      catch (JSONException localJSONException)
      {
        return localIntent;
      }
    }
  }
  
  /* Error */
  private Intent l()
  {
    // Byte code:
    //   0: new 399	java/lang/String
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 385	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:ii	()Ljava/lang/String;
    //   8: invokevirtual 945	java/lang/String:getBytes	()[B
    //   11: iconst_0
    //   12: invokestatic 949	aqgo:encode	([BI)[B
    //   15: invokespecial 777	java/lang/String:<init>	([B)V
    //   18: astore 5
    //   20: aload_0
    //   21: invokespecial 249	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:k	()Landroid/content/Intent;
    //   24: astore 4
    //   26: new 574	org/json/JSONObject
    //   29: dup
    //   30: invokespecial 575	org/json/JSONObject:<init>	()V
    //   33: astore_2
    //   34: aload 4
    //   36: ldc_w 1091
    //   39: invokevirtual 867	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifne +206 -> 253
    //   50: new 574	org/json/JSONObject
    //   53: dup
    //   54: aload_3
    //   55: invokespecial 1111	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 858	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:ahk	Z
    //   65: ifeq +61 -> 126
    //   68: aload_0
    //   69: getfield 869	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:abU	Ljava/lang/String;
    //   72: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifeq +153 -> 228
    //   78: ldc 132
    //   80: astore_3
    //   81: aload_2
    //   82: ldc_w 953
    //   85: aload_3
    //   86: invokevirtual 603	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   89: pop
    //   90: aload_2
    //   91: ldc_w 955
    //   94: aload_0
    //   95: getfield 862	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:ahl	Z
    //   98: invokevirtual 941	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   101: pop
    //   102: aload_2
    //   103: ldc_w 956
    //   106: aload_0
    //   107: getfield 134	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:commentId	Ljava/lang/String;
    //   110: invokevirtual 603	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload_2
    //   115: ldc_w 958
    //   118: aload_0
    //   119: getfield 136	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:abV	Ljava/lang/String;
    //   122: invokevirtual 603	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   125: pop
    //   126: aload_2
    //   127: ldc_w 779
    //   130: aload 5
    //   132: invokevirtual 603	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload_2
    //   137: ldc_w 1113
    //   140: aload_0
    //   141: getfield 561	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:ahd	Z
    //   144: invokevirtual 941	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload 4
    //   150: ldc_w 1091
    //   153: aload_2
    //   154: invokevirtual 614	org/json/JSONObject:toString	()Ljava/lang/String;
    //   157: invokevirtual 1095	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   160: pop
    //   161: aload_0
    //   162: getfield 198	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:abX	Ljava/lang/String;
    //   165: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   168: ifeq +76 -> 244
    //   171: iconst_2
    //   172: istore_1
    //   173: aload 4
    //   175: ldc_w 904
    //   178: iload_1
    //   179: invokevirtual 1110	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   182: pop
    //   183: aload 4
    //   185: ldc_w 871
    //   188: aload_0
    //   189: getfield 435	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   192: invokevirtual 1098	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   195: pop
    //   196: ldc 210
    //   198: iconst_1
    //   199: new 688	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 689	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 1115
    //   209: invokevirtual 695	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_2
    //   213: invokevirtual 614	org/json/JSONObject:toString	()Ljava/lang/String;
    //   216: invokevirtual 695	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 696	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload 4
    //   227: areturn
    //   228: aload_0
    //   229: getfield 869	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:abU	Ljava/lang/String;
    //   232: astore_3
    //   233: goto -152 -> 81
    //   236: astore_3
    //   237: aload_3
    //   238: invokevirtual 674	org/json/JSONException:printStackTrace	()V
    //   241: goto -93 -> 148
    //   244: iconst_3
    //   245: istore_1
    //   246: goto -73 -> 173
    //   249: astore_3
    //   250: goto -13 -> 237
    //   253: goto -192 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	ReadInJoyCommentComponentFragment
    //   172	74	1	i	int
    //   33	180	2	localObject1	Object
    //   42	191	3	localObject2	Object
    //   236	2	3	localJSONException1	JSONException
    //   249	1	3	localJSONException2	JSONException
    //   24	202	4	localIntent	Intent
    //   18	113	5	str	String
    // Exception table:
    //   from	to	target	type
    //   34	59	236	org/json/JSONException
    //   61	78	249	org/json/JSONException
    //   81	126	249	org/json/JSONException
    //   126	148	249	org/json/JSONException
    //   228	233	249	org/json/JSONException
  }
  
  private void mE(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.iE.setImageResource(2130843668);
      this.ahd = true;
      return;
    }
    this.iE.setImageResource(2130843667);
    this.ahd = false;
  }
  
  private void mv(String paramString)
  {
    paramString = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", kxm.aMw);
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
        ((JSONObject)localObject).put("consume_time", kxy.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, false) / 1000L);
      }
      localObject = ((JSONObject)localObject).toString();
      paramString = (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    kbp.a(null, "", "0X800844A", "0X800844A", 0, 0, String.valueOf(1), String.valueOf(this.mSourceType), "", paramString, false);
  }
  
  private void oM(int paramInt)
  {
    int m = 2130850239;
    this.aIK = paramInt;
    int k = 2130843783;
    int i;
    if (paramInt == 1)
    {
      if ((this.jdField_c_of_type_ComTencentWidgetXPanelContainer == null) || (this.jdField_c_of_type_ComTencentWidgetXPanelContainer.vm() == 1)) {
        break label204;
      }
      this.jdField_c_of_type_ComTencentWidgetXPanelContainer.abp(1);
      paramInt = 2130843781;
      i = k;
    }
    for (;;)
    {
      if (this.iz != null) {
        this.iz.setImageResource(paramInt);
      }
      if (this.iA != null) {
        this.iA.setImageResource(i);
      }
      return;
      if (paramInt == 2)
      {
        i = k;
        paramInt = m;
        if (this.jdField_c_of_type_ComTencentWidgetXPanelContainer != null)
        {
          i = k;
          paramInt = m;
          if (this.jdField_c_of_type_ComTencentWidgetXPanelContainer.vm() != 3)
          {
            this.jdField_c_of_type_ComTencentWidgetXPanelContainer.abp(3);
            i = k;
            paramInt = m;
          }
        }
      }
      else
      {
        if (paramInt == 3)
        {
          if ((this.jdField_c_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_c_of_type_ComTencentWidgetXPanelContainer.vm() != 24))
          {
            this.jdField_c_of_type_ComTencentWidgetXPanelContainer.abp(24);
            i = 2130850239;
            paramInt = 2130843781;
          }
        }
        else
        {
          if ((paramInt == 0) && (this.jdField_c_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_c_of_type_ComTencentWidgetXPanelContainer.vm() != 0)) {
            this.jdField_c_of_type_ComTencentWidgetXPanelContainer.aJS();
          }
          label204:
          paramInt = 2130843781;
          i = k;
          continue;
        }
        i = 2130850239;
        paramInt = 2130843781;
      }
    }
  }
  
  private void pz(int paramInt)
  {
    this.aLv = paramInt;
  }
  
  protected void Hh()
  {
    pz(1);
    this.mActivity.setResult(-1, k());
    this.mActivity.finish();
  }
  
  public void a(ykv paramykv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "onZhituSend:" + paramykv);
    }
    this.jdField_a_of_type_Ykv = paramykv;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
    ThreadManager.getUIHandler().post(new ReadInJoyCommentComponentFragment.9(this, paramykv));
  }
  
  public void aAt()
  {
    if ((this.j != null) && (this.j.isShowing())) {
      this.j.dismiss();
    }
  }
  
  protected void aCU()
  {
    if (this.afe) {
      md("1");
    }
    ykm localykm = a();
    if ((localykm != null) && (this.ahi))
    {
      localykm.ciX();
      this.ahi = false;
      this.iB.setSelected(false);
    }
  }
  
  protected void aGi()
  {
    if ((this.jdField_a_of_type_Ykv != null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null)) {
      return;
    }
    if (!this.isSelected)
    {
      this.iC.setImageResource(2130843668);
      this.isSelected = true;
      if (!this.isSelected) {
        break label92;
      }
    }
    label92:
    for (String str = "0";; str = "1")
    {
      kbp.a(null, "", "0X8008F58", "0X8008F58", 0, 0, str, "", "", f(false), false);
      return;
      this.iC.setImageResource(2130843667);
      this.isSelected = false;
      break;
    }
  }
  
  protected void aGj()
  {
    ykm localykm = a();
    if (localykm != null)
    {
      if (!this.ahi) {
        break label60;
      }
      localykm.ciX();
      this.ahi = false;
      this.iB.setSelected(false);
    }
    for (;;)
    {
      kbp.a(null, "", "0X8008F59", "0X8008F59", 0, 0, "", "", "", f(false), false);
      label60:
      Editable localEditable;
      do
      {
        return;
        localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
      } while (!localykm.b(localEditable));
      if (localEditable.length() > 24)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getContext(), "24个字符以内才支持转为智图。", 0).show();
        return;
      }
      localykm.a(this.mActivity, this.eR, null, null, false, this.uiHandler);
      if (localykm.hs.getChildCount() > 1) {
        localykm.hs.removeViewAt(0);
      }
      localykm.a(this.mActivity.app, localEditable, null, 7220, false);
      localykm.a(this);
      this.ahi = true;
      this.iB.setSelected(true);
      this.uiHandler.removeMessages(84);
      this.uiHandler.sendEmptyMessageDelayed(84, 10000L);
    }
  }
  
  public void gR()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText != null)
    {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.clearFocus();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.uiHandler.removeMessages(84);
      paramMessage = a();
      if ((paramMessage != null) && (this.ahi))
      {
        paramMessage.ciX();
        this.ahi = false;
        this.iB.setSelected(false);
      }
    }
  }
  
  protected String ii()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getEditableText();
    String str;
    if ((localObject == null) || (((Editable)localObject).length() <= 0)) {
      str = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "getCommentString result=" + str);
      }
      return str;
      str = UUID.randomUUID().toString();
      localObject = mkt.V(localObject.toString(), str).trim();
      if (((String)localObject).length() <= 0) {
        str = "";
      } else {
        str = anbk.nm(mkt.W(((String)localObject).replaceAll("\n|\r\n", ""), str));
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setSoftInputMode(17);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void md(String paramString)
  {
    this.jdField_c_of_type_ComTencentWidgetXPanelContainer.aJS();
    Intent localIntent = new Intent(this.mActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_min", 1);
    localIntent.putExtra("param_max", 10);
    startActivityForResult(localIntent, 10000);
    kbp.a(null, "", "0X8008660", "0X8008660", 0, 0, paramString, "", "", f(false), false);
  }
  
  public void mw(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      aAt();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic empty path!");
      }
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyCommentComponentFragment.3(this, paramString));
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    r(paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    this.mActivity.setResult(0, k());
    aGc();
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
      this.mActivity.doOnBackPressed();
      continue;
      aGd();
      continue;
      aGe();
      continue;
      aCW();
      continue;
      aGf();
      continue;
      aGg();
      continue;
      aCU();
      continue;
      aGj();
      continue;
      aGi();
      continue;
      Hh();
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mActivity = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2131560285, paramViewGroup, false);
    this.eQ = ((RelativeLayout)paramLayoutInflater.findViewById(2131363228));
    this.eQ.setOnClickListener(this);
    this.eP = ((RelativeLayout)paramLayoutInflater.findViewById(2131368895));
    this.ix = ((ImageView)paramLayoutInflater.findViewById(2131368896));
    this.ix.setOnClickListener(this);
    paramLayoutInflater.findViewById(2131368899).setOnClickListener(this);
    this.iy = ((ImageView)paramLayoutInflater.findViewById(2131362731));
    this.iy.setOnClickListener(this);
    this.iz = ((ImageView)paramLayoutInflater.findViewById(2131366307));
    this.iz.setOnClickListener(this);
    this.iA = ((ImageView)paramLayoutInflater.findViewById(2131368018));
    this.iD = ((ImageView)paramLayoutInflater.findViewById(2131368993));
    if (!ahzd.a(this.mActivity.app).aoB()) {
      this.iA.setVisibility(8);
    }
    for (;;)
    {
      this.hZ = ((ImageView)paramLayoutInflater.findViewById(2131363023));
      if (this.hZ != null) {
        this.hZ.setOnClickListener(this);
      }
      this.oN = ((TextView)paramLayoutInflater.findViewById(2131364450));
      this.bO = ((Button)paramLayoutInflater.findViewById(2131365717));
      this.bO.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText = ((BiuEditText)paramLayoutInflater.findViewById(2131369276));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.requestFocus();
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setEditableFactory(this.jdField_a_of_type_AndroidTextEditable$Factory);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.addTextChangedListener(this.textWatcher);
        this.jdField_c_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)paramLayoutInflater.findViewById(2131377546));
        this.jdField_c_of_type_ComTencentWidgetXPanelContainer.X(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText, false);
        this.jdField_c_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this.jdField_a_of_type_ComTencentWidgetXPanelContainer$c);
        this.iB = ((ImageView)paramLayoutInflater.findViewById(2131382435));
        this.iB.setOnClickListener(this);
        this.eR = ((RelativeLayout)paramLayoutInflater.findViewById(2131382438));
        cg(paramLayoutInflater);
        initData();
        this.mStatusBarHeight = ImmersiveUtils.getStatusBarHeight(this.mActivity);
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          bool = true;
          this.ahf = bool;
          this.mRootLayout = ((FrameLayout)this.mActivity.findViewById(2131367554));
          this.mLayoutParams = this.mRootLayout.getLayoutParams();
          this.jdField_c_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_c_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
          if (ThemeUtil.isInNightMode(this.mActivity.getAppRuntime()))
          {
            paramViewGroup = paramLayoutInflater.findViewById(2131372391);
            if (paramViewGroup != null) {
              paramViewGroup.setVisibility(0);
            }
          }
          this.j = new arhz(this.mActivity, this.mActivity.getTitleBarHeight());
          this.j.setCanceledOnTouchOutside(true);
          this.iC = ((ImageView)paramLayoutInflater.findViewById(2131364995));
          this.oO = ((TextView)paramLayoutInflater.findViewById(2131365718));
          this.dy = ((LinearLayout)paramLayoutInflater.findViewById(2131363545));
        }
      }
      catch (Exception paramViewGroup)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.amM) {
              this.ahm = false;
            }
            if (this.ahm) {
              break label674;
            }
            this.dy.setVisibility(8);
            if (Au())
            {
              this.iC.setImageResource(2130843668);
              this.isSelected = true;
            }
            aGk();
            aGl();
            V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
            return paramLayoutInflater;
            this.iA.setOnClickListener(this);
            break;
            paramViewGroup = paramViewGroup;
            QLog.e("ReadInJoyCommentComponentFragment", 1, "input set error", paramViewGroup);
          }
          boolean bool = false;
        }
        catch (NullPointerException paramViewGroup)
        {
          for (;;)
          {
            paramViewGroup.printStackTrace();
            continue;
            label674:
            this.dy.setVisibility(0);
            this.dy.setOnClickListener(this);
          }
        }
      }
    }
  }
  
  @TargetApi(16)
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.removeTextChangedListener(this.textWatcher);
    }
    if (this.sp != null)
    {
      this.sp.edit().putBoolean("readinjoy_comment_biu_switch", this.isSelected);
      this.sp.edit().commit();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onDestory();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.setPublicAccountGifListener(null);
    }
    if (this.jdField_c_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_c_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(false);
      this.jdField_c_of_type_ComTencentWidgetXPanelContainer.exR();
      this.jdField_c_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(null);
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_c_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_c_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    ykm localykm = a();
    if (localykm != null) {
      localykm.a(null);
    }
    if (this.mActivity == null) {
      this.mActivity = getActivity();
    }
    if (this.mActivity != null) {
      this.mActivity.app.a().b(this.jdField_a_of_type_Aook);
    }
    gR();
  }
  
  public void onDetach()
  {
    super.onDetach();
    try
    {
      Field localField = Fragment.class.getDeclaredField("mChildFragmentManager");
      localField.setAccessible(true);
      localField.set(this, null);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException(localNoSuchFieldException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
  }
  
  public void onFinish()
  {
    this.mActivity.overridePendingTransition(0, 0);
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
    this.aIL = this.aIK;
  }
  
  public void onResume()
  {
    super.onResume();
    AbstractGifImage.resumeAll();
    if (this.aIL == 1) {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyCommentComponentFragment.1(this), 300L);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    nhr.a(getActivity(), null);
  }
  
  protected void r(int paramInt, Intent paramIntent)
  {
    if ((paramIntent == null) || (!this.afe)) {}
    do
    {
      do
      {
        return;
        localObject = paramIntent.getParcelableArrayListExtra("result_set");
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText == null) || (localObject == null));
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getSelectionStart();
      paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getEditableText();
      paramInt = i;
      if (paramIntent != null)
      {
        paramInt = i;
        if (!TextUtils.isEmpty(paramIntent.toString()))
        {
          paramInt = i;
          if (i > 0)
          {
            paramInt = i;
            if (paramIntent.toString().substring(i - 1, i).equals("@"))
            {
              paramIntent.delete(i - 1, i);
              paramInt = i - 1;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(paramInt);
            }
          }
        }
      }
      if (this.aIR <= 0)
      {
        this.aIR = getResources().getDisplayMetrics().widthPixels;
        this.aIR = (this.aIR - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingLeft() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingRight());
      }
    } while (paramIntent == null);
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
      String str = "@" + BiuNicknameSpan.d(localResultRecord.name) + " ";
      paramIntent.insert(paramInt, str);
      paramIntent.setSpan(new AtFriendsSpan(localResultRecord.uin, 0L, str, this.mActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaint(), this.aIR), paramInt, str.length() + paramInt, 33);
      paramInt = str.length() + paramInt;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(paramInt);
  }
  
  protected void showLoading(int paramInt)
  {
    if (this.j != null)
    {
      this.j.setMessage(paramInt);
      if (!this.j.isShowing()) {
        this.j.show();
      }
    }
  }
  
  protected boolean t(ArrayList<b> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText == null) {
      return true;
    }
    Editable localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
    String str1 = "0";
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {
      str1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    }
    int k = 0;
    int i = 0;
    if ((localEditable == null) || (TextUtils.isEmpty(localEditable.toString())))
    {
      paramArrayList.add(new b(str1, 0L, ""));
      return false;
    }
    String str3 = UUID.randomUUID().toString();
    Object localObject3 = mkt.V(localEditable.toString(), str3).trim();
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      paramArrayList.add(new b(str1, 0L, ""));
      return true;
    }
    localObject1 = (BiuNicknameSpan[])localEditable.getSpans(0, localEditable.length(), BiuNicknameSpan.class);
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      paramArrayList.add(new b(str1, 0L, anbk.nm(mkt.W(((String)localObject3).replaceAll("\n|\r\n", ""), str3))));
      return true;
    }
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).addAll(Arrays.asList((Object[])localObject1));
    Collections.sort((List)localObject3, new a(localEditable));
    long l = 0L;
    localObject3 = ((ArrayList)localObject3).iterator();
    BiuNicknameSpan localBiuNicknameSpan;
    int n;
    int m;
    if (((Iterator)localObject3).hasNext())
    {
      localBiuNicknameSpan = (BiuNicknameSpan)((Iterator)localObject3).next();
      n = localEditable.getSpanStart(localBiuNicknameSpan);
      m = localEditable.getSpanEnd(localBiuNicknameSpan);
    }
    label545:
    for (;;)
    {
      String str2;
      try
      {
        localObject1 = localEditable.subSequence(k, n).toString();
        if (localObject1 != null)
        {
          localObject1 = mkt.V((String)localObject1, str3).replaceAll("\n|\r\n", "");
          if (k != 0) {
            break label545;
          }
          localObject1 = ((String)localObject1).substring(((String)localObject1).indexOf(((String)localObject1).trim()));
          paramArrayList.add(new b(str1, l, anbk.nm(mkt.W((String)localObject1, str3)), i));
        }
        if ((localBiuNicknameSpan instanceof AtFriendsSpan))
        {
          i = 1;
          str1 = localBiuNicknameSpan.mUin;
          l = localBiuNicknameSpan.mFeedId;
          k = m;
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        str2 = null;
        continue;
        i = 0;
        continue;
      }
      try
      {
        str2 = localEditable.subSequence(k, localEditable.length()).toString();
        if (str2 != null)
        {
          str2 = mkt.V(str2, str3).replaceAll("\n|\r\n", "");
          paramArrayList.add(new b(str1, l, anbk.nm(mkt.W(str2.substring(0, str2.indexOf(str2.trim()) + str2.trim().length()), str3)), i));
        }
        return false;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          Object localObject2 = null;
        }
      }
    }
  }
  
  public JSONObject u()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      u(localArrayList);
      JSONObject localJSONObject1 = new JSONObject();
      new SocializeFeedsInfo().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c = new SocializeFeedsInfo.c();
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c != null))
      {
        localJSONObject1.put("mOriFeedType", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z);
        localJSONObject1.put("mOriFeedId", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.y);
      }
      localJSONObject1.put("biuSrc", this.aKZ);
      localJSONObject1.put("feedtype", this.feedstype);
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < localArrayList.size())
      {
        b localb = (b)localArrayList.get(i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("biu_info_comment", localb.o);
        localJSONObject2.put("biu_feedid", new Long(localb.sI));
        localJSONObject2.put("biu_optype", localb.opType);
        localJSONObject2.put("biu_uin", localb.uin);
        localJSONObject2.put("biu_nickname", localb.n);
        localJSONArray.put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("biuinfo", localJSONArray);
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "build article info error!");
      }
    }
    return null;
  }
  
  protected boolean u(ArrayList<b> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText == null) {
      return true;
    }
    Editable localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
    Object localObject1 = "0";
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface)) {
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
    }
    if ((!TextUtils.isEmpty(this.abW)) && (!TextUtils.isEmpty(this.abX)) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {}
    for (int k = 1;; k = 0)
    {
      if ((kxm.o(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.aLu == 1)) {}
      int n;
      int i;
      for (int m = 1;; m = 0)
      {
        n = 0;
        i = 0;
        if ((localEditable != null) && (!TextUtils.isEmpty(localEditable.toString()))) {
          break;
        }
        paramArrayList.add(new b((String)localObject1, 0L, ""));
        return false;
      }
      String str2 = UUID.randomUUID().toString();
      Object localObject4 = mkt.V(localEditable.toString(), str2).trim();
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        paramArrayList.add(new b((String)localObject1, 0L, ""));
      }
      for (boolean bool = true;; bool = true)
      {
        if (k != 0)
        {
          this.abW = (": " + this.abW);
          paramArrayList.add(new b(this.abX, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId, this.abW, 0));
        }
        if ((m == 0) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT == null)) {
          break label882;
        }
        localObject1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT;
        k = ((List)localObject1).size();
        i = 0;
        for (;;)
        {
          if (i >= k) {
            break label882;
          }
          localObject2 = (SocializeFeedsInfo.BiuCommentInfo)((List)localObject1).get(i);
          if (localObject2 != null) {
            break;
          }
          label357:
          i += 1;
        }
        localObject2 = (BiuNicknameSpan[])localEditable.getSpans(0, localEditable.length(), BiuNicknameSpan.class);
        if ((localObject2 != null) && (localObject2.length > 0)) {
          break;
        }
        str2 = anbk.nm(mkt.W(((String)localObject4).replaceAll("\n|\r\n", ""), str2));
        if (k == 0)
        {
          localObject2 = str2;
          if (m == 0) {}
        }
        else
        {
          localObject2 = str2 + "//";
        }
        paramArrayList.add(new b((String)localObject1, 0L, "：" + (String)localObject2));
      }
      localObject4 = new ArrayList();
      ((ArrayList)localObject4).addAll(Arrays.asList((Object[])localObject2));
      Collections.sort((List)localObject4, new a(localEditable));
      long l = 0L;
      localObject4 = ((ArrayList)localObject4).iterator();
      BiuNicknameSpan localBiuNicknameSpan;
      int i2;
      int i1;
      if (((Iterator)localObject4).hasNext())
      {
        localBiuNicknameSpan = (BiuNicknameSpan)((Iterator)localObject4).next();
        i2 = localEditable.getSpanStart(localBiuNicknameSpan);
        i1 = localEditable.getSpanEnd(localBiuNicknameSpan);
      }
      label882:
      label885:
      for (;;)
      {
        Object localObject3;
        for (;;)
        {
          String str1;
          try
          {
            localObject2 = localEditable.subSequence(n, i2).toString();
            if (localObject2 != null)
            {
              localObject2 = mkt.V((String)localObject2, str2).replaceAll("\n|\r\n", "");
              if (n != 0) {
                break label885;
              }
              localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(((String)localObject2).trim()));
              paramArrayList.add(new b((String)localObject1, l, anbk.nm(mkt.W((String)localObject2, str2)), i));
            }
            if ((localBiuNicknameSpan instanceof AtFriendsSpan))
            {
              i = 1;
              localObject1 = localBiuNicknameSpan.mUin;
              l = localBiuNicknameSpan.mFeedId;
              n = i1;
            }
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            str1 = null;
            continue;
            i = 0;
            continue;
          }
          try
          {
            str1 = localEditable.subSequence(n, localEditable.length()).toString();
            if (str1 != null)
            {
              str1 = mkt.V(str1, str2).replaceAll("\n|\r\n", "");
              paramArrayList.add(new b((String)localObject1, l, anbk.nm(mkt.W(str1.substring(0, str1.indexOf(str1.trim()) + str1.trim().length()), str2)), i));
            }
            bool = false;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
              localObject3 = null;
            }
          }
        }
        paramArrayList.add(new b(String.valueOf(localObject3.i), localObject3.x.longValue(), localObject3.ahj, localObject3.aSO));
        break label357;
        return bool;
      }
    }
  }
  
  public class a
    implements Comparator<BiuNicknameSpan>
  {
    private Editable mEditable;
    
    public a(Editable paramEditable)
    {
      this.mEditable = paramEditable;
    }
    
    public int a(BiuNicknameSpan paramBiuNicknameSpan1, BiuNicknameSpan paramBiuNicknameSpan2)
    {
      int i = this.mEditable.getSpanStart(paramBiuNicknameSpan1);
      int j = this.mEditable.getSpanStart(paramBiuNicknameSpan2);
      if (i > j) {
        return 1;
      }
      if (i < j) {
        return -1;
      }
      return 0;
    }
  }
  
  public class b
  {
    public CharSequence n;
    public CharSequence o;
    public int opType;
    public long sI;
    public String uin;
    
    public b(String paramString, long paramLong, CharSequence paramCharSequence)
    {
      this(paramString, paramLong, paramCharSequence, 0);
    }
    
    public b(String paramString, long paramLong, CharSequence paramCharSequence, int paramInt)
    {
      this.uin = paramString;
      this.sI = paramLong;
      this$1 = paramCharSequence;
      if (paramCharSequence == null) {
        this$1 = "";
      }
      this.o = ReadInJoyCommentComponentFragment.this;
      this.opType = paramInt;
    }
    
    public void J(QQAppInterface paramQQAppInterface)
    {
      if (!TextUtils.isEmpty(this.uin))
      {
        this.n = BiuNicknameSpan.d(aqgv.b(paramQQAppInterface, this.uin, true));
        if (!TextUtils.isEmpty(this.n)) {
          break label79;
        }
        this.n = this.uin;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentComponentFragment", 2, "nick name is " + this.n);
        }
        return;
        label79:
        if ((int)Math.ceil(ReadInJoyCommentComponentFragment.this.a.getPaint().measureText(this.n.toString())) <= 0) {
          this.n = this.uin;
        }
      }
    }
    
    public String toString()
    {
      int i = 0;
      if (!TextUtils.isEmpty(this.o)) {
        i = this.o.length();
      }
      return "UserBiuInfo {uin=" + this.uin + ", nickName=" + this.n + ", comment=" + this.o + ", length=" + i + ", feedid=" + this.sI + "}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment
 * JD-Core Version:    0.7.0.1
 */