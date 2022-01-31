import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class wpi
  extends JobSegment<wov, wpn>
{
  private Vector<urt> jdField_a_of_type_JavaUtilVector = new Vector(5);
  private ves jdField_a_of_type_Ves;
  private vev jdField_a_of_type_Vev;
  private vey jdField_a_of_type_Vey;
  private vhg jdField_a_of_type_Vhg;
  
  private uxd a(int paramInt, woi paramwoi)
  {
    List localList = this.jdField_a_of_type_Vhg.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (uxd localuxd = (uxd)localList.get(paramInt);; localuxd = null)
    {
      if ((localuxd != null) && (localuxd.a.equals(paramwoi.a.feedId))) {
        return localuxd;
      }
      localuxd = new uxd();
      localuxd.a = paramwoi.a.feedId;
      paramInt = localList.indexOf(localuxd);
      if (paramInt >= 0) {
        return (uxd)localList.get(paramInt);
      }
      wxe.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "can't not find feed like for id:%s", new Object[] { paramwoi.a.feedId });
      return null;
    }
  }
  
  private void a(wov paramwov)
  {
    boolean bool3 = true;
    int i = 0;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_Vey != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Ves == null) {
        break label68;
      }
      bool2 = true;
      label24:
      if (this.jdField_a_of_type_Vev == null) {
        break label74;
      }
    }
    for (;;)
    {
      wxe.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed info resp basic info:%b, comment %b, like %b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
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
    if ((this.jdField_a_of_type_Vey == null) || (this.jdField_a_of_type_Vey.jdField_a_of_type_Int != 0))
    {
      notifyError(new ErrorMessage(this.jdField_a_of_type_Vey.jdField_a_of_type_Int, this.jdField_a_of_type_Vey.b));
      return;
    }
    woy localwoy = (woy)uwa.a(11);
    wpn localwpn = new wpn(new ErrorMessage());
    localwpn.c = paramwov.jdField_a_of_type_Boolean;
    localwpn.jdField_a_of_type_Boolean = paramwov.b;
    localwpn.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Vey.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (wqn)((Iterator)localObject1).next();
      localwpn.jdField_a_of_type_JavaUtilList.add(((wqn)localObject2).a.feedId);
    }
    localwpn.b = this.jdField_a_of_type_Vey.jdField_a_of_type_JavaUtilList;
    localObject1 = this.jdField_a_of_type_Vey.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (wqn)((Iterator)localObject1).next();
      ((wqn)localObject2).a(i, this.jdField_a_of_type_Vey, this.jdField_a_of_type_Ves, this.jdField_a_of_type_Vev);
      if ((localObject2 instanceof woi))
      {
        localObject2 = (woi)localObject2;
        if (this.jdField_a_of_type_Vhg != null)
        {
          localObject3 = a(i, (woi)localObject2);
          if (localObject3 != null)
          {
            ((woi)localObject2).a().mViewTotalTime = ((uxd)localObject3).c;
            wxe.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "get feature feedId=%s, view total=%d", ((woi)localObject2).a.feedId, Long.valueOf(((woi)localObject2).a().mViewTotalTime));
          }
        }
      }
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_Vey.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((wqn)((Iterator)localObject1).next()).a();
    }
    localObject1 = new ArrayList(localwpn.b.size());
    Object localObject2 = localwpn.b.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((wqn)((Iterator)localObject2).next()).a);
    }
    localObject1 = localwoy.a((List)localObject1);
    localObject2 = localwpn.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (wqn)((Iterator)localObject2).next();
      i = ((List)localObject1).indexOf(((wqn)localObject3).a);
      if (i >= 0)
      {
        ((wqn)localObject3).a = ((FeedItem)((List)localObject1).get(i));
        ((wqn)localObject3).a.onRefresh();
      }
    }
    if (paramwov.jdField_a_of_type_Boolean) {
      localwoy.a().a();
    }
    wxe.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "need sync comment size:%d", Integer.valueOf(this.jdField_a_of_type_Ves.b.size()));
    if ((this.jdField_a_of_type_Ves.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Ves.b.size() > 0)) {
      localwoy.a().a(this.jdField_a_of_type_Ves.b);
    }
    notifyResult(localwpn);
  }
  
  private void b(JobContext paramJobContext, wov paramwov)
  {
    List localList = paramwov.jdField_a_of_type_JavaUtilList;
    wxe.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info count:%d", Integer.valueOf(localList.size()));
    if (wxe.a()) {
      wxe.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info %s", localList);
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((woq)((Iterator)localObject).next()).a);
    }
    localObject = new vex();
    this.jdField_a_of_type_JavaUtilVector.add(localObject);
    ver localver = new ver(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localver);
    veu localveu = new veu(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localveu);
    vfj localvfj = new vfj();
    this.jdField_a_of_type_JavaUtilVector.add(localvfj);
    ((vex)localObject).jdField_a_of_type_JavaUtilList = localList;
    urp.a().a((urt)localObject, new wpj(this, paramJobContext, paramwov));
    urp.a().a(localver, new wpk(this, paramJobContext, paramwov));
    urp.a().a(localveu, new wpl(this, paramJobContext, paramwov));
    localvfj.jdField_a_of_type_JavaUtilList = localArrayList;
    urp.a().a(localvfj, new wpm(this, paramJobContext, paramwov));
  }
  
  protected void a(JobContext paramJobContext, wov paramwov)
  {
    Iterator localIterator = paramwov.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    if (paramwov.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (paramwov.b)
      {
        paramJobContext = new wpn(new ErrorMessage());
        paramJobContext.c = paramwov.jdField_a_of_type_Boolean;
        paramJobContext.jdField_a_of_type_Boolean = paramwov.b;
        notifyResult(paramJobContext);
        return;
      }
      paramJobContext = new ErrorMessage(940001, "");
      paramJobContext.extraMsg = "data error no data";
      notifyError(paramJobContext);
      wxe.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed id arg %s", paramJobContext);
      return;
    }
    b(paramJobContext, paramwov);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpi
 * JD-Core Version:    0.7.0.1
 */