import com.tencent.mobileqq.adapter.TroopListAdapter2;
import java.util.List;

class yfi
  implements Runnable
{
  yfi(yfh paramyfh, List paramList) {}
  
  public void run()
  {
    this.jdField_a_of_type_Yfh.a.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Yfh.a.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    TroopListAdapter2.a(this.jdField_a_of_type_Yfh.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yfi
 * JD-Core Version:    0.7.0.1
 */