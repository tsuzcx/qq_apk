package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import ankt;
import aoop;
import aqcl;
import aqcx;
import aqiw;
import arkp;
import awit;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView.b;
import com.tencent.biz.pubaccount.readinjoy.view.HeadImageWithRing;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView.b;
import com.tencent.biz.pubaccount.readinjoy.view.RecyclerViewWithHeaderFooterFix;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.Long;Lmgu;>;
import java.util.Set;
import kbp;
import kgc;
import kvn;
import kvn.a;
import kvp;
import kvp.a;
import kwz;
import kxm;
import lbz;
import ldy;
import ldz;
import lea;
import leb;
import lec;
import led;
import lee;
import lef;
import leg;
import leh;
import mgu;
import mkt;
import nce;
import nce.a;
import ndi;
import nrz;
import odv;
import odv.b;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;
import tencent.im.oidb.gallery.galleryFeeds.Picture;
import tencent.im.oidb.gallery.galleryFeeds.UserInfo;
import wja;

public class ReadInJoyPicWaterFallFragment
  extends ReadInJoyFragmentWithSubChannel<c>
  implements kvn.a
{
  public static final int aOi = Color.parseColor("#999999");
  public Set<Long> U;
  protected f a;
  public i a;
  public ReadInjoyXRecyclerView a;
  protected kvn a;
  private nrz a;
  int aOh;
  final int aOj = Color.parseColor("#262626");
  final int aOk = -1;
  private boolean ajF;
  public Map<Long, mgu> ek;
  private View kh;
  public ArrayList<c> kz = new ArrayList();
  private int mChannelId = 41522;
  private RecyclerView.ItemAnimator mItemAnimator;
  int spanCount = 2;
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    localObject1 = kxm.f(paramArticleInfo);
    int i;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label152;
      }
    }
    label152:
    for (int j = 0;; j = 1)
    {
      Object localObject2 = kxm.a(paramArticleInfo.mAlgorithmID, paramInt2, paramInt1, i, j, aqiw.isWifiConnected(null), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, kxm.h(paramArticleInfo), paramArticleInfo);
      localObject1 = new JSONObject();
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          localObject2 = new JSONObject((String)localObject2);
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          continue;
          Object localObject3;
          continue;
        }
        try
        {
          ((JSONObject)localObject2).put("feeds_type", paramInt2);
          localObject1 = localObject2;
          kbp.a(null, kxm.f(paramArticleInfo), "0X8007625", "0X8007625", 0, 0, ndi.ay(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), ((JSONObject)localObject1).toString(), false);
          return;
        }
        catch (JSONException localJSONException2)
        {
          localObject1 = localJSONException1;
          localObject3 = localJSONException2;
        }
      }
      i = 0;
      break;
    }
  }
  
  private void aKZ()
  {
    this.mItemAnimator.setAddDuration(0L);
    this.mItemAnimator.setChangeDuration(0L);
    this.mItemAnimator.setMoveDuration(0L);
    this.mItemAnimator.setRemoveDuration(0L);
  }
  
  private void aLa()
  {
    this.mItemAnimator.setAddDuration(120L);
    this.mItemAnimator.setChangeDuration(250L);
    this.mItemAnimator.setMoveDuration(250L);
    this.mItemAnimator.setRemoveDuration(120L);
  }
  
  private void cq(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131369627);
    Object localObject = (LinearLayout)paramView.findViewById(2131369629);
    localObject = (ImageView)paramView.findViewById(2131369628);
    paramView = (TextView)paramView.findViewById(2131369579);
    localTextView.setText(getActivity().getIntent().getStringExtra("sub_channel_name"));
    paramView.setOnClickListener(new leb(this));
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
    if (AppSetting.enableTalkBack) {
      aqcl.changeAccessibilityForView(paramView, Button.class.getName());
    }
  }
  
  protected boolean BX()
  {
    return this.ajF;
  }
  
  public void C(View paramView, int paramInt)
  {
    paramView = ((c)this.kz.get(paramInt)).e;
    if (TextUtils.isEmpty(paramView.mChannelJumpUrl))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      localIntent.putExtra("channel_id", paramView.mChannelCoverId);
      localIntent.putExtra("sub_channel_name", paramView.mChannelCoverName);
      localIntent.putExtra("is_sub_channel", true);
      PublicFragmentActivity.start(getActivity(), localIntent, ReadInJoyPicWaterFallFragment.class);
    }
  }
  
  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, ChannelClassificationListView<c> paramChannelClassificationListView)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131560387, null);
    this.kh = paramLayoutInflater.findViewById(2131379798);
    if (BX())
    {
      this.kh.setVisibility(0);
      cq(paramLayoutInflater);
      mkt.a(this);
    }
    paramBundle = (FrameLayout)paramLayoutInflater.findViewById(2131365322);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView = new ReadInJoyPicWaterFallFragment.1(this, paramViewGroup.getContext());
    paramViewGroup = new ldy(this, this.spanCount, 1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView != null)
    {
      paramChannelClassificationListView = new ScrollableHeader(getActivity());
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setPadding(0, wja.dp2px(3.0F, getResources()), 0, wja.dp2px(3.0F, getResources()));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 17;
      paramChannelClassificationListView.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView, localLayoutParams);
      paramChannelClassificationListView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView.setAdapter(new d(null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().addHeaderView(paramChannelClassificationListView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().setLayoutManager(paramViewGroup);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i = new i();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().addOnScrollListener(new ldz(this));
      this.aOh = wja.dp2px(3.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().addItemDecoration(new g(this.aOh));
      this.mItemAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().getItemAnimator();
      aKZ();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.setBackgroundColor(Color.parseColor("#f7f7f7"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Kgc);
      paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
      paramBundle.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView, paramViewGroup);
      this.jdField_a_of_type_Nrz = new nrz(getActivity(), new lea(this));
      return paramLayoutInflater;
      paramChannelClassificationListView = new ScrollableHeader(getActivity());
      paramChannelClassificationListView.setPadding(0, wja.dp2px(3.0F, getResources()), 0, wja.dp2px(3.0F, getResources()));
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().addHeaderView(paramChannelClassificationListView);
    }
  }
  
  public ReadInJoyFragmentWithSubChannel.a a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f = new lec(this);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f;
  }
  
  public void a(Map<Long, mgu> paramMap, boolean paramBoolean, Map<Long, odv.b> paramMap1, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (!paramBoolean))
    {
      QLog.d("ReadInJoyPicWaterFallFragment", 2, "report data is null ");
      return;
    }
    Iterator localIterator = paramMap.values().iterator();
    mgu localmgu;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localmgu = (mgu)localIterator.next();
        if (!localmgu.amp)
        {
          localmgu.amp = true;
          if ((localmgu.j != null) && (localmgu.j.mGalleryFeedsInfo != null))
          {
            i = localmgu.j.mGalleryFeedsInfo.enum_article_style.get();
            localmgu.mArticleType = 1008;
            if (i == 5) {
              localmgu.mArticleType = 1009;
            }
          }
          kbp.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localmgu.v.longValue()), Integer.toString(localmgu.mStrategyId), kxm.a(localmgu.mAlgorithmID, localmgu.mArticleType, nh(), localmgu.aRx), false);
          kbp.d("0X80066FC", "", "", Long.toString(localmgu.v.longValue()), Integer.toString(localmgu.mStrategyId), kxm.a(localmgu.mAlgorithmID, localmgu.mArticleType, nh(), localmgu.aRx));
          paramMap = kxm.a(localmgu.mAlgorithmID, localmgu.mArticleType, nh(), localmgu.aRx, localmgu.aRy, aqiw.isWifiConnected(getActivity()), localmgu.agM, localmgu.mStrCircleId, localmgu.agO, kxm.h(localmgu.j), (ArticleInfo)localmgu.j, 0L, -1, localmgu.aRz, localmgu.aRA, localmgu.aRB, localmgu.amu, localmgu.aRD, localmgu.aRC, localmgu.aRF);
          if (localmgu.j != null)
          {
            try
            {
              localObject = new JSONObject(paramMap);
              ((JSONObject)localObject).put("feeds_type", localmgu.mArticleType);
              ((JSONObject)localObject).put("folder_status", paramString);
              localObject = ((JSONObject)localObject).toString();
              paramMap = (Map<Long, mgu>)localObject;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                Object localObject;
                int j;
                long l3;
                long l1;
                localJSONException.printStackTrace();
                continue;
                str1 = "0X8007626";
              }
            }
            if (odv.aT(nh()))
            {
              localObject = "0X8009354";
              paramMap = new nce.a(paramMap);
              paramMap.a(localmgu.k).f(localmgu.k);
              kbp.a(null, "CliOper", "", localmgu.agN, (String)localObject, (String)localObject, 0, 0, Long.toString(localmgu.j.mFeedId), Long.toString(localmgu.v.longValue()), Integer.toString(localmgu.mStrategyId), paramMap.a().toJsonString(), false);
              kbp.d((String)localObject, localmgu.agN, Long.toString(localmgu.j.mFeedId), Long.toString(localmgu.v.longValue()), Integer.toString(localmgu.mStrategyId), kxm.a(localmgu.mAlgorithmID, localmgu.mArticleType, nh(), localmgu.aRx, localmgu.aRy, aqiw.isWifiConnected(getActivity()), localmgu.agM, localmgu.mStrCircleId, localmgu.agO, kxm.h(localmgu.j), (ArticleInfo)localmgu.j, 0L, -1, localmgu.aRz, localmgu.aRA, localmgu.aRB, localmgu.amu, localmgu.aRD, localmgu.aRC, localmgu.aRF));
              if ((localmgu.j == null) || (localmgu.j.mGalleryFeedsInfo == null)) {
                continue;
              }
              j = localmgu.j.mGalleryFeedsInfo.enum_article_style.get();
              i = 8;
              if (j == 5) {
                i = 12;
              }
              l3 = localmgu.ve;
              j = localmgu.mPosition;
              l1 = 0L;
              paramMap = null;
              localObject = null;
              if (localmgu.j == null) {
                break label910;
              }
              l1 = localmgu.j.mArticleID;
              paramMap = localmgu.j.innerUniqueID;
              localObject = localmgu.j.galleryReprotExdData;
            }
          }
        }
      }
    }
    label910:
    for (long l2 = localmgu.j.mAlgorithmID;; l2 = 0L)
    {
      String str2 = kvp.a(getActivity(), kxm.getLongAccountUin(), 16, l1, l3, j, paramMap, (String)localObject, i, nh());
      kbp.a(null, localmgu.agN, "0X8008E2E", "0X8008E2E", 0, 0, "", l1 + "", l2 + "", str2, false);
      kvp.a(7, kxm.getLongAccountUin(), (int)l2, 16, l3, j, paramMap, (String)localObject);
      break;
      String str1;
      odv.L(paramMap1);
      return;
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i.notifyDataSetChanged();
    }
  }
  
  public void aCe()
  {
    if (this.jdField_a_of_type_Kgc != null) {
      this.jdField_a_of_type_Kgc.aCe();
    }
    if (this.jdField_a_of_type_Kvn != null)
    {
      this.jdField_a_of_type_Kvn.aHu();
      this.jdField_a_of_type_Kvn.clearAll();
    }
  }
  
  protected void aKY()
  {
    super.aKY();
    Intent localIntent = getActivity().getIntent();
    this.mChannelId = localIntent.getIntExtra("channel_id", 41522);
    this.ajF = localIntent.getBooleanExtra("is_sub_channel", false);
  }
  
  public void d(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo != null) && (this.ek != null)) {
      if (this.ek.containsKey(Long.valueOf(paramBaseArticleInfo.mArticleID))) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ThreadManager.post(new ReadInJoyPicWaterFallFragment.7(this, paramBaseArticleInfo, paramInt, kxm.nQ(), System.currentTimeMillis()), 5, null, true);
      }
      return;
    }
  }
  
  public void h(String paramString, Object paramObject)
  {
    if (paramString.equals("exp_waterfall_operation")) {
      kvp.a((kvp.a)paramObject);
    }
    while (!paramString.equals("exp_subchannel")) {
      return;
    }
    paramString = (c)paramObject;
    kvp.c(getActivity(), "0X8009A70", nh(), paramString.e.mChannelCoverId);
  }
  
  public int nh()
  {
    return this.mChannelId;
  }
  
  public boolean onBackEvent()
  {
    finish();
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Kvn = new kvn(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i.notifyDataSetChanged();
    }
    if (BX()) {
      mkt.a(this);
    }
  }
  
  public boolean zl()
  {
    return getActivity() instanceof SplashActivity;
  }
  
  static class ScrollableHeader
    extends FrameLayout
    implements ReadInjoyXRecyclerView.b
  {
    Rect rect = new Rect();
    
    public ScrollableHeader(@NonNull Context paramContext)
    {
      super();
    }
    
    public ScrollableHeader(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public boolean z(MotionEvent paramMotionEvent)
    {
      getHitRect(this.rect);
      return this.rect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
  }
  
  public class a
    extends ReadInJoyPicWaterFallFragment.b
  {
    ImageView iK;
    URLImageView q;
    
    a(View paramView)
    {
      super(paramView);
      this.e = ((URLImageView)paramView.findViewById(2131365462));
      this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.q = ((URLImageView)paramView.findViewById(2131362691));
      this.q.setImageDrawable(new ColorDrawable(Color.parseColor("#7f000000")));
      wja.dp2px(3.0F, ReadInJoyPicWaterFallFragment.this.getResources());
      this.iK = ((ImageView)paramView.findViewById(2131362041));
      this.title = ((TextView)paramView.findViewById(2131379769));
      paramView.setOnClickListener(new led(this, ReadInJoyPicWaterFallFragment.this));
    }
  }
  
  public class b
    extends RecyclerView.ViewHolder
  {
    public BaseArticleInfo d;
    URLImageView e;
    public Context mContext;
    public TextView title;
    
    b(View paramView)
    {
      super();
    }
    
    public int oA()
    {
      return getAdapterPosition() - 1;
    }
  }
  
  public static class c
    implements ChannelClassificationListView.b
  {
    public String aeE;
    public ChannelCoverInfo e;
    private boolean hasReport;
    public String mName;
    
    public c(ChannelCoverInfo paramChannelCoverInfo, String paramString1, String paramString2)
    {
      this.e = paramChannelCoverInfo;
      this.mName = paramString1;
      this.aeE = paramString2;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public boolean hasReport()
    {
      return this.hasReport;
    }
    
    public String jq()
    {
      return this.aeE;
    }
    
    public void setHasReport(boolean paramBoolean)
    {
      this.hasReport = paramBoolean;
    }
  }
  
  public class d
    extends BaseAdapter
  {
    private d() {}
    
    public ReadInJoyPicWaterFallFragment.c a(int paramInt)
    {
      return (ReadInJoyPicWaterFallFragment.c)ReadInJoyPicWaterFallFragment.this.kz.get(paramInt);
    }
    
    public int getCount()
    {
      return ReadInJoyPicWaterFallFragment.this.kz.size();
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(ReadInJoyPicWaterFallFragment.this.getActivity()).inflate(2131562911, paramViewGroup, false);
        paramView.setOnClickListener(new lee(this));
      }
      for (;;)
      {
        ReadInJoyPicWaterFallFragment.c localc = (ReadInJoyPicWaterFallFragment.c)ReadInJoyPicWaterFallFragment.this.kz.get(paramInt);
        paramView.setTag(Integer.valueOf(paramInt));
        ((TextView)paramView).setText(localc.getName());
        ReadInJoyPicWaterFallFragment.this.a.f("exp_subchannel", localc);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
  }
  
  public class e
    extends ReadInJoyPicWaterFallFragment.b
  {
    HeadImageWithRing a;
    ReadInJoyNickNameTextView c;
    TextView cB;
    ImageView iL;
    ImageView iM;
    ImageView iN;
    View ki;
    View kj;
    View kk;
    TextView pe;
    TextView pf;
    TextView pg;
    
    e(View paramView)
    {
      super(paramView);
      this.title = ((TextView)paramView.findViewById(2131379769));
      this.kk = paramView.findViewById(2131379451);
      this.kk.setBackgroundDrawable(new arkp(Color.parseColor("#D9D9D8"), 0));
      this.e = ((URLImageView)paramView.findViewById(2131365462));
      this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.kj = paramView.findViewById(2131372498);
      this.iM = ((ImageView)paramView.findViewById(2131372496));
      this.iN = ((ImageView)paramView.findViewById(2131372477));
      this.pg = ((TextView)paramView.findViewById(2131372504));
      this.c = ((ReadInJoyNickNameTextView)paramView.findViewById(2131372369));
      this.a = ((HeadImageWithRing)paramView.findViewById(2131369458));
      this.a.setAttrs(wja.dp2px(0.5F, ReadInJoyPicWaterFallFragment.this.getResources()), Color.parseColor("#0c000000"));
      this.a.setDrawRing(true);
      this.a.setCorner(wja.dp2px(12.0F, ReadInJoyPicWaterFallFragment.this.getResources()) / 2);
      this.pe = ((TextView)paramView.findViewById(2131370441));
      this.cB = ((TextView)paramView.findViewById(2131380841));
      this.pf = ((TextView)paramView.findViewById(2131380092));
      this.ki = paramView.findViewById(2131380080);
      this.ki.setBackgroundDrawable(new arkp(Color.parseColor("#D9D9D8"), 0));
      this.iL = ((ImageView)paramView.findViewById(2131380075));
      paramView.setOnClickListener(new lef(this, ReadInJoyPicWaterFallFragment.this));
      this.iN.setOnClickListener(new leg(this, ReadInJoyPicWaterFallFragment.this));
      this.ki.setOnClickListener(new leh(this, ReadInJoyPicWaterFallFragment.this));
    }
  }
  
  public static abstract interface f
    extends ReadInJoyFragmentWithSubChannel.a<BaseArticleInfo>
  {
    public abstract void a(Map<Long, mgu> paramMap, boolean paramBoolean);
    
    public abstract void a(Map<Long, mgu> paramMap, boolean paramBoolean, Map<Long, odv.b> paramMap1, String paramString);
    
    public abstract void b(Set<Long> paramSet, Map<Long, mgu> paramMap);
    
    public abstract void nq(boolean paramBoolean);
    
    public abstract void nr(boolean paramBoolean);
    
    public abstract void t(boolean paramBoolean, String paramString);
  }
  
  public class g
    extends RecyclerView.ItemDecoration
  {
    private int space;
    
    public g(int paramInt)
    {
      this.space = paramInt;
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
      if (((StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams()).getSpanIndex() % 2 == 0)
      {
        paramRect.left = (this.space * 2);
        paramRect.right = this.space;
        return;
      }
      paramRect.left = (this.space / 2);
      paramRect.right = this.space;
    }
  }
  
  public static class h
  {
    int aOm;
    int originHeight;
    int originWidth;
    int scaleHeight;
    URL url;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[WaterFallPic]--> url=");
      if (this.url != null) {}
      for (String str = this.url.toString();; str = "") {
        return str + ",originWidth =" + this.originWidth + ",originHeight =" + this.originHeight + ",calcHeight =" + this.aOm + ",scaleHeight =" + this.scaleHeight;
      }
    }
  }
  
  public class i
    extends RecyclerView.Adapter<ReadInJoyPicWaterFallFragment.b>
  {
    public final int aOn = aqcx.dip2px(ReadInJoyPicWaterFallFragment.this.getActivity(), 150.0F);
    int aOo = wja.dp2px(3.0F, ReadInJoyPicWaterFallFragment.this.getResources());
    int aOp = wja.dp2px(58.5F, ReadInJoyPicWaterFallFragment.this.getResources());
    int aOq = wja.dp2px(226.0F, ReadInJoyPicWaterFallFragment.this.getResources());
    int itemWidth;
    public List<BaseArticleInfo> mData = new ArrayList();
    
    public i() {}
    
    private void a(ReadInJoyPicWaterFallFragment.a parama, int paramInt)
    {
      int i = -1;
      Object localObject1 = (BaseArticleInfo)this.mData.get(paramInt);
      if (parama.itemView.getLayoutParams() == null)
      {
        localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, wja.dp2px(314.0F, ReadInJoyPicWaterFallFragment.this.getResources()));
        parama.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      parama.title.setText(((BaseArticleInfo)localObject1).mTitle);
      Object localObject2 = parama.title;
      paramInt = i;
      if (lbz.a().aO(((BaseArticleInfo)localObject1).mArticleID)) {
        paramInt = ReadInJoyPicWaterFallFragment.aOi;
      }
      ((TextView)localObject2).setTextColor(paramInt);
      parama.e.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
      kwz.a(parama.e, ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_topic_pic_url.get().toStringUtf8(), ReadInJoyPicWaterFallFragment.this.getActivity());
      parama.d = ((BaseArticleInfo)localObject1);
      localObject1 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_topic_icon_url.get().toStringUtf8();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        parama.iK.setVisibility(0);
        localObject1 = aoop.getDrawable((String)localObject1);
        parama.iK.setImageDrawable((Drawable)localObject1);
        return;
      }
      parama.iK.setVisibility(8);
    }
    
    private void a(ReadInJoyPicWaterFallFragment.e parame, int paramInt)
    {
      Object localObject1 = (BaseArticleInfo)this.mData.get(paramInt);
      b((BaseArticleInfo)localObject1);
      Object localObject2 = (FrameLayout.LayoutParams)parame.e.getLayoutParams();
      label107:
      int i;
      label153:
      label299:
      label316:
      Object localObject3;
      if (localObject2 == null)
      {
        localObject2 = new FrameLayout.LayoutParams(-1, ((BaseArticleInfo)localObject1).waterFallPic.aOm);
        parame.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (((BaseArticleInfo)localObject1).waterFallPic.scaleHeight <= this.aOq) {
          break label750;
        }
        parame.e.setPadding(0, ((BaseArticleInfo)localObject1).waterFallPic.scaleHeight - ((BaseArticleInfo)localObject1).waterFallPic.aOm, 0, 0);
        parame.d = ((BaseArticleInfo)localObject1);
        parame.title.setText(((BaseArticleInfo)localObject1).mTitle);
        boolean bool = lbz.a().aO(((BaseArticleInfo)localObject1).mArticleID);
        localObject2 = parame.title;
        if (!bool) {
          break label764;
        }
        i = ReadInJoyPicWaterFallFragment.aOi;
        ((TextView)localObject2).setTextColor(i);
        parame.e.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
        kwz.a(parame.e, ((BaseArticleInfo)localObject1).waterFallPic.url, ReadInJoyPicWaterFallFragment.this.getActivity());
        parame.c.setVisibility(0);
        parame.c.setText(((BaseArticleInfo)localObject1).getSubscribeName());
        parame.c.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
        parame.c.getPaint().setFakeBoldText(true);
        if (((BaseArticleInfo)localObject1).mGalleryFeedsInfo.uint32_is_account_derelict.get() != 1) {
          break label775;
        }
        parame.a.setImageResource(2130847230);
        label261:
        if (((BaseArticleInfo)localObject1).mSocialFeedInfo == null) {
          break label900;
        }
        parame.pe.setVisibility(0);
        awit.a(((BaseArticleInfo)localObject1).mSocialFeedInfo.mLikeCount, 999000L, "99.9万", "0");
        if (((BaseArticleInfo)localObject1).mGalleryPicNumber <= 1) {
          break label912;
        }
        parame.cB.setVisibility(0);
        if (((BaseArticleInfo)localObject1).mGalleryFeedsInfo == null) {
          break label956;
        }
        localObject2 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_content.get().toStringUtf8();
        localObject3 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_jump_url.get().toStringUtf8();
        String str = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_icon_url.get().toStringUtf8();
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(str))) {
          break label934;
        }
        parame.ki.setVisibility(0);
        parame.pf.setText((CharSequence)localObject2);
        localObject2 = aoop.getDrawable(str);
        parame.iL.setImageDrawable((Drawable)localObject2);
        localObject2 = kvp.a(ReadInJoyPicWaterFallFragment.this.getActivity(), ReadInJoyPicWaterFallFragment.a(ReadInJoyPicWaterFallFragment.this), 3, paramInt, (ArticleInfo)localObject1);
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            ((JSONObject)localObject2).put("exptime", System.currentTimeMillis());
            ((JSONObject)localObject2).put("proxy_bytes", ((BaseArticleInfo)localObject1).galleryReprotExdData);
            ((JSONObject)localObject2).put("operation_id", ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_operation_id.get().toStringUtf8());
            localObject3 = new kvp.a((BaseArticleInfo)localObject1);
            ((kvp.a)localObject3).a = ((BaseArticleInfo)localObject1);
            ((kvp.a)localObject3).r3 = String.valueOf(((BaseArticleInfo)localObject1).mArticleID);
            ((kvp.a)localObject3).r4 = String.valueOf(((BaseArticleInfo)localObject1).mAlgorithmID);
            ((kvp.a)localObject3).r5 = ((JSONObject)localObject2).toString();
            if (((BaseArticleInfo)localObject1).mSocialFeedInfo.a != null) {
              ((kvp.a)localObject3).toUin = String.valueOf(((BaseArticleInfo)localObject1).mSocialFeedInfo.a.uin);
            }
            ((kvp.a)localObject3).subAction = "0X8009A7A";
            ((kvp.a)localObject3).actionName = "0X8009A7A";
            ReadInJoyPicWaterFallFragment.this.jdField_a_of_type_Kvn.f("exp_waterfall_operation", localObject3);
          }
          catch (JSONException localJSONException)
          {
            label750:
            label764:
            localJSONException.printStackTrace();
            label775:
            continue;
          }
          localObject2 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_note_content.get().toStringUtf8();
          localObject1 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_note_icon_url.get().toStringUtf8();
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
            break label946;
          }
          parame.kj.setVisibility(0);
          parame.pg.setText((CharSequence)localObject2);
          localObject1 = aoop.getDrawable((String)localObject1);
          parame.iM.setImageDrawable((Drawable)localObject1);
          return;
          if ((((FrameLayout.LayoutParams)localObject2).height > 0) && (((FrameLayout.LayoutParams)localObject2).height == ((BaseArticleInfo)localObject1).waterFallPic.aOm)) {
            break;
          }
          ((FrameLayout.LayoutParams)localObject2).height = ((BaseArticleInfo)localObject1).waterFallPic.aOm;
          parame.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
          parame.e.setPadding(0, 0, 0, 0);
          break label107;
          i = ReadInJoyPicWaterFallFragment.this.aOj;
          break label153;
          localObject2 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.msg_publisher_info.bytes_header_url.get().toStringUtf8();
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          i = wja.dp2px(12.0F, ReadInJoyPicWaterFallFragment.this.getResources());
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
          try
          {
            localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
            parame.a.setImageDrawable((Drawable)localObject2);
          }
          catch (Exception localException)
          {
            QLog.e("ReadInJoyPicWaterFallFragment", 1, "bindNormalHolder, e = " + localException);
          }
        }
        break label261;
        parame.a.setImageResource(2130847230);
        break label261;
        label900:
        parame.pe.setVisibility(8);
        break label299;
        label912:
        parame.cB.setVisibility(8);
        break label316;
        label934:
        parame.ki.setVisibility(8);
      }
      label946:
      parame.kj.setVisibility(8);
      return;
      label956:
      parame.kj.setVisibility(8);
      parame.ki.setVisibility(8);
    }
    
    private void a(ReadInJoyPicWaterFallFragment.h paramh)
    {
      if (paramh.originWidth > 0)
      {
        i = (int)(this.itemWidth / paramh.originWidth * paramh.originHeight);
        paramh.scaleHeight = i;
        if ((i >= this.aOp) && (i <= this.aOq)) {
          paramh.aOm = i;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyPicWaterFallFragment", 2, "WaterFallPic = " + paramh.toString());
          }
          return;
          if (i < this.aOp) {
            paramh.aOm = this.aOp;
          } else {
            paramh.aOm = this.aOq;
          }
        }
      }
      if (this.itemWidth != 0) {}
      for (int i = this.itemWidth;; i = this.aOn)
      {
        paramh.aOm = i;
        break;
      }
    }
    
    private void b(BaseArticleInfo paramBaseArticleInfo)
    {
      if (paramBaseArticleInfo.waterFallPic != null) {
        return;
      }
      Object localObject = (galleryFeeds.Picture)paramBaseArticleInfo.mGalleryFeedsInfo.msg_custom_cover.get();
      ReadInJoyPicWaterFallFragment.h localh = new ReadInJoyPicWaterFallFragment.h();
      if (localObject != null)
      {
        int i = (int)((galleryFeeds.Picture)localObject).uint64_width.get();
        int j = (int)((galleryFeeds.Picture)localObject).uint64_height.get();
        localh.originWidth = i;
        localh.originHeight = j;
      }
      for (localh.url = kxm.b(((galleryFeeds.Picture)localObject).bytes_pic_url.get().toStringUtf8());; localh.url = kxm.b((String)localObject))
      {
        paramBaseArticleInfo.waterFallPic = localh;
        a(paramBaseArticleInfo.waterFallPic);
        return;
        localObject = paramBaseArticleInfo.mFirstPagePicUrl;
        localh.originWidth = -1;
        localh.originHeight = -1;
      }
    }
    
    public ReadInJoyPicWaterFallFragment.b a(ViewGroup paramViewGroup, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        paramViewGroup = LayoutInflater.from(ReadInJoyPicWaterFallFragment.this.getActivity()).inflate(2131560442, null);
        paramViewGroup = new ReadInJoyPicWaterFallFragment.e(ReadInJoyPicWaterFallFragment.this, paramViewGroup);
        paramViewGroup.mContext = ReadInJoyPicWaterFallFragment.this.getActivity();
        return paramViewGroup;
      }
      paramViewGroup = LayoutInflater.from(ReadInJoyPicWaterFallFragment.this.getActivity()).inflate(2131560443, null);
      paramViewGroup = new ReadInJoyPicWaterFallFragment.a(ReadInJoyPicWaterFallFragment.this, paramViewGroup);
      paramViewGroup.mContext = ReadInJoyPicWaterFallFragment.this.getActivity();
      return paramViewGroup;
    }
    
    public void a(ReadInJoyPicWaterFallFragment.b paramb, int paramInt)
    {
      int j;
      int i;
      if (this.itemWidth == 0)
      {
        j = ReadInJoyPicWaterFallFragment.this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.getWidth();
        if (j > 0) {
          break label290;
        }
        if (ankt.SCREEN_WIDTH <= 0) {
          break label259;
        }
        i = ankt.SCREEN_WIDTH;
        QLog.d("ReadInJoyPicWaterFallFragment", 1, "getRecyclerView width error, getScreenWidth : " + i + ", layoutWidth : " + j);
      }
      for (;;)
      {
        this.itemWidth = ((i - ReadInJoyPicWaterFallFragment.this.aOh * 2 - this.aOo * 2 * ReadInJoyPicWaterFallFragment.this.spanCount) / 2);
        this.aOp = ((int)(this.itemWidth * 0.52F));
        this.aOq = ((int)(this.itemWidth * 1.33F));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyPicWaterFallFragment", 2, "itemWidth = " + this.itemWidth + ",minImgHeight = " + this.aOp + ",maxImgHeight = " + this.aOq);
        }
        switch (getItemViewType(paramInt))
        {
        }
        for (;;)
        {
          BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)this.mData.get(paramInt);
          ReadInJoyPicWaterFallFragment.this.d(localBaseArticleInfo, paramInt);
          EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
          return;
          label259:
          i = 1080;
          break;
          a((ReadInJoyPicWaterFallFragment.e)paramb, paramInt);
          continue;
          a((ReadInJoyPicWaterFallFragment.a)paramb, paramInt);
        }
        label290:
        i = j;
      }
    }
    
    public int getItemCount()
    {
      return this.mData.size();
    }
    
    public int getItemViewType(int paramInt)
    {
      paramInt = ((BaseArticleInfo)this.mData.get(paramInt)).mGalleryFeedsInfo.enum_article_style.get();
      if (paramInt == 4) {
        return 1;
      }
      if (paramInt == 5) {
        return 2;
      }
      return 1;
    }
    
    public void setData(List<BaseArticleInfo> paramList)
    {
      this.mData.clear();
      this.mData.addAll(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment
 * JD-Core Version:    0.7.0.1
 */