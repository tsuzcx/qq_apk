import android.os.Bundle;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDelFeedComment;

public class vri
  extends vta
{
  qqstory_service.RspDelFeedComment jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspDelFeedComment;
  vtb jdField_a_of_type_Vtb;
  
  public vri(qqstory_service.RspDelFeedComment paramRspDelFeedComment, vtb paramvtb)
  {
    super(paramRspDelFeedComment.result);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspDelFeedComment = paramRspDelFeedComment;
    this.jdField_a_of_type_Vtb = paramvtb;
  }
  
  public vri(vtb paramvtb)
  {
    this.jdField_a_of_type_Vtb = paramvtb;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vtb.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspDelFeedComment);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Vtb.a(paramInt, paramBundle);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Vtb.a(paramInt, paramString);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_Vtb.a(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vri
 * JD-Core Version:    0.7.0.1
 */