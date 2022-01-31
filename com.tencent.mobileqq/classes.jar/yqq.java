import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troopgift.RadioViewPager;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class yqq
  implements View.OnClickListener
{
  public yqq(RadioViewPager paramRadioViewPager, Context paramContext, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("selfSet_leftViewText", alpo.a(2131713080));
    paramView.putExtra("hide_more_button", true);
    paramView.putExtra("hide_operation_bar", true);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yqq
 * JD-Core Version:    0.7.0.1
 */