import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.tencent.mobileqq.activity.EditTagActivity;
import com.tencent.mobileqq.widget.Workspace;
import java.util.ArrayList;

class cka
  implements View.OnClickListener
{
  cka(cjz paramcjz) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof ckb))
    {
      paramView = (ckb)paramView;
      if ((paramView.a >= 0) && (paramView.a < this.a.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramView.a);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a(this.a.jdField_a_of_type_JavaUtilArrayList.size());
        this.a.notifyDataSetChanged();
        int i = 0;
        while (i < this.a.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a.getChildCount())
        {
          ((BaseAdapter)((GridView)this.a.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a.getChildAt(i)).getAdapter()).notifyDataSetChanged();
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cka
 * JD-Core Version:    0.7.0.1
 */