import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;

public class sjs
  extends ClickableSpan
{
  private sjs.a a;
  private int bxp;
  private ColorStateList e;
  private String xL;
  
  public void onClick(View paramView)
  {
    if ((!TextUtils.isEmpty(this.xL)) && (this.a != null)) {
      this.a.onClick(this.xL);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.bxp > 0) {
      paramTextPaint.setColor(this.bxp);
    }
    if (this.e != null) {
      paramTextPaint.setColor(this.e.getColorForState(paramTextPaint.drawableState, 0));
    }
    paramTextPaint.setUnderlineText(false);
  }
  
  public static abstract interface a
  {
    public abstract void onClick(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjs
 * JD-Core Version:    0.7.0.1
 */