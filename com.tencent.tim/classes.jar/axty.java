import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.common.app.BaseApplicationImpl;

public class axty
{
  int eHh = 0;
  int eHi = 0;
  public int eHj;
  public int eHk;
  public int eHl;
  public int eHm;
  public int eHn = 2;
  public Bitmap mBackground;
  int mHeight = 0;
  public Typeface mTypeface;
  int mWidth = 0;
  
  public int dp2px(float paramFloat)
  {
    return wja.dp2px(paramFloat, BaseApplicationImpl.getApplication().getResources());
  }
  
  public int lN(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder.append("我");
      i += 1;
    }
    TextPaint localTextPaint = new TextPaint();
    if (this.mTypeface != null) {
      localTextPaint.setTypeface(this.mTypeface);
    }
    localTextPaint.setShadowLayer(dp2px(3.0F), dp2px(5.0F), dp2px(5.0F), -1);
    paramInt = wja.dp2px(100.0F, BaseApplicationImpl.getApplication().getResources());
    for (;;)
    {
      localTextPaint.setTextSize(paramInt);
      StaticLayout localStaticLayout = axvp.create(localStringBuilder, 0, localStringBuilder.length(), localTextPaint, this.mWidth, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 1);
      if (localTextPaint.measureText(localStringBuilder.toString()) > this.mWidth)
      {
        paramInt -= 1;
      }
      else
      {
        if (localStaticLayout.getHeight() <= this.mHeight) {
          break;
        }
        paramInt -= 1;
      }
    }
    return paramInt;
  }
  
  public static class a
  {
    int eHh = 0;
    int eHi = 0;
    public int eHj;
    public int eHk;
    public int eHn = 2;
    public Bitmap mBackground;
    int mHeight = 0;
    public Typeface mTypeface;
    int mWidth = 0;
    
    public a a(float paramFloat1, float paramFloat2)
    {
      this.eHj = dp2px(paramFloat1);
      this.eHk = dp2px(paramFloat2);
      return this;
    }
    
    public a a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
    {
      this.mWidth = dp2px(paramFloat1);
      this.mHeight = dp2px(paramFloat2);
      this.eHh = paramInt1;
      this.eHi = paramInt2;
      return this;
    }
    
    public a a(Bitmap paramBitmap)
    {
      this.mBackground = paramBitmap;
      return this;
    }
    
    public a a(Typeface paramTypeface)
    {
      this.mTypeface = paramTypeface;
      return this;
    }
    
    public axty a()
    {
      axty localaxty = new axty();
      a(localaxty);
      return localaxty;
    }
    
    void a(axty paramaxty)
    {
      paramaxty.mBackground = this.mBackground;
      paramaxty.eHj = this.eHj;
      paramaxty.eHk = this.eHk;
      paramaxty.mWidth = this.mWidth;
      paramaxty.mHeight = this.mHeight;
      paramaxty.eHh = this.eHh;
      paramaxty.eHi = this.eHi;
      paramaxty.mTypeface = this.mTypeface;
      paramaxty.eHl = paramaxty.lN(paramaxty.eHh);
      paramaxty.eHm = paramaxty.lN(paramaxty.eHi);
      paramaxty.eHn = this.eHn;
    }
    
    public int dp2px(float paramFloat)
    {
      return wja.dp2px(paramFloat, BaseApplicationImpl.getApplication().getResources());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axty
 * JD-Core Version:    0.7.0.1
 */