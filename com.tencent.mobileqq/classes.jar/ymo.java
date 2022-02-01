import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ymo
  extends JobSegment<ymb, ymt>
{
  private Vector<wpa> jdField_a_of_type_JavaUtilVector = new Vector(5);
  private xbz jdField_a_of_type_Xbz;
  private xcc jdField_a_of_type_Xcc;
  private xcf jdField_a_of_type_Xcf;
  private xen jdField_a_of_type_Xen;
  
  private wuk a(int paramInt, ylo paramylo)
  {
    List localList = this.jdField_a_of_type_Xen.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (wuk localwuk = (wuk)localList.get(paramInt);; localwuk = null)
    {
      if ((localwuk != null) && (localwuk.a.equals(paramylo.a.feedId))) {
        return localwuk;
      }
      localwuk = new wuk();
      localwuk.a = paramylo.a.feedId;
      paramInt = localList.indexOf(localwuk);
      if (paramInt >= 0) {
        return (wuk)localList.get(paramInt);
      }
      yuk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "can't not find feed like for id:%s", new Object[] { paramylo.a.feedId });
      return null;
    }
  }
  
  private void a(ymb paramymb)
  {
    boolean bool3 = true;
    int i = 0;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_Xcf != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Xbz == null) {
        break label68;
      }
      bool2 = true;
      label24:
      if (this.jdField_a_of_type_Xcc == null) {
        break label74;
      }
    }
    for (;;)
    {
      yuk.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed info resp basic info:%b, comment %b, like %b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
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
    if ((this.jdField_a_of_type_Xcf == null) || (this.jdField_a_of_type_Xcf.jdField_a_of_type_Int != 0))
    {
      notifyError(new ErrorMessage(this.jdField_a_of_type_Xcf.jdField_a_of_type_Int, this.jdField_a_of_type_Xcf.b));
      return;
    }
    yme localyme = (yme)wth.a(11);
    ymt localymt = new ymt(new ErrorMessage());
    localymt.c = paramymb.jdField_a_of_type_Boolean;
    localymt.jdField_a_of_type_Boolean = paramymb.b;
    localymt.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Xcf.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ynt)((Iterator)localObject1).next();
      localymt.jdField_a_of_type_JavaUtilList.add(((ynt)localObject2).a.feedId);
    }
    localymt.b = this.jdField_a_of_type_Xcf.jdField_a_of_type_JavaUtilList;
    localObject1 = this.jdField_a_of_type_Xcf.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ynt)((Iterator)localObject1).next();
      ((ynt)localObject2).a(i, this.jdField_a_of_type_Xcf, this.jdField_a_of_type_Xbz, this.jdField_a_of_type_Xcc);
      if ((localObject2 instanceof ylo))
      {
        localObject2 = (ylo)localObject2;
        if (this.jdField_a_of_type_Xen != null)
        {
          localObject3 = a(i, (ylo)localObject2);
          if (localObject3 != null)
          {
            ((ylo)localObject2).a().mViewTotalTime = ((wuk)localObject3).c;
            yuk.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "get feature feedId=%s, view total=%d", ((ylo)localObject2).a.feedId, Long.valueOf(((ylo)localObject2).a().mViewTotalTime));
          }
        }
      }
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_Xcf.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ynt)((Iterator)localObject1).next()).a();
    }
    localObject1 = new ArrayList(localymt.b.size());
    Object localObject2 = localymt.b.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((ynt)((Iterator)localObject2).next()).a);
    }
    localObject1 = localyme.a((List)localObject1);
    localObject2 = localymt.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ynt)((Iterator)localObject2).next();
      i = ((List)localObject1).indexOf(((ynt)localObject3).a);
      if (i >= 0)
      {
        ((ynt)localObject3).a = ((FeedItem)((List)localObject1).get(i));
        ((ynt)localObject3).a.onRefresh();
      }
    }
    if (paramymb.jdField_a_of_type_Boolean) {
      localyme.a().a();
    }
    yuk.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "need sync comment size:%d", Integer.valueOf(this.jdField_a_of_type_Xbz.b.size()));
    if ((this.jdField_a_of_type_Xbz.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Xbz.b.size() > 0)) {
      localyme.a().a(this.jdField_a_of_type_Xbz.b);
    }
    notifyResult(localymt);
  }
  
  private void b(JobContext paramJobContext, ymb paramymb)
  {
    List localList = paramymb.jdField_a_of_type_JavaUtilList;
    yuk.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info count:%d", Integer.valueOf(localList.size()));
    if (yuk.a()) {
      yuk.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info %s", localList);
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((ylw)((Iterator)localObject).next()).a);
    }
    localObject = new xce();
    this.jdField_a_of_type_JavaUtilVector.add(localObject);
    xby localxby = new xby(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localxby);
    xcb localxcb = new xcb(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localxcb);
    xcq localxcq = new xcq();
    this.jdField_a_of_type_JavaUtilVector.add(localxcq);
    ((xce)localObject).jdField_a_of_type_JavaUtilList = localList;
    wow.a().a((wpa)localObject, new ymp(this, paramJobContext, paramymb));
    wow.a().a(localxby, new ymq(this, paramJobContext, paramymb));
    wow.a().a(localxcb, new ymr(this, paramJobContext, paramymb));
    localxcq.jdField_a_of_type_JavaUtilList = localArrayList;
    wow.a().a(localxcq, new yms(this, paramJobContext, paramymb));
  }
  
  protected void a(JobContext paramJobContext, ymb paramymb)
  {
    Iterator localIterator = paramymb.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    if (paramymb.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (paramymb.b)
      {
        paramJobContext = new ymt(new ErrorMessage());
        paramJobContext.c = paramymb.jdField_a_of_type_Boolean;
        paramJobContext.jdField_a_of_type_Boolean = paramymb.b;
        notifyResult(paramJobContext);
        return;
      }
      paramJobContext = new ErrorMessage(940001, "");
      paramJobContext.extraMsg = "data error no data";
      notifyError(paramJobContext);
      yuk.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed id arg %s", paramJobContext);
      return;
    }
    b(paramJobContext, paramymb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymo
 * JD-Core Version:    0.7.0.1
 */