import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.concurrent.atomic.AtomicInteger;

class uhs
  implements ThreadExcutor.IThreadListener
{
  uhs(uhr paramuhr, Runnable paramRunnable) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    uhr.a(this.jdField_a_of_type_Uhr).decrementAndGet();
    wsv.b(uhr.a(this.jdField_a_of_type_Uhr), "threshold after running current task is " + uhr.a(this.jdField_a_of_type_Uhr).get());
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      wsv.b(uhr.a(this.jdField_a_of_type_Uhr), "threshold after running current task is:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
  
  public void onPreRun()
  {
    uhr.a(this.jdField_a_of_type_Uhr).incrementAndGet();
    wsv.a(uhr.a(this.jdField_a_of_type_Uhr), "execute %s", this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      wsv.b(uhr.a(this.jdField_a_of_type_Uhr), "execute hashcode:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhs
 * JD-Core Version:    0.7.0.1
 */