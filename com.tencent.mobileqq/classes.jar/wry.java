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

public class wry
  extends wpw
  implements wfk<wui, wvr>
{
  protected String a;
  protected List<wrz> a;
  
  public wry(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    wui localwui = new wui();
    localwui.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    localwui.b = this.jdField_a_of_type_JavaLangString;
    wfi.a().a(localwui, this);
  }
  
  public void a(List<wrz> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@NonNull wui paramwui, @Nullable wvr paramwvr, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramwvr != null))
    {
      paramwui = new wqf(1);
      paramErrorMessage = (wjf)wjs.a(19);
      paramwvr = paramwvr.jdField_a_of_type_JavaUtilList;
      Object localObject1 = paramwvr.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new wqe(2, paramErrorMessage.a((VideoCollectionItem)((Iterator)localObject1).next()));
        paramwui.a.add(localObject2);
      }
      paramErrorMessage = (yck)wjs.a(11);
      localObject1 = new ArrayList(paramwvr.size());
      paramwvr = paramwvr.iterator();
      while (paramwvr.hasNext())
      {
        localObject2 = (VideoCollectionItem)paramwvr.next();
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
      wad.a().dispatch(paramwui);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wry
 * JD-Core Version:    0.7.0.1
 */