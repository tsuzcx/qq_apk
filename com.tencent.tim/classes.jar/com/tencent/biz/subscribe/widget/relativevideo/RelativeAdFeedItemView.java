package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ausj;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.fragments.SubscribeAdGdtCanvasFragment;
import com.tencent.biz.subscribe.fragments.SubscribeAdVideoCeilingFragment;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.pb.vac_adv_get.DropList;
import cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaInfo;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import ryx;
import rzd;
import rze;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class RelativeAdFeedItemView
  extends BaseWidgetView<CertifiedAccountMeta.StFeed>
  implements View.OnClickListener, View.OnLongClickListener
{
  private TextView Ab;
  private ausj M;
  private a jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeAdFeedItemView$a;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private vac_adv_get.VacFeedsAdvMetaInfo jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo;
  private Set<String> aS = new HashSet();
  private boolean avA;
  private AsyncRichTextView e;
  private RoundCornerImageView f;
  private RelativeLayout ga;
  private Drawable mDefaultDrawable = getResources().getDrawable(2130840645);
  private CertifiedAccountMeta.StFeed mFeed;
  private TextView mVideoDuration;
  private int mWidth = ImmersiveUtils.getScreenWidth() / 2;
  private SquareImageView o;
  private ImageView ok;
  private View qc;
  
  public RelativeAdFeedItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RelativeAdFeedItemView(Context paramContext, a parama)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeAdFeedItemView$a = parama;
  }
  
  private void byY()
  {
    if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo == null) {
      return;
    }
    try
    {
      GdtHandler.Params localParams = new GdtHandler.Params();
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(getContext());
      localParams.processId = 1;
      if ((getContext() instanceof Activity)) {
        localParams.activity = new WeakReference((Activity)getContext());
      }
      localParams.ad = new GdtAd(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp);
      localParams.reportForClick = true;
      localParams.aOV = true;
      if ((this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.creative_size.get() == 185))
      {
        localParams.videoCeilingSupportedIfNotInstalled = true;
        localParams.videoCeilingSupportedIfInstalled = true;
      }
      localParams.videoSpliceSupported = true;
      Object localObject = new int[2];
      this.f.getLocationInWindow((int[])localObject);
      this.f.getLocationOnScreen((int[])localObject);
      localParams.mediaViewLocationRect = new Rect(localObject[0], localObject[1], localObject[0] + this.f.getWidth(), localObject[1] + this.f.getHeight());
      localParams.n = SubscribeAdVideoCeilingFragment.class;
      localParams.p = SubscribeAdGdtCanvasFragment.class;
      localParams.appReceiver = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      localObject = new Bundle();
      ((Bundle)localObject).putString("big_brother_source_key", "biz_src_ads");
      ((Bundle)localObject).putString("big_brother_ref_source_key", "biz_src_renzhenghao");
      localParams.extra = ((Bundle)localObject);
      GdtHandler.a(localParams);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void byX()
  {
    if (this.M == null)
    {
      this.M = ausj.d(getContext());
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(getContext()).inflate(2131558866, null);
      localViewGroup.findViewById(2131377024).setOnClickListener(this);
      localViewGroup.findViewById(2131372155).setOnClickListener(this);
      localViewGroup.findViewById(2131364221).setOnClickListener(this);
      this.M.setActionContentView(localViewGroup, null);
    }
    this.M.show();
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.e = ((AsyncRichTextView)findViewById(2131380702));
    this.Ab = ((TextView)findViewById(2131380565));
    this.f = ((RoundCornerImageView)findViewById(2131369745));
    this.f.setCorner(ImmersiveUtils.dpToPx(4.0F));
    this.o = ((SquareImageView)findViewById(2131369666));
    this.mVideoDuration = ((TextView)findViewById(2131380695));
    this.qc = findViewById(2131370761);
    this.ok = ((ImageView)findViewById(2131369651));
    this.ga = ((RelativeLayout)findViewById(2131377379));
    this.ga.setOnClickListener(this);
    this.ga.setOnLongClickListener(this);
  }
  
  public int getLayoutId()
  {
    return 2131558867;
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
      byY();
      continue;
      if ((this.mFeed != null) && (this.mFeed.adBuffer.has()) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeAdFeedItemView$a != null))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeAdFeedItemView$a.g(this.mFeed);
        if ((this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.negative_feedback_url.get()))) {
          rze.dO(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.negative_feedback_url.get().replace("__ACT_TYPE__", "2001"));
        }
      }
      this.M.cancel();
      continue;
      if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.droplist != null)
      {
        Iterator localIterator = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.droplist.get().iterator();
        while (localIterator.hasNext())
        {
          vac_adv_get.DropList localDropList = (vac_adv_get.DropList)localIterator.next();
          if ((localDropList.action_type != null) && (localDropList.action_type.get() == 1)) {
            rzd.sW(localDropList.jumpurl.get());
          }
        }
      }
      this.M.cancel();
      continue;
      this.M.cancel();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver != null) {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.unregister(getContext());
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    byX();
    return true;
  }
  
  @RequiresApi(api=8)
  protected void q(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((paramStFeed == null) || (!paramStFeed.adBuffer.has())) {}
    for (;;)
    {
      return;
      this.mFeed = paramStFeed;
      try
      {
        this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo = new vac_adv_get.VacFeedsAdvMetaInfo();
        this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.mergeFrom(paramStFeed.adBuffer.get().toByteArray());
        if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo == null) {
          continue;
        }
        if ((this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info != null))
        {
          if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info != null)
          {
            if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info.pic_width.get() < this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info.pic_height.get()) {
              break label663;
            }
            f1 = 0.5625F;
            this.f.getLayoutParams().height = ((int)(f1 * this.mWidth));
            this.f.getLayoutParams().width = this.mWidth;
            this.f.requestLayout();
            this.e.setText(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info.txt.get());
            paramStFeed = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info.img.get();
            if (!TextUtils.isEmpty(paramStFeed)) {
              ryx.b(paramStFeed, this.f);
            }
          }
          if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.advertiser_info != null)
          {
            this.Ab.setText(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.advertiser_info.corporate_image_name.get());
            ryx.b(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.advertiser_info.corporate_logo.get(), this.o);
          }
          if ((this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.creative_size.get() != 185) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.creative_size.get() != 585)) {
            break label670;
          }
          if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.video_info != null)
          {
            int i = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.video_info.media_duration.get() / 60;
            int j = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.video_info.media_duration.get();
            this.mVideoDuration.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j % 60) }));
          }
          this.mVideoDuration.setVisibility(0);
        }
        else
        {
          if ((this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.exposure_url.get())) && (!this.aS.contains(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.exposure_url.get())))
          {
            rze.dO(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.exposure_url.get());
            this.aS.add(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.exposure_url.get());
          }
          if (!this.avA) {
            continue;
          }
          this.o.setFilterColor(1711276032);
          this.f.setColorFilter(1711276032);
          this.e.setTextColor(-5723992);
          this.Ab.setTextColor(-10132123);
          this.mVideoDuration.setTextColor(-5723992);
          this.mVideoDuration.setBackgroundDrawable(getResources().getDrawable(2130839126));
          return;
        }
      }
      catch (Exception paramStFeed)
      {
        for (;;)
        {
          paramStFeed.printStackTrace();
          continue;
          label663:
          float f1 = 1.777778F;
          continue;
          label670:
          this.mVideoDuration.setVisibility(8);
        }
      }
    }
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.avA = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void g(CertifiedAccountMeta.StFeed paramStFeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView
 * JD-Core Version:    0.7.0.1
 */