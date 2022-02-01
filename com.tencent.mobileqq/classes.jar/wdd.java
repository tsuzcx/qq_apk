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

public class wdd
  extends wbb
  implements vqp<wfn, wgw>
{
  protected String a;
  protected List<wde> a;
  
  public wdd(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    wfn localwfn = new wfn();
    localwfn.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    localwfn.b = this.jdField_a_of_type_JavaLangString;
    vqn.a().a(localwfn, this);
  }
  
  public void a(List<wde> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@NonNull wfn paramwfn, @Nullable wgw paramwgw, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramwgw != null))
    {
      paramwfn = new wbk(1);
      paramErrorMessage = (vuk)vux.a(19);
      paramwgw = paramwgw.jdField_a_of_type_JavaUtilList;
      Object localObject1 = paramwgw.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new wbj(2, paramErrorMessage.a((VideoCollectionItem)((Iterator)localObject1).next()));
        paramwfn.a.add(localObject2);
      }
      paramErrorMessage = (xnp)vux.a(11);
      localObject1 = new ArrayList(paramwgw.size());
      paramwgw = paramwgw.iterator();
      while (paramwgw.hasNext())
      {
        localObject2 = (VideoCollectionItem)paramwgw.next();
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
      vli.a().dispatch(paramwfn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdd
 * JD-Core Version:    0.7.0.1
 */