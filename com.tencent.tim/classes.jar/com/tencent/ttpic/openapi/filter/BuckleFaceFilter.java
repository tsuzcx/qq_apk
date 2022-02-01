package com.tencent.ttpic.openapi.filter;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.BuckleFaceItem;
import com.tencent.ttpic.openapi.model.BuckleFrameItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuckleFaceFilter
  extends VideoFilterBase
{
  public static final String FACE_CROP_FRAGMENT = "precision mediump float;\nvarying lowp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\n\nvoid main(void) {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
  public static final String FACE_CROP_VERTEX = "precision highp float;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(void) {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
  private float[] attrPositions = new float[8];
  private float[] attrTexCoords = new float[8];
  private List<PointF> faceCheckPoint = new ArrayList();
  private BuckleFaceItem mBuckleItem;
  private boolean needRender;
  private List<NormalVideoFilter> normalFilters;
  private List<RenderItem> normalRenderItems;
  
  public BuckleFaceFilter(BuckleFaceItem paramBuckleFaceItem, String paramString)
  {
    super(BaseFilter.nativeDecrypt("precision highp float;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(void) {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}"), BaseFilter.nativeDecrypt("precision mediump float;\nvarying lowp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\n\nvoid main(void) {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}"));
    if ((paramBuckleFaceItem == null) || (paramBuckleFaceItem.frameList.size() <= 0)) {
      throw new IllegalArgumentException("BuckleFaceFilter| items length error!");
    }
    this.needRender = false;
    this.mBuckleItem = paramBuckleFaceItem;
  }
  
  private static float distanceOf(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private static float radians2DEGREES(float paramFloat)
  {
    return (float)(180.0F * paramFloat / 3.141592653589793D);
  }
  
  private void updateParams(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0)) {
      this.needRender = false;
    }
    Object localObject1;
    float f1;
    float f2;
    Object localObject2;
    float f5;
    PointF localPointF;
    float f3;
    float f4;
    do
    {
      return;
      localObject1 = (BuckleFrameItem)this.mBuckleItem.frameList.get(paramInt);
      double d1 = localObject1.size[0];
      double d2 = localObject1.size[1];
      double d3 = localObject1.nosePoint[0];
      double d4 = localObject1.nosePoint[1];
      paramFloat = (float)Math.min(d1 / this.width, d2 / this.height);
      f1 = (float)(d1 / paramFloat);
      f2 = (float)(d2 / paramFloat);
      localObject2 = new PointF((f1 - this.width) / 2.0F, (f2 - this.height) / 2.0F);
      f5 = (float)(((BuckleFrameItem)localObject1).faceWidth / paramFloat);
      f1 = (float)(d3 / paramFloat - ((PointF)localObject2).x);
      f2 = (float)(d4 / paramFloat - ((PointF)localObject2).y);
      localObject2 = FaceOffUtil.getFullCoords(paramList, 3.0F);
      if ((localObject2 == null) || (((List)localObject2).isEmpty()))
      {
        this.needRender = false;
        return;
      }
      paramList = ((List)localObject2).iterator();
      while (paramList.hasNext())
      {
        localPointF = (PointF)paramList.next();
        localPointF.x = ((float)(localPointF.x / this.mFaceDetScale));
        localPointF.y = ((float)(localPointF.y / this.mFaceDetScale));
      }
      paramFloat = distanceOf((PointF)((List)localObject2).get(0), (PointF)((List)localObject2).get(18));
      f3 = ((PointF)((List)localObject2).get(64)).x;
      f4 = ((PointF)((List)localObject2).get(64)).y;
      paramList = new ArrayList();
      paramList.add(((List)localObject2).get(99));
      paramList.add(((List)localObject2).get(105));
      paramList.add(((List)localObject2).get(101));
      paramList.add(((List)localObject2).get(103));
      this.faceCheckPoint.add(((List)localObject2).get(9));
      this.faceCheckPoint.add(((List)localObject2).get(86));
      this.faceCheckPoint.add(((List)localObject2).get(88));
      this.faceCheckPoint.add(((List)localObject2).get(0));
      this.faceCheckPoint.add(((List)localObject2).get(18));
      localObject2 = this.faceCheckPoint.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localPointF = (PointF)((Iterator)localObject2).next();
        if ((localPointF.x < 0.0F) || (localPointF.y < 0.0F) || (localPointF.x >= this.width) || (localPointF.y >= this.height)) {
          this.needRender = false;
        }
      }
      this.faceCheckPoint.clear();
    } while (!this.needRender);
    float f6 = f5 / paramFloat;
    float f7 = paramArrayOfFloat[1];
    paramFloat = 0.0F;
    if (Math.abs(f7) > 0.2D) {
      if (f7 <= 0.0F) {
        break label825;
      }
    }
    label825:
    for (paramFloat = (f7 - 0.2F) * f5;; paramFloat = (0.2F + f7) * f5)
    {
      localObject2 = new Matrix();
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).postRotate(radians2DEGREES((float)(paramArrayOfFloat[2] - ((BuckleFrameItem)localObject1).faceAngle)), f3, f4);
      ((Matrix)localObject2).postScale(f6, f6, f3, f4);
      ((Matrix)localObject2).postTranslate(f1 - f3, f2 - f4);
      ((Matrix)localObject2).postTranslate(paramFloat, 0.0F);
      paramArrayOfFloat = new ArrayList();
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localPointF = (PointF)((Iterator)localObject1).next();
        float[] arrayOfFloat = new float[2];
        ((Matrix)localObject2).mapPoints(arrayOfFloat, new float[] { localPointF.x, localPointF.y });
        paramArrayOfFloat.add(new PointF(arrayOfFloat[0], arrayOfFloat[1]));
      }
    }
    int i = 0;
    paramInt = 0;
    while (paramInt < 4)
    {
      localObject1 = (PointF)paramArrayOfFloat.get(paramInt);
      this.attrPositions[i] = (2.0F * ((PointF)localObject1).x / this.width - 1.0F);
      this.attrPositions[(i + 1)] = (((PointF)localObject1).y * 2.0F / this.height - 1.0F);
      localObject1 = (PointF)paramList.get(paramInt);
      this.attrTexCoords[i] = (((PointF)localObject1).x / this.width);
      this.attrTexCoords[(i + 1)] = (((PointF)localObject1).y / this.height);
      i += 2;
      paramInt += 1;
    }
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
    setRenderMode(0);
    setPositions(this.attrPositions);
    setTexCords(this.attrTexCoords);
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
  }
  
  public void initParams() {}
  
  public boolean isNeedRender()
  {
    return this.needRender;
  }
  
  public void setNormalRenderItems(List<RenderItem> paramList)
  {
    this.normalRenderItems = paramList;
  }
  
  public void updatePreview(Object paramObject)
  {
    label51:
    int j;
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      int i;
      if (!CollectionUtils.isEmpty(this.normalRenderItems))
      {
        bool = true;
        this.needRender = bool;
        if (this.normalRenderItems == null) {
          break label196;
        }
        Iterator localIterator = this.normalRenderItems.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label198;
        }
        AEFilterI localAEFilterI = ((RenderItem)localIterator.next()).filter;
        j = i;
        if ((localAEFilterI instanceof NormalVideoFilter))
        {
          localAEFilterI.updatePreview(paramObject);
          j = i;
          if (!((NormalVideoFilter)localAEFilterI).getStickerItem().id.equals("bgm"))
          {
            j = i;
            if (((NormalVideoFilter)localAEFilterI).getStickerItem().frameDuration == this.mBuckleItem.frameDuration)
            {
              j = ((NormalVideoFilter)localAEFilterI).getLastFrameIndex();
              if ((!this.needRender) || (!((NormalVideoFilter)localAEFilterI).isRenderReady())) {
                break label190;
              }
            }
          }
        }
      }
      label190:
      for (boolean bool = true;; bool = false)
      {
        this.needRender = bool;
        i = j;
        break label51;
        bool = false;
        break;
      }
      label196:
      j = 0;
      label198:
      if ((this.needRender) && (!CollectionUtils.indexOutOfBounds(this.mBuckleItem.frameList, j))) {}
    }
    else
    {
      return;
    }
    updateParams(paramObject.facePoints, paramObject.faceAngles, paramObject.phoneAngle, j);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BuckleFaceFilter
 * JD-Core Version:    0.7.0.1
 */