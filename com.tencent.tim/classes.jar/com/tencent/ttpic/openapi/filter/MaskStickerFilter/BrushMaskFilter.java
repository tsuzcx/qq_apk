package com.tencent.ttpic.openapi.filter.MaskStickerFilter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.filter.FaceLineFilter;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FrameUtil;
import java.util.ArrayList;
import java.util.List;

public class BrushMaskFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision mediump float;\n varying vec2 grayTextureCoordinate;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture2;\nuniform int drawTypeFragment;\nuniform int maskType;\nvoid main(void) {\n    if (drawTypeFragment == 1) {// 纯色笔触画到画布\n        gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);\n    } else if (drawTypeFragment == 2) {// 纯色笔触把画布融合到画面\n        vec4 texColor = texture2D(inputImageTexture2, grayTextureCoordinate);\n        gl_FragColor = vec4(texColor.rgb, texColor.a);\n    }\n}\n";
  private static final int LINE_POINT_GAP = 200;
  private static final String TAG = FaceLineFilter.class.getSimpleName();
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate = inputGrayTextureCoordinate.xy;\n}\n";
  private boolean mIsDrawLines = true;
  private PointF mLastPoint;
  private long mLastUpdateTime;
  private Frame mMaskFrame = new Frame();
  private int mMaskType = 1;
  private boolean mNeedMaksFrameClear = true;
  private String mPaintImagePath;
  private float[] mPaintPointList = new float[0];
  private int mPaintSize = 10;
  private float[] mTextruePointList = new float[0];
  
  public BrushMaskFilter(int paramInt1, int paramInt2, String paramString)
  {
    super("attribute vec4 position;\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate = inputGrayTextureCoordinate.xy;\n}\n", "precision mediump float;\n varying vec2 grayTextureCoordinate;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture2;\nuniform int drawTypeFragment;\nuniform int maskType;\nvoid main(void) {\n    if (drawTypeFragment == 1) {// 纯色笔触画到画布\n        gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);\n    } else if (drawTypeFragment == 2) {// 纯色笔触把画布融合到画面\n        vec4 texColor = texture2D(inputImageTexture2, grayTextureCoordinate);\n        gl_FragColor = vec4(texColor.rgb, texColor.a);\n    }\n}\n");
    String str = paramString;
    if (paramString == null) {
      str = FaceOffUtil.getMaskBrushPointPath();
    }
    this.mPaintImagePath = str;
    if (this.mPaintImagePath == null) {}
    for (;;)
    {
      this.mIsDrawLines = bool;
      initParams();
      this.mPaintSize = paramInt2;
      this.mMaskType = paramInt1;
      return;
      bool = false;
    }
  }
  
  private double caculateDistance(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF1.x - paramPointF2.x;
    float f2 = paramPointF1.y - paramPointF2.y;
    return Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private ArrayList<PointF> check2Points(PointF paramPointF1, PointF paramPointF2)
  {
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = localArrayList2;
    if (paramPointF1 != null)
    {
      localArrayList1 = localArrayList2;
      if (paramPointF2 != null)
      {
        if (this.mPaintSize != 0) {
          break label33;
        }
        localArrayList1 = localArrayList2;
      }
    }
    label33:
    double d;
    do
    {
      return localArrayList1;
      d = caculateDistance(paramPointF1, paramPointF2);
      localArrayList1 = localArrayList2;
    } while (d <= this.mPaintSize * 0.5F);
    int j = (int)Math.ceil(2.0D * d / this.mPaintSize);
    localArrayList2 = new ArrayList();
    float f1 = (paramPointF2.x - paramPointF1.x) / j;
    float f2 = (paramPointF2.y - paramPointF1.y) / j;
    int i = 1;
    for (;;)
    {
      localArrayList1 = localArrayList2;
      if (i >= j) {
        break;
      }
      localArrayList2.add(new PointF(paramPointF1.x + i * f1, paramPointF1.y + i * f2));
      i += 1;
    }
  }
  
  private List<PointF> insertPoints(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() < 2)) {}
    Object localObject1;
    do
    {
      return paramList;
      Object localObject2 = (PointF)paramList.get(0);
      localObject1 = null;
      int i = 1;
      while (i < paramList.size())
      {
        PointF localPointF = (PointF)paramList.get(i);
        ArrayList localArrayList = check2Points((PointF)localObject2, localPointF);
        localObject2 = localObject1;
        if (localArrayList != null)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList(paramList.subList(0, i - 1));
          }
          ((ArrayList)localObject2).addAll(localArrayList);
        }
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(localPointF);
        }
        i += 1;
        localObject1 = localObject2;
        localObject2 = localPointF;
      }
    } while (localObject1 == null);
    return localObject1;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    if (this.mIsDrawLines) {
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.LINES_STRIP);
    }
    for (;;)
    {
      this.mNeedMaksFrameClear = true;
      return;
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    }
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    if (this.mMaskFrame != null) {
      this.mMaskFrame.clear();
    }
  }
  
  public int getMaskType()
  {
    return this.mMaskType;
  }
  
  public void initAttribParams()
  {
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    setGrayCords(GlUtil.ORIGIN_TEX_COORDS);
  }
  
  public void initParams()
  {
    if (this.mIsDrawLines) {}
    for (int i = 1;; i = 2)
    {
      addParam(new UniformParam.IntParam("drawTypeFragment", i));
      addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.mPaintImagePath, 1), 33986, true));
      return;
    }
  }
  
  public Frame render(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mNeedMaksFrameClear)
    {
      this.mNeedMaksFrameClear = false;
      FrameUtil.clearFrame(this.mMaskFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramInt2, paramInt3);
    }
    this.mMaskFrame.bindFrame(-1, this.mMaskFrame.width, this.mMaskFrame.height, 0.0D);
    GlUtil.setBlendMode(true);
    OnDrawFrameGLSL();
    renderTexture(this.mMaskFrame.getTextureId(), paramInt2, paramInt3);
    GlUtil.setBlendMode(false);
    return this.mMaskFrame;
  }
  
  public void reset()
  {
    this.mNeedMaksFrameClear = true;
  }
  
  public void setTouchPoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if (this.mIsDrawLines)
    {
      setTouchPointsByLines(paramList, paramInt1, paramInt2);
      return;
    }
    setTouchPointsByTriangles(paramList, paramInt1, paramInt2);
  }
  
  public void setTouchPointsByLines(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if ((this.mLastPoint != null) && (System.currentTimeMillis() - this.mLastUpdateTime < 200L)) {
        paramList.add(0, this.mLastPoint);
      }
      if (paramList.size() * 2 > this.mPaintPointList.length) {
        this.mPaintPointList = new float[paramList.size() * 2];
      }
      int j = 0;
      int k = 0;
      int i = 0;
      while (j < paramList.size())
      {
        PointF localPointF = (PointF)paramList.get(j);
        this.mPaintPointList[k] = ((localPointF.x - this.mPaintSize * 0.5F) * 2.0F / paramInt1 - 1.0F);
        this.mPaintPointList[(k + 1)] = ((localPointF.y - this.mPaintSize * 0.5F) * 2.0F / paramInt2 - 1.0F);
        k += 2;
        i += 1;
        j += 1;
      }
      if (this.mLastPoint == null) {
        this.mLastPoint = new PointF();
      }
      this.mLastUpdateTime = System.currentTimeMillis();
      this.mLastPoint.x = ((PointF)paramList.get(i - 1)).x;
      this.mLastPoint.y = ((PointF)paramList.get(i - 1)).y;
      setPositions(this.mPaintPointList);
      setCoordNum(paramList.size());
      GLES20.glLineWidth(this.mPaintSize);
    }
  }
  
  public void setTouchPointsByTriangles(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      PointF localPointF;
      if ((this.mLastPoint != null) && (System.currentTimeMillis() - this.mLastUpdateTime < 200L))
      {
        localPointF = (PointF)paramList.get(0);
        float f1 = localPointF.x - this.mLastPoint.x;
        float f2 = localPointF.y - this.mLastPoint.y;
        if (Math.abs(f2 * f2 + f1 * f1) > 9.0F) {
          paramList.add(0, this.mLastPoint);
        }
      }
      paramList = insertPoints(paramList);
      if (paramList.size() * 12 > this.mPaintPointList.length)
      {
        this.mPaintPointList = new float[paramList.size() * 12];
        this.mTextruePointList = new float[paramList.size() * 12];
      }
      int i = 0;
      int k = 0;
      int j = 0;
      while (j < paramList.size())
      {
        localPointF = (PointF)paramList.get(j);
        this.mPaintPointList[k] = ((localPointF.x + this.mPaintSize * 0.5F) * 2.0F / paramInt1 - 1.0F);
        this.mPaintPointList[(k + 1)] = ((localPointF.y + this.mPaintSize * 0.5F) * 2.0F / paramInt2 - 1.0F);
        this.mPaintPointList[(k + 2)] = ((localPointF.x + this.mPaintSize * 0.5F) * 2.0F / paramInt1 - 1.0F);
        this.mPaintPointList[(k + 3)] = ((localPointF.y - this.mPaintSize * 0.5F) * 2.0F / paramInt2 - 1.0F);
        this.mPaintPointList[(k + 4)] = ((localPointF.x - this.mPaintSize * 0.5F) * 2.0F / paramInt1 - 1.0F);
        this.mPaintPointList[(k + 5)] = ((localPointF.y - this.mPaintSize * 0.5F) * 2.0F / paramInt2 - 1.0F);
        this.mPaintPointList[(k + 6)] = this.mPaintPointList[k];
        this.mPaintPointList[(k + 7)] = this.mPaintPointList[(k + 1)];
        this.mPaintPointList[(k + 8)] = this.mPaintPointList[(k + 4)];
        this.mPaintPointList[(k + 9)] = this.mPaintPointList[(k + 5)];
        this.mPaintPointList[(k + 10)] = ((localPointF.x - this.mPaintSize * 0.5F) * 2.0F / paramInt1 - 1.0F);
        this.mPaintPointList[(k + 11)] = ((localPointF.y + this.mPaintSize * 0.5F) * 2.0F / paramInt2 - 1.0F);
        this.mTextruePointList[k] = 1.0F;
        this.mTextruePointList[(k + 1)] = 1.0F;
        this.mTextruePointList[(k + 2)] = 1.0F;
        this.mTextruePointList[(k + 3)] = 0.0F;
        this.mTextruePointList[(k + 4)] = 0.0F;
        this.mTextruePointList[(k + 5)] = 0.0F;
        this.mTextruePointList[(k + 6)] = 1.0F;
        this.mTextruePointList[(k + 7)] = 1.0F;
        this.mTextruePointList[(k + 8)] = 0.0F;
        this.mTextruePointList[(k + 9)] = 0.0F;
        this.mTextruePointList[(k + 10)] = 0.0F;
        this.mTextruePointList[(k + 11)] = 1.0F;
        k += 12;
        i += 1;
        j += 1;
      }
      if (this.mLastPoint == null) {
        this.mLastPoint = new PointF();
      }
      this.mLastUpdateTime = System.currentTimeMillis();
      this.mLastPoint.x = ((PointF)paramList.get(i - 1)).x;
      this.mLastPoint.y = ((PointF)paramList.get(i - 1)).y;
      setPositions(this.mPaintPointList);
      setGrayCords(this.mTextruePointList);
      setCoordNum(paramList.size() * 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.MaskStickerFilter.BrushMaskFilter
 * JD-Core Version:    0.7.0.1
 */