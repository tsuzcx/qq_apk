import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class feu
  extends ClickableSpan
{
  Context jdField_a_of_type_AndroidContentContext;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public feu(Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = paramString1;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    if (!TextUtils.isEmpty(this.b)) {
      paramView.putExtra("uin", this.b);
    }
    paramView.putExtra("ba_is_login", false);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    paramView.putExtra("hide_more_button", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     feu
 * JD-Core Version:    0.7.0.1
 */