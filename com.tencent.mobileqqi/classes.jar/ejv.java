import com.tencent.mobileqq.activity.contact.newfriend.RecommendListView;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.List;

class ejv
  implements Runnable
{
  ejv(eju parameju, List paramList) {}
  
  public void run()
  {
    this.jdField_a_of_type_Eju.a.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    if ((this.jdField_a_of_type_Eju.a.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Eju.a.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (this.jdField_a_of_type_Eju.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a() != this.jdField_a_of_type_Eju.a.jdField_a_of_type_Eke) {
        this.jdField_a_of_type_Eju.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Eju.a.jdField_a_of_type_Eke);
      }
      this.jdField_a_of_type_Eju.a.jdField_a_of_type_Eke.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Eju.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(null);
    this.jdField_a_of_type_Eju.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.jdField_a_of_type_Eju.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ejv
 * JD-Core Version:    0.7.0.1
 */