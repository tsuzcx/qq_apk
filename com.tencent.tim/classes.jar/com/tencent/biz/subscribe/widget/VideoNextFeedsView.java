package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import aqhu;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.QZLog;
import java.util.List;
import java.util.Timer;
import rpq;
import rzd;

public class VideoNextFeedsView
  extends FrameLayout
{
  private int Rq = 5;
  private final String TAG = "VideoNextFeedsView";
  private a a;
  private boolean aLq;
  private int bxl = rpq.dip2px(getContext(), 18.0F);
  private int bxm;
  private CircleProgress c;
  private View fN;
  private CertifiedAccountMeta.StFeed j;
  private ImageView mCover;
  private int mCoverHeight;
  private int mCoverWidth;
  private int mCurrentIndex;
  private int mHeight = rpq.dip2px(getContext(), 75.0F);
  private TextView mNickName;
  private TextView mTitle;
  private int mWidth = rpq.dip2px(getContext(), 331.0F);
  private ImageView oj;
  private List<CertifiedAccountMeta.StFeed> ps;
  private Timer q;
  private TextView zX;
  
  public VideoNextFeedsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoNextFeedsView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoNextFeedsView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private boolean MV()
  {
    if (this.ps == null) {
      return false;
    }
    CertifiedAccountMeta.StFeed localStFeed;
    do
    {
      this.mCurrentIndex += 1;
      if (this.mCurrentIndex >= this.ps.size()) {
        break;
      }
      localStFeed = (CertifiedAccountMeta.StFeed)this.ps.get(this.mCurrentIndex);
    } while ((localStFeed == null) || (!rzd.fe(localStFeed.type.get())));
    for (;;)
    {
      if (localStFeed == null)
      {
        QZLog.e("VideoNextFeedsView", "playNextData():no more feed can play!");
        return false;
      }
      ImageView localImageView = this.oj;
      String str = localStFeed.poster.icon.get();
      int i = rpq.dip2px(getContext(), this.bxl);
      int k = rpq.dip2px(getContext(), this.bxl);
      Context localContext = getContext();
      if (this.aLq) {}
      for (float f = 10.0F;; f = 9.0F)
      {
        rpq.a(localImageView, str, i, k, rpq.dip2px(localContext, f), aqhu.at(), null);
        rpq.a(this.mCover, localStFeed.cover.url.get(), this.mCoverWidth, this.mCoverHeight, getResources().getDrawable(2130840068), null);
        this.mTitle.setText(localStFeed.title.get());
        this.mNickName.setText(localStFeed.poster.nick.get());
        this.j = localStFeed;
        this.mCurrentIndex += 1;
        return true;
      }
      localStFeed = null;
    }
  }
  
  private void byW()
  {
    if (this.q != null)
    {
      this.q.cancel();
      this.q = null;
      this.Rq = 5;
    }
  }
  
  private void initView()
  {
    this.fN = LayoutInflater.from(getContext()).inflate(2131558878, null);
    addView(this.fN);
    this.oj = ((ImageView)this.fN.findViewById(2131369823));
    this.mTitle = ((TextView)this.fN.findViewById(2131380815));
    this.mNickName = ((TextView)this.fN.findViewById(2131380816));
    this.zX = ((TextView)this.fN.findViewById(2131380635));
    this.mCover = ((ImageView)this.fN.findViewById(2131369824));
    this.c = ((CircleProgress)this.fN.findViewById(2131365503));
    this.c.setBgAndProgressColor(30, Color.parseColor("#ffffff"), 100, Color.parseColor("#ffffff"));
    this.c.setStrokeWidth(rpq.dip2px(getContext(), 1.0F));
    setVisibility(8);
  }
  
  public void byU()
  {
    if (this.a != null) {
      this.a.uL(MV());
    }
  }
  
  public void byV()
  {
    byW();
    if (this.bxm != 0) {
      this.Rq = this.bxm;
    }
    this.q = new Timer();
    this.q.schedule(new VideoNextFeedsView.2(this), 0L, 1000L);
  }
  
  public CertifiedAccountMeta.StFeed f()
  {
    return this.j;
  }
  
  public void hide()
  {
    if (getHandler() != null) {
      getHandler().post(new VideoNextFeedsView.1(this));
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (getHandler() != null) {
      getHandler().removeCallbacksAndMessages(null);
    }
    byW();
  }
  
  public void setData(List<CertifiedAccountMeta.StFeed> paramList)
  {
    this.mCurrentIndex = 0;
    this.ps = paramList;
  }
  
  public void setOnCounterListener(a parama)
  {
    this.a = parama;
  }
  
  public void setUIState(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k;
    if (paramBoolean2)
    {
      i = ImmersiveUtils.dpToPx(400.0F);
      this.aLq = paramBoolean1;
      if (!paramBoolean1) {
        break label234;
      }
      k = ImmersiveUtils.dpToPx(14.0F);
      label28:
      if (!paramBoolean1) {
        break label245;
      }
      label32:
      this.mWidth = i;
      if (!paramBoolean1) {
        break label254;
      }
      i = ImmersiveUtils.dpToPx(135.0F);
      label48:
      this.mHeight = i;
      if (!paramBoolean1) {
        break label260;
      }
      i = ImmersiveUtils.dpToPx(133.0F);
      label64:
      this.mCoverWidth = i;
      if (!paramBoolean1) {
        break label269;
      }
      i = ImmersiveUtils.dpToPx(103.0F);
      label80:
      this.mCoverHeight = i;
      if (!paramBoolean1) {
        break label279;
      }
      i = ImmersiveUtils.dpToPx(20.0F);
      label96:
      this.bxl = i;
      if (!paramBoolean1) {
        break label288;
      }
    }
    label260:
    label269:
    label279:
    label288:
    for (int i = ImmersiveUtils.dpToPx(30.0F);; i = ImmersiveUtils.dpToPx(10.0F))
    {
      this.fN.setPadding(k, k, k, k);
      getLayoutParams().width = this.mWidth;
      getLayoutParams().height = this.mHeight;
      this.oj.getLayoutParams().width = this.bxl;
      this.oj.getLayoutParams().height = this.bxl;
      this.mCover.getLayoutParams().width = this.mCoverWidth;
      this.mCover.getLayoutParams().height = this.mCoverHeight;
      this.mTitle.setPadding(0, 0, i, 0);
      requestLayout();
      return;
      i = (int)(ImmersiveUtils.getScreenWidth() * 0.88D);
      break;
      label234:
      k = ImmersiveUtils.dpToPx(8.0F);
      break label28;
      label245:
      i = ImmersiveUtils.dpToPx(331.0F);
      break label32;
      label254:
      i = -2;
      break label48;
      i = ImmersiveUtils.dpToPx(75.0F);
      break label64;
      i = ImmersiveUtils.dpToPx(59.0F);
      break label80;
      i = ImmersiveUtils.dpToPx(18.0F);
      break label96;
    }
  }
  
  public boolean show()
  {
    if (MV())
    {
      byV();
      setVisibility(0);
      return true;
    }
    setVisibility(8);
    return false;
  }
  
  public void uM(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.bxm = this.Rq;
      byW();
      return;
    }
    byV();
    this.bxm = 0;
  }
  
  public static abstract interface a
  {
    public abstract void uL(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.VideoNextFeedsView
 * JD-Core Version:    0.7.0.1
 */