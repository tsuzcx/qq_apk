import com.tencent.lottieNew.model.content.ShapeTrimPath;
import com.tencent.lottieNew.model.content.ShapeTrimPath.Type;
import java.util.ArrayList;
import java.util.List;

public class ttf
  implements tso, ttg.a
{
  private final ShapeTrimPath.Type a;
  private final List<ttg.a> listeners = new ArrayList();
  private String name;
  private final ttg<?, Float> s;
  private final ttg<?, Float> t;
  private final ttg<?, Float> u;
  
  public ttf(twe paramtwe, ShapeTrimPath paramShapeTrimPath)
  {
    this.name = paramShapeTrimPath.getName();
    this.a = paramShapeTrimPath.a();
    this.s = paramShapeTrimPath.p().g();
    this.t = paramShapeTrimPath.o().g();
    this.u = paramShapeTrimPath.n().g();
    paramtwe.a(this.s);
    paramtwe.a(this.t);
    paramtwe.a(this.u);
    this.s.b(this);
    this.t.b(this);
    this.u.b(this);
  }
  
  ShapeTrimPath.Type a()
  {
    return this.a;
  }
  
  public ttg<?, Float> a()
  {
    return this.s;
  }
  
  void a(ttg.a parama)
  {
    this.listeners.add(parama);
  }
  
  public ttg<?, Float> b()
  {
    return this.t;
  }
  
  public ttg<?, Float> c()
  {
    return this.u;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void onValueChanged()
  {
    int i = 0;
    while (i < this.listeners.size())
    {
      ((ttg.a)this.listeners.get(i)).onValueChanged();
      i += 1;
    }
  }
  
  public void setContents(List<tso> paramList1, List<tso> paramList2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttf
 * JD-Core Version:    0.7.0.1
 */