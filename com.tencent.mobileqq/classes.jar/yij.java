import android.view.View;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.utils.ApolloHttpCallBack;

public final class yij
  extends ApolloHttpCallBack
{
  public yij(View paramView, long paramLong) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof ApolloSurfaceView)) {
      ((ApolloSurfaceView)this.jdField_a_of_type_AndroidViewView).queueEvent(new yik(this, paramArrayOfByte, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yij
 * JD-Core Version:    0.7.0.1
 */