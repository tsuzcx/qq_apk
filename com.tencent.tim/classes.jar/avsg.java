import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import cooperation.qzone.util.NetworkState.a;

class avsg
  implements NetworkState.a
{
  avsg(avsf paramavsf, UploadConfiguration.NetworkStateObserver paramNetworkStateObserver) {}
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadEnv", 2, "upload2: onNetworkConnect registerNetworkStateObserver|onNetworkConnect：" + paramBoolean);
    }
    avsf.a(this.jdField_a_of_type_Avsf, paramBoolean);
    this.jdField_a_of_type_ComTencentUploadCommonUploadConfiguration$NetworkStateObserver.onStateChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsg
 * JD-Core Version:    0.7.0.1
 */