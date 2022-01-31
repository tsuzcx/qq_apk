import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class wkf
  implements wdp
{
  wkf(wke paramwke, JobContext paramJobContext, wkg paramwkg) {}
  
  public void a(wdq paramwdq)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wsv.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.jdField_a_of_type_Wkg });
      return;
    }
    wke.a(this.jdField_a_of_type_Wke);
    wsv.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(wke.b(this.jdField_a_of_type_Wke)), paramwdq);
    if (paramwdq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      wke.a(this.jdField_a_of_type_Wke).addAll(paramwdq.jdField_a_of_type_JavaUtilList);
      if ((!paramwdq.jdField_a_of_type_Boolean) && (wke.b(this.jdField_a_of_type_Wke) < 10))
      {
        wsv.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(wke.b(this.jdField_a_of_type_Wke)));
        wke.a(this.jdField_a_of_type_Wke).c();
        return;
      }
      paramwdq.jdField_a_of_type_JavaUtilList = wke.a(this.jdField_a_of_type_Wke);
      wsv.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(wke.a(this.jdField_a_of_type_Wke).size()));
      wke.a(this.jdField_a_of_type_Wke, paramwdq);
      return;
    }
    paramwdq.jdField_a_of_type_JavaUtilList = wke.a(this.jdField_a_of_type_Wke);
    wsv.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(wke.a(this.jdField_a_of_type_Wke).size()));
    wke.b(this.jdField_a_of_type_Wke, paramwdq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkf
 * JD-Core Version:    0.7.0.1
 */