import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Task;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskPool;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class epc
  implements Runnable
{
  public epc(TroopFileTransferManager.TaskPool paramTaskPool) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      if (this.a.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        return;
      }
      TroopFileTransferManager.Task localTask = (TroopFileTransferManager.Task)this.a.jdField_a_of_type_JavaUtilLinkedList.remove(0);
      localTask.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     epc
 * JD-Core Version:    0.7.0.1
 */