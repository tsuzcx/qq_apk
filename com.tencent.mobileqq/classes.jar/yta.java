import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class yta
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public yta(ApolloSurfaceView paramApolloSurfaceView) {}
  
  public void a()
  {
    this.jdField_a_of_type_Int = ApolloSurfaceView.access$601(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
  }
  
  public void run()
  {
    if (ApolloSurfaceView.access$100(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView) == null) {}
    OnApolloViewListener localOnApolloViewListener;
    do
    {
      do
      {
        do
        {
          return;
          localOnApolloViewListener = (OnApolloViewListener)ApolloSurfaceView.access$100(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView).get();
        } while (localOnApolloViewListener == null);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloSurfaceView", 2, "CheckForLongPress onLongClick");
        }
      } while (this.jdField_a_of_type_Int != ApolloSurfaceView.access$201(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView));
      ApolloSurfaceView.access$302(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, true);
      ApolloSurfaceView.access$401(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, 2);
    } while ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mApolloId)) || (ApolloSurfaceView.access$500(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView) < 0) || (localOnApolloViewListener == null));
    localOnApolloViewListener.onNotifyLongTouch(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mApolloId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yta
 * JD-Core Version:    0.7.0.1
 */