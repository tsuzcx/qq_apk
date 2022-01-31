import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ugv
  extends QQUIEventReceiver<ugn, ttd>
{
  public ugv(@NonNull ugn paramugn)
  {
    super(paramugn);
  }
  
  public void a(@NonNull ugn paramugn, @NonNull ttd paramttd)
  {
    if (TextUtils.equals(String.valueOf(paramugn.hashCode()), paramttd.jdField_a_of_type_JavaLangString)) {
      b(paramugn, paramttd);
    }
  }
  
  public Class acceptEventClass()
  {
    return ttd.class;
  }
  
  public void b(ugn paramugn, ttd paramttd)
  {
    paramugn = ((StoryPlayerGroupHolder)paramugn.a()).a();
    if (paramugn != null) {
      paramugn.c(false);
    }
    if (paramttd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
      return;
    }
    boolean bool = tsu.a(paramttd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    switch (paramttd.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return;
    case 1: 
      bcpw.a(BaseApplicationImpl.getContext(), 1, ajyc.a(2131701164), 0).a();
      return;
    case 2: 
      if (bool) {}
      for (paramugn = "2";; paramugn = "1")
      {
        vel.a("play_video", "down_suc", 0, 0, new String[] { paramugn, "", "", paramttd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        bcpw.a(BaseApplicationImpl.getContext(), 2, sxp.a(2131699708), 0).a();
        return;
      }
    }
    if (bool) {}
    for (paramugn = "2";; paramugn = "1")
    {
      vel.a("play_video", "down_fail", 0, 0, new String[] { paramugn, "", "", paramttd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      bcpw.a(BaseApplicationImpl.getContext(), 1, ajyc.a(2131701165), 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugv
 * JD-Core Version:    0.7.0.1
 */