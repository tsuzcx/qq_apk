package com.tencent.ttpic.openapi.filter.MaskStickerFilter;

import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.filter.FaceLineFilter;
import com.tencent.ttpic.util.FrameUtil;
import java.util.List;

public class CircleMaskFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision mediump float;\n varying vec2 grayTextureCoordinate;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture2;\nuniform int drawTypeFragment;\nvoid main(void) {\n    vec4 whiteColor = vec4(1.0, 1.0, 1.0, 1.0);\n    vec4 canvasColor = texture2D(inputImageTexture, textureCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, grayTextureCoordinate);\n    gl_FragColor = vec4(whiteColor.rgb, mix(canvasColor.a,1.0,texColor.a));\n}\n";
  private static final String TAG = FaceLineFilter.class.getSimpleName();
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate = inputGrayTextureCoordinate.xy;\n}\n";
  private boolean mIsDrawLines = true;
  private PointF mLastPoint;
  private Frame mMaskFrame = new Frame();
  private boolean mNeedMaksFrameClear = true;
  private String mPaintImagePath;
  private float[] mPaintPointList = new float[0];
  private int mPaintSize = 10;
  private int mPointCount = 0;
  private float[] mTextruePointList = new float[0];
  
  public CircleMaskFilter(int paramInt, String paramString)
  {
    super("attribute vec4 position;\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate = inputGrayTextureCoordinate.xy;\n}\n", "precision mediump float;\n varying vec2 grayTextureCoordinate;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture2;\nuniform int drawTypeFragment;\nvoid main(void) {\n    vec4 whiteColor = vec4(1.0, 1.0, 1.0, 1.0);\n    vec4 canvasColor = texture2D(inputImageTexture, textureCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, grayTextureCoordinate);\n    gl_FragColor = vec4(whiteColor.rgb, mix(canvasColor.a,1.0,texColor.a));\n}\n");
    this.mPaintImagePath = paramString;
    if (paramString == null) {}
    for (;;)
    {
      this.mIsDrawLines = bool;
      initParams();
      this.mPaintSize = paramInt;
      return;
      bool = false;
    }
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
  
  public void initAttribParams()
  {
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    setGrayCords(GlUtil.ORIGIN_TEX_COORDS);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.mPaintImagePath, 1), 33986, true));
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
      if (this.mLastPoint != null) {
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
      this.mPointCount = i;
      if (this.mLastPoint == null) {
        this.mLastPoint = new PointF();
      }
      this.mLastPoint.x = ((PointF)paramList.get(i - 1)).x;
      this.mLastPoint.y = ((PointF)paramList.get(i - 1)).y;
      setPositions(this.mPaintPointList);
      setCoordNum(paramList.size());
    }
  }
  
  public void setTouchPointsByTriangles(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    int j = 0;
    if ((paramList != null) && (paramList.size() > 0))
    {
      PointF localPointF;
      if (this.mLastPoint != null)
      {
        localPointF = (PointF)paramList.get(0);
        float f1 = localPointF.x - this.mLastPoint.x;
        float f2 = localPointF.y - this.mLastPoint.y;
        if (Math.abs(f2 * f2 + f1 * f1) > 9.0F) {
          paramList.add(0, this.mLastPoint);
        }
      }
      if (paramList.size() * 12 > this.mPaintPointList.length)
      {
        this.mPaintPointList = new float[paramList.size() * 12];
        this.mTextruePointList = new float[paramList.size() * 12];
      }
      int k = 0;
      int i = 0;
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
      this.mPointCount = i;
      if (this.mLastPoint == null) {
        this.mLastPoint = new PointF();
      }
      this.mLastPoint.x = ((PointF)paramList.get(i - 1)).x;
      this.mLastPoint.y = ((PointF)paramList.get(i - 1)).y;
      setPositions(this.mPaintPointList);
      setGrayCords(this.mTextruePointList);
      setCoordNum(paramList.size() * 6);
    }
  }
  
  public void updatePoints()
  {
    float[] arrayOfFloat = new float[12];
    float[] tmp6_5 = arrayOfFloat;
    tmp6_5[0] = 0.25F;
    float[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 0.25F;
    float[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 0.25F;
    float[] tmp21_16 = tmp16_11;
    tmp21_16[3] = -0.25F;
    float[] tmp26_21 = tmp21_16;
    tmp26_21[4] = -0.25F;
    float[] tmp31_26 = tmp26_21;
    tmp31_26[5] = -0.25F;
    float[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 0.25F;
    float[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 0.25F;
    float[] tmp48_42 = tmp42_36;
    tmp48_42[8] = -0.25F;
    float[] tmp54_48 = tmp48_42;
    tmp54_48[9] = -0.25F;
    float[] tmp60_54 = tmp54_48;
    tmp60_54[10] = -0.25F;
    float[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 0.25F;
    tmp66_60;
    setPositions(arrayOfFloat);
    setCoordNum(arrayOfFloat.length / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.MaskStickerFilter.CircleMaskFilter
 * JD-Core Version:    0.7.0.1
 */