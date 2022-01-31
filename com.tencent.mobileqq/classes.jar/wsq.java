import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wsq
  extends QQUIEventReceiver<wtd, uvs>
  implements wsz
{
  protected wtb a;
  
  public wsq(wtd paramwtd)
  {
    super(paramwtd);
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
    umc.a().registerSubscriber(this);
    ((uvq)uwa.a(13)).c();
  }
  
  public void a(Object paramObject) {}
  
  public void a(wta paramwta) {}
  
  public void a(wtb paramwtb)
  {
    this.a = paramwtb;
  }
  
  public void a(wtd paramwtd, uvs paramuvs)
  {
    umc.a().unRegisterSubscriber(this);
    if (this.a != null) {
      this.a.a(a());
    }
    for (;;)
    {
      wxe.d("Q.qqstory.home,ReportWatchVideoListStep", "receive event. step is done");
      return;
      wxe.d("Q.qqstory.home,ReportWatchVideoListStep", "finish callBack is null");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Class acceptEventClass()
  {
    return uvs.class;
  }
  
  public void b()
  {
    wxe.a("Q.qqstory.home.qqstory_step", "Q.qqstory.home,ReportWatchVideoListStep", "Q.qqstory.home,ReportWatchVideoListStep");
  }
  
  public void c()
  {
    uvq localuvq = (uvq)uwa.a(13);
    umc.a().unRegisterSubscriber(this);
    localuvq.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wsq
 * JD-Core Version:    0.7.0.1
 */