import android.arch.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCirclePrivateMsgShow.StGetPMSettingRsp;

class vuj
  implements zxa<QQCirclePrivateMsgShow.StGetPMSettingRsp>
{
  vuj(vui paramvui) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCirclePrivateMsgShow.StGetPMSettingRsp paramStGetPMSettingRsp)
  {
    QLog.d("QCirclePrivateMessageSettingViewModel", 1, "getPMSettingRequest isSuccess:" + paramBoolean + " retCode:" + paramLong + " errorMsg:" + paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetPMSettingRsp == null))
    {
      this.a.a.setValue(vup.a(paramString).a(paramLong));
      return;
    }
    this.a.a.setValue(vup.a(false).a(false, paramStGetPMSettingRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vuj
 * JD-Core Version:    0.7.0.1
 */