package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import knd;
import kng;
import koq;
import kwz;
import mgs;
import mye.b;
import org.json.JSONException;
import org.json.JSONObject;
import wja;

public class ReadInJoyPatchAdView
  extends FrameLayout
  implements View.OnClickListener
{
  public a a;
  private KanDianUrlRoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
  private mye.b jdField_a_of_type_Mye$b;
  private int aKG;
  public AdvertisementInfo advertisementInfo;
  private KandianUrlImageView d;
  private View mRootView;
  private TextView oA;
  private TextView oB;
  private TextView oC;
  private TextView oD;
  private TextView ov;
  private int qU;
  private Handler uiHandler;
  
  public ReadInJoyPatchAdView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyPatchAdView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyPatchAdView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
    Nx();
    initHandler();
  }
  
  private void Nx()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setOnClickListener(this);
    this.ov.setOnClickListener(this);
    this.oD.setOnClickListener(this);
  }
  
  private void aFu()
  {
    if (this.oB != null) {
      this.oB.setText("0秒");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a != null)
    {
      finish();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a.d(this.jdField_a_of_type_Mye$b, this.qU, 0);
    }
  }
  
  private void initHandler()
  {
    this.uiHandler = new koq(this, Looper.getMainLooper());
  }
  
  private void initView()
  {
    this.mRootView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131560239, this);
    this.d = ((KandianUrlImageView)this.mRootView.findViewById(2131368863));
    this.oA = ((TextView)this.mRootView.findViewById(2131372904));
    this.oB = ((TextView)this.mRootView.findViewById(2131378314));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)this.mRootView.findViewById(2131362107));
    this.oC = ((TextView)this.mRootView.findViewById(2131362277));
    this.ov = ((TextView)this.mRootView.findViewById(2131362148));
    this.oD = ((TextView)this.mRootView.findViewById(2131372906));
  }
  
  private int nu()
  {
    if (this.jdField_a_of_type_Mye$b == null) {
      return 0;
    }
    return this.jdField_a_of_type_Mye$b.d.patchStatus.U.get();
  }
  
  private int nv()
  {
    if (this.jdField_a_of_type_Mye$b == null) {
      return 0;
    }
    return this.jdField_a_of_type_Mye$b.d.patchStatus.V.get();
  }
  
  private void startTimer(int paramInt)
  {
    if (this.uiHandler == null) {}
    for (;;)
    {
      return;
      if ((this.advertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a != null)) {}
      try
      {
        if (kng.f(new JSONObject(this.advertisementInfo.mAdExtInfo)) == paramInt)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a.a(this.jdField_a_of_type_Mye$b, this.qU);
          this.uiHandler.sendEmptyMessageDelayed(1203, 1000L);
        }
        if (this.oB != null)
        {
          this.oB.setText(paramInt + "秒");
          this.aKG = paramInt;
        }
        if (paramInt >= 1)
        {
          Message localMessage = new Message();
          localMessage.what = 1201;
          localMessage.obj = Integer.valueOf(paramInt - 1);
          this.uiHandler.sendMessageDelayed(localMessage, 1000L);
        }
        if (paramInt >= 1) {
          continue;
        }
        this.uiHandler.sendEmptyMessage(1202);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public boolean Ag()
  {
    return (nu() == 1) || (nv() == 1);
  }
  
  public void a(mye.b paramb, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      this.qU = paramInt;
      this.advertisementInfo = paramAdvertisementInfo;
      this.jdField_a_of_type_Mye$b = paramb;
      this.ov.setText(paramAdvertisementInfo.mTitle);
      this.oC.setText(paramAdvertisementInfo.mAdTxt);
      this.oD.setText(knd.a(getContext(), paramAdvertisementInfo));
      try
      {
        paramb = new URL(paramAdvertisementInfo.mAdImg);
        URL localURL = new URL(paramAdvertisementInfo.mAdCorporateLogo);
        kwz.a(this.d, paramb, getContext(), false);
        kwz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, localURL, getContext(), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(wja.dp2px(2.0F, getContext().getResources()));
        try
        {
          paramInt = kng.f(new JSONObject(paramAdvertisementInfo.mAdExtInfo));
          if (paramInt < 0)
          {
            finish();
            return;
          }
        }
        catch (JSONException paramb)
        {
          paramb.printStackTrace();
          return;
        }
      }
      catch (Exception paramb)
      {
        for (;;)
        {
          paramb.printStackTrace();
        }
      }
    } while (this.uiHandler == null);
    paramb = new Message();
    paramb.what = 1201;
    paramb.obj = Integer.valueOf(paramInt);
    this.uiHandler.sendMessage(paramb);
  }
  
  public mye.b b()
  {
    return this.jdField_a_of_type_Mye$b;
  }
  
  public void finish()
  {
    if (this.uiHandler != null)
    {
      this.uiHandler.removeMessages(1201);
      this.uiHandler.removeMessages(1202);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = 5;
    int i = j;
    switch (paramView.getId())
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a != null)
      {
        finish();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a.c(this.jdField_a_of_type_Mye$b, this.qU, i);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a.d(this.jdField_a_of_type_Mye$b, this.qU, 1);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 8;
    }
  }
  
  public void onCompletion()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a.d(this.jdField_a_of_type_Mye$b, this.qU, 0);
    }
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a.d(this.jdField_a_of_type_Mye$b, this.qU);
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a.c(this.jdField_a_of_type_Mye$b, this.qU);
    }
  }
  
  public void pr(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a.c(this.jdField_a_of_type_Mye$b, this.qU, paramInt);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a.d(this.jdField_a_of_type_Mye$b, this.qU, 1);
    }
  }
  
  public void setOnPatchAdListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(mye.b paramb, int paramInt);
    
    public abstract void b(mye.b paramb, int paramInt);
    
    public abstract void c(mye.b paramb, int paramInt);
    
    public abstract void c(mye.b paramb, int paramInt1, int paramInt2);
    
    public abstract void d(mye.b paramb, int paramInt);
    
    public abstract void d(mye.b paramb, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView
 * JD-Core Version:    0.7.0.1
 */