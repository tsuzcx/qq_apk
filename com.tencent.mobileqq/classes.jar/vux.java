import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class vux
  implements aads<QCircleBaseRequest>
{
  private List<aadq> a = new ArrayList();
  private List<aadr> b = new ArrayList();
  
  public vux a(aadq paramaadq)
  {
    this.a.add(paramaadq);
    return this;
  }
  
  public vux a(aadr paramaadr)
  {
    this.b.add(paramaadr);
    return this;
  }
  
  public void a(QCircleBaseRequest paramQCircleBaseRequest, aadt paramaadt)
  {
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.addAll(this.a);
    localArrayList1.add(new aadp());
    localArrayList1.add(new vvb());
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(this.b);
    new vuz(localArrayList1, localArrayList2, new WeakReference(paramaadt), 0).a(paramQCircleBaseRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vux
 * JD-Core Version:    0.7.0.1
 */