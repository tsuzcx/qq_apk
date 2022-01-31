import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import java.util.ArrayList;

public abstract interface yiy<T extends SimpleBaseEvent>
{
  public abstract ArrayList<Class<T>> getEventClass();
  
  public abstract void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yiy
 * JD-Core Version:    0.7.0.1
 */