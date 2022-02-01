import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

public class xvi
  extends wpx
  implements wfk<wsz, wta>
{
  private final String jdField_a_of_type_JavaLangString;
  private final xvk jdField_a_of_type_Xvk;
  private final ycb jdField_a_of_type_Ycb;
  private boolean c;
  
  public xvi(ycb paramycb, @NonNull String paramString)
  {
    this.jdField_a_of_type_Ycb = paramycb;
    this.jdField_a_of_type_Xvk = null;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public xvi(ycb paramycb, @NonNull xvk paramxvk)
  {
    this.jdField_a_of_type_Ycb = paramycb;
    this.jdField_a_of_type_Xvk = paramxvk;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a(xvl paramxvl)
  {
    if (this.jdField_a_of_type_Xvk == null)
    {
      wad.a().dispatch(this.jdField_a_of_type_JavaLangString, paramxvl);
      return;
    }
    this.jdField_a_of_type_Xvk.a(paramxvl);
  }
  
  private void e()
  {
    wsz localwsz = new wsz();
    localwsz.jdField_a_of_type_Ycb = this.jdField_a_of_type_Ycb;
    wfi.a().a(localwsz, this);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.c) {
      return;
    }
    this.jdField_a_of_type_Ycb.jdField_b_of_type_JavaLangString = "";
    e();
  }
  
  public void a(@NonNull wsz paramwsz, @Nullable wta paramwta, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.a("Q.qqstory.detail:CommentListPageLoader", "get comment list return:%s", paramErrorMessage.toString());
    if (this.c)
    {
      ykq.c("Q.qqstory.detail:CommentListPageLoader", "don't nothing after terminate");
      return;
    }
    xvl localxvl = new xvl(paramErrorMessage, this.jdField_a_of_type_Ycb.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ycb.jdField_a_of_type_Int);
    localxvl.d = this.jdField_a_of_type_Boolean;
    localxvl.jdField_a_of_type_Int = this.jdField_a_of_type_Ycb.jdField_b_of_type_Int;
    if ((paramwta == null) || (paramErrorMessage.isFail()))
    {
      a(localxvl);
      return;
    }
    ykq.a("Q.qqstory.detail:CommentListPageLoader", "comment respond from cookie:%s to %s", paramwsz.jdField_a_of_type_Ycb.jdField_b_of_type_JavaLangString, paramwta.jdField_a_of_type_JavaLangString);
    boolean bool = TextUtils.isEmpty(paramwsz.jdField_a_of_type_Ycb.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Ycb.jdField_b_of_type_JavaLangString = paramwta.jdField_a_of_type_JavaLangString;
    localxvl.jdField_a_of_type_JavaUtilList = paramwta.jdField_a_of_type_JavaUtilList;
    localxvl.jdField_b_of_type_Int = paramwta.jdField_b_of_type_Int;
    localxvl.c = bool;
    localxvl.jdField_a_of_type_Boolean = paramwta.jdField_a_of_type_Boolean;
    localxvl.jdField_b_of_type_JavaLangString = paramwta.jdField_a_of_type_JavaLangString;
    if ((!paramwta.jdField_a_of_type_Boolean) && (paramwta.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      localxvl.jdField_a_of_type_Boolean = true;
      ykq.d("Q.qqstory.detail:CommentListPageLoader", "comment pull should be end!!!!!!!!!!!!");
    }
    try
    {
      this.b = true;
      a(localxvl);
      ykq.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from network: %s", localxvl);
      paramwsz = new xvj(this, "Q.qqstory.detail:CommentListPageLoader", localxvl, bool);
      Bosses.get().postJob(paramwsz);
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Ycb.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    super.c();
    if (this.c)
    {
      zdl.a("don't call this method after terminate", new Object[0]);
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
 * Qualified Name:     xvi
 * JD-Core Version:    0.7.0.1
 */