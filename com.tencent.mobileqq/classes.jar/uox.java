import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.VideoCompositeRec.1;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uox
  extends QQUIEventReceiver<uom, upp>
{
  public uox(@NonNull uom paramuom)
  {
    super(paramuom);
  }
  
  public void a(@NonNull uom paramuom, @NonNull upp paramupp)
  {
    if (paramupp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      wxe.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "get event update  vid:%s video path:%s", paramupp.jdField_a_of_type_JavaLangString, paramupp.b);
      Bosses.get().postLightWeightJob(new StoryVideoUploadManager.VideoCompositeRec.1(this, paramuom, paramupp), 0);
    }
  }
  
  public Class acceptEventClass()
  {
    return upp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uox
 * JD-Core Version:    0.7.0.1
 */