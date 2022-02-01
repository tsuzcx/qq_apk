package com.tencent.av.video.effect.filter;

import android.content.Context;
import com.tencent.av.video.effect.core.BaseRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import java.lang.ref.WeakReference;

public class FilterRender
  extends BaseRender
{
  private static final String TAG = "FilterRender";
  private WeakReference<Context> mContextReference;
  private QQAVImageFilter mFilter = null;
  private FilterFactory mFilterFactory;
  
  public FilterRender(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FilterRender(Context paramContext, String paramString)
  {
    this.mContextReference = new WeakReference(paramContext);
    this.mFilterFactory = new FilterFactory(paramContext);
    setFilterPath(paramString);
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.mFilter != null)
    {
      this.mFilter.destroy();
      this.mFilter = null;
    }
  }
  
  public int getFilterType()
  {
    if (this.mFilter != null) {
      return this.mFilter.getQQAVEffectType();
    }
    return -1;
  }
  
  public void preProcess(int paramInt1, int paramInt2)
  {
    baseProcess(paramInt1, paramInt2);
    if (this.mFilter != null) {
      this.mFilter.onOutputSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public EffectTexture process(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    EffectTexture localEffectTexture = super.process(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mFilter == null)
    {
      Log.d("FilterRender", "mFilter = null");
      CommonUtils.glCheckError();
      return localEffectTexture;
    }
    Log.d("FilterRender", "mFilter = " + this.mFilter + " | filterType = " + this.mFilter.getQQAVEffectType());
    this.mFilter.onOutputSizeChanged(this.mWidth, this.mHeight);
    this.mFilter.onDraw2(localEffectTexture.getTextureId(), this.mOutFbo);
    CommonUtils.glCheckError();
    return new EffectTexture(this.mOutTextureId, this.mOutFbo, this.mWidth, this.mHeight);
  }
  
  public void setFilterPath(String paramString)
  {
    Log.d("FilterRender", "setFilterPath filterPath = " + paramString);
    addTaskBeforeProcess(new FilterRender.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.filter.FilterRender
 * JD-Core Version:    0.7.0.1
 */