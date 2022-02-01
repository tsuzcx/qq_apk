import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.mobileqq.theme.ThemeUtil;

public class auvj
{
  public static int euK = 1;
  public static int euL = 2;
  public static int euM = 3;
  RectF an = new RectF();
  private int caO = ThemeUtil.NIGHTMODE_MASKCOLOR;
  boolean cbQ = true;
  boolean dlb = false;
  private int euN = euK;
  int euO;
  Paint mMaskPaint = new Paint();
  
  public auvj()
  {
    this.mMaskPaint.setAntiAlias(true);
    this.mMaskPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
    this.euO = this.mMaskPaint.getColor();
  }
  
  public static boolean aJN()
  {
    return "2920".equals(ThemeUtil.curThemeId);
  }
  
  public static boolean isNightMode()
  {
    return ("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId));
  }
  
  public void a(Canvas paramCanvas, auvj.a parama)
  {
    if ((paramCanvas == null) || (parama == null)) {
      return;
    }
    if ((this.cbQ) && (isNightMode()))
    {
      this.an.set(0.0F, 0.0F, parama.getWidth(), parama.getHeight());
      int i = this.euN;
      if (aJN()) {
        i = euM;
      }
      if (i == euK)
      {
        parama.L(paramCanvas);
        this.mMaskPaint.setColorFilter(null);
        this.mMaskPaint.setColor(this.caO);
        paramCanvas.drawRoundRect(this.an, this.an.centerX(), this.an.centerY(), this.mMaskPaint);
        return;
      }
      if (i == euL)
      {
        parama.L(paramCanvas);
        this.mMaskPaint.setColorFilter(null);
        this.mMaskPaint.setColor(this.caO);
        paramCanvas.drawRect(this.an, this.mMaskPaint);
        return;
      }
      if (this.mMaskPaint.getColorFilter() == null) {
        this.mMaskPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
      }
      this.mMaskPaint.setColor(this.euO);
      paramCanvas.saveLayer(null, this.mMaskPaint, 31);
      parama.L(paramCanvas);
      paramCanvas.restore();
      return;
    }
    parama.L(paramCanvas);
  }
  
  public void setMaskShape(int paramInt)
  {
    this.euN = paramInt;
  }
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    this.cbQ = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void L(Canvas paramCanvas);
    
    public abstract int getHeight();
    
    public abstract int getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auvj
 * JD-Core Version:    0.7.0.1
 */