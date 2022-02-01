import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

public class yfc
  extends wzm
  implements woy<xco, xcp>
{
  private final String jdField_a_of_type_JavaLangString;
  private final yfe jdField_a_of_type_Yfe;
  private final ylv jdField_a_of_type_Ylv;
  private boolean c;
  
  public yfc(ylv paramylv, @NonNull String paramString)
  {
    this.jdField_a_of_type_Ylv = paramylv;
    this.jdField_a_of_type_Yfe = null;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public yfc(ylv paramylv, @NonNull yfe paramyfe)
  {
    this.jdField_a_of_type_Ylv = paramylv;
    this.jdField_a_of_type_Yfe = paramyfe;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a(yff paramyff)
  {
    if (this.jdField_a_of_type_Yfe == null)
    {
      wjj.a().dispatch(this.jdField_a_of_type_JavaLangString, paramyff);
      return;
    }
    this.jdField_a_of_type_Yfe.a(paramyff);
  }
  
  private void e()
  {
    xco localxco = new xco();
    localxco.jdField_a_of_type_Ylv = this.jdField_a_of_type_Ylv;
    wow.a().a(localxco, this);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.c) {
      return;
    }
    this.jdField_a_of_type_Ylv.jdField_b_of_type_JavaLangString = "";
    e();
  }
  
  public void a(@NonNull xco paramxco, @Nullable xcp paramxcp, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.a("Q.qqstory.detail:CommentListPageLoader", "get comment list return:%s", paramErrorMessage.toString());
    if (this.c)
    {
      yuk.c("Q.qqstory.detail:CommentListPageLoader", "don't nothing after terminate");
      return;
    }
    yff localyff = new yff(paramErrorMessage, this.jdField_a_of_type_Ylv.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ylv.jdField_a_of_type_Int);
    localyff.d = this.jdField_a_of_type_Boolean;
    localyff.jdField_a_of_type_Int = this.jdField_a_of_type_Ylv.jdField_b_of_type_Int;
    if ((paramxcp == null) || (paramErrorMessage.isFail()))
    {
      a(localyff);
      return;
    }
    yuk.a("Q.qqstory.detail:CommentListPageLoader", "comment respond from cookie:%s to %s", paramxco.jdField_a_of_type_Ylv.jdField_b_of_type_JavaLangString, paramxcp.jdField_a_of_type_JavaLangString);
    boolean bool = TextUtils.isEmpty(paramxco.jdField_a_of_type_Ylv.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Ylv.jdField_b_of_type_JavaLangString = paramxcp.jdField_a_of_type_JavaLangString;
    localyff.jdField_a_of_type_JavaUtilList = paramxcp.jdField_a_of_type_JavaUtilList;
    localyff.jdField_b_of_type_Int = paramxcp.jdField_b_of_type_Int;
    localyff.c = bool;
    localyff.jdField_a_of_type_Boolean = paramxcp.jdField_a_of_type_Boolean;
    localyff.jdField_b_of_type_JavaLangString = paramxcp.jdField_a_of_type_JavaLangString;
    if ((!paramxcp.jdField_a_of_type_Boolean) && (paramxcp.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      localyff.jdField_a_of_type_Boolean = true;
      yuk.d("Q.qqstory.detail:CommentListPageLoader", "comment pull should be end!!!!!!!!!!!!");
    }
    try
    {
      this.b = true;
      a(localyff);
      yuk.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from network: %s", localyff);
      paramxco = new yfd(this, "Q.qqstory.detail:CommentListPageLoader", localyff, bool);
      Bosses.get().postJob(paramxco);
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Ylv.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    super.c();
    if (this.c)
    {
      znw.a("don't call this method after terminate", new Object[0]);
      return;
    }
    e();
  }
  
  public void d()
  {
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfc
 * JD-Core Version:    0.7.0.1
 */