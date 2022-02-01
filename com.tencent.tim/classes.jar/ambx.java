import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ambx
{
  private CopyOnWriteArrayList<Integer> ao = new CopyOnWriteArrayList();
  private AtomicInteger bH = new AtomicInteger(0);
  private AtomicInteger bI = new AtomicInteger(10);
  private final Object cj = new Object();
  private final Object mLock = new Object();
  
  public int Iw()
  {
    return this.bH.get();
  }
  
  public int Ix()
  {
    return this.bI.get();
  }
  
  public int Iy()
  {
    if ((this.ao != null) && (!this.ao.isEmpty()))
    {
      int i;
      synchronized (this.cj)
      {
        i = ((Integer)this.ao.get(0)).intValue();
        if (!QLog.isColorLevel()) {
          break label160;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = this.ao.iterator();
        if (localIterator.hasNext())
        {
          int j = ((Integer)localIterator.next()).intValue();
          localStringBuilder.append(j + ",");
        }
      }
      QLog.d("PeakAudioTransHandler ChannelStateManager", 2, "getRecentTopEvent lastevent = " + i + "， eventlist = " + localObject2.toString());
      label160:
      this.ao.clear();
      return i;
    }
    return -1;
  }
  
  public void Ul(int paramInt)
  {
    synchronized (this.cj)
    {
      this.bH.set(paramInt);
      return;
    }
  }
  
  public void Um(int paramInt)
  {
    synchronized (this.cj)
    {
      this.bI.set(paramInt);
      return;
    }
  }
  
  public void Un(int paramInt)
  {
    this.ao.add(0, Integer.valueOf(paramInt));
  }
  
  public boolean avq()
  {
    return this.bH.get() == 2;
  }
  
  public boolean avr()
  {
    return this.bH.get() == 1;
  }
  
  public boolean avs()
  {
    return this.bH.get() == 0;
  }
  
  public boolean avt()
  {
    return this.bI.get() == 12;
  }
  
  public boolean avu()
  {
    return this.bI.get() == 11;
  }
  
  public boolean avv()
  {
    return this.bI.get() == 10;
  }
  
  public boolean avw()
  {
    return this.bI.get() == 13;
  }
  
  public boolean avx()
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    int i = this.bH.get();
    int j = this.bI.get();
    switch (i)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if ((!bool1) && (QLog.isColorLevel())) {
        QLog.e("PeakAudioTransHandler ChannelStateManager", 2, "isLegalState , currentSessionState = " + i + " currentTCPState = " + j);
      }
      return bool1;
      switch (j)
      {
      }
      for (bool1 = false;; bool1 = false) {
        break;
      }
      bool1 = bool2;
      switch (j)
      {
      case 11: 
      case 12: 
      case 13: 
      default: 
        bool1 = bool2;
        break;
      case 10: 
        bool1 = true;
        continue;
        bool1 = bool3;
        switch (j)
        {
        default: 
          bool1 = false;
        }
        continue;
        bool1 = bool2;
        switch (j)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          bool1 = bool2;
          break;
        case 10: 
          bool1 = true;
        }
        break;
      }
    }
  }
  
  public void reset()
  {
    synchronized (this.cj)
    {
      if (this.ao != null) {
        this.ao.clear();
      }
      this.bH.set(0);
      this.bI.set(10);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambx
 * JD-Core Version:    0.7.0.1
 */