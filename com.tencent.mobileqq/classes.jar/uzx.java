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

public class uzx
  extends uxv
  implements uni<vch, vdq>
{
  protected String a;
  protected List<uzy> a;
  
  public uzx(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    vch localvch = new vch();
    localvch.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    localvch.b = this.jdField_a_of_type_JavaLangString;
    ung.a().a(localvch, this);
  }
  
  public void a(List<uzy> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@NonNull vch paramvch, @Nullable vdq paramvdq, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramvdq != null))
    {
      paramvch = new uye(1);
      paramErrorMessage = (ure)urr.a(19);
      paramvdq = paramvdq.jdField_a_of_type_JavaUtilList;
      Object localObject1 = paramvdq.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new uyd(2, paramErrorMessage.a((VideoCollectionItem)((Iterator)localObject1).next()));
        paramvch.a.add(localObject2);
      }
      paramErrorMessage = (wkp)urr.a(11);
      localObject1 = new ArrayList(paramvdq.size());
      paramvdq = paramvdq.iterator();
      while (paramvdq.hasNext())
      {
        localObject2 = (VideoCollectionItem)paramvdq.next();
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
      uht.a().dispatch(paramvch);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzx
 * JD-Core Version:    0.7.0.1
 */