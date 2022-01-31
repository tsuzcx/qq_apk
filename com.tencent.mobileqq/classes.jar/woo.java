import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class woo
  implements why
{
  woo(won paramwon, JobContext paramJobContext, wop paramwop) {}
  
  public void a(whz paramwhz)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wxe.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.jdField_a_of_type_Wop });
      return;
    }
    won.a(this.jdField_a_of_type_Won);
    wxe.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(won.b(this.jdField_a_of_type_Won)), paramwhz);
    if (paramwhz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      won.a(this.jdField_a_of_type_Won).addAll(paramwhz.jdField_a_of_type_JavaUtilList);
      if ((!paramwhz.jdField_a_of_type_Boolean) && (won.b(this.jdField_a_of_type_Won) < 10))
      {
        wxe.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(won.b(this.jdField_a_of_type_Won)));
        won.a(this.jdField_a_of_type_Won).c();
        return;
      }
      paramwhz.jdField_a_of_type_JavaUtilList = won.a(this.jdField_a_of_type_Won);
      wxe.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(won.a(this.jdField_a_of_type_Won).size()));
      won.a(this.jdField_a_of_type_Won, paramwhz);
      return;
    }
    paramwhz.jdField_a_of_type_JavaUtilList = won.a(this.jdField_a_of_type_Won);
    wxe.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(won.a(this.jdField_a_of_type_Won).size()));
    won.b(this.jdField_a_of_type_Won, paramwhz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     woo
 * JD-Core Version:    0.7.0.1
 */