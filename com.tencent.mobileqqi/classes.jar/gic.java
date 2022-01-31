import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.pic.BasePicOprerator;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack;

public class gic
  extends Handler
{
  public gic(BasePicOprerator paramBasePicOprerator, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Logger.a(this.a.b, this.a.jdField_a_of_type_JavaLangString, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.a.jdField_a_of_type_ComTencentMobileqqPicUiCallBack == null) {}
    int i;
    PicResult localPicResult;
    do
    {
      return;
      i = paramMessage.arg1;
      localPicResult = (PicResult)paramMessage.obj;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        this.a.jdField_a_of_type_ComTencentMobileqqPicUiCallBack.a(i, localPicResult);
        return;
      }
    } while (!(localPicResult.a instanceof Integer));
    this.a.jdField_a_of_type_ComTencentMobileqqPicUiCallBack.a(((Integer)localPicResult.a).intValue());
    return;
    this.a.jdField_a_of_type_ComTencentMobileqqPicUiCallBack.b(i, localPicResult);
    return;
    this.a.jdField_a_of_type_ComTencentMobileqqPicUiCallBack.c(i, localPicResult);
    return;
    this.a.jdField_a_of_type_ComTencentMobileqqPicUiCallBack.d(i, localPicResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gic
 * JD-Core Version:    0.7.0.1
 */