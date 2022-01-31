import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uzp
  extends QQUIEventReceiver<vac, tcr>
  implements uzy
{
  protected vaa a;
  
  public uzp(vac paramvac)
  {
    super(paramvac);
  }
  
  public Object a()
  {
    return null;
  }
  
  public String a()
  {
    return "ReportWatchVideoListStep";
  }
  
  public void a()
  {
    stb.a().registerSubscriber(this);
    ((tcp)tcz.a(13)).c();
  }
  
  public void a(Object paramObject) {}
  
  public void a(uzz paramuzz) {}
  
  public void a(vaa paramvaa)
  {
    this.a = paramvaa;
  }
  
  public void a(vac paramvac, tcr paramtcr)
  {
    stb.a().unRegisterSubscriber(this);
    if (this.a != null) {
      this.a.a(a());
    }
    for (;;)
    {
      ved.d("Q.qqstory.home,ReportWatchVideoListStep", "receive event. step is done");
      return;
      ved.d("Q.qqstory.home,ReportWatchVideoListStep", "finish callBack is null");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Class acceptEventClass()
  {
    return tcr.class;
  }
  
  public void b()
  {
    ved.a("Q.qqstory.home.qqstory_step", "Q.qqstory.home,ReportWatchVideoListStep", "Q.qqstory.home,ReportWatchVideoListStep");
  }
  
  public void c()
  {
    tcp localtcp = (tcp)tcz.a(13);
    stb.a().unRegisterSubscriber(this);
    localtcp.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzp
 * JD-Core Version:    0.7.0.1
 */