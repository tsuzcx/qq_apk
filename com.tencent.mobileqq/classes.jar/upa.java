import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.parallel.ParallelStream;

public class upa
  extends JobSegment<upp, upp>
{
  private JobContext jdField_a_of_type_ComTribeAsyncAsyncJobContext;
  private ParallelStream jdField_a_of_type_ComTribeAsyncParallelParallelStream;
  private upp jdField_a_of_type_Upp;
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = ParallelStream.of(new upi(this), paramString);
    uvo localuvo1;
    uvo localuvo2;
    if (this.jdField_a_of_type_Upp.a())
    {
      localuvo1 = new uvo(paramString, 2, "", 0);
      localuvo2 = new uvo(paramString, 2, "", 1);
    }
    for (this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new upg(this, 0), paramString).map(new upg(this, 1), paramString).map(new upe(this), localuvo1).map(new upe(this), localuvo2);; this.jdField_a_of_type_ComTribeAsyncParallelParallelStream = this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.map(new upg(this, -1), paramString).map(new upe(this), localuvo1))
    {
      this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.subscribe(new upd(this));
      return;
      localuvo1 = new uvo(paramString, 2, "");
    }
  }
  
  protected void a(JobContext paramJobContext, upp paramupp)
  {
    if ((paramupp == null) || (paramupp.a == null) || (TextUtils.isEmpty(paramupp.a.feedId)))
    {
      ved.b("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed id is while request feed all info.");
      notifyError(new ErrorMessage(940001, "feed id is while request feed all info."));
      return;
    }
    this.jdField_a_of_type_ComTribeAsyncAsyncJobContext = paramJobContext;
    this.jdField_a_of_type_Upp = paramupp;
    a(paramupp.a.feedId);
  }
  
  public void onCancel()
  {
    super.onCancel();
    this.jdField_a_of_type_ComTribeAsyncParallelParallelStream.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upa
 * JD-Core Version:    0.7.0.1
 */