import QQService.TagInfo;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.EditTagActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class cjy
  implements CompoundButton.OnCheckedChangeListener
{
  cjy(cjx paramcjx, int paramInt) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_Cjx.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Cjx.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.b.ae)
      {
        this.jdField_a_of_type_Cjx.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Cjx.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int));
        this.jdField_a_of_type_Cjx.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a(this.jdField_a_of_type_Cjx.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Cjx.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_Cjz != null) {
        this.jdField_a_of_type_Cjx.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_Cjz.notifyDataSetChanged();
      }
      return;
      paramCompoundButton.setChecked(false);
      continue;
      int i = 0;
      while (i < this.jdField_a_of_type_Cjx.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((TagInfo)this.jdField_a_of_type_Cjx.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.get(i)).iTagId == ((TagInfo)this.jdField_a_of_type_Cjx.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).iTagId)
        {
          this.jdField_a_of_type_Cjx.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.remove(i);
          this.jdField_a_of_type_Cjx.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a(this.jdField_a_of_type_Cjx.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.size());
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cjy
 * JD-Core Version:    0.7.0.1
 */