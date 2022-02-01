import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.mobileqq.shortvideo.ptvfilter.DoodleMagicAlgoHandler;
import com.tencent.mobileqq.shortvideo.ptvfilter.DoodleMagicAlgoHandler.RenderPoint;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

@TargetApi(9)
public class aymq
  extends VideoFilterBase
{
  public static final String aAA = FileUtils.loadAssetsString(AEModule.getContext(), "camera/camera_video/shader/DoodleFireworksAndLighterVertexShader.dat");
  public static final String aAB = FileUtils.loadAssetsString(AEModule.getContext(), "camera/camera_video/shader/DoodleFireworksFragmentShader.dat");
  public static final float[] aF = { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
  boolean aHS;
  boolean aHT = false;
  private boolean aHU;
  int brI;
  int brJ;
  int brK = -1;
  int brL = 0;
  Point c;
  int[] ec = new int[1];
  Frame mRenderFrame = new Frame();
  float no = 0.35F;
  float np;
  float nq;
  Queue<DoodleMagicAlgoHandler.RenderPoint> u = new LinkedBlockingDeque();
  
  public aymq()
  {
    super(aAA, aAB);
    initParams();
  }
  
  private void a(DoodleMagicAlgoHandler.RenderPoint paramRenderPoint, int paramInt)
  {
    int i1 = 0;
    super.addParam(new UniformParam.IntParam("drawType", paramInt));
    int i2 = paramRenderPoint.xList.length;
    float[] arrayOfFloat1 = new float[i2 * 2];
    float[] arrayOfFloat2 = new float[i2];
    int m = 0;
    paramInt = 0;
    int i = 0;
    int k = i;
    int j = paramInt;
    int n = i1;
    if (m < i2)
    {
      if (paramRenderPoint.aList[m] <= 0.8F) {
        break label305;
      }
      k = i + 1;
      arrayOfFloat1[i] = paramRenderPoint.xList[m];
      arrayOfFloat1[k] = paramRenderPoint.yList[m];
      j = paramInt + 1;
      arrayOfFloat2[paramInt] = paramRenderPoint.aList[m];
      i = k + 1;
      paramInt = j;
    }
    label296:
    label305:
    for (;;)
    {
      m += 1;
      break;
      if (n < i2)
      {
        if (paramRenderPoint.aList[n] > 0.8F) {
          break label296;
        }
        i = k + 1;
        arrayOfFloat1[k] = paramRenderPoint.xList[n];
        arrayOfFloat1[i] = paramRenderPoint.yList[n];
        paramInt = j + 1;
        arrayOfFloat2[j] = paramRenderPoint.aList[n];
        i += 1;
      }
      for (;;)
      {
        n += 1;
        k = i;
        j = paramInt;
        break;
        super.setPositions(arrayOfFloat1);
        super.setTexCords(arrayOfFloat1);
        super.addAttribParam(new AttributeParam("inputBlendAlpha", arrayOfFloat2, 1));
        super.addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
        super.addParam(new UniformParam.FloatParam("texScale", 1.0F));
        super.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
        return;
        i = k;
        paramInt = j;
      }
    }
  }
  
  private void buG()
  {
    super.addParam(new UniformParam.IntParam("drawType", 0));
    super.setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    super.addAttribParam(new AttributeParam("inputBlendAlpha", aF, 1));
  }
  
  public void ApplyGLSLFilter()
  {
    if (!this.aHU)
    {
      this.aHU = true;
      super.ApplyGLSLFilter();
    }
  }
  
  public void a(DoodleMagicAlgoHandler.RenderPoint paramRenderPoint)
  {
    if (paramRenderPoint.xList.length != 0) {
      this.u.add(paramRenderPoint);
    }
  }
  
  public boolean a(List<PointF> paramList, boolean paramBoolean, aymt paramaymt)
  {
    GLES20.glBlendFuncSeparate(1, 771, 1, 1);
    this.mRenderFrame.bindFrame(this.ec[0], this.brI, this.brJ, 1.0D);
    GLES20.glBindFramebuffer(36160, this.mRenderFrame.getFBO());
    GLES20.glViewport(0, 0, this.brI, this.brJ);
    if ((this.brL == 0) && (this.aHS))
    {
      this.mRenderFrame.bindFrame(this.ec[0], this.brI, this.brJ, 1.0D);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16640);
      GLES20.glFlush();
    }
    int i = this.brL;
    PointF localPointF;
    if (i < paramList.size())
    {
      localPointF = (PointF)paramList.get(i);
      localPointF = new PointF(localPointF.x + this.c.x, localPointF.y + this.c.y);
      if (i == 0)
      {
        this.np = localPointF.x;
        this.nq = localPointF.y;
        DoodleMagicAlgoHandler.onTouchEvent(0, localPointF.x, localPointF.y);
      }
      for (;;)
      {
        i += 1;
        break;
        DoodleMagicAlgoHandler.onTouchEvent(1, localPointF.x, localPointF.y);
      }
    }
    if (paramBoolean)
    {
      paramList = (PointF)paramList.get(paramList.size() - 1);
      localPointF = new PointF(this.brI / 2, this.brJ / 2);
      paramList = new PointF(paramList.x + localPointF.x, paramList.y + localPointF.y);
      if ((paramList.x == this.np) && (paramList.y == this.nq))
      {
        paramList.x += 1.0F;
        paramList.y += 1.0F;
      }
      DoodleMagicAlgoHandler.onTouchEvent(2, paramList.x, paramList.y);
      this.brL = 0;
      this.np = -1.0F;
      this.np = -1.0F;
    }
    for (;;)
    {
      this.aHT = paramBoolean;
      while (!this.u.isEmpty())
      {
        paramList = (DoodleMagicAlgoHandler.RenderPoint)this.u.poll();
        if (paramList != null)
        {
          paramaymt.ny.add(paramList);
          b(paramList);
        }
      }
      this.brL = (paramList.size() - 1);
    }
    return true;
  }
  
  public void ac(int paramInt1, int paramInt2, int paramInt3)
  {
    super.setPositions(AlgoUtils.calPositions(0.0F, this.brJ, this.brI + 0.0F, 0.0F, paramInt2, paramInt3));
    super.addParam(new UniformParam.Float2fParam("texAnchor", this.c.x, this.c.y));
    super.addParam(new UniformParam.FloatParam("texScale", 1.0F));
    super.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    GLES20.glFlush();
    super.OnDrawFrameGLSL();
    super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void b(DoodleMagicAlgoHandler.RenderPoint paramRenderPoint)
  {
    a(paramRenderPoint, 4);
    super.OnDrawFrameGLSL();
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.brK);
    GLES20.glDrawArrays(5, 0, paramRenderPoint.xList.length);
    GLES20.glFlush();
    buG();
  }
  
  public void buF()
  {
    if (!this.aHS)
    {
      GLES20.glGenTextures(this.ec.length, this.ec, 0);
      this.mRenderFrame.bindFrame(this.ec[0], this.brI, this.brJ, 1.0D);
      this.brK = this.mRenderFrame.getTextureId();
      this.aHS = true;
    }
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    super.addAttribParam(new AttributeParam("inputBlendAlpha", aF, 1));
  }
  
  public void initParams()
  {
    super.addParam(new UniformParam.IntParam("texNeedTransform", 1));
    super.addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    super.addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
    super.addParam(new UniformParam.FloatParam("texScale", 1.0F));
    super.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    super.addParam(new UniformParam.FloatParam("positionRotate", 0.0F));
    super.addParam(new UniformParam.IntParam("blendMode", -1));
    super.addParam(new UniformParam.IntParam("drawType", 0));
    super.addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glBlendFuncSeparate(770, 771, 1, 1);
    UniformParam.TextureParam localTextureParam = new UniformParam.TextureParam("inputImageTexture2", this.brK, 33986);
    localTextureParam.initialParams(super.getProgramIds());
    super.addParam(localTextureParam);
    ac(paramInt1, this.brI, this.brJ);
    return true;
  }
  
  public void updatePreview(Object paramObject) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.c = new Point(paramInt1 / 2, paramInt2 / 2);
    this.brI = paramInt1;
    this.brJ = paramInt2;
    super.addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
    DoodleMagicAlgoHandler.OnUpdateSize(this.brI, this.brJ, this.no);
    DoodleMagicAlgoHandler.setFilter(this);
  }
  
  public void xy(int paramInt)
  {
    UniformParam.TextureParam localTextureParam = new UniformParam.TextureParam("inputImageTexture2", this.brK, 33986);
    localTextureParam.initialParams(super.getProgramIds());
    super.addParam(localTextureParam);
    super.addParam(new UniformParam.IntParam("drawType", 0));
    ac(paramInt, this.brI, this.brJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aymq
 * JD-Core Version:    0.7.0.1
 */