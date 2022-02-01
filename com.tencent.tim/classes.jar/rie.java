import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.model.DoodleItem;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rie
  extends VideoFilterBase
{
  private String aAC = "doodle_image";
  private boolean aHU;
  public int brM = 1080;
  public int brN = 1440;
  int brO;
  Point c;
  DoodleItem doodleItem;
  public int mScreenHeight = 480;
  public int mScreenWidth = 320;
  protected UniformParam.TextureBitmapParam mTextureParam;
  List<Bitmap> oR = new ArrayList();
  List<List<PointF>> oS = new ArrayList();
  
  public rie(DoodleItem paramDoodleItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_NORMAL));
    this.doodleItem = paramDoodleItem;
    initParams();
    sy(paramString);
  }
  
  private double a(PointF paramPointF1, PointF paramPointF2)
  {
    return Math.sqrt((paramPointF1.x - paramPointF2.x) * (paramPointF1.x - paramPointF2.x) + (paramPointF1.y - paramPointF2.y) * (paramPointF1.y - paramPointF2.y));
  }
  
  private void buH()
  {
    Object localObject = this.oR;
    int i = this.brO;
    this.brO = (i + 1);
    localObject = (Bitmap)((List)localObject).get(i % this.oR.size());
    if (this.mTextureParam != null)
    {
      this.mTextureParam.swapTextureBitmap((Bitmap)localObject);
      return;
    }
    this.mTextureParam = new UniformParam.TextureBitmapParam("inputImageTexture2", (Bitmap)localObject, 33986, false);
    this.mTextureParam.initialParams(super.getProgramIds());
    super.addParam(this.mTextureParam);
  }
  
  private void sy(String paramString)
  {
    int i = 0;
    this.brO = 0;
    if (i < this.doodleItem.count)
    {
      Bitmap localBitmap = BitmapUtils.decodeSampledBitmapFromFile(FileUtils.getRealPath(paramString + "/" + this.aAC + "/" + this.aAC + "_" + i + ".png"), 80, 80);
      if (BitmapUtils.isLegal(localBitmap)) {
        this.oR.add(localBitmap);
      }
      for (;;)
      {
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Personality", 2, "PersonalityImageFilter unlegal bitmap " + i);
        }
      }
    }
  }
  
  public void ApplyGLSLFilter()
  {
    if (!this.aHU)
    {
      this.aHU = true;
      super.ApplyGLSLFilter();
    }
  }
  
  public void initAttribParams()
  {
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
  }
  
  public void initParams()
  {
    super.addParam(new UniformParam.IntParam("texNeedTransform", 1));
    super.addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    super.addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
    super.addParam(new UniformParam.FloatParam("texScale", 1.0F));
    super.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    super.addParam(new UniformParam.FloatParam("positionRotate", 0.0F));
    super.addParam(new UniformParam.IntParam("blendMode", this.doodleItem.blendMode));
    super.addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
    super.addParam(new UniformParam.FloatParam("alpha", 1.0F));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.oS == null) || (this.oS.size() < 1) || (((List)this.oS.get(0)).size() < 1)) {
      return false;
    }
    this.brO = 0;
    Object localObject = null;
    paramInt2 = 0;
    while (paramInt2 < this.oS.size())
    {
      paramInt3 = 0;
      if (paramInt3 < ((List)this.oS.get(paramInt2)).size())
      {
        PointF localPointF = (PointF)((List)this.oS.get(paramInt2)).get(paramInt3);
        if ((localObject != null) && (a(localPointF, (PointF)localObject) <= Math.max(this.doodleItem.width, this.doodleItem.height) * 1.2D)) {}
        for (;;)
        {
          paramInt3 += 1;
          break;
          buH();
          float f1 = this.doodleItem.width * this.width / this.brM * 1.5F;
          float f2 = this.doodleItem.height * this.height / this.brN * 1.5F;
          float f3 = localPointF.x - f1 / 2.0F;
          float f4 = this.height - localPointF.y + f2 / 2.0F;
          super.setPositions(AlgoUtils.calPositions(f3, f4, f1 + f3, f4 - f2, this.width, this.height));
          super.addParam(new UniformParam.Float2fParam("texAnchor", -this.c.x, this.c.y));
          super.addParam(new UniformParam.FloatParam("texScale", 1.0F));
          super.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
          GLES20.glFlush();
          super.OnDrawFrameGLSL();
          super.renderTexture(paramInt1, this.width, this.height);
          localObject = localPointF;
        }
      }
      paramInt2 += 1;
    }
    return true;
  }
  
  public void setTouchPoints(List<PointF> paramList)
  {
    this.oS = new ArrayList(1);
    if (this.oR.size() < 1) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PointF localPointF = (PointF)paramList.next();
      localArrayList.add(new PointF(localPointF.x + this.c.x, localPointF.y + this.c.y));
    }
    this.oS.add(localArrayList);
  }
  
  public void updatePreview(Object paramObject) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.c = new Point(paramInt1 / 2, paramInt2 / 2);
    super.addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rie
 * JD-Core Version:    0.7.0.1
 */