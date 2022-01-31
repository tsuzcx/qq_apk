import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;

public class ymc
  implements Runnable
{
  public ymc(ApolloRenderDriver paramApolloRenderDriver) {}
  
  public void run()
  {
    String str = String.format("mainTicker.interval = %f;mainTicker.paused = false;renderTicker.paused = false;renderTicker.interval = %f;BK.Director.tickerResume();", new Object[] { Double.valueOf(60.0D / this.a.jdField_a_of_type_Int), Double.valueOf(60.0D / this.a.jdField_a_of_type_Int) });
    this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymc
 * JD-Core Version:    0.7.0.1
 */