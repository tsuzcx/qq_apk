import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

public class uoy
  extends tjh
  implements syt<tmj, tmk>
{
  private final String jdField_a_of_type_JavaLangString;
  private final upa jdField_a_of_type_Upa;
  private final uvr jdField_a_of_type_Uvr;
  private boolean c;
  
  public uoy(uvr paramuvr, @NonNull String paramString)
  {
    this.jdField_a_of_type_Uvr = paramuvr;
    this.jdField_a_of_type_Upa = null;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public uoy(uvr paramuvr, @NonNull upa paramupa)
  {
    this.jdField_a_of_type_Uvr = paramuvr;
    this.jdField_a_of_type_Upa = paramupa;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a(upb paramupb)
  {
    if (this.jdField_a_of_type_Upa == null)
    {
      ste.a().dispatch(this.jdField_a_of_type_JavaLangString, paramupb);
      return;
    }
    this.jdField_a_of_type_Upa.a(paramupb);
  }
  
  private void e()
  {
    tmj localtmj = new tmj();
    localtmj.jdField_a_of_type_Uvr = this.jdField_a_of_type_Uvr;
    syr.a().a(localtmj, this);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.c) {
      return;
    }
    this.jdField_a_of_type_Uvr.jdField_b_of_type_JavaLangString = "";
    e();
  }
  
  public void a(@NonNull tmj paramtmj, @Nullable tmk paramtmk, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.a("Q.qqstory.detail:CommentListPageLoader", "get comment list return:%s", paramErrorMessage.toString());
    if (this.c)
    {
      veg.c("Q.qqstory.detail:CommentListPageLoader", "don't nothing after terminate");
      return;
    }
    upb localupb = new upb(paramErrorMessage, this.jdField_a_of_type_Uvr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Uvr.jdField_a_of_type_Int);
    localupb.d = this.jdField_a_of_type_Boolean;
    localupb.jdField_a_of_type_Int = this.jdField_a_of_type_Uvr.jdField_b_of_type_Int;
    if ((paramtmk == null) || (paramErrorMessage.isFail()))
    {
      a(localupb);
      return;
    }
    veg.a("Q.qqstory.detail:CommentListPageLoader", "comment respond from cookie:%s to %s", paramtmj.jdField_a_of_type_Uvr.jdField_b_of_type_JavaLangString, paramtmk.jdField_a_of_type_JavaLangString);
    boolean bool = TextUtils.isEmpty(paramtmj.jdField_a_of_type_Uvr.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Uvr.jdField_b_of_type_JavaLangString = paramtmk.jdField_a_of_type_JavaLangString;
    localupb.jdField_a_of_type_JavaUtilList = paramtmk.jdField_a_of_type_JavaUtilList;
    localupb.jdField_b_of_type_Int = paramtmk.jdField_b_of_type_Int;
    localupb.c = bool;
    localupb.jdField_a_of_type_Boolean = paramtmk.jdField_a_of_type_Boolean;
    localupb.jdField_b_of_type_JavaLangString = paramtmk.jdField_a_of_type_JavaLangString;
    if ((!paramtmk.jdField_a_of_type_Boolean) && (paramtmk.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      localupb.jdField_a_of_type_Boolean = true;
      veg.d("Q.qqstory.detail:CommentListPageLoader", "comment pull should be end!!!!!!!!!!!!");
    }
    try
    {
      this.b = true;
      a(localupb);
      veg.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from network: %s", localupb);
      paramtmj = new uoz(this, "Q.qqstory.detail:CommentListPageLoader", localupb, bool);
      Bosses.get().postJob(paramtmj);
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Uvr.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    super.c();
    if (this.c)
    {
      vxs.a("don't call this method after terminate", new Object[0]);
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
 * Qualified Name:     uoy
 * JD-Core Version:    0.7.0.1
 */