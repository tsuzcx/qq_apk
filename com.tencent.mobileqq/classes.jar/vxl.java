import android.arch.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCirclePrivateMsgShow.StChangePMSettingRsp;

class vxl
  implements aaav<QQCirclePrivateMsgShow.StChangePMSettingRsp>
{
  vxl(vxj paramvxj) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCirclePrivateMsgShow.StChangePMSettingRsp paramStChangePMSettingRsp)
  {
    QLog.d("QCirclePrivateMessageSettingViewModel", 1, "setProfileRequest isSuccess:" + paramBoolean + " retCode:" + paramLong + " errorMsg:" + paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStChangePMSettingRsp == null))
    {
      this.a.b.setValue(vxq.a(paramString).a(paramLong));
      return;
    }
    this.a.b.setValue(vxq.a(false).a(false, paramStChangePMSettingRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxl
 * JD-Core Version:    0.7.0.1
 */