package com.tencent.gdtad.api.banner;

import android.content.Context;
import android.view.View;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import java.lang.ref.WeakReference;
import thb;
import thd;
import the;
import thf;
import tkw;
import tle;

public final class GdtBannerAd
  extends com.tencent.gdtad.api.GdtAd
{
  private thd params;
  private boolean rendered;
  
  public GdtBannerAd(thd paramthd)
  {
    super(paramthd);
    this.params = paramthd;
  }
  
  public int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = super.getErrorCode(paramGdtAd, paramInt1, paramInt2, paramInt3);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    if ((paramGdtAd == null) || (!isValid()))
    {
      tkw.e("GdtBannerAd", "getErrorCode error");
      return 1;
    }
    paramInt1 = paramGdtAd.getCreativeSize();
    if ((getParams().style == 0) && ((paramInt1 == 65) || (paramInt1 == 184) || (paramInt1 == 193) || (paramInt1 == 194) || (paramInt1 == 210) || (paramInt1 == 285))) {
      return 0;
    }
    return 7;
  }
  
  protected thd getParams()
  {
    return this.params;
  }
  
  public the render(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramContext == null) || (paramInt1 < 0) || (paramInt2 < 0) || (!isLoaded()) || (this.rendered))
    {
      tkw.e("GdtBannerAd", "render error");
      return null;
    }
    paramContext = new thd();
    paramContext.c = this.params.c;
    paramContext.style = this.params.style;
    paramContext.width = paramInt1;
    paramContext.height = paramInt2;
    paramContext = thf.a(paramContext);
    if ((paramContext == null) || (paramContext.getView() == null) || (the.a == null))
    {
      tkw.e("GdtBannerAd", "render error");
      return null;
    }
    this.params.a = new GdtDwellTimeStatisticsAfterClick(getAd(), new WeakReference(paramContext.getView()));
    paramContext.getView().setOnClickListener(new thb(this, paramContext));
    tle.impressionReport(getAd().getUrlForImpression());
    notifyImpression();
    this.rendered = true;
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerAd
 * JD-Core Version:    0.7.0.1
 */