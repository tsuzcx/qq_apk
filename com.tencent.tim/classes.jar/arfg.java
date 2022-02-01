import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView.a;

final class arfg
  implements AnyScaleTypeImageView.a
{
  public Matrix a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    Matrix localMatrix = new Matrix();
    if (paramDrawable == null) {
      return localMatrix;
    }
    paramInt2 = paramDrawable.getIntrinsicWidth();
    float f = paramInt1 / paramInt2;
    localMatrix.setScale(f, f);
    return localMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfg
 * JD-Core Version:    0.7.0.1
 */