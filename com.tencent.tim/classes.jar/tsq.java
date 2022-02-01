import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.Nullable;

public abstract interface tsq
  extends tso
{
  public abstract void a(RectF paramRectF, Matrix paramMatrix);
  
  public abstract void b(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter);
  
  public abstract void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tsq
 * JD-Core Version:    0.7.0.1
 */