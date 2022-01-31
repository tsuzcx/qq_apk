import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uzs
  extends QQUIEventReceiver<vaf, tcu>
  implements vab
{
  protected vad a;
  
  public uzs(vaf paramvaf)
  {
    super(paramvaf);
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
    ste.a().registerSubscriber(this);
    ((tcs)tdc.a(13)).c();
  }
  
  public void a(Object paramObject) {}
  
  public void a(vac paramvac) {}
  
  public void a(vad paramvad)
  {
    this.a = paramvad;
  }
  
  public void a(vaf paramvaf, tcu paramtcu)
  {
    ste.a().unRegisterSubscriber(this);
    if (this.a != null) {
      this.a.a(a());
    }
    for (;;)
    {
      veg.d("Q.qqstory.home,ReportWatchVideoListStep", "receive event. step is done");
      return;
      veg.d("Q.qqstory.home,ReportWatchVideoListStep", "finish callBack is null");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Class acceptEventClass()
  {
    return tcu.class;
  }
  
  public void b()
  {
    veg.a("Q.qqstory.home.qqstory_step", "Q.qqstory.home,ReportWatchVideoListStep", "Q.qqstory.home,ReportWatchVideoListStep");
  }
  
  public void c()
  {
    tcs localtcs = (tcs)tdc.a(13);
    ste.a().unRegisterSubscriber(this);
    localtcs.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzs
 * JD-Core Version:    0.7.0.1
 */