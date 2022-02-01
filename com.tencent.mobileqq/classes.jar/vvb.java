import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.BaseApplication;

public class vvb
  implements aadq<QCircleBaseRequest, vuz>
{
  public String a()
  {
    return "QCircleSenderReqInterceptor";
  }
  
  public void a(QCircleBaseRequest paramQCircleBaseRequest, vuz paramvuz)
  {
    if ((paramQCircleBaseRequest == null) || (paramvuz == null)) {
      return;
    }
    VSNetworkHelper.a().a(BaseApplication.getContext(), paramQCircleBaseRequest, new vvc(this, paramvuz, paramQCircleBaseRequest));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvb
 * JD-Core Version:    0.7.0.1
 */