import android.view.View;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.apollo.ApolloRender;

public final class yif
  implements APICallback
{
  public yif(View paramView, DoraemonAPIManager paramDoraemonAPIManager, long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, this.jdField_a_of_type_Double, this.b, this.c, this.d, this.e, this.f, "", paramInt, "location city failed permission");
  }
  
  public void a(int paramInt, String paramString)
  {
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, this.jdField_a_of_type_Double, this.b, this.c, this.d, this.e, this.f, "", paramInt, "location city failed");
  }
  
  public void a(APIParam paramAPIParam)
  {
    paramAPIParam = (String)DoraemonUtil.a(paramAPIParam, "city", "");
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, this.jdField_a_of_type_Double, this.b, this.c, this.d, this.e, this.f, paramAPIParam, 0, "location success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yif
 * JD-Core Version:    0.7.0.1
 */