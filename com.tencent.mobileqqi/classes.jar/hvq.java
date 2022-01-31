import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.image.ProxyDrawable;
import com.tencent.widget.BubblePopupWindow;

public class hvq
  extends ProxyDrawable
{
  int jdField_a_of_type_Int;
  int b;
  
  public hvq(BubblePopupWindow paramBubblePopupWindow, Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if (this.b > this.jdField_a_of_type_Int)
    {
      int i = paramCanvas.save();
      paramCanvas.clipRect(this.jdField_a_of_type_Int, 0, this.b, localRect.height());
      this.mCurrDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hvq
 * JD-Core Version:    0.7.0.1
 */