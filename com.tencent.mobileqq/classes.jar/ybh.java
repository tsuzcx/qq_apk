import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

public class ybh
  extends wvr
  implements wld<wyt, wyu>
{
  private final String jdField_a_of_type_JavaLangString;
  private final ybj jdField_a_of_type_Ybj;
  private final yia jdField_a_of_type_Yia;
  private boolean c;
  
  public ybh(yia paramyia, @NonNull String paramString)
  {
    this.jdField_a_of_type_Yia = paramyia;
    this.jdField_a_of_type_Ybj = null;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public ybh(yia paramyia, @NonNull ybj paramybj)
  {
    this.jdField_a_of_type_Yia = paramyia;
    this.jdField_a_of_type_Ybj = paramybj;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a(ybk paramybk)
  {
    if (this.jdField_a_of_type_Ybj == null)
    {
      wfo.a().dispatch(this.jdField_a_of_type_JavaLangString, paramybk);
      return;
    }
    this.jdField_a_of_type_Ybj.a(paramybk);
  }
  
  private void e()
  {
    wyt localwyt = new wyt();
    localwyt.jdField_a_of_type_Yia = this.jdField_a_of_type_Yia;
    wlb.a().a(localwyt, this);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.c) {
      return;
    }
    this.jdField_a_of_type_Yia.jdField_b_of_type_JavaLangString = "";
    e();
  }
  
  public void a(@NonNull wyt paramwyt, @Nullable wyu paramwyu, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.a("Q.qqstory.detail:CommentListPageLoader", "get comment list return:%s", paramErrorMessage.toString());
    if (this.c)
    {
      yqp.c("Q.qqstory.detail:CommentListPageLoader", "don't nothing after terminate");
      return;
    }
    ybk localybk = new ybk(paramErrorMessage, this.jdField_a_of_type_Yia.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Yia.jdField_a_of_type_Int);
    localybk.d = this.jdField_a_of_type_Boolean;
    localybk.jdField_a_of_type_Int = this.jdField_a_of_type_Yia.jdField_b_of_type_Int;
    if ((paramwyu == null) || (paramErrorMessage.isFail()))
    {
      a(localybk);
      return;
    }
    yqp.a("Q.qqstory.detail:CommentListPageLoader", "comment respond from cookie:%s to %s", paramwyt.jdField_a_of_type_Yia.jdField_b_of_type_JavaLangString, paramwyu.jdField_a_of_type_JavaLangString);
    boolean bool = TextUtils.isEmpty(paramwyt.jdField_a_of_type_Yia.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Yia.jdField_b_of_type_JavaLangString = paramwyu.jdField_a_of_type_JavaLangString;
    localybk.jdField_a_of_type_JavaUtilList = paramwyu.jdField_a_of_type_JavaUtilList;
    localybk.jdField_b_of_type_Int = paramwyu.jdField_b_of_type_Int;
    localybk.c = bool;
    localybk.jdField_a_of_type_Boolean = paramwyu.jdField_a_of_type_Boolean;
    localybk.jdField_b_of_type_JavaLangString = paramwyu.jdField_a_of_type_JavaLangString;
    if ((!paramwyu.jdField_a_of_type_Boolean) && (paramwyu.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      localybk.jdField_a_of_type_Boolean = true;
      yqp.d("Q.qqstory.detail:CommentListPageLoader", "comment pull should be end!!!!!!!!!!!!");
    }
    try
    {
      this.b = true;
      a(localybk);
      yqp.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from network: %s", localybk);
      paramwyt = new ybi(this, "Q.qqstory.detail:CommentListPageLoader", localybk, bool);
      Bosses.get().postJob(paramwyt);
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Yia.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    super.c();
    if (this.c)
    {
      zkb.a("don't call this method after terminate", new Object[0]);
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
 * Qualified Name:     ybh
 * JD-Core Version:    0.7.0.1
 */