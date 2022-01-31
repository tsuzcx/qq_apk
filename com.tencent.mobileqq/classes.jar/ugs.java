import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ugs
  extends QQUIEventReceiver<ugk, tta>
{
  public ugs(@NonNull ugk paramugk)
  {
    super(paramugk);
  }
  
  public void a(@NonNull ugk paramugk, @NonNull tta paramtta)
  {
    if (TextUtils.equals(String.valueOf(paramugk.hashCode()), paramtta.jdField_a_of_type_JavaLangString)) {
      b(paramugk, paramtta);
    }
  }
  
  public Class acceptEventClass()
  {
    return tta.class;
  }
  
  public void b(ugk paramugk, tta paramtta)
  {
    paramugk = ((StoryPlayerGroupHolder)paramugk.a()).a();
    if (paramugk != null) {
      paramugk.c(false);
    }
    if (paramtta.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
      return;
    }
    boolean bool = tsr.a(paramtta.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    switch (paramtta.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return;
    case 1: 
      bcql.a(BaseApplicationImpl.getContext(), 1, ajya.a(2131701175), 0).a();
      return;
    case 2: 
      if (bool) {}
      for (paramugk = "2";; paramugk = "1")
      {
        vei.a("play_video", "down_suc", 0, 0, new String[] { paramugk, "", "", paramtta.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        bcql.a(BaseApplicationImpl.getContext(), 2, sxm.a(2131699719), 0).a();
        return;
      }
    }
    if (bool) {}
    for (paramugk = "2";; paramugk = "1")
    {
      vei.a("play_video", "down_fail", 0, 0, new String[] { paramugk, "", "", paramtta.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      bcql.a(BaseApplicationImpl.getContext(), 1, ajya.a(2131701176), 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugs
 * JD-Core Version:    0.7.0.1
 */