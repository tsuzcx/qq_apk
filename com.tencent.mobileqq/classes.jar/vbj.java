import android.os.Bundle;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMultiRcmdDisLike;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.List;

class vbj
  extends mxm
{
  vbj(vbi paramvbi) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.home:FeedSegment", 2, "ReqMultiRcmdDisLike,onResult error=" + paramInt + " data=" + paramArrayOfByte);
      }
      return;
    }
    try
    {
      paramBundle = new qqstory_service.RspMultiRcmdDisLike();
      paramBundle.mergeFrom(paramArrayOfByte);
      paramInt = ((qqstory_struct.ErrorInfo)paramBundle.result.get()).error_code.get();
      if (paramInt != 0) {
        break label255;
      }
      QLog.d("Q.qqstory.home:FeedSegment", 1, "RspMultiRcmdDisLike, dislike success");
      paramArrayOfByte = (uxl)this.a.jdField_a_of_type_Vbd.a.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHotRecommendFeedItem.feedId);
      paramArrayOfByte.a(this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      if (paramArrayOfByte.a().isEmpty())
      {
        this.a.jdField_a_of_type_Vbd.a.a().remove(paramArrayOfByte);
        paramArrayOfByte = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHotRecommendFeedItem.feedId;
        Bosses.get().postJob(new vbk(this, "Q.qqstory.home:FeedSegment", paramArrayOfByte));
        vbd.a(this.a.jdField_a_of_type_Vbd);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.d("Q.qqstory.home:FeedSegment", 1, "RspMultiRcmdDisLike, error protobuf content" + paramArrayOfByte.getStackTrace());
      return;
    }
    vbd.a(this.a.jdField_a_of_type_Vbd, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHotRecommendFeedItem.feedId);
    return;
    label255:
    QLog.d("Q.qqstory.home:FeedSegment", 1, "RspMultiRcmdDisLike, errorcode:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbj
 * JD-Core Version:    0.7.0.1
 */