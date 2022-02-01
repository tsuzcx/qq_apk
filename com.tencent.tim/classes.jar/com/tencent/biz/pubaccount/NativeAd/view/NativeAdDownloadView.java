package com.tencent.biz.pubaccount.NativeAd.view;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress;
import jzp;
import kjy;
import kjz;
import odc;
import org.json.JSONObject;
import wja;

public class NativeAdDownloadView
  extends RelativeLayout
{
  private JSONObject Q;
  private ReadInjoyHeaderAdDownloadView.SimpleRoundProgress jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress;
  private kjy jdField_a_of_type_Kjy;
  private RelativeLayout eC;
  private Context mContext;
  private ProgressBar mProgressBar;
  private int mStyle = 1;
  private TextView nO;
  
  public NativeAdDownloadView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public NativeAdDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public NativeAdDownloadView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void aBu()
  {
    if (this.Q == null) {
      return;
    }
    if (this.jdField_a_of_type_Kjy == null) {
      this.jdField_a_of_type_Kjy = new kjy(1);
    }
    kjy.a(1, this.jdField_a_of_type_Kjy, this.Q);
    setStyle1(this.jdField_a_of_type_Kjy);
  }
  
  private void aBv()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress = new ReadInjoyHeaderAdDownloadView.SimpleRoundProgress(getContext());
    }
    kjz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(25.0F, getContext().getResources()), wja.dp2px(25.0F, getContext().getResources()));
    localLayoutParams.rightMargin = wja.dp2px(10.0F, getContext().getResources());
    this.eC.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress, localLayoutParams);
  }
  
  private void initView(Context paramContext)
  {
    this.mContext = paramContext;
    inflate(getContext(), 2131560233, this);
    this.eC = ((RelativeLayout)findViewById(2131372941));
  }
  
  public void ck(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4)
    {
      if (this.mProgressBar != null) {
        this.mProgressBar.setProgress(paramInt2);
      }
      if ((this.nO == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setPaused(true);
      }
      return;
    }
    setProgress(paramInt2);
  }
  
  public void setBtnText(String paramString)
  {
    if (this.nO != null) {
      this.nO.setText(paramString);
    }
  }
  
  public void setProgress(int paramInt)
  {
    if (this.mProgressBar != null) {
      this.mProgressBar.setProgress(paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setPauseWithoutInvalidate(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView$SimpleRoundProgress.setProgress(paramInt);
    }
    setText(paramInt);
  }
  
  public void setProgressStyle(JSONObject paramJSONObject)
  {
    this.Q = paramJSONObject;
    if (paramJSONObject != null)
    {
      this.mStyle = jzp.o(paramJSONObject.optString("style"), 1);
      setStyle(this.mStyle);
    }
  }
  
  public void setStyle(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      aBu();
      return;
    }
    aBv();
  }
  
  public void setStyle1(kjy paramkjy)
  {
    float f1 = 2.0F;
    if (paramkjy == null) {}
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    do
    {
      return;
      if (this.mProgressBar == null)
      {
        inflate(getContext(), 2131560242, this.eC);
        this.mProgressBar = ((ProgressBar)this.eC.findViewById(2131372944));
        this.nO = ((TextView)this.eC.findViewById(2131380854));
      }
      this.jdField_a_of_type_Kjy = paramkjy;
      this.mProgressBar.setVisibility(0);
      paramkjy = (RelativeLayout.LayoutParams)this.mProgressBar.getLayoutParams();
      paramkjy.width = wja.dp2px(this.jdField_a_of_type_Kjy.width, this.mContext.getResources());
      paramkjy.height = wja.dp2px(this.jdField_a_of_type_Kjy.height, this.mContext.getResources());
      paramkjy.addRule(13);
      this.mProgressBar.setLayoutParams(paramkjy);
      this.mProgressBar.setMax(100);
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(wja.dp2px(this.jdField_a_of_type_Kjy.iB, this.mContext.getResources()));
      ((GradientDrawable)localObject1).setColor(jzp.l(this.jdField_a_of_type_Kjy.ZF, "#F2F2F2"));
      localObject1 = new ClipDrawable((Drawable)localObject1, 3, 1);
      ((ClipDrawable)localObject1).setLevel(10000);
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(wja.dp2px(this.jdField_a_of_type_Kjy.iB, this.mContext.getResources()));
      ((GradientDrawable)localObject2).setColor(jzp.l(this.jdField_a_of_type_Kjy.ZG, "#F2F2F2"));
      localObject2 = new ClipDrawable((Drawable)localObject2, 3, 1);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(wja.dp2px(this.jdField_a_of_type_Kjy.iB, this.mContext.getResources()));
      localGradientDrawable.setColor(jzp.l(this.jdField_a_of_type_Kjy.ZE, "#12B7F5"));
      localObject1 = new LayerDrawable(new Drawable[] { localObject1, localObject2, new ClipDrawable(localGradientDrawable, 3, 1) });
      ((LayerDrawable)localObject1).setId(0, 16908288);
      ((LayerDrawable)localObject1).setId(1, 16908303);
      ((LayerDrawable)localObject1).setId(2, 16908301);
      this.mProgressBar.setProgressDrawable((Drawable)localObject1);
      this.mProgressBar.setProgress(0);
      this.nO.setGravity(17);
      this.nO.setTextColor(jzp.l(this.jdField_a_of_type_Kjy.textColor, "#ffffff"));
      j = this.jdField_a_of_type_Kjy.textSize;
      if (j >= this.jdField_a_of_type_Kjy.minTextSize) {
        break;
      }
      i = this.jdField_a_of_type_Kjy.minTextSize;
      this.nO.setTextSize(2, i);
      this.nO.setVisibility(0);
      this.nO.setClickable(false);
      localObject1 = this.jdField_a_of_type_Kjy.ZH;
      localObject2 = String.valueOf(this.jdField_a_of_type_Kjy.iC);
    } while ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)));
    float f2 = jzp.b((String)localObject2, 0.0F);
    if (f2 > 2.0F) {}
    for (;;)
    {
      localObject2 = (RelativeLayout.LayoutParams)this.eC.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = (paramkjy.width + wja.dp2px(f1, this.mContext.getResources()) * 2);
      ((RelativeLayout.LayoutParams)localObject2).height = (paramkjy.height + wja.dp2px(f1, this.mContext.getResources()) * 2);
      this.eC.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      odc.a(this.eC, wja.dp2px(this.jdField_a_of_type_Kjy.iB, this.mContext.getResources()), jzp.l((String)localObject1, "#12B7F5"), wja.dp2px(f1, this.mContext.getResources()));
      return;
      i = j;
      if (j <= this.jdField_a_of_type_Kjy.maxTextSize) {
        break;
      }
      i = this.jdField_a_of_type_Kjy.maxTextSize;
      break;
      f1 = f2;
    }
  }
  
  public void setText(int paramInt)
  {
    if (this.nO != null) {
      switch (this.mStyle)
      {
      }
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_Kjy == null) || (this.jdField_a_of_type_Kjy.afV));
    this.nO.setText(paramInt + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView
 * JD-Core Version:    0.7.0.1
 */