import com.tencent.av.core.IVideoEventListener;
import com.tencent.av.core.VcControllerImpl;

public class bhh
  implements Runnable
{
  public bhh(VcControllerImpl paramVcControllerImpl) {}
  
  public void run()
  {
    if (this.a.mEventListener != null) {
      this.a.mEventListener.b(this.a.mPreviewW, this.a.mPreviewH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhh
 * JD-Core Version:    0.7.0.1
 */