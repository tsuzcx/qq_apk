import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mpb
  implements amwd<ampx>
{
  private List<mpc> ju = new ArrayList();
  
  public List<ampx> a(amwt paramamwt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ju.iterator();
    while (localIterator.hasNext())
    {
      mpc localmpc = (mpc)localIterator.next();
      if (localmpc.match(paramamwt.keyword)) {
        localArrayList.add(localmpc);
      }
    }
    return localArrayList;
  }
  
  public void a(amwt paramamwt, amwe<ampx> paramamwe)
  {
    paramamwe.s(a(paramamwt), 1);
  }
  
  public void cancel() {}
  
  public void destroy() {}
  
  public void init()
  {
    Iterator localIterator = lbz.a().aE().iterator();
    while (localIterator.hasNext())
    {
      mhg localmhg = (mhg)localIterator.next();
      this.ju.add(new mpc(localmhg));
    }
  }
  
  public void pause() {}
  
  public void resume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mpb
 * JD-Core Version:    0.7.0.1
 */