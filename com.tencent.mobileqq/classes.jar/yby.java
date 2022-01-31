import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribeGetRecommendUserListRequest;

public class yby
{
  private long jdField_a_of_type_Long;
  private COMM.StCommonExt jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  private yca jdField_a_of_type_Yca;
  
  public COMM.StCommonExt a()
  {
    return this.jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramString = new SubscribeGetRecommendUserListRequest(paramString, this.jdField_a_of_type_NS_COMMCOMM$StCommonExt, 0, 1);
    VSNetworkHelper.a().a(paramString, new ybz(this));
  }
  
  public void a(yca paramyca)
  {
    this.jdField_a_of_type_Yca = paramyca;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yby
 * JD-Core Version:    0.7.0.1
 */