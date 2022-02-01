import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class wwk
  implements wld<wzo, xbc>
{
  wwk(List paramList) {}
  
  public void a(@NonNull wzo paramwzo, @Nullable xbc paramxbc, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond");
    wwl localwwl = new wwl();
    localwwl.jdField_a_of_type_JavaUtilList = new ArrayList(paramwzo.jdField_a_of_type_JavaUtilList);
    localwwl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramxbc == null))
    {
      yqp.c("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond: get story player tag info failed, error:%s", paramErrorMessage);
      wfo.a().dispatch(localwwl);
      return;
    }
    yqp.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond, vid list:%s, response list:%s", this.jdField_a_of_type_JavaUtilList, paramxbc.jdField_a_of_type_JavaUtilList);
    paramErrorMessage = (wpj)wpm.a(5);
    paramwzo = paramwzo.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwzo.hasNext())
    {
      Object localObject = (String)paramwzo.next();
      StoryVideoItem localStoryVideoItem = paramErrorMessage.a((String)localObject);
      localObject = wwj.a((String)localObject, paramxbc.jdField_a_of_type_JavaUtilList);
      if (localStoryVideoItem != null)
      {
        if (localObject == null)
        {
          localStoryVideoItem.mTagInfoBase = null;
          localStoryVideoItem.mCompInfoBase = null;
          localStoryVideoItem.mOALinkInfoJson = null;
        }
        for (localStoryVideoItem.mOALinkInfo = null;; localStoryVideoItem.mOALinkInfo = wrb.a(localStoryVideoItem.mOALinkInfoJson))
        {
          if (localStoryVideoItem.mTagInfoBase != null) {
            localStoryVideoItem.mTagInfoBase.b = System.currentTimeMillis();
          }
          paramErrorMessage.a(localStoryVideoItem);
          break;
          localStoryVideoItem.mTagInfoBase = ((wzp)localObject).jdField_a_of_type_Zhq;
          localStoryVideoItem.mCompInfoBase = ((wzp)localObject).jdField_a_of_type_Zhi;
          localStoryVideoItem.mOALinkInfoJson = ((wzp)localObject).b;
        }
      }
    }
    localwwl.b = new ArrayList(paramxbc.jdField_a_of_type_JavaUtilList);
    wfo.a().dispatch(localwwl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwk
 * JD-Core Version:    0.7.0.1
 */