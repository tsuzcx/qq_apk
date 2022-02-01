import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ycu
  extends JobSegment<ych, ycz>
{
  private Vector<wfm> jdField_a_of_type_JavaUtilVector = new Vector(5);
  private wsk jdField_a_of_type_Wsk;
  private wsn jdField_a_of_type_Wsn;
  private wsq jdField_a_of_type_Wsq;
  private wuy jdField_a_of_type_Wuy;
  
  private wkv a(int paramInt, ybu paramybu)
  {
    List localList = this.jdField_a_of_type_Wuy.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (wkv localwkv = (wkv)localList.get(paramInt);; localwkv = null)
    {
      if ((localwkv != null) && (localwkv.a.equals(paramybu.a.feedId))) {
        return localwkv;
      }
      localwkv = new wkv();
      localwkv.a = paramybu.a.feedId;
      paramInt = localList.indexOf(localwkv);
      if (paramInt >= 0) {
        return (wkv)localList.get(paramInt);
      }
      ykq.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "can't not find feed like for id:%s", new Object[] { paramybu.a.feedId });
      return null;
    }
  }
  
  private void a(ych paramych)
  {
    boolean bool3 = true;
    int i = 0;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_Wsq != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Wsk == null) {
        break label68;
      }
      bool2 = true;
      label24:
      if (this.jdField_a_of_type_Wsn == null) {
        break label74;
      }
    }
    for (;;)
    {
      ykq.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed info resp basic info:%b, comment %b, like %b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
      if (this.jdField_a_of_type_JavaUtilVector.isEmpty()) {
        break label80;
      }
      return;
      bool1 = false;
      break;
      label68:
      bool2 = false;
      break label24;
      label74:
      bool3 = false;
    }
    label80:
    if ((this.jdField_a_of_type_Wsq == null) || (this.jdField_a_of_type_Wsq.jdField_a_of_type_Int != 0))
    {
      if (this.jdField_a_of_type_Wsq == null)
      {
        i = 940001;
        if (this.jdField_a_of_type_Wsq != null) {
          break label142;
        }
      }
      for (paramych = "";; paramych = this.jdField_a_of_type_Wsq.b)
      {
        notifyError(new ErrorMessage(i, paramych));
        return;
        i = this.jdField_a_of_type_Wsq.jdField_a_of_type_Int;
        break;
      }
    }
    label142:
    yck localyck = (yck)wjs.a(11);
    ycz localycz = new ycz(new ErrorMessage());
    localycz.c = paramych.jdField_a_of_type_Boolean;
    localycz.jdField_a_of_type_Boolean = paramych.b;
    localycz.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Wsq.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ydz)((Iterator)localObject1).next();
      localycz.jdField_a_of_type_JavaUtilList.add(((ydz)localObject2).a.feedId);
    }
    localycz.b = this.jdField_a_of_type_Wsq.jdField_a_of_type_JavaUtilList;
    localObject1 = this.jdField_a_of_type_Wsq.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ydz)((Iterator)localObject1).next();
      ((ydz)localObject2).a(i, this.jdField_a_of_type_Wsq, this.jdField_a_of_type_Wsk, this.jdField_a_of_type_Wsn);
      if ((localObject2 instanceof ybu))
      {
        localObject2 = (ybu)localObject2;
        if (this.jdField_a_of_type_Wuy != null)
        {
          localObject3 = a(i, (ybu)localObject2);
          if (localObject3 != null)
          {
            ((ybu)localObject2).a().mViewTotalTime = ((wkv)localObject3).c;
            ykq.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "get feature feedId=%s, view total=%d", ((ybu)localObject2).a.feedId, Long.valueOf(((ybu)localObject2).a().mViewTotalTime));
          }
        }
      }
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_Wsq.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ydz)((Iterator)localObject1).next()).a();
    }
    localObject1 = new ArrayList(localycz.b.size());
    Object localObject2 = localycz.b.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((ydz)((Iterator)localObject2).next()).a);
    }
    localObject1 = localyck.a((List)localObject1);
    localObject2 = localycz.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ydz)((Iterator)localObject2).next();
      i = ((List)localObject1).indexOf(((ydz)localObject3).a);
      if (i >= 0)
      {
        ((ydz)localObject3).a = ((FeedItem)((List)localObject1).get(i));
        ((ydz)localObject3).a.onRefresh();
      }
    }
    if (paramych.jdField_a_of_type_Boolean) {
      localyck.a().a();
    }
    if (this.jdField_a_of_type_Wsk != null)
    {
      ykq.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "need sync comment size:%d", Integer.valueOf(this.jdField_a_of_type_Wsk.b.size()));
      if ((this.jdField_a_of_type_Wsk.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Wsk.b.size() > 0)) {
        localyck.a().a(this.jdField_a_of_type_Wsk.b);
      }
    }
    notifyResult(localycz);
  }
  
  private void b(JobContext paramJobContext, ych paramych)
  {
    List localList = paramych.jdField_a_of_type_JavaUtilList;
    ykq.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info count:%d", Integer.valueOf(localList.size()));
    if (ykq.a()) {
      ykq.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info %s", localList);
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((ycc)((Iterator)localObject).next()).a);
    }
    localObject = new wsp();
    this.jdField_a_of_type_JavaUtilVector.add(localObject);
    wsj localwsj = new wsj(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localwsj);
    wsm localwsm = new wsm(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localwsm);
    wtb localwtb = new wtb();
    this.jdField_a_of_type_JavaUtilVector.add(localwtb);
    ((wsp)localObject).jdField_a_of_type_JavaUtilList = localList;
    wfi.a().a((wfm)localObject, new ycv(this, paramJobContext, paramych));
    wfi.a().a(localwsj, new ycw(this, paramJobContext, paramych));
    wfi.a().a(localwsm, new ycx(this, paramJobContext, paramych));
    localwtb.jdField_a_of_type_JavaUtilList = localArrayList;
    wfi.a().a(localwtb, new ycy(this, paramJobContext, paramych));
  }
  
  protected void a(JobContext paramJobContext, ych paramych)
  {
    Iterator localIterator = paramych.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    if (paramych.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (paramych.b)
      {
        paramJobContext = new ycz(new ErrorMessage());
        paramJobContext.c = paramych.jdField_a_of_type_Boolean;
        paramJobContext.jdField_a_of_type_Boolean = paramych.b;
        notifyResult(paramJobContext);
        return;
      }
      paramJobContext = new ErrorMessage(940001, "");
      paramJobContext.extraMsg = "data error no data";
      notifyError(paramJobContext);
      ykq.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed id arg %s", paramJobContext);
      return;
    }
    b(paramJobContext, paramych);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycu
 * JD-Core Version:    0.7.0.1
 */