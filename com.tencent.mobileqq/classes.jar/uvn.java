import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class uvn
  implements uox
{
  uvn(uvm paramuvm, JobContext paramJobContext, uvo paramuvo) {}
  
  public void a(uoy paramuoy)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ved.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.jdField_a_of_type_Uvo });
      return;
    }
    uvm.a(this.jdField_a_of_type_Uvm);
    ved.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(uvm.b(this.jdField_a_of_type_Uvm)), paramuoy);
    if (paramuoy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      uvm.a(this.jdField_a_of_type_Uvm).addAll(paramuoy.jdField_a_of_type_JavaUtilList);
      if ((!paramuoy.jdField_a_of_type_Boolean) && (uvm.b(this.jdField_a_of_type_Uvm) < 10))
      {
        ved.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(uvm.b(this.jdField_a_of_type_Uvm)));
        uvm.a(this.jdField_a_of_type_Uvm).c();
        return;
      }
      paramuoy.jdField_a_of_type_JavaUtilList = uvm.a(this.jdField_a_of_type_Uvm);
      ved.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(uvm.a(this.jdField_a_of_type_Uvm).size()));
      uvm.a(this.jdField_a_of_type_Uvm, paramuoy);
      return;
    }
    paramuoy.jdField_a_of_type_JavaUtilList = uvm.a(this.jdField_a_of_type_Uvm);
    ved.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(uvm.a(this.jdField_a_of_type_Uvm).size()));
    uvm.b(this.jdField_a_of_type_Uvm, paramuoy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvn
 * JD-Core Version:    0.7.0.1
 */