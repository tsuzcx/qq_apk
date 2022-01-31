import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class uiu
  implements uce
{
  uiu(uit paramuit, JobContext paramJobContext, uiv paramuiv) {}
  
  public void a(ucf paramucf)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      urk.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.jdField_a_of_type_Uiv });
      return;
    }
    uit.a(this.jdField_a_of_type_Uit);
    urk.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(uit.b(this.jdField_a_of_type_Uit)), paramucf);
    if (paramucf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      uit.a(this.jdField_a_of_type_Uit).addAll(paramucf.jdField_a_of_type_JavaUtilList);
      if ((!paramucf.jdField_a_of_type_Boolean) && (uit.b(this.jdField_a_of_type_Uit) < 10))
      {
        urk.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(uit.b(this.jdField_a_of_type_Uit)));
        uit.a(this.jdField_a_of_type_Uit).c();
        return;
      }
      paramucf.jdField_a_of_type_JavaUtilList = uit.a(this.jdField_a_of_type_Uit);
      urk.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(uit.a(this.jdField_a_of_type_Uit).size()));
      uit.a(this.jdField_a_of_type_Uit, paramucf);
      return;
    }
    paramucf.jdField_a_of_type_JavaUtilList = uit.a(this.jdField_a_of_type_Uit);
    urk.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(uit.a(this.jdField_a_of_type_Uit).size()));
    uit.b(this.jdField_a_of_type_Uit, paramucf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uiu
 * JD-Core Version:    0.7.0.1
 */