import android.os.Handler;
import com.tencent.biz.qqstory.model.TrimmableManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class wtn
  implements wsp
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private CopyOnWriteArraySet<wsq> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  
  public wtn()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(new wto());
  }
  
  private void b(int paramInt)
  {
    yuk.d("TrimmableManager", "trimMemory : level = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((wsq)localIterator.next()).a(paramInt);
    }
    System.gc();
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new TrimmableManager.1(this, paramInt));
  }
  
  public void a(wsq paramwsq)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramwsq);
  }
  
  public void b() {}
  
  public void b(wsq paramwsq)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramwsq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtn
 * JD-Core Version:    0.7.0.1
 */