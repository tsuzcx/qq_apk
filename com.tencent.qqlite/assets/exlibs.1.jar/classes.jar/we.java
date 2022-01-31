import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class we
  extends LBSObserver
{
  public we(AddFriendActivity paramAddFriendActivity) {}
  
  protected void a(boolean paramBoolean, List paramList, int paramInt)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_JavaUtilList = paramList;
      if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.a.c.setText(2131363376);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.a.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      return;
      paramList = (List)((ArrayList)this.a.jdField_a_of_type_JavaUtilList).clone();
      this.a.app.a(new wf(this, paramList));
      AddFriendActivity.a(this.a);
      continue;
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (!this.a.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        AddFriendActivity.a(this.a);
      }
      else
      {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.a.c.setText(2131363375);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     we
 * JD-Core Version:    0.7.0.1
 */