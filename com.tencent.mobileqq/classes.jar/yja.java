import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class yja
  extends JobSegment<Integer, yig>
{
  private int jdField_a_of_type_Int;
  private wre jdField_a_of_type_Wre;
  private yif jdField_a_of_type_Yif;
  
  public yja(@NonNull yif paramyif, wre paramwre)
  {
    this.jdField_a_of_type_Yif = paramyif;
    this.jdField_a_of_type_Wre = paramwre;
  }
  
  public static boolean a(@Nullable wzn paramwzn, AtomicBoolean paramAtomicBoolean)
  {
    Object localObject2 = "";
    Object localObject1 = null;
    List localList = ((wpj)wpm.a(5)).a(true);
    Iterator localIterator = paramwzn.a.iterator();
    paramwzn = (wzn)localObject1;
    if (localIterator.hasNext())
    {
      yib localyib = (yib)localIterator.next();
      localObject1 = localObject2;
      if (!((String)localObject2).equals(localyib.c)) {
        localObject1 = localyib.c;
      }
      if (!a(localyib, localList)) {
        break label121;
      }
      localyib.jdField_b_of_type_Boolean = true;
      paramAtomicBoolean.set(true);
      paramwzn = localyib;
    }
    label121:
    for (;;)
    {
      localObject2 = localObject1;
      break;
      return (paramwzn != null) && (((String)localObject2).equals(paramwzn.c));
    }
  }
  
  private static boolean a(yib paramyib, List<StoryVideoItem> paramList)
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
          } while (!paramyib.c.equals(((StoryVideoItem)localObject1).mPublishDate));
          if ((((StoryVideoItem)localObject1).isLocalAddShareGroupVideo()) && (paramyib.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).shareGroupId)))
          {
            yqp.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has *add* fail video:%s", new Object[] { paramyib });
            return true;
          }
          localObject2 = wjr.a(((StoryVideoItem)localObject1).mVid);
          if ((localObject2 != null) && (((PublishVideoEntry)localObject2).getBooleanExtra("ignorePersonalPublish", false))) {}
          for (int i = 1; (i == 0) && (paramyib.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).mOwnerUid)); i = 0)
          {
            yqp.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this personal feed  has fail video:%s", new Object[] { paramyib });
            return true;
          }
          localObject1 = ((StoryVideoItem)localObject1).mVideoSpreadGroupList;
        } while ((localObject1 == null) || (((wrd)localObject1).b == null));
        localObject1 = ((wrd)localObject1).b.iterator();
      }
      localObject2 = (String)((Iterator)localObject1).next();
    } while (!paramyib.jdField_b_of_type_JavaLangString.equals(localObject2));
    yqp.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has fail video:%s", new Object[] { paramyib });
    return true;
    return false;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.jdField_a_of_type_Yif.a(paramInteger.intValue(), 5);
    if ((((yig)localObject).a.size() > 0) || (((yig)localObject).jdField_b_of_type_Boolean))
    {
      yqp.b("Q.qqstory.home.data.HomeFeedListPageLoader", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new AtomicBoolean(false);
    wzm localwzm = new wzm();
    localwzm.jdField_a_of_type_Wre = this.jdField_a_of_type_Wre;
    localwzm.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Yif.a();
    wlb.a().a(localwzm, new yjb(this, paramJobContext, (AtomicBoolean)localObject, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yja
 * JD-Core Version:    0.7.0.1
 */