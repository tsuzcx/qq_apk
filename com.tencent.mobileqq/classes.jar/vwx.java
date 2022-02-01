import android.arch.lifecycle.MutableLiveData;
import com.tencent.TMG.utils.QLog;
import qqcircle.QQCircleProfile.SetProfileRsp;

class vwx
  implements aaav<QQCircleProfile.SetProfileRsp>
{
  vwx(vww paramvww) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleProfile.SetProfileRsp paramSetProfileRsp)
  {
    QLog.d("QCircleDataEditViewMode", 1, "setProfileRequest isSuccess:" + paramBoolean + " retCode:" + paramLong + " errorMsg:" + paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramSetProfileRsp == null))
    {
      this.a.a.setValue(vxq.a(paramString).a(paramLong));
      return;
    }
    this.a.a.setValue(vxq.a(false).a(false, paramSetProfileRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwx
 * JD-Core Version:    0.7.0.1
 */