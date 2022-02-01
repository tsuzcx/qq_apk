import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleSetProfileRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.List;
import qqcircle.QQCircleProfile.SetProfileRsp;

public class vtx
  extends zxg
{
  public MutableLiveData<vup<QQCircleProfile.SetProfileRsp>> a = new MutableLiveData();
  
  public String a()
  {
    return "QCircleDataEditViewMode";
  }
  
  public void a(String paramString, List<FeedCloudMeta.StTagInfo> paramList, List<Long> paramList1)
  {
    paramString = new QCircleSetProfileRequest(paramString, paramList, paramList1);
    this.a.setValue(vup.b());
    VSNetworkHelper.a().a(paramString, new vty(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtx
 * JD-Core Version:    0.7.0.1
 */