package com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kjz;
import org.json.JSONObject;
import wja;

public class ReadInJoyCommonSoftAdBar
  extends FrameLayout
  implements View.OnClickListener
{
  private a a;
  public ProteusInnerData a;
  private FrameLayout aa;
  private FrameLayout ab;
  private FrameLayout ac;
  private ReadInjoyHeaderAdDownloadView.SimpleRoundProgress b;
  private ImageView icon;
  private TextView od;
  private int qU = 3;
  private View rootView;
  
  public ReadInJoyCommonSoftAdBar(@NonNull Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public ReadInJoyCommonSoftAdBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public ReadInJoyCommonSoftAdBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private TextView a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(paramString);
    localTextView.setTextSize(paramInt1);
    localTextView.setTextColor(paramInt2);
    localTextView.setMaxLines(paramInt3);
    if (paramInt3 == 1) {
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
    }
    return localTextView;
  }
  
  private void aDN() {}
  
  private void aDO() {}
  
  private void aDP()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.aC == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.aC.optString("adImg", "");
    Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.aC.optString("goodsName", "");
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.aC.optString("buttonTxt", "");
    kjz.a(getContext(), this.icon, (String)localObject1, 8, 30, -1);
    localObject1 = new LinearLayout(getContext());
    Object localObject4 = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject4).gravity = 16;
    ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((LinearLayout)localObject1).setOrientation(0);
    localObject3 = a((String)localObject3, 14, Color.parseColor("#000000"), 1);
    localObject4 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject4).gravity = 16;
    ((TextView)localObject3).setTag("soft_title");
    ((TextView)localObject3).setOnClickListener(this);
    ((LinearLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject2 = a((String)localObject2, 11, Color.parseColor("#99000000"), 1);
    localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).gravity = 16;
    ((LinearLayout.LayoutParams)localObject3).leftMargin = wja.dp2px(6.0F, getResources());
    ((TextView)localObject2).setTag("soft_desc");
    ((TextView)localObject2).setOnClickListener(this);
    ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    this.aa.addView((View)localObject1);
    this.b = new ReadInjoyHeaderAdDownloadView.SimpleRoundProgress(getContext());
    kjz.a(this.b);
    localObject1 = new FrameLayout.LayoutParams(wja.dp2px(25.0F, getResources()), wja.dp2px(25.0F, getResources()));
    ((FrameLayout.LayoutParams)localObject1).gravity = 21;
    ((FrameLayout.LayoutParams)localObject1).rightMargin = wja.dp2px(6.0F, getResources());
    this.b.setTag("soft_progress");
    this.b.setOnClickListener(this);
    this.ab.addView(this.b, (ViewGroup.LayoutParams)localObject1);
    this.b.setVisibility(8);
    this.od = new TextView(getContext());
    localObject1 = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject1).gravity = 17;
    this.od.setText("立即下载");
    this.od.setTextSize(14.0F);
    this.od.setTextColor(Color.parseColor("#00CAFC"));
    this.od.setTag("soft_btn");
    this.od.setOnClickListener(this);
    this.ab.addView(this.od, (ViewGroup.LayoutParams)localObject1);
    this.ab.setVisibility(0);
    this.ac.setVisibility(0);
  }
  
  private void aDQ() {}
  
  private void initView()
  {
    this.rootView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131560293, this);
    this.icon = ((ImageView)this.rootView.findViewById(2131368698));
    this.aa = ((FrameLayout)this.rootView.findViewById(2131365373));
    this.ab = ((FrameLayout)this.rootView.findViewById(2131363777));
    this.ac = ((FrameLayout)this.rootView.findViewById(2131366981));
    resetUI();
    this.icon.setOnClickListener(this);
    this.ac.setOnClickListener(this);
  }
  
  private void resetUI()
  {
    this.aa.removeAllViews();
    this.ab.removeAllViews();
  }
  
  public void ck(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4) {
      if (this.b != null) {
        this.b.setPaused(true);
      }
    }
    while (this.b == null) {
      return;
    }
    this.b.setProgress(paramInt2);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barReadInJoyCommonSoftAdBar$a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof String)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barReadInJoyCommonSoftAdBar$a.h(this.qU, (String)localObject, paramView.getId());
      } else {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barReadInJoyCommonSoftAdBar$a.h(this.qU, null, paramView.getId());
      }
    }
  }
  
  public void setDownloadState(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            ck(paramInt1, paramInt2);
            if (this.od != null) {
              this.od.setVisibility(8);
            }
          } while (this.b == null);
          this.b.setVisibility(0);
          return;
          if (this.od != null) {
            this.od.setVisibility(0);
          }
          ck(paramInt1, paramInt2);
        } while (this.b == null);
        this.b.setVisibility(8);
        return;
        if (this.od != null) {
          this.od.setVisibility(0);
        }
        ck(paramInt1, paramInt2);
      } while (this.b == null);
      this.b.setVisibility(8);
      return;
      if (this.od != null) {
        this.od.setVisibility(8);
      }
      if (this.b != null) {
        this.b.setVisibility(0);
      }
      ck(paramInt1, paramInt2);
      return;
      if (this.od != null) {
        this.od.setVisibility(0);
      }
    } while (this.b == null);
    this.b.setVisibility(8);
  }
  
  public void setSoftAdClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barReadInJoyCommonSoftAdBar$a = parama;
  }
  
  public void setUI(ProteusInnerData paramProteusInnerData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData = paramProteusInnerData;
    this.qU = 3;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData == null) {
      return;
    }
    resetUI();
    switch (this.qU)
    {
    default: 
      return;
    case 1: 
      aDN();
      return;
    case 2: 
      aDO();
      return;
    case 3: 
      aDP();
      return;
    }
    aDQ();
  }
  
  public static abstract interface a
  {
    public abstract void h(int paramInt1, String paramString, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.ReadInJoyCommonSoftAdBar
 * JD-Core Version:    0.7.0.1
 */