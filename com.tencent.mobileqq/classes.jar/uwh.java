import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class uwh
  extends JobSegment<uvu, uwm>
{
  private Vector<sys> jdField_a_of_type_JavaUtilVector = new Vector(5);
  private tlr jdField_a_of_type_Tlr;
  private tlu jdField_a_of_type_Tlu;
  private tlx jdField_a_of_type_Tlx;
  private tof jdField_a_of_type_Tof;
  
  private tec a(int paramInt, uvh paramuvh)
  {
    List localList = this.jdField_a_of_type_Tof.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (tec localtec = (tec)localList.get(paramInt);; localtec = null)
    {
      if ((localtec != null) && (localtec.a.equals(paramuvh.a.feedId))) {
        return localtec;
      }
      localtec = new tec();
      localtec.a = paramuvh.a.feedId;
      paramInt = localList.indexOf(localtec);
      if (paramInt >= 0) {
        return (tec)localList.get(paramInt);
      }
      ved.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "can't not find feed like for id:%s", new Object[] { paramuvh.a.feedId });
      return null;
    }
  }
  
  private void a(uvu paramuvu)
  {
    boolean bool3 = true;
    int i = 0;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_Tlx != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Tlr == null) {
        break label68;
      }
      bool2 = true;
      label24:
      if (this.jdField_a_of_type_Tlu == null) {
        break label74;
      }
    }
    for (;;)
    {
      ved.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed info resp basic info:%b, comment %b, like %b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
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
    if ((this.jdField_a_of_type_Tlx == null) || (this.jdField_a_of_type_Tlx.jdField_a_of_type_Int != 0))
    {
      notifyError(new ErrorMessage(this.jdField_a_of_type_Tlx.jdField_a_of_type_Int, this.jdField_a_of_type_Tlx.b));
      return;
    }
    uvx localuvx = (uvx)tcz.a(11);
    uwm localuwm = new uwm(new ErrorMessage());
    localuwm.c = paramuvu.jdField_a_of_type_Boolean;
    localuwm.jdField_a_of_type_Boolean = paramuvu.b;
    localuwm.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Tlx.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (uxm)((Iterator)localObject1).next();
      localuwm.jdField_a_of_type_JavaUtilList.add(((uxm)localObject2).a.feedId);
    }
    localuwm.b = this.jdField_a_of_type_Tlx.jdField_a_of_type_JavaUtilList;
    localObject1 = this.jdField_a_of_type_Tlx.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (uxm)((Iterator)localObject1).next();
      ((uxm)localObject2).a(i, this.jdField_a_of_type_Tlx, this.jdField_a_of_type_Tlr, this.jdField_a_of_type_Tlu);
      if ((localObject2 instanceof uvh))
      {
        localObject2 = (uvh)localObject2;
        if (this.jdField_a_of_type_Tof != null)
        {
          localObject3 = a(i, (uvh)localObject2);
          if (localObject3 != null)
          {
            ((uvh)localObject2).a().mViewTotalTime = ((tec)localObject3).c;
            ved.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "get feature feedId=%s, view total=%d", ((uvh)localObject2).a.feedId, Long.valueOf(((uvh)localObject2).a().mViewTotalTime));
          }
        }
      }
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_Tlx.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((uxm)((Iterator)localObject1).next()).a();
    }
    localObject1 = new ArrayList(localuwm.b.size());
    Object localObject2 = localuwm.b.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((uxm)((Iterator)localObject2).next()).a);
    }
    localObject1 = localuvx.a((List)localObject1);
    localObject2 = localuwm.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (uxm)((Iterator)localObject2).next();
      i = ((List)localObject1).indexOf(((uxm)localObject3).a);
      if (i >= 0)
      {
        ((uxm)localObject3).a = ((FeedItem)((List)localObject1).get(i));
        ((uxm)localObject3).a.onRefresh();
      }
    }
    if (paramuvu.jdField_a_of_type_Boolean) {
      localuvx.a().a();
    }
    ved.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "need sync comment size:%d", Integer.valueOf(this.jdField_a_of_type_Tlr.b.size()));
    if ((this.jdField_a_of_type_Tlr.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Tlr.b.size() > 0)) {
      localuvx.a().a(this.jdField_a_of_type_Tlr.b);
    }
    notifyResult(localuwm);
  }
  
  private void b(JobContext paramJobContext, uvu paramuvu)
  {
    List localList = paramuvu.jdField_a_of_type_JavaUtilList;
    ved.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info count:%d", Integer.valueOf(localList.size()));
    if (ved.a()) {
      ved.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info %s", localList);
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((uvp)((Iterator)localObject).next()).a);
    }
    localObject = new tlw();
    this.jdField_a_of_type_JavaUtilVector.add(localObject);
    tlq localtlq = new tlq(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localtlq);
    tlt localtlt = new tlt(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localtlt);
    tmi localtmi = new tmi();
    this.jdField_a_of_type_JavaUtilVector.add(localtmi);
    ((tlw)localObject).jdField_a_of_type_JavaUtilList = localList;
    syo.a().a((sys)localObject, new uwi(this, paramJobContext, paramuvu));
    syo.a().a(localtlq, new uwj(this, paramJobContext, paramuvu));
    syo.a().a(localtlt, new uwk(this, paramJobContext, paramuvu));
    localtmi.jdField_a_of_type_JavaUtilList = localArrayList;
    syo.a().a(localtmi, new uwl(this, paramJobContext, paramuvu));
  }
  
  protected void a(JobContext paramJobContext, uvu paramuvu)
  {
    Iterator localIterator = paramuvu.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    if (paramuvu.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (paramuvu.b)
      {
        paramJobContext = new uwm(new ErrorMessage());
        paramJobContext.c = paramuvu.jdField_a_of_type_Boolean;
        paramJobContext.jdField_a_of_type_Boolean = paramuvu.b;
        notifyResult(paramJobContext);
        return;
      }
      paramJobContext = new ErrorMessage(940001, "");
      paramJobContext.extraMsg = "data error no data";
      notifyError(paramJobContext);
      ved.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed id arg %s", paramJobContext);
      return;
    }
    b(paramJobContext, paramuvu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwh
 * JD-Core Version:    0.7.0.1
 */