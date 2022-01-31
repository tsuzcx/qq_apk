import com.tencent.mobileqq.qcall.QCallDetailActivity;
import java.util.List;

class gfo
  implements Runnable
{
  gfo(gfn paramgfn, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      QCallDetailActivity.a(this.jdField_a_of_type_Gfn.a).jdField_a_of_type_JavaUtilList.clear();
      QCallDetailActivity.a(this.jdField_a_of_type_Gfn.a).jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    QCallDetailActivity.a(this.jdField_a_of_type_Gfn.a, this.jdField_a_of_type_Boolean);
    if (QCallDetailActivity.a(this.jdField_a_of_type_Gfn.a) != null) {
      QCallDetailActivity.a(this.jdField_a_of_type_Gfn.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gfo
 * JD-Core Version:    0.7.0.1
 */