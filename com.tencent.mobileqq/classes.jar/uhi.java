import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import java.util.ArrayList;

public abstract interface uhi<T extends WSSimpleBaseEvent>
{
  public abstract void a(WSSimpleBaseEvent paramWSSimpleBaseEvent);
  
  public abstract ArrayList<Class<T>> getEventClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhi
 * JD-Core Version:    0.7.0.1
 */