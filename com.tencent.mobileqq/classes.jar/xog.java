import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class xog
  extends JobSegment<Integer, xnm>
{
  private int jdField_a_of_type_Int;
  private vwp jdField_a_of_type_Vwp;
  private xnl jdField_a_of_type_Xnl;
  
  public xog(@NonNull xnl paramxnl, vwp paramvwp)
  {
    this.jdField_a_of_type_Xnl = paramxnl;
    this.jdField_a_of_type_Vwp = paramvwp;
  }
  
  public static boolean a(@Nullable wey paramwey, AtomicBoolean paramAtomicBoolean)
  {
    Object localObject2 = "";
    Object localObject1 = null;
    List localList = ((vuu)vux.a(5)).a(true);
    Iterator localIterator = paramwey.a.iterator();
    paramwey = (wey)localObject1;
    if (localIterator.hasNext())
    {
      xnh localxnh = (xnh)localIterator.next();
      localObject1 = localObject2;
      if (!((String)localObject2).equals(localxnh.c)) {
        localObject1 = localxnh.c;
      }
      if (!a(localxnh, localList)) {
        break label121;
      }
      localxnh.jdField_b_of_type_Boolean = true;
      paramAtomicBoolean.set(true);
      paramwey = localxnh;
    }
    label121:
    for (;;)
    {
      localObject2 = localObject1;
      break;
      return (paramwey != null) && (((String)localObject2).equals(paramwey.c));
    }
  }
  
  private static boolean a(xnh paramxnh, List<StoryVideoItem> paramList)
  {
    Object localObject2;
    do
    {
      paramList = paramList.iterator();
      Object localObject1;
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            localObject1 = (StoryVideoItem)paramList.next();
          } while (!paramxnh.c.equals(((StoryVideoItem)localObject1).mPublishDate));
          if ((((StoryVideoItem)localObject1).isLocalAddShareGroupVideo()) && (paramxnh.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).shareGroupId)))
          {
            xvv.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has *add* fail video:%s", new Object[] { paramxnh });
            return true;
          }
          localObject2 = vpd.a(((StoryVideoItem)localObject1).mVid);
          if ((localObject2 != null) && (((PublishVideoEntry)localObject2).getBooleanExtra("ignorePersonalPublish", false))) {}
          for (int i = 1; (i == 0) && (paramxnh.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).mOwnerUid)); i = 0)
          {
            xvv.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this personal feed  has fail video:%s", new Object[] { paramxnh });
            return true;
          }
          localObject1 = ((StoryVideoItem)localObject1).mVideoSpreadGroupList;
        } while ((localObject1 == null) || (((vwo)localObject1).b == null));
        localObject1 = ((vwo)localObject1).b.iterator();
      }
      localObject2 = (String)((Iterator)localObject1).next();
    } while (!paramxnh.jdField_b_of_type_JavaLangString.equals(localObject2));
    xvv.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has fail video:%s", new Object[] { paramxnh });
    return true;
    return false;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.jdField_a_of_type_Xnl.a(paramInteger.intValue(), 5);
    if ((((xnm)localObject).a.size() > 0) || (((xnm)localObject).jdField_b_of_type_Boolean))
    {
      xvv.b("Q.qqstory.home.data.HomeFeedListPageLoader", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new AtomicBoolean(false);
    wex localwex = new wex();
    localwex.jdField_a_of_type_Vwp = this.jdField_a_of_type_Vwp;
    localwex.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Xnl.a();
    vqn.a().a(localwex, new xoh(this, paramJobContext, (AtomicBoolean)localObject, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xog
 * JD-Core Version:    0.7.0.1
 */