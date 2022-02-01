import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xte
  extends QQUIEventReceiver<xsw, xfn>
{
  public xte(@NonNull xsw paramxsw)
  {
    super(paramxsw);
  }
  
  public void a(@NonNull xsw paramxsw, @NonNull xfn paramxfn)
  {
    if (TextUtils.equals(String.valueOf(paramxsw.hashCode()), paramxfn.jdField_a_of_type_JavaLangString)) {
      b(paramxsw, paramxfn);
    }
  }
  
  public Class acceptEventClass()
  {
    return xfn.class;
  }
  
  public void b(xsw paramxsw, xfn paramxfn)
  {
    paramxsw = ((StoryPlayerGroupHolder)paramxsw.a()).a();
    if (paramxsw != null) {
      paramxsw.c(false);
    }
    if (paramxfn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
      return;
    }
    boolean bool = xfe.a(paramxfn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    switch (paramxfn.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return;
    case 1: 
      QQToast.a(BaseApplicationImpl.getContext(), 1, anni.a(2131699980), 0).a();
      return;
    case 2: 
      if (bool) {}
      for (paramxsw = "2";; paramxsw = "1")
      {
        yqu.a("play_video", "down_suc", 0, 0, new String[] { paramxsw, "", "", paramxfn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        QQToast.a(BaseApplicationImpl.getContext(), 2, wjz.a(2131698526), 0).a();
        return;
      }
    }
    if (bool) {}
    for (paramxsw = "2";; paramxsw = "1")
    {
      yqu.a("play_video", "down_fail", 0, 0, new String[] { paramxsw, "", "", paramxfn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      QQToast.a(BaseApplicationImpl.getContext(), 1, anni.a(2131699981), 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xte
 * JD-Core Version:    0.7.0.1
 */