import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.parallel.ParallelJobSegment;
import com.tribe.async.parallel.ParallelStream;
import com.tribe.async.parallel.SimpleParallelObserver;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class qro
  extends JobSegment<qru, qru>
{
  private ParallelStream jdField_a_of_type_ComTribeAsyncParallelParallelStream;
  private qru jdField_a_of_type_Qru;
  private JobContext mJobContext;
  
  private void rU(String paramString)
  {
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = ParallelStream.of(new qro.f(), paramString);
    qvc localqvc1;
    qvc localqvc2;
    if (this.jdField_a_of_type_Qru.Kl())
    {
      localqvc1 = new qvc(paramString, 2, "", 0);
      localqvc2 = new qvc(paramString, 2, "", 1);
    }
    for (this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new qro.e(0), paramString).map(new qro.e(1), paramString).map(new qro.d(), localqvc1).map(new qro.d(), localqvc2);; this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new qro.e(-1), paramString).map(new qro.d(), localqvc1))
    {
      this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.subscribe(new qro.c());
      return;
      localqvc1 = new qvc(paramString, 2, "");
    }
  }
  
  protected void a(JobContext paramJobContext, qru paramqru)
  {
    if ((paramqru == null) || (paramqru.d == null) || (TextUtils.isEmpty(paramqru.d.feedId)))
    {
      ram.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed id is while request feed all info.");
      notifyError(new ErrorMessage(940001, "feed id is while request feed all info."));
      return;
    }
    this.mJobContext = paramJobContext;
    this.jdField_a_of_type_Qru = paramqru;
    rU(paramqru.d.feedId);
  }
  
  public void onCancel()
  {
    super.onCancel();
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.cancel();
  }
  
  public static class a
  {
    public boolean aEW;
    public String ayn;
    public int commentCount;
    public boolean isOpen;
    public List<CommentEntry> od;
    
    public a(boolean paramBoolean1, List<CommentEntry> paramList, int paramInt, boolean paramBoolean2, String paramString)
    {
      this.isOpen = paramBoolean1;
      this.od = paramList;
      this.commentCount = paramInt;
      this.aEW = paramBoolean2;
      this.ayn = paramString;
    }
  }
  
  public static class b
  {
    public int blo;
    public boolean isOpen;
    public int likeCount;
    public List<LikeEntry> oe;
    
    public b(boolean paramBoolean, List<LikeEntry> paramList, int paramInt1, int paramInt2)
    {
      this.isOpen = paramBoolean;
      this.oe = paramList;
      this.likeCount = paramInt1;
      this.blo = paramInt2;
    }
  }
  
  public class c
    extends SimpleParallelObserver
  {
    c() {}
    
    public void onAllFunctionComplete(boolean paramBoolean)
    {
      super.onAllFunctionComplete(paramBoolean);
      ThreadManager.getUIHandler().post(new DetailFeedAllInfoPullSegment.Observer.1(this, paramBoolean));
    }
  }
  
  class d
    extends ParallelJobSegment<qvc, qro.a>
  {
    public d()
    {
      this("RequestCommentListSegment");
    }
    
    public d(String paramString)
    {
      super();
    }
    
    protected void a(JobContext paramJobContext, qvc paramqvc)
    {
      pyt localpyt = new pyt();
      localpyt.a = paramqvc;
      ppv.a().a(localpyt, new qrp(this, paramJobContext, paramqvc));
    }
  }
  
  class e
    extends ParallelJobSegment<String, qro.b>
  {
    public int type = -1;
    
    public e(int paramInt)
    {
      super();
      this.type = paramInt;
    }
    
    protected void a(JobContext paramJobContext, String paramString)
    {
      qrv.b localb = new qrv.b();
      localb.feedId = paramString;
      localb.isOpen = true;
      if (this.type != -1) {
        localb.type = this.type;
      }
      ppv.a().a(localb, new qrq(this, paramJobContext, paramString));
    }
  }
  
  class f
    extends ParallelJobSegment<String, Integer>
  {
    public f()
    {
      this("RequestViewCountSegment");
    }
    
    public f(String paramString)
    {
      super();
    }
    
    protected void a(JobContext paramJobContext, String paramString)
    {
      pyu localpyu = new pyu();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      localpyu.no = localArrayList;
      ppv.a().a(localpyu, new qrr(this, paramJobContext, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qro
 * JD-Core Version:    0.7.0.1
 */