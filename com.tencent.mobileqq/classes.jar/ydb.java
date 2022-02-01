import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ydb
  extends JobSegment<Integer, ych>
{
  private int jdField_a_of_type_Int;
  private wlk jdField_a_of_type_Wlk;
  private ycg jdField_a_of_type_Ycg;
  
  public ydb(@NonNull ycg paramycg, wlk paramwlk)
  {
    this.jdField_a_of_type_Ycg = paramycg;
    this.jdField_a_of_type_Wlk = paramwlk;
  }
  
  public static boolean a(@Nullable wtt paramwtt, AtomicBoolean paramAtomicBoolean)
  {
    Object localObject2 = "";
    Object localObject1 = null;
    List localList = ((wjp)wjs.a(5)).a(true);
    Iterator localIterator = paramwtt.a.iterator();
    paramwtt = (wtt)localObject1;
    if (localIterator.hasNext())
    {
      ycc localycc = (ycc)localIterator.next();
      localObject1 = localObject2;
      if (!((String)localObject2).equals(localycc.c)) {
        localObject1 = localycc.c;
      }
      if (!a(localycc, localList)) {
        break label121;
      }
      localycc.jdField_b_of_type_Boolean = true;
      paramAtomicBoolean.set(true);
      paramwtt = localycc;
    }
    label121:
    for (;;)
    {
      localObject2 = localObject1;
      break;
      return (paramwtt != null) && (((String)localObject2).equals(paramwtt.c));
    }
  }
  
  private static boolean a(ycc paramycc, List<StoryVideoItem> paramList)
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
          } while (!paramycc.c.equals(((StoryVideoItem)localObject1).mPublishDate));
          if ((((StoryVideoItem)localObject1).isLocalAddShareGroupVideo()) && (paramycc.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).shareGroupId)))
          {
            ykq.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has *add* fail video:%s", new Object[] { paramycc });
            return true;
          }
          localObject2 = wdy.a(((StoryVideoItem)localObject1).mVid);
          if ((localObject2 != null) && (((PublishVideoEntry)localObject2).getBooleanExtra("ignorePersonalPublish", false))) {}
          for (int i = 1; (i == 0) && (paramycc.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).mOwnerUid)); i = 0)
          {
            ykq.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this personal feed  has fail video:%s", new Object[] { paramycc });
            return true;
          }
          localObject1 = ((StoryVideoItem)localObject1).mVideoSpreadGroupList;
        } while ((localObject1 == null) || (((wlj)localObject1).b == null));
        localObject1 = ((wlj)localObject1).b.iterator();
      }
      localObject2 = (String)((Iterator)localObject1).next();
    } while (!paramycc.jdField_b_of_type_JavaLangString.equals(localObject2));
    ykq.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has fail video:%s", new Object[] { paramycc });
    return true;
    return false;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.jdField_a_of_type_Ycg.a(paramInteger.intValue(), 5);
    if ((((ych)localObject).a.size() > 0) || (((ych)localObject).jdField_b_of_type_Boolean))
    {
      ykq.b("Q.qqstory.home.data.HomeFeedListPageLoader", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new AtomicBoolean(false);
    wts localwts = new wts();
    localwts.jdField_a_of_type_Wlk = this.jdField_a_of_type_Wlk;
    localwts.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Ycg.a();
    wfi.a().a(localwts, new ydc(this, paramJobContext, (AtomicBoolean)localObject, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydb
 * JD-Core Version:    0.7.0.1
 */