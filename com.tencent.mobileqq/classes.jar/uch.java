import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.parallel.ParallelStream;

public class uch
  extends JobSegment<ucw, ucw>
{
  private JobContext jdField_a_of_type_ComTribeAsyncAsyncJobContext;
  private ParallelStream jdField_a_of_type_ComTribeAsyncParallelParallelStream;
  private ucw jdField_a_of_type_Ucw;
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = ParallelStream.of(new ucp(this), paramString);
    uiv localuiv1;
    uiv localuiv2;
    if (this.jdField_a_of_type_Ucw.a())
    {
      localuiv1 = new uiv(paramString, 2, "", 0);
      localuiv2 = new uiv(paramString, 2, "", 1);
    }
    for (this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new ucn(this, 0), paramString).map(new ucn(this, 1), paramString).map(new ucl(this), localuiv1).map(new ucl(this), localuiv2);; this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new ucn(this, -1), paramString).map(new ucl(this), localuiv1))
    {
      this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.subscribe(new uck(this));
      return;
      localuiv1 = new uiv(paramString, 2, "");
    }
  }
  
  protected void a(JobContext paramJobContext, ucw paramucw)
  {
    if ((paramucw == null) || (paramucw.a == null) || (TextUtils.isEmpty(paramucw.a.feedId)))
    {
      urk.b("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed id is while request feed all info.");
      notifyError(new ErrorMessage(940001, "feed id is while request feed all info."));
      return;
    }
    this.jdField_a_of_type_ComTribeAsyncAsyncJobContext = paramJobContext;
    this.jdField_a_of_type_Ucw = paramucw;
    a(paramucw.a.feedId);
  }
  
  public void onCancel()
  {
    super.onCancel();
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uch
 * JD-Core Version:    0.7.0.1
 */