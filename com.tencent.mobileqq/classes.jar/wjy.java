import android.os.Handler;
import com.tencent.biz.qqstory.model.TrimmableManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class wjy
  implements wja
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private CopyOnWriteArraySet<wjb> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  
  public wjy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(new wjz());
  }
  
  private void b(int paramInt)
  {
    ykq.d("TrimmableManager", "trimMemory : level = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((wjb)localIterator.next()).a(paramInt);
    }
    System.gc();
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new TrimmableManager.1(this, paramInt));
  }
  
  public void a(wjb paramwjb)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramwjb);
  }
  
  public void b() {}
  
  public void b(wjb paramwjb)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramwjb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjy
 * JD-Core Version:    0.7.0.1
 */