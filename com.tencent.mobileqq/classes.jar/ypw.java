import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ypw
  extends QQUIEventReceiver<yqj, wsz>
  implements yqf
{
  protected yqh a;
  
  public ypw(yqj paramyqj)
  {
    super(paramyqj);
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
    wjj.a().registerSubscriber(this);
    ((wsx)wth.a(13)).c();
  }
  
  public void a(Object paramObject) {}
  
  public void a(yqg paramyqg) {}
  
  public void a(yqh paramyqh)
  {
    this.a = paramyqh;
  }
  
  public void a(yqj paramyqj, wsz paramwsz)
  {
    wjj.a().unRegisterSubscriber(this);
    if (this.a != null) {
      this.a.a(a());
    }
    for (;;)
    {
      yuk.d("Q.qqstory.home,ReportWatchVideoListStep", "receive event. step is done");
      return;
      yuk.d("Q.qqstory.home,ReportWatchVideoListStep", "finish callBack is null");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Class acceptEventClass()
  {
    return wsz.class;
  }
  
  public void b()
  {
    yuk.a("Q.qqstory.home.qqstory_step", "Q.qqstory.home,ReportWatchVideoListStep", "Q.qqstory.home,ReportWatchVideoListStep");
  }
  
  public void c()
  {
    wsx localwsx = (wsx)wth.a(13);
    wjj.a().unRegisterSubscriber(this);
    localwsx.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypw
 * JD-Core Version:    0.7.0.1
 */