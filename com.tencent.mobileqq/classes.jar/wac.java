import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.concurrent.atomic.AtomicInteger;

class wac
  implements ThreadExcutor.IThreadListener
{
  wac(wab paramwab, Runnable paramRunnable) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    wab.a(this.jdField_a_of_type_Wab).decrementAndGet();
    ykq.b(wab.a(this.jdField_a_of_type_Wab), "threshold after running current task is " + wab.a(this.jdField_a_of_type_Wab).get());
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ykq.b(wab.a(this.jdField_a_of_type_Wab), "threshold after running current task is:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
  
  public void onPreRun()
  {
    wab.a(this.jdField_a_of_type_Wab).incrementAndGet();
    ykq.a(wab.a(this.jdField_a_of_type_Wab), "execute %s", this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ykq.b(wab.a(this.jdField_a_of_type_Wab), "execute hashcode:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wac
 * JD-Core Version:    0.7.0.1
 */