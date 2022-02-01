import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;

public class aqff
{
  public static int c(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      return -1;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return aqft.getBitmapSize(((BitmapDrawable)paramDrawable).getBitmap());
      }
      if ((paramDrawable instanceof SkinnableBitmapDrawable)) {
        return aqft.getBitmapSize(((SkinnableBitmapDrawable)paramDrawable).getBitmap());
      }
    } while (!(paramDrawable instanceof SkinnableNinePatchDrawable));
    return aqft.getBitmapSize(((SkinnableNinePatchDrawable)paramDrawable).getBitmap());
  }
  
  public static final Bitmap getDrawableBitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      return null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
    } while (!(paramDrawable instanceof SkinnableBitmapDrawable));
    return ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqff
 * JD-Core Version:    0.7.0.1
 */