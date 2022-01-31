import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import protocol.KQQConfig.GetResourceRespInfo;

public class fey
  implements Runnable
{
  public fey(ConfigHandler paramConfigHandler, String paramString, StatusManager paramStatusManager, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject = new File(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a.getApplication().getFilesDir(), "rich_status.tmp");
    int i = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a, this.jdField_a_of_type_JavaLangString, (File)localObject);
    if (QLog.isColorLevel()) {
      QLog.w("Q.richstatus.xml", 2, "handleUpdateStatusActions download " + this.jdField_a_of_type_JavaLangString + " result " + i);
    }
    HashMap localHashMap;
    String str;
    if (i == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a((File)localObject, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.uiNewVer))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(7, true, Integer.valueOf(102));
        localObject = StatisticCollector.a(BaseApplication.getContext());
        localHashMap = new HashMap();
        localHashMap.put("result", String.valueOf(i));
        localHashMap.put("version", String.valueOf(this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.uiNewVer));
        localHashMap.put("url", this.jdField_a_of_type_JavaLangString);
        str = this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a.a();
        if (i != 0) {
          break label318;
        }
      }
    }
    for (;;)
    {
      ((StatisticCollector)localObject).a(str, "RichStatusAction", bool, 0L, 0L, localHashMap, "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(7, false, Integer.valueOf(-3));
      break;
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.xml", 2, "httpdownload failed: " + this.jdField_a_of_type_JavaLangString + ", result " + i);
      }
      if ((i == 4) || (i == 12))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(7, false, Integer.valueOf(-3));
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.a(7, false, Integer.valueOf(-1));
      break;
      label318:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fey
 * JD-Core Version:    0.7.0.1
 */