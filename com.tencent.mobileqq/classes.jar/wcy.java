import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.VideoCompositeRec.1;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wcy
  extends QQUIEventReceiver<wcn, wdi>
{
  public wcy(@NonNull wcn paramwcn)
  {
    super(paramwcn);
  }
  
  public void a(@NonNull wcn paramwcn, @NonNull wdi paramwdi)
  {
    if (paramwdi.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ykq.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "get event update  vid:%s video path:%s", paramwdi.jdField_a_of_type_JavaLangString, paramwdi.b);
      Bosses.get().postLightWeightJob(new StoryVideoUploadManager.VideoCompositeRec.1(this, paramwcn, paramwdi), 0);
    }
  }
  
  public Class acceptEventClass()
  {
    return wdi.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcy
 * JD-Core Version:    0.7.0.1
 */