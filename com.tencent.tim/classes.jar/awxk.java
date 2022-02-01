import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.a;
import java.util.concurrent.atomic.AtomicReference;

class awxk
  implements awxc.b
{
  awxk(awxg paramawxg, AtomicReference paramAtomicReference) {}
  
  public void b(awxf paramawxf)
  {
    CameraCaptureView.a locala = (CameraCaptureView.a)this.l.get();
    if (locala != null) {
      locala.a(paramawxf);
    }
  }
  
  public void onFail(String paramString)
  {
    CameraCaptureView.a locala = (CameraCaptureView.a)this.l.get();
    if (locala != null) {
      locala.Ps(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awxk
 * JD-Core Version:    0.7.0.1
 */