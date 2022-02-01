import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xuw
  extends QQUIEventReceiver<xui, xfu>
{
  public xuw(@NonNull xui paramxui)
  {
    super(paramxui);
  }
  
  public void a(@NonNull xui paramxui, @NonNull xfu paramxfu)
  {
    if (!TextUtils.equals(paramxfu.b, String.valueOf(paramxui.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramxui.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramxui.l();
    if (paramxfu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      yqp.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramxfu.jdField_a_of_type_JavaLangString);
      if (paramxfu.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        xfs.a().a(paramxui.b(), paramxfu.jdField_a_of_type_JavaLangString);
        return;
      }
      xfs.a().a(paramxui.b(), paramxfu.jdField_a_of_type_JavaLangString, paramxfu.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxui.hashCode());
      return;
    }
    yqp.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    QQToast.a(BaseApplicationImpl.getContext(), 1, anni.a(2131705663), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return xfu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xuw
 * JD-Core Version:    0.7.0.1
 */