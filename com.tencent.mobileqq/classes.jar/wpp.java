import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class wpp
  extends JobSegment<Integer, wov>
{
  private int jdField_a_of_type_Int;
  private uxs jdField_a_of_type_Uxs;
  private wou jdField_a_of_type_Wou;
  
  public wpp(@NonNull wou paramwou, uxs paramuxs)
  {
    this.jdField_a_of_type_Wou = paramwou;
    this.jdField_a_of_type_Uxs = paramuxs;
  }
  
  public static boolean a(@Nullable vgb paramvgb, AtomicBoolean paramAtomicBoolean)
  {
    Object localObject2 = "";
    Object localObject1 = null;
    List localList = ((uvx)uwa.a(5)).a(true);
    Iterator localIterator = paramvgb.a.iterator();
    paramvgb = (vgb)localObject1;
    if (localIterator.hasNext())
    {
      woq localwoq = (woq)localIterator.next();
      localObject1 = localObject2;
      if (!((String)localObject2).equals(localwoq.c)) {
        localObject1 = localwoq.c;
      }
      if (!a(localwoq, localList)) {
        break label121;
      }
      localwoq.jdField_b_of_type_Boolean = true;
      paramAtomicBoolean.set(true);
      paramvgb = localwoq;
    }
    label121:
    for (;;)
    {
      localObject2 = localObject1;
      break;
      return (paramvgb != null) && (((String)localObject2).equals(paramvgb.c));
    }
  }
  
  private static boolean a(woq paramwoq, List<StoryVideoItem> paramList)
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
          } while (!paramwoq.c.equals(((StoryVideoItem)localObject1).mPublishDate));
          if ((((StoryVideoItem)localObject1).isLocalAddShareGroupVideo()) && (paramwoq.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).shareGroupId)))
          {
            wxe.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has *add* fail video:%s", new Object[] { paramwoq });
            return true;
          }
          localObject2 = uqf.a(((StoryVideoItem)localObject1).mVid);
          if ((localObject2 != null) && (((PublishVideoEntry)localObject2).getBooleanExtra("ignorePersonalPublish", false))) {}
          for (int i = 1; (i == 0) && (paramwoq.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).mOwnerUid)); i = 0)
          {
            wxe.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this personal feed  has fail video:%s", new Object[] { paramwoq });
            return true;
          }
          localObject1 = ((StoryVideoItem)localObject1).mVideoSpreadGroupList;
        } while ((localObject1 == null) || (((uxr)localObject1).b == null));
        localObject1 = ((uxr)localObject1).b.iterator();
      }
      localObject2 = (String)((Iterator)localObject1).next();
    } while (!paramwoq.jdField_b_of_type_JavaLangString.equals(localObject2));
    wxe.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has fail video:%s", new Object[] { paramwoq });
    return true;
    return false;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.jdField_a_of_type_Wou.a(paramInteger.intValue(), 5);
    if ((((wov)localObject).a.size() > 0) || (((wov)localObject).jdField_b_of_type_Boolean))
    {
      wxe.b("Q.qqstory.home.data.HomeFeedListPageLoader", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new AtomicBoolean(false);
    vga localvga = new vga();
    localvga.jdField_a_of_type_Uxs = this.jdField_a_of_type_Uxs;
    localvga.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Wou.a();
    urp.a().a(localvga, new wpq(this, paramJobContext, (AtomicBoolean)localObject, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpp
 * JD-Core Version:    0.7.0.1
 */