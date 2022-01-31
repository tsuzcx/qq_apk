import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import java.util.List;

public class gfp
  implements Runnable
{
  public gfp(QCallDetailActivity paramQCallDetailActivity, List paramList) {}
  
  public void run()
  {
    QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).jdField_a_of_type_JavaUtilList.clear();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).jdField_a_of_type_JavaUtilList.clear();
      int i = 20;
      int k = 0;
      while ((k < i) && (k < this.jdField_a_of_type_JavaUtilList.size()))
      {
        int j = i;
        if ((this.jdField_a_of_type_JavaUtilList.get(k) instanceof QCallRecord))
        {
          j = i;
          if (((QCallRecord)this.jdField_a_of_type_JavaUtilList.get(k)).type == QCallRecord.TYPE_DATE) {
            j = i + 1;
          }
          QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).jdField_a_of_type_JavaUtilList.add((QCallRecord)this.jdField_a_of_type_JavaUtilList.get(k));
        }
        k += 1;
        i = j;
      }
    }
    if (QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).jdField_a_of_type_JavaUtilList.size() == 0) {
      QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, true);
    }
    for (;;)
    {
      QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).notifyDataSetChanged();
      return;
      QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gfp
 * JD-Core Version:    0.7.0.1
 */