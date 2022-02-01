import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

public class xgn
  extends wbc
  implements vqp<wee, wef>
{
  private final String jdField_a_of_type_JavaLangString;
  private final xgp jdField_a_of_type_Xgp;
  private final xng jdField_a_of_type_Xng;
  private boolean c;
  
  public xgn(xng paramxng, @NonNull String paramString)
  {
    this.jdField_a_of_type_Xng = paramxng;
    this.jdField_a_of_type_Xgp = null;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public xgn(xng paramxng, @NonNull xgp paramxgp)
  {
    this.jdField_a_of_type_Xng = paramxng;
    this.jdField_a_of_type_Xgp = paramxgp;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a(xgq paramxgq)
  {
    if (this.jdField_a_of_type_Xgp == null)
    {
      vli.a().dispatch(this.jdField_a_of_type_JavaLangString, paramxgq);
      return;
    }
    this.jdField_a_of_type_Xgp.a(paramxgq);
  }
  
  private void e()
  {
    wee localwee = new wee();
    localwee.jdField_a_of_type_Xng = this.jdField_a_of_type_Xng;
    vqn.a().a(localwee, this);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.c) {
      return;
    }
    this.jdField_a_of_type_Xng.jdField_b_of_type_JavaLangString = "";
    e();
  }
  
  public void a(@NonNull wee paramwee, @Nullable wef paramwef, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.a("Q.qqstory.detail:CommentListPageLoader", "get comment list return:%s", paramErrorMessage.toString());
    if (this.c)
    {
      xvv.c("Q.qqstory.detail:CommentListPageLoader", "don't nothing after terminate");
      return;
    }
    xgq localxgq = new xgq(paramErrorMessage, this.jdField_a_of_type_Xng.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xng.jdField_a_of_type_Int);
    localxgq.d = this.jdField_a_of_type_Boolean;
    localxgq.jdField_a_of_type_Int = this.jdField_a_of_type_Xng.jdField_b_of_type_Int;
    if ((paramwef == null) || (paramErrorMessage.isFail()))
    {
      a(localxgq);
      return;
    }
    xvv.a("Q.qqstory.detail:CommentListPageLoader", "comment respond from cookie:%s to %s", paramwee.jdField_a_of_type_Xng.jdField_b_of_type_JavaLangString, paramwef.jdField_a_of_type_JavaLangString);
    boolean bool = TextUtils.isEmpty(paramwee.jdField_a_of_type_Xng.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Xng.jdField_b_of_type_JavaLangString = paramwef.jdField_a_of_type_JavaLangString;
    localxgq.jdField_a_of_type_JavaUtilList = paramwef.jdField_a_of_type_JavaUtilList;
    localxgq.jdField_b_of_type_Int = paramwef.jdField_b_of_type_Int;
    localxgq.c = bool;
    localxgq.jdField_a_of_type_Boolean = paramwef.jdField_a_of_type_Boolean;
    localxgq.jdField_b_of_type_JavaLangString = paramwef.jdField_a_of_type_JavaLangString;
    if ((!paramwef.jdField_a_of_type_Boolean) && (paramwef.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      localxgq.jdField_a_of_type_Boolean = true;
      xvv.d("Q.qqstory.detail:CommentListPageLoader", "comment pull should be end!!!!!!!!!!!!");
    }
    try
    {
      this.b = true;
      a(localxgq);
      xvv.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from network: %s", localxgq);
      paramwee = new xgo(this, "Q.qqstory.detail:CommentListPageLoader", localxgq, bool);
      Bosses.get().postJob(paramwee);
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Xng.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    super.c();
    if (this.c)
    {
      yos.a("don't call this method after terminate", new Object[0]);
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
 * Qualified Name:     xgn
 * JD-Core Version:    0.7.0.1
 */