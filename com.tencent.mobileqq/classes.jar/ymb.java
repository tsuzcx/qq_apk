import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ymb
  extends QQUIEventReceiver<ymo, wpe>
  implements ymk
{
  protected ymm a;
  
  public ymb(ymo paramymo)
  {
    super(paramymo);
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
    wfo.a().registerSubscriber(this);
    ((wpc)wpm.a(13)).c();
  }
  
  public void a(Object paramObject) {}
  
  public void a(yml paramyml) {}
  
  public void a(ymm paramymm)
  {
    this.a = paramymm;
  }
  
  public void a(ymo paramymo, wpe paramwpe)
  {
    wfo.a().unRegisterSubscriber(this);
    if (this.a != null) {
      this.a.a(a());
    }
    for (;;)
    {
      yqp.d("Q.qqstory.home,ReportWatchVideoListStep", "receive event. step is done");
      return;
      yqp.d("Q.qqstory.home,ReportWatchVideoListStep", "finish callBack is null");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Class acceptEventClass()
  {
    return wpe.class;
  }
  
  public void b()
  {
    yqp.a("Q.qqstory.home.qqstory_step", "Q.qqstory.home,ReportWatchVideoListStep", "Q.qqstory.home,ReportWatchVideoListStep");
  }
  
  public void c()
  {
    wpc localwpc = (wpc)wpm.a(13);
    wfo.a().unRegisterSubscriber(this);
    localwpc.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymb
 * JD-Core Version:    0.7.0.1
 */