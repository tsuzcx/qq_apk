import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wym
  extends QQUIEventReceiver<wyc, wlf>
{
  public wym(@NonNull wyc paramwyc)
  {
    super(paramwyc);
  }
  
  public void a(@NonNull wyc paramwyc, @NonNull wlf paramwlf)
  {
    if (!TextUtils.equals(paramwlf.b, String.valueOf(paramwyc.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramwyc.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramwyc.l();
    if (paramwlf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      xvv.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramwlf.jdField_a_of_type_JavaLangString);
      if (paramwlf.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        wld.a().a(paramwyc.b(), paramwlf.jdField_a_of_type_JavaLangString);
        return;
      }
      wld.a().a(paramwyc.b(), paramwlf.jdField_a_of_type_JavaLangString, paramwlf.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwyc.hashCode());
      return;
    }
    xvv.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    QQToast.a(BaseApplicationImpl.getContext(), 1, amtj.a(2131700321), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return wlf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wym
 * JD-Core Version:    0.7.0.1
 */