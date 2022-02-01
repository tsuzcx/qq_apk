import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleChangePMSettingRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetPMSettingRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import qqcircle.QQCirclePrivateMsgShow.StChangePMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow.StGetPMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow.StPMSettingData;

public class vxj
  extends aabb
{
  public MutableLiveData<vxq<QQCirclePrivateMsgShow.StGetPMSettingRsp>> a = new MutableLiveData();
  public MutableLiveData<vxq<QQCirclePrivateMsgShow.StChangePMSettingRsp>> b = new MutableLiveData();
  
  public String a()
  {
    return "QCirclePrivateMessageSettingViewModel";
  }
  
  public void a(String paramString)
  {
    paramString = new QCircleGetPMSettingRequest(paramString);
    this.a.setValue(vxq.b());
    VSNetworkHelper.a().a(paramString, new vxk(this));
  }
  
  public void a(QQCirclePrivateMsgShow.StPMSettingData paramStPMSettingData)
  {
    paramStPMSettingData = new QCircleChangePMSettingRequest(paramStPMSettingData);
    this.b.setValue(vxq.b());
    VSNetworkHelper.a().a(paramStPMSettingData, new vxl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxj
 * JD-Core Version:    0.7.0.1
 */