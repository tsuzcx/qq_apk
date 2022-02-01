import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import rx.functions.Func1;

public class vsp
  implements Func1<Bitmap, Bitmap>
{
  public vsp(RoundImageView paramRoundImageView, Drawable paramDrawable) {}
  
  public Bitmap a(Bitmap paramBitmap)
  {
    Canvas localCanvas = new Canvas(paramBitmap);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(localCanvas);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsp
 * JD-Core Version:    0.7.0.1
 */