import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class aesi
  extends ClickableSpan
{
  aesi(aesh paramaesh, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (this.bAP.equals(this.a.d.bAT)) {
      aqlt.b(this.bAP, BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramView.getContext());
    }
    for (;;)
    {
      aesh.aD("0X800AE67", this.bAQ, "");
      return;
      aqrf.cU(paramView.getContext(), this.bAP);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesi
 * JD-Core Version:    0.7.0.1
 */