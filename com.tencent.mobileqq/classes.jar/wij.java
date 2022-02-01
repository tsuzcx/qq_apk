import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.VideoCompositeRec.1;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wij
  extends QQUIEventReceiver<why, wjb>
{
  public wij(@NonNull why paramwhy)
  {
    super(paramwhy);
  }
  
  public void a(@NonNull why paramwhy, @NonNull wjb paramwjb)
  {
    if (paramwjb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      yqp.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "get event update  vid:%s video path:%s", paramwjb.jdField_a_of_type_JavaLangString, paramwjb.b);
      Bosses.get().postLightWeightJob(new StoryVideoUploadManager.VideoCompositeRec.1(this, paramwhy, paramwjb), 0);
    }
  }
  
  public Class acceptEventClass()
  {
    return wjb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wij
 * JD-Core Version:    0.7.0.1
 */