import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class uvq
  implements upa
{
  uvq(uvp paramuvp, JobContext paramJobContext, uvr paramuvr) {}
  
  public void a(upb paramupb)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      veg.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.jdField_a_of_type_Uvr });
      return;
    }
    uvp.a(this.jdField_a_of_type_Uvp);
    veg.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(uvp.b(this.jdField_a_of_type_Uvp)), paramupb);
    if (paramupb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      uvp.a(this.jdField_a_of_type_Uvp).addAll(paramupb.jdField_a_of_type_JavaUtilList);
      if ((!paramupb.jdField_a_of_type_Boolean) && (uvp.b(this.jdField_a_of_type_Uvp) < 10))
      {
        veg.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(uvp.b(this.jdField_a_of_type_Uvp)));
        uvp.a(this.jdField_a_of_type_Uvp).c();
        return;
      }
      paramupb.jdField_a_of_type_JavaUtilList = uvp.a(this.jdField_a_of_type_Uvp);
      veg.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(uvp.a(this.jdField_a_of_type_Uvp).size()));
      uvp.a(this.jdField_a_of_type_Uvp, paramupb);
      return;
    }
    paramupb.jdField_a_of_type_JavaUtilList = uvp.a(this.jdField_a_of_type_Uvp);
    veg.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(uvp.a(this.jdField_a_of_type_Uvp).size()));
    uvp.b(this.jdField_a_of_type_Uvp, paramupb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvq
 * JD-Core Version:    0.7.0.1
 */