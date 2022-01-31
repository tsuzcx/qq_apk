import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.widget.ImageView;

final class ykx
  extends Property<ImageView, Matrix>
{
  ykx(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Matrix a(ImageView paramImageView)
  {
    return null;
  }
  
  public void a(ImageView paramImageView, Matrix paramMatrix)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    if (localDrawable == null) {
      return;
    }
    if (paramMatrix == null) {
      localDrawable.setBounds(0, 0, paramImageView.getWidth(), paramImageView.getHeight());
    }
    for (;;)
    {
      paramImageView.invalidate();
      return;
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      if (paramImageView.getImageMatrix() == null) {
        paramImageView.setImageMatrix(new Matrix());
      }
      paramImageView.setImageMatrix(paramMatrix);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ykx
 * JD-Core Version:    0.7.0.1
 */