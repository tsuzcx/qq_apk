import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class sjt
  extends ClickableSpan
{
  private int QB;
  private sjt.a a;
  private String text;
  private String url;
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.an(this.url, this.text);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.QB != -2147483648)
    {
      paramTextPaint.setColor(this.QB);
      return;
    }
    super.updateDrawState(paramTextPaint);
  }
  
  public static abstract interface a
  {
    public abstract void an(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjt
 * JD-Core Version:    0.7.0.1
 */