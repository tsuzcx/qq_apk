import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(14)
public class amaf
{
  private amac a;
  private amad b;
  private Surface surface;
  private TextureRender textureRender;
  
  public void a(amae paramamae, Surface paramSurface)
  {
    this.surface = paramSurface;
    this.a = new amac(paramamae.a(), 1);
    this.b = new amad(this.a);
    this.b.createWindowSurface(paramSurface);
    this.b.makeCurrent();
    this.textureRender = new TextureRender();
  }
  
  public void e(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    this.textureRender.drawTexture(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
    this.b.setPresentationTime(paramLong);
    this.b.swapBuffers();
  }
  
  public void release()
  {
    if (this.surface != null)
    {
      this.surface.release();
      this.surface = null;
    }
    if (this.b != null)
    {
      this.b.releaseEglSurface();
      this.b = null;
    }
    if (this.a != null)
    {
      this.a.release();
      this.a = null;
    }
    if (this.textureRender != null)
    {
      this.textureRender.release();
      this.textureRender = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amaf
 * JD-Core Version:    0.7.0.1
 */