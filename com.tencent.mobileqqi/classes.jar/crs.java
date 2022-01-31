import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import java.util.List;

class crs
  implements Runnable
{
  crs(crr paramcrr, List paramList) {}
  
  public void run()
  {
    if (Leba.a(this.jdField_a_of_type_Crr.a) != null)
    {
      Leba.a(this.jdField_a_of_type_Crr.a).clear();
      Leba.a(this.jdField_a_of_type_Crr.a).addAll(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Crr.a.a != null) {
        this.jdField_a_of_type_Crr.a.a.notifyDataSetChanged();
      }
      Leba.a(this.jdField_a_of_type_Crr.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     crs
 * JD-Core Version:    0.7.0.1
 */