import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vzv
  extends QQUIEventReceiver<vzl, vmi>
{
  public vzv(@NonNull vzl paramvzl)
  {
    super(paramvzl);
  }
  
  public void a(@NonNull vzl paramvzl, @NonNull vmi paramvmi)
  {
    if (!TextUtils.equals(paramvmi.b, String.valueOf(paramvzl.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramvzl.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramvzl.l();
    if (paramvmi.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      wxe.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramvmi.jdField_a_of_type_JavaLangString);
      if (paramvmi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        vmg.a().a(paramvzl.b(), paramvmi.jdField_a_of_type_JavaLangString);
        return;
      }
      vmg.a().a(paramvzl.b(), paramvmi.jdField_a_of_type_JavaLangString, paramvmi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvzl.hashCode());
      return;
    }
    wxe.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    QQToast.a(BaseApplicationImpl.getContext(), 1, alud.a(2131701555), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return vmi.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vzv
 * JD-Core Version:    0.7.0.1
 */