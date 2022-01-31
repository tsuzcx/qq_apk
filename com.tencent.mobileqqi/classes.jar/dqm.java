import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.StrangerManageActivity;
import com.tencent.mobileqq.activity.StrangerManageActivity.StrangeManagerListAdapter;
import com.tencent.mobileqq.data.Stranger;
import java.util.ArrayList;
import java.util.Iterator;

public class dqm
  implements View.OnClickListener
{
  public dqm(StrangerManageActivity paramStrangerManageActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramView.hasNext()) {
      ((Stranger)paramView.next()).uiSelected = true;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter.notifyDataSetChanged();
    this.a.c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dqm
 * JD-Core Version:    0.7.0.1
 */