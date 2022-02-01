import cooperation.qzone.statistic.access.concept.Statistic;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class awbm
{
  protected volatile ConcurrentLinkedQueue<Statistic> U = new ConcurrentLinkedQueue();
  
  public List<Statistic> ar(int paramInt)
  {
    Object localObject;
    if (paramInt < 1)
    {
      localObject = null;
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i = Math.min(paramInt, size());
    paramInt = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (paramInt >= i) {
        break;
      }
      localObject = b();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      paramInt += 1;
    }
  }
  
  public Statistic b()
  {
    return (Statistic)this.U.poll();
  }
  
  public List<Statistic> hA()
  {
    return ar(size());
  }
  
  public void put(Statistic paramStatistic)
  {
    this.U.add(paramStatistic);
  }
  
  public int size()
  {
    return this.U.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awbm
 * JD-Core Version:    0.7.0.1
 */