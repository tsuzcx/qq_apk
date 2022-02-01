import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class aeqt
  extends ClickableSpan
{
  aeqt(aeqs.a parama, String paramString, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    aqlt.b(this.val$url, BaseApplicationImpl.getApplication().getRuntime().getAccount(), (Activity)this.val$context);
    anot.a(null, "dc00898", "", "", aeqs.a.a(this.d), aeqs.a.a(this.d), 2, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeqt
 * JD-Core Version:    0.7.0.1
 */