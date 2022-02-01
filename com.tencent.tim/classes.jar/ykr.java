import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.c;
import com.tencent.qphone.base.util.QLog;

class ykr
  extends Handler
{
  ykr(ykm paramykm, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      do
      {
        do
        {
          return;
          paramMessage = (ykv)paramMessage.obj;
          if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, ykm.a(paramMessage.aYv, "main handler", paramMessage.bZJ, "all img process is finished, now is in main thread"));
          }
          this.this$0.h(paramMessage);
          return;
          paramMessage = (String)paramMessage.obj;
          if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "response is empty, errorMsg is " + paramMessage);
          }
        } while (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$c == null);
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$c.yN(paramMessage);
        return;
        i = paramMessage.arg1;
        paramMessage = (String)paramMessage.obj;
        if (paramMessage.equals(this.this$0.pE())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ZhituManager", 2, ykm.u(paramMessage, "main handler", "reqKey is outdated, skip"));
      return;
      if (this.this$0.jdField_a_of_type_Yku != null) {
        this.this$0.jdField_a_of_type_Yku.bt(i, paramMessage);
      }
    } while (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$c == null);
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$c.bt(i, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ykr
 * JD-Core Version:    0.7.0.1
 */