import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

public class whw
  extends vcf
  implements urr<vfh, vfi>
{
  private final String jdField_a_of_type_JavaLangString;
  private final why jdField_a_of_type_Why;
  private final wop jdField_a_of_type_Wop;
  private boolean c;
  
  public whw(wop paramwop, @NonNull String paramString)
  {
    this.jdField_a_of_type_Wop = paramwop;
    this.jdField_a_of_type_Why = null;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public whw(wop paramwop, @NonNull why paramwhy)
  {
    this.jdField_a_of_type_Wop = paramwop;
    this.jdField_a_of_type_Why = paramwhy;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a(whz paramwhz)
  {
    if (this.jdField_a_of_type_Why == null)
    {
      umc.a().dispatch(this.jdField_a_of_type_JavaLangString, paramwhz);
      return;
    }
    this.jdField_a_of_type_Why.a(paramwhz);
  }
  
  private void e()
  {
    vfh localvfh = new vfh();
    localvfh.jdField_a_of_type_Wop = this.jdField_a_of_type_Wop;
    urp.a().a(localvfh, this);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.c) {
      return;
    }
    this.jdField_a_of_type_Wop.jdField_b_of_type_JavaLangString = "";
    e();
  }
  
  public void a(@NonNull vfh paramvfh, @Nullable vfi paramvfi, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.a("Q.qqstory.detail:CommentListPageLoader", "get comment list return:%s", paramErrorMessage.toString());
    if (this.c)
    {
      wxe.c("Q.qqstory.detail:CommentListPageLoader", "don't nothing after terminate");
      return;
    }
    whz localwhz = new whz(paramErrorMessage, this.jdField_a_of_type_Wop.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wop.jdField_a_of_type_Int);
    localwhz.d = this.jdField_a_of_type_Boolean;
    localwhz.jdField_a_of_type_Int = this.jdField_a_of_type_Wop.jdField_b_of_type_Int;
    if ((paramvfi == null) || (paramErrorMessage.isFail()))
    {
      a(localwhz);
      return;
    }
    wxe.a("Q.qqstory.detail:CommentListPageLoader", "comment respond from cookie:%s to %s", paramvfh.jdField_a_of_type_Wop.jdField_b_of_type_JavaLangString, paramvfi.jdField_a_of_type_JavaLangString);
    boolean bool = TextUtils.isEmpty(paramvfh.jdField_a_of_type_Wop.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Wop.jdField_b_of_type_JavaLangString = paramvfi.jdField_a_of_type_JavaLangString;
    localwhz.jdField_a_of_type_JavaUtilList = paramvfi.jdField_a_of_type_JavaUtilList;
    localwhz.jdField_b_of_type_Int = paramvfi.jdField_b_of_type_Int;
    localwhz.c = bool;
    localwhz.jdField_a_of_type_Boolean = paramvfi.jdField_a_of_type_Boolean;
    localwhz.jdField_b_of_type_JavaLangString = paramvfi.jdField_a_of_type_JavaLangString;
    if ((!paramvfi.jdField_a_of_type_Boolean) && (paramvfi.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      localwhz.jdField_a_of_type_Boolean = true;
      wxe.d("Q.qqstory.detail:CommentListPageLoader", "comment pull should be end!!!!!!!!!!!!");
    }
    try
    {
      this.b = true;
      a(localwhz);
      wxe.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from network: %s", localwhz);
      paramvfh = new whx(this, "Q.qqstory.detail:CommentListPageLoader", localwhz, bool);
      Bosses.get().postJob(paramvfh);
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Wop.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    super.c();
    if (this.c)
    {
      xqq.a("don't call this method after terminate", new Object[0]);
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
 * Qualified Name:     whw
 * JD-Core Version:    0.7.0.1
 */