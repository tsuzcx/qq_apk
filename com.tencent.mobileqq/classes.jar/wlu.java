import android.os.Bundle;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;

public class wlu
  extends wno
{
  qqstory_service.RspAddFeedComment jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspAddFeedComment;
  wnp jdField_a_of_type_Wnp;
  
  public wlu(qqstory_service.RspAddFeedComment paramRspAddFeedComment, wnp paramwnp)
  {
    super(paramRspAddFeedComment.result);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspAddFeedComment = paramRspAddFeedComment;
    this.jdField_a_of_type_Wnp = paramwnp;
  }
  
  public wlu(wnp paramwnp)
  {
    this.jdField_a_of_type_Wnp = paramwnp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wnp.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspAddFeedComment);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Wnp.a(paramInt, paramBundle);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Wnp.a(paramInt, paramString);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_Wnp.a(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlu
 * JD-Core Version:    0.7.0.1
 */