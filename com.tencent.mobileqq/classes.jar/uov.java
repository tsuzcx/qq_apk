import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

public class uov
  extends tje
  implements syq<tmg, tmh>
{
  private final String jdField_a_of_type_JavaLangString;
  private final uox jdField_a_of_type_Uox;
  private final uvo jdField_a_of_type_Uvo;
  private boolean c;
  
  public uov(uvo paramuvo, @NonNull String paramString)
  {
    this.jdField_a_of_type_Uvo = paramuvo;
    this.jdField_a_of_type_Uox = null;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public uov(uvo paramuvo, @NonNull uox paramuox)
  {
    this.jdField_a_of_type_Uvo = paramuvo;
    this.jdField_a_of_type_Uox = paramuox;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a(uoy paramuoy)
  {
    if (this.jdField_a_of_type_Uox == null)
    {
      stb.a().dispatch(this.jdField_a_of_type_JavaLangString, paramuoy);
      return;
    }
    this.jdField_a_of_type_Uox.a(paramuoy);
  }
  
  private void e()
  {
    tmg localtmg = new tmg();
    localtmg.jdField_a_of_type_Uvo = this.jdField_a_of_type_Uvo;
    syo.a().a(localtmg, this);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.c) {
      return;
    }
    this.jdField_a_of_type_Uvo.jdField_b_of_type_JavaLangString = "";
    e();
  }
  
  public void a(@NonNull tmg paramtmg, @Nullable tmh paramtmh, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.a("Q.qqstory.detail:CommentListPageLoader", "get comment list return:%s", paramErrorMessage.toString());
    if (this.c)
    {
      ved.c("Q.qqstory.detail:CommentListPageLoader", "don't nothing after terminate");
      return;
    }
    uoy localuoy = new uoy(paramErrorMessage, this.jdField_a_of_type_Uvo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Uvo.jdField_a_of_type_Int);
    localuoy.d = this.jdField_a_of_type_Boolean;
    localuoy.jdField_a_of_type_Int = this.jdField_a_of_type_Uvo.jdField_b_of_type_Int;
    if ((paramtmh == null) || (paramErrorMessage.isFail()))
    {
      a(localuoy);
      return;
    }
    ved.a("Q.qqstory.detail:CommentListPageLoader", "comment respond from cookie:%s to %s", paramtmg.jdField_a_of_type_Uvo.jdField_b_of_type_JavaLangString, paramtmh.jdField_a_of_type_JavaLangString);
    boolean bool = TextUtils.isEmpty(paramtmg.jdField_a_of_type_Uvo.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Uvo.jdField_b_of_type_JavaLangString = paramtmh.jdField_a_of_type_JavaLangString;
    localuoy.jdField_a_of_type_JavaUtilList = paramtmh.jdField_a_of_type_JavaUtilList;
    localuoy.jdField_b_of_type_Int = paramtmh.jdField_b_of_type_Int;
    localuoy.c = bool;
    localuoy.jdField_a_of_type_Boolean = paramtmh.jdField_a_of_type_Boolean;
    localuoy.jdField_b_of_type_JavaLangString = paramtmh.jdField_a_of_type_JavaLangString;
    if ((!paramtmh.jdField_a_of_type_Boolean) && (paramtmh.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      localuoy.jdField_a_of_type_Boolean = true;
      ved.d("Q.qqstory.detail:CommentListPageLoader", "comment pull should be end!!!!!!!!!!!!");
    }
    try
    {
      this.b = true;
      a(localuoy);
      ved.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from network: %s", localuoy);
      paramtmg = new uow(this, "Q.qqstory.detail:CommentListPageLoader", localuoy, bool);
      Bosses.get().postJob(paramtmg);
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Uvo.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    super.c();
    if (this.c)
    {
      vxp.a("don't call this method after terminate", new Object[0]);
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
 * Qualified Name:     uov
 * JD-Core Version:    0.7.0.1
 */