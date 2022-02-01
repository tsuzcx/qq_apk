import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wxs
  extends wvq
  implements wld<xac, xbl>
{
  protected String a;
  protected List<wxt> a;
  
  public wxs(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    xac localxac = new xac();
    localxac.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    localxac.b = this.jdField_a_of_type_JavaLangString;
    wlb.a().a(localxac, this);
  }
  
  public void a(List<wxt> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@NonNull xac paramxac, @Nullable xbl paramxbl, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramxbl != null))
    {
      paramxac = new wvz(1);
      paramErrorMessage = (woz)wpm.a(19);
      paramxbl = paramxbl.jdField_a_of_type_JavaUtilList;
      Object localObject1 = paramxbl.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new wvy(2, paramErrorMessage.a((VideoCollectionItem)((Iterator)localObject1).next()));
        paramxac.a.add(localObject2);
      }
      paramErrorMessage = (yij)wpm.a(11);
      localObject1 = new ArrayList(paramxbl.size());
      paramxbl = paramxbl.iterator();
      while (paramxbl.hasNext())
      {
        localObject2 = (VideoCollectionItem)paramxbl.next();
        if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
        {
          VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)paramErrorMessage.a(((VideoCollectionItem)localObject2).feedId);
          if (localVideoListFeedItem != null)
          {
            localVideoListFeedItem.mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
            ((ArrayList)localObject1).add(localVideoListFeedItem);
          }
        }
      }
      paramErrorMessage.a((List)localObject1);
      wfo.a().dispatch(paramxac);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxs
 * JD-Core Version:    0.7.0.1
 */