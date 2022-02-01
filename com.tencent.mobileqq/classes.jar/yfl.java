import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class yfl
  implements wfk<wtb, wuy>, ygl
{
  protected yfo a;
  protected ygm a;
  protected ygn a;
  
  public Object a()
  {
    return this.jdField_a_of_type_Yfo;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    ykq.c("GetMyStoryFeatureDataStep", "GetMyStoryFeatureDataStep");
    if ((this.jdField_a_of_type_Yfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Yfo.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_Ygn != null)
      {
        this.jdField_a_of_type_Ygn.a(a());
        return;
      }
      ykq.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    wtb localwtb = new wtb();
    localwtb.a = Arrays.asList(new String[] { this.jdField_a_of_type_Yfo.jdField_a_of_type_JavaLangString });
    wfi.a().a(localwtb, this);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_Yfo = ((yfo)paramObject);
  }
  
  public void a(@NonNull wtb paramwtb, @Nullable wuy paramwuy, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramwuy != null) && (paramErrorMessage.isSuccess()) && (paramwuy.a != null) && (paramwuy.a.size() > 0))
    {
      this.jdField_a_of_type_Yfo.jdField_a_of_type_Wkv = ((wkv)paramwuy.a.get(0));
      paramwtb = (wjl)wjs.a(10);
      paramwtb.b("qqstory_key_story_latest_feed_feature_feed_id", this.jdField_a_of_type_Yfo.jdField_a_of_type_Wkv.jdField_a_of_type_JavaLangString);
      paramwtb.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(this.jdField_a_of_type_Yfo.jdField_a_of_type_Wkv.jdField_a_of_type_Int));
      paramwtb.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(this.jdField_a_of_type_Yfo.jdField_a_of_type_Wkv.b));
      paramwtb.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(this.jdField_a_of_type_Yfo.jdField_a_of_type_Wkv.c));
      if (this.jdField_a_of_type_Ygn != null)
      {
        this.jdField_a_of_type_Ygn.a(a());
        return;
      }
      ykq.d("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    int i = paramErrorMessage.errorCode;
    if (paramwuy == null) {
      paramwtb = "rsp is null";
    }
    for (;;)
    {
      ykq.e("GetMyStoryFeatureDataStep", "请求Features失败 errorCode: %d %s", new Object[] { Integer.valueOf(i), paramwtb });
      this.jdField_a_of_type_Yfo.jdField_a_of_type_Wkv = new wkv();
      this.jdField_a_of_type_Yfo.jdField_a_of_type_Wkv.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Yfo.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Ygn == null) {
        break;
      }
      this.jdField_a_of_type_Ygn.a(a());
      return;
      if (paramwuy.a == null) {
        paramwtb = "features is null";
      } else {
        paramwtb = "invalid rsp";
      }
    }
    ykq.d("GetMyStoryFeatureDataStep", "finish callBack is null");
  }
  
  public void a(ygm paramygm)
  {
    this.jdField_a_of_type_Ygm = paramygm;
  }
  
  public void a(ygn paramygn)
  {
    this.jdField_a_of_type_Ygn = paramygn;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfl
 * JD-Core Version:    0.7.0.1
 */