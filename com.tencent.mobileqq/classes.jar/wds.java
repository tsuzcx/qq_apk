import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.parallel.ParallelStream;

public class wds
  extends JobSegment<weh, weh>
{
  private JobContext jdField_a_of_type_ComTribeAsyncAsyncJobContext;
  private ParallelStream jdField_a_of_type_ComTribeAsyncParallelParallelStream;
  private weh jdField_a_of_type_Weh;
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = ParallelStream.of(new wea(this), paramString);
    wkg localwkg1;
    wkg localwkg2;
    if (this.jdField_a_of_type_Weh.a())
    {
      localwkg1 = new wkg(paramString, 2, "", 0);
      localwkg2 = new wkg(paramString, 2, "", 1);
    }
    for (this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new wdy(this, 0), paramString).map(new wdy(this, 1), paramString).map(new wdw(this), localwkg1).map(new wdw(this), localwkg2);; this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new wdy(this, -1), paramString).map(new wdw(this), localwkg1))
    {
      this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.subscribe(new wdv(this));
      return;
      localwkg1 = new wkg(paramString, 2, "");
    }
  }
  
  protected void a(JobContext paramJobContext, weh paramweh)
  {
    if ((paramweh == null) || (paramweh.a == null) || (TextUtils.isEmpty(paramweh.a.feedId)))
    {
      wsv.b("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed id is while request feed all info.");
      notifyError(new ErrorMessage(940001, "feed id is while request feed all info."));
      return;
    }
    this.jdField_a_of_type_ComTribeAsyncAsyncJobContext = paramJobContext;
    this.jdField_a_of_type_Weh = paramweh;
    a(paramweh.a.feedId);
  }
  
  public void onCancel()
  {
    super.onCancel();
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wds
 * JD-Core Version:    0.7.0.1
 */