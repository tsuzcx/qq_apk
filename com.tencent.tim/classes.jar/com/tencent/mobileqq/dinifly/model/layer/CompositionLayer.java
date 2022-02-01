package com.tencent.mobileqq.dinifly.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.util.LongSparseArray;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LayerInfo;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositionLayer
  extends BaseLayer
{
  @Nullable
  private Boolean hasMasks;
  @Nullable
  private Boolean hasMatte;
  private BaseLayer layer;
  private final List<BaseLayer> layers = new ArrayList();
  private final RectF newClipRect = new RectF();
  private final RectF rect = new RectF();
  @Nullable
  private BaseKeyframeAnimation<Float, Float> timeRemapping;
  
  public CompositionLayer(LottieDrawable paramLottieDrawable, Layer paramLayer, List<Layer> paramList, LottieComposition paramLottieComposition)
  {
    super(paramLottieDrawable, paramLayer);
    paramLayer = paramLayer.getTimeRemapping();
    LongSparseArray localLongSparseArray;
    label103:
    Layer localLayer;
    if (paramLayer != null)
    {
      this.timeRemapping = paramLayer.createAnimation();
      addAnimation(this.timeRemapping);
      this.timeRemapping.addUpdateListener(this);
      localLongSparseArray = new LongSparseArray(paramLottieComposition.getLayers().size());
      i = paramList.size() - 1;
      paramLayer = null;
      if (i < 0) {
        break label275;
      }
      localLayer = (Layer)paramList.get(i);
      this.layer = BaseLayer.forModel(localLayer, paramLottieDrawable, paramLottieComposition);
      if (this.layer != null) {
        break label157;
      }
    }
    for (;;)
    {
      i -= 1;
      break label103;
      this.timeRemapping = null;
      break;
      label157:
      localLongSparseArray.put(this.layer.getLayerModel().getId(), this.layer);
      if (paramLayer != null)
      {
        paramLayer.setMatteLayer(this.layer);
        paramLayer = null;
      }
      else
      {
        this.layer.parentComposition = this;
        this.layerCount += this.layer.layerCount;
        this.layers.add(0, this.layer);
        switch (CompositionLayer.1.$SwitchMap$com$tencent$mobileqq$dinifly$model$layer$Layer$MatteType[localLayer.getMatteType().ordinal()])
        {
        default: 
          break;
        case 1: 
        case 2: 
          paramLayer = this.layer;
        }
      }
    }
    label275:
    int i = 0;
    if (i < localLongSparseArray.size())
    {
      paramLottieDrawable = (BaseLayer)localLongSparseArray.get(localLongSparseArray.keyAt(i));
      if (paramLottieDrawable == null) {}
      for (;;)
      {
        i += 1;
        break;
        paramLayer = (BaseLayer)localLongSparseArray.get(paramLottieDrawable.getLayerModel().getParentId());
        if (paramLayer != null) {
          paramLottieDrawable.setParentLayer(paramLayer);
        }
      }
    }
  }
  
  private void collectLayers(LayerInfo paramLayerInfo, int paramInt)
  {
    if (paramInt > paramLayerInfo.maxDepth)
    {
      paramLayerInfo.maxDepth = paramInt;
      paramLayerInfo.deepestLayer = this;
    }
    Iterator localIterator = this.layers.iterator();
    while (localIterator.hasNext())
    {
      BaseLayer localBaseLayer = (BaseLayer)localIterator.next();
      if ((localBaseLayer instanceof CompositionLayer)) {
        ((CompositionLayer)localBaseLayer).collectLayers(paramLayerInfo, paramInt + 1);
      }
    }
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    super.addValueCallback(paramT, paramLottieValueCallback);
    if (paramT == LottieProperty.TIME_REMAP)
    {
      if (paramLottieValueCallback == null) {
        this.timeRemapping = null;
      }
    }
    else {
      return;
    }
    this.timeRemapping = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
    addAnimation(this.timeRemapping);
  }
  
  public void collectLayers(LayerInfo paramLayerInfo)
  {
    paramLayerInfo.maxDepth = -1;
    collectLayers(paramLayerInfo, 0);
    ArrayDeque localArrayDeque = new ArrayDeque(paramLayerInfo.maxDepth);
    for (Object localObject = paramLayerInfo.deepestLayer; ((CompositionLayer)localObject).parentComposition != null; localObject = ((CompositionLayer)localObject).parentComposition) {
      localArrayDeque.push(((CompositionLayer)localObject).layerModel.getRefId());
    }
    localObject = new StringBuilder("root");
    while (!localArrayDeque.isEmpty())
    {
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append((String)localArrayDeque.pop());
    }
    paramLayerInfo.layerCount = this.layerCount;
    paramLayerInfo.longestPath = ((StringBuilder)localObject).toString();
  }
  
  void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    L.beginSection("CompositionLayer#draw");
    paramCanvas.save();
    this.newClipRect.set(0.0F, 0.0F, this.layerModel.getPreCompWidth(), this.layerModel.getPreCompHeight());
    paramMatrix.mapRect(this.newClipRect);
    int i = this.layers.size() - 1;
    while (i >= 0)
    {
      boolean bool = true;
      if (!this.newClipRect.isEmpty()) {
        bool = paramCanvas.clipRect(this.newClipRect);
      }
      if (bool) {
        ((BaseLayer)this.layers.get(i)).draw(paramCanvas, paramMatrix, paramInt);
      }
      i -= 1;
    }
    paramCanvas.restore();
    L.endSection("CompositionLayer#draw");
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    super.getBounds(paramRectF, paramMatrix, paramBoolean);
    int i = this.layers.size() - 1;
    while (i >= 0)
    {
      this.rect.set(0.0F, 0.0F, 0.0F, 0.0F);
      ((BaseLayer)this.layers.get(i)).getBounds(this.rect, this.boundsMatrix, true);
      paramRectF.union(this.rect);
      i -= 1;
    }
  }
  
  public BaseLayer getLayer()
  {
    return this.layer;
  }
  
  public boolean hasMasks()
  {
    if (this.hasMasks == null)
    {
      int i = this.layers.size() - 1;
      while (i >= 0)
      {
        BaseLayer localBaseLayer = (BaseLayer)this.layers.get(i);
        if ((localBaseLayer instanceof ShapeLayer))
        {
          if (localBaseLayer.hasMasksOnThisLayer())
          {
            this.hasMasks = Boolean.valueOf(true);
            return true;
          }
        }
        else if (((localBaseLayer instanceof CompositionLayer)) && (((CompositionLayer)localBaseLayer).hasMasks()))
        {
          this.hasMasks = Boolean.valueOf(true);
          return true;
        }
        i -= 1;
      }
      this.hasMasks = Boolean.valueOf(false);
    }
    return this.hasMasks.booleanValue();
  }
  
  public boolean hasMatte()
  {
    if (this.hasMatte == null)
    {
      if (hasMatteOnThisLayer())
      {
        this.hasMatte = Boolean.valueOf(true);
        return true;
      }
      int i = this.layers.size() - 1;
      while (i >= 0)
      {
        if (((BaseLayer)this.layers.get(i)).hasMatteOnThisLayer())
        {
          this.hasMatte = Boolean.valueOf(true);
          return true;
        }
        i -= 1;
      }
      this.hasMatte = Boolean.valueOf(false);
    }
    return this.hasMatte.booleanValue();
  }
  
  protected void resolveChildKeyPath(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2)
  {
    int i = 0;
    while (i < this.layers.size())
    {
      ((BaseLayer)this.layers.get(i)).resolveKeyPath(paramKeyPath1, paramInt, paramList, paramKeyPath2);
      i += 1;
    }
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    super.setProgress(paramFloat);
    if (this.timeRemapping != null)
    {
      paramFloat = (float)this.lottieDrawable.getComposition().getDuration();
      paramFloat = (float)(((Float)this.timeRemapping.getValue()).floatValue() * 1000.0F) / paramFloat;
    }
    float f = paramFloat;
    if (this.layerModel.getTimeStretch() != 0.0F) {
      f = paramFloat / this.layerModel.getTimeStretch();
    }
    paramFloat = this.layerModel.getStartProgress();
    int i = this.layers.size() - 1;
    while (i >= 0)
    {
      ((BaseLayer)this.layers.get(i)).setProgress(f - paramFloat);
      i -= 1;
    }
  }
  
  public String toString()
  {
    return "CompositionLayer{refId=" + this.layerModel.getRefId() + ", layerCount=" + this.layerCount + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.CompositionLayer
 * JD-Core Version:    0.7.0.1
 */