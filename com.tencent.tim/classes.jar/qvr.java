import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class qvr
  extends qve<qvq>
{
  public qvr(@Nullable qve.d paramd)
  {
    super(paramd);
  }
  
  protected void K(List<String> paramList, boolean paramBoolean)
  {
    ((qvf)psx.a(11)).Q(paramList, paramBoolean);
  }
  
  protected JobSegment<qve.c, qvq> a()
  {
    return new qvl();
  }
  
  protected JobSegment<Integer, qve.c> a(qve.b paramb)
  {
    return new qvr.a(paramb, this.c);
  }
  
  protected qvq a()
  {
    qvf localqvf = (qvf)psx.a(11);
    List localList = localqvf.bV();
    qvq localqvq = new qvq(new ErrorMessage());
    localqvq.or = localqvf.av(localList);
    localqvq.aCu = true;
    localqvq.isEnd = localqvq.or.isEmpty();
    return localqvq;
  }
  
  protected qvq a(ErrorMessage paramErrorMessage)
  {
    return new qvq(paramErrorMessage);
  }
  
  public static class a
    extends JobSegment<Integer, qve.c>
  {
    private qve.b b;
    private int bmm;
    private pua c;
    
    public a(@NonNull qve.b paramb, pua parampua)
    {
      this.b = paramb;
      this.c = parampua;
    }
    
    public static boolean a(@Nullable pzh.a parama, AtomicBoolean paramAtomicBoolean)
    {
      Object localObject2 = "";
      Object localObject1 = null;
      List localList = ((psu)psx.a(5)).g(true);
      Iterator localIterator = parama.nk.iterator();
      parama = (pzh.a)localObject1;
      if (localIterator.hasNext())
      {
        qvd localqvd = (qvd)localIterator.next();
        localObject1 = localObject2;
        if (!((String)localObject2).equals(localqvd.ayV)) {
          localObject1 = localqvd.ayV;
        }
        if (!a(localqvd, localList)) {
          break label121;
        }
        localqvd.aFI = true;
        paramAtomicBoolean.set(true);
        parama = localqvd;
      }
      label121:
      for (;;)
      {
        localObject2 = localObject1;
        break;
        return (parama != null) && (((String)localObject2).equals(parama.ayV));
      }
    }
    
    private static boolean a(qvd paramqvd, List<StoryVideoItem> paramList)
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
            } while (!paramqvd.ayV.equals(((StoryVideoItem)localObject1).mPublishDate));
            if ((((StoryVideoItem)localObject1).isLocalAddShareGroupVideo()) && (paramqvd.mUnionId.equals(((StoryVideoItem)localObject1).shareGroupId)))
            {
              ram.w("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has *add* fail video:%s", new Object[] { paramqvd });
              return true;
            }
            localObject2 = pox.b(((StoryVideoItem)localObject1).mVid);
            if ((localObject2 != null) && (((PublishVideoEntry)localObject2).getBooleanExtra("ignorePersonalPublish", false))) {}
            for (int i = 1; (i == 0) && (paramqvd.mUnionId.equals(((StoryVideoItem)localObject1).mOwnerUid)); i = 0)
            {
              ram.w("Q.qqstory.home.data.HomeFeedListPageLoader", "this personal feed  has fail video:%s", new Object[] { paramqvd });
              return true;
            }
            localObject1 = ((StoryVideoItem)localObject1).mVideoSpreadGroupList;
          } while ((localObject1 == null) || (((ptz)localObject1).mB == null));
          localObject1 = ((ptz)localObject1).mB.iterator();
        }
        localObject2 = (String)((Iterator)localObject1).next();
      } while (!paramqvd.mUnionId.equals(localObject2));
      ram.w("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has fail video:%s", new Object[] { paramqvd });
      return true;
      return false;
    }
    
    protected void a(JobContext paramJobContext, Integer paramInteger)
    {
      Object localObject = this.b.a(paramInteger.intValue(), 5);
      if ((((qve.c)localObject).oq.size() > 0) || (((qve.c)localObject).mIsEnd))
      {
        ram.d("Q.qqstory.home.data.HomeFeedListPageLoader", "hit feed id cache");
        notifyResult(localObject);
        return;
      }
      localObject = new AtomicBoolean(false);
      pzh localpzh = new pzh();
      localpzh.b = this.c;
      localpzh.cookie = this.b.mP();
      ppv.a().a(localpzh, new qvs(this, paramJobContext, (AtomicBoolean)localObject, paramInteger));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvr
 * JD-Core Version:    0.7.0.1
 */