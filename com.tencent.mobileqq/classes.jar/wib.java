import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.parallel.ParallelStream;

public class wib
  extends JobSegment<wiq, wiq>
{
  private JobContext jdField_a_of_type_ComTribeAsyncAsyncJobContext;
  private ParallelStream jdField_a_of_type_ComTribeAsyncParallelParallelStream;
  private wiq jdField_a_of_type_Wiq;
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = ParallelStream.of(new wij(this), paramString);
    wop localwop1;
    wop localwop2;
    if (this.jdField_a_of_type_Wiq.a())
    {
      localwop1 = new wop(paramString, 2, "", 0);
      localwop2 = new wop(paramString, 2, "", 1);
    }
    for (this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new wih(this, 0), paramString).map(new wih(this, 1), paramString).map(new wif(this), localwop1).map(new wif(this), localwop2);; this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new wih(this, -1), paramString).map(new wif(this), localwop1))
    {
      this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.subscribe(new wie(this));
      return;
      localwop1 = new wop(paramString, 2, "");
    }
  }
  
  protected void a(JobContext paramJobContext, wiq paramwiq)
  {
    if ((paramwiq == null) || (paramwiq.a == null) || (TextUtils.isEmpty(paramwiq.a.feedId)))
    {
      wxe.b("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed id is while request feed all info.");
      notifyError(new ErrorMessage(940001, "feed id is while request feed all info."));
      return;
    }
    this.jdField_a_of_type_ComTribeAsyncAsyncJobContext = paramJobContext;
    this.jdField_a_of_type_Wiq = paramwiq;
    a(paramwiq.a.feedId);
  }
  
  public void onCancel()
  {
    super.onCancel();
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wib
 * JD-Core Version:    0.7.0.1
 */