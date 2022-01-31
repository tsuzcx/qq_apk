import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import protocol.KQQConfig.GetResourceRespInfo;

public class yyo
  implements Runnable
{
  public yyo(ConfigHandler paramConfigHandler, String paramString, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler.b, MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.uiNewVer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yyo
 * JD-Core Version:    0.7.0.1
 */