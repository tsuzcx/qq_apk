import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.VideoCompositeRec.1;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vod
  extends QQUIEventReceiver<vns, von>
{
  public vod(@NonNull vns paramvns)
  {
    super(paramvns);
  }
  
  public void a(@NonNull vns paramvns, @NonNull von paramvon)
  {
    if (paramvon.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      xvv.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "get event update  vid:%s video path:%s", paramvon.jdField_a_of_type_JavaLangString, paramvon.b);
      Bosses.get().postLightWeightJob(new StoryVideoUploadManager.VideoCompositeRec.1(this, paramvns, paramvon), 0);
    }
  }
  
  public Class acceptEventClass()
  {
    return von.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vod
 * JD-Core Version:    0.7.0.1
 */