import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wbl
  extends QQUIEventReceiver<wax, vmi>
{
  public wbl(@NonNull wax paramwax)
  {
    super(paramwax);
  }
  
  public void a(@NonNull wax paramwax, @NonNull vmi paramvmi)
  {
    if (!TextUtils.equals(paramvmi.b, String.valueOf(paramwax.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramwax.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramwax.l();
    if (paramvmi.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      wxe.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramvmi.jdField_a_of_type_JavaLangString);
      if (paramvmi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        vmg.a().a(paramwax.b(), paramvmi.jdField_a_of_type_JavaLangString);
        return;
      }
      vmg.a().a(paramwax.b(), paramvmi.jdField_a_of_type_JavaLangString, paramvmi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwax.hashCode());
      return;
    }
    wxe.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    QQToast.a(BaseApplicationImpl.getContext(), 1, alud.a(2131707272), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return vmi.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wbl
 * JD-Core Version:    0.7.0.1
 */