import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xox
  extends QQUIEventReceiver<xoj, xaa>
{
  public xox(@NonNull xoj paramxoj)
  {
    super(paramxoj);
  }
  
  public void a(@NonNull xoj paramxoj, @NonNull xaa paramxaa)
  {
    if (!TextUtils.equals(paramxaa.b, String.valueOf(paramxoj.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramxoj.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramxoj.l();
    if (paramxaa.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ykq.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramxaa.jdField_a_of_type_JavaLangString);
      if (paramxaa.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        wzy.a().a(paramxoj.b(), paramxaa.jdField_a_of_type_JavaLangString);
        return;
      }
      wzy.a().a(paramxoj.b(), paramxaa.jdField_a_of_type_JavaLangString, paramxaa.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxoj.hashCode());
      return;
    }
    ykq.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    QQToast.a(BaseApplicationImpl.getContext(), 1, anvx.a(2131706351), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return xaa.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xox
 * JD-Core Version:    0.7.0.1
 */