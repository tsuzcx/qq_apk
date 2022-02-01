import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.parallel.ParallelStream;

public class ybm
  extends JobSegment<ycb, ycb>
{
  private JobContext jdField_a_of_type_ComTribeAsyncAsyncJobContext;
  private ParallelStream jdField_a_of_type_ComTribeAsyncParallelParallelStream;
  private ycb jdField_a_of_type_Ycb;
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = ParallelStream.of(new ybu(this), paramString);
    yia localyia1;
    yia localyia2;
    if (this.jdField_a_of_type_Ycb.a())
    {
      localyia1 = new yia(paramString, 2, "", 0);
      localyia2 = new yia(paramString, 2, "", 1);
    }
    for (this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new ybs(this, 0), paramString).map(new ybs(this, 1), paramString).map(new ybq(this), localyia1).map(new ybq(this), localyia2);; this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new ybs(this, -1), paramString).map(new ybq(this), localyia1))
    {
      this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.subscribe(new ybp(this));
      return;
      localyia1 = new yia(paramString, 2, "");
    }
  }
  
  protected void a(JobContext paramJobContext, ycb paramycb)
  {
    if ((paramycb == null) || (paramycb.a == null) || (TextUtils.isEmpty(paramycb.a.feedId)))
    {
      yqp.b("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed id is while request feed all info.");
      notifyError(new ErrorMessage(940001, "feed id is while request feed all info."));
      return;
    }
    this.jdField_a_of_type_ComTribeAsyncAsyncJobContext = paramJobContext;
    this.jdField_a_of_type_Ycb = paramycb;
    a(paramycb.a.feedId);
  }
  
  public void onCancel()
  {
    super.onCancel();
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybm
 * JD-Core Version:    0.7.0.1
 */