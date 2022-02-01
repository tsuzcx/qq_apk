import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.confighandler.NormalConfigHandler;
import com.tencent.mobileqq.utils.confighandler.NormalConfigHandler.GetConfigListen;
import com.tencent.mobileqq.utils.confighandler.ReadConfigTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aqnw
  implements aqms.a
{
  public aqnw(NormalConfigHandler paramNormalConfigHandler, NormalConfigHandler.GetConfigListen paramGetConfigListen, AppInterface paramAppInterface) {}
  
  public void j(boolean paramBoolean, ArrayList<aqms> paramArrayList)
  {
    paramArrayList = (ReadConfigTask)paramArrayList.get(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsConfighandlerNormalConfigHandler.mReadConfigTask != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsConfighandlerNormalConfigHandler.mReadConfigTask == paramArrayList))
    {
      QLog.w(this.jdField_a_of_type_ComTencentMobileqqUtilsConfighandlerNormalConfigHandler.TAG, 1, "异步加载config返回, bsuc[" + paramBoolean + "], TAG[" + paramArrayList.TAG + "], config[" + paramArrayList.mConfigInfo + "]");
      this.jdField_a_of_type_ComTencentMobileqqUtilsConfighandlerNormalConfigHandler.mReadConfigTask = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsConfighandlerNormalConfigHandler$GetConfigListen != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsConfighandlerNormalConfigHandler$GetConfigListen.onGetConfig(this.b, paramArrayList.mConfigInfo);
      }
      return;
      QLog.w(this.jdField_a_of_type_ComTencentMobileqqUtilsConfighandlerNormalConfigHandler.TAG, 1, "异步加载config返回[" + paramArrayList.TAG + "], 但原请求取消了");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqnw
 * JD-Core Version:    0.7.0.1
 */