import android.os.Handler;
import com.tencent.biz.qqstory.model.TrimmableManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class urx
  implements uqz
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private CopyOnWriteArraySet<ura> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  
  public urx()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(new ury());
  }
  
  private void b(int paramInt)
  {
    wsv.d("TrimmableManager", "trimMemory : level = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((ura)localIterator.next()).a(paramInt);
    }
    System.gc();
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new TrimmableManager.1(this, paramInt));
  }
  
  public void a(ura paramura)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramura);
  }
  
  public void b() {}
  
  public void b(ura paramura)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramura);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     urx
 * JD-Core Version:    0.7.0.1
 */