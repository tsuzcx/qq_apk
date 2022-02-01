import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class qxk
  extends QQUIEventReceiver<qxq, psq.b>
  implements qxo
{
  protected qxo.b a;
  
  public qxk(qxq paramqxq)
  {
    super(paramqxq);
  }
  
  public Object D()
  {
    return null;
  }
  
  public boolean KH()
  {
    return false;
  }
  
  public void a(qxo.a parama) {}
  
  public void a(qxo.b paramb)
  {
    this.a = paramb;
  }
  
  public void a(qxq paramqxq, psq.b paramb)
  {
    pmi.a().unRegisterSubscriber(this);
    if (this.a != null) {
      this.a.si(getKey());
    }
    for (;;)
    {
      ram.w("Q.qqstory.home,ReportWatchVideoListStep", "receive event. step is done");
      return;
      ram.w("Q.qqstory.home,ReportWatchVideoListStep", "finish callBack is null");
    }
  }
  
  public Class acceptEventClass()
  {
    return psq.b.class;
  }
  
  public void an(Object paramObject) {}
  
  public void dump()
  {
    ram.b("Q.qqstory.home.qqstory_step", "Q.qqstory.home,ReportWatchVideoListStep", "Q.qqstory.home,ReportWatchVideoListStep");
  }
  
  public String getKey()
  {
    return "ReportWatchVideoListStep";
  }
  
  public void reset()
  {
    psq localpsq = (psq)psx.a(13);
    pmi.a().unRegisterSubscriber(this);
    localpsq.bme();
  }
  
  public void run()
  {
    pmi.a().registerSubscriber(this);
    ((psq)psx.a(13)).bmB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxk
 * JD-Core Version:    0.7.0.1
 */