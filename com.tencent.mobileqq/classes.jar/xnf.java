import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class xnf
  implements xgp
{
  xnf(xne paramxne, JobContext paramJobContext, xng paramxng) {}
  
  public void a(xgq paramxgq)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      xvv.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.jdField_a_of_type_Xng });
      return;
    }
    xne.a(this.jdField_a_of_type_Xne);
    xvv.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(xne.b(this.jdField_a_of_type_Xne)), paramxgq);
    if (paramxgq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      xne.a(this.jdField_a_of_type_Xne).addAll(paramxgq.jdField_a_of_type_JavaUtilList);
      if ((!paramxgq.jdField_a_of_type_Boolean) && (xne.b(this.jdField_a_of_type_Xne) < 10))
      {
        xvv.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(xne.b(this.jdField_a_of_type_Xne)));
        xne.a(this.jdField_a_of_type_Xne).c();
        return;
      }
      paramxgq.jdField_a_of_type_JavaUtilList = xne.a(this.jdField_a_of_type_Xne);
      xvv.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(xne.a(this.jdField_a_of_type_Xne).size()));
      xne.a(this.jdField_a_of_type_Xne, paramxgq);
      return;
    }
    paramxgq.jdField_a_of_type_JavaUtilList = xne.a(this.jdField_a_of_type_Xne);
    xvv.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(xne.a(this.jdField_a_of_type_Xne).size()));
    xne.b(this.jdField_a_of_type_Xne, paramxgq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnf
 * JD-Core Version:    0.7.0.1
 */