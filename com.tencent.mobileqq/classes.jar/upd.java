import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.parallel.ParallelStream;

public class upd
  extends JobSegment<ups, ups>
{
  private JobContext jdField_a_of_type_ComTribeAsyncAsyncJobContext;
  private ParallelStream jdField_a_of_type_ComTribeAsyncParallelParallelStream;
  private ups jdField_a_of_type_Ups;
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = ParallelStream.of(new upl(this), paramString);
    uvr localuvr1;
    uvr localuvr2;
    if (this.jdField_a_of_type_Ups.a())
    {
      localuvr1 = new uvr(paramString, 2, "", 0);
      localuvr2 = new uvr(paramString, 2, "", 1);
    }
    for (this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new upj(this, 0), paramString).map(new upj(this, 1), paramString).map(new uph(this), localuvr1).map(new uph(this), localuvr2);; this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new upj(this, -1), paramString).map(new uph(this), localuvr1))
    {
      this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.subscribe(new upg(this));
      return;
      localuvr1 = new uvr(paramString, 2, "");
    }
  }
  
  protected void a(JobContext paramJobContext, ups paramups)
  {
    if ((paramups == null) || (paramups.a == null) || (TextUtils.isEmpty(paramups.a.feedId)))
    {
      veg.b("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed id is while request feed all info.");
      notifyError(new ErrorMessage(940001, "feed id is while request feed all info."));
      return;
    }
    this.jdField_a_of_type_ComTribeAsyncAsyncJobContext = paramJobContext;
    this.jdField_a_of_type_Ups = paramups;
    a(paramups.a.feedId);
  }
  
  public void onCancel()
  {
    super.onCancel();
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upd
 * JD-Core Version:    0.7.0.1
 */