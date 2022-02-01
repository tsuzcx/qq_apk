import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.layer.Layer;

public class twj
  extends twe
{
  private final float density;
  private final Rect dst = new Rect();
  private final Paint paint = new Paint(3);
  private final Rect src = new Rect();
  
  twj(trz paramtrz, Layer paramLayer, float paramFloat)
  {
    super(paramtrz, paramLayer);
    this.density = paramFloat;
  }
  
  @Nullable
  private Bitmap getBitmap()
  {
    String str = this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer.getRefId();
    return this.jdField_a_of_type_Trz.getImageAsset(str);
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    paramMatrix = getBitmap();
    if (paramMatrix != null)
    {
      paramRectF.set(paramRectF.left, paramRectF.top, Math.min(paramRectF.right, paramMatrix.getWidth()), Math.min(paramRectF.bottom, paramMatrix.getHeight()));
      this.boundsMatrix.mapRect(paramRectF);
    }
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
  }
  
  public void drawLayer(@NonNull Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    Bitmap localBitmap = getBitmap();
    if (localBitmap == null) {
      return;
    }
    this.paint.setAlpha(paramInt);
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    this.src.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
    this.dst.set(0, 0, (int)(localBitmap.getWidth() * this.density), (int)(localBitmap.getHeight() * this.density));
    paramCanvas.drawBitmap(localBitmap, this.src, this.dst, this.paint);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     twj
 * JD-Core Version:    0.7.0.1
 */