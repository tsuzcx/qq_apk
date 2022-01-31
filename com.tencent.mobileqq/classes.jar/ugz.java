import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher.Event;

public class ugz
  implements Dispatcher.Event
{
  public ErrorMessage a = new ErrorMessage();
  
  public String a()
  {
    return this.a.getErrorMessage();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("{\"_class\":\"SimpleBaseEvent\", \"errorInfo\":");
    if (this.a == null) {}
    for (String str = "null";; str = "\"" + this.a + "\"") {
      return str + "}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ugz
 * JD-Core Version:    0.7.0.1
 */