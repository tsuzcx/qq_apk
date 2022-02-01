import android.graphics.Canvas;
import android.text.TextPaint;

public class aeyb
  extends aexy
{
  private TextPaint mTextPaint = new TextPaint();
  
  private String a(aexe paramaexe)
  {
    return String.valueOf(paramaexe.getData());
  }
  
  public aeys a(aexe paramaexe)
  {
    aexx localaexx = aexj.a();
    float f1 = aeyv.a(localaexx.getTextSize(), a(paramaexe)) + localaexx.getPaddingHorizontal() + localaexx.getPaddingHorizontal();
    float f2 = aeyv.l(localaexx.getTextSize());
    f2 = localaexx.getPaddingVertical() * 2.0F + f2;
    paramaexe.setContentHeight(f2);
    paramaexe.setContentWidth(f1);
    return new aeys(f1, f2);
  }
  
  public void b(Canvas paramCanvas, aexe paramaexe, aexj paramaexj, float paramFloat1, float paramFloat2)
  {
    paramaexj = aexj.a();
    this.mTextPaint.setTextSize(paramaexj.getTextSize());
    this.mTextPaint.setColor(-1);
    paramCanvas.drawText(a(paramaexe), paramaexj.getPaddingHorizontal() + paramFloat1, paramaexj.getPaddingVertical() + paramFloat2 - this.mTextPaint.ascent(), this.mTextPaint);
  }
  
  public boolean b(aexe paramaexe)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyb
 * JD-Core Version:    0.7.0.1
 */