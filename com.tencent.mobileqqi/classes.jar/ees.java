import com.tencent.mobileqq.activity.contact.newfriend.RecommendListView;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.List;

class ees
  implements Runnable
{
  ees(eer parameer, List paramList) {}
  
  public void run()
  {
    this.jdField_a_of_type_Eer.a.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    if ((this.jdField_a_of_type_Eer.a.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Eer.a.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (this.jdField_a_of_type_Eer.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a() != this.jdField_a_of_type_Eer.a.jdField_a_of_type_Efb) {
        this.jdField_a_of_type_Eer.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Eer.a.jdField_a_of_type_Efb);
      }
      this.jdField_a_of_type_Eer.a.jdField_a_of_type_Efb.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Eer.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(null);
    this.jdField_a_of_type_Eer.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.jdField_a_of_type_Eer.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ees
 * JD-Core Version:    0.7.0.1
 */