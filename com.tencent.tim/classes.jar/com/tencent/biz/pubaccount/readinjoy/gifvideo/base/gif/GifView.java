package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicLong;
import kwz;
import lfe;
import lff;

public class GifView
  extends FrameLayout
{
  private static Drawable mLoadingDrawable;
  private String DE;
  public int aOv = 1;
  private boolean ajQ;
  private KandianUrlImageView f;
  private Context mContext;
  protected String mCoverUrl;
  private int mGifHeight;
  private int mGifWidth;
  private URLImageView t;
  
  public GifView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public GifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean BZ()
  {
    return this.aOv <= 2;
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {}
    AtomicLong localAtomicLong1;
    AtomicLong localAtomicLong2;
    long l;
    AtomicLong localAtomicLong3;
    AtomicLong localAtomicLong4;
    do
    {
      return;
      localAtomicLong1 = new AtomicLong(0L);
      localAtomicLong2 = new AtomicLong(0L);
      l = System.currentTimeMillis();
      localAtomicLong3 = new AtomicLong(l);
      localAtomicLong4 = new AtomicLong(0L);
      paramURLDrawable.setDownloadListener(new lfe(this, localAtomicLong3, localAtomicLong1, l, localAtomicLong2, localAtomicLong4, paramURLDrawable));
    } while (this.t == null);
    StringBuilder localStringBuilder = new StringBuilder();
    this.t.setURLDrawableDownListener(new lff(this, l, localAtomicLong3, localAtomicLong1, localAtomicLong4, localAtomicLong2, localStringBuilder, paramURLDrawable));
  }
  
  private void aLG()
  {
    this.aOv = 1;
    this.ajQ = false;
  }
  
  private void aLH()
  {
    cI(this.mGifWidth >> this.aOv, this.mGifHeight >> this.aOv);
  }
  
  private void aLI()
  {
    this.f.setVisibility(4);
  }
  
  private static Drawable am()
  {
    if (mLoadingDrawable == null) {
      mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130842541);
    }
    return mLoadingDrawable;
  }
  
  private void init()
  {
    this.mContext = getContext();
    this.t = new URLImageView(this.mContext);
    this.f = new KandianUrlImageView(this.mContext);
    this.t.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.t, -1, -1);
    addView(this.f, -1, -1);
  }
  
  public void aLE()
  {
    cI(-1, -1);
  }
  
  public void aLF()
  {
    this.f.setVisibility(0);
    this.f.setAlpha(1.0F);
  }
  
  public void cI(int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(this.DE))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = am();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = am();
      if ((paramInt2 > 0) && (paramInt1 > 0))
      {
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
      }
      localObject = URLDrawable.getDrawable(this.DE, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1) {
        aLI();
      }
      a((URLDrawable)localObject);
      this.t.setImageDrawable((Drawable)localObject);
    }
  }
  
  public boolean isPlaying()
  {
    return (this.f != null) && (this.f.getVisibility() != 0);
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    aLF();
  }
  
  public void setCoverUrl(String paramString)
  {
    this.mCoverUrl = paramString;
    if (this.f != null) {}
    try
    {
      kwz.a(this.f, new URL(this.mCoverUrl), getContext());
      aLG();
      return;
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        QLog.d("gifvideo.GifView", 2, paramString.getMessage());
      }
    }
  }
  
  public void setGifHeight(int paramInt)
  {
    this.mGifHeight = paramInt;
  }
  
  public void setGifUrl(String paramString)
  {
    this.DE = paramString;
    aLG();
  }
  
  public void setGifWidth(int paramInt)
  {
    this.mGifWidth = paramInt;
  }
  
  public void setIsBigImg(boolean paramBoolean)
  {
    this.ajQ = paramBoolean;
  }
  
  public void setScaleType(int paramInt)
  {
    if (this.f != null) {
      this.f.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(paramInt, ImageView.ScaleType.CENTER_CROP));
    }
    if (this.t != null) {
      this.t.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(paramInt, ImageView.ScaleType.CENTER_CROP));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif.GifView
 * JD-Core Version:    0.7.0.1
 */