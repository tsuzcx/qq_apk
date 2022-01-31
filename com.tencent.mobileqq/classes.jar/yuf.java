import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;

public class yuf
  implements Runnable
{
  public yuf(HotChatCenterFragment paramHotChatCenterFragment, int paramInt, TextView paramTextView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment.isAdded())
    {
      String str1 = "" + this.jdField_a_of_type_Int;
      if (!HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment))
      {
        str1 = this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment.getString(2131433311) + "(" + this.jdField_a_of_type_Int + ")";
        if (this.jdField_a_of_type_Int > 99) {
          str1 = this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment.getString(2131433311) + "(99+)";
        }
        if (this.jdField_a_of_type_Int <= 0) {
          str1 = this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment.getString(2131433311);
        }
      }
      String str2 = str1;
      if (HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment))
      {
        str2 = str1;
        if (this.jdField_a_of_type_Int > 99) {
          str2 = "99+";
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment.isAdded()) {
        this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment.getActivity().runOnUiThread(new yug(this, str2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yuf
 * JD-Core Version:    0.7.0.1
 */