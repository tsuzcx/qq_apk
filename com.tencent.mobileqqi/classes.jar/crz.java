import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class crz
  extends Handler
{
  public crz(Leba paramLeba) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ("0".equals(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 11340002: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.leba", 2, "handler refresh leba config");
        }
        this.a.h();
        return;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter == null);
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
    Leba.a(this.a);
    return;
    paramMessage = new Thread(new csa(this));
    paramMessage.setPriority(5);
    paramMessage.start();
    return;
    Leba.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     crz
 * JD-Core Version:    0.7.0.1
 */