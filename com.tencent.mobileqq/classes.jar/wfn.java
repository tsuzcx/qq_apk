import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.concurrent.atomic.AtomicInteger;

class wfn
  implements ThreadExcutor.IThreadListener
{
  wfn(wfm paramwfm, Runnable paramRunnable) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    wfm.a(this.jdField_a_of_type_Wfm).decrementAndGet();
    yqp.b(wfm.a(this.jdField_a_of_type_Wfm), "threshold after running current task is " + wfm.a(this.jdField_a_of_type_Wfm).get());
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      yqp.b(wfm.a(this.jdField_a_of_type_Wfm), "threshold after running current task is:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
  
  public void onPreRun()
  {
    wfm.a(this.jdField_a_of_type_Wfm).incrementAndGet();
    yqp.a(wfm.a(this.jdField_a_of_type_Wfm), "execute %s", this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      yqp.b(wfm.a(this.jdField_a_of_type_Wfm), "execute hashcode:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfn
 * JD-Core Version:    0.7.0.1
 */