import android.util.Log;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.UniformParam.Float4fParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ips
  extends ipy
{
  private static String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform vec4 offset;\nuniform vec4 offset1;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture1;\nvoid main() {\n    vec2 newCoordinate;\n    if (textureCoordinate.x <= 0.5) {\n        newCoordinate.x = offset.x + textureCoordinate.x * 2.0 * (1.0 - offset.y - offset.x);\n        newCoordinate.y = offset.y + textureCoordinate.y * (1.0 - offset.w - offset.z);\n        gl_FragColor = texture2D(inputImageTexture, newCoordinate);\n    } else {\n        newCoordinate.x = offset1.x + (textureCoordinate.x - 0.5) * 2.0 * (1.0 - offset1.y - offset1.x);\n        newCoordinate.y = offset1.z + textureCoordinate.y * (1.0 - offset1.w - offset1.z);\n        gl_FragColor = texture2D(inputImageTexture1, newCoordinate);\n    }\n}";
  private static String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
  private String TAG = "CompositeFilter2-" + Integer.toHexString(hashCode());
  private float[] Z = new float[4];
  private ips.a a;
  private float[] aa = new float[4];
  private int height;
  private int width;
  
  public ips(int paramInt1, int paramInt2)
  {
    super(2);
    this.width = paramInt1;
    this.height = paramInt2;
    QLog.d(this.TAG, 1, "CompositeFilter2: width=" + paramInt1 + ", height=" + paramInt2);
  }
  
  private void a(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f = this.height / this.width * 2.0F;
    if (paramInt2 / paramInt1 > f)
    {
      paramArrayOfFloat[1] = 0.0F;
      paramArrayOfFloat[0] = 0.0F;
      paramArrayOfFloat[2] = ((paramInt2 - f * paramInt1) / paramInt2 / 2.0F);
      paramArrayOfFloat[3] = paramArrayOfFloat[2];
      return;
    }
    paramArrayOfFloat[0] = ((paramInt1 - paramInt2 / f) / paramInt1 / 2.0F);
    paramArrayOfFloat[1] = paramArrayOfFloat[0];
    paramArrayOfFloat[3] = 0.0F;
    paramArrayOfFloat[2] = 0.0F;
  }
  
  @NotNull
  protected Frame a(List<iqa> paramList, long paramLong)
  {
    if ((this.width == 0) || (this.height == 0))
    {
      Log.e(this.TAG, "onRender: invalidate composite size");
      return null;
    }
    if (paramList.size() > 2) {
      Log.w(this.TAG, "onRender: expect 2 inputs, but got " + paramList.size());
    }
    Frame localFrame = ((iqa)paramList.get(0)).frame;
    a(this.Z, localFrame.width, localFrame.height);
    this.a.addParam(new UniformParam.Float4fParam("offset", this.Z[0], this.Z[1], this.Z[2], this.Z[3]));
    if (paramList.size() > 1)
    {
      paramList = ((iqa)paramList.get(1)).frame;
      a(this.aa, paramList.width, paramList.height);
      this.a.addParam(new UniformParam.TextureParam("inputImageTexture1", paramList.getTextureId(), 33985));
      this.a.addParam(new UniformParam.Float4fParam("offset1", this.aa[0], this.aa[1], this.aa[2], this.aa[3]));
    }
    for (;;)
    {
      return this.a.RenderProcess(localFrame.getTextureId(), this.width, this.height);
      this.a.addParam(new UniformParam.TextureParam("inputImageTexture1", -1, 33985));
    }
  }
  
  protected void onDestroy()
  {
    if (this.a != null)
    {
      this.a.clearGLSLSelf();
      QLog.d(this.TAG, 1, "onDestroy: filter#" + Integer.toHexString(this.a.hashCode()));
      this.a = null;
    }
  }
  
  protected void onInit()
  {
    this.a = new ips.a();
    QLog.d(this.TAG, 1, "onInit: create filter#" + Integer.toHexString(this.a.hashCode()));
    this.a.setPositions(AEOpenRenderConfig.ORIGIN_POSITION_COORDS, true);
    this.a.setTexCords(AEOpenRenderConfig.ORIGIN_TEX_COORDS, true);
    this.a.ApplyGLSLFilter();
  }
  
  class a
    extends VideoFilterBase
  {
    a()
    {
      super(ips.FRAGMENT_SHADER);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ips
 * JD-Core Version:    0.7.0.1
 */