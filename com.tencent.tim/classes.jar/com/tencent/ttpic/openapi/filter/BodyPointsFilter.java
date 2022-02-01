package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import java.util.List;

public class BodyPointsFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = " precision highp float;\n void main()\n {\n     gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n }\n";
  public static final String VERTEX_SHADER = "attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}";
  private int BODY_POINTS_COUNT = 59;
  float[] lineVertex = new float[this.BODY_POINTS_COUNT * 4];
  private boolean mNoPoints = true;
  float[] pointsVertex = new float[this.BODY_POINTS_COUNT * 2];
  
  public BodyPointsFilter()
  {
    super("attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}", " precision highp float;\n void main()\n {\n     gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n }\n");
  }
  
  private void normalizePoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    int j = 0;
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size() - 1)
      {
        this.lineVertex[(i * 4 + 0)] = (((PointF)paramList.get(i)).x * 2.0F / paramInt1 - 1.0F);
        this.lineVertex[(i * 4 + 1)] = (((PointF)paramList.get(i)).y * 2.0F / paramInt2 - 1.0F);
        this.lineVertex[(i * 4 + 2)] = (((PointF)paramList.get(i + 1)).x * 2.0F / paramInt1 - 1.0F);
        this.lineVertex[(i * 4 + 3)] = (((PointF)paramList.get(i + 1)).y * 2.0F / paramInt2 - 1.0F);
        i += 1;
      }
      i = paramList.size() - 1;
      this.lineVertex[(i * 4 + 0)] = (((PointF)paramList.get(i)).x * 2.0F / paramInt1 - 1.0F);
      this.lineVertex[(i * 4 + 1)] = (((PointF)paramList.get(i)).y * 2.0F / paramInt2 - 1.0F);
      this.lineVertex[(i * 4 + 2)] = (((PointF)paramList.get(0)).x * 2.0F / paramInt1 - 1.0F);
      this.lineVertex[(i * 4 + 3)] = (((PointF)paramList.get(0)).y * 2.0F / paramInt2 - 1.0F);
      i = j;
      while (i < paramList.size())
      {
        this.pointsVertex[(i * 2)] = (((PointF)paramList.get(i)).x * 2.0F / paramInt1 - 1.0F);
        this.pointsVertex[(i * 2 + 1)] = (((PointF)paramList.get(i)).y * 2.0F / paramInt2 - 1.0F);
        i += 1;
      }
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
  }
  
  public void initAttribParams()
  {
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
  }
  
  public void initParams() {}
  
  public void render(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.mNoPoints)
    {
      GLES20.glLineWidth(4.0F);
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.LINES);
      setCoordNum(this.BODY_POINTS_COUNT * 2);
      setPositions(this.lineVertex);
      GlUtil.setBlendMode(true);
      OnDrawFrameGLSL();
      renderTexture(paramInt1, paramInt2, paramInt3);
      GlUtil.setBlendMode(false);
      GLES20.glLineWidth(8.0F);
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.POINTS);
      setCoordNum(this.BODY_POINTS_COUNT);
      setPositions(this.pointsVertex);
      GlUtil.setBlendMode(true);
      OnDrawFrameGLSL();
      renderTexture(paramInt1, paramInt2, paramInt3);
      GlUtil.setBlendMode(false);
    }
  }
  
  public void setBodyPointsSize(int paramInt)
  {
    this.BODY_POINTS_COUNT = paramInt;
  }
  
  public void updatePoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList == null) || (paramList.size() != this.BODY_POINTS_COUNT))
    {
      this.mNoPoints = true;
      return;
    }
    this.mNoPoints = false;
    normalizePoints(paramList, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BodyPointsFilter
 * JD-Core Version:    0.7.0.1
 */