import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ayvp
{
  private ayvp.a a;
  private ConcurrentHashMap<Integer, ayvr.a> dl;
  
  public ayvr.a a(int paramInt)
  {
    return (ayvr.a)this.dl.get(Integer.valueOf(paramInt));
  }
  
  public void a(ayvr.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + parama.index);
    }
    this.dl.putIfAbsent(Integer.valueOf(parama.index), parama);
    if (this.a != null) {
      this.a.onChanged();
    }
  }
  
  public boolean hF(int paramInt)
  {
    return this.dl.containsKey(Integer.valueOf(paramInt));
  }
  
  public boolean isEmpty()
  {
    return this.dl.size() == 0;
  }
  
  public static abstract interface a
  {
    public abstract void onChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayvp
 * JD-Core Version:    0.7.0.1
 */