import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class qvb
  implements qrl.a
{
  qvb(quy.b paramb, JobContext paramJobContext, qvc paramqvc) {}
  
  public void b(qrl.b paramb)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ram.w("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.b });
      return;
    }
    quy.b.a(this.jdField_a_of_type_Quy$b);
    ram.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(quy.b.b(this.jdField_a_of_type_Quy$b)), paramb);
    if (paramb.b.isSuccess())
    {
      quy.b.a(this.jdField_a_of_type_Quy$b).addAll(paramb.nh);
      if ((!paramb.isEnd) && (quy.b.b(this.jdField_a_of_type_Quy$b) < 10))
      {
        ram.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(quy.b.b(this.jdField_a_of_type_Quy$b)));
        quy.b.a(this.jdField_a_of_type_Quy$b).aPh();
        return;
      }
      paramb.nh = quy.b.a(this.jdField_a_of_type_Quy$b);
      ram.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(quy.b.a(this.jdField_a_of_type_Quy$b).size()));
      quy.b.a(this.jdField_a_of_type_Quy$b, paramb);
      return;
    }
    paramb.nh = quy.b.a(this.jdField_a_of_type_Quy$b);
    ram.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(quy.b.a(this.jdField_a_of_type_Quy$b).size()));
    quy.b.b(this.jdField_a_of_type_Quy$b, paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvb
 * JD-Core Version:    0.7.0.1
 */