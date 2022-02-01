import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

final class iws
  extends ClickableSpan
{
  iws(iwx paramiwx) {}
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.a.r();
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iws
 * JD-Core Version:    0.7.0.1
 */