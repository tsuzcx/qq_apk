import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class wkz
  extends JobSegment<wkm, wle>
{
  private Vector<unk> jdField_a_of_type_JavaUtilVector = new Vector(5);
  private vaj jdField_a_of_type_Vaj;
  private vam jdField_a_of_type_Vam;
  private vap jdField_a_of_type_Vap;
  private vcx jdField_a_of_type_Vcx;
  
  private usu a(int paramInt, wjz paramwjz)
  {
    List localList = this.jdField_a_of_type_Vcx.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (usu localusu = (usu)localList.get(paramInt);; localusu = null)
    {
      if ((localusu != null) && (localusu.a.equals(paramwjz.a.feedId))) {
        return localusu;
      }
      localusu = new usu();
      localusu.a = paramwjz.a.feedId;
      paramInt = localList.indexOf(localusu);
      if (paramInt >= 0) {
        return (usu)localList.get(paramInt);
      }
      wsv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "can't not find feed like for id:%s", new Object[] { paramwjz.a.feedId });
      return null;
    }
  }
  
  private void a(wkm paramwkm)
  {
    boolean bool3 = true;
    int i = 0;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_Vap != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Vaj == null) {
        break label68;
      }
      bool2 = true;
      label24:
      if (this.jdField_a_of_type_Vam == null) {
        break label74;
      }
    }
    for (;;)
    {
      wsv.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed info resp basic info:%b, comment %b, like %b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
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
    if ((this.jdField_a_of_type_Vap == null) || (this.jdField_a_of_type_Vap.jdField_a_of_type_Int != 0))
    {
      notifyError(new ErrorMessage(this.jdField_a_of_type_Vap.jdField_a_of_type_Int, this.jdField_a_of_type_Vap.b));
      return;
    }
    wkp localwkp = (wkp)urr.a(11);
    wle localwle = new wle(new ErrorMessage());
    localwle.c = paramwkm.jdField_a_of_type_Boolean;
    localwle.jdField_a_of_type_Boolean = paramwkm.b;
    localwle.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Vap.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (wme)((Iterator)localObject1).next();
      localwle.jdField_a_of_type_JavaUtilList.add(((wme)localObject2).a.feedId);
    }
    localwle.b = this.jdField_a_of_type_Vap.jdField_a_of_type_JavaUtilList;
    localObject1 = this.jdField_a_of_type_Vap.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (wme)((Iterator)localObject1).next();
      ((wme)localObject2).a(i, this.jdField_a_of_type_Vap, this.jdField_a_of_type_Vaj, this.jdField_a_of_type_Vam);
      if ((localObject2 instanceof wjz))
      {
        localObject2 = (wjz)localObject2;
        if (this.jdField_a_of_type_Vcx != null)
        {
          localObject3 = a(i, (wjz)localObject2);
          if (localObject3 != null)
          {
            ((wjz)localObject2).a().mViewTotalTime = ((usu)localObject3).c;
            wsv.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "get feature feedId=%s, view total=%d", ((wjz)localObject2).a.feedId, Long.valueOf(((wjz)localObject2).a().mViewTotalTime));
          }
        }
      }
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_Vap.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((wme)((Iterator)localObject1).next()).a();
    }
    localObject1 = new ArrayList(localwle.b.size());
    Object localObject2 = localwle.b.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((wme)((Iterator)localObject2).next()).a);
    }
    localObject1 = localwkp.a((List)localObject1);
    localObject2 = localwle.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (wme)((Iterator)localObject2).next();
      i = ((List)localObject1).indexOf(((wme)localObject3).a);
      if (i >= 0)
      {
        ((wme)localObject3).a = ((FeedItem)((List)localObject1).get(i));
        ((wme)localObject3).a.onRefresh();
      }
    }
    if (paramwkm.jdField_a_of_type_Boolean) {
      localwkp.a().a();
    }
    wsv.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "need sync comment size:%d", Integer.valueOf(this.jdField_a_of_type_Vaj.b.size()));
    if ((this.jdField_a_of_type_Vaj.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Vaj.b.size() > 0)) {
      localwkp.a().a(this.jdField_a_of_type_Vaj.b);
    }
    notifyResult(localwle);
  }
  
  private void b(JobContext paramJobContext, wkm paramwkm)
  {
    List localList = paramwkm.jdField_a_of_type_JavaUtilList;
    wsv.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info count:%d", Integer.valueOf(localList.size()));
    if (wsv.a()) {
      wsv.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info %s", localList);
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((wkh)((Iterator)localObject).next()).a);
    }
    localObject = new vao();
    this.jdField_a_of_type_JavaUtilVector.add(localObject);
    vai localvai = new vai(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localvai);
    val localval = new val(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localval);
    vba localvba = new vba();
    this.jdField_a_of_type_JavaUtilVector.add(localvba);
    ((vao)localObject).jdField_a_of_type_JavaUtilList = localList;
    ung.a().a((unk)localObject, new wla(this, paramJobContext, paramwkm));
    ung.a().a(localvai, new wlb(this, paramJobContext, paramwkm));
    ung.a().a(localval, new wlc(this, paramJobContext, paramwkm));
    localvba.jdField_a_of_type_JavaUtilList = localArrayList;
    ung.a().a(localvba, new wld(this, paramJobContext, paramwkm));
  }
  
  protected void a(JobContext paramJobContext, wkm paramwkm)
  {
    Iterator localIterator = paramwkm.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    if (paramwkm.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (paramwkm.b)
      {
        paramJobContext = new wle(new ErrorMessage());
        paramJobContext.c = paramwkm.jdField_a_of_type_Boolean;
        paramJobContext.jdField_a_of_type_Boolean = paramwkm.b;
        notifyResult(paramJobContext);
        return;
      }
      paramJobContext = new ErrorMessage(940001, "");
      paramJobContext.extraMsg = "data error no data";
      notifyError(paramJobContext);
      wsv.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed id arg %s", paramJobContext);
      return;
    }
    b(paramJobContext, paramwkm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkz
 * JD-Core Version:    0.7.0.1
 */