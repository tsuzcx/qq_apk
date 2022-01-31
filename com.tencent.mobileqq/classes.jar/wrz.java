import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class wrz
  implements urr<vfj, vhg>, wsz
{
  protected wsc a;
  protected wta a;
  protected wtb a;
  
  public Object a()
  {
    return this.jdField_a_of_type_Wsc;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    wxe.c("GetMyStoryFeatureDataStep", "GetMyStoryFeatureDataStep");
    if ((this.jdField_a_of_type_Wsc == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Wsc.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_Wtb != null)
      {
        this.jdField_a_of_type_Wtb.a(a());
        return;
      }
      wxe.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    vfj localvfj = new vfj();
    localvfj.a = Arrays.asList(new String[] { this.jdField_a_of_type_Wsc.jdField_a_of_type_JavaLangString });
    urp.a().a(localvfj, this);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_Wsc = ((wsc)paramObject);
  }
  
  public void a(@NonNull vfj paramvfj, @Nullable vhg paramvhg, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramvhg != null) && (paramErrorMessage.isSuccess()) && (paramvhg.a != null) && (paramvhg.a.size() > 0))
    {
      this.jdField_a_of_type_Wsc.jdField_a_of_type_Uxd = ((uxd)paramvhg.a.get(0));
      paramvfj = (uvt)uwa.a(10);
      paramvfj.b("qqstory_key_story_latest_feed_feature_feed_id", this.jdField_a_of_type_Wsc.jdField_a_of_type_Uxd.jdField_a_of_type_JavaLangString);
      paramvfj.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(this.jdField_a_of_type_Wsc.jdField_a_of_type_Uxd.jdField_a_of_type_Int));
      paramvfj.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(this.jdField_a_of_type_Wsc.jdField_a_of_type_Uxd.b));
      paramvfj.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(this.jdField_a_of_type_Wsc.jdField_a_of_type_Uxd.c));
      if (this.jdField_a_of_type_Wtb != null)
      {
        this.jdField_a_of_type_Wtb.a(a());
        return;
      }
      wxe.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    int i = paramErrorMessage.errorCode;
    if (paramvhg == null) {
      paramvfj = "rsp is null";
    }
    for (;;)
    {
      wxe.e("GetMyStoryFeatureDataStep", "请求Features失败 errorCode: %d %s", new Object[] { Integer.valueOf(i), paramvfj });
      this.jdField_a_of_type_Wsc.jdField_a_of_type_Uxd = new uxd();
      this.jdField_a_of_type_Wsc.jdField_a_of_type_Uxd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Wsc.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Wtb == null) {
        break;
      }
      this.jdField_a_of_type_Wtb.a(a());
      return;
      if (paramvhg.a == null) {
        paramvfj = "features is null";
      } else {
        paramvfj = "invalid rsp";
      }
    }
    wxe.d("GetMyStoryFeatureDataStep", "finish callBack is null");
  }
  
  public void a(wta paramwta)
  {
    this.jdField_a_of_type_Wta = paramwta;
  }
  
  public void a(wtb paramwtb)
  {
    this.jdField_a_of_type_Wtb = paramwtb;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wrz
 * JD-Core Version:    0.7.0.1
 */