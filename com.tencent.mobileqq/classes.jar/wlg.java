import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class wlg
  extends JobSegment<Integer, wkm>
{
  private int jdField_a_of_type_Int;
  private utj jdField_a_of_type_Utj;
  private wkl jdField_a_of_type_Wkl;
  
  public wlg(@NonNull wkl paramwkl, utj paramutj)
  {
    this.jdField_a_of_type_Wkl = paramwkl;
    this.jdField_a_of_type_Utj = paramutj;
  }
  
  public static boolean a(@Nullable vbs paramvbs, AtomicBoolean paramAtomicBoolean)
  {
    Object localObject2 = "";
    Object localObject1 = null;
    List localList = ((uro)urr.a(5)).a(true);
    Iterator localIterator = paramvbs.a.iterator();
    paramvbs = (vbs)localObject1;
    if (localIterator.hasNext())
    {
      wkh localwkh = (wkh)localIterator.next();
      localObject1 = localObject2;
      if (!((String)localObject2).equals(localwkh.c)) {
        localObject1 = localwkh.c;
      }
      if (!a(localwkh, localList)) {
        break label121;
      }
      localwkh.jdField_b_of_type_Boolean = true;
      paramAtomicBoolean.set(true);
      paramvbs = localwkh;
    }
    label121:
    for (;;)
    {
      localObject2 = localObject1;
      break;
      return (paramvbs != null) && (((String)localObject2).equals(paramvbs.c));
    }
  }
  
  private static boolean a(wkh paramwkh, List<StoryVideoItem> paramList)
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
          } while (!paramwkh.c.equals(((StoryVideoItem)localObject1).mPublishDate));
          if ((((StoryVideoItem)localObject1).isLocalAddShareGroupVideo()) && (paramwkh.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).shareGroupId)))
          {
            wsv.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has *add* fail video:%s", new Object[] { paramwkh });
            return true;
          }
          localObject2 = ulw.a(((StoryVideoItem)localObject1).mVid);
          if ((localObject2 != null) && (((PublishVideoEntry)localObject2).getBooleanExtra("ignorePersonalPublish", false))) {}
          for (int i = 1; (i == 0) && (paramwkh.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).mOwnerUid)); i = 0)
          {
            wsv.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this personal feed  has fail video:%s", new Object[] { paramwkh });
            return true;
          }
          localObject1 = ((StoryVideoItem)localObject1).mVideoSpreadGroupList;
        } while ((localObject1 == null) || (((uti)localObject1).b == null));
        localObject1 = ((uti)localObject1).b.iterator();
      }
      localObject2 = (String)((Iterator)localObject1).next();
    } while (!paramwkh.jdField_b_of_type_JavaLangString.equals(localObject2));
    wsv.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has fail video:%s", new Object[] { paramwkh });
    return true;
    return false;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.jdField_a_of_type_Wkl.a(paramInteger.intValue(), 5);
    if ((((wkm)localObject).a.size() > 0) || (((wkm)localObject).jdField_b_of_type_Boolean))
    {
      wsv.b("Q.qqstory.home.data.HomeFeedListPageLoader", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new AtomicBoolean(false);
    vbr localvbr = new vbr();
    localvbr.jdField_a_of_type_Utj = this.jdField_a_of_type_Utj;
    localvbr.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Wkl.a();
    ung.a().a(localvbr, new wlh(this, paramJobContext, (AtomicBoolean)localObject, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlg
 * JD-Core Version:    0.7.0.1
 */