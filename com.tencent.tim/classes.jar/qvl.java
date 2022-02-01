import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class qvl
  extends JobSegment<qve.c, qvq>
{
  private pyi.a jdField_a_of_type_Pyi$a;
  private pyj.a jdField_a_of_type_Pyj$a;
  private pyk.a jdField_a_of_type_Pyk$a;
  private qag jdField_a_of_type_Qag;
  private Vector<ppw> l = new Vector(5);
  
  private ptp a(int paramInt, qux paramqux)
  {
    List localList = this.jdField_a_of_type_Qag.nB;
    if (paramInt < localList.size()) {}
    for (ptp localptp = (ptp)localList.get(paramInt);; localptp = null)
    {
      if ((localptp != null) && (localptp.feedId.equals(paramqux.c.feedId))) {
        return localptp;
      }
      localptp = new ptp();
      localptp.feedId = paramqux.c.feedId;
      paramInt = localList.indexOf(localptp);
      if (paramInt >= 0) {
        return (ptp)localList.get(paramInt);
      }
      ram.w("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "can't not find feed like for id:%s", new Object[] { paramqux.c.feedId });
      return null;
    }
  }
  
  private void a(qve.c paramc)
  {
    boolean bool3 = true;
    int i = 0;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_Pyk$a != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Pyi$a == null) {
        break label68;
      }
      bool2 = true;
      label24:
      if (this.jdField_a_of_type_Pyj$a == null) {
        break label74;
      }
    }
    for (;;)
    {
      ram.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed info resp basic info:%b, comment %b, like %b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
      if (this.l.isEmpty()) {
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
    if ((this.jdField_a_of_type_Pyk$a == null) || (this.jdField_a_of_type_Pyk$a.errorCode != 0))
    {
      notifyError(new ErrorMessage(this.jdField_a_of_type_Pyk$a.errorCode, this.jdField_a_of_type_Pyk$a.errorMsg));
      return;
    }
    qvf localqvf = (qvf)psx.a(11);
    qvq localqvq = new qvq(new ErrorMessage());
    localqvq.isFirstPage = paramc.aFJ;
    localqvq.isEnd = paramc.mIsEnd;
    localqvq.np = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Pyk$a.nm.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (qwa)((Iterator)localObject1).next();
      localqvq.np.add(((qwa)localObject2).c.feedId);
    }
    localqvq.or = this.jdField_a_of_type_Pyk$a.nm;
    localObject1 = this.jdField_a_of_type_Pyk$a.nm.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (qwa)((Iterator)localObject1).next();
      ((qwa)localObject2).a(i, this.jdField_a_of_type_Pyk$a, this.jdField_a_of_type_Pyi$a, this.jdField_a_of_type_Pyj$a);
      if ((localObject2 instanceof qux))
      {
        localObject2 = (qux)localObject2;
        if (this.jdField_a_of_type_Qag != null)
        {
          localObject3 = a(i, (qux)localObject2);
          if (localObject3 != null)
          {
            ((qux)localObject2).a().mViewTotalTime = ((ptp)localObject3).bkm;
            ram.b("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "get feature feedId=%s, view total=%d", ((qux)localObject2).c.feedId, Long.valueOf(((qux)localObject2).a().mViewTotalTime));
          }
        }
      }
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_Pyk$a.nm.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((qwa)((Iterator)localObject1).next()).bra();
    }
    localObject1 = new ArrayList(localqvq.or.size());
    Object localObject2 = localqvq.or.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((qwa)((Iterator)localObject2).next()).c);
    }
    localObject1 = localqvf.au((List)localObject1);
    localObject2 = localqvq.or.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (qwa)((Iterator)localObject2).next();
      i = ((List)localObject1).indexOf(((qwa)localObject3).c);
      if (i >= 0)
      {
        ((qwa)localObject3).c = ((FeedItem)((List)localObject1).get(i));
        ((qwa)localObject3).c.onRefresh();
      }
    }
    if (paramc.aFJ) {
      localqvf.a().brc();
    }
    ram.b("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "need sync comment size:%d", Integer.valueOf(this.jdField_a_of_type_Pyi$a.ng.size()));
    if ((this.jdField_a_of_type_Pyi$a.errorCode == 0) && (this.jdField_a_of_type_Pyi$a.ng.size() > 0)) {
      localqvf.a().eD(this.jdField_a_of_type_Pyi$a.ng);
    }
    notifyResult(localqvq);
  }
  
  private void b(JobContext paramJobContext, qve.c paramc)
  {
    List localList = paramc.oq;
    ram.b("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info count:%d", Integer.valueOf(localList.size()));
    if (ram.isColorLevel()) {
      ram.b("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info %s", localList);
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((qvd)((Iterator)localObject).next()).mFeedId);
    }
    localObject = new pyk();
    this.l.add(localObject);
    pyi localpyi = new pyi(localArrayList, true);
    this.l.add(localpyi);
    pyj localpyj = new pyj(localArrayList, true);
    this.l.add(localpyj);
    pyu localpyu = new pyu();
    this.l.add(localpyu);
    ((pyk)localObject).nk = localList;
    ppv.a().a((ppw)localObject, new qvm(this, paramJobContext, paramc));
    ppv.a().a(localpyi, new qvn(this, paramJobContext, paramc));
    ppv.a().a(localpyj, new qvo(this, paramJobContext, paramc));
    localpyu.no = localArrayList;
    ppv.a().a(localpyu, new qvp(this, paramJobContext, paramc));
  }
  
  protected void a(JobContext paramJobContext, qve.c paramc)
  {
    Iterator localIterator = paramc.oq.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    if (paramc.oq.isEmpty())
    {
      if (paramc.mIsEnd)
      {
        paramJobContext = new qvq(new ErrorMessage());
        paramJobContext.isFirstPage = paramc.aFJ;
        paramJobContext.isEnd = paramc.mIsEnd;
        notifyResult(paramJobContext);
        return;
      }
      paramJobContext = new ErrorMessage(940001, "");
      paramJobContext.extraMsg = "data error no data";
      notifyError(paramJobContext);
      ram.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed id arg %s", paramJobContext);
      return;
    }
    b(paramJobContext, paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvl
 * JD-Core Version:    0.7.0.1
 */