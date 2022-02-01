package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FastStaticSticker
  extends FastSticker
{
  private boolean initialized = false;
  private float ratio = 0.75F;
  private List<PointF> relativePivotsPts = new ArrayList();
  private List<PointF> relativePosPts = new ArrayList();
  
  public FastStaticSticker(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
    updateRelativeParams(0, this.ratio);
    this.renderParam.texScale = 1.0F;
  }
  
  private void updateRelativeParams(int paramInt, float paramFloat)
  {
    int j = 720;
    this.relativePivotsPts.clear();
    this.relativePosPts.clear();
    int i;
    label45:
    float f;
    if ((paramInt == 0) || (paramInt == 180))
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label398;
      }
      i = 720;
      if (paramInt != 0) {
        j = 960;
      }
      if (paramInt == 0) {
        break label406;
      }
      f = 0.75F;
      label61:
      if (paramFloat >= f) {
        break label412;
      }
      paramFloat = j * paramFloat;
      this.relativePivotsPts.add(new PointF(i / 2, j / 2));
      this.relativePivotsPts.add(new PointF((i - paramFloat) / 2.0F, 0.0F));
      this.relativePivotsPts.add(new PointF(i / 2, 0.0F));
      this.relativePivotsPts.add(new PointF(i - (i - paramFloat) / 2.0F, 0.0F));
      this.relativePivotsPts.add(new PointF((i - paramFloat) / 2.0F, j / 2));
      this.relativePivotsPts.add(new PointF(i - (i - paramFloat) / 2.0F, j / 2));
      this.relativePivotsPts.add(new PointF((i - paramFloat) / 2.0F, j));
      this.relativePivotsPts.add(new PointF(i / 2, j));
      this.relativePivotsPts.add(new PointF(i - (i - paramFloat) / 2.0F, j));
    }
    for (;;)
    {
      Iterator localIterator = this.relativePivotsPts.iterator();
      while (localIterator.hasNext())
      {
        PointF localPointF = (PointF)localIterator.next();
        this.relativePosPts.add(new PointF(localPointF.x / i, localPointF.y / j));
      }
      paramInt = 0;
      break;
      label398:
      i = 960;
      break label45;
      label406:
      f = 1.333333F;
      break label61;
      label412:
      paramFloat = i / paramFloat;
      this.relativePivotsPts.add(new PointF(i / 2, j / 2));
      this.relativePivotsPts.add(new PointF(0.0F, (j - paramFloat) / 2.0F));
      this.relativePivotsPts.add(new PointF(i / 2, (j - paramFloat) / 2.0F));
      this.relativePivotsPts.add(new PointF(i, (j - paramFloat) / 2.0F));
      this.relativePivotsPts.add(new PointF(0.0F, j / 2));
      this.relativePivotsPts.add(new PointF(i, j / 2));
      this.relativePivotsPts.add(new PointF(0.0F, j - (j - paramFloat) / 2.0F));
      this.relativePivotsPts.add(new PointF(i / 2, j - (j - paramFloat) / 2.0F));
      this.relativePivotsPts.add(new PointF(i, j - (j - paramFloat) / 2.0F));
    }
  }
  
  public void clearTextureParam()
  {
    super.clearTextureParam();
    this.initialized = false;
  }
  
  public void initPositionAdjusted(int paramInt)
  {
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2))
    {
      this.renderParam.position = GlUtil.EMPTY_POSITIONS_TRIANGLES;
      return;
    }
    int i;
    int m;
    int k;
    if (this.item.orienting)
    {
      i = paramInt;
      updateRelativeParams(i, this.ratio);
      m = this.item.width;
      k = this.item.height;
      if (this.item.type != VideoFilterFactory.POSITION_TYPE.RELATIVE.type) {
        break label1182;
      }
      if ((paramInt != 90) && (paramInt != 270)) {
        break label1654;
      }
      i = 720;
    }
    for (int j = 960;; j = 720)
    {
      Object localObject = this.relativePivotsPts;
      List localList = this.relativePosPts;
      label194:
      float[] arrayOfFloat;
      if (this.item.relativeScaleType == 0)
      {
        f1 = AlgoUtils.getDistance((PointF)((List)localObject).get(this.item.scalePivots[0]), (PointF)((List)localObject).get(this.item.scalePivots[1])) / this.item.scaleFactor;
        m = (int)(m * f1);
        k = (int)(k * f1);
        arrayOfFloat = new float[2];
        localObject = arrayOfFloat;
        if (this.item.alignFacePoints != null)
        {
          localObject = arrayOfFloat;
          if (this.item.alignFacePoints.length >= 1)
          {
            if (this.item.alignFacePoints.length != 1) {
              break label626;
            }
            localObject = arrayOfFloat;
            if (this.item.alignFacePoints[0] < localList.size()) {
              localObject = new float[] { ((PointF)localList.get(this.item.alignFacePoints[0])).x, ((PointF)localList.get(this.item.alignFacePoints[0])).y };
            }
          }
        }
        label337:
        if ((this.item.anchorPoint != null) && (this.item.anchorPoint.length >= 2))
        {
          this.item.position[0] = (localObject[0] - this.item.anchorPoint[0] * f1 / j);
          this.item.position[1] = (localObject[1] - f1 * this.item.anchorPoint[1] / i);
        }
        d2 = this.width / this.height;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label808;
        }
        d1 = 1.333333333333333D;
        label454:
        if (d2 < d1) {
          break label924;
        }
        f1 = this.width / j;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label815;
        }
      }
      label808:
      label815:
      for (paramInt = (int)(this.width * 0.75D);; paramInt = (int)(this.width / 0.75D))
      {
        j = (int)(paramInt * this.item.position[1]);
        i = (int)(this.width * this.item.position[0]);
        paramInt = j - (paramInt - this.height) / 2;
        if (this.item.scaleDirection != 0) {
          break label829;
        }
        localObject = this.renderParam;
        f2 = i;
        f3 = paramInt;
        f4 = k;
        f5 = i;
        ((RenderParam)localObject).position = AlgoUtils.calPositionsTriangles(f2, f3 + f4 * f1, f1 * m + f5, paramInt, this.width, this.height);
        return;
        i = 0;
        break;
        f1 = 1.0F;
        break label194;
        label626:
        localObject = arrayOfFloat;
        if (this.item.alignFacePoints.length != 2) {
          break label337;
        }
        localObject = arrayOfFloat;
        if (this.item.alignFacePoints[0] >= localList.size()) {
          break label337;
        }
        localObject = arrayOfFloat;
        if (this.item.alignFacePoints[1] >= localList.size()) {
          break label337;
        }
        f2 = ((PointF)localList.get(this.item.alignFacePoints[0])).x;
        f2 = (((PointF)localList.get(this.item.alignFacePoints[1])).x + f2) / 2.0F;
        f3 = ((PointF)localList.get(this.item.alignFacePoints[0])).y;
        localObject = new float[] { f2, (((PointF)localList.get(this.item.alignFacePoints[1])).y + f3) / 2.0F };
        break label337;
        d1 = 0.75D;
        break label454;
      }
      label829:
      float f2 = i;
      float f3 = paramInt;
      float f4 = k;
      float f5 = i;
      localObject = AlgoUtils.calPositionsTriangles(f2, f3 + f4 * f1, f1 * m + f5, paramInt, this.width, this.height);
      if (this.triggerCtrlItem == null) {
        break;
      }
      this.renderParam.position = AlgoUtils.adjustPositionTriangles((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection);
      return;
      label924:
      float f1 = this.height / i;
      if ((paramInt == 90) || (paramInt == 270)) {}
      for (paramInt = (int)(this.height / 0.75D);; paramInt = (int)(this.height * 0.75D))
      {
        i = (int)(this.height * this.item.position[1]);
        paramInt = (int)(paramInt * this.item.position[0]) - (paramInt - this.width) / 2;
        if (this.item.scaleDirection != 0) {
          break;
        }
        localObject = this.renderParam;
        f2 = paramInt;
        f3 = i;
        f4 = k;
        f5 = paramInt;
        ((RenderParam)localObject).position = AlgoUtils.calPositionsTriangles(f2, f3 + f4 * f1, f1 * m + f5, i, this.width, this.height);
        return;
      }
      f2 = paramInt;
      f3 = i;
      f4 = k;
      f5 = paramInt;
      localObject = AlgoUtils.calPositionsTriangles(f2, f3 + f4 * f1, f1 * m + f5, i, this.width, this.height);
      if (this.triggerCtrlItem == null) {
        break;
      }
      this.renderParam.position = AlgoUtils.adjustPositionTriangles((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection);
      return;
      label1182:
      if (this.width / this.height >= 0.75D)
      {
        d1 = this.width / 720.0D;
        i = (int)(this.width / 0.75D);
        j = (int)(i * this.item.position[1]);
        paramInt = (int)(this.width * this.item.position[0]);
        i = j - (i - this.height) / 2;
        if (this.item.scaleDirection == 0)
        {
          localObject = this.renderParam;
          f1 = paramInt;
          f2 = (float)(i + k * d1);
          d2 = paramInt;
          ((RenderParam)localObject).position = AlgoUtils.calPositionsTriangles(f1, f2, (float)(d1 * m + d2), i, this.width, this.height);
          return;
        }
        f1 = paramInt;
        f2 = (float)(i + k * d1);
        d2 = paramInt;
        localObject = AlgoUtils.calPositionsTriangles(f1, f2, (float)(d1 * m + d2), i, this.width, this.height);
        if (this.triggerCtrlItem == null) {
          break;
        }
        this.renderParam.position = AlgoUtils.adjustPositionTriangles((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection);
        return;
      }
      double d1 = this.height / 960.0D;
      i = (int)(this.height * 0.75D);
      paramInt = (int)(this.height * this.item.position[1]);
      i = (int)(i * this.item.position[0]) - (i - this.width) / 2;
      if (this.item.scaleDirection == 0)
      {
        localObject = this.renderParam;
        f1 = i;
        f2 = (float)(paramInt + k * d1);
        d2 = i;
        ((RenderParam)localObject).position = AlgoUtils.calPositionsTriangles(f1, f2, (float)(d1 * m + d2), paramInt, this.width, this.height);
        return;
      }
      f1 = i;
      f2 = (float)(paramInt + k * d1);
      double d2 = i;
      localObject = AlgoUtils.calPositionsTriangles(f1, f2, (float)(d1 * m + d2), paramInt, this.width, this.height);
      if (this.triggerCtrlItem == null) {
        break;
      }
      this.renderParam.position = AlgoUtils.adjustPositionTriangles((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection);
      return;
      label1654:
      i = 960;
    }
  }
  
  public void setRatio(float paramFloat)
  {
    this.ratio = paramFloat;
  }
  
  public void updatePositions(List<PointF> paramList)
  {
    if (this.initialized) {
      return;
    }
    initPositionAdjusted(0);
  }
  
  protected void updatePositions(List<PointF> paramList, int paramInt) {}
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    if (this.initialized) {
      return;
    }
    initPositionAdjusted(0);
  }
  
  protected void updatePositionsForMultiAnchor(List<PointF> paramList, int paramInt)
  {
    if (this.initialized) {
      return;
    }
    initPositionAdjusted(0);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if ((this.width != paramInt1) || (this.height != paramInt2)) {
      initPositionAdjusted(0);
    }
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.model.FastStaticSticker
 * JD-Core Version:    0.7.0.1
 */