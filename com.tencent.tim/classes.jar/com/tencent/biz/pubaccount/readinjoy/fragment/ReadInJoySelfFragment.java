package com.tencent.biz.pubaccount.readinjoy.fragment;

import acfp;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqbn;
import aqgo;
import aqgz;
import aute;
import awit;
import awit.a;
import awit.b;
import ayxa;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.d;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MySelfNormalItemRedPointInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyMenuIconView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.presseffect.PressEffectLinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kbp;
import kgj;
import kgw;
import kwt;
import kxb;
import kxm;
import kxm.b;
import lbz;
import lcc;
import lce;
import lep;
import leq;
import ler;
import les;
import let;
import leu;
import lev;
import lew;
import lex;
import ley;
import lez;
import lhs;
import liw.a;
import mix;
import mqq.os.MqqHandler;
import msg;
import nhm;
import nhn;
import ntp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import riw;
import wja;

public class ReadInJoySelfFragment
  extends ReadInJoyBaseFragment
  implements View.OnClickListener, KandianMergeManager.d
{
  private ValueAnimator C;
  private ValueAnimator D;
  private ReadInjoyMenuIconView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private PressEffectLinearLayout jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout;
  @Nullable
  private lhs jdField_a_of_type_Lhs;
  private nhn jdField_a_of_type_Nhn;
  private int aOr;
  private int aOs;
  private int aOt;
  private String aeF = "";
  private String aeG = "";
  private String aeH = "";
  private boolean afw = true;
  private boolean afx;
  private boolean afy;
  protected boolean ajL;
  public boolean ajM = false;
  private boolean ajN;
  private boolean ajO;
  private ReadInjoyMenuIconView b;
  private KandianMergeManager jdField_c_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  private ReadInjoyMenuIconView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView;
  private ColorDrawable jdField_d_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
  private ReadInJoyNickNameTextView jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  private ReadInjoyMenuIconView jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView;
  private HorizontalListView jdField_d_of_type_ComTencentWidgetHorizontalListView;
  private LinearLayout dG;
  private HashMap<Integer, a> dH = new HashMap();
  private RelativeLayout eX;
  private RelativeLayout eY;
  private ReadInJoyHeadImageView f;
  public int fromType = 0;
  private RotateAnimation h;
  private RotateAnimation i;
  private ImageView iP;
  private ImageView iQ;
  public float jl;
  public float jm;
  public float jn;
  public float jo;
  private View kl;
  private View km;
  private View kn;
  private View ko;
  private View kp;
  public View mContentView;
  protected lce mObserver = new les(this);
  private TextView ph;
  private TextView pi;
  private TextView pj;
  private TextView pk;
  private TextView pl;
  private TextView pm;
  private TextView pn;
  public URLImageView r;
  int screenWidth;
  private TranslateAnimation v;
  private TranslateAnimation w;
  
  private ValueAnimator a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, wja.dp2px(55.0F, getActivity().getResources()) });
    localValueAnimator.addUpdateListener(new ley(this));
    localValueAnimator.setDuration(300L);
    return localValueAnimator;
  }
  
  private void a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramView == null) {
      return;
    }
    paramView = new a((DragTextView)paramView.findViewById(paramInt2), (RelativeLayout)paramView.findViewById(paramInt3), (URLImageView)paramView.findViewById(paramInt4), (DragTextView)paramView.findViewById(paramInt5));
    this.dH.put(Integer.valueOf(paramInt1), paramView);
    qP(paramInt1);
  }
  
  private void a(@NotNull lhs paramlhs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.readinjoy.self.SelfFragment", 2, "updateColumnInfo, columnInfoForSelfPage=" + paramlhs);
    }
    this.jdField_a_of_type_Lhs = paramlhs;
    View localView;
    if (paramlhs.aPg > 0)
    {
      localView = this.mContentView.findViewById(2131372173);
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131369530)).setText(2131718519);
    }
    if (paramlhs.aPh > 0)
    {
      localView = this.mContentView.findViewById(2131372172);
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131369530)).setText(2131718518);
    }
    mix.e(getActivity(), 1, paramlhs.aeY);
    mix.e(getActivity(), 2, paramlhs.aeX);
    mix.e(getActivity(), 3, paramlhs.aeZ);
  }
  
  private void aE(String paramString, int paramInt)
  {
    int k = 1;
    kxm.b localb1 = new kxm.b();
    boolean bool1 = mix.DN();
    boolean bool2 = mix.DJ();
    kxm.b localb2;
    if (bool1)
    {
      j = 1;
      localb2 = localb1.a("ugc_video_flag", Integer.valueOf(j));
      if (!bool2) {
        break label96;
      }
    }
    label96:
    for (int j = k;; j = 0)
    {
      localb2.a("ugc_column_flag", Integer.valueOf(j));
      if (paramInt != 0) {
        localb1.a("my_column_cnt", Integer.valueOf(paramInt));
      }
      kbp.bp(paramString, localb1.build());
      return;
      j = 0;
      break;
    }
  }
  
  private void aKN()
  {
    if (ThemeUtil.isInNightMode(kxm.getAppRuntime()))
    {
      ViewStub localViewStub = (ViewStub)this.mContentView.findViewById(2131376763);
      if (localViewStub != null) {
        localViewStub.inflate();
      }
    }
  }
  
  private void aLe()
  {
    String str = getResources().getString(2131718519);
    if (mix.DN())
    {
      j = 0;
      b(2131372173, 2131369530, str, 2, j);
      str = getResources().getString(2131718518);
      if (!mix.DM()) {
        break label92;
      }
    }
    label92:
    for (int j = 0;; j = 1)
    {
      b(2131372172, 2131369530, str, 2, j);
      b(2131372164, 2131369530, getResources().getString(2131718516), 2, 0);
      return;
      j = 1;
      break;
    }
  }
  
  private void aLf()
  {
    if (this.afx)
    {
      this.aOs = wja.dp2px(23.0F, getActivity().getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.w(true, -wja.dp2px(100.0F, getResources()), wja.dp2px(100.0F, getResources()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollStateChangedListener(new lev(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new lew(this));
      this.iQ = ((ImageView)this.mContentView.findViewById(2131369671));
      this.dG = ((LinearLayout)this.mContentView.findViewById(2131370960));
      this.dG.setOnClickListener(this);
      this.iQ.setOnClickListener(this);
      this.eX = ((RelativeLayout)this.mContentView.findViewById(2131370975));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout = ((PressEffectLinearLayout)this.mContentView.findViewById(2131370970));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setOnClickListener(this);
      this.pk = ((TextView)this.mContentView.findViewById(2131380924));
      this.pj = ((TextView)this.mContentView.findViewById(2131380675));
      this.pl = ((TextView)this.mContentView.findViewById(2131366169));
      this.pm = ((TextView)this.mContentView.findViewById(2131370448));
      this.ko = this.mContentView.findViewById(2131381969);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.mContentView.findViewById(2131371281));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.mContentView.findViewById(2131371288));
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.mContentView.findViewById(2131371293));
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.mContentView.findViewById(2131371282));
      this.pn = ((TextView)this.mContentView.findViewById(2131380987));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.pj.setOnClickListener(this);
      this.mContentView.findViewById(2131364863).setVisibility(8);
      this.mContentView.findViewById(2131368536).setVisibility(8);
      this.mContentView.findViewById(2131380078).setVisibility(8);
      this.mContentView.findViewById(2131378472).setVisibility(8);
      this.mContentView.findViewById(2131370438).setOnClickListener(this);
      long l = awit.c(getActivity().getAppRuntime());
      this.pm.setText(awit.a(l, 9900000L, "999万", "0"));
      l = awit.b(this.mApp);
      this.pl.setText(awit.a(l, 9900000L, "999万", "0"));
      this.f.setOnClickListener(this);
      this.mContentView.findViewById(2131366162).setOnClickListener(this);
      if (!(getActivity() instanceof ReadInJoyNewFeedsActivity)) {
        break label673;
      }
      this.eX.setVisibility(8);
      int j = this.mContentView.getPaddingTop() - wja.dp2px(22.0F, getResources());
      if (j > 0) {
        this.mContentView.setPadding(0, j, 0, 0);
      }
      ((LinearLayout)this.mContentView.findViewById(2131370972)).setPadding(0, wja.dp2px(4.0F, getResources()), 0, 0);
    }
    for (;;)
    {
      this.mContentView.findViewById(2131370965).setOnClickListener(this);
      aLg();
      aKN();
      kbp.a(null, "", "0X8009923", "0X8009923", 0, 0, "", "", "", "", false);
      return;
      label673:
      if (this.aOt == 2) {
        this.kp.setBackgroundResource(2130847256);
      } else {
        this.kp.setBackgroundResource(2130847253);
      }
    }
  }
  
  private void aLg()
  {
    int j = ayxa.getStatusBarHeight(getActivity());
    Object localObject = (LinearLayout)this.mContentView.findViewById(2131370963);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    localLayoutParams.topMargin = j;
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.dG.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (riw.dip2px(getActivity(), 11.0F) + j);
    this.dG.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.pn.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (riw.dip2px(getActivity(), 11.0F) + j);
    this.pn.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.ko.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (riw.dip2px(getActivity(), 44.0F) + j);
    this.ko.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void aLj()
  {
    String str = mix.a(getActivity(), this.mApp, 2);
    if (!TextUtils.isEmpty(str)) {
      kxm.aJ(getActivity(), str);
    }
    for (;;)
    {
      aE("0X800AC6F", 0);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item myVideoJumpUrl is empty");
    }
  }
  
  private void aLk()
  {
    String str = mix.a(getActivity(), this.mApp, 1);
    if (!TextUtils.isEmpty(str)) {
      kxm.aJ(getActivity(), str);
    }
    while (this.jdField_a_of_type_Lhs != null)
    {
      aE("0X800AC74", this.jdField_a_of_type_Lhs.aPh);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item myColumnJumpUrl is empty");
    }
    aE("0X800AC74", 0);
  }
  
  private void aLl()
  {
    String str = mix.a(getActivity(), this.mApp, 3);
    if (!TextUtils.isEmpty(str)) {
      kxm.aJ(getActivity(), str);
    }
    while (this.jdField_a_of_type_Lhs != null)
    {
      aE("0X800AC7C", this.jdField_a_of_type_Lhs.aPi);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item mySubscribeJumpUrl is empty");
    }
    aE("0X800AC7C", 0);
  }
  
  private void aLm()
  {
    mix.a(getActivity(), null, 1);
  }
  
  private void aLn()
  {
    ColumnInfo localColumnInfo = new ColumnInfo();
    int j = ((Integer)awit.a("key_sp_readinjoy_viola_test_column_id", Integer.valueOf(0), true)).intValue();
    if (j == 0) {
      QQToast.a(getActivity(), 2131718520, 0).show();
    }
    for (;;)
    {
      mix.a(getActivity(), localColumnInfo, 3);
      return;
      localColumnInfo.columnID = j;
    }
  }
  
  private void aLo()
  {
    PublicFragmentActivity.start(getActivity(), ReadInJoyDailySettingFragment.class);
  }
  
  private void aLp()
  {
    PublicFragmentActivity.start(getActivity(), ReadInJoyProteusFamilyFragment.class);
  }
  
  private void aLq()
  {
    Object localObject = kxm.getAccount();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("Q.readinjoy.self.SelfFragment", 2, "click personal page , but uin is empty !");
      return;
    }
    String str = kwt.acF + aqgo.encodeToString(((String)localObject).getBytes(), 2);
    if (!awit.aMR())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("bundle_param_click_time", System.currentTimeMillis());
      kxm.a(this.mContentView.getContext(), str, (Bundle)localObject);
      return;
    }
    ntp.b(this.mContentView.getContext(), "", "https://sqimg.qq.com/qq_product_operations/kan/viola_biz/bundle_accountPage.js?v_bid=3531&v_tid=6&_rij_violaUrl=1&v_bundleName=accountPage&hideNav=1&statusColor=1&v_nav_immer=1&adfrom=client&accountId=" + aqgo.encodeToString(((String)localObject).getBytes(), 2), null);
  }
  
  private void aLr()
  {
    kbp.a(null, "", "0X80096DE", "0X80096DE", 0, 0, "", "", "", "", false);
    PublicFragmentActivity.start(getActivity(), ReadInJoyDraftboxFragment.class);
  }
  
  private void aLs()
  {
    Object localObject1 = ReadInJoyUserInfoModule.a(this.mApp.getLongAccountUin(), null);
    if (localObject1 != null)
    {
      localObject2 = ReadInJoyUserInfoModule.a((ReadInJoyUserInfo)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    }
    else
    {
      return;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(localObject2);
    Object localObject2 = new Intent(getActivity(), TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", 0);
    localBundle.putStringArrayList("seqNum", (ArrayList)localObject1);
    localBundle.putBoolean("needBottomBar", false);
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", false);
    ((Intent)localObject2).putExtras(localBundle);
    getActivity().startActivity((Intent)localObject2);
  }
  
  private void aLt()
  {
    if (this.afx)
    {
      if (this.D == null) {
        this.D = b();
      }
      this.D.start();
    }
    for (;;)
    {
      if (this.i == null)
      {
        this.i = new RotateAnimation(180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        this.i.setDuration(300L);
        this.i.setFillEnabled(true);
        this.i.setFillAfter(true);
      }
      this.iP.startAnimation(this.i);
      return;
      if (this.w == null)
      {
        this.w = new TranslateAnimation(0.0F, 0.0F, 0.0F, -wja.dp2px(70.0F, getResources()));
        this.w.setDuration(300L);
        this.w.setAnimationListener(new lez(this));
      }
      this.kn.startAnimation(this.w);
    }
  }
  
  private void aLu()
  {
    if (this.mApp == null) {
      return;
    }
    msg.a().nR(this.mApp.getCurrentAccountUin());
  }
  
  private void aLv()
  {
    if ((this.mApp == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)) {
      return;
    }
    msg localmsg = msg.a();
    String str = this.mApp.getCurrentAccountUin();
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.BD()) {}
    for (int j = 0;; j = 1)
    {
      localmsg.aN(str, j);
      return;
    }
  }
  
  private void aLw()
  {
    if (this.f != null) {
      this.f.setHeadImgByUin(this.mApp.getLongAccountUin(), false);
    }
    if (this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
    {
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(this.mApp.getLongAccountUin());
      if (this.pn != null) {
        this.pn.setText(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getText());
      }
    }
    int j;
    if (this.ph != null)
    {
      j = awit.D(this.mApp);
      this.ph.setText(awit.gL(j));
    }
    if (this.pi != null)
    {
      j = awit.E(this.mApp);
      this.pi.setText(awit.gL(j));
    }
    Object localObject;
    if (this.iP != null)
    {
      localObject = awit.b(this.mApp);
      if ((localObject != null) && (((List)localObject).size() > 1)) {
        this.iP.setVisibility(0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Nhn != null) {
        this.jdField_a_of_type_Nhn.av(awit.b(this.mApp));
      }
      if (this.pj != null)
      {
        localObject = awit.g(this.mApp);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label400;
        }
        this.pj.setVisibility(0);
        this.pk.setVisibility(8);
        label218:
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.self.SelfFragment", 2, "bindUserInfoViews userDesc = " + (String)localObject);
        }
      }
      long l;
      if (this.pl != null)
      {
        l = awit.b(this.mApp);
        this.pl.setText(awit.a(l, 9900000L, "999万", "0"));
      }
      if (this.pm != null)
      {
        l = awit.c(this.mApp);
        this.pm.setText(awit.a(l, 9900000L, "999万", "0"));
      }
      boolean bool = awit.a(this.mApp).booleanValue();
      if (this.kl != null)
      {
        if (!bool) {
          break label429;
        }
        this.kl.setVisibility(0);
      }
      label353:
      if ((!bool) && (this.km != null))
      {
        if (awit.C(this.mApp) <= 0) {
          break label441;
        }
        this.km.setVisibility(0);
      }
    }
    for (;;)
    {
      aLy();
      return;
      this.iP.setVisibility(8);
      break;
      label400:
      this.pj.setVisibility(8);
      this.pk.setVisibility(0);
      this.pk.setText((CharSequence)localObject);
      break label218;
      label429:
      this.kl.setVisibility(8);
      break label353;
      label441:
      this.km.setVisibility(8);
    }
  }
  
  private void aLx()
  {
    try
    {
      this.jl = getResources().getDimension(2131299208);
      this.jm = getResources().getDimension(2131299210);
      this.jn = getResources().getDimension(2131299211);
      this.jo = getResources().getDimension(2131299209);
      this.screenWidth = ((int)aqgz.hK());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void aLy()
  {
    kgj localkgj = awit.a(this.mApp);
    if ((localkgj == null) || (localkgj.mPicWidth <= 0) || (localkgj.mPicHeight <= 0) || (TextUtils.isEmpty(localkgj.Zb))) {
      QLog.d("Q.readinjoy.self.SelfFragment", 1, "showMedal! no medal info! ");
    }
    ImageView localImageView;
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localImageView = (ImageView)this.mContentView.findViewById(2131368848);
      localViewTreeObserver = this.eY.getViewTreeObserver();
    } while (!localViewTreeObserver.isAlive());
    localViewTreeObserver.addOnGlobalLayoutListener(new let(this, localImageView, localkgj));
  }
  
  private ValueAnimator b()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_d_of_type_ComTencentWidgetHorizontalListView.getHeight(), 0 });
    localValueAnimator.addUpdateListener(new leq(this));
    localValueAnimator.addListener(new ler(this));
    localValueAnimator.setDuration(300L);
    return localValueAnimator;
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    if (this.mContentView == null) {}
    View localView;
    do
    {
      return;
      localView = this.mContentView.findViewById(paramInt1);
    } while (localView == null);
    if (paramInt4 == 0)
    {
      ((TextView)localView.findViewById(paramInt2)).setText(paramString);
      localView.setVisibility(0);
      a(paramInt3, localView, paramString, null, true);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      return;
      localView.setVisibility(8);
    }
  }
  
  private void cj(List<liw.a> paramList)
  {
    HorizontalListView localHorizontalListView = this.jdField_d_of_type_ComTencentWidgetHorizontalListView;
    int j;
    if (paramList.size() == 2)
    {
      j = wja.dp2px(11.0F, getResources());
      localHorizontalListView.setDividerWidth(j);
      this.jdField_a_of_type_Nhn.av(paramList);
      if (!this.afx) {
        break label158;
      }
      if (this.C == null) {
        this.C = a();
      }
      this.C.start();
    }
    for (;;)
    {
      this.jdField_d_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      if (this.h == null)
      {
        this.h = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
        this.h.setDuration(300L);
        this.h.setFillEnabled(true);
        this.h.setFillAfter(true);
      }
      this.iP.startAnimation(this.h);
      return;
      j = wja.dp2px(7.5F, getResources());
      break;
      label158:
      if (this.v == null)
      {
        this.v = new TranslateAnimation(0.0F, 0.0F, -wja.dp2px(70.0F, getResources()), 0.0F);
        this.v.setDuration(300L);
        this.v.setFillAfter(true);
      }
      this.kn.startAnimation(this.v);
    }
  }
  
  private int dk(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.mApp.getManager(162));
    }
    MySelfNormalItemRedPointInfo localMySelfNormalItemRedPointInfo = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(paramInt);
    if (localMySelfNormalItemRedPointInfo != null)
    {
      if ((localMySelfNormalItemRedPointInfo.redPointType == 0) || (TextUtils.isEmpty(localMySelfNormalItemRedPointInfo.imgUrl))) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  private void initUI()
  {
    Object localObject1 = awit.c(this.mApp);
    List localList = awit.d(this.mApp);
    this.kp = this.mContentView.findViewById(2131378132);
    int j;
    Object localObject3;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      j = 0;
      if (j < ((List)localObject1).size())
      {
        localObject2 = (awit.a)((List)localObject1).get(j);
        if (((awit.a)localObject2).id == 10)
        {
          localObject3 = this.mContentView.findViewById(2131372012);
          if (localObject3 != null)
          {
            ((View)localObject3).setOnClickListener(this);
            if (((awit.a)localObject2).eBi != 0) {
              break label148;
            }
            ((TextView)this.mContentView.findViewById(2131372013)).setText(((awit.a)localObject2).title);
            ((View)localObject3).setVisibility(0);
          }
        }
        for (;;)
        {
          j += 1;
          break;
          label148:
          ((View)localObject3).setVisibility(8);
          continue;
          if (((awit.a)localObject2).id == 11)
          {
            b(2131380078, 2131380079, ((awit.a)localObject2).title, 2, ((awit.a)localObject2).eBi);
            a(((awit.a)localObject2).id, this.mContentView, 2131380095, 2131380096, 2131380097, 2131380098);
          }
          else if (((awit.a)localObject2).id == 12)
          {
            b(2131364863, 2131364864, ((awit.a)localObject2).title, 2, ((awit.a)localObject2).eBi);
            a(((awit.a)localObject2).id, this.mContentView, 2131364867, 2131364868, 2131364869, 2131364870);
          }
          else
          {
            if (((awit.a)localObject2).id == 13)
            {
              if (localList != null) {
                b(2131368536, 2131368537, ((awit.a)localObject2).title, 2, ((awit.a)localObject2).eBi);
              }
              for (;;)
              {
                a(((awit.a)localObject2).id, this.mContentView, 2131368543, 2131368544, 2131368545, 2131368546);
                break;
                b(2131368536, 2131368537, ((awit.a)localObject2).title, 3, ((awit.a)localObject2).eBi);
              }
            }
            if (((awit.a)localObject2).id == 14)
            {
              b(2131378472, 2131378473, ((awit.a)localObject2).title, 2, ((awit.a)localObject2).eBi);
              a(((awit.a)localObject2).id, this.mContentView, 2131378474, 2131378475, 2131378476, 2131378477);
            }
            else if (((awit.a)localObject2).id == 15)
            {
              this.aOt = 2;
              b(2131378132, 2131378133, ((awit.a)localObject2).title, this.aOt, ((awit.a)localObject2).eBi);
              a(((awit.a)localObject2).id, this.mContentView, 2131378145, 2131378146, 2131378147, 2131378148);
            }
          }
        }
      }
    }
    else
    {
      localObject1 = this.mContentView.findViewById(2131372012);
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        ((View)localObject1).setOnClickListener(this);
      }
    }
    Object localObject2 = (LinearLayout)this.mContentView.findViewById(2131365666);
    if ((localList != null) && (localList.size() > 0))
    {
      localObject3 = LayoutInflater.from(getActivity());
      j = 0;
      if (j < localList.size())
      {
        awit.b localb = (awit.b)localList.get(j);
        View localView = ((LayoutInflater)localObject3).inflate(2131561636, null);
        TextView localTextView = (TextView)localView.findViewById(2131369530);
        a(localb.id, localView, 2131369536, 2131369537, 2131369538, 2131369539);
        if (localb.title == null)
        {
          localObject1 = "";
          label643:
          localTextView.setText((CharSequence)localObject1);
          if ((localb == null) || (j == localList.size() - 1)) {
            break label715;
          }
          a(2, localb.id, localView, localb.title, localb.jumpUrl, true);
          ((LinearLayout)localObject2).addView(localView);
        }
        for (;;)
        {
          j += 1;
          break;
          localObject1 = localb.title;
          break label643;
          label715:
          if (localb != null)
          {
            a(3, localb.id, localView, localb.title, localb.jumpUrl, true);
            ((LinearLayout)localObject2).addView(localView);
          }
        }
      }
    }
    this.f = ((ReadInJoyHeadImageView)this.mContentView.findViewById(2131368698));
    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)this.mContentView.findViewById(2131372208));
    this.mContentView.findViewById(2131371097).setOnClickListener(this);
    if (this.fromType == 1) {
      this.mContentView.findViewById(2131378087).setVisibility(8);
    }
    int k;
    while (kwt.aid)
    {
      localObject1 = this.mContentView.findViewById(2131366983);
      if (localObject1 == null)
      {
        return;
        k = wja.dp2px(44.5F, getResources());
        j = k;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          j = k + ImmersiveUtils.getStatusBarHeight(getActivity());
        }
        this.mContentView.setPadding(0, j, 0, 0);
        localObject1 = (Switch)this.mContentView.findViewById(2131370023);
        ((Switch)localObject1).setChecked(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.By());
        ((Switch)localObject1).setTrackResource(2130843344);
        ((Switch)localObject1).setThumbResource(2130843343);
        ((Switch)localObject1).setOnClickListener(this);
        ((Switch)localObject1).setOnCheckedChangeListener(new lep(this));
      }
      else
      {
        ((TextView)((View)localObject1).findViewById(2131375088)).setText(kwt.acK);
        localObject1 = this.mContentView.findViewById(2131378132);
        this.aOt = 2;
        ((View)localObject1).setBackgroundResource(2130839695);
      }
    }
    if (kxb.AG()) {
      b(2131373709, 2131373712, "PTS全家桶", 3, 0);
    }
    this.ajN = awit.aMS();
    boolean bool;
    if (((Integer)awit.f("readinjjoy_notes_config", Integer.valueOf(0))).intValue() == 1)
    {
      bool = true;
      this.ajO = bool;
      localObject1 = (LinearLayout)this.mContentView.findViewById(2131377975);
      if ((!this.ajN) && (!this.ajO)) {
        break label1547;
      }
      ((LinearLayout)localObject1).setVisibility(0);
      label1086:
      if (Aladdin.getConfig(302).getIntegerFromString("me_mywallet_switch", 0) != 1) {
        break label1557;
      }
      j = 1;
      label1105:
      if ((!RIJRedPacketManager.a().Dr()) || (!RIJRedPacketManager.a().Dt())) {
        break label1562;
      }
      k = 1;
      label1125:
      if ((j != 0) || (k != 0)) {
        b(2131382113, 2131382114, Aladdin.getConfig(302).getString("entrance_title", acfp.m(2131718558)), 3, 0);
      }
      if ((!this.ajN) || (this.ajO)) {}
      aLh();
      localObject1 = this.mContentView.findViewById(2131367382);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener(this);
        this.ph = ((TextView)this.mContentView.findViewById(2131367399));
        if (this.ph != null)
        {
          j = awit.D(getActivity().getAppRuntime());
          this.ph.setText(awit.gL(j));
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.self.SelfFragment", 2, "initUI followCnt:" + j);
          }
        }
      }
      localObject1 = this.mContentView.findViewById(2131366706);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener(this);
        this.pi = ((TextView)this.mContentView.findViewById(2131366711));
        this.iP = ((ImageView)this.mContentView.findViewById(2131366709));
        this.jdField_d_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.mContentView.findViewById(2131364072));
        this.jdField_a_of_type_Nhn = new nhn(getActivity(), this.jdField_d_of_type_ComTencentWidgetHorizontalListView, this.afx);
        this.jdField_d_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Nhn);
      }
      this.kn = this.mContentView.findViewById(2131378119);
      this.km = this.mContentView.findViewById(2131368753);
      this.kl = this.mContentView.findViewById(2131367497);
      if (this.kl != null)
      {
        if (!awit.a(getActivity().getAppRuntime()).booleanValue()) {
          break label1567;
        }
        this.kl.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131365322));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setDrawFinishedListener(new leu(this));
      this.eY = ((RelativeLayout)this.mContentView.findViewById(2131377974));
      this.r = ((URLImageView)this.mContentView.findViewById(2131371202));
      aLe();
      aLf();
      aLw();
      return;
      bool = false;
      break;
      label1547:
      ((LinearLayout)localObject1).setVisibility(8);
      break label1086;
      label1557:
      j = 0;
      break label1105;
      label1562:
      k = 0;
      break label1125;
      label1567:
      this.kl.setVisibility(8);
    }
  }
  
  private void onShow()
  {
    this.afw = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.invalidate();
    }
  }
  
  private void qO(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.mApp.getManager(162));
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.qm(paramInt);
    qP(paramInt);
  }
  
  private void qP(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.mApp.getManager(162));
    }
    a locala = (a)this.dH.get(Integer.valueOf(paramInt));
    if ((locala == null) || (locala.b == null) || (locala.s == null)) {
      return;
    }
    Object localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(paramInt);
    if (localObject == null)
    {
      locala.eZ.setVisibility(8);
      aute.updateCustomNoteTxt(locala.b, 0, this.aOr, 2130851404, 99, null);
      return;
    }
    if ((((MySelfNormalItemRedPointInfo)localObject).redPointType == 0) || (TextUtils.isEmpty(((MySelfNormalItemRedPointInfo)localObject).imgUrl)))
    {
      aute.updateCustomNoteTxt(locala.b, 1, this.aOr, 0);
      locala.eZ.setVisibility(8);
      return;
    }
    aute.updateCustomNoteTxt(locala.c, 1, this.aOr, 0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_d_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_d_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mPlayGifImage = true;
    localObject = URLDrawable.getDrawable(((MySelfNormalItemRedPointInfo)localObject).imgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(aqbn.b);
    locala.s.setImageDrawable((Drawable)localObject);
    locala.s.setBackgroundResource(2130847242);
    if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
      ((URLDrawable)localObject).restartDownload();
    }
    locala.eZ.setVisibility(0);
  }
  
  public boolean BS()
  {
    return false;
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setOnClickListener(new lex(this, paramString2, paramInt2, paramString1));
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      paramView.getBackground().setAlpha(255);
      return;
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130847253);
      continue;
      paramView.setBackgroundResource(2130847256);
      continue;
      if (this.afx)
      {
        paramView.setBackgroundResource(2130843822);
      }
      else
      {
        paramView.setBackgroundResource(2130847255);
        continue;
        if (this.afx)
        {
          paramView.setBackgroundResource(2130843819);
        }
        else
        {
          paramView.setBackgroundResource(2130847254);
          continue;
          paramView.setBackgroundColor(2130847253);
        }
      }
    }
  }
  
  protected void a(int paramInt, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramInt, 0, paramView, paramString1, paramString2, paramBoolean);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    aLh();
    aLu();
    aLv();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "notifyShowSelf()");
    }
    lbz.a().mS(this.mApp.getCurrentUin());
    onShow();
  }
  
  public void aCc()
  {
    super.aCc();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
  }
  
  public void aDh()
  {
    ThreadManager.getUIHandler().post(new ReadInJoySelfFragment.12(this));
  }
  
  public void aIq() {}
  
  public void aLh()
  {
    int j = 3;
    if (this.mApp == null) {}
    do
    {
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.mApp.getManager(162));
      }
      this.aOr = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.de(3);
    } while (this.mContentView == null);
    if (this.afx)
    {
      if (this.aOr > 0) {}
      for (j = 1;; j = 0)
      {
        aute.updateCustomNoteTxt((DragTextView)this.mContentView.findViewById(2131381284), j, this.aOr, 0, 99, null);
        return;
      }
    }
    if (this.aOr > 0) {}
    for (;;)
    {
      aute.updateCustomNoteTxt((DragTextView)this.mContentView.findViewById(2131381284), j, this.aOr, 2130851404, 99, null);
      return;
      j = 0;
    }
  }
  
  public void aLi()
  {
    if (this.ajO) {
      kbp.a(null, "CliOper", "", "", "0X800A606", "0X800A606", 0, 0, "", "", "", kxm.iQ(), false);
    }
  }
  
  public void i(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "updateFollowAndFansCount followCnt:" + paramInt1 + ", fansCnt:" + paramInt2);
    }
    aLw();
  }
  
  public int nh()
  {
    return -1;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void onClick(View paramView)
  {
    Object localObject1 = null;
    switch (paramView.getId())
    {
    default: 
      QLog.i("Q.readinjoy.self.SelfFragment", 1, "onClick, no handler, id=" + paramView.getId());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      kbp.a(null, "CliOper", "", "", "0X8007DB5", "0X8007DB5", 0, 0, "", "", "", kxm.bd(this.aOr), false);
      kxm.O(this.mContentView.getContext(), 2);
      kbp.a(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", kxm.bd(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.oi()), false);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.aIS();
      continue;
      aLq();
      kbp.a(null, "CliOper", "", "", "0X8007DB4", "0X8007DB4", 0, 0, "", "", "", kxm.iQ(), false);
      continue;
      ThreadManager.postImmediately(new ReadInJoySelfFragment.7(this), null, true);
      startActivity(new Intent(this.mContentView.getContext(), ReadInJoySettingActivity.class));
      qO(15);
      anot.a(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", kxm.iQ());
      continue;
      kgw.L(this.mContentView.getContext(), dk(14));
      qO(14);
      continue;
      kxm.aJ(this.mContentView.getContext(), kwt.acL);
      continue;
      kxm.aK(this.mContentView.getContext(), kwt.acT);
      localObject1 = new kxm.b().c().build();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        kbp.a(null, "CliOper", "", "", "0X80080EE", "0X80080EE", 0, 0, "" + awit.D(this.mApp), "", "", (String)localObject1, false);
        continue;
        localObject1 = awit.b(this.mApp);
        int j;
        if (this.jdField_d_of_type_ComTencentWidgetHorizontalListView.getVisibility() == 0)
        {
          aLt();
          j = 0;
        }
        while (j > 0)
        {
          localObject1 = new kxm.b().c().build();
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          kbp.a(null, "CliOper", "", "", "0X80080EF", "0X80080EF", 0, 0, "" + awit.E(this.mApp), "" + j, "", (String)localObject1, false);
          break;
          if ((localObject1 != null) && (((List)localObject1).size() > 1))
          {
            cj((List)localObject1);
            j = 1;
          }
          else
          {
            kxm.aK(this.mContentView.getContext(), kwt.acU);
            j = 2;
          }
        }
        kxm.aJ(this.mContentView.getContext(), kwt.acM);
        localObject1 = kxm.v();
        kbp.a(null, "CliOper", "", "", "0X800845B", "0X800845B", 0, 0, dk(13) + "", "", "", ((JSONObject)localObject1).toString(), false);
        qO(13);
        continue;
        kxm.aJ(this.mContentView.getContext(), kwt.acN);
        localObject1 = kxm.v();
        kbp.a(null, "CliOper", "", "", "0X800845A", "0X800845A", 0, 0, dk(11) + "", "", "", ((JSONObject)localObject1).toString(), false);
        qO(11);
        continue;
        localObject1 = kwt.acO.replace("_bid", "_pbid") + "&_jbid=3257&_vjs=collectBox&_prenr=1";
        Bundle localBundle = new Bundle();
        localBundle.putLong("bundle_param_click_time", System.currentTimeMillis());
        kxm.a(this.mContentView.getContext(), (String)localObject1, localBundle);
        localObject1 = kxm.f(this.mContentView.getContext(), "3.4.4".replace("", ""), this.mApp.getCurrentUin());
        kbp.a(null, "CliOper", "", "", "0X8008E3C", "0X8008E3C", 0, 0, dk(12) + "", "", "", (String)localObject1, false);
        qO(12);
        continue;
        aLr();
        continue;
        ntp.b(this.mContentView.getContext(), "viola测试页面", "https://kandian.qq.com/viola/bundle_home.js?v_bid=3256&statusColor=1", null);
        continue;
        getActivity().finish();
        continue;
        kxm.aJ(this.mContentView.getContext(), kwt.acQ);
        kbp.a(null, "CliOper", "", "", "0X8008E3C", "0X8008E3C", 0, 0, "", "", "", kxm.f(this.mContentView.getContext(), "3.4.4".replace("", ""), this.mApp.getCurrentUin()), false);
        continue;
        kxm.aJ(this.mContentView.getContext(), kwt.acR);
        kbp.a(null, "CliOper", "", "", "0X8009927", "0X8009927", 0, 0, "", "", "", kxm.iQ(), false);
        continue;
        kxm.aJ(this.mContentView.getContext(), kwt.acS);
        continue;
        new nhm(getActivity());
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("number", String.valueOf(awit.c(this.mApp)));
          kbp.a(null, "CliOper", "", "", "0X8009926", "0X8009926", 0, 0, "", "", "", kxm.i((JSONObject)localObject1), false);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        aLs();
        continue;
        aLq();
        kbp.a(null, "", "0X8009925", "0X8009925", 0, 0, "", "", "", "", false);
        continue;
        ntp.b(getActivity(), null, "https://viola.qq.com/js/myFamily.js?_rij_violaUrl=1&v_tid=6&v_bundleName=myFamily&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740", null);
        continue;
        ntp.b(getActivity(), null, "https://viola.qq.com/js/notes-center.js?_rij_violaUrl=1&v_nav_immer=1&v_tid=15&v_bid=3811&v_bundleName=notes-center&hideNav=1&statusBarStyle=1", null);
        kbp.a(null, "", "0X800A607", "0X800A607", 0, 0, "", "", "", "", false);
      }
      try
      {
        localObject2 = (kgj)this.r.getTag();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        label1487:
        break label1487;
      }
      if (localObject1 != null)
      {
        kxm.a(getActivity(), (kgj)localObject1);
        continue;
        aLp();
        continue;
        aLo();
        continue;
        localObject1 = String.format("https://viola.qq.com/js/redpackIndex.js?_rij_violaUrl=1&hideNav=1&statusColor=1&statusBarStyle=1&v_nav_immer=1&v_tid=6&v_bundleName=redpackIndex&v_bid=3740&redpack_type=%d&plat_source=%d&jump_source=%d", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
        localObject2 = Aladdin.getConfig(302).getString("url", null);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (;;)
        {
          kxm.aJ(paramView.getContext(), (String)localObject1);
          break;
          localObject1 = URLDecoder.decode((String)localObject2);
        }
        aLj();
        continue;
        aLk();
        continue;
        aLl();
        continue;
        aLm();
        continue;
        aLn();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.fromType = paramBundle.getInt("from_type");
      this.afx = paramBundle.getBoolean("show_type", false);
      this.afy = paramBundle.getBoolean("redTouch", false);
    }
    if ((getActivity() instanceof ReadInJoyNewFeedsActivity)) {
      this.afx = awit.P(this.mApp);
    }
    this.ajL = getActivity().getIntent().getBooleanExtra("is_from_bb_circle", false);
    lcc.a().b(this.mObserver);
    aLx();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mInflater = LayoutInflater.from(getActivity());
    int j = 2131560471;
    if (this.afx) {
      j = 2131560474;
    }
    this.mContentView = this.mInflater.inflate(j, paramViewGroup, false);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.mApp.getManager(162));
    initUI();
    paramLayoutInflater = this.mContentView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.v != null)
    {
      this.v.cancel();
      this.v = null;
    }
    if (this.h != null)
    {
      this.h.cancel();
      this.h = null;
    }
    if (this.w != null)
    {
      this.w.cancel();
      this.w = null;
    }
    if (this.i != null)
    {
      this.i.cancel();
      this.i = null;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
    lcc.a().c(this.mObserver);
    super.onDestroy();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onResume()
  {
    super.onResume();
    aLh();
    lbz.a().mS(this.mApp.getCurrentUin());
    aLi();
    this.ajM = false;
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  static class a
  {
    DragTextView b;
    DragTextView c;
    RelativeLayout eZ;
    URLImageView s;
    
    public a(DragTextView paramDragTextView1, RelativeLayout paramRelativeLayout, URLImageView paramURLImageView, DragTextView paramDragTextView2)
    {
      this.b = paramDragTextView1;
      this.eZ = paramRelativeLayout;
      this.s = paramURLImageView;
      this.c = paramDragTextView2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment
 * JD-Core Version:    0.7.0.1
 */