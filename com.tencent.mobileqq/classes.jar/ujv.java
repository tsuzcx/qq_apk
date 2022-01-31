import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ujv
  extends JobSegment<Integer, ujb>
{
  private int jdField_a_of_type_Int;
  private sry jdField_a_of_type_Sry;
  private uja jdField_a_of_type_Uja;
  
  public ujv(@NonNull uja paramuja, sry paramsry)
  {
    this.jdField_a_of_type_Uja = paramuja;
    this.jdField_a_of_type_Sry = paramsry;
  }
  
  public static boolean a(@Nullable tah paramtah, AtomicBoolean paramAtomicBoolean)
  {
    Object localObject2 = "";
    Object localObject1 = null;
    List localList = ((sqd)sqg.a(5)).a(true);
    Iterator localIterator = paramtah.a.iterator();
    paramtah = (tah)localObject1;
    if (localIterator.hasNext())
    {
      uiw localuiw = (uiw)localIterator.next();
      localObject1 = localObject2;
      if (!((String)localObject2).equals(localuiw.c)) {
        localObject1 = localuiw.c;
      }
      if (!a(localuiw, localList)) {
        break label121;
      }
      localuiw.jdField_b_of_type_Boolean = true;
      paramAtomicBoolean.set(true);
      paramtah = localuiw;
    }
    label121:
    for (;;)
    {
      localObject2 = localObject1;
      break;
      return (paramtah != null) && (((String)localObject2).equals(paramtah.c));
    }
  }
  
  private static boolean a(uiw paramuiw, List<StoryVideoItem> paramList)
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
          } while (!paramuiw.c.equals(((StoryVideoItem)localObject1).mPublishDate));
          if ((((StoryVideoItem)localObject1).isLocalAddShareGroupVideo()) && (paramuiw.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).shareGroupId)))
          {
            urk.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has *add* fail video:%s", new Object[] { paramuiw });
            return true;
          }
          localObject2 = skl.a(((StoryVideoItem)localObject1).mVid);
          if ((localObject2 != null) && (((PublishVideoEntry)localObject2).getBooleanExtra("ignorePersonalPublish", false))) {}
          for (int i = 1; (i == 0) && (paramuiw.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).mOwnerUid)); i = 0)
          {
            urk.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this personal feed  has fail video:%s", new Object[] { paramuiw });
            return true;
          }
          localObject1 = ((StoryVideoItem)localObject1).mVideoSpreadGroupList;
        } while ((localObject1 == null) || (((srx)localObject1).b == null));
        localObject1 = ((srx)localObject1).b.iterator();
      }
      localObject2 = (String)((Iterator)localObject1).next();
    } while (!paramuiw.jdField_b_of_type_JavaLangString.equals(localObject2));
    urk.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has fail video:%s", new Object[] { paramuiw });
    return true;
    return false;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.jdField_a_of_type_Uja.a(paramInteger.intValue(), 5);
    if ((((ujb)localObject).a.size() > 0) || (((ujb)localObject).jdField_b_of_type_Boolean))
    {
      urk.b("Q.qqstory.home.data.HomeFeedListPageLoader", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new AtomicBoolean(false);
    tag localtag = new tag();
    localtag.jdField_a_of_type_Sry = this.jdField_a_of_type_Sry;
    localtag.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Uja.a();
    slv.a().a(localtag, new ujw(this, paramJobContext, (AtomicBoolean)localObject, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujv
 * JD-Core Version:    0.7.0.1
 */