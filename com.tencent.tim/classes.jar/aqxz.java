import java.util.ArrayList;
import java.util.LinkedList;

public class aqxz
{
  private static aqxz a;
  private ArrayList<aqxx> Df = new ArrayList(5);
  private LinkedList<aqxw> aq = new LinkedList();
  
  private aqxx a(int paramInt1, int paramInt2)
  {
    return new aqxx(paramInt1, paramInt2);
  }
  
  public static aqxz a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aqxz();
      }
      return a;
    }
    finally {}
  }
  
  public aqxx a(aqxw paramaqxw, int paramInt1, int paramInt2)
  {
    if (this.Df.size() == 5)
    {
      this.aq.add(paramaqxw);
      return null;
    }
    aqxx localaqxx = a(paramInt1, paramInt2);
    localaqxx.a(paramaqxw);
    this.Df.add(localaqxx);
    return localaqxx;
  }
  
  public void a(aqxx paramaqxx)
  {
    if (paramaqxx != null)
    {
      paramaqxx.release();
      this.Df.remove(paramaqxx);
      if ((this.Df.size() < 5) && (!this.aq.isEmpty()))
      {
        paramaqxx = (aqxw)this.aq.getFirst();
        aqxx localaqxx = a(paramaqxx.getRenderWidth(), paramaqxx.getRenderHeight());
        localaqxx.a(paramaqxx);
        this.Df.add(localaqxx);
        paramaqxx.onSetRenderer(localaqxx);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqxz
 * JD-Core Version:    0.7.0.1
 */