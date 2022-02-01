import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

public class atbg
  extends DynamicDrawableSpan
{
  private static final int eoT = aqnm.dpToPx(6.0F);
  private WeakReference<Drawable> mDrawableRef;
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramCanvas.save();
    paramInt1 = paramCharSequence.getBounds().bottom;
    paramCanvas.translate(eoT + paramFloat, paramInt4 - paramInt1);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public Drawable getDrawable()
  {
    Object localObject2 = this.mDrawableRef;
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = (Drawable)((WeakReference)localObject2).get();
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = BaseApplicationImpl.getContext().getResources();
      localObject2 = new BitmapDrawable((Resources)localObject1, BitmapFactory.decodeResource((Resources)localObject1, 2130842409));
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      this.mDrawableRef = new WeakReference(localObject2);
    }
    return localObject2;
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    return getDrawable().getIntrinsicWidth() + eoT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbg
 * JD-Core Version:    0.7.0.1
 */