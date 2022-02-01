import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPublish;

public class mcf
  extends ClickableSpan
{
  public mcf(ComponentHeaderPublish paramComponentHeaderPublish) {}
  
  public void onClick(View paramView)
  {
    kxm.a(this.b.getContext(), this.b.a.a.a(), 1, false, 8, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14132075);
    paramTextPaint.setTextSize(wja.a(2, 14, this.b.getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mcf
 * JD-Core Version:    0.7.0.1
 */