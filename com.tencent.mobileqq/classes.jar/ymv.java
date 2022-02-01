import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ymv
  extends JobSegment<Integer, ymb>
{
  private int jdField_a_of_type_Int;
  private wuz jdField_a_of_type_Wuz;
  private yma jdField_a_of_type_Yma;
  
  public ymv(@NonNull yma paramyma, wuz paramwuz)
  {
    this.jdField_a_of_type_Yma = paramyma;
    this.jdField_a_of_type_Wuz = paramwuz;
  }
  
  public static boolean a(@Nullable xdi paramxdi, AtomicBoolean paramAtomicBoolean)
  {
    Object localObject2 = "";
    Object localObject1 = null;
    List localList = ((wte)wth.a(5)).a(true);
    Iterator localIterator = paramxdi.a.iterator();
    paramxdi = (xdi)localObject1;
    if (localIterator.hasNext())
    {
      ylw localylw = (ylw)localIterator.next();
      localObject1 = localObject2;
      if (!((String)localObject2).equals(localylw.c)) {
        localObject1 = localylw.c;
      }
      if (!a(localylw, localList)) {
        break label121;
      }
      localylw.jdField_b_of_type_Boolean = true;
      paramAtomicBoolean.set(true);
      paramxdi = localylw;
    }
    label121:
    for (;;)
    {
      localObject2 = localObject1;
      break;
      return (paramxdi != null) && (((String)localObject2).equals(paramxdi.c));
    }
  }
  
  private static boolean a(ylw paramylw, List<StoryVideoItem> paramList)
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
          } while (!paramylw.c.equals(((StoryVideoItem)localObject1).mPublishDate));
          if ((((StoryVideoItem)localObject1).isLocalAddShareGroupVideo()) && (paramylw.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).shareGroupId)))
          {
            yuk.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has *add* fail video:%s", new Object[] { paramylw });
            return true;
          }
          localObject2 = wnm.a(((StoryVideoItem)localObject1).mVid);
          if ((localObject2 != null) && (((PublishVideoEntry)localObject2).getBooleanExtra("ignorePersonalPublish", false))) {}
          for (int i = 1; (i == 0) && (paramylw.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).mOwnerUid)); i = 0)
          {
            yuk.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this personal feed  has fail video:%s", new Object[] { paramylw });
            return true;
          }
          localObject1 = ((StoryVideoItem)localObject1).mVideoSpreadGroupList;
        } while ((localObject1 == null) || (((wuy)localObject1).b == null));
        localObject1 = ((wuy)localObject1).b.iterator();
      }
      localObject2 = (String)((Iterator)localObject1).next();
    } while (!paramylw.jdField_b_of_type_JavaLangString.equals(localObject2));
    yuk.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has fail video:%s", new Object[] { paramylw });
    return true;
    return false;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.jdField_a_of_type_Yma.a(paramInteger.intValue(), 5);
    if ((((ymb)localObject).a.size() > 0) || (((ymb)localObject).jdField_b_of_type_Boolean))
    {
      yuk.b("Q.qqstory.home.data.HomeFeedListPageLoader", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new AtomicBoolean(false);
    xdh localxdh = new xdh();
    localxdh.jdField_a_of_type_Wuz = this.jdField_a_of_type_Wuz;
    localxdh.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Yma.a();
    wow.a().a(localxdh, new ymw(this, paramJobContext, (AtomicBoolean)localObject, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymv
 * JD-Core Version:    0.7.0.1
 */