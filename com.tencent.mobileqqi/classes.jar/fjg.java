import com.tencent.mobileqq.app.PluginConfigProxy;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceRespV2;

public class fjg
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private ServerConfigObserver jdField_a_of_type_MqqObserverServerConfigObserver;
  private GetResourceRespV2 jdField_a_of_type_ProtocolKQQConfigGetResourceRespV2;
  private boolean jdField_a_of_type_Boolean;
  
  public fjg(PluginConfigProxy paramPluginConfigProxy, ServerConfigObserver paramServerConfigObserver, boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    this.jdField_a_of_type_MqqObserverServerConfigObserver = paramServerConfigObserver;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespV2 = paramGetResourceRespV2;
  }
  
  public void run()
  {
    this.jdField_a_of_type_MqqObserverServerConfigObserver.onGetPluginConfig(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespV2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fjg
 * JD-Core Version:    0.7.0.1
 */