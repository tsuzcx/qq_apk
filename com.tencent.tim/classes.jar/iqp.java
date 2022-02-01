import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class iqp
  extends iqq
{
  private float mAlpha = 1.0F;
  protected Canvas mCanvas;
  private final Bitmap.Config mConfig;
  private int mMaxHeight = 2147483647;
  private int mMaxLength = 2147483647;
  private int mMaxWidth = 2147483647;
  private Paint.FontMetricsInt mMetrics;
  private TextPaint mPaint = new TextPaint();
  private String mText = "";
  private int mTextColor = -1;
  private float mTextSize = 15.0F;
  
  public iqp()
  {
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(this.mTextColor);
    this.mPaint.setTextSize(this.mTextSize);
    this.mPaint.setShadowLayer(2.0F, 0.0F, 0.0F, -16777216);
    this.mMetrics = this.mPaint.getFontMetricsInt();
    this.mConfig = Bitmap.Config.ARGB_8888;
    setOpaque(false);
  }
  
  public void a(ipm paramipm, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.mAlpha < 0.99F) && (Build.VERSION.SDK_INT >= 16)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramipm.save(3);
        paramipm.setAlpha(this.mAlpha);
      }
      paramipm.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
      if (i != 0) {
        paramipm.restore();
      }
      return;
    }
  }
  
  public void apv()
  {
    int i = 1;
    if (!TextUtils.isEmpty(this.mText))
    {
      j = jji.length(this.mText);
      i = (int)Math.ceil(this.mPaint.measureText(this.mText));
      if ((j <= this.mMaxLength) && (i <= this.mMaxWidth)) {
        break label302;
      }
    }
    label302:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        i = Math.min(Math.max((this.mMaxWidth - (int)Math.ceil(this.mPaint.measureText("..."))) / (int)Math.ceil(this.mPaint.measureText("M")), 1), this.mMaxLength);
        this.mText = (jji.subString(this.mText, 0, i) + "...");
        i = (int)Math.ceil(this.mPaint.measureText(this.mText));
      }
      j = this.mMetrics.bottom - this.mMetrics.top;
      if (i <= 0) {
        i = 1;
      }
      for (;;)
      {
        if (j <= 0) {
          j = 1;
        }
        for (;;)
        {
          setSourceSize(i, j);
          setTextureSize(i, j);
          if (QLog.isColorLevel()) {
            QLog.d("StringTexture", 2, "refreshText width: " + this.mWidth + ", height: " + this.mHeight + ", maxLength: " + this.mMaxLength + ", textSize: " + this.mTextSize + ", text: " + this.mText + ";mMetrics:=" + this.mMetrics.toString());
          }
          return;
          j = 1;
        }
      }
    }
  }
  
  public int getMeasureHeight()
  {
    return (int)Math.ceil(this.mMetrics.descent - this.mMetrics.ascent);
  }
  
  public int lu()
  {
    return Math.abs(this.mMetrics.ascent);
  }
  
  protected void onFreeBitmap(Bitmap paramBitmap)
  {
    if (!inFinalizer()) {
      paramBitmap.recycle();
    }
  }
  
  protected Bitmap onGetBitmap()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, this.mConfig);
    this.mCanvas = new Canvas(localBitmap);
    this.mCanvas.translate(0.0F, -this.mMetrics.ascent);
    this.mCanvas.drawText(this.mText, 0.0F, 0.0F, this.mPaint);
    return localBitmap;
  }
  
  public void setMaxLength(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setMaxLength maxLength: " + paramInt);
    }
    this.mMaxLength = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setWidth width: " + paramInt);
    }
    if (paramInt > 0) {
      this.mMaxWidth = paramInt;
    }
  }
  
  public void setText(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setText text: " + paramString);
    }
    this.mText = paramString;
  }
  
  public void setTextColor(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setTextColor textColor: " + paramInt);
    }
    this.mTextColor = paramInt;
    this.mPaint.setColor(this.mTextColor);
  }
  
  public void setTextSize(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StringTexture", 2, "setTextSize textSize: " + paramFloat);
    }
    this.mTextSize = paramFloat;
    this.mPaint.setTextSize(this.mTextSize);
    this.mMetrics = this.mPaint.getFontMetricsInt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqp
 * JD-Core Version:    0.7.0.1
 */