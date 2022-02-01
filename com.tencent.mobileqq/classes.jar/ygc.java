import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ygc
  extends QQUIEventReceiver<ygp, wjk>
  implements ygl
{
  protected ygn a;
  
  public ygc(ygp paramygp)
  {
    super(paramygp);
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
    wad.a().registerSubscriber(this);
    ((wji)wjs.a(13)).c();
  }
  
  public void a(Object paramObject) {}
  
  public void a(ygm paramygm) {}
  
  public void a(ygn paramygn)
  {
    this.a = paramygn;
  }
  
  public void a(ygp paramygp, wjk paramwjk)
  {
    wad.a().unRegisterSubscriber(this);
    if (this.a != null) {
      this.a.a(a());
    }
    for (;;)
    {
      ykq.d("Q.qqstory.home,ReportWatchVideoListStep", "receive event. step is done");
      return;
      ykq.d("Q.qqstory.home,ReportWatchVideoListStep", "finish callBack is null");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Class acceptEventClass()
  {
    return wjk.class;
  }
  
  public void b()
  {
    ykq.a("Q.qqstory.home.qqstory_step", "Q.qqstory.home,ReportWatchVideoListStep", "Q.qqstory.home,ReportWatchVideoListStep");
  }
  
  public void c()
  {
    wji localwji = (wji)wjs.a(13);
    wad.a().unRegisterSubscriber(this);
    localwji.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygc
 * JD-Core Version:    0.7.0.1
 */