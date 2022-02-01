import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aivj
{
  private static final LocationRoom.b d = new LocationRoom.b(-1, "-1");
  private final List<aivk> CH = new ArrayList();
  private final QQAppInterface app;
  private LocationRoom.b e = d;
  
  public aivj(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public void a(aivk paramaivk)
  {
    synchronized (this.CH)
    {
      if (!this.CH.contains(paramaivk)) {
        this.CH.add(paramaivk);
      }
      return;
    }
  }
  
  public LocationRoom.b b()
  {
    return this.e;
  }
  
  /* Error */
  public void b(aivk paramaivk)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	aivj:CH	Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 35	aivj:CH	Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface 53 2 0
    //   19: pop
    //   20: aload_2
    //   21: monitorexit
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_1
    //   26: aload_2
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	aivj
    //   0	35	1	paramaivk	aivk
    // Exception table:
    //   from	to	target	type
    //   9	22	25	finally
    //   26	28	25	finally
    //   2	9	30	finally
    //   28	30	30	finally
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	aivj:CH	Ljava/util/List;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 35	aivj:CH	Ljava/util/List;
    //   13: invokeinterface 57 1 0
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_2
    //   24: aload_1
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	aivj
    //   28	4	1	localObject1	Object
    //   23	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	20	23	finally
    //   24	26	23	finally
    //   2	9	28	finally
    //   26	28	28	finally
  }
  
  public void duP()
  {
    this.e = d;
    Iterator localIterator = this.CH.iterator();
    while (localIterator.hasNext()) {
      ((aivk)localIterator.next()).ccz();
    }
  }
  
  public void i(LocationRoom.b paramb)
  {
    this.e = paramb;
    Iterator localIterator = this.CH.iterator();
    while (localIterator.hasNext()) {
      ((aivk)localIterator.next()).a(paramb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aivj
 * JD-Core Version:    0.7.0.1
 */