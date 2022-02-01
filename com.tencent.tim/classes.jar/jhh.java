import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import java.lang.ref.WeakReference;
import java.util.Random;

public class jhh
  extends jhf
{
  private int Rr;
  private int[] cP;
  Random mRandom = new Random();
  
  public jhh(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramContext, paramWeakReference, paramInt1, paramInt2, paramFloat);
    this.cP = new int[] { paramInt1 / 4, (int)(paramInt1 / 3.8D), (int)(paramInt1 / 3.6D), (int)(paramInt1 / 3.4D), (int)(paramInt1 / 3.2D), paramInt1 / 3, (int)(paramInt1 / 2.8D), (int)(paramInt1 / 2.6D) };
    paramInt1 = this.mRandom.nextInt(8);
    this.Rr = this.cP[paramInt1];
  }
  
  protected int cF(int paramInt)
  {
    igd.aJ(this.TAG, "getSPEED: " + this.Rr);
    return this.Rr;
  }
  
  protected void d(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.mPaint.setColor(this.jdField_a_of_type_Jhc$a.azG);
    this.mPaint.setFakeBoldText(true);
    this.mPaint.setStrokeWidth(this.jdField_a_of_type_Jhc$a.hX);
    float f1 = -this.mPaint.getFontMetrics().ascent;
    paramCanvas.drawText((String)this.jdField_a_of_type_Ijn.l, 0.0F, f1, this.mPaint);
    this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.mPaint.setColor(this.jdField_a_of_type_Jhc$a.azF);
    this.mPaint.setFakeBoldText(false);
    this.mPaint.setStrokeWidth(0.0F);
    float f2 = this.jdField_a_of_type_Jhc$a.hX / 6.0F;
    paramCanvas.drawText((String)this.jdField_a_of_type_Ijn.l, 0.0F + f2, f1 - f2, this.mPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhh
 * JD-Core Version:    0.7.0.1
 */