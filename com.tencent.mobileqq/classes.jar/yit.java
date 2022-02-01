import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class yit
  extends JobSegment<yig, yiy>
{
  private Vector<wlf> jdField_a_of_type_JavaUtilVector = new Vector(5);
  private wye jdField_a_of_type_Wye;
  private wyh jdField_a_of_type_Wyh;
  private wyk jdField_a_of_type_Wyk;
  private xas jdField_a_of_type_Xas;
  
  private wqp a(int paramInt, yht paramyht)
  {
    List localList = this.jdField_a_of_type_Xas.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (wqp localwqp = (wqp)localList.get(paramInt);; localwqp = null)
    {
      if ((localwqp != null) && (localwqp.a.equals(paramyht.a.feedId))) {
        return localwqp;
      }
      localwqp = new wqp();
      localwqp.a = paramyht.a.feedId;
      paramInt = localList.indexOf(localwqp);
      if (paramInt >= 0) {
        return (wqp)localList.get(paramInt);
      }
      yqp.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "can't not find feed like for id:%s", new Object[] { paramyht.a.feedId });
      return null;
    }
  }
  
  private void a(yig paramyig)
  {
    boolean bool3 = true;
    int i = 0;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_Wyk != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Wye == null) {
        break label68;
      }
      bool2 = true;
      label24:
      if (this.jdField_a_of_type_Wyh == null) {
        break label74;
      }
    }
    for (;;)
    {
      yqp.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed info resp basic info:%b, comment %b, like %b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
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
    if ((this.jdField_a_of_type_Wyk == null) || (this.jdField_a_of_type_Wyk.jdField_a_of_type_Int != 0))
    {
      notifyError(new ErrorMessage(this.jdField_a_of_type_Wyk.jdField_a_of_type_Int, this.jdField_a_of_type_Wyk.b));
      return;
    }
    yij localyij = (yij)wpm.a(11);
    yiy localyiy = new yiy(new ErrorMessage());
    localyiy.c = paramyig.jdField_a_of_type_Boolean;
    localyiy.jdField_a_of_type_Boolean = paramyig.b;
    localyiy.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Wyk.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (yjy)((Iterator)localObject1).next();
      localyiy.jdField_a_of_type_JavaUtilList.add(((yjy)localObject2).a.feedId);
    }
    localyiy.b = this.jdField_a_of_type_Wyk.jdField_a_of_type_JavaUtilList;
    localObject1 = this.jdField_a_of_type_Wyk.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (yjy)((Iterator)localObject1).next();
      ((yjy)localObject2).a(i, this.jdField_a_of_type_Wyk, this.jdField_a_of_type_Wye, this.jdField_a_of_type_Wyh);
      if ((localObject2 instanceof yht))
      {
        localObject2 = (yht)localObject2;
        if (this.jdField_a_of_type_Xas != null)
        {
          localObject3 = a(i, (yht)localObject2);
          if (localObject3 != null)
          {
            ((yht)localObject2).a().mViewTotalTime = ((wqp)localObject3).c;
            yqp.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "get feature feedId=%s, view total=%d", ((yht)localObject2).a.feedId, Long.valueOf(((yht)localObject2).a().mViewTotalTime));
          }
        }
      }
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_Wyk.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((yjy)((Iterator)localObject1).next()).a();
    }
    localObject1 = new ArrayList(localyiy.b.size());
    Object localObject2 = localyiy.b.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((yjy)((Iterator)localObject2).next()).a);
    }
    localObject1 = localyij.a((List)localObject1);
    localObject2 = localyiy.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (yjy)((Iterator)localObject2).next();
      i = ((List)localObject1).indexOf(((yjy)localObject3).a);
      if (i >= 0)
      {
        ((yjy)localObject3).a = ((FeedItem)((List)localObject1).get(i));
        ((yjy)localObject3).a.onRefresh();
      }
    }
    if (paramyig.jdField_a_of_type_Boolean) {
      localyij.a().a();
    }
    yqp.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "need sync comment size:%d", Integer.valueOf(this.jdField_a_of_type_Wye.b.size()));
    if ((this.jdField_a_of_type_Wye.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Wye.b.size() > 0)) {
      localyij.a().a(this.jdField_a_of_type_Wye.b);
    }
    notifyResult(localyiy);
  }
  
  private void b(JobContext paramJobContext, yig paramyig)
  {
    List localList = paramyig.jdField_a_of_type_JavaUtilList;
    yqp.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info count:%d", Integer.valueOf(localList.size()));
    if (yqp.a()) {
      yqp.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info %s", localList);
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((yib)((Iterator)localObject).next()).a);
    }
    localObject = new wyj();
    this.jdField_a_of_type_JavaUtilVector.add(localObject);
    wyd localwyd = new wyd(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localwyd);
    wyg localwyg = new wyg(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localwyg);
    wyv localwyv = new wyv();
    this.jdField_a_of_type_JavaUtilVector.add(localwyv);
    ((wyj)localObject).jdField_a_of_type_JavaUtilList = localList;
    wlb.a().a((wlf)localObject, new yiu(this, paramJobContext, paramyig));
    wlb.a().a(localwyd, new yiv(this, paramJobContext, paramyig));
    wlb.a().a(localwyg, new yiw(this, paramJobContext, paramyig));
    localwyv.jdField_a_of_type_JavaUtilList = localArrayList;
    wlb.a().a(localwyv, new yix(this, paramJobContext, paramyig));
  }
  
  protected void a(JobContext paramJobContext, yig paramyig)
  {
    Iterator localIterator = paramyig.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    if (paramyig.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (paramyig.b)
      {
        paramJobContext = new yiy(new ErrorMessage());
        paramJobContext.c = paramyig.jdField_a_of_type_Boolean;
        paramJobContext.jdField_a_of_type_Boolean = paramyig.b;
        notifyResult(paramJobContext);
        return;
      }
      paramJobContext = new ErrorMessage(940001, "");
      paramJobContext.extraMsg = "data error no data";
      notifyError(paramJobContext);
      yqp.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed id arg %s", paramJobContext);
      return;
    }
    b(paramJobContext, paramyig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yit
 * JD-Core Version:    0.7.0.1
 */