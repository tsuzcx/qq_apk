import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class uzb
  implements syt<tml, toi>, vab
{
  protected uze a;
  protected vac a;
  protected vad a;
  
  public Object a()
  {
    return this.jdField_a_of_type_Uze;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    veg.c("GetMyStoryFeatureDataStep", "GetMyStoryFeatureDataStep");
    if ((this.jdField_a_of_type_Uze == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Uze.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_Vad != null)
      {
        this.jdField_a_of_type_Vad.a(a());
        return;
      }
      veg.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    tml localtml = new tml();
    localtml.a = Arrays.asList(new String[] { this.jdField_a_of_type_Uze.jdField_a_of_type_JavaLangString });
    syr.a().a(localtml, this);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_Uze = ((uze)paramObject);
  }
  
  public void a(@NonNull tml paramtml, @Nullable toi paramtoi, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramtoi != null) && (paramErrorMessage.isSuccess()) && (paramtoi.a != null) && (paramtoi.a.size() > 0))
    {
      this.jdField_a_of_type_Uze.jdField_a_of_type_Tef = ((tef)paramtoi.a.get(0));
      paramtml = (tcv)tdc.a(10);
      paramtml.b("qqstory_key_story_latest_feed_feature_feed_id", this.jdField_a_of_type_Uze.jdField_a_of_type_Tef.jdField_a_of_type_JavaLangString);
      paramtml.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(this.jdField_a_of_type_Uze.jdField_a_of_type_Tef.jdField_a_of_type_Int));
      paramtml.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(this.jdField_a_of_type_Uze.jdField_a_of_type_Tef.b));
      paramtml.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(this.jdField_a_of_type_Uze.jdField_a_of_type_Tef.c));
      if (this.jdField_a_of_type_Vad != null)
      {
        this.jdField_a_of_type_Vad.a(a());
        return;
      }
      veg.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    int i = paramErrorMessage.errorCode;
    if (paramtoi == null) {
      paramtml = "rsp is null";
    }
    for (;;)
    {
      veg.e("GetMyStoryFeatureDataStep", "请求Features失败 errorCode: %d %s", new Object[] { Integer.valueOf(i), paramtml });
      this.jdField_a_of_type_Uze.jdField_a_of_type_Tef = new tef();
      this.jdField_a_of_type_Uze.jdField_a_of_type_Tef.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Uze.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Vad == null) {
        break;
      }
      this.jdField_a_of_type_Vad.a(a());
      return;
      if (paramtoi.a == null) {
        paramtml = "features is null";
      } else {
        paramtml = "invalid rsp";
      }
    }
    veg.d("GetMyStoryFeatureDataStep", "finish callBack is null");
  }
  
  public void a(vac paramvac)
  {
    this.jdField_a_of_type_Vac = paramvac;
  }
  
  public void a(vad paramvad)
  {
    this.jdField_a_of_type_Vad = paramvad;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzb
 * JD-Core Version:    0.7.0.1
 */