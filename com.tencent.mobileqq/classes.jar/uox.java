import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.doodle.DoodleItem;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils.CombineCallback;
import com.tencent.qphone.base.util.QLog;

public class uox
  implements ScribbleMsgUtils.CombineCallback
{
  public uox(DoodlePanel paramDoodlePanel, DoodleItem paramDoodleItem) {}
  
  public void a(int paramInt)
  {
    QLog.i("Scribble", 2, "bsuc " + paramInt);
    new Handler(Looper.getMainLooper()).post(new uoy(this, paramInt));
  }
  
  public boolean a(String paramString)
  {
    return DoodlePanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uox
 * JD-Core Version:    0.7.0.1
 */