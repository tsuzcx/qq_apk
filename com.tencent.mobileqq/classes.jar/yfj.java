import android.os.Handler;
import android.os.Message;
import com.tencent.gamecenter.common.util.ReportInfoManager;

public class yfj
  extends Handler
{
  public yfj(ReportInfoManager paramReportInfoManager, long paramLong) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    yfq.a("post report", this.jdField_a_of_type_Long, (short)1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yfj
 * JD-Core Version:    0.7.0.1
 */