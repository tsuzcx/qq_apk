import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.VideoCompositeRec.1;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uko
  extends QQUIEventReceiver<ukd, ulg>
{
  public uko(@NonNull ukd paramukd)
  {
    super(paramukd);
  }
  
  public void a(@NonNull ukd paramukd, @NonNull ulg paramulg)
  {
    if (paramulg.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      wsv.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "get event update  vid:%s video path:%s", paramulg.jdField_a_of_type_JavaLangString, paramulg.b);
      Bosses.get().postLightWeightJob(new StoryVideoUploadManager.VideoCompositeRec.1(this, paramukd, paramulg), 0);
    }
  }
  
  public Class acceptEventClass()
  {
    return ulg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uko
 * JD-Core Version:    0.7.0.1
 */