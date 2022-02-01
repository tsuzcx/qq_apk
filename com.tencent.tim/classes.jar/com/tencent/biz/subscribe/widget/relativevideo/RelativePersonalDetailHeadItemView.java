package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StIconInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPersonInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StQQGroup;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StMainPageJumpH5URL;
import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import apuh;
import avpw;
import avpw.d;
import avre;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.widget.textview.NewStyleFollowTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import ram;
import rpq;
import rwv;
import rwx;
import ryx;
import rzd;
import rze;
import sjm;
import sqn;
import wja;

public class RelativePersonalDetailHeadItemView
  extends RelativeFeedBaseHeaderView
  implements View.OnClickListener, rwx
{
  private TextView Ai;
  private TextView Aj;
  private TextView Ak;
  private TextView Al;
  private TextView Am;
  private a jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView$a;
  private NewStyleFollowTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private boolean aLK;
  private FrameLayout aM;
  private CertifiedAccountRead.StGetMainPageRsp jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
  private FollowedRecommendBannerView jdField_b_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView;
  private Button cC;
  private LinearLayout fn;
  private LinearLayout fo;
  private LinearLayout fp;
  private LinearLayout fq;
  private AnimationDrawable m;
  private Context mContext;
  private ImageView om;
  private ImageView on;
  private ImageView oo;
  private ImageView op;
  private ImageView oq;
  private ImageView or;
  private SquareImageView p;
  private View qe;
  private RecyclerView r;
  private TextView wt;
  private TextView wu;
  private TextView wv;
  private TextView ww;
  private TextView wz;
  
  public RelativePersonalDetailHeadItemView(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.mContext = paramContext;
  }
  
  private boolean MW()
  {
    return fi(0);
  }
  
  private boolean MX()
  {
    return fi(3);
  }
  
  private View a(CertifiedAccountMeta.StYouZanGood paramStYouZanGood)
  {
    SquareImageView localSquareImageView = new SquareImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ImmersiveUtils.dpToPx(27.0F), ImmersiveUtils.dpToPx(27.0F));
    localLayoutParams.rightMargin = ImmersiveUtils.dpToPx(5.0F);
    localSquareImageView.setLayoutParams(localLayoutParams);
    localSquareImageView.setRoundRect(ImmersiveUtils.dpToPx(5.0F));
    localSquareImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    rpq.a(localSquareImageView, paramStYouZanGood.img.get(), ImmersiveUtils.dpToPx(27.0F), ImmersiveUtils.dpToPx(27.0F), null, "");
    return localSquareImageView;
  }
  
  private void a(PublishBoxStatusEvent paramPublishBoxStatusEvent)
  {
    ThreadManager.getUIHandler().post(new RelativePersonalDetailHeadItemView.3(this, paramPublishBoxStatusEvent));
  }
  
  private void bza()
  {
    if (this.qe == null) {
      this.qe = findViewById(2131370737);
    }
    if ((this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) || (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.size() == 0) || (((CertifiedAccountMeta.StYouZanShop)this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.get(0)).goods.size() == 0))
    {
      this.qe.setVisibility(8);
      return;
    }
    CertifiedAccountMeta.StYouZanShop localStYouZanShop = (CertifiedAccountMeta.StYouZanShop)this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.get(0);
    if (this.fn == null) {
      this.fn = ((LinearLayout)findViewById(2131370679));
    }
    if (this.Al == null) {
      this.Al = ((TextView)findViewById(2131380741));
    }
    TextView localTextView = (TextView)findViewById(2131380931);
    String str;
    if (rze.bg(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get()))
    {
      str = acfp.m(2131713860);
      localTextView.setText(str);
      this.fn.removeAllViews();
      this.qe.setVisibility(0);
      this.Al.setText(String.format(acfp.m(2131720622), new Object[] { Integer.valueOf(localStYouZanShop.goodNum.get()) }));
      if (localStYouZanShop.goods.size() <= 4) {
        break label294;
      }
    }
    label294:
    for (int i = 4;; i = localStYouZanShop.goods.size())
    {
      int j = 0;
      while (j < i)
      {
        this.fn.addView(a((CertifiedAccountMeta.StYouZanGood)localStYouZanShop.goods.get(j)));
        j += 1;
      }
      str = this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.nick.get();
      break;
    }
    this.qe.setOnClickListener(new sjm(this, localStYouZanShop));
  }
  
  private void bzb()
  {
    if ((this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) || (this.mContext == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.iconInfo.iconUrl.get())) {
      localArrayList.add(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.iconInfo.iconUrl.get());
    }
    for (;;)
    {
      Intent localIntent = new Intent(this.mContext, TroopAvatarWallPreviewActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("seqNum", localArrayList);
      localBundle.putBoolean("delete_ability", false);
      localBundle.putBoolean("IS_EDIT", false);
      localBundle.putBoolean("is_use_path", true);
      localBundle.putBoolean("is_show_action", false);
      localBundle.putBoolean("is_not_show_index", false);
      localIntent.putExtras(localBundle);
      this.mContext.startActivity(localIntent);
      sqn.c(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "clk_head", 0, 0, new String[0]);
      return;
      localArrayList.add(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.icon.get());
    }
  }
  
  private void bzc()
  {
    try
    {
      Object localObject = rze.no() + "/certified_account_personal_head_bg.png";
      if (new File((String)localObject).exists())
      {
        ViewGroup.LayoutParams localLayoutParams = this.op.getLayoutParams();
        localLayoutParams.width = ImmersiveUtils.getScreenWidth();
        localLayoutParams.height = ((int)(localLayoutParams.width * 0.66D));
        this.op.setLayoutParams(localLayoutParams);
        localObject = Drawable.createFromPath((String)localObject);
        this.op.setImageDrawable((Drawable)localObject);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void bzd()
  {
    if (this.m == null) {
      this.m = ((AnimationDrawable)getHostActivity().getResources().getDrawable(2130849513));
    }
    this.m.stop();
    if ((this.oo == null) || (this.oo.getVisibility() == 8)) {
      return;
    }
    this.oo.setImageDrawable(this.m);
    this.m.start();
  }
  
  private void bze()
  {
    if (this.m != null) {
      this.m.stop();
    }
    this.oo.setImageResource(2130851325);
  }
  
  private String fK(String paramString)
  {
    Object localObject1;
    if (paramString == null)
    {
      localObject1 = "";
      return localObject1;
    }
    String str2 = "";
    String str1 = str2;
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramString).optJSONObject("location");
        localObject1 = str2;
        if (localObject2 == null) {
          break;
        }
        str1 = str2;
        paramString = ((JSONObject)localObject2).optString("country");
        str1 = str2;
        localObject1 = ((JSONObject)localObject2).optString("province");
        str1 = str2;
        localObject2 = ((JSONObject)localObject2).optString("area");
        str1 = str2;
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          break label192;
        }
      }
      catch (JSONException paramString)
      {
        Object localObject2;
        paramString.printStackTrace();
        return str1;
      }
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label189;
        }
        str1 = paramString + "·" + (String)localObject1;
        paramString = str1;
      }
      catch (JSONException localJSONException)
      {
        str1 = paramString;
        paramString = localJSONException;
        continue;
        continue;
      }
      localObject1 = paramString;
      str1 = paramString;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      str1 = paramString;
      paramString = paramString + "·" + (String)localObject2;
      return paramString;
      label189:
      label192:
      paramString = "";
    }
  }
  
  private boolean fi(int paramInt)
  {
    int j = 48;
    int i = j;
    if (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null)
    {
      i = j;
      if (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null)
      {
        String str = Long.toBinaryString(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get());
        i = j;
        if (!TextUtils.isEmpty(str))
        {
          i = j;
          if (str.length() > paramInt) {
            i = str.charAt(str.length() - 1 - paramInt);
          }
        }
      }
    }
    return i == 49;
  }
  
  private boolean isOwner()
  {
    return fi(1);
  }
  
  private void kJ()
  {
    this.cC.setOnClickListener(this);
    this.Ak.setOnClickListener(this);
    this.oo.setOnClickListener(this);
    this.on.setOnClickListener(this);
    this.om.setOnClickListener(this);
    this.fo.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.fp.setOnClickListener(this);
    this.aM.setOnClickListener(this);
  }
  
  public void L(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RelativePersonalDetailH", 2, "enableFlingRight->enable:" + paramBoolean);
    }
  }
  
  public void P(Object paramObject)
  {
    this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp = ((CertifiedAccountRead.StGetMainPageRsp)paramObject);
    if (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setUserData(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setNoneReportType(false);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setExtraTypeInfo(getExtraTypeInfo());
    }
    if ((this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecGroup.get() != null) && (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecGroup.get().size() != 0))
    {
      this.Aj.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView$a = new a(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecGroup.get());
      this.r.setAdapter(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView$a);
      if ((this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (this.aLK))
      {
        sqn.b(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_fan", "card_expo", 0, 0, new String[0]);
        this.aLK = false;
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get() != null)) {
        setPostUserData(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user);
      }
      this.wu.setText(rze.ck(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.feedCount.get()));
      this.wv.setText(rze.ck(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.fansCount.get()));
      this.ww.setText(rze.ck(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.followCount.get()));
      bza();
      return;
      this.Aj.setVisibility(8);
    }
  }
  
  protected TopGestureLayout a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) && ((getContext() instanceof FragmentActivity)))
    {
      Object localObject = (ViewGroup)((FragmentActivity)getContext()).getWindow().getDecorView();
      View localView = ((ViewGroup)localObject).getChildAt(0);
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.r = ((RecyclerView)findViewById(2131377614));
    this.r.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
    this.r.setNestedScrollingEnabled(true);
    this.wt = ((TextView)findViewById(2131380818));
    this.Ai = ((TextView)findViewById(2131380646));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView = ((NewStyleFollowTextView)findViewById(2131380716));
    this.wu = ((TextView)findViewById(2131380697));
    this.wv = ((TextView)findViewById(2131380691));
    this.ww = ((TextView)findViewById(2131380718));
    this.p = ((SquareImageView)findViewById(2131369780));
    this.cC = ((Button)findViewById(2131363848));
    this.Aj = ((TextView)findViewById(2131380690));
    this.om = ((ImageView)findViewById(2131369814));
    this.Ak = ((TextView)findViewById(2131381317));
    this.on = ((ImageView)findViewById(2131369813));
    this.oo = ((ImageView)findViewById(2131369944));
    this.op = ((ImageView)findViewById(2131369833));
    this.fo = ((LinearLayout)findViewById(2131370664));
    this.aM = ((FrameLayout)findViewById(2131367190));
    this.fp = ((LinearLayout)findViewById(2131370662));
    this.or = ((ImageView)findViewById(2131369874));
    this.oq = ((ImageView)findViewById(2131369893));
    this.jdField_b_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView = ((FollowedRecommendBannerView)findViewById(2131376890));
    this.fq = ((LinearLayout)findViewById(2131370689));
    this.Am = ((TextView)findViewById(2131380792));
    this.wz = ((TextView)findViewById(2131380793));
    bzc();
    kJ();
    L(false);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    localArrayList.add(PublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131558850;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rwv.a().a(this);
    avre.a().eBJ();
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
      if ((this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.jumpURLs != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.jumpURLs.editPageURL.get())))
      {
        rzd.sW(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.jumpURLs.editPageURL.get());
        continue;
        if ((this.mContext != null) && (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_type_queue", 2);
          avpw.d locald = avpw.d.a();
          Object localObject = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject instanceof QQAppInterface))
          {
            localObject = (QQAppInterface)localObject;
            locald.nickname = ((QQAppInterface)localObject).getCurrentNickname();
            locald.cMP = ((QQAppInterface)localObject).getCurrentUin();
          }
          avpw.c((Activity)this.mContext, locald, localIntent, -1);
          continue;
          if ((this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus.jumpURL.get())))
          {
            rzd.sW(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus.jumpURL.get());
            sqn.c(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "msg_clk", 0, 0, new String[0]);
            continue;
            if ((this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.has()) && (!TextUtils.isEmpty(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get())) && (isOwner()))
            {
              rzd.sW("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
              continue;
              bzb();
              continue;
              if ((this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.has()) && (!TextUtils.isEmpty(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get())) && (isOwner()))
              {
                rzd.sW("https://h5.qzone.qq.com/subscription/fanslist/{uin}?_proxy=1&_wv=3".replace("{uin}", this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get()));
                sqn.c(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "clk_fans", 0, 0, new String[0]);
                continue;
                if (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) {
                  if (this.jdField_b_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.Mq())
                  {
                    this.jdField_b_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.bxB();
                    this.or.setImageResource(2130839176);
                    sqn.c(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "show_reco", 0, 0, new String[0]);
                  }
                  else
                  {
                    this.jdField_b_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.sY(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get());
                    this.or.setImageResource(2130839177);
                    sqn.c(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "fold_reco", 0, 0, new String[0]);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
    if (this.m != null)
    {
      this.m.stop();
      this.m = null;
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof FollowUpdateEvent)) && (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (TextUtils.equals(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), ((FollowUpdateEvent)paramSimpleBaseEvent).useId)))
    {
      j = this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.fansCount.get();
      if ((((FollowUpdateEvent)paramSimpleBaseEvent).followStatus == 1) && (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.followState.get() == 0))
      {
        i = j + 1;
        if (!this.jdField_b_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.Mq()) {
          this.jdField_b_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.sY(((FollowUpdateEvent)paramSimpleBaseEvent).useId);
        }
        this.or.setImageResource(2130839177);
        this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.fansCount.set(i);
        this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.followState.set(((FollowUpdateEvent)paramSimpleBaseEvent).followStatus);
        ThreadManager.getUIHandler().post(new RelativePersonalDetailHeadItemView.2(this, i));
        ram.i("RelativePersonalDetailH", "onReceiveEvent  id:" + ((FollowUpdateEvent)paramSimpleBaseEvent).useId + " , status:" + ((FollowUpdateEvent)paramSimpleBaseEvent).followStatus + " " + toString());
      }
    }
    while (!(paramSimpleBaseEvent instanceof PublishBoxStatusEvent)) {
      for (;;)
      {
        int j;
        return;
        int i = j;
        if (((FollowUpdateEvent)paramSimpleBaseEvent).followStatus == 0)
        {
          i = j;
          if (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.followState.get() == 1)
          {
            i = j;
            if (j > 0) {
              i = j - 1;
            }
          }
        }
      }
    }
    a((PublishBoxStatusEvent)paramSimpleBaseEvent);
  }
  
  public void setCardReport(boolean paramBoolean)
  {
    this.aLK = paramBoolean;
  }
  
  public void setPostUserData(CertifiedAccountMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (paramStUser.get() != null))
    {
      this.wt.setText(paramStUser.nick.get());
      this.Ai.setText(paramStUser.desc.get());
      this.p.getLayoutParams().width = ankt.dip2px(92.0F);
      this.p.getLayoutParams().height = ankt.dip2px(92.0F);
      ryx.b(paramStUser.icon.get(), this.p);
      if (!MW()) {
        break label256;
      }
      this.cC.setVisibility(0);
      if (!MX()) {
        break label280;
      }
      this.on.setVisibility(0);
      if ((this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) || (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus == null) || (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus.readStatus.get() != 1)) {
        break label268;
      }
      this.om.setVisibility(0);
      label157:
      if (!isOwner()) {
        break label301;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setVisibility(8);
      this.aM.setVisibility(8);
      this.fo.setVisibility(0);
      if (paramStUser.personInfo.sex.get() != 1) {
        break label388;
      }
      this.oq.setImageResource(2130839181);
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramStUser.personInfo.location.get())) || (!TextUtils.isEmpty(paramStUser.personInfo.school.get()))) {
        break label415;
      }
      this.fq.setVisibility(8);
      return;
      label256:
      this.cC.setVisibility(8);
      break;
      label268:
      this.om.setVisibility(8);
      break label157;
      label280:
      this.on.setVisibility(8);
      this.om.setVisibility(8);
      break label157;
      label301:
      this.cC.setVisibility(8);
      if (paramStUser.type.get() == 1)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setVisibility(0);
        this.aM.setVisibility(0);
      }
      for (;;)
      {
        this.oo.setVisibility(8);
        this.Ak.setVisibility(8);
        this.fo.setVisibility(8);
        break;
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setVisibility(8);
        this.aM.setVisibility(8);
      }
      label388:
      if (paramStUser.personInfo.sex.get() == 2) {
        this.oq.setImageResource(2130839182);
      }
    }
    label415:
    this.fq.setVisibility(0);
    this.Am.setText(fK(paramStUser.personInfo.location.get()));
    this.wz.setText(paramStUser.personInfo.school.get());
  }
  
  class a
    extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  {
    private List<CertifiedAccountMeta.StQQGroup> pt;
    
    public a()
    {
      Object localObject;
      this.pt = localObject;
    }
    
    public int getItemCount()
    {
      if (this.pt == null) {
        return 0;
      }
      return this.pt.size();
    }
    
    public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      if ((this.pt != null) && (this.pt.size() > paramInt))
      {
        RelativePersonalDetailHeadItemView.b localb = (RelativePersonalDetailHeadItemView.b)paramViewHolder;
        if (localb != null) {
          localb.a((CertifiedAccountMeta.StQQGroup)this.pt.get(paramInt));
        }
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
    }
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558852, paramViewGroup, false);
      if ((this.pt != null) && (this.pt.size() == 1)) {
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      }
      return new RelativePersonalDetailHeadItemView.b(RelativePersonalDetailHeadItemView.this, paramViewGroup);
    }
  }
  
  class b
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private TextView An;
    private CertifiedAccountMeta.StQQGroup a;
    private TextView bS;
    private Button cD;
    
    public b(View paramView)
    {
      super();
      this.bS = ((TextView)paramView.findViewById(2131380814));
      this.An = ((TextView)paramView.findViewById(2131380839));
      this.cD = ((Button)paramView.findViewById(2131363927));
      this.cD.setOnClickListener(this);
    }
    
    public void a(CertifiedAccountMeta.StQQGroup paramStQQGroup)
    {
      String str;
      if (paramStQQGroup != null)
      {
        this.bS.setText(paramStQQGroup.name.get());
        this.An.setText(paramStQQGroup.memberNum.get() + acfp.m(2131713862));
        this.a = paramStQQGroup;
        Button localButton = this.cD;
        if (paramStQQGroup.joinState.get() != 1) {
          break label143;
        }
        str = acfp.m(2131713858);
        localButton.setText(str);
        if (RelativePersonalDetailHeadItemView.a(RelativePersonalDetailHeadItemView.this).user != null)
        {
          str = RelativePersonalDetailHeadItemView.a(RelativePersonalDetailHeadItemView.this).user.id.get();
          if (paramStQQGroup.joinState.get() != 1) {
            break label152;
          }
        }
      }
      label143:
      label152:
      for (paramStQQGroup = "open_butten";; paramStQQGroup = "enter_butten")
      {
        sqn.b(str, "auth_fan", paramStQQGroup, 0, 0, new String[0]);
        return;
        str = acfp.m(2131713857);
        break;
      }
    }
    
    public void onClick(View paramView)
    {
      Object localObject;
      if ((this.a != null) && (paramView != null) && (paramView.getContext() != null))
      {
        if (this.a.joinState.get() != 1) {
          break label117;
        }
        localObject = wja.a(new Intent(paramView.getContext(), SplashActivity.class), new int[] { 2 });
        ((Intent)localObject).putExtra("uin", String.valueOf(this.a.id.get()));
        ((Intent)localObject).putExtra("uintype", 1);
        ((Intent)localObject).putExtra("uinname", this.a.name.get());
        paramView.getContext().startActivity((Intent)localObject);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label117:
        localObject = TroopInfoActivity.c(String.valueOf(this.a.id.get()), 4);
        ((Bundle)localObject).putInt("t_s_f", 1001);
        apuh.a(paramView.getContext(), (Bundle)localObject, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView
 * JD-Core Version:    0.7.0.1
 */