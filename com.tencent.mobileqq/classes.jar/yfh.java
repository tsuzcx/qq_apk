import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.parallel.ParallelStream;

public class yfh
  extends JobSegment<yfw, yfw>
{
  private JobContext jdField_a_of_type_ComTribeAsyncAsyncJobContext;
  private ParallelStream jdField_a_of_type_ComTribeAsyncParallelParallelStream;
  private yfw jdField_a_of_type_Yfw;
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = ParallelStream.of(new yfp(this), paramString);
    ylv localylv1;
    ylv localylv2;
    if (this.jdField_a_of_type_Yfw.a())
    {
      localylv1 = new ylv(paramString, 2, "", 0);
      localylv2 = new ylv(paramString, 2, "", 1);
    }
    for (this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new yfn(this, 0), paramString).map(new yfn(this, 1), paramString).map(new yfl(this), localylv1).map(new yfl(this), localylv2);; this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new yfn(this, -1), paramString).map(new yfl(this), localylv1))
    {
      this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.subscribe(new yfk(this));
      return;
      localylv1 = new ylv(paramString, 2, "");
    }
  }
  
  protected void a(JobContext paramJobContext, yfw paramyfw)
  {
    if ((paramyfw == null) || (paramyfw.a == null) || (TextUtils.isEmpty(paramyfw.a.feedId)))
    {
      yuk.b("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed id is while request feed all info.");
      notifyError(new ErrorMessage(940001, "feed id is while request feed all info."));
      return;
    }
    this.jdField_a_of_type_ComTribeAsyncAsyncJobContext = paramJobContext;
    this.jdField_a_of_type_Yfw = paramyfw;
    a(paramyfw.a.feedId);
  }
  
  public void onCancel()
  {
    super.onCancel();
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfh
 * JD-Core Version:    0.7.0.1
 */