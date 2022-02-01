import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class vgs
{
  private final List<vhb> jdField_a_of_type_JavaUtilList;
  private final BlockingQueue<vhb> jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private final vhe jdField_a_of_type_Vhe;
  private final vhh<vhb> jdField_a_of_type_Vhh;
  private final vhj jdField_a_of_type_Vhj;
  private final BlockingQueue<vhb> b;
  
  public vgs(vhe paramvhe, vgp paramvgp, vgy paramvgy)
  {
    this.jdField_a_of_type_Vhe = paramvhe;
    this.jdField_a_of_type_Vhj = new vhj(paramvgp, new vhc(1L), paramvhe);
    this.jdField_a_of_type_Vhj.a(paramvhe);
    this.jdField_a_of_type_Vhh = new vhh(paramvgy);
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.b = new LinkedBlockingQueue();
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  List<vhb> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  void a()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      Thread.yield();
    }
    vhb localvhb;
    while (!this.b.isEmpty())
    {
      localvhb = (vhb)this.b.remove();
      this.jdField_a_of_type_Vhh.b(localvhb);
    }
    while (!this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.isEmpty())
    {
      localvhb = (vhb)this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.remove();
      this.jdField_a_of_type_Vhh.a(localvhb);
    }
    this.jdField_a_of_type_Vhj.a(this.jdField_a_of_type_Vhe.a());
    this.jdField_a_of_type_Vhh.a(this.jdField_a_of_type_Vhj, this.jdField_a_of_type_JavaUtilList);
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) {
      Thread.yield();
    }
  }
  
  public void a(List<vhb> paramList)
  {
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.addAll(paramList);
  }
  
  public void b()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      Thread.yield();
    }
    this.jdField_a_of_type_Vhh.a();
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.clear();
    this.b.clear();
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) {
      Thread.yield();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgs
 * JD-Core Version:    0.7.0.1
 */