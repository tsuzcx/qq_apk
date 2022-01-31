import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import java.util.ArrayList;

public abstract interface wcl<T extends SimpleBaseEvent>
{
  public abstract ArrayList<Class<T>> a();
  
  public abstract void a(SimpleBaseEvent paramSimpleBaseEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wcl
 * JD-Core Version:    0.7.0.1
 */