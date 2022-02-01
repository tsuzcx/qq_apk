package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import lie;
import mas;
import mrk;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import wja;

public class NativeAvatarView
  extends RingAvatarView
  implements IView
{
  private mas a = new mas();
  private ReadInJoyHeadImageView j;
  private ImageView jd;
  private NativeReadInjoyImageView m;
  private long uin;
  
  public NativeAvatarView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jd = new ImageView(paramContext);
    localLayoutParams.addRule(13);
    this.jd.setImageResource(2130850324);
    this.jd.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.jd.setVisibility(8);
    addView(this.jd, localLayoutParams);
    this.j = new ReadInJoyHeadImageView(paramContext);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(13);
    int i = wja.dp2px(3.5F, paramContext.getResources());
    localLayoutParams.setMargins(i, i, i, i);
    this.j.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.j, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(16.0F, paramContext.getResources()), wja.dp2px(16.0F, paramContext.getResources()));
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    i = wja.dp2px(0.0F, paramContext.getResources());
    localLayoutParams.setMargins(0, 0, i, i);
    this.m = new NativeReadInjoyImageView(paramContext);
    this.m.setImageResource(2130843712);
    this.m.setVisibility(8);
    addView(this.m, localLayoutParams);
  }
  
  public void a(lie paramlie)
  {
    if (paramlie == null) {}
    do
    {
      return;
      paramlie = paramlie.a();
    } while ((paramlie == null) || (paramlie.mSocialFeedInfo == null) || (paramlie.mSocialFeedInfo.a == null));
    if (paramlie.mSocialFeedInfo.a.DD())
    {
      this.jd.setVisibility(0);
      return;
    }
    this.jd.setVisibility(8);
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void refresh(boolean paramBoolean)
  {
    if (this.a.a == null) {
      return;
    }
    this.j.setHeadImgByUin(this.uin, paramBoolean);
    Object localObject = this.a.a.a();
    if (localObject == null)
    {
      this.m.setVisibility(8);
      return;
    }
    this.m.setImageResource(2130843712);
    if (((ArticleInfo)localObject).isAccountShown) {
      if (((ArticleInfo)localObject).mPartnerAccountInfo != null)
      {
        localObject = ((ArticleInfo)localObject).mPartnerAccountInfo.bytes_v_icon_url.get().toStringUtf8();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label162;
        }
        this.m.setVisibility(0);
      }
    }
    for (;;)
    {
      try
      {
        this.m.setImage(new URL((String)localObject));
        a(this.a.a);
        mrk.a(this.uin, this.m);
        return;
        localObject = "";
      }
      catch (Exception localException)
      {
        QLog.e("NativeAvatarView", 2, localException, new Object[0]);
        continue;
      }
      label162:
      this.m.setVisibility(8);
      continue;
      if ((localException.mSocialFeedInfo != null) && (localException.mSocialFeedInfo.a != null))
      {
        if (localException.mSocialFeedInfo.a.type == 1) {
          this.m.setVisibility(0);
        } else {
          this.m.setVisibility(8);
        }
      }
      else {
        this.m.setVisibility(8);
      }
    }
  }
  
  public void setAvatarDrawable(Drawable paramDrawable)
  {
    this.j.setImageDrawable(paramDrawable);
    this.m.setVisibility(8);
  }
  
  public void setModel(lie paramlie)
  {
    setModel(paramlie, true);
  }
  
  public void setModel(lie paramlie, boolean paramBoolean)
  {
    this.a.setModel(paramlie);
    refresh(paramBoolean);
  }
  
  public void setUin(long paramLong)
  {
    this.uin = paramLong;
    this.j.setHeadImgByUin(paramLong, true);
    mrk.a(paramLong, this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAvatarView
 * JD-Core Version:    0.7.0.1
 */