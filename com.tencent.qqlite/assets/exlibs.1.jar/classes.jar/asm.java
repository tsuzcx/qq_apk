import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import java.util.List;

class asm
  implements Runnable
{
  asm(asl paramasl, List paramList) {}
  
  public void run()
  {
    if (Leba.a(this.jdField_a_of_type_Asl.a) != null)
    {
      Leba.a(this.jdField_a_of_type_Asl.a).clear();
      Leba.a(this.jdField_a_of_type_Asl.a).addAll(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Asl.a.a != null) {
        this.jdField_a_of_type_Asl.a.a.notifyDataSetChanged();
      }
      Leba.b(this.jdField_a_of_type_Asl.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     asm
 * JD-Core Version:    0.7.0.1
 */