import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.concurrent.atomic.AtomicInteger;

class umb
  implements ThreadExcutor.IThreadListener
{
  umb(uma paramuma, Runnable paramRunnable) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    uma.a(this.jdField_a_of_type_Uma).decrementAndGet();
    wxe.b(uma.a(this.jdField_a_of_type_Uma), "threshold after running current task is " + uma.a(this.jdField_a_of_type_Uma).get());
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      wxe.b(uma.a(this.jdField_a_of_type_Uma), "threshold after running current task is:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
  
  public void onPreRun()
  {
    uma.a(this.jdField_a_of_type_Uma).incrementAndGet();
    wxe.a(uma.a(this.jdField_a_of_type_Uma), "execute %s", this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      wxe.b(uma.a(this.jdField_a_of_type_Uma), "execute hashcode:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     umb
 * JD-Core Version:    0.7.0.1
 */