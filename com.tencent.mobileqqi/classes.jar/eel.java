import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;

public class eel
  implements View.OnClickListener
{
  public eel(NewFriendActivity paramNewFriendActivity, SharedPreferences paramSharedPreferences) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("newfriend_enter_time", System.currentTimeMillis()).commit();
    NewFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eel
 * JD-Core Version:    0.7.0.1
 */