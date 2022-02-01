package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CartoonStylePreProcessFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = " precision highp float;\n void main()\n {\n     gl_FragColor = vec4(0.0, 0.0, 1.0, 1.0);\n }\n";
  public static final String VERTEX_SHADER = "attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}";
  List<Float> lineVertexFloats = new ArrayList();
  private boolean mNoPoints = true;
  List<Float> pointsVertexFloats = new ArrayList();
  
  public CartoonStylePreProcessFilter()
  {
    super("attribute vec4 position;\n\nvoid main() {\n    gl_Position = position;\n}", " precision highp float;\n void main()\n {\n     gl_FragColor = vec4(0.0, 0.0, 1.0, 1.0);\n }\n");
  }
  
  private void drawLineToListFromP1AndP2(PointF paramPointF1, PointF paramPointF2)
  {
    this.lineVertexFloats.add(Float.valueOf(paramPointF1.x * 2.0F / this.width - 1.0F));
    this.lineVertexFloats.add(Float.valueOf(paramPointF1.y * 2.0F / this.height - 1.0F));
    this.lineVertexFloats.add(Float.valueOf(paramPointF2.x * 2.0F / this.width - 1.0F));
    this.lineVertexFloats.add(Float.valueOf(paramPointF2.y * 2.0F / this.height - 1.0F));
  }
  
  private void getCartoonFacePoints(List<PointF> paramList)
  {
    int j = 0;
    int i = 0;
    while (i < 18)
    {
      drawLineToListFromP1AndP2((PointF)paramList.get(i), (PointF)paramList.get(i + 1));
      i += 1;
    }
    Object localObject = new PointF[3];
    i = 20;
    while (i < 23)
    {
      localObject[(i - 20)] = getMiddleByP1AndP2((PointF)paramList.get(i), (PointF)paramList.get(46 - i));
      i += 1;
    }
    drawLineToListFromP1AndP2((PointF)paramList.get(19), localObject[0]);
    drawLineToListFromP1AndP2(localObject[0], localObject[1]);
    drawLineToListFromP1AndP2(localObject[1], localObject[2]);
    drawLineToListFromP1AndP2(localObject[2], (PointF)paramList.get(23));
    i = 28;
    while (i < 31)
    {
      localObject[(i - 28)] = getMiddleByP1AndP2((PointF)paramList.get(i), (PointF)paramList.get(62 - i));
      i += 1;
    }
    drawLineToListFromP1AndP2((PointF)paramList.get(27), localObject[0]);
    drawLineToListFromP1AndP2(localObject[0], localObject[1]);
    drawLineToListFromP1AndP2(localObject[1], localObject[2]);
    drawLineToListFromP1AndP2(localObject[2], (PointF)paramList.get(31));
    drawLineToListFromP1AndP2(getMiddleByP1AndP2((PointF)paramList.get(56), (PointF)paramList.get(62)), (PointF)paramList.get(64));
    localObject = getMiddleByP1AndP2((PointF)paramList.get(65), (PointF)paramList.get(82));
    PointF localPointF = getMiddleByP1AndP2((PointF)paramList.get(66), (PointF)paramList.get(80));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new PointF(((PointF)localObject).x, ((PointF)localObject).y));
    localArrayList.add(paramList.get(82));
    localArrayList.add(paramList.get(81));
    localArrayList.add(paramList.get(80));
    localArrayList.add(new PointF(localPointF.x, localPointF.y));
    localArrayList.add(paramList.get(72));
    localArrayList.add(paramList.get(73));
    localArrayList.add(paramList.get(74));
    localArrayList.add(new PointF(((PointF)localObject).x, ((PointF)localObject).y));
    i = j;
    while (i < localArrayList.size() - 1)
    {
      drawLineToListFromP1AndP2((PointF)localArrayList.get(i), (PointF)localArrayList.get(i + 1));
      i += 1;
    }
  }
  
  private PointF getMiddleByP1AndP2(PointF paramPointF1, PointF paramPointF2)
  {
    paramPointF1.x = ((paramPointF1.x + paramPointF2.x) * 0.5F);
    paramPointF1.y = ((paramPointF1.y + paramPointF2.y) * 0.5F);
    return paramPointF1;
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
    float[] arrayOfFloat = new float[this.lineVertexFloats.size()];
    Iterator localIterator = this.lineVertexFloats.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Float localFloat = (Float)localIterator.next();
      if (localFloat != null) {}
      for (float f = localFloat.floatValue();; f = 0.0F)
      {
        arrayOfFloat[i] = f;
        i += 1;
        break;
      }
    }
    if (!this.mNoPoints)
    {
      GLES20.glLineWidth(4.0F);
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.LINES);
      setCoordNum(arrayOfFloat.length / 2);
      setPositions(arrayOfFloat);
      GlUtil.setBlendMode(true);
      OnDrawFrameGLSL();
      renderTexture(paramInt1, paramInt2, paramInt3);
      GlUtil.setBlendMode(false);
      this.lineVertexFloats.clear();
    }
  }
  
  public void updatePoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if (paramList == null)
    {
      this.mNoPoints = true;
      return;
    }
    this.mNoPoints = false;
    this.width = paramInt1;
    this.height = paramInt2;
    getCartoonFacePoints(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.CartoonStylePreProcessFilter
 * JD-Core Version:    0.7.0.1
 */