import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mpe
  implements amwd<ampx>, amwe<ampx>
{
  private amwe<ampx> a;
  private List<amwd> jv = new ArrayList();
  private List<ampx> jw = new ArrayList();
  
  public mpe(List<amwd> paramList)
  {
    if (paramList != null) {
      this.jv.addAll(paramList);
    }
  }
  
  public List<ampx> a(amwt paramamwt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jv.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((amwd)localIterator.next()).a(paramamwt));
    }
    return localArrayList;
  }
  
  public void a(amwt paramamwt, amwe<ampx> paramamwe)
  {
    this.jw.clear();
    this.a = paramamwe;
    paramamwe = this.jv.iterator();
    while (paramamwe.hasNext()) {
      ((amwd)paramamwe.next()).a(paramamwt, this);
    }
  }
  
  public void a(List<ampx> paramList, amwu paramamwu)
  {
    s(paramList, paramamwu.status);
  }
  
  public void cR(List<ampx> paramList)
  {
    if (this.a != null) {
      this.a.cR(paramList);
    }
  }
  
  public void cancel()
  {
    Iterator localIterator = this.jv.iterator();
    while (localIterator.hasNext()) {
      ((amwd)localIterator.next()).cancel();
    }
  }
  
  public void destroy()
  {
    Iterator localIterator = this.jv.iterator();
    while (localIterator.hasNext()) {
      ((amwd)localIterator.next()).destroy();
    }
  }
  
  public void init()
  {
    Iterator localIterator = this.jv.iterator();
    while (localIterator.hasNext()) {
      ((amwd)localIterator.next()).init();
    }
  }
  
  public void pause()
  {
    Iterator localIterator = this.jv.iterator();
    while (localIterator.hasNext()) {
      ((amwd)localIterator.next()).pause();
    }
  }
  
  public void resume()
  {
    Iterator localIterator = this.jv.iterator();
    while (localIterator.hasNext()) {
      ((amwd)localIterator.next()).resume();
    }
  }
  
  public void s(List<ampx> paramList, int paramInt)
  {
    this.jw.addAll(paramList);
    if (this.a != null) {
      this.a.s(this.jw, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mpe
 * JD-Core Version:    0.7.0.1
 */