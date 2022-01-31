import android.content.Intent;
import android.os.Handler;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;

class tqp
  extends ClickableSpan
{
  tqp(tqo paramtqo, String paramString) {}
  
  public void onClick(View paramView)
  {
    Selection.removeSelection(SpannableString.valueOf(this.jdField_a_of_type_JavaLangString));
    if (TextUtils.isEmpty(RegisterVerifyCodeActivity.b(this.jdField_a_of_type_Tqo.a))) {}
    while (!RegisterVerifyCodeActivity.a(this.jdField_a_of_type_Tqo.a)) {
      return;
    }
    RegisterVerifyCodeActivity.a(this.jdField_a_of_type_Tqo.a, false);
    this.jdField_a_of_type_Tqo.a.a.postDelayed(new tqq(this), 1000L);
    paramView = new Intent(this.jdField_a_of_type_Tqo.a, QQBrowserActivity.class);
    paramView.putExtra("url", RegisterVerifyCodeActivity.b(this.jdField_a_of_type_Tqo.a));
    paramView.putExtra("hide_more_button", true);
    this.jdField_a_of_type_Tqo.a.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16734752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tqp
 * JD-Core Version:    0.7.0.1
 */