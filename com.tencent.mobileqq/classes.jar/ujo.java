import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ujo
  extends JobSegment<ujb, ujt>
{
  private Vector<slz> jdField_a_of_type_JavaUtilVector = new Vector(5);
  private syy jdField_a_of_type_Syy;
  private szb jdField_a_of_type_Szb;
  private sze jdField_a_of_type_Sze;
  private tbm jdField_a_of_type_Tbm;
  
  private srj a(int paramInt, uio paramuio)
  {
    List localList = this.jdField_a_of_type_Tbm.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (srj localsrj = (srj)localList.get(paramInt);; localsrj = null)
    {
      if ((localsrj != null) && (localsrj.a.equals(paramuio.a.feedId))) {
        return localsrj;
      }
      localsrj = new srj();
      localsrj.a = paramuio.a.feedId;
      paramInt = localList.indexOf(localsrj);
      if (paramInt >= 0) {
        return (srj)localList.get(paramInt);
      }
      urk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "can't not find feed like for id:%s", new Object[] { paramuio.a.feedId });
      return null;
    }
  }
  
  private void a(ujb paramujb)
  {
    boolean bool3 = true;
    int i = 0;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_Sze != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Syy == null) {
        break label68;
      }
      bool2 = true;
      label24:
      if (this.jdField_a_of_type_Szb == null) {
        break label74;
      }
    }
    for (;;)
    {
      urk.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed info resp basic info:%b, comment %b, like %b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
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
    if ((this.jdField_a_of_type_Sze == null) || (this.jdField_a_of_type_Sze.jdField_a_of_type_Int != 0))
    {
      notifyError(new ErrorMessage(this.jdField_a_of_type_Sze.jdField_a_of_type_Int, this.jdField_a_of_type_Sze.b));
      return;
    }
    uje localuje = (uje)sqg.a(11);
    ujt localujt = new ujt(new ErrorMessage());
    localujt.c = paramujb.jdField_a_of_type_Boolean;
    localujt.jdField_a_of_type_Boolean = paramujb.b;
    localujt.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Sze.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ukt)((Iterator)localObject1).next();
      localujt.jdField_a_of_type_JavaUtilList.add(((ukt)localObject2).a.feedId);
    }
    localujt.b = this.jdField_a_of_type_Sze.jdField_a_of_type_JavaUtilList;
    localObject1 = this.jdField_a_of_type_Sze.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ukt)((Iterator)localObject1).next();
      ((ukt)localObject2).a(i, this.jdField_a_of_type_Sze, this.jdField_a_of_type_Syy, this.jdField_a_of_type_Szb);
      if ((localObject2 instanceof uio))
      {
        localObject2 = (uio)localObject2;
        if (this.jdField_a_of_type_Tbm != null)
        {
          localObject3 = a(i, (uio)localObject2);
          if (localObject3 != null)
          {
            ((uio)localObject2).a().mViewTotalTime = ((srj)localObject3).c;
            urk.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "get feature feedId=%s, view total=%d", ((uio)localObject2).a.feedId, Long.valueOf(((uio)localObject2).a().mViewTotalTime));
          }
        }
      }
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_Sze.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ukt)((Iterator)localObject1).next()).a();
    }
    localObject1 = new ArrayList(localujt.b.size());
    Object localObject2 = localujt.b.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((ukt)((Iterator)localObject2).next()).a);
    }
    localObject1 = localuje.a((List)localObject1);
    localObject2 = localujt.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ukt)((Iterator)localObject2).next();
      i = ((List)localObject1).indexOf(((ukt)localObject3).a);
      if (i >= 0)
      {
        ((ukt)localObject3).a = ((FeedItem)((List)localObject1).get(i));
        ((ukt)localObject3).a.onRefresh();
      }
    }
    if (paramujb.jdField_a_of_type_Boolean) {
      localuje.a().a();
    }
    urk.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "need sync comment size:%d", Integer.valueOf(this.jdField_a_of_type_Syy.b.size()));
    if ((this.jdField_a_of_type_Syy.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Syy.b.size() > 0)) {
      localuje.a().a(this.jdField_a_of_type_Syy.b);
    }
    notifyResult(localujt);
  }
  
  private void b(JobContext paramJobContext, ujb paramujb)
  {
    List localList = paramujb.jdField_a_of_type_JavaUtilList;
    urk.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info count:%d", Integer.valueOf(localList.size()));
    if (urk.a()) {
      urk.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info %s", localList);
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((uiw)((Iterator)localObject).next()).a);
    }
    localObject = new szd();
    this.jdField_a_of_type_JavaUtilVector.add(localObject);
    syx localsyx = new syx(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localsyx);
    sza localsza = new sza(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localsza);
    szp localszp = new szp();
    this.jdField_a_of_type_JavaUtilVector.add(localszp);
    ((szd)localObject).jdField_a_of_type_JavaUtilList = localList;
    slv.a().a((slz)localObject, new ujp(this, paramJobContext, paramujb));
    slv.a().a(localsyx, new ujq(this, paramJobContext, paramujb));
    slv.a().a(localsza, new ujr(this, paramJobContext, paramujb));
    localszp.jdField_a_of_type_JavaUtilList = localArrayList;
    slv.a().a(localszp, new ujs(this, paramJobContext, paramujb));
  }
  
  protected void a(JobContext paramJobContext, ujb paramujb)
  {
    Iterator localIterator = paramujb.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    if (paramujb.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (paramujb.b)
      {
        paramJobContext = new ujt(new ErrorMessage());
        paramJobContext.c = paramujb.jdField_a_of_type_Boolean;
        paramJobContext.jdField_a_of_type_Boolean = paramujb.b;
        notifyResult(paramJobContext);
        return;
      }
      paramJobContext = new ErrorMessage(940001, "");
      paramJobContext.extraMsg = "data error no data";
      notifyError(paramJobContext);
      urk.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed id arg %s", paramJobContext);
      return;
    }
    b(paramJobContext, paramujb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujo
 * JD-Core Version:    0.7.0.1
 */