import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import java.util.ArrayList;

public class aiwr
{
  public aiwq a = new aiwq();
  public aiwq b = new aiwq();
  public final int dfA;
  public final int dfB;
  public final int dfy;
  private final int dfz;
  public final String mText;
  public final ArrayList<aiwm> xv;
  
  public aiwr(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<aiwm> paramArrayList)
  {
    this.dfy = paramInt1;
    this.dfz = paramInt2;
    this.dfA = paramInt3;
    this.dfB = paramInt4;
    this.mText = paramString;
    this.xv = paramArrayList;
  }
  
  public aiwr(String paramString, int paramInt1, int paramInt2, ArrayList<aiwm> paramArrayList)
  {
    this.dfy = paramInt1;
    this.dfz = paramInt2;
    this.dfA = 0;
    this.dfB = 0;
    this.mText = paramString;
    this.xv = paramArrayList;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2)
  {
    a(paramCanvas, paramInt1, paramInt2, paramPaint1, paramPaint2, null, null, 1);
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt3)
  {
    paramInt1 = this.dfy + paramInt1;
    if ((this.a != null) && (this.a.mBitmap != null) && (!this.a.mBitmap.isRecycled()))
    {
      paramBitmap1 = new Rect(paramInt1 - this.a.mPadding - this.a.mBitmap.getWidth(), (int)(paramInt2 - paramPaint1.getTextSize()), paramInt1 - this.a.mPadding, (int)(this.a.mBitmap.getHeight() + paramInt2 - paramPaint1.getTextSize()));
      paramCanvas.drawBitmap(this.a.mBitmap, null, paramBitmap1, null);
    }
    paramCanvas.drawText(this.mText, paramInt1 - paramInt3, paramInt2 - paramInt3, paramPaint2);
    paramCanvas.drawText(this.mText, paramInt1, paramInt2 - paramInt3, paramPaint2);
    paramCanvas.drawText(this.mText, paramInt1 + paramInt3, paramInt2 - paramInt3, paramPaint2);
    paramCanvas.drawText(this.mText, paramInt1 + paramInt3, paramInt2, paramPaint2);
    paramCanvas.drawText(this.mText, paramInt1 + paramInt3, paramInt2 + paramInt3, paramPaint2);
    paramCanvas.drawText(this.mText, paramInt1, paramInt2 + paramInt3, paramPaint2);
    paramCanvas.drawText(this.mText, paramInt1 - paramInt3, paramInt2 + paramInt3, paramPaint2);
    paramCanvas.drawText(this.mText, paramInt1 - paramInt3, paramInt2, paramPaint2);
    paramCanvas.drawText(this.mText, paramInt1, paramInt2, paramPaint1);
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, Paint paramPaint3, int paramInt3, float paramFloat1, float paramFloat2, int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    int i = this.dfz;
    paramFloat2 += this.dfz;
    paramPaint3.setShader(new LinearGradient(paramFloat2, paramInt2, paramFloat2 + paramFloat1, paramInt2, paramArrayOfInt, paramArrayOfFloat, Shader.TileMode.CLAMP));
    if (paramInt3 > 0)
    {
      paramArrayOfInt = (aiwm)this.xv.get(paramInt3 - 1);
      paramCanvas.drawText(this.mText.substring(0, paramArrayOfInt.mEnd), paramInt1 + i, paramInt2, paramPaint2);
    }
    paramPaint2 = (aiwm)this.xv.get(paramInt3);
    if (paramInt3 == this.xv.size() - 1) {}
    for (paramPaint2 = this.mText.substring(paramPaint2.mStart, this.mText.length());; paramPaint2 = this.mText.substring(paramPaint2.mStart, paramPaint2.mEnd))
    {
      paramCanvas.drawText(paramPaint2, paramFloat2, paramInt2, paramPaint3);
      if (paramInt3 < this.xv.size() - 1)
      {
        paramPaint2 = (aiwm)this.xv.get(paramInt3 + 1);
        paramCanvas.drawText(this.mText.substring(paramPaint2.mStart, this.mText.length()), paramFloat2 + paramFloat1, paramInt2, paramPaint1);
      }
      return;
    }
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = this.dfz;; i = this.dfy)
    {
      paramCanvas.drawText(this.mText, i + paramInt1, paramInt2, paramPaint);
      return;
    }
  }
  
  public long getEndTime()
  {
    if ((this.xv != null) && (this.xv.size() > 0))
    {
      aiwm localaiwm = (aiwm)this.xv.get(this.xv.size() - 1);
      long l = localaiwm.mStartTime;
      return localaiwm.mDuration + l;
    }
    return 0L;
  }
  
  public long getStartTime()
  {
    if ((this.xv != null) && (this.xv.size() > 0)) {
      return ((aiwm)this.xv.get(0)).mStartTime;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiwr
 * JD-Core Version:    0.7.0.1
 */