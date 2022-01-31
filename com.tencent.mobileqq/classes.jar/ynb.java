import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.ReentrantLock;

public class ynb
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public ynb(ApolloTextureView paramApolloTextureView) {}
  
  public void a()
  {
    this.jdField_a_of_type_Int = ApolloTextureView.access$1101(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
  }
  
  public void run()
  {
    Object localObject1;
    if (this.jdField_a_of_type_Int == ApolloTextureView.access$201(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView))
    {
      ApolloTextureView.access$302(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, true);
      ApolloTextureView.access$401(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, 2);
      localObject1 = ApolloActionManager.a();
      QLog.d("ApolloLock", 2, "checkForLongPress");
      localObject1 = ((ApolloActionManager)localObject1).a();
      ((ReentrantLock)localObject1).lock();
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.mRender != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.mRender.getSavaWrapper() != null))
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.mRender.getSavaWrapper().a(ApolloTextureView.access$500(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView), ApolloTextureView.access$601(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView) - ApolloTextureView.access$701(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView) - ApolloTextureView.access$800(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView));
        if ((ApolloTextureView.access$900(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView) >= 0) && (ApolloTextureView.access$1000(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView) != null)) {
          ApolloTextureView.access$1000(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView).onNotifyLongTouch(str);
        }
        QLog.d("ApolloTextureView", 2, "surfaceView longclick node = " + str);
      }
      return;
    }
    finally
    {
      ((ReentrantLock)localObject1).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ynb
 * JD-Core Version:    0.7.0.1
 */