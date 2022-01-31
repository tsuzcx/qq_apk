import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.ITriggerRenderCallback;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class ymh
  implements Runnable
{
  private WeakReference a;
  
  public ymh(ApolloRenderDriver paramApolloRenderDriver)
  {
    this.a = new WeakReference(paramApolloRenderDriver);
  }
  
  public void run()
  {
    ApolloRenderDriver localApolloRenderDriver;
    if ((this.a != null) && (this.a.get() != null))
    {
      localApolloRenderDriver = (ApolloRenderDriver)this.a.get();
      if ((localApolloRenderDriver != null) && (localApolloRenderDriver.jdField_a_of_type_ComTencentMobileqqApolloITriggerRenderCallback != null) && (localApolloRenderDriver.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null))
      {
        localApolloRenderDriver.jdField_a_of_type_ComTencentMobileqqApolloITriggerRenderCallback.onRender();
        if (((ApolloRenderDriver)this.a.get()).jdField_a_of_type_Int <= 0) {
          break label101;
        }
      }
    }
    label101:
    for (int i = 1000 / ((ApolloRenderDriver)this.a.get()).jdField_a_of_type_Int;; i = 50)
    {
      localApolloRenderDriver.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(this, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymh
 * JD-Core Version:    0.7.0.1
 */