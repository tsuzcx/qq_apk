import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribeGetRecommendUserListRequest;

public class vwd
{
  private long jdField_a_of_type_Long;
  private COMM.StCommonExt jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  private vwf jdField_a_of_type_Vwf;
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramString = new SubscribeGetRecommendUserListRequest(paramString, this.jdField_a_of_type_NS_COMMCOMM$StCommonExt, 0, 1);
    VSNetworkHelper.a().a(paramString, new vwe(this));
  }
  
  public void a(vwf paramvwf)
  {
    this.jdField_a_of_type_Vwf = paramvwf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vwd
 * JD-Core Version:    0.7.0.1
 */