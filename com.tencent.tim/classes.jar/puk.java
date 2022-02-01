import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class puk
  extends JobSegment<List<qej>, List<qej>>
{
  puh b;
  
  public puk(puh parampuh)
  {
    this.b = parampuh;
  }
  
  protected void a(JobContext paramJobContext, List<qej> paramList)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.b.nodeType == 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobLocalVideo", 2, "self node, check local video");
      }
      paramJobContext = (psu)psx.a(5);
      localObject1 = ((puy)QQStoryContext.a().getManager(251)).a().a(this.b.nodeType, this.b.unionId);
      if ((localObject1 == null) || (((puh)localObject1).mC == null) || (((puh)localObject1).mC.isEmpty())) {
        break label410;
      }
      localObject1 = ((puh)localObject1).mC.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (qej)((Iterator)localObject1).next();
        localObject3 = paramJobContext.a(((qej)localObject2).vid);
        if (localObject3 != null)
        {
          ((qej)localObject2).g = ((StoryVideoItem)localObject3);
          paramList.add(localObject2);
        }
      }
    }
    label410:
    for (int i = 1;; i = 0)
    {
      localObject1 = paramJobContext.g(false);
      int j = i;
      if (localObject1 != null)
      {
        j = i;
        if (((List)localObject1).size() > 0)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
            localObject3 = new qej();
            ((qej)localObject3).aBR = false;
            ((qej)localObject3).feedId = ((StoryVideoItem)localObject2).mAttachedFeedId;
            ((qej)localObject3).vid = ((StoryVideoItem)localObject2).mVid;
            ((qej)localObject3).g = ((StoryVideoItem)localObject2);
            ((qej)localObject3).isLocal = true;
            paramList.add(localObject3);
          }
          j = 1;
        }
      }
      if (j != 0)
      {
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (qej)((Iterator)localObject1).next();
          if (((qej)localObject2).g == null) {
            ((qej)localObject2).g = paramJobContext.a(((qej)localObject2).vid);
          }
          if (((qej)localObject2).g == null)
          {
            notifyError(new ErrorMessage(940001, "should not be null"));
            return;
          }
        }
        Collections.sort(paramList, new pul(this));
      }
      if (paramList.isEmpty())
      {
        notifyError(new ErrorMessage(103, "nodeInfo not valid"));
        return;
      }
      notifyResult(paramList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     puk
 * JD-Core Version:    0.7.0.1
 */