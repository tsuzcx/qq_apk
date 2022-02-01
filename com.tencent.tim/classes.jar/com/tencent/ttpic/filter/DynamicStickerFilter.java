package com.tencent.ttpic.filter;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import java.util.List;

public class DynamicStickerFilter
  extends NormalVideoFilter
{
  private static final int LENTH_POINTS_ANGLE = 4;
  private static final String TAG = DynamicStickerFilter.class.getSimpleName();
  private Point canvasCenter;
  private float[] mPositions = new float[8];
  private float[] mTexCoords = new float[8];
  
  public DynamicStickerFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  private boolean checkArrayLength(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfInt == null) || (paramInt == 0)) {
      return false;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label36;
      }
      if (paramArrayOfInt[i] >= paramInt) {
        break;
      }
      i += 1;
    }
    label36:
    return true;
  }
  
  public static boolean isValidItem(StickerItem paramStickerItem)
  {
    if (paramStickerItem == null) {}
    while ((paramStickerItem.alignFacePoints == null) || (paramStickerItem.alignFacePoints.length <= 0) || (paramStickerItem.anchorPoint == null) || (paramStickerItem.anchorPoint.length < 2) || (paramStickerItem.scalePivots == null) || (paramStickerItem.scalePivots.length < 2)) {
      return false;
    }
    return true;
  }
  
  private boolean isValidPoint(Point paramPoint)
  {
    if (paramPoint == null) {}
    while ((paramPoint.x < 0) || (paramPoint.x > this.width) || (paramPoint.y < 0) || (paramPoint.y > this.height)) {
      return false;
    }
    return true;
  }
  
  public void initParams()
  {
    super.initParams();
    addParam(new UniformParam.IntParam("texNeedTransform", 1));
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("texScale", 1.0F));
    addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
  }
  
  public boolean isBodyNeeded()
  {
    return this.item.type == VideoFilterFactory.POSITION_TYPE.BODY.type;
  }
  
  protected void updateCatFacePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    super.updatePositions(paramList);
    if ((CollectionUtils.isEmpty(paramList)) || (!isValidItem(this.item))) {
      clearTextureParam();
    }
    int i;
    do
    {
      return;
      localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
      if (this.item.alignFacePoints.length != 1) {
        break;
      }
      i = this.item.alignFacePoints[0];
      PointF localPointF2 = (PointF)paramList.get(i);
      localPointF1 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      float f1 = localPointF1.x - this.item.anchorPoint[0];
      float f2 = localPointF1.y - this.item.anchorPoint[1];
      float f3 = this.item.width;
      setPositions(AlgoUtils.adjustPosition(AlgoUtils.calPositions(f1, this.item.height + f2, f1 + f3, f2, this.width, this.height), this.audioScaleFactor));
      addParam(new UniformParam.Float2fParam("texAnchor", localPointF1.x - this.canvasCenter.x, localPointF1.y - this.canvasCenter.y));
    } while ((paramList.size() <= this.item.scalePivots[0]) || (paramList.size() <= this.item.scalePivots[1]));
    PointF localPointF1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
    paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
    double d1 = Math.pow(localPointF1.x - paramList.x, 2.0D);
    d1 = Math.sqrt(Math.pow(localPointF1.y - paramList.y, 2.0D) + d1) / this.item.scaleFactor;
    double d2;
    if (this.item.maxScaledWidth != 0)
    {
      d2 = this.item.maxScaledWidth / this.item.width;
      if (d1 > d2) {
        d1 = d2;
      }
    }
    for (;;)
    {
      d2 = d1;
      if (this.item.minScaledWidth != 0)
      {
        double d3 = this.item.minScaledWidth / this.item.width;
        d2 = d1;
        if (d1 < d3) {
          d2 = d3;
        }
      }
      addParam(new UniformParam.FloatParam("texScale", (float)d2));
      addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, (float)(paramArrayOfFloat[0] + 3.141592653589793D + Math.toRadians(paramFloat))));
      return;
      i = this.item.alignFacePoints[1];
      break;
    }
  }
  
  protected void updatePositions(List<PointF> paramList)
  {
    super.updatePositions(paramList);
    if ((CollectionUtils.isEmpty(paramList)) || (!isValidItem(this.item))) {
      clearTextureParam();
    }
    label199:
    label861:
    label867:
    for (;;)
    {
      return;
      PointF localPointF1;
      PointF localPointF2;
      float f1;
      float f2;
      float f3;
      float f4;
      double d1;
      if ((VideoMaterialUtil.isGestureItem(this.item)) && (paramList.size() > 22))
      {
        localPointF1 = (PointF)paramList.get(14);
        localPointF2 = (PointF)paramList.get(22);
        if ((localPointF1 != null) && (localPointF2 != null))
        {
          f1 = localPointF1.x;
          f2 = localPointF1.y;
          f3 = localPointF2.x;
          f4 = localPointF2.y;
          if (f1 < f3) {
            d1 = Math.atan2(f4 - f2, f3 - f1);
          }
        }
      }
      for (;;)
      {
        if (!checkArrayLength(this.item.alignFacePoints, paramList.size())) {
          break label867;
        }
        localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
        int i;
        double d2;
        double d3;
        if (this.item.alignFacePoints.length == 1)
        {
          i = this.item.alignFacePoints[0];
          localPointF2 = (PointF)paramList.get(i);
          PointF localPointF3 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
          f1 = localPointF3.x - this.item.anchorPoint[0];
          f2 = localPointF3.y - this.item.anchorPoint[1];
          f3 = this.item.width;
          setPositions(AlgoUtils.adjustPosition(AlgoUtils.calPositions(f1, this.item.height + f2, f1 + f3, f2, this.width, this.height), this.audioScaleFactor));
          addParam(new UniformParam.Float2fParam("texAnchor", localPointF3.x - this.canvasCenter.x, localPointF3.y - this.canvasCenter.y));
          if ((paramList.size() <= this.item.scalePivots[0]) || (paramList.size() <= this.item.scalePivots[1])) {
            break;
          }
          localPointF3 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
          paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
          d2 = Math.pow(localPointF3.x - paramList.x, 2.0D);
          d2 = Math.sqrt(Math.pow(localPointF3.y - paramList.y, 2.0D) + d2) / this.item.scaleFactor;
          if (this.item.maxScaledWidth == 0) {
            break label861;
          }
          d3 = this.item.maxScaledWidth / this.item.width;
          if (d2 <= d3) {
            break label861;
          }
          d2 = d3;
        }
        for (;;)
        {
          d3 = d2;
          if (this.item.minScaledWidth != 0)
          {
            double d4 = this.item.minScaledWidth / this.item.width;
            d3 = d2;
            if (d2 < d4) {
              d3 = d4;
            }
          }
          addParam(new UniformParam.FloatParam("texScale", (float)d3));
          if (this.item.alignFacePoints.length > 1)
          {
            f2 = (float)Math.atan2(localPointF1.y - localPointF2.y, localPointF1.x - localPointF2.x);
            f3 = this.item.angle;
            if ((VideoMaterialUtil.isGestureItem(this.item)) && (this.item.needHandRotation == 1)) {}
            for (f1 = 0.0F;; f1 = (float)d1)
            {
              addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, f1 + (f2 - f3)));
              return;
              d1 = Math.atan2(f2 - f4, f1 - f3);
              break;
              i = this.item.alignFacePoints[1];
              break label199;
            }
          }
          if ((!VideoMaterialUtil.isGestureItem(this.item)) || (this.item.needHandRotation != 1)) {
            break;
          }
          addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, this.item.angle + (float)d1));
          return;
        }
        d1 = 0.0D;
      }
    }
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3) || (!isValidItem(this.item)))
    {
      clearTextureParam();
      return;
    }
    PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
    int i;
    double d1;
    double d2;
    if (this.item.alignFacePoints.length == 1)
    {
      i = this.item.alignFacePoints[0];
      PointF localPointF2 = (PointF)paramList.get(i);
      localPointF1 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      if (VideoMaterialUtil.isFaceItem(this.item))
      {
        localPointF1.x = ((float)(localPointF1.x / this.mFaceDetScale));
        localPointF1.y = ((float)(localPointF1.y / this.mFaceDetScale));
      }
      paramFloat = localPointF1.x - this.item.anchorPoint[0];
      float f1 = localPointF1.y - this.item.anchorPoint[1];
      float f2 = this.item.width;
      setPositions(AlgoUtils.adjustPosition(AlgoUtils.calPositions(paramFloat, this.item.height + f1, paramFloat + f2, f1, this.width, this.height), this.audioScaleFactor));
      addParam(new UniformParam.Float2fParam("texAnchor", localPointF1.x - this.canvasCenter.x, localPointF1.y - this.canvasCenter.y));
      localPointF1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      if (VideoMaterialUtil.isFaceItem(this.item))
      {
        localPointF1.x = ((float)(localPointF1.x / this.mFaceDetScale));
        localPointF1.y = ((float)(localPointF1.y / this.mFaceDetScale));
      }
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      if (VideoMaterialUtil.isFaceItem(this.item))
      {
        paramList.x = ((float)(paramList.x / this.mFaceDetScale));
        paramList.y = ((float)(paramList.y / this.mFaceDetScale));
      }
      d1 = Math.pow(localPointF1.x - paramList.x, 2.0D);
      d1 = Math.sqrt(Math.pow(localPointF1.y - paramList.y, 2.0D) + d1) / this.item.scaleFactor;
      if (this.item.maxScaledWidth == 0) {
        break label725;
      }
      d2 = this.item.maxScaledWidth / this.item.width;
      if (d1 <= d2) {
        break label725;
      }
      d1 = d2;
    }
    label725:
    for (;;)
    {
      d2 = d1;
      if (this.item.minScaledWidth != 0)
      {
        double d3 = this.item.minScaledWidth / this.item.width;
        d2 = d1;
        if (d1 < d3) {
          d2 = d3;
        }
      }
      addParam(new UniformParam.FloatParam("texScale", (float)d2));
      if (this.item.support3D == 1)
      {
        addParam(new UniformParam.Float3fParam("texRotate", paramArrayOfFloat[0], paramArrayOfFloat[1], -paramArrayOfFloat[2] - this.item.angle));
        return;
        i = this.item.alignFacePoints[1];
        break;
      }
      addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, -paramArrayOfFloat[2] - this.item.angle));
      return;
    }
  }
  
  protected void updatePositionsForMultiAnchor(List<PointF> paramList, int paramInt)
  {
    super.updatePositionsForMultiAnchor(paramList, paramInt);
    if ((CollectionUtils.isEmpty(paramList)) || (!isValidItem(this.item)))
    {
      clearTextureParam();
      return;
    }
    PointF localPointF1;
    if (paramInt == 4)
    {
      paramInt = 0;
      while (paramInt < 4)
      {
        int i = this.item.anchorPoint[(paramInt * 2)];
        int j = this.item.anchorPoint[(paramInt * 2 + 1)];
        this.mTexCoords[(paramInt * 2)] = (i / this.item.width);
        this.mTexCoords[(paramInt * 2 + 1)] = (j / this.item.height);
        paramInt += 1;
      }
      paramInt = 0;
      while (paramInt < 4)
      {
        localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[paramInt]);
        this.mPositions[(paramInt * 2)] = ((float)(localPointF1.x / (this.width * this.mFaceDetScale) * 2.0D - 1.0D));
        this.mPositions[(paramInt * 2 + 1)] = ((float)(localPointF1.y / (this.height * this.mFaceDetScale) * 2.0D - 1.0D));
        paramInt += 1;
      }
      setPositions(this.mPositions);
      setTexCords(this.mTexCoords);
    }
    for (;;)
    {
      addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
      addParam(new UniformParam.FloatParam("texScale", 1.0F));
      addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
      return;
      if (paramInt == 2)
      {
        localPointF1 = new PointF(this.item.anchorPoint[0], this.item.anchorPoint[1]);
        Object localObject = new PointF(this.item.anchorPoint[2], this.item.anchorPoint[3]);
        PointF localPointF2 = (PointF)paramList.get(this.item.alignFacePoints[0]);
        PointF localPointF3 = (PointF)paramList.get(this.item.alignFacePoints[1]);
        paramList = new PointF((float)(localPointF2.x / this.mFaceDetScale), (float)(localPointF2.y / this.mFaceDetScale));
        localPointF2 = new PointF((float)(localPointF3.x / this.mFaceDetScale), (float)(localPointF3.y / this.mFaceDetScale));
        float f1 = AlgoUtils.getDistance(paramList, localPointF2) / AlgoUtils.getDistance(localPointF1, (PointF)localObject);
        this.mPositions[0] = 0.0F;
        this.mPositions[1] = 0.0F;
        this.mPositions[2] = (this.item.width * f1);
        this.mPositions[3] = 0.0F;
        this.mPositions[4] = (this.item.width * f1);
        this.mPositions[5] = (this.item.height * f1);
        this.mPositions[6] = 0.0F;
        this.mPositions[7] = (this.item.height * f1);
        this.mTexCoords[0] = 0.0F;
        this.mTexCoords[1] = 0.0F;
        this.mTexCoords[2] = 1.0F;
        this.mTexCoords[3] = 0.0F;
        this.mTexCoords[4] = 1.0F;
        this.mTexCoords[5] = 1.0F;
        this.mTexCoords[6] = 0.0F;
        this.mTexCoords[7] = 1.0F;
        float f2 = (float)Math.atan2(((PointF)localObject).y - localPointF1.y, ((PointF)localObject).x - localPointF1.x);
        float f3 = (float)Math.atan2(localPointF2.y - paramList.y, localPointF2.x - paramList.x);
        localObject = new Matrix();
        ((Matrix)localObject).postTranslate(-localPointF1.x * f1, f1 * -localPointF1.y);
        ((Matrix)localObject).postRotate((float)((f3 - f2) * 180.0F / 3.141592653589793D));
        ((Matrix)localObject).postTranslate(paramList.x, paramList.y);
        ((Matrix)localObject).mapPoints(this.mPositions);
        paramInt = 0;
        while (paramInt < 4)
        {
          this.mPositions[(paramInt * 2)] = (this.mPositions[(paramInt * 2)] / this.width * 2.0F - 1.0F);
          this.mPositions[(paramInt * 2 + 1)] = (this.mPositions[(paramInt * 2 + 1)] / this.height * 2.0F - 1.0F);
          paramInt += 1;
        }
        setPositions(this.mPositions);
        setTexCords(this.mTexCoords);
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.canvasCenter = new Point(paramInt1 / 2, paramInt2 / 2);
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.DynamicStickerFilter
 * JD-Core Version:    0.7.0.1
 */