import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class btj
  extends LBSObserver
{
  public btj(AddFriendActivity paramAddFriendActivity) {}
  
  protected void a(boolean paramBoolean, List paramList, int paramInt)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_JavaUtilList = paramList;
      if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.a.c.setText(2131561438);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.a.b(this.a.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      return;
      paramList = (List)((ArrayList)this.a.jdField_a_of_type_JavaUtilList).clone();
      this.a.b.a(new btk(this, paramList));
      AddFriendActivity.a(this.a);
      continue;
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (!this.a.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        AddFriendActivity.a(this.a);
      }
      else
      {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.a.c.setText(2131563113);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     btj
 * JD-Core Version:    0.7.0.1
 */