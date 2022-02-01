import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class qry
  extends ClickableSpan
{
  qry(qrx.a parama, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.a.bs(this.atK, this.bnO);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.getColor());
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qry
 * JD-Core Version:    0.7.0.1
 */