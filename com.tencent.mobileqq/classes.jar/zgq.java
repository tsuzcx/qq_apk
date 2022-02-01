import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class zgq
  implements Handler.Callback
{
  public zgq(SegmentList paramSegmentList) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    return SegmentList.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgq
 * JD-Core Version:    0.7.0.1
 */