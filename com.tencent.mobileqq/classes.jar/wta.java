import com.tencent.mobileqq.activity.contacts.adapter.PhoneContactAdapter;
import com.tencent.mobileqq.activity.contacts.fragment.PhoneContactFragment;

class wta
  implements Runnable
{
  wta(wsz paramwsz, boolean paramBoolean) {}
  
  public void run()
  {
    PhoneContactFragment.a(this.jdField_a_of_type_Wsz.a, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Wsz.a.a != null) {
      this.jdField_a_of_type_Wsz.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wta
 * JD-Core Version:    0.7.0.1
 */