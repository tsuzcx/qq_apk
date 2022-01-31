import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uii
  extends QQUIEventReceiver<uhw, tta>
{
  public uii(@NonNull uhw paramuhw)
  {
    super(paramuhw);
  }
  
  public void a(@NonNull uhw paramuhw, @NonNull tta paramtta)
  {
    if (TextUtils.equals(String.valueOf(paramuhw.hashCode()), paramtta.jdField_a_of_type_JavaLangString)) {
      b(paramuhw, paramtta);
    }
  }
  
  public Class acceptEventClass()
  {
    return tta.class;
  }
  
  public void b(uhw paramuhw, tta paramtta)
  {
    paramuhw = ((StoryPlayerGroupHolder)paramuhw.a()).a();
    if (paramuhw != null) {
      paramuhw.c(false);
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
      bcql.a(BaseApplicationImpl.getContext(), 1, ajya.a(2131706890), 0).a();
      return;
    case 2: 
      if (bool) {}
      for (paramuhw = "2";; paramuhw = "1")
      {
        vei.a("play_video", "down_suc", 0, 0, new String[] { paramuhw, "", "", paramtta.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        bcql.a(BaseApplicationImpl.getContext(), 2, sxm.a(2131699719), 0).a();
        return;
      }
    }
    if (bool) {}
    for (paramuhw = "2";; paramuhw = "1")
    {
      vei.a("play_video", "down_fail", 0, 0, new String[] { paramuhw, "", "", paramtta.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      bcql.a(BaseApplicationImpl.getContext(), 1, ajya.a(2131706894), 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uii
 * JD-Core Version:    0.7.0.1
 */