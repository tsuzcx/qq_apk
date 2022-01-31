import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import java.util.List;

class cxy
  implements Runnable
{
  cxy(cxx paramcxx, List paramList) {}
  
  public void run()
  {
    if (Leba.a(this.jdField_a_of_type_Cxx.a) != null)
    {
      Leba.a(this.jdField_a_of_type_Cxx.a).clear();
      Leba.a(this.jdField_a_of_type_Cxx.a).addAll(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Cxx.a.a != null) {
        this.jdField_a_of_type_Cxx.a.a.notifyDataSetChanged();
      }
      Leba.a(this.jdField_a_of_type_Cxx.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cxy
 * JD-Core Version:    0.7.0.1
 */