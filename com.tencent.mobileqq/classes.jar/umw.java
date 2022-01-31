import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class umw
  extends QQUIEventReceiver<unj, spy>
  implements unf
{
  protected unh a;
  
  public umw(unj paramunj)
  {
    super(paramunj);
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
    sgi.a().registerSubscriber(this);
    ((spw)sqg.a(13)).c();
  }
  
  public void a(Object paramObject) {}
  
  public void a(ung paramung) {}
  
  public void a(unh paramunh)
  {
    this.a = paramunh;
  }
  
  public void a(unj paramunj, spy paramspy)
  {
    sgi.a().unRegisterSubscriber(this);
    if (this.a != null) {
      this.a.a(a());
    }
    for (;;)
    {
      urk.d("Q.qqstory.home,ReportWatchVideoListStep", "receive event. step is done");
      return;
      urk.d("Q.qqstory.home,ReportWatchVideoListStep", "finish callBack is null");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Class acceptEventClass()
  {
    return spy.class;
  }
  
  public void b()
  {
    urk.a("Q.qqstory.home.qqstory_step", "Q.qqstory.home,ReportWatchVideoListStep", "Q.qqstory.home,ReportWatchVideoListStep");
  }
  
  public void c()
  {
    spw localspw = (spw)sqg.a(13);
    sgi.a().unRegisterSubscriber(this);
    localspw.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umw
 * JD-Core Version:    0.7.0.1
 */