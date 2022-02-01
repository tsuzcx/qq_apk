import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class ypf
  implements woy<xcq, xen>, yqf
{
  protected ypi a;
  protected yqg a;
  protected yqh a;
  
  public Object a()
  {
    return this.jdField_a_of_type_Ypi;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    yuk.c("GetMyStoryFeatureDataStep", "GetMyStoryFeatureDataStep");
    if ((this.jdField_a_of_type_Ypi == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Ypi.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_Yqh != null)
      {
        this.jdField_a_of_type_Yqh.a(a());
        return;
      }
      yuk.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    xcq localxcq = new xcq();
    localxcq.a = Arrays.asList(new String[] { this.jdField_a_of_type_Ypi.jdField_a_of_type_JavaLangString });
    wow.a().a(localxcq, this);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_Ypi = ((ypi)paramObject);
  }
  
  public void a(@NonNull xcq paramxcq, @Nullable xen paramxen, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramxen != null) && (paramErrorMessage.isSuccess()) && (paramxen.a != null) && (paramxen.a.size() > 0))
    {
      this.jdField_a_of_type_Ypi.jdField_a_of_type_Wuk = ((wuk)paramxen.a.get(0));
      paramxcq = (wta)wth.a(10);
      paramxcq.b("qqstory_key_story_latest_feed_feature_feed_id", this.jdField_a_of_type_Ypi.jdField_a_of_type_Wuk.jdField_a_of_type_JavaLangString);
      paramxcq.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(this.jdField_a_of_type_Ypi.jdField_a_of_type_Wuk.jdField_a_of_type_Int));
      paramxcq.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(this.jdField_a_of_type_Ypi.jdField_a_of_type_Wuk.b));
      paramxcq.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(this.jdField_a_of_type_Ypi.jdField_a_of_type_Wuk.c));
      if (this.jdField_a_of_type_Yqh != null)
      {
        this.jdField_a_of_type_Yqh.a(a());
        return;
      }
      yuk.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    int i = paramErrorMessage.errorCode;
    if (paramxen == null) {
      paramxcq = "rsp is null";
    }
    for (;;)
    {
      yuk.e("GetMyStoryFeatureDataStep", "请求Features失败 errorCode: %d %s", new Object[] { Integer.valueOf(i), paramxcq });
      this.jdField_a_of_type_Ypi.jdField_a_of_type_Wuk = new wuk();
      this.jdField_a_of_type_Ypi.jdField_a_of_type_Wuk.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Ypi.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Yqh == null) {
        break;
      }
      this.jdField_a_of_type_Yqh.a(a());
      return;
      if (paramxen.a == null) {
        paramxcq = "features is null";
      } else {
        paramxcq = "invalid rsp";
      }
    }
    yuk.d("GetMyStoryFeatureDataStep", "finish callBack is null");
  }
  
  public void a(yqg paramyqg)
  {
    this.jdField_a_of_type_Yqg = paramyqg;
  }
  
  public void a(yqh paramyqh)
  {
    this.jdField_a_of_type_Yqh = paramyqh;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypf
 * JD-Core Version:    0.7.0.1
 */