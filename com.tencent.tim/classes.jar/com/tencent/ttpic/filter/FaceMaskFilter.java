package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.filter.FaceLineFilter;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import java.util.List;

public class FaceMaskFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = " precision highp float;\n varying vec2 grayTextureCoordinate;\n uniform sampler2D inputImageTexture2;\n void main(void) {\n    vec4 graycolor= texture2D(inputImageTexture2, grayTextureCoordinate);\n    float grayColorR=1.0-graycolor.r;\n    if(graycolor.r<0.981){\n        gl_FragColor = vec4(grayColorR,grayColorR,grayColorR,1.0);\n    }\n\n }";
  private static final String TAG = FaceLineFilter.class.getSimpleName();
  public static final String VERTEX_SHADER = "attribute vec4 position;\n\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate  = inputGrayTextureCoordinate.xy;\n}\n";
  private float[] faceVertices = new float[1380];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[1380];
  private boolean mIsNeedWhiteBg = false;
  
  public FaceMaskFilter()
  {
    super(BaseFilter.nativeDecrypt("attribute vec4 position;\n\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate  = inputGrayTextureCoordinate.xy;\n}\n"), BaseFilter.nativeDecrypt(" precision highp float;\n varying vec2 grayTextureCoordinate;\n uniform sampler2D inputImageTexture2;\n void main(void) {\n    vec4 graycolor= texture2D(inputImageTexture2, grayTextureCoordinate);\n    float grayColorR=1.0-graycolor.r;\n    if(graycolor.r<0.981){\n        gl_FragColor = vec4(grayColorR,grayColorR,grayColorR,1.0);\n    }\n\n }"));
    initParams();
  }
  
  private float[] facePointInit(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    int n = 88;
    if ((CollectionUtils.isEmpty(paramList)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      localObject = new float[0];
      return localObject;
    }
    Object localObject = (PointF)paramList.get(88);
    paramArrayOfFloat[0] = (((PointF)localObject).x / paramInt1 * 2.0F - 1.0F);
    paramArrayOfFloat[1] = (((PointF)localObject).y / paramInt2 * 2.0F - 1.0F);
    localObject = (PointF)paramList.get(86);
    paramArrayOfFloat[2] = (((PointF)localObject).x / paramInt1 * 2.0F - 1.0F);
    paramArrayOfFloat[3] = (((PointF)localObject).y / paramInt2 * 2.0F - 1.0F);
    int j = 0;
    int i = 4;
    int k;
    int m;
    for (;;)
    {
      k = n;
      m = i;
      if (j >= 19) {
        break;
      }
      localObject = (PointF)paramList.get(j);
      k = i + 1;
      paramArrayOfFloat[i] = (((PointF)localObject).x / paramInt1 * 2.0F - 1.0F);
      i = k + 1;
      paramArrayOfFloat[k] = (((PointF)localObject).y / paramInt2 * 2.0F - 1.0F);
      j += 1;
    }
    for (;;)
    {
      localObject = paramArrayOfFloat;
      if (k <= 86) {
        break;
      }
      localObject = (PointF)paramList.get(k);
      i = m + 1;
      paramArrayOfFloat[m] = (((PointF)localObject).x / paramInt1 * 2.0F - 1.0F);
      m = i + 1;
      paramArrayOfFloat[i] = (((PointF)localObject).y / paramInt2 * 2.0F - 1.0F);
      k -= 1;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  public void initAttribParams()
  {
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    addAttribParam("inputGrayTextureCoordinate", FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.getGrayCoords(FaceOffUtil.FEATURE_TYPE.FACE_HEAD_CROP), 3.0F), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
  }
  
  public void initParams()
  {
    Bitmap localBitmap = FaceOffUtil.getGrayBitmap(FaceOffUtil.FEATURE_TYPE.FACE_HEAD_CROP);
    this.grayImageWidth = localBitmap.getWidth();
    this.grayImageHeight = localBitmap.getHeight();
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, true));
  }
  
  public void render(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mIsNeedWhiteBg)
    {
      GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
      GLES20.glClear(16384);
    }
    GLES20.glLineWidth(3.0F);
    GlUtil.setBlendMode(true);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
    GlUtil.setBlendMode(false);
  }
  
  public void setWhiteBg(boolean paramBoolean)
  {
    this.mIsNeedWhiteBg = paramBoolean;
  }
  
  public void updatePoints(List<List<PointF>> paramList)
  {
    if (paramList.size() == 0)
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList((List)paramList.get(0)), 3.0F), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    setCoordNum(690);
  }
  
  public void updatePointsAngles(List<List<PointF>> paramList)
  {
    if (paramList.size() == 0)
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    paramList = VideoMaterialUtil.copyList((List)paramList.get(0));
    FaceOffUtil.getFullCoords(paramList, 2.0F);
    setPositions(facePointInit(paramList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    setCoordNum(23);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceMaskFilter
 * JD-Core Version:    0.7.0.1
 */