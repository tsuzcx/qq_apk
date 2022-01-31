import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ttz
  extends QQUIEventReceiver<ttr, tgh>
{
  public ttz(@NonNull ttr paramttr)
  {
    super(paramttr);
  }
  
  public void a(@NonNull ttr paramttr, @NonNull tgh paramtgh)
  {
    if (TextUtils.equals(String.valueOf(paramttr.hashCode()), paramtgh.jdField_a_of_type_JavaLangString)) {
      b(paramttr, paramtgh);
    }
  }
  
  public Class acceptEventClass()
  {
    return tgh.class;
  }
  
  public void b(ttr paramttr, tgh paramtgh)
  {
    paramttr = ((StoryPlayerGroupHolder)paramttr.a()).a();
    if (paramttr != null) {
      paramttr.c(false);
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
      bbmy.a(BaseApplicationImpl.getContext(), 1, ajjy.a(2131635380), 0).a();
      return;
    case 2: 
      if (bool) {}
      for (paramttr = "2";; paramttr = "1")
      {
        urp.a("play_video", "down_suc", 0, 0, new String[] { paramttr, "", "", paramtgh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        bbmy.a(BaseApplicationImpl.getContext(), 2, skt.a(2131633920), 0).a();
        return;
      }
    }
    if (bool) {}
    for (paramttr = "2";; paramttr = "1")
    {
      urp.a("play_video", "down_fail", 0, 0, new String[] { paramttr, "", "", paramtgh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      bbmy.a(BaseApplicationImpl.getContext(), 1, ajjy.a(2131635381), 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ttz
 * JD-Core Version:    0.7.0.1
 */