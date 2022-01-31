import android.content.Intent;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class yp
  extends ClickableSpan
{
  public yp(AuthDevActivity paramAuthDevActivity) {}
  
  public void onClick(View paramView)
  {
    Selection.removeSelection(SpannableString.valueOf(AuthDevActivity.a(this.a).getText()));
    paramView = new Intent(this.a, QQBrowserActivity.class);
    paramView.putExtra("url", "http://kf.qq.com/touch/apifaq/1211147RVfAV140617UV3MZn.html?ADTAG=veda.mobileqq.en");
    paramView.putExtra("hide_more_button", true);
    this.a.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16734752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     yp
 * JD-Core Version:    0.7.0.1
 */