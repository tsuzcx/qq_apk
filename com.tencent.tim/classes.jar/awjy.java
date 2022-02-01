import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;

public class awjy
  extends Handler
{
  public awjy(TroopHWJsPlugin paramTroopHWJsPlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return;
    case 0: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131699648, 0).show();
      return;
    case 1: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131699666, 0).show();
      return;
    case 3: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131699646, 0).show();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131699647, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjy
 * JD-Core Version:    0.7.0.1
 */