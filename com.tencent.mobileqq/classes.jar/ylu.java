import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class ylu
  implements yfe
{
  ylu(ylt paramylt, JobContext paramJobContext, ylv paramylv) {}
  
  public void a(yff paramyff)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yuk.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.jdField_a_of_type_Ylv });
      return;
    }
    ylt.a(this.jdField_a_of_type_Ylt);
    yuk.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(ylt.b(this.jdField_a_of_type_Ylt)), paramyff);
    if (paramyff.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ylt.a(this.jdField_a_of_type_Ylt).addAll(paramyff.jdField_a_of_type_JavaUtilList);
      if ((!paramyff.jdField_a_of_type_Boolean) && (ylt.b(this.jdField_a_of_type_Ylt) < 10))
      {
        yuk.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(ylt.b(this.jdField_a_of_type_Ylt)));
        ylt.a(this.jdField_a_of_type_Ylt).c();
        return;
      }
      paramyff.jdField_a_of_type_JavaUtilList = ylt.a(this.jdField_a_of_type_Ylt);
      yuk.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(ylt.a(this.jdField_a_of_type_Ylt).size()));
      ylt.a(this.jdField_a_of_type_Ylt, paramyff);
      return;
    }
    paramyff.jdField_a_of_type_JavaUtilList = ylt.a(this.jdField_a_of_type_Ylt);
    yuk.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(ylt.a(this.jdField_a_of_type_Ylt).size()));
    ylt.b(this.jdField_a_of_type_Ylt, paramyff);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylu
 * JD-Core Version:    0.7.0.1
 */