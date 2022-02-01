import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

public class anyr
  extends anyu
{
  private Paint mPaint = new Paint();
  private String mText = "";
  private int mTextColor = -1;
  private int mTextSize = 20;
  
  public anyr(SpriteGLView paramSpriteGLView, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    this.mPaint.setAntiAlias(true);
    setTextColor(paramInt1);
    setTextSize(paramInt2);
    a(paramSpriteGLView, paramString);
  }
  
  public void a(SpriteGLView paramSpriteGLView, String paramString)
  {
    if (paramString.equals(this.mText)) {
      return;
    }
    this.mText = paramString;
    paramString = Bitmap.createBitmap((int)this.mPaint.measureText(paramString), this.mTextSize, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramString);
    localCanvas.drawColor(-16777216, PorterDuff.Mode.CLEAR);
    localCanvas.drawText(this.mText, 0.0F, this.mTextSize * 0.8F, this.mPaint);
    if (this.a != null) {
      this.a.release();
    }
    this.a = new anyv(paramSpriteGLView, paramString);
    init();
    ckj();
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = paramInt;
    this.mPaint.setColor(this.mTextColor);
  }
  
  public void setTextSize(int paramInt)
  {
    this.mTextSize = paramInt;
    this.mPaint.setTextSize(this.mTextSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyr
 * JD-Core Version:    0.7.0.1
 */