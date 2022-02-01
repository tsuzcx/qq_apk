import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.concurrent.atomic.AtomicInteger;

class wji
  implements ThreadExcutor.IThreadListener
{
  wji(wjh paramwjh, Runnable paramRunnable) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    wjh.a(this.jdField_a_of_type_Wjh).decrementAndGet();
    yuk.b(wjh.a(this.jdField_a_of_type_Wjh), "threshold after running current task is " + wjh.a(this.jdField_a_of_type_Wjh).get());
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      yuk.b(wjh.a(this.jdField_a_of_type_Wjh), "threshold after running current task is:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
  
  public void onPreRun()
  {
    wjh.a(this.jdField_a_of_type_Wjh).incrementAndGet();
    yuk.a(wjh.a(this.jdField_a_of_type_Wjh), "execute %s", this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      yuk.b(wjh.a(this.jdField_a_of_type_Wjh), "execute hashcode:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wji
 * JD-Core Version:    0.7.0.1
 */