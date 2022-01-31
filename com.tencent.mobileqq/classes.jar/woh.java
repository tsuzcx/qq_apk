import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class woh
  extends QQUIEventReceiver<wou, urj>
  implements woq
{
  protected wos a;
  
  public woh(wou paramwou)
  {
    super(paramwou);
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
    uht.a().registerSubscriber(this);
    ((urh)urr.a(13)).c();
  }
  
  public void a(Object paramObject) {}
  
  public void a(wor paramwor) {}
  
  public void a(wos paramwos)
  {
    this.a = paramwos;
  }
  
  public void a(wou paramwou, urj paramurj)
  {
    uht.a().unRegisterSubscriber(this);
    if (this.a != null) {
      this.a.a(a());
    }
    for (;;)
    {
      wsv.d("Q.qqstory.home,ReportWatchVideoListStep", "receive event. step is done");
      return;
      wsv.d("Q.qqstory.home,ReportWatchVideoListStep", "finish callBack is null");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Class acceptEventClass()
  {
    return urj.class;
  }
  
  public void b()
  {
    wsv.a("Q.qqstory.home.qqstory_step", "Q.qqstory.home,ReportWatchVideoListStep", "Q.qqstory.home,ReportWatchVideoListStep");
  }
  
  public void c()
  {
    urh localurh = (urh)urr.a(13);
    uht.a().unRegisterSubscriber(this);
    localurh.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     woh
 * JD-Core Version:    0.7.0.1
 */