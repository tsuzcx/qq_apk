import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;

public class gnz
  extends Handler
{
  public static final int a = 0;
  
  public gnz(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(BaseTransProcessor paramBaseTransProcessor)
  {
    sendMessage(obtainMessage(0, paramBaseTransProcessor));
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 0) && (paramMessage.obj != null) && ((paramMessage.obj instanceof BaseTransProcessor))) {
      paramMessage = (BaseTransProcessor)paramMessage.obj;
    }
    try
    {
      TransferRequest localTransferRequest = paramMessage.a();
      if ((localTransferRequest != null) && (localTransferRequest.jdField_a_of_type_Long != 0L) && (localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)) {
        localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessage.a.a().b(localTransferRequest.b, localTransferRequest.jdField_a_of_type_Int, localTransferRequest.jdField_a_of_type_Long);
      }
    }
    catch (Exception localException)
    {
      label83:
      break label83;
    }
    paramMessage.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gnz
 * JD-Core Version:    0.7.0.1
 */