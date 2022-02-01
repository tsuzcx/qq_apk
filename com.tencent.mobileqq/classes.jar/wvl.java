import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.widget.MediaController;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;

public class wvl
  implements wxe
{
  public wvl(TextureVideoView paramTextureVideoView) {}
  
  @TargetApi(15)
  public void a_(wwz paramwwz)
  {
    if (this.a.jdField_a_of_type_Wwz == null) {}
    label282:
    do
    {
      int i;
      do
      {
        do
        {
          return;
          this.a.jdField_a_of_type_Int = 2;
          TextureVideoView localTextureVideoView1 = this.a;
          TextureVideoView localTextureVideoView2 = this.a;
          this.a.jdField_d_of_type_Boolean = true;
          localTextureVideoView2.c = true;
          localTextureVideoView1.jdField_b_of_type_Boolean = true;
          if (this.a.jdField_a_of_type_Wxe != null) {
            this.a.jdField_a_of_type_Wxe.a_(this.a.jdField_a_of_type_Wwz);
          }
          if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
            this.a.jdField_a_of_type_AndroidWidgetMediaController.setEnabled(true);
          }
          this.a.jdField_d_of_type_Int = paramwwz.c();
          this.a.e = paramwwz.d();
          i = this.a.g;
          if (i != 0) {
            this.a.seekTo(i);
          }
          if ((this.a.jdField_d_of_type_Int == 0) || (this.a.e == 0)) {
            break label282;
          }
          if (Build.VERSION.SDK_INT >= 15) {
            this.a.getSurfaceTexture().setDefaultBufferSize(this.a.jdField_d_of_type_Int, this.a.e);
          }
          if (this.a.jdField_b_of_type_Int != 3) {
            break;
          }
          this.a.start();
        } while (this.a.jdField_a_of_type_AndroidWidgetMediaController == null);
        this.a.jdField_a_of_type_AndroidWidgetMediaController.show();
        return;
      } while ((this.a.isPlaying()) || ((i == 0) && (this.a.getCurrentPosition() <= 0)) || (this.a.jdField_a_of_type_AndroidWidgetMediaController == null));
      this.a.jdField_a_of_type_AndroidWidgetMediaController.show(0);
      return;
    } while (this.a.jdField_b_of_type_Int != 3);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvl
 * JD-Core Version:    0.7.0.1
 */