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

class qyq
  extends jnm.d
{
  qyq(qyp paramqyp) {}
  
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
      paramArrayOfByte = (qvx)this.a.this$0.a.a(this.a.a.feedId);
      paramArrayOfByte.o(this.a.val$storyVideoItem);
      if (paramArrayOfByte.bS().isEmpty())
      {
        this.a.this$0.a.bY().remove(paramArrayOfByte);
        paramArrayOfByte = this.a.a.feedId;
        Bosses.get().postJob(new qyr(this, "Q.qqstory.home:FeedSegment", paramArrayOfByte));
        qyk.a(this.a.this$0);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.d("Q.qqstory.home:FeedSegment", 1, "RspMultiRcmdDisLike, error protobuf content" + paramArrayOfByte.getStackTrace());
      return;
    }
    qyk.a(this.a.this$0, this.a.a.feedId);
    return;
    label255:
    QLog.d("Q.qqstory.home:FeedSegment", 1, "RspMultiRcmdDisLike, errorcode:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qyq
 * JD-Core Version:    0.7.0.1
 */