package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import java.util.List;

public class HandBoxFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = " precision highp float;\n void main()\n {\n     gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n }\n";
  public static final String VERTEX_SHADER = "attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}";
  private boolean mNoPoints = true;
  private float[] pointsVertex = new float[16];
  
  public HandBoxFilter()
  {
    super("attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}", " precision highp float;\n void main()\n {\n     gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n }\n");
  }
  
  private void normalizePoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.pointsVertex[0] = (((PointF)paramList.get(1)).x * 2.0F / paramInt1 - 1.0F);
    this.pointsVertex[1] = (((PointF)paramList.get(1)).y * 2.0F / paramInt2 - 1.0F);
    this.pointsVertex[2] = (((PointF)paramList.get(3)).x * 2.0F / paramInt1 - 1.0F);
    this.pointsVertex[3] = (((PointF)paramList.get(3)).y * 2.0F / paramInt2 - 1.0F);
    this.pointsVertex[4] = (((PointF)paramList.get(3)).x * 2.0F / paramInt1 - 1.0F);
    this.pointsVertex[5] = (((PointF)paramList.get(3)).y * 2.0F / paramInt2 - 1.0F);
    this.pointsVertex[6] = (((PointF)paramList.get(8)).x * 2.0F / paramInt1 - 1.0F);
    this.pointsVertex[7] = (((PointF)paramList.get(8)).y * 2.0F / paramInt2 - 1.0F);
    this.pointsVertex[8] = (((PointF)paramList.get(8)).x * 2.0F / paramInt1 - 1.0F);
    this.pointsVertex[9] = (((PointF)paramList.get(8)).y * 2.0F / paramInt2 - 1.0F);
    this.pointsVertex[10] = (((PointF)paramList.get(6)).x * 2.0F / paramInt1 - 1.0F);
    this.pointsVertex[11] = (((PointF)paramList.get(6)).y * 2.0F / paramInt2 - 1.0F);
    this.pointsVertex[12] = (((PointF)paramList.get(6)).x * 2.0F / paramInt1 - 1.0F);
    this.pointsVertex[13] = (((PointF)paramList.get(6)).y * 2.0F / paramInt2 - 1.0F);
    this.pointsVertex[14] = (((PointF)paramList.get(1)).x * 2.0F / paramInt1 - 1.0F);
    this.pointsVertex[15] = (((PointF)paramList.get(1)).y * 2.0F / paramInt2 - 1.0F);
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
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.LINES);
      GLES20.glLineWidth(4.0F);
      GlUtil.setBlendMode(true);
      OnDrawFrameGLSL();
      renderTexture(paramInt1, paramInt2, paramInt3);
      GlUtil.setBlendMode(false);
    }
  }
  
  public void updatePoints(List<PointF> paramList, float paramFloat, int paramInt1, int paramInt2)
  {
    if ((paramList == null) || (paramList.size() != 9))
    {
      this.mNoPoints = true;
      return;
    }
    this.mNoPoints = false;
    normalizePoints(paramList, (int)(paramInt1 * paramFloat), (int)(paramInt2 * paramFloat));
    setCoordNum(8);
    setPositions(this.pointsVertex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.HandBoxFilter
 * JD-Core Version:    0.7.0.1
 */