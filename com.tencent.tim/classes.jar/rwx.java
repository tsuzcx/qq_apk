import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;

public abstract interface rwx<T extends SimpleBaseEvent>
{
  public abstract ArrayList<Class<T>> getEventClass();
  
  public abstract void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwx
 * JD-Core Version:    0.7.0.1
 */