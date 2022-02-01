import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class ylk
  implements wld<wyv, xas>, ymk
{
  protected yln a;
  protected yml a;
  protected ymm a;
  
  public Object a()
  {
    return this.jdField_a_of_type_Yln;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    yqp.c("GetMyStoryFeatureDataStep", "GetMyStoryFeatureDataStep");
    if ((this.jdField_a_of_type_Yln == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Yln.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_Ymm != null)
      {
        this.jdField_a_of_type_Ymm.a(a());
        return;
      }
      yqp.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    wyv localwyv = new wyv();
    localwyv.a = Arrays.asList(new String[] { this.jdField_a_of_type_Yln.jdField_a_of_type_JavaLangString });
    wlb.a().a(localwyv, this);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_Yln = ((yln)paramObject);
  }
  
  public void a(@NonNull wyv paramwyv, @Nullable xas paramxas, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramxas != null) && (paramErrorMessage.isSuccess()) && (paramxas.a != null) && (paramxas.a.size() > 0))
    {
      this.jdField_a_of_type_Yln.jdField_a_of_type_Wqp = ((wqp)paramxas.a.get(0));
      paramwyv = (wpf)wpm.a(10);
      paramwyv.b("qqstory_key_story_latest_feed_feature_feed_id", this.jdField_a_of_type_Yln.jdField_a_of_type_Wqp.jdField_a_of_type_JavaLangString);
      paramwyv.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(this.jdField_a_of_type_Yln.jdField_a_of_type_Wqp.jdField_a_of_type_Int));
      paramwyv.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(this.jdField_a_of_type_Yln.jdField_a_of_type_Wqp.b));
      paramwyv.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(this.jdField_a_of_type_Yln.jdField_a_of_type_Wqp.c));
      if (this.jdField_a_of_type_Ymm != null)
      {
        this.jdField_a_of_type_Ymm.a(a());
        return;
      }
      yqp.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    int i = paramErrorMessage.errorCode;
    if (paramxas == null) {
      paramwyv = "rsp is null";
    }
    for (;;)
    {
      yqp.e("GetMyStoryFeatureDataStep", "请求Features失败 errorCode: %d %s", new Object[] { Integer.valueOf(i), paramwyv });
      this.jdField_a_of_type_Yln.jdField_a_of_type_Wqp = new wqp();
      this.jdField_a_of_type_Yln.jdField_a_of_type_Wqp.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Yln.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Ymm == null) {
        break;
      }
      this.jdField_a_of_type_Ymm.a(a());
      return;
      if (paramxas.a == null) {
        paramwyv = "features is null";
      } else {
        paramwyv = "invalid rsp";
      }
    }
    yqp.d("GetMyStoryFeatureDataStep", "finish callBack is null");
  }
  
  public void a(yml paramyml)
  {
    this.jdField_a_of_type_Yml = paramyml;
  }
  
  public void a(ymm paramymm)
  {
    this.jdField_a_of_type_Ymm = paramymm;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylk
 * JD-Core Version:    0.7.0.1
 */