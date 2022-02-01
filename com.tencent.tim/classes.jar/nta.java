import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import java.util.HashMap;
import java.util.Map;

public class nta
{
  private int bco = 0;
  private final Map<Character, Float> eR = new HashMap(256);
  private float lj;
  private float lq;
  private final Paint textPaint;
  
  public nta(Paint paramPaint)
  {
    this.textPaint = paramPaint;
    invalidate();
  }
  
  float a(char paramChar)
  {
    if (paramChar == 0) {
      return 0.0F;
    }
    Float localFloat = (Float)this.eR.get(Character.valueOf(paramChar));
    if (localFloat != null) {
      return localFloat.floatValue();
    }
    float f = this.textPaint.measureText(Character.toString(paramChar));
    this.eR.put(Character.valueOf(paramChar), Float.valueOf(f));
    return f;
  }
  
  public float as()
  {
    return this.lj;
  }
  
  public float at()
  {
    return this.lq;
  }
  
  public void invalidate()
  {
    this.eR.clear();
    Paint.FontMetrics localFontMetrics = this.textPaint.getFontMetrics();
    this.lj = (localFontMetrics.bottom - localFontMetrics.top);
    this.lq = (-localFontMetrics.top);
  }
  
  int qU()
  {
    return this.bco;
  }
  
  public void setPreferredScrollingDirection(int paramInt)
  {
    this.bco = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nta
 * JD-Core Version:    0.7.0.1
 */