import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.widget.MediaController;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;

public class qlg
  implements qmc.e
{
  public qlg(TextureVideoView paramTextureVideoView) {}
  
  @TargetApi(15)
  public void a(qmc paramqmc)
  {
    if (this.a.jdField_a_of_type_Qmc == null) {}
    label282:
    do
    {
      int i;
      do
      {
        do
        {
          return;
          this.a.mCurrentState = 2;
          TextureVideoView localTextureVideoView1 = this.a;
          TextureVideoView localTextureVideoView2 = this.a;
          this.a.ik = true;
          localTextureVideoView2.ij = true;
          localTextureVideoView1.ii = true;
          if (this.a.jdField_a_of_type_Qmc$e != null) {
            this.a.jdField_a_of_type_Qmc$e.a(this.a.jdField_a_of_type_Qmc);
          }
          if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
            this.a.jdField_a_of_type_AndroidWidgetMediaController.setEnabled(true);
          }
          this.a.mVideoWidth = paramqmc.getVideoWidth();
          this.a.mVideoHeight = paramqmc.getVideoHeight();
          i = this.a.we;
          if (i != 0) {
            this.a.seekTo(i);
          }
          if ((this.a.mVideoWidth == 0) || (this.a.mVideoHeight == 0)) {
            break label282;
          }
          if (Build.VERSION.SDK_INT >= 15) {
            this.a.getSurfaceTexture().setDefaultBufferSize(this.a.mVideoWidth, this.a.mVideoHeight);
          }
          if (this.a.mTargetState != 3) {
            break;
          }
          this.a.start();
        } while (this.a.jdField_a_of_type_AndroidWidgetMediaController == null);
        this.a.jdField_a_of_type_AndroidWidgetMediaController.show();
        return;
      } while ((this.a.isPlaying()) || ((i == 0) && (this.a.getCurrentPosition() <= 0)) || (this.a.jdField_a_of_type_AndroidWidgetMediaController == null));
      this.a.jdField_a_of_type_AndroidWidgetMediaController.show(0);
      return;
    } while (this.a.mTargetState != 3);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qlg
 * JD-Core Version:    0.7.0.1
 */