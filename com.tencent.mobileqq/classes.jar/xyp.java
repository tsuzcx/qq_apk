import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xyp
  extends QQUIEventReceiver<xyd, xji>
{
  public xyp(@NonNull xyd paramxyd)
  {
    super(paramxyd);
  }
  
  public void a(@NonNull xyd paramxyd, @NonNull xji paramxji)
  {
    if (TextUtils.equals(String.valueOf(paramxyd.hashCode()), paramxji.jdField_a_of_type_JavaLangString)) {
      b(paramxyd, paramxji);
    }
  }
  
  public Class acceptEventClass()
  {
    return xji.class;
  }
  
  public void b(xyd paramxyd, xji paramxji)
  {
    paramxyd = ((StoryPlayerGroupHolder)paramxyd.a()).a();
    if (paramxyd != null) {
      paramxyd.c(false);
    }
    if (paramxji.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
      return;
    }
    boolean bool = xiz.a(paramxji.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    switch (paramxji.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return;
    case 1: 
      QQToast.a(BaseApplicationImpl.getContext(), 1, anzj.a(2131705772), 0).a();
      return;
    case 2: 
      if (bool) {}
      for (paramxyd = "2";; paramxyd = "1")
      {
        yup.a("play_video", "down_suc", 0, 0, new String[] { paramxyd, "", "", paramxji.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        QQToast.a(BaseApplicationImpl.getContext(), 2, wnu.a(2131698633), 0).a();
        return;
      }
    }
    if (bool) {}
    for (paramxyd = "2";; paramxyd = "1")
    {
      yup.a("play_video", "down_fail", 0, 0, new String[] { paramxyd, "", "", paramxji.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      QQToast.a(BaseApplicationImpl.getContext(), 1, anzj.a(2131705776), 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyp
 * JD-Core Version:    0.7.0.1
 */