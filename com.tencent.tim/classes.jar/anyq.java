import android.graphics.Bitmap;
import android.view.MotionEvent;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

public class anyq
  extends anyu
  implements anxw, anyt.a
{
  private anya a;
  private anyq.a c;
  private boolean cKH;
  private String mEvent;
  private boolean mIsPressed;
  
  public anyq(SpriteGLView paramSpriteGLView, Bitmap paramBitmap, boolean paramBoolean)
  {
    super(paramSpriteGLView, paramBitmap);
    this.jdField_a_of_type_Anya = new anya(0.0F, 0.0F);
    this.cKH = paramBoolean;
  }
  
  public anyq(SpriteGLView paramSpriteGLView, boolean paramBoolean, String paramString)
  {
    super(paramSpriteGLView);
    this.jdField_a_of_type_Anya = new anya(0.0F, 0.0F);
    this.cKH = paramBoolean;
    this.mEvent = paramString;
  }
  
  public void a(anyq.a parama)
  {
    this.c = parama;
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Anyv == null) || (this.jdField_a_of_type_Anyv.bitmap == null)) {
      return false;
    }
    paramInt1 = paramMotionEvent.getAction();
    float f3 = paramMotionEvent.getX();
    float f4 = paramMotionEvent.getY();
    a(this.jdField_a_of_type_Anya);
    float f1 = bv();
    float f5 = (this.jdField_a_of_type_Anya.x - this.jdField_a_of_type_Anyv.bitmap.getWidth() * this.scale / 2.0F) * f1;
    float f6 = (this.jdField_a_of_type_Anya.x + this.jdField_a_of_type_Anyv.bitmap.getWidth() * this.scale / 2.0F) * f1;
    float f2;
    if (this.b.cKJ)
    {
      f2 = paramInt2 - (this.jdField_a_of_type_Anya.y + this.jdField_a_of_type_Anyv.bitmap.getHeight() * this.scale / 2.0F) * f1;
      f1 = paramInt2 - f1 * (this.jdField_a_of_type_Anya.y - this.jdField_a_of_type_Anyv.bitmap.getHeight() * this.scale / 2.0F);
      if (paramInt1 != 0) {
        break label337;
      }
      if ((f3 <= f5) || (f3 >= f6) || (f4 <= f2) || (f4 >= f1)) {
        break label315;
      }
      this.mIsPressed = true;
      if (this.cKH) {
        this.opacity = 128;
      }
    }
    for (;;)
    {
      return this.mIsPressed;
      f2 = (this.jdField_a_of_type_Anya.y - this.jdField_a_of_type_Anyv.bitmap.getHeight() * this.scale / 2.0F) * f1;
      f1 *= (this.jdField_a_of_type_Anya.y + this.jdField_a_of_type_Anyv.bitmap.getHeight() * this.scale / 2.0F);
      break;
      label315:
      this.mIsPressed = false;
      if (this.cKH) {
        this.opacity = 255;
      }
    }
    label337:
    if ((paramInt1 == 1) || (paramInt1 == 3))
    {
      this.mIsPressed = false;
      if (this.cKH) {
        this.opacity = 255;
      }
      if ((f3 > f5) && (f3 < f6) && (f4 > f2) && (f4 < f1))
      {
        if (this.c != null)
        {
          this.c.a(this);
          return true;
        }
        return true;
      }
    }
    return false;
  }
  
  public String on()
  {
    return this.mEvent;
  }
  
  public static abstract interface a
  {
    public abstract void a(anyu paramanyu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyq
 * JD-Core Version:    0.7.0.1
 */