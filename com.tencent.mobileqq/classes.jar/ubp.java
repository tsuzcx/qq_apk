import com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo.VTopicVideo;
import com.tencent.viola.core.dispatch.ComponentAppearEvent;
import com.tencent.viola.core.dispatch.IEvent;
import com.tencent.viola.core.dispatch.IObserver;

public class ubp
  implements IObserver
{
  public ubp(VTopicVideo paramVTopicVideo) {}
  
  public String getRef()
  {
    return this.a.getRef();
  }
  
  public void onReceive(IEvent paramIEvent)
  {
    if ((paramIEvent.getRef().equals(this.a.getRef())) && (this.a.getVideoLifeCycleChangeListener() != null))
    {
      paramIEvent = (ComponentAppearEvent)paramIEvent;
      if (!paramIEvent.event.equals("didDisappear")) {
        break label59;
      }
      this.a.getVideoLifeCycleChangeListener().H_();
    }
    label59:
    do
    {
      return;
      if (paramIEvent.event.equals("willAppear"))
      {
        this.a.getVideoLifeCycleChangeListener().F_();
        return;
      }
    } while (!paramIEvent.event.equals("didAppear"));
    this.a.getVideoLifeCycleChangeListener().G_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ubp
 * JD-Core Version:    0.7.0.1
 */