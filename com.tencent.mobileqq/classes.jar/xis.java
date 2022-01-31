import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import java.util.ArrayList;

public class xis
  implements View.OnClickListener
{
  public xis(CommonHbFragment paramCommonHbFragment, View paramView) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (CommonHbFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment) + 1200L > l) {
      return;
    }
    CommonHbFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment, l);
    paramView = new ArrayList();
    try
    {
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_AndroidViewView.getTag();
      paramView = localArrayList;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment.a.a(CommonHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xis
 * JD-Core Version:    0.7.0.1
 */