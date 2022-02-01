import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;

public abstract class aqtg
  implements aqtb.b
{
  protected SurfaceHolder a;
  protected Rect cK = new Rect();
  private boolean cVR = true;
  
  public aqtg(SurfaceHolder paramSurfaceHolder)
  {
    this.a = paramSurfaceHolder;
  }
  
  private void ad(Drawable paramDrawable)
  {
    if (aqsj.i(paramDrawable))
    {
      aqsj.a().a(paramDrawable, true);
      paramDrawable.setBounds(this.cK);
      return;
    }
    Rect localRect = new Rect();
    Object localObject;
    float f2;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      localRect.set(0, 0, ((BitmapDrawable)localObject).getBitmap().getWidth(), ((BitmapDrawable)localObject).getBitmap().getHeight());
      float f1 = this.cK.width() / localRect.width();
      f2 = this.cK.height() / localRect.height();
      if (f1 <= f2) {
        break label201;
      }
      localRect.right = this.cK.right;
      localRect.bottom = ((int)(f1 * localRect.bottom));
    }
    for (;;)
    {
      Gravity.apply(17, localRect.width(), localRect.height(), this.cK, localRect);
      paramDrawable.setBounds(localRect);
      return;
      if (!(paramDrawable instanceof ApngDrawable)) {
        break;
      }
      localObject = (ApngDrawable)paramDrawable;
      localRect.set(0, 0, ((ApngDrawable)localObject).getImage().getWidth(), ((ApngDrawable)localObject).getImage().getHeight());
      break;
      label201:
      localRect.bottom = this.cK.bottom;
      localRect.right = ((int)(localRect.right * f2));
    }
  }
  
  abstract Canvas a(SurfaceHolder paramSurfaceHolder);
  
  public final void ac(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    while ((this.a == null) || (this.a.getSurface() == null) || (!this.a.getSurface().isValid())) {
      return;
    }
    Canvas localCanvas = a(this.a);
    if (localCanvas != null)
    {
      if (this.cVR)
      {
        if (this.cK.width() == 0) {
          this.cK.set(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        }
        this.cVR = false;
        ad(paramDrawable);
      }
      paramDrawable.draw(localCanvas);
    }
    this.a.unlockCanvasAndPost(localCanvas);
  }
  
  public void reset()
  {
    this.cVR = true;
  }
  
  public final void setBounds(Rect paramRect)
  {
    this.cK.set(paramRect);
    this.cVR = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqtg
 * JD-Core Version:    0.7.0.1
 */