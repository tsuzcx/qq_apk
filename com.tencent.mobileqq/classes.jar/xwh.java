import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class xwh
  extends QQUIEventReceiver<AbsVideoInfoWidget, xbq>
{
  public xwh(@NonNull AbsVideoInfoWidget paramAbsVideoInfoWidget)
  {
    super(paramAbsVideoInfoWidget);
  }
  
  public void a(@NonNull AbsVideoInfoWidget paramAbsVideoInfoWidget, @NonNull xbq paramxbq)
  {
    if ((paramxbq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramxbq.jdField_a_of_type_JavaUtilList == null)) {}
    String str;
    StoryVideoItem localStoryVideoItem;
    do
    {
      do
      {
        return;
        while (paramAbsVideoInfoWidget.a == null) {}
        str = paramAbsVideoInfoWidget.a.a;
        paramxbq = paramxbq.jdField_a_of_type_JavaUtilList.iterator();
      } while (!paramxbq.hasNext());
      localStoryVideoItem = (StoryVideoItem)paramxbq.next();
    } while ((!TextUtils.equals(str, localStoryVideoItem.mVid)) || (!localStoryVideoItem.isBasicInfoOK()));
    paramAbsVideoInfoWidget.i();
  }
  
  public Class acceptEventClass()
  {
    return xbq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwh
 * JD-Core Version:    0.7.0.1
 */