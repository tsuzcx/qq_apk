import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;

public class xwf
  implements View.OnFocusChangeListener
{
  public xwf(PhoneContactSelectActivity paramPhoneContactSelectActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.a.l == 0) || (this.a.l == 1) || (this.a.l == 2) || (this.a.l == 3) || (this.a.l != this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())))
    {
      paramView = ((SelectMemberInnerFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a();
      if (paramView != null)
      {
        FragmentTransaction localFragmentTransaction = this.a.getSupportFragmentManager().beginTransaction();
        if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
          localFragmentTransaction.remove(this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment);
        }
        localFragmentTransaction.add(2131363900, paramView);
        localFragmentTransaction.commit();
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment = paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xwf
 * JD-Core Version:    0.7.0.1
 */