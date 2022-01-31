import com.tencent.biz.subscribe.videoplayer.CleanVideoPlayerView;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class yig
  implements vrw
{
  yig(yid paramyid, affq paramaffq, CleanVideoPlayerView paramCleanVideoPlayerView) {}
  
  public void a(vrr paramvrr)
  {
    Long localLong = (Long)yid.b(this.jdField_a_of_type_Yid).get(Integer.valueOf(this.jdField_a_of_type_Affq.b));
    if ((localLong != null) && (localLong.longValue() > 0L))
    {
      paramvrr.a(localLong.longValue());
      QLog.d("SubscribePlayerManager", 4, "playInner seekTo: " + localLong);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerCleanVideoPlayerView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yig
 * JD-Core Version:    0.7.0.1
 */