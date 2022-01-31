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

public class tlf
  extends tjd
  implements syq<tnp, toy>
{
  protected String a;
  protected List<tlg> a;
  
  public tlf(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    tnp localtnp = new tnp();
    localtnp.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    localtnp.b = this.jdField_a_of_type_JavaLangString;
    syo.a().a(localtnp, this);
  }
  
  public void a(List<tlg> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@NonNull tnp paramtnp, @Nullable toy paramtoy, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramtoy != null))
    {
      paramtnp = new tjm(1);
      paramErrorMessage = (tcm)tcz.a(19);
      paramtoy = paramtoy.jdField_a_of_type_JavaUtilList;
      Object localObject1 = paramtoy.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new tjl(2, paramErrorMessage.a((VideoCollectionItem)((Iterator)localObject1).next()));
        paramtnp.a.add(localObject2);
      }
      paramErrorMessage = (uvx)tcz.a(11);
      localObject1 = new ArrayList(paramtoy.size());
      paramtoy = paramtoy.iterator();
      while (paramtoy.hasNext())
      {
        localObject2 = (VideoCollectionItem)paramtoy.next();
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
      stb.a().dispatch(paramtnp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlf
 * JD-Core Version:    0.7.0.1
 */