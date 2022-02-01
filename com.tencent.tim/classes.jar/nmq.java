import android.os.Parcelable;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.LinkedList;

public class nmq
{
  private BaseActivity c;
  private LinkedList<nmq.b> x = new LinkedList();
  
  public nmq(BaseActivity paramBaseActivity)
  {
    this.c = paramBaseActivity;
  }
  
  public nmq.b a()
  {
    if (this.x.isEmpty()) {
      return null;
    }
    return (nmq.b)this.x.pop();
  }
  
  public void a(nmq.a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      while (!isEmpty())
      {
        nmq.b localb = a();
        if (localb != null) {
          parama.b(localb);
        }
      }
    }
  }
  
  public void c(nmq.b paramb)
  {
    this.x.push(paramb);
  }
  
  public boolean isEmpty()
  {
    return this.x.isEmpty();
  }
  
  public int qJ()
  {
    if (this.x == null) {
      return 0;
    }
    return this.x.size();
  }
  
  public static abstract interface a
  {
    public abstract void b(nmq.b paramb);
  }
  
  public static class b
  {
    public ItemShowDispatcher a;
    public nlj a;
    public String akh;
    public boolean asN;
    public ArticleInfo b;
    public Parcelable d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nmq
 * JD-Core Version:    0.7.0.1
 */