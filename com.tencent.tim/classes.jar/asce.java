import cooperation.wadl.ipc.WadlResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class asce
  extends asby
{
  private WeakReference<asce.a> iQ;
  
  public asce()
  {
    super(false, null);
  }
  
  public void b(asce.a parama)
  {
    this.iQ = new WeakReference(parama);
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    super.onQueryCallback(paramArrayList);
    if ((this.iQ != null) && (this.iQ.get() != null)) {
      ((asce.a)this.iQ.get()).dx(paramArrayList);
    }
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    super.onWadlTaskStatusChanged(paramWadlResult);
    if ((paramWadlResult == null) || (paramWadlResult.a == null)) {}
    int i;
    do
    {
      return;
      i = ascc.kR(paramWadlResult.bBa);
    } while ((this.iQ == null) || (this.iQ.get() == null));
    ((asce.a)this.iQ.get()).a(i, paramWadlResult);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, WadlResult paramWadlResult);
    
    public abstract void dx(ArrayList<WadlResult> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asce
 * JD-Core Version:    0.7.0.1
 */