import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.smtt.sdk.WebView;
import java.util.List;
import java.util.TimerTask;

public class hko
  extends TimerTask
{
  public hko(BaseInterface paramBaseInterface, WebView paramWebView, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseInterface.optLef <= 0)
    {
      cancel();
      this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseInterface.firstIn = true;
    }
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseInterface.batchCallbackQueue.size() > 0) {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseInterface.batchCallback(this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hko
 * JD-Core Version:    0.7.0.1
 */