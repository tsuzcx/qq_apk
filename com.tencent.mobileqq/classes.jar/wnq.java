import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class wnq
  implements uni<vba, vcx>, woq
{
  protected wnt a;
  protected wor a;
  protected wos a;
  
  public Object a()
  {
    return this.jdField_a_of_type_Wnt;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    wsv.c("GetMyStoryFeatureDataStep", "GetMyStoryFeatureDataStep");
    if ((this.jdField_a_of_type_Wnt == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Wnt.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_Wos != null)
      {
        this.jdField_a_of_type_Wos.a(a());
        return;
      }
      wsv.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    vba localvba = new vba();
    localvba.a = Arrays.asList(new String[] { this.jdField_a_of_type_Wnt.jdField_a_of_type_JavaLangString });
    ung.a().a(localvba, this);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_Wnt = ((wnt)paramObject);
  }
  
  public void a(@NonNull vba paramvba, @Nullable vcx paramvcx, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramvcx != null) && (paramErrorMessage.isSuccess()) && (paramvcx.a != null) && (paramvcx.a.size() > 0))
    {
      this.jdField_a_of_type_Wnt.jdField_a_of_type_Usu = ((usu)paramvcx.a.get(0));
      paramvba = (urk)urr.a(10);
      paramvba.b("qqstory_key_story_latest_feed_feature_feed_id", this.jdField_a_of_type_Wnt.jdField_a_of_type_Usu.jdField_a_of_type_JavaLangString);
      paramvba.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(this.jdField_a_of_type_Wnt.jdField_a_of_type_Usu.jdField_a_of_type_Int));
      paramvba.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(this.jdField_a_of_type_Wnt.jdField_a_of_type_Usu.b));
      paramvba.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(this.jdField_a_of_type_Wnt.jdField_a_of_type_Usu.c));
      if (this.jdField_a_of_type_Wos != null)
      {
        this.jdField_a_of_type_Wos.a(a());
        return;
      }
      wsv.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    int i = paramErrorMessage.errorCode;
    if (paramvcx == null) {
      paramvba = "rsp is null";
    }
    for (;;)
    {
      wsv.e("GetMyStoryFeatureDataStep", "请求Features失败 errorCode: %d %s", new Object[] { Integer.valueOf(i), paramvba });
      this.jdField_a_of_type_Wnt.jdField_a_of_type_Usu = new usu();
      this.jdField_a_of_type_Wnt.jdField_a_of_type_Usu.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Wnt.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Wos == null) {
        break;
      }
      this.jdField_a_of_type_Wos.a(a());
      return;
      if (paramvcx.a == null) {
        paramvba = "features is null";
      } else {
        paramvba = "invalid rsp";
      }
    }
    wsv.d("GetMyStoryFeatureDataStep", "finish callBack is null");
  }
  
  public void a(wor paramwor)
  {
    this.jdField_a_of_type_Wor = paramwor;
  }
  
  public void a(wos paramwos)
  {
    this.jdField_a_of_type_Wos = paramwos;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wnq
 * JD-Core Version:    0.7.0.1
 */