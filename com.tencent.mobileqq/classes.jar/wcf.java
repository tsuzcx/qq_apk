import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class wcf
  implements Handler.Callback
{
  public wcf(SegmentList paramSegmentList) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    return SegmentList.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wcf
 * JD-Core Version:    0.7.0.1
 */