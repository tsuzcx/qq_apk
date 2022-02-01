import android.os.Message;
import com.tencent.mobileqq.activity.CloudFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;

public class urm
  implements ativ.a
{
  public urm(CloudFileActivity paramCloudFileActivity) {}
  
  public void aSa()
  {
    if (!this.this$0.jdField_a_of_type_Auja.isComplete())
    {
      if (CloudFileActivity.a(this.this$0) != null) {
        CloudFileActivity.a(this.this$0).lz(true);
      }
      ((ateh)this.this$0.app.getBusinessHandler(180)).N(2, this.this$0.jdField_a_of_type_Auja.W());
    }
  }
  
  public void bLR()
  {
    if (!aqiw.isNetworkAvailable(BaseApplication.getContext()))
    {
      Message localMessage = this.this$0.b.obtainMessage(3);
      localMessage.obj = this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetGridListView;
      this.this$0.b.sendMessageDelayed(localMessage, 1000L);
      return;
    }
    CloudFileActivity.a(this.this$0, true);
    this.this$0.wC(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     urm
 * JD-Core Version:    0.7.0.1
 */