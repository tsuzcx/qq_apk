import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.Size;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import java.nio.FloatBuffer;

public abstract interface adkx
  extends GLSurfaceView.Renderer
{
  public abstract void A(int paramInt, Object paramObject);
  
  public abstract int BQ();
  
  public abstract void Lk(int paramInt);
  
  public abstract void a(int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void a(int paramInt, float[] paramArrayOfFloat);
  
  public abstract void a(adcz paramadcz);
  
  public abstract void a(adly paramadly);
  
  public abstract void a(VideoRecordController paramVideoRecordController);
  
  public abstract boolean a(addc paramaddc);
  
  public abstract boolean a(GLSurfaceView paramGLSurfaceView, Context paramContext);
  
  public abstract boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2);
  
  public abstract boolean afc();
  
  public abstract void b(addd paramaddd);
  
  public abstract void b(FloatBuffer paramFloatBuffer, Size paramSize);
  
  public abstract void cSm();
  
  public abstract long fq();
  
  public abstract void iP(long paramLong);
  
  public abstract void iQ(long paramLong);
  
  public abstract void requestRender();
  
  public abstract boolean start();
  
  public abstract void stop();
  
  public abstract void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adkx
 * JD-Core Version:    0.7.0.1
 */