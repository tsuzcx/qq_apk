import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class uwo
  extends JobSegment<Integer, uvu>
{
  private int jdField_a_of_type_Int;
  private ter jdField_a_of_type_Ter;
  private uvt jdField_a_of_type_Uvt;
  
  public uwo(@NonNull uvt paramuvt, ter paramter)
  {
    this.jdField_a_of_type_Uvt = paramuvt;
    this.jdField_a_of_type_Ter = paramter;
  }
  
  public static boolean a(@Nullable tna paramtna, AtomicBoolean paramAtomicBoolean)
  {
    Object localObject2 = "";
    Object localObject1 = null;
    List localList = ((tcw)tcz.a(5)).a(true);
    Iterator localIterator = paramtna.a.iterator();
    paramtna = (tna)localObject1;
    if (localIterator.hasNext())
    {
      uvp localuvp = (uvp)localIterator.next();
      localObject1 = localObject2;
      if (!((String)localObject2).equals(localuvp.c)) {
        localObject1 = localuvp.c;
      }
      if (!a(localuvp, localList)) {
        break label121;
      }
      localuvp.jdField_b_of_type_Boolean = true;
      paramAtomicBoolean.set(true);
      paramtna = localuvp;
    }
    label121:
    for (;;)
    {
      localObject2 = localObject1;
      break;
      return (paramtna != null) && (((String)localObject2).equals(paramtna.c));
    }
  }
  
  private static boolean a(uvp paramuvp, List<StoryVideoItem> paramList)
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
          } while (!paramuvp.c.equals(((StoryVideoItem)localObject1).mPublishDate));
          if ((((StoryVideoItem)localObject1).isLocalAddShareGroupVideo()) && (paramuvp.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).shareGroupId)))
          {
            ved.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has *add* fail video:%s", new Object[] { paramuvp });
            return true;
          }
          localObject2 = sxe.a(((StoryVideoItem)localObject1).mVid);
          if ((localObject2 != null) && (((PublishVideoEntry)localObject2).getBooleanExtra("ignorePersonalPublish", false))) {}
          for (int i = 1; (i == 0) && (paramuvp.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).mOwnerUid)); i = 0)
          {
            ved.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this personal feed  has fail video:%s", new Object[] { paramuvp });
            return true;
          }
          localObject1 = ((StoryVideoItem)localObject1).mVideoSpreadGroupList;
        } while ((localObject1 == null) || (((teq)localObject1).b == null));
        localObject1 = ((teq)localObject1).b.iterator();
      }
      localObject2 = (String)((Iterator)localObject1).next();
    } while (!paramuvp.jdField_b_of_type_JavaLangString.equals(localObject2));
    ved.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has fail video:%s", new Object[] { paramuvp });
    return true;
    return false;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.jdField_a_of_type_Uvt.a(paramInteger.intValue(), 5);
    if ((((uvu)localObject).a.size() > 0) || (((uvu)localObject).jdField_b_of_type_Boolean))
    {
      ved.b("Q.qqstory.home.data.HomeFeedListPageLoader", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new AtomicBoolean(false);
    tmz localtmz = new tmz();
    localtmz.jdField_a_of_type_Ter = this.jdField_a_of_type_Ter;
    localtmz.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Uvt.a();
    syo.a().a(localtmz, new uwp(this, paramJobContext, (AtomicBoolean)localObject, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwo
 * JD-Core Version:    0.7.0.1
 */