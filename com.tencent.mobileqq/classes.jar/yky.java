import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.qphone.base.util.QLog;

public class yky
  implements Runnable
{
  public yky(ApolloRender paramApolloRender, OnApolloViewListener paramOnApolloViewListener, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener != null)
    {
      QLog.d("ApolloRender", 2, "cb.onSurfaceReady");
      this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener.onSurfaceReady(this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yky
 * JD-Core Version:    0.7.0.1
 */