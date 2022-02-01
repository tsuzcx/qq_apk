import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class wbv
  implements vqp<wez, wgn>
{
  wbv(List paramList) {}
  
  public void a(@NonNull wez paramwez, @Nullable wgn paramwgn, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond");
    wbw localwbw = new wbw();
    localwbw.jdField_a_of_type_JavaUtilList = new ArrayList(paramwez.jdField_a_of_type_JavaUtilList);
    localwbw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramwgn == null))
    {
      xvv.c("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond: get story player tag info failed, error:%s", paramErrorMessage);
      vli.a().dispatch(localwbw);
      return;
    }
    xvv.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond, vid list:%s, response list:%s", this.jdField_a_of_type_JavaUtilList, paramwgn.jdField_a_of_type_JavaUtilList);
    paramErrorMessage = (vuu)vux.a(5);
    paramwez = paramwez.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwez.hasNext())
    {
      Object localObject = (String)paramwez.next();
      StoryVideoItem localStoryVideoItem = paramErrorMessage.a((String)localObject);
      localObject = wbu.a((String)localObject, paramwgn.jdField_a_of_type_JavaUtilList);
      if (localStoryVideoItem != null)
      {
        if (localObject == null)
        {
          localStoryVideoItem.mTagInfoBase = null;
          localStoryVideoItem.mCompInfoBase = null;
          localStoryVideoItem.mOALinkInfoJson = null;
        }
        for (localStoryVideoItem.mOALinkInfo = null;; localStoryVideoItem.mOALinkInfo = vwm.a(localStoryVideoItem.mOALinkInfoJson))
        {
          if (localStoryVideoItem.mTagInfoBase != null) {
            localStoryVideoItem.mTagInfoBase.b = System.currentTimeMillis();
          }
          paramErrorMessage.a(localStoryVideoItem);
          break;
          localStoryVideoItem.mTagInfoBase = ((wfa)localObject).jdField_a_of_type_Yml;
          localStoryVideoItem.mCompInfoBase = ((wfa)localObject).jdField_a_of_type_Ymd;
          localStoryVideoItem.mOALinkInfoJson = ((wfa)localObject).b;
        }
      }
    }
    localwbw.b = new ArrayList(paramwgn.jdField_a_of_type_JavaUtilList);
    vli.a().dispatch(localwbw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbv
 * JD-Core Version:    0.7.0.1
 */