package com.tencent.biz.subscribe.widget.commodity;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import aoop;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import siu;
import sja;
import sjb;
import sqn;

public class CommodityItemView
  extends BaseWidgetView
{
  private boolean aLI;
  private CertifiedAccountMeta.StFeed k;
  private int mCardWidth;
  private SquareImageView n;
  private View qa;
  private View qb;
  private TextView zY;
  private TextView zZ;
  
  public CommodityItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommodityItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommodityItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void P(Object paramObject)
  {
    long l;
    if ((paramObject instanceof CommodityBean))
    {
      localObject = ((CommodityBean)paramObject).mTitle;
      l = ((CommodityBean)paramObject).mPrice;
      paramObject = ((CommodityBean)paramObject).mImg;
      this.zY.setText((CharSequence)localObject);
      if (l % 100L != 0L) {
        break label228;
      }
    }
    label228:
    for (Object localObject = String.format("%d", new Object[] { Long.valueOf(l / 100L) });; localObject = String.format("%.2f", new Object[] { Float.valueOf((float)l / 100.0F) }))
    {
      this.zZ.setText((CharSequence)localObject);
      if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        break label261;
      }
      try
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.am();
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.getFailedDrawable();
        paramObject = URLDrawable.getDrawable(paramObject, (URLDrawable.URLDrawableOptions)localObject);
        if (paramObject != null) {
          this.n.setImageDrawable(paramObject);
        }
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          paramObject.printStackTrace();
        }
      }
      if (this.k != null) {
        sqn.b(this.k.poster.id.get(), "auth_" + siu.b(getExtraTypeInfo()), "exp_goods", 0, 0, new String[0]);
      }
      return;
      localObject = ((CertifiedAccountMeta.StYouZanGood)paramObject).title.get();
      l = ((CertifiedAccountMeta.StYouZanGood)paramObject).price.get();
      paramObject = ((CertifiedAccountMeta.StYouZanGood)paramObject).img.get();
      break;
    }
    label261:
    ImageLoader.getInstance().loadImageAsync(paramObject, new sja(this));
  }
  
  public View aB()
  {
    return this;
  }
  
  public View aH()
  {
    return this.qb;
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.n = ((SquareImageView)paramView.findViewById(2131369716));
    this.zY = ((TextView)paramView.findViewById(2131380625));
    this.zZ = ((TextView)paramView.findViewById(2131380626));
    this.qa = paramView.findViewById(2131380585);
    this.qb = paramView.findViewById(2131369722);
    this.mCardWidth = (ImmersiveUtils.getScreenWidth() * 5 / 6);
    if (getLayoutParams() == null) {
      setLayoutParams(new FrameLayout.LayoutParams(this.mCardWidth, ImmersiveUtils.dpToPx(132.0F)));
    }
    this.zZ.setTextSize(ImmersiveUtils.getScreenWidth() / 750 * 24);
  }
  
  public int getLayoutId()
  {
    return 2131558836;
  }
  
  public void setCurrentFeed(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.k = paramStFeed;
  }
  
  public void setIsPublishUI(boolean paramBoolean)
  {
    this.aLI = paramBoolean;
    if (!paramBoolean) {}
    do
    {
      return;
      if (this.qa.getVisibility() == 0) {
        this.qa.setVisibility(8);
      }
    } while (this.qb.getVisibility() != 8);
    this.qb.setVisibility(0);
  }
  
  public View.OnClickListener v()
  {
    return new sjb(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityItemView
 * JD-Core Version:    0.7.0.1
 */