import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tvp
  extends QQUIEventReceiver<tvd, tgh>
{
  public tvp(@NonNull tvd paramtvd)
  {
    super(paramtvd);
  }
  
  public void a(@NonNull tvd paramtvd, @NonNull tgh paramtgh)
  {
    if (TextUtils.equals(String.valueOf(paramtvd.hashCode()), paramtgh.jdField_a_of_type_JavaLangString)) {
      b(paramtvd, paramtgh);
    }
  }
  
  public Class acceptEventClass()
  {
    return tgh.class;
  }
  
  public void b(tvd paramtvd, tgh paramtgh)
  {
    paramtvd = ((StoryPlayerGroupHolder)paramtvd.a()).a();
    if (paramtvd != null) {
      paramtvd.c(false);
    }
    if (paramtgh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
      return;
    }
    boolean bool = tfy.a(paramtgh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    switch (paramtgh.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return;
    case 1: 
      bbmy.a(BaseApplicationImpl.getContext(), 1, ajjy.a(2131641094), 0).a();
      return;
    case 2: 
      if (bool) {}
      for (paramtvd = "2";; paramtvd = "1")
      {
        urp.a("play_video", "down_suc", 0, 0, new String[] { paramtvd, "", "", paramtgh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        bbmy.a(BaseApplicationImpl.getContext(), 2, skt.a(2131633920), 0).a();
        return;
      }
    }
    if (bool) {}
    for (paramtvd = "2";; paramtvd = "1")
    {
      urp.a("play_video", "down_fail", 0, 0, new String[] { paramtvd, "", "", paramtgh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      bbmy.a(BaseApplicationImpl.getContext(), 1, ajjy.a(2131641098), 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvp
 * JD-Core Version:    0.7.0.1
 */