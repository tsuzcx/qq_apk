import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;

public class afeh
  extends BitmapDrawable
{
  public int chatWindowHeight;
  private Bitmap mBitmap;
  private Rect mDrawRect = new Rect();
  private final Paint mPaint = new Paint(2);
  
  public afeh(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
    this.mBitmap = paramBitmap;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()))
    {
      Rect localRect = getBounds();
      paramCanvas.drawBitmap(this.mBitmap, this.mDrawRect, localRect, this.mPaint);
    }
  }
  
  protected Rect getImageDrawnRect(Rect paramRect)
  {
    if (getBitmap() == null) {
      return this.mDrawRect;
    }
    int i = getBitmap().getHeight();
    int k = getBitmap().getWidth();
    if (paramRect == null) {
      return new Rect(0, 0, k, i);
    }
    QLog.d("chatbg", 1, "dstRect = " + paramRect);
    QLog.d("chatbg", 1, "img width = " + k + " img height = " + i);
    if (this.chatWindowHeight < paramRect.height()) {
      this.chatWindowHeight = paramRect.height();
    }
    int j;
    if (this.chatWindowHeight / paramRect.width() >= i / k)
    {
      j = paramRect.width() * i / this.chatWindowHeight;
      k = (int)((k - j) * 0.5D);
      if (this.chatWindowHeight > paramRect.height()) {
        i = getBitmap().getHeight() * paramRect.height() / this.chatWindowHeight;
      }
    }
    for (paramRect = new Rect(k, 0, j + k, i);; paramRect = new Rect(0, i, k, j + i))
    {
      QLog.d("chatbg", 1, " result = " + paramRect + " chatWindowHeight " + this.chatWindowHeight);
      return paramRect;
      j = paramRect.height() * k / paramRect.width();
      i = (int)((i - this.chatWindowHeight * k / paramRect.width()) * 0.5D);
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.mDrawRect = getImageDrawnRect(getBounds());
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afeh
 * JD-Core Version:    0.7.0.1
 */