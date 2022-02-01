package com.tencent.biz.pubaccount.Advertisement.view;

import ahal;
import ahao;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aroc;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import jxc;
import jxd;
import jxe;
import jxo;
import jxt;
import jxu;
import jxv;
import jxw;
import mqq.os.MqqHandler;
import skj;

public class VideoCoverView
  extends RelativeLayout
{
  public String UC;
  private AdvertisementSplitedProgressBar jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar;
  private a jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView$a;
  private b jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView$b;
  private ResizeURLImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView;
  private jxc jdField_a_of_type_Jxc;
  private int aDT;
  private int aEs;
  public int aEt;
  boolean acT = false;
  private boolean acU;
  private boolean acV;
  private AnimatorListenerAdapter b;
  private skj c;
  private RelativeLayout eA;
  private View jl;
  private View jm;
  private ArrayList<jxd> jv;
  private ValueAnimator mAnimator;
  private Context mContext;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private View mLoadingView;
  private int mScreenHeight;
  private int mScreenWidth;
  
  public VideoCoverView(Context paramContext, jxd paramjxd, int paramInt, AdvertisementSplitedProgressBar paramAdvertisementSplitedProgressBar, b paramb, ArrayList<jxd> paramArrayList, jxc paramjxc, skj paramskj)
  {
    super(paramContext);
    this.mContext = paramContext;
    LayoutInflater.from(getContext()).inflate(2131559801, this);
    this.eA = ((RelativeLayout)findViewById(2131381710));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView = ((ResizeURLImageView)findViewById(2131381646));
    this.mLoadingView = findViewById(2131370820);
    this.jl = findViewById(2131366694);
    this.jl.setOnClickListener(new jxt(this, paramContext));
    this.jm = findViewById(2131378781);
    this.jm.setOnClickListener(new jxu(this));
    this.aDT = paramjxd.aDT;
    this.UC = paramjxd.UC;
    this.aEs = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = paramAdvertisementSplitedProgressBar;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView$b = paramb;
    this.jv = paramArrayList;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar.setTotalCount(this.aEs);
    paramContext = getResources().getDisplayMetrics();
    this.mScreenWidth = paramContext.widthPixels;
    this.mScreenHeight = paramContext.heightPixels;
    this.jdField_a_of_type_Jxc = paramjxc;
    this.acT = this.jdField_a_of_type_Jxc.a.acC;
    this.c = paramskj;
    this.mAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView$a = new a();
    this.b = new jxv(this);
    if (this.acT)
    {
      paramContext = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.getLayoutParams();
      paramContext.width = this.mScreenWidth;
      paramContext.height = ((int)(this.mScreenWidth * 0.5626F));
    }
    if (!TextUtils.isEmpty(paramjxd.UB)) {}
    try
    {
      paramContext = new URL(paramjxd.UB);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setImage(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void lG(boolean paramBoolean)
  {
    if (!VideoCoverFragment.isSelected)
    {
      lH(paramBoolean);
      return;
    }
    if (VideoCoverFragment.acG)
    {
      bJ(this.mContext);
      return;
    }
    lH(paramBoolean);
  }
  
  private void lH(boolean paramBoolean)
  {
    boolean bool = jxo.dp(this.UC);
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverView", 2, this.UC + " playByNet hasCache:" + bool + " isStop" + paramBoolean);
    }
    if (bool)
    {
      bJ(this.mContext);
      return;
    }
    int i = aroc.getNetType(null);
    if (i == 0)
    {
      ahao.OS(2131689700);
      this.aEt = 6;
      updateView();
      return;
    }
    if (i == 1)
    {
      if ((paramBoolean) && (this.aEt == 5))
      {
        resumeVideo();
        return;
      }
      bJ(this.mContext);
      return;
    }
    showDialog();
  }
  
  public void akG() {}
  
  public void azR() {}
  
  public BaseVideoView b()
  {
    return null;
  }
  
  public void bJ(Context paramContext) {}
  
  public long bY()
  {
    return 0L;
  }
  
  public void initSDK(Context paramContext) {}
  
  public void onDestory()
  {
    azR();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = null;
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler = null;
    this.c = null;
    this.mAnimator.removeAllUpdateListeners();
    this.mAnimator.removeAllListeners();
  }
  
  public void pauseVideo() {}
  
  public void resumeVideo() {}
  
  public void showDialog()
  {
    if ((PublicAccountAdvertisementActivity.class.isInstance(this.mContext)) && (!((PublicAccountAdvertisementActivity)this.mContext).isFinishing()))
    {
      this.acU = true;
      ahal.a(this.mContext, 2131693826, 2131689698, new jxw(this));
    }
  }
  
  public void updateView()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new VideoCoverView.5(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverView", 2, "updateView mVideoState=" + this.aEt);
    }
    switch (this.aEt)
    {
    default: 
      if (jxo.dp(this.UC)) {
        this.mLoadingView.setVisibility(8);
      }
      break;
    }
    for (;;)
    {
      this.jl.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.jm.setVisibility(8);
      return;
      this.mLoadingView.setVisibility(8);
      this.jl.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
      this.jm.setVisibility(8);
      return;
      this.mLoadingView.setVisibility(8);
      this.jl.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
      this.jm.setVisibility(8);
      return;
      this.mLoadingView.setVisibility(8);
      this.jl.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.jm.setVisibility(0);
      return;
      this.mLoadingView.setVisibility(8);
      this.jl.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.jm.setVisibility(0);
      return;
      this.mLoadingView.setVisibility(0);
    }
  }
  
  class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      VideoCoverView.this.setRotation(90.0F * f1);
      float f2 = VideoCoverView.a(VideoCoverView.this) * 1.0F / VideoCoverView.b(VideoCoverView.this);
      VideoCoverView.this.setScaleX((f2 - 1.0F) * f1 + 1.0F);
      VideoCoverView.this.setScaleY(f1 * 0.7774618F + 1.0F);
    }
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView
 * JD-Core Version:    0.7.0.1
 */