import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

public class ucc
  extends swl
  implements slx<szn, szo>
{
  private final String jdField_a_of_type_JavaLangString;
  private final uce jdField_a_of_type_Uce;
  private final uiv jdField_a_of_type_Uiv;
  private boolean c;
  
  public ucc(uiv paramuiv, @NonNull String paramString)
  {
    this.jdField_a_of_type_Uiv = paramuiv;
    this.jdField_a_of_type_Uce = null;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public ucc(uiv paramuiv, @NonNull uce paramuce)
  {
    this.jdField_a_of_type_Uiv = paramuiv;
    this.jdField_a_of_type_Uce = paramuce;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a(ucf paramucf)
  {
    if (this.jdField_a_of_type_Uce == null)
    {
      sgi.a().dispatch(this.jdField_a_of_type_JavaLangString, paramucf);
      return;
    }
    this.jdField_a_of_type_Uce.a(paramucf);
  }
  
  private void e()
  {
    szn localszn = new szn();
    localszn.jdField_a_of_type_Uiv = this.jdField_a_of_type_Uiv;
    slv.a().a(localszn, this);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.c) {
      return;
    }
    this.jdField_a_of_type_Uiv.jdField_b_of_type_JavaLangString = "";
    e();
  }
  
  public void a(@NonNull szn paramszn, @Nullable szo paramszo, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.a("Q.qqstory.detail:CommentListPageLoader", "get comment list return:%s", paramErrorMessage.toString());
    if (this.c)
    {
      urk.c("Q.qqstory.detail:CommentListPageLoader", "don't nothing after terminate");
      return;
    }
    ucf localucf = new ucf(paramErrorMessage, this.jdField_a_of_type_Uiv.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Uiv.jdField_a_of_type_Int);
    localucf.d = this.jdField_a_of_type_Boolean;
    localucf.jdField_a_of_type_Int = this.jdField_a_of_type_Uiv.jdField_b_of_type_Int;
    if ((paramszo == null) || (paramErrorMessage.isFail()))
    {
      a(localucf);
      return;
    }
    urk.a("Q.qqstory.detail:CommentListPageLoader", "comment respond from cookie:%s to %s", paramszn.jdField_a_of_type_Uiv.jdField_b_of_type_JavaLangString, paramszo.jdField_a_of_type_JavaLangString);
    boolean bool = TextUtils.isEmpty(paramszn.jdField_a_of_type_Uiv.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Uiv.jdField_b_of_type_JavaLangString = paramszo.jdField_a_of_type_JavaLangString;
    localucf.jdField_a_of_type_JavaUtilList = paramszo.jdField_a_of_type_JavaUtilList;
    localucf.jdField_b_of_type_Int = paramszo.jdField_b_of_type_Int;
    localucf.c = bool;
    localucf.jdField_a_of_type_Boolean = paramszo.jdField_a_of_type_Boolean;
    localucf.jdField_b_of_type_JavaLangString = paramszo.jdField_a_of_type_JavaLangString;
    if ((!paramszo.jdField_a_of_type_Boolean) && (paramszo.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      localucf.jdField_a_of_type_Boolean = true;
      urk.d("Q.qqstory.detail:CommentListPageLoader", "comment pull should be end!!!!!!!!!!!!");
    }
    try
    {
      this.b = true;
      a(localucf);
      urk.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from network: %s", localucf);
      paramszn = new ucd(this, "Q.qqstory.detail:CommentListPageLoader", localucf, bool);
      Bosses.get().postJob(paramszn);
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Uiv.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    super.c();
    if (this.c)
    {
      vkw.a("don't call this method after terminate", new Object[0]);
      return;
    }
    e();
  }
  
  public void d()
  {
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucc
 * JD-Core Version:    0.7.0.1
 */