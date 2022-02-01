import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import java.util.ArrayList;

public abstract interface unz<T extends WSSimpleBaseEvent>
{
  public abstract ArrayList<Class<T>> a();
  
  public abstract void a(WSSimpleBaseEvent paramWSSimpleBaseEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unz
 * JD-Core Version:    0.7.0.1
 */