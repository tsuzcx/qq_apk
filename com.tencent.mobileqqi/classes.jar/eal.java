import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.richstatus.MovieDetailActivity;
import com.tencent.qphone.base.util.QLog;

public class eal
  implements View.OnClickListener
{
  public eal(RichStatItemBuilder paramRichStatItemBuilder, int paramInt1, int paramInt2, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOSign", 2, "actionId is:" + this.jdField_a_of_type_Int + ",dataId is:" + this.jdField_b_of_type_Int);
    }
    MovieDetailActivity.a((BaseActivity)RichStatItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eal
 * JD-Core Version:    0.7.0.1
 */