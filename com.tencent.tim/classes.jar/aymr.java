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
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.DoodleItem;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aymr
  extends VideoFilterBase
{
  private String aAC = "doodle_image";
  private boolean aHU;
  public int brM = 1080;
  public int brN = 1440;
  Point c;
  private DoodleItem doodleItem;
  public int mScreenHeight = 480;
  public int mScreenWidth = 320;
  protected UniformParam.TextureBitmapParam mTextureParam;
  List<PointF> mTouchPoints = new ArrayList();
  List<Bitmap> oR = new ArrayList();
  
  public aymr(DoodleItem paramDoodleItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_DOODLE));
    this.doodleItem = paramDoodleItem;
    initParams();
    sy(paramString);
    paramDoodleItem.width = 25;
    paramDoodleItem.height = 25;
  }
  
  private void buH()
  {
    Bitmap localBitmap = (Bitmap)this.oR.get(0);
    if (this.mTextureParam != null)
    {
      this.mTextureParam.swapTextureBitmap(localBitmap);
      return;
    }
    this.mTextureParam = new UniformParam.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, false);
    this.mTextureParam.initialParams(super.getProgramIds());
    super.addParam(this.mTextureParam);
  }
  
  private void sy(String paramString)
  {
    paramString = BitmapUtils.decodeSampledBitmapFromFile(FileUtils.getRealPath(paramString + "/" + this.aAC + "/" + this.aAC + "_0.png"), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
    if (BitmapUtils.isLegal(paramString)) {
      this.oR.add(paramString);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Personality", 2, "PersonalityGlareFilter init bitmap is null");
  }
  
  public void ApplyGLSLFilter()
  {
    if (!this.aHU)
    {
      this.aHU = true;
      super.ApplyGLSLFilter();
    }
  }
  
  public boolean Lz()
  {
    if ((this.mTouchPoints == null) || (this.mTouchPoints.size() < 1)) {
      return false;
    }
    System.currentTimeMillis();
    aymv.setBlendMode(2);
    float f1 = this.doodleItem.width * this.width / this.brM * 1.5F;
    float f2 = this.doodleItem.height * this.height / this.brN * 1.5F;
    ArrayList localArrayList = new ArrayList();
    int j;
    if (this.mTouchPoints.size() <= 3)
    {
      i = 3;
      j = 0;
    }
    float f3;
    float f4;
    for (;;)
    {
      if ((j >= this.mTouchPoints.size()) || (j >= i)) {
        break label343;
      }
      if (j > 0)
      {
        localObject1 = (PointF)this.mTouchPoints.get(j - 1);
        localObject2 = (PointF)this.mTouchPoints.get(j);
        int m = (int)((float)aymv.a((PointF)localObject1, (PointF)localObject2) / f1 * 18.0F) + 1;
        int k = m;
        if (m < 6) {
          k = 6;
        }
        f3 = (((PointF)localObject2).x - ((PointF)localObject1).x) / (k * 1.0F);
        f4 = (((PointF)localObject2).y - ((PointF)localObject1).y) / (k * 1.0F);
        m = 0;
        for (;;)
        {
          if (m < k)
          {
            localArrayList.add(new PointF(((PointF)localObject1).x + m * f3, ((PointF)localObject1).y + m * f4));
            m += 1;
            continue;
            i = 2;
            break;
          }
        }
        if (!((PointF)localArrayList.get(localArrayList.size() - 1)).equals(((PointF)localObject2).x, ((PointF)localObject2).y)) {
          localArrayList.add(localObject1);
        }
      }
      j += 1;
    }
    label343:
    if (this.mTouchPoints.size() > 3) {
      cq(localArrayList);
    }
    Object localObject1 = new float[localArrayList.size() * 8];
    Object localObject2 = new float[localArrayList.size() * 8];
    int i = 0;
    while (i < localArrayList.size())
    {
      PointF localPointF = (PointF)localArrayList.get(i);
      float f6 = localPointF.x - f1 / 2.0F;
      float f5 = this.height - localPointF.y + f2 / 2.0F;
      f3 = f6 / this.width * 2.0F - 1.0F;
      f4 = f5 / this.height * 2.0F - 1.0F;
      f6 = (f6 + f1) / this.width * 2.0F - 1.0F;
      f5 = (f5 - f2) / this.height * 2.0F - 1.0F;
      localObject1[(i * 8 + 0)] = f3;
      localObject1[(i * 8 + 1)] = f5;
      localObject1[(i * 8 + 2)] = f6;
      localObject1[(i * 8 + 3)] = f5;
      localObject1[(i * 8 + 4)] = f3;
      localObject1[(i * 8 + 5)] = f4;
      localObject1[(i * 8 + 6)] = f6;
      localObject1[(i * 8 + 7)] = f4;
      localObject2[(i * 8 + 0)] = 0.0F;
      localObject2[(i * 8 + 1)] = 1.0F;
      localObject2[(i * 8 + 2)] = 1.0F;
      localObject2[(i * 8 + 3)] = 1.0F;
      localObject2[(i * 8 + 4)] = 0.0F;
      localObject2[(i * 8 + 5)] = 0.0F;
      localObject2[(i * 8 + 6)] = 1.0F;
      localObject2[(i * 8 + 7)] = 0.0F;
      i += 1;
    }
    super.setPositions((float[])localObject1);
    super.setTexCords((float[])localObject2);
    super.addParam(new UniformParam.Float2fParam("texAnchor", -this.c.x, this.c.y));
    super.addParam(new UniformParam.FloatParam("texScale", 1.0F));
    super.addParam(new UniformParam.FloatParam("texScaleX", 1.0F));
    super.addParam(new UniformParam.FloatParam("texScaleY", 1.0F));
    super.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    super.OnDrawFrameGLSL();
    GLES20.glDrawArrays(5, 0, localArrayList.size() * 4);
    GLES20.glFlush();
    aymv.setBlendMode(0);
    System.currentTimeMillis();
    return true;
  }
  
  PointF a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, float paramFloat)
  {
    PointF localPointF1 = new PointF((paramPointF3.x - paramPointF1.x) * 0.5F, (paramPointF3.y - paramPointF1.y) * 0.5F);
    PointF localPointF2 = new PointF((paramPointF3.x - paramPointF2.x) * 3.0F - (paramPointF4.x - paramPointF2.x) * 0.5F - 2.0F * 0.5F * (paramPointF3.x - paramPointF1.x), (paramPointF3.y - paramPointF2.y) * 3.0F - (paramPointF4.y - paramPointF2.y) * 0.5F - 2.0F * 0.5F * (paramPointF3.y - paramPointF1.y));
    float f1 = paramPointF3.x;
    float f2 = paramPointF2.x;
    float f3 = paramPointF4.x;
    float f4 = paramPointF2.x;
    float f5 = paramPointF3.x;
    float f6 = paramPointF1.x;
    float f7 = paramPointF3.y;
    float f8 = paramPointF2.y;
    float f9 = paramPointF4.y;
    float f10 = paramPointF2.y;
    paramPointF1 = new PointF((f1 - f2) * -2.0F + (f3 - f4) * 0.5F + (f5 - f6) * 0.5F, 0.5F * (paramPointF3.y - paramPointF1.y) + ((f7 - f8) * -2.0F + (f9 - f10) * 0.5F));
    f1 = paramPointF1.x;
    f2 = localPointF2.x;
    f3 = localPointF1.x;
    f4 = paramPointF2.x;
    f5 = paramPointF1.y;
    f6 = localPointF2.y;
    return new PointF(f1 * paramFloat * paramFloat * paramFloat + f2 * paramFloat * paramFloat + f3 * paramFloat + f4, localPointF1.y * paramFloat + (f6 * paramFloat * paramFloat + f5 * paramFloat * paramFloat * paramFloat) + paramPointF2.y);
  }
  
  void cq(ArrayList<PointF> paramArrayList)
  {
    float f3 = this.doodleItem.width * this.width / this.brM;
    int i = 3;
    float f1;
    float f2;
    if (i < this.mTouchPoints.size())
    {
      f1 = (float)aymv.a((PointF)this.mTouchPoints.get(i - 3), (PointF)this.mTouchPoints.get(i - 2));
      f2 = (float)aymv.a((PointF)this.mTouchPoints.get(i - 2), (PointF)this.mTouchPoints.get(i - 1));
      f1 = 1.0F / ((int)(((float)aymv.a((PointF)this.mTouchPoints.get(i - 1), (PointF)this.mTouchPoints.get(i)) + (f1 + f2)) / (f3 * 1.5F)) * 12 * 1.0F);
      if (f1 > 0.1F) {
        f1 = 0.1F;
      }
    }
    label290:
    for (;;)
    {
      f2 = 0.0F;
      for (;;)
      {
        if (f2 < 1.0F)
        {
          paramArrayList.add(a((PointF)this.mTouchPoints.get(i - 3), (PointF)this.mTouchPoints.get(i - 2), (PointF)this.mTouchPoints.get(i - 1), (PointF)this.mTouchPoints.get(i), f2));
          f2 += f1;
          continue;
          if (f1 >= 0.01F) {
            break label290;
          }
          f1 = 0.01F;
          break;
        }
      }
      i += 1;
      break;
      return;
    }
  }
  
  public void initParams()
  {
    super.addParam(new UniformParam.IntParam("texNeedTransform", 1));
    super.addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    super.addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
    super.addParam(new UniformParam.FloatParam("texScale", 1.0F));
    super.addParam(new UniformParam.FloatParam("texScaleX", 1.0F));
    super.addParam(new UniformParam.FloatParam("texScaleY", 1.0F));
    super.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    super.addParam(new UniformParam.FloatParam("positionRotate", 0.0F));
    super.addParam(new UniformParam.FloatParam("alpha", 1.0F));
    if (this.doodleItem != null) {
      super.addParam(new UniformParam.IntParam("blendMode", this.doodleItem.blendMode));
    }
    super.addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
  }
  
  public void setTouchPoints(List<PointF> paramList)
  {
    this.mTouchPoints.clear();
    if (this.oR.size() < 1) {}
    for (;;)
    {
      return;
      buH();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PointF localPointF = (PointF)paramList.next();
        localPointF = new PointF(localPointF.x + this.c.x, localPointF.y + this.c.y);
        this.mTouchPoints.add(localPointF);
      }
    }
  }
  
  public void updatePreview(Object paramObject) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.c = new Point(paramInt1 / 2, paramInt2 / 2);
    super.addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aymr
 * JD-Core Version:    0.7.0.1
 */