import android.opengl.Matrix;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ipe
{
  private final float[] U = new float[16];
  private TextureRender a;
  private RenderBuffer c;
  private final float[] mMvpMatrix;
  
  public ipe()
  {
    Matrix.setIdentityM(this.U, 0);
    this.mMvpMatrix = new float[16];
    Matrix.setIdentityM(this.mMvpMatrix, 0);
    Matrix.scaleM(this.mMvpMatrix, 0, -1.0F, 1.0F, 1.0F);
    if (this.a == null) {
      this.a = new TextureRender();
    }
  }
  
  public ipc a(ipc paramipc, int paramInt1, int paramInt2)
  {
    if ((paramipc == null) || (paramipc.arC == -1) || (paramInt1 == 0) || (paramInt2 == 0)) {
      return null;
    }
    if ((this.c == null) || (paramInt1 != this.c.getWidth()) || (paramInt2 != this.c.getHeight()))
    {
      if (this.c != null) {
        this.c.destroy();
      }
      this.c = new RenderBuffer(paramInt1, paramInt2, 33984);
    }
    this.c.bind();
    this.a.drawTexture(3553, paramipc.arC, this.U, this.mMvpMatrix);
    this.c.unbind();
    return ipc.a(0, this.c.getTexId());
  }
  
  public void aoI()
  {
    if (this.c != null)
    {
      this.c.destroy();
      this.c = null;
    }
    if (this.a != null)
    {
      this.a.release();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipe
 * JD-Core Version:    0.7.0.1
 */