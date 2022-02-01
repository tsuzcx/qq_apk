import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class wqq
  implements wfk<wtu, wvi>
{
  wqq(List paramList) {}
  
  public void a(@NonNull wtu paramwtu, @Nullable wvi paramwvi, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond");
    wqr localwqr = new wqr();
    localwqr.jdField_a_of_type_JavaUtilList = new ArrayList(paramwtu.jdField_a_of_type_JavaUtilList);
    localwqr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramwvi == null))
    {
      ykq.c("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond: get story player tag info failed, error:%s", paramErrorMessage);
      wad.a().dispatch(localwqr);
      return;
    }
    ykq.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond, vid list:%s, response list:%s", this.jdField_a_of_type_JavaUtilList, paramwvi.jdField_a_of_type_JavaUtilList);
    paramErrorMessage = (wjp)wjs.a(5);
    paramwtu = paramwtu.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwtu.hasNext())
    {
      Object localObject = (String)paramwtu.next();
      StoryVideoItem localStoryVideoItem = paramErrorMessage.a((String)localObject);
      localObject = wqp.a((String)localObject, paramwvi.jdField_a_of_type_JavaUtilList);
      if (localStoryVideoItem != null)
      {
        if (localObject == null)
        {
          localStoryVideoItem.mTagInfoBase = null;
          localStoryVideoItem.mCompInfoBase = null;
          localStoryVideoItem.mOALinkInfoJson = null;
        }
        for (localStoryVideoItem.mOALinkInfo = null;; localStoryVideoItem.mOALinkInfo = wlh.a(localStoryVideoItem.mOALinkInfoJson))
        {
          if (localStoryVideoItem.mTagInfoBase != null) {
            localStoryVideoItem.mTagInfoBase.b = System.currentTimeMillis();
          }
          paramErrorMessage.a(localStoryVideoItem);
          break;
          localStoryVideoItem.mTagInfoBase = ((wtv)localObject).jdField_a_of_type_Zbe;
          localStoryVideoItem.mCompInfoBase = ((wtv)localObject).jdField_a_of_type_Zaw;
          localStoryVideoItem.mOALinkInfoJson = ((wtv)localObject).b;
        }
      }
    }
    localwqr.b = new ArrayList(paramwvi.jdField_a_of_type_JavaUtilList);
    wad.a().dispatch(localwqr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqq
 * JD-Core Version:    0.7.0.1
 */