import android.os.SystemClock;
import com.tencent.common.app.ThreadTracker;
import com.tencent.widget.TraceUtils;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.Vector;

class bvt
  implements Iterator
{
  private Thread jdField_a_of_type_JavaLangThread;
  private final Iterator jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_Bvs.jdField_a_of_type_JavaLangIterable.iterator();
  private boolean jdField_a_of_type_Boolean;
  private Thread b;
  
  bvt(bvs parambvs) {}
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    while ((this.jdField_a_of_type_JavaLangThread == null) && (this.jdField_a_of_type_JavaUtilIterator.hasNext()))
    {
      this.jdField_a_of_type_JavaLangThread = ((Thread)((Reference)this.jdField_a_of_type_JavaUtilIterator.next()).get());
      if ((this.jdField_a_of_type_Bvs.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangThread == null)) {
        this.jdField_a_of_type_JavaUtilIterator.remove();
      }
    }
  }
  
  public Thread a()
  {
    if (!hasNext()) {
      throw new IllegalStateException();
    }
    Thread localThread = this.jdField_a_of_type_JavaLangThread;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangThread = null;
    this.b = localThread;
    return localThread;
  }
  
  public boolean hasNext()
  {
    a();
    return this.jdField_a_of_type_JavaLangThread != null;
  }
  
  public void remove()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException();
    }
    this.jdField_a_of_type_JavaUtilIterator.remove();
    bvu localbvu;
    if (this.b != null)
    {
      if (!this.b.getName().startsWith("SharedPreferencesImpl")) {
        TraceUtils.a("Thread." + this.b.getName() + "." + this.b.getId());
      }
      if (ThreadTracker.a())
      {
        localbvu = ThreadTracker.a(this.b.getId(), ThreadTracker.a);
        if (localbvu == null) {
          break label161;
        }
        bvu.a(localbvu, this.b.getName());
        bvu.a(localbvu, SystemClock.uptimeMillis() - ThreadTracker.a());
      }
    }
    for (;;)
    {
      if (!this.b.getName().startsWith("SharedPreferencesImpl")) {
        TraceUtils.a();
      }
      this.b = null;
      return;
      label161:
      localbvu = new bvu(this.b.getId(), this.b.getName(), 0L, null);
      bvu.a(localbvu, this.b.getName());
      bvu.a(localbvu, SystemClock.uptimeMillis() - ThreadTracker.a());
      ThreadTracker.a.add(localbvu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bvt
 * JD-Core Version:    0.7.0.1
 */