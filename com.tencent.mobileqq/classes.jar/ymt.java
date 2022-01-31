import com.tencent.biz.subscribe.videoplayer.CleanVideoPlayerView;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ymt
  implements vwf
{
  ymt(ymq paramymq, afkf paramafkf, CleanVideoPlayerView paramCleanVideoPlayerView) {}
  
  public void a(vwa paramvwa)
  {
    Long localLong = (Long)ymq.b(this.jdField_a_of_type_Ymq).get(Integer.valueOf(this.jdField_a_of_type_Afkf.b));
    if ((localLong != null) && (localLong.longValue() > 0L))
    {
      paramvwa.a(localLong.longValue());
      QLog.d("SubscribePlayerManager", 4, "playInner seekTo: " + localLong);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerCleanVideoPlayerView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ymt
 * JD-Core Version:    0.7.0.1
 */