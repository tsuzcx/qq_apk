import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Map;

public class aeyv
{
  private static final Rect P = new Rect();
  private static int QA;
  public static Paint T;
  public static Paint bT;
  private static final TextPaint c = new TextPaint();
  private static final Map<Float, Float> cl = new HashMap();
  private static final Map<Float, Float> ke = new HashMap();
  private static final Map<Float, Float> kf = new HashMap();
  
  static
  {
    T = new Paint();
    T.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  public static float a(float paramFloat, String paramString)
  {
    c.setTextSize(paramFloat);
    return getTextWidth(c, paramString);
  }
  
  public static float a(aexx paramaexx)
  {
    return l(paramaexx.getTextSize()) + aexj.a().getMarginVertical() * 2 + paramaexx.getBorderWidth() * 2.0F + paramaexx.getPaddingVertical() * 2.0F;
  }
  
  public static void a(Canvas paramCanvas, String paramString)
  {
    if (bT == null)
    {
      bT = new Paint();
      bT.setColor(-256);
      Object localObject = aewr.a().a().d().getDisplayMetrics();
      bT.setTextSize(((DisplayMetrics)localObject).density * 12.5F);
      localObject = bT.getFontMetrics();
      QA = (int)Math.ceil(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent);
    }
    paramCanvas.drawText(paramString, 10.0F, paramCanvas.getHeight() - QA, bT);
  }
  
  public static void clearCanvas(Canvas paramCanvas)
  {
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
  }
  
  public static float getTextWidth(Paint paramPaint, String paramString)
  {
    return paramPaint.measureText(paramString);
  }
  
  public static float l(float paramFloat)
  {
    c.setTextSize(paramFloat);
    Float localFloat = (Float)cl.get(Float.valueOf(paramFloat));
    Object localObject = localFloat;
    if (localFloat == null)
    {
      localObject = c.getFontMetrics();
      float f1 = ((Paint.FontMetrics)localObject).descent;
      float f2 = ((Paint.FontMetrics)localObject).ascent;
      localObject = Float.valueOf(((Paint.FontMetrics)localObject).leading + (f1 - f2));
      cl.put(Float.valueOf(paramFloat), localObject);
    }
    return ((Float)localObject).floatValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyv
 * JD-Core Version:    0.7.0.1
 */