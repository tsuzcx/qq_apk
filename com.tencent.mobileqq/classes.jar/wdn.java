import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

public class wdn
  extends uxw
  implements uni<vay, vaz>
{
  private final String jdField_a_of_type_JavaLangString;
  private final wdp jdField_a_of_type_Wdp;
  private final wkg jdField_a_of_type_Wkg;
  private boolean c;
  
  public wdn(wkg paramwkg, @NonNull String paramString)
  {
    this.jdField_a_of_type_Wkg = paramwkg;
    this.jdField_a_of_type_Wdp = null;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public wdn(wkg paramwkg, @NonNull wdp paramwdp)
  {
    this.jdField_a_of_type_Wkg = paramwkg;
    this.jdField_a_of_type_Wdp = paramwdp;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a(wdq paramwdq)
  {
    if (this.jdField_a_of_type_Wdp == null)
    {
      uht.a().dispatch(this.jdField_a_of_type_JavaLangString, paramwdq);
      return;
    }
    this.jdField_a_of_type_Wdp.a(paramwdq);
  }
  
  private void e()
  {
    vay localvay = new vay();
    localvay.jdField_a_of_type_Wkg = this.jdField_a_of_type_Wkg;
    ung.a().a(localvay, this);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.c) {
      return;
    }
    this.jdField_a_of_type_Wkg.jdField_b_of_type_JavaLangString = "";
    e();
  }
  
  public void a(@NonNull vay paramvay, @Nullable vaz paramvaz, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.a("Q.qqstory.detail:CommentListPageLoader", "get comment list return:%s", paramErrorMessage.toString());
    if (this.c)
    {
      wsv.c("Q.qqstory.detail:CommentListPageLoader", "don't nothing after terminate");
      return;
    }
    wdq localwdq = new wdq(paramErrorMessage, this.jdField_a_of_type_Wkg.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wkg.jdField_a_of_type_Int);
    localwdq.d = this.jdField_a_of_type_Boolean;
    localwdq.jdField_a_of_type_Int = this.jdField_a_of_type_Wkg.jdField_b_of_type_Int;
    if ((paramvaz == null) || (paramErrorMessage.isFail()))
    {
      a(localwdq);
      return;
    }
    wsv.a("Q.qqstory.detail:CommentListPageLoader", "comment respond from cookie:%s to %s", paramvay.jdField_a_of_type_Wkg.jdField_b_of_type_JavaLangString, paramvaz.jdField_a_of_type_JavaLangString);
    boolean bool = TextUtils.isEmpty(paramvay.jdField_a_of_type_Wkg.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Wkg.jdField_b_of_type_JavaLangString = paramvaz.jdField_a_of_type_JavaLangString;
    localwdq.jdField_a_of_type_JavaUtilList = paramvaz.jdField_a_of_type_JavaUtilList;
    localwdq.jdField_b_of_type_Int = paramvaz.jdField_b_of_type_Int;
    localwdq.c = bool;
    localwdq.jdField_a_of_type_Boolean = paramvaz.jdField_a_of_type_Boolean;
    localwdq.jdField_b_of_type_JavaLangString = paramvaz.jdField_a_of_type_JavaLangString;
    if ((!paramvaz.jdField_a_of_type_Boolean) && (paramvaz.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      localwdq.jdField_a_of_type_Boolean = true;
      wsv.d("Q.qqstory.detail:CommentListPageLoader", "comment pull should be end!!!!!!!!!!!!");
    }
    try
    {
      this.b = true;
      a(localwdq);
      wsv.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from network: %s", localwdq);
      paramvay = new wdo(this, "Q.qqstory.detail:CommentListPageLoader", localwdq, bool);
      Bosses.get().postJob(paramvay);
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Wkg.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    super.c();
    if (this.c)
    {
      xmh.a("don't call this method after terminate", new Object[0]);
      return;
    }
    e();
  }
  
  public void d()
  {
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdn
 * JD-Core Version:    0.7.0.1
 */