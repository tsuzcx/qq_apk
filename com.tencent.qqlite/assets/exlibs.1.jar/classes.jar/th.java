import android.os.SystemClock;
import com.tencent.common.app.ThreadTracker;
import com.tencent.widget.TraceUtils;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.Vector;

class th
  implements Iterator
{
  private Thread jdField_a_of_type_JavaLangThread;
  private final Iterator jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_Tg.jdField_a_of_type_JavaLangIterable.iterator();
  private boolean jdField_a_of_type_Boolean;
  private Thread b;
  
  th(tg paramtg) {}
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    while ((this.jdField_a_of_type_JavaLangThread == null) && (this.jdField_a_of_type_JavaUtilIterator.hasNext()))
    {
      this.jdField_a_of_type_JavaLangThread = ((Thread)((Reference)this.jdField_a_of_type_JavaUtilIterator.next()).get());
      if ((this.jdField_a_of_type_Tg.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangThread == null)) {
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
    ti localti;
    if (this.b != null)
    {
      if (!this.b.getName().startsWith("SharedPreferencesImpl")) {
        TraceUtils.a("Thread." + this.b.getName() + "." + this.b.getId());
      }
      if (ThreadTracker.a())
      {
        localti = ThreadTracker.a(this.b.getId(), ThreadTracker.a);
        if (localti == null) {
          break label161;
        }
        ti.a(localti, this.b.getName());
        ti.a(localti, SystemClock.uptimeMillis() - ThreadTracker.a());
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
      localti = new ti(this.b.getId(), this.b.getName(), 0L, null);
      ti.a(localti, this.b.getName());
      ti.a(localti, SystemClock.uptimeMillis() - ThreadTracker.a());
      ThreadTracker.a.add(localti);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     th
 * JD-Core Version:    0.7.0.1
 */