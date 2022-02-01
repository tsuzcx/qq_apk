import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class xaf
  implements woy<xdj, xex>
{
  xaf(List paramList) {}
  
  public void a(@NonNull xdj paramxdj, @Nullable xex paramxex, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond");
    xag localxag = new xag();
    localxag.jdField_a_of_type_JavaUtilList = new ArrayList(paramxdj.jdField_a_of_type_JavaUtilList);
    localxag.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramxex == null))
    {
      yuk.c("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond: get story player tag info failed, error:%s", paramErrorMessage);
      wjj.a().dispatch(localxag);
      return;
    }
    yuk.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond, vid list:%s, response list:%s", this.jdField_a_of_type_JavaUtilList, paramxex.jdField_a_of_type_JavaUtilList);
    paramErrorMessage = (wte)wth.a(5);
    paramxdj = paramxdj.jdField_a_of_type_JavaUtilList.iterator();
    while (paramxdj.hasNext())
    {
      Object localObject = (String)paramxdj.next();
      StoryVideoItem localStoryVideoItem = paramErrorMessage.a((String)localObject);
      localObject = xae.a((String)localObject, paramxex.jdField_a_of_type_JavaUtilList);
      if (localStoryVideoItem != null)
      {
        if (localObject == null)
        {
          localStoryVideoItem.mTagInfoBase = null;
          localStoryVideoItem.mCompInfoBase = null;
          localStoryVideoItem.mOALinkInfoJson = null;
        }
        for (localStoryVideoItem.mOALinkInfo = null;; localStoryVideoItem.mOALinkInfo = wuw.a(localStoryVideoItem.mOALinkInfoJson))
        {
          if (localStoryVideoItem.mTagInfoBase != null) {
            localStoryVideoItem.mTagInfoBase.b = System.currentTimeMillis();
          }
          paramErrorMessage.a(localStoryVideoItem);
          break;
          localStoryVideoItem.mTagInfoBase = ((xdk)localObject).jdField_a_of_type_Zll;
          localStoryVideoItem.mCompInfoBase = ((xdk)localObject).jdField_a_of_type_Zld;
          localStoryVideoItem.mOALinkInfoJson = ((xdk)localObject).b;
        }
      }
    }
    localxag.b = new ArrayList(paramxex.jdField_a_of_type_JavaUtilList);
    wjj.a().dispatch(localxag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xaf
 * JD-Core Version:    0.7.0.1
 */