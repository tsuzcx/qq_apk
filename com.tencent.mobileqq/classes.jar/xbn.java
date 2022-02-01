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

public class xbn
  extends wzl
  implements woy<xdx, xfg>
{
  protected String a;
  protected List<xbo> a;
  
  public xbn(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    xdx localxdx = new xdx();
    localxdx.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    localxdx.b = this.jdField_a_of_type_JavaLangString;
    wow.a().a(localxdx, this);
  }
  
  public void a(List<xbo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@NonNull xdx paramxdx, @Nullable xfg paramxfg, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramxfg != null))
    {
      paramxdx = new wzu(1);
      paramErrorMessage = (wsu)wth.a(19);
      paramxfg = paramxfg.jdField_a_of_type_JavaUtilList;
      Object localObject1 = paramxfg.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new wzt(2, paramErrorMessage.a((VideoCollectionItem)((Iterator)localObject1).next()));
        paramxdx.a.add(localObject2);
      }
      paramErrorMessage = (yme)wth.a(11);
      localObject1 = new ArrayList(paramxfg.size());
      paramxfg = paramxfg.iterator();
      while (paramxfg.hasNext())
      {
        localObject2 = (VideoCollectionItem)paramxfg.next();
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
      wjj.a().dispatch(paramxdx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbn
 * JD-Core Version:    0.7.0.1
 */