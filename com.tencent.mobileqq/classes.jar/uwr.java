import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class uwr
  extends JobSegment<Integer, uvx>
{
  private int jdField_a_of_type_Int;
  private teu jdField_a_of_type_Teu;
  private uvw jdField_a_of_type_Uvw;
  
  public uwr(@NonNull uvw paramuvw, teu paramteu)
  {
    this.jdField_a_of_type_Uvw = paramuvw;
    this.jdField_a_of_type_Teu = paramteu;
  }
  
  public static boolean a(@Nullable tnd paramtnd, AtomicBoolean paramAtomicBoolean)
  {
    Object localObject2 = "";
    Object localObject1 = null;
    List localList = ((tcz)tdc.a(5)).a(true);
    Iterator localIterator = paramtnd.a.iterator();
    paramtnd = (tnd)localObject1;
    if (localIterator.hasNext())
    {
      uvs localuvs = (uvs)localIterator.next();
      localObject1 = localObject2;
      if (!((String)localObject2).equals(localuvs.c)) {
        localObject1 = localuvs.c;
      }
      if (!a(localuvs, localList)) {
        break label121;
      }
      localuvs.jdField_b_of_type_Boolean = true;
      paramAtomicBoolean.set(true);
      paramtnd = localuvs;
    }
    label121:
    for (;;)
    {
      localObject2 = localObject1;
      break;
      return (paramtnd != null) && (((String)localObject2).equals(paramtnd.c));
    }
  }
  
  private static boolean a(uvs paramuvs, List<StoryVideoItem> paramList)
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
          } while (!paramuvs.c.equals(((StoryVideoItem)localObject1).mPublishDate));
          if ((((StoryVideoItem)localObject1).isLocalAddShareGroupVideo()) && (paramuvs.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).shareGroupId)))
          {
            veg.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has *add* fail video:%s", new Object[] { paramuvs });
            return true;
          }
          localObject2 = sxh.a(((StoryVideoItem)localObject1).mVid);
          if ((localObject2 != null) && (((PublishVideoEntry)localObject2).getBooleanExtra("ignorePersonalPublish", false))) {}
          for (int i = 1; (i == 0) && (paramuvs.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).mOwnerUid)); i = 0)
          {
            veg.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this personal feed  has fail video:%s", new Object[] { paramuvs });
            return true;
          }
          localObject1 = ((StoryVideoItem)localObject1).mVideoSpreadGroupList;
        } while ((localObject1 == null) || (((tet)localObject1).b == null));
        localObject1 = ((tet)localObject1).b.iterator();
      }
      localObject2 = (String)((Iterator)localObject1).next();
    } while (!paramuvs.jdField_b_of_type_JavaLangString.equals(localObject2));
    veg.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has fail video:%s", new Object[] { paramuvs });
    return true;
    return false;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.jdField_a_of_type_Uvw.a(paramInteger.intValue(), 5);
    if ((((uvx)localObject).a.size() > 0) || (((uvx)localObject).jdField_b_of_type_Boolean))
    {
      veg.b("Q.qqstory.home.data.HomeFeedListPageLoader", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new AtomicBoolean(false);
    tnc localtnc = new tnc();
    localtnc.jdField_a_of_type_Teu = this.jdField_a_of_type_Teu;
    localtnc.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Uvw.a();
    syr.a().a(localtnc, new uws(this, paramJobContext, (AtomicBoolean)localObject, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwr
 * JD-Core Version:    0.7.0.1
 */