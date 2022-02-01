import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class xnz
  extends JobSegment<xnm, xoe>
{
  private Vector<vqr> jdField_a_of_type_JavaUtilVector = new Vector(5);
  private wdp jdField_a_of_type_Wdp;
  private wds jdField_a_of_type_Wds;
  private wdv jdField_a_of_type_Wdv;
  private wgd jdField_a_of_type_Wgd;
  
  private vwa a(int paramInt, xmz paramxmz)
  {
    List localList = this.jdField_a_of_type_Wgd.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (vwa localvwa = (vwa)localList.get(paramInt);; localvwa = null)
    {
      if ((localvwa != null) && (localvwa.a.equals(paramxmz.a.feedId))) {
        return localvwa;
      }
      localvwa = new vwa();
      localvwa.a = paramxmz.a.feedId;
      paramInt = localList.indexOf(localvwa);
      if (paramInt >= 0) {
        return (vwa)localList.get(paramInt);
      }
      xvv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "can't not find feed like for id:%s", new Object[] { paramxmz.a.feedId });
      return null;
    }
  }
  
  private void a(xnm paramxnm)
  {
    boolean bool3 = true;
    int i = 0;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_Wdv != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Wdp == null) {
        break label68;
      }
      bool2 = true;
      label24:
      if (this.jdField_a_of_type_Wds == null) {
        break label74;
      }
    }
    for (;;)
    {
      xvv.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed info resp basic info:%b, comment %b, like %b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
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
    if ((this.jdField_a_of_type_Wdv == null) || (this.jdField_a_of_type_Wdv.jdField_a_of_type_Int != 0))
    {
      if (this.jdField_a_of_type_Wdv == null)
      {
        i = 940001;
        if (this.jdField_a_of_type_Wdv != null) {
          break label142;
        }
      }
      for (paramxnm = "";; paramxnm = this.jdField_a_of_type_Wdv.b)
      {
        notifyError(new ErrorMessage(i, paramxnm));
        return;
        i = this.jdField_a_of_type_Wdv.jdField_a_of_type_Int;
        break;
      }
    }
    label142:
    xnp localxnp = (xnp)vux.a(11);
    xoe localxoe = new xoe(new ErrorMessage());
    localxoe.c = paramxnm.jdField_a_of_type_Boolean;
    localxoe.jdField_a_of_type_Boolean = paramxnm.b;
    localxoe.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Wdv.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (xpe)((Iterator)localObject1).next();
      localxoe.jdField_a_of_type_JavaUtilList.add(((xpe)localObject2).a.feedId);
    }
    localxoe.b = this.jdField_a_of_type_Wdv.jdField_a_of_type_JavaUtilList;
    localObject1 = this.jdField_a_of_type_Wdv.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (xpe)((Iterator)localObject1).next();
      ((xpe)localObject2).a(i, this.jdField_a_of_type_Wdv, this.jdField_a_of_type_Wdp, this.jdField_a_of_type_Wds);
      if ((localObject2 instanceof xmz))
      {
        localObject2 = (xmz)localObject2;
        if (this.jdField_a_of_type_Wgd != null)
        {
          localObject3 = a(i, (xmz)localObject2);
          if (localObject3 != null)
          {
            ((xmz)localObject2).a().mViewTotalTime = ((vwa)localObject3).c;
            xvv.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "get feature feedId=%s, view total=%d", ((xmz)localObject2).a.feedId, Long.valueOf(((xmz)localObject2).a().mViewTotalTime));
          }
        }
      }
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_Wdv.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((xpe)((Iterator)localObject1).next()).a();
    }
    localObject1 = new ArrayList(localxoe.b.size());
    Object localObject2 = localxoe.b.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((xpe)((Iterator)localObject2).next()).a);
    }
    localObject1 = localxnp.a((List)localObject1);
    localObject2 = localxoe.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (xpe)((Iterator)localObject2).next();
      i = ((List)localObject1).indexOf(((xpe)localObject3).a);
      if (i >= 0)
      {
        ((xpe)localObject3).a = ((FeedItem)((List)localObject1).get(i));
        ((xpe)localObject3).a.onRefresh();
      }
    }
    if (paramxnm.jdField_a_of_type_Boolean) {
      localxnp.a().a();
    }
    if (this.jdField_a_of_type_Wdp != null)
    {
      xvv.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "need sync comment size:%d", Integer.valueOf(this.jdField_a_of_type_Wdp.b.size()));
      if ((this.jdField_a_of_type_Wdp.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Wdp.b.size() > 0)) {
        localxnp.a().a(this.jdField_a_of_type_Wdp.b);
      }
    }
    notifyResult(localxoe);
  }
  
  private void b(JobContext paramJobContext, xnm paramxnm)
  {
    List localList = paramxnm.jdField_a_of_type_JavaUtilList;
    xvv.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info count:%d", Integer.valueOf(localList.size()));
    if (xvv.a()) {
      xvv.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info %s", localList);
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((xnh)((Iterator)localObject).next()).a);
    }
    localObject = new wdu();
    this.jdField_a_of_type_JavaUtilVector.add(localObject);
    wdo localwdo = new wdo(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localwdo);
    wdr localwdr = new wdr(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localwdr);
    weg localweg = new weg();
    this.jdField_a_of_type_JavaUtilVector.add(localweg);
    ((wdu)localObject).jdField_a_of_type_JavaUtilList = localList;
    vqn.a().a((vqr)localObject, new xoa(this, paramJobContext, paramxnm));
    vqn.a().a(localwdo, new xob(this, paramJobContext, paramxnm));
    vqn.a().a(localwdr, new xoc(this, paramJobContext, paramxnm));
    localweg.jdField_a_of_type_JavaUtilList = localArrayList;
    vqn.a().a(localweg, new xod(this, paramJobContext, paramxnm));
  }
  
  protected void a(JobContext paramJobContext, xnm paramxnm)
  {
    Iterator localIterator = paramxnm.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    if (paramxnm.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (paramxnm.b)
      {
        paramJobContext = new xoe(new ErrorMessage());
        paramJobContext.c = paramxnm.jdField_a_of_type_Boolean;
        paramJobContext.jdField_a_of_type_Boolean = paramxnm.b;
        notifyResult(paramJobContext);
        return;
      }
      paramJobContext = new ErrorMessage(940001, "");
      paramJobContext.extraMsg = "data error no data";
      notifyError(paramJobContext);
      xvv.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed id arg %s", paramJobContext);
      return;
    }
    b(paramJobContext, paramxnm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnz
 * JD-Core Version:    0.7.0.1
 */