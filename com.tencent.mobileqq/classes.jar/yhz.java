import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class yhz
  implements ybj
{
  yhz(yhy paramyhy, JobContext paramJobContext, yia paramyia) {}
  
  public void a(ybk paramybk)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yqp.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.jdField_a_of_type_Yia });
      return;
    }
    yhy.a(this.jdField_a_of_type_Yhy);
    yqp.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(yhy.b(this.jdField_a_of_type_Yhy)), paramybk);
    if (paramybk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      yhy.a(this.jdField_a_of_type_Yhy).addAll(paramybk.jdField_a_of_type_JavaUtilList);
      if ((!paramybk.jdField_a_of_type_Boolean) && (yhy.b(this.jdField_a_of_type_Yhy) < 10))
      {
        yqp.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(yhy.b(this.jdField_a_of_type_Yhy)));
        yhy.a(this.jdField_a_of_type_Yhy).c();
        return;
      }
      paramybk.jdField_a_of_type_JavaUtilList = yhy.a(this.jdField_a_of_type_Yhy);
      yqp.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(yhy.a(this.jdField_a_of_type_Yhy).size()));
      yhy.a(this.jdField_a_of_type_Yhy, paramybk);
      return;
    }
    paramybk.jdField_a_of_type_JavaUtilList = yhy.a(this.jdField_a_of_type_Yhy);
    yqp.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(yhy.a(this.jdField_a_of_type_Yhy).size()));
    yhy.b(this.jdField_a_of_type_Yhy, paramybk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhz
 * JD-Core Version:    0.7.0.1
 */