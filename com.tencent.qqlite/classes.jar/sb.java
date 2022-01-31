import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.qphone.base.util.QLog;

public class sb
  implements AsyncCallBack
{
  public sb(OfflinePlugin paramOfflinePlugin, long paramLong) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(OfflinePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin), 2, "transToLocalUrl loadMode:" + paramInt + "," + " time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {}
    Message localMessage = this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a.obtainMessage();
    localMessage.arg1 = 1;
    localMessage.arg2 = paramInt;
    localMessage.obj = paramString;
    this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     sb
 * JD-Core Version:    0.7.0.1
 */