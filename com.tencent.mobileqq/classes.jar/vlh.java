import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.concurrent.atomic.AtomicInteger;

class vlh
  implements ThreadExcutor.IThreadListener
{
  vlh(vlg paramvlg, Runnable paramRunnable) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    vlg.a(this.jdField_a_of_type_Vlg).decrementAndGet();
    xvv.b(vlg.a(this.jdField_a_of_type_Vlg), "threshold after running current task is " + vlg.a(this.jdField_a_of_type_Vlg).get());
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      xvv.b(vlg.a(this.jdField_a_of_type_Vlg), "threshold after running current task is:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
  
  public void onPreRun()
  {
    vlg.a(this.jdField_a_of_type_Vlg).incrementAndGet();
    xvv.a(vlg.a(this.jdField_a_of_type_Vlg), "execute %s", this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      xvv.b(vlg.a(this.jdField_a_of_type_Vlg), "execute hashcode:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlh
 * JD-Core Version:    0.7.0.1
 */