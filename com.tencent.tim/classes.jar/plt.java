import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher.Event;

public class plt
  implements Dispatcher.Event
{
  public ErrorMessage b = new ErrorMessage();
  
  public String getErrorMessage()
  {
    return this.b.getErrorMessage();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("{\"_class\":\"SimpleBaseEvent\", \"errorInfo\":");
    if (this.b == null) {}
    for (String str = "null";; str = "\"" + this.b + "\"") {
      return str + "}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     plt
 * JD-Core Version:    0.7.0.1
 */