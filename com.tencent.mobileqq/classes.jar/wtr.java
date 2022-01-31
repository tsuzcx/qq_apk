import com.tencent.biz.subscribe.videoplayer.CleanVideoPlayerView;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class wtr
  implements udh
{
  wtr(wto paramwto, adni paramadni, CleanVideoPlayerView paramCleanVideoPlayerView) {}
  
  public void a_(udc paramudc)
  {
    Long localLong = (Long)wto.b(this.jdField_a_of_type_Wto).get(Integer.valueOf(this.jdField_a_of_type_Adni.b));
    if ((localLong != null) && (localLong.longValue() > 0L))
    {
      paramudc.a(localLong.longValue());
      QLog.d("SubscribePlayerManager", 4, "playInner seekTo: " + localLong);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerCleanVideoPlayerView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wtr
 * JD-Core Version:    0.7.0.1
 */