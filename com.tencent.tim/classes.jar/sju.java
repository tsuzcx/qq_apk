import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;

public class sju
  extends ClickableSpan
{
  private sju.a a;
  private ColorStateList f;
  private String uin;
  private int userNameColor;
  
  public sju(String paramString, int paramInt, sju.a parama)
  {
    this.uin = paramString;
    this.userNameColor = paramInt;
    this.a = parama;
  }
  
  public sju(String paramString, ColorStateList paramColorStateList, sju.a parama)
  {
    this.uin = paramString;
    this.f = paramColorStateList;
    this.a = parama;
  }
  
  public void onClick(View paramView)
  {
    if ((!TextUtils.isEmpty(this.uin)) && (this.a != null)) {
      this.a.fW(this.uin);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.userNameColor > 0) {
      paramTextPaint.setColor(this.userNameColor);
    }
    if (this.f != null) {
      paramTextPaint.setColor(this.f.getColorForState(paramTextPaint.drawableState, 0));
    }
    paramTextPaint.setUnderlineText(false);
  }
  
  public static abstract interface a
  {
    public abstract boolean fW(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sju
 * JD-Core Version:    0.7.0.1
 */