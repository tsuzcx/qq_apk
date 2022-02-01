import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class yca
  implements xvk
{
  yca(ybz paramybz, JobContext paramJobContext, ycb paramycb) {}
  
  public void a(xvl paramxvl)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ykq.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.jdField_a_of_type_Ycb });
      return;
    }
    ybz.a(this.jdField_a_of_type_Ybz);
    ykq.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(ybz.b(this.jdField_a_of_type_Ybz)), paramxvl);
    if (paramxvl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ybz.a(this.jdField_a_of_type_Ybz).addAll(paramxvl.jdField_a_of_type_JavaUtilList);
      if ((!paramxvl.jdField_a_of_type_Boolean) && (ybz.b(this.jdField_a_of_type_Ybz) < 10))
      {
        ykq.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(ybz.b(this.jdField_a_of_type_Ybz)));
        ybz.a(this.jdField_a_of_type_Ybz).c();
        return;
      }
      paramxvl.jdField_a_of_type_JavaUtilList = ybz.a(this.jdField_a_of_type_Ybz);
      ykq.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(ybz.a(this.jdField_a_of_type_Ybz).size()));
      ybz.a(this.jdField_a_of_type_Ybz, paramxvl);
      return;
    }
    paramxvl.jdField_a_of_type_JavaUtilList = ybz.a(this.jdField_a_of_type_Ybz);
    ykq.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(ybz.a(this.jdField_a_of_type_Ybz).size()));
    ybz.b(this.jdField_a_of_type_Ybz, paramxvl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yca
 * JD-Core Version:    0.7.0.1
 */