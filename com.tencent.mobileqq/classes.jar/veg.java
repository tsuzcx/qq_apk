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

public class veg
  extends vce
  implements urr<vgq, vhz>
{
  protected String a;
  protected List<veh> a;
  
  public veg(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    vgq localvgq = new vgq();
    localvgq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    localvgq.b = this.jdField_a_of_type_JavaLangString;
    urp.a().a(localvgq, this);
  }
  
  public void a(List<veh> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@NonNull vgq paramvgq, @Nullable vhz paramvhz, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramvhz != null))
    {
      paramvgq = new vcn(1);
      paramErrorMessage = (uvn)uwa.a(19);
      paramvhz = paramvhz.jdField_a_of_type_JavaUtilList;
      Object localObject1 = paramvhz.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new vcm(2, paramErrorMessage.a((VideoCollectionItem)((Iterator)localObject1).next()));
        paramvgq.a.add(localObject2);
      }
      paramErrorMessage = (woy)uwa.a(11);
      localObject1 = new ArrayList(paramvhz.size());
      paramvhz = paramvhz.iterator();
      while (paramvhz.hasNext())
      {
        localObject2 = (VideoCollectionItem)paramvhz.next();
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
      umc.a().dispatch(paramvgq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     veg
 * JD-Core Version:    0.7.0.1
 */