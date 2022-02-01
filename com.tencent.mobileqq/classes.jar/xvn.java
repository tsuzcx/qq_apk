import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.parallel.ParallelStream;

public class xvn
  extends JobSegment<xwc, xwc>
{
  private JobContext jdField_a_of_type_ComTribeAsyncAsyncJobContext;
  private ParallelStream jdField_a_of_type_ComTribeAsyncParallelParallelStream;
  private xwc jdField_a_of_type_Xwc;
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = ParallelStream.of(new xvv(this), paramString);
    ycb localycb1;
    ycb localycb2;
    if (this.jdField_a_of_type_Xwc.a())
    {
      localycb1 = new ycb(paramString, 2, "", 0);
      localycb2 = new ycb(paramString, 2, "", 1);
    }
    for (this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new xvt(this, 0), paramString).map(new xvt(this, 1), paramString).map(new xvr(this), localycb1).map(new xvr(this), localycb2);; this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new xvt(this, -1), paramString).map(new xvr(this), localycb1))
    {
      this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.subscribe(new xvq(this));
      return;
      localycb1 = new ycb(paramString, 2, "");
    }
  }
  
  protected void a(JobContext paramJobContext, xwc paramxwc)
  {
    if ((paramxwc == null) || (paramxwc.a == null) || (TextUtils.isEmpty(paramxwc.a.feedId)))
    {
      ykq.b("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed id is while request feed all info.");
      notifyError(new ErrorMessage(940001, "feed id is while request feed all info."));
      return;
    }
    this.jdField_a_of_type_ComTribeAsyncAsyncJobContext = paramJobContext;
    this.jdField_a_of_type_Xwc = paramxwc;
    a(paramxwc.a.feedId);
  }
  
  public void onCancel()
  {
    super.onCancel();
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvn
 * JD-Core Version:    0.7.0.1
 */