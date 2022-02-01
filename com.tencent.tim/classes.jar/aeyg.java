import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnTouchListener;

public class aeyg
  implements aeye, TextureView.SurfaceTextureListener
{
  private aeye.a a;
  private TextureView mTextureView;
  
  public aeyg(TextureView paramTextureView)
  {
    this.mTextureView = paramTextureView;
    this.mTextureView.setOpaque(false);
    this.mTextureView.setSurfaceTextureListener(this);
  }
  
  public void a(aeye.a parama)
  {
    this.a = parama;
  }
  
  public float aZ()
  {
    return this.mTextureView.getY();
  }
  
  public void destroy()
  {
    this.a = null;
    if (this.mTextureView != null)
    {
      this.mTextureView.setOnTouchListener(null);
      this.mTextureView = null;
    }
  }
  
  public Canvas lockCanvas()
  {
    return this.mTextureView.lockCanvas();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mTextureView.setOpaque(false);
    if (this.a != null)
    {
      this.a.cXL();
      this.a.cXM();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (this.a != null) {
      this.a.cXN();
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.cXM();
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.mTextureView.setOnTouchListener(paramOnTouchListener);
  }
  
  public void unlock() {}
  
  public void unlockCanvasAndPost(Canvas paramCanvas)
  {
    this.mTextureView.unlockCanvasAndPost(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyg
 * JD-Core Version:    0.7.0.1
 */