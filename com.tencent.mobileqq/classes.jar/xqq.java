import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class xqq
  implements vqp<weg, wgd>, xrq
{
  protected xqt a;
  protected xrr a;
  protected xrs a;
  
  public Object a()
  {
    return this.jdField_a_of_type_Xqt;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    xvv.c("GetMyStoryFeatureDataStep", "GetMyStoryFeatureDataStep");
    if ((this.jdField_a_of_type_Xqt == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Xqt.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_Xrs != null)
      {
        this.jdField_a_of_type_Xrs.a(a());
        return;
      }
      xvv.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    weg localweg = new weg();
    localweg.a = Arrays.asList(new String[] { this.jdField_a_of_type_Xqt.jdField_a_of_type_JavaLangString });
    vqn.a().a(localweg, this);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_Xqt = ((xqt)paramObject);
  }
  
  public void a(@NonNull weg paramweg, @Nullable wgd paramwgd, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramwgd != null) && (paramErrorMessage.isSuccess()) && (paramwgd.a != null) && (paramwgd.a.size() > 0))
    {
      this.jdField_a_of_type_Xqt.jdField_a_of_type_Vwa = ((vwa)paramwgd.a.get(0));
      paramweg = (vuq)vux.a(10);
      paramweg.b("qqstory_key_story_latest_feed_feature_feed_id", this.jdField_a_of_type_Xqt.jdField_a_of_type_Vwa.jdField_a_of_type_JavaLangString);
      paramweg.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(this.jdField_a_of_type_Xqt.jdField_a_of_type_Vwa.jdField_a_of_type_Int));
      paramweg.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(this.jdField_a_of_type_Xqt.jdField_a_of_type_Vwa.b));
      paramweg.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(this.jdField_a_of_type_Xqt.jdField_a_of_type_Vwa.c));
      if (this.jdField_a_of_type_Xrs != null)
      {
        this.jdField_a_of_type_Xrs.a(a());
        return;
      }
      xvv.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    int i = paramErrorMessage.errorCode;
    if (paramwgd == null) {
      paramweg = "rsp is null";
    }
    for (;;)
    {
      xvv.e("GetMyStoryFeatureDataStep", "请求Features失败 errorCode: %d %s", new Object[] { Integer.valueOf(i), paramweg });
      this.jdField_a_of_type_Xqt.jdField_a_of_type_Vwa = new vwa();
      this.jdField_a_of_type_Xqt.jdField_a_of_type_Vwa.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Xqt.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Xrs == null) {
        break;
      }
      this.jdField_a_of_type_Xrs.a(a());
      return;
      if (paramwgd.a == null) {
        paramweg = "features is null";
      } else {
        paramweg = "invalid rsp";
      }
    }
    xvv.d("GetMyStoryFeatureDataStep", "finish callBack is null");
  }
  
  public void a(xrr paramxrr)
  {
    this.jdField_a_of_type_Xrr = paramxrr;
  }
  
  public void a(xrs paramxrs)
  {
    this.jdField_a_of_type_Xrs = paramxrs;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqq
 * JD-Core Version:    0.7.0.1
 */