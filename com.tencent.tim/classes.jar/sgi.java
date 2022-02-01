import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.widget.ImageView;

final class sgi
  extends Property<ImageView, Matrix>
{
  sgi(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
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
  
  public Matrix b(ImageView paramImageView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgi
 * JD-Core Version:    0.7.0.1
 */