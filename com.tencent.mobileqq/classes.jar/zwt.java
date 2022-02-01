import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StVideo;

class zwt
  implements vob
{
  zwt(zws paramzws, FeedCloudMeta.StVideo paramStVideo) {}
  
  public void a(long paramLong, String paramString)
  {
    if (!VSNetworkHelper.a((int)paramLong)) {
      this.jdField_a_of_type_Zws.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo.fileId.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo.playUrl.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo.duration.get());
    }
  }
  
  public void a(FeedCloudMeta.StVideo paramStVideo, boolean paramBoolean)
  {
    this.jdField_a_of_type_Zws.a(paramStVideo.fileId.get(), paramStVideo.playUrl.get(), paramStVideo.duration.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwt
 * JD-Core Version:    0.7.0.1
 */