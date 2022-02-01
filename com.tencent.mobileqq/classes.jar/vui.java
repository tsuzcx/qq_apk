import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleChangePMSettingRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetPMSettingRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import qqcircle.QQCirclePrivateMsgShow.StChangePMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow.StGetPMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow.StPMSettingData;

public class vui
  extends zxg
{
  public MutableLiveData<vup<QQCirclePrivateMsgShow.StGetPMSettingRsp>> a = new MutableLiveData();
  public MutableLiveData<vup<QQCirclePrivateMsgShow.StChangePMSettingRsp>> b = new MutableLiveData();
  
  public String a()
  {
    return "QCirclePrivateMessageSettingViewModel";
  }
  
  public void a(String paramString)
  {
    paramString = new QCircleGetPMSettingRequest(paramString);
    this.a.setValue(vup.b());
    VSNetworkHelper.a().a(paramString, new vuj(this));
  }
  
  public void a(QQCirclePrivateMsgShow.StPMSettingData paramStPMSettingData)
  {
    paramStPMSettingData = new QCircleChangePMSettingRequest(paramStPMSettingData);
    this.b.setValue(vup.b());
    VSNetworkHelper.a().a(paramStPMSettingData, new vuk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vui
 * JD-Core Version:    0.7.0.1
 */