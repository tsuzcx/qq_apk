import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.activity.qwallet.widget.ViewTransformer;
import java.util.ArrayList;
import java.util.List;

public class wzt
  implements View.OnClickListener
{
  public wzt(CommonHbFragment paramCommonHbFragment, ViewTransformer paramViewTransformer, TextView paramTextView, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((CommonHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment) != 0L) && (System.currentTimeMillis() - CommonHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment) < 1000L)) {
      return;
    }
    CommonHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment, l);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment.a = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetViewTransformer.startTransform();
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty((String)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetViewTransformer.getTag())) {
          break label246;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetViewTransformer.setTag("check");
        this.jdField_a_of_type_AndroidWidgetTextView.setText("当前指定人领取，");
        this.jdField_a_of_type_AndroidWidgetButton.setText("改为所有成员可抢");
        if ((CommonHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment) == null) || (CommonHbFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment) == null)) {
          break label274;
        }
        int i = CommonHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment).getCurrentItem();
        paramView = (View)CommonHbFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment).get(i);
        if (paramView == null) {
          break label274;
        }
        paramView = paramView.getTag();
        if (paramView == null)
        {
          CommonHbFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment).setText("");
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetViewTransformer.performClick();
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      try
      {
        paramView = (ArrayList)paramView;
        if ((paramView == null) || (paramView.size() < 0)) {
          continue;
        }
        CommonHbFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment).setText(String.valueOf(paramView.size()));
      }
      catch (Exception paramView)
      {
        CommonHbFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment).setText("");
        paramView.printStackTrace();
      }
      continue;
      label246:
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetViewTransformer.setTag("");
      this.jdField_a_of_type_AndroidWidgetTextView.setText("当前所有成员可抢，");
      this.jdField_a_of_type_AndroidWidgetButton.setText("改为指定人领取");
      return;
      label274:
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzt
 * JD-Core Version:    0.7.0.1
 */