import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.VideoCompositeRec.1;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wme
  extends QQUIEventReceiver<wlt, wmw>
{
  public wme(@NonNull wlt paramwlt)
  {
    super(paramwlt);
  }
  
  public void a(@NonNull wlt paramwlt, @NonNull wmw paramwmw)
  {
    if (paramwmw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      yuk.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "get event update  vid:%s video path:%s", paramwmw.jdField_a_of_type_JavaLangString, paramwmw.b);
      Bosses.get().postLightWeightJob(new StoryVideoUploadManager.VideoCompositeRec.1(this, paramwlt, paramwmw), 0);
    }
  }
  
  public Class acceptEventClass()
  {
    return wmw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wme
 * JD-Core Version:    0.7.0.1
 */