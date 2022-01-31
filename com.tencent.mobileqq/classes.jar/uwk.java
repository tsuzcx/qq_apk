import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class uwk
  extends JobSegment<uvx, uwp>
{
  private Vector<syv> jdField_a_of_type_JavaUtilVector = new Vector(5);
  private tlu jdField_a_of_type_Tlu;
  private tlx jdField_a_of_type_Tlx;
  private tma jdField_a_of_type_Tma;
  private toi jdField_a_of_type_Toi;
  
  private tef a(int paramInt, uvk paramuvk)
  {
    List localList = this.jdField_a_of_type_Toi.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (tef localtef = (tef)localList.get(paramInt);; localtef = null)
    {
      if ((localtef != null) && (localtef.a.equals(paramuvk.a.feedId))) {
        return localtef;
      }
      localtef = new tef();
      localtef.a = paramuvk.a.feedId;
      paramInt = localList.indexOf(localtef);
      if (paramInt >= 0) {
        return (tef)localList.get(paramInt);
      }
      veg.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "can't not find feed like for id:%s", new Object[] { paramuvk.a.feedId });
      return null;
    }
  }
  
  private void a(uvx paramuvx)
  {
    boolean bool3 = true;
    int i = 0;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_Tma != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Tlu == null) {
        break label68;
      }
      bool2 = true;
      label24:
      if (this.jdField_a_of_type_Tlx == null) {
        break label74;
      }
    }
    for (;;)
    {
      veg.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed info resp basic info:%b, comment %b, like %b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
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
    if ((this.jdField_a_of_type_Tma == null) || (this.jdField_a_of_type_Tma.jdField_a_of_type_Int != 0))
    {
      notifyError(new ErrorMessage(this.jdField_a_of_type_Tma.jdField_a_of_type_Int, this.jdField_a_of_type_Tma.b));
      return;
    }
    uwa localuwa = (uwa)tdc.a(11);
    uwp localuwp = new uwp(new ErrorMessage());
    localuwp.c = paramuvx.jdField_a_of_type_Boolean;
    localuwp.jdField_a_of_type_Boolean = paramuvx.b;
    localuwp.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Tma.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (uxp)((Iterator)localObject1).next();
      localuwp.jdField_a_of_type_JavaUtilList.add(((uxp)localObject2).a.feedId);
    }
    localuwp.b = this.jdField_a_of_type_Tma.jdField_a_of_type_JavaUtilList;
    localObject1 = this.jdField_a_of_type_Tma.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (uxp)((Iterator)localObject1).next();
      ((uxp)localObject2).a(i, this.jdField_a_of_type_Tma, this.jdField_a_of_type_Tlu, this.jdField_a_of_type_Tlx);
      if ((localObject2 instanceof uvk))
      {
        localObject2 = (uvk)localObject2;
        if (this.jdField_a_of_type_Toi != null)
        {
          localObject3 = a(i, (uvk)localObject2);
          if (localObject3 != null)
          {
            ((uvk)localObject2).a().mViewTotalTime = ((tef)localObject3).c;
            veg.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "get feature feedId=%s, view total=%d", ((uvk)localObject2).a.feedId, Long.valueOf(((uvk)localObject2).a().mViewTotalTime));
          }
        }
      }
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_Tma.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((uxp)((Iterator)localObject1).next()).a();
    }
    localObject1 = new ArrayList(localuwp.b.size());
    Object localObject2 = localuwp.b.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((uxp)((Iterator)localObject2).next()).a);
    }
    localObject1 = localuwa.a((List)localObject1);
    localObject2 = localuwp.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (uxp)((Iterator)localObject2).next();
      i = ((List)localObject1).indexOf(((uxp)localObject3).a);
      if (i >= 0)
      {
        ((uxp)localObject3).a = ((FeedItem)((List)localObject1).get(i));
        ((uxp)localObject3).a.onRefresh();
      }
    }
    if (paramuvx.jdField_a_of_type_Boolean) {
      localuwa.a().a();
    }
    veg.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "need sync comment size:%d", Integer.valueOf(this.jdField_a_of_type_Tlu.b.size()));
    if ((this.jdField_a_of_type_Tlu.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Tlu.b.size() > 0)) {
      localuwa.a().a(this.jdField_a_of_type_Tlu.b);
    }
    notifyResult(localuwp);
  }
  
  private void b(JobContext paramJobContext, uvx paramuvx)
  {
    List localList = paramuvx.jdField_a_of_type_JavaUtilList;
    veg.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info count:%d", Integer.valueOf(localList.size()));
    if (veg.a()) {
      veg.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info %s", localList);
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((uvs)((Iterator)localObject).next()).a);
    }
    localObject = new tlz();
    this.jdField_a_of_type_JavaUtilVector.add(localObject);
    tlt localtlt = new tlt(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localtlt);
    tlw localtlw = new tlw(localArrayList, true);
    this.jdField_a_of_type_JavaUtilVector.add(localtlw);
    tml localtml = new tml();
    this.jdField_a_of_type_JavaUtilVector.add(localtml);
    ((tlz)localObject).jdField_a_of_type_JavaUtilList = localList;
    syr.a().a((syv)localObject, new uwl(this, paramJobContext, paramuvx));
    syr.a().a(localtlt, new uwm(this, paramJobContext, paramuvx));
    syr.a().a(localtlw, new uwn(this, paramJobContext, paramuvx));
    localtml.jdField_a_of_type_JavaUtilList = localArrayList;
    syr.a().a(localtml, new uwo(this, paramJobContext, paramuvx));
  }
  
  protected void a(JobContext paramJobContext, uvx paramuvx)
  {
    Iterator localIterator = paramuvx.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    if (paramuvx.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (paramuvx.b)
      {
        paramJobContext = new uwp(new ErrorMessage());
        paramJobContext.c = paramuvx.jdField_a_of_type_Boolean;
        paramJobContext.jdField_a_of_type_Boolean = paramuvx.b;
        notifyResult(paramJobContext);
        return;
      }
      paramJobContext = new ErrorMessage(940001, "");
      paramJobContext.extraMsg = "data error no data";
      notifyError(paramJobContext);
      veg.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed id arg %s", paramJobContext);
      return;
    }
    b(paramJobContext, paramuvx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwk
 * JD-Core Version:    0.7.0.1
 */