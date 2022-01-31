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
public class xhi
  extends VideoFilterBase
{
  public static final String a;
  public static final float[] a;
  public static final String b;
  float jdField_a_of_type_Float = 0.35F;
  int jdField_a_of_type_Int;
  Point jdField_a_of_type_AndroidGraphicsPoint;
  Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  Queue<DoodleMagicAlgoHandler.RenderPoint> jdField_a_of_type_JavaUtilQueue = new LinkedBlockingDeque();
  boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt = new int[1];
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  int d = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = FileUtils.loadAssetsString(AEModule.getContext(), "camera/camera_video/shader/DoodleFireworksAndLighterVertexShader.dat");
    jdField_b_of_type_JavaLangString = FileUtils.loadAssetsString(AEModule.getContext(), "camera/camera_video/shader/DoodleFireworksFragmentShader.dat");
    jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
  }
  
  public xhi()
  {
    super(jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString);
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
  
  private void b()
  {
    super.addParam(new UniformParam.IntParam("drawType", 0));
    super.setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    super.addAttribParam(new AttributeParam("inputBlendAlpha", jdField_a_of_type_ArrayOfFloat, 1));
  }
  
  public void ApplyGLSLFilter()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      super.ApplyGLSLFilter();
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.bindFrame(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0D);
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt)
  {
    UniformParam.TextureParam localTextureParam = new UniformParam.TextureParam("inputImageTexture2", this.jdField_c_of_type_Int, 33986);
    localTextureParam.initialParams(super.getProgramIds());
    super.addParam(localTextureParam);
    super.addParam(new UniformParam.IntParam("drawType", 0));
    a(paramInt, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    super.setPositions(AlgoUtils.calPositions(0.0F, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int + 0.0F, 0.0F, paramInt2, paramInt3));
    super.addParam(new UniformParam.Float2fParam("texAnchor", this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y));
    super.addParam(new UniformParam.FloatParam("texScale", 1.0F));
    super.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    GLES20.glFlush();
    super.OnDrawFrameGLSL();
    super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(DoodleMagicAlgoHandler.RenderPoint paramRenderPoint)
  {
    if (paramRenderPoint.xList.length != 0) {
      this.jdField_a_of_type_JavaUtilQueue.add(paramRenderPoint);
    }
  }
  
  public boolean a(List<PointF> paramList, boolean paramBoolean, xhl paramxhl)
  {
    GLES20.glBlendFuncSeparate(1, 771, 1, 1);
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.bindFrame(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0D);
    GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getFBO());
    GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if ((this.d == 0) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.bindFrame(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0D);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16640);
      GLES20.glFlush();
    }
    int i = this.d;
    PointF localPointF;
    if (i < paramList.size())
    {
      localPointF = (PointF)paramList.get(i);
      localPointF = new PointF(localPointF.x + this.jdField_a_of_type_AndroidGraphicsPoint.x, localPointF.y + this.jdField_a_of_type_AndroidGraphicsPoint.y);
      if (i == 0)
      {
        this.jdField_b_of_type_Float = localPointF.x;
        this.jdField_c_of_type_Float = localPointF.y;
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
      localPointF = new PointF(this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int / 2);
      paramList = new PointF(paramList.x + localPointF.x, paramList.y + localPointF.y);
      if ((paramList.x == this.jdField_b_of_type_Float) && (paramList.y == this.jdField_c_of_type_Float))
      {
        paramList.x += 1.0F;
        paramList.y += 1.0F;
      }
      DoodleMagicAlgoHandler.onTouchEvent(2, paramList.x, paramList.y);
      this.d = 0;
      this.jdField_b_of_type_Float = -1.0F;
      this.jdField_b_of_type_Float = -1.0F;
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      while (!this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        paramList = (DoodleMagicAlgoHandler.RenderPoint)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (paramList != null)
        {
          paramxhl.a.add(paramList);
          b(paramList);
        }
      }
      this.d = (paramList.size() - 1);
    }
    return true;
  }
  
  public void b(DoodleMagicAlgoHandler.RenderPoint paramRenderPoint)
  {
    a(paramRenderPoint, 4);
    super.OnDrawFrameGLSL();
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.jdField_c_of_type_Int);
    GLES20.glDrawArrays(5, 0, paramRenderPoint.xList.length);
    GLES20.glFlush();
    b();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    super.addAttribParam(new AttributeParam("inputBlendAlpha", jdField_a_of_type_ArrayOfFloat, 1));
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
    UniformParam.TextureParam localTextureParam = new UniformParam.TextureParam("inputImageTexture2", this.jdField_c_of_type_Int, 33986);
    localTextureParam.initialParams(super.getProgramIds());
    super.addParam(localTextureParam);
    a(paramInt1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    return true;
  }
  
  public void updatePreview(Object paramObject) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(paramInt1 / 2, paramInt2 / 2);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    super.addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
    DoodleMagicAlgoHandler.OnUpdateSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float);
    DoodleMagicAlgoHandler.setFilter(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xhi
 * JD-Core Version:    0.7.0.1
 */