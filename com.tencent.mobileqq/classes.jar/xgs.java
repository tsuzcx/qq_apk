import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.parallel.ParallelStream;

public class xgs
  extends JobSegment<xhh, xhh>
{
  private JobContext jdField_a_of_type_ComTribeAsyncAsyncJobContext;
  private ParallelStream jdField_a_of_type_ComTribeAsyncParallelParallelStream;
  private xhh jdField_a_of_type_Xhh;
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = ParallelStream.of(new xha(this), paramString);
    xng localxng1;
    xng localxng2;
    if (this.jdField_a_of_type_Xhh.a())
    {
      localxng1 = new xng(paramString, 2, "", 0);
      localxng2 = new xng(paramString, 2, "", 1);
    }
    for (this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new xgy(this, 0), paramString).map(new xgy(this, 1), paramString).map(new xgw(this), localxng1).map(new xgw(this), localxng2);; this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new xgy(this, -1), paramString).map(new xgw(this), localxng1))
    {
      this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.subscribe(new xgv(this));
      return;
      localxng1 = new xng(paramString, 2, "");
    }
  }
  
  protected void a(JobContext paramJobContext, xhh paramxhh)
  {
    if ((paramxhh == null) || (paramxhh.a == null) || (TextUtils.isEmpty(paramxhh.a.feedId)))
    {
      xvv.b("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed id is while request feed all info.");
      notifyError(new ErrorMessage(940001, "feed id is while request feed all info."));
      return;
    }
    this.jdField_a_of_type_ComTribeAsyncAsyncJobContext = paramJobContext;
    this.jdField_a_of_type_Xhh = paramxhh;
    a(paramxhh.a.feedId);
  }
  
  public void onCancel()
  {
    super.onCancel();
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgs
 * JD-Core Version:    0.7.0.1
 */