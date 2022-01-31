import com.tencent.mobileqq.qcall.QCallDetailActivity;
import java.util.List;

class gjx
  implements Runnable
{
  gjx(gjw paramgjw, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      QCallDetailActivity.a(this.jdField_a_of_type_Gjw.a).jdField_a_of_type_JavaUtilList.clear();
      QCallDetailActivity.a(this.jdField_a_of_type_Gjw.a).jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    QCallDetailActivity.a(this.jdField_a_of_type_Gjw.a, this.jdField_a_of_type_Boolean);
    if (QCallDetailActivity.a(this.jdField_a_of_type_Gjw.a) != null) {
      QCallDetailActivity.a(this.jdField_a_of_type_Gjw.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gjx
 * JD-Core Version:    0.7.0.1
 */