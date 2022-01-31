import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView.DisplayRuleDef;

public class bxo
  implements AnyScaleTypeImageView.DisplayRuleDef
{
  public bxo(RichStatItemBuilder paramRichStatItemBuilder) {}
  
  public Matrix getMatrix(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    Matrix localMatrix = new Matrix();
    if (paramDrawable == null) {
      return localMatrix;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    float f2;
    if (i * paramInt2 > paramInt1 * j) {
      f2 = paramInt2 / j;
    }
    for (float f1 = (paramInt1 - i * f2) * 0.5F;; f1 = 0.0F)
    {
      localMatrix.setScale(f2, f2);
      localMatrix.postTranslate((int)(f1 + 0.5F), (int)(0.0F + 0.5F));
      return localMatrix;
      f2 = paramInt1 / i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bxo
 * JD-Core Version:    0.7.0.1
 */