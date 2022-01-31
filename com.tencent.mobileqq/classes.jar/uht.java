import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class uht
{
  public static Dispatcher a()
  {
    return Dispatchers.get(ThreadManager.getSubThreadLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uht
 * JD-Core Version:    0.7.0.1
 */