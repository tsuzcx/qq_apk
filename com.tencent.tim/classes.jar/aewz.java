import android.util.SparseArray;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class aewz
{
  private aexj a;
  private final SparseArray<BlockingQueue<aexe>> cu = new SparseArray();
  private final BlockingQueue<aexe> m = new LinkedBlockingQueue();
  
  public aewz(aexj paramaexj)
  {
    this.a = paramaexj;
  }
  
  protected int CJ()
  {
    return 300;
  }
  
  public aexe a(int paramInt, Object paramObject)
  {
    BlockingQueue localBlockingQueue = (BlockingQueue)this.cu.get(paramInt);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null) {
      localObject = new LinkedBlockingQueue();
    }
    localObject = (aexe)((BlockingQueue)localObject).poll();
    if (localObject == null)
    {
      localObject = this.a.a(paramInt);
      aeyw.v("DanmakuFactory", new Object[] { localObject, " is created " });
    }
    for (;;)
    {
      ((aexe)localObject).reset();
      ((aexe)localObject).setData(paramObject);
      return localObject;
      aeyw.v("DanmakuFactory", new Object[] { localObject, " is reused " });
    }
  }
  
  public void g(aexe paramaexe)
  {
    int i = paramaexe.getType();
    BlockingQueue localBlockingQueue = (BlockingQueue)this.cu.get(i);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null)
    {
      localObject = new LinkedBlockingQueue();
      this.cu.put(i, localObject);
    }
    if (CJ() > ((BlockingQueue)localObject).size()) {
      ((BlockingQueue)localObject).add(paramaexe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aewz
 * JD-Core Version:    0.7.0.1
 */