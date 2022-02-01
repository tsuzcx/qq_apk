import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

public class ahcz
  extends ClickableSpan
{
  private View.OnClickListener onClickListener;
  private ColorStateList p;
  private boolean pressed;
  private ColorStateList q;
  
  public ahcz(View.OnClickListener paramOnClickListener, ColorStateList paramColorStateList)
  {
    this(paramOnClickListener, paramColorStateList, null);
  }
  
  public ahcz(View.OnClickListener paramOnClickListener, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
  {
    this.onClickListener = paramOnClickListener;
    this.p = paramColorStateList1;
    this.q = paramColorStateList2;
  }
  
  public void onClick(View paramView)
  {
    if (this.onClickListener != null) {
      this.onClickListener.onClick(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    if (this.p != null) {
      if (this.pressed)
      {
        i = this.p.getColorForState(new int[] { 16842919 }, 0);
        paramTextPaint.setColor(i);
        label46:
        if (this.q == null) {
          break label122;
        }
        if (!this.pressed) {
          break label107;
        }
      }
    }
    label107:
    for (int i = this.q.getColorForState(new int[] { 16842919 }, 0);; i = this.q.getColorForState(new int[0], 0))
    {
      paramTextPaint.bgColor = i;
      return;
      i = this.p.getColorForState(new int[0], 0);
      break;
      paramTextPaint.setColor(-16777216);
      break label46;
    }
    label122:
    paramTextPaint.bgColor = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcz
 * JD-Core Version:    0.7.0.1
 */