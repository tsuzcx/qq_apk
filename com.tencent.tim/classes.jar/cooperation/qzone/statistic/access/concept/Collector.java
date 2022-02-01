package cooperation.qzone.statistic.access.concept;

import awbd;
import awbf;
import awbh;
import awbk;
import awbm;
import cooperation.qzone.statistic.access.WnsKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collector
  implements Runnable
{
  protected List<Statistic> LO = new ArrayList();
  protected awbf a;
  protected awbh a;
  protected awbk a;
  protected awbm a;
  protected volatile long aAG;
  protected long aAH = 3000L;
  protected awbd b = awbd.a;
  protected volatile boolean dpJ;
  protected volatile boolean flush;
  protected volatile boolean isWorking = true;
  protected Thread thread;
  
  public Collector()
  {
    this.jdField_a_of_type_Awbf = awbf.b;
    this.jdField_a_of_type_Awbk = awbk.b;
    this.jdField_a_of_type_Awbh = awbh.b;
    this.jdField_a_of_type_Awbm = new awbm();
  }
  
  public awbd a()
  {
    return this.b;
  }
  
  public awbh a()
  {
    return this.jdField_a_of_type_Awbh;
  }
  
  public awbk a()
  {
    return this.jdField_a_of_type_Awbk;
  }
  
  public awbm a()
  {
    return this.jdField_a_of_type_Awbm;
  }
  
  public void a(awbd paramawbd)
  {
    this.b = paramawbd;
  }
  
  public void a(awbf paramawbf)
  {
    this.jdField_a_of_type_Awbf = paramawbf;
  }
  
  public void a(awbh paramawbh)
  {
    this.jdField_a_of_type_Awbh = paramawbh;
  }
  
  public void a(awbk paramawbk)
  {
    this.jdField_a_of_type_Awbk = paramawbk;
  }
  
  public void b(Statistic paramStatistic)
  {
    this.jdField_a_of_type_Awbm.put(paramStatistic);
  }
  
  public void bdi()
  {
    if ((this.thread != null) && (this.thread.isAlive()))
    {
      this.isWorking = false;
      this.thread.interrupt();
    }
    this.thread = new Thread(this, "com.qzone.statistic.access.concept");
    this.isWorking = true;
    this.thread.setName("Statistic.Collector");
    if (!this.thread.isAlive()) {
      this.thread.start();
    }
    this.aAG = System.currentTimeMillis();
  }
  
  public void doWork()
  {
    boolean bool = true;
    eCZ();
    List localList;
    Object localObject1;
    if ((this.jdField_a_of_type_Awbf.a(this)) || (this.flush))
    {
      this.flush = false;
      localList = this.jdField_a_of_type_Awbm.hA();
      if ((localList != null) && (localList.size() > 0))
      {
        if (this.dpJ) {
          i = 1;
        }
        for (;;)
        {
          localObject1 = localList.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((Statistic)((Iterator)localObject1).next()).setValue(WnsKeys.Frequency, Integer.valueOf(i));
          }
          if (a() == null) {
            i = 1;
          } else {
            i = a().getFrequency();
          }
        }
        localObject1 = localList.toArray();
        if (this.LO.size() > 0) {
          localList.addAll(this.LO);
        }
        this.LO.clear();
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          this.LO.add((Statistic)localObject2);
          i += 1;
        }
        localObject1 = a().Z(localList);
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          if (!this.dpJ) {
            break label284;
          }
          this.dpJ = false;
          if (!bool) {
            break label302;
          }
        }
      }
    }
    label284:
    label302:
    for (int i = a().aw((String)localObject1, localList.size());; i = 0)
    {
      if (i == 0) {
        this.LO.clear();
      }
      eCY();
      return;
      if (a() == null) {
        break;
      }
      bool = a().aMa();
      break;
    }
  }
  
  public void eCY()
  {
    this.aAG = System.currentTimeMillis();
  }
  
  public void eCZ()
  {
    if (this.aAH > 0L) {}
    try
    {
      Thread.sleep(this.aAH);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public void eDa()
  {
    try
    {
      this.dpJ = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void flush()
  {
    this.flush = true;
    if ((this.thread != null) && (this.thread.isAlive())) {
      this.thread.interrupt();
    }
  }
  
  public long iQ()
  {
    return this.aAG;
  }
  
  public boolean isStopped()
  {
    return !this.isWorking;
  }
  
  public void onStop()
  {
    doWork();
  }
  
  public void run()
  {
    while (this.isWorking) {
      doWork();
    }
    onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.statistic.access.concept.Collector
 * JD-Core Version:    0.7.0.1
 */