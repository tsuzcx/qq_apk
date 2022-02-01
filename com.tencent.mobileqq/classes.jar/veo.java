import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class veo
{
  private final List<vex> jdField_a_of_type_JavaUtilList;
  private final BlockingQueue<vex> jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private final vfa jdField_a_of_type_Vfa;
  private final vfd<vex> jdField_a_of_type_Vfd;
  private final vff jdField_a_of_type_Vff;
  private final BlockingQueue<vex> b;
  
  public veo(vfa paramvfa, vel paramvel, veu paramveu)
  {
    this.jdField_a_of_type_Vfa = paramvfa;
    this.jdField_a_of_type_Vff = new vff(paramvel, new vey(1L), paramvfa);
    this.jdField_a_of_type_Vff.a(paramvfa);
    this.jdField_a_of_type_Vfd = new vfd(paramveu);
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.b = new LinkedBlockingQueue();
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  List<vex> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  void a()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      Thread.yield();
    }
    vex localvex;
    while (!this.b.isEmpty())
    {
      localvex = (vex)this.b.remove();
      this.jdField_a_of_type_Vfd.b(localvex);
    }
    while (!this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.isEmpty())
    {
      localvex = (vex)this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.remove();
      this.jdField_a_of_type_Vfd.a(localvex);
    }
    this.jdField_a_of_type_Vff.a(this.jdField_a_of_type_Vfa.a());
    this.jdField_a_of_type_Vfd.a(this.jdField_a_of_type_Vff, this.jdField_a_of_type_JavaUtilList);
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) {
      Thread.yield();
    }
  }
  
  public void a(List<vex> paramList)
  {
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.addAll(paramList);
  }
  
  public void b()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      Thread.yield();
    }
    this.jdField_a_of_type_Vfd.a();
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.clear();
    this.b.clear();
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) {
      Thread.yield();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     veo
 * JD-Core Version:    0.7.0.1
 */