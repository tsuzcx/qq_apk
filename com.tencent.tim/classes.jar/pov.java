import android.annotation.TargetApi;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

@TargetApi(14)
public class pov
{
  public long Aj;
  public int bjJ;
  public List<pos> ms = new ArrayList();
  public ErrorMessage result;
  public int retryTimes;
  public volatile int status = 0;
  
  public boolean isFail()
  {
    return (this.status == 6) || (this.status == 3);
  }
  
  public boolean isSuccess()
  {
    return this.status == 5;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("BaseTaskInfo{");
    localStringBuffer.append("status=").append(this.status);
    localStringBuffer.append(", retryTimes=").append(this.retryTimes);
    localStringBuffer.append(", result=").append(this.result);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pov
 * JD-Core Version:    0.7.0.1
 */