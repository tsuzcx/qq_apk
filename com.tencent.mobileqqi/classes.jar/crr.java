import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import java.util.List;

class crr
  implements Runnable
{
  crr(crq paramcrq, List paramList) {}
  
  public void run()
  {
    if (Leba.a(this.jdField_a_of_type_Crq.a) != null)
    {
      Leba.a(this.jdField_a_of_type_Crq.a).clear();
      Leba.a(this.jdField_a_of_type_Crq.a).addAll(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Crq.a.a != null) {
        this.jdField_a_of_type_Crq.a.a.notifyDataSetChanged();
      }
      Leba.a(this.jdField_a_of_type_Crq.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     crr
 * JD-Core Version:    0.7.0.1
 */