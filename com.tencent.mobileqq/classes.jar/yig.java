import android.view.View;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.apollo.ApolloRender;

public final class yig
  implements APICallback
{
  public yig(View paramView, DoraemonAPIManager paramDoraemonAPIManager, long paramLong, int paramInt) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, "location permision code");
  }
  
  public void a(int paramInt, String paramString)
  {
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, "location failed," + paramString);
  }
  
  public void a(APIParam paramAPIParam)
  {
    double d1 = ((Double)DoraemonUtil.a(paramAPIParam, "altitude", Double.valueOf(0.0D))).doubleValue();
    double d2 = ((Double)DoraemonUtil.a(paramAPIParam, "latitude", Double.valueOf(0.0D))).doubleValue();
    double d3 = ((Double)DoraemonUtil.a(paramAPIParam, "longitude", Double.valueOf(0.0D))).doubleValue();
    double d4 = ((Double)DoraemonUtil.a(paramAPIParam, "horizontalAccuracy", Double.valueOf(0.0D))).doubleValue();
    ((Double)DoraemonUtil.a(paramAPIParam, "verticalAccuracy", Double.valueOf(0.0D))).doubleValue();
    ((Double)DoraemonUtil.a(paramAPIParam, "accuracy", Double.valueOf(0.0D))).doubleValue();
    double d5 = ((Double)DoraemonUtil.a(paramAPIParam, "speed", Double.valueOf(0.0D))).doubleValue();
    if (this.jdField_a_of_type_Int == 1)
    {
      ApolloRender.getLocationCity(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, d4, d2, d3, d5, d1, 0.0D);
      return;
    }
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, d4, d2, d3, d5, d1, 0.0D, "", 0, "location success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yig
 * JD-Core Version:    0.7.0.1
 */