package com.tencent.ttpic.openapi.filter.MaskStickerFilter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.util.ArrayList;
import java.util.List;

public class DoodleMaskFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform int drawTypeFragment;\nvoid main(void) {\n    if (drawTypeFragment == 1) {// 纯色笔触画到画布\n        vec4 brushColor = vec4(1.0, 1.0, 1.0, 1.0);\n        gl_FragColor = vec4(brushColor.rgb, 1.0);\n    } else if (drawTypeFragment == 2) {// 纯色笔触把画布融合到画面\n        vec4 texColor = texture2D(inputImageTexture, textureCoordinate);\n        gl_FragColor = texColor;\n    }\n}\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main() {\n    gl_Position = position;\n    gl_PointSize = 1.0;\n    textureCoordinate = inputTextureCoordinate.xy;\n}\n";
  private BaseFilter mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  private PointF mLastPoint = new PointF();
  private Frame mMaskFrame = new Frame();
  private String mPaintImagePath;
  private int mPaintSize = 10;
  private int mPointCount = 0;
  private List<float[]> paintAlphaList = new ArrayList();
  private List<float[]> paintPointList = new ArrayList();
  private List<float[]> paintTexPoseList = new ArrayList();
  
  public DoodleMaskFilter(int paramInt, String paramString)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main() {\n    gl_Position = position;\n    gl_PointSize = 1.0;\n    textureCoordinate = inputTextureCoordinate.xy;\n}\n", "precision mediump float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform int drawTypeFragment;\nvoid main(void) {\n    if (drawTypeFragment == 1) {// 纯色笔触画到画布\n        vec4 brushColor = vec4(1.0, 1.0, 1.0, 1.0);\n        gl_FragColor = vec4(brushColor.rgb, 1.0);\n    } else if (drawTypeFragment == 2) {// 纯色笔触把画布融合到画面\n        vec4 texColor = texture2D(inputImageTexture, textureCoordinate);\n        gl_FragColor = texColor;\n    }\n}\n");
    this.mPaintSize = paramInt;
    this.mPaintImagePath = paramString;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    this.mCopyFilter.apply();
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.mCopyFilter.clearGLSLSelf();
    this.mMaskFrame.clear();
  }
  
  public void initAttribParams()
  {
    setPositions(null);
  }
  
  public void initParams()
  {
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    addParam(new UniformParam.IntParam("drawTypeFragment", 2));
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture", BitmapUtils.decodeSampledBitmapFromFile(this.mPaintImagePath, 1), 33986, true));
  }
  
  public Frame renderProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < this.mPointCount)
    {
      float[] arrayOfFloat1 = (float[])this.paintPointList.get(i);
      float[] arrayOfFloat2 = (float[])this.paintTexPoseList.get(i);
      setPositions(arrayOfFloat1);
      setCoordNum(6);
      setTexCords(arrayOfFloat2);
      OnDrawFrameGLSL();
      GLES20.glDrawArrays(4, 0, this.mPointCount * 6);
      i += 1;
    }
    GLES20.glFlush();
    this.mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.mMaskFrame);
    return this.mMaskFrame;
  }
  
  public void setTouchPoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if (paramList != null)
    {
      paramList.add(0, this.mLastPoint);
      int i = 0;
      int j = 0;
      while (i < paramList.size())
      {
        PointF localPointF = (PointF)paramList.get(i);
        float[] arrayOfFloat = new float[12];
        arrayOfFloat[0] = ((localPointF.x - this.mPaintSize * 0.5F) * 2.0F / paramInt1 - 1.0F);
        arrayOfFloat[1] = ((localPointF.y - this.mPaintSize * 0.5F) * 2.0F / paramInt2 - 1.0F);
        arrayOfFloat[2] = ((localPointF.x + this.mPaintSize * 0.5F) * 2.0F / paramInt1 - 1.0F);
        arrayOfFloat[3] = ((localPointF.y - this.mPaintSize * 0.5F) * 2.0F / paramInt2 - 1.0F);
        arrayOfFloat[4] = ((localPointF.x - this.mPaintSize * 0.5F) * 2.0F / paramInt1 - 1.0F);
        arrayOfFloat[5] = ((localPointF.y + this.mPaintSize * 0.5F) * 2.0F / paramInt2 - 1.0F);
        arrayOfFloat[6] = arrayOfFloat[2];
        arrayOfFloat[7] = arrayOfFloat[3];
        arrayOfFloat[8] = arrayOfFloat[4];
        arrayOfFloat[9] = arrayOfFloat[5];
        arrayOfFloat[10] = ((localPointF.x + this.mPaintSize * 0.5F) * 2.0F / paramInt1 - 1.0F);
        arrayOfFloat[11] = ((localPointF.y + this.mPaintSize * 0.5F) * 2.0F / paramInt2 - 1.0F);
        this.paintPointList.add(arrayOfFloat);
        this.paintAlphaList.add(new float[] { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F });
        this.paintTexPoseList.add(new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
        j += 1;
        i += 1;
      }
      this.mPointCount = j;
      this.mLastPoint.x = ((PointF)paramList.get(j - 1)).x;
      this.mLastPoint.y = ((PointF)paramList.get(j - 1)).y;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.MaskStickerFilter.DoodleMaskFilter
 * JD-Core Version:    0.7.0.1
 */