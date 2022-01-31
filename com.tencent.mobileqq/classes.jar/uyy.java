import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class uyy
  implements syq<tmi, tof>, uzy
{
  protected uzb a;
  protected uzz a;
  protected vaa a;
  
  public Object a()
  {
    return this.jdField_a_of_type_Uzb;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    ved.c("GetMyStoryFeatureDataStep", "GetMyStoryFeatureDataStep");
    if ((this.jdField_a_of_type_Uzb == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Uzb.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_Vaa != null)
      {
        this.jdField_a_of_type_Vaa.a(a());
        return;
      }
      ved.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    tmi localtmi = new tmi();
    localtmi.a = Arrays.asList(new String[] { this.jdField_a_of_type_Uzb.jdField_a_of_type_JavaLangString });
    syo.a().a(localtmi, this);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_Uzb = ((uzb)paramObject);
  }
  
  public void a(@NonNull tmi paramtmi, @Nullable tof paramtof, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramtof != null) && (paramErrorMessage.isSuccess()) && (paramtof.a != null) && (paramtof.a.size() > 0))
    {
      this.jdField_a_of_type_Uzb.jdField_a_of_type_Tec = ((tec)paramtof.a.get(0));
      paramtmi = (tcs)tcz.a(10);
      paramtmi.b("qqstory_key_story_latest_feed_feature_feed_id", this.jdField_a_of_type_Uzb.jdField_a_of_type_Tec.jdField_a_of_type_JavaLangString);
      paramtmi.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(this.jdField_a_of_type_Uzb.jdField_a_of_type_Tec.jdField_a_of_type_Int));
      paramtmi.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(this.jdField_a_of_type_Uzb.jdField_a_of_type_Tec.b));
      paramtmi.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(this.jdField_a_of_type_Uzb.jdField_a_of_type_Tec.c));
      if (this.jdField_a_of_type_Vaa != null)
      {
        this.jdField_a_of_type_Vaa.a(a());
        return;
      }
      ved.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    int i = paramErrorMessage.errorCode;
    if (paramtof == null) {
      paramtmi = "rsp is null";
    }
    for (;;)
    {
      ved.e("GetMyStoryFeatureDataStep", "请求Features失败 errorCode: %d %s", new Object[] { Integer.valueOf(i), paramtmi });
      this.jdField_a_of_type_Uzb.jdField_a_of_type_Tec = new tec();
      this.jdField_a_of_type_Uzb.jdField_a_of_type_Tec.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Uzb.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Vaa == null) {
        break;
      }
      this.jdField_a_of_type_Vaa.a(a());
      return;
      if (paramtof.a == null) {
        paramtmi = "features is null";
      } else {
        paramtmi = "invalid rsp";
      }
    }
    ved.d("GetMyStoryFeatureDataStep", "finish callBack is null");
  }
  
  public void a(uzz paramuzz)
  {
    this.jdField_a_of_type_Uzz = paramuzz;
  }
  
  public void a(vaa paramvaa)
  {
    this.jdField_a_of_type_Vaa = paramvaa;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uyy
 * JD-Core Version:    0.7.0.1
 */