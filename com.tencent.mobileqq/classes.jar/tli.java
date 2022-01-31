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

public class tli
  extends tjg
  implements syt<tns, tpb>
{
  protected String a;
  protected List<tlj> a;
  
  public tli(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    tns localtns = new tns();
    localtns.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    localtns.b = this.jdField_a_of_type_JavaLangString;
    syr.a().a(localtns, this);
  }
  
  public void a(List<tlj> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@NonNull tns paramtns, @Nullable tpb paramtpb, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramtpb != null))
    {
      paramtns = new tjp(1);
      paramErrorMessage = (tcp)tdc.a(19);
      paramtpb = paramtpb.jdField_a_of_type_JavaUtilList;
      Object localObject1 = paramtpb.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new tjo(2, paramErrorMessage.a((VideoCollectionItem)((Iterator)localObject1).next()));
        paramtns.a.add(localObject2);
      }
      paramErrorMessage = (uwa)tdc.a(11);
      localObject1 = new ArrayList(paramtpb.size());
      paramtpb = paramtpb.iterator();
      while (paramtpb.hasNext())
      {
        localObject2 = (VideoCollectionItem)paramtpb.next();
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
      ste.a().dispatch(paramtns);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tli
 * JD-Core Version:    0.7.0.1
 */