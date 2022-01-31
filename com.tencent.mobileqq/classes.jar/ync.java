import android.view.View;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.ApolloTicker;
import java.lang.ref.WeakReference;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class ync
  extends TimerTask
{
  private final long jdField_a_of_type_Long;
  private final WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ynd jdField_a_of_type_Ynd;
  private yne jdField_a_of_type_Yne;
  private final long b;
  
  public ync(ApolloTicker paramApolloTicker, View paramView, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            } while (localObject == null);
            if (!(localObject instanceof ApolloSurfaceView)) {
              break;
            }
            localObject = (ApolloSurfaceView)localObject;
          } while ((((ApolloSurfaceView)localObject).mIsDestroy == null) || (((ApolloSurfaceView)localObject).mIsDestroy.get()));
          if (this.jdField_a_of_type_Ynd == null) {
            this.jdField_a_of_type_Ynd = new ynd(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker, (ApolloSurfaceView)localObject, this.jdField_a_of_type_Long, this.b);
          }
          if (((ApolloSurfaceView)localObject).mRenderMode == 0)
          {
            ((ApolloSurfaceView)localObject).queueEvent(this.jdField_a_of_type_Ynd);
            return;
          }
        } while (((ApolloSurfaceView)localObject).mRenderMode != 1);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker.pauseTicker(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker.ticker);
        return;
      } while (!(localObject instanceof ApolloTextureView));
      localObject = (ApolloTextureView)localObject;
    } while ((((ApolloTextureView)localObject).mIsDestroy == null) || (((ApolloTextureView)localObject).mIsDestroy.get()));
    if (this.jdField_a_of_type_Yne == null) {
      this.jdField_a_of_type_Yne = new yne(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker, (ApolloTextureView)localObject, this.jdField_a_of_type_Long, this.b);
    }
    ((ApolloTextureView)localObject).queueEvent(this.jdField_a_of_type_Yne);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ync
 * JD-Core Version:    0.7.0.1
 */