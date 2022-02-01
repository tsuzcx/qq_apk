import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.view.ViewGroup;

public abstract class awla
  implements GLSurfaceView.Renderer
{
  protected ViewGroup as;
  public Context mContext;
  
  public awla(Context paramContext, ViewGroup paramViewGroup)
  {
    this.mContext = paramContext;
    this.as = paramViewGroup;
  }
  
  public void onActivityDestroy() {}
  
  public void onActivityPause() {}
  
  public void onActivityResume() {}
  
  public void onActivityStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awla
 * JD-Core Version:    0.7.0.1
 */