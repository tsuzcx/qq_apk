import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.widget.QQToast;

public class zqk
  implements Runnable
{
  public zqk(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, int paramInt) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), "Linkstar Push!ChooserAc!! msgType = " + this.jdField_a_of_type_Int, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zqk
 * JD-Core Version:    0.7.0.1
 */