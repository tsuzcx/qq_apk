import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xrh
  extends QQUIEventReceiver<xru, vup>
  implements xrq
{
  protected xrs a;
  
  public xrh(xru paramxru)
  {
    super(paramxru);
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
    vli.a().registerSubscriber(this);
    ((vun)vux.a(13)).c();
  }
  
  public void a(Object paramObject) {}
  
  public void a(xrr paramxrr) {}
  
  public void a(xrs paramxrs)
  {
    this.a = paramxrs;
  }
  
  public void a(xru paramxru, vup paramvup)
  {
    vli.a().unRegisterSubscriber(this);
    if (this.a != null) {
      this.a.a(a());
    }
    for (;;)
    {
      xvv.d("Q.qqstory.home,ReportWatchVideoListStep", "receive event. step is done");
      return;
      xvv.d("Q.qqstory.home,ReportWatchVideoListStep", "finish callBack is null");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Class acceptEventClass()
  {
    return vup.class;
  }
  
  public void b()
  {
    xvv.a("Q.qqstory.home.qqstory_step", "Q.qqstory.home,ReportWatchVideoListStep", "Q.qqstory.home,ReportWatchVideoListStep");
  }
  
  public void c()
  {
    vun localvun = (vun)vux.a(13);
    vli.a().unRegisterSubscriber(this);
    localvun.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrh
 * JD-Core Version:    0.7.0.1
 */