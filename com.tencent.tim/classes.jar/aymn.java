import android.view.View;
import android.view.View.OnLayoutChangeListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.GLTextureView;

public class aymn
  implements View.OnLayoutChangeListener
{
  public aymn(GLTextureView paramGLTextureView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.this$0.surfaceChanged(this.this$0.getSurfaceTexture(), 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aymn
 * JD-Core Version:    0.7.0.1
 */