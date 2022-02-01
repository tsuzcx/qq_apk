import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase.c.a;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase.d;

public class alzn
  implements FlowDecodeScreenSurfaceBase.c.a
{
  public alzn(FlowDecodeScreenSurfaceBase paramFlowDecodeScreenSurfaceBase) {}
  
  public GLSurfaceView.EGLConfigChooser a()
  {
    return new FlowDecodeScreenSurfaceBase.d(this.a, true);
  }
  
  public GLSurfaceView.EGLContextFactory a()
  {
    return new alzo(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzn
 * JD-Core Version:    0.7.0.1
 */