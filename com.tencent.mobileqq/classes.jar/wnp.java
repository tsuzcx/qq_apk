import com.tencent.mobileqq.activity.contacts.adapter.PhoneContactAdapter;
import com.tencent.mobileqq.activity.contacts.fragment.PhoneContactFragment;

class wnp
  implements Runnable
{
  wnp(wno paramwno, boolean paramBoolean) {}
  
  public void run()
  {
    PhoneContactFragment.a(this.jdField_a_of_type_Wno.a, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Wno.a.a != null) {
      this.jdField_a_of_type_Wno.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wnp
 * JD-Core Version:    0.7.0.1
 */