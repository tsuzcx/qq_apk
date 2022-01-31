import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class umf
  implements slx<szp, tbm>, unf
{
  protected umi a;
  protected ung a;
  protected unh a;
  
  public Object a()
  {
    return this.jdField_a_of_type_Umi;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    urk.c("GetMyStoryFeatureDataStep", "GetMyStoryFeatureDataStep");
    if ((this.jdField_a_of_type_Umi == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Umi.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_Unh != null)
      {
        this.jdField_a_of_type_Unh.a(a());
        return;
      }
      urk.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    szp localszp = new szp();
    localszp.a = Arrays.asList(new String[] { this.jdField_a_of_type_Umi.jdField_a_of_type_JavaLangString });
    slv.a().a(localszp, this);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_Umi = ((umi)paramObject);
  }
  
  public void a(@NonNull szp paramszp, @Nullable tbm paramtbm, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramtbm != null) && (paramErrorMessage.isSuccess()) && (paramtbm.a != null) && (paramtbm.a.size() > 0))
    {
      this.jdField_a_of_type_Umi.jdField_a_of_type_Srj = ((srj)paramtbm.a.get(0));
      paramszp = (spz)sqg.a(10);
      paramszp.b("qqstory_key_story_latest_feed_feature_feed_id", this.jdField_a_of_type_Umi.jdField_a_of_type_Srj.jdField_a_of_type_JavaLangString);
      paramszp.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(this.jdField_a_of_type_Umi.jdField_a_of_type_Srj.jdField_a_of_type_Int));
      paramszp.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(this.jdField_a_of_type_Umi.jdField_a_of_type_Srj.b));
      paramszp.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(this.jdField_a_of_type_Umi.jdField_a_of_type_Srj.c));
      if (this.jdField_a_of_type_Unh != null)
      {
        this.jdField_a_of_type_Unh.a(a());
        return;
      }
      urk.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    int i = paramErrorMessage.errorCode;
    if (paramtbm == null) {
      paramszp = "rsp is null";
    }
    for (;;)
    {
      urk.e("GetMyStoryFeatureDataStep", "请求Features失败 errorCode: %d %s", new Object[] { Integer.valueOf(i), paramszp });
      this.jdField_a_of_type_Umi.jdField_a_of_type_Srj = new srj();
      this.jdField_a_of_type_Umi.jdField_a_of_type_Srj.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Umi.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Unh == null) {
        break;
      }
      this.jdField_a_of_type_Unh.a(a());
      return;
      if (paramtbm.a == null) {
        paramszp = "features is null";
      } else {
        paramszp = "invalid rsp";
      }
    }
    urk.d("GetMyStoryFeatureDataStep", "finish callBack is null");
  }
  
  public void a(ung paramung)
  {
    this.jdField_a_of_type_Ung = paramung;
  }
  
  public void a(unh paramunh)
  {
    this.jdField_a_of_type_Unh = paramunh;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umf
 * JD-Core Version:    0.7.0.1
 */