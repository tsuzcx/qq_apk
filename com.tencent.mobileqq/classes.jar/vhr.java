import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.CellTextView;

public class vhr
  extends Handler
{
  public vhr(CellTextView paramCellTextView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.b = true;
    this.a.a(6, paramMessage.arg1, paramMessage.arg2, 0);
    paramMessage = this.a.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell;
    this.a.a();
    this.a.jdField_a_of_type_Vip.g();
    this.a.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell = paramMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhr
 * JD-Core Version:    0.7.0.1
 */