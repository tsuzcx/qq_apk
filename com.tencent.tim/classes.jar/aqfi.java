import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

public final class aqfi
{
  public static final DownloadParams.DecodeHandler A = new aqfj();
  public static final DownloadParams.DecodeHandler B = new aqfi.a(aqbn.s, A);
  
  public static Bitmap a(@NonNull Bitmap paramBitmap1, @NonNull Bitmap paramBitmap2, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return paramBitmap1;
    }
    paramBitmap2.setDensity((int)aqnm.getDensityDpi());
    Canvas localCanvas = new Canvas(paramBitmap2);
    Path localPath = a(paramInt1, paramInt2);
    BitmapShader localBitmapShader = new BitmapShader(paramBitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    localBitmapShader.setLocalMatrix(b(paramBitmap1.getWidth(), paramBitmap1.getHeight(), paramInt1, paramInt2));
    paramBitmap1 = new Paint();
    paramBitmap1.setShader(localBitmapShader);
    paramBitmap1.setAntiAlias(true);
    localCanvas.drawPath(localPath, paramBitmap1);
    return paramBitmap2;
  }
  
  @NonNull
  public static Path a(int paramInt1, int paramInt2)
  {
    Path localPath = new Path();
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return localPath;
    }
    float f1 = Math.min(paramInt1 * 0.0618F, paramInt2 * 0.0618F);
    float f2 = paramInt1 / 2.0F;
    float f3 = paramInt2 / 2.0F;
    localPath.moveTo(0.0F, f3);
    localPath.cubicTo(0.0F, f1, f1, 0.0F, f2, 0.0F);
    localPath.cubicTo(paramInt1 - f1, 0.0F, paramInt1, f1, paramInt1, f3);
    localPath.cubicTo(paramInt1, paramInt2 - f1, paramInt1 - f1, paramInt2, f2, paramInt2);
    localPath.cubicTo(f1, paramInt2, 0.0F, paramInt2 - f1, 0.0F, f3);
    return localPath;
  }
  
  @NonNull
  private static Matrix b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 0.0F;
    Matrix localMatrix = new Matrix();
    if ((paramInt1 == paramInt3) && (paramInt2 == paramInt4)) {
      return localMatrix;
    }
    float f1;
    float f3;
    if (paramInt1 * paramInt4 > paramInt3 * paramInt2)
    {
      f1 = paramInt4 / paramInt2;
      f3 = (paramInt3 - paramInt1 * f1) * 0.5F;
    }
    for (;;)
    {
      localMatrix.setScale(f1, f1);
      localMatrix.postTranslate(Math.round(f3), Math.round(f2));
      return localMatrix;
      f1 = paramInt3 / paramInt1;
      f2 = paramInt4;
      float f4 = paramInt2;
      f3 = 0.0F;
      f2 = (f2 - f4 * f1) * 0.5F;
    }
  }
  
  public static Bitmap createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return paramConfig;
    }
    catch (Exception paramConfig)
    {
      return null;
    }
    catch (OutOfMemoryError paramConfig) {}
    return null;
  }
  
  public static Bitmap p(@NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0) || ((paramInt1 <= 0) && (paramInt2 <= 0))) {}
    Bitmap localBitmap;
    do
    {
      return paramBitmap;
      localBitmap = createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    } while (localBitmap == null);
    return a(paramBitmap, localBitmap, paramInt1, paramInt2);
  }
  
  public static Bitmap z(@NonNull Bitmap paramBitmap)
  {
    return p(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  public static class a
    implements DownloadParams.DecodeHandler
  {
    private DownloadParams.DecodeHandler C;
    private DownloadParams.DecodeHandler D;
    
    public a(DownloadParams.DecodeHandler paramDecodeHandler1, DownloadParams.DecodeHandler paramDecodeHandler2)
    {
      this.C = paramDecodeHandler1;
      this.D = paramDecodeHandler2;
    }
    
    public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
    {
      Bitmap localBitmap = this.C.run(paramDownloadParams, paramBitmap);
      DownloadParams localDownloadParams = null;
      if (localBitmap != null)
      {
        paramDownloadParams = this.D.run(paramDownloadParams, localBitmap);
        localDownloadParams = paramDownloadParams;
        if (localBitmap != paramDownloadParams)
        {
          localDownloadParams = paramDownloadParams;
          if (localBitmap != paramBitmap)
          {
            localBitmap.recycle();
            localDownloadParams = paramDownloadParams;
          }
        }
      }
      if (localDownloadParams != null) {
        paramBitmap = localDownloadParams;
      }
      return paramBitmap;
    }
  }
  
  public static class b
    extends Drawable
  {
    private int mColor;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private int mWidth;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramInt2 > 0) && (paramInt3 > 0))
      {
        this.mWidth = paramInt2;
        this.mHeight = paramInt3;
        this.mPath = aqfi.a(this.mWidth, this.mHeight);
      }
      this.mColor = paramInt1;
      this.mPaint = new Paint();
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setColor(this.mColor);
    }
    
    public void draw(@NonNull Canvas paramCanvas)
    {
      Rect localRect = getBounds();
      int i = localRect.right - localRect.left;
      int j = localRect.bottom - localRect.top;
      if ((i != this.mWidth) && (j != this.mHeight))
      {
        this.mWidth = i;
        this.mHeight = j;
        this.mPath = aqfi.a(this.mWidth, this.mHeight);
      }
      paramCanvas.save();
      paramCanvas.translate(localRect.left, localRect.top);
      paramCanvas.drawPath(this.mPath, this.mPaint);
      paramCanvas.restore();
    }
    
    public int getOpacity()
    {
      switch (this.mColor >>> 24)
      {
      default: 
        return -3;
      case 255: 
        return -1;
      }
      return -2;
    }
    
    public void setAlpha(int paramInt) {}
    
    public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfi
 * JD-Core Version:    0.7.0.1
 */