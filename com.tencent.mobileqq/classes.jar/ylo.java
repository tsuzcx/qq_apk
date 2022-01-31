import android.view.View;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.apollo.ApolloRender;

public final class ylo
  implements APICallback
{
  public ylo(View paramView, DoraemonAPIManager paramDoraemonAPIManager, long paramLong, int paramInt, String paramString) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, "location login permision code");
  }
  
  public void a(int paramInt, String paramString)
  {
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, "location login failed," + paramString);
  }
  
  public void a(APIParam paramAPIParam)
  {
    ApolloRender.getLocationDoLocation(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ylo
 * JD-Core Version:    0.7.0.1
 */