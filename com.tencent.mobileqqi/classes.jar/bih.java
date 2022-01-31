import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.av.service.IAVServiceCallback;
import com.tencent.av.service.IAVServiceForQQ.Stub;

public class bih
  extends IAVServiceForQQ.Stub
{
  IAVServiceCallback jdField_a_of_type_ComTencentAvServiceIAVServiceCallback = null;
  
  private bih(AVServiceForQQ paramAVServiceForQQ) {}
  
  public void a(IAVServiceCallback paramIAVServiceCallback)
  {
    this.jdField_a_of_type_ComTencentAvServiceIAVServiceCallback = paramIAVServiceCallback;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.a != null) {}
    for (VideoController localVideoController = this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.a.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.b(paramArrayOfByte);
      }
      return;
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.a != null) {}
    for (VideoController localVideoController = this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ.a.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.c(paramArrayOfByte);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bih
 * JD-Core Version:    0.7.0.1
 */